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

import org.ehealth_connector.cda.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Implements the IHE PrescriptionItemEntry.
 */
public class PrescriptionItemEntry extends MedicationItemEntry {

	/**
	 * Instantiates a new prescription item entry.
	 */
	public PrescriptionItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new prescription item entry.
	 *
	 * @param languageCode
	 *          the language code
	 */
	public PrescriptionItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPrescriptionItemEntry().init());
	}

	/**
	 * Instantiates a new prescription item entry.
	 *
	 * @param mdht
	 *          the mdht
	 */
	public PrescriptionItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry mdht) {
		super(mdht);
	}

	/**
	 * Gets the medication treatment plan item reference entry.
	 *
	 * @return the medication treatment plan item reference entry
	 */
	public MedicationTreatmentPlanItemReferenceEntry getMedicationTreatmentPlanItemReferenceEntry() {
		if (((org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry) getMdht())
				.getMedicationTreatmentPlanItemReferenceEntry() != null) {
			return new MedicationTreatmentPlanItemReferenceEntry(
					((org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry) getMdht())
							.getMedicationTreatmentPlanItemReferenceEntry());
		}
		return null;
	}

	/**
	 * Sets the medication treatment plan item reference entry.
	 *
	 * @param entry
	 *          the new medication treatment plan item reference entry
	 */
	public void setMedicationTreatmentPlanItemReferenceEntry(
			MedicationTreatmentPlanItemReferenceEntry entry) {
		MedicationTreatmentPlanItemReferenceEntry old = getMedicationTreatmentPlanItemReferenceEntry();
		if (old != null) {
			for (EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSubstanceAdministration(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setSubstanceAdministration(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

}
