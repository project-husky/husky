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
package org.ehealth_connector.xua.communication.xua.impl;

import java.util.List;

import org.ehealth_connector.xua.communication.xua.AppliesTo;
import org.ehealth_connector.xua.communication.xua.RequestType;
import org.ehealth_connector.xua.communication.xua.TokenType;
import org.ehealth_connector.xua.communication.xua.XUserAssertionConstants;
import org.ehealth_connector.xua.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.hl7v3.PurposeOfUse;
import org.ehealth_connector.xua.hl7v3.Role;
import org.ehealth_connector.xua.helpers.ListXmlObjectHelper;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSAny;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.core.xml.schema.impl.XSAnyImpl;
import org.opensaml.core.xml.schema.impl.XSStringImpl;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.NameID;
import org.opensaml.saml.saml2.core.impl.AttributeImpl;
import org.opensaml.saml.saml2.core.impl.NameIDImpl;
import org.opensaml.soap.wstrust.Claims;
import org.opensaml.soap.wstrust.RequestSecurityToken;
import org.opensaml.soap.wstrust.impl.ClaimsImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XUserAssertionRequest and SecurityObject</div>
 * <div class="de">Implementations Klasse von Interface XUserAssertionRequest und SecurityObject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionRequestImpl implements XUserAssertionRequest,
		SecurityObject<org.opensaml.soap.wstrust.RequestSecurityToken> {

	private RequestSecurityToken requestSecurityToken;

	protected XUserAssertionRequestImpl(RequestSecurityToken aRequestSecurityToken) {
		requestSecurityToken = aRequestSecurityToken;
	}

	@Override
	public AppliesTo getAppliesTo() {
		final org.opensaml.soap.wspolicy.AppliesTo wspAppliesTo = new ListXmlObjectHelper<org.opensaml.soap.wspolicy.AppliesTo>()
				.getComponent(org.opensaml.soap.wspolicy.impl.AppliesToImpl.class,
						requestSecurityToken.getUnknownXMLObjects());
		return new AppliesToBuilderImpl().create(wspAppliesTo);
	}

	private Attribute getAttributeByName(List<Attribute> attributes, String aName) {
		for (final Attribute attribute : attributes) {
			if (aName.equals(attribute.getName())) {
				return attribute;
			}
		}
		return null;
	}

	private XMLObject getAttributeValueAsXmlObjectByName(List<XMLObject> unknownXMLObjects,
			String oasisXacmlSubjectid) {
		final List<Attribute> attributes = new ListXmlObjectHelper<Attribute>()
				.getComponentList(AttributeImpl.class, unknownXMLObjects);
		if (attributes != null) {
			final Attribute attribute = getAttributeByName(attributes, oasisXacmlSubjectid);
			if (attribute != null) {
				final XSAny value = new ListXmlObjectHelper<XSAny>().getComponent(XSAnyImpl.class,
						attribute.getAttributeValues());
				return value.getUnknownXMLObjects().get(0);
			}
		}
		return null;
	}

	private String getAttributeValueByName(List<XMLObject> unknownXMLObjects,
			String oasisXacmlSubjectid) {
		final List<Attribute> attributes = new ListXmlObjectHelper<Attribute>()
				.getComponentList(AttributeImpl.class, unknownXMLObjects);
		if (attributes != null) {
			final Attribute attribute = getAttributeByName(attributes, oasisXacmlSubjectid);
			if (attribute != null) {
				final XSString value = new ListXmlObjectHelper<XSString>()
						.getComponent(XSStringImpl.class, attribute.getAttributeValues());
				return value.getValue();
			}
		}
		return null;
	}

	@Override
	public String getContext() {
		return requestSecurityToken.getContext();
	}

	@Override
	public String getDialect() {
		final Claims aClaim = new ListXmlObjectHelper<Claims>().getComponent(ClaimsImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (aClaim != null) {
			return aClaim.getDialect();
		}
		return "";
	}

	@Override
	public String getOrganizationId() {
		return getAttributeValueByName(requestSecurityToken.getUnknownXMLObjects(),
				XUserAssertionConstants.OASIS_XACML_ORGANISATIONID);
	}

	@Override
	public String getOrganizationName() {
		return getAttributeValueByName(requestSecurityToken.getUnknownXMLObjects(),
				XUserAssertionConstants.OASIS_XACML_ORGANISATION);
	}

	@Override
	public PurposeOfUse getPurposeOfUse() {
		final Claims claimes = new ListXmlObjectHelper<Claims>().getComponent(ClaimsImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (claimes != null) {
			return (PurposeOfUse) getAttributeValueAsXmlObjectByName(claimes.getUnknownXMLObjects(),
					XUserAssertionConstants.OASIS_XACML_PURPOSEOFUSE);
		}
		return null;
	}

	@Override
	public RequestType getRequestType() {
		final org.opensaml.soap.wstrust.RequestType wstRequestType = new ListXmlObjectHelper<org.opensaml.soap.wstrust.RequestType>()
				.getComponent(org.opensaml.soap.wstrust.impl.RequestTypeImpl.class,
						requestSecurityToken.getUnknownXMLObjects());
		return RequestType.getEnum(wstRequestType.getValue());
	}

	@Override
	public String getResourceId() {
		final Claims claimes = new ListXmlObjectHelper<Claims>().getComponent(ClaimsImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (claimes != null) {
			return getAttributeValueByName(claimes.getUnknownXMLObjects(),
					XUserAssertionConstants.OASIS_XACML_RESOURCEID);
		}
		return "";
	}

	@Override
	public String getSubjectId() {
		final NameID nameId = new ListXmlObjectHelper<NameID>().getComponent(NameIDImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (nameId != null) {
			return nameId.getValue();
		}
		return "";
	}

	@Override
	public String getSubjectName() {
		return getAttributeValueByName(requestSecurityToken.getUnknownXMLObjects(),
				XUserAssertionConstants.OASIS_XACML_SUBJECTID);
	}

	@Override
	public Role getSubjectRole() {
		final Claims claimes = new ListXmlObjectHelper<Claims>().getComponent(ClaimsImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (claimes != null) {
			return (Role) getAttributeValueAsXmlObjectByName(claimes.getUnknownXMLObjects(),
					XUserAssertionConstants.OASIS_XACML_ROLE);
		}
		return null;
	}

	@Override
	public TokenType getTokenType() {
		final org.opensaml.soap.wstrust.TokenType wstRequestType = new ListXmlObjectHelper<org.opensaml.soap.wstrust.TokenType>()
				.getComponent(org.opensaml.soap.wstrust.impl.TokenTypeImpl.class,
						requestSecurityToken.getUnknownXMLObjects());
		return TokenType.getEnum(wstRequestType.getValue());
	}

	@Override
	public RequestSecurityToken getWrappedObject() {
		return requestSecurityToken;
	}

}
