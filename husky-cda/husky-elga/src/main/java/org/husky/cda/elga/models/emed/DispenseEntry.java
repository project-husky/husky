/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.emed;

import java.util.ArrayList;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.emed.AlteredDosageInformation;
import org.husky.cda.elga.generated.artdecor.emed.Iddescontainers;
import org.husky.cda.elga.generated.artdecor.emed.MedikationAbgabeEntryemed;
import org.husky.cda.elga.generated.artdecor.emed.MedikationVerordnungEntryemed;
import org.husky.cda.elga.generated.artdecor.emed.PatientInstructions;
import org.husky.cda.elga.generated.artdecor.emed.PharmacistInstructions;
import org.husky.cda.elga.generated.artdecor.emed.Therapieart;
import org.husky.cda.elga.models.AdditionalInformation;
import org.husky.cda.elga.models.Dose;
import org.husky.cda.elga.models.Drug;
import org.husky.cda.elga.models.PeriodOfPrescription;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLPQ;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040Consumable;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040ExternalDocument;
import org.husky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.hl7cdar2.XDocumentSubstanceMood;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;

public class DispenseEntry  {

	private Code kindOfDelivery;
	private int packageAmount;
	private Drug drug;
	private Identificator prescriptionId;
	private List<AdditionalInformation> addInfoPatient;
	private List<AdditionalInformation> addInfoPharmacist;
	private Code kindOfTherapy;
	private List<Dose> alteredDoses;
	private Code alteredTypeOfApplication;
	private PeriodOfPrescription alteredPeriodOfPrescription;
	private Identificator emedId;
	
	public Code getKindOfDelivery() {
		return kindOfDelivery;
	}

