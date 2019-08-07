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

import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;

/**
 * Unit Tests for Class LaboratorySpecialtySection.
 */
public class LaboratorySpecialtySectionTest {

	/** The name of the class under test. */
	private String cutName = "LaboratorySpecialtySection";

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratorySpecialtySection#addLaboratoryBatteryOrganizer(org.ehealth_connector.common.mdht.Code, org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer, org.ehealth_connector.common.enums.LanguageCode)}.
	 */
	@Test
	public void testAddGetLaboratoryBatteryOrganizer() {

		Date timeStamp1 = DateUtil.parseDateyyyyMMdd("20180721");
		Date timeStamp2 = DateUtil.parseDateyyyyMMdd("20180722");
		LaboratorySpecialtySection section = new LaboratorySpecialtySection();
		LaboratoryBatteryOrganizer lbo1 = new LaboratoryBatteryOrganizer();
		LaboratoryBatteryOrganizer lbo2 = new LaboratoryBatteryOrganizer();
		lbo1.setEffectiveTime(timeStamp1);
		lbo2.setEffectiveTime(timeStamp2);
		section.addLaboratoryBatteryOrganizer(new Code("2.999", "myTestCode1"), lbo1,
				LanguageCode.FRENCH);
		section.addLaboratoryBatteryOrganizer(new Code("2.999", "myTestCode2"), lbo2,
				LanguageCode.FRENCH);
		List<LaboratoryBatteryOrganizer> list = section.getLaboratoryBatteryOrganizers();
		assertTrue(list.get(0).getEffectiveTime().equals(timeStamp1));
		assertTrue(list.get(1).getEffectiveTime().equals(timeStamp2));
	}

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIhe = "1.3.6.1.4.1.19376.1.3.3.2.1";
		boolean idFoundIhe = false;
		String idChPalm = "2.16.756.5.30.1.1.10.3.3";
		boolean idFoundChPalm = false;

		LaboratorySpecialtySection section = new LaboratorySpecialtySection();

		for (Identificator id : section.getTemplateIds()) {
			assertNull("Extensions not allowd for template ids", id.getExtension());
			if (idIhe.equals(id.getRoot()))
				idFoundIhe = true;
			if (idChPalm.equals(id.getRoot()))
				idFoundChPalm = true;
		}

		assertTrue(cutName + " templateID defined by IHE XD-LAB is missing", idFoundIhe);
		assertTrue(cutName + " templateID defined by ART DECOR CH-PALM is missing", idFoundChPalm);
		assertFalse(cutName + " contains more templateIds than expected",
				(section.getTemplateIds().size() > 2));
	}

}
