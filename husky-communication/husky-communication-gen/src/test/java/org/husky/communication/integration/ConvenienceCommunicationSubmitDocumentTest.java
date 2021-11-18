/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.communication.DocumentMetadata;
import org.husky.common.communication.SubmissionSetMetadata;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.testhelper.PurposeOfUse;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdsTestUtils;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.husky.xua.communication.xua.RequestType;
import org.husky.xua.communication.xua.TokenType;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.RoleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Severity;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class ConvenienceCommunicationSubmitDocumentTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConvenienceCommunicationSubmitDocumentTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	private AffinityDomain affinityDomain = null;

	private SecurityHeaderElement securityHeaderElement;

	private String hcpAssertion = "<saml2:Assertion xmlns:saml2=\"urn:oasis:names:tc:SAML:2.0:assertion\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" ID=\"_8bbe7760-50c7-4103-8264-50a485479788\" IssueInstant=\"2015-03-18T09:23:19.375Z\" Version=\"2.0\"><saml2:Issuer Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\">urn:elga:ets</saml2:Issuer><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><ds:SignedInfo><ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /><ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\" /><ds:Reference URI=\"#_8bbe7760-50c7-4103-8264-50a485479788\"><ds:Transforms><ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /><ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"><ec:InclusiveNamespaces xmlns:ec=\"http://www.w3.org/2001/10/xml-exc-c14n#\" PrefixList=\"xs\" /></ds:Transform></ds:Transforms><ds:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><ds:DigestValue>PWc/D/NBInAk9D8lES+q1kIebtY=</ds:DigestValue></ds:Reference></ds:SignedInfo><ds:SignatureValue>F3lFBtnQliCP3TSnjpVCbbf2y6yFQSM3tcB8G5cKa5umep7s4zVvZpGcdf0QQnRVAwB4NlsORYb++Pfz0deVc4+fuYHUYE8oC0wexk3Yfzz1CDc4NWLH+bR7vYxwGYUvks3aAcHC/wxxc7Ezlv2LHf7t7Cqp+g1agpN0IlY34b+C6OEq4+4mOD9X07mtxQE34/63CZtAfQYkrWm19vVg/Zj1kBC7/WeCEn0AAy/mli+E/WQLSwPLm0wV7SBxhj3wqsiLp7YFcQWBZ+yGpUYujUYt+HkiKsIwvFtuUaLYGIiU8hHY0uXwl5ln6w9Zh+316blb1JLxn6/sTlBA26SwSQ==</ds:SignatureValue><ds:KeyInfo><ds:X509Data><ds:X509Certificate>MIIEQTCCAymgAwIBAgIBAzANBgkqhkiG9w0BAQUFADCBrDELMAkGA1UEBhMCQVQxEDAOBgNVBAgTB0F1c3RyaWExDzANBgNVBAcTBlZpZW5uYTEaMBgGA1UEChMRVGlhbmkgU3Bpcml0IEdtYkgxGTAXBgNVBAsTEERlbW8gRW52aXJvbm1lbnQxEDAOBgNVBAMTB1Rlc3QgQ0ExMTAvBgkqhkiG9w0BCQEWIm1hc3NpbWlsaWFuby5tYXNpQHRpYW5pLXNwaXJpdC5jb20wIBcNMTEwNzI3MDgyMTUyWhgPMjE5MDEyMzEwODIxNTJaMIGbMQswCQYDVQQGEwJBVDEQMA4GA1UECBMHQXVzdHJpYTEaMBgGA1UEChMRVGlhbmkgU3Bpcml0IEdtYkgxGTAXBgNVBAsTEERlbW8gRW52aXJvbm1lbnQxEDAOBgNVBAMTB3NlcnZlcjExMTAvBgkqhkiG9w0BCQEWIm1hc3NpbWlsaWFuby5tYXNpQHRpYW5pLXNwaXJpdC5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDcEpmyaFK8aKKrvaFZL6IGttOwI3ImGCUiwINIc+fcuVWRyT7Deb8tymnwVBfHVD/8Mh5ufwiS9YU774Ta2aB8H/Gwr5QIndu4eG9+adDEV3+Di6e3HhiA/8RP8CXCMGY4LOAjaNwUh/EEsn1S2oa+Dsiff5Ba8wmddc6pyYiwmhDfwEF0YBXDjvB8iexcLcOLvo/pl2hP87g/ptDXy0VUWWPzX9qxc6YtqhkS7EtmhzMW5deWvmRiPzJ2NVfCuvpcsK2Tii+MgCYbLXCLYkCg+5ZpV7esrqb5hWOf2tKUsDlu/sjck2lflsWTE1woKr0tbp7IxLzvGKx9hERB0hzJAgMBAAGjezB5MAkGA1UdEwQCMAAwLAYJYIZIAYb4QgENBB8WHU9wZW5TU0wgR2VuZXJhdGVkIENlcnRpZmljYXRlMB0GA1UdDgQWBBQU7M3dSaInYi+0MCDYpbACOCjvBzAfBgNVHSMEGDAWgBRkwihuUTlGpNDxrnZFbW84FXj72jANBgkqhkiG9w0BAQUFAAOCAQEAjEqNtOb2Hk6BpBDRXk9vd+0vvJSOWvdZnL3I2Kr30oN6nQOMud68FPI1JC1QwLni05ZVDTyMYOk/HRPK2jSByFmLZECaE6Q5Z1BTD9vR/AqtmTOvub922uS5gTpVEWijSW1o9j+LFzGC4k8l4xWidPtKa3o1aXSGcWSw0i1BKgxM3pMzSvKieZ2KQaHgZSb7bfk4uR4kAaida5hv6kveiDKRRG+8AeBvBD5lofaqUaUN9q/YIOucc8gHQBzGrmkObvyykzyPz5wddLmouqrZZqfufPTNh4whyABbXCPXsptDZZss8DlKS37rFVUKLHEhcfd1J+IOioaTnaPhgY/dXg==</ds:X509Certificate></ds:X509Data></ds:KeyInfo></ds:Signature><saml2:Subject><saml2:NameID Format=\"urn:oasis:names:tc:SAML:2.0:unspecified\">1.2.40.0.34.3.1.1000^K434@Wels-Grieskirchen-KL</saml2:NameID><saml2:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"><saml2:SubjectConfirmationData /></saml2:SubjectConfirmation></saml2:Subject><saml2:Conditions NotBefore=\"2015-03-18T09:23:19.374Z\" NotOnOrAfter=\"2015-03-18T13:23:19.374Z\"><saml2:ProxyRestriction Count=\"1\" /><saml2:AudienceRestriction><saml2:Audience>https://elga-online.at/KBS</saml2:Audience><saml2:Audience>https://elga-online.at/ETS</saml2:Audience></saml2:AudienceRestriction></saml2:Conditions><saml2:AuthnStatement AuthnInstant=\"2015-03-18T09:23:19.374Z\"><saml2:AuthnContext><saml2:AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:PreviousSession</saml2:AuthnContextClassRef></saml2:AuthnContext></saml2:AuthnStatement><saml2:AttributeStatement><saml2:Attribute FriendlyName=\"Purpose Of Use\" Name=\"urn:oasis:names:tc:xspa:1.0:subject:purposeofuse\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">PUBLICHEALTH</saml2:AttributeValue></saml2:Attribute><saml2:Attribute FriendlyName=\"ELGA Rolle\" Name=\"urn:oasis:names:tc:xacml:2.0:subject:role\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:anyType\"><Role xmlns=\"urn:hl7-org:v3\" code=\"702\" codeSystem=\"1.2.40.0.34.5.3\" codeSystemName=\"ELGA Rollen\" displayName=\"Krankenanstalt\" /></saml2:AttributeValue></saml2:Attribute><saml2:Attribute FriendlyName=\"XSPA Subject\" Name=\"urn:oasis:names:tc:xacml:1.0:subject:subject-id\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">Dr. John Zoidberg</saml2:AttributeValue></saml2:Attribute><saml2:Attribute FriendlyName=\"XSPA Organization ID\" Name=\"urn:oasis:names:tc:xspa:1.0:subject:organization-id\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:anyURI\">1.2.40.0.34.3.1.1000</saml2:AttributeValue></saml2:Attribute><saml2:Attribute FriendlyName=\"Permissions\" Name=\"urn:elga:bes:permission\" NameFormat=\"urn:oasis:names:tc:SAML:2.0:attrname-format:uri\"><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">urn:elga:bes:2013:permission:eBefunde</saml2:AttributeValue><saml2:AttributeValue xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"xs:string\">urn:elga:bes:2013:permission:eMedikation</saml2:AttributeValue></saml2:Attribute></saml2:AttributeStatement></saml2:Assertion>";

	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS?wsdl";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";

	public void setSecurityHeaderElement() {
		if (this.securityHeaderElement == null) {
			AssertionDeserializerImpl assertionDeserializer = new AssertionDeserializerImpl();
			try {
				this.securityHeaderElement = assertionDeserializer.fromXmlString(hcpAssertion);
			} catch (DeserializeException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();

		affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);

		// query HCP assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/ch-ppq/Assertion.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var purposeOfUse = new PurposeOfUseBuilder().code(PurposeOfUse.NORMAL_ACCESS.getCodeValue())
					.codeSystem("2.16.756.5.30.1.127.3.10.6").displayName(PurposeOfUse.NORMAL_ACCESS.getDisplayName())
					.buildObject();
			var role = new RoleBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse).subjectRole(role)
					.resourceId("761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO").create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			securityHeaderElement = response.get(0).getAssertion();
		} catch (Exception e) {
			e.printStackTrace();
		}

		convenienceCommunication.clearDocuments();
	}

	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void submitPdfDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForPdf(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);
		var response = convenienceCommunication.submit(subSet, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	@Test
	public void submitCdaDocTest() throws Exception {
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		var response = convenienceCommunication.submit(subSet, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	@Test
	public void submitDocumentWrongMetadataTest() throws Exception {
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		metdata.setClassCode(new Code("1", "1.2.3.4.5", "display"));
		setSubmissionMetadata(subSet, patientId);

		var response = convenienceCommunication.submit(subSet, null);

		assertEquals(Status.FAILURE, response.getStatus());
		assertTrue(response.getErrors().size() > 0);

		ErrorInfo error = response.getErrors().get(0);
		assertEquals(ErrorCode.REGISTRY_METADATA_ERROR, error.getErrorCode());
		assertEquals("CodeValidation", error.getLocation());
		assertEquals(Severity.ERROR, error.getSeverity());
	}

	@Test
	public void replaceCdaDocTest() throws Exception {
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		var response = convenienceCommunication.submit(subSet, null);

		String entryUuid = convenienceCommunication.getTxnData().getDocuments().get(0).getDocumentEntry()
				.getEntryUuid();

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		convenienceCommunication.clearDocuments();
		metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCdaV2());
		subSet = new SubmissionSetMetadata();
		patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		response = convenienceCommunication.submitReplacement(subSet, entryUuid, securityHeaderElement);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

}
