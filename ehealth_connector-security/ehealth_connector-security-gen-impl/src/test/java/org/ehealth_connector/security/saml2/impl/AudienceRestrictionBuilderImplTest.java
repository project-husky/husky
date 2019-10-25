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
package org.ehealth_connector.security.saml2.impl;

import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.saml2.AudienceRestriction;
import org.ehealth_connector.security.saml2.AudienceRestrictionBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class AudienceRestrictionBuilderImplTest {

	public AudienceRestrictionBuilder testBuilder;

	@Before
	public void setUp() throws Exception {
		testBuilder = new AudienceRestrictionBuilderImpl();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.AudienceRestrictionBuilderImpl#create()}.
	 */
	@Test
	public void testCreate() {
		final AudienceRestriction audience = testBuilder.create();
		assertNotNull(audience);
	}

}
