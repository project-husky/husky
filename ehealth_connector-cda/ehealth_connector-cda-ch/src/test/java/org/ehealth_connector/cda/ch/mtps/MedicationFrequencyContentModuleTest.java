/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;

import org.ehealth_connector.cda.ch.mtps.MedicationFrequencyContentModule.FrequencyType;
import org.ehealth_connector.cda.ch.mtps.MedicationFrequencyContentModule.MedicationFrequency;
import org.ehealth_connector.cda.ch.mtps.MedicationFrequencyContentModule.PosologyType;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.DosageType;
import org.ehealth_connector.cda.ihe.pharm.enums.TimingEvent;
import org.ehealth_connector.common.Value;
import org.junit.Test;

/**
 * The Class PrescriptionItemEntry.
 */
public class MedicationFrequencyContentModuleTest {

	@Test
	public void test10MorningEveningBeforeMeal() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.TimingEvent, 0,
				new TimingEvent[] { TimingEvent.BEFORE_BREAKFAST, TimingEvent.BEFORE_DINNER }, null,
				3, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.TimingEvent, medicationFrequency.posology);
		assertEquals(TimingEvent.BEFORE_BREAKFAST, medicationFrequency.timingEvents[0]);
		assertEquals(TimingEvent.BEFORE_DINNER, medicationFrequency.timingEvents[1]);
	}

	@Test
	public void test1NTimesPerDay() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.NTimesADay, 3, null, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.NTimesADay, medicationFrequency.posology);
		assertEquals(new Double(3.0), new Double(medicationFrequency.posologyFactor));
	}

	@Test
	public void test2NTimesPerDayDuringMeal() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.NTimesADay, 2,
				new TimingEvent[] { TimingEvent.DURING_MEAL }, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.NTimesADay, medicationFrequency.posology);
		assertEquals(new Double(2.0), new Double(medicationFrequency.posologyFactor));
		assertEquals(TimingEvent.DURING_MEAL, medicationFrequency.timingEvents[0]);
	}

	@Test
	public void test3NTimesPerWeek() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.NTimesAWeek, 3, null, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.NTimesAWeek, medicationFrequency.posology);
		assertEquals(new Double(3.0), new Double(medicationFrequency.posologyFactor));
	}

	@Test
	public void test4NTimesPerHours() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.EveryXHours, 3, null, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.EveryXHours, medicationFrequency.posology);
		assertEquals(new Double(3.0), new Double(medicationFrequency.posologyFactor));
	}

	@Test
	public void test5NTimesPerDayDuringMealsEvery3Days() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.NTimesADay, 2,
				new TimingEvent[] { TimingEvent.DURING_MEAL }, FrequencyType.EveryXDay, 3, null,
				null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.NTimesADay, medicationFrequency.posology);
		assertEquals(new Double(2.0), new Double(medicationFrequency.posologyFactor));
		assertEquals(TimingEvent.DURING_MEAL, medicationFrequency.timingEvents[0]);
		assertEquals(FrequencyType.EveryXDay, medicationFrequency.frequency);
		assertEquals(new Double(3.0), new Double(medicationFrequency.frequencyFactor));
	}

	@Test
	public void test6BeforeBreakfast() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.TimingEvent, 0,
				new TimingEvent[] { TimingEvent.BEFORE_BREAKFAST }, null, 3, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.TimingEvent, medicationFrequency.posology);
		assertEquals(TimingEvent.BEFORE_BREAKFAST, medicationFrequency.timingEvents[0]);
	}

	@Test
	public void testSplitDosing() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);

		final Value[] values = new Value[4];
		values[0] = new Value(2.0);
		values[1] = new Value(1.5);
		values[2] = new Value(2.5);
		values[3] = new Value(4.0);
		frequency.setMedicationFrequency(PosologyType.TimingEvent, 0,
				new TimingEvent[] { TimingEvent.DURING_BREAKFAST, TimingEvent.DURING_LUNCH,
						TimingEvent.DURING_DINNER, TimingEvent.BEFORE_SLEEP },
				null, 0, DosageType.Split, values);
		entry.getDocument();

		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.TimingEvent, medicationFrequency.posology);
		assertEquals(TimingEvent.DURING_BREAKFAST, medicationFrequency.timingEvents[0]);
		assertEquals(TimingEvent.DURING_LUNCH, medicationFrequency.timingEvents[1]);
		assertEquals(TimingEvent.DURING_DINNER, medicationFrequency.timingEvents[2]);
		assertEquals(TimingEvent.BEFORE_SLEEP, medicationFrequency.timingEvents[3]);
		assertEquals(DosageType.Split, medicationFrequency.dosage);
		assertEquals(new Double(2.0), new Double(medicationFrequency.doseQuantities[0]
				.getPhysicalQuantity().getValue().doubleValue()));
		assertEquals(new Double(1.5), new Double(medicationFrequency.doseQuantities[1]
				.getPhysicalQuantity().getValue().doubleValue()));
		assertEquals(new Double(2.5), new Double(medicationFrequency.doseQuantities[2]
				.getPhysicalQuantity().getValue().doubleValue()));
		assertEquals(new Double(4.0), new Double(medicationFrequency.doseQuantities[3]
				.getPhysicalQuantity().getValue().doubleValue()));

	}

}
