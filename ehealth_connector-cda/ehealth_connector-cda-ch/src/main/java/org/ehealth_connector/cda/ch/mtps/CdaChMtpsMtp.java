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

package org.ehealth_connector.cda.ch.mtps;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemReferenceEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanSection;
import org.ehealth_connector.cda.ihe.pharm.PatientMedicalInstructionsEntry;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionPermission;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PatientMedicalInstructions;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
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
 * The Class CdaChMtpsMtp. see also CDA CH MTPS 7.4.2.3
 */
public class CdaChMtpsMtp extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp> {

	public static PatientMedicalInstructionsEntry createPatientMedicalInstruction(
			String textReference) {
		// TODO Auto-generated method stub
		final PatientMedicalInstructionsEntry pi = new PatientMedicalInstructionsEntry();
		pi.setTextReference(textReference);
		return pi;
	}

	/**
	 * Instantiates a new cda ch mtps mtp.
	 */
	public CdaChMtpsMtp() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch mtps mtp.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CdaChMtpsMtp(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsMtp().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Medikamentöser Behandlungsplan");
			break;
		case FRENCH:
			setTitle("Plan de traitement médicamenteux");
			break;
		case ITALIAN:
			setTitle("Piano terapeutico farmacologico");
			break;
		case ENGLISH:
			setTitle("Medication Treatment Plan");
			break;
		}

		final MedicationTreatmentPlanSection section = new MedicationTreatmentPlanSection(
				getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps mtp document
	 *
	 * @param doc
	 *            the document
	 */
	public CdaChMtpsMtp(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp doc) {
		super(doc);
	}

	/**
	 * Adds the id.
	 *
	 * @param codedId
	 *            the new id
	 */
	public void addId(Identificator codedId) {
		final II ii = CdaChUtil.createUniqueIiFromIdentificator(codedId);
		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).getIds().add(ii);
		// this.getMdht().getIds().add(ii);
	}

	/*
	 * ImmunizationSection section = null; if
	 * (getMdht().getImmunizationsSection() == null) { section = new
	 * ImmunizationSection(getLanguageCode());
	 * this.getMdht().addSection(section.getMdht()); } else { section = new
	 * ImmunizationSection(getMdht().getImmunizationsSection()); }
	 * section.addImmunization(immunization, true); }
	 *
	 * public List<ImmunizationRecommendation> getImmunizationRecommendations()
	 * { // Search for the right section final Section tps =
	 * getDoc().getImmunizationRecommendationSection(); if (tps == null) {
	 * return null; } final EList<SubstanceAdministration>
	 * substanceAdministrations = tps .getSubstanceAdministrations();
	 *
	 * final List<ImmunizationRecommendation> immunizations = new
	 * ArrayList<ImmunizationRecommendation>(); for (final
	 * SubstanceAdministration substanceAdministration :
	 * substanceAdministrations) { final ImmunizationRecommendation immunization
	 * = new ImmunizationRecommendation(
	 * (org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation)
	 * substanceAdministration); immunizations.add(immunization); } return
	 * immunizations; }
	 */

