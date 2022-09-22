/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.xua.validation.statement;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.datatypes.Oids;
import org.husky.communication.ch.enums.PurposeOfUse;
import org.husky.communication.ch.enums.Role;
import org.husky.xua.hl7v3.impl.AbstractImpl;
import org.husky.xua.hl7v3.impl.CodedWithEquivalentImpl;
import org.husky.xua.validation.ChEprAssertionValidationParameters;
import org.husky.xua.validation.ValidationUtils;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.StatementValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeStatement;
import org.opensaml.saml.saml2.core.Statement;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

import static org.husky.common.enums.CodeSystems.SWISS_EPR_SPID;
import static org.husky.communication.ch.enums.PurposeOfUse.*;
import static org.husky.communication.ch.enums.Role.*;
import static org.husky.xua.communication.xua.XUserAssertionConstants.*;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * Validator used to validate {@link Statement}s within a given {@link Assertion} in the CH-EPR context.
 *
 * @author Quentin Ligier
 */
@ThreadSafe
public class ChEprAttributeStatementValidator implements StatementValidator {

    public static final String ERRMSG_CONTAINS_INVALID_VALUE = "' contains an invalid value";
    public static final String ERRMSG_ATTRIBUTE = "The attribute '";

    /**
     * Gets the element or schema type QName of the statement handled by this validator.
     */
    @NonNull
    public QName getServicedStatement() {
        return AttributeStatement.DEFAULT_ELEMENT_NAME;
    }

    /**
     * Validates the given statement.
     *
     * @param statement The statement to be validated.
     * @param assertion The assertion bearing the statement.
     * @param context   The current Assertion validation context.
     * @return The validation result.
     */
    @NonNull
    public ValidationResult validate(final Statement statement,
                                     final Assertion assertion,
                                     final ValidationContext context) {
        if (!(statement instanceof final AttributeStatement attributeStatement)) {
            return ValidationResult.INDETERMINATE;
        }

        final Role role = (Role) context.getDynamicParameters().get(ChEprAssertionValidationParameters.CH_EPR_ROLE);

        ValidationResult result;
        for (final var attribute : attributeStatement.getAttributes()) {
            result = switch (attribute.getName()) {
                case OASIS_XACML_PURPOSEOFUSE -> this.validatePurposeOfUse(attribute, context, role);
                case IHE_XCA_HOMECOMMUNITYID -> this.validateHomeCommunityId(attribute, context);
                case OASIS_XACML_RESOURCEID -> this.validateResourceId(attribute, context);
                case OASIS_XACML_SUBJECTID -> this.validateSubjectId(attribute, context);
                case OASIS_XACML_ORGANIZATIONID -> this.validateOrganizationsId(attribute, context, role);
                case OASIS_XACML_ORGANISATION -> this.validateOrganizationsName(attribute, context, role);
                case OASIS_XACML_ROLE -> ValidationResult.VALID; // It has been validated by ChEprAssertionValidator.validateRole
                default -> ValidationResult.INDETERMINATE;
            };

            if (result != ValidationResult.VALID) {
                return result;
            }
        }

        return ValidationResult.VALID;
    }

    /**
     * Validates the PurposeOfUse attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @param role      The subject's role.
     * @return The validation result.
     */
    ValidationResult validatePurposeOfUse(final Attribute attribute,
                                          final ValidationContext context,
                                          final Role role) {
        final var purposeOfUse = Optional.ofNullable(attribute.getAttributeValues())
                .map(OptionalUtils::getListOnlyElement)
                .map(xmlObject -> OptionalUtils.castOrNull(xmlObject, AttributeValueImpl.class))
                .map(attributeValue -> attributeValue.getUnknownXMLObjects(new QName("urn:hl7-org:v3", "PurposeOfUse")))
                .map(OptionalUtils::getListOnlyElement)
                .map(xmlObject -> OptionalUtils.castOrNull(xmlObject, CodedWithEquivalentImpl.class))
                .filter(p -> PurposeOfUse.CODE_SYSTEM_ID.equals(p.getCodeSystem()))
                .map(AbstractImpl::getCode)
                .map(PurposeOfUse::getEnum)
                .orElse(null);
        if (purposeOfUse == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_PURPOSEOFUSE + ERRMSG_CONTAINS_INVALID_VALUE);
            return ValidationResult.INVALID;
        }

