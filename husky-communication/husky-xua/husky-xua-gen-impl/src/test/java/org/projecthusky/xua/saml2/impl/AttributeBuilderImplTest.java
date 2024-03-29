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
package org.projecthusky.xua.saml2.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.projecthusky.xua.hl7v3.CE;
import org.projecthusky.xua.hl7v3.PurposeOfUse;
import org.projecthusky.xua.hl7v3.Role;
import org.projecthusky.xua.hl7v3.impl.CodedWithEquivalentsBuilder;
import org.projecthusky.xua.saml2.AttributeBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;

class AttributeBuilderImplTest {

	private String testAttributeName;
	private String testAttributeValue;
	public CE testAttributeValueRole;

	public AttributeBuilder testBuilder;

	@BeforeEach
	public void setUp() throws Exception {
		testBuilder = new AttributeBuilderImpl();
		testAttributeName = "My Attribute Name";
		testAttributeValue = "My Attribute Value";

		testAttributeValueRole = new CodedWithEquivalentsBuilder().buildObject(PurposeOfUse.DEFAULT_NS_URI,
				Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);
		testAttributeValueRole.setCode("My Code");
		testAttributeValueRole.setCode("My Code System");
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.AttributeBuilderImpl#name(java.lang.String)}.
	 */
	@Test
	void testName() {
		final AttributeType ref = testBuilder.name(testAttributeName).create();
		assertEquals(testAttributeName, ref.getName());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.AttributeBuilderImpl#value(java.lang.String)}.
	 */
	@Test
	void testValue() {
		final AttributeType ref = testBuilder.value(testAttributeValue).create();
		assertEquals(testAttributeValue, testBuilder.getValueAsString());
	}

	@Test
	void testValueRole() {
		final AttributeType ref = testBuilder.value(testAttributeValueRole).create();
		assertEquals(testAttributeValueRole, testBuilder.getValueAsRole());
	}

}
