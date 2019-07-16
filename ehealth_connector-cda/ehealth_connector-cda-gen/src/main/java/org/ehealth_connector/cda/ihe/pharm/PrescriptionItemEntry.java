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

import org.ehealth_connector.cda.ihe.pharm.enums.PharmacyItemTypeList;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

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
	 *            the language code
	 */
	public PrescriptionItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPrescriptionItemEntry().init());

		this.getMdht().setClassCode(ActClass.SBADM);
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);

		// Priority code --> null flavor
		final CE nullFlavorCode = DatatypesFactory.eINSTANCE.createCE();
		nullFlavorCode.setNullFlavor(NullFlavor.NA);
		this.getMdht().setPriorityCode(nullFlavorCode);

	}

	/**
	 * Instantiates a new prescription item entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PrescriptionItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry mdht) {
		super(mdht);
	}

	/**
	 * <div class="en">Creates a Reference to a PRE Entry using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">created Reference to PRE Entry</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public PrescriptionItemReferenceEntry createPreItemReferenceEntry() {

		final PrescriptionItemReferenceEntry referenceEntry = new PrescriptionItemReferenceEntry();

		CD cd = DatatypesFactory.eINSTANCE.createCD();

		cd.setCode(PharmacyItemTypeList.PREItem.getCode().getCode());
		cd.setCodeSystem(PharmacyItemTypeList.CODE_SYSTEM_OID);
		cd.setCodeSystemName(PharmacyItemTypeList.CODE_SYSTEM_NAME);
		cd.setDisplayName(PharmacyItemTypeList.PREItem.getCode().getDisplayName());

		referenceEntry.getMdht().setCode(cd);

		referenceEntry.getMdht().setRouteCode(null);
		referenceEntry.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);
		referenceEntry.getMdht().setClassCode(ActClass.SBADM);
		referenceEntry.getMdht().getIds().add(this.getId().getIi());

		return referenceEntry;
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
	 *            the new medication treatment plan item reference entry
	 */
	public void setMedicationTreatmentPlanItemReferenceEntry(
			MedicationTreatmentPlanItemReferenceEntry entry) {
		final MedicationTreatmentPlanItemReferenceEntry old = getMedicationTreatmentPlanItemReferenceEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSubstanceAdministration(entry.getMdht());
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationship = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setSubstanceAdministration(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}
}
