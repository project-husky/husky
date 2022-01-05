package org.husky.xua.validation;

import static org.husky.common.ch.ChEpr.EPR_SPID_URN;
import static org.husky.xua.ChEprXuaSpecifications.DOCUMENT_ADMINISTRATOR_ID;
import static org.husky.xua.ChEprXuaSpecifications.POLICY_ADMINISTRATOR_ID;
import static org.husky.xua.ChEprXuaSpecifications.REPRESENTATIVE_ID;
import static org.husky.xua.ChEprXuaSpecifications.TECHNICAL_USER_ID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.IHE_XCA_HOMECOMMUNITYID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_ORGANISATION;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_ORGANIZATIONID;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_PURPOSEOFUSE;
import static org.husky.xua.communication.xua.XUserAssertionConstants.OASIS_XACML_ROLE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ASSISTANT_GLN;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ASSISTANT_NAME;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_HOME_COMMUNITY_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ORGANIZATIONS_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ORGANIZATIONS_NAME;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_PURPOSE_OF_USE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_RESPONSIBLE_SUBJECT_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ROLE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_TCU_ID;
import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.CLOCK_SKEW;
import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.SIGNATURE_REQUIRED;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.xml.namespace.QName;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.communication.ch.enums.Role;
import org.husky.xua.hl7v3.impl.AbstractImpl;
import org.husky.xua.hl7v3.impl.CodedWithEquivalentImpl;
import org.husky.xua.validation.condition.ChEprAudienceRestrictionConditionValidator;
import org.husky.xua.validation.condition.ChEprDelegationRestrictionConditionValidator;
import org.husky.xua.validation.statement.ChEprAttributeStatementValidator;
import org.husky.xua.validation.subject.ChEprSubjectConfirmationBearerValidator;
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
import org.opensaml.security.credential.impl.CollectionCredentialResolver;
import org.opensaml.storage.ReplayCache;
import org.opensaml.storage.impl.MemoryStorageService;
import org.opensaml.xmlsec.signature.support.impl.ExplicitKeySignatureTrustEngine;

import net.shibboleth.utilities.java.support.component.ComponentInitializationException;

/**
 * A component capable of performing core validation of SAML version 2.0 {@link Assertion} instances in use in the
 * CH-EPR domain.
 *
 * <p>The calling application needs to initiate the SAML library by calling {@link InitializationService#initialize()}.
 *
 * <p>Supports the following {@link ValidationContext} static parameters:
 * <ul>
 *     <li>{@link SAML2AssertionValidationParameters#CLOCK_SKEW}: Optional. If not present the default clock skew of
 *     {@link Duration#ZERO} will be used.
 *     <li>Others?
 * </ul>
 *
 * <p>The required conditions and attributes are extracted, verified then put in the {@link ValidationContext}
 * dynamic parameters and can easily be retrieved after validation. See {@link ChEprAssertionValidationParameters}
 * for the list.
 *
 * @author Quentin Ligier
 */
public class ChEprAssertionValidator {
	
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
     * @param oneTimeUseConditionExpires The time for disposal of tracked assertion from the replay cache. If {@code
     *                                   null}, the OneTimeUseCondition is not processed.
     * @throws ComponentInitializationException if the {@link ReplayCache} of the {@link OneTimeUseConditionValidator}
     *                                          fails to initialize.
     */
    
    /* development in progress */
    @SuppressWarnings({"java:S1481","java:S1874"})  
     
    public ChEprAssertionValidator(@Nullable final Duration oneTimeUseConditionExpires) throws ComponentInitializationException {
        final var conditionValidators = new ArrayList<ConditionValidator>();
        conditionValidators.add(new ChEprAudienceRestrictionConditionValidator());
        conditionValidators.add(new ChEprDelegationRestrictionConditionValidator());
        if (oneTimeUseConditionExpires != null) {
            final var cache = new ReplayCache();
            cache.setStorage(new MemoryStorageService());
            cache.doInitialize();
            conditionValidators.add(new OneTimeUseConditionValidator(cache, oneTimeUseConditionExpires));
        }

        final var trustEngine = new ExplicitKeySignatureTrustEngine(
                new CollectionCredentialResolver(),
                new NoopKeyInfoCredentialResolver() // A KeyInfo element is not expected in the Signature
        );
        
        this.validator = new SAML20AssertionValidator(
                conditionValidators,
                List.of(new ChEprSubjectConfirmationBearerValidator()),
                List.of(new ChEprAttributeStatementValidator()),
                null, // TODO
                null // No signature pre-validation needed, CH-EPR does not add requirements
        );
    }

    /**
     * Validate the supplied SAML 2 {@link Assertion}, using the parameters from the supplied {@link
     * ValidationContext}.
     *
     * @param assertion        The assertion being evaluated.
     * @param staticParameters ?? or null.
     * @return the validation result.
     * @throws AssertionValidationException if there is a fatal error evaluating the validity of the assertion.
     */
    public ChEprValidationResult validate(final Assertion assertion,
                                          @Nullable final Map<String, @Nullable Object> staticParameters) throws AssertionValidationException {
        Objects.requireNonNull(assertion);

        // Create a ValidationContext with some of our static parameters
        final Map<String, @Nullable Object> newStaticParameters;
        if (staticParameters == null) {
            newStaticParameters = new HashMap<>();
        } else {
            newStaticParameters = new HashMap<>(staticParameters);
        }

        newStaticParameters.putIfAbsent(CLOCK_SKEW, Duration.ZERO);
        newStaticParameters.put(SIGNATURE_REQUIRED, false); 
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
    private ValidationResult validateRole(final Assertion assertion,
                                          final ValidationContext context) {
        final var roleAttribute = Optional.ofNullable(assertion.getAttributeStatements())
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
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
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .filter(AttributeValueImpl.class::isInstance)
                .map(AttributeValueImpl.class::cast)
                .map(attributeValue -> attributeValue.getUnknownXMLObjects(new QName("urn:hl7-org:v3", "Role")))
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
				.filter(CodedWithEquivalentImpl.class::isInstance).map(CodedWithEquivalentImpl.class::cast)
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
                        .filter(l -> l.size() == 1)
                        .map(l -> l.get(0))
                        .map(Delegate::getNameID)
                        .filter(n -> NameIDType.PERSISTENT.equals(n.getFormat()))
                        .map(NameIDType::getNameQualifier)
                        .orElse(null);
                if (NAMESPACE_GS1_GLN.equals(nameQualifier)) {
                    role = Role.ASSISTANT;
                } else if (TECHNICAL_USER_ID.equals(nameQualifier)) {
                    role = Role.TECHNICAL_USER;
                } else {
                    return ValidationResult.INDETERMINATE;
                }
            }
        }

        context.getDynamicParameters().put(CH_EPR_ROLE, role);
        return ValidationResult.VALID;
    }

    /**
     * Validates the Subject. The validation of the SubjectConfirmation is delegated to the {@link
     * ChEprSubjectConfirmationBearerValidator}.
     *
     * @param subject The Subject to be validated.
     * @param context The current validation context.
     * @param role    The subject's role.
     * @return the validation result.
     */
    private ValidationResult validateSubject(@Nullable final Subject subject,
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
     * Validates that all required attributes and conditions have been properly validated and put in the {@link
     * ValidationContext} dynamic parameters.
     *
     * @param assertion The assertion being evaluated.
     * @param context   The current validation context.
     * @param role      The subject's role.
     * @return the validation result.
     */
    private ValidationResult validateRequiredAssertions(final Assertion assertion,
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
