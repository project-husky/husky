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

import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.w3c.dom.Element;

/**
 * Class implementing the corresponding interface {@code Deserializer<Response>}.
 */
public class XUserAssertionResponseDeserializerImpl
		extends AbstractDeserializerImpl<RequestSecurityTokenResponse, XUserAssertionResponse> {

	@Override
	public XUserAssertionResponse fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final RequestSecurityTokenResponse response = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new XUserAssertionResponseBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public XUserAssertionResponse fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final RequestSecurityTokenResponse response = getOpenSamlDeserializer()
					.deserializeFromXml(aXmlElement);
			return new XUserAssertionResponseBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public XUserAssertionResponse fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final RequestSecurityTokenResponse response = getOpenSamlDeserializer()
					.deserializeFromString(aXmlString);
			return new XUserAssertionResponseBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
