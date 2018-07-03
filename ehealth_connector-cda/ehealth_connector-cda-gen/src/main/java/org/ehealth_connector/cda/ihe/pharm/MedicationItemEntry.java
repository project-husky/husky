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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ihe.pharm.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.ihe.pharm.enums.SubstanceAdminSubstitution;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.PharmSubjectOf4;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionPermission;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.InternalReference;
import org.openhealthtools.mdht.uml.cda.ihe.SupplyEntry;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.ExternalDocumentRef;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmSupplyEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXPR_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassSupply;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipExternalReference;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Implements the Base Class MedicationItemEntry from the IHE PHARM Model.
 */
public class MedicationItemEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationItemEntry> {

	public static final String APPROACH_SITE_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
	public static final String APPROACH_SITE_CODE_SYSTEM_NAME = "SNOMED CT";

	/**
	 * Creates the subordinate substance administration element.
	 *
	 * @param effectiveTime
	 *            the effective time (intake instructions).
	 * @param doseQuantity
	 *            the dosage.
	 * @param consumable
	 *            the subordinate consumable.
	 * @return the substance administration.
	 */
	public static SubstanceAdministration createSubordinateSubstanceAdministration(
			SXPR_TS effectiveTime, IVL_PQ doseQuantity,
			org.ehealth_connector.cda.Consumable consumable) {

		SubstanceAdministration substanceAdministration = new SubstanceAdministration();

		substanceAdministration.getMdht().getEffectiveTimes().add(effectiveTime);
		substanceAdministration.setDoseQuantity(doseQuantity);
		substanceAdministration.setConsumable(consumable);

		return substanceAdministration;
	}

