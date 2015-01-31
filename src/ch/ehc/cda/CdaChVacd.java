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
 * Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package ch.ehc.cda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ActiveProblemConcernEntry;
import org.ehc.cda.AllergyConcern;
import org.ehc.cda.AllergyConcernTextBuilder;
import org.ehc.cda.AllergyIntolerance;
import org.ehc.cda.Disease;
import org.ehc.cda.Immunization;
import org.ehc.cda.ImmunizationRecommendation;
import org.ehc.cda.ImmunizationRecommendationTextBuilder;
import org.ehc.cda.ImmunizationTextBuilder;
import org.ehc.cda.Medication;
import org.ehc.cda.PastProblemConcernEntry;
import org.ehc.cda.Pregnancy;
import org.ehc.cda.ProblemConcernEntry;
import org.ehc.cda.ProblemConcernEntryTextBuilder;
import org.ehc.cda.ProblemConcernTextBuilder;
import org.ehc.cda.Serologie;
import org.ehc.cda.SimpleTextBuilder;
import org.ehc.cda.Value;
import org.ehc.cda.converter.MedicationConverter;
import org.ehc.common.Code;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Encounter;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Procedure;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil.Query;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;

import ch.ehc.cda.enums.LanguageCode;
import ch.ehc.cda.enums.ProblemsSpecialConditions;
import ch.ehc.cda.enums.StatusCode;
import ch.ehc.common.SectionsVACD;

