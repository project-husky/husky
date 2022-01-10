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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.husky.xua.saml2.AssertionBuilder;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.husky.xua.saml2.impl.AttributeBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;

class AssertionBuilderImplTest {

	private String testAttributeName;
	private String testAttributeValue;
	private AssertionBuilder testBuilder;
	private String testId;

	@BeforeEach
	public void setUp() throws Exception {
		testBuilder = new AssertionBuilderImpl();

		testId = UUID.randomUUID().toString();

		testAttributeName = "My Attribute Name";
		testAttributeValue = "My Attribute Value";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AssertionBuilderImpl#addAttribute(org.husky.xua.saml2.Attribute)}.
	 */
	@Test
	void testAddAttribute() {
		final AttributeType attribute = new AttributeBuilderImpl().name(testAttributeName)
				.value(testAttributeValue).create();
		final AssertionType ref = testBuilder.addAttribute(attribute).create();
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AssertionBuilderImpl#id(java.lang.String)}.
	 */
	@Test
	void testId() {
		final AssertionType ref = testBuilder.id(testId).create();
		assertEquals(testId, ref.getID());
	}

}
