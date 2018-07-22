/*
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
package org.ehealth_connector.cda.ch.lab.lrep;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;

/**
 * Unit Tests for Class PreviousObservation.
 */
public class PreviousObservationTest {
	/** The name of the class under test. */
	private String cutName = "PreviousObservation";

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIhe = "1.3.6.1.4.1.19376.1.3.1.6";
		boolean idFoundIhe = false;
		String idChPalm = "2.16.756.5.30.1.1.10.4.22";
		boolean idFoundChPalm = false;

		LaboratoryObservation obs = new LaboratoryObservation();
		Value value = new Value(new Double(999.9));
		Code obsIntCode = new Code(CodeSystems.HL7ObservationInterpretation.getCodeSystemId(), "L",
				CodeSystems.HL7ObservationInterpretation.getCodeSystemName(), "Low");
		PreviousObservation prevObs = new PreviousObservation(obs,
				DateUtil.parseDateyyyyMMddHHmmZZZZ("201505021003+0200"), value, obsIntCode);

		for (Identificator id : prevObs.getTemplateIds()) {
			assertNull("Extensions not allowd for template ids", id.getExtension());
			if (idIhe.equals(id.getRoot()))
				idFoundIhe = true;
			if (idChPalm.equals(id.getRoot()))
				idFoundChPalm = true;
		}

		assertTrue(cutName + " templateID defined by IHE XD-LAB is missing", idFoundIhe);
		assertTrue(cutName + " templateID defined by ART DECOR CH-PALM is missing", idFoundChPalm);
		assertFalse(cutName + " contains more templateIds than expected",
				(prevObs.getTemplateIds().size() > 2));
	}

}
