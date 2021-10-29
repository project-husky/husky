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
package org.husky.xua.saml2.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.husky.xua.hl7v3.Role;
import org.husky.xua.hl7v3.impl.RoleBuilder;
import org.husky.xua.saml2.AttributeBuilder;
import org.husky.xua.saml2.impl.AttributeBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;

public class AttributeBuilderImplTest {

	private String testAttributeName;
	private String testAttributeValue;
	public Role testAttributeValueRole;

	public AttributeBuilder testBuilder;

	@BeforeEach
	public void setUp() throws Exception {
		testBuilder = new AttributeBuilderImpl();
		testAttributeName = "My Attribute Name";
		testAttributeValue = "My Attribute Value";

		testAttributeValueRole = new RoleBuilder().buildObject();
		testAttributeValueRole.setCode("My Code");
		testAttributeValueRole.setCode("My Code System");
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AttributeBuilderImpl#name(java.lang.String)}.
	 */
	@Test
	public void testName() {
		final AttributeType ref = testBuilder.name(testAttributeName).create();
		assertEquals(testAttributeName, ref.getName());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AttributeBuilderImpl#value(java.lang.String)}.
	 */
	@Test
	public void testValue() {
		final AttributeType ref = testBuilder.value(testAttributeValue).create();
		assertEquals(testAttributeValue, testBuilder.getValueAsString());
	}

	public void testValueRole() {
		final AttributeType ref = testBuilder.value(testAttributeValueRole).create();
		assertEquals(testAttributeValueRole, testBuilder.getValueAsRole());
	}

}
