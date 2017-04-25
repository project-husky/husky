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

import org.ehealth_connector.cda.ch.mtps.enums.FrequencyType;
import org.ehealth_connector.cda.ch.mtps.enums.PosologyType;
import org.ehealth_connector.cda.ihe.pharm.enums.DosageType;
import org.ehealth_connector.cda.ihe.pharm.enums.TimingEvent;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.Ucum;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.PIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

/**
 * The Class MedicationFrequency.<div class="en">Implements the frequency of a
 * medication. See MTPS 7.5.10 and CDA Time intervals.</div>
 * <div class="de">.</div>
 */
public class MedicationFrequency {

	/** The dosage. */
	private DosageType dosage;

	/** The dose quantities. */
	private Value[] doseQuantities;

	/** The frequency. */
	private FrequencyType frequency;

	/** The frequency factor. */
	private double frequencyFactor;

	/** The posology. */
	private PosologyType posology;

	/** The posology factor. */
	private double posologyFactor;

	/** The timing events. */
	private TimingEvent[] timingEvents;

	/**
	 * Gets the medication dosage.
	 *
	 * @return the medication dosage
	 */
	public DosageType getDosage() {
		return this.dosage;
	}

	/**
	 * Gets the medication dose quantities.
	 *
	 * @return the dose quantities
	 */
	public Value[] getDoseQuantities() {
		return this.doseQuantities;
	}

	/**
	 * Gets the medication frequency.
	 *
	 * @return the medication frequency
	 */
	public FrequencyType getFrequency() {
		return this.frequency;
	}

	/**
	 * Gets the medication frequency factor.
	 *
	 * @return the medication frequency factor
	 */
	public double getFrequencyFactor() {
		return this.frequencyFactor;
	}

	/**
	 * Gets the medication frequency data access object out of the datatypes.
	 *
	 * @param period
	 *            the period
	 * @param freqPeriod
	 *            the frequency
	 * @param events
	 *            the events
	 * @param dosages
	 *            the dosages
	 * @return the medication frequency
	 */
	public static MedicationFrequency getMedicationFrequency(PIVL_TS period, PIVL_TS freqPeriod, EIVL_TS[] events,
			IVL_PQ[] dosages) {
		final MedicationFrequency medicationFrequency = new MedicationFrequency();
		if (period != null) {
			if (period.getInstitutionSpecified().booleanValue()) {
				final PQ pq = period.getPeriod();
				if (pq != null && Ucum.Hour.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setPosology(PosologyType.N_TIMES_A_DAY);
					medicationFrequency.setPosologyFactor(24.0 / pq.getValue().doubleValue());
				}
				if (pq != null && Ucum.Week.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setPosology(PosologyType.N_TIMES_A_WEEK);
					medicationFrequency.setPosologyFactor(1.0 / pq.getValue().doubleValue());
				}
				if (pq != null && Ucum.Month.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setPosology(PosologyType.N_TIMES_A_MONTH);
					medicationFrequency.setPosologyFactor(1.0 / pq.getValue().doubleValue());
				}
			} else {
				final PQ pq = period.getPeriod();
				if (pq != null && Ucum.Hour.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setPosology(PosologyType.EVERY_X_HOURS);
					medicationFrequency.setPosologyFactor(pq.getValue().doubleValue());
				}
			}
		}
		if (freqPeriod != null) {
			if (freqPeriod.getInstitutionSpecified().booleanValue()) {
				final PQ pq = freqPeriod.getPeriod();
				if (pq != null && Ucum.Week.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setFrequency(FrequencyType.X_TIMES_A_WEEK);
					medicationFrequency.setFrequencyFactor(1.0 / pq.getValue().doubleValue());
				}
				if (pq != null && Ucum.Month.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setFrequency(FrequencyType.X_TIMES_A_MONTH);
					medicationFrequency.setFrequencyFactor(1.0 / pq.getValue().doubleValue());
				}
			} else {
				final PQ pq = freqPeriod.getPeriod();
				if (pq != null && Ucum.Day.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setFrequency(FrequencyType.EVERY_X_DAY);
					medicationFrequency.setFrequencyFactor(pq.getValue().doubleValue());
				}
				if (pq != null && Ucum.Week.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setFrequency(FrequencyType.EVERY_X_WEEKS);
					medicationFrequency.setFrequencyFactor(pq.getValue().doubleValue());
				}
				if (pq != null && Ucum.Month.getCodeValue().equals(pq.getUnit())) {
					medicationFrequency.setFrequency(FrequencyType.EVERY_X_MONTHS);
					medicationFrequency.setFrequencyFactor(pq.getValue().doubleValue());
				}
			}
		}
		if (events != null) {
			if (period == null) {
				medicationFrequency.setPosology(PosologyType.TIMING_EVENT);
			}
			final TimingEvent[] timingEvents = new TimingEvent[events.length];
			for (int i = 0; i < events.length; ++i) {
				timingEvents[i] = TimingEvent.getEnum(events[i].getEvent().getCode());
			}
			medicationFrequency.setTimingEvents(timingEvents);

			if (dosages != null) {
				medicationFrequency.setDosage(DosageType.Split);
				final Value[] doseQuantities = new Value[dosages.length];
				for (int i = 0; i < dosages.length; ++i) {
					doseQuantities[i] = getValue(dosages[i]);
				}
				medicationFrequency.setDoseQuantities(doseQuantities);
			}
		}
		return medicationFrequency;
	}

