/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.xua.validation.condition;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.husky.communication.ch.enums.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.opensaml.saml.saml2.core.AudienceRestriction;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_AUDIENCE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ROLE;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link ChEprAudienceRestrictionConditionValidator}.
 *
 * @author Quentin Ligier
 */
class ChEprAudienceRestrictionConditionValidatorTest {

    private static final ConditionValidator VALIDATOR = new ChEprAudienceRestrictionConditionValidator();
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER = null;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialize the library
        InitializationService.initialize();
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(AudienceRestriction.TYPE_NAME);
    }

    /**
     * The context is dirtied by each call to validate(), recreate it each time.
     */
    /* simple test function to compare results for various roles, no use reducing complexity */
    @Test
    @SuppressWarnings("java:S5961")
    void testValidate() throws Exception {
        var condition = this.unmarshal("""
                <saml2:Audience>urn:e-health-suisse:token-audience:all-communities</saml2:Audience>
        """);

        ValidationResult result;
        ValidationContext context;

        context = this.getContext(Role.HEALTHCARE_PROFESSIONAL);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.VALID, result);
        assertNull(context.getValidationFailureMessage());
        assertEquals("urn:e-health-suisse:token-audience:all-communities", context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        context = this.getContext(Role.TECHNICAL_USER);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.VALID, result);
        assertNull(context.getValidationFailureMessage());
        assertEquals("urn:e-health-suisse:token-audience:all-communities", context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        context = this.getContext(Role.POLICY_ADMINISTRATOR);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        context = this.getContext(Role.DOCUMENT_ADMINISTRATOR);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        context = this.getContext(Role.PATIENT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        context = this.getContext(Role.REPRESENTATIVE);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        condition = this.unmarshal("""
                <saml2:Audience>urn:e-health-suisse:token-audience:all-communities</saml2:Audience>
                <saml2:Audience>urn:e-health-suisse:token-audience:all-communities</saml2:Audience>
        """);
        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        condition = this.unmarshal("<saml2:Audience>urn:ISSN:0167-6423</saml2:Audience>");
        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));

        condition = this.unmarshal("");
        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_AUDIENCE));
    }

    private ValidationContext getContext(final Role role) {
        final var context = new ValidationContext();
        context.getDynamicParameters().put(CH_EPR_ROLE, role);
        return context;
    }

    private AudienceRestriction unmarshal(final String xml) throws Exception {
        final var bytes = ("<saml2:AudienceRestriction xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">" + xml + "</saml2:AudienceRestriction>").getBytes(StandardCharsets.UTF_8);
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(new ByteArrayInputStream(bytes))
                .getDocumentElement();
        return (AudienceRestriction) UNMARSHALLER.unmarshall(element);
    }
}