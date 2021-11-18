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
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.PurposeOfUse;
import org.husky.xua.hl7v3.Role;
import org.husky.xua.hl7v3.impl.InstanceIdentifierImpl;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;
import org.husky.xua.hl7v3.impl.PurposeOfUseImpl;
import org.husky.xua.hl7v3.impl.RoleImpl;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.core.xml.schema.impl.XSStringImpl;
import org.opensaml.saml.saml2.core.impl.AttributeBuilder;
import org.opensaml.saml.saml2.core.impl.AttributeValueImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Attribute</div>
 * <div class="de">Implementations Klasse von Attribute</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AttributeImpl
		extends AttributeType implements SecurityObject<org.opensaml.saml.saml2.core.Attribute> {

	private org.opensaml.saml.saml2.core.Attribute attribute;

	/**
	 *
	 * Default constructor to instanciate the object
	 *
	 * @param aAttribute
	 */
	protected AttributeImpl(org.opensaml.saml.saml2.core.Attribute aAttribute) {
		attribute = aAttribute;
	}

	/**
	 *
	 * Default constructor to instanciate the object
	 *
	 * @param aAttribute
	 */
	protected AttributeImpl(AttributeType aAttribute) {
		attribute = new AttributeBuilder().buildObject();
		attribute.setFriendlyName(aAttribute.getFriendlyName());
		attribute.setName(aAttribute.getName());
		attribute.setNameFormat(aAttribute.getNameFormat());

		for (Object obj : aAttribute.getAttributeValue()) {
			if (obj instanceof org.openehealth.ipf.commons.audit.types.PurposeOfUse.PurposeOfUseImpl) {
				var purposeOfUse = (org.openehealth.ipf.commons.audit.types.PurposeOfUse.PurposeOfUseImpl) obj;
				var retVal = new PurposeOfUseBuilder().buildObject();
				retVal.setCode(purposeOfUse.getCode());
				retVal.setCodeSystemName(purposeOfUse.getCodeSystemName());
				retVal.setDisplayName(purposeOfUse.getDisplayName());
				attribute.getAttributeValues().add(retVal);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Attribute#getFriendlyName()
	 */
	@Override
	public String getFriendlyName() {
		this.friendlyName = attribute.getFriendlyName();
		return attribute.getFriendlyName();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Attribute#getName()
	 */
	@Override
	public String getName() {
		this.name = attribute.getName();
		return attribute.getName();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Attribute#getNameFormat()
	 */
	@Override
	public String getNameFormat() {
		this.nameFormat = attribute.getNameFormat();
		return attribute.getNameFormat();
	}

	public InstanceIdentifier getValueAsInstanceIdentifier() {
		if (isValueAInstanceIdentifier()) {
			var instanceIdentifier = (InstanceIdentifierImpl) ((AttributeValueImpl) attribute.getAttributeValues()
					.get(0)).getUnknownXMLObjects().get(0);
			getAttributeValue().add(instanceIdentifier);
			return instanceIdentifier;
		}
		return null;
	}

	public PurposeOfUse getValueAsPurposeOfUse() {
		if (isValueAPurposeOfUse()) {
			var purposeOfUse = (PurposeOfUseImpl) ((AttributeValueImpl) attribute.getAttributeValues().get(0))
					.getUnknownXMLObjects().get(0);
			getAttributeValue().add(purposeOfUse);
			return purposeOfUse;
		}
		return null;
	}

	public Role getValueAsRole() {
		if (isValueARole()) {
			var role = (RoleImpl) ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects()
					.get(0);
			getAttributeValue().add(role);
			return role;
		}
		return null;
	}

	public String getValueAsString() {
		if (isValueAString()) {
			final XSString attributeValue = (XSStringImpl) attribute.getAttributeValues().get(0);
			getAttributeValue().add(attributeValue);
			return attributeValue.getValue();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Attribute getWrappedObject() {
		return attribute;
	}

	public boolean isValueAInstanceIdentifier() {
		return (attribute.getAttributeValues() != null) //
				&& (!attribute.getAttributeValues().isEmpty()) //
				&& attribute.getAttributeValues().get(0) instanceof AttributeValueImpl
				&& ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects() != null
				&& !((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects().isEmpty()
				&& ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects()
						.get(0) instanceof InstanceIdentifierImpl;
	}

	public boolean isValueAPurposeOfUse() {
		return (attribute.getAttributeValues() != null) //
				&& (!attribute.getAttributeValues().isEmpty()) //
				&& attribute.getAttributeValues().get(0) instanceof AttributeValueImpl
				&& ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects() != null
				&& !((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects().isEmpty()
				&& ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects()
						.get(0) instanceof PurposeOfUseImpl;
	}

	public boolean isValueARole() {
		return (attribute.getAttributeValues() != null) //
				&& (!attribute.getAttributeValues().isEmpty()) //
				&& attribute.getAttributeValues().get(0) instanceof AttributeValueImpl
				&& ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects() != null
				&& !((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects().isEmpty()
				&& ((AttributeValueImpl) attribute.getAttributeValues().get(0)).getUnknownXMLObjects()
						.get(0) instanceof RoleImpl;
	}

	public boolean isValueAString() {
		return (attribute.getAttributeValues() != null) //
				&& (!attribute.getAttributeValues().isEmpty()) //
				&& attribute.getAttributeValues().get(0) instanceof XSStringImpl
				&& ((XSStringImpl) attribute.getAttributeValues().get(0)).getValue() != null;
	}

}
