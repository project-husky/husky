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
package org.husky.communication.ch.ppq.impl.serialization;

import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryResponseImpl;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.serialization.Serializer;
import org.husky.xua.serialization.impl.AbstractSerializerImpl;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<PrivacyPolicyQueryResponse></div>
 * <div class="de">Implementations Klasse von Serializer<PrivacyPolicyQueryResponse></div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyQueryResponseSerializerImpl extends AbstractSerializerImpl
		implements Serializer<PrivacyPolicyQueryResponse> {

	@Override
	public byte[] toXmlByteArray(PrivacyPolicyQueryResponse ppqResponse) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((PrivacyPolicyQueryResponseImpl) ppqResponse).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(PrivacyPolicyQueryResponse ppqResponse) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToXml(
					((PrivacyPolicyQueryResponseImpl) ppqResponse).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(PrivacyPolicyQueryResponse ppqResponse) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToString(
					((PrivacyPolicyQueryResponseImpl) ppqResponse).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
