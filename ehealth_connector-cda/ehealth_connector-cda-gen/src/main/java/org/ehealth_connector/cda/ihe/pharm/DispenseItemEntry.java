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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ihe.pharm.enums.DispenseCodeList;
import org.ehealth_connector.cda.ihe.pharm.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.ihe.pharm.enums.PharmacyItemTypeList;
import org.ehealth_connector.cda.ihe.pharm.enums.SubstanceAdminSubstitution;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.PharmComponent1;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionMade;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassSupply;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipExternalReference;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Implements the Base Class DispenseItemEntry from the IHE PHARM Model.
 */
public class DispenseItemEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry> {

	/**
	 * Instantiates a new dispense item entry.
	 */
	public DispenseItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new dispense item entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public DispenseItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createDispenseItemEntry().init());

		this.getMdht().setClassCode(ActClassSupply.SPLY);
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.EVN);
	}

	/**
	 * Instantiates a new facade for the provided mdht object.
	 *
	 * @param mdht
	 *            the mdht model object
	 */
	public DispenseItemEntry(org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry mdht) {
		super(mdht, null, null);
	}

	/**
	 * Adds an author to the authors list
	 *
	 * @param author
	 *            Author to add to the list
	 *
	 */
	public void addAuthor(org.ehealth_connector.common.Author author) {

		this.getMdht().getAuthors().add(author.getAuthorMdht());

	}

	/**
	 * Add the Daily Dosage
	 *
	 * @param dailyDosage
	 *            Description of the daily dosage
	 *
	 */
	public void addDailyDosage(SubstanceAdministration dailyDosage) {

		final EntryRelationship dailyDosageEntryRelationship = CDAFactory.eINSTANCE
				.createEntryRelationship();
		dailyDosageEntryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		dailyDosageEntryRelationship.setSubstanceAdministration(dailyDosage);
		this.getMdht().getEntryRelationships().add(dailyDosageEntryRelationship);

	}

	/**
	 * Adds the precondition entry.
	 *
	 * @param entry
	 *            the entry
	 */
	public void addPreconditionEntry(CriterionEntry entry) {
		final Precondition precondition = CDAFactory.eINSTANCE.createPrecondition();
		precondition.setCriterion(entry.getMdht());
		getMdht().getPreconditions().add(precondition);
	}

	/**
	 * Set the document reference (used when the item is in a PML document)
	 *
	 * @param documentId
	 *            ID of the parent document
	 *
	 */
	public void addXCRPTReference(Identificator documentId) {

		final Reference referenceXCRPT = CDAFactory.eINSTANCE.createReference();
		referenceXCRPT.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.getMdht().getTemplateIds().clear();
		documentEntry.setId(documentId);
		documentEntry.getMdht().unsetMoodCode();
		documentEntry.getMdht().unsetClassCode();
		referenceXCRPT.setExternalDocument(documentEntry.getMdht());
		this.getMdht().getReferences().add(referenceXCRPT);

	}

	/**
	 * <div class="en">Creates a Reference to a DIS Entry using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">created Reference to DIS Entry</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public DispenseItemReferenceEntry createDISItemReferenceEntry() {

		final DispenseItemReferenceEntry referenceEntry = new DispenseItemReferenceEntry();

		CD cd = DatatypesFactory.eINSTANCE.createCD();

		cd.setCode(PharmacyItemTypeList.DISItem.getCode().getCode());
		cd.setCodeSystem(PharmacyItemTypeList.CODE_SYSTEM_OID);
		cd.setCodeSystemName(PharmacyItemTypeList.CODE_SYSTEM_NAME);
		cd.setDisplayName(PharmacyItemTypeList.DISItem.getCode().getDisplayName());

		referenceEntry.getMdht().setCode(cd);

		referenceEntry.getMdht().setMoodCode(x_DocumentSubstanceMood.EVN);
		referenceEntry.getMdht().setClassCode(ActClassSupply.SPLY);
		referenceEntry.getMdht().getIds().add(this.getId().getIi());

		return referenceEntry;
	}

	/**
	 * Returns the authors
	 *
	 * @return authors list
	 *
	 */
	public ArrayList<org.ehealth_connector.common.Author> getAuthors() {

		ArrayList<org.ehealth_connector.common.Author> authors = new ArrayList<org.ehealth_connector.common.Author>();

		for (final Author mdhtAuthor : this.getMdht().getAuthors()) {
			authors.add(new org.ehealth_connector.common.Author(mdhtAuthor));
		}

		return authors;

	}

	/**
	 * Gets the dispense code.
	 *
	 * @return the dispense code
	 */
	public Code getDispenseCode() {
		if (this.getMdht().getCode() != null) {
			return new Code(this.getMdht().getCode());
		}
		return null;
	}

	/**
	 * Get the dispensed product
	 *
	 * return Product dispensed
	 *
	 */
	public org.openhealthtools.mdht.uml.cda.Product getDispensedProduct() {

		return this.getMdht().getProduct();

	}

	/**
	 * Gets the dosage instructions.
	 *
	 * @return the dosage instructions
	 */
	public DosageInstructionsEntry getDosageInstructions() {
		if (getMdht().getDosageInstructionsEntry() != null) {
			return new DosageInstructionsEntry(getMdht().getDosageInstructionsEntry());
		}
		return null;
	}

	/**
	 * Gets the external document entry.
	 *
	 * @return the external document entry
	 */
	public ExternalDocumentEntry getExternalDocumentEntry() {
		if (getMdht().getReferences().size() > 0) {
			final Reference reference = this.getMdht().getReferences().get(0);
			return new ExternalDocumentEntry(reference.getExternalDocument());
		}
		return null;
	}

	/**
	 * Gets the first .
	 *
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getIds() != null) && (getMdht().getIds().size() > 0)) {
			id = new Identificator(getMdht().getIds().get(0));
		}
		return id;
	}

	/**
	 * Gets the medication fullfillment instructions.
	 *
	 * @return the medication fullfillment instructions
	 */
	public MedicationFullfillmentInstructionsEntry getMedicationFullfillmentInstructions() {
		if (getMdht().getMedicationFullfillmentInstructions() != null) {
			return new MedicationFullfillmentInstructionsEntry(
					getMdht().getMedicationFullfillmentInstructions());
		}
		return null;
	}

	/**
	 * Gets the medications special conditions.
	 *
	 * @return the medications special conditions
	 */
	public MedicationsSpecialConditions getMedicationsSpecialConditions() {
		if (this.getMdht().getCode() != null) {
			final Code code = new Code(this.getMdht().getCode());
			if ((code != null)
					&& MedicationsSpecialConditions.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return MedicationsSpecialConditions.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * Gets the medication treatment plan item reference entry.
	 *
	 * @return the medication treatment plan item reference entry
	 */
	public MedicationTreatmentPlanItemReferenceEntry getMedicationTreatmentPlanItemReferenceEntry() {
		if (getMdht().getMedicationTreatmentPlanItemReferenceEntry() != null) {
			return new MedicationTreatmentPlanItemReferenceEntry(
					getMdht().getMedicationTreatmentPlanItemReferenceEntry());
		}
		return null;
	}

	/**
	 * Gets the patient medical instructions.
	 *
	 * @return the patient medical instructions
	 */
	public PatientMedicalInstructionsEntry getPatientMedicalInstructions() {
		if (getMdht().getPatientMedicalInstructions() != null) {
			return new PatientMedicalInstructionsEntry(getMdht().getPatientMedicalInstructions());
		}
		return null;
	}

	/**
	 * Gets the pharmaceutical advice item reference entry.
	 *
	 * @return the pharmaceutical advice item reference entry
	 */
	public PharmaceuticalAdviceItemReferenceEntry getPharmaceuticalAdviceItemReferenceEntry() {
		if (getMdht().getPharmaceuticalAdviceItemReferenceEntry() != null) {
			return new PharmaceuticalAdviceItemReferenceEntry(
					getMdht().getPharmaceuticalAdviceItemReferenceEntry());
		}
		return null;
	}

	/**
	 * Gets the precondition entries.
	 *
	 * @return the precondition entries
	 */
	public List<CriterionEntry> getPreconditionEntries() {
		final List<CriterionEntry> preconditionEntries = new ArrayList<CriterionEntry>();
		for (final Precondition precondition : getMdht().getPreconditions()) {
			preconditionEntries.add(new CriterionEntry(precondition.getCriterion()));
		}
		return preconditionEntries;
	}

	/**
	 * Gets the prescription item reference entry.
	 *
	 * @return the prescription item reference entry
	 */
	public PrescriptionItemReferenceEntry getPrescriptionItemReferenceEntry() {
		if (getMdht().getPrescriptionItemReferenceEntry() != null) {
			return new PrescriptionItemReferenceEntry(
					getMdht().getPrescriptionItemReferenceEntry());
		}
		return null;
	}

	/**
	 * Gets the substance admin substitution.
	 *
	 * @return the substance admin substitution
	 */
	public SubstanceAdminSubstitution getSubstanceAdminSubstitutionMade() {
		if (this.getMdht().getComponent1() != null) {
			final PharmSubstitutionMade pharmSubstitution = this.getMdht().getComponent1()
					.getSubstitutionMade();
			if (pharmSubstitution.getCode() != null) {
				return SubstanceAdminSubstitution.getEnum(pharmSubstitution.getCode().getCode());
			}
		}
		return null;
	}

	/**
	 * Gets the text reference.
	 *
	 * @return the text reference
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Sets the dispense code.
	 *
	 * @param dispenseCode
	 *            the new dispense code
	 */
	public void setDispenseCode(Code dispenseCode) {
		final CE dispenseCodeCE = DatatypesFactory.eINSTANCE.createCE();
		dispenseCodeCE.setCode(dispenseCode.getCode());
		dispenseCodeCE.setCodeSystem(DispenseCodeList.CODE_SYSTEM_OID);
		dispenseCodeCE.setCodeSystemName(DispenseCodeList.CODE_SYSTEM_NAME);
		dispenseCodeCE.setDisplayName(dispenseCode.getDisplayName());
		this.getMdht().setCode(dispenseCodeCE);
	}

	/**
	 * Set the dispensed product
	 *
	 * @param product
	 *            Product dispensed
	 *
	 */
	public void setDispensedProduct(org.openhealthtools.mdht.uml.cda.Product product) {

		this.getMdht().setProduct(product);

	}

	/**
	 * Sets the dosage instructions.
	 *
	 * @param entry
	 *            the new dosage instructions
	 */
	public void setDosageInstructions(DosageInstructionsEntry entry) {
		final DosageInstructionsEntry old = this.getDosageInstructions();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSubstanceAdministration((entry.getMdht()));
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationShip = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setSubstanceAdministration(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the external document entry.
	 *
	 * @param externalDocumentEntry
	 *            the new external document entry
	 */
	public void setExternalDocumentEntry(ExternalDocumentEntry externalDocumentEntry) {
		// note PCC Template only for REFR not for XCRPT
		final ExternalDocumentRef reference = PHARMFactory.eINSTANCE.createExternalDocumentRef()
				.init();
		reference.getTemplateIds().clear();
		externalDocumentEntry.getMdht().getTemplateIds().clear();
		reference.setExternalDocument(externalDocumentEntry.getMdht());
		getMdht().getReferences().clear();
		getMdht().getReferences().add(reference);
	}

	/**
	 * Sets the identificator. Note: replaces all existing identifiers
	 *
	 * @param id
	 *            the new identificator
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		if (id != null) {
			this.getMdht().getIds().add(id.getIi());
		}
	}

	/**
	 * Sets the medication fullfillment instructions.
	 *
	 * @param entry
	 *            the new medication fullfillment instructions
	 */
	public void setMedicationFullfillmentInstructions(
			MedicationFullfillmentInstructionsEntry entry) {
		final MedicationFullfillmentInstructionsEntry old = this
				.getMedicationFullfillmentInstructions();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setAct(entry.getMdht());
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationship = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationship.setAct(entry.getMdht());
			entryRelationship.setInversionInd(Boolean.TRUE);
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the medications special conditions.
	 *
	 * @param code
	 *            the code
	 * @param languageCode
	 *            the language code
	 */
	public void setMedicationsSpecialConditions(MedicationsSpecialConditions code,
			LanguageCode languageCode) {
		if (code != null) {
			this.getMdht().setCode(code.getCode(languageCode).getCD());
		}
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

	/**
	 * Sets the patient medical instructions.
	 *
	 * @param entry
	 *            the new patient medical instructions
	 */
	public void setPatientMedicalInstructions(PatientMedicalInstructionsEntry entry) {
		final PatientMedicalInstructionsEntry old = this.getPatientMedicalInstructions();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setAct(entry.getMdht());
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationShip = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setAct(entry.getMdht());
			entryRelationShip.setInversionInd(Boolean.TRUE);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the pharmaceutical advice item reference entry.
	 *
	 * @param entry
	 *            the new pharmaceutical advice item reference entry
	 */
	public void setPharmaceuticalAdviceItemReferenceEntry(
			PharmaceuticalAdviceItemReferenceEntry entry) {
		final PharmaceuticalAdviceItemReferenceEntry old = getPharmaceuticalAdviceItemReferenceEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setObservation(entry.getMdht());
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationship = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setObservation(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the prescription item reference entry.
	 *
	 * @param entry
	 *            the new prescription item reference entry
	 */
	public void setPrescriptionItemReferenceEntry(PrescriptionItemReferenceEntry entry) {
		final PrescriptionItemReferenceEntry old = getPrescriptionItemReferenceEntry();
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

	/**
	 * Sets the dispensed quantity element
	 *
	 * @param quantity
	 *            Amount dispensed
	 *
	 */
	public void setQuantity(PQ quantity) {

		this.getMdht().setQuantity(quantity);

	}

	/**
	 * Sets the substance admin substitution.
	 *
	 * @param substanceAdminSubstitution
	 *            the substance admin substitution
	 * @param languageCode
	 *            the language code
	 */
	public void setSubstanceAdminSubstitutionMade(
			SubstanceAdminSubstitution substanceAdminSubstitution, LanguageCode languageCode) {
		if (substanceAdminSubstitution != null) {
			if (this.getMdht().getComponent1() == null) {
				final PharmSubstitutionMade pharmSubstitution = CDAFactory.eINSTANCE
						.createPharmSubstitutionMade();
				pharmSubstitution.setClassCode(ActClassRoot.SUBST);
				pharmSubstitution.setMoodCode(ActMood.EVN);
				final PharmComponent1 component1 = CDAFactory.eINSTANCE.createPharmComponent1();
				component1.setSubstitutionMade(pharmSubstitution);
				this.getMdht().setComponent1(component1);
			}
			final PharmSubstitutionMade pharmSubstitution = this.getMdht().getComponent1()
					.getSubstitutionMade();
			pharmSubstitution.setCode(substanceAdminSubstitution.getCode(languageCode).getCE());
		} else {
			this.getMdht().setComponent1(null);
		}

	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
