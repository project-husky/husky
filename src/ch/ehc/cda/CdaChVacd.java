/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package ch.ehc.cda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.ehc.cda.AllergyIntolerance;
import org.ehc.general.Util;
import org.ehc.general.ConvenienceUtilsEnums.Language;
import org.ehc.general.DateUtil;
import org.ehc.general.CSUtil;
import org.ehc.cda.Disease;
import org.ehc.cda.Immunization;
import org.ehc.cda.ImmunizationTextBuilder;
import org.ehc.cda.LoincSectionCode;
import org.ehc.cda.Medication;
import org.ehc.cda.PastIllnessBuilder;
import org.ehc.cda.ProblemConcernEntry;
import org.ehc.cda.Serologie;
import org.ehc.cda.Treatment;
import org.ehc.cda.TreatmentBuilder;
import org.ehc.cda.TreatmentPlanTextBuilder;
import org.ehc.cda.Value;
import org.ehc.cda.converter.MedicationConverter;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.Encounter;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Procedure;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection;
import org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;

/**
 * <div class="de" Ein CDA Dokument, welches der Spezifikation CDA-CH-VACD entspricht.</div>
 * <div class="fr">Class CdaChVacd.</div>
 * <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends CdaCh {

	/**
	 * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-eVACDOC Objekts. Beide repräsentieren ein Impfdokument.</div>
	 * <div class="fr"></div>
	 *
	 * @param doc 
	 * 		<div class="de">eVACDOC</div>
	 *		<div class="fr"></div>
	 */
	public CdaChVacd(VACD doc) {
		super();
		this.doc = doc;
	}
	
	/**
	 * Liefert das MDHT-eVACDOC-Objekt zurück
	 *
	 * @return the doc
	 */
	public VACD getDoc() {
		return (VACD) this.doc;
	}
	
	/**
	 * Setzt das MDHT-eVACDOC-Objekt
	 *
	 * @param doc the new doc
	 */
	public void setDoc(VACD doc) {
		this.doc = doc;
	}	

	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 * @param language          Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet          Stylesheet, welches im CDA mittels <?xml-stylesheet> für die
	 *          menschlich Lesbare Darstellung referenziert werden soll.
	 */
	public CdaChVacd(Language language, String stylesheet) {
		super();
		doc = CHFactory.eINSTANCE.createVACD().init();
		setChMetadata(language, stylesheet);

		docRoot.setClinicalDocument(doc);
	}
	
	/**
	 * Set title and effectiveTime, otherwise document is NOT XML schema compliant.
	 * 
	 * @see ehealthconnector.cda.documents.ch.CdaCh#setChMetadata(ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.Language, java.lang.String)
	 */
	@Override
	public void setChMetadata(Language language, String stylesheet) {
		super.setChMetadata(language, stylesheet);
		
		setParentTemplateIds();
		
		doc.setTitle(st("eVACDOC"));
		doc.setEffectiveTime(DateUtil.nowAsTS());
	}
	
	/**
	 * Sets the parent template ids
	 * Schematron validation checks for this ids !
	 */
	private void setParentTemplateIds() {
		// IHE PCC Medical Documents Specification
		doc.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.1.1"));
	
		// IHE Immunization Detail Specification
		doc.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.1.18.1.2"));
		
		// CDA-CH
		doc.getTemplateIds().add(ii("2.16.756.5.30.1.1.1.1", "CDA-CH"));

		// eVACDOC (VACD) V1
		
		// TODO: acutually validator crashes when setting this !!??
//		doc.getTemplateIds().add(ii("2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH-VACD"));
		
		// fix missing extension value in MDHT model.
		for (II templateId : doc.getTemplateIds()) {
			if ("2.16.756.5.30.1.1.1.1.3.5.1".equals(templateId.getRoot())) {
				templateId.setExtension("CDA-CH-VACD");
			}
		}
	}
	
	/**
	 * Erstellt ein neues eVACDOC CDA Dokument
	 * 
	 * @param language
	 *            Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet
	 *            Stylesheet, welches im CDA mittels <?xml-stylesheet> fuer die
	 *            menschlich Lesbare Darstellung referenziert werden soll.
	 */
	public CdaChVacd(Language language, String stylesheet, Object old) {
		doc = CHFactory.eINSTANCE.createVACD().init();

		// Set language of the document
		doc.setLanguageCode(Util.createLanguageCode(language));

		// Set OID of the document
		II docID = DatatypesFactory.eINSTANCE.createII();
		doc.setId(docID);
		docID.setRoot("MDHT");
		docID.setExtension("1817558763");

		// Set Type ID
		InfrastructureRootTypeId typeId = CDAFactory.eINSTANCE
				.createInfrastructureRootTypeId();
		doc.setTypeId(typeId);
		typeId.setRoot("2.16.840.1.113883.1.3");
		typeId.setExtension("POCD_HD000040");

		// set title
		doc.setTitle(st("eVACDOC"));

		// set effective time
		doc.setEffectiveTime(DateUtil.nowAsTS());
		
		// Set Confidentially Code
		CE confidentialityCode = DatatypesFactory.eINSTANCE.createCE();
		doc.setConfidentialityCode(confidentialityCode);
		confidentialityCode.setCode("1941043196");

		initDocumentRoot(stylesheet);
	}
	
	private void initDocumentRoot(String stylesheet) {
		// Create document root
		docRoot = CDAFactory.eINSTANCE.createDocumentRoot();

		// Add the stylesheet processing instructions to the document root using featuremaputil
		if (stylesheet != null) {
		FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(), "xml-stylesheet", "type=\"text/xsl\" href=\"" + stylesheet
						+ "\" ");
		}

		// Set the CDA document
		docRoot.setClinicalDocument(doc);

		// set xml namespace
		docRoot.getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);
	}

	/**
	 * C add allergy.
	 *
	 * @param allergie <br>
	 * 		<div class="de"> allergie</div>
	 * 		<div class="fr"> allergie</div>
	 * 		<div class="it"> allergie</div>
	 */
	public void cAddAllergy(AllergyIntolerance allergy) {
		AllergyIntoleranceConcern concern = IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init();
		
		org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance iheAllergy = allergy.getAllergyIntolerance();
		concern.addObservation(iheAllergy);
		concern.getEntryRelationships().get(0).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);	
		
		getAllergiesReactionsSection().addAct(concern);
	}
	
	/**
	 * Fuegt eine Serologie hinzu.
	 * 
	 * @param serologie
	 */
	public void cAddSerologie(Serologie serologie) {
		Act act = CDAFactory.eINSTANCE.createAct();
		act.setClassCode(x_ActClassDocumentEntryAct.ACT);
		act.setMoodCode(x_DocumentActMood.EVN);

		act.setCode(createLaboratorySpecialityCode());
		
		act.setStatusCode(CSUtil.completed());
		act.addObservation(createObservation(serologie));

		act.getEntryRelationships().get(0).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);

		getLaboratorySpecialitySection().addAct(act);
	}	
	
	private Observation createObservation(Serologie serologie) {
		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.3.1.6"));
		observation.setCode(createCode(serologie));
		observation.setStatusCode(CSUtil.completed());
		observation.setEffectiveTime(convertDate(serologie.getDate()));
		return observation;
	}

	private IVL_TS convertDate(Date date) {
		if (date == null) {
			return createUnknownTime();
		} else {
			IVL_TS ts = DatatypesFactory.eINSTANCE.createIVL_TS();
			ts.setValue(format(date));
			return ts;
		}
	}

	private String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	private CD createCode(Serologie serologie) {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode("5193-3");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		code.setDisplayName(serologie.toString());
		return code;
	}

	@SuppressWarnings("unused")
	private CD createAllergyCode() {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode("213020009");
		code.setCodeSystem("2.16.840.1.113883.6.96");
		code.setCodeSystemName("SNOMED CT");
		code.setDisplayName("Egg protein allergy (disorder)");
		return code;
	}
	
	@SuppressWarnings("unused")
	private CD createAllergyObservationCode(AllergyIntolerance allergie) {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode("FALG");
		code.setCodeSystem("2.16.840.1.113883.5.4");
		code.setCodeSystemName("ObservationIntoleranceType");
		code.setDisplayName("");
		return code;
	}

	private AllergiesReactionsSection getAllergiesReactionsSection() {
		org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection section = findAllergiesReactionsSection();
		if (section == null) { 
			section = createAllergiesReactionsSection();
			doc.addSection(section);
		}
		return section;
	}
	
	private Section getLaboratorySpecialitySection() {
		org.openhealthtools.mdht.uml.cda.Section section = findLaboratorySpecialitySection();
		if (section == null) { 
			section = createLaboratorySpecialitySection();
			doc.addSection(section);
		}
		return section;	
	}	

	private Section createLaboratorySpecialitySection() {
		Section section = CDAFactory.eINSTANCE.createSection();
		section.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.3.3.2.1"));
		section.setCode(createLaboratorySpecialityCode());
		section.setTitle(st("Laborbefund"));
		return section;
	}
	
	private Section createTreatmentPlanSection() {
		Section section = CDAFactory.eINSTANCE.createSection();
		section.setTitle(st("Impfempfehlung"));
		section.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.3.3.2.1"));
		section.setCode(createTreatmentPlanCode());
		return section;
	}	

	private CE createTreatmentPlanCode() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCode(LoincSectionCode.TREATMENT_PLAN.getLoincCode());
		ce.setCodeSystem("2.16.840.1.113883.6.1");
		ce.setDisplayName("TREATMENT PLAN");
		return ce;
	}

	private II ii(String root) {
		II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(root);
		return ii;
	}
	
	private II ii(String root, String extension) {
		II ii = ii(root);
		ii.setExtension(extension);
		return ii;
	}	

	private CE createLaboratorySpecialityCode() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCode(LoincSectionCode.SEROLOGY_STUDIES.getLoincCode());
		ce.setCodeSystem("2.16.840.1.113883.6.1");
		ce.setDisplayName("SEROLOGY STUDIES");
		return ce;
	}

	private Section findLaboratorySpecialitySection() {
		for (Section section : doc.getSections()) {
			if (LoincSectionCode.isLaboratorySpeciality(section.getCode().getCode())) {
				return (Section) section;
			}
		}
		return null;
	}

	/**
	 * Creates the allergies reactions section (displayName="Allergies and Adverse Reactions").
	 * 
	 * @return AllergiesReactionsSection
	 */
	private AllergiesReactionsSection createAllergiesReactionsSection() {
		org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection section = IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
		return section;
	}

	/**
	 * Fügt eine Impfung hinzu.
	 *
	 * @param medication            Medikament
	 * @param dosage            Dosis
	 * @param date            Datum der Verabreichung
	 * @param arzt            Verabreichender Arzt
	 */
	public void cAddImmunization(Medication medication, Value dosage, Date date, org.ehc.general.Author arzt) {
		MedicationConverter c = new MedicationConverter(medication);
		org.openhealthtools.mdht.uml.cda.ihe.Immunization immunization = c.convert();
		
		getImmunizationSection().addSubstanceAdministration(immunization);
	}
	
	public void cAddImmunization(org.ehc.cda.Immunization immunization, org.ehc.general.Author author) {
		org.openhealthtools.mdht.uml.cda.ihe.Immunization iheImmunization = immunization.getImmunization();
		iheImmunization.getAuthors().add(author.getAuthorMdht());
		
		getImmunizationSection().addSubstanceAdministration(iheImmunization);
		getImmunizationSection().createStrucDocText(getImmunizationText());
	}
	
	private String getImmunizationText() {
		ImmunizationTextBuilder b = new ImmunizationTextBuilder(cGetImmunizations());
		return b.toString();
	}
	
	private String getTreatmentPlanText() {
		TreatmentPlanTextBuilder b = new TreatmentPlanTextBuilder(cGetImmunizations());
		return b.toString();
	}	

	
	@SuppressWarnings("unused")
	private Supply createSupply() {
		Supply supply = IHEFactory.eINSTANCE.createSupplyEntry();
		return supply;
	}

	@SuppressWarnings("unused")
	private Encounter createEncounter() {
		Encounter encounter = IHEFactory.eINSTANCE.createEncounterActivity();
				
		return encounter;
	}

	@SuppressWarnings("unused")
	private Procedure createProcedure() {
		Procedure procedure = IHEFactory.eINSTANCE.createProcedureEntryPlanOfCareActivityProcedure();
		procedure.setEffectiveTime(createUnknownTime());
		return procedure;
	}

	private IVL_TS createUnknownTime() {
		IVXB_TS ts_unknown = DatatypesFactory.eINSTANCE.createIVXB_TS();
		
		IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
		effectiveTime.setLow(ts_unknown);
		
		return effectiveTime;
	}
	
	private IVL_TS createUnknownLowHighTimeNullFlavor() {
		IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
		effectiveTime.setLow(createNullFlavorUnknown());
		effectiveTime.setHigh(createNullFlavorUnknown());
		return effectiveTime;
	}	

	private IVXB_TS createNullFlavorUnknown() {
		IVXB_TS ts = DatatypesFactory.eINSTANCE.createIVXB_TS();
		ts.setNullFlavor(NullFlavor.UNK);
		return ts;
	}

	private ImmunizationsSection getImmunizationSection() {
		org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection section = findImmunizationSection();
		if (section == null) { 
			section = createImmunizationSection();
			doc.addSection(section);
		}
		return section;
	}
	
	private ActiveProblemsSection getActiveProblemsSection() {
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection section = findActiveProblemsSection();
		if (section == null) { 
			section = createActiveProblemsSection();
			doc.addSection(section);
		}
		return section;
	}
	
	private HistoryOfPastIllnessSection getHistoryOfPastIllnessSection() {
		org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection section = findHistoryOfPastIllnessSection();
		if (section == null) { 
			section = createHistoryOfPastIllnessSection();
			doc.addSection(section);
		}
		return section;
	}
	
	private HistoryOfPastIllnessSection createHistoryOfPastIllnessSection() {
		HistoryOfPastIllnessSection section = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
		section.setTitle(st("Bisherige Krankheiten"));
		return section;
	}

	/**
	 * Creates the problem list section (displayName="Problem list").
	 * 
	 * @return {@link ActiveProblemsSection}
	 */

	private ActiveProblemsSection createActiveProblemsSection() {
		ActiveProblemsSection activeProblemsSection = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
		return activeProblemsSection;
	}

	private ImmunizationsSection findImmunizationSection() {
		for (Section section : doc.getSections()) {
			if (LoincSectionCode.isHistoryOfImmunization(section.getCode().getCode())) {
				return (ImmunizationsSection) section;
			}
		}
		return null;
	}
	
	private AllergiesReactionsSection findAllergiesReactionsSection() {
		for (Section section : doc.getSections()) {
			if (LoincSectionCode.isAllergiesReactions(section.getCode().getCode())) {
				return (AllergiesReactionsSection) section;
			}
		}
		return null;
	}	
	
	private ActiveProblemsSection findActiveProblemsSection() {
		for (Section section : doc.getSections()) {
			if (LoincSectionCode.isActiveProblems(section.getCode().getCode())) {
				return (ActiveProblemsSection) section;
			}
		}
		return null;
	}
	
	private HistoryOfPastIllnessSection findHistoryOfPastIllnessSection() {
		for (Section section : getSections()) {
			if (LoincSectionCode.isHistoryOfPastIllness(section.getCode().getCode())) {
				return (HistoryOfPastIllnessSection) section;
			}
		}
		return null;
	}
	
	private EList<Section> getSections() {
		return doc.getSections();
	}
	
		

	/**
	 * Creates the immunization section (displayName="History of immunizations").
	 * 
	 * @return ImmunizationsSection
	 */
	private org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection createImmunizationSection() {
		org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection section = IHEFactory.eINSTANCE.createImmunizationsSection().init();
		section.setTitle(st("Impfungen"));
		return section;
	}
	
	private ST st(String text) {
		ST value = DatatypesFactory.eINSTANCE.createST();
		value.addText(text);
		return value;
	}

	public void cAddProblemConcernEntry(org.ehc.cda.ProblemConcernEntry problemConcernEntry) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblem = problemConcernEntry.getProblemConcernEntry();
		
		getActiveProblemsSection().addAct(iheProblem);
	}
	
	public void cAddHistoryOfPastIllnessEntry(org.ehc.cda.ProblemConcernEntry problemConcernEntry) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblem = problemConcernEntry.getProblemConcernEntry();
		
		getHistoryOfPastIllnessSection().addAct(iheProblem);
	}
	
	/**
	 * Adds an entry to the "HISTORY OF PAST ILLNESS" section.
	 * 
	 * @param disease
	 */
	public void cAddPastIllNess(Disease disease) {
		PastIllnessBuilder builder = new PastIllnessBuilder(disease);
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblemConcernEntry = builder.build();
		
		getHistoryOfPastIllnessSection().createStrucDocText("KeineAngaben");
		getHistoryOfPastIllnessSection().addAct(iheProblemConcernEntry);
	}
	
	/**
	 * Adds an entry to the "TREATMENT PLAN" section.
	 * 
	 * @param disease
	 */
	public void cAddTreatment(Treatment treatment) {
		TreatmentBuilder b = new TreatmentBuilder(treatment);
		org.openhealthtools.mdht.uml.cda.SubstanceAdministration substanceAdministration = b.build();
		
		getTreatmentPlanSection().addSubstanceAdministration(substanceAdministration);
		getTreatmentPlanSection().createStrucDocText(getTreatmentPlanText());
	}	
	
	private Section getTreatmentPlanSection() {
		org.openhealthtools.mdht.uml.cda.Section section = findTreatmentPlanSection();
		if (section == null) { 
			section = createTreatmentPlanSection();
			doc.addSection(section);
		}
		return section;	
	}

	private Section findTreatmentPlanSection() {
		for (Section section : doc.getSections()) {
			if (LoincSectionCode.isTreatmentPlan(section.getCode().getCode())) {
				return (Section) section;
			}
		}
		return null;
	}
	
	private CD createCodeNullFlavor() {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setNullFlavor(NullFlavor.NA);
		return code;
	}
	
	
	
	private org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry createProblemEntry(Disease disease) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry entry = IHEFactory.eINSTANCE.createProblemEntry();
		entry.setClassCode(ActClassObservation.OBS);
		entry.setMoodCode(x_ActMoodDocumentObservation.EVN);
		
		entry.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
		entry.getTemplateIds().add(ii("2.16.840.1.113883.10.20.1.28"));
		entry.getTemplateIds().add(ii("2.16.840.1.113883.10.20.1.54"));
		
		entry.getIds().add(ii("2.16.756.5.30.1.1.1.1.3.1.1", "B3DC860A-D59C-42E2-9527-BE21A0D0334F"));
		
		entry.setCode(createCode(disease));
		entry.setText(createProblemEntryText());
		entry.setStatusCode(CSUtil.completed());
		entry.setEffectiveTime(createUnknownLowHighTimeNullFlavor());
		entry.getValues().add(createCode(disease));
		return entry;
	}

	private ED createProblemEntryText() {
		return DatatypesFactory.eINSTANCE.createED();
	}

	private CD createCode(Disease disease) {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode(disease.getSnomedCode());
		code.setCodeSystem("2.16.840.1.113883.6.96");
		code.setCodeSystemName("SNOMED CT");
		code.setDisplayName(disease.name());
		return code;
	}

	/**
	 * Fügt ein Leiden hinzu.
	 *
	 * @param problem            Das Leiden
	 */
	public void addProblemConcern(
			org.ehc.cda.ProblemConcernEntry problem) {
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = IHEFactory.eINSTANCE
				.createActiveProblemsSection().init();
		doc.addSection(activeProblemsSection);

		// set up the narrative (human-readable) text portion of the alerts
		// section
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table border=\"1\" width=\"100%\">");
		buffer.append("<thead>");
		buffer.append("<tr>");
		buffer.append("<th>Risikokategorie</th>");
		buffer.append("<th>Risikofaktor</th>");
		buffer.append("</tr>");
		buffer.append("</thead>");
		buffer.append("<tbody>");
		buffer.append("<tr>");
		buffer.append("<td>Komplikationsrisiko</td>");
		buffer.append("<td><content ID='p1'>Niereninsuffizienz</content></td>");
		buffer.append("</tr>");
		buffer.append("</tbody>");
		buffer.append("</table>");
		activeProblemsSection.createStrucDocText(buffer.toString());

		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry leidenMdht = problem.getProblemConcernEntry();
		activeProblemsSection.addAct(leidenMdht);
	}

	/**
	 * Liefert alle Impfempfehlungen im eVACDOC.
	 *
	 * @return Liste von Impfempfehlungen
	 */
	public List<Immunization> getImmunizationRecommendations() {
		// Auto-generated method stub
		return null;
	}

	/**
	 * Liefert alle Impfungen im eVACDOC.
	 *
	 * @return Liste von Impfungen
	 */
	public List<Immunization> cGetImmunizations() {
		EList<SubstanceAdministration> substanceAdministrations = getImmunizationSection().getSubstanceAdministrations();
		
		List<Immunization> immunizations = new ArrayList<Immunization>();
		for (SubstanceAdministration substanceAdministration : substanceAdministrations) {
			Immunization immunization = convert((org.openhealthtools.mdht.uml.cda.ihe.Immunization) substanceAdministration);
			immunizations.add(immunization);
		}
		return immunizations;
	}

	/**
	 * Converts from IHE to convenience API class.
	 * 
	 * @param immunization
	 * @return Immunization - convenience API class
	 */
	private Immunization convert(org.openhealthtools.mdht.uml.cda.ihe.Immunization iheImmunization) {
		return new Immunization(iheImmunization);
	}

	/**
	 * Liefert alle Leiden im eVACDOC.
	 *
	 * @return Liste von Leiden
	 */
	public ArrayList<ProblemConcernEntry> getProblemConcernEntries() {
		// Get the ActiveProblemSection from the Document
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = (org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection) doc
				.getSections().get(0);

		// Create a List with Problem ConcernEntries
		ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();

		// Check if an Act is a problemConcernEntry. If so, create an
		// eHealthConnector ProblemConcernObject with it and add it to the list.
		for (Act act : activeProblemsSection.getActs()) {
			if (act instanceof org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) {
				ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
				problemConcernEntryList.add(problemConcernEntry);
			}
		}

		return problemConcernEntryList;
	}

	public boolean cHasPastIllness(Disease disease) {
		HistoryOfPastIllnessSection section = getHistoryOfPastIllnessSection();
		EList<Act> acts = section.getActs();
		for (Act act : acts) {
			for (Observation observation : act.getObservations()) {
				CD code = observation.getCode();
				if (code.getCode().equals(disease.getSnomedCode())) {
					return true;
				}
			}
		}
		return false;
	}
}
