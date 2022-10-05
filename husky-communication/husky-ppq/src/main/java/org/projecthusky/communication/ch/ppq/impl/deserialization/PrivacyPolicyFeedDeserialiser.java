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
package org.projecthusky.communication.ch.ppq.impl.deserialization;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl;
import org.projecthusky.xua.deserialization.impl.AbstractDeserializerImpl;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.opensaml.saml.saml2.core.Assertion;
import org.w3c.dom.Element;

/**
 * Class implementing the corresponding interface {@code Deserializer<Response>}.
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
