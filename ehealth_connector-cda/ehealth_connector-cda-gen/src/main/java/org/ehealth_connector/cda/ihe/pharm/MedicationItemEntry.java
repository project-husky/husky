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

import java.math.BigDecimal;
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
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.InternalReference;
import org.openhealthtools.mdht.uml.cda.ihe.SupplyEntry;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;

/**
 * Implements the Base Class MedicationItemEntry from the IHE PHARM Model.
 */
public class MedicationItemEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationItemEntry> {

	/**
	 * Instantiates a new facade for the provided mdht object.
	 *
	 * @param mdht
	 *          the mdht model object
	 */
	protected MedicationItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationItemEntry mdht) {
		super(mdht, null, null);
		// adding missing template pcc id
		mdht.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", null).getIi());
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);
	}

	/**
	 * Adds the precondition entry.
	 *
	 * @param entry
	 *          the entry
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
	 * Gets the patient medical instructions.
	 *
	 * @return the patient medical instructions
	 */
	public PatientMedicalInstructionsEntry getPatientMedicalInstructions() {
		if (getMdht().getPharmPatientMedicalInstructions() != null) {
			return new PatientMedicalInstructionsEntry(getMdht().getPharmPatientMedicalInstructions());
		}
		return null;
	}

	/**
	 * Gets the pharm substitution handling entry.
	 *
	 * @return the pharm substitution handling entry
	 */
	public PharmSubstitutionHandlingEntry getPharmSubstitutionHandlingEntry() {
		if (getMdht().getPharmSubstitutionHandlingEntry() != null) {
			return new PharmSubstitutionHandlingEntry(getMdht().getPharmSubstitutionHandlingEntry());
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
	 * Gets the reason for.
	 *
	 * @return the reason for
	 */
	public Identificator getReasonFor() {
		if (this.getMdht().getPharmInternalReference() != null) {
			InternalReference internalReference = getMdht().getInternalReferences().get(0);
			if (internalReference.getIds() != null && internalReference.getIds().size() > 0) {
				return new Identificator(internalReference.getIds().get(0));
			}
		}
		return null;
	}

	/**
	 * Gets the route of administration.
	 *
	 * @return the route of administration
	 */
	public Code getRouteOfAdministration() {
		if (this.getMdht().getRouteCode() != null) {
			return new Code(this.getMdht().getRouteCode());
		}
		return null;
	}

	/**
	 * Gets the supply quantity value.
	 *
	 * @return the supply quantity value
	 */
	public BigDecimal getSupplyQuantityValue() {
		if (this.getMdht().getPharmSupplyEntry() != null) {
			SupplyEntry supplyEntry = getMdht().getPharmSupplyEntry();
			PQ pq = supplyEntry.getQuantity();
			return pq.getValue();
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
		if ((this.getMdht().getText() != null) && (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Sets the external document entry.
	 *
	 * @param externalDocumentEntry
	 *          the new external document entry
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
	 *          the new identificator
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
	 *          the new medication fullfillment instructions
	 */
	public void setMedicationFullfillmentInstructions(MedicationFullfillmentInstructionsEntry entry) {
		MedicationFullfillmentInstructionsEntry old = this.getMedicationFullfillmentInstructions();
		if (old != null) {
			for (EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
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
	 *          the code
	 * @param languageCode
	 *          the language code
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
	 * @param entry
	 *          the new patient medical instructions
	 */
	public void setPatientMedicalInstructions(PatientMedicalInstructionsEntry entry) {
		PatientMedicalInstructionsEntry old = this.getPatientMedicalInstructions();
		if (old != null) {
			for (EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
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
	 * Sets the pharm substitution handling entry.
	 *
	 * @param entry
	 *          the new pharm substitution handling entry
	 */
	public void setPharmSubstitutionHandlingEntry(PharmSubstitutionHandlingEntry entry) {
		PharmSubstitutionHandlingEntry old = this.getPharmSubstitutionHandlingEntry();
		if (old != null) {
			for (EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSupply(entry.getMdht());
					break;
				}
			}
		} else {
			EntryRelationship entryRelationShip = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setSupply(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the reason for.
	 *
	 * @param internalReferenceIdentificator
	 *          the new reason for
	 */
	public void setReasonFor(Identificator internalReferenceIdentificator) {
		if (getMdht().getInternalReferences() != null && getMdht().getInternalReferences().size() > 0) {
			InternalReference internalReference = getMdht().getInternalReferences().get(0);
			internalReference.getIds().clear();
			internalReference.getIds().add(internalReferenceIdentificator.getIi());
		} else {
			InternalReference internalReference = IHEFactory.eINSTANCE.createInternalReference().init();
			internalReference.getIds().add(internalReferenceIdentificator.getIi());
			internalReference.setMoodCode(x_DocumentActMood.EVN);
			internalReference.setClassCode(x_ActClassDocumentEntryAct.ACT);

			EntryRelationship entryRelationShip = CDAFactory.eINSTANCE.createEntryRelationship();
			// needed? entryRelationShip.setInversionInd(false);
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
			entryRelationShip.setAct(internalReference);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the route of administration.
	 *
	 * @param code
	 *          the new route of administration
	 */
	public void setRouteOfAdministration(Code code) {
		this.getMdht().setRouteCode(code.getCE());
	}

	/**
	 * Sets the supply quantity value.
	 *
	 * @param value
	 *          the new supply quantity value
	 */
	public void setSupplyQuantityValue(BigDecimal value) {
		PQ pq = DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), "1");
		if (this.getMdht().getPharmSupplyEntry() != null) {
			SupplyEntry supplyEntry = getMdht().getPharmSupplyEntry();
			supplyEntry.setQuantity(pq);
		} else {
			SupplyEntry supplyEntry = IHEFactory.eINSTANCE.createSupplyEntry().init();
			supplyEntry.setQuantity(pq);
			supplyEntry.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
			EntryRelationship entryRelationShip = CDAFactory.eINSTANCE.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setSupply(supplyEntry);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *          the new text reference
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
