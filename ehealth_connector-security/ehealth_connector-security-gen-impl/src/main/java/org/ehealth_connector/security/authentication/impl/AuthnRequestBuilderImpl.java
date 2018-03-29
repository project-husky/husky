/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.authentication.impl;

import java.util.Calendar;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.AuthnRequestBuilder;
import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.ehealth_connector.security.saml2.Subject;
import org.joda.time.DateTime;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.NameIDPolicy;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;
import org.opensaml.saml.saml2.core.impl.NameIDPolicyBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for authnrequest building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface um authnrequests bilden zu k&ooml;nnen.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AuthnRequestBuilderImpl
		implements AuthnRequestBuilder, SecurityObjectBuilder<org.opensaml.saml.saml2.core.AuthnRequest, AuthnRequest> {

	private org.opensaml.saml.saml2.core.AuthnRequest authnRequest;
	private NameIDPolicy nameIDPolicy;
	private Issuer issuer;
	private org.opensaml.saml.saml2.core.Subject subject;

	public AuthnRequestBuilderImpl() {
		final org.opensaml.saml.saml2.core.impl.AuthnRequestBuilder builder = new org.opensaml.saml.saml2.core.impl.AuthnRequestBuilder();
		authnRequest = builder.buildObject();

		final NameIDPolicyBuilder nameidpolBuilder = new NameIDPolicyBuilder();
		nameIDPolicy = nameidpolBuilder.buildObject();
		authnRequest.setNameIDPolicy(nameIDPolicy);

		final IssuerBuilder issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject();
		authnRequest.setIssuer(issuer);

	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#id(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder id(String aId) {
		if (aId != null) {
			authnRequest.setID(aId);
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#issueInstant(java.util.Calendar)
	 */
	@Override
	public AuthnRequestBuilder issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			final DateTime dateTime = new DateTime(aIssueInstant.getTimeInMillis());
			authnRequest.setIssueInstant(dateTime);
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#issuer(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder issuer(String aIssuer) {
		if (aIssuer != null) {
			issuer.setValue(aIssuer);
		}

		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#version(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder version(String aVersion) {
		if (aVersion != null) {
			authnRequest.setVersion(SAMLVersion.valueOf(aVersion));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#assertionConsumerServiceIndex(java.lang.Integer)
	 */
	@Override
	public AuthnRequestBuilder assertionConsumerServiceIndex(Integer aAssertionConsumerServiceIndex) {
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
	public AuthnRequestBuilder assertionConsumerServiceURL(String aAssertionConsumerServiceURL) {
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
	public AuthnRequestBuilder attributeConsumingServiceIndex(Integer aAttributeConsumingServiceIndex) {
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
	public AuthnRequestBuilder destination(String aDestination) {
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
	public AuthnRequestBuilder providerName(String aProviderName) {
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
	public AuthnRequestBuilder protocolBinding(String aProtocolBinding) {
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
	public AuthnRequestBuilder consent(String aConsent) {
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
	public AuthnRequestBuilder forceAuthn(Boolean aForceAuthn) {
		if (aForceAuthn != null) {
			authnRequest.setForceAuthn(aForceAuthn);
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#nameIdPolicyAllowCreate(java.lang.Boolean)
	 */
	@Override
	public AuthnRequestBuilder nameIdPolicyAllowCreate(Boolean aNameIdPolicyAllowCreate) {
		if (aNameIdPolicyAllowCreate != null) {
			nameIDPolicy.setAllowCreate(aNameIdPolicyAllowCreate);
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#nameIdPolicyFormat(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder nameIdPolicyFormat(String aNameIdPolicyFormat) {
		if (aNameIdPolicyFormat != null) {
			nameIDPolicy.setFormat(aNameIdPolicyFormat);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#subject(org.ehealth_connector.security.saml2.Subject)
	 */
	@Override
	public AuthnRequestBuilder subject(Subject aSubject) {
		authnRequest.setSubject(subject);
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthnRequestBuilder#create()
	 */
	@Override
	public AuthnRequest create() {
		return new AuthnRequestImpl(authnRequest);
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public AuthnRequest create(org.opensaml.saml.saml2.core.AuthnRequest aInternalObject) {
		return new AuthnRequestImpl(aInternalObject);
	}

}
