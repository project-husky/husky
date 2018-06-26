/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.impl.AssertionBuilderImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PrivacyPolicyFeed.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface PrivacyPolicyFeed.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedImpl
		implements PrivacyPolicyFeed, SecurityObject<org.opensaml.saml.saml2.core.Assertion> {

	private org.opensaml.saml.saml2.core.Assertion mAssertion;
	private PpfMethod mPpfMethod;

	protected PrivacyPolicyFeedImpl(PpfMethod ppfMethod,
			org.opensaml.saml.saml2.core.Assertion aInternalObject) {
		mPpfMethod = ppfMethod;
		mAssertion = aInternalObject;
	}

	@Override
	public Assertion getAssertion() {
		return new AssertionBuilderImpl().create(mAssertion);
	}

	@Override
	public PpfMethod getMethod() {
		return mPpfMethod;
	}

	@Override
	public org.opensaml.saml.saml2.core.Assertion getWrappedObject() {
		return mAssertion;
	}

}
