package org.husky.xua.validation.condition;

import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ASSISTANT_GLN;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ROLE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_TCU_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.husky.communication.ch.enums.Role;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.ext.saml2delrestrict.DelegationRestrictionType;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.w3c.dom.Element;

/**
 * Tests for {@link ChEprDelegationRestrictionConditionValidator}.
 *
 * @author Quentin Ligier
 */
@Disabled
class ChEprDelegationRestrictionConditionValidatorTest {

    private static final ConditionValidator VALIDATOR = new ChEprDelegationRestrictionConditionValidator();
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER = null;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialize the library
        InitializationService.initialize();
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(DelegationRestrictionType.TYPE_NAME);
    }

    /**
     * The context is dirtied by each call to validate(), recreate it each time.
     */
    @Test
    void testValidate() throws Exception {
        var condition = this.unmarshal("""
                <del:Delegate>
                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                </del:Delegate>
        """);

        ValidationResult result;
        ValidationContext context;

        context = this.getContext(Role.HEALTHCARE_PROFESSIONAL);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.VALID, result);
        assertNull(context.getValidationFailureMessage());
        assertEquals("2000000090108", context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        condition = this.unmarshal("""
                <del:Delegate>
                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:e-health-suisse:technical-user-id">2000000090108</saml2:NameID>
                </del:Delegate>
        """);
        context = this.getContext(Role.TECHNICAL_USER);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.VALID, result);
        assertNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.POLICY_ADMINISTRATOR);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.DOCUMENT_ADMINISTRATOR);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.PATIENT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.REPRESENTATIVE);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        condition = this.unmarshal("""
                <del:Delegate>
                    <saml2:NameID NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                </del:Delegate>
        """);
        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        condition = this.unmarshal("""
                <del:Delegate>
                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                </del:Delegate>
                <del:Delegate>
                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                </del:Delegate>
        """);
        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        condition = this.unmarshal("""
                <del:Delegate>
                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:e-health-suisse:technical-user-id">2000000090108</saml2:NameID>
                </del:Delegate>
        """);
        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        condition = this.unmarshal("""
                <del:Delegate>
                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                </del:Delegate>
        """);
        context = this.getContext(Role.TECHNICAL_USER);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessage());
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));
    }

    private ValidationContext getContext(final Role role) {
        final var context = new ValidationContext();
        context.getDynamicParameters().put(CH_EPR_ROLE, role);
        return context;
    }

    private DelegationRestrictionType unmarshal(final String xml) throws Exception {
        final var bytes = ("<saml2:Condition xsi:type=\"del:DelegationRestrictionType\" xmlns:del=\"urn:oasis:names:tc:SAML:2.0:conditions:delegation\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">" + xml + "</saml2:Condition>").getBytes(StandardCharsets.UTF_8);
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(new ByteArrayInputStream(bytes))
                .getDocumentElement();
        return (DelegationRestrictionType) UNMARSHALLER.unmarshall(element);
    }
}