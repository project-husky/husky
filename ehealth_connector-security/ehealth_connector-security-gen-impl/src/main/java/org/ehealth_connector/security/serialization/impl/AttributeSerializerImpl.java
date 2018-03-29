/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.serialization.impl;

import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.impl.AttributeImpl;
import org.ehealth_connector.security.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<Attribute</div>
 * <div class="de">Implementations Klasse von Serializer<Attribute</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AttributeSerializerImpl extends AbstractSerializerImpl implements Serializer<Attribute> {

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.Serializer#toXmlElement(java.lang.Object)
	 */
	@Override
	public Element toXmlElement(Attribute aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToXml(((AttributeImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.Serializer#toXmlString(java.lang.Object)
	 */
	@Override
	public String toXmlString(Attribute aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToString(((AttributeImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.Serializer#toXmlByteArray(java.lang.Object)
	 */
	@Override
	public byte[] toXmlByteArray(Attribute aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(((AttributeImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
