package org.ehealth_connector.xua.communication.xua.impl.ch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.ehealth_connector.xua.XUserAssertionConstantsCh;
import org.ehealth_connector.xua.authentication.AuthnRequest;
import org.ehealth_connector.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.ehealth_connector.xua.communication.clients.XuaClient;
import org.ehealth_connector.xua.communication.clients.impl.ClientFactory;
import org.ehealth_connector.xua.communication.clients.impl.IdpSoapBindingClientByBasicAuth;
import org.ehealth_connector.xua.communication.clients.impl.ServerTestHelper;
import org.ehealth_connector.xua.communication.config.XuaClientConfig;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.ehealth_connector.xua.communication.xua.RequestType;
import org.ehealth_connector.xua.communication.xua.TokenType;
import org.ehealth_connector.xua.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.ehealth_connector.xua.hl7v3.impl.RoleBuilder;
import org.ehealth_connector.xua.saml2.Assertion;
import org.ehealth_connector.xua.saml2.Response;
import org.ehealth_connector.xua.saml2.impl.AttributeImpl;
import org.ehealth_connector.xua.serialization.impl.AssertionSerializerImpl;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.StatementAbstractType;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;
import org.xml.sax.SAXException;

public class XuaClientTest extends ServerTestHelper {

	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS?wsdl";
	private String urlToIdp = "https://ehealthsuisse.ihe-europe.net/idp/profile/SAML2/SOAP/ECP";
	private String clientKeyStore = "src/test/resources/testKeystoreXua.jks";
	private String clientKeyStorePass = "changeit";

	@Test
	public void testGetAssertionWithForAssistant()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException,
			SerializeException {
		
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion_Assistant.xml"))) {

			var assertionString = new AssertionSerializerImpl().toXmlString(requestIdpAssertion("ltieche", "azerty"));

			var assertion = new AssertionDeserializerImpl().fromXmlString(assertionString);

			var role = new RoleBuilder().code(XUserAssertionConstantsCh.ROLE_ASSITANT)
					.codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access")
					.buildObject();
			var principalId = "7601002467373";
			var principalName = "Richard Reynolds";
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderChImpl().principal(principalId, principalName)
					.requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18")
							.create())
					.purposeOfUse(purposeOfUse).subjectRole(role)
					.resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			assertNotNull(response);			
			assertNotNull(response.get(0).getAssertion());
			
