package org.ehealth_connector.communication.ch.ppq.impl.clients;


import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.GregorianCalendar;
import java.util.UUID;

import org.apache.camel.CamelContext;
import org.ehealth_connector.communication.ch.ppq.TestApplication;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.ehealth_connector.xua.hl7v3.InstanceIdentifier;
import org.ehealth_connector.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class SimplePpqClientTest {

	@Autowired
	private CamelContext camelContext;
	private String urlToPpq = "https://ehealthsuisse.ihe-europe.net:10443/ppq-repository";
	private String clientKeyStore;
	private String clientKeyStorePass;

	@BeforeEach
	public void setup() {
		try {
			InitializationService.initialize();
		} catch (InitializationException e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void testSendPpq2() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq)
				.clientKeyStore(clientKeyStore).clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpqClient client = ClientFactoryCh.getPpqClient(config);
		client.setCamelContext(camelContext);

		InstanceIdentifier instanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		instanceIdentifier.setExtension("761337610455909127");
		instanceIdentifier.setRoot("2.16.756.5.30.1.127.3.10.3");
		PrivacyPolicyQuery query = new PrivacyPolicyQueryBuilderImpl().instanceIdentifier(instanceIdentifier)
				.issueInstant(new GregorianCalendar()).version("2.0").id(UUID.randomUUID().toString()).create();
		PrivacyPolicyQueryResponse response = client.send(null, query);

		assertNull(response);
	}

}
