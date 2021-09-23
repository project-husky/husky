/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication.ch.ppq.impl.clients;

import org.ehealth_connector.communication.CamelService;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.clients.PpfClient;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.AddPolicyRequest;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.AssertionBasedRequestType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.DeletePolicyRequest;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.EprPolicyRepositoryResponse;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.UpdatePolicyRequest;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the simple ppq client.</div>
 * <div class="de">Klasse die den Simple PPQ Client implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SimplePpfClient extends CamelService
		implements PpfClient {

	private static final String EHS_2015_POLYADMIN = "urn:e-health-suisse:2015:policy-administration:";
	private PpClientConfig config;
	

	//PrivacyPolicyFeedResponse
	public SimplePpfClient(PpClientConfig clientConfiguration) {
		this.config = clientConfiguration;
	}
	
	public PrivacyPolicyFeedResponse send(SecurityHeaderElement aAssertion,
			PrivacyPolicyFeed request) {
		
		try {
			AssertionBasedRequestType requestToSend = null;
			if(request != null) {
				if(PrivacyPolicyFeed.PpfMethod.AddPolicy.equals(request.getMethod())) {
					requestToSend = new AddPolicyRequest();			
				} else if(PrivacyPolicyFeed.PpfMethod.DeletePolicy.equals(request.getMethod())) {
					requestToSend = new DeletePolicyRequest();
				} else if(PrivacyPolicyFeed.PpfMethod.UpdatePolicy.equals(request.getMethod())) {
					requestToSend = new UpdatePolicyRequest();
				}
				
				if (requestToSend != null) {
					requestToSend.setAssertion(request.getAssertion());

					final var serverInLogger = "#serverInLogger";
					final var serverOutLogger = "#serverOutLogger";
					final var endpoint = String.format(
							"ch-ppq1://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s",
							config.getUrl().replace("https://", ""),
							serverInLogger, serverInLogger, serverOutLogger, serverOutLogger,
							true);

					final var exchange = send(endpoint, requestToSend, aAssertion, null);

					if (exchange.getException() != null) {
						return new PrivacyPolicyFeedResponseBuilderImpl().exception(exchange.getException())
								.method(request.getMethod()).create();
					}

					var response = exchange.getMessage().getBody(EprPolicyRepositoryResponse.class);
					return new PrivacyPolicyFeedResponseBuilderImpl().status(response.getStatus())
							.method(request.getMethod()).create();
				}
			}	
		} catch (Exception e) {
			return new PrivacyPolicyFeedResponseBuilderImpl().exception(e).method(request.getMethod()).create();
		}
		
		return null;		
	}

}
