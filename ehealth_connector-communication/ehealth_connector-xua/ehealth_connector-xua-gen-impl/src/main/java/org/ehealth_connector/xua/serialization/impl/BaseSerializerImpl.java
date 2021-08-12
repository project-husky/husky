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
package org.ehealth_connector.xua.serialization.impl;

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.saml2.Base;
import org.ehealth_connector.xua.serialization.Serializer;
import org.opensaml.core.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Base Serializer for OpenSaml objects.</div>
 * <div class="de">Basis Serializer für OpenSaml-Objekte.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class BaseSerializerImpl extends AbstractSerializerImpl implements Serializer<Base> {

	@SuppressWarnings("unchecked")
	@Override
	public byte[] toXmlByteArray(Base aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((SecurityObject<XMLObject>) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Element toXmlElement(Base aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToXml(
					((SecurityObject<XMLObject>) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toXmlString(Base aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToString(
					((SecurityObject<XMLObject>) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
