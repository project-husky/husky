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
package org.husky.xua.deserialization.impl;

import org.husky.xua.communication.xua.XUserAssertionRequest;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.opensaml.soap.wstrust.RequestSecurityToken;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface Deserializer<Response> .</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface Deserializer<Response> .</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionRequestDeserializerImpl
		extends AbstractDeserializerImpl<RequestSecurityToken, XUserAssertionRequest> {

	@Override
	public XUserAssertionRequest fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final RequestSecurityToken request = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new XUserAssertionRequestBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public XUserAssertionRequest fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final RequestSecurityToken request = getOpenSamlDeserializer()
					.deserializeFromXml(aXmlElement);
			return new XUserAssertionRequestBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public XUserAssertionRequest fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final RequestSecurityToken request = getOpenSamlDeserializer()
					.deserializeFromString(aXmlString);
			return new XUserAssertionRequestBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
