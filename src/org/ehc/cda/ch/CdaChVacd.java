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

package org.ehc.cda.ch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ActiveProblemConcernEntry;
import org.ehc.cda.AllergyConcern;
import org.ehc.cda.GestationalAge;
import org.ehc.cda.Immunization;
import org.ehc.cda.ImmunizationRecommendation;
import org.ehc.cda.PastProblemConcern;
import org.ehc.cda.Pregnancy;
import org.ehc.cda.ProblemConcernEntry;
import org.ehc.cda.ch.enums.LanguageCode;
import org.ehc.cda.ch.enums.ProblemsSpecialConditions;
import org.ehc.cda.ch.textbuilder.AllergyConcernTextBuilder;
import org.ehc.cda.ch.textbuilder.ImmunizationRecommendationTextBuilder;
import org.ehc.cda.ch.textbuilder.ImmunizationTextBuilder;
import org.ehc.cda.ch.textbuilder.LaboratoryObservationTextBuilder;
import org.ehc.cda.ch.textbuilder.ProblemConcernEntryTextBuilder;
import org.ehc.cda.ch.textbuilder.SimpleTextBuilder;
import org.ehc.common.Code;
import org.ehc.common.Util;
import org.ehc.common.ch.SectionsVACD;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.LaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ch.LaboratoryReportDataProcessingEntry;
import org.openhealthtools.mdht.uml.cda.ch.SpecimenAct;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil.Query;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de" Ein CDA Dokument, welches der Spezifikation CDA-CH-VACD entspricht.</div> <div
 * class="fr">Class CdaChVacd.</div> <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends CdaCh {
	public static final String OID_VACD = "2.16.756.5.30.1.1.1.1.3.1.1";
	public static final String eVACDOCTitle = "eVACDOC";
	Query query;

	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 */
	public CdaChVacd() {
		super(CHFactory.eINSTANCE.createVACD().init());
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
		query = new Query(doc);
	}
	
	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 * @param language Dokument-Sprache
	 * @param immunization Impfung
	 */
	public CdaChVacd(LanguageCode language, Immunization immunization) {
		this();	
		setLanguageCode(language);
		setTitle(eVACDOCTitle);
		setProcessingInstructions(null);
		addImmunization(immunization);
	}
	
	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 * @param german Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet Stylesheet, welches im CDA mittels <?xml-stylesheet> für die menschlich
	 *        Lesbare Darstellung referenziert werden soll.
	 */
	public CdaChVacd(LanguageCode language, Immunization immunization, String stylesheet) {
		this();
		setLanguageCode(language);
		setTitle(eVACDOCTitle);
		setProcessingInstructions(stylesheet);
		addImmunization(immunization);
	}

	/**
	 * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-VACD
	 * Objekts. Beide repräsentieren ein Impfdokument.</div> <div class="fr"></div>
	 *
	 * @param doc <div class="de">CdaChVacd</div> <div class="fr"></div>
	 */
	public CdaChVacd(VACD doc) {
		super(doc);
		setDoc(doc);
		query = new Query(this.doc);
	}
	
	public void addActiveProblemConcern(ActiveProblemConcernEntry activeProblemConcern) {
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection aps;

		//find or create (and add) the Section
		aps = getDoc().getActiveProblemsSection();
		if (aps==null) {
			aps = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
			aps.setTitle(Util.st(SectionsVACD.ACTIVE_PROBLEMS.getSectionTitleDe()));
			doc.addSection(aps);
		}

		//add the MDHT Object to the section
		aps.addAct(activeProblemConcern.copyMdhtProblemConcernEntry());

		//update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(aps.getActs(), SectionsVACD.ACTIVE_PROBLEMS)) {
			//create the CDA level 1 text
			aps.createStrucDocText(getActiveProblemConcernsText());
		}
		else {
			aps.createStrucDocText("Keine Angaben");
			activeProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
		}
	}

