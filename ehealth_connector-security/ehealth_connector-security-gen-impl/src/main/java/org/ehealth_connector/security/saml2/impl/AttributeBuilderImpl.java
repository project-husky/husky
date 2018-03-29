/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2.impl;

import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.AttributeBuilder;
import org.opensaml.saml2.core.AttributeValue;
import org.opensaml.xml.schema.XSString;
import org.opensaml.xml.schema.impl.XSStringBuilder;

/**
 * @since Feb 20, 2018 11:18:52 AM
 *
 */
public class AttributeBuilderImpl implements AttributeBuilder<org.opensaml.saml2.core.Attribute> {

	private org.opensaml.saml2.core.Attribute attribute;

	public AttributeBuilderImpl() {
		final org.opensaml.saml2.core.impl.AttributeBuilder openSamlBuilder = new org.opensaml.saml2.core.impl.AttributeBuilder();
		attribute = openSamlBuilder.buildObject();

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AttributeBuilder#name(java.lang.String)
	 */
	@Override
	public AttributeBuilder<org.opensaml.saml2.core.Attribute> name(String aName) {
		if (aName != null) {
			attribute.setName(aName);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AttributeBuilder#value(java.lang.String)
	 */
	@Override
	public AttributeBuilder<org.opensaml.saml2.core.Attribute> value(String aValue) {
		if (aValue != null) {
			final XSStringBuilder builder = new XSStringBuilder();
			final XSString attributeValue = builder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME,
					XSString.TYPE_NAME);
			attributeValue.setValue(aValue);
			attribute.getAttributeValues().add(attributeValue);
		}

		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AttributeBuilder#createAttribute()
	 */
	@Override
	public Attribute<org.opensaml.saml2.core.Attribute> createAttribute() {
		return new AttributeImpl(attribute);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AttributeBuilder#createAttribute(java.lang.Object)
	 */
	@Override
	public Attribute<org.opensaml.saml2.core.Attribute> createAttribute(
			org.opensaml.saml2.core.Attribute aInternalObject) {
		return new AttributeImpl(aInternalObject);
	}

}
