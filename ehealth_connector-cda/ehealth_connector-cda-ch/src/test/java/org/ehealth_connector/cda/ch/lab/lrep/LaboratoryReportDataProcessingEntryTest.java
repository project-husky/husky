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

import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.junit.jupiter.api.Test;

/**
 * Unit Tests for Class LaboratoryReportDataProcessingEntry.
 */
public class LaboratoryReportDataProcessingEntryTest {

	/** The name of the class under test. */
	private String cutName = "LaboratoryReportDataProcessingEntry";

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIhe = "1.3.6.1.4.1.19376.1.3.1";
		boolean idFoundIhe = false;
		String idChPalm = "2.16.756.5.30.1.1.10.4.4";
		boolean idFoundChPalm = false;

		LaboratoryReportDataProcessingEntry lrdpe = new LaboratoryReportDataProcessingEntry();

		for (Identificator id : lrdpe.getTemplateIds()) {
			assertNull(id.getExtension(), "Extensions not allowd for template ids");
			if (idIhe.equals(id.getRoot()))
				idFoundIhe = true;
			if (idChPalm.equals(id.getRoot()))
				idFoundChPalm = true;
		}

		assertTrue(idFoundIhe, cutName + " templateID defined by IHE XD-LAB is missing");
		assertTrue(idFoundChPalm, cutName + " templateID defined by ART DECOR CH-PALM is missing");
		assertFalse((lrdpe.getTemplateIds().size() > 2), cutName + " contains more templateIds than expected"
				);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryReportDataProcessingEntry#setSpecimenAct(org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct)}
	 * and
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryReportDataProcessingEntry#getSpecimenAct()}.
	 */
	@Test
	public void testSetGetSpecimenAct() {
		Code code = new Code("2.999", "mySpecActCode");
		LaboratoryReportDataProcessingEntry lrdpe = new LaboratoryReportDataProcessingEntry();
		BaseChSpecimenAct specAct1 = new BaseChSpecimenAct();
		specAct1.setCode(code);
		lrdpe.setSpecimenAct(specAct1);
		BaseChSpecimenAct specAct2 = lrdpe.getSpecimenAct();
		assertTrue(specAct2.getCode().getCode().equals(code.getCode()));
	}

}
