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
package org.projecthusky.xua.authentication.impl;

import java.util.Calendar;

import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.saml2.impl.SubjectBuilderImpl;
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
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getAssertionConsumerServiceIndex()
	 */
	@Override
	public Integer getAssertionConsumerServiceIndex() {
		return authnRequest.getAssertionConsumerServiceIndex();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getAssertionConsumerServiceUrl()
	 */
	@Override
	public String getAssertionConsumerServiceUrl() {
		return authnRequest.getAssertionConsumerServiceURL();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getAttributeConsumingServiceIndex()
	 */
	@Override
	public Integer getAttributeConsumingServiceIndex() {
		return authnRequest.getAttributeConsumingServiceIndex();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getConsent()
	 */
	@Override
	public String getConsent() {
		return authnRequest.getConsent();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getDestination()
	 */
	@Override
	public String getDestination() {
		return authnRequest.getDestination();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getForceAuthn()
	 */
	@Override
	public Boolean getForceAuthn() {
		return authnRequest.isForceAuthn();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.saml2.Base#getId()
	 */
	@Override
	public String getId() {
		return authnRequest.getID();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.saml2.Base#getIssueInstant()
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
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getIssuer()
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
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getNameIdPolicyAllowCreate()
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
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getNameIdPolicyFormat()
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
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getProtocolBinding()
	 */
	@Override
	public String getProtocolBinding() {
		return authnRequest.getProtocolBinding();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getProviderName()
	 */
	@Override
	public String getProviderName() {
		return authnRequest.getProviderName();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.authentication.AuthnRequest#getSubject()
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
	 * @see org.projecthusky.xua.saml2.Base#getVersion()
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
	 * @see org.projecthusky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.AuthnRequest getWrappedObject() {
		return authnRequest;
	}

}