	public void setKindOfDelivery(Code kindOfDelivery) {
		this.kindOfDelivery = kindOfDelivery;
	}
	public int getPackageAmount() {
		return packageAmount;
	}
	public void setPackageAmount(int packageAmount) {
		this.packageAmount = packageAmount;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	public Identificator getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(Identificator prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public List<AdditionalInformation> getAdditionalInformationPatient() {
		return addInfoPatient;
	}
	public void setAdditionalInformationPatient(List<AdditionalInformation> additionalInformationPatient) {
		this.addInfoPatient = additionalInformationPatient;
	}

	public List<AdditionalInformation> getAdditionalInformationPharmacist() {
		return addInfoPharmacist;
	}

	public void setAdditionalInformationPharmacist(List<AdditionalInformation> additionalInformationPharmacist) {
		this.addInfoPharmacist = additionalInformationPharmacist;
	}

	public Code getKindOfTherapy() {
		return kindOfTherapy;
	}

	public void setKindOfTherapy(Code kindOfTherapy) {
		this.kindOfTherapy = kindOfTherapy;
	}
	public List<Dose> getAlteredDoses() {
		return alteredDoses;
	}
	public void setAlteredDoses(List<Dose> alteredDoses) {
		this.alteredDoses = alteredDoses;
	}

	public Code getAlteredTypeOfApplication() {
		return alteredTypeOfApplication;
	}

	public void setAlteredTypeOfApplication(Code alteredTypeOfApplication) {
		this.alteredTypeOfApplication = alteredTypeOfApplication;
	}
	public PeriodOfPrescription getAlteredPeriodOfPrescription() {
		return alteredPeriodOfPrescription;
	}
	public void setAlteredPeriodOfPrescription(PeriodOfPrescription alteredPeriodOfPrescription) {
		this.alteredPeriodOfPrescription = alteredPeriodOfPrescription;
	}
	
	public Identificator getEmedId() {
		return emedId;
	}
	public void setEmedId(Identificator emedId) {
		this.emedId = emedId;
	}
	
	public POCDMT000040SubstanceAdministration getMedikationAbgabeSubstanceAdministration(int indexDelivery, Identificator gdaId) {
		POCDMT000040SubstanceAdministration substanceAdministration = new POCDMT000040SubstanceAdministration();
		substanceAdministration.getClassCode().add("SBADM");
		substanceAdministration.setMoodCode(XDocumentSubstanceMood.INT);
		substanceAdministration.getTemplateId().add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.6").getHl7CdaR2Ii());
		
		if (emedId != null && gdaId != null) {
			II deliveryId = emedId.getHl7CdaR2Ii();
			deliveryId.setExtension(String.format("%s_%d", deliveryId.getExtension(), indexDelivery));
			deliveryId.setAssigningAuthorityName(gdaId.getAssigningAuthorityName());
			substanceAdministration.getId().add(deliveryId);
		}
		
		substanceAdministration.setText(new ED(null, new TEL("#apos-" + indexDelivery)));
		substanceAdministration.setStatusCode(new CS("completed"));
		
		if(this.packageAmount > 0) {
			substanceAdministration.setDoseQuantity(new IVLPQ(String.valueOf(packageAmount)));
		} else {
			IVLPQ mskPq = new IVLPQ();
			mskPq.nullFlavor = new ArrayList<>();
			mskPq.nullFlavor.add("MSK");
			substanceAdministration.setDoseQuantity(mskPq);
		}
		
		if (this.drug != null) {
			POCDMT000040Consumable consumable = new POCDMT000040Consumable();
			POCDMT000040ManufacturedProduct manufacturedProduct = new POCDMT000040ManufacturedProduct();
			POCDMT000040Material material = new POCDMT000040Material();
			material.getNullFlavor().add("NA");
			manufacturedProduct.setManufacturedMaterial(material);
			consumable.setManufacturedProduct(manufacturedProduct);
			substanceAdministration.setConsumable(consumable);
		}
		
		if(this.prescriptionId != null) {			
			substanceAdministration.getEntryRelationship().add(getReferencePrescription());
		}
		
		if (this.addInfoPatient != null && !this.addInfoPatient.isEmpty()) {
			substanceAdministration.getEntryRelationship().add(getPatientInstructions());
		}

		if (this.addInfoPharmacist != null && !this.addInfoPharmacist.isEmpty()) {			
			substanceAdministration.getEntryRelationship().add(getPharmInstructions());
		}
		
		if(this.kindOfTherapy != null && kindOfTherapy.getCode() != null) {
			substanceAdministration.getEntryRelationship().add(getEntryRelKindOfTherapy());
		}
	
		if(this.alteredDoses != null || this.alteredPeriodOfPrescription != null || this.alteredTypeOfApplication != null) {
			substanceAdministration.getEntryRelationship().add(getAlteredDosageInformationEntryRel()); 
		}
		
		if (this.emedId != null) {
			substanceAdministration.getReference().add(getReferencePrescriptionEMedId());
		}

		return substanceAdministration;
	}
	
	public POCDMT000040Entry getMedikationAbgabeEntryemed(int indexDelivery, Identificator gdaId) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		MedikationAbgabeEntryemed supply = new MedikationAbgabeEntryemed();

		if (emedId != null && gdaId != null) {
			II deliveryId = emedId.getHl7CdaR2Ii();
			deliveryId.setExtension(String.format("%s_%d", deliveryId.getExtension(), indexDelivery));
			deliveryId.setAssigningAuthorityName(gdaId.getAssigningAuthorityName());
			supply.getId().add(deliveryId);
		}
		
		supply.setText(new ED(null, new TEL("#apos-" + indexDelivery)));
		supply.setStatusCode(new CS("completed"));
		
		if(this.packageAmount > 0) {
			supply.setQuantity(new PQ(String.valueOf(packageAmount)));
		} else {
			PQ mskPq = new PQ();
			mskPq.nullFlavor = new ArrayList<>();
			mskPq.nullFlavor.add("MSK");
			supply.setQuantity(mskPq);
		}
		
		if (this.drug != null) {
			supply.setProduct(this.drug.getArzneiEntryDelivery(indexDelivery));
		}
		
		if(this.prescriptionId != null) {			
			supply.getEntryRelationship().add(getReferencePrescription());
		}
		
		if (this.addInfoPatient != null && !this.addInfoPatient.isEmpty()) {
			supply.getEntryRelationship().add(getPatientInstructions());
		}

		if (this.addInfoPharmacist != null && !this.addInfoPharmacist.isEmpty()) {			
			supply.getEntryRelationship().add(getPharmInstructions());
		}
		
		if(this.kindOfTherapy != null && kindOfTherapy.getCode() != null) {
			supply.getEntryRelationship().add(getEntryRelKindOfTherapy());
		}
	
		if(this.alteredDoses != null || this.alteredPeriodOfPrescription != null || this.alteredTypeOfApplication != null) {
			supply.getEntryRelationship().add(getAlteredDosageInformationEntryRel()); 
		}
		
		if (this.emedId != null) {
			supply.getReference().add(getReferencePrescriptionEMedId());
		}

		entry.setSupply(supply);

		return entry;
	}
	
	public POCDMT000040EntryRelationship getReferencePrescription() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.REFR);
		POCDMT000040SubstanceAdministration substanceAdministration = new POCDMT000040SubstanceAdministration();
		substanceAdministration.getClassCode().add("SBADM");
		substanceAdministration.setMoodCode(XDocumentSubstanceMood.INT);
		
		if(this.prescriptionId != null) {
			substanceAdministration.getId().add(this.prescriptionId.getHl7CdaR2Ii());
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
	
	public POCDMT000040EntryRelationship getPatientInstructions() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
		entryRel.setInversionInd(true);

		PatientInstructions patInstructions = new PatientInstructions();
		patInstructions.setText(new ED(null, new TEL("#patinfo-" + 0)));

		int index = 1;
		for (AdditionalInformation info : this.addInfoPatient) {
			if (info != null && info.getKindOfInformation() != null) {
				patInstructions.addHl7EntryRelationship(info.getEntryRelationshipForPatientInformation(index++));
			}
		}

		entryRel.setAct(patInstructions);
		return entryRel;
	}
	
