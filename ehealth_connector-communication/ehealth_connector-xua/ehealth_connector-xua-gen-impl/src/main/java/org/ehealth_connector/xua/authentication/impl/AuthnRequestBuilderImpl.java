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

import org.apache.commons.lang.StringUtils;
import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.Subject;
import org.ehealth_connector.xua.authentication.AuthnRequest;
import org.ehealth_connector.xua.authentication.AuthnRequestBuilder;
import org.joda.time.DateTime;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.IDPEntry;
import org.opensaml.saml.saml2.core.IDPList;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.NameIDPolicy;
import org.opensaml.saml.saml2.core.Scoping;
import org.opensaml.saml.saml2.core.impl.IDPEntryBuilder;
import org.opensaml.saml.saml2.core.impl.IDPListBuilder;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;
import org.opensaml.saml.saml2.core.impl.NameIDPolicyBuilder;
import org.opensaml.saml.saml2.core.impl.ScopingBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for authnrequest building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um authnrequests bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AuthnRequestBuilderImpl implements AuthnRequestBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.AuthnRequest, AuthnRequest> {

	/** The AuthnRequest. */
	private org.opensaml.saml.saml2.core.AuthnRequest authnRequest;

	/** The list of IdPs. */
	private IDPList idpList;

	/** The issuer. */
	private Issuer issuer;

	/** The name id policy. */
	private NameIDPolicy nameIdPolicy;

	/** The subject. */
	private org.opensaml.saml.saml2.core.Subject subject;

	/**
	 * Instantiates a new AuthnRequestBuilderImpl.
	 */
	public AuthnRequestBuilderImpl() {
		final var builder = new org.opensaml.saml.saml2.core.impl.AuthnRequestBuilder();
		authnRequest = builder.buildObject();

		final var nameidpolBuilder = new NameIDPolicyBuilder();
		nameIdPolicy = nameidpolBuilder.buildObject();
		authnRequest.setNameIDPolicy(nameIdPolicy);

		final var issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject();
		authnRequest.setIssuer(issuer);

		final var scoping = new ScopingBuilder().buildObject();
		idpList = new IDPListBuilder().buildObject();
		scoping.setIDPList(idpList);
		authnRequest.setScoping(scoping);

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#assertionConsumerServiceIndex(java.lang.Integer)
	 */
	@Override
	public AuthnRequestBuilder assertionConsumerServiceIndex(
			Integer aAssertionConsumerServiceIndex) {
		if (aAssertionConsumerServiceIndex != null) {
			authnRequest.setAssertionConsumerServiceIndex(aAssertionConsumerServiceIndex);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#assertionConsumerServiceUrl(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder assertionConsumerServiceUrl(String aAssertionConsumerServiceURL) {
		if (!StringUtils.isEmpty(aAssertionConsumerServiceURL)) {
			authnRequest.setAssertionConsumerServiceURL(aAssertionConsumerServiceURL);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#attributeConsumingServiceIndex(java.lang.Integer)
	 */
	@Override
	public AuthnRequestBuilder attributeConsumingServiceIndex(
			Integer aAttributeConsumingServiceIndex) {
		if (aAttributeConsumingServiceIndex != null) {
			authnRequest.setAttributeConsumingServiceIndex(aAttributeConsumingServiceIndex);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#consent(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder consent(String aConsent) {
		if (!StringUtils.isEmpty(aConsent)) {
			authnRequest.setConsent(aConsent);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#create()
	 */
	@Override
	public AuthnRequest create() {
		return new AuthnRequestImpl(authnRequest);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public AuthnRequest create(org.opensaml.saml.saml2.core.AuthnRequest aInternalObject) {
		return new AuthnRequestImpl(aInternalObject);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#destination(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder destination(String aDestination) {
		if (!StringUtils.isEmpty(aDestination)) {
			authnRequest.setDestination(aDestination);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#forceAuthn(java.lang.Boolean)
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
	 * @see org.ehealth_connector.xua.saml2.BaseBuilder#id(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder id(String aId) {
		if (!StringUtils.isEmpty(aId)) {
			authnRequest.setID(aId);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.BaseBuilder#issueInstant(java.util.Calendar)
	 */
	@Override
	public AuthnRequestBuilder issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			final var dateTime = new DateTime(aIssueInstant.getTimeInMillis());
			authnRequest.setIssueInstant(dateTime);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.BaseBuilder#issuer(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder issuer(String aIssuer) {
		if (!StringUtils.isEmpty(aIssuer)) {
			issuer.setValue(aIssuer);
		}

		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#nameIdPolicyAllowCreate(java.lang.Boolean)
	 */
	@Override
	public AuthnRequestBuilder nameIdPolicyAllowCreate(Boolean aNameIdPolicyAllowCreate) {
		if (aNameIdPolicyAllowCreate != null) {
			nameIdPolicy.setAllowCreate(aNameIdPolicyAllowCreate);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#nameIdPolicyFormat(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder nameIdPolicyFormat(String aNameIdPolicyFormat) {
		if (!StringUtils.isEmpty(aNameIdPolicyFormat)) {
			nameIdPolicy.setFormat(aNameIdPolicyFormat);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#protocolBinding(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder protocolBinding(String aProtocolBinding) {
		if (!StringUtils.isEmpty(aProtocolBinding)) {
			authnRequest.setProtocolBinding(aProtocolBinding);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#providerId(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder providerId(String aProviderID) {
		if (!StringUtils.isEmpty(aProviderID)) {
			final var idpEntry = new IDPEntryBuilder().buildObject();
			idpEntry.setProviderID(aProviderID);
			idpList.getIDPEntrys().add(idpEntry);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#providerName(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder providerName(String aProviderName) {
		if (!StringUtils.isEmpty(aProviderName)) {
			authnRequest.setProviderName(aProviderName);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.authentication.AuthnRequestBuilder#subject(org.ehealth_connector.xua.saml2.Subject)
	 */
	@Override
	public AuthnRequestBuilder subject(Subject aSubject) {
		if (aSubject != null) {
			authnRequest.setSubject(subject);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.BaseBuilder#version(java.lang.String)
	 */
	@Override
	public AuthnRequestBuilder version(String aVersion) {
		if (!StringUtils.isEmpty(aVersion)) {
			authnRequest.setVersion(SAMLVersion.valueOf(aVersion));
		}
		return this;
	}

}
