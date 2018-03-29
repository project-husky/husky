/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication.impl;

import java.util.Calendar;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.joda.time.DateTime;

/**
 * @since Feb 20, 2018 3:01:05 PM
 *
 */
public class AuthnRequestImpl implements AuthnRequest {

	private org.opensaml.saml2.core.AuthnRequest authnRequest;

	/**
	 * Default constructor to instanciate the object
	 */
	protected AuthnRequestImpl(org.opensaml.saml2.core.AuthnRequest aAuthnRequest) {
		authnRequest = aAuthnRequest;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getProtocolBinding()
	 */
	@Override
	public String getProtocolBinding() {
		return authnRequest.getProtocolBinding();
	}

	/**
	 * {@inheritDoc}Object
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getAssertionConsumerServiceIndex()
	 */
	@Override
	public Integer getAssertionConsumerServiceIndex() {
		return authnRequest.getAssertionConsumerServiceIndex();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getAssertionConsumerServiceURL()
	 */
	@Override
	public String getAssertionConsumerServiceURL() {
		return authnRequest.getAssertionConsumerServiceURL();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getAttributeConsumingServiceIndex()
	 */
	@Override
	public Integer getAttributeConsumingServiceIndex() {
		return authnRequest.getAttributeConsumingServiceIndex();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getProviderName()
	 */
	@Override
	public String getProviderName() {
		return authnRequest.getProviderName();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getForceAuthn()
	 */
	@Override
	public Boolean getForceAuthn() {
		return authnRequest.isForceAuthn();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getConsent()
	 */
	@Override
	public String getConsent() {
		return authnRequest.getConsent();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getDestination()
	 */
	@Override
	public String getDestination() {
		return authnRequest.getDestination();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getIssueInstant()
	 */
	@Override
	public Calendar getIssueInstant() {
		final DateTime instant = authnRequest.getIssueInstant();
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(instant.getMillis());
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getID()
	 */
	@Override
	public String getID() {
		return authnRequest.getID();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getIssuer()
	 */
	@Override
	public String getIssuer() {
		if (authnRequest.getIssuer() != null) {
			return authnRequest.getIssuer().getValue();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getNameIdPolicyAllowCreate()
	 */
	@Override
	public Boolean getNameIdPolicyAllowCreate() {
		if (authnRequest.getNameIDPolicy() != null) {
			return authnRequest.getNameIDPolicy().getAllowCreate();
		}
		return Boolean.FALSE;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequest#getNameIdPolicyFormat()
	 */
	@Override
	public String getNameIdPolicyFormat() {
		if (authnRequest.getNameIDPolicy() != null) {
			return authnRequest.getNameIDPolicy().getFormat();
		}
		return "";
	}

	/**
	 * 
	 * @formatter:off
	 * <div class="en">method to get the wrapped inner object (opensaml)</div>
	 * <div class="de">Method um das gewrappted innere objet zu erhalten  (opensaml)</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the inner authnrequest instance
	 */
	public org.opensaml.saml2.core.AuthnRequest getWrappedObject() {
		return authnRequest;
	}

}
