package org.ehealth_connector.xua.validation.condition;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.communication.ch.enums.Role;
import org.ehealth_connector.xua.ChEprXuaSpecifications;
import org.ehealth_connector.xua.validation.ChEprAssertionValidationParameters;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Audience;
import org.opensaml.saml.saml2.core.AudienceRestriction;
import org.opensaml.saml.saml2.core.Condition;

import javax.xml.namespace.QName;
import java.util.Optional;

import static org.ehealth_connector.xua.validation.ChEprAssertionValidationParameters.CH_EPR_AUDIENCE;

/**
 * Validator of the CH-EPR AudienceRestriction Condition.
 *
 * <p>It relies on the {@link ChEprAssertionValidationParameters#CH_EPR_ROLE} dynamic parameter of the
 * {@link ValidationContext}.
 *
 * @author Quentin Ligier
 */
public class ChEprAudienceRestrictionConditionValidator implements ConditionValidator {

    /**
     * Gets the element or schema type QName of the condition handled by this validator.
     *
     * @return element or schema type QName of the statement handled by this validator
     */
    public QName getServicedCondition() {
        return AudienceRestriction.DEFAULT_ELEMENT_NAME;
    }

    /**
     * Validates the given condition.
     *
     * @param condition The condition to be evaluated.
     * @param assertion The assertion bearing the condition. It is not used by the validator.
     * @param context   The current Assertion validation context.
     * @return the result of the condition evaluation.
     */
    @Override
    public ValidationResult validate(final Condition condition,
                                     @Nullable final Assertion assertion,
                                     final ValidationContext context) {
        if (!(condition instanceof final AudienceRestriction audienceRestriction)) {
            return ValidationResult.INDETERMINATE;
        }
        final Role role = (Role) context.getDynamicParameters().get(ChEprAssertionValidationParameters.CH_EPR_ROLE);
        if (role != Role.ASSISTANT && role != Role.TECHNICAL_USER) {
            context.setValidationFailureMessage("The AudienceRestriction Condition shall not appear for other " +
                    "extensions than TCU and ASS");
            return ValidationResult.INVALID;
        }

        final var audienceUri = Optional.ofNullable(audienceRestriction.getAudiences())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .map(Audience::getURI)
                .orElse(null);
        if (!ChEprXuaSpecifications.AUDIENCE_ALL_COMMUNITIES.equals(audienceUri)) {
            context.setValidationFailureMessage("The AudienceRestriction Condition doesn't contain a valid " +
                    "URI");
            return ValidationResult.INVALID;
        }
        context.getDynamicParameters().put(CH_EPR_AUDIENCE, audienceUri);

        return ValidationResult.VALID;
    }
}
