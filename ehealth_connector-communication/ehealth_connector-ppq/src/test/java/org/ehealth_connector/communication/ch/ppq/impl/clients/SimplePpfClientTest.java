package org.ehealth_connector.communication.ch.ppq.impl.clients;

import static org.junit.Assert.assertNull;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.ehealth_connector.xua.saml2.Assertion;
import org.ehealth_connector.xua.saml2.impl.AssertionBuilderImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openehealth.ipf.platform.camel.ihe.xacml20.chppq1.ChPpq1Component;

public class SimplePpfClientTest {

	private CamelContext camelContext;
	private String urlToPpq = "ch-ppq1://84.38.125.52/XCA/eHealth";
	private String clientKeyStore;
	private String clientKeyStorePass;

	@Before
	public void setup() {
		this.camelContext = new DefaultCamelContext();
		
		ChPpq1Component component = new ChPpq1Component();

		this.camelContext.addComponent(urlToPpq, component);

		this.camelContext.getEndpoint(urlToPpq);

		this.camelContext.start();
	}

	@Test
	public void testSendPpq1() throws Exception {

		PpClientConfig config = new PpClientConfigBuilderImpl().url(urlToPpq)
				.clientKeyStore(clientKeyStore).clientKeyStorePassword(clientKeyStorePass).create();
		SimplePpfClient client = ClientFactoryCh.getPpfClient(config);

		client.setCamelContext(camelContext);

		Assertion securityHeader = new AssertionBuilderImpl().create();
		PrivacyPolicyFeedBuilderImpl builder = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy);

		PrivacyPolicyFeedResponse response = client.send(securityHeader, builder.create());

		assertNull(response.getExceptions());
	}

	@After
	public void tearDown() {
		if (this.camelContext != null) {
			this.camelContext.stop();
		}
	}

}
