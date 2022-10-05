/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.emed;

import org.projecthusky.cda.elga.generated.artdecor.emed.MedikationPharmazeutischeEmpfehlungEntry;
import org.projecthusky.cda.elga.models.PrescriptionEntry;
import org.projecthusky.common.hl7cdar2.ActClassSupply;
import org.projecthusky.common.hl7cdar2.BL;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component4;
import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.projecthusky.common.hl7cdar2.POCDMT000040Material;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organizer;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.POCDMT000040Supply;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.XActClassDocumentEntryOrganizer;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;

public class PharmaceuticalRecommendationEntry  {

	private Identificator emedId;
	private Code state;
	private Identificator referencePrescription;
	private Identificator referenceDelivery;
	private PrescriptionEntry alteredPrescriptionEntry;
	private DispenseEntry alteredDeliveryEntry;

	public Code getState() {
		return state;
	}

	public void setState(Code state) {
		this.state = state;
	}

	public Identificator getReferencePrescription() {
		return referencePrescription;
	}

	public void setReferencePrescription(Identificator referencePrescription) {
		this.referencePrescription = referencePrescription;
	}

	public Identificator getReferenceDelivery() {
		return referenceDelivery;
	}

	public void setReferenceDelivery(Identificator referenceDelivery) {
		this.referenceDelivery = referenceDelivery;
	}

	public PrescriptionEntry getAlteredPrescriptionEntry() {
		return alteredPrescriptionEntry;
	}

	public void setAlteredPrescriptionEntry(PrescriptionEntry prescriptionEntry) {
		this.alteredPrescriptionEntry = prescriptionEntry;
	}

	public Identificator getEmedId() {
		return emedId;
	}

	public void setEmedId(Identificator emedId) {
		this.emedId = emedId;
	}

	public DispenseEntry getAlteredDeliveryEntry() {
		return alteredDeliveryEntry;
	}

	public void setAlteredDeliveryEntry(DispenseEntry alteredDeliveryEntry) {
		this.alteredDeliveryEntry = alteredDeliveryEntry;
	}

	public POCDMT000040Entry getMedikationPharmazeutischeEmpfehlungEntryemed(int indexRecommendation,
			Identificator gdaId, Code kindOfPrescription) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		MedikationPharmazeutischeEmpfehlungEntry pharmaceuticalRecommendation = new MedikationPharmazeutischeEmpfehlungEntry();

		if (emedId != null && gdaId != null) {
			II deliveryId = emedId.getHl7CdaR2Ii();
			deliveryId.setExtension(String.format("%s_%d", deliveryId.getExtension(), indexRecommendation));
			deliveryId.setAssigningAuthorityName(gdaId.getAssigningAuthorityName());
			pharmaceuticalRecommendation.getId().add(deliveryId);
		}

		if (state != null) {
			CD cd = state.getHl7CdaR2Cd();
			cd.setOriginalText(new ED(null, new TEL("#pharm-state-" + indexRecommendation)));
			pharmaceuticalRecommendation
					.setCode(cd);
		}

		pharmaceuticalRecommendation.setText(new ED(null, new TEL("#pepos-" + indexRecommendation)));
		pharmaceuticalRecommendation.setStatusCode(new CS("completed"));

		if (referencePrescription != null) {
			pharmaceuticalRecommendation.getEntryRelationship().add(getReferencePrescriptionEntryRel());
		}

		if (referenceDelivery != null) {
			pharmaceuticalRecommendation.getEntryRelationship().add(getReferenceDeliveryEntryRel());
		}
		
		if(alteredDeliveryEntry != null) {
			pharmaceuticalRecommendation.getEntryRelationship().add(getAlteredDeliveryEntryRel(1, gdaId));
		}
		
		if(alteredPrescriptionEntry != null) {
			pharmaceuticalRecommendation.getEntryRelationship().add(getAlteredPrescriptionEntryRel(1, gdaId, kindOfPrescription));
		}

		return entry;
	}

	public POCDMT000040EntryRelationship getReferencePrescriptionEntryRel() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.REFR);
		POCDMT000040SubstanceAdministration substanceAdministration = new POCDMT000040SubstanceAdministration();
		substanceAdministration.getClassCode().add("SBADM");
		substanceAdministration.setMoodCode(XDocumentSubstanceMood.INT);

		if (this.referencePrescription != null) {
			substanceAdministration.getId().add(this.referencePrescription.getHl7CdaR2Ii());
		}

		POCDMT000040Consumable consumable = new POCDMT000040Consumable();
		POCDMT000040ManufacturedProduct manufacturedProd = new POCDMT000040ManufacturedProduct();
		POCDMT000040Material material = new POCDMT000040Material();
		material.getNullFlavor().add("NA");
		manufacturedProd.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProd);
		substanceAdministration.setConsumable(consumable);

		entryRel.setSubstanceAdministration(substanceAdministration);

		return entryRel;
	}

	public POCDMT000040EntryRelationship getReferenceDeliveryEntryRel() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.REFR);
		POCDMT000040Supply supply = new POCDMT000040Supply();
		supply.setClassCode(ActClassSupply.SPLY);
		supply.setMoodCode(XDocumentSubstanceMood.EVN);

		if (this.referenceDelivery != null) {
			supply.getId().clear();
			supply.getId().add(this.referenceDelivery.getHl7CdaR2Ii());
		}

		entryRel.setSupply(supply);

		return entryRel;
	}

	public POCDMT000040EntryRelationship getAlteredDeliveryEntryRel(int index, Identificator gdaId) {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.REFR);
		entryRel.setInversionInd(false);
		entryRel.setSubstanceAdministration(this.alteredDeliveryEntry
				.getMedikationAbgabeSubstanceAdministration(index, gdaId));
		return entryRel;
	}

	public POCDMT000040EntryRelationship getAlteredPrescriptionEntryRel(int index, Identificator gdaId,
			Code kindOfPrescription) {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.REFR);
		entryRel.setInversionInd(false);
		POCDMT000040Organizer organizer = new POCDMT000040Organizer();
		organizer.setClassCode(XActClassDocumentEntryOrganizer.CLUSTER);
		organizer.getMoodCode().add("EVN");
		organizer.setStatusCode(new CS("completed"));

		POCDMT000040Component4 comp4 = new POCDMT000040Component4();
		BL bl = new BL();
		bl.setValue(false);
		comp4.setSeperatableInd(bl);
		comp4.setSubstanceAdministration(this.alteredPrescriptionEntry
				.getMedikationVerordnungEntryemedEmedication(index, gdaId, kindOfPrescription)
				.getSubstanceAdministration());
		organizer.getComponent().add(comp4);
		entryRel.setOrganizer(organizer);

		return entryRel;
	}

}
