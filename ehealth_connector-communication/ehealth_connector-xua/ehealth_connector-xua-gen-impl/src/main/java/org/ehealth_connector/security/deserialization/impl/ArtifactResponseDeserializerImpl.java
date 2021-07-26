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
package org.ehealth_connector.security.deserialization.impl;

import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.saml2.ArtifactResponse;
import org.ehealth_connector.security.saml2.impl.ArtifactResponseBuilderImpl;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface Deserializer<ArtifactResponse> .</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface Deserializer<ArtifactResponse> .</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
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
