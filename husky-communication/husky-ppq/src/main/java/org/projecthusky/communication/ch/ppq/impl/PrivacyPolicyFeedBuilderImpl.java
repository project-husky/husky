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

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeedBuilder;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.impl.AssertionBuilder;

/**
 * Class implementing the interfaces PrivacyPolicyFeedBuilder and SecurityObjectBuilder.
 */
public class PrivacyPolicyFeedBuilderImpl
		implements PrivacyPolicyFeedBuilder, SecurityObjectBuilder<Assertion, PrivacyPolicyFeed> {

	private PpfMethod ppfMethod;

	@Override
	public PrivacyPolicyFeed create() {
		return new PrivacyPolicyFeedImpl(ppfMethod, new AssertionBuilder().buildObject());
	}

	@Override
	public PrivacyPolicyFeed create(org.opensaml.saml.saml2.core.Assertion aInternalObject) {
		return new PrivacyPolicyFeedImpl(ppfMethod, aInternalObject);
	}

	@Override
	public PrivacyPolicyFeedBuilderImpl method(PpfMethod aMethod) {
		ppfMethod = aMethod;
		return this;
	}

}
