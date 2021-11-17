/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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

import org.husky.xua.saml2.Condition;
import org.husky.xua.saml2.impl.ConditionBuilderImpl;
import org.husky.xua.saml2.impl.ConditionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConditionBuilderImplTest {

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
	public void testCreate() {
		final Condition ref = builder.create(testInnerObject);
		assertEquals(testInnerObject, ((ConditionImpl) ref).getWrappedObject());
	}

}
