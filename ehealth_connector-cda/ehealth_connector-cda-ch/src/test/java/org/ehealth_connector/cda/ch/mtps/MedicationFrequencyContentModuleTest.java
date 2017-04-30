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

import org.ehealth_connector.cda.ch.mtps.enums.FrequencyType;
import org.ehealth_connector.cda.ch.mtps.enums.PosologyType;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.DosageType;
import org.ehealth_connector.cda.ihe.pharm.enums.TimingEvent;
import org.ehealth_connector.common.Value;
import org.junit.Test;

/**
 * The Class PrescriptionItemEntry.
 */
public class MedicationFrequencyContentModuleTest {

	/**
	 * @throws Exception
	 */
	@Test
	public void test10MorningEveningBeforeMeal() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.TIMING_EVENT, 0,
				new TimingEvent[] { TimingEvent.BEFORE_BREAKFAST, TimingEvent.BEFORE_DINNER }, null,
				3, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.TIMING_EVENT, medicationFrequency.getPosology());
		assertEquals(TimingEvent.BEFORE_BREAKFAST, medicationFrequency.getTimingEvents()[0]);
		assertEquals(TimingEvent.BEFORE_DINNER, medicationFrequency.getTimingEvents()[1]);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test1NTimesPerDay() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.N_TIMES_A_DAY, 3, null, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.N_TIMES_A_DAY, medicationFrequency.getPosology());
		assertEquals(new Double(3.0), new Double(medicationFrequency.getPosologyFactor()));
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test2NTimesPerDayDuringMeal() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.N_TIMES_A_DAY, 2,
				new TimingEvent[] { TimingEvent.DURING_MEAL }, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.N_TIMES_A_DAY, medicationFrequency.getPosology());
		assertEquals(new Double(2.0), new Double(medicationFrequency.getPosologyFactor()));
		assertEquals(TimingEvent.DURING_MEAL, medicationFrequency.getTimingEvents()[0]);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test3NTimesPerWeek() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.N_TIMES_A_WEEK, 3, null, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.N_TIMES_A_WEEK, medicationFrequency.getPosology());
		assertEquals(new Double(3.0), new Double(medicationFrequency.getPosologyFactor()));
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test4NTimesPerHours() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.EVERY_X_HOURS, 3, null, null, 0, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.EVERY_X_HOURS, medicationFrequency.getPosology());
		assertEquals(new Double(3.0), new Double(medicationFrequency.getPosologyFactor()));
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test5NTimesPerDayDuringMealsEvery3Days() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.N_TIMES_A_DAY, 2,
				new TimingEvent[] { TimingEvent.DURING_MEAL }, FrequencyType.EVERY_X_DAY, 3, null,
				null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.N_TIMES_A_DAY, medicationFrequency.getPosology());
		assertEquals(new Double(2.0), new Double(medicationFrequency.getPosologyFactor()));
		assertEquals(TimingEvent.DURING_MEAL, medicationFrequency.getTimingEvents()[0]);
		assertEquals(FrequencyType.EVERY_X_DAY, medicationFrequency.getFrequency());
		assertEquals(new Double(3.0), new Double(medicationFrequency.getFrequencyFactor()));
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void test6BeforeBreakfast() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		final MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(
				entry);
		frequency.setMedicationFrequency(PosologyType.TIMING_EVENT, 0,
				new TimingEvent[] { TimingEvent.BEFORE_BREAKFAST }, null, 3, null, null);
		entry.getDocument();
		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.TIMING_EVENT, medicationFrequency.getPosology());
		assertEquals(TimingEvent.BEFORE_BREAKFAST, medicationFrequency.getTimingEvents()[0]);
	}

	/**
	 * @throws Exception
	 */
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
		frequency.setMedicationFrequency(PosologyType.TIMING_EVENT, 0,
				new TimingEvent[] { TimingEvent.DURING_BREAKFAST, TimingEvent.DURING_LUNCH,
						TimingEvent.DURING_DINNER, TimingEvent.BEFORE_SLEEP },
				null, 0, DosageType.Split, values);
		entry.getDocument();

		final MedicationFrequency medicationFrequency = frequency.getMedicationFrequency();
		assertEquals(PosologyType.TIMING_EVENT, medicationFrequency.getPosology());
		assertEquals(TimingEvent.DURING_BREAKFAST, medicationFrequency.getTimingEvents()[0]);
		assertEquals(TimingEvent.DURING_LUNCH, medicationFrequency.getTimingEvents()[1]);
		assertEquals(TimingEvent.DURING_DINNER, medicationFrequency.getTimingEvents()[2]);
		assertEquals(TimingEvent.BEFORE_SLEEP, medicationFrequency.getTimingEvents()[3]);
		assertEquals(DosageType.Split, medicationFrequency.getDosage());
		assertEquals(new Double(2.0), new Double(medicationFrequency.getDoseQuantities()[0]
				.getPhysicalQuantity().getValue().doubleValue()));
		assertEquals(new Double(1.5), new Double(medicationFrequency.getDoseQuantities()[1]
				.getPhysicalQuantity().getValue().doubleValue()));
		assertEquals(new Double(2.5), new Double(medicationFrequency.getDoseQuantities()[2]
				.getPhysicalQuantity().getValue().doubleValue()));
		assertEquals(new Double(4.0), new Double(medicationFrequency.getDoseQuantities()[3]
				.getPhysicalQuantity().getValue().doubleValue()));

	}

}
