/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2.impl;

import static org.junit.Assert.assertEquals;

import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.AttributeBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @since Feb 20, 2018 4:35:40 PM
 *
 */
public class AttributeBuilderImplTest {

	public AttributeBuilder testBuilder;
	private String testName;
	private String testValue;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testBuilder = new AttributeBuilderImpl();
		testName = "My Name";
		testValue = "My Value";
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.saml2.impl.AttributeBuilderImpl#name(java.lang.String)}.
	 */
	@Test
	public void testName() {
		final Attribute ref = testBuilder.name(testName).createAttribute();
		assertEquals(testName, ref.getName());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.saml2.impl.AttributeBuilderImpl#value(java.lang.String)}.
	 */
	@Test
	public void testValue() {
		final Attribute ref = testBuilder.value(testValue).createAttribute();
		assertEquals(testValue, ref.getValue());
	}

}
