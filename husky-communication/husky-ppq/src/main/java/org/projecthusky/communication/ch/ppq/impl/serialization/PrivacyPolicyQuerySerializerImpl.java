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

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.projecthusky.communication.ch.ppq.impl.PrivacyPolicyQueryImpl;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.serialization.Serializer;
import org.projecthusky.xua.serialization.impl.AbstractSerializerImpl;
import org.w3c.dom.Element;

/**
 * Implementation class of {@code Serializer<PrivacyPolicyQuery>}.
 */
public class PrivacyPolicyQuerySerializerImpl extends AbstractSerializerImpl
		implements Serializer<PrivacyPolicyQuery> {

	@Override
	public byte[] toXmlByteArray(PrivacyPolicyQuery ppQuery) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToByteArray(((PrivacyPolicyQueryImpl) ppQuery).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(PrivacyPolicyQuery ppQuery) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((PrivacyPolicyQueryImpl) ppQuery).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(PrivacyPolicyQuery ppQuery) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((PrivacyPolicyQueryImpl) ppQuery).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
