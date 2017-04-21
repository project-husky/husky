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
package org.ehealth_connector.cda.ch.lab.lrqc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.ehealth_connector.cda.ch.lab.lrqc.enums.QualabQcc;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;

public class IntendedRecipientTest extends TestUtils {
	@Test
	public void testEnum() {
		IntendedRecipient ir = new IntendedRecipient(
				QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ);

		assertFalse(ir.getIdsEnum().isEmpty());
		assertEquals(QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ.getCodeSystemOid(),
				ir.getIds().get(0).getRoot());
		assertEquals(QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ.getCodeValue(),
				ir.getIds().get(0).getExtension());
	}
}
