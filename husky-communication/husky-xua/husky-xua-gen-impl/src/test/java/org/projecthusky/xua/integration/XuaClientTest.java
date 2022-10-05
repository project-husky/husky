package org.projecthusky.xua.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.projecthusky.xua.communication.clients.XuaClient;
import org.projecthusky.xua.communication.clients.impl.ClientFactory;
import org.projecthusky.xua.communication.clients.impl.ServerTestHelper;
import org.projecthusky.xua.communication.config.XuaClientConfig;
import org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.projecthusky.xua.communication.xua.RequestType;
import org.projecthusky.xua.communication.xua.TokenType;
import org.projecthusky.xua.communication.xua.XUserAssertionResponse;
import org.projecthusky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.projecthusky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.exceptions.SoapException;
import org.projecthusky.xua.hl7v3.PurposeOfUse;
import org.projecthusky.xua.hl7v3.Role;
import org.projecthusky.xua.hl7v3.impl.CodedWithEquivalentsBuilder;
import org.projecthusky.xua.saml2.impl.AttributeImpl;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.StatementAbstractType;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;
import org.xml.sax.SAXException;

/**
 * The purpose of this test class is to check if the assertion query works for a
 * user.
 */
class XuaClientTest extends ServerTestHelper {

	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS?wsdl";
	private String clientKeyStore = "src/test/resources/testKeystoreXua.jks";
	private String clientKeyStorePass = "changeit";

	/**
	 * This test checks the behavior of the
	 * {@link XuaClient#send(SecurityHeaderElement, org.projecthusky.xua.communication.xua.XUserAssertionRequest)
	 * when querying a XUA assertion for a registered healthcare professional
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetAssertionForHcp()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		// initialize XUA client to query XUA assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion.xml"))) {

			var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			// set role of subject
			var role = new CodedWithEquivalentsBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)")
					.buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);

			// set the purpose of use
			var purposeOfUse = new CodedWithEquivalentsBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject(PurposeOfUse.DEFAULT_NS_URI,
							PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);

			// set ID of patient with namespace EPR_SPID
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

			// query XUA assertion
			List<XUserAssertionResponse> response = client.send(idpAssertion, assertionRequest);

			// check if assertion is returned
			assertNotNull(response);
			assertNotNull(response.get(0).getAssertion());

			// check if correct issuer is included in assertion
			assertEquals("https://ehealthsuisse.ihe-europe.net/STS",
					response.get(0).getAssertion().getIssuer().getValue());

			String actualRole = null;
			String actualPurposeOfUse = null;
			String actualSubjectId = null;
			String actualResourceId = null;

			for (StatementAbstractType statement : response.get(0).getAssertion()
					.getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
				if (statement instanceof AttributeStatementType) {
					AttributeStatementType attributeStatment = (AttributeStatementType) statement;

					for (Object obj : attributeStatment.getAttributeOrEncryptedAttribute()) {
						if (obj instanceof AttributeType) {
							AttributeImpl attribute = (AttributeImpl) obj;

							if (attribute.isValueARole()) {
								actualRole = attribute.getValueAsRole().getCode();
							}

							if (attribute.isValueAPurposeOfUse()) {
								actualPurposeOfUse = attribute.getValueAsPurposeOfUse().getCode();
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
								actualSubjectId = ((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0)).getTextContent();
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
								actualResourceId = (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent();
							}

						}
					}
				}
			}

			// check attribute parameter of returned assertion
			assertEquals(role.getCode(), actualRole);
			assertEquals(purposeOfUse.getCode(), actualPurposeOfUse);
			assertEquals("Ann Andrews", actualSubjectId);
			assertEquals(resourceId, actualResourceId);
		}
	}

	/**
	 * This test checks the behavior of the
	 * {@link XuaClient#send(SecurityHeaderElement, org.projecthusky.xua.communication.xua.XUserAssertionRequest)
	 * when querying a XUA assertion for registered user with a wrong role.
	 * 
	 * @throws Exception
	 */
	@Test
	void testWrongAssertionDetailsForHcp()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		// initialize XUA client to query XUA assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion.xml"))) {

			var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new CodedWithEquivalentsBuilder().code("AKT").codeSystem("1.2.3.4.5")
					.displayName("Behandelnde(r)")
					.buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);
			var purposeOfUse = new CodedWithEquivalentsBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject(PurposeOfUse.DEFAULT_NS_URI,
							PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

			// query XUA assertion and expecting SoapException due to wrong role code
			assertThrows(SoapException.class, () -> client.send(idpAssertion, assertionRequest));
		}
	}

	/**
	 * This test checks the behavior of the
	 * {@link XuaClient#send(SecurityHeaderElement, org.projecthusky.xua.communication.xua.XUserAssertionRequest)
	 * when querying a XUA assertion for registered user with a wrong role, a wrong
	 * patient ID and a wrong purpose of use.
	 * 
	 * @throws Exception
	 */
	@Test
	void testInvalidXmlAssertionForHcp()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		// initialize XUA client to query XUA assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion.xml"))) {

			var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new CodedWithEquivalentsBuilder().code("AKT").codeSystem("1.2.3.4.5")
					.displayName("Behandelnde(r)")
					.buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);
			var purposeOfUse = new CodedWithEquivalentsBuilder().code("1234").codeSystem("1.2.3.4.5.6.7")
					.displayName("Normal Access").buildObject(PurposeOfUse.DEFAULT_NS_URI,
							PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
			String resourceId = "1234^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();
			
			// query XUA assertion and expecting ClientSendException due to invalid
			// assertion
			assertThrows(ClientSendException.class, () -> client.send(idpAssertion, assertionRequest));
		}
	}

}
