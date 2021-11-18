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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.ArtifactResponse;
import org.husky.xua.saml2.Response;
import org.husky.xua.saml2.Status;
import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
public class ArtifactResponseImpl
		implements ArtifactResponse, SecurityObject<org.opensaml.saml.saml2.core.ArtifactResponse> {

	private org.opensaml.saml.saml2.core.ArtifactResponse wrappedObject;

	protected ArtifactResponseImpl(org.opensaml.saml.saml2.core.ArtifactResponse artifactResponse) {
		wrappedObject = artifactResponse;
	}

	@Override
	public String getConsent() {

		return wrappedObject.getConsent();
	}

	@Override
	public String getDestination() {
		return wrappedObject.getDestination();
	}

	@Override
	public String getId() {
		return wrappedObject.getID();
	}

	@Override
	public String getInResponseTo() {
		return wrappedObject.getInResponseTo();
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
	public List<Response> getResponses() {
		final List<Response> retVal = new ArrayList<>();

		final List<XMLObject> orderedChildren = wrappedObject.getOrderedChildren();
		orderedChildren.forEach(c -> {
			if (c instanceof org.opensaml.saml.saml2.core.Response) {
				retVal.add(new ResponseBuilderImpl()
						.create((org.opensaml.saml.saml2.core.Response) c));
			}
		});
		return retVal;
	}

	@Override
	public Status getStatus() {
		return new StatusImpl(wrappedObject.getStatus());
	}

	@Override
	public String getVersion() {
		if (wrappedObject.getVersion() != null) {
			return wrappedObject.getVersion().toString();
		}
		return "";
	}

	@Override
	public org.opensaml.saml.saml2.core.ArtifactResponse getWrappedObject() {
		return wrappedObject;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Response#hasSignature()
	 */
	@Override
	public boolean hasSignature() {
		return (wrappedObject.getSignature() != null);
	}

}