	/**
	 * Gets the medication posology.
	 *
	 * @return the medication posology
	 */
	public PosologyType getPosology() {
		return this.posology;
	}

	/**
	 * Gets the medication posology factor.
	 *
	 * @return the medication posology factor
	 */
	public double getPosologyFactor() {
		return this.posologyFactor;
	}

	/**
	 * Gets the value out of a dose quantity
	 *
	 * @param doseQuantity
	 *            the dose quantity
	 * @return the value
	 */
	private static Value getValue(IVL_PQ doseQuantity) {
		return new Value(doseQuantity.getValue().doubleValue());
	}
	
	/**
	 * Gets the medication timing events.
	 *
	 * @return the medication timing events
	 */
	public TimingEvent[] getTimingEvents() {
		return this.timingEvents;
	}
	
	/**
	 * Sets the medication dosage
	 *
	 * @param dosage
	 *            the dosage
	 */
	public void setDosage(DosageType dosage) {
		this.dosage = dosage;
	}

	/**
	 * Sets the medication dose quantities
	 *
	 * @param doseQuantities
	 *            the dose quantities
	 */
	public void setDoseQuantities(Value[] doseQuantities) {
		this.doseQuantities = doseQuantities;
	}

	/**
	 * Sets the medication frequency
	 *
	 * @param frequency
	 *            the frequency
	 */
	public void setFrequency(FrequencyType frequency) {
		this.frequency = frequency;
	}

	/**
	 * Sets the medication frequency factor
	 *
	 * @param frequencyFactor
	 *            the frequency factor
	 */
	public void setFrequencyFactor(double frequencyFactor) {
		this.frequencyFactor = frequencyFactor;
	}

	/**
	 * Sets the medication posology
	 *
	 * @param posology
	 *            the posology
	 */
	public void setPosology(PosologyType posology) {
		this.posology = posology;
	}

	/**
	 * Sets the medication posology factor
	 *
	 * @param posologyFactor
	 *            the posology factor
	 */
	public void setPosologyFactor(double posologyFactor) {
		this.posologyFactor = posologyFactor;
	}

	/**
	 * Sets the medication timing events
	 *
	 * @param timingEvents
	 *            the timing events
	 */
	public void setTimingEvents(TimingEvent[] timingEvents) {
		this.timingEvents = timingEvents;
	}

}
