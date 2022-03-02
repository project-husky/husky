/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.emed.Iddescontainers;
import org.husky.cda.elga.generated.artdecor.emed.MedikationVerordnungEntryemed;
import org.husky.cda.elga.generated.artdecor.emed.PatientInstructions;
import org.husky.cda.elga.generated.artdecor.emed.PharmacistInstructions;
import org.husky.cda.elga.generated.artdecor.emed.Therapieart;
import org.husky.cda.elga.generated.artdecor.emed.enums.ElgaMedikationRezeptart;
import org.husky.common.hl7cdar2.ActClassSupply;
import org.husky.common.hl7cdar2.BL;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLINT;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040ExternalDocument;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.POCDMT000040Supply;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.hl7cdar2.SXCMTS;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.XActRelationshipEntry;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.hl7cdar2.XDocumentSubstanceMood;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrescriptionEntry  {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionEntry.class.getName());
	public static final String TEMPLATE_ID_KIND_OF_THERAPY = "1.2.40.0.34.11.8.1.3.4";
	private ZonedDateTime changeDate;
	private List<Dose> doses;
	private PeriodOfPrescription periodOfPrescription;
	private int amountPackages;
	private int amountPossibleDispenses;
	private Code kindOfTherapy;
	private Code typeOfApplication;
	private String id;
	private List<AdditionalInformation> addInfoPat;
	private List<AdditionalInformation> addInfoPharm;
	private Drug drug;
	private Magistraliter magistraliter;
	private Identificator emedId;

	public PrescriptionEntry(POCDMT000040Entry entry) {
		if (entry != null && entry.getSubstanceAdministration() != null) {
			if (entry.getSubstanceAdministration().getEffectiveTime() != null) {
				for (SXCMTS time : entry.getSubstanceAdministration().getEffectiveTime()) {
					if (time instanceof IVLTS ivlts) {
						periodOfPrescription = new PeriodOfPrescription(ivlts);
					}
				}
			}

			if (entry.getSubstanceAdministration().getConsumable() != null) {
				this.drug = new Drug(entry.getSubstanceAdministration().getConsumable());
			}

			if (entry.getSubstanceAdministration().getEntryRelationship() != null) {
				for (POCDMT000040EntryRelationship entryRel : entry.getSubstanceAdministration()
						.getEntryRelationship()) {
					if (entryRel != null && entryRel.getAct() != null && entryRel.getAct().getCode() != null
							&& "PINSTRUCT".equalsIgnoreCase(entryRel.getAct().getCode().getCode())) {
						this.addInfoPat = new ArrayList<>();
						for (POCDMT000040EntryRelationship entryR : entryRel.getAct().getEntryRelationship()) {
							addInfoPat.add(new AdditionalInformation(entryR));
						}
					} else if (entryRel != null && entryRel.getAct() != null && entryRel.getAct().getCode() != null
							&& "FINSTRUCT".equalsIgnoreCase(entryRel.getAct().getCode().getCode())) {
						this.addInfoPharm = new ArrayList<>();
						for (POCDMT000040EntryRelationship entryR : entryRel.getAct().getEntryRelationship()) {
							addInfoPharm.add(new AdditionalInformation(entryR));
						}
					} else if (entryRel != null && entryRel.getAct() != null && entryRel.getAct().getCode() != null
							&& entryRel.getAct().getTemplateId() != null
							&& entryRel.getAct().getTemplateId().stream().anyMatch(
									tempId -> TEMPLATE_ID_KIND_OF_THERAPY.equalsIgnoreCase(tempId.getRoot()))) {
						this.kindOfTherapy = new Code(entryRel.getAct().getCode());
					} else if (entryRel != null && entryRel.getSupply() != null
							&& entryRel.getSupply().getQuantity() != null) {
						try {
							this.amountPossibleDispenses = Integer
									.parseInt(entryRel.getSupply().getQuantity().getValue());
						} catch (NumberFormatException ex) {
							LOGGER.error(ex.getMessage());
						}
					} else if (entryRel != null && entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.COMP)
							&& entryRel.getSubstanceAdministration() != null) {
						if (this.doses == null) {
							this.doses = new ArrayList<>();
						}
						this.doses.add(new Dose(entryRel.getSubstanceAdministration()));
					}
				}
			}
		}
	}

	public List<AdditionalInformation> getAddInfoPat() {
		return addInfoPat;
	}

	public List<AdditionalInformation> getAddInfoPharm() {
		return addInfoPharm;
	}

	public int getAmountPackages() {
		return amountPackages;
	}

	public int getAmountPossibleDispenses() {
		return amountPossibleDispenses;
	}

	public ZonedDateTime getChangeDate() {
		return changeDate;
	}

	public Drug getDrug() {
		return drug;
	}

	public Identificator getEmedId() {
		return emedId;
	}

	public String getId() {
		return id;
	}

	public Code getKindOfTherapy() {
		return kindOfTherapy;
	}

	public Magistraliter getMagistraliter() {
		return magistraliter;
	}

	public PeriodOfPrescription getPeriodOfPrescription() {
		return periodOfPrescription;
	}

	public List<Dose> getSingleDoses() {
		return doses;
	}

	public void setAddInfoPat(List<AdditionalInformation> addInfoPat) {
		this.addInfoPat = addInfoPat;
	}

	public void setAddInfoPharm(List<AdditionalInformation> addInfoPharm) {
		this.addInfoPharm = addInfoPharm;
	}

	public void setAmountPackages(int amountPackages) {
		this.amountPackages = amountPackages;
	}

	public void setAmountPossibleDispenses(int amountPossibleDispenses) {
		this.amountPossibleDispenses = amountPossibleDispenses;
	}

	public void setChangeDate(ZonedDateTime changeDate) {
		this.changeDate = changeDate;
	}

	public void setDoses(List<Dose> doses) {
		this.doses = doses;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public void setEmedId(Identificator emedId) {
		this.emedId = emedId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setKindOfTherapy(Code kindOfTherapy) {
		this.kindOfTherapy = kindOfTherapy;
	}

	public Code getTypeOfApplication() {
		return typeOfApplication;
	}

	public void setTypeOfApplication(Code typeOfApplication) {
		this.typeOfApplication = typeOfApplication;
	}

	public void setMagistraliter(Magistraliter magistraliter) {
		this.magistraliter = magistraliter;
	}

	public void setPeriodOfPrescription(PeriodOfPrescription periodOfPrescription) {
		this.periodOfPrescription = periodOfPrescription;
	}

	public POCDMT000040Entry getMedikationVerordnungEntryemed(int indexPrescription) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		MedikationVerordnungEntryemed substance = new MedikationVerordnungEntryemed();

		if (this.id != null && !this.id.isEmpty()) {
			II prescriptionId = new II("1.2.40.0.10.1.4.3.4.2.2", this.id);
			substance.getId().add(prescriptionId);
		}

		substance.setText(new ED(null, new TEL("#vpos-1")));
		substance.setStatusCode(new CS("completed"));

		if (this.periodOfPrescription != null && (this.periodOfPrescription.getStartIntake() != null
				|| this.periodOfPrescription.getFrequence() != null)) {
			substance.getTemplateId().add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531421());
			substance.setHl7EffectiveTime(this.periodOfPrescription.getEinnahmedauer());
		}

		IVLINT ivlint = new IVLINT();
		ivlint.setValue(BigInteger.valueOf(this.amountPossibleDispenses));
		substance.setRepeatNumber(ivlint);

		if (this.doses != null && !this.doses.isEmpty()) {
			int index = 1;
			for (Dose dose : this.doses) {
				if (dose != null) {
					if (dose.getFrequence() != null && dose.getDays() != null && !dose.getDays().isEmpty()) {
						POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
						POCDMT000040SubstanceAdministration substanceAdmin = new POCDMT000040SubstanceAdministration();
						substanceAdmin.getEffectiveTime().add(dose.getDosierung3dqDailyDoseWithPauseMultipleWeekDays());
						entryRel.setSubstanceAdministration(substanceAdmin);
						substance.getEntryRelationship().add(entryRel);
						substance.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471());
					} else if (dose.getFrequence() != null) {
						substance.getEffectiveTime().add(dose.getDosierung1DailyDose());
						substance.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471());
					}

					if (dose.getIntakeTime() != null && dose.getDays() != null && !dose.getDays().isEmpty()) {
						LOGGER.debug("add dose 4 single dose");
						substance.getEntryRelationship().add(dose.getDosierung4erSingleDoseWithPause(index++));
						substance.getTemplateId()
								.remove(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
						substance.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
					} else if (dose.getIntakeTime() != null) {
						LOGGER.debug("add dose 2 single dose");
						substance.getEntryRelationship().add(dose.getDosierung2erSingleDose(index++));
						substance.getTemplateId()
								.remove(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
						substance.getTemplateId()
								.add(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
					}
				}
			}

		}

		if (this.drug != null) {
			substance.setConsumable(this.drug.getArzneiEntry(indexPrescription));
		}

		substance.getEntryRelationship().add(getHl7CdaR2Pocdmt000040EntryRelationshipForPackageAmount());

		if (this.addInfoPat != null && !this.addInfoPat.isEmpty()) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(true);

			PatientInstructions patInstructions = new PatientInstructions();
			patInstructions.setText(new ED(null, new TEL("#patinfo-" + 0)));

			int index = 1;
			for (AdditionalInformation info : this.addInfoPat) {
				if (info != null && info.getKindOfInformation() != null) {
					patInstructions.addHl7EntryRelationship(info.getEntryRelationshipForPatientInformation(index++));
				}
			}

			entryRel.setAct(patInstructions);
			substance.getEntryRelationship().add(entryRel);
		}

		if (this.addInfoPharm != null && !this.addInfoPharm.isEmpty()) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(true);
			PharmacistInstructions pharmInstructions = new PharmacistInstructions();

			int index = 1;
			for (AdditionalInformation info : this.addInfoPharm) {
				if (info != null && info.getKindOfInformation() != null) {
					pharmInstructions.addHl7EntryRelationship(info.getEntryRelationshipForDispenseInformation(index++));
					index++;
				}
			}

			entryRel.setAct(pharmInstructions);
			substance.getEntryRelationship().add(entryRel);
		}

		if (this.kindOfTherapy != null) {
			substance.getEntryRelationship().add(getKindOfTherapy(this.kindOfTherapy));
		}

		if (this.emedId != null) {
			substance.getReference().add(getReferencePrescriptionEMedId());
		}

		entry.setSubstanceAdministration(substance);

		return entry;
	}

	public POCDMT000040Entry getMedikationVerordnungEntryemedEmedication(int indexPrescription, Identificator gdaId,
			Code kindOfPrescription) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		MedikationVerordnungEntryemed substance = new MedikationVerordnungEntryemed();

		if (emedId != null && gdaId != null) {
			II prescriptionId = gdaId.getHl7CdaR2Ii();
			substance.getId().add(prescriptionId);
		}

		if (this.id != null && !this.id.isEmpty()) {
			II prescriptionId = new Identificator("1.2.40.0.10.1.4.3.4.2.2", id).getHl7CdaR2Ii();
			substance.getId().add(prescriptionId);
		}

		substance.setText(new ED(null, new TEL("#vpos-" + indexPrescription)));
		substance.setStatusCode(new CS("completed"));

		if (this.periodOfPrescription != null && (this.periodOfPrescription.getStartIntake() != null
				|| this.periodOfPrescription.getFrequence() != null)) {
			substance.getTemplateId().add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531421());
			substance.setHl7EffectiveTime(this.periodOfPrescription.getEinnahmedauer());
		}

		IVLINT ivlint = new IVLINT();
		if (kindOfPrescription.equals(ElgaMedikationRezeptart.KASSENREZEPT.getCode())) {
			ivlint.setValue(BigInteger.valueOf(0));
		} else {
			ivlint.setValue(BigInteger.valueOf(this.amountPossibleDispenses));
		}
		substance.setRepeatNumber(ivlint);

		if (typeOfApplication != null && typeOfApplication.getCode() != null) {
			substance.setRouteCode(typeOfApplication.getHl7CdaR2Ce());
		}

		if (this.doses != null && !this.doses.isEmpty()) {
			int index = 1;
			for (Dose dose : this.doses) {
				if (dose != null) {
					if (dose.getFrequence() != null && dose.getDays() != null && !dose.getDays().isEmpty()) {
						POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
						POCDMT000040SubstanceAdministration substanceAdmin = new POCDMT000040SubstanceAdministration();
						substanceAdmin.getEffectiveTime().add(dose.getDosierung3dqDailyDoseWithPauseMultipleWeekDays());
						entryRel.setSubstanceAdministration(substanceAdmin);
						substance.getEntryRelationship().add(entryRel);
						if (!containsTemplateId(substance.getTemplateId(),
								MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471())) {
							substance.getTemplateId()
									.add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471());
						}
					} else if (dose.getFrequence() != null) {
						substance.getEffectiveTime().add(dose.getDosierung1DailyDose());

						if (!containsTemplateId(substance.getTemplateId(),
								MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471())) {
							substance.getTemplateId()
									.add(MedikationVerordnungEntryemed.getPredefinedTemplateId136141193761531471());
						}
					}

					if (dose.getIntakeTime() != null && dose.getDays() != null && !dose.getDays().isEmpty()) {
						LOGGER.debug("add dose 4 single dose");
						substance.getEntryRelationship().add(dose.getDosierung4erSingleDoseWithPause(index++));
						if (!containsTemplateId(substance.getTemplateId(),
								MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149())) {
							substance.getTemplateId()
									.add(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
						}
					} else if (dose.getIntakeTime() != null) {
						LOGGER.debug("add dose 2 single dose");
						substance.getEntryRelationship().add(dose.getDosierung2erSingleDose(index++));
						if (!containsTemplateId(substance.getTemplateId(),
								MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149())) {
							substance.getTemplateId()
									.add(MedikationVerordnungEntryemed.getPredefinedTemplateId13614119376153149());
						}
					}
				}
			}

		}

		if (this.drug != null) {
			substance.setConsumable(this.drug.getArzneiEntry(indexPrescription));
		}

		substance.getEntryRelationship().clear();
		substance.getEntryRelationship().add(getHl7CdaR2Pocdmt000040EntryRelationshipForPackageAmount());

		if (this.addInfoPat != null && !this.addInfoPat.isEmpty()) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(true);

			PatientInstructions patInstructions = new PatientInstructions();
			patInstructions.setText(new ED(null, new TEL("#patinfo-" + 0)));

			int index = 1;
			for (AdditionalInformation info : this.addInfoPat) {
				if (info != null && info.getKindOfInformation() != null) {
					patInstructions.addHl7EntryRelationship(info.getEntryRelationshipForPatientInformation(index++));
				}
			}

			entryRel.setAct(patInstructions);
			substance.getEntryRelationship().add(entryRel);
		}

		if (this.addInfoPharm != null && !this.addInfoPharm.isEmpty()) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(true);
			PharmacistInstructions pharmInstructions = new PharmacistInstructions();

			int index = 1;
			for (AdditionalInformation info : this.addInfoPharm) {
				if (info != null && info.getKindOfInformation() != null) {
					pharmInstructions.addHl7EntryRelationship(info.getEntryRelationshipForDispenseInformation(index++));
					index++;
				}
			}

			entryRel.setAct(pharmInstructions);
			substance.getEntryRelationship().add(entryRel);
		}

		if (this.kindOfTherapy != null) {
			substance.getEntryRelationship().add(getKindOfTherapy(this.kindOfTherapy));
		}

		if (this.emedId != null && this.emedId.getRoot() != null) {
			substance.getReference().add(getReferencePrescriptionEMedId());
		}

		entry.setSubstanceAdministration(substance);

		return entry;
	}

	private boolean containsTemplateId(List<II> ids, II templateId) {
		if (ids == null) {
			return false;
		}

		for (II tempId : ids) {
			if (tempId != null && tempId.getRoot() != null && templateId != null
					&& tempId.getRoot().equalsIgnoreCase(templateId.getRoot())) {
				return true;
			}
		}

		return false;
	}

	protected Therapieart getKindOfTherapy(Code kindOfTherapy) {
		Therapieart entryRelTherapy = new Therapieart();
		POCDMT000040Act act = entryRelTherapy.getAct();
		act.getTemplateId().add(new Identificator(TEMPLATE_ID_KIND_OF_THERAPY).getHl7CdaR2Ii());
		act.setCode(new CE(kindOfTherapy.getCode(), kindOfTherapy.getCodeSystem(), kindOfTherapy.getCodeSystemName(),
				kindOfTherapy.getDisplayName()));
		return entryRelTherapy;
	}

	protected Iddescontainers getReferencePrescriptionEMedId() {
		if (emedId != null) {
			Iddescontainers idContainer = new Iddescontainers();
			POCDMT000040ExternalDocument doc = new POCDMT000040ExternalDocument();
			doc.getId().clear();
			II emedIdII = this.emedId.getHl7CdaR2Ii();
			emedIdII.setAssigningAuthorityName("e-MedAT");
			doc.getId().add(emedIdII);
			idContainer.setExternalDocument(doc);
			return idContainer;
		}

		return null;
	}

	protected POCDMT000040EntryRelationship getHl7CdaR2Pocdmt000040EntryRelationshipForPackageAmount() {
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		entryRel.setInversionInd(false);
		POCDMT000040Supply supply = new POCDMT000040Supply();
		supply.setClassCode(ActClassSupply.SPLY);
		supply.setMoodCode(XDocumentSubstanceMood.RQO);
		BL bl = new BL();
		bl.setValue(false);
		supply.setIndependentInd(bl);
		supply.setQuantity(new PQ(String.valueOf(this.amountPackages)));
		entryRel.setSupply(supply);
		return entryRel;
	}
}
