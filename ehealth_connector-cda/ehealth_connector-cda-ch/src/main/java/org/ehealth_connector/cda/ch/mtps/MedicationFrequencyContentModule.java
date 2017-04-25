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

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.ch.mtps.enums.FrequencyType;
import org.ehealth_connector.cda.ch.mtps.enums.PosologyType;
import org.ehealth_connector.cda.ihe.pharm.MedicationItemEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.DosageType;
import org.ehealth_connector.cda.ihe.pharm.enums.TimingEvent;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.Ucum;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.PIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXPR_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.SetOperator;

/**
 * The Class MedicationFrequencyContentModule.<div class="en">Describes the
 * Medication Frequency according to MTPS 7.5.10</div> <div class="de">.</div>
 */
public class MedicationFrequencyContentModule
		extends org.ehealth_connector.cda.ihe.pharm.MedicationFrequencyContentModule {

	/**
	 * @param medicationItemEntry
	 *            the medication item entry
	 */
	public MedicationFrequencyContentModule(MedicationItemEntry medicationItemEntry) {
		super(medicationItemEntry);
	}

	/**
	 * Gets the events out of the SXCM_TS datatype.
	 *
	 * @param scxm
	 *            the scxm
	 * @return the events
	 */
	private EIVL_TS[] getEvents(SXCM_TS scxm) {
		if (scxm instanceof EIVL_TS) {
			final EIVL_TS[] eivlts = new EIVL_TS[1];
			eivlts[0] = (EIVL_TS) scxm;
			return eivlts;
		}
		if (scxm instanceof SXPR_TS) {
			final EList<SXCM_TS> comps = ((SXPR_TS) scxm).getComps();
			final EIVL_TS[] eivlts = new EIVL_TS[comps.size()];
			for (int i = 0; i < comps.size(); ++i) {
				eivlts[i] = (EIVL_TS) comps.get(i);
			}
			return eivlts;
		}
		return null;
	}

	/**
	 * Gets the IVL_PQ datatype for a dose quantity
	 *
	 * @param doseQuantity
	 *            the dose quantity
	 * @return the IVL_PQ datatype
	 */
	private IVL_PQ getIvlPq(Value doseQuantity) {
		final IVL_PQ ivlPq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivlPq.setValue(doseQuantity.getPhysicalQuantity().getValue().doubleValue());
		return ivlPq;

	}

	/**
	 * Gets the medication frequency for a substanceadministration
	 *
	 * @return the medication frequency for a substanceadministration
	 */
	public MedicationFrequency getMedicationFrequency() {
		final SXCM_TS effectiveTime = super.getMedicationFrequencyEffectiveTime();
		IVL_PQ[] dosings = null;
		EIVL_TS[] events = null;
		if (this.hasSplitDosing()) {
			dosings = new IVL_PQ[getMaxSubordinateSequenceNumber()];
			events = new EIVL_TS[getMaxSubordinateSequenceNumber()];
			for (int i = 1; i <= this.getMaxSubordinateSequenceNumber(); ++i) {
				events[i - 1] = (EIVL_TS) getSubordinateSubstanceAdminiatrationEffectiveTime(i);
				dosings[i - 1] = this.getSubordinateSubstanceAdminiatrationDoseQuantity(i);
			}
		}
		if (effectiveTime == null) {
			if (dosings != null) {
				return MedicationFrequency.getMedicationFrequency(null, null, events, dosings);
			}
			return null;
		}
		if (effectiveTime instanceof PIVL_TS) {
			// case 1
			return MedicationFrequency.getMedicationFrequency((PIVL_TS) effectiveTime, null, events, dosings);
		}
		if (isEvents(effectiveTime)) {
			// case 1
			return MedicationFrequency.getMedicationFrequency(null, null, getEvents(effectiveTime), null);
		}
		if (effectiveTime instanceof SXPR_TS) {
			final SXPR_TS components = (SXPR_TS) effectiveTime;
			final EList<SXCM_TS> comps = components.getComps();
			if ((comps.size() == 2) && (comps.get(0) instanceof PIVL_TS) && isEvents(comps.get(1))) {
				final PIVL_TS period = (PIVL_TS) comps.get(0);
				return MedicationFrequency.getMedicationFrequency(period, null, getEvents(comps.get(1)), null);
			}
			if ((comps.size() == 3) && (comps.get(0) instanceof PIVL_TS && (comps.get(1) instanceof PIVL_TS)
					&& isEvents(comps.get(2)))) {
				final PIVL_TS period = (PIVL_TS) comps.get(0);
				final PIVL_TS freqPeriod = (PIVL_TS) comps.get(1);
				return MedicationFrequency.getMedicationFrequency(period, freqPeriod, getEvents(comps.get(2)), null);
			}
		}
		throw new RuntimeException("not implemented yet");
	}

	/**
	 * Checks if the SCXM_TS component is based on events (EIVL_TS)
	 *
	 * @param component
	 *            the component
	 * @return true, if is events
	 */
	private boolean isEvents(SXCM_TS component) {
		if (component instanceof EIVL_TS) {
			return true;
		}
		if (!(component instanceof SXPR_TS)) {
			return false;
		}
		for (final SXCM_TS comp : ((SXPR_TS) component).getComps()) {
			if (!(comp instanceof EIVL_TS)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Setting the medication frequency according the mtps rules NOTE: first
	 * draft version, no support for TAPERED Dosing currently
	 *
	 * @param medicationFrequency
	 *            the medication frequency
	 * @return true, if successful
	 */
	public boolean setMedicationFrequency(MedicationFrequency medicationFrequency) {
		return this.setMedicationFrequency(medicationFrequency.getPosology(), medicationFrequency.getPosologyFactor(),
				medicationFrequency.getTimingEvents(), medicationFrequency.getFrequency(),
				medicationFrequency.getFrequencyFactor(), medicationFrequency.getDosage(),
				medicationFrequency.getDoseQuantities());
	}

	/**
	 * Setting the medication frequency according the mtps rules NOTE: first
	 * draft version, no support for TAPERED Dosing currently
	 *
	 * @param posology
	 *            the posology
	 * @param posologyFactory
	 *            the posology factory
	 * @param timingEvents
	 *            the timing events
	 * @param frequency
	 *            the frequency
	 * @param frequencyFactor
	 *            the frequency factor
	 * @param dosage
	 *            the dosage
	 * @param doseQuantities
	 *            the dose quantities
	 * @return true, if successful
	 */
	public boolean setMedicationFrequency(PosologyType posology, double posologyFactory, TimingEvent[] timingEvents,
			FrequencyType frequency, double frequencyFactor, DosageType dosage, Value[] doseQuantities) {

		if (dosage == null) {
			dosage = DosageType.Normal;
		}
		if (DosageType.Split.equals(dosage) && doseQuantities != null) {
			if (timingEvents == null) {
				throw new RuntimeException("not implemented yet");
			} else {
				if (doseQuantities.length != timingEvents.length) {
					return false;
				}
			}
		}
		if (DosageType.Tapered.equals(dosage)) {
			throw new RuntimeException("not implemented yet");
		}

		Ucum freqUnit = null;
		boolean freqInstitiutionSpecified = false;
		double freqFactor = 0;
		if (frequency != null) {
			switch (frequency) {
			case X_TIMES_A_WEEK:
				freqInstitiutionSpecified = true;
				freqUnit = Ucum.Week;
				freqFactor = 1.0 / frequencyFactor;
				break;
			case X_TIMES_A_MONTH:
				freqInstitiutionSpecified = true;
				freqUnit = Ucum.Month;
				freqFactor = 1.0 / frequencyFactor;
				break;
			case EVERY_X_DAY:
				freqUnit = Ucum.Day;
				freqFactor = frequencyFactor;
				break;
			case EVERY_X_WEEKS:
				freqUnit = Ucum.Week;
				freqFactor = frequencyFactor;
				break;
			case EVERY_X_MONTHS:
				freqUnit = Ucum.Month;
				freqFactor = frequencyFactor;
				break;
			}
		}

		Ucum posUnit = null;
		boolean posInstitiutionSpecified = false;
		double posFactor = 0;

		if (posology != null) {
			switch (posology) {
			case N_TIMES_A_DAY:
				posInstitiutionSpecified = true;
				posUnit = Ucum.Hour;
				posFactor = 24 / posologyFactory;
				break;
			case N_TIMES_A_WEEK:
				posInstitiutionSpecified = true;
				posUnit = Ucum.Week;
				posFactor = 1.0 / posologyFactory;
				break;
			case N_TIMES_A_MONTH:
				posUnit = Ucum.Month;
				posFactor = 1.0 / posologyFactory;
				break;
			case EVERY_X_HOURS:
				posUnit = Ucum.Hour;
				posFactor = posologyFactory;
				break;
			case TIMING_EVENT:
				posUnit = null;
				posFactor = 0;
				break;
			case INSTANT_OF_TIME:
				throw new RuntimeException("not implemented yet");
			default:
				break;
			}
			setMedicationFrequencyPeriod(posFactor, posUnit, posInstitiutionSpecified, timingEvents, freqFactor,
					freqUnit, freqInstitiutionSpecified, doseQuantities);
			return true;
		}

		throw new RuntimeException("not implemented yet");
	}

	/**
	 * Setting the medication frequency according the mtps rules NOTE: first
	 * draft version, no support for TAPERED Dosing currently
	 *
	 * @param value
	 *            the value
	 * @param unit
	 *            the unit
	 * @param institutionSpecified
	 *            the institution specified
	 * @param timingEvents
	 *            the timing events
	 * @param freqValue
	 *            the freq value
	 * @param freqUnit
	 *            the freq unit
	 * @param freqInstitutionSpecified
	 *            the freq institution specified
	 * @param doseQuantities
	 *            the dose quantities
	 */
	private void setMedicationFrequencyPeriod(double value, Ucum unit, boolean institutionSpecified,
			TimingEvent[] timingEvents, double freqValue, Ucum freqUnit, boolean freqInstitutionSpecified,
			Value[] doseQuantities) {

		if (timingEvents == null && freqUnit == null) {
			setMedicationFrequencyEffectiveTime(getPeriod(value, unit, institutionSpecified, true));
			return;
		}

		if (unit == null && freqUnit == null && doseQuantities == null) {
			setMedicationFrequencyEffectiveTime(getTimingEvents(timingEvents, true));
			return;
		}

		boolean setOperatorA = false;
		final SXPR_TS sxcmTs = DatatypesFactory.eINSTANCE.createSXPR_TS();
		sxcmTs.setOperator(SetOperator.A);
		if (unit != null) {
			sxcmTs.getComps().add(getPeriod(value, unit, institutionSpecified, setOperatorA));
			setOperatorA = true;
		}

		if (freqUnit != null) {
			sxcmTs.getComps().add(getPeriod(freqValue, freqUnit, freqInstitutionSpecified, setOperatorA));
			setOperatorA = true;
		}
		if (timingEvents != null && doseQuantities == null) {
			final SXCM_TS eivlTs = getTimingEvents(timingEvents, setOperatorA);
			sxcmTs.getComps().add(eivlTs);
		}
		if (doseQuantities != null) {
			setSplitDosing();
			for (int i = 0; i < timingEvents.length; ++i) {
				this.setSubordinateSubstanceAdministration(i + 1, getTimingEvent(timingEvents[i], false, false),
						getIvlPq(doseQuantities[i]));
			}
			if (sxcmTs.getComps() != null && sxcmTs.getComps().size() == 0) {
				return;
			}
		}
		setMedicationFrequencyEffectiveTime(sxcmTs);
	}
}
