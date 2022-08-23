/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.cda.elga.models.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.cda.TestUtils;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.ActRelationshipHasComponent;
import org.husky.common.hl7cdar2.XActClassDocumentEntryOrganizer;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link Antibiogram}
 *
 */

class AntibiogramTest extends TestUtils {

	private Antibiogram testAntibiogram;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		super.init();
		testAntibiogram = getAntibiogram();
	}

	private Antibiogram getAntibiogram() {
		Antibiogram antibiogram = new Antibiogram();
		antibiogram.setSpecimen(getSpecimen());
		antibiogram.setResultTime(endDate);
		antibiogram.setLaboratoryBattery(getLaboratoryBatteryOrganizer());

		return antibiogram;
	}

	private LaboratoryBatteryOrganizer getLaboratoryBatteryOrganizer() {
		LaboratoryBatteryOrganizer battery = new LaboratoryBatteryOrganizer();
		battery.setStartDate(startDate);
		battery.setStopDate(endDate);
		return battery;
	}

	private Specimen getSpecimen() {
		Specimen testSpecimen = new Specimen();
		testSpecimen.setId(new Identificator("2.16.840.1.113883.3.933.1.1", "47110816"));

		Code code = new Code();
		code.setNullFlavor(NullFlavor.NOT_APPLICABLE);
		code.setOriginalText("vergründende Streptokokken");
		testSpecimen.setSignificantPathogen(code);
		return testSpecimen;
	}

	/**
	 * Test method for {@link Antibiogram#getAntibiogram()}.
	 */
	@Test
	@Disabled
	void testGetAntibiogram() {
		final org.husky.cda.elga.generated.artdecor.base.Antibiogram antibiogram = testAntibiogram.getAntibiogram();
		assertNotNull(antibiogram);
		assertNotNull(antibiogram.getClassCode());
		assertEquals(XActClassDocumentEntryOrganizer.CLUSTER, antibiogram.getClassCode());
		assertNotNull(antibiogram.getMoodCode());
		assertNotNull(antibiogram.getMoodCode().get(0));
		assertEquals("EVN", antibiogram.getMoodCode().get(0));

		assertNotNull(antibiogram.getTemplateId());
		assertNotNull(antibiogram.getTemplateId().get(0));
		assertEquals("1.3.6.1.4.1.19376.1.3.1.5", antibiogram.getTemplateId().get(0).getRoot());

		assertNotNull(antibiogram.getStatusCode());
		assertEquals("completed", antibiogram.getStatusCode().getCode());

		assertNotNull(antibiogram.getEffectiveTime());
		assertNotNull(antibiogram.getEffectiveTime().getValue());
		assertEquals(DateUtil.formatDateTimeTzon(endDate), antibiogram.getEffectiveTime().getValue());

		assertNotNull(antibiogram.getSpecimen());
		assertEquals(1, antibiogram.getSpecimen().size());
		assertNotNull(antibiogram.getSpecimen().get(0));

		assertNotNull(antibiogram.getComponent());
		assertEquals(1, antibiogram.getComponent().size());
		assertNotNull(antibiogram.getComponent().get(0));
		assertEquals(ActRelationshipHasComponent.COMP, antibiogram.getComponent().get(0).getTypeCode());
		assertNotNull(antibiogram.getComponent().get(0).getOrganizer());
		assertNotNull(antibiogram.getComponent().get(0).getOrganizer().getTemplateId());
		assertNotNull(antibiogram.getComponent().get(0).getOrganizer().getTemplateId().get(0));
		assertEquals("1.3.6.1.4.1.19376.1.3.1.4",
				antibiogram.getComponent().get(0).getOrganizer().getTemplateId().get(0).getRoot());

		assertNotNull(antibiogram.getComponent().get(0).getOrganizer().getCode());
		assertEquals("29576-6", antibiogram.getComponent().get(0).getOrganizer().getCode().getCode());
		assertEquals("2.16.840.1.113883.6.1",
				antibiogram.getComponent().get(0).getOrganizer().getCode().getCodeSystem());
		assertEquals("LOINC", antibiogram.getComponent().get(0).getOrganizer().getCode().getCodeSystemName());
		assertEquals("Antibiogramm", antibiogram.getComponent().get(0).getOrganizer().getCode().getDisplayName());
	}

}
