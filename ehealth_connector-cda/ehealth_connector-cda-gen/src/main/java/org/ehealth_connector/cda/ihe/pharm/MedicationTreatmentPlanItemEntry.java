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
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Implements the IHE MedicationTreatmentPlanItemEntry.
 */
public class MedicationTreatmentPlanItemEntry extends MedicationItemEntry {

	/**
	 * Instantiates a new medication treatment plan item entry.
	 */
	public MedicationTreatmentPlanItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new medication treatment plan item entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public MedicationTreatmentPlanItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createMedicationTreatmentPlanItemEntry().init());

		this.getMdht().setClassCode(ActClass.SBADM);
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);

		// Priority code --> null flavor
		final CE nullFlavorCode = DatatypesFactory.eINSTANCE.createCE();
		nullFlavorCode.setNullFlavor(NullFlavor.NA);
		this.getMdht().setPriorityCode(nullFlavorCode);
	}

	/**
	 * Instantiates a new medication treatment plan item entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public MedicationTreatmentPlanItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry mdht) {
		super(mdht);
	}

	/**
	 * <div class="en">Creates a Reference to a Medication Treatment Plan Entry
	 * using the eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param mtpe
	 *            <div class="en">Medication Treatment Plan Entry to which we
	 *            need a reference</div> <div class="de"></div>
	 *            <div class="fr"></div>
	 *
	 * @return <div class="en">created Reference to Medication Treatment Plan
	 *         Entry</div> <div class="de"></div> <div class="fr"></div>
	 */

	public MedicationTreatmentPlanItemReferenceEntry createMTPItemReferenceEntry() {

		final MedicationTreatmentPlanItemReferenceEntry referenceEntry = new MedicationTreatmentPlanItemReferenceEntry();

		final CD cd = DatatypesFactory.eINSTANCE.createCD();

		cd.setCode(PharmacyItemTypeList.MTPItem.getCode().getCode());
		cd.setCodeSystem(PharmacyItemTypeList.CODE_SYSTEM_OID);
		cd.setCodeSystemName(PharmacyItemTypeList.CODE_SYSTEM_NAME);
		cd.setDisplayName(PharmacyItemTypeList.MTPItem.getCode().getDisplayName());

		referenceEntry.getMdht().setCode(cd);

		referenceEntry.getMdht().setRouteCode(null);
		referenceEntry.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);
		referenceEntry.getMdht().setClassCode(ActClass.SBADM);
		referenceEntry.getMdht().getIds().add(this.getId().getIi());

		return referenceEntry;
	}
}
