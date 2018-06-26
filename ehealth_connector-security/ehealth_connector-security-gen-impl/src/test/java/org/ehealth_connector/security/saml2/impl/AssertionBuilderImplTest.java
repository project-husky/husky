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
package org.ehealth_connector.security.saml2.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.AssertionBuilder;
import org.ehealth_connector.security.saml2.Attribute;
import org.junit.Before;
import org.junit.Test;

public class AssertionBuilderImplTest {

	private String testAttributeName;
	private String testAttributeValue;
	private AssertionBuilder testBuilder;
	private String testId;

	@Before
	public void setUp() throws Exception {
		testBuilder = new AssertionBuilderImpl();

		testId = UUID.randomUUID().toString();

		testAttributeName = "My Attribute Name";
		testAttributeValue = "My Attribute Value";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.AssertionBuilderImpl#addAttribute(org.ehealth_connector.security.saml2.Attribute)}.
	 */
	@Test
	public void testAddAttribute() {
		final Attribute attribute = new AttributeBuilderImpl().name(testAttributeName)
				.value(testAttributeValue).create();
		final Assertion ref = testBuilder.addAttribute(attribute).create();
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.AssertionBuilderImpl#id(java.lang.String)}.
	 */
	@Test
	public void testId() {
		final Assertion ref = testBuilder.id(testId).create();
		assertEquals(testId, ref.getId());
	}

}
