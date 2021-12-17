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
package org.husky.communication.ch.ppq.impl.clients;

import org.husky.communication.CamelService;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.husky.communication.ch.ppq.api.clients.PpfClient;
import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl;
import org.husky.xua.core.SecurityHeaderElement;
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

					boolean secure = config.getUrl().contains("https://");

					final var serverInLogger = "#serverInLogger";
					final var serverOutLogger = "#serverOutLogger";
					final var endpoint = String.format(
							"ch-ppq1://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=#auditContext",
							config.getUrl().replace("https://", "").replace("http://", ""),
							serverInLogger, serverInLogger, serverOutLogger, serverOutLogger,
							secure, getAuditContext().isAuditEnabled());

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
