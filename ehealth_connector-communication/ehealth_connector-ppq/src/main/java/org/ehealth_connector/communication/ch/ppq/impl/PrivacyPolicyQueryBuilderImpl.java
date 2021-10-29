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
package org.ehealth_connector.communication.ch.ppq.impl;

import java.util.Calendar;

import org.ehealth_connector.common.ch.ChEpr;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryBuilder;
import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.hl7v3.InstanceIdentifier;
import org.ehealth_connector.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;
import org.opensaml.xacml.ctx.AttributeType;
import org.opensaml.xacml.ctx.AttributeValueType;
import org.opensaml.xacml.ctx.RequestType;
import org.opensaml.xacml.ctx.ResourceType;
import org.opensaml.xacml.ctx.impl.AttributeTypeImplBuilder;
import org.opensaml.xacml.ctx.impl.AttributeValueTypeImplBuilder;
import org.opensaml.xacml.profile.saml.XACMLPolicyQueryType;
import org.opensaml.xacml.profile.saml.impl.XACMLPolicyQueryTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PatientPrivacyQuery building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um PatientPrivacyQuery bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyQueryBuilderImpl implements PrivacyPolicyQueryBuilder,
		SecurityObjectBuilder<XACMLPolicyQueryType, PrivacyPolicyQuery> {

	private org.opensaml.saml.saml2.core.Issuer issuer;
	private RequestType request;
	private ResourceType resource;
	private XACMLPolicyQueryType wrappedObject;

	public PrivacyPolicyQueryBuilderImpl() {
		wrappedObject = new XACMLPolicyQueryTypeImplBuilder().buildObject(
				"urn:oasis:names:tc:xacml:2.0:profile:saml2.0:v2:schema:protocol", "XACMLPolicyQuery", "xacml-samlp");
		final var issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject(Issuer.DEFAULT_ELEMENT_NAME);
		wrappedObject.setIssuer(issuer);

		request = new org.opensaml.xacml.ctx.impl.RequestTypeImplBuilder().buildObject();
		resource = new org.opensaml.xacml.ctx.impl.ResourceTypeImplBuilder().buildObject();
		request.getResources().add(resource);
		wrappedObject.getRequests().add(request);
	}

	@Override
	public PrivacyPolicyQueryBuilder consent(String aConsent) {
		if (aConsent != null) {
			wrappedObject.setConsent(aConsent);
		}
		return this;
	}

	@Override
	public PrivacyPolicyQuery create() {
		return new PrivacyPolicyQueryImpl(wrappedObject);
	}

	@Override
	public PrivacyPolicyQuery create(XACMLPolicyQueryType aInternalObject) {
		return new PrivacyPolicyQueryImpl(aInternalObject);
	}

	@Override
	public PrivacyPolicyQueryBuilder destination(String aDestination) {
		if (aDestination != null) {
			wrappedObject.setDestination(aDestination);
		}
		return this;
	}

	@Override
	public PrivacyPolicyQueryBuilder id(String aId) {
		if (aId != null) {
			wrappedObject.setID(aId);
		}
		return this;
	}

	@Override
	public PrivacyPolicyQueryBuilder instanceIdentifier(InstanceIdentifier identifier) {

		final AttributeType attribute = new AttributeTypeImplBuilder().buildObject();
		attribute.setAttributeID(ChEpr.EPR_SPID_URN);
		attribute.setDataType("urn:hl7-org:v3#II");

		final AttributeValueType attributeValue = new AttributeValueTypeImplBuilder().buildObject();
		attribute.getAttributeValues().add(attributeValue);

		attributeValue.getUnknownXMLObjects().add((OpenSamlInstanceIdentifier) identifier);

		resource.getAttributes().add(attribute);
		return this;
	}

	@Override
	public PrivacyPolicyQueryBuilder issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			wrappedObject.setIssueInstant(aIssueInstant.toInstant());
		}
		return this;
	}

	@Override
	public PrivacyPolicyQueryBuilder issuer(String aIssuer) {
		if (aIssuer != null) {
			issuer.setValue(aIssuer);
		}
		return this;
	}

	@Override
	public PrivacyPolicyQueryBuilder version(String aVersion) {
		if (aVersion != null) {
			wrappedObject.setVersion(SAMLVersion.valueOf(aVersion));
		}
		return this;
	}

}
