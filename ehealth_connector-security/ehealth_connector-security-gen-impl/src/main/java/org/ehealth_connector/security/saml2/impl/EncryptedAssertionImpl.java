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
package org.ehealth_connector.security.saml2.impl;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.EncryptedAssertion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of EncryptedAssertion</div>
 * <div class="de">Implementations Klasse von EncryptedAssertion</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public class EncryptedAssertionImpl
		implements EncryptedAssertion, SecurityObject<org.opensaml.saml.saml2.core.EncryptedAssertion> {

	private org.opensaml.saml.saml2.core.EncryptedAssertion wrappedObject;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param aInnerObject
	 * <!-- @formatter:on -->
	 */
	protected EncryptedAssertionImpl(org.opensaml.saml.saml2.core.EncryptedAssertion aInnerObject) {
		wrappedObject = aInnerObject;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.EncryptedAssertion getWrappedObject() {
		return wrappedObject;
	}

}
