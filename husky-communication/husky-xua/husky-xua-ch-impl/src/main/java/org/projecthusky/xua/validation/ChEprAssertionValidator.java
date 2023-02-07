/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua.validation;

import net.shibboleth.utilities.java.support.component.ComponentInitializationException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.opensaml.core.config.InitializationService;
import org.opensaml.saml.common.assertion.AssertionValidationException;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.ext.saml2delrestrict.Delegate;
import org.opensaml.saml.ext.saml2delrestrict.DelegationRestrictionType;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.opensaml.saml.saml2.assertion.SAML20AssertionValidator;
import org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters;
import org.opensaml.saml.saml2.assertion.impl.OneTimeUseConditionValidator;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.AttributeStatement;
import org.opensaml.saml.saml2.core.NameIDType;
import org.opensaml.saml.saml2.core.Subject;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;
import org.opensaml.storage.ReplayCache;
import org.opensaml.storage.impl.MemoryStorageService;
import org.opensaml.xmlsec.keyinfo.KeyInfoCredentialResolver;
import org.opensaml.xmlsec.signature.support.SignatureTrustEngine;
import org.opensaml.xmlsec.signature.support.impl.ExplicitKeySignatureTrustEngine;
import org.projecthusky.common.utils.OptionalUtils;
import org.projecthusky.communication.ch.enums.stable.Role;
import org.projecthusky.xua.hl7v3.impl.AbstractImpl;
import org.projecthusky.xua.hl7v3.impl.CodedWithEquivalentImpl;
import org.projecthusky.xua.validation.condition.ChEprAudienceRestrictionConditionValidator;
import org.projecthusky.xua.validation.condition.ChEprDelegationRestrictionConditionValidator;
import org.projecthusky.xua.validation.statement.ChEprAttributeStatementValidator;
import org.projecthusky.xua.validation.subject.ChEprSubjectConfirmationBearerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.concurrent.ThreadSafe;
import javax.xml.namespace.QName;
import java.time.Duration;
import java.util.*;

