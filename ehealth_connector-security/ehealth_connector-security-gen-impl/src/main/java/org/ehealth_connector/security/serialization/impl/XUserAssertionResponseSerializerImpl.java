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
package org.ehealth_connector.security.serialization.impl;

import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionResponseImpl;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.serialization.Serializer;
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
