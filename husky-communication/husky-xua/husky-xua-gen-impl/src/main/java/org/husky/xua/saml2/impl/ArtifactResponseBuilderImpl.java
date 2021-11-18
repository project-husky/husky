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
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.ArtifactResponse;
import org.husky.xua.saml2.ArtifactResponseBuilder;

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
