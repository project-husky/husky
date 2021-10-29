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
package org.husky.xua.serialization.impl;

import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.impl.AttributeImpl;
import org.husky.xua.serialization.Serializer;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<Attribute</div>
 * <div class="de">Implementations Klasse von Serializer<Attribute</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AttributeSerializerImpl extends AbstractSerializerImpl
		implements Serializer<AttributeType> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.Serializer#toXmlByteArray(java.lang.Object)
	 */
	@Override
	public byte[] toXmlByteArray(AttributeType aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToByteArray(((AttributeImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.Serializer#toXmlElement(java.lang.Object)
	 */
	@Override
	public Element toXmlElement(AttributeType aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((AttributeImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.serialization.Serializer#toXmlString(java.lang.Object)
	 */
	@Override
	public String toXmlString(AttributeType aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((AttributeImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
