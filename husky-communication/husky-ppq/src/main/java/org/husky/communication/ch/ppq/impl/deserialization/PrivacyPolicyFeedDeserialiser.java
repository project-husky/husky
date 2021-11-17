/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.ppq.impl.deserialization;

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.husky.xua.deserialization.impl.AbstractDeserializerImpl;
import org.husky.xua.exceptions.DeserializeException;
import org.opensaml.saml.saml2.core.Assertion;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface Deserializer<Response> .</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface Deserializer<Response> .</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedDeserialiser
		extends AbstractDeserializerImpl<Assertion, PrivacyPolicyFeed> {

	@Override
	public PrivacyPolicyFeed fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final Assertion response = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new PrivacyPolicyFeedBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public PrivacyPolicyFeed fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final Assertion response = getOpenSamlDeserializer().deserializeFromXml(aXmlElement);
			return new PrivacyPolicyFeedBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public PrivacyPolicyFeed fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final Assertion response = getOpenSamlDeserializer().deserializeFromString(aXmlString);
			return new PrivacyPolicyFeedBuilderImpl().create(response);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
