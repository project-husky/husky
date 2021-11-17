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
package org.husky.xua.serialization.impl;

import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.Response;
import org.husky.xua.saml2.impl.ResponseImpl;
import org.husky.xua.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<Response></div>
 * <div class="de">Implementations Klasse von Serializer<Response></div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ResponseSerializerImpl extends AbstractSerializerImpl implements Serializer<Response> {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.Serializer#toXmlByteArray(java.lang.Object)
	 */
	@Override
	public byte[] toXmlByteArray(Response aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToByteArray(((ResponseImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.Serializer#toXmlElement(java.lang.Object)
	 */
	@Override
	public Element toXmlElement(Response aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((ResponseImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.Serializer#toXmlString(java.lang.Object)
	 */
	@Override
	public String toXmlString(Response aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((ResponseImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
