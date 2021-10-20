package org.ehealth_connector.xua.communication.clients.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.ehealth_connector.xua.authentication.AuthnRequest;
import org.ehealth_connector.xua.communication.clients.XuaClient;
import org.ehealth_connector.xua.communication.config.XuaClientConfig;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigBuilderImpl;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.ehealth_connector.xua.communication.xua.RequestType;
import org.ehealth_connector.xua.communication.xua.TokenType;
import org.ehealth_connector.xua.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.ehealth_connector.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.deserialization.impl.AuthnRequestDeserializerImpl;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.hl7v3.impl.RoleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XuaClientTest extends ServerTestHelper {

	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS?wsdl";
	private String urlToIdp = "https://ehealthsuisse.ihe-europe.net/idp/profile/SAML2/POST/SSO";
	private String clientKeyStore = "src/test/resources/testKeystoreXua.jks";
	private String clientKeyStorePass = "changeit";

	@BeforeEach
	public void setUp() {

	}

	public void testSendClient()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {
		IdpClientBasicAuthConfigImpl idpClientBasicAuthConfig = new IdpClientBasicAuthConfigBuilderImpl()
				.basicAuthUsername("rreynolds").basicAuthPassword("azerty").url(urlToIdp).create();
		
		IdpSoapBindingClientByBasicAuth idpClient = (IdpSoapBindingClientByBasicAuth) ClientFactory.getIdpClient(idpClientBasicAuthConfig);
		
		final Element xmlElement = loadXmlDokument("/saml2/AuthnRequestGazelle.xml");
		AuthnRequest testAuthnRequest = new AuthnRequestDeserializerImpl().fromXmlElement(xmlElement);

		Object obj = idpClient.send(testAuthnRequest);
		
		// query HCP assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
					.appliesTo(new AppliesToBuilderImpl().address("https://localhost:17001/services/iti18").create())
					.resourceId("761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO").create();

			List<XUserAssertionResponse> response = client.send(assertion, assertionRequest);

			 response.get(0).getAssertion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
