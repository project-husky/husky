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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.saml2.AudienceRestrictionBuilder;
import org.husky.xua.saml2.impl.AudienceRestrictionBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AudienceRestrictionType;

/**
 *
 */
public class AudienceRestrictionBuilderImplTest {

	public AudienceRestrictionBuilder testBuilder;

	@BeforeEach
	public void setUp() throws Exception {
		testBuilder = new AudienceRestrictionBuilderImpl();
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AudienceRestrictionBuilderImpl#create()}.
	 */
	@Test
	public void testCreate() {
		final AudienceRestrictionType audience = testBuilder.create();
		assertNotNull(audience);
	}

}
