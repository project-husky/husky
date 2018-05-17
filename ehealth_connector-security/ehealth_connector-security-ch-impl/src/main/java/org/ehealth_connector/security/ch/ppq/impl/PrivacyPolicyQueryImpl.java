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
package org.ehealth_connector.security.ch.ppq.impl;

import java.util.Calendar;

import org.ehealth_connector.security.ch.ppq.PrivacyPolicyQuery;
import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.hl7v3.InstanceIdentifier;
import org.joda.time.DateTime;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.xacml.ctx.AttributeType;
import org.opensaml.xacml.ctx.AttributeValueType;
import org.opensaml.xacml.ctx.RequestType;
import org.opensaml.xacml.ctx.ResourceType;
import org.opensaml.xacml.profile.saml.XACMLPolicyQueryType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PatientPrivacyQuery.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface PatientPrivacyQuery.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyQueryImpl implements PrivacyPolicyQuery, SecurityObject<XACMLPolicyQueryType> {

	private XACMLPolicyQueryType internalObject;

	protected PrivacyPolicyQueryImpl(XACMLPolicyQueryType aInternalObject) {
		internalObject = aInternalObject;
	}

	@Override
	public String getId() {
		return internalObject.getID();
	}

	@Override
	public Calendar getIssueInstant() {
		final DateTime instant = internalObject.getIssueInstant();
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(instant.getMillis());
		return retVal;
	}

	@Override
	public String getIssuer() {
		return internalObject.getIssuer().getValue();

	}

	@Override
	public String getDestination() {
		return internalObject.getDestination();
	}

	@Override
	public String getConsent() {
		if (internalObject.getConsent() != null) {
			return internalObject.getConsent();
		}
		return "";
	}

	@Override
	public String getVersion() {
		if (internalObject.getVersion() != null) {
			return internalObject.getVersion().toString();
		}
		return "";
	}

	@Override
	public InstanceIdentifier getInstanceIdentifier() {
		for (final RequestType request : internalObject.getRequests()) {
			for (final ResourceType resource : request.getResources()) {
				for (final AttributeType attribute : resource.getAttributes()) {
					if ("urn:e-health-suisse:2015:epr-spid".equalsIgnoreCase(attribute.getAttributeId())) {
						for (final AttributeValueType attVal : attribute.getAttributeValues()) {
							for (final XMLObject value : attVal.getUnknownXMLObjects()) {
								if (value instanceof InstanceIdentifier) {
									final InstanceIdentifier retVal = (InstanceIdentifier) value;
									return retVal;
								}
							}

						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public XACMLPolicyQueryType getWrappedObject() {
		return internalObject;
	}

}
