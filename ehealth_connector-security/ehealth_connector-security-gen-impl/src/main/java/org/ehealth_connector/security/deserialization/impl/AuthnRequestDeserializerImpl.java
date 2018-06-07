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
package org.ehealth_connector.security.deserialization.impl;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface Deserializer<AuthnRequest> .</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface Deserializer<AuthnRequest> .</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AuthnRequestDeserializerImpl
		extends AbstractDeserializerImpl<org.opensaml.saml.saml2.core.AuthnRequest, AuthnRequest> {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.deserialization.Deserializer#fromXmlByteArray(byte[])
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
	 * @see org.ehealth_connector.security.deserialization.Deserializer#fromXmlElement(org.w3c.dom.Element)
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
	 * @see org.ehealth_connector.security.deserialization.Deserializer#fromXmlString(java.lang.String)
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
