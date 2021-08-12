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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.ArtifactResponse;
import org.ehealth_connector.xua.saml2.ArtifactResponseBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
public class ArtifactResponseBuilderImpl implements ArtifactResponseBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.ArtifactResponse, ArtifactResponse> {

	private org.opensaml.saml.saml2.core.ArtifactResponse wrappedObject;

	@Override
	public ArtifactResponse create() {
		return new ArtifactResponseImpl(wrappedObject);
	}

	@Override
	public ArtifactResponse create(org.opensaml.saml.saml2.core.ArtifactResponse aInternalObject) {
		return new ArtifactResponseImpl(aInternalObject);
	}

}
