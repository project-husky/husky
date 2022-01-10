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

import org.husky.xua.saml2.Condition;
import org.husky.xua.saml2.impl.ConditionBuilderImpl;
import org.husky.xua.saml2.impl.ConditionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionBuilderImplTest {

	private ConditionBuilderImpl builder;
	private org.opensaml.saml.saml2.core.Condition testInnerObject;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new ConditionBuilderImpl();
		testInnerObject = new org.opensaml.saml.saml2.core.impl.AudienceRestrictionBuilder()
				.buildObject();
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.ConditionBuilderImpl#create(org.opensaml.saml.saml2.core.Condition)}.
	 */
	@Test
	void testCreate() {
		final Condition ref = builder.create(testInnerObject);
		assertEquals(testInnerObject, ((ConditionImpl) ref).getWrappedObject());
	}

}
