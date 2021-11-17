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
package org.husky.communication.ch.ppq.impl.serialization;

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryResponseImpl;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.serialization.Serializer;
import org.husky.xua.serialization.impl.AbstractSerializerImpl;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<PrivacyPolicyFeedResponse></div>
 * <div class="de">Implementations Klasse von Serializer<PrivacyPolicyFeedResponse></div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedResponseSerializerImpl extends AbstractSerializerImpl
		implements Serializer<PrivacyPolicyFeedResponse> {

	@Override
	public byte[] toXmlByteArray(PrivacyPolicyFeedResponse ppfResponse) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((PrivacyPolicyQueryResponseImpl) ppfResponse).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(PrivacyPolicyFeedResponse ppfResponse) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToXml(
					((PrivacyPolicyQueryResponseImpl) ppfResponse).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(PrivacyPolicyFeedResponse ppfResponse) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToString(
					((PrivacyPolicyQueryResponseImpl) ppfResponse).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
