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

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;

/**
 * Unit Tests for Class SpecimenCollectionEntry.
 */
public class SpecimenCollectionEntryTest {

	/** The name of the class under test. */
	private String cutName = "SpecimenCollectionEntry";

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIhe = "1.3.6.1.4.1.19376.1.3.1.2";
		boolean idFoundIhe = false;
		String idChPalm = "2.16.756.5.30.1.1.10.4.11";
		boolean idFoundChPalm = false;

		final SpecimenCollectionEntry sce = new SpecimenCollectionEntry();
		sce.setEffectiveTime(DateUtil.dateAndTime("22.07.2018 12:02"));
		sce.setSpecimenMaterialOriginalText("Testmaterial");
		sce.setSpecimenCollectionApproachSiteCodeOriginalText("Test site");

		for (Identificator id : sce.getTemplateIds()) {
			assertNull("Extensions not allowd for template ids", id.getExtension());
			if (idIhe.equals(id.getRoot()))
				idFoundIhe = true;
			if (idChPalm.equals(id.getRoot()))
				idFoundChPalm = true;
		}

		assertTrue(cutName + " templateID defined by IHE XD-LAB is missing", idFoundIhe);
		assertTrue(cutName + " templateID defined by ART DECOR CH-PALM is missing", idFoundChPalm);
		assertFalse(cutName + " contains more templateIds than expected",
				(sce.getTemplateIds().size() > 2));
	}

}