/**
 * <div class="de" Ein CDA Dokument, welches der Spezifikation CDA-CH-VACD entspricht.</div> <div
 * class="fr">Class CdaChVacd.</div> <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends CdaCh {
	Query query;

	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 * @param german Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet Stylesheet, welches im CDA mittels <?xml-stylesheet> für die menschlich
	 *        Lesbare Darstellung referenziert werden soll.
	 */
	public CdaChVacd(LanguageCode german, String stylesheet) {
		super(CHFactory.eINSTANCE.createVACD().init());
		setChMetadata(german, stylesheet, "eVACDOC");
		CHPackage.eINSTANCE.eClass();
		// fix missing extension values in MDHT model.
		for (II templateId : doc.getTemplateIds()) {
			if ("2.16.756.5.30.1.1.1.1.3.5.1".equals(templateId.getRoot())) {
				templateId.setExtension("CDA-CH-VACD");
			}
			if ("2.16.756.5.30.1.1.1.1".equals(templateId.getRoot())) {
				templateId.setExtension("CDA-CH");
			}
		}
		query = new Query(this.doc);
	}

	/**
	 * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-VACD
	 * Objekts. Beide repräsentieren ein Impfdokument.</div> <div class="fr"></div>
	 *
	 * @param doc <div class="de">CdaChVacd</div> <div class="fr"></div>
	 */
	public CdaChVacd(VACD doc) {
		super(doc);
		this.setDoc(doc);
		query = new Query(this.doc);
	}

	/**
	 * Fügt ein Leiden hinzu.
	 *
	 * @param problemConcern Das Leiden
	 */
	public void addActiveProblemConcern(org.ehc.cda.ActiveProblemConcernEntry problemConcern) {

		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection;
		ProblemConcernTextBuilder tb;
		StrucDocText sectionTextStrucDoc;
		String activeProblemsSectionText;

		activeProblemsSection = getDoc().getActiveProblemsSection();
		if (activeProblemsSection == null) {
			activeProblemsSection = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
			activeProblemsSection.setTitle(Util.st(SectionsVACD.ACTIVE_PROBLEMS.getSectionTitleDe()));
			this.doc.addSection(activeProblemsSection);
		}

		// Update existing Entries with the reference to the CDA level 1 text and create the level 1
		// text.
		activeProblemsSectionText =
				Util.extractStringFromNonQuotedStrucDocText(activeProblemsSection.getText());
		ArrayList<ActiveProblemConcernEntry> problemConcernEntries = this.getProblemConcernEntries();
		tb =
				new ProblemConcernTextBuilder(problemConcernEntries, problemConcern,
						activeProblemsSectionText);
		//problemConcern = tb.getProblemConcernEntry();

		// Update the section text.
		// This is a workaround for the following problem:
		// - The sectionText can only be created once with the createSectionText Method
		// - The StrucDocText Object can´t create text with xml-elements inside. These will be quoted.
		// The Workaround crates a special text object, which can´t be read by the getText Method. So
		// the current state of the section text is stored in the activeProblemSectionText field.
		activeProblemsSectionText = tb.getSectionText();
		sectionTextStrucDoc = Util.createNonQotedStrucDocText(activeProblemsSectionText);
		activeProblemsSection.setText(sectionTextStrucDoc);

		// insert the values which are special for VACD Document
		problemConcern.copyMdhtProblemConcernEntry().getIds().add(Util.ii("1.3.6.1.4.1.19376.1.5.3.1.4.5")); 

		// Add the code for "Komplikations- oder Expositionsrisiken"
		CD komplikationsExpositionsrisikoCode = DatatypesFactory.eINSTANCE.createCD();
		komplikationsExpositionsrisikoCode.setCodeSystem("2.16.840.1.113883.6.96");
		komplikationsExpositionsrisikoCode.setCode("55607006");
		komplikationsExpositionsrisikoCode.setCodeSystemName("SNOMED CT");
		komplikationsExpositionsrisikoCode.setDisplayName("Problem");
		problemConcern.getMdhtProblemEntryList().get(0).setCode(komplikationsExpositionsrisikoCode);

		// create a copy of the given object and its sub-objects
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntryMdht =
				EcoreUtil.copy(problemConcern.copyMdhtProblemConcernEntry());
		activeProblemsSection.addAct(problemConcernEntryMdht);
		updateProblemConcernReferences(activeProblemsSection.getActs(), SectionsVACD.ACTIVE_PROBLEMS);
	}

	public void addPregnancy(Pregnancy pregnancy) {
		org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection phs;
		SimpleTextBuilder sb;

		//TODO Change to max one section in the model
		phs = getDoc().getPregnancyHistorySection();

		if (phs==null) {
			phs = IHEFactory.eINSTANCE.createPregnancyHistorySection().init();
			phs.setTitle(Util.st(SectionsVACD.HISTORY_OF_PREGNANCIES.getSectionTitleDe()));
			this.doc.addSection(phs);
		}

		//create the CDA level 1 text and update the MDHT Object content references to CDA level 1 text
		String pregnancyText = "Voraussichtlicher Geburtstermin: "+pregnancy.getEstimatedBirthdate();
		if (phs.getText() != null) {
			String oldSectionText = Util.extractStringFromNonQuotedStrucDocText(phs.getText());
			sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_PREGNANCIES, pregnancyText, oldSectionText);
		}
		else {
			sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_PREGNANCIES, pregnancyText);
		}

		ED reference = Util.createReference(sb.getNewTextContentIDNr(), SectionsVACD.HISTORY_OF_PREGNANCIES.getContentIdPrefix());
		pregnancy.getMdhtPregnancy().setText(reference);
		phs.addObservation(pregnancy.copyMdhtPregnancy());

		phs.createStrucDocText(sb.toString());
	}

	public void addAllergyProblemConcern(AllergyConcern huenereinweissAllergieLeiden) {
		org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection ars;

		//find or create (and add) the Section
		ars = getDoc().getAllergiesReactionsSection();
		if (ars==null) {
			ars = IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
			ars.setTitle(Util.st(SectionsVACD.ALLERGIES_REACTIONS.getSectionTitleDe()));
			this.doc.addSection(ars);
		}

		//add the MDHT Object to the section
		ars.addAct(huenereinweissAllergieLeiden.copyMdhtAllergyConcern());

		//update the MDHT Object content references to CDA level 1 text
		if (updateAllergyConcernReferences(ars.getActs(), SectionsVACD.ALLERGIES_REACTIONS)) {
			//create the CDA level 1 text
			ars.createStrucDocText(getAllergyProblemConcernText());
		}
		else {
			ars.createStrucDocText("Keine Angaben");
			huenereinweissAllergieLeiden.copyMdhtAllergyConcern().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
		}
	}

	public void addComment(String comment) {
		Section rs;
		SimpleTextBuilder sb;

		//find or create (and add) the Section
		rs = findRemarksSection();
		//rs = getDoc().getRemarksSection();
		if (rs==null) {
			rs = CHFactory.eINSTANCE.createRemarksSection().init();
			rs.setTitle(Util.st(SectionsVACD.REMARKS.getSectionTitleDe()));
			this.doc.addSection(rs);
		}

		//create add the MDHT Object to the section
		Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		rs.addAct(mComment);

		//update the MDHT Object content references to CDA level 1 text
		if (rs.getText() != null) {
			String oldSectionText = Util.extractStringFromNonQuotedStrucDocText(rs.getText());
			sb = new SimpleTextBuilder(SectionsVACD.REMARKS, comment, oldSectionText);
		}
		else {
			sb = new SimpleTextBuilder(SectionsVACD.REMARKS, comment);
		}

		ED reference = Util.createReference(sb.getNewTextContentIDNr(), SectionsVACD.REMARKS.getContentIdPrefix());
		mComment.setText(reference);

		//create the CDA level 1 text
		rs.createStrucDocText(sb.toString());
	}

	private Section findRemarksSection() {
		for (Section section : this.doc.getSections()) {
			if (SectionsVACD.isRemarks(section.getCode().getCode())) {
				return section;
			}
		}
		return null;
	}

	public void addHistoryOfPastIllnessEntry(org.ehc.cda.ProblemConcernEntry problemConcernEntry) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblem =
				problemConcernEntry.copyMdhtProblemConcernEntry();

		getDoc().getHistoryOfPastIllnessSection().addAct(iheProblem);
	}

	/**
	 * Fügt eine Impfung hinzu.
	 *
	 * @param medication Medikament
	 * @param dosage Dosis
	 * @param date Datum der Verabreichung
	 * @param arzt Verabreichender Arzt
	 */
	public void addImmunization(Medication medication, Value dosage, Date date,
			org.ehc.common.Author arzt) {
		MedicationConverter c = new MedicationConverter(medication);
		org.openhealthtools.mdht.uml.cda.ihe.Immunization immunization = c.convert();

		getImmunizationSection().addSubstanceAdministration(immunization);
	}

	public void addImmunization(org.ehc.cda.Immunization immunization, org.ehc.common.Author author) {
		ImmunizationsSection immunizationSection = this.getImmunizationSection();
		org.openhealthtools.mdht.uml.cda.ihe.Immunization iheImmunization =
				EcoreUtil.copy(immunization.getImmunization());

		iheImmunization.getAuthors().add(EcoreUtil.copy(author.getAuthorMdht()));

		immunizationSection.addSubstanceAdministration(iheImmunization);

		// Update the content references to cda level 1 text
		updateSubstanceAdministrationReferences(immunizationSection.getSubstanceAdministrations(), SectionsVACD.HISTORY_OF_IMMUNIZATION);

		immunizationSection.createStrucDocText(getImmunizationText());
	}

	public void addImmunizationRecommendation(ImmunizationRecommendation immunizationRecommendation) {
		org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection immunizationRecommendationsSection;

		//find or create (and add) the Section
		immunizationRecommendationsSection = getDoc().getImmunizationRecommendationSection();
		if (immunizationRecommendationsSection==null) {
			immunizationRecommendationsSection = createTreatmentPlanSection().init();
			immunizationRecommendationsSection.setTitle(Util.st(SectionsVACD.TREATMENT_PLAN.getSectionTitleDe()));
			this.doc.addSection(immunizationRecommendationsSection);
		}

		//add the MDHT Object to the section
		immunizationRecommendationsSection.addSubstanceAdministration(immunizationRecommendation.copyMdhtImmunizationRecommendation());

		//update the MDHT Object content references to CDA level 1 text
		updateSubstanceAdministrationReferences(immunizationRecommendationsSection.getSubstanceAdministrations(), SectionsVACD.TREATMENT_PLAN);

		//create the CDA level 1 text
		immunizationRecommendationsSection.createStrucDocText(getImmunizationRecommendationText());
	}

	public void addPastProblemConcern(PastProblemConcernEntry pastProblemConcern) {
		org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection hopis;

		//find or create (and add) the Section
		hopis = getDoc().getHistoryOfPastIllnessSection();
		if (hopis==null) {
			hopis = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
			hopis.setTitle(Util.st(SectionsVACD.HISTORY_OF_PAST_ILLNESS.getSectionTitleDe()));
			this.doc.addSection(hopis);
		}

		//add the MDHT Object to the section
		hopis.addAct(pastProblemConcern.copyMdhtProblemConcernEntry());

		//update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(hopis.getActs(), SectionsVACD.HISTORY_OF_PAST_ILLNESS)) {
			//create the CDA level 1 text
			hopis.createStrucDocText(getPastProblemConcernText());
		}
		else {
			hopis.createStrucDocText("Keine Angaben");
			pastProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
		}
	}

	/**
	 * Fuegt eine Serologie hinzu.
	 * 
	 * @param serologie
	 */
	public void addSerologie(Serologie serologie) {
		Act act = CDAFactory.eINSTANCE.createAct();
		act.setClassCode(x_ActClassDocumentEntryAct.ACT);
		act.setMoodCode(x_DocumentActMood.EVN);

		act.setCode(createLaboratorySpecialityCode());

		act.setStatusCode(StatusCode.COMPLETED.getCS());
		act.addObservation(createObservation(serologie));

		act.getEntryRelationships().get(0).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);

		getLaboratorySpecialitySection().addAct(act);
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

	private CD createCode(Serologie serologie) {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setCode("5193-3");
		code.setCodeSystem("2.16.840.1.113883.6.1");
		code.setCodeSystemName("LOINC");
		code.setDisplayName(serologie.toString());
		return code;
	}

	@SuppressWarnings("unused")
	private Encounter createEncounter() {
		Encounter encounter = IHEFactory.eINSTANCE.createEncounterActivity();

		return encounter;
	}

	/**
	 * Creates the immunization section (displayName="History of immunizations").
	 * 
	 * @return ImmunizationsSection
	 */
	private org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection createImmunizationSection() {
		org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection section =
				IHEFactory.eINSTANCE.createImmunizationsSection().init();
		section.setTitle(Util.st(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleDe()));
		return section;
	}

	private CE createLaboratorySpecialityCode() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCode(SectionsVACD.SEROLOGY_STUDIES.getLoincCode());
		ce.setCodeSystem("2.16.840.1.113883.6.1");
		ce.setDisplayName("SEROLOGY STUDIES");
		return ce;
	}

	private Section createLaboratorySpecialitySection() {
		Section section = CDAFactory.eINSTANCE.createSection();
		section.getTemplateIds().add(Util.ii("1.3.6.1.4.1.19376.1.3.3.2.1"));
		section.setCode(createLaboratorySpecialityCode());
		section.setTitle(Util.st("Laborbefund"));
		return section;
	}

	private Observation createObservation(Serologie serologie) {
		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.getTemplateIds().add(Util.ii("1.3.6.1.4.1.19376.1.3.1.6"));
		observation.setCode(createCode(serologie));
		observation.setStatusCode(StatusCode.COMPLETED.getCS());
		observation.setEffectiveTime(DateUtil.convertDate(serologie.getDate()));
		return observation;
	}

	@SuppressWarnings("unused")
	private Procedure createProcedure() {
		Procedure procedure = IHEFactory.eINSTANCE.createProcedureEntryPlanOfCareActivityProcedure();
		procedure.setEffectiveTime(DateUtil.createUnknownTime());
		return procedure;
	}

	@SuppressWarnings("unused")
	private Supply createSupply() {
		Supply supply = IHEFactory.eINSTANCE.createSupplyEntry();
		return supply;
	}

	private ImmunizationRecommendationSection createTreatmentPlanSection() {
		ImmunizationRecommendationSection section = CHFactory.eINSTANCE.createImmunizationRecommendationSection().init();
		section.setTitle(Util.st(SectionsVACD.TREATMENT_PLAN.getSectionTitleDe()));
		return section;
	}

	private ImmunizationsSection findImmunizationSection() {
		for (Section section : doc.getSections()) {
			if (SectionsVACD.isHistoryOfImmunization(section.getCode().getCode())) {
				return (ImmunizationsSection) section;
			}
		}
		return null;
	}

	private Section findLaboratorySpecialitySection() {
		// TODO Auto-generated method stub
		return null;
	}


	private ArrayList<AllergyConcern> getAllergyProblemConcernEntries() {
		//Search for the right section 
		Section ars = getDoc().getAllergiesReactionsSection();
		if (ars==null) {
			return null;
		}
		EList<Act> acts = ars.getActs();

		ArrayList<AllergyConcern> problemConcernEntries = new ArrayList<AllergyConcern>();
		for (Act act : acts) {
			AllergyConcern problemConcernEntry = new AllergyConcern((org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	private String getAllergyProblemConcernText() {
		ArrayList<AllergyConcern> problemConcernEntryList = new ArrayList<AllergyConcern>();
		//Convert from the specific PastProblemConcern Type to the more genearal PastProblemConcern
		for (AllergyConcern prob : getAllergyProblemConcernEntries()) {
			//TODO Create an Allergy Text Builder here
			problemConcernEntryList.add(prob);
		}

		AllergyConcernTextBuilder b = new AllergyConcernTextBuilder(problemConcernEntryList, SectionsVACD.ALLERGIES_REACTIONS);
		return b.toString();
	}

	/**
	 * Liefert das MDHT-VACD-Objekt zurück
	 *
	 * @return the doc
	 */
	public VACD getDoc() {
		return (VACD) this.doc;
	}

	/**
	 * Liefert alle Impfempfehlungen im eVACDOC.
	 *
	 * @return Liste von Impfempfehlungen
	 */
	public List<ImmunizationRecommendation> getImmunizationRecommendations() {
		//Search for the right section 
		Section tps = getDoc().getImmunizationRecommendationSection();
		if (tps==null) {
			return null;
		}
		EList<SubstanceAdministration> substanceAdministrations = tps.getSubstanceAdministrations();

		List<ImmunizationRecommendation> immunizations = new ArrayList<ImmunizationRecommendation>();
		for (SubstanceAdministration substanceAdministration : substanceAdministrations) {
			ImmunizationRecommendation immunization = new ImmunizationRecommendation((org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation) substanceAdministration);
			immunizations.add(immunization);
		}
		return immunizations;
	}

	private String getImmunizationRecommendationText() {
		ImmunizationRecommendationTextBuilder b = new ImmunizationRecommendationTextBuilder(getImmunizationRecommendations());
		return b.toString();
	}

	/**
	 * Liefert alle Impfungen im eVACDOC.
	 *
	 * @return Liste von Impfungen
	 */
	public List<Immunization> getImmunizations() {
		EList<SubstanceAdministration> substanceAdministrations =
				getImmunizationSection().getSubstanceAdministrations();

		List<Immunization> immunizations = new ArrayList<Immunization>();
		for (SubstanceAdministration substanceAdministration : substanceAdministrations) {
			Immunization immunization =
					convert((org.openhealthtools.mdht.uml.cda.ihe.Immunization) substanceAdministration);
			immunizations.add(immunization);
		}
		return immunizations;
	}

	private ImmunizationsSection getImmunizationSection() {
		org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection section = findImmunizationSection();
		if (section == null) {
			section = createImmunizationSection();
			doc.addSection(section);
		}
		return section;
	}

	private String getImmunizationText() {
		ImmunizationTextBuilder b = new ImmunizationTextBuilder(getImmunizations());
		return b.toString();
	}

	private Section getLaboratorySpecialitySection() {
		org.openhealthtools.mdht.uml.cda.Section section = findLaboratorySpecialitySection();
		if (section == null) {
			section = createLaboratorySpecialitySection();
			doc.addSection(section);
		}
		return section;
	}

	private ArrayList<PastProblemConcernEntry> getPastProblemConcernEntries() {
		//Search for the right section 
		Section hopis = getDoc().getHistoryOfPastIllnessSection();
		if (hopis==null) {
			return null;
		}
		EList<Act> acts = hopis.getActs();

		ArrayList<PastProblemConcernEntry> problemConcernEntries = new ArrayList<PastProblemConcernEntry>();
		for (Act act : acts) {
			PastProblemConcernEntry problemConcernEntry = new PastProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}

	private String getPastProblemConcernText() {
		ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();
		//Convert from the specific PastProblemConcern Type to the more genearal PastProblemConcern
		for (PastProblemConcernEntry prob : getPastProblemConcernEntries()) {
			problemConcernEntryList.add(prob);
		}

		ProblemConcernEntryTextBuilder b = new ProblemConcernEntryTextBuilder(problemConcernEntryList, SectionsVACD.HISTORY_OF_PAST_ILLNESS);
		return b.toString();
	}

	/**
	 * Liefert alle Leiden im eVACDOC.
	 *
	 * @return Liste von Leiden
	 */
	public ArrayList<ActiveProblemConcernEntry> getProblemConcernEntries() {
		// Get the ActiveProblemSection from the Document
		query = new Query(this.doc);
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection =
				query.getSections(org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection.class).get(0);
		if (activeProblemsSection.getActs() == null) {
			return null;
		} else {
			// Create a List with Problem ConcernEntries
			ArrayList<ActiveProblemConcernEntry> problemConcernEntryList = new ArrayList<ActiveProblemConcernEntry>();

			System.out.println("Assembling ProblemConcernEntryList");
			// Check if an Act is a problemConcernEntry. If so, create an
			// eHealthConnector ProblemConcernObject and add it to the list.
			for (Act act : activeProblemsSection.getActs()) {
				if (act instanceof org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) {
					ActiveProblemConcernEntry problemConcernEntry =
							new ActiveProblemConcernEntry(
									(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
					problemConcernEntryList.add(problemConcernEntry);
					System.out.println("List Item Code: " + problemConcernEntry.getConcern());
				}
			}

			return problemConcernEntryList;
		}
	}

	public boolean hasPastIllness(Disease disease) {
		HistoryOfPastIllnessSection section = getDoc().getHistoryOfPastIllnessSection();
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

	/**
	 * Setzt das MDHT-VACD-Objekt
	 *
	 * @param doc the new doc
	 */
	public void setDoc(VACD doc) {
		this.doc = (VACD) doc;
	}

	private boolean updateAllergyConcernReferences(
			EList<Act> acts, SectionsVACD loincSectionCode) {
		int i = 0;
		for (Act act : acts) {
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act;
			for (ProblemEntry problemEntry : problemConcernEntry.getAllergyIntolerances()) {
				//Check if the problem is not unknown (leads to no reference, because there is no problem)
				Code code = new Code (problemEntry.getCode());
				if (code.getOid().equals("2.16.840.1.113883.6.96") && code.getCode().equals(ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				}
				else {
					//Create references to level 1 text
					i++;
					ED reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
			}
		}
		return true;
	}

	private boolean updateProblemConcernReferences(
			EList<Act> acts, SectionsVACD loincSectionCode) {
		int i = 0;
		for (Act act : acts) {
			org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act;
			for (ProblemEntry problemEntry : problemConcernEntry.getProblemEntries()) {
				//Check if the problem is not unknown (leads to no reference, because there is no problem)
				Code code = new Code (problemEntry.getCode());
				if (code.getOid().equals("2.16.840.1.113883.6.96") && code.getCode().equals(ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
					return false;
				}
				else {
					//Create references to level 1 text
					i++;
					ED reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
					problemEntry.setText(EcoreUtil.copy(reference));
					problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
				}
			}
		}
		return true;
	}

	private void updateSubstanceAdministrationReferences(List<SubstanceAdministration> substanceAdministrations, SectionsVACD loincSectionCode) {
		int i = 0;
		for (SubstanceAdministration ir : substanceAdministrations) {
			i++;
			ED reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
			ir.setText(reference);
			ir.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode().setOriginalText(EcoreUtil.copy(reference));
		}
	}

}
