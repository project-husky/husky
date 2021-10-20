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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.DocumentMetadata;
import org.ehealth_connector.common.communication.SubmissionSetMetadata;
import org.ehealth_connector.common.enums.DocumentDescriptor;
import org.ehealth_connector.communication.testhelper.TestApplication;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class ConvenienceCommunicationXdmContentsTest extends XdsTestUtils {

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

	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void createXdmContentsTest() throws Exception {
		// assemble two files for the XDM Zip
		DocumentMetadata metaData = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda(),
				getDocCda());
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metaData, patientId);

		metaData = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		setMetadataForPdf(metaData, patientId);

		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		setSubmissionMetadata(subSet, patientId);

		// create a FileOutputStream to store the zip file
		final File targetFile = new File("src/test/resources/xdmTest_Java.zip");
		try (final FileOutputStream outputStream = new FileOutputStream(targetFile)) {
			// create and store zip.
			convenienceCommunication.createXdmContents(subSet, outputStream);
		}

		checkZipContent(targetFile);
	}

	private void checkZipContent(File targetFile) throws Exception {

		String readmeFile = null;
		String indexHtmFile = null;
		Path iheXdmFolder = null;
		File targetUnzip = new File("src/test/resources/xdmTest_Java");

		try (ZipFile zipFile = new ZipFile(targetFile)) {
			Iterator<? extends ZipEntry> entryIt = zipFile.entries().asIterator();

			while (entryIt.hasNext()) {
				ZipEntry zipEntry = entryIt.next();

				Path resolvedPath = targetUnzip.toPath().resolve(zipEntry.getName()).normalize();
				try (InputStream is = zipFile.getInputStream(zipEntry)) {
					if ("README.TXT".equals(zipEntry.getName())) {
						readmeFile = new String(is.readAllBytes());
					} else if ("INDEX.HTM".equals(zipEntry.getName())) {
						indexHtmFile = new String(is.readAllBytes());
					} else if (zipEntry.getName().contains("IHE_XDM/")) {
						if (zipEntry.isDirectory()) {
							if (zipEntry.getName().equals("IHE_XDM/")) {
								iheXdmFolder = Files.createDirectories(resolvedPath);
							} else {
								Files.createDirectories(resolvedPath);
							}

						} else {
							Files.createDirectories(resolvedPath.getParent());
							Files.copy(is, resolvedPath, StandardCopyOption.REPLACE_EXISTING);
						}
					}
				}
			}

			assertNotNull(readmeFile);
			testReadMeFile(readmeFile);
			assertNotNull(indexHtmFile);
			testIndexHtmFile(indexHtmFile);
			assertNotNull(iheXdmFolder);
		}

		checkSubsetDirContent(String.format("%s/SUBSET01", iheXdmFolder.toString()));
	}

	/**
	 * check if readme contains
	 * 
	 * <ul>
	 * <li>contact information regarding the institution that created the media
	 * (default values)</li>
	 * <li>information regarding the application like name of the product or
	 * software version</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param readmeContent content of README.TXT file
	 * @see <a href="https://profiles.ihe.net/ITI/TF/Volume2/ITI-32.html">ITI-32</a>
	 */
	private void testReadMeFile(String readmeContent) {
		assertTrue(readmeContent.contains("eHealth Connector - http://ehealth-connector.org"));
		assertTrue(readmeContent.contains("Open Source"));
		assertTrue(readmeContent.contains("Convenience API"));
		assertTrue(readmeContent.contains("http://sourceforge.net/p/ehealthconnector/wiki/Team"));
	}

	/**
	 * check if INDEX.HTM contains
	 * 
	 * <ul>
	 * <li>identification of the institution that created the interchange media</li>
	 * <li>a link to an entry point for accessing the web content of the IHE_PDI
	 * directory</li>
	 * <li>a link to the README.TXT file</li>
	 * <li>a manifest which lists the data that can be imported by a Portable Media
	 * Importer</li>
	 * <li>a manifest which lists any patient-related data contained on the CD that
	 * cannot be imported</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param indexHtmContent content of INDEX.HTM file
	 * @see <a href="https://profiles.ihe.net/ITI/TF/Volume2/ITI-32.html">ITI-32</a>
	 */
	private void testIndexHtmFile(String indexHtmContent) {
		assertTrue(indexHtmContent.contains("eHealthConnector XDM Cross-Enterprise Document Media Interchange"));

		// check patient details
		assertTrue(indexHtmContent.contains("Patient ID: IHEBLUE-1043 (1.3.6.1.4.1.21367.13.20.3000)"));

		// check references to other documents in folder
		assertTrue(indexHtmContent.contains("<a target=\"_blank\" href=\"README.TXT\">"));
		assertTrue(indexHtmContent.contains("IHE_XDM/SUBSET01/DOC00002.PDF"));
		assertTrue(indexHtmContent.contains("IHE_XDM/SUBSET01/DOC00001.XML"));
	}

	private void checkSubsetDirContent(String dir) throws Exception {

		String metadataXml = null;
		String doc1 = null;
		String doc2 = null;

		File directory = new File(dir);
		File[] files = directory.listFiles();

		assertNotNull(files);

		for (File file : files) {
			try (InputStream is = new FileInputStream(file)) {
				if ("METADATA.XML".equals(file.getName())) {
					metadataXml = new String(is.readAllBytes());
				} else if (file.getName().contains("DOC00002.PDF")) {
					doc1 = new String(is.readAllBytes());
				} else if (file.getName().contains("DOC00001.XML")) {
					doc2 = new String(is.readAllBytes());
				}
			}
		}

		assertNotNull(metadataXml);
		validateMetadata(metadataXml);
		assertNotNull(doc1);
		assertNotNull(doc2);

	}

	private void validateMetadata(String documentContent)
			throws Exception {

		CloseableHttpClient httpClient = HttpClients.custom().build();
		final var post = new HttpPost("https://gazelle.ihe.net/XDStarClient-ejb/ModelBasedValidationWSService/ModelBasedValidationWS");
		post.setEntity(new ByteArrayEntity(createSOAPRequest(documentContent)));

		CloseableHttpResponse response = httpClient.execute(post);
		String contentResponse = IOUtils.toString(response.getEntity().getContent());
		
		assertFalse(contentResponse.contains("FAILED"));
	}

	private byte[] createSOAPRequest(String documentContent) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("ws", "http://ws.mb.validator.gazelle.ihe.net");

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("validateBase64Document", "ws");
		SOAPElement soapBodyElemBase64Doc = soapBodyElem.addChildElement("base64Document");
		soapBodyElemBase64Doc.addTextNode(Base64.getEncoder().encodeToString(documentContent.getBytes()));

		SOAPElement soapBodyElementValidator = soapBodyElem.addChildElement("validator");
		soapBodyElementValidator.addTextNode("IHE XDM ITI-32 Distribute Document Set on Media");

		soapMessage.saveChanges();

		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

		soapMessage.writeTo(byteOutput);

		return byteOutput.toByteArray();
	}

}
