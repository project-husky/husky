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
import org.ehealth_connector.security.authentication.AuthnRequestBuilder;
import org.joda.time.DateTime;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.NameIDPolicy;
import org.opensaml.saml2.core.impl.IssuerBuilder;
import org.opensaml.saml2.core.impl.NameIDPolicyBuilder;

/**
 * @since Feb 20, 2018 11:38:39 AM
 *
 */
public class AuthnRequestBuilderImpl implements AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> {

	private org.opensaml.saml2.core.AuthnRequest authnRequest;
	private NameIDPolicy nameIDPolicy;
	private Issuer issuer;

	public AuthnRequestBuilderImpl() {
		final org.opensaml.saml2.core.impl.AuthnRequestBuilder builder = new org.opensaml.saml2.core.impl.AuthnRequestBuilder();
		authnRequest = builder.buildObject();

		final NameIDPolicyBuilder nameidpolBuilder = new NameIDPolicyBuilder();
		nameIDPolicy = nameidpolBuilder.buildObject();
		authnRequest.setNameIDPolicy(nameIDPolicy);

		final IssuerBuilder issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject(Issuer.DEFAULT_ELEMENT_NAME);
		authnRequest.setIssuer(issuer);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#id(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> id(String aId) {
		if (aId != null) {
			authnRequest.setID(aId);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#issueInstant(java.util.Calendar)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			final DateTime dateTime = new DateTime(aIssueInstant.getTimeInMillis());
			authnRequest.setIssueInstant(dateTime);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#assertionConsumerServiceIndex(java.lang.Integer)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> assertionConsumerServiceIndex(
			Integer aAssertionConsumerServiceIndex) {
		if (aAssertionConsumerServiceIndex != null) {
			authnRequest.setAssertionConsumerServiceIndex(aAssertionConsumerServiceIndex);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#assertionConsumerServiceURL(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> assertionConsumerServiceURL(
			String aAssertionConsumerServiceURL) {
		if (aAssertionConsumerServiceURL != null) {
			authnRequest.setAssertionConsumerServiceURL(aAssertionConsumerServiceURL);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#attributeConsumingServiceIndex(java.lang.Integer)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> attributeConsumingServiceIndex(
			Integer aAttributeConsumingServiceIndex) {
		if (aAttributeConsumingServiceIndex != null) {
			authnRequest.setAttributeConsumingServiceIndex(aAttributeConsumingServiceIndex);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#destination(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> destination(String aDestination) {
		if (aDestination != null) {
			authnRequest.setDestination(aDestination);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#providerName(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> providerName(String aProviderName) {
		if (aProviderName != null) {
			authnRequest.setProviderName(aProviderName);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#protocolBinding(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> protocolBinding(String aProtocolBinding) {
		if (aProtocolBinding != null) {
			authnRequest.setProtocolBinding(aProtocolBinding);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#consent(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> consent(String aConsent) {
		if (aConsent != null) {
			authnRequest.setConsent(aConsent);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#forceAuthn(java.lang.Boolean)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> forceAuthn(Boolean aForceAuthn) {
		if (aForceAuthn != null) {
			authnRequest.setForceAuthn(aForceAuthn);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#issuer(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> issuer(String aIssuer) {
		if (aIssuer != null) {
			issuer.setValue(aIssuer);
		}

		return this;
	}

	/**
	 * // addSignature(authnRequest); {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#nameIdPolicyAllowCreate(boolean)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> nameIdPolicyAllowCreate(
			Boolean aNameIdPolicyAllowCreate) {
		if (aNameIdPolicyAllowCreate != null) {
			nameIDPolicy.setAllowCreate(aNameIdPolicyAllowCreate);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#nameIdPolicyFormat(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder<org.opensaml.saml2.core.AuthnRequest> nameIdPolicyFormat(String aNameIdPolicyFormat) {
		if (aNameIdPolicyFormat != null) {
			nameIDPolicy.setFormat(aNameIdPolicyFormat);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#createAuthnRequest()
	 */
	@Override
	public AuthnRequest<org.opensaml.saml2.core.AuthnRequest> createAuthnRequest() {
		return new AuthnRequestImpl(authnRequest);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#createAuthnRequest(java.lang.Object)
	 */
	@Override
	public AuthnRequest<org.opensaml.saml2.core.AuthnRequest> createAuthnRequest(
			org.opensaml.saml2.core.AuthnRequest aInternalObject) {
		return new AuthnRequestImpl(aInternalObject);
	}

}
