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
package org.projecthusky.xua.deserialization.impl;

import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.saml2.Assertion;
import org.projecthusky.xua.saml2.impl.AssertionBuilderImpl;
import org.w3c.dom.Element;

/**
 * Class implementing the corresponding interface {@code Deserializer<Assertion>}.
 */
public class AssertionDeserializerImpl
		extends AbstractDeserializerImpl<org.opensaml.saml.saml2.core.Assertion, Assertion> {

	@Override
	public Assertion fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.Assertion request = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new AssertionBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public Assertion fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.Assertion request = getOpenSamlDeserializer()
					.deserializeFromXml(aXmlElement);
			return new AssertionBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public Assertion fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.Assertion request = getOpenSamlDeserializer()
					.deserializeFromString(aXmlString);
			return new AssertionBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
