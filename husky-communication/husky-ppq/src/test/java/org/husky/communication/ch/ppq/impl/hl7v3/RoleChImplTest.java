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
package org.husky.communication.ch.ppq.impl.hl7v3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.hl7v3.RoleChImpl;
import org.husky.xua.hl7v3.CE;
import org.junit.jupiter.api.Test;

class RoleChImplTest {

	@Test
	void testASSISTENT() {
		final CE ref = RoleChImpl.assistent();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_ASS, ref.getCode());
	}

	@Test
	void testDOCUMENT_ADMINISTRATOR() {
		final CE ref = RoleChImpl.documentAdministrator();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_DADM, ref.getCode());
	}

	@Test
	void testGENERAL_PRACTITIONER() {
		final CE ref = RoleChImpl.healthCareProfessional();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_HCP, ref.getCode());
	}

	@Test
	void testPATIENT() {
		final CE ref = RoleChImpl.patient();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_PAT, ref.getCode());
	}

	@Test
	void testPOLICY_ADMINISTRATOR() {
		final CE ref = RoleChImpl.policyAdministrator();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_PADM, ref.getCode());
	}

	@Test
	void testREPRESENTATIVE() {
		final CE ref = RoleChImpl.representative();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_REP, ref.getCode());
	}

	@Test
	void testTECHNICAL_USER() {
		final CE ref = RoleChImpl.technicalUser();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_TCU, ref.getCode());
	}

}
