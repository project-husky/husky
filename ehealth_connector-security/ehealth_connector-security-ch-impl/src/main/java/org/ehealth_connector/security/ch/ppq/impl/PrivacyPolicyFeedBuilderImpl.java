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
package org.ehealth_connector.security.ch.ppq.impl;

import org.ehealth_connector.security.ch.ppq.PrivacyPolicyFeed;
import org.ehealth_connector.security.ch.ppq.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.security.ch.ppq.PrivacyPolicyFeedBuilder;
import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.impl.AssertionBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interfaces PrivacyPolicyFeedBuilder and SecurityObjectBuilder.</div>
 * <div class="de">Klasse welche das Interface PrivacyPolicyFeedBuilder and SecurityObjectBuilder implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedBuilderImpl
		implements PrivacyPolicyFeedBuilder, SecurityObjectBuilder<Assertion, PrivacyPolicyFeed> {

	private PpfMethod ppfMethod;

	public PrivacyPolicyFeedBuilderImpl() {

	}

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
