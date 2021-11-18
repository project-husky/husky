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
package org.husky.xua.serialization.impl;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.Base;
import org.husky.xua.serialization.Serializer;
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
