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

import org.husky.xua.communication.xua.impl.ch.PurposeOfUseChImpl;
import org.husky.xua.hl7v3.PurposeOfUse;
import org.junit.jupiter.api.Test;

public class PurposeOfUseChImplTest {

	@Test
	public void testAUTO() {
		final PurposeOfUse ref = PurposeOfUseChImpl.AUTO();
		assertNotNull(ref);
		assertEquals(org.husky.communication.ch.enums.PurposeOfUse.AUTOMATIC_UPLOAD_CODE,
				ref.getCode());
	}

	@Test
	public void testEMER() {
		final PurposeOfUse ref = PurposeOfUseChImpl.EMER();
		assertNotNull(ref);
		assertEquals(org.husky.communication.ch.enums.PurposeOfUse.EMERGENCY_ACCESS_CODE,
				ref.getCode());
	}

	@Test
	public void testNORM() {
		final PurposeOfUse ref = PurposeOfUseChImpl.NORM();
		assertNotNull(ref);
		assertEquals(org.husky.communication.ch.enums.PurposeOfUse.NORMAL_ACCESS_CODE,
				ref.getCode());
	}

}
