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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.saml2.ArtifactResponse;
import org.ehealth_connector.xua.saml2.Response;
import org.ehealth_connector.xua.saml2.Status;
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
	 * @see org.ehealth_connector.xua.saml2.Response#hasSignature()
	 */
	@Override
	public boolean hasSignature() {
		return (wrappedObject.getSignature() != null);
	}

}
