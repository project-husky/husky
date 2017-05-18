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

package org.ehealth_connector.cda.ihe.pharm;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.ihe.pharm.enums.TimingEvent;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.Ucum;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_event;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.PIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXPR_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.SetOperator;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Implements the IHE MedicationFrequencyContentModule.
 */
public class MedicationFrequencyContentModule {

	/** The medication item entry. */
	private final MedicationItemEntry medicationItemEntry;

	/**
	 * Instantiates a new medication frequency content module.
	 *
	 * @param medicationItemEntry
	 *            the medication item entry
	 */
	public MedicationFrequencyContentModule(MedicationItemEntry medicationItemEntry) {
		this.medicationItemEntry = medicationItemEntry;
	}

	/**
	 * Gets the max subordinate sequence number.
	 *
	 * @return the max subordinate sequence number
	 */
	protected int getMaxSubordinateSequenceNumber() {
		return this.medicationItemEntry.getMaxSubordinateSequenceNumber();
	}

	/**
	 * Gets the medication frequency effective time.
	 *
	 * @return the medication frequency effective time
	 */
	protected SXCM_TS getMedicationFrequencyEffectiveTime() {
		final EList<SXCM_TS> effectiveTimes = medicationItemEntry.getMdht().getEffectiveTimes();
		if (effectiveTimes.size() > 1) {
			return effectiveTimes.get(1);
		}
		return null;
	}

	/**
	 * Gets the period.
	 *
	 * @param value
	 *            the value
	 * @param unit
	 *            the unit
	 * @param institutionSpecified
	 *            the institution specified
	 * @param setOperatorA
	 *            the set operator A
	 * @return the period
	 */
	protected SXCM_TS getPeriod(double value, Ucum unit, boolean institutionSpecified,
			boolean setOperatorA) {
		final PIVL_TS pivlTs = DatatypesFactory.eINSTANCE.createPIVL_TS();
		if (setOperatorA) {
			pivlTs.setOperator(SetOperator.A);
		}
		pivlTs.setInstitutionSpecified(institutionSpecified);
		pivlTs.setPeriod(DatatypesFactory.eINSTANCE.createPQ(value, unit.getCodeValue()));
		return pivlTs;
	}

	/**
	 * Gets the subordinate substance administration dose quantity.
	 *
	 * @param sequenceNumber
	 *            the sequence number
	 * @return the subordinate substance administration dose quantity
	 */
	protected IVL_PQ getSubordinateSubstanceAdministrationDoseQuantity(int sequenceNumber) {
		final org.ehealth_connector.cda.ihe.pharm.SubstanceAdministration sub = medicationItemEntry
				.getSubordinateSubstanceAdministration(sequenceNumber);
		return sub.getDoseQuantity();
	}

	/**
	 * Gets the subordinate substance administration effective time.
	 *
	 * @param sequenceNumber
	 *            the sequence number
	 * @return the subordinate substance administration effective time
	 */
	protected SXCM_TS getSubordinateSubstanceAdministrationEffectiveTime(int sequenceNumber) {
		final org.ehealth_connector.cda.ihe.pharm.SubstanceAdministration sub = medicationItemEntry
				.getSubordinateSubstanceAdministration(sequenceNumber);
		return sub.getMdht().getEffectiveTimes().get(0);
	}

	/**
	 * Gets the subordinate substance administration.
	 *
	 * @param sequenceNumber
	 *            the sequence number
	 * @return the subordinate substance administration
	 */
	protected org.ehealth_connector.cda.ihe.pharm.SubstanceAdministration getSubordinateSubstanceAdministration(int sequenceNumber) {
		return this.medicationItemEntry.getSubordinateSubstanceAdministration(sequenceNumber);
	}

