/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua.validation.subject;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.assertion.SubjectConfirmationValidator;
import org.opensaml.saml.saml2.core.SubjectConfirmation;
import org.projecthusky.communication.ch.enums.stable.Role;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.projecthusky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * Tests for {@link ChEprSubjectConfirmationBearerValidator}.
 *
 * @author Quentin Ligier
 */
class ChEprSubjectConfirmationBearerValidatorTest {

    private static final SubjectConfirmationValidator VALIDATOR = new ChEprSubjectConfirmationBearerValidator();
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialize the library
        InitializationService.initialize();
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(SubjectConfirmation.TYPE_NAME);
    }

    /**
     * The context is dirtied by each call to validate(), recreate it each time.
     */
    /* simple test function to compare results for various roles, no use reducing complexity */
    @Test
    @SuppressWarnings("java:S5961")
    void testValidate() throws Exception {
        ValidationResult result;
        ValidationContext context;

        var subjectConfirmation = this.unmarshal("""
                                                                <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln" xmlns:saml2="urn:oasis:names:tc:SAML:2.0:assertion">2000000090108</saml2:NameID>
                                                                <saml2:SubjectConfirmationData>
                                                                    <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                        <saml2:AttributeValue xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                    </saml2:Attribute>
                                                                </saml2:SubjectConfirmationData>
                                                         """);
        context = this.getContext(Role.HEALTHCARE_PROFESSIONAL);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.TECHNICAL_USER);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        context = this.getContext(Role.POLICY_ADMINISTRATOR);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.DOCUMENT_ADMINISTRATOR);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.PATIENT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.REPRESENTATIVE);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:e-health-suisse:technical-user-id">urn:oid:1.3.6.1.4.1.343</saml2:NameID>
                                                     """);
        context = this.getContext(Role.HEALTHCARE_PROFESSIONAL);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        context = this.getContext(Role.TECHNICAL_USER);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.POLICY_ADMINISTRATOR);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.DOCUMENT_ADMINISTRATOR);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.PATIENT);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);

        context = this.getContext(Role.REPRESENTATIVE);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.VALID, result);
    }

    @Test
    void testValidateAssistant() throws Exception {
        ValidationResult result;
        ValidationContext context;

        // No NameID
        var subjectConfirmation = this.unmarshal("""
                                                                <saml2:SubjectConfirmationData>
                                                                    <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                        <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                    </saml2:Attribute>
                                                                </saml2:SubjectConfirmationData>
                                                         """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // No 'urn:gs1:gln' NameID
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent">2000000090108</saml2:NameID>
                                                            <saml2:SubjectConfirmationData>
                                                                <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                    <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                </saml2:Attribute>
                                                            </saml2:SubjectConfirmationData>
                                                     """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // Wrong GLN
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                                                            <saml2:SubjectConfirmationData>
                                                                <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                    <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                </saml2:Attribute>
                                                            </saml2:SubjectConfirmationData>
                                                     """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "1234");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // Two AttributeValues
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                                                            <saml2:SubjectConfirmationData>
                                                                <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                    <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                    <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                </saml2:Attribute>
                                                            </saml2:SubjectConfirmationData>
                                                     """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // Two Attributes
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                                                            <saml2:SubjectConfirmationData>
                                                                <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                    <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                </saml2:Attribute>
                                                                <saml2:Attribute Name="urn:oasis:names:tc:xspa:1.0:subject:subject-id" NameFormat="urn:oasis:names:tc:SAML:2.0:attrname-format:uri">
                                                                    <saml2:AttributeValue xsi:type="xsd:string">Dagmar Musterassistent</saml2:AttributeValue>
                                                                </saml2:Attribute>
                                                            </saml2:SubjectConfirmationData>
                                                     """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // No SubjectConfirmationData
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                                                     """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // Empty SubjectConfirmationData
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:gs1:gln">2000000090108</saml2:NameID>
                                                            <saml2:SubjectConfirmationData></saml2:SubjectConfirmationData>
                                                     """);
        context = this.getContext(Role.ASSISTANT);
        context.getDynamicParameters().put(CH_EPR_ASSISTANT_GLN, "2000000090108");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);
    }

    @Test
    void testValidateTechnicalUser() throws Exception {
        ValidationResult result;
        ValidationContext context;

        // No NameID
        var subjectConfirmation = this.unmarshal("");
        context = this.getContext(Role.TECHNICAL_USER);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // No 'urn:e-health-suisse:technical-user-id' NameID
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent">urn:oid:1.3.6.1.4.1.343</saml2:NameID>
                                                     """);
        context = this.getContext(Role.TECHNICAL_USER);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.3.6.1.4.1.343");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);

        // Wrong ID
        subjectConfirmation = this.unmarshal("""
                                                            <saml2:NameID Format="urn:oasis:names:tc:SAML:2.0:nameid-format:persistent" NameQualifier="urn:e-health-suisse:technical-user-id">urn:oid:1.3.6.1.4.1.343</saml2:NameID>
                                                     """);
        context = this.getContext(Role.TECHNICAL_USER);
        context.getDynamicParameters().put(CH_EPR_TCU_ID, "1.2.3");
        result = VALIDATOR.validate(subjectConfirmation, null, context);
        assertEquals(ValidationResult.INVALID, result);
    }

    private ValidationContext getContext(final Role role) {
        final var context = new ValidationContext();
        context.getDynamicParameters().put(CH_EPR_ROLE, role);
        return context;
    }

    private SubjectConfirmation unmarshal(final String xml) throws Exception {
        final var bytes = ("<saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\" " +
                "xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + xml +
                "</saml2:SubjectConfirmation>").getBytes(StandardCharsets.UTF_8);
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(new ByteArrayInputStream(bytes))
                .getDocumentElement();
        return (SubjectConfirmation) UNMARSHALLER.unmarshall(element);
    }
}
