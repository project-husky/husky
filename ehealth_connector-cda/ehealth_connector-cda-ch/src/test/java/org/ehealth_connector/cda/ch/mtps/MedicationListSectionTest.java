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

package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class MedicationFrequency.
 */
public class MedicationListSectionTest {

	/**
	 * Test method for the MedicationnListSection
	 *
	 * @throws Exception
	 */
	@Test
	public void testMedicationListSection() throws Exception {

		final MedicationListSection medicationListSection = new MedicationListSection();
		assertEquals("1.3.6.1.4.1.19376.1.9.1.2.6",
				medicationListSection.getMedicationTreatmentPlanSection().getTemplateId());
		assertEquals("77604-7", medicationListSection.getMedicationTreatmentPlanSection().getMdht()
				.getCode().getCode());
		assertEquals("2.16.840.1.113883.6.1", medicationListSection
				.getMedicationTreatmentPlanSection().getMdht().getCode().getCodeSystem());
	}

}
