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
package org.projecthusky.xua.saml2.impl;

import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.saml2.EncryptedAssertion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of EncryptedAssertion</div>
 * <div class="de">Implementations Klasse von EncryptedAssertion</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class EncryptedAssertionImpl implements EncryptedAssertion,
		SecurityObject<org.opensaml.saml.saml2.core.EncryptedAssertion> {

	/** The wrapped object. */
	private org.opensaml.saml.saml2.core.EncryptedAssertion wrappedObject;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 *
	 * @param aInnerObject the EncryptedAssertion
	 */
	protected EncryptedAssertionImpl(org.opensaml.saml.saml2.core.EncryptedAssertion aInnerObject) {
		wrappedObject = aInnerObject;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.EncryptedAssertion getWrappedObject() {
		return wrappedObject;
	}

}
