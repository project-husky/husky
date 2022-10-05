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
package org.projecthusky.communication.ch.ppq.impl;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryResponseBuilder;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ResponseType;
import org.opensaml.saml.saml2.core.Response;

/**
 * Class implementing the interfaces PrivacyPolicyQueryResponseBuilder and SecurityObjectBuilder.
 */
public class PrivacyPolicyQueryResponseBuilderImpl implements PrivacyPolicyQueryResponseBuilder,
		SecurityObjectBuilder<Response, PrivacyPolicyQueryResponse> {

	@Override
	public PrivacyPolicyQueryResponse create(Response request) {
		return new PrivacyPolicyQueryResponseImpl(request);
	}

	public PrivacyPolicyQueryResponse create(ResponseType request) {
		return new PrivacyPolicyQueryResponseImpl(request);
	}

}
