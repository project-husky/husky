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

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.impl.AuthnRequestImpl;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.serialization.OpenSaml2Serializer;
import org.ehealth_connector.security.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<AuthnRequest></div>
 * <div class="de">Implementations Klasse von Serializer<AuthnRequest></div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AuthnRequestSerializerImpl implements Serializer<AuthnRequest> {

	private OpenSaml2Serializer openSamlSerializer;

	public AuthnRequestSerializerImpl() {
		openSamlSerializer = new OpenSaml2SerializerImpl();
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.serialization.Serializer#toXmlElement(java.lang.Object)
	 */
	@Override
	public Element toXmlElement(AuthnRequest aSecurityObject) throws SerializeException {
		try {
			return openSamlSerializer.serializeToXml(((AuthnRequestImpl) aSecurityObject).getWrappedObject());
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
	public String toXmlString(AuthnRequest aSecurityObject) throws SerializeException {
		try {
			return openSamlSerializer.serializeToString(((AuthnRequestImpl) aSecurityObject).getWrappedObject());
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
	public byte[] toXmlByteArray(AuthnRequest aSecurityObject) throws SerializeException {
		try {
			return openSamlSerializer.serializeToByteArray(((AuthnRequestImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
