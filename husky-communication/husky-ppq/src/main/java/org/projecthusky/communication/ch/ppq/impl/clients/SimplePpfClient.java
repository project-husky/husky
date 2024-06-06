/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.ch.ppq.impl.clients;

import org.projecthusky.communication.CamelService;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.projecthusky.communication.ch.ppq.api.clients.PpfClient;
import org.projecthusky.communication.ch.ppq.api.config.PpClientConfig;
import org.projecthusky.communication.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl;
import org.projecthusky.communication.utils.HuskyUtils;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.hl7v3.PIXV3;
import org.openehealth.ipf.commons.ihe.xacml20.CH_PPQ;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.AddPolicyRequest;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.AssertionBasedRequestType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.DeletePolicyRequest;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.EprPolicyRepositoryResponse;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.UpdatePolicyRequest;

/**
 * Class implementing the simple ppq client.
 */
public class SimplePpfClient extends CamelService implements PpfClient {

	private PpClientConfig config;

	// PrivacyPolicyFeedResponse
	public SimplePpfClient(PpClientConfig clientConfiguration) {
		this.config = clientConfiguration;
	}

	public PrivacyPolicyFeedResponse send(SecurityHeaderElement aAssertion,
			PrivacyPolicyFeed request) {

		try {
			AssertionBasedRequestType requestToSend = null;
			if (request != null) {
				if (PrivacyPolicyFeed.PpfMethod.ADD_POLICY.equals(request.getMethod())) {
					requestToSend = new AddPolicyRequest();
				} else if (PrivacyPolicyFeed.PpfMethod.DELETE_POLICY.equals(request.getMethod())) {
					requestToSend = new DeletePolicyRequest();
				} else if (PrivacyPolicyFeed.PpfMethod.UPDATE_POLICY.equals(request.getMethod())) {
					requestToSend = new UpdatePolicyRequest();
				}

				if (requestToSend != null) {
					requestToSend.setAssertion(request.getAssertion());

					boolean secure = config.getUrl().contains("https://");

					final var endpoint = HuskyUtils.createEndpoint(
							CH_PPQ.Interactions.CH_PPQ_1.getWsTransactionConfiguration().getName(), //
							config.getUrl(), //
							secure, //
							getAuditContext().isAuditEnabled());

					final var exchange = send(endpoint, requestToSend, aAssertion, null, null);

					if (exchange.getException() != null) {
						return new PrivacyPolicyFeedResponseBuilderImpl()
								.exception(exchange.getException()).method(request.getMethod())
								.create();
					}

					var response = exchange.getMessage().getBody(EprPolicyRepositoryResponse.class);
					return new PrivacyPolicyFeedResponseBuilderImpl().status(response.getStatus())
							.method(request.getMethod()).create();
				}
			}
		} catch (Exception e) {
			return new PrivacyPolicyFeedResponseBuilderImpl().exception(e)
					.method(request.getMethod()).create();
		}

		return null;
	}

}