	public void addSubstanceAdministration(CE priorityCode, CE routeCode, IVL_PQ doseQuantity,
			IVL_PQ rateQuantity, SXCM_TS planificationTime, Consumable consumable, Author author,
			CD approachSite, SXCM_TS startTime, SXCM_TS endTime,
			org.ehealth_connector.cda.ch.mtps.enums.RouteOfAdministration routeOfAdministration,
			SXCM_TS uniqueDailyDoseTime, SXCM_TS multipleDailyDoseTime, Double prescribedQuantity,
			String unitOfPrescribedQuantity, boolean isSubstitionPossible) {
		final SubstanceAdministration substanceAdministration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		substanceAdministration.setClassCode(ActClass.SBADM);
		substanceAdministration.setMoodCode(x_DocumentSubstanceMood.EVN);

		substanceAdministration.getTemplateIds()
				.add(new Identificator("2.16.756.5.30.1.1.1.1.1", "CDA-CH.Body.MediL3").getIi());
		substanceAdministration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "IHE PHARM").getIi());
		substanceAdministration.getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.24", "HL7 CCD").getIi());
		substanceAdministration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7", "IHE PHARM").getIi());

		substanceAdministration.getIds().add(DatatypesFactory.eINSTANCE.createII(NullFlavor.NA));
		final Code code = new Code("2.16.840.1.113883.5.4", "DRUG", "Medikamentöse Therapie");
		substanceAdministration.setCode(code.getCD());
		substanceAdministration.setText(Util.createReference("null"));
		substanceAdministration.setStatusCode(getCS("completed"));
		substanceAdministration.setPriorityCode(priorityCode);
		// doseQuantity - Quantité unitaire (unit of Quantité [supply] class)
		substanceAdministration.setDoseQuantity(doseQuantity);
		// rateQuantity
		substanceAdministration.setRateQuantity(rateQuantity);
		substanceAdministration.getEffectiveTimes().add(planificationTime);
		// Consumable (Substance(s) active(s) et Produit)
		substanceAdministration.setConsumable(consumable.getMdht());

		// Authors
		substanceAdministration.getAuthors().add(author.getAuthorMdht());

		// Site d’administration
		substanceAdministration.getApproachSiteCodes().add(approachSite);

		// Date de début -> effectiveTime (planification)
		substanceAdministration.getEffectiveTimes().add(startTime);

		// Date de fin
		substanceAdministration.getEffectiveTimes().add(endTime);

		// Voie d’administration (routeCode)
		substanceAdministration
				.setRouteCode(routeOfAdministration.getCode(this.getLanguageCode()).getCE());
		// mtpEntry.setRouteOfAdministration(getRouteOfAdministration());

		// Dose journalière- fréquence (prise quotidienne unique)
		if (uniqueDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes().add(uniqueDailyDoseTime);
		}
		// Dose journalière- fréquence (prise quotidienne multiple)
		if (multipleDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes().add(multipleDailyDoseTime);
		}

		// Quantité prescrite / à remettre
		substanceAdministration.getEntryRelationships()
				.add(getPrescribedQty(prescribedQuantity, unitOfPrescribedQuantity));

		// Raison du traitement (see Act -> SetReasonForTreatment)

		// Substitution autorisée
		if (isSubstitionPossible) {
			substanceAdministration.getEntryRelationships().add(getPossibleSubstitution());
		}
		// Reference ID de MTP
		final Reference referenceXCRPTToMTP = CDAFactory.eINSTANCE.createReference();
		referenceXCRPTToMTP.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(this.getId());
		referenceXCRPTToMTP.setExternalDocument(documentEntry.getMdht());
		substanceAdministration.getReferences().add(referenceXCRPTToMTP);
		this.getMdht().getMedicationTreatmentPlanSection()
				.addSubstanceAdministration(substanceAdministration);
	}

	public void addSubstanceAdministration(SubstanceAdministration substance) {
		this.getMedicationTreatmentPlanSection().getMdht().addSubstanceAdministration(substance);
	}

	private CS getCS(String code) {
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}

	public MedicationTreatmentPlanItemReferenceEntry getMedicationTreatmentPlanItemReferenceEntry() {
		final MedicationTreatmentPlanItemReferenceEntry referenceEntry = new MedicationTreatmentPlanItemReferenceEntry();
		referenceEntry.getMdht().getTemplateIds()
				.add((new Identificator("1.3.6.1.4.1.19376.1.9.1.3.7", null).getIi()));
		final SubstanceAdministration administration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		administration.getIds().add(this.getMdht().getId());
		administration.setMoodCode(x_DocumentSubstanceMood.INT);
		administration.setCode(this.getMdht().getCode());
		administration.setClassCode(ActClass.SBADM);
		final org.openhealthtools.mdht.uml.cda.Consumable consumable = CDAFactory.eINSTANCE
				.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		administration.setConsumable(consumable);
		referenceEntry.getMdht().addSubstanceAdministration(administration);

		return referenceEntry;
	}

	/**
	 * Gets the medication treatment plan section.
	 *
	 * @return the medication treatment plan section
	 */
	public MedicationTreatmentPlanSection getMedicationTreatmentPlanSection() {
		if (this.getMdht().getMedicationTreatmentPlanSection() != null) {
			return new MedicationTreatmentPlanSection(
					this.getMdht().getMedicationTreatmentPlanSection());
		}
		return null;
	}

	private EntryRelationship getPossibleSubstitution() {
		// TODO Auto-generated method stub
		final EntryRelationship possibleSubstitution = CDAFactory.eINSTANCE
				.createEntryRelationship();
		possibleSubstitution.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		final Supply substitutionSupply = CDAFactory.eINSTANCE.createSupply();
		substitutionSupply.setClassCode(ActClassSupply.SPLY);
		substitutionSupply.setMoodCode(x_DocumentSubstanceMood.RQO);
		substitutionSupply.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));

		final PharmSubstitutionPermission substitutionPermissionSo4 = CDAFactory.eINSTANCE
				.createPharmSubstitutionPermission();
		substitutionPermissionSo4.setClassCode(ActClassRoot.SUBST);
		substitutionPermissionSo4.setMoodCode(ActMood.PERM);
		final CE pharmCode = DatatypesFactory.eINSTANCE.createCE();
		pharmCode.setCodeSystem("2.16.840.1.113883.5.1070");
		pharmCode.setCodeSystemName("HL7 Substance Admin Substitution");
		pharmCode.setCode("E");
		pharmCode.setDisplayName("equivalent");
		substitutionPermissionSo4.setCode(pharmCode);
		possibleSubstitution.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.9", "").getIi());
		substitutionSupply.setSubjectOf4(substitutionPermissionSo4);

		possibleSubstitution.setSupply(substitutionSupply);
		return possibleSubstitution;
	}

	private EntryRelationship getPrescribedQty(Double Value, String unit) {
		// TODO Auto-generated method stub
		final EntryRelationship prescribedQty = CDAFactory.eINSTANCE.createEntryRelationship();
		prescribedQty.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		final Supply prescribedQuantity = CDAFactory.eINSTANCE.createSupply();
		prescribedQuantity.setClassCode(ActClassSupply.SPLY);
		prescribedQuantity.setMoodCode(x_DocumentSubstanceMood.RQO);
		prescribedQuantity.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		final Double value = new Double(10);
		prescribedQuantity.setQuantity(
				DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), value.toString()));
		prescribedQuantity.setText(DatatypesFactory.eINSTANCE.createED(value + " " + unit));
		prescribedQty.setSupply(prescribedQuantity);
		return prescribedQty;
	}

	public EList<Reference> getReferences() {
		return this.getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0).getReferences();
	}

	/*
	 * public void addActiveProblemConcern(ActiveProblemConcern
	 * activeProblemConcern) { // find or create (and add) the Section
	 * org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection aps = getDoc()
	 * .getActiveProblemsSection(); if (aps == null) { aps =
	 * IHEFactory.eINSTANCE.createActiveProblemsSection().init();
	 * aps.setTitle(Util
	 * .st(SectionsVACD.ACTIVE_PROBLEMS.getSectionTitle(getDoc().getLanguageCode
	 * ()))); getDoc().addSection(aps); }
	 *
	 * // add the MDHT Object to the section
	 * aps.addAct(activeProblemConcern.copyMdhtProblemConcernEntry());
	 *
	 * // update the MDHT Object content references to CDA level 1 text if
	 * (updateProblemConcernReferences(aps.getActs(),
	 * SectionsVACD.ACTIVE_PROBLEMS)) { if (IsNarrativeTextGenerationEnabled())
	 * { // create the CDA level 1 text
	 * aps.createStrucDocText(generateNarrativeTextActiveProblemConcerns()); }
	 * else { setNarrativeTextSectionActiveProblems(""); } } else {
	 * aps.createStrucDocText("Keine Angaben");
	 * activeProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships(
	 * ).get(0) .getObservation().setText(Util.createEd("")); } }
	 */

	public boolean hasItemEntry() {
		boolean flag = false;
		if (getMdht().getMedicationTreatmentPlanSection() != null) {
			if (getMdht().getMedicationTreatmentPlanSection()
					.getMedicationTreatmentPlanItemEntries().size() > 0) {
				flag = true;
			}
		}
		return flag;
	}

	private void initMTPEntry() {
		// TODO Auto-generated method stub
		// final
		// org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry
		// e = PHARMFactory.eINSTANCE.createMedicationTreatmentPlanItemEntry();
		this.getMdht().getMedicationTreatmentPlanSection().init();
		// this.getMdht().getMedicationTreatmentPlanSection().getMedicationTreatmentPlanItemEntries().add(e);
	}

	public void setPatientInstructions(String instructions) {
		// find or create (and add) the Section
		if (!hasItemEntry()) {
			initMTPEntry();
			// init if doesn't exist
		}
		final PatientMedicalInstructions pmi = IHEFactory.eINSTANCE
				.createPatientMedicalInstructions();
		pmi.setText((DatatypesFactory.eINSTANCE.createED(instructions)));

		final PatientMedicalInstructionsEntry pi = new PatientMedicalInstructionsEntry();
		pi.setTextReference(instructions);

		/*
		 * MedicationTreatmentPlanSection mtpsection = null; //
		 * //ImmunizationSection section = null; if
		 * (getMdht().getMedicationTreatmentPlanSection() == null) { mtpsection
		 * = new MedicationTreatmentPlanSection(this.getLanguageCode());
		 * this.getMdht().addSection(mtpsection.getMdht()); } else { mtpsection
		 * = new MedicationTreatmentPlanSection(getMdht().
		 * getMedicationTreatmentPlanSection()); }
		 * mtpsection.getMdht().getMedicationTreatmentPlanItemEntries().toArray(
		 * );
		 *
		 * this.getMdht().getMedicationTreatmentPlanSection().
		 * getSubstanceAdministrations().get(0)
		 * .getEntryRelationships().add(null);
		 */
		// new
		// PatientMedicalInstructionsEntry().getMdht().getEntryRelationships().);
		// )getMedicationTreatmentPlanItemEntries().get(0).getPatientMedicalInstructionss().add(pmi);

	}

	public void setProfessionalInstructions(String instructions) {
		// find or create (and add) the Section

		if (!hasItemEntry()) {
			initMTPEntry();
			// create if doesn't exist
		}
		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).getMedicationFullfillmentInstructions()
				.setText(DatatypesFactory.eINSTANCE.createED(instructions));
	}

	public void setReasonForTreatment(String r) {
		// find or create (and add) the Section
		if (!hasItemEntry()) {
			initMTPEntry();
			// create if doesn't exist
		}
		final Act reasonOfTreatment = CDAFactory.eINSTANCE.createAct();
		reasonOfTreatment.setClassCode(x_ActClassDocumentEntryAct.ACT);
		reasonOfTreatment.setMoodCode(x_DocumentActMood.EVN);
		reasonOfTreatment.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.4.1", "IHE PHARM").getIi());
		reasonOfTreatment.setText(DatatypesFactory.eINSTANCE.createED(r));
		// prendre la référence de l'élément indiquant la raison dans le
		// document
		// mtpEntry.setReasonFor();
		reasonOfTreatment.getIds()
				.add(/* mtpEntry.getReasonFor().getIi() */new Identificator("root", "extension")
						.getIi());
		reasonOfTreatment.setStatusCode(getCS("completed"));
		final EntryRelationship reason = CDAFactory.eINSTANCE.createEntryRelationship();
		reason.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
		reason.setInversionInd(false);
		reason.setAct(reasonOfTreatment);
		reasonOfTreatment.getEntryRelationships().add(reason);
		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).addAct(reasonOfTreatment);
	}

	public void setReference(Identificator id) {
		/** Reference from document where this document is (PML) **/
		// create if doesn't exist
		if (!hasItemEntry()) {
			initMTPEntry();
		}
		final Reference referenceXCRPT = CDAFactory.eINSTANCE.createReference();
		referenceXCRPT.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(id);
		referenceXCRPT.setExternalDocument(documentEntry.getMdht());

		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).getReferences().add(referenceXCRPT);
	}
}
