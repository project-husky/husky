/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua.validation.condition;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.ext.saml2delrestrict.Delegate;
import org.opensaml.saml.ext.saml2delrestrict.DelegationRestrictionType;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Condition;
import org.opensaml.saml.saml2.core.NameIDType;
import org.projecthusky.common.utils.OptionalUtils;
import org.projecthusky.communication.ch.enums.stable.Role;
import org.projecthusky.xua.validation.ChEprAssertionValidationParameters;
import org.projecthusky.xua.validation.ValidationUtils;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.namespace.QName;
import java.util.Optional;

import static org.projecthusky.xua.ChEprXuaSpecifications.TECHNICAL_USER_ID;
import static org.projecthusky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * Validator of the CH-EPR DelegationRestrictionType Condition.
 *
 * <p>It relies on the {@link ChEprAssertionValidationParameters#CH_EPR_ROLE} dynamic parameter of the
 * {@link ValidationContext}.
 *
 * @author Quentin Ligier
 */
@ThreadSafe
public class ChEprDelegationRestrictionConditionValidator implements ConditionValidator {

    /**
     * Gets the element or schema type QName of the condition handled by this validator.
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
     * @return The result of the condition evaluation.
     */
    public ValidationResult validate(final Condition condition,
                                     @Nullable final Assertion assertion,
                                     final ValidationContext context) {
        if (!(condition instanceof final DelegationRestrictionType delegationRestriction)) {
            return ValidationResult.INDETERMINATE;
        }
        final Role role = (Role) context.getDynamicParameters().get(CH_EPR_ROLE);
        if (role != Role.ASSISTANT && role != Role.TECHNICAL_USER) {
            context.getValidationFailureMessages().add("The DelegationRestrictionType Condition shall not appear for other " +
                                                        "extensions than TCU and ASS");
            return ValidationResult.INVALID;
        }

        final var nameId = Optional.ofNullable(delegationRestriction.getDelegates())
                .map(OptionalUtils::getListOnlyElement)
                .map(Delegate::getNameID)
                .filter(n -> NameIDType.PERSISTENT.equals(n.getFormat()))
                .filter(n -> n.getValue() != null)
                .orElse(null);
        if (nameId == null) {
            context.getValidationFailureMessages().add("The DelegationRestrictionType Condition doesn't contain a valid " +
                                                        "NameID");
            return ValidationResult.INVALID;
        }

        if (role == Role.ASSISTANT) {
            if (!"urn:gs1:gln".equals(nameId.getNameQualifier())) {
                context.getValidationFailureMessages().add("The DelegationRestrictionType Condition doesn't contain the " +
                                                            "assistant GLN");
                return ValidationResult.INVALID;
            }
            context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, nameId.getValue());
            return ValidationResult.VALID;
        } else {
            if (!TECHNICAL_USER_ID.equals(nameId.getNameQualifier())) {
                context.getValidationFailureMessages().add("The DelegationRestrictionType Condition doesn't contain the " +
                                                            "technical user unique ID");
                return ValidationResult.INVALID;
            }
            // May or may not be URN-encoded, see https://github.com/ehealthsuisse/EPD-by-example/issues/14
            context.getDynamicParameters().put(CH_EPR_TCU_ID, ValidationUtils.trimOidUrn(nameId.getValue()));
            return ValidationResult.VALID;
        }
    }
}
