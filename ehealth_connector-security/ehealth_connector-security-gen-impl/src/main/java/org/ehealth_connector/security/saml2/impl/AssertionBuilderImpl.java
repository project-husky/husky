/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2.impl;

import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.AssertionBuilder;
import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.AttributeBuilder;

/**
 * @since Feb 21, 2018 3:45:44 PM
 *
 */
public class AssertionBuilderImpl implements AssertionBuilder<org.opensaml.saml2.core.Assertion> {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#id(java.lang.String)
	 */
	@Override
	public AssertionBuilder<org.opensaml.saml2.core.Assertion> id(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#addAttribute(org.ehealth_connector.security.saml2.Attribute)
	 */
	@Override
	public AttributeBuilder<org.opensaml.saml2.core.Assertion> addAttribute(
			Attribute<org.opensaml.saml2.core.Assertion> attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#createAssertion()
	 */
	@Override
	public Assertion<org.opensaml.saml2.core.Assertion> createAssertion() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#createAssertion(java.lang.Object)
	 */
	@Override
	public Assertion<org.opensaml.saml2.core.Assertion> createAssertion(
			org.opensaml.saml2.core.Assertion aInternalObject) {
		return new AssertionImpl(aInternalObject);
	}

}
