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

import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.ArtifactResponse;
import org.projecthusky.xua.saml2.impl.ArtifactResponseImpl;
import org.projecthusky.xua.serialization.Serializer;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
public class ArtifactResponseSerializerImpl extends AbstractSerializerImpl
		implements Serializer<ArtifactResponse> {

	@Override
	public byte[] toXmlByteArray(ArtifactResponse aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer().serializeToByteArray(
					((ArtifactResponseImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public Element toXmlElement(ArtifactResponse aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToXml(((ArtifactResponseImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

	@Override
	public String toXmlString(ArtifactResponse aSecurityObject) throws SerializeException {
		try {
			return getOpenSamlSerializer()
					.serializeToString(((ArtifactResponseImpl) aSecurityObject).getWrappedObject());
		} catch (final Exception e) {
			throw new SerializeException(e);
		}
	}

}