			assertEquals("https://ehealthsuisse.ihe-europe.net/STS", response.get(0).getAssertion().getIssuer().getValue());
			
			
			for(StatementAbstractType statement: response.get(0).getAssertion().getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
				if(statement instanceof AttributeStatementType) {
					AttributeStatementType attributeStatment = (AttributeStatementType) statement;
					
					for(Object obj: attributeStatment.getAttributeOrEncryptedAttribute()) {
						if(obj instanceof AttributeType) {
							AttributeImpl attribute = (AttributeImpl) obj;

							if (attribute.isValueARole()) {
								assertEquals("HCP", attribute.getValueAsRole().getCode());
							}

							if (attribute.isValueAPurposeOfUse()) {
								assertEquals(purposeOfUse.getCode(), attribute.getValueAsPurposeOfUse().getCode());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
								assertEquals("Richard Reynolds",
										(((AttributeValueImpl) attribute.getWrappedObject().getAttributeValues()
												.get(0))).getTextContent());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
								assertEquals(resourceId, (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName().equalsIgnoreCase("urn:e-health-suisse:principal-id")) {
								assertEquals(principalId, (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName().equalsIgnoreCase("urn:e-health-suisse:principal-name")) {
								assertEquals("Richard Reynolds", (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

						}
					}
				}
			}
		}
			
	}

	@Test
	public void testGetAssertionWithForTechnicalUser()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion_Technical_User.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("TCU")
					.codeSystem("2.16.756.5.30.1.127.3.10.6").displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("AUTO").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			var principalId = "7601000050717";
			var principalName = "Marc Loris Agpar";
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderChImpl().principal(principalId, principalName)
					.requestType(RequestType.WST_ISSUE).tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			assertNotNull(response);
			assertNotNull(response.get(0).getAssertion());

			assertEquals("https://ehealthsuisse.ihe-europe.net/STS",
					response.get(0).getAssertion().getIssuer().getValue());

			for (StatementAbstractType statement : response.get(0).getAssertion()
					.getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
				if (statement instanceof AttributeStatementType) {
					AttributeStatementType attributeStatment = (AttributeStatementType) statement;

					for (Object obj : attributeStatment.getAttributeOrEncryptedAttribute()) {
						if (obj instanceof AttributeType) {
							AttributeImpl attribute = (AttributeImpl) obj;

							if (attribute.isValueARole()) {
								assertEquals("HCP", attribute.getValueAsRole().getCode());
							}

							if (attribute.isValueAPurposeOfUse()) {
								assertEquals(purposeOfUse.getCode(), attribute.getValueAsPurposeOfUse().getCode());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
								assertEquals("Marc Loris Agpar", (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
								assertEquals(resourceId, (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName().equalsIgnoreCase("urn:e-health-suisse:principal-id")) {
								assertEquals(principalId, (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName().equalsIgnoreCase("urn:e-health-suisse:principal-name")) {
								assertEquals("Marc Loris Agpar", (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

						}
					}
				}
			}
		}

	}

	@Test
	public void testGetAssertionWithForPolicyAdministration()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion_Policy_Administration.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("PADM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderChImpl()
					.requestType(RequestType.WST_ISSUE).tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			assertNotNull(response);
			assertNotNull(response.get(0).getAssertion());

			assertEquals("https://ehealthsuisse.ihe-europe.net/STS",
					response.get(0).getAssertion().getIssuer().getValue());

			for (StatementAbstractType statement : response.get(0).getAssertion()
					.getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
				if (statement instanceof AttributeStatementType) {
					AttributeStatementType attributeStatment = (AttributeStatementType) statement;

					for (Object obj : attributeStatment.getAttributeOrEncryptedAttribute()) {
						if (obj instanceof AttributeType) {
							AttributeImpl attribute = (AttributeImpl) obj;

							if (attribute.isValueARole()) {
								assertEquals(role.getCode(), attribute.getValueAsRole().getCode());
							}

							if (attribute.isValueAPurposeOfUse()) {
								assertEquals(purposeOfUse.getCode(), attribute.getValueAsPurposeOfUse().getCode());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
								assertEquals("Ivo Castineira", (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
								assertEquals(resourceId, (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

						}
					}
				}
			}
		}

	}

	@Test
	public void testGetAssertionWithForDocumentAdministration()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(
				new File("src/test/resources/Assertion_Document_Administration.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("DADM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderChImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).purposeOfUse(purposeOfUse).subjectRole(role)
					.resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			assertNotNull(response);
			assertNotNull(response.get(0).getAssertion());

			assertEquals("https://ehealthsuisse.ihe-europe.net/STS",
					response.get(0).getAssertion().getIssuer().getValue());

			for (StatementAbstractType statement : response.get(0).getAssertion()
					.getStatementOrAuthnStatementOrAuthzDecisionStatement()) {
				if (statement instanceof AttributeStatementType) {
					AttributeStatementType attributeStatment = (AttributeStatementType) statement;

					for (Object obj : attributeStatment.getAttributeOrEncryptedAttribute()) {
						if (obj instanceof AttributeType) {
							AttributeImpl attribute = (AttributeImpl) obj;

							if (attribute.isValueARole()) {
								assertEquals(role.getCode(), attribute.getValueAsRole().getCode());
							}

							if (attribute.isValueAPurposeOfUse()) {
								assertEquals(purposeOfUse.getCode(), attribute.getValueAsPurposeOfUse().getCode());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
								assertEquals("Käthi Weisskopf", (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
								assertEquals(resourceId, (((AttributeValueImpl) attribute.getWrappedObject()
										.getAttributeValues().get(0))).getTextContent());
							}

						}
					}
				}
			}
		}
	}

	private Assertion requestIdpAssertion(String user, String password) throws ClientSendException {
		IdpClientBasicAuthConfigImpl idpClientConfig = new IdpClientBasicAuthConfigBuilderImpl()
				.basicAuthPassword(password).basicAuthUsername(user).url(urlToIdp).create();

		IdpSoapBindingClientByBasicAuth client = (IdpSoapBindingClientByBasicAuth) ClientFactory
				.getIdpClient(idpClientConfig);

		AuthnRequest authnRequest = new AuthnRequestBuilderImpl()
				.assertionConsumerServiceUrl("https://sp-clone.ihe-europe.net/Shibboleth.sso/SAML2/ECP")
				.issueInstant(new GregorianCalendar()).id(String.valueOf(System.currentTimeMillis()))
				.protocolBinding("urn:oasis:names:tc:SAML:2.0:bindings:PAOS").version("2.0")
				.issuer("https://sp-clone.ihe-europe.net/shibboleth").nameIdPolicyAllowCreate(true)
				.providerId("https://idp.ihe-europe.net/idp/shibboleth").create();
		Response response = client.send(authnRequest);


		return response.getAssertions().get(0);

	}
}
