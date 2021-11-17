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
package org.husky.xua.saml2.impl;

import java.util.Calendar;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.ArtifactResolve;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the ArtifactResolve methods.</div>
 * <div class="de">Interface welches die ArtifactResolve Methoden beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ArtifactResolveImpl
		implements ArtifactResolve, SecurityObject<org.opensaml.saml.saml2.core.ArtifactResolve> {

	private org.opensaml.saml.saml2.core.ArtifactResolve wrappedObject;

	protected ArtifactResolveImpl(org.opensaml.saml.saml2.core.ArtifactResolve aWrappedObject) {
		wrappedObject = aWrappedObject;
	}

	@Override
	public String getArtifact() {
		if (wrappedObject.getArtifact() != null) {
			return wrappedObject.getArtifact().getValue();
		}
		return "";
	}

	@Override
	public String getId() {
		return wrappedObject.getID();
	}

	@Override
	public Calendar getIssueInstant() {
		final var retVal = Calendar.getInstance();
		retVal.setTimeInMillis(wrappedObject.getIssueInstant().toEpochMilli());
		return retVal;
	}

	@Override
	public String getIssuer() {
		if (wrappedObject.getIssuer() != null) {
			return wrappedObject.getIssuer().getValue();
		}
		return "";
	}

	@Override
	public String getVersion() {
		if (wrappedObject.getVersion() != null) {
			return wrappedObject.getVersion().toString();
		}
		return "";
	}

	@Override
	public org.opensaml.saml.saml2.core.ArtifactResolve getWrappedObject() {
		return wrappedObject;
	}

}
