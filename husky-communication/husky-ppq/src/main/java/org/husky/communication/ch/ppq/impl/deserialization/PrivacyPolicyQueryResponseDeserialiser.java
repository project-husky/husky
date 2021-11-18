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
package org.husky.communication.ch.ppq.impl.deserialization;

import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryResponseBuilderImpl;
import org.husky.xua.deserialization.impl.AbstractDeserializerImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.opensaml.saml.saml2.core.Response;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface Deserializer<Response> .</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface Deserializer<Response> .</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyQueryResponseDeserialiser
		extends AbstractDeserializerImpl<Response, PrivacyPolicyQueryResponse> {

	@Override
	public PrivacyPolicyQueryResponse fromXmlByteArray(byte[] aByteArray)
			throws DeserializeException {
		try {
			final Response response = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new PrivacyPolicyQueryResponseBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public PrivacyPolicyQueryResponse fromXmlElement(Element aXmlElement)
			throws DeserializeException {
		try {
			final Response response = getOpenSamlDeserializer().deserializeFromXml(aXmlElement);
			return new PrivacyPolicyQueryResponseBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public PrivacyPolicyQueryResponse fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final Response response = getOpenSamlDeserializer().deserializeFromString(aXmlString);
			return new PrivacyPolicyQueryResponseBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