        if ((role == HEALTHCARE_PROFESSIONAL && purposeOfUse != NORMAL_ACCESS && purposeOfUse != EMERGENCY_ACCESS)
                || (role == ASSISTANT && purposeOfUse != NORMAL_ACCESS && purposeOfUse != EMERGENCY_ACCESS)
                || (role == TECHNICAL_USER && purposeOfUse != AUTOMATIC_UPLOAD)
                || (role == PATIENT && purposeOfUse != NORMAL_ACCESS)
                || (role == REPRESENTATIVE && purposeOfUse != NORMAL_ACCESS)
                || (role == DOCUMENT_ADMINISTRATOR && purposeOfUse != NORMAL_ACCESS)
                || (role == POLICY_ADMINISTRATOR && purposeOfUse != NORMAL_ACCESS)) {
            context.setValidationFailureMessage(String.format("The attribute '%s' contains an illegal value: %s is " +
                    "not allowed for %s", OASIS_XACML_PURPOSEOFUSE, purposeOfUse, role));
            return ValidationResult.INVALID;
        }
        context.getDynamicParameters().put(CH_EPR_PURPOSE_OF_USE, purposeOfUse);
        return ValidationResult.VALID;
    }

    /**
     * Validates the HomeCommunityId attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @return The validation result.
     */
    ValidationResult validateHomeCommunityId(final Attribute attribute,
                                             final ValidationContext context) {
        var homeCommunityId = Optional.ofNullable(attribute.getAttributeValues())
                .map(OptionalUtils::getListOnlyElement)
                .map(ValidationUtils::extractXsValue)
                .orElse(null);
        if (homeCommunityId == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + IHE_XCA_HOMECOMMUNITYID + ERRMSG_CONTAINS_INVALID_VALUE);
            return ValidationResult.INVALID;
        }
        homeCommunityId = Oids.normalize(homeCommunityId); // Decode the URN (remove the prefix)
        context.getDynamicParameters().put(CH_EPR_HOME_COMMUNITY_ID, homeCommunityId);
        return ValidationResult.VALID;
    }

    /**
     * Validates the ResourceId attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @return The validation result.
     */
    ValidationResult validateResourceId(final Attribute attribute,
                                        final ValidationContext context) {
        var resourceId = Optional.ofNullable(attribute.getAttributeValues())
                .map(OptionalUtils::getListOnlyElement)
                .map(ValidationUtils::extractXsValue)
                .orElse(null);
        final var suffix = "^^^&" + SWISS_EPR_SPID.getCodeSystemId() + "&ISO";
        if (resourceId == null || !resourceId.endsWith(suffix)) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_RESOURCEID + ERRMSG_CONTAINS_INVALID_VALUE);
            return ValidationResult.INVALID;
        }
        resourceId = resourceId.substring(0, resourceId.length() - suffix.length());
        context.getDynamicParameters().put(CH_EPR_PATIENT_EPR_SPID, resourceId);
        return ValidationResult.VALID;

    }

    /**
     * Validates the SubjectId attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @return The validation result.
     */
    ValidationResult validateSubjectId(final Attribute attribute,
                                       final ValidationContext context) {
        final var subjectId = Optional.ofNullable(attribute.getAttributeValues())
                .map(OptionalUtils::getListOnlyElement)
                .map(ValidationUtils::extractXsValue)
                .orElse(null);
        if (subjectId == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_SUBJECTID + ERRMSG_CONTAINS_INVALID_VALUE);
            return ValidationResult.INVALID;
        }
        context.getDynamicParameters().put(CH_EPR_SUBJECT_NAME, subjectId);
        return ValidationResult.VALID;
    }

    /**
     * Validates the OrganizationsId attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @param role      The subject's role.
     * @return The validation result.
     */
    ValidationResult validateOrganizationsId(final Attribute attribute,
                                             final ValidationContext context,
                                             final Role role) {
        final var shallBeEmpty = role == POLICY_ADMINISTRATOR
                || role == DOCUMENT_ADMINISTRATOR
                || role == PATIENT
                || role == REPRESENTATIVE;
        final var organizationIds = Optional.ofNullable(attribute.getAttributeValues())
                .orElseGet(Collections::emptyList).stream()
                .map(ValidationUtils::extractXsValue)
                .filter(Objects::nonNull)
                .map(Oids::normalize)
                .toList();

        if (shallBeEmpty) {
            if (organizationIds.isEmpty()) {
                return ValidationResult.VALID;
            }
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANIZATIONID + "' must be empty");
            return ValidationResult.INVALID;
        }

        if (context.getDynamicParameters().containsKey(CH_EPR_ORGANIZATIONS_ID)) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANIZATIONID + "' shall not appear " +
                                                        "multiple times");
            return ValidationResult.INVALID;
        }

        context.getDynamicParameters().put(CH_EPR_ORGANIZATIONS_ID, organizationIds);
        return ValidationResult.VALID;
    }

    /**
     * Validates the OrganizationsName attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @param role      The subject's role.
     * @return The validation result.
     */
    ValidationResult validateOrganizationsName(final Attribute attribute,
                                               final ValidationContext context,
                                               final Role role) {
        final var shallBeEmpty = role == POLICY_ADMINISTRATOR
                || role == DOCUMENT_ADMINISTRATOR
                || role == PATIENT
                || role == REPRESENTATIVE;
        final var organizationNames = Optional.ofNullable(attribute.getAttributeValues())
                .orElseGet(Collections::emptyList).stream()
                .map(ValidationUtils::extractXsValue)
                .filter(Objects::nonNull)
                .map(Oids::normalize)
                .toList();

        if (shallBeEmpty) {
            if (organizationNames.isEmpty()) {
                return ValidationResult.VALID;
            }
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANISATION + "' must be empty");
            return ValidationResult.INVALID;
        }

        if (context.getDynamicParameters().containsKey(CH_EPR_ORGANIZATIONS_NAME)) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANISATION + "' shall not appear " +
                                                        "multiple times");
            return ValidationResult.INVALID;
        }

        context.getDynamicParameters().put(CH_EPR_ORGANIZATIONS_NAME, organizationNames);
        return ValidationResult.VALID;
    }
}
