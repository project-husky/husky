/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.xua.validation;

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.communication.ch.enums.PurposeOfUse;
import org.husky.communication.ch.enums.Role;
import org.husky.xua.helpers.SignXua;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.security.credential.BasicCredential;
import org.opensaml.security.credential.UsageType;
import org.opensaml.security.credential.impl.CollectionCredentialResolver;
import org.opensaml.xmlsec.signature.support.impl.ExplicitKeySignatureTrustEngine;
import org.w3c.dom.Element;

import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.CLOCK_SKEW;

/**
 * Tests for the {@link ChEprAssertionValidator} class.
 *
 * @author Quentin Ligier
 */
class ChEprAssertionValidatorTest {

    /**
     * A validator with the 'husky_test_keystore1.jks' public key to validate signatures.
     */
    @MonotonicNonNull
    private static ChEprAssertionValidator VALIDATOR = null;

    /**
     * A validator with no public key to validate signatures.
     */
    @MonotonicNonNull
    private static ChEprAssertionValidator UNVALIDATOR = null;
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER = null;

    private static final Map<String, @Nullable Object> VALIDATION_PARAMS = new HashMap<>();

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Initialize the library
        InitializationService.initialize();

        // Load the keystore
        final KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(SignXua.class.getResourceAsStream("/husky_test_keystore1.jks"), "password".toCharArray());

        final RSAPrivateCrtKey privateKey = (RSAPrivateCrtKey) ((KeyStore.PrivateKeyEntry) ks.getEntry("testkey",
                new KeyStore.PasswordProtection("password".toCharArray()))).getPrivateKey();
        final var publicKey =
                KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(privateKey.getModulus(), privateKey.getPublicExponent()));

        final var credential = new BasicCredential(publicKey);
        credential.setUsageType(UsageType.SIGNING);
        credential.setEntityId("xua.hin.ch");

        final var trustEngine = new ExplicitKeySignatureTrustEngine(
                new CollectionCredentialResolver(List.of(credential)),
                new NoopKeyInfoCredentialResolver() // A KeyInfo element is not expected in the Signature
        );

        VALIDATOR = new ChEprAssertionValidator(Duration.ofSeconds(3), trustEngine);
        UNVALIDATOR = new ChEprAssertionValidator(Duration.ofSeconds(3), new ExplicitKeySignatureTrustEngine(
                new CollectionCredentialResolver(),
                new NoopKeyInfoCredentialResolver()
        ));
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(Assertion.TYPE_NAME);
        VALIDATION_PARAMS.put(CLOCK_SKEW, Duration.ofDays(3650));
    }

    @Test
    void testValidateHcp() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.HEALTHCARE_PROFESSIONAL, result.getRole());
        assertEquals(PurposeOfUse.NORMAL_ACCESS, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("2000000090092", result.getResponsibleSubjectId());
        assertEquals("Martina Musterarzt", result.getSubjectName());
        assertEquals("http://ihe.connectathon.XUA/X-ServiceProvider-IHE-Connectathon", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(List.of("urn:oid:2.2.2.1", "urn:oid:2.2.2.2", "urn:oid:2.2.2.3"), result.getOrganizationsId());
        assertEquals(List.of("Name of group with id urn:oid:2.2.2.1", "Name of group with id urn:oid:2.2.2.2", "Name of group with id urn:oid:2.2.2.3"), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidSignatureWithoutPublicKey() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var result = UNVALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testInvalidSignatureWithPublicKey() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var signatureValue = assertion.getSignature().getDOM().getElementsByTagNameNS("http://www.w3" +
                ".org/2000/09/xmldsig#", "SignatureValue").item(0);
        signatureValue.setTextContent(signatureValue.getTextContent().replace('a', 'e')); // Mess with the signature
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testInvalidReference() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var reference = (Element) assertion.getSignature().getDOM().getElementsByTagNameNS("http://www.w3" +
                ".org/2000/09/xmldsig#", "Reference").item(0);
        reference.setAttribute("URI", reference.getAttribute("URI").replace('0', '6')); // Mess with the reference
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testInvalidDigest() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var digestValue = assertion.getSignature().getDOM().getElementsByTagNameNS("http://www.w3" +
                ".org/2000/09/xmldsig#", "DigestValue").item(0);
        digestValue.setTextContent(digestValue.getTextContent().replace('W', 'k')); // Mess with the digest
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testModifiedContent() throws Exception {
        final var assertion = this.unmarshal("assertion-hcp.xml");
        final var audience = assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Audience").item(0);
        audience.setTextContent("Not the original content");
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    private Assertion unmarshal(final String fileName) throws Exception {
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("xua/" + fileName)))
                .getDocumentElement();
        return (Assertion) UNMARSHALLER.unmarshall(element);
    }

    /**
     * TODO:
     * test notBefore, notOnOrAfter, notOnOrAfter <= notBefore
     */
}