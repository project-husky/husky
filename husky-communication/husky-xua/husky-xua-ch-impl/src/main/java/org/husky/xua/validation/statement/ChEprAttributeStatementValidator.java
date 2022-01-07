package org.husky.xua.validation.statement;

import static org.husky.common.enums.CodeSystems.SWISS_EPR_SPID;
import static org.husky.communication.ch.enums.PurposeOfUse.AUTOMATIC_UPLOAD;
import static org.husky.communication.ch.enums.PurposeOfUse.EMERGENCY_ACCESS;
import static org.husky.communication.ch.enums.PurposeOfUse.NORMAL_ACCESS;
import static org.husky.communication.ch.enums.Role.ASSISTANT;
import static org.husky.communication.ch.enums.Role.DOCUMENT_ADMINISTRATOR;
import static org.husky.communication.ch.enums.Role.HEALTHCARE_PROFESSIONAL;
import static org.husky.communication.ch.enums.Role.PATIENT;
import static org.husky.communication.ch.enums.Role.POLICY_ADMINISTRATOR;
import static org.husky.communication.ch.enums.Role.REPRESENTATIVE;
import static org.husky.communication.ch.enums.Role.TECHNICAL_USER;
import static org.husky.xua.communication.xua.XUserAssertionConstants.IHE_XCA_HOMECOMMUNITYID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_ORGANISATION;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_ORGANIZATIONID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_PURPOSEOFUSE;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_RESOURCEID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_SUBJECTID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_HOME_COMMUNITY_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ORGANIZATIONS_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ORGANIZATIONS_NAME;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_PATIENT_EPR_SPID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_PURPOSE_OF_USE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_SUBJECT_NAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.namespace.QName;

import org.husky.communication.ch.enums.PurposeOfUse;
import org.husky.communication.ch.enums.Role;
import org.husky.xua.hl7v3.impl.AbstractImpl;
import org.husky.xua.hl7v3.impl.CodedWithEquivalentImpl;
import org.husky.xua.validation.ChEprAssertionValidationParameters;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.StatementValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeStatement;
import org.opensaml.saml.saml2.core.Statement;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;

import com.google.common.annotations.VisibleForTesting;

/**
 * Validator used to validate {@link Statement}s within a given {@link Assertion} in the CH-EPR context.
 *
 * @author Quentin Ligier
 */
public class ChEprAttributeStatementValidator implements StatementValidator {
	
	public static final String ERRMSG_CONTAINS_INVALID_VALUE = "' contains an invalid value";
	public static final String ERRMSG_ATTRIBUTE = "The attribute '";

    /**
     * Gets the element or schema type QName of the statement handled by this validator.
     *
     * @return element or schema type QName of the statement handled by this validator
     */
    public QName getServicedStatement() {
        return AttributeStatement.DEFAULT_ELEMENT_NAME;
    }

