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

import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.communication.ch.enums.stable.PurposeOfUse;
import org.projecthusky.communication.ch.enums.stable.Role;
import org.projecthusky.xua.helpers.AssertionSigner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.common.assertion.ValidationResult;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.security.credential.BasicCredential;
import org.opensaml.security.credential.Credential;
import org.opensaml.security.credential.UsageType;
import org.opensaml.security.credential.impl.CollectionCredentialResolver;
import org.opensaml.xmlsec.signature.support.impl.ExplicitKeySignatureTrustEngine;
import org.w3c.dom.Element;

import java.io.StringReader;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

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
    private static ChEprAssertionValidator VALIDATOR;

    /**
     * A validator with no public key to validate signatures.
     */
    @MonotonicNonNull
    private static ChEprAssertionValidator UNVALIDATOR;

    /**
     * The assertion unmarshaller.
     */
    @MonotonicNonNull
    private static Unmarshaller UNMARSHALLER;

    @MonotonicNonNull
    private static Credential SIGNING_CRED;

    @MonotonicNonNull
    private static String SIGNED_HCP_ASSERTION;

    private static final Map<String, @Nullable Object> VALIDATION_PARAMS = new HashMap<>();

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT %1$tL] [%4$-7s] %5$s %n");

        // Initialize the library
        InitializationService.initialize();
        UNMARSHALLER = XMLObjectSupport.getUnmarshaller(Assertion.TYPE_NAME);

        // Load the keystore
        final KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(AssertionSigner.class.getResourceAsStream("/husky_test_keystore1.jks"), "password".toCharArray());
        final RSAPrivateCrtKey privateKey = (RSAPrivateCrtKey) ((KeyStore.PrivateKeyEntry) ks.getEntry("testkey",
                new KeyStore.PasswordProtection("password".toCharArray()))).getPrivateKey();
        final var publicKey =
                KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(privateKey.getModulus(), privateKey.getPublicExponent()));


        // Sign the HCP assertion
        final Assertion assertion = loadAndPrepareAssertion("xua/assertion-hcp.xml");
        SIGNING_CRED = new BasicCredential(publicKey, privateKey);
        SIGNED_HCP_ASSERTION = AssertionSigner.sign(assertion, SIGNING_CRED);

        // Initiate the validator
        final var credential = new BasicCredential(publicKey, privateKey);
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
        VALIDATION_PARAMS.put(CLOCK_SKEW, Duration.ofSeconds(30));
    }

    @Test
    void testValidateHcp() throws Exception {
        final var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
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
        assertEquals(List.of("2.2.2.1", "2.2.2.2", "2.2.2.3"), result.getOrganizationsId());
        assertEquals(List.of("Name of group with id urn:oid:2.2.2.1", "Name of group with id urn:oid:2.2.2.2", "Name of group with id urn:oid:2.2.2.3"), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidatePat() throws Exception {
        Assertion assertion = loadAndPrepareAssertion("xua/assertion-pat.xml");
        assertion = this.signAndUnmarshall(assertion);

        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.PATIENT, result.getRole());
        assertEquals(PurposeOfUse.NORMAL_ACCESS, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("305000", result.getResponsibleSubjectId());
        assertEquals("Iris Musterpatient", result.getSubjectName());
        assertEquals("http://ihe.connectathon.XUA/X-ServiceProvider-IHE-Connectathon", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(Collections.emptyList(), result.getOrganizationsId());
        assertEquals(Collections.emptyList(), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidateRep() throws Exception {
        Assertion assertion = loadAndPrepareAssertion("xua/assertion-rep.xml");
        assertion = this.signAndUnmarshall(assertion);

        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.REPRESENTATIVE, result.getRole());
        assertEquals(PurposeOfUse.NORMAL_ACCESS, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("7602501e-425d-43e8-b4e8-eabd50869e95", result.getResponsibleSubjectId());
        assertEquals("Peter Muster Stellvertreter", result.getSubjectName());
        assertEquals("http://ihe.connectathon.XUA/X-ServiceProvider-IHE-Connectathon", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(Collections.emptyList(), result.getOrganizationsId());
        assertEquals(Collections.emptyList(), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidateAss() throws Exception {
        Assertion assertion = loadAndPrepareAssertion("xua/assertion-ass.xml");
        assertion = this.signAndUnmarshall(assertion);

        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.ASSISTANT, result.getRole());
        assertEquals(PurposeOfUse.NORMAL_ACCESS, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("2000000090092", result.getResponsibleSubjectId());
        assertEquals("Martina Musterarzt", result.getSubjectName());
        assertEquals("urn:e-health-suisse:token-audience:all-communities", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(List.of("2.2.2.1", "2.2.2.2", "2.2.2.3"), result.getOrganizationsId());
        assertEquals(List.of("Name of group with id urn:oid:2.2.2.1", "Name of group with id urn:oid:2.2.2.2", "Name of group with id urn:oid:2.2.2.3"), result.getOrganizationsName());
        assertEquals("2000000090108", result.getAssistantGln());
        assertEquals("Dagmar Musterassistent", result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidateTcu() throws Exception {
        Assertion assertion = loadAndPrepareAssertion("xua/assertion-tcu.xml");
        assertion = this.signAndUnmarshall(assertion);

        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.TECHNICAL_USER, result.getRole());
        assertEquals(PurposeOfUse.AUTOMATIC_UPLOAD, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("2000000090201", result.getResponsibleSubjectId());
        assertEquals("Martina Musterarzt", result.getSubjectName());
        assertEquals("urn:e-health-suisse:token-audience:all-communities", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(List.of("2.2.2.1", "2.2.2.2", "2.2.2.3"), result.getOrganizationsId());
        assertEquals(List.of("Name of group with id urn:oid:2.2.2.1", "Name of group with id urn:oid:2.2.2.2", "Name of group with id urn:oid:2.2.2.3"), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertEquals("urn:oid:1.3.6.1.4.1.343", result.getTechnicalUserId());
    }

    @Test
    void testValidatePadm() throws Exception {
        Assertion assertion = loadAndPrepareAssertion("xua/assertion-padm.xml");
        assertion = this.signAndUnmarshall(assertion);

        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.POLICY_ADMINISTRATOR, result.getRole());
        assertEquals(PurposeOfUse.NORMAL_ACCESS, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("f94e868c-f849-490c-9886-77a2b65ab62f", result.getResponsibleSubjectId());
        assertEquals("Sabine Muster-Administrator", result.getSubjectName());
        assertEquals("http://ihe.connectathon.XUA/X-ServiceProvider-IHE-Connectathon", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(Collections.emptyList(), result.getOrganizationsId());
        assertEquals(Collections.emptyList(), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidateDadm() throws Exception {
        Assertion assertion = loadAndPrepareAssertion("xua/assertion-dadm.xml");
        assertion = this.signAndUnmarshall(assertion);

        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.VALID, result.getResult());
        assertEquals(Role.DOCUMENT_ADMINISTRATOR, result.getRole());
        assertEquals(PurposeOfUse.NORMAL_ACCESS, result.getPurposeOfUse());
        assertEquals("761337610411353650", result.getPatientEprSpid());
        assertEquals("f94e868c-f849-490c-9886-77a2b65ab62f", result.getResponsibleSubjectId());
        assertEquals("Sabine Muster-Administrator", result.getSubjectName());
        assertEquals("http://ihe.connectathon.XUA/X-ServiceProvider-IHE-Connectathon", result.getAudienceRestriction());
        assertEquals("3.3.3.1", result.getHomeCommunityId());
        assertEquals(Collections.emptyList(), result.getOrganizationsId());
        assertEquals(Collections.emptyList(), result.getOrganizationsName());
        assertNull(result.getAssistantGln());
        assertNull(result.getAssistantName());
        assertNull(result.getTechnicalUserId());
    }

    @Test
    void testValidSignatureWithoutPublicKey() throws Exception {
        final var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        final var result = UNVALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testInvalidSignatureWithPublicKey() throws Exception {
        final var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
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
        final var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
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
        final var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        final var digestValue = assertion.getSignature().getDOM().getElementsByTagNameNS("http://www.w3" +
                ".org/2000/09/xmldsig#", "DigestValue").item(0);
        digestValue.setTextContent("abc123"); // Mess with the digest
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testModifiedContent() throws Exception {
        final var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        final var audience = assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Audience").item(0);
        audience.setTextContent("Not the original content");
        final var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertNotNull(result);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Signature of Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' from Issuer 'xua.hin.ch' was not valid", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testInvalidTimeBounds() throws Exception {
        // NotBefore in the future
        var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        var conditions = (Element) assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
                "Conditions").item(0);
        conditions.setAttribute("NotBefore", Instant.now().plusSeconds(120).toString());
        conditions.setAttribute("NotOnOrAfter", Instant.now().plusSeconds(180).toString());
        assertion = this.signAndUnmarshall(assertion);
        var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertTrue(result.getContext().getValidationFailureMessage().startsWith("Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' with NotBefore condition of"));

        // NotOnOrAfter in the past
        assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        conditions = (Element) assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
                "Conditions").item(0);
        conditions.setAttribute("NotBefore", Instant.now().minusSeconds(180).toString());
        conditions.setAttribute("NotOnOrAfter", Instant.now().minusSeconds(120).toString());
        assertion = this.signAndUnmarshall(assertion);
        result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertTrue(result.getContext().getValidationFailureMessage().startsWith("Assertion '_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' with NotOnOrAfter condition of"));

        // NotOnOrAfter before NotBefore
        assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        conditions = (Element) assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
                "Conditions").item(0);
        conditions.setAttribute("NotBefore", Instant.now().plusSeconds(180).toString());
        conditions.setAttribute("NotOnOrAfter", Instant.now().minusSeconds(120).toString());
        assertion = this.signAndUnmarshall(assertion);
        result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());

        // Assertion is valid in 10 seconds, less than the clock skew
        assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        conditions = (Element) assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
                "Conditions").item(0);
        conditions.setAttribute("NotBefore", Instant.now().plusSeconds(10).toString());
        conditions.setAttribute("NotOnOrAfter", Instant.now().plusSeconds(120).toString());
        assertion = this.signAndUnmarshall(assertion);
        result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.VALID, result.getResult());

        // Assertion was valid 10 seconds ago, less than the clock skew
        assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        conditions = (Element) assertion.getDOM().getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion",
                "Conditions").item(0);
        conditions.setAttribute("NotBefore", Instant.now().minusSeconds(180).toString());
        conditions.setAttribute("NotOnOrAfter", Instant.now().minusSeconds(10).toString());
        AssertionSigner.sign(assertion, SIGNING_CRED);
        result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.VALID, result.getResult());
    }

    @Test
    void testNoConditions() throws Exception {
        var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        assertion.setConditions(null);
        assertion = this.signAndUnmarshall(assertion);
        var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("The Condition NotBefore attribute is missing", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testNoSignature() throws Exception {
        var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        assertion.setSignature(null);
        var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Assertion was required to be signed, but was not", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testNoSubject() throws Exception {
        var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        assertion.setSubject(null);
        var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("The Subject is missing", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testNoIssuer() throws Exception {
        var assertion = this.unmarshal(SIGNED_HCP_ASSERTION);
        assertion.setIssuer(null);
        var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Assertion Issuer was missing and was required", result.getContext().getValidationFailureMessage());
    }

    @Test
    void testOneTimeUse() throws Exception {
        var assertion = this.unmarshal(SIGNED_HCP_ASSERTION.replace("</saml2:AudienceRestriction>", "</saml2:AudienceRestriction><saml2:OneTimeUse/>"));
        assertion = this.signAndUnmarshall(assertion);
        var result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.VALID, result.getResult());

        // The same assertion cannot be validated again immediately
        result = VALIDATOR.validate(assertion, VALIDATION_PARAMS);
        assertEquals(ValidationResult.INVALID, result.getResult());
        assertEquals("Condition '{urn:oasis:names:tc:SAML:2.0:assertion}OneTimeUse' of type 'null' in assertion " +
                "'_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' was not valid.: Assertion " +
                "'_2cfcc382-7e60-44e0-99b5-18e3f718cbc6' has a one time use condition and has been used before",
                result.getContext().getValidationFailureMessage());
    }

    private Assertion unmarshal(final String assertionXml) throws Exception {
        Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool())
                .parse(new StringReader(assertionXml))
                .getDocumentElement();
        return (Assertion) UNMARSHALLER.unmarshall(element);
    }

    private Assertion signAndUnmarshall(final Assertion assertion) throws Exception {
        return this.unmarshal(AssertionSigner.sign(assertion, SIGNING_CRED));
    }

    private static Assertion loadAndPrepareAssertion(final String fileName) throws Exception {
        final Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool(), "Can't get " +
                        "the parser pool")
                .parse(Objects.requireNonNull(ChEprAssertionValidatorTest.class.getClassLoader().getResourceAsStream(fileName),
                        "Can't find the XUA file to sign"))
                .getDocumentElement();
        element.setAttribute("IssueInstant", Instant.now().minusSeconds(120).toString());
        final var conditions = (Element) element.getElementsByTagNameNS("urn:oasis:names:tc:SAML:2.0:assertion", "Conditions").item(0);
        conditions.setAttribute("NotBefore", Instant.now().minusSeconds(120).toString());
        conditions.setAttribute("NotOnOrAfter", Instant.now().plusSeconds(180).toString());
        return (Assertion) UNMARSHALLER.unmarshall(element);
    }
}