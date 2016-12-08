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
 * Year of publication: 2016
 *
 *******************************************************************************/

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
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
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
	private MedicationItemEntry medicationItemEntry;

	/**
	 * Instantiates a new medication frequency content module.
	 *
	 * @param medicationItemEntry the medication item entry
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
		EList<SXCM_TS> effectiveTimes = medicationItemEntry.getMdht().getEffectiveTimes();
		if (effectiveTimes.size() > 1) {
			return effectiveTimes.get(1);
		}
		return null;
	}

	/**
	 * Gets the period.
	 *
	 * @param value the value
	 * @param unit the unit
	 * @param institutionSpecified the institution specified
	 * @param setOperatorA the set operator A
	 * @return the period
	 */
	protected SXCM_TS getPeriod(double value, Ucum unit, boolean institutionSpecified,
			boolean setOperatorA) {
		PIVL_TS pivlTs = DatatypesFactory.eINSTANCE.createPIVL_TS();
		if (setOperatorA) {
			pivlTs.setOperator(SetOperator.A);
		}
		pivlTs.setInstitutionSpecified(institutionSpecified);
		pivlTs.setPeriod(DatatypesFactory.eINSTANCE.createPQ(value, unit.getCodeValue()));
		return pivlTs;
	}

	/**
	 * Gets the subordinate substance administration.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the subordinate substance administration
	 */
	protected SubstanceAdministration getSubordinateSubstanceAdministration(int sequenceNumber) {
		return this.medicationItemEntry.getSubordinateSubstanceAdministration(sequenceNumber);
	}

	/**
	 * Gets the subordinate substance administration dose quantity.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the subordinate substance administration dose quantity
	 */
	protected IVL_PQ getSubordinateSubstanceAdminiatrationDoseQuantity(int sequenceNumber) {
		SubstanceAdministration sub = medicationItemEntry
				.getSubordinateSubstanceAdministration(sequenceNumber);
		return sub.getDoseQuantity();
	}

	/**
	 * Gets the subordinate substance administration effective time.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the subordinate substance administration effective time
	 */
	protected SXCM_TS getSubordinateSubstanceAdminiatrationEffectiveTime(int sequenceNumber) {
		SubstanceAdministration sub = medicationItemEntry
				.getSubordinateSubstanceAdministration(sequenceNumber);
		return sub.getEffectiveTimes().get(0);
	}

	/**
	 * Gets the timing event.
	 *
	 * @param timingEvent the timing event
	 * @param setOperatorA the set operator A
	 * @param setOperatorI the set operator I
	 * @return the timing event
	 */
	protected EIVL_TS getTimingEvent(TimingEvent timingEvent, boolean setOperatorA,
			boolean setOperatorI) {
		EIVL_TS eivlTs = DatatypesFactory.eINSTANCE.createEIVL_TS();
		EIVL_event event = DatatypesFactory.eINSTANCE.createEIVL_event();
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
	 * @param timingEvents the timing events
	 * @param setOperatorA the set operator A
	 * @return the timing events
	 */
	protected SXCM_TS getTimingEvents(TimingEvent[] timingEvents, boolean setOperatorA) {
		if (timingEvents == null) {
			return null;
		}
		if (timingEvents.length == 1) {
			return getTimingEvent(timingEvents[0], setOperatorA, false);
		}
		SXPR_TS sxcmTs = DatatypesFactory.eINSTANCE.createSXPR_TS();
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
		for (II ii : medicationItemEntry.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.9".equals(ii.getRoot())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets the medication frequency effective time.
	 *
	 * @param frequency the new medication frequency effective time
	 */
	protected void setMedicationFrequencyEffectiveTime(SXCM_TS frequency) {
		EList<SXCM_TS> effectiveTimes = medicationItemEntry.getMdht().getEffectiveTimes();
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
	 * @param sequenceNumber the sequence number
	 * @param effectiveTime the effective time
	 * @param doseQuantity the dose quantity
	 */
	protected void setSubordinateSubstanceAdministration(int sequenceNumber, SXCM_TS effectiveTime,
			IVL_PQ doseQuantity) {
		SubstanceAdministration sub = CDAFactory.eINSTANCE.createSubstanceAdministration();
		sub.setMoodCode(x_DocumentSubstanceMood.INT);

		final Consumable consumable = CDAFactory.eINSTANCE.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		sub.setConsumable(consumable);

		sub.getEffectiveTimes().add(effectiveTime);
		sub.setDoseQuantity(doseQuantity);

		this.medicationItemEntry.setSubordinateSubstanceAdminsitration(sequenceNumber, sub);
	}

}
