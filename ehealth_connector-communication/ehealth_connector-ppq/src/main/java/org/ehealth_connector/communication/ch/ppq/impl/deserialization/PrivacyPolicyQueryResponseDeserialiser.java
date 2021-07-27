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
package org.ehealth_connector.communication.ch.ppq.impl.deserialization;

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyQueryResponseBuilderImpl;
import org.ehealth_connector.xua.deserialization.impl.AbstractDeserializerImpl;
import org.ehealth_connector.xua.exceptions.DeserializeException;
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
