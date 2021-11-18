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
package org.husky.xua.wssecurity.impl;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.wssecurity.UsernameToken;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of interfaces UsernameToken and SecurityObject</div>
 * <div class="de">Implementations Klasse der Interfaces UsernameToken und SecurityObject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class UsernameTokenImpl
		implements UsernameToken, SecurityObject<org.opensaml.soap.wssecurity.UsernameToken> {

	/** The wrapped object. */
	private org.opensaml.soap.wssecurity.UsernameToken wrappedObject;

	/**
	 * Instantiates a new UsernameTokenImpl.
	 *
	 * @param aInternalObject
	 *            the UsernameToken
	 */
	public UsernameTokenImpl(org.opensaml.soap.wssecurity.UsernameToken aInternalObject) {
		wrappedObject = aInternalObject;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.wssecurity.UsernameToken#getNonce()
	 */
	@Override
	public String getNonce() {
		if (!wrappedObject
						.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Nonce.ELEMENT_NAME)
						.isEmpty()) {
			final var nonce = (org.opensaml.soap.wssecurity.Nonce) wrappedObject
					.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Nonce.ELEMENT_NAME).get(0);
			return nonce.getValue();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.wssecurity.UsernameToken#getPassword()
	 */
	@Override
	public String getPassword() {
		if (!wrappedObject
						.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Password.ELEMENT_NAME)
						.isEmpty()) {
			final var password = (org.opensaml.soap.wssecurity.Password) wrappedObject
					.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Password.ELEMENT_NAME)
					.get(0);
			return password.getValue();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.wssecurity.UsernameToken#getUsername()
	 */
	@Override
	public String getUsername() {
		if (wrappedObject.getUsername() != null) {
			return wrappedObject.getUsername().getValue();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.soap.wssecurity.UsernameToken getWrappedObject() {
		return wrappedObject;
	}

}
