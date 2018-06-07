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
package org.ehealth_connector.security.ch.epr.policyadmin.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlEprPolicyRepositoryResponse;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.Test;

public class EprPolicyRepositoryResponseBuilderImplTest extends InitializerTestHelper {

	private String testStatus;

	@Before
	public void setUp() throws Exception {
		testStatus = "urn:e-health-suisse:2015:response-status:success";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.ch.epr.policyadmin.impl.EprPolicyRepositoryResponseBuilderImpl#status(java.lang.String)}.
	 */
	@Test
	public void testStatus() {
		final OpenSamlEprPolicyRepositoryResponse ref = new EprPolicyRepositoryResponseBuilderImpl()
				.status(testStatus).buildObject();
		assertNotNull(ref);
		assertEquals(testStatus, ref.getStatus());
	}

}
