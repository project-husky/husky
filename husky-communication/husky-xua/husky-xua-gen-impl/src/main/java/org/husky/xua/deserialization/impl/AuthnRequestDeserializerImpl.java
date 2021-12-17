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
package org.husky.xua.deserialization.impl;

import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.w3c.dom.Element;

/**
 * Class implementing the corresponding interface {@code Deserializer<AuthnRequest>}.
 */
public class AuthnRequestDeserializerImpl
		extends AbstractDeserializerImpl<org.opensaml.saml.saml2.core.AuthnRequest, AuthnRequest> {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.Deserializer#fromXmlByteArray(byte[])
	 */
	@Override
	public AuthnRequest fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.AuthnRequest request = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new AuthnRequestBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.Deserializer#fromXmlElement(org.w3c.dom.Element)
	 */
	@Override
	public AuthnRequest fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.AuthnRequest request = getOpenSamlDeserializer()
					.deserializeFromXml(aXmlElement);
			return new AuthnRequestBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.deserialization.Deserializer#fromXmlString(java.lang.String)
	 */
	@Override
	public AuthnRequest fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.AuthnRequest request = getOpenSamlDeserializer()
					.deserializeFromString(aXmlString);
			return new AuthnRequestBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
