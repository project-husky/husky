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
import org.projecthusky.common.utils.OptionalUtils;
import org.projecthusky.xua.validation.ChEprAssertionValidationParameters;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Audience;
import org.opensaml.saml.saml2.core.AudienceRestriction;
import org.opensaml.saml.saml2.core.Condition;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.namespace.QName;

import java.util.Optional;

import static org.projecthusky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_AUDIENCE;

/**
 * Validator of the CH-EPR AudienceRestriction Condition.
 *
 * <p>It relies on the {@link ChEprAssertionValidationParameters#CH_EPR_ROLE} dynamic parameter of the
 * {@link ValidationContext}.
 *
 * @author Quentin Ligier
 */
@ThreadSafe
public class ChEprAudienceRestrictionConditionValidator implements ConditionValidator {

    /**
     * Gets the element or schema type QName of the condition handled by this validator.
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
     * @return The result of the condition evaluation.
     */
    @Override
    public ValidationResult validate(final Condition condition,
                                     @Nullable final Assertion assertion,
                                     final ValidationContext context) {
        if (!(condition instanceof final AudienceRestriction audienceRestriction)) {
            return ValidationResult.INDETERMINATE;
        }

        final var audienceUri = Optional.ofNullable(audienceRestriction.getAudiences())
                .map(OptionalUtils::getListOnlyElement)
                .map(Audience::getURI)
                .orElse(null);
        if (audienceUri == null) {
            context.getValidationFailureMessages().add("The AudienceRestriction Condition doesn't contain a valid " +
                    "URI");
            return ValidationResult.INVALID;
        }
        context.getDynamicParameters().put(CH_EPR_AUDIENCE, audienceUri);

        return ValidationResult.VALID;
    }
}
