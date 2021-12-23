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

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.wssecurity.UsernameToken;
import org.husky.xua.wssecurity.UsernameTokenBuilder;
import org.opensaml.soap.wssecurity.EncodedString;

/**
 * Class implementing the corresponding interface for UsernameToken building.
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
		nonce.setEncodingType(EncodedString.ENCODING_TYPE_BASE64_BINARY);
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
