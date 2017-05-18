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
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Implements the IHE MedicationTreatmentPlanItemReferenceEntry.
 */
public class MedicationTreatmentPlanItemReferenceEntry extends MedicationTreatmentPlanItemEntry {

	/**
	 * Instantiates a new medication treatment plan item reference entry.
	 */
	public MedicationTreatmentPlanItemReferenceEntry() {
		this(PHARMFactory.eINSTANCE.createMedicationTreatmentPlanItemReferenceEntry().init());
	}

	/**
	 * Instantiates a new medication treatment plan item reference entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public MedicationTreatmentPlanItemReferenceEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemReferenceEntry mdht) {
		super(mdht);
		final String templateId = this.getTemplateId();
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().add(new Identificator(templateId, null).getIi());
		this.getMdht().setStatusCode(null);
		// mdht modeling issue codeSystem, codeSystemName is form
		// ihe::Medication
		// fixed to snomed
		if ("2.16.840.1.113883.6.96".equals(this.getMdht().getCode().getCodeSystem())) {
			this.getMdht().getCode().setCodeSystem("1.3.6.1.4.1.19376.1.9.2.2");
			this.getMdht().getCode().setCodeSystemName("IHE Pharmacy Item Type List");
		}
		final Consumable consumable = CDAFactory.eINSTANCE.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		this.getMdht().setConsumable(consumable);
	}

	/**
	 * Instantiates a new medication treatment plan item reference entry.
	 *
	 * @param itemId
	 *            IF of referenced item
	 */
	public MedicationTreatmentPlanItemReferenceEntry(Identificator itemId) {

		this(PHARMFactory.eINSTANCE.createMedicationTreatmentPlanItemReferenceEntry().init());

		final CD cd = DatatypesFactory.eINSTANCE.createCD();

		cd.setCode(PharmacyItemTypeList.MTPItem.getCode().getCode());
		cd.setCodeSystem(PharmacyItemTypeList.CODE_SYSTEM_OID);
		cd.setCodeSystemName(PharmacyItemTypeList.CODE_SYSTEM_NAME);
		cd.setDisplayName(PharmacyItemTypeList.MTPItem.getCode().getDisplayName());

		this.getMdht().setCode(cd);

		this.getMdht().setRouteCode(null);
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);
		this.getMdht().setClassCode(ActClass.SBADM);
		this.getMdht().getIds().add(itemId.getIi());
	}


}
