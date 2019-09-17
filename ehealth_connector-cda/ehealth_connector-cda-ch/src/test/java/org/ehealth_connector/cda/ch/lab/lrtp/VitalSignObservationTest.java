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
package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationForVitalSign;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.VitalSignList;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.Ucum;
import org.junit.Test;

public class VitalSignObservationTest extends TestUtils {
	@Test
	public void testConvenience() {
		super.init();
		VitalSignObservation o = new VitalSignObservation();

		// Method code has to be NA or a translation
		assertTrue(o.getMdhtCopy().getMethodCodes().get(0).getNullFlavor() != null);
		o.setMethodCodeTranslation(code1);
		assertTrue(code1.equals(o.getMethodCodeTranslation()));

		// Observation Interpretation
		o.setInterpretationCode(ObservationInterpretationForVitalSign.ABNORMAL.getCode());
		assertEquals(ObservationInterpretationForVitalSign.ABNORMAL.getCodeValue(),
				o.getInterpretationCode().getCode());
		assertEquals(ObservationInterpretationForVitalSign.ABNORMAL.getCodeValue(),
				o.getObservationInterpretationCodeEnum().getCodeValue());

		// Code
		o.setCode(VitalSignList.BODY_HEIGHT);
		assertTrue(VitalSignList.BODY_HEIGHT.getCode().equals(o.getCodeEnum().getCode()));

		// Value
		Value v = new Value("182", Ucum.CentiMeter);
		o.setValue(v);
		assertEquals(v.copyMdhtPhysicalQuantity().getValue(),
				o.getValue().copyMdhtPhysicalQuantity().getValue());
		assertEquals("182.0", o.getValue().getPhysicalQuantityValue());

		// Section Annotation Comment Entry
		o.addCommentEntry(new SectionAnnotationCommentEntry());
		assertFalse(o.getCommentEntries().isEmpty());
	}
}
