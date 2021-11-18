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
