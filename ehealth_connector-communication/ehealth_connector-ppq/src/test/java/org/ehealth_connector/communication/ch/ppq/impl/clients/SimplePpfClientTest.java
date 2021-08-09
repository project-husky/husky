package org.ehealth_connector.communication.ch.ppq.impl.clients;

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.clients.PpfClient;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.ehealth_connector.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.saml2.impl.AssertionBuilderImpl;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;

public class SimplePpfClientTest {

	public void testSendPpq1() throws ClientSendException {
		PpfClient client = ClientFactoryCh.getPpfClient(new PpClientConfigBuilderImpl().serviceName("").create());

		AssertionType securityHeader = new AssertionBuilderImpl().create();
		PrivacyPolicyFeedBuilderImpl builder = new PrivacyPolicyFeedBuilderImpl().method(PpfMethod.AddPolicy);

		client.send(securityHeader, builder.create());
	}

}
