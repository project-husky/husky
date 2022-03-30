/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.xua.validation.subject;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.utils.OptionalUtils;
import org.husky.communication.ch.enums.Role;
import org.husky.xua.validation.ChEprAssertionValidationParameters;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSAny;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.SubjectConfirmationValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeValue;
import org.opensaml.saml.saml2.core.SubjectConfirmation;

import java.util.Optional;

import static org.husky.xua.ChEprXuaSpecifications.TECHNICAL_USER_ID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_SUBJECTID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * Validator that confirms the {@link org.opensaml.saml.saml2.core.Subject} of the issuer by evaluating the {@link
 * SubjectConfirmation}s within that subject.
 *
 * @author Quentin Ligier
 */
public class ChEprSubjectConfirmationBearerValidator implements SubjectConfirmationValidator {

    /**
     * Gets the subject confirmation method handled by this validator.
     */
    public String getServicedMethod() {
        return SubjectConfirmation.METHOD_BEARER;
    }

    /**
     * Confirms the {@link org.opensaml.saml.saml2.core.Subject} by means of the given {@link SubjectConfirmation}.
     *
     * @param confirmation The subject confirmation information.
     * @param assertion    The assertion bearing the subject. It is not used by the validator.
     * @param context      The current Assertion validation context.
     * @return The validation result.
     */
    /* reduction of complexity not necessary, value still below 20 */
    @SuppressWarnings("java:S3776")
    public ValidationResult validate(final SubjectConfirmation confirmation,
                                     @Nullable final Assertion assertion,
                                     final ValidationContext context) {
        final var role = (Role) context.getDynamicParameters().get(ChEprAssertionValidationParameters.CH_EPR_ROLE);

        // Validation of the SubjectConfirmation
        if (role != Role.ASSISTANT && role != Role.TECHNICAL_USER) {
            context.setValidationFailureMessage("The SubjectConfirmation shall not appear for other " +
                    "extensions than TCU and ASS");
            return ValidationResult.INVALID;
        }

        final var nameId = confirmation.getNameID();
        if (nameId == null || nameId.getNameQualifier() == null || nameId.getValue() == null) {
            context.setValidationFailureMessage("The SubjectConfirmation NameID is missing");
            return ValidationResult.INVALID;
        }

        // Here we compare the value to the one extracted from the DelegationRestrictionType Condition
        if (role == Role.ASSISTANT) {
            if (!"urn:gs1:gln".equals(nameId.getNameQualifier())) {
                context.setValidationFailureMessage("The assistant GLN is missing in the SubjectConfirmation");
                return ValidationResult.INVALID;
            }

            final var assistantGln = (String) context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN);
            if (assistantGln == null || !assistantGln.equals(nameId.getValue())) {
                context.setValidationFailureMessage("The assistant GLN in the SubjectConfirmation is different from " +
                        "the one in the DelegationRestrictionType Condition");
                return ValidationResult.INVALID;
            }
        } else {
            if (!TECHNICAL_USER_ID.equals(nameId.getNameQualifier())) {
                context.setValidationFailureMessage("The technical user unique ID is missing in the " +
                        "SubjectConfirmation");
                return ValidationResult.INVALID;
            }

            final var technicalUserUniqueId = (String) context.getDynamicParameters().get(CH_EPR_TCU_ID);
            if (technicalUserUniqueId == null || !technicalUserUniqueId.equals(nameId.getValue())) {
                context.setValidationFailureMessage("The technical user unique ID in the SubjectConfirmation is " +
                        "different from the one in the DelegationRestrictionType Condition");
                return ValidationResult.INVALID;
            }
        }

        // Extraction of the SubjectConfirmationData
        if (role == Role.ASSISTANT) {
            final var assistantName = extractAssistantName(confirmation);
            if (assistantName.isEmpty()) {
                context.setValidationFailureMessage("The assistant name is missing in the SubjectConfirmation");
                return ValidationResult.INVALID;
            }
            context.getDynamicParameters().put(CH_EPR_ASSISTANT_NAME, assistantName.get());
        }

        return ValidationResult.VALID;
    }

    /**
     * Extracts the assistant name from the subject confirmation.
     *
     * @param confirmation The subject confirmation.
     * @return An {@link Optional} that may contain the assistant name.
     */
    Optional<String> extractAssistantName(final SubjectConfirmation confirmation) {
		return Optional.ofNullable(confirmation.getSubjectConfirmationData())
                .map(XMLObject::getOrderedChildren)
                .map(OptionalUtils::getListOnlyElement)
                .map(attribute -> OptionalUtils.castOrNull(attribute, Attribute.class))
                .filter(attribute -> OASIS_XACML_SUBJECTID.equals(attribute.getName()))
				.map(Attribute::getAttributeValues)
                .map(OptionalUtils::getListOnlyElement)
                .map(attributeValue -> OptionalUtils.castOrNull(attributeValue, AttributeValue.class))
                .map(XSAny::getTextContent);
	}
}
