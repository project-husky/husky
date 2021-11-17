/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.xua.serialization.impl;

import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.ArtifactResolve;
import org.husky.xua.saml2.impl.ArtifactResolveImpl;
import org.husky.xua.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Serializer<rtifactResolve</div>
 * <div class="de">Implementations Klasse von Serializer<rtifactResolve</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ArtifactResolveSerializerImpl extends AbstractSerializerImpl
		implements Serializer<ArtifactResolve> {

	@Override
	public byte[] toXmlByteArray(ArtifactResolve aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((ArtifactResolveImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(ArtifactResolve aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((ArtifactResolveImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(ArtifactResolve aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((ArtifactResolveImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
