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
package org.ehealth_connector.security.saml2.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.EncryptedAssertion;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.saml2.Status;
import org.joda.time.DateTime;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Response</div>
 * <div class="de">Implementations Klasse von Response</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ResponseImpl
		implements Response, SecurityObject<org.opensaml.saml.saml2.core.Response> {

	/** The response. */
	private org.opensaml.saml.saml2.core.Response response;

	/**
	 * Instantiates a new ResponseImpl.
	 *
	 * @param response
	 *            the response
	 */
	protected ResponseImpl(org.opensaml.saml.saml2.core.Response response) {
		this.response = response;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#getAssertions()
	 */
	@Override
	public List<Assertion> getAssertions() {
		final List<org.opensaml.saml.saml2.core.Assertion> internal = response.getAssertions();
		final List<Assertion> retVal = new ArrayList<>();
		internal.forEach(c -> {
			retVal.add(new AssertionBuilderImpl().create(c));
		});
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#getConsent()
	 */
	@Override
	public String getConsent() {
		return response.getConsent();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#getDestination()
	 */
	@Override
	public String getDestination() {
		return response.getDestination();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#getEncryptedAssertions()
	 */
	@Override
	public List<EncryptedAssertion> getEncryptedAssertions() {
		final List<org.opensaml.saml.saml2.core.EncryptedAssertion> internal = response
				.getEncryptedAssertions();
		final List<EncryptedAssertion> retVal = new ArrayList<>();
		internal.forEach(c -> {
			retVal.add(new EncryptedAssertionBuilderImpl().create(c));
		});
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Base#getId()
	 */
	@Override
	public String getId() {
		return response.getID();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#getInResponseTo()
	 */
	@Override
	public String getInResponseTo() {
		return response.getInResponseTo();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Base#getIssueInstant()
	 */
	@Override
	public Calendar getIssueInstant() {
		final DateTime instant = response.getIssueInstant();
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(instant.getMillis());
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Base#getIssuer()
	 */
	@Override
	public String getIssuer() {
		if (response.getIssuer() != null) {
			return response.getIssuer().getValue();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#getStatus()
	 */
	@Override
	public Status getStatus() {
		return new StatusImpl(response.getStatus());
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Base#getVersion()
	 */
	@Override
	public String getVersion() {
		if (response.getVersion() != null) {
			return response.getVersion().toString();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Response getWrappedObject() {
		return response;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Response#hasSignature()
	 */
	@Override
	public boolean hasSignature() {
		return (response.getSignature() != null);
	}
}
