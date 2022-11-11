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
package org.projecthusky.xua.saml2.impl;

import java.util.Calendar;

import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.ArtifactResolve;
import org.projecthusky.xua.saml2.ArtifactResolveBuilder;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;

/**
 * Class implementing the corresponding interface for Assertion building.
 */
public class ArtifactResolveBuilderImpl implements ArtifactResolveBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.ArtifactResolve, ArtifactResolve> {

	private org.opensaml.saml.saml2.core.ArtifactResolve wrappedObject;
	private org.opensaml.saml.saml2.core.Issuer issuer;
	private org.opensaml.saml.saml2.core.Artifact artifact;

	/**
	 * Default constructor.
	 */
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

	/**
	 * Method to create ArtefactResolve instance.
	 * @return the created artefactresolve instance
	 */
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
