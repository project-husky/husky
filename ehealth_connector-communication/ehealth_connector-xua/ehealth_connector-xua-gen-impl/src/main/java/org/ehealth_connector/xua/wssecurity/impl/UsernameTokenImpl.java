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
package org.ehealth_connector.xua.wssecurity.impl;

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.wssecurity.UsernameToken;

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
	 * @see org.ehealth_connector.xua.wssecurity.UsernameToken#getNonce()
	 */
	@Override
	public String getNonce() {
		if ((wrappedObject
				.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Nonce.ELEMENT_NAME) != null)
				&& (wrappedObject
						.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Nonce.ELEMENT_NAME)
						.size() > 0)) {
			final org.opensaml.soap.wssecurity.Nonce nonce = (org.opensaml.soap.wssecurity.Nonce) wrappedObject
					.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Nonce.ELEMENT_NAME).get(0);
			return nonce.getValue();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.wssecurity.UsernameToken#getPassword()
	 */
	@Override
	public String getPassword() {
		if ((wrappedObject
				.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Password.ELEMENT_NAME) != null)
				&& (wrappedObject
						.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Password.ELEMENT_NAME)
						.size() > 0)) {
			final org.opensaml.soap.wssecurity.Password password = (org.opensaml.soap.wssecurity.Password) wrappedObject
					.getUnknownXMLObjects(org.opensaml.soap.wssecurity.Password.ELEMENT_NAME)
					.get(0);
			return password.getValue();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.wssecurity.UsernameToken#getUsername()
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
	 * @see org.ehealth_connector.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.soap.wssecurity.UsernameToken getWrappedObject() {
		return wrappedObject;
	}

}
