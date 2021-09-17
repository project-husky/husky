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
package org.ehealth_connector.communication.ch.ppq.impl.hl7v3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.ehealth_connector.communication.ch.ppq.hl7v3.RoleChImpl;
import org.ehealth_connector.xua.hl7v3.Role;
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
