package org.husky.xua.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.clients.impl.ServerTestHelper;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.husky.xua.communication.xua.RequestType;
import org.husky.xua.communication.xua.TokenType;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.husky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.exceptions.DeserializeException;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.RoleBuilder;
import org.husky.xua.saml2.impl.AttributeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.StatementAbstractType;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;
import org.xml.sax.SAXException;

public class XuaClientTest extends ServerTestHelper {

	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS?wsdl";
	private String clientKeyStore = "src/test/resources/testKeystoreXua.jks";
	private String clientKeyStorePass = "changeit";

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void testGetAssertionForHcp()
			throws ClientSendException, DeserializeException, SAXException, IOException, ParserConfigurationException {

		// query HCP assertion
		XuaClientConfig xuaClientConfig = new XuaClientConfigBuilderImpl().clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).clientKeyStoreType("jks").url(urlToXua).create();

		XuaClient client = ClientFactory.getXuaClient(xuaClientConfig);

		try (InputStream is = new FileInputStream(new File("src/test/resources/Assertion.xml"))) {

			var assertion = new AssertionDeserializerImpl().fromXmlByteArray(IOUtils.toByteArray(is));

			var role = new RoleBuilder().code("HCP").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Behandelnde(r)").buildObject();
			var purposeOfUse = new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.6")
					.displayName("Normal Access").buildObject();
			String resourceId = "761337610411265304^^^SPID&2.16.756.5.30.1.127.3.10.3&ISO";

			var assertionRequest = new XUserAssertionRequestBuilderImpl().requestType(RequestType.WST_ISSUE)
					.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20)
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
								assertEquals(role.getCode(), attribute.getValueAsRole().getCode());
							}

							if (attribute.isValueAPurposeOfUse()) {
								assertEquals(purposeOfUse.getCode(), attribute.getValueAsPurposeOfUse().getCode());
							}

							if (attribute.getName()
									.equalsIgnoreCase("urn:oasis:names:tc:xspa:1.0:subject:subject-id")) {
								assertEquals("Ann Andrews", (((AttributeValueImpl) attribute.getWrappedObject()
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

}
