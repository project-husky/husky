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
package org.ehealth_connector.xua.authentication.impl;

import java.util.Calendar;

import org.ehealth_connector.xua.authentication.AuthnRequest;
import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.saml2.impl.SubjectBuilderImpl;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AuthnRequest.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface AuthnRequest.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AuthnRequestImpl
		implements AuthnRequest, SecurityObject<org.opensaml.saml.saml2.core.AuthnRequest> {

	/** The AuthnRequest. */
	private org.opensaml.saml.saml2.core.AuthnRequest authnRequest;

	/**
	 * Default constructor to instanciate the object
	 */
	protected AuthnRequestImpl(org.opensaml.saml.saml2.core.AuthnRequest aAuthnRequest) {
		authnRequest = aAuthnRequest;
	}

	/**
	 * {@inheritDoc}Object
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getAssertionConsumerServiceIndex()
	 */
	@Override
	public Integer getAssertionConsumerServiceIndex() {
		return authnRequest.getAssertionConsumerServiceIndex();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getAssertionConsumerServiceUrl()
	 */
	@Override
	public String getAssertionConsumerServiceUrl() {
		return authnRequest.getAssertionConsumerServiceURL();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getAttributeConsumingServiceIndex()
	 */
	@Override
	public Integer getAttributeConsumingServiceIndex() {
		return authnRequest.getAttributeConsumingServiceIndex();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getConsent()
	 */
	@Override
	public String getConsent() {
		return authnRequest.getConsent();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getDestination()
	 */
	@Override
	public String getDestination() {
		return authnRequest.getDestination();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getForceAuthn()
	 */
	@Override
	public Boolean getForceAuthn() {
		return authnRequest.isForceAuthn();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Base#getId()
	 */
	@Override
	public String getId() {
		return authnRequest.getID();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Base#getIssueInstant()
	 */
	@Override
	public Calendar getIssueInstant() {
		final var retVal = Calendar.getInstance();
		retVal.setTimeInMillis(authnRequest.getIssueInstant().toEpochMilli());
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getIssuer()
	 */
	@Override
	public String getIssuer() {
		if (authnRequest.getIssuer() != null) {
			return authnRequest.getIssuer().getValue();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getNameIdPolicyAllowCreate()
	 */
	@Override
	public Boolean getNameIdPolicyAllowCreate() {
		if (authnRequest.getNameIDPolicy() != null) {
			return authnRequest.getNameIDPolicy().getAllowCreate();
		}
		return Boolean.FALSE;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getNameIdPolicyFormat()
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
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getProtocolBinding()
	 */
	@Override
	public String getProtocolBinding() {
		return authnRequest.getProtocolBinding();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getProviderName()
	 */
	@Override
	public String getProviderName() {
		return authnRequest.getProviderName();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequest#getSubject()
	 */
	@Override
	public SubjectType getSubject() {
		if (authnRequest.getSubject() != null) {
			return new SubjectBuilderImpl().create(authnRequest.getSubject());
		}
		return new SubjectBuilderImpl().create();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Base#getVersion()
	 */
	@Override
	public String getVersion() {
		if (authnRequest.getVersion() != null) {
			return authnRequest.getVersion().toString();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.AuthnRequest getWrappedObject() {
		return authnRequest;
	}

}
