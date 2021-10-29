package org.ehealth_connector.xua.validation.condition;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.communication.ch.enums.Role;
import org.ehealth_connector.xua.validation.ChEprAssertionValidationParameters;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.ext.saml2delrestrict.Delegate;
import org.opensaml.saml.ext.saml2delrestrict.DelegationRestrictionType;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Condition;
import org.opensaml.saml.saml2.core.NameIDType;

import javax.xml.namespace.QName;
import java.util.Optional;

import static org.ehealth_connector.xua.ChEprXuaSpecifications.TECHNICAL_USER_ID;
import static org.ehealth_connector.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * Validator of the CH-EPR DelegationRestrictionType Condition.
 *
 * <p>It relies on the {@link ChEprAssertionValidationParameters#CH_EPR_ROLE} dynamic parameter of the
 * {@link ValidationContext}.
 *
 * @author Quentin Ligier
 */
public class ChEprDelegationRestrictionConditionValidator implements ConditionValidator {

    /**
     * Gets the element or schema type QName of the condition handled by this validator.
     *
     * @return element or schema type QName of the statement handled by this validator
     */
    public QName getServicedCondition() {
        return DelegationRestrictionType.TYPE_NAME;
    }

    /**
     * Validates the given condition.
     *
     * @param condition The condition to be evaluated.
     * @param assertion The assertion bearing the condition. It is not used by the validator.
     * @param context   The current Assertion validation context.
     * @return the result of the condition evaluation.
     */
    public ValidationResult validate(final Condition condition,
                                     @Nullable final Assertion assertion,
                                     final ValidationContext context) {
        if (!(condition instanceof final DelegationRestrictionType delegationRestriction)) {
            return ValidationResult.INDETERMINATE;
        }
        final Role role = (Role) context.getDynamicParameters().get(CH_EPR_ROLE);
        if (role != Role.ASSISTANT && role != Role.TECHNICAL_USER) {
            context.setValidationFailureMessage("The DelegationRestrictionType Condition shall not appear for other " +
                    "extensions than TCU and ASS");
            return ValidationResult.INVALID;
        }

        final var nameId = Optional.ofNullable(delegationRestriction.getDelegates())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .map(Delegate::getNameID)
                .filter(n -> NameIDType.PERSISTENT.equals(n.getFormat()))
                .orElse(null);
        if (nameId == null) {
            context.setValidationFailureMessage("The DelegationRestrictionType Condition doesn't contain a valid " +
                    "NameID");
            return ValidationResult.INVALID;
        }

        if (role == Role.ASSISTANT) {
            if (!"urn:gs1:gln".equals(nameId.getNameQualifier())) {
                context.setValidationFailureMessage("The DelegationRestrictionType Condition doesn't contain the " +
                        "assistant GLN");
                return ValidationResult.INVALID;
            }
            context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, nameId.getValue());
            return ValidationResult.VALID;
        } else {
            if (!TECHNICAL_USER_ID.equals(nameId.getNameQualifier())) {
                context.setValidationFailureMessage("The DelegationRestrictionType Condition doesn't contain the " +
                        "technical user unique ID");
                return ValidationResult.INVALID;
            }
            // TODO: URN-encoded OID?
            context.getDynamicParameters().put(CH_EPR_TCU_ID, nameId.getValue());
            return ValidationResult.VALID;
        }
    }
}
