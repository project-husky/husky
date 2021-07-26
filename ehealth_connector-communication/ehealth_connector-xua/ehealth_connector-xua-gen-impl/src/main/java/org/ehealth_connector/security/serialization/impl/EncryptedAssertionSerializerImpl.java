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
package org.ehealth_connector.security.serialization.impl;

import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.EncryptedAssertion;
import org.ehealth_connector.security.saml2.impl.EncryptedAssertionImpl;
import org.ehealth_connector.security.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<Assertion</div>
 * <div class="de">Implementations Klasse von Serializer<Assertion</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class EncryptedAssertionSerializerImpl extends AbstractSerializerImpl
		implements Serializer<EncryptedAssertion> {

	@Override
	public byte[] toXmlByteArray(EncryptedAssertion aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((EncryptedAssertionImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(EncryptedAssertion aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((EncryptedAssertionImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(EncryptedAssertion aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToString(
					((EncryptedAssertionImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
