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
package org.ehealth_connector.security.wssecurity.impl;

import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.ehealth_connector.security.wssecurity.UsernameToken;
import org.ehealth_connector.security.wssecurity.UsernameTokenBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for UsernameToken building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um UsernameToken bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class UsernameTokenBuilderImpl implements UsernameTokenBuilder,
		SecurityObjectBuilder<org.opensaml.soap.wssecurity.UsernameToken, UsernameToken> {

	private org.opensaml.soap.wssecurity.Nonce nonce;
	private org.opensaml.soap.wssecurity.Password password;
	private org.opensaml.soap.wssecurity.Username userName;
	private org.opensaml.soap.wssecurity.UsernameToken wrappedObject;

	public UsernameTokenBuilderImpl() {
		wrappedObject = new org.opensaml.soap.wssecurity.impl.UsernameTokenBuilder().buildObject();
		userName = new org.opensaml.soap.wssecurity.impl.UsernameBuilder().buildObject();
		password = new org.opensaml.soap.wssecurity.impl.PasswordBuilder().buildObject();
		password.setType(org.opensaml.soap.wssecurity.Password.TYPE_PASSWORD_TEXT);
		nonce = new org.opensaml.soap.wssecurity.impl.NonceBuilder().buildObject();
		nonce.setEncodingType(org.opensaml.soap.wssecurity.Nonce.ENCODING_TYPE_BASE64_BINARY);
	}

	@Override
	public UsernameToken create() {
		if ((userName != null) && (userName.getValue() != null)) {
			wrappedObject.setUsername(userName);
		}
		if ((password != null) && (password.getValue() != null)) {
			wrappedObject.getUnknownXMLObjects().add(password);
		}
		if ((nonce != null) && (nonce.getValue() != null)) {
			wrappedObject.getUnknownXMLObjects().add(nonce);
		}

		return new UsernameTokenImpl(wrappedObject);
	}

	@Override
	public UsernameToken create(org.opensaml.soap.wssecurity.UsernameToken aInternalObject) {
		return new UsernameTokenImpl(aInternalObject);
	}

	@Override
	public UsernameTokenBuilder nonce(String aNonce) {
		if (aNonce != null) {
			nonce.setValue(aNonce);
		}
		return this;
	}

	@Override
	public UsernameTokenBuilder password(String aPassword) {
		if (aPassword != null) {
			password.setValue(aPassword);
		}
		return this;
	}

	@Override
	public UsernameTokenBuilder username(String aUsername) {
		if (aUsername != null) {
			userName.setValue(aUsername);
		}
		return this;
	}

}
