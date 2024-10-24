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

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.ext.saml2delrestrict.DelegationRestrictionType;
import org.opensaml.saml.saml2.assertion.ConditionValidator;
import org.projecthusky.communication.ch.enums.stable.Role;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.projecthusky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * Tests for {@link ChEprDelegationRestrictionConditionValidator}.
 *
 * @author Quentin Ligier
 */
class ChEprDelegationRestrictionConditionValidatorTest {

    private static final ConditionValidator VALIDATOR = new ChEprDelegationRestrictionConditionValidator();
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialize the library
        InitializationService.initialize();
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(DelegationRestrictionType.TYPE_NAME);
    }

    /**
     * The context is dirtied by each call to validate(), recreate it each time.
     */
    /* simple test function to compare results for various roles, no use reducing complexity */
    @Test
    @SuppressWarnings("java:S5961")
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
        assertNotNull(context.getValidationFailureMessages().get(0));
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.ASSISTANT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.VALID, result);
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()==0);
        assertEquals("2000000090108", context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        condition = this.unmarshal("""
                                               <del:Delegate>
                                                    <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent"
                                                                  NameQualifier="urn:e-health-suisse:technical-user-id">1.2.3</saml2:NameID>
                                              </del:Delegate>
                                           """);
        context = this.getContext(Role.TECHNICAL_USER);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.VALID, result);
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()==0);
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertEquals("1.2.3", context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.POLICY_ADMINISTRATOR);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.DOCUMENT_ADMINISTRATOR);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.PATIENT);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));

        context = this.getContext(Role.REPRESENTATIVE);
        result = VALIDATOR.validate(condition, null, context);
        assertEquals(ValidationResult.INVALID, result);
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
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
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
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
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
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
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
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
        assertNotNull(context.getValidationFailureMessages());
        assertTrue(context.getValidationFailureMessages().size()>0);
        assertNull(context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN));
        assertNull(context.getDynamicParameters().get(CH_EPR_TCU_ID));
    }

    private ValidationContext getContext(final Role role) {
        final var context = new ValidationContext();
        context.getDynamicParameters().put(CH_EPR_ROLE, role);
        return context;
    }

    private DelegationRestrictionType unmarshal(final String xml) throws Exception {
        final var bytes = ("<saml2:Condition xsi:type=\"del:DelegationRestrictionType\" xmlns:del=\"urn:oasis:names:tc:SAML:2.0:conditions:delegation\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\">" + xml + "</saml2:Condition>").getBytes(
                StandardCharsets.UTF_8);
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(new ByteArrayInputStream(bytes))
                .getDocumentElement();
        return (DelegationRestrictionType) UNMARSHALLER.unmarshall(element);
    }
}
