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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.hl7v3.InstanceIdentifier;
import org.ehealth_connector.xua.hl7v3.PurposeOfUse;
import org.ehealth_connector.xua.hl7v3.Role;
import org.ehealth_connector.xua.saml2.Attribute;
import org.opensaml.core.xml.schema.XSString;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Attribute</div>
 * <div class="de">Implementations Klasse von Attribute</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AttributeImpl
		implements Attribute, SecurityObject<org.opensaml.saml.saml2.core.Attribute> {

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
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Attribute#getFriendlyName()
	 */
	@Override
	public String getFriendlyName() {
		return attribute.getFriendlyName();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Attribute#getName()
	 */
	@Override
	public String getName() {
		return attribute.getName();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Attribute#getNameFormat()
	 */
	@Override
	public String getNameFormat() {
		return attribute.getNameFormat();
	}

	@Override
	public InstanceIdentifier getValueAsInstanceIdentifier() {
		if (isValueAInstanceIdentifier()) {
			final InstanceIdentifier attributeValue = (InstanceIdentifier) attribute
					.getAttributeValues().get(0);
			return attributeValue;
		}
		return null;
	}

	@Override
	public PurposeOfUse getValueAsPurposeOfUse() {
		if (isValueAPurposeOfUse()) {
			final PurposeOfUse attributeValue = (PurposeOfUse) attribute.getAttributeValues()
					.get(0);
			return attributeValue;
		}
		return null;
	}

	@Override
	public Role getValueAsRole() {
		if (isValueARole()) {
			final Role attributeValue = (Role) attribute.getAttributeValues().get(0);
			return attributeValue;
		}
		return null;
	}

	@Override
	public String getValueAsString() {
		if (isValueAString()) {
			final XSString attributeValue = (XSString) attribute.getAttributeValues().get(0);
			return attributeValue.getValue();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Attribute getWrappedObject() {
		return attribute;
	}

	@Override
	public boolean isValueAInstanceIdentifier() {
		return (attribute.getAttributeValues() != null) //
				&& (attribute.getAttributeValues().size() > 0) //
				&& (attribute.getAttributeValues().get(0) instanceof InstanceIdentifier);
	}

	@Override
	public boolean isValueAPurposeOfUse() {
		return (attribute.getAttributeValues() != null) //
				&& (attribute.getAttributeValues().size() > 0) //
				&& (attribute.getAttributeValues().get(0) instanceof PurposeOfUse);
	}

	@Override
	public boolean isValueARole() {
		return (attribute.getAttributeValues() != null) //
				&& (attribute.getAttributeValues().size() > 0) //
				&& (attribute.getAttributeValues().get(0) instanceof Role);
	}

	@Override
	public boolean isValueAString() {
		return (attribute.getAttributeValues() != null) //
				&& (attribute.getAttributeValues().size() > 0) //
				&& (attribute.getAttributeValues().get(0) instanceof XSString);
	}

}
