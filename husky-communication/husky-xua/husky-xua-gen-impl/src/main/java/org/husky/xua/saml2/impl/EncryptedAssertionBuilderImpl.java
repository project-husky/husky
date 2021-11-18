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
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.EncryptedAssertion;
import org.husky.xua.saml2.EncryptedAssertionBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for EncryptedAssertion building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um EncryptedAssertions bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class EncryptedAssertionBuilderImpl implements EncryptedAssertionBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.EncryptedAssertion, EncryptedAssertion> {

	/** The encrypted assertion. */
	private org.opensaml.saml.saml2.core.EncryptedAssertion encryptedAssertion;

	public EncryptedAssertionBuilderImpl() {
		encryptedAssertion = new org.opensaml.saml.saml2.core.impl.EncryptedAssertionBuilder()
				.buildObject();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SimpleBuilder#create()
	 */
	@Override
	public EncryptedAssertion create() {
		return new EncryptedAssertionImpl(encryptedAssertion);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public EncryptedAssertion create(
			org.opensaml.saml.saml2.core.EncryptedAssertion aInternalObject) {
		return new EncryptedAssertionImpl(aInternalObject);
	}

}
