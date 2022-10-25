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

import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.authentication.impl.AuthnRequestImpl;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * Implementation class of {@code Serializer<AuthnRequest>}.
 */
public class AuthnRequestSerializerImpl extends AbstractSerializerImpl
		implements Serializer<AuthnRequest> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.serialization.Serializer#toXmlByteArray(java.lang.Object)
	 */
	@Override
	public byte[] toXmlByteArray(AuthnRequest aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToByteArray(((AuthnRequestImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.serialization.Serializer#toXmlElement(java.lang.Object)
	 */
	@Override
	public Element toXmlElement(AuthnRequest aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((AuthnRequestImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.serialization.Serializer#toXmlString(java.lang.Object)
	 */
	@Override
	public String toXmlString(AuthnRequest aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((AuthnRequestImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
