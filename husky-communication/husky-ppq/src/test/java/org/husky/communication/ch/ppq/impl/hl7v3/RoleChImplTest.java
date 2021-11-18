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
import org.husky.xua.hl7v3.Role;
import org.junit.jupiter.api.Test;

public class RoleChImplTest {

	@Test
	public void testASSISTENT() {
		final Role ref = RoleChImpl.ASSISTENT();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_ASS, ref.getCode());
	}

	@Test
	public void testDOCUMENT_ADMINISTRATOR() {
		final Role ref = RoleChImpl.DOCUMENT_ADMINISTRATOR();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_DADM, ref.getCode());
	}

	@Test
	public void testGENERAL_PRACTITIONER() {
		final Role ref = RoleChImpl.HEALT_CARE_PROFESSIONAL();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_HCP, ref.getCode());
	}

	@Test
	public void testPATIENT() {
		final Role ref = RoleChImpl.PATIENT();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_PAT, ref.getCode());
	}

	@Test
	public void testPOLICY_ADMINISTRATOR() {
		final Role ref = RoleChImpl.POLICY_ADMINISTRATOR();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_PADM, ref.getCode());
	}

	@Test
	public void testREPRESENTATIVE() {
		final Role ref = RoleChImpl.REPRESENTATIVE();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_REP, ref.getCode());
	}

	@Test
	public void testTECHNICAL_USER() {
		final Role ref = RoleChImpl.TECHNICAL_USER();
		assertNotNull(ref);
		assertEquals(RoleChImpl.CODE_TCU, ref.getCode());
	}

}
