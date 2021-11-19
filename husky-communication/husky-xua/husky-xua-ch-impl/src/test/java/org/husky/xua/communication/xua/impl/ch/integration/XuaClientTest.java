package org.husky.xua.communication.xua.impl.ch.integration;

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
import org.husky.communication.ch.enums.Role;
import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.clients.impl.IdpSoapBindingClientByBasicAuth;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.husky.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.husky.xua.communication.xua.RequestType;
import org.husky.xua.communication.xua.TokenType;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.husky.xua.communication.xua.impl.ch.XUserAssertionRequestBuilderChImpl;
import org.husky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.exceptions.DeserializeException;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.RoleBuilder;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.impl.AttributeImpl;
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
	public void testGetAssertionWithForAssistant() throws ClientSendException, DeserializeException, SAXException,
			IOException, ParserConfigurationException, SerializeException {

		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		var idpAssertion = requestIdpAssertion("ltieche", "azerty");

		var role = new RoleBuilder().code(Role.ASSISTANT_CODE).codeSystem("2.16.756.5.30.1.127.3.10.6")
				.displayName("Behandelnde(r)").buildObject();
		var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
				.displayName("Normal Access").buildObject();
		var principalId = "7601002467373";
		var principalName = "Richard Reynolds";
		String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

		var xuaAssertionRequest = new XUserAssertionRequestBuilderChImpl().principal(principalId, principalName)
				.requestType(RequestType.WST_ISSUE).tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
				.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
				.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

		List<XUserAssertionResponse> response = client.send(idpAssertion, xuaAssertionRequest);

		assertNotNull(response);
		assertNotNull(response.get(0).getAssertion());

		assertEquals("https://ehealthsuisse.ihe-europe.net/STS", response.get(0).getAssertion().getIssuer().getValue());

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

						if (attribute.getName().equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
							assertEquals("Richard Reynolds",
									(((AttributeValueImpl) attribute.getWrappedObject().getAttributeValues().get(0)))
											.getTextContent());
						}

						if (attribute.getName().equalsIgnoreCase("urn:oasis:names:tc:xacml:2.0:resource:resource-id")) {
							assertEquals(resourceId,
									(((AttributeValueImpl) attribute.getWrappedObject().getAttributeValues().get(0)))
											.getTextContent());
						}

						if (attribute.getName().equalsIgnoreCase("urn:e-health-suisse:principal-id")) {
							assertEquals(principalId,
									(((AttributeValueImpl) attribute.getWrappedObject().getAttributeValues().get(0)))
											.getTextContent());
						}

						if (attribute.getName().equalsIgnoreCase("urn:e-health-suisse:principal-name")) {
							assertEquals("Richard Reynolds",
									(((AttributeValueImpl) attribute.getWrappedObject().getAttributeValues().get(0)))
											.getTextContent());
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

			var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("TCU").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("AUTO").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			var principalId = "7601000050717";
			var principalName = "Marc Loris Agpar";
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var xuaAssertionRequest = new XUserAssertionRequestBuilderChImpl().principal(principalId, principalName)
					.requestType(RequestType.WST_ISSUE).tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.purposeOfUse(purposeOfUse).subjectRole(role).resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(idpAssertion, xuaAssertionRequest);

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

			var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("PADM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var xuaAssertionRequest = new XUserAssertionRequestBuilderChImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).purposeOfUse(purposeOfUse).subjectRole(role)
					.resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(idpAssertion, xuaAssertionRequest);

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

			var idpAssertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("DADM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var xuaAssertionRequest = new XUserAssertionRequestBuilderChImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).purposeOfUse(purposeOfUse).subjectRole(role)
					.resourceId(resourceId).create();

			List<XUserAssertionResponse> response = client.send(idpAssertion, xuaAssertionRequest);

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
		var response = client.send(authnRequest);

		return response.getAssertions().get(0);

	}

}
