package org.ehealth_connector.communication.ch.ppq.impl.clients;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.camel.CamelContext;
import org.ehealth_connector.communication.ch.ppq.TestApplication;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.saml2.Assertion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
public class SimplePpfClientAtnaAuditTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimplePpfClientAtnaAuditTest.class.getName());

	@Autowired
	private CamelContext camelContext;
	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";

	@BeforeEach
	public void setup() {
		try {
			InitializationService.initialize();

			File file = new File(clientKeyStore);

			System.setProperty("javax.net.ssl.keyStore", clientKeyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", clientKeyStorePass);
			System.setProperty("javax.net.ssl.trustStore", clientKeyStore);
			System.setProperty("javax.net.ssl.trustStorePassword", clientKeyStorePass);
		} catch (InitializationException e1) {
			e1.printStackTrace();
		}
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

		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110106\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"PPQ-1\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));

	}

	private String checkAuditLogging() throws IOException {
		File originLogFile = new File("log/Spring-TestEHC.log");

		String logContent = new String(Files.readAllBytes(originLogFile.toPath()));

		assertFalse(logContent.contains("Failed to send ATNA audit event to destination"));
		assertTrue(logContent.contains("Auditing"));

		return logContent;
	}

}
