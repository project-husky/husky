/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Person;
import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.Destination;
import org.ehealth_connector.communication.testhelper.PurposeOfUse;
import org.ehealth_connector.communication.testhelper.TestApplication;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.ehealth_connector.communication.xd.storedquery.FindDocumentsQuery;
import org.ehealth_connector.xua.communication.clients.XuaClient;
import org.ehealth_connector.xua.communication.clients.impl.ClientFactory;
import org.ehealth_connector.xua.communication.config.XuaClientConfig;
import org.ehealth_connector.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.ehealth_connector.xua.communication.xua.RequestType;
import org.ehealth_connector.xua.communication.xua.TokenType;
import org.ehealth_connector.xua.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.ehealth_connector.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.ehealth_connector.xua.hl7v3.impl.RoleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
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
public class ConvenienceCommunicationQueryDocumentsTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvenienceCommunication.class.getName());

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

		var context = app.run();

		affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"https://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/xcq"));
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
	}

	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void ITI18QueryMetadataEmptyTest() throws Exception {

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2737");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);
		
		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery,
				null, false);

		assertTrue(response.getErrors().isEmpty());
		assertTrue(response.getDocuments().isEmpty());
		assertTrue(response.getDocumentEntries().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	@Test
	public void ITI18QueryMetadataTest() throws Exception {

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);

		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null, false);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(!response.getDocumentEntries().isEmpty());
		assertEquals(1, response.getDocumentEntries().size());

		DocumentEntry documentEntry = response.getDocumentEntries().get(0);

		// check if identifiers (unique ID, repository ID and home community ID are
		// equal)
		assertEquals("1.2.820.99999.15031207481211484821638086641062503555190193702785", documentEntry.getUniqueId());
		assertEquals("1.1.4567332.1.75", documentEntry.getRepositoryUniqueId());
		assertEquals("urn:oid:1.1.4567334.1.6", documentEntry.getHomeCommunityId());
		assertEquals("urn:uuid:b8f37101-8842-4e2c-b1e7-bc421d0dc01f", documentEntry.getEntryUuid());

		assertEquals(AvailabilityStatus.APPROVED, documentEntry.getAvailabilityStatus());
		assertEquals("application/pdf", documentEntry.getMimeType());

		assertNull(documentEntry.getComments());
		assertNull(documentEntry.getDocumentAvailability());

		assertEquals("Informed Consent", documentEntry.getTitle().getValue());
		assertEquals("20211012082534", documentEntry.getCreationTime().toHL7());

		// check different codes
		assertEquals("de-CH", documentEntry.getLanguageCode());

		assertNotNull(documentEntry.getClassCode());
		assertEquals("422735006", documentEntry.getClassCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getClassCode().getSchemeName());
		assertEquals("Summary clinical document (record artifact)",
				documentEntry.getClassCode().getDisplayName().getValue());

		assertNotNull(documentEntry.getConfidentialityCodes().get(0));
		assertEquals("17621005", documentEntry.getConfidentialityCodes().get(0).getCode());
		assertEquals("Normal (qualifier value)",
				documentEntry.getConfidentialityCodes().get(0).getDisplayName().getValue());

		assertTrue(documentEntry.getEventCodeList().isEmpty());

		assertEquals("urn:ihe:iti:xds-sd:pdf:2008", documentEntry.getFormatCode().getCode());
		assertEquals("1.3.6.1.4.1.19376.1.2.3", documentEntry.getFormatCode().getSchemeName());
		assertEquals("1.3.6.1.4.1.19376.1.2.20 (Scanned Document)",
				documentEntry.getFormatCode().getDisplayName().getValue());

		assertEquals("394747008", documentEntry.getHealthcareFacilityTypeCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getHealthcareFacilityTypeCode().getSchemeName());
		assertEquals("Health Authority",
				documentEntry.getHealthcareFacilityTypeCode().getDisplayName().getValue());

		assertEquals("394810000", documentEntry.getPracticeSettingCode().getCode());
		assertEquals("Rheumatology (qualifier value)",
				documentEntry.getPracticeSettingCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getPracticeSettingCode().getSchemeName());

		assertEquals("371535009", documentEntry.getTypeCode().getCode());
		assertEquals("Transfer summary report (record artifact)",
				documentEntry.getTypeCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getTypeCode().getSchemeName());

		// check patient details
		assertEquals("IHERED-1024", documentEntry.getPatientId().getId());
		assertEquals("1.3.6.1.4.1.21367.13.20.1000",
				documentEntry.getPatientId().getAssigningAuthority().getUniversalId());

		assertEquals("2342134localid", documentEntry.getSourcePatientId().getId());
		assertEquals("1.2.3.4", documentEntry.getSourcePatientId().getAssigningAuthority().getUniversalId());

		// check author details
		assertFalse(documentEntry.getAuthors().isEmpty());
		assertNotNull(documentEntry.getAuthors().get(0));
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorPerson());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorPerson().getName());
		assertEquals("Bereit", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getFamilyName());
		assertEquals("Allzeit", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getGivenName());
		assertEquals("Dr.", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getPrefix());

		assertNotNull(documentEntry.getAuthors().get(0).getAuthorRole());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorRole().get(0));
		assertEquals("221", documentEntry.getAuthors().get(0).getAuthorRole().get(0).getId());
		assertEquals("2.16.840.1.113883.2.9.6.2.7",
				documentEntry.getAuthors().get(0).getAuthorRole().get(0).getAssigningAuthority().getUniversalId());

		assertNotNull(documentEntry.getAuthors().get(0).getAuthorSpecialty());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0));
		assertNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getId());
		assertNull(
				documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getAssigningAuthority().getUniversalId());
	}

	@Test
	public void ITI18QueryMetadataCdaTest() throws Exception {

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2599");

		List<Code> classCodes = List
				.of(
						new Code("417319006", "2.16.840.1.113883.6.96", "Record of health event (record artifact)"));
		List<Code> practiceSettingCodes = List
				.of(new Code("394802001", "2.16.840.1.113883.6.96", "General medicine (qualifier value)"));
		List<Code> healthcareFacilityCodes = List
				.of(new Code("394747008", "2.16.840.1.113883.6.96", "Health Authority"));
		List<Code> confidentialityCodes = List
				.of(new Code("17621005", "2.16.840.1.113883.6.96", "Normal (qualifier value)"));
		List<Code> formatCodes = List
				.of(new Code("urn:ihe:pcc:ic:2009", "1.3.6.1.4.1.19376.1.2.3", "Immunization Content (IC)"));

		Person person = new Person();
		var name = new Name();
		name.setFamily("Bereit");
		name.setGiven("Allzeit");
		name.setPrefix("Dr.");
		person.addName(name);

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, classCodes, null,
				practiceSettingCodes, healthcareFacilityCodes, confidentialityCodes, formatCodes, person,
				AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);

		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null, false);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(!response.getDocumentEntries().isEmpty());
		assertEquals(1, response.getDocumentEntries().size());

		DocumentEntry documentEntry = response.getDocumentEntries().get(0);

		// check if identifiers (unique ID, repository ID and home community ID are
		// equal)
		assertEquals("1.2.820.99999.18508463736145106181926975526539403561455330316563", documentEntry.getUniqueId());
		assertEquals("1.1.4567332.1.75", documentEntry.getRepositoryUniqueId());
		assertEquals("urn:oid:1.1.4567334.1.6", documentEntry.getHomeCommunityId());
		assertEquals("urn:uuid:afd9bee4-4c30-4b58-a0e7-e301c799047b", documentEntry.getEntryUuid());

		assertEquals(AvailabilityStatus.APPROVED, documentEntry.getAvailabilityStatus());
		assertEquals("text/xml", documentEntry.getMimeType());

		assertNull(documentEntry.getComments());
		assertNull(documentEntry.getDocumentAvailability());

		assertNull(documentEntry.getTitle());
		assertEquals("20211012111457", documentEntry.getCreationTime().toHL7());

		// check different codes
		assertEquals("fr-CH", documentEntry.getLanguageCode());

		assertNotNull(documentEntry.getClassCode());
		assertEquals("417319006", documentEntry.getClassCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getClassCode().getSchemeName());
		assertEquals("Record of health event (record artifact)",
				documentEntry.getClassCode().getDisplayName().getValue());

		assertNotNull(documentEntry.getConfidentialityCodes().get(0));
		assertEquals("17621005", documentEntry.getConfidentialityCodes().get(0).getCode());
		assertEquals("Normal (qualifier value)",
				documentEntry.getConfidentialityCodes().get(0).getDisplayName().getValue());

		assertTrue(documentEntry.getEventCodeList().isEmpty());

		assertEquals("urn:ihe:pcc:ic:2009", documentEntry.getFormatCode().getCode());
		assertEquals("1.3.6.1.4.1.19376.1.2.3", documentEntry.getFormatCode().getSchemeName());
		assertEquals("Immunization Content (IC)",
				documentEntry.getFormatCode().getDisplayName().getValue());

		assertEquals("394747008", documentEntry.getHealthcareFacilityTypeCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getHealthcareFacilityTypeCode().getSchemeName());
		assertEquals("Health Authority", documentEntry.getHealthcareFacilityTypeCode().getDisplayName().getValue());

		assertEquals("394802001", documentEntry.getPracticeSettingCode().getCode());
		assertEquals("General medicine (qualifier value)",
				documentEntry.getPracticeSettingCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getPracticeSettingCode().getSchemeName());

		assertEquals("41000179103", documentEntry.getTypeCode().getCode());
		assertEquals("Immunization record",
				documentEntry.getTypeCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getTypeCode().getSchemeName());

		// check patient details
		assertEquals("IHEBLUE-2599", documentEntry.getPatientId().getId());
		assertEquals("1.3.6.1.4.1.21367.13.20.3000",
				documentEntry.getPatientId().getAssigningAuthority().getUniversalId());

		assertEquals("23423452342134localid", documentEntry.getSourcePatientId().getId());
		assertEquals("1.2.3.4", documentEntry.getSourcePatientId().getAssigningAuthority().getUniversalId());

		// check author details
		assertFalse(documentEntry.getAuthors().isEmpty());
		assertNotNull(documentEntry.getAuthors().get(0));
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorPerson());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorPerson().getName());
		assertEquals("Bereit", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getFamilyName());
		assertEquals("Allzeit", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getGivenName());
		assertEquals("Dr.", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getPrefix());

		assertNotNull(documentEntry.getAuthors().get(0).getAuthorRole());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorRole().get(0));
		assertEquals("221", documentEntry.getAuthors().get(0).getAuthorRole().get(0).getId());
		assertEquals("2.16.840.1.113883.2.9.6.2.7",
				documentEntry.getAuthors().get(0).getAuthorRole().get(0).getAssigningAuthority().getUniversalId());

		assertNotNull(documentEntry.getAuthors().get(0).getAuthorSpecialty());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0));
		assertNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getId());
		assertNull(
				documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getAssigningAuthority().getUniversalId());
	}

}
