/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.deserialization.impl;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl;
import org.ehealth_connector.security.deserialization.Deserializer;
import org.ehealth_connector.security.deserialization.OpenSaml2Deserializer;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.opensaml.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * @since Feb 21, 2018 2:40:59 PM
 *
 */
public class AuthnRequestDeserializerImpl implements Deserializer<AuthnRequest<org.opensaml.saml2.core.AuthnRequest>> {

	private OpenSaml2Deserializer openSamlDeserializer;

	public AuthnRequestDeserializerImpl() {
		openSamlDeserializer = new OpenSaml2DeserializerImpl();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.deserialization.Deserializer#fromXmlElement(org.w3c.dom.Element)
	 */
	@Override
	public AuthnRequest<org.opensaml.saml2.core.AuthnRequest> fromXmlElement(Element aXmlElement)
			throws DeserializeException {
		try {
			final XMLObject request = openSamlDeserializer.deserializeFromXml(aXmlElement);
			return new AuthnRequestBuilderImpl().createAuthnRequest((org.opensaml.saml2.core.AuthnRequest) request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.deserialization.Deserializer#fromXmlString(java.lang.String)
	 */
	@Override
	public AuthnRequest<org.opensaml.saml2.core.AuthnRequest> fromXmlString(String aXmlString)
			throws DeserializeException {
		try {
			final XMLObject request = openSamlDeserializer.deserializeFromString(aXmlString);
			return new AuthnRequestBuilderImpl().createAuthnRequest((org.opensaml.saml2.core.AuthnRequest) request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.deserialization.Deserializer#fromXmlByteArray(byte[])
	 */
	@Override
	public AuthnRequest<org.opensaml.saml2.core.AuthnRequest> fromXmlByteArray(byte[] aByteArray)
			throws DeserializeException {
		try {
			final XMLObject request = openSamlDeserializer.deserializeFromByteArray(aByteArray);
			return new AuthnRequestBuilderImpl().createAuthnRequest((org.opensaml.saml2.core.AuthnRequest) request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
