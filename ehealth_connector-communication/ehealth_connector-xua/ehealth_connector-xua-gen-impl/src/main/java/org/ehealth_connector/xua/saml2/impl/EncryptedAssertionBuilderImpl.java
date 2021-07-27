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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.EncryptedAssertion;
import org.ehealth_connector.xua.saml2.EncryptedAssertionBuilder;

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
	 * @see org.ehealth_connector.xua.saml2.SimpleBuilder#create()
	 */
	@Override
	public EncryptedAssertion create() {
		return new EncryptedAssertionImpl(encryptedAssertion);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public EncryptedAssertion create(
			org.opensaml.saml.saml2.core.EncryptedAssertion aInternalObject) {
		return new EncryptedAssertionImpl(aInternalObject);
	}

}
