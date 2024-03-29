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
import org.projecthusky.xua.saml2.ArtifactResponse;
import org.projecthusky.xua.saml2.impl.ArtifactResponseBuilderImpl;
import org.w3c.dom.Element;

/**
 * Class implementing the corresponding interface {@code Deserializer<ArtifactResponse>}.
 */
public class ArtifactResponseDeserializerImpl extends
		AbstractDeserializerImpl<org.opensaml.saml.saml2.core.ArtifactResponse, ArtifactResponse> {

	@Override
	public ArtifactResponse fromXmlByteArray(byte[] aByteArray) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.ArtifactResponse request = getOpenSamlDeserializer()
					.deserializeFromByteArray(aByteArray);
			return new ArtifactResponseBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public ArtifactResponse fromXmlElement(Element aXmlElement) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.ArtifactResponse request = getOpenSamlDeserializer()
					.deserializeFromXml(aXmlElement);
			return new ArtifactResponseBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

	@Override
	public ArtifactResponse fromXmlString(String aXmlString) throws DeserializeException {
		try {
			final org.opensaml.saml.saml2.core.ArtifactResponse request = getOpenSamlDeserializer()
					.deserializeFromString(aXmlString);
			return new ArtifactResponseBuilderImpl().create(request);
		} catch (final Exception e) {
			throw new DeserializeException(e);
		}
	}

}
