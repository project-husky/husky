package org.projecthusky.communication.ch.ppq.integration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.apache.camel.CamelContext;
import org.projecthusky.communication.ch.ppq.TestApplication;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.projecthusky.communication.ch.ppq.api.config.PpClientConfig;
import org.projecthusky.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.projecthusky.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.projecthusky.communication.ch.ppq.impl.clients.SimplePpqClient;
import org.projecthusky.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.projecthusky.xua.hl7v3.InstanceIdentifier;
import org.projecthusky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xacml20.Xacml20Utils;
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
 * This test class is to check whether ATNA audit messages are sent in the
 * course of CH-PPQ-2 transactions. This is tested by checking whether audit
 * entries have been written to the LOG file.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
class SimplePpqClientAtnaAuditTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimplePpqClientAtnaAuditTest.class.getName());

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private AuditContext auditContext;

	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";

	/**
	 * This method initializes IPF and OpenSAML XACML modules and sets key- and
	 * truststore.
	 */
	@BeforeEach
	public void setup() {
		try {
			InitializationService.initialize();
			Xacml20Utils.initializeHerasaf();

			System.setProperty("javax.net.ssl.keyStore", clientKeyStore);
			System.setProperty("javax.net.ssl.keyStorePassword", clientKeyStorePass);
			System.setProperty("javax.net.ssl.trustStore", clientKeyStore);
			System.setProperty("javax.net.ssl.trustStorePassword", clientKeyStorePass);
		} catch (InitializationException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * This tests whether an audit event with type PPQ-2 and ID 110112 is sent when
	 * querying a policy set.
	 * 
	 * @throws Exception
	 */
	@Test
	void testSendPpq2() throws Exception {

		// initialize client to query policies
		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
		client.setAuditContext(auditContext);
		client.setCamelContext(camelContext);

		// set identifier for whom the policies are to be queried
		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610411265304");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponse response = client.send(null, query);

		assertNotNull(response);

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110112\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"PPQ-2\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	/**
	 * This method extracts content of LOG file and checks if auditing is basically
	 * enabled.
	 * 
	 * @return
	 * @throws IOException
	 */
	private String checkAuditLogging() throws IOException {
		File originLogFile = new File("log/Spring-TestEHC.log");

		// extract content of log file
		String logContent = new String(Files.readAllBytes(originLogFile.toPath()));

		// check if ATNA audit events could be sent
		assertFalse(logContent.contains("Failed to send ATNA audit event to destination"));

		// check if ATNA auditing is basically enabled
		assertTrue(logContent.contains("Auditing"));

		return logContent;
	}

}
