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

import org.projecthusky.xua.communication.xua.AppliesTo;
import org.projecthusky.xua.communication.xua.RequestType;
import org.projecthusky.xua.communication.xua.TokenType;
import org.projecthusky.xua.communication.xua.XUserAssertionConstants;
import org.projecthusky.xua.communication.xua.XUserAssertionRequest;
import org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.hl7v3.CE;
import org.projecthusky.xua.hl7v3.impl.CodedWithEquivalentImpl;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSAny;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.core.xml.schema.impl.XSAnyBuilder;
import org.opensaml.core.xml.schema.impl.XSStringBuilder;
import org.opensaml.saml.saml2.core.Attribute;
import org.opensaml.saml.saml2.core.AttributeValue;
import org.opensaml.saml.saml2.core.NameID;
import org.opensaml.saml.saml2.core.impl.AttributeBuilder;
import org.opensaml.saml.saml2.core.impl.NameIDBuilder;
import org.opensaml.soap.wstrust.Claims;
import org.opensaml.soap.wstrust.RequestSecurityToken;
import org.opensaml.soap.wstrust.impl.ClaimsBuilder;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenBuilder;
import org.opensaml.soap.wstrust.impl.RequestTypeBuilder;
import org.opensaml.soap.wstrust.impl.TokenTypeBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for XUserAssertionRequest building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um XUserAssertionRequests bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionRequestBuilderImpl implements XUserAssertionRequestBuilder,
		SecurityObjectBuilder<RequestSecurityToken, XUserAssertionRequest> {

	private Claims claims;
	private RequestSecurityToken requestSecurityToken;

	public XUserAssertionRequestBuilderImpl() {
		requestSecurityToken = new RequestSecurityTokenBuilder().buildObject();
		claims = new ClaimsBuilder().buildObject();
		addXMLObject(claims);
	}

	protected void addXMLObject(XMLObject aXmlObject) {
		requestSecurityToken.getUnknownXMLObjects().add(aXmlObject);
	}

	protected void addXMLObjectToClaims(XMLObject aXmlObject) {
		claims.getUnknownXMLObjects().add(aXmlObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#appliesTo(org.projecthusky.xua.communication.xua.AppliesTo)
	 */
	@Override
	public XUserAssertionRequestBuilder appliesTo(AppliesTo appliesTo) {
		if (appliesTo != null) {
			addXMLObject(((AppliesToImpl) appliesTo).getWrappedObject());
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#context(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder context(String aContext) {
		if (aContext != null) {
			requestSecurityToken.setContext(aContext);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#create()
	 */
	@Override
	public XUserAssertionRequest create() {
		return new XUserAssertionRequestImpl(requestSecurityToken);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public XUserAssertionRequest create(RequestSecurityToken aInternalObject) {
		return new XUserAssertionRequestImpl(aInternalObject);
	}

	protected XMLObject createObjectAttribute(String aName, XMLObject hl7PurposeOfUse) {
		final var attribute = new AttributeBuilder().buildObject();
		attribute.setName(aName);
		final var anyBuilder = new XSAnyBuilder();
		final XSAny any = anyBuilder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME);
		any.getUnknownXMLObjects().add(hl7PurposeOfUse);
		attribute.getAttributeValues().add(any);
		return attribute;
	}

	protected Attribute createStringAttribute(String aName, String aValue) {
		final var attribute = new AttributeBuilder().buildObject();
		attribute.setName(aName);

		final var stringBuilder = new XSStringBuilder();
		final XSString attributeValue = stringBuilder
				.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, XSString.TYPE_NAME);
		attributeValue.setValue(aValue);
		attribute.getAttributeValues().add(attributeValue);
		return attribute;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#dialect(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder dialect(String aDialect) {
		if (aDialect != null) {
			claims.setDialect(aDialect);
		}
		return this;
	}

	protected Claims getClaims() {
		return claims;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#organizationId(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder organizationId(String organizationId) {
		if (organizationId != null) {
			addXMLObject(createStringAttribute(XUserAssertionConstants.OASIS_XACML_ORGANIZATIONID,
					organizationId));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#organizationName(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder organizationName(String organizationName) {
		if (organizationName != null) {
			addXMLObject(createStringAttribute(XUserAssertionConstants.OASIS_XACML_ORGANISATION,
					organizationName));
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#purposeOfUse(org.projecthusky.xua.hl7v3.PurposeOfUse)
	 */
	@Override
	public XUserAssertionRequestBuilder purposeOfUse(CE purposeOfUse) {
		if (purposeOfUse != null) {
			addXMLObjectToClaims(
					createObjectAttribute(XUserAssertionConstants.OASIS_XACML_PURPOSEOFUSE,
							(CodedWithEquivalentImpl) purposeOfUse));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#requestType(org.projecthusky.xua.communication.xua.RequestType)
	 */
	@Override
	public XUserAssertionRequestBuilder requestType(RequestType requestType) {
		if (requestType != null) {
			final var wstRequestType = new RequestTypeBuilder()
					.buildObject();
			wstRequestType.setURI(requestType.toString());
			addXMLObject(wstRequestType);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#resourceId(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder resourceId(String resourceId) {
		if (resourceId != null) {
			addXMLObjectToClaims(createStringAttribute(
					XUserAssertionConstants.OASIS_XACML_RESOURCEID, resourceId));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#subjectId(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder subjectId(String subjectId) {
		if (subjectId != null) {
			final NameID id = new NameIDBuilder().buildObject();
			id.setValue(subjectId);
			addXMLObject(id);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#subjectName(java.lang.String)
	 */
	@Override
	public XUserAssertionRequestBuilder subjectName(String subjectName) {
		if (subjectName != null) {
			addXMLObject(createStringAttribute(XUserAssertionConstants.OASIS_XACML_SUBJECTID,
					subjectName));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#subjectRole(org.projecthusky.xua.hl7v3.Role)
	 */
	@Override
	public XUserAssertionRequestBuilder subjectRole(CE aRole) {
		if (aRole != null) {
			addXMLObjectToClaims(createObjectAttribute(XUserAssertionConstants.OASIS_XACML_ROLE,
					(CodedWithEquivalentImpl) aRole));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.XUserAssertionRequestBuilder#tokenType(org.projecthusky.xua.communication.xua.TokenType)
	 */
	@Override
	public XUserAssertionRequestBuilder tokenType(TokenType tokenType) {
		if (tokenType != null) {
			final org.opensaml.soap.wstrust.TokenType wstTokeType = new TokenTypeBuilder()
					.buildObject();
			wstTokeType.setURI(tokenType.toString());
			addXMLObject(wstTokeType);
		}
		return this;
	}

}
