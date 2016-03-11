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
