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
package org.husky.communication.ch.ppq.impl;

import java.util.Calendar;

import org.husky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.husky.xua.core.SecurityObject;
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.xacml.ctx.AttributeType;
import org.opensaml.xacml.ctx.AttributeValueType;
import org.opensaml.xacml.ctx.RequestType;
import org.opensaml.xacml.ctx.ResourceType;
import org.opensaml.xacml.profile.saml.XACMLPolicyQueryType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PatientPrivacyQuery.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface PatientPrivacyQuery.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyQueryImpl
		implements PrivacyPolicyQuery, SecurityObject<XACMLPolicyQueryType> {

	private XACMLPolicyQueryType internalObject;

	protected PrivacyPolicyQueryImpl(XACMLPolicyQueryType aInternalObject) {
		internalObject = aInternalObject;
	}

	@Override
	public String getConsent() {
		if (internalObject.getConsent() != null) {
			return internalObject.getConsent();
		}
		return "";
	}

	@Override
	public String getDestination() {
		return internalObject.getDestination();
	}

	@Override
	public String getId() {
		return internalObject.getID();
	}

	@Override
	public InstanceIdentifier getInstanceIdentifier() {
		for (final RequestType request : internalObject.getRequests()) {
			for (final ResourceType resource : request.getResources()) {
				for (final AttributeType attribute : resource.getAttributes()) {
					var instanceIdent = extractEprSpidFromAttributes(attribute);

					if (instanceIdent != null) {
						return instanceIdent;
					}
				}
			}
		}
		return null;
	}

	private InstanceIdentifier extractEprSpidFromAttributes(AttributeType attribute) {
		if ("urn:e-health-suisse:2015:epr-spid".equalsIgnoreCase(attribute.getAttributeId())) {
			for (final AttributeValueType attVal : attribute.getAttributeValues()) {
				for (final XMLObject value : attVal.getUnknownXMLObjects()) {
					if (value instanceof InstanceIdentifier retVal) {
						return retVal;
					}
				}

			}
		}

		return null;
	}

	@Override
	public Calendar getIssueInstant() {
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(internalObject.getIssueInstant().toEpochMilli());
		return retVal;
	}

	@Override
	public String getIssuer() {
		return internalObject.getIssuer().getValue();

	}

	@Override
	public String getVersion() {
		if (internalObject.getVersion() != null) {
			return internalObject.getVersion().toString();
		}
		return "";
	}

	@Override
	public XACMLPolicyQueryType getWrappedObject() {
		return internalObject;
	}

}