	/**
	 * Gets the timing event.
	 *
	 * @param timingEvent
	 *            the timing event
	 * @param setOperatorA
	 *            the set operator A
	 * @param setOperatorI
	 *            the set operator I
	 * @return the timing event
	 */
	protected EIVL_TS getTimingEvent(TimingEvent timingEvent, boolean setOperatorA,
			boolean setOperatorI) {
		final EIVL_TS eivlTs = DatatypesFactory.eINSTANCE.createEIVL_TS();
		final EIVL_event event = DatatypesFactory.eINSTANCE.createEIVL_event();
		event.setCode(timingEvent.getCode(null).getCode());
		if (setOperatorA) {
			eivlTs.setOperator(SetOperator.A);
		}
		if (setOperatorI) {
			eivlTs.setOperator(SetOperator.I);
		}
		eivlTs.setEvent(event);
		return eivlTs;
	}

	/**
	 * Gets the timing events.
	 *
	 * @param timingEvents
	 *            the timing events
	 * @param setOperatorA
	 *            the set operator A
	 * @return the timing events
	 */
	protected SXCM_TS getTimingEvents(TimingEvent[] timingEvents, boolean setOperatorA) {
		if (timingEvents == null) {
			return null;
		}
		if (timingEvents.length == 1) {
			return getTimingEvent(timingEvents[0], setOperatorA, false);
		}
		final SXPR_TS sxcmTs = DatatypesFactory.eINSTANCE.createSXPR_TS();
		if (setOperatorA) {
			sxcmTs.setOperator(SetOperator.A);
		}
		for (int i = 0; i < timingEvents.length; ++i) {
			sxcmTs.getComps().add(getTimingEvent(timingEvents[i], false, i > 0));
		}
		return sxcmTs;
	}

	/**
	 * Checks for split dosing.
	 *
	 * @return true, if successful
	 */
	public boolean hasSplitDosing() {
		for (final II ii : medicationItemEntry.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.9".equals(ii.getRoot())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets the medication frequency effective time.
	 *
	 * @param frequency
	 *            the new medication frequency effective time
	 */
	protected void setMedicationFrequencyEffectiveTime(SXCM_TS frequency) {
		final EList<SXCM_TS> effectiveTimes = medicationItemEntry.getMdht().getEffectiveTimes();
		if (effectiveTimes.size() == 0) {
			effectiveTimes.add(DatatypesFactory.eINSTANCE.createSXCM_TS());
		}
		if (effectiveTimes.size() == 1) {
			effectiveTimes.add(frequency);
		} else {
			effectiveTimes.set(1, frequency);
		}
	}

	/**
	 * Sets the split dosing.
	 */
	public void setSplitDosing() {
		if (!hasSplitDosing()) {
			this.medicationItemEntry.getMdht().getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.9", null).getIi());
		}
	}

	/**
	 * Sets the subordinate substance administration.
	 *
	 * @param sequenceNumber
	 *            the sequence number
	 * @param effectiveTime
	 *            the effective time
	 * @param doseQuantity
	 *            the dose quantity
	 */
	protected void setSubordinateSubstanceAdministration(int sequenceNumber, SXCM_TS effectiveTime,
			IVL_PQ doseQuantity) {
		final org.ehealth_connector.cda.ihe.pharm.SubstanceAdministration sub = new org.ehealth_connector.cda.ihe.pharm.SubstanceAdministration();

		final org.ehealth_connector.cda.Consumable consumable = new org.ehealth_connector.cda.Consumable(false);
		final org.ehealth_connector.cda.ihe.pharm.ManufacturedProduct manufacturedProduct = new org.ehealth_connector.cda.ihe.pharm.ManufacturedProduct();
		final ManufacturedMaterial material = new ManufacturedMaterial();
		material.setNullFlavored();
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		sub.setConsumable(consumable);
		sub.getMdht().getEffectiveTimes().add(effectiveTime);
		sub.setDoseQuantity(doseQuantity);

		this.medicationItemEntry.setSubordinateSubstanceAdministration(sequenceNumber, sub);
	}

}
