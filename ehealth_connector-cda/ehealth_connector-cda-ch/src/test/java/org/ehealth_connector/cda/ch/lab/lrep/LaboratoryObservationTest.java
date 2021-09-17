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
package org.ehealth_connector.cda.ch.lab.lrep;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.junit.jupiter.api.Test;

/**
 * Unit Tests for Class LaboratoryObservation.
 */
public class LaboratoryObservationTest {

	/** The name of the class under test. */
	private String cutName = "LaboratoryObservation";

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryObservation#addInterpretationCode(org.ehealth_connector.common.mdht.enums.ObservationInterpretation)}.
	 */
	@Test
	public void testAddGetInterpretationCode() {
		ObservationInterpretation obsInt1 = ObservationInterpretation.ABNORMAL;
		ObservationInterpretation obsInt2 = ObservationInterpretation.RESISTANT;
		LaboratoryObservation obs1 = new LaboratoryObservation();
		obs1.setInterpretationCode(obsInt1);
		assertTrue(obs1.getInterpretationCode().getCode().equals(obsInt1.getCode().getCode()));

		LaboratoryObservation obs2 = new LaboratoryObservation();
		obs2.addInterpretationCode(obsInt1);
		obs2.addInterpretationCode(obsInt2);
		assertTrue(
				obs2.getInterpretationCodes().get(0).getCode().equals(obsInt1.getCode().getCode()));
		assertTrue(
				obs2.getInterpretationCodes().get(1).getCode().equals(obsInt2.getCode().getCode()));

		obs2.setInterpretationCode(obsInt2);
		assertTrue(
				obs2.getInterpretationCodes().get(0).getCode().equals(obsInt2.getCode().getCode()));
		assertTrue(obs2.getInterpretationCodes().size() == 1);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryObservation#addPreviousObservation(org.ehealth_connector.cda.ch.lab.lrep.PreviousLaboratoryObservation)}.
	 */
	@Test
	public void testAddGetPreviousObservation() {
		Value value1 = new Value(100);
		Value value2 = new Value(200);
		Value value3 = new Value(300);
		Value value4 = new Value(400);
		LaboratoryObservation obs = new LaboratoryObservation();
		LaboratoryObservation prevObs1 = new LaboratoryObservation();
		LaboratoryObservation prevObs2 = new LaboratoryObservation();
		prevObs1.addValue(value1);
		prevObs1.addValue(value2);
		prevObs2.addValue(value3);
		prevObs2.addValue(value4);

		obs.addPreviousObservation(prevObs1);
		obs.addPreviousObservation(prevObs2);

		List<org.ehealth_connector.cda.ihe.lab.LaboratoryObservation> prevObsList = obs
				.getPreviousObservations();

		assertTrue(prevObsList.get(0).getValues().get(0).getIntText().equals(value1.getIntText()));
		assertTrue(prevObsList.get(0).getValues().get(1).getIntText().equals(value2.getIntText()));
		assertTrue(prevObsList.get(1).getValues().get(0).getIntText().equals(value3.getIntText()));
		assertTrue(prevObsList.get(1).getValues().get(1).getIntText().equals(value4.getIntText()));

	}

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIhe = "1.3.6.1.4.1.19376.1.3.1.6";
		boolean idFoundIhe = false;
		String idChPalm = "2.16.756.5.30.1.1.10.4.3";
		boolean idFoundChPalm = false;

		LaboratoryObservation obs = new LaboratoryObservation();

		for (Identificator id : obs.getTemplateIds()) {
			assertNull(id.getExtension(), "Extensions not allowd for template ids");
			if (idIhe.equals(id.getRoot()))
				idFoundIhe = true;
			if (idChPalm.equals(id.getRoot()))
				idFoundChPalm = true;
		}

		assertTrue(idFoundIhe, cutName + " templateID defined by IHE XD-LAB is missing");
		assertTrue(idFoundChPalm, cutName + " templateID defined by ART DECOR CH-PALM is missing");
		assertFalse((obs.getTemplateIds().size() > 2), cutName + " contains more templateIds than expected");
	}

}
