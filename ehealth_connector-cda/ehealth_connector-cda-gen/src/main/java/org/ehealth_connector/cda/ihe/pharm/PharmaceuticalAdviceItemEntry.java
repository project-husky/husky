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
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ihe.pharm;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.pharm.enums.PharmaceuticalAdviceStatusList;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Component4;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Implements the Base Class PharmaceuticalAdviceItemEntry from the IHE PHARM Model.
 */
public class PharmaceuticalAdviceItemEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry> {

	/**
	 * Instantiates a new prescription item entry.
	 *
	 * @param languageCode the language code
	 */
	public PharmaceuticalAdviceItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmaceuticalAdviceItemEntry().init());
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);		
	}

	/**
	 * Instantiates a new dipsen item entry.
	 */
	public PharmaceuticalAdviceItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new facade for the provided mdht object.
	 * 
	 * @param mdht
	 *            the mdht model object
	 */
	protected PharmaceuticalAdviceItemEntry(org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry mdht) {
		super(mdht, null, null);
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
	 * Adds the precondition entry.
	 *
	 * @param entry the entry
	 */
	public void addPreconditionEntry(CriterionEntry entry) {
		Precondition precondition = CDAFactory.eINSTANCE.createPrecondition();
		precondition.setCriterion(entry.getMdht());
		getMdht().getPreconditions().add(precondition);
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
	 * Gets the pharmaceutical advice status list.
	 *
	 * @return the pharmaceutical advice status list
	 */
	public PharmaceuticalAdviceStatusList getPharmaceuticalAdviceStatusList() {
		if (this.getMdht().getCode()!=null) {
			final Code code = new Code(this.getMdht().getCode());
			if ((code != null)
					&& PharmaceuticalAdviceStatusList.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
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
		for (Precondition precondition : getMdht().getPreconditions()) {
			preconditionEntries.add(new CriterionEntry(precondition.getCriterion()));
		}
		return preconditionEntries;
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
	 * Sets the external document entry.
	 *
	 * @param externalDocumentEntry
	 *            the new external document entry
	 */
	public void setExternalDocumentEntry(ExternalDocumentEntry externalDocumentEntry) {
		// note PCC Template only for REFR not for XCRPT
		ExternalDocumentRef reference = PHARMFactory.eINSTANCE.createExternalDocumentRef().init();
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
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}
	
	/**
	 * Sets the pharmaceutical advice status.
	 *
	 * @param code the new pharmaceutical advice status
	 */
	public void setPharmaceuticalAdviceStatus(Code code) {
		this.getMdht().setCode(code.getCD());
	}
	
	/**
	 * Gets the pharmaceutical advice status.
	 *
	 * @return the pharmaceutical advice status
	 */
	public Code getPharmaceuticalAdviceStatus() {
		if (this.getMdht().getCode()!=null) {
			return new Code(this.getMdht().getCode());
		}
		return null;
	}
	
	/**
	 * Gets the medication treatment plan item reference entry.
	 *
	 * @return the medication treatment plan item reference entry
	 */
	public MedicationTreatmentPlanItemReferenceEntry getMedicationTreatmentPlanItemReferenceEntry() {
		if (((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht())
				.getMedicationTreatmentPlanItemReferenceEntry() != null) {
			return new MedicationTreatmentPlanItemReferenceEntry(
					((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht())
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
	
	/**
	 * Gets the prescription item reference entry.
	 *
	 * @return the prescription item reference entry
	 */
	public PrescriptionItemReferenceEntry getPrescriptionItemReferenceEntry() {
		if (((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht())
				.getPrescriptionItemReferenceEntry() != null) {
			return new PrescriptionItemReferenceEntry(
					((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht())
							.getPrescriptionItemReferenceEntry());
		}
		return null;
	}
	
	/**
	 * Sets the prescription item reference entry.
	 *
	 * @param entry
	 *            the new prescription item reference entry
	 */
	public void setPrescriptionItemReferenceEntry(PrescriptionItemReferenceEntry entry) {
		PrescriptionItemReferenceEntry old = getPrescriptionItemReferenceEntry();
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
	
	
	/**
	 * Gets the new medication treatment plan item entry.
	 *
	 * @return the new medication treatment plan item entry
	 */
	public MedicationTreatmentPlanItemEntry getNewMedicationTreatmentPlanItemEntry() {
		if (((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht()).getNewMedicationTreatmentPlanItemEntry() != null) {
			return new MedicationTreatmentPlanItemEntry(
					((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht()).getNewMedicationTreatmentPlanItemEntry());
		}
		return null;
	}
	
	/**
	 * Gets the dispense item reference entry.
	 *
	 * @return the dispense item reference entry
	 */
	public DispenseItemReferenceEntry getDispenseItemReferenceEntry() {
		if (((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht())
				.getDispenseItemReferenceEntry() != null) {
			return new DispenseItemReferenceEntry(
					((org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry) getMdht())
							.getDispenseItemReferenceEntry());
		}
		return null;
	}
	
	/**
	 * Sets the dispense item reference entry.
	 *
	 * @param entry the new dispense item reference entry
	 */
	public void setDispenseItemReferenceEntry(DispenseItemReferenceEntry entry) {
		DispenseItemReferenceEntry old = getDispenseItemReferenceEntry();
		if (old != null) {
			for (EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSupply(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setSupply(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}
	
	
	/**
	 * Sets the new medication treatment plan item entry.
	 *
	 * @param entry the new new medication treatment plan item entry
	 */
	public void setNewMedicationTreatmentPlanItemEntry(MedicationTreatmentPlanItemEntry entry) {
		MedicationTreatmentPlanItemEntry old = getNewMedicationTreatmentPlanItemEntry();
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
			entryRelationship.setInversionInd(Boolean.FALSE);
			entryRelationship.setSubstanceAdministration(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}
	
	
	/**
	 * Gets the new presciption entry.
	 *
	 * @return the new presciption entry
	 */
	public PrescriptionItemEntry getNewPresciptionEntry() {
		if (this.getMdht().getNewPrescription()!=null) {
			Organizer organizer = (Organizer) getMdht().getNewPrescription();
			if (organizer.getComponents()!=null && organizer.getComponents().size()>0) {
				if (organizer.getComponents().get(0).getSubstanceAdministration()!=null) {
					return new PrescriptionItemEntry(((org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry) organizer.getComponents().get(0).getSubstanceAdministration()));
				}
			}
		}
		return null;
	}
	

	/**
	 * Sets the new presciption entry.
	 *
	 * @param entry the new new presciption entry
	 */
	public void setNewPresciptionEntry(PrescriptionItemEntry entry) {
		PrescriptionItemEntry old = getNewPresciptionEntry();
		if (old != null) {
			Organizer organizer = (Organizer) getMdht().getNewPrescription();
			organizer.getComponents().get(0).setSubstanceAdministration(entry.getMdht());
		} else {
			Organizer organizer = CDAFactory.eINSTANCE.createOrganizer();
			Component4 component = CDAFactory.eINSTANCE.createComponent4();
			component.setSubstanceAdministration(entry.getMdht());
			organizer.getComponents().add(component);
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
			entryRelationship.setInversionInd(Boolean.FALSE);
			entryRelationship.setOrganizer(organizer);
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	
	


}
