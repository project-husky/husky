package org.ehealth_connector.communication.ch.ppq.impl.clients;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.camel.CamelContext;
import org.ehealth_connector.communication.ch.ppq.TestApplication;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.saml2.Assertion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class SimplePpfClientTest {

	@Autowired
	private CamelContext camelContext;
	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";

	@BeforeEach
	public void setup() {
		try {
			InitializationService.initialize();

			System.setProperty("javax.net.ssl.trustStoreType", "JKS");
			System.setProperty("javax.net.ssl.keyStore", clientKeyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", clientKeyStorePass);
			System.setProperty("javax.net.ssl.trustStore", clientKeyStore);
			System.setProperty("javax.net.ssl.trustStorePassword", clientKeyStorePass);
		} catch (InitializationException e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testSendPpq1AddPolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);

		File fileAssertionOnly = new File("src/test/resources/ch-ppq/add_policy_assertion.xml");

		Assertion assertionRequest = null;
		try (var fis = new FileInputStream(fileAssertionOnly)) {
			var deserializer = new AssertionDeserializerImpl();
			assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
		}

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest
				.getWrappedObject();
		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		assertNull(response.getExceptions());
	}

	@Test
	public void testSendPpq1UpdatePolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);

		Assertion assertionRequest = null;
		try (var fis = new FileInputStream(new File("src/test/resources/ch-ppq/update_policy_assertion.xml"))) {

			var deserializer = new AssertionDeserializerImpl();
			assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
		}

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest
				.getWrappedObject();
		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.UpdatePolicy)
				.create(samlAssertion);

		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		assertNull(response.getExceptions());

	}

	private Element getAssertionAsElement(byte[] xmlByteArray) throws DeserializeException {
		try {
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			final Document doc = dbf.newDocumentBuilder().newDocument();
			// marshaller.marshal(wsAssertion, doc);
			return doc.getDocumentElement();
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Test
	public void testSendPpq1DeletePolicy() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);
		client.setCamelContext(camelContext);

		File fileAssertionOnly = new File("src/test/resources/ch-ppq/delete_policy_assertion.xml");

		Assertion assertionRequest = null;
		try (var fis = new FileInputStream(fileAssertionOnly)) {
			var deserializer = new AssertionDeserializerImpl();
			assertionRequest = deserializer.fromXmlByteArray(fis.readAllBytes());
		}

		org.opensaml.saml.saml2.core.Assertion samlAssertion = (org.opensaml.saml.saml2.core.Assertion) assertionRequest
				.getWrappedObject();

		PrivacyPolicyFeed ppFeedRequest = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.DeletePolicy)
				.create(null);

		PrivacyPolicyFeedResponse response = client.send(null, ppFeedRequest);

		assertNull(response.getExceptions());
	}

}