import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.CLOCK_SKEW;
import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.SIGNATURE_REQUIRED;
import static org.projecthusky.common.ch.ChEpr.EPR_SPID_URN;
import static org.projecthusky.xua.ChEprXuaSpecifications.*;
import static org.projecthusky.xua.communication.xua.XUserAssertionConstants.*;
import static org.projecthusky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * A component capable of performing core validation of SAML version 2.0 {@link Assertion} instances in use in the
 * CH-EPR domain.
 *
 * <p>The calling application needs to initiate the SAML library by calling {@link InitializationService#initialize()}.
 *
 * <p>Supports all static validation parameters (see {@link SAML2AssertionValidationParameters}). The following are
 * recommended:
 * <ul>
 *     <li>{@link SAML2AssertionValidationParameters#CLOCK_SKEW}: Optional. If not present the default clock skew of
 *     {@link Duration#ZERO} will be used. The SAML 2.0 specification recommend supporting a clock skew.
 *     <li>{@link SAML2AssertionValidationParameters#COND_VALID_AUDIENCES}: Optional. The set of allowed audiences.
 * </ul>
 *
 * <p>The required conditions and attributes are extracted, verified then put in the {@link ValidationContext}
 * dynamic parameters and can easily be retrieved after validation. See {@link ChEprAssertionValidationParameters}
 * for the list.
 *
 * @author Quentin Ligier
 */
@ThreadSafe // The only thread-unsafe object seems to be the ValidationContext
public class ChEprAssertionValidator {
    private static final Logger log = LoggerFactory.getLogger(ChEprAssertionValidator.class);

    public static final String ERRMSG_ATTRIBUTE = "The attribute '";
    public static final String ERRMSG_IS_MISSING = "' is missing";
    public static final String NAMESPACE_GS1_GLN = "urn:gs1:gln";
    public static final String ERRMSG_SUBJECT_CONFIRMATION_MISSING = "The SubjectConfirmation is missing";

    /**
     * The SAML 2 {@link Assertion} validator implemented by OpenSAML and configured for the CH-EPR specifications.
     */
    private final SAML20AssertionValidator validator;

    /**
     * Constructor.
     *
     * @param oneTimeUseConditionExpires The time for disposal of tracked assertion from the replay cache. If
     *                                   {@code null}, the OneTimeUseCondition is not enforced.
     * @param signatureTrustEngine       The trust engine to use to validate signatures. This can be an
     *                                   {@link ExplicitKeySignatureTrustEngine} or any other implementation. A
     *                                   {@link KeyInfoCredentialResolver} is not needed, as we don't expect a KeyInfo
     *                                   in the CH:XUA assertions.
     * @throws ComponentInitializationException if the {@link ReplayCache} of the {@link OneTimeUseConditionValidator}
     *                                          fails to initialize.
     */
    public ChEprAssertionValidator(@Nullable final Duration oneTimeUseConditionExpires,
                                   @Nullable final SignatureTrustEngine signatureTrustEngine)
            throws ComponentInitializationException {
        final var conditionValidators = new ArrayList<ConditionValidator>();
        conditionValidators.add(new ChEprAudienceRestrictionConditionValidator());
        conditionValidators.add(new ChEprDelegationRestrictionConditionValidator());
        if (oneTimeUseConditionExpires != null) {
            final var storageService = new MemoryStorageService();
            storageService.setId("memory-storage-saml-onetimeuse");
            storageService.setCleanupInterval(Duration.ofSeconds(900));
            storageService.initialize();
            final var cache = new ReplayCache();
            cache.setStorage(storageService);
            cache.initialize();
            conditionValidators.add(new OneTimeUseConditionValidator(cache, oneTimeUseConditionExpires));
        }

        if (signatureTrustEngine == null) {
            log.warn("Using ChEprAssertionValidator without signature validator!");
        }

        this.validator = new SAML20AssertionValidator(
                conditionValidators,
                List.of(new ChEprSubjectConfirmationBearerValidator()),
                List.of(new ChEprAttributeStatementValidator()),
                null,
                signatureTrustEngine,
                null // No signature pre-validation needed, CH-EPR does not add requirements
        );
    }

    /**
     * Validate the supplied SAML 2 {@link Assertion}, using the parameters from the supplied
     * {@link ValidationContext}.
     *
     * @param assertion        The assertion being evaluated.
     * @param staticParameters ?? or null.
     * @return the validation result.
     * @throws AssertionValidationException if there is a fatal error evaluating the validity of the assertion.
     */
    public ChEprValidationResult validate(final Assertion assertion,
                                          @Nullable final Map<String, @Nullable Object> staticParameters)
            throws AssertionValidationException {
        Objects.requireNonNull(assertion, "assertion shall not be null in validate()");

        // Create a ValidationContext with some of our static parameters
        final Map<String, @Nullable Object> newStaticParameters;
        if (staticParameters == null) {
            newStaticParameters = new HashMap<>();
        } else {
            newStaticParameters = new HashMap<>(staticParameters);
        }

        newStaticParameters.putIfAbsent(CLOCK_SKEW, Duration.ZERO);
        newStaticParameters.put(SIGNATURE_REQUIRED, true);
        final var validationContext = new ValidationContext(newStaticParameters);

        // Extract the role that will influence other CH-EPR validators
        ValidationResult result = this.validateRole(assertion, validationContext);
        if (result != ValidationResult.VALID) {
            return new ChEprValidationResult(result, validationContext);
        }
        final var role = (Role) validationContext.getDynamicParameters().get(CH_EPR_ROLE);

        result = this.validateSubject(assertion.getSubject(), validationContext, role);
        if (result != ValidationResult.VALID) {
            return new ChEprValidationResult(result, validationContext);
        }

        // Perform the main SAML 2 validation
        result = this.validator.validate(assertion, validationContext);
        if (result != ValidationResult.VALID) {
            return new ChEprValidationResult(result, validationContext);
        }

        validationContext.getDynamicParameters().computeIfAbsent(CH_EPR_ORGANIZATIONS_ID,
                                                                 key -> new ArrayList<String>());
        validationContext.getDynamicParameters().computeIfAbsent(CH_EPR_ORGANIZATIONS_NAME,
                                                                 key -> new ArrayList<String>());

        // Check that all conditions/assertions have been validated and extracted in the context
        result = this.validateRequiredAssertions(assertion, validationContext, role);
        return new ChEprValidationResult(result, validationContext);
    }

    /**
     * Extracts the CH-EPR Role from the {@link Assertion}, validates it and puts it in the {@link ValidationContext}
     * dynamic parameters. Other CH-EPR validator depend on this value.
     *
     * @param assertion The assertion being evaluated.
     * @param context   The current validation context.
     * @return the validation result.
     */
    ValidationResult validateRole(final Assertion assertion,
                                  final ValidationContext context) {
        final var roleAttribute = Optional.ofNullable(assertion.getAttributeStatements())
                .map(OptionalUtils::getListOnlyElement)
                .map(AttributeStatement::getAttributes)
                .orElse(Collections.emptyList())
                .stream()
                .filter(a -> OASIS_XACML_ROLE.equals(a.getName()))
                .findAny()
                .orElse(null);
        if (roleAttribute == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ROLE + ERRMSG_IS_MISSING);
            return ValidationResult.INVALID;
        }
        var role = Optional.ofNullable(roleAttribute.getAttributeValues())
                .map(OptionalUtils::getListOnlyElement)
                .map(xmlObject -> OptionalUtils.castOrNull(xmlObject, AttributeValueImpl.class))
                .map(attributeValue -> attributeValue.getUnknownXMLObjects(new QName("urn:hl7-org:v3", "Role")))
                .map(OptionalUtils::getListOnlyElement)
                .map(xmlObject -> OptionalUtils.castOrNull(xmlObject, CodedWithEquivalentImpl.class))
                .filter(r -> "2.16.756.5.30.1.127.3.10.6".equals(r.getCodeSystem()))
                .map(AbstractImpl::getCode)
                .map(Role::getEnum)
                .filter(r -> r != Role.ASSISTANT && r != Role.TECHNICAL_USER)
                .orElse(null);
        if (role == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ROLE + "' contains " +
                                                        "an invalid value");
            return ValidationResult.INVALID;
        }

        // Assistants and technical users are also using HCP, detect it and upgrade the code
        if (role == Role.HEALTHCARE_PROFESSIONAL && assertion.getConditions() != null) {
            for (final var condition : assertion.getConditions().getConditions(DelegationRestrictionType.TYPE_NAME)) {
                if (!(condition instanceof final DelegationRestrictionType delegationRestriction)) {
                    continue;
                }
                final var nameQualifier = Optional.ofNullable(delegationRestriction.getDelegates())
                        .map(OptionalUtils::getListOnlyElement)
                        .map(Delegate::getNameID)
                        .filter(n -> NameIDType.PERSISTENT.equals(n.getFormat()))
                        .map(NameIDType::getNameQualifier)
                        .orElse(null);
                if (NAMESPACE_GS1_GLN.equals(nameQualifier)) {
                    role = Role.ASSISTANT;
                } else if (TECHNICAL_USER_ID.equals(nameQualifier)) {
                    role = Role.TECHNICAL_USER;
                } else {
                    return ValidationResult.INVALID;
                }
            }
        }

        context.getDynamicParameters().put(CH_EPR_ROLE, role);
        return ValidationResult.VALID;
    }

    /**
     * Validates the Subject. The validation of the SubjectConfirmation is delegated to the
     * {@link ChEprSubjectConfirmationBearerValidator}.
     *
     * @param subject The Subject to be validated.
     * @param context The current validation context.
     * @param role    The subject's role.
     * @return the validation result.
     */
    ValidationResult validateSubject(@Nullable final Subject subject,
                                     final ValidationContext context,
                                     final Role role) {
        if (subject == null) {
            context.setValidationFailureMessage("The Subject is missing");
            return ValidationResult.INVALID;
        }

        final var nameId = subject.getNameID();
        if (nameId == null || nameId.getNameQualifier() == null || nameId.getValue() == null) {
            context.setValidationFailureMessage("The Subject NameID is missing");
            return ValidationResult.INVALID;
        }

        if ((role == Role.HEALTHCARE_PROFESSIONAL || role == Role.ASSISTANT || role == Role.TECHNICAL_USER)
                && !NAMESPACE_GS1_GLN.equals(nameId.getNameQualifier())) {
            context.setValidationFailureMessage("The healthcare professional GLN is missing in the Subject");
            return ValidationResult.INVALID;
        } else if (role == Role.POLICY_ADMINISTRATOR && !POLICY_ADMINISTRATOR_ID.equals(nameId.getNameQualifier())) {
            context.setValidationFailureMessage("The policy administrator ID is missing in the Subject");
            return ValidationResult.INVALID;
        } else if (role == Role.DOCUMENT_ADMINISTRATOR && !DOCUMENT_ADMINISTRATOR_ID.equals(nameId.getNameQualifier())) {
            context.setValidationFailureMessage("The document administrator ID is missing in the Subject");
            return ValidationResult.INVALID;
        } else if (role == Role.PATIENT && !EPR_SPID_URN.equals(nameId.getNameQualifier())) {
            context.setValidationFailureMessage("The patient EPR-SPID is missing in the Subject");
            return ValidationResult.INVALID;
        } else if (role == Role.REPRESENTATIVE && !REPRESENTATIVE_ID.equals(nameId.getNameQualifier())) {
            context.setValidationFailureMessage("The representative ID is missing in the Subject");
            return ValidationResult.INVALID;
        }

        context.getDynamicParameters().put(CH_EPR_RESPONSIBLE_SUBJECT_ID, nameId.getValue());
        return ValidationResult.VALID;
    }

    /**
     * Validates that all required attributes and conditions have been properly validated and put in the
     * {@link ValidationContext} dynamic parameters.
     *
     * @param assertion The assertion being evaluated.
     * @param context   The current validation context.
     * @param role      The subject's role.
     * @return the validation result.
     */
    @SuppressWarnings("unchecked")
    ValidationResult validateRequiredAssertions(final Assertion assertion,
                                                final ValidationContext context,
                                                final Role role) {
        if (context.getDynamicParameters().getOrDefault(CH_EPR_PURPOSE_OF_USE, null) == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_PURPOSEOFUSE + ERRMSG_IS_MISSING);
            return ValidationResult.INVALID;
        }
        if (context.getDynamicParameters().getOrDefault(CH_EPR_ORGANIZATIONS_NAME, null) == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANISATION + ERRMSG_IS_MISSING);
            return ValidationResult.INVALID;
        }
        if (context.getDynamicParameters().getOrDefault(CH_EPR_ORGANIZATIONS_ID, null) == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANIZATIONID + ERRMSG_IS_MISSING);
            return ValidationResult.INVALID;
        }
        if (role == Role.HEALTHCARE_PROFESSIONAL || role == Role.ASSISTANT || role == Role.TECHNICAL_USER) {
            if (((List<String>) context.getDynamicParameters().get(CH_EPR_ORGANIZATIONS_NAME)).isEmpty()) {
                context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANISATION + "' shall not be empty");
                return ValidationResult.INVALID;
            }
            if (((List<String>) context.getDynamicParameters().get(CH_EPR_ORGANIZATIONS_ID)).isEmpty()) {
                context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + OASIS_XACML_ORGANIZATIONID + "' shall not be empty");
                return ValidationResult.INVALID;
            }
        }
        if (context.getDynamicParameters().getOrDefault(CH_EPR_HOME_COMMUNITY_ID, null) == null) {
            context.setValidationFailureMessage(ERRMSG_ATTRIBUTE + IHE_XCA_HOMECOMMUNITYID + ERRMSG_IS_MISSING);
            return ValidationResult.INVALID;
        }
        if (context.getDynamicParameters().getOrDefault(CH_EPR_RESPONSIBLE_SUBJECT_ID, null) == null) {
            context.setValidationFailureMessage("The Subject is missing");
            return ValidationResult.INVALID;
        }

        if (role == Role.ASSISTANT) {
            if (context.getDynamicParameters().getOrDefault(CH_EPR_ASSISTANT_NAME, null) == null) {
                context.setValidationFailureMessage(ERRMSG_SUBJECT_CONFIRMATION_MISSING);
                return ValidationResult.INVALID;
            }
            if (context.getDynamicParameters().getOrDefault(CH_EPR_ASSISTANT_GLN, null) == null) {
                context.setValidationFailureMessage(ERRMSG_SUBJECT_CONFIRMATION_MISSING);
                return ValidationResult.INVALID;
            }
        }
        if (role == Role.TECHNICAL_USER && context.getDynamicParameters().getOrDefault(CH_EPR_TCU_ID, null) == null) {
            context.setValidationFailureMessage(ERRMSG_SUBJECT_CONFIRMATION_MISSING);
            return ValidationResult.INVALID;
        }

        if (assertion.getConditions() == null || assertion.getConditions().getNotBefore() == null) {
            context.setValidationFailureMessage("The Condition NotBefore attribute is missing");
            return ValidationResult.INVALID;
        }
        if (assertion.getConditions().getNotOnOrAfter() == null) {
            context.setValidationFailureMessage("The Condition NotOnOrAfter attribute is missing");
            return ValidationResult.INVALID;
        }

        return ValidationResult.VALID;
    }
}