//	/**
//	 * Fügt ein Leiden hinzu.
//	 *
//	 * @param problemConcern Das Leiden
//	 */
//	public void addActiveProblemConcern(org.ehc.cda.ActiveProblemConcernEntry problemConcern) {
//
//		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection;
//		ActiveProblemConcernTextBuilder tb;
//		StrucDocText sectionTextStrucDoc;
//		String activeProblemsSectionText;
//
//		activeProblemsSection = getDoc().getActiveProblemsSection();
//		if (activeProblemsSection == null) {
//			activeProblemsSection = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
//			activeProblemsSection.setTitle(Util.st(SectionsVACD.ACTIVE_PROBLEMS.getSectionTitleDe()));
//			doc.addSection(activeProblemsSection);
//		}
//
//		// Update existing Entries with the reference to the CDA level 1 text and create the level 1
//		// text.
//		activeProblemsSectionText =
//				Util.extractStringFromNonQuotedStrucDocText(activeProblemsSection.getText());
//		ArrayList<ActiveProblemConcernEntry> problemConcernEntries = getActiveProblemConcerns();
//		tb =
//				new ActiveProblemConcernTextBuilder(problemConcernEntries, problemConcern,
//						activeProblemsSectionText);
//		//problemConcern = tb.getProblemConcernEntry();
//
//		// Update the section text.
//		// This is a workaround for the following problem:
//		// - The sectionText can only be created once with the createSectionText Method
//		// - The StrucDocText Object can´t create text with xml-elements inside. These will be quoted.
//		// The Workaround crates a special text object, which can´t be read by the getText Method. So
//		// the current state of the section text is stored in the activeProblemSectionText field.
//		activeProblemsSectionText = tb.getSectionText();
//		sectionTextStrucDoc = Util.createNonQotedStrucDocText(activeProblemsSectionText);
//		activeProblemsSection.setText(sectionTextStrucDoc);
//
//		// insert the values which are special for VACD Document
//		problemConcern.copyMdhtProblemConcernEntry().getIds().add(Util.ii("1.3.6.1.4.1.19376.1.5.3.1.4.5")); 
//
//		// Add the code for "Komplikations- oder Expositionsrisiken"
//		CD komplikationsExpositionsrisikoCode = DatatypesFactory.eINSTANCE.createCD();
//		komplikationsExpositionsrisikoCode.setCodeSystem("2.16.840.1.113883.6.96");
//		komplikationsExpositionsrisikoCode.setCode("55607006");
//		komplikationsExpositionsrisikoCode.setCodeSystemName("SNOMED CT");
//		komplikationsExpositionsrisikoCode.setDisplayName("Problem");
//		problemConcern.getMdhtProblemConcernEntry().getProblemEntries().get(0).setCode(komplikationsExpositionsrisikoCode);
//
//		// create a copy of the given object and its sub-objects
//		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntryMdht =
//				EcoreUtil.copy(problemConcern.copyMdhtProblemConcernEntry());
//		activeProblemsSection.addAct(problemConcernEntryMdht);
//		updateProblemConcernReferences(activeProblemsSection.getActs(), SectionsVACD.ACTIVE_PROBLEMS);
//	}

	public void addAllergyProblemConcern(AllergyConcern huenereinweissAllergieLeiden) {
		org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection ars;

		//find or create (and add) the Section
		ars = getDoc().getAllergiesReactionsSection();
		if (ars==null) {
			ars = IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
			ars.setTitle(Util.st(SectionsVACD.ALLERGIES_REACTIONS.getSectionTitleDe()));
			doc.addSection(ars);
		}

		//add the MDHT Object to the section
		ars.addAct(huenereinweissAllergieLeiden.copyMdhtAllergyConcern());

		//update the MDHT Object content references to CDA level 1 text
		if (updateAllergyConcernReferences(ars.getActs(), SectionsVACD.ALLERGIES_REACTIONS)) {
			//create the CDA level 1 text
			ars.createStrucDocText(getAllergyProblemConcernsText());
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
		if (rs==null) {
			rs = CHFactory.eINSTANCE.createRemarksSection().init();
			rs.setTitle(Util.st(SectionsVACD.REMARKS.getSectionTitleDe()));
			doc.addSection(rs);
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
	
	public void addImmunization(org.ehc.cda.Immunization immunization) {
		org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection immunizationSection;

		//find or create (and add) the Section
		immunizationSection = getDoc().getImmunizationsSection();
		if (immunizationSection==null) {
			immunizationSection = CHFactory.eINSTANCE.createImmunizationsSection().init();
			immunizationSection.setTitle(Util.st(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleDe()));
			doc.addSection(immunizationSection);
		}

		//add the MDHT Object to the section
		immunizationSection.addSubstanceAdministration(immunization.copyMdhtImmunization());

		//update the MDHT Object content references to CDA level 1 text
		updateSubstanceAdministrationReferences(immunizationSection.getSubstanceAdministrations(), SectionsVACD.HISTORY_OF_IMMUNIZATION);

		//create the CDA level 1 text
		immunizationSection.createStrucDocText(getImmunizationText());
	}
	
	public void addImmunizationRecommendation(ImmunizationRecommendation immunizationRecommendation) {
		org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection immunizationRecommendationsSection;

		//find or create (and add) the Section
		immunizationRecommendationsSection = getDoc().getImmunizationRecommendationSection();
		if (immunizationRecommendationsSection==null) {
			immunizationRecommendationsSection = CHFactory.eINSTANCE.createImmunizationRecommendationSection().init();
			immunizationRecommendationsSection.setTitle(Util.st(SectionsVACD.TREATMENT_PLAN.getSectionTitleDe()));
			doc.addSection(immunizationRecommendationsSection);
		}

		//add the MDHT Object to the section
		immunizationRecommendationsSection.addSubstanceAdministration(immunizationRecommendation.copyMdhtImmunizationRecommendation());

		//update the MDHT Object content references to CDA level 1 text
		updateSubstanceAdministrationReferences(immunizationRecommendationsSection.getSubstanceAdministrations(), SectionsVACD.TREATMENT_PLAN);

		//create the CDA level 1 text
		immunizationRecommendationsSection.createStrucDocText(getImmunizationRecommendationsText());
	}

	//TODO Evtl. Erzeugung eines weiteren Konstruktors, um LaboratoryBatteryOrganizer einzufügen
	public void addLaboratoryObservation(org.ehc.cda.LaboratoryObservation lo) {
		org.openhealthtools.mdht.uml.cda.ch.LaboratorySpecialitySection lss;
		LaboratoryReportDataProcessingEntry lrdpe;
		SpecimenAct spa;
		LaboratoryObservationTextBuilder tb;

		//find or create (and add) the Section
		lss = getDoc().getLaboratorySpecialitySection();
		if (lss==null) {
			lss = CHFactory.eINSTANCE.createLaboratorySpecialitySection().init();
			lrdpe = CHFactory.eINSTANCE.createLaboratoryReportDataProcessingEntry().init();
			spa = CHFactory.eINSTANCE.createSpecimenAct().init();

			lss.getEntries().add(lrdpe);
			lrdpe.setAct(spa);    

			lss.setTitle(Util.st(SectionsVACD.SEROLOGY_STUDIES.getSectionTitleDe()));
			doc.addSection(lss);
		}
		//If the section is already present, get instances of the templates
		else {
			lrdpe = lss.getLaboratoryReportDataProcessingEntry();
			spa = (SpecimenAct) lrdpe.getAct();
		}

		//Create a new Laboratory Battery Organizer for each Observation that is added through this constructor and add it to the specimen act. 
		LaboratoryBatteryOrganizer lbo = CHFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init();        
		spa.addOrganizer(lbo);

		//add the MDHT Object to the section
		lbo.addObservation(lo.copyMdhtLaboratoryObservation());

		//Set the Type codes
		lbo.getComponents().get(lbo.getComponents().size()-1).setTypeCode(ActRelationshipHasComponent.COMP);
		spa.getEntryRelationships().get(spa.getEntryRelationships().size()-1).setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		//TODO update the MDHT Object content references to CDA level 1 text (if necessary)
		tb = new LaboratoryObservationTextBuilder(getLaboratoryObservations(), SectionsVACD.SEROLOGY_STUDIES);
		lss.createStrucDocText(tb.toString());
	}

	public void addPastProblemConcern(PastProblemConcern pastProblemConcern) {
		org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection hopis;

		//find or create (and add) the Section
		hopis = getDoc().getHistoryOfPastIllnessSection();
		if (hopis==null) {
			hopis = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
			hopis.setTitle(Util.st(SectionsVACD.HISTORY_OF_PAST_ILLNESS.getSectionTitleDe()));
			doc.addSection(hopis);
		}

		//add the MDHT Object to the section
		hopis.addAct(pastProblemConcern.copyMdhtProblemConcernEntry());

		//update the MDHT Object content references to CDA level 1 text
		if (updateProblemConcernReferences(hopis.getActs(), SectionsVACD.HISTORY_OF_PAST_ILLNESS)) {
			//create the CDA level 1 text
			hopis.createStrucDocText(getPastProblemConcernEntriesText());
		}
		else {
			hopis.createStrucDocText("Keine Angaben");
			pastProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
		}
	}

	public void addPregnancy(Pregnancy pregnancy) {
		org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection phs;
		SimpleTextBuilder sb;

		//TODO Change to max one section in the model
		phs = getDoc().getPregnancyHistorySection();

		if (phs==null) {
			phs = IHEFactory.eINSTANCE.createPregnancyHistorySection().init();
			phs.setTitle(Util.st(SectionsVACD.HISTORY_OF_PREGNANCIES.getSectionTitleDe()));
			doc.addSection(phs);
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

	/**
	 * Converts from IHE to convenience API class.
	 * 
	 * @param immunization
	 * @return Immunization - convenience API class
	 */
	private Immunization convert(org.openhealthtools.mdht.uml.cda.ihe.Immunization iheImmunization) {
		return new Immunization(iheImmunization);
	}

	private Section findRemarksSection() {
		for (Section section : doc.getSections()) {
			if (section.getCode()!=null) {
			if (SectionsVACD.isRemarks(section.getCode().getCode())) {
				return section;
			}
			}
		}
		return null;
	}

	public ArrayList<ActiveProblemConcernEntry> getActiveProblemConcerns() {
		//Search for the right section 
		Section aps = getDoc().getActiveProblemsSection();
		if (aps==null) {
			return null;
		}
		EList<Act> acts = aps.getActs();

		ArrayList<ActiveProblemConcernEntry> problemConcernEntries = new ArrayList<ActiveProblemConcernEntry>();
		for (Act act : acts) {
			ActiveProblemConcernEntry problemConcernEntry = new ActiveProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}
	
//	public String getActiveProblemConcernText() {
//		ActiveProblemConcernTextBuilder b = new ActiveProblemConcernTextBuilder((), SectionsVACD.ALLERGIES_REACTIONS);
//		return b.toString();
//	}

	public String getActiveProblemConcernsText() {
		ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();
		//Convert from the specific PastProblemConcern Type to the more genearal PastProblemConcern
		for (ActiveProblemConcernEntry prob : getActiveProblemConcerns()) {
			problemConcernEntryList.add(prob);
		}

		ProblemConcernEntryTextBuilder b = new ProblemConcernEntryTextBuilder(problemConcernEntryList, SectionsVACD.ACTIVE_PROBLEMS);
		return b.toString();
	}

	public ArrayList<AllergyConcern> getAllergyProblemConcerns() {
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

	public String getAllergyProblemConcernsText() {
		AllergyConcernTextBuilder b = new AllergyConcernTextBuilder(getAllergyProblemConcerns(), SectionsVACD.ALLERGIES_REACTIONS);
		return b.toString();
	}
	

	
	public String getComment() {
		Section rs;
		org.ehc.cda.Comment comment;
		
		//find the Section
		rs = findRemarksSection();
		if (rs==null) {
			return null;
		}
		comment = new org.ehc.cda.Comment(rs.getText().getText());
		
		return comment.getText();
	}

	/**
	 * Liefert das MDHT-VACD-Objekt zurück
	 *
	 * @return the doc
	 */
	public VACD getDoc() {
		return (VACD) doc;
	}

	public GestationalAge getGestationalAge() {
		return new GestationalAge(this.getDoc().getCodedResultsSection());
	}

	public String getGestationalAgeText() {
		return getGestationalAge().getGestationalAgeText();
	}
	
	/**
	 * Liefert alle Impfempfehlungen im eVACDOC.
	 *
	 * @return Liste von Impfempfehlungen
	 */
	public ArrayList<ImmunizationRecommendation> getImmunizationRecommendations() {
		//Search for the right section 
		Section tps = getDoc().getImmunizationRecommendationSection();
		if (tps==null) {
			return null;
		}
		EList<SubstanceAdministration> substanceAdministrations = tps.getSubstanceAdministrations();

		ArrayList<ImmunizationRecommendation> immunizations = new ArrayList<ImmunizationRecommendation>();
		for (SubstanceAdministration substanceAdministration : substanceAdministrations) {
			ImmunizationRecommendation immunization = new ImmunizationRecommendation((org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation) substanceAdministration);
			immunizations.add(immunization);
		}
		return immunizations;
	}
	
	private String getImmunizationRecommendationsText() {
		ImmunizationRecommendationTextBuilder b = new ImmunizationRecommendationTextBuilder(getImmunizationRecommendations());
		return b.toString();
	}

	/**
	 * Liefert alle Impfungen im eVACDOC.
	 *
	 * @return Liste von Impfungen
	 */
	public ArrayList<Immunization> getImmunizations() {
		EList<SubstanceAdministration> substanceAdministrations =
				getDoc().getImmunizationsSection().getSubstanceAdministrations();

		ArrayList<Immunization> immunizations = new ArrayList<Immunization>();
		for (SubstanceAdministration substanceAdministration : substanceAdministrations) {
			Immunization immunization =
					convert((org.openhealthtools.mdht.uml.cda.ihe.Immunization) substanceAdministration);
			immunizations.add(immunization);
		}
		return immunizations;
	}

	public String getImmunizationText() {
		ImmunizationTextBuilder b = new ImmunizationTextBuilder(getImmunizations());
		return b.toString();
	}

	/**
	 * Liefert alle Laborresultate im eVACDOC.
	 *
	 * @return Liste von Laborresultaten
	 */
	public ArrayList<org.ehc.cda.LaboratoryObservation> getLaboratoryObservations() {
		//Search for the right section 
		Section los = getDoc().getLaboratorySpecialitySection();
		if (los==null) {
			return null;
		}
		EList<Entry> entries = los.getEntries();

		ArrayList<org.ehc.cda.LaboratoryObservation> labObservations = new ArrayList<org.ehc.cda.LaboratoryObservation>();
		for (Entry entry : entries) {
			org.openhealthtools.mdht.uml.cda.ch.LaboratoryReportDataProcessingEntry mLabRdpe = (org.openhealthtools.mdht.uml.cda.ch.LaboratoryReportDataProcessingEntry) entry;
			org.openhealthtools.mdht.uml.cda.ch.SpecimenAct mSpecAct = (org.openhealthtools.mdht.uml.cda.ch.SpecimenAct) mLabRdpe.getAct();
			for (org.openhealthtools.mdht.uml.cda.ch.LaboratoryBatteryOrganizer mLabOrg : mSpecAct.getLaboratoryBatteryOrganizers()) {
				for(org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation mLo : mLabOrg.getLaboratoryObservations()) {
					org.ehc.cda.LaboratoryObservation lo = new org.ehc.cda.LaboratoryObservation (mLo);
					labObservations.add(lo);
				}
			}
		}
		return labObservations;
	}

	public String getLaboratoryObservationsText() {
		LaboratoryObservationTextBuilder b = new LaboratoryObservationTextBuilder(getLaboratoryObservations(), SectionsVACD.SEROLOGY_STUDIES);
		return b.toString();
	}
	
	public ArrayList<PastProblemConcern> getPastProblemConcernEntries() {
		//Search for the right section 
		Section hopis = getDoc().getHistoryOfPastIllnessSection();
		if (hopis==null) {
			return null;
		}
		EList<Act> acts = hopis.getActs();

		ArrayList<PastProblemConcern> problemConcernEntries = new ArrayList<PastProblemConcern>();
		for (Act act : acts) {
			PastProblemConcern problemConcernEntry = new PastProblemConcern((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
			problemConcernEntries.add(problemConcernEntry);
		}
		return problemConcernEntries;
	}
	
	public String getPastProblemConcernEntriesText() {
		ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();
		//Convert from the specific PastProblemConcern Type to the more genearal PastProblemConcern
		for (PastProblemConcern prob : getPastProblemConcernEntries()) {
			problemConcernEntryList.add(prob);
		}

		ProblemConcernEntryTextBuilder b = new ProblemConcernEntryTextBuilder(problemConcernEntryList, SectionsVACD.HISTORY_OF_PAST_ILLNESS);
		return b.toString();
	}
	
	/**
	 * Liefert alle Schwangerschaften im eVACDOC.
	 *
	 * @return Liste von Impfempfehlungen
	 */
	public ArrayList<Pregnancy> getPregnancies() {
		//Search for the right section 
		PregnancyHistorySection phs = getDoc().getPregnancyHistorySection();
		if (phs==null) {
			return null;
		}
		ArrayList<Pregnancy> pregnancies = new ArrayList<Pregnancy>();
		for (PregnancyObservation mPregnancy : phs.getPregnancyObservations()) {
			Pregnancy immunization = new Pregnancy(mPregnancy);
			pregnancies.add(immunization);
		}
		return pregnancies;
	}

	/**
	 * Setzt das MDHT-VACD-Objekt
	 *
	 * @param doc the new doc
	 */
	public void setDoc(VACD doc) {
		this.doc = doc;
	}

	public void setGestationalAge(GestationalAge gestationalAge) {
		SimpleTextBuilder sb;
	
		//update the MDHT Object content references to CDA level 1 text
		sb = new SimpleTextBuilder(SectionsVACD.CODED_RESULTS, gestationalAge.getGestationalAgeText());

		ED reference = Util.createReference(sb.getNewTextContentIDNr(), SectionsVACD.CODED_RESULTS.getContentIdPrefix());
		gestationalAge.getMdhtGestationalAgeWeeksObservation().setText(EcoreUtil.copy(reference));
		gestationalAge.getMdhtGestationalAgeDaysObservation().setText(EcoreUtil.copy(reference));

		//create the CDA level 1 text
		gestationalAge.getMdhtCodedResultsSection().createStrucDocText(sb.toString());
		
		gestationalAge.getMdhtCodedResultsSection().setTitle(Util.st(SectionsVACD.CODED_RESULTS.getSectionTitleDe()));
		
		doc.addSection(gestationalAge.copyMdhtCodedResultsSection());
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
			if (ir.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode()!=null) {
				ir.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode().setOriginalText(EcoreUtil.copy(reference));
			}
		}
	}

}
