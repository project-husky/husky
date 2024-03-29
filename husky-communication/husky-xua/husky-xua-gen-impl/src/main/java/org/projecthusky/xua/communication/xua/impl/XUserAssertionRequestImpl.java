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
package org.projecthusky.xua.communication.xua.impl;

import java.util.List;

import org.projecthusky.xua.communication.xua.AppliesTo;
import org.projecthusky.xua.communication.xua.RequestType;
import org.projecthusky.xua.communication.xua.TokenType;
import org.projecthusky.xua.communication.xua.XUserAssertionConstants;
import org.projecthusky.xua.communication.xua.XUserAssertionRequest;
import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.helpers.ListXmlObjectHelper;
import org.projecthusky.xua.hl7v3.CE;
import org.projecthusky.xua.hl7v3.OpenSamlCodedWithEquivalent;
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
		final var wspAppliesTo = new ListXmlObjectHelper<org.opensaml.soap.wspolicy.AppliesTo>()
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
			final var attribute = getAttributeByName(attributes, oasisXacmlSubjectid);
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
			final var attribute = getAttributeByName(attributes, oasisXacmlSubjectid);
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
				XUserAssertionConstants.OASIS_XACML_ORGANIZATIONID);
	}

	@Override
	public String getOrganizationName() {
		return getAttributeValueByName(requestSecurityToken.getUnknownXMLObjects(),
				XUserAssertionConstants.OASIS_XACML_ORGANISATION);
	}

	@Override
	public CE getPurposeOfUse() {
		final Claims claimes = new ListXmlObjectHelper<Claims>().getComponent(ClaimsImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (claimes != null) {
			return (OpenSamlCodedWithEquivalent) getAttributeValueAsXmlObjectByName(claimes.getUnknownXMLObjects(),
					XUserAssertionConstants.OASIS_XACML_PURPOSEOFUSE);
		}
		return null;
	}

	@Override
	public RequestType getRequestType() {
		final var wstRequestType = new ListXmlObjectHelper<org.opensaml.soap.wstrust.RequestType>()
				.getComponent(org.opensaml.soap.wstrust.impl.RequestTypeImpl.class,
						requestSecurityToken.getUnknownXMLObjects());
		return RequestType.getEnum(wstRequestType.getURI());
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
		final var nameId = new ListXmlObjectHelper<NameID>().getComponent(NameIDImpl.class,
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
	public CE getSubjectRole() {
		final Claims claimes = new ListXmlObjectHelper<Claims>().getComponent(ClaimsImpl.class,
				requestSecurityToken.getUnknownXMLObjects());
		if (claimes != null) {
			return (OpenSamlCodedWithEquivalent) getAttributeValueAsXmlObjectByName(claimes.getUnknownXMLObjects(),
					XUserAssertionConstants.OASIS_XACML_ROLE);
		}
		return null;
	}

	@Override
	public TokenType getTokenType() {
		final org.opensaml.soap.wstrust.TokenType wstRequestType = new ListXmlObjectHelper<org.opensaml.soap.wstrust.TokenType>()
				.getComponent(org.opensaml.soap.wstrust.impl.TokenTypeImpl.class,
						requestSecurityToken.getUnknownXMLObjects());
		return TokenType.getEnum(wstRequestType.getURI());
	}

	@Override
	public RequestSecurityToken getWrappedObject() {
		return requestSecurityToken;
	}

}
