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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlEprPolicyRepositoryResponse;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EprPolicyRepositoryResponseBuilderImplTest extends InitializerTestHelper {

	private String testStatus;

	@BeforeEach
	public void setUp() throws Exception {
		testStatus = "urn:e-health-suisse:2015:response-status:success";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.ch.epr.policyadmin.impl.EprPolicyRepositoryResponseBuilderImpl#status(java.lang.String)}.
	 */
	@Test
	void testStatus() {
		final OpenSamlEprPolicyRepositoryResponse ref = new EprPolicyRepositoryResponseBuilderImpl()
				.status(testStatus).buildObject();
		assertNotNull(ref);
		assertEquals(testStatus, ref.getStatus());
	}

}
