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
import org.ehealth_connector.cda.ihe.pharm.enums.PharmaceuticalAdviceStatusList;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Component4;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryOrganizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipExternalReference;

/**
 * Implements the Base Class PharmaceuticalAdviceItemEntry from the IHE PHARM
 * Model.
 */
public class PharmaceuticalAdviceItemEntry extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry> {

	/**
	 * Instantiates a new dipsen item entry.
	 */
	public PharmaceuticalAdviceItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new prescription item entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PharmaceuticalAdviceItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmaceuticalAdviceItemEntry().init());
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);
	}

	/**
	 * Instantiates a new facade for the provided mdht object.
	 *
	 * @param mdht
	 *            the mdht model object
	 */
	public PharmaceuticalAdviceItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry mdht) {
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
	 * Add the modified Dosage instructions
	 *
	 * @param modifiedDosageInstructions
	 *            New dosage instructions (substrance administration)
	 */
	public void addModifiedDosageInstructions(SubstanceAdministration substanceAdministration) {

		final EntryRelationship newDosageInstructions = CDAFactory.eINSTANCE
				.createEntryRelationship();
		newDosageInstructions.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		newDosageInstructions.setInversionInd(false);

		newDosageInstructions.setSubstanceAdministration(substanceAdministration);

		this.getMdht().getEntryRelationships().add(newDosageInstructions);

	}

	/**
	 * Add the modified MTP Item
	 *
	 * @param newMtpItem
	 *            Modified MTP Item
	 */
	public void addModifiedMtpItem(EntryRelationship newMtpItem) {

		this.getMdht().getEntryRelationships().add(newMtpItem);

	}

	/**
	 * Add the modified Prescription
	 *
	 * @param modifiedPrescription
	 *            New prescription (substrance administration)
	 */
	public void addModifiedPrescription(SubstanceAdministration substanceAdministration) {

		final EntryRelationship newPrescription = CDAFactory.eINSTANCE.createEntryRelationship();
		newPrescription.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		newPrescription.setInversionInd(false);

		final Organizer organizer = CDAFactory.eINSTANCE.createOrganizer();
		organizer.setClassCode(x_ActClassDocumentEntryOrganizer.CLUSTER);
		organizer.setMoodCode(ActMood.EVN);

		final CS statusCodeOrganizer = DatatypesFactory.eINSTANCE.createCS();
		statusCodeOrganizer.setCode(StatusCode.COMPLETED_CODE);
		organizer.setStatusCode(statusCodeOrganizer);

		final Component4 newPrescriptionComponent = CDAFactory.eINSTANCE.createComponent4();
		newPrescriptionComponent.setSeperatableInd(DatatypesFactory.eINSTANCE.createBL(false));
		newPrescriptionComponent.setSubstanceAdministration(substanceAdministration);
		organizer.getComponents().add(newPrescriptionComponent);
		newPrescription.setOrganizer(organizer);
		this.getMdht().getEntryRelationships().add(newPrescription);

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
	 * Gets the dispense item reference entry.
	 *
	 * @return the dispense item reference entry
	 */
	public DispenseItemReferenceEntry getDispenseItemReferenceEntry() {
		if (getMdht().getDispenseItemReferenceEntry() != null) {
			return new DispenseItemReferenceEntry(getMdht().getDispenseItemReferenceEntry());
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
	 * Gets the new medication treatment plan item entry.
	 *
	 * @return the new medication treatment plan item entry
	 */
	public MedicationTreatmentPlanItemEntry getNewMedicationTreatmentPlanItemEntry() {
		if (getMdht().getNewMedicationTreatmentPlanItemEntry() != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (x_ActRelationshipEntryRelationship.REFR.equals(entryRelationship.getTypeCode())
						&& (entryRelationship.getInversionInd() != null)
						&& (entryRelationship.getInversionInd().booleanValue() == false)) {
					return new MedicationTreatmentPlanItemEntry(
							(org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry) entryRelationship
									.getSubstanceAdministration());
				}
			}
		}
		return null;
	}

	/**
	 * Gets the new presciption entry.
	 *
	 * @return the new presciption entry
	 */
	public PrescriptionItemEntry getNewPresciptionEntry() {
		if (this.getMdht().getNewPrescription() != null) {
			final Organizer organizer = (Organizer) getMdht().getNewPrescription();
			if ((organizer.getComponents() != null) && (organizer.getComponents().size() > 0)) {
				if (organizer.getComponents().get(0).getSubstanceAdministration() != null) {
					return new PrescriptionItemEntry(
							((org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry) organizer
									.getComponents().get(0).getSubstanceAdministration()));
				}
			}
		}
		return null;
	}

	/**
	 * Gets the pharmaceutical advice concern entry.
	 *
	 * @return the pharmaceutical advice concern entry
	 */
	public PharmaceuticalAdviceConcernEntry getPharmaceuticalAdviceConcernEntry() {
		if (getMdht().getPharmaceuticalAdviceConcernEntry() != null) {
			return new PharmaceuticalAdviceConcernEntry(
					getMdht().getPharmaceuticalAdviceConcernEntry());
		}
		return null;
	}

	/**
	 * Gets the pharmaceutical advice status.
	 *
	 * @return the pharmaceutical advice status
	 */
	public Code getPharmaceuticalAdviceStatus() {
		if (this.getMdht().getCode() != null) {
			return new Code(this.getMdht().getCode());
		}
		return null;
	}

	/**
	 * Gets the pharmaceutical advice status list.
	 *
	 * @return the pharmaceutical advice status list
	 */
	public PharmaceuticalAdviceStatusList getPharmaceuticalAdviceStatusList() {
		if (this.getMdht().getCode() != null) {
			final Code code = new Code(this.getMdht().getCode());
			if ((code != null) && PharmaceuticalAdviceStatusList.CODE_SYSTEM_OID
					.equals(code.getCodeSystem())) {
				return PharmaceuticalAdviceStatusList.getEnum(code.getCode());
			}
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
	 * Sets the dispense item reference entry.
	 *
	 * @param entry
	 *            the new dispense item reference entry
	 */
	public void setDispenseItemReferenceEntry(DispenseItemReferenceEntry entry) {
		final DispenseItemReferenceEntry old = getDispenseItemReferenceEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSupply(entry.getMdht());
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationship = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setSupply(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
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
	 * Sets the new medication treatment plan item entry.
	 *
	 * @param entry
	 *            the new new medication treatment plan item entry
	 */
	public void setNewMedicationTreatmentPlanItemEntry(MedicationTreatmentPlanItemEntry entry) {
		final MedicationTreatmentPlanItemEntry old = getNewMedicationTreatmentPlanItemEntry();
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
			entryRelationship.setInversionInd(Boolean.FALSE);
			entryRelationship.setSubstanceAdministration(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the new presciption entry.
	 *
	 * @param entry
	 *            the new new presciption entry
	 */
	public void setNewPresciptionEntry(PrescriptionItemEntry entry) {
		final PrescriptionItemEntry old = getNewPresciptionEntry();
		if (old != null) {
			final Organizer organizer = (Organizer) getMdht().getNewPrescription();
			organizer.getComponents().get(0).setSubstanceAdministration(entry.getMdht());
		} else {
			final Organizer organizer = CDAFactory.eINSTANCE.createOrganizer();
			final Component4 component = CDAFactory.eINSTANCE.createComponent4();
			component.setSubstanceAdministration(entry.getMdht());
			organizer.getComponents().add(component);
			final EntryRelationship entryRelationship = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setInversionInd(Boolean.FALSE);
			entryRelationship.setOrganizer(organizer);
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the phamaceutical advice concern entry
	 *
	 * @param entry
	 *            the entry
	 */
	public void setPharmaceuticalAdviceConcernEntry(PharmaceuticalAdviceConcernEntry entry) {
		final PharmaceuticalAdviceConcernEntry old = this.getPharmaceuticalAdviceConcernEntry();
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
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			entryRelationship.setInversionInd(Boolean.FALSE);
			entryRelationship.setAct(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the pharmaceutical advice status.
	 *
	 * @param code
	 *            the new pharmaceutical advice status
	 */
	public void setPharmaceuticalAdviceStatus(Code code) {
		this.getMdht().setCode(code.getCD());
	}

	/**
	 * Sets the medications special conditions.
	 *
	 * @param code
	 *            the code
	 */
	public void setPharmaceuticalAdviceStatus(PharmaceuticalAdviceStatusList code) {
		if (code != null) {
			this.getMdht().setCode(code.getCode().getCD());
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
	 * Sets the status code active.
	 */
	public void setStatusCodeActive() {
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("active");
		this.getMdht().setStatusCode(statusCodeCompleted);
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
