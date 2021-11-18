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
package org.husky.communication.ch.ppq.impl;

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponseBuilder;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interfaces PrivacyPolicyFeedResponseBuilder.</div>
 * <div class="de">Klasse welche das Interface PrivacyPolicyFeedResponseBuilder implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedResponseBuilderImpl implements PrivacyPolicyFeedResponseBuilder {

	private PrivacyPolicyFeedResponseImpl response;

	public PrivacyPolicyFeedResponseBuilderImpl() {
		response = new PrivacyPolicyFeedResponseImpl();
	}

	@Override
	public PrivacyPolicyFeedResponse create() {
		return response;
	}

	@Override
	public PrivacyPolicyFeedResponseBuilder exception(Exception aException) {
		response.addException(aException);
		return this;
	}

	@Override
	public PrivacyPolicyFeedResponseBuilder method(PpfMethod aMethod) {
		response.setMethod(aMethod);
		return this;
	}

	@Override
	public PrivacyPolicyFeedResponseBuilder status(String aStatus) {
		response.setStatus(aStatus);
		return this;
	}

}
