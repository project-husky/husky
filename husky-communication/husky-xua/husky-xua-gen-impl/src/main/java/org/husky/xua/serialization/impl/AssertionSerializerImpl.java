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

import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.impl.AssertionImpl;
import org.husky.xua.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * Implementation class of {@code Serializer<Assertion>}.
 */
public class AssertionSerializerImpl extends AbstractSerializerImpl
		implements Serializer<Assertion> {

	@Override
	public byte[] toXmlByteArray(Assertion aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToByteArray(((AssertionImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(Assertion aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((AssertionImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(Assertion aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((AssertionImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