    /**
     * Validates the given statement.
     *
     * @param statement The statement to be validated.
     * @param assertion The assertion bearing the statement.
     * @param context   The current Assertion validation context.
     * @return the validation result.
     */
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
     * @return the validation result.
     */
    @VisibleForTesting
    protected ValidationResult validatePurposeOfUse(final Attribute attribute,
                                                    final ValidationContext context,
                                                    final Role role) {
        final var purposeOfUse = Optional.ofNullable(attribute.getAttributeValues())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(AttributeValueImpl.class::isInstance)
                .map(AttributeValueImpl.class::cast)
                .map(attributeValue -> attributeValue.getUnknownXMLObjects(new QName("urn:hl7-org:v3", "PurposeOfUse")))
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
				.filter(CodedWithEquivalentImpl.class::isInstance).map(CodedWithEquivalentImpl.class::cast)
                .filter(p -> PurposeOfUse.VALUE_SET_ID.equals(p.getCodeSystem()))
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
                || (role == POLICY_ADMINISTRATOR && purposeOfUse != NORMAL_ACCESS)
        ) {
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
     * @return the validation result.
     */
    @VisibleForTesting
    protected ValidationResult validateHomeCommunityId(final Attribute attribute,
                                                       final ValidationContext context) {
        var homeCommunityId = Optional.ofNullable(attribute.getAttributeValues())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(XSString.class::isInstance)
                .map(XSString.class::cast)
                .map(XSString::getValue)
                .orElse(null);
        final var prefix = "urn:oid:";
        if (homeCommunityId == null || !homeCommunityId.startsWith(prefix)) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + IHE_XCA_HOMECOMMUNITYID + ERRMSG_CONTAINS_INVALID_VALUE);
            return ValidationResult.INVALID;
        }
        homeCommunityId = homeCommunityId.substring(prefix.length());
        context.getDynamicParameters().put(CH_EPR_HOME_COMMUNITY_ID, homeCommunityId);
        return ValidationResult.VALID;
    }

    /**
     * Validates the ResourceId attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @return the validation result.
     */
    @VisibleForTesting
    protected ValidationResult validateResourceId(final Attribute attribute,
                                                  final ValidationContext context) {
        var resourceId = Optional.ofNullable(attribute.getAttributeValues())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(XSString.class::isInstance)
                .map(XSString.class::cast)
                .map(XSString::getValue)
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
     * @return the validation result.
     */
    @VisibleForTesting
    protected ValidationResult validateSubjectId(final Attribute attribute,
                                                 final ValidationContext context) {
        final var subjectId = Optional.ofNullable(attribute.getAttributeValues())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(XSString.class::isInstance)
                .map(XSString.class::cast)
                .map(XSString::getValue)
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
     * @return the validation result.
     */
    @VisibleForTesting
    protected ValidationResult validateOrganizationsId(final Attribute attribute,
                                                       final ValidationContext context,
                                                       final Role role) {
        final var shallBeEmpty = role == POLICY_ADMINISTRATOR || role == DOCUMENT_ADMINISTRATOR;
        final var organizationId = Optional.ofNullable(attribute.getAttributeValues())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(XSString.class::isInstance)
                .map(XSString.class::cast)
                .map(XSString::getValue)
                .orElse(null);
        if (organizationId == null) {
            if (shallBeEmpty) {
                return ValidationResult.VALID;
            } else {
                context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANIZATIONID + ERRMSG_CONTAINS_INVALID_VALUE);
                return ValidationResult.INVALID;
            }
        }
        if (shallBeEmpty) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANIZATIONID + "' must be empty");
            return ValidationResult.INVALID;
        }

        context.getDynamicParameters().computeIfAbsent(CH_EPR_ORGANIZATIONS_ID, key -> new ArrayList<String>());
        ((List<String>) context.getDynamicParameters().get(CH_EPR_ORGANIZATIONS_ID)).add(organizationId);
        return ValidationResult.VALID;
    }

    /**
     * Validates the OrganizationsName attribute.
     *
     * @param attribute The Attribute to be validated.
     * @param context   The current validation context.
     * @param role      The subject's role.
     * @return the validation result.
     */
    @VisibleForTesting
    protected ValidationResult validateOrganizationsName(final Attribute attribute,
                                                         final ValidationContext context,
                                                         final Role role) {
        final var shallBeEmpty = role == POLICY_ADMINISTRATOR || role == DOCUMENT_ADMINISTRATOR;
        final var organizationName = Optional.ofNullable(attribute.getAttributeValues())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(XSString.class::isInstance)
                .map(XSString.class::cast)
                .map(XSString::getValue)
                .orElse(null);
        if (organizationName == null) {
            if (shallBeEmpty) {
                return ValidationResult.VALID;
            } else {
                context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANISATION + ERRMSG_CONTAINS_INVALID_VALUE);
                return ValidationResult.INVALID;
            }
        }
        if (shallBeEmpty) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANISATION + "' must be empty");
            return ValidationResult.INVALID;
        }

        context.getDynamicParameters().computeIfAbsent(CH_EPR_ORGANIZATIONS_NAME, key -> new ArrayList<String>());
        ((List<String>) context.getDynamicParameters().get(CH_EPR_ORGANIZATIONS_NAME)).add(organizationName);
        return ValidationResult.VALID;
    }
}
