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
package org.husky.xua.saml2.impl;

import java.util.Calendar;

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.ArtifactResolve;
import org.husky.xua.saml2.ArtifactResolveBuilder;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Assertion building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Assertion bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ArtifactResolveBuilderImpl implements ArtifactResolveBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.ArtifactResolve, ArtifactResolve> {

	private org.opensaml.saml.saml2.core.ArtifactResolve wrappedObject;
	private org.opensaml.saml.saml2.core.Issuer issuer;
	private org.opensaml.saml.saml2.core.Artifact artifact;

	public ArtifactResolveBuilderImpl() {
		wrappedObject = new org.opensaml.saml.saml2.core.impl.ArtifactResolveBuilder()
				.buildObject();

		final var issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject(Issuer.DEFAULT_ELEMENT_NAME);
		wrappedObject.setIssuer(issuer);

		artifact = new org.opensaml.saml.saml2.core.impl.ArtifactBuilder().buildObject();
		wrappedObject.setArtifact(artifact);
	}

	@Override
	public ArtifactResolveBuilderImpl artifact(String aArtifact) {
		if (aArtifact != null) {
			artifact.setValue(aArtifact);
		}
		return this;
	}

	public ArtifactResolve create() {
		return new ArtifactResolveImpl(wrappedObject);
	}

	@Override
	public ArtifactResolve create(org.opensaml.saml.saml2.core.ArtifactResolve aInternalObject) {
		return new ArtifactResolveImpl(aInternalObject);
	}

	@Override
	public ArtifactResolveBuilderImpl id(String aId) {
		wrappedObject.setID(aId);
		return this;
	}

	@Override
	public ArtifactResolveBuilderImpl issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			wrappedObject.setIssueInstant(aIssueInstant.toInstant());
		}
		return this;
	}

	@Override
	public ArtifactResolveBuilderImpl issuer(String aIssuer) {
		if (aIssuer != null) {
			issuer.setValue(aIssuer);
		}
		return this;
	}

	@Override
	public ArtifactResolveBuilderImpl version(String aVersion) {
		if (aVersion != null) {
			wrappedObject.setVersion(SAMLVersion.valueOf(aVersion));
		}
		return this;
	}

}
