package org.husky.communication.ch.ppq.integration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.apache.camel.CamelContext;
import org.apache.commons.io.IOUtils;
import org.husky.communication.ch.ppq.TestApplication;
import org.husky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.epr.enums.PurposeOfUse;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.husky.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.husky.communication.ch.ppq.impl.clients.SimplePpqClient;
import org.husky.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.husky.xua.communication.xua.RequestType;
import org.husky.xua.communication.xua.TokenType;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.AppliesToBuilderImpl;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.deserialization.impl.AssertionDeserializerImpl;
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.RoleBuilder;
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
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
public class SimplePpqClientAtnaAuditTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimplePpqClientAtnaAuditTest.class.getName());

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private AuditContext auditContext;

	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String urlToXua = "https://ehealthsuisse.ihe-europe.net:10443/STS";
	private String urlToSts = "https://gazelle.ihe.net/gazelle-sts?wsdl";
	private String clientKeyStore = "src/test/resources/testKeystore.jks";
	private String clientKeyStorePass = "changeit";
	private SecurityHeaderElement securityHeader = null;

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

			securityHeader = response.get(0).getAssertion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSendPpq2() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq).clientKeyStore(clientKeyStore)
				.clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
		client.setAuditContext(auditContext);
		client.setCamelContext(camelContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610411265304");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponse response = client.send(securityHeader, query);

		assertNotNull(response);

		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110112\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"PPQ-2\""));
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
