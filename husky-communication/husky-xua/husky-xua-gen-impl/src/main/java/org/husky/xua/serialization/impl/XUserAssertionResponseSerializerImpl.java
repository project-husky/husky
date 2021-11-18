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
package org.husky.xua.serialization.impl;

import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.XUserAssertionResponseImpl;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<Response></div>
 * <div class="de">Implementations Klasse von Serializer<Response></div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionResponseSerializerImpl extends AbstractSerializerImpl
		implements Serializer<XUserAssertionResponse> {

	@Override
	public byte[] toXmlByteArray(XUserAssertionResponse aXUserAssertionRequest)
			throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((XUserAssertionResponseImpl) aXUserAssertionRequest).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(XUserAssertionResponse aXUserAssertionRequest)
			throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToXml(
					((XUserAssertionResponseImpl) aXUserAssertionRequest).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(XUserAssertionResponse aXUserAssertionRequest)
			throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToString(
					((XUserAssertionResponseImpl) aXUserAssertionRequest).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
