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
package org.ehealth_connector.communication.ch.ppq.impl.serialization;

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyQueryImpl;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.serialization.Serializer;
import org.ehealth_connector.xua.serialization.impl.AbstractSerializerImpl;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<PrivacyPolicyQuery></div>
 * <div class="de">Implementations Klasse von Serializer<PrivacyPolicyQuery></div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
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
