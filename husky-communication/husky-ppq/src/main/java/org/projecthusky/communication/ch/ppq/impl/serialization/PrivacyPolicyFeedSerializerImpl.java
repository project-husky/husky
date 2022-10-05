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
package org.projecthusky.communication.ch.ppq.impl.serialization;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.impl.PrivacyPolicyFeedImpl;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.serialization.Serializer;
import org.projecthusky.xua.serialization.impl.AbstractSerializerImpl;
import org.w3c.dom.Element;

/**
 * Class implementating the interface Serializer&gt;Assertion&lt;.
 */
public class PrivacyPolicyFeedSerializerImpl extends AbstractSerializerImpl
		implements Serializer<PrivacyPolicyFeed> {

	@Override
	public byte[] toXmlByteArray(PrivacyPolicyFeed ppFeed) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToByteArray(((PrivacyPolicyFeedImpl) ppFeed).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(PrivacyPolicyFeed ppFeed) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((PrivacyPolicyFeedImpl) ppFeed).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(PrivacyPolicyFeed ppFeed) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((PrivacyPolicyFeedImpl) ppFeed).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
