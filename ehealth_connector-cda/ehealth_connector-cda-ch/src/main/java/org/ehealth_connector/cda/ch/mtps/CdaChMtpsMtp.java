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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.ihe.pharm.MedicationFullfillmentInstructionsEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemReferenceEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanSection;
import org.ehealth_connector.cda.ihe.pharm.PatientMedicalInstructionsEntry;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.PharmSubjectOf4;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionPermission;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PatientMedicalInstructions;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_event;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXPR_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassSupply;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.SetOperator;
import org.openhealthtools.mdht.uml.hl7.vocab.TimingEvent;
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

	private final AbstractCda cdaDocument = null;

	private final ClinicalDocument mdhtDocument = null;

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
	}

	@Deprecated
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
		// doseQuantity - Unit of the quantity( [supply] class)
		substanceAdministration.setDoseQuantity(doseQuantity);
		// rateQuantity
		substanceAdministration.setRateQuantity(rateQuantity);
		substanceAdministration.getEffectiveTimes().add(planificationTime);
		// Consumable (Active Substance(s) and Product)
		substanceAdministration.setConsumable(consumable.getMdht());

		// Authors
		substanceAdministration.getAuthors().add(author.getAuthorMdht());

		// Administration Site / Location
		substanceAdministration.getApproachSiteCodes().add(approachSite);

		// Beginning Date -> effectiveTime (planning)
		substanceAdministration.getEffectiveTimes().add(startTime);

		// End Date
		substanceAdministration.getEffectiveTimes().add(endTime);

		// Administration Route (routeCode)
		substanceAdministration
				.setRouteCode(routeOfAdministration.getCode(this.getLanguageCode()).getCE());

		// Daily dosage - frequency > unique daily intake
		if (uniqueDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes().add(uniqueDailyDoseTime);
		}
		// Daily dosage - frequency (multiple daily intake)
		if (multipleDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes().add(multipleDailyDoseTime);
		}

		// Prescribed Quantity / to prescribe
		substanceAdministration.getEntryRelationships()
				.add(createPrescribedQty(prescribedQuantity, unitOfPrescribedQuantity));

		// see Act -> SetReasonForTreatment

		// Authorisation of Substitution
		if (isSubstitionPossible) {
			substanceAdministration.getEntryRelationships().add(getPossibleSubstitution());
		}
		// Reference ID of MTP
		final Reference referenceXCRPTToMTP = CDAFactory.eINSTANCE.createReference();
		referenceXCRPTToMTP.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(this.getId());
		referenceXCRPTToMTP.setExternalDocument(documentEntry.getMdht());
		substanceAdministration.getReferences().add(referenceXCRPTToMTP);
		this.getMdht().getMedicationTreatmentPlanSection()
				.addSubstanceAdministration(substanceAdministration);
	}

	public void addSubstanceAdministration(Code priorityCode, Code routeCode, Double doseQuantity,
			Double rateQuantity, Date planificationTime, Consumable consumable, Author author,
			CD approachSite, Date startTime, Date endTime,
			org.ehealth_connector.cda.ch.mtps.enums.RouteOfAdministration routeOfAdministration,
			Date uniqueDailyDoseTime, ArrayList<Date> multipleDailyDoseTime,
			Double prescribedQuantity, String unitOfPrescribedQuantity,
			boolean isSubstitionPossible) {
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
		substanceAdministration.setStatusCode(createStatusCode("completed").getCS());
		substanceAdministration.setPriorityCode(priorityCode.getCE());
		// doseQuantity - Unit Quantity -> [supply] class
		substanceAdministration.setDoseQuantity(createDosage(doseQuantity));
		// rateQuantity
		substanceAdministration.setRateQuantity(createDosage(rateQuantity));
		substanceAdministration.getEffectiveTimes().add(DateUtil.createSTCM_TS(planificationTime));
		// Consumable (Active Substance(s) and product)
		substanceAdministration.setConsumable(consumable.getMdht());

		// Authors
		substanceAdministration.getAuthors().add(author.getAuthorMdht());

		// Site / Location of administration
		substanceAdministration.getApproachSiteCodes().add(approachSite);

		// Begin Date -> effectiveTime (planning)
		substanceAdministration.getEffectiveTimes().add(DateUtil.createSTCM_TS(startTime));

		// End Date
		substanceAdministration.getEffectiveTimes().add(DateUtil.createSTCM_TS(endTime));

		// Route of administration (routeCode)
		substanceAdministration.setRouteCode(routeCode.getCE());
		// mtpEntry.setRouteOfAdministration(getRouteOfAdministration());

		// Daily Dosage - frequency (unique daily intake)
		if (uniqueDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes()
					.add(DateUtil.createSTCM_TS(uniqueDailyDoseTime));
		}
		// Daily dosage - frequency (multiple daily intake)
		if (multipleDailyDoseTime != null) {
			for (final Date multipleDate : multipleDailyDoseTime) {
				substanceAdministration.getEffectiveTimes()
						.add(DateUtil.createSTCM_TS(multipleDate));
			}

		}

		// PRescribed quantity-> to give
		substanceAdministration.getEntryRelationships()
				.add(createPrescribedQty(prescribedQuantity, unitOfPrescribedQuantity));

		// (see Act -> SetReasonForTreatment)

		// Substitution is authorized
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

	public IVL_PQ createDosage(Double doseQuantity) {
		final IVL_PQ ivl_pq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivl_pq.setUnit("ml");
		ivl_pq.setValue(doseQuantity);
		return ivl_pq;
	}

	public MedicationTreatmentPlanItemReferenceEntry createMedicationTreatmentPlanItemReferenceEntry() {
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
	 * <div class="en">Creates a multiple daily dose description
	 * <div class="de"></div> <div class="fr"></div>
	 *
	 * @return <div class="en">Timestamp (SXCM_TS)</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	private SXCM_TS createMultipleDailyDoses(ArrayList<String> dates) {

		for (final String date : dates) {

		}

		// root of multiple doses
		final SXPR_TS sxcmTs = DatatypesFactory.eINSTANCE.createSXPR_TS();
		sxcmTs.setOperator(SetOperator.A);

		// beginning dose 1
		final SXPR_TS sxcmTsInner1 = DatatypesFactory.eINSTANCE.createSXPR_TS();
		sxcmTs.getComps().add(sxcmTsInner1);
		final IVL_TS ivlTs1 = DatatypesFactory.eINSTANCE.createIVL_TS();
		final IVXB_TS low1 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		low1.setValue("20120505");
		final IVXB_TS high1 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		high1.setValue("20151105");
		ivlTs1.setLow(low1);
		ivlTs1.setHigh(high1);
		sxcmTsInner1.getComps().add(ivlTs1);

		final EIVL_TS eivlTs = DatatypesFactory.eINSTANCE.createEIVL_TS();
		final EIVL_event event = DatatypesFactory.eINSTANCE.createEIVL_event();
		event.setCode(TimingEvent.ACM.getName());
		eivlTs.setOperator(SetOperator.A);
		eivlTs.setEvent(event);
		sxcmTsInner1.getComps().add(eivlTs);
		// end dose 1

		// beginning dose 2
		final SXPR_TS sxcmTsInner2 = DatatypesFactory.eINSTANCE.createSXPR_TS();
		sxcmTsInner2.setOperator(SetOperator.I);
		sxcmTs.getComps().add(sxcmTsInner2);

		final IVL_TS ivlTs2 = DatatypesFactory.eINSTANCE.createIVL_TS();
		final IVXB_TS low2 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		low2.setValue("20130404");
		final IVXB_TS high2 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		high2.setValue("20161107");
		ivlTs2.setLow(low2);
		ivlTs2.setHigh(high2);
		sxcmTsInner2.getComps().add(ivlTs2);

		final EIVL_TS eivlTs2 = DatatypesFactory.eINSTANCE.createEIVL_TS();
		final EIVL_event event2 = DatatypesFactory.eINSTANCE.createEIVL_event();
		event2.setCode(TimingEvent.ACV.getName());
		eivlTs2.setOperator(SetOperator.A);
		eivlTs2.setEvent(event2);
		sxcmTsInner2.getComps().add(eivlTs2);
		// end dose 2

		return sxcmTs;
	}

	private EntryRelationship createPrescribedQty(Double value, String unit) {
		// TODO Auto-generated method stub
		final EntryRelationship prescribedQty = CDAFactory.eINSTANCE.createEntryRelationship();
		prescribedQty.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		final Supply prescribedQuantity = CDAFactory.eINSTANCE.createSupply();
		prescribedQuantity.setClassCode(ActClassSupply.SPLY);
		prescribedQuantity.setMoodCode(x_DocumentSubstanceMood.RQO);
		prescribedQuantity.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		prescribedQuantity.setQuantity(
				DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), value.toString()));
		prescribedQuantity.setText(DatatypesFactory.eINSTANCE.createED(value + " " + unit));
		prescribedQty.setSupply(prescribedQuantity);
		return prescribedQty;
	}

	private Code createStatusCode(String statusCode) {
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setNullFlavor(NullFlavor.UNK);
		cs.setCode(statusCode);
		return new Code(cs);
	}

	// format "10.31.2016"
	private SXCM_TS createSXCMTS(String dateMMDDYYYY) {

		final SXCM_TS uniqueDosage = DatatypesFactory.eINSTANCE.createSXCM_TS();
		final EIVL_TS tS = DatatypesFactory.eINSTANCE.createEIVL_TS();
		tS.setValue(DateUtil.formatDate(DateUtil.date(dateMMDDYYYY)));
		uniqueDosage.setValue(tS.getValue());
		uniqueDosage.setOperator(SetOperator.A);
		final EIVL_event eventEIVL = DatatypesFactory.eINSTANCE.createEIVL_event();
		final Code eventCode = new Code("2.16.840.1.113883.5.139", TimingEvent.HS.getName());
		eventCode.setCode(eventCode.getCode());
		tS.setEvent(eventEIVL);
		return uniqueDosage;
	}

	private CS getCS(String code) {
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}

	public Value getDosage() {
		if (((SubstanceAdministration) getMdht()).getDoseQuantity() != null) {
			final Value value = new Value(((SubstanceAdministration) getMdht()).getDoseQuantity());
			return value;
		}
		return null;
	}

	@Override
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getId() != null)) {
			id = new Identificator(getMdht().getId());
		}
		return id;
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

	public MedicationTreatmentPlanItemEntry getMtpEntry() {
		MedicationTreatmentPlanItemEntry mtpEntry = null;
		final List<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry> entries = getMdht()
				.getMedicationTreatmentPlanSection().getMedicationTreatmentPlanItemEntries();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry entry : entries) {
			mtpEntry = new MedicationTreatmentPlanItemEntry(entry);
		}

		return mtpEntry;
	}

	public PatientMedicalInstructionsEntry getPatientInstructions() {

		final PatientMedicalInstructionsEntry pi = new PatientMedicalInstructionsEntry();

		pi.setTextReference(this.getMdht().getMedicationTreatmentPlanSection()
				.getMedicationTreatmentPlanItemEntries().get(0).getPatientInstructions().get(0)
				.getText().getText());
		return pi;
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
		final PharmSubjectOf4 pharmSubjectOf4 = CDAFactory.eINSTANCE.createPharmSubjectOf4();
		pharmSubjectOf4.setSubstitutionPermission(substitutionPermissionSo4);
		substitutionSupply.setSubjectOf4(pharmSubjectOf4);
		possibleSubstitution.setSupply(substitutionSupply);

		return possibleSubstitution;
	}

	public String getProfessionalInstructions() {
		return this.getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0)
				.getMedicationFullfillmentInstructions().getText().getText();
	}

	public String getReasonForTreatment() {
		return this.getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0).getActs().get(0).getText()
				.getText();
	}

	public Identificator getReference() {
		return new Identificator(getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0).getReferences().get(0)
				.getExternalDocument().getIds().get(0));
	}

	@Deprecated
	public EList<Reference> getReferences() {
		return this.getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0).getReferences();
	}

	public void getStatusCode(Code statusCode) {
		getMdht().setCode(statusCode.getCS());
	}

	@Deprecated
	public EList<SubstanceAdministration> getSubstanceadministrations() {
		final EList<SubstanceAdministration> substances = this.getMdht()
				.getMedicationTreatmentPlanSection().getSubstanceAdministrations();

		return substances;
	}

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

	private void initializeMedicationTreatmentPlanSection() {
		// TODO Auto-generated method stub

		this.getMdht().getMedicationTreatmentPlanSection().init();
	}

	@Deprecated
	public void old_setMtpEntry(MedicationTreatmentPlanItemEntry mtpEntry) {
		if (mtpEntry != null) {
			/**
			 * Set ID identically to the one of the Clinical Document, see
			 * 7.5.2.4
			 **/
			this.getMedicationTreatmentPlanSection().getMdht().setId(
					/* mtpEntry.getMdht().getClinicalDocument().getId() */mtpEntry.getId().getIi());
			/** Patient Instructions **/

			setPatientInstructions(
					mtpEntry.getPatientMedicalInstructions().getMdht().getText().getText());

			/** Professional Instructions **/
			final MedicationFullfillmentInstructionsEntry proInstructions = mtpEntry
					.getMedicationFullfillmentInstructions();
			/** Reference **/
			final EList<Reference> references = mtpEntry.getMdht().getReferences();
			/** Entry content -> substanceAdmin **/
			final EList<SubstanceAdministration> substAdministrations = mtpEntry.getMdht()
					.getSubstanceAdministrations();
			for (final SubstanceAdministration substanceAdministration : substAdministrations) {
				this.getMedicationTreatmentPlanSection().getMdht()
						.addSubstanceAdministration(substanceAdministration);
			}
		}
	}

	@Deprecated
	public void setMedicationTreatmentPlanItemEntry(MedicationTreatmentPlanItemEntry mtpEntry) {
		final EList<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry> entriesMedicationSections = getMdht()
				.getMedicationTreatmentPlanSection().getMedicationTreatmentPlanItemEntries();
		if (entriesMedicationSections != null) {

			final org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry iheMtpItemEntry = PHARMFactory.eINSTANCE
					.createMedicationTreatmentPlanItemEntry().init();

			/** setID **/
			iheMtpItemEntry.getIds().add(mtpEntry.getId().getIi());

			/** Patients instruction **/
			iheMtpItemEntry.getPatientMedicalInstructionss()
					.add(mtpEntry.getPatientMedicalInstructions().getMdht());

			/** Professional instructions **/
			final EList<EntryRelationship> professionalInstructionsEntryRelationships = mtpEntry
					.getMedicationFullfillmentInstructions().getMdht().getEntryRelationships();
			for (final EntryRelationship entryRelationship : professionalInstructionsEntryRelationships) {
				iheMtpItemEntry.getMedicationFullfillmentInstructions().getEntryRelationships()
						.add(entryRelationship);
			}

			/** Reference **/
			final EList<Reference> references = mtpEntry.getMdht().getReferences();
			for (final Reference reference : references) {
				iheMtpItemEntry.getReferences().add(reference);
			}

			/** set substanceAdministration */
			final EList<SubstanceAdministration> substanceAdministrations = mtpEntry.getMdht()
					.getSubstanceAdministrations();
			for (final SubstanceAdministration substanceAdministration : substanceAdministrations) {
				iheMtpItemEntry.addSubstanceAdministration(substanceAdministration);
			}

			entriesMedicationSections.add(iheMtpItemEntry);
		}
		System.out.println(entriesMedicationSections);
	}

	// use this one
	public void setMtpEntry(MedicationTreatmentPlanItemEntry mtp) {
		this.getMdht().getMedicationTreatmentPlanSection()
				.addSubstanceAdministration(mtp.getMdht());
	}

	public void setPatientInstructions(String instructions) {
		// find or create (and add) the Section
		if (!hasItemEntry()) {
			initializeMedicationTreatmentPlanSection();
			// init if doesn't exist
		}
		final PatientMedicalInstructions pmi = IHEFactory.eINSTANCE
				.createPatientMedicalInstructions();
		pmi.setText((DatatypesFactory.eINSTANCE.createED(instructions)));
		this.getMdht().getMedicationTreatmentPlanSection().getMedicationTreatmentPlanItemEntries()
				.get(0).getPatientInstructions().add(pmi);
	}

	public void setProfessionalInstructions(String instructions) {
		// find or create (and add) the Section

		if (!hasItemEntry()) {
			initializeMedicationTreatmentPlanSection();
			// create if doesn't exist
		}
		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).getMedicationFullfillmentInstructions()
				.setText(DatatypesFactory.eINSTANCE.createED(instructions));
	}

	public void setReasonForTreatment(String reasonForTreatment) {
		// find or create (and add) the Section
		if (!hasItemEntry()) {
			initializeMedicationTreatmentPlanSection();
			// create if doesn't exist
		}
		final Act actReasonOfTreatment = CDAFactory.eINSTANCE.createAct();
		actReasonOfTreatment.setClassCode(x_ActClassDocumentEntryAct.ACT);
		actReasonOfTreatment.setMoodCode(x_DocumentActMood.EVN);
		actReasonOfTreatment.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.4.1", "IHE PHARM").getIi());
		actReasonOfTreatment.setText(DatatypesFactory.eINSTANCE.createED(reasonForTreatment));
		// take the reference of the element while indicating the reason in the
		// document
		actReasonOfTreatment.getIds().add(new Identificator("root", "extension").getIi());
		actReasonOfTreatment.setStatusCode(getCS("completed"));
		final EntryRelationship reason = CDAFactory.eINSTANCE.createEntryRelationship();
		reason.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
		reason.setInversionInd(false);
		reason.setAct(actReasonOfTreatment);
		actReasonOfTreatment.getEntryRelationships().add(reason);
		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).addAct(actReasonOfTreatment);
	}

	public void setReference(Identificator id) {
		/** Reference from document where this document is (PML) **/
		// create if doesn't exist
		if (!hasItemEntry()) {
			initializeMedicationTreatmentPlanSection();
		}
		final Reference referenceXCRPT = CDAFactory.eINSTANCE.createReference();
		referenceXCRPT.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(id);
		referenceXCRPT.setExternalDocument(documentEntry.getMdht());

		this.getMedicationTreatmentPlanSection().getMdht().getMedicationTreatmentPlanItemEntries()
				.get(0).getReferences().add(referenceXCRPT);
	}

	public void setStatusCode(Code statusCode) {
		getMdht().setCode(statusCode.getCS());
	}
}
