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
package org.projecthusky.xua.deserialization.impl;

import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.saml2.Response;
import org.projecthusky.xua.saml2.impl.ResponseBuilderImpl;
import org.w3c.dom.Element;

/**
 * Class implementing the corresponding interface {@code Deserializer<Response>}.
 */
public class ResponseDeserializerImpl
		extends AbstractDeserializerImpl<org.opensaml.saml.saml2.core.Response, Response> {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.deserialization.Deserializer#fromXmlByteArray(byte[])
	 */
	@Override
	public Response fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.Response request = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new ResponseBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.deserialization.Deserializer#fromXmlElement(org.w3c.dom.Element)
	 */
	@Override
	public Response fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.Response request = getOpenSamlDeserializer()
					.deserializeFromXml(aXmlElement);
			return new ResponseBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.deserialization.Deserializer#fromXmlString(java.lang.String)
	 */
	@Override
	public Response fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.Response request = getOpenSamlDeserializer()
					.deserializeFromString(aXmlString);
			return new ResponseBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
