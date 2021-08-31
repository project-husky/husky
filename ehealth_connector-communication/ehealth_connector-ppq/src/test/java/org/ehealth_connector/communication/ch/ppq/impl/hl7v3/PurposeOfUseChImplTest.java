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

import org.ehealth_connector.communication.ch.ppq.hl7v3.PurposeOfUseChImpl;
import org.ehealth_connector.xua.hl7v3.PurposeOfUse;
import org.junit.jupiter.api.Test;

public class PurposeOfUseChImplTest {

	@Test
	public void testAUTO() {
		final PurposeOfUse ref = PurposeOfUseChImpl.AUTO();
		assertNotNull(ref);
		assertEquals(org.ehealth_connector.communication.ch.ppq.epr.enums.PurposeOfUse.AUTOMATIC_UPLOAD_CODE,
				ref.getCode());
	}

	@Test
	public void testEMER() {
		final PurposeOfUse ref = PurposeOfUseChImpl.EMER();
		assertNotNull(ref);
		assertEquals(org.ehealth_connector.communication.ch.ppq.epr.enums.PurposeOfUse.EMERGENCY_ACCESS_CODE,
				ref.getCode());
	}

	@Test
	public void testNORM() {
		final PurposeOfUse ref = PurposeOfUseChImpl.NORM();
		assertNotNull(ref);
		assertEquals(org.ehealth_connector.communication.ch.ppq.epr.enums.PurposeOfUse.NORMAL_ACCESS_CODE,
				ref.getCode());
	}

}
