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
import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.saml2.impl.AssertionBuilderImpl;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;

/**
 * Class implementing the corresponding interface for PrivacyPolicyFeed.
 */
public class PrivacyPolicyFeedImpl
		implements PrivacyPolicyFeed, SecurityObject<AssertionType/*org.opensaml.saml.saml2.core.Assertion*/> {

	private AssertionType/*org.opensaml.saml.saml2.core.Assertion*/ mAssertion;
	private PpfMethod mPpfMethod;

	protected PrivacyPolicyFeedImpl(PpfMethod ppfMethod,
			AssertionType/*org.opensaml.saml.saml2.core.Assertion*/ aInternalObject) {
		mPpfMethod = ppfMethod;
		mAssertion = aInternalObject;
	}

	@Override
	public AssertionType getAssertion() {
		return mAssertion;//new AssertionBuilderImpl().create(mAssertion);
	}

	@Override
	public PpfMethod getMethod() {
		return mPpfMethod;
	}

	@Override
	public AssertionType/*org.opensaml.saml.saml2.core.Assertion*/ getWrappedObject() {
		return mAssertion;
	}

}