	/**
	 * Instantiates a new facade for the provided mdht object.
	 *
	 * @param mdht
	 *            the mdht model object
	 */
	protected MedicationItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationItemEntry mdht) {
		super(mdht, null, null);
		// adding missing template pcc id
		boolean alreadyPresent = false;
		for (II templateId : this.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.7.1".equalsIgnoreCase(templateId.getRoot())) {
				alreadyPresent = true;
			}
		}
		if (!alreadyPresent) {
			mdht.getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "IHE PHARM").getIi());
		}
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);
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
	 * Adds an effectiveTime
	 *
	 * @param effectiveTime
	 *            Effective time to add to the list
	 *
	 */
	public void addEffectiveTime(SXCM_TS effectiveTime) {

		this.getMdht().getEffectiveTimes().add(effectiveTime);

	}

	/**
	 * Defines the possible substitutions
	 *
	 * @param substanceAdminSubstitution
	 *            Posisble substitution
	 *
	 */
	public void addPossibleSubstitution(LanguageCode languageCode,
			SubstanceAdminSubstitution substanceAdminSubstitution) {

		final EntryRelationship possibleSubstitution = CDAFactory.eINSTANCE
				.createEntryRelationship();

		possibleSubstitution.setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		final Supply substitutionSupply = CDAFactory.eINSTANCE.createSupply();
		substitutionSupply.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.9", "").getIi());
		substitutionSupply.setClassCode(ActClassSupply.SPLY);
		substitutionSupply.setMoodCode(x_DocumentSubstanceMood.RQO);
		substitutionSupply.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));

		final PharmSubjectOf4 subjectOf4 = CDAFactory.eINSTANCE.createPharmSubjectOf4();

		final PharmSubstitutionPermission substitutionPermission = CDAFactory.eINSTANCE
				.createPharmSubstitutionPermission();
		substitutionPermission.setClassCode(ActClassRoot.SUBST);
		substitutionPermission.setMoodCode(ActMood.PERM);

		final CE pharmCode = DatatypesFactory.eINSTANCE.createCE();
		final Code substCode = substanceAdminSubstitution.getCode(languageCode);
		pharmCode.setCodeSystem(substCode.getCodeSystem());
		pharmCode.setCodeSystemName(substCode.getCodeSystemName());
		pharmCode.setCode(substCode.getCode());
		pharmCode.setDisplayName(substCode.getDisplayName());

		substitutionPermission.setCode(pharmCode);

		subjectOf4.setSubstitutionPermission(substitutionPermission);

		substitutionSupply.setSubjectOf4(subjectOf4);

		possibleSubstitution.setSupply(substitutionSupply);

		this.getMdht().getEntryRelationships().add(possibleSubstitution);
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
	 * Adds the prescribed quantity element
	 *
	 * @param value
	 *            Amount prescribed
	 * @param valueUnit
	 *            Units of prescribed amount (e.g. "1" for tabs)
	 * @param textualUnit
	 *            Type of units (e.g. "tabs")
	 *
	 */
	public void addPrescribedQuantity(Double value, String valueUnit, String textualUnit) {

		final EntryRelationship prescribedQty = CDAFactory.eINSTANCE.createEntryRelationship();

		prescribedQty.setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		final Supply prescribedQuantity = CDAFactory.eINSTANCE.createSupply();
		prescribedQuantity.getTemplateIds().add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.8",
				"Amount of units of the consumable").getIi());
		prescribedQuantity.setClassCode(ActClassSupply.SPLY);
		prescribedQuantity.setMoodCode(x_DocumentSubstanceMood.RQO);
		prescribedQuantity.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		prescribedQuantity
				.setQuantity(DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), valueUnit));
		prescribedQuantity.setText(DatatypesFactory.eINSTANCE.createED(value + " " + textualUnit));
		prescribedQty.setSupply(prescribedQuantity);

		this.getMdht().getEntryRelationships().add(prescribedQty);

	}

	/**
	 * Set the XCRPT document reference (used when the item is in a PML
	 * document)
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
	 * Returns the Approach Site
	 *
	 * @return approach site
	 *
	 */
	public CD getApproachSiteCode() {

		return this.getMdht().getApproachSiteCodes().get(0);

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
	 * Returns the medication (consumable)
	 *
	 * @return medication
	 *
	 */
	public Consumable getConsumable() {

		if (this.getMdht().getConsumable() != null)
			return new Consumable(this.getMdht().getConsumable());
		return null;

	}

	/**
	 * Returns the dose quantity
	 *
	 * @return dose quantity
	 */
	public IVL_PQ getDoseQuantity() {

		return this.getMdht().getDoseQuantity();

	}

	/**
	 * Gets the second - n effective time
	 *
	 * @return 2nd - nth effective time or null
	 */
	public ArrayList<SXCM_TS> getEffectiveTimeList() {

		if (this.getMdht().getEffectiveTimes().size() > 1) {

			ArrayList<SXCM_TS> result = new ArrayList<SXCM_TS>();
			boolean first = true;
			for (SXCM_TS effectiveTime : this.getMdht().getEffectiveTimes()) {
				if (!first)
					result.add(effectiveTime);
				else
					first = false;
			}
			return result;
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
	 * Gets the max subordinate sequence number.
	 *
	 * @return the max subordinate sequence number
	 */
	public int getMaxSubordinateSequenceNumber() {
		int max = 0;
		for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
			if (entryRelationship.getSubstanceAdministration() != null
					&& entryRelationship.getSequenceNumber().getValue().intValue() > max) {
				max = entryRelationship.getSequenceNumber().getValue().intValue();
			}
		}
		return max;
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
			return new PatientMedicalInstructionsEntry(
					getMdht().getPharmPatientMedicalInstructions());
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
			return new PharmSubstitutionHandlingEntry(
					getMdht().getPharmSubstitutionHandlingEntry());
		}
		return null;
	}

	/**
	 * Gets the possible substitutions
	 *
	 * @return the possible substitutions
	 */
	public Supply getPossibleSubstitution() {

		Supply supply;
		for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
			if (entryRelationship.getTypeCode()
					.getValue() == x_ActRelationshipEntryRelationship.COMP.getValue()) {
				if ((supply = entryRelationship.getSupply()) != null) {
					if (supply.getClassCode().getValue() == ActClassSupply.SPLY.getValue() && supply
							.getMoodCode().getValue() == x_DocumentSubstanceMood.RQO.getValue()) {
						for (final II templateId : supply.getTemplateIds()) {
							if (templateId.getRoot()
									.equalsIgnoreCase(SubstanceAdminSubstitution.CODE_SYSTEM_OID))
								return supply;
						}
					}
				}
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
	 * Returns the rate quantity
	 *
	 * @return rate quantity
	 */
	public IVL_PQ getRateQuantity() {

		return this.getMdht().getRateQuantity();

	}

	/**
	 * Gets the reason for.
	 *
	 * @return the reason for
	 */
	public Identificator getReasonFor() {
		if (this.getMdht().getPharmInternalReference() != null) {
			final InternalReference internalReference = getMdht().getInternalReferences().get(0);
			if ((internalReference.getIds() != null) && (internalReference.getIds().size() > 0)) {
				return new Identificator(internalReference.getIds().get(0));
			}
		}
		return null;
	}

	/**
	 * Get the amount of possible repetition of the prescription
	 *
	 * return Amount of possible repetitions
	 *
	 */
	public BigInteger getRepeatNumber() {

		IVL_INT repeatNumber = this.getMdht().getRepeatNumber();
		if (repeatNumber != null)
			return repeatNumber.getValue();
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
	 * Gets the first effective time
	 *
	 * @return Initial effective time or null
	 */
	public IVL_TS getStartEndDate() {
		if (this.getMdht().getEffectiveTimes().size() > 0) {
			return (IVL_TS) this.getMdht().getEffectiveTimes().get(0);
		}
		return null;
	}

	/**
	 * Gets the subordinate substance administration.
	 *
	 * @param sequenceNumber
	 *            the sequence number
	 * @return the subordinate substance administration
	 */
	public SubstanceAdministration getSubordinateSubstanceAdministration(int sequenceNumber) {
		for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
			if (entryRelationship.getSubstanceAdministration() != null && entryRelationship
					.getSequenceNumber().getValue().intValue() == sequenceNumber) {
				return new SubstanceAdministration(entryRelationship.getSubstanceAdministration());
			}
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
			final SupplyEntry supplyEntry = getMdht().getPharmSupplyEntry();
			final PQ pq = supplyEntry.getQuantity();
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
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Set the Approach Site code with a SNOMED-CT NullFlavor.UNK code (only
	 * text reference)
	 *
	 * @param reference
	 *            Textual reference to approach site code
	 *
	 */
	public void setApproachSiteCode(String reference) {

		final CD approachSiteCode = CdaUtil.getMdhtDatatypesFactoryInstance().createCD();
		approachSiteCode.setNullFlavor(NullFlavor.UNK);
		approachSiteCode.setCodeSystem(APPROACH_SITE_CODE_SYSTEM_OID);
		approachSiteCode.setCodeSystemName(APPROACH_SITE_CODE_SYSTEM_NAME);
		if (reference != null)
			approachSiteCode.setOriginalText(Util.createReference(reference));
		this.getMdht().getApproachSiteCodes().add(approachSiteCode);

	}

	/**
	 * Sets approach site code
	 *
	 * @param code
	 *            Approach site code
	 * @param displayName
	 *            Approach site display name
	 * @param codeSystem
	 *            Used code system
	 * @param codeSystemName
	 *            User code system name
	 * @param reference
	 *            Reference
	 */
	public void setApproachSiteCode(String code, String displayName, String codeSystem,
			String codeSystemName, String reference) {
		final CD approachCode = CdaUtil.getMdhtDatatypesFactoryInstance().createCD();
		if (codeSystem != null)
			approachCode.setCodeSystem(codeSystem);
		if (codeSystemName != null)
			approachCode.setCodeSystem(codeSystemName);
		if (code != null) {
			approachCode.setCode(code);
			if (displayName != null)
				approachCode.setDisplayName(displayName);
		} else {
			approachCode.setNullFlavor(NullFlavor.UNK);
		}
		if (reference != null)
			approachCode.setOriginalText(Util.createReference(reference));
		this.getMdht().getApproachSiteCodes().add(approachCode);
	}

	/**
	 * Set type of dosing to Combination
	 *
	 */
	public void setCombinationDosing() {
		boolean alreadyPresent = false;
		ArrayList<II> newTemplateIds = new ArrayList<II>();

		for (II templateId : this.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.11".equalsIgnoreCase(templateId.getRoot())) {
				alreadyPresent = true;
				newTemplateIds.add(templateId);
			} else if (!("1.3.6.1.4.1.19376.1.5.3.1.4.8".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.9".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.7.1".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.10".equalsIgnoreCase(templateId.getRoot()))) {
				newTemplateIds.add(templateId);
			}
		}
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().addAll(newTemplateIds);
		if (!alreadyPresent) {
			this.getMdht().getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.11", "IHE PHARM").getIi());
		}
	}

	/**
	 * Set type of dosing to Conditional
	 *
	 */
	public void setConditionalDosing() {
		boolean alreadyPresent = false;
		ArrayList<II> newTemplateIds = new ArrayList<II>();

		for (II templateId : this.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.10".equalsIgnoreCase(templateId.getRoot())) {
				alreadyPresent = true;
				newTemplateIds.add(templateId);
			} else if (!("1.3.6.1.4.1.19376.1.5.3.1.4.8".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.9".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.7.1".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.11".equalsIgnoreCase(templateId.getRoot()))) {
				newTemplateIds.add(templateId);
			}
		}
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().addAll(newTemplateIds);
		if (!alreadyPresent) {
			this.getMdht().getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.10", "IHE PHARM").getIi());
		}
	}

	/**
	 * Set the medication (consumable)
	 *
	 * @param consumable
	 *            Dose quantity of the medication
	 *
	 */
	public void setConsumable(org.ehealth_connector.cda.Consumable consumable) {

		this.getMdht().setConsumable(consumable.getMdht());

	}

	/**
	 * Set the dose quantity
	 *
	 * @param doseQuantity
	 *            Dose quantity of the medication
	 *
	 */
	public void setDoseQuantity(IVL_PQ doseQuantity) {

		this.getMdht().setDoseQuantity(doseQuantity);

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
	 * Sets the id. Note: replaces all existing identifiers.
	 *
	 * @param id
	 *            the new id
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
			entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			entryRelationship.setAct(entry.getMdht());
			entryRelationship.setInversionInd(Boolean.TRUE);
			this.getMdht().getEntryRelationships().add(entryRelationship);
		}
	}

	/**
	 * Sets the medication fullfillment instructions.
	 *
	 * @param instructions
	 *            the new medication fullfillment instructions
	 */
	public void setMedicationFullfillmentInstructions(String instructions) {

		final MedicationFullfillmentInstructionsEntry professionnalInstructions = new MedicationFullfillmentInstructionsEntry();
		professionnalInstructions.setTextReference(instructions);
		setMedicationFullfillmentInstructions(professionnalInstructions);
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
	 * Set type of dosing to Normal
	 *
	 */
	public void setNormalDosing() {
		boolean alreadyPresent = false;
		ArrayList<II> newTemplateIds = new ArrayList<II>();

		for (II templateId : this.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.7.1".equalsIgnoreCase(templateId.getRoot())) {
				alreadyPresent = true;
				newTemplateIds.add(templateId);
			} else if (!("1.3.6.1.4.1.19376.1.5.3.1.4.8".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.9".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.10".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.11".equalsIgnoreCase(templateId.getRoot()))) {
				newTemplateIds.add(templateId);
			}
		}
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().addAll(newTemplateIds);
		if (!alreadyPresent) {
			this.getMdht().getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "IHE PHARM").getIi());
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
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			entryRelationShip.setAct(entry.getMdht());
			entryRelationShip.setInversionInd(Boolean.TRUE);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the pharm substitution handling entry.
	 *
	 * @param entry
	 *            the new pharm substitution handling entry
	 */
	public void setPharmSubstitutionHandlingEntry(PharmSubstitutionHandlingEntry entry) {
		final PharmSubstitutionHandlingEntry old = this.getPharmSubstitutionHandlingEntry();
		if (old != null) {
			for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
				if (old.getMdht() == entryRelationship.getAct()) {
					entryRelationship.setSupply(entry.getMdht());
					break;
				}
			}
		} else {
			final EntryRelationship entryRelationShip = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setSupply(entry.getMdht());
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Set the rate quantity
	 *
	 * @param rateQuantity
	 *            Rate quantity of the medication
	 *
	 */
	public void setRateQuantity(IVL_PQ rateQuantity) {

		this.getMdht().setRateQuantity(rateQuantity);

	}

	/**
	 * Sets the reason for.
	 *
	 * @param internalReferenceIdentificator
	 *            the new reason for
	 */
	public void setReasonFor(Identificator internalReferenceIdentificator) {
		if ((getMdht().getInternalReferences() != null)
				&& (getMdht().getInternalReferences().size() > 0)) {
			final InternalReference internalReference = getMdht().getInternalReferences().get(0);
			internalReference.getIds().clear();
			internalReference.getIds().add(internalReferenceIdentificator.getIi());
		} else {
			final InternalReference internalReference = IHEFactory.eINSTANCE
					.createInternalReference().init();
			internalReference.getIds().add(internalReferenceIdentificator.getIi());
			internalReference.setMoodCode(x_DocumentActMood.EVN);
			internalReference.setClassCode(x_ActClassDocumentEntryAct.ACT);

			final EntryRelationship entryRelationShip = CDAFactory.eINSTANCE
					.createEntryRelationship();
			// needed? entryRelationShip.setInversionInd(false);
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
			entryRelationShip.setAct(internalReference);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Sets the amount of possible repetition of the prescription
	 *
	 * @param amount
	 *            Amount of possible repetitions
	 *
	 */
	public void setRepeatNumber(BigInteger amount) {

		final IVL_INT repeatNumber = DatatypesFactory.eINSTANCE.createIVL_INT();
		repeatNumber.setValue(amount);
		this.getMdht().setRepeatNumber(repeatNumber);
	}

	/**
	 * Sets the route of administration.
	 *
	 * @param code
	 *            the new route of administration
	 */
	public void setRouteOfAdministration(Code code) {
		this.getMdht().setRouteCode(code.getCE());
	}

	/**
	 * Set type of dosing to Split
	 *
	 */
	public void setSplitDosing() {
		boolean alreadyPresent = false;
		ArrayList<II> newTemplateIds = new ArrayList<II>();

		for (II templateId : this.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.9".equalsIgnoreCase(templateId.getRoot())) {
				alreadyPresent = true;
				newTemplateIds.add(templateId);
			} else if (!("1.3.6.1.4.1.19376.1.5.3.1.4.8".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.7.1".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.10".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.11".equalsIgnoreCase(templateId.getRoot()))) {
				newTemplateIds.add(templateId);
			}
		}
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().addAll(newTemplateIds);
		if (!alreadyPresent) {
			this.getMdht().getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.9", "IHE PHARM").getIi());
		}
	}

	/**
	 * Defines the starting and ending date
	 *
	 * This is the first EffectiveTime in the sequence --> list of effective
	 * times is cleared before setting this one
	 *
	 * @param startingDate
	 *            Starting date
	 *
	 * @param endingDate
	 *            Ending date
	 */
	public void setStartEndDate(Date startingDate, Date endingDate) {

		final IVL_TS time = CdaUtil.getMdhtDatatypesFactoryInstance().createIVL_TS();
		time.setLow(DateUtil.createIVXB_TSFromDate(startingDate));
		time.setHigh(DateUtil.createIVXB_TSFromDate(endingDate));

		this.getMdht().getEffectiveTimes().clear();
		this.getMdht().getEffectiveTimes().add(time);
	}

	/**
	 * Defines the starting and ending date (clear existing ones before)
	 *
	 * This is the first EffectiveTime in the sequence --> list of effective
	 * times is cleared before setting this one
	 *
	 * @param effectiveTime
	 *            Initial effective time
	 */
	public void setStartEndDate(IVL_TS effectiveTime) {

		this.getMdht().getEffectiveTimes().clear();

		final IVL_TS time = CdaUtil.getMdhtDatatypesFactoryInstance().createIVL_TS();
		if (effectiveTime.getLow() != null && effectiveTime.getLow().getValue() != null)
			time.setLow(DateUtil.createIVXB_TSFromDate(
					DateUtil.parseDateyyyyMMdd(effectiveTime.getLow().getValue())));
		else
			time.setLow(null);

		if (effectiveTime.getHigh() != null && effectiveTime.getHigh().getValue() != null)
			time.setHigh(DateUtil.createIVXB_TSFromDate(
					DateUtil.parseDateyyyyMMdd(effectiveTime.getHigh().getValue())));
		else
			time.setHigh(null);

		this.getMdht().getEffectiveTimes().add(time);
	}

	/**
	 * Sets the subordinate substance administration.
	 *
	 * @param sequenceNumber
	 *            the sequence number.
	 * @param substanceAdmin
	 *            the substance administration.
	 */
	public void setSubordinateSubstanceAdministration(int sequenceNumber,
			SubstanceAdministration substanceAdmin) {
		for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
			if (entryRelationship.getSubstanceAdministration() != null
					&& entryRelationship.getSequenceNumber().getValue().equals(sequenceNumber)) {
				entryRelationship.setSubstanceAdministration(substanceAdmin.copy());
				return;
			}
		}
		final EntryRelationship entryRelationship = CDAFactory.eINSTANCE.createEntryRelationship();
		entryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		entryRelationship.setSubstanceAdministration(substanceAdmin.copy());
		INT seqNumber = DatatypesFactory.eINSTANCE.createINT();
		seqNumber.setValue(sequenceNumber);
		entryRelationship.setSequenceNumber(seqNumber);
		this.getMdht().getEntryRelationships().add(entryRelationship);
	}

	/**
	 * Sets the supply quantity value.
	 *
	 * @param value
	 *            the new supply quantity value
	 */
	public void setSupplyQuantityValue(BigDecimal value) {
		final PQ pq = DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), "1");
		if (this.getMdht().getPharmSupplyEntry() != null) {
			final SupplyEntry supplyEntry = getMdht().getPharmSupplyEntry();
			supplyEntry.setQuantity(pq);
		} else {
			final PharmSupplyEntry supplyEntry = PHARMFactory.eINSTANCE.createPharmSupplyEntry()
					.init();
			supplyEntry.setQuantity(pq);
			supplyEntry.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
			final EntryRelationship entryRelationShip = CDAFactory.eINSTANCE
					.createEntryRelationship();
			entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
			entryRelationShip.setSupply(supplyEntry);
			this.getMdht().getEntryRelationships().add(entryRelationShip);
		}
	}

	/**
	 * Set type of dosing to Tapered
	 *
	 */
	public void setTaperedDosing() {
		boolean alreadyPresent = false;
		ArrayList<II> newTemplateIds = new ArrayList<II>();

		for (II templateId : this.getMdht().getTemplateIds()) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.8".equalsIgnoreCase(templateId.getRoot())) {
				alreadyPresent = true;
				newTemplateIds.add(templateId);
			} else if (!("1.3.6.1.4.1.19376.1.5.3.1.4.7.1".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.9".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.10".equalsIgnoreCase(templateId.getRoot())
					|| "1.3.6.1.4.1.19376.1.5.3.1.4.11".equalsIgnoreCase(templateId.getRoot()))) {
				newTemplateIds.add(templateId);
			}
		}
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().addAll(newTemplateIds);
		if (!alreadyPresent) {
			this.getMdht().getTemplateIds()
					.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.8", "IHE PHARM").getIi());
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