	public POCDMT000040EntryRelationship getPharmInstructions() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
		entryRel.setInversionInd(true);
		PharmacistInstructions pharmInstructions = new PharmacistInstructions();

		int index = 1;
		for (AdditionalInformation info : this.addInfoPharmacist) {
			if (info != null && info.getKindOfInformation() != null) {
				pharmInstructions.addHl7EntryRelationship(info.getEntryRelationshipForDispenseInformation(index++));
				index++;
			}
		}

		entryRel.setAct(pharmInstructions);
		return entryRel;
	}
	
	public POCDMT000040EntryRelationship getEntryRelKindOfTherapy() {
		Therapieart therapieArtEntryRel = new Therapieart();
		POCDMT000040Act act = therapieArtEntryRel.getAct();
		act.setCode(this.kindOfTherapy.getHl7CdaR2Ce());
		therapieArtEntryRel.setAct(act);
		return therapieArtEntryRel;
	}
	
	public POCDMT000040EntryRelationship getAlteredDosageInformationEntryRel() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		
		AlteredDosageInformation alteredDosageInfoEntryRel = new AlteredDosageInformation();
		alteredDosageInfoEntryRel.setRouteCode(this.alteredTypeOfApplication.getHl7CdaR2Ce());
		
		POCDMT000040Consumable consumable = new POCDMT000040Consumable();
		POCDMT000040ManufacturedProduct manufacturedProduct = new POCDMT000040ManufacturedProduct();
		POCDMT000040Material material = new POCDMT000040Material();
		material.getNullFlavor().add("NA");
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		alteredDosageInfoEntryRel.setConsumable(consumable);
		
		if (this.alteredPeriodOfPrescription != null
				&& (this.alteredPeriodOfPrescription.getStartIntake() != null || this.alteredPeriodOfPrescription.getFrequence() != null)) {
			alteredDosageInfoEntryRel.getTemplateId().add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531421());
			alteredDosageInfoEntryRel.setHl7EffectiveTime(this.alteredPeriodOfPrescription.getEinnahmedauer());
		}
		
		if (this.alteredDoses != null && !this.alteredDoses.isEmpty()) {
			int index = 1;
			for (Dose dose : this.alteredDoses) {
				if (dose != null) {
					if (dose.getFrequence() != null && dose.getDays() != null && !dose.getDays().isEmpty()) {
						/*
						 * createDailyDoseWithPauseMultipleWeekDays(substance, dose.getDays(),
						 * dose.getFrequence(), dose.getQuantity(), dose.getUnit());
						 */
						POCDMT000040EntryRelationship entryRelDose = new POCDMT000040EntryRelationship();
						POCDMT000040SubstanceAdministration substanceAdmin = new POCDMT000040SubstanceAdministration();
						substanceAdmin.getEffectiveTime().add(dose.getDosierung3dqDailyDoseWithPauseMultipleWeekDays());
						entryRel.setSubstanceAdministration(substanceAdmin);
						alteredDosageInfoEntryRel.getEntryRelationship().add(entryRel);
						alteredDosageInfoEntryRel.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471());
					} else if (dose.getFrequence() != null) {
						alteredDosageInfoEntryRel.getEffectiveTime().add(dose.getDosierung1DailyDose());
						alteredDosageInfoEntryRel.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471());
					}

					if (dose.getIntakeTime() != null && dose.getDays() != null && !dose.getDays().isEmpty()) {
						alteredDosageInfoEntryRel.getEntryRelationship().add(dose.getDosierung4erSingleDoseWithPause(index++));
						alteredDosageInfoEntryRel.getTemplateId()
								.remove(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
						alteredDosageInfoEntryRel.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
					} else if (dose.getIntakeTime() != null) {
						alteredDosageInfoEntryRel.getEntryRelationship().add(dose.getDosierung2erSingleDose(index++));
						alteredDosageInfoEntryRel.getTemplateId()
								.remove(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
						alteredDosageInfoEntryRel.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
					}
				}
			}

		}

		entryRel.setSubstanceAdministration(alteredDosageInfoEntryRel);
		return entryRel;
	}
	
	protected Iddescontainers getReferencePrescriptionEMedId() {
		if(emedId != null) {
			Iddescontainers idContainer = new Iddescontainers();
			POCDMT000040ExternalDocument doc = new POCDMT000040ExternalDocument();
			doc.setSetId(this.emedId.getHl7CdaR2Ii());
			idContainer.setExternalDocument(doc);
			return idContainer;
		}
		
		return null;
	}
}
