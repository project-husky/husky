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

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.hl7v3.InstanceIdentifier;
import org.ehealth_connector.xua.hl7v3.PurposeOfUse;
import org.ehealth_connector.xua.hl7v3.Role;
import org.ehealth_connector.xua.saml2.Attribute;
import org.ehealth_connector.xua.saml2.AttributeBuilder;
import org.ehealth_connector.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.ehealth_connector.xua.hl7v3.OpenSamlPurposeOfUse;
import org.ehealth_connector.xua.hl7v3.OpenSamlRole;
import org.opensaml.core.xml.schema.XSAny;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.core.xml.schema.impl.XSAnyBuilder;
import org.opensaml.core.xml.schema.impl.XSStringBuilder;
import org.opensaml.saml.saml2.core.AttributeValue;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Attribute building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Attribute bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AttributeBuilderImpl implements AttributeBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Attribute, Attribute> {

	/** The attribute. */
	private org.opensaml.saml.saml2.core.Attribute attribute;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 */
	public AttributeBuilderImpl() {
		attribute = new org.opensaml.saml.saml2.core.impl.AttributeBuilder().buildObject();

	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.AttributeBuilder#create()
	 */
	@Override
	public Attribute create() {
		return new AttributeImpl(attribute);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Attribute create(org.opensaml.saml.saml2.core.Attribute aInternalObject) {
		return new AttributeImpl(aInternalObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.AttributeBuilder#friendlyName(java.lang.String)
	 */
	@Override
	public AttributeBuilder friendlyName(String aFriendlyName) {
		if (aFriendlyName != null) {
			attribute.setFriendlyName(aFriendlyName);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.AttributeBuilder#name(java.lang.String)
	 */
	@Override
	public AttributeBuilder name(String aName) {
		if (aName != null) {
			attribute.setName(aName);
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.AttributeBuilder#nameFormat(java.lang.String)
	 */
	@Override
	public AttributeBuilder nameFormat(String aNameFormat) {
		if (aNameFormat != null) {
			attribute.setNameFormat(aNameFormat);
		}
		return this;
	}

	@Override
	public AttributeBuilder value(Object aValue) {
		final var anyBuilder = new XSAnyBuilder();
		final XSAny any = anyBuilder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME);
		if (aValue instanceof Role) {
			any.getUnknownXMLObjects().add((OpenSamlRole) aValue);
		} else if (aValue instanceof PurposeOfUse) {
			any.getUnknownXMLObjects().add((OpenSamlPurposeOfUse) aValue);
		} else if (aValue instanceof InstanceIdentifier) {
			any.getUnknownXMLObjects().add((OpenSamlInstanceIdentifier) aValue);
		}
		attribute.getAttributeValues().add(any);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.AttributeBuilder#value(java.lang.String)
	 */
	@Override
	public AttributeBuilder value(String aValue) {
		if (aValue != null) {
			final var builder = new XSStringBuilder();
			final XSString attributeValue = builder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME,
					XSString.TYPE_NAME);
			attributeValue.setValue(aValue);
			attribute.getAttributeValues().add(attributeValue);
		}

		return this;
	}
}
