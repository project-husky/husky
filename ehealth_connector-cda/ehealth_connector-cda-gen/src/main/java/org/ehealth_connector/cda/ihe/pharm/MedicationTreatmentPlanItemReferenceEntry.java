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

import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

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
	 *          the mdht
	 */
	public MedicationTreatmentPlanItemReferenceEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemReferenceEntry mdht) {
		super(mdht);
		String templateId = this.getTemplateId();
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().add(new Identificator(templateId, null).getIi());
		this.getMdht().setStatusCode(null);
		// mdht modeling issue codeSystem, codeSystemName is form ihe::Medication
		// fixed to snomed
		if ("2.16.840.1.113883.6.96".equals(this.getMdht().getCode().getCodeSystem())) {
			this.getMdht().getCode().setCodeSystem("1.3.6.1.4.1.19376.1.9.2.2");
			this.getMdht().getCode().setCodeSystemName("IHE Pharmacy Item Type List");
		}
		Consumable consumable = CDAFactory.eINSTANCE.createConsumable();
		ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE.createManufacturedProduct();
		Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		this.getMdht().setConsumable(consumable);
	}

}
