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
package org.projecthusky.xua.serialization.impl;

import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.Base;
import org.projecthusky.xua.serialization.Serializer;
import org.opensaml.core.xml.XMLObject;
import org.w3c.dom.Element;

/**
 * Base Serializer for OpenSaml objects.
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
