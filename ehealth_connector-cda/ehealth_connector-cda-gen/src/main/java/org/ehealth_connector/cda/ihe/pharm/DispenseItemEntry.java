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
import org.ehealth_connector.cda.ihe.pharm.enums.MedicationsSpecialConditions;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Implements the Base Class DispenseItemEntry from the IHE PHARM Model
 *
 */
public class DispenseItemEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry> {

	/**
	 * Instantiates a new dispense item entry.
	 *
	 * @param languageCode the language code
	 */
	public DispenseItemEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createDispenseItemEntry().init());
	}

	/**
	 * Instantiates a new dispense item entry.
	 */
	public DispenseItemEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new facade for the provided mdht object.
	 * 
	 * @param mdht
	 *            the mdht model object
	 */
	protected DispenseItemEntry(org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry mdht) {
		super(mdht, null, null);
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
		if (this.getMdht().getCode()!=null) {
			final Code code = new Code(this.getMdht().getCode());
			if ((code != null)
					&& MedicationsSpecialConditions.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return MedicationsSpecialConditions.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * Gets the patient medical instructions.
	 *
	 * @return the patient medical instructions
	 */
	public PatientMedicalInstructionsEntry getPatientMedicalInstructions() {
		if (getMdht().getPatientMedicalInstructions()!=null) {
			return new PatientMedicalInstructionsEntry(
					getMdht().getPatientMedicalInstructions());
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
	 * Sets the medication fullfillment instructions.
	 *
	 * @param entry the new medication fullfillment instructions
	 */
	public void setMedicationFullfillmentInstructions(
			MedicationFullfillmentInstructionsEntry entry) {
		MedicationFullfillmentInstructionsEntry old = this.getMedicationFullfillmentInstructions();
		if (old!=null) {
			for(EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setAct(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationship = null;
			entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
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
	 * Sets the patient medical instructions.
	 *
	 * @param entry the new patient medical instructions
	 */
	public void setPatientMedicalInstructions(PatientMedicalInstructionsEntry entry) {
		PatientMedicalInstructionsEntry old = this.getPatientMedicalInstructions();
		if (old!=null) {
			for(EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setAct(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationShip = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setAct(entry.getMdht());
			entryRelationShip.setInversionInd(Boolean.TRUE);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
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
	
	public void setDispenseCode(Code code) {
		this.getMdht().setCode(code.getCD());
	}
	
	public Code getDispenseCode() {
		if (this.getMdht().getCode()!=null) {
			return new Code(this.getMdht().getCode());
		}
		return null;
	}

}
