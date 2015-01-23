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
import org.ehc.cda.AllergyIntolerance;
import org.ehc.cda.Disease;
import org.ehc.cda.Immunization;
import org.ehc.cda.ImmunizationRecommendation;
import org.ehc.cda.ImmunizationRecommendationTextBuilder;
import org.ehc.cda.ImmunizationTextBuilder;
import org.ehc.cda.LoincSectionCode;
import org.ehc.cda.Medication;
import org.ehc.cda.PastIllnessBuilder;
import org.ehc.cda.PastProblemConcernEntry;
import org.ehc.cda.ProblemConcernEntry;
import org.ehc.cda.ProblemConcernEntryTextBuilder;
import org.ehc.cda.ProblemConcernTextBuilder;
import org.ehc.cda.Serologie;
import org.ehc.cda.Value;
import org.ehc.cda.converter.MedicationConverter;
import org.ehc.common.CSUtil;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.ehc.common.ConvenienceUtilsEnums.Language;
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
import org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationsSection;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection;
import org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection;
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

import ch.ehc.cda.enums.ProblemsSpecialConditions;

/**
 * <div class="de" Ein CDA Dokument, welches der Spezifikation CDA-CH-VACD entspricht.</div> <div
 * class="fr">Class CdaChVacd.</div> <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends CdaCh {
  Query query;

  /**
   * Erstellt ein neues eVACDOC CDA Dokument.
   *
   * @param language Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
   * @param stylesheet Stylesheet, welches im CDA mittels <?xml-stylesheet> für die menschlich
   *        Lesbare Darstellung referenziert werden soll.
   */
  public CdaChVacd(Language language, String stylesheet) {
    super();
    doc = CHFactory.eINSTANCE.createVACD().init();
    setChMetadata(language, stylesheet, "eVACDOC");

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
    super();
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

    activeProblemsSection = getActiveProblemsSection();

    // Update existing Entries with the reference to the CDA level 1 text and create the level 1
    // text.
    activeProblemsSectionText =
        Util.extractStringFromNonQuotedStrucDocText(activeProblemsSection.getText());
    ArrayList<ActiveProblemConcernEntry> problemConcernEntries = this.getProblemConcernEntries();
    tb =
        new ProblemConcernTextBuilder(problemConcernEntries, problemConcern,
            activeProblemsSectionText);
    problemConcern = tb.getProblemConcernEntry();

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
    // TODO Enum einfügen
    // problemConcern.getMdhtProblemEntryList().get(0).setStatusCode(ConvenienceUtilsEnums.StatusCode.completed);
    // //Status code of the problem has to be "completed"
    problemConcern.getMdhtProblemConcernEntry().getIds().add(Util.ii("1.3.6.1.4.1.19376.1.5.3.1.4.5")); 

    // Add the code for "Komplikations- oder Expositionsrisiken"
    CD komplikationsExpositionsrisikoCode = DatatypesFactory.eINSTANCE.createCD();
    komplikationsExpositionsrisikoCode.setCodeSystem("2.16.840.1.113883.6.96");
    komplikationsExpositionsrisikoCode.setCode("55607006");
    komplikationsExpositionsrisikoCode.setCodeSystemName("SNOMED CT");
    komplikationsExpositionsrisikoCode.setDisplayName("Problem");
    problemConcern.getMdhtProblemEntryList().get(0).setCode(komplikationsExpositionsrisikoCode);

    // create a copy of the given object and its sub-objects
    org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntryMdht =
        EcoreUtil.copy(problemConcern.getMdhtProblemConcernEntry());
    activeProblemsSection.addAct(problemConcernEntryMdht);
  }

  /**
   * C add allergy.
   *
   * @param allergie <br>
   *        <div class="de"> allergie</div> <div class="fr"> allergie</div> <div class="it">
   *        allergie</div>
   */
  public void addAllergy(AllergyIntolerance allergy) {
    AllergyIntoleranceConcern concern =
        IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init();

    org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance iheAllergy =
        allergy.getAllergyIntolerance();
    concern.addObservation(iheAllergy);
    concern.getEntryRelationships().get(0).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);

    getAllergiesReactionsSection().addAct(concern);
  }

  public void addHistoryOfPastIllnessEntry(org.ehc.cda.ProblemConcernEntry problemConcernEntry) {
    org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblem =
        problemConcernEntry.getMdhtProblemConcernEntry();

    getHistoryOfPastIllnessSection().addAct(iheProblem);
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
    updateSubstanceAdministrationReferences(immunizationSection.getSubstanceAdministrations(), LoincSectionCode.HISTORY_OF_IMMUNIZATION);

    immunizationSection.createStrucDocText(getImmunizationText());
  }

  public void addImmunizationRecommendation(ImmunizationRecommendation immunizationRecommendation) {
    org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationsSection immunizationRecommendationsSection;

    //find or create (and add) the Section
    immunizationRecommendationsSection = (org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationsSection) findImmunizationRecommendationSection();
    if (immunizationRecommendationsSection==null) {
      immunizationRecommendationsSection = createTreatmentPlanSection().init();
      this.doc.addSection(immunizationRecommendationsSection);
    }

    //add the MDHT Object to the section
    immunizationRecommendationsSection.addSubstanceAdministration(immunizationRecommendation.getMdhtImmunizationRecommendation());

    //update the MDHT Object content references to CDA level 1 text
    updateSubstanceAdministrationReferences(immunizationRecommendationsSection.getSubstanceAdministrations(), LoincSectionCode.TREATMENT_PLAN);

    //create the CDA level 1 text
    immunizationRecommendationsSection.createStrucDocText(getImmunizationRecommendationText());
  }

  public void addPastProblemConcern(PastProblemConcernEntry pastProblemConcern) {
    org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection hopis;

    //find or create (and add) the Section
    hopis = (org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection) findHistoryOfPastIllnessSection();
    if (hopis==null) {
      hopis = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
      this.doc.addSection(hopis);
    }

    //add the MDHT Object to the section
    hopis.addAct(pastProblemConcern.getMdhtProblemConcernEntry());

    //update the MDHT Object content references to CDA level 1 text
    if (updateProblemConcernReferences(hopis.getActs(), LoincSectionCode.HISTORY_OF_PAST_ILLNESS)) {
      //create the CDA level 1 text
      hopis.createStrucDocText(getPastProblemConcernText());
    }
    else {
      hopis.createStrucDocText("Keine Angaben");
      pastProblemConcern.getMdhtProblemConcernEntry().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
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

    act.setStatusCode(CSUtil.completed());
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

  /**
   * Creates the allergies reactions section (displayName="Allergies and Adverse Reactions").
   * 
   * @return AllergiesReactionsSection
   */
  private AllergiesReactionsSection createAllergiesReactionsSection() {
    org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection section =
        IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
    return section;
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

  private HistoryOfPastIllnessSection createHistoryOfPastIllnessSection() {
    HistoryOfPastIllnessSection section =
        IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
    section.setTitle(Util.st("Bisherige Krankheiten"));
    return section;
  }

  /**
   * Creates the immunization section (displayName="History of immunizations").
   * 
   * @return ImmunizationsSection
   */
  private org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection createImmunizationSection() {
    org.openhealthtools.mdht.uml.cda.ihe.ImmunizationsSection section =
        IHEFactory.eINSTANCE.createImmunizationsSection().init();
    section.setTitle(Util.st("Impfungen"));
    return section;
  }

  private CE createLaboratorySpecialityCode() {
    CE ce = DatatypesFactory.eINSTANCE.createCE();
    ce.setCode(LoincSectionCode.SEROLOGY_STUDIES.getLoincCode());
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
    observation.setStatusCode(CSUtil.completed());
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

  private ImmunizationRecommendationsSection createTreatmentPlanSection() {
    ImmunizationRecommendationsSection section = CHFactory.eINSTANCE.createImmunizationRecommendationsSection().init();
    section.setTitle(Util.st("Impfplan"));
    return section;
  }

  private ActiveProblemsSection findActiveProblemsSection() {
    for (Section section : doc.getSections()) {
      if (LoincSectionCode.isActiveProblems(section.getCode().getCode())) {
        return (ActiveProblemsSection) section;
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

  private HistoryOfPastIllnessSection findHistoryOfPastIllnessSection() {
    for (Section section : getSections()) {
      if (LoincSectionCode.isHistoryOfPastIllness(section.getCode().getCode())) {
        return (HistoryOfPastIllnessSection) section;
      }
    }
    return null;
  }

  private Section findImmunizationRecommendationSection() {
    for (Section section : doc.getSections()) {
      if (LoincSectionCode.isTreatmentPlan(section.getCode().getCode())) {
        return (Section) section;
      }
    }
    return null;
  }

  private ImmunizationsSection findImmunizationSection() {
    for (Section section : doc.getSections()) {
      if (LoincSectionCode.isHistoryOfImmunization(section.getCode().getCode())) {
        return (ImmunizationsSection) section;
      }
    }
    return null;
  }

  private Section findLaboratorySpecialitySection() {
    for (Section section : doc.getSections()) {
      if (LoincSectionCode.isLaboratorySpeciality(section.getCode().getCode())) {
        return (Section) section;
      }
    }
    return null;
  }

  private ActiveProblemsSection getActiveProblemsSection() {
    // Check if this section has already be created, if not create it

    org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection section =
        findActiveProblemsSection();
    if (section == null) {
      section = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
      doc.addSection(section);

      StrucDocText sectionTextStrucDoc = CDAFactory.eINSTANCE.createStrucDocText();
      sectionTextStrucDoc.addText("");;
    }
    return section;
  }

  private AllergiesReactionsSection getAllergiesReactionsSection() {
    org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection section =
        findAllergiesReactionsSection();
    if (section == null) {
      section = createAllergiesReactionsSection();
      doc.addSection(section);
    }
    return section;
  }

  /**
   * Liefert das MDHT-VACD-Objekt zurück
   *
   * @return the doc
   */
  public VACD getDoc() {
    return (VACD) this.doc;
  }

  private HistoryOfPastIllnessSection getHistoryOfPastIllnessSection() {
    org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection section =
        findHistoryOfPastIllnessSection();
    if (section == null) {
      section = createHistoryOfPastIllnessSection();
      doc.addSection(section);
    }
    return section;
  }

  /**
   * Liefert alle Impfempfehlungen im eVACDOC.
   *
   * @return Liste von Impfempfehlungen
   */
  public List<ImmunizationRecommendation> getImmunizationRecommendations() {
    //Search for the right section 
    Section tps = findImmunizationRecommendationSection();
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
    Section hopis = findHistoryOfPastIllnessSection();
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
    ProblemConcernEntryTextBuilder b = new ProblemConcernEntryTextBuilder(getPastProblemConcernEntries());
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
          System.out.println("List Item Code: " + problemConcernEntry.getProblemConcern());
        }
      }

      return problemConcernEntryList;
    }
  }

  private EList<Section> getSections() {
    return doc.getSections();
  }

  public boolean hasPastIllness(Disease disease) {
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

  /**
   * Setzt das MDHT-VACD-Objekt
   *
   * @param doc the new doc
   */
  public void setDoc(VACD doc) {
    this.doc = doc;
  }

  private boolean updateProblemConcernReferences(
      EList<Act> acts, LoincSectionCode loincSectionCode) {
    int i = 0;
    for (Act act : acts) {
      org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act;
      if (problemConcernEntry.getProblemEntries().size()>0) {
        org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry problemEntry = problemConcernEntry.getProblemEntries().get(0);
        //Check if the problem is not unknown (leads to no reference, because there is no problem)
        CD code = problemConcernEntry.getProblemEntries().get(0).getCode();
        //TODO Change to enum codesystem
        if (code.getCodeSystem().equals("2.16.840.1.113883.6.96") && code.getCode().equals(ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
          return false;
        }
        else {
          //Create references to level 1 text
          i++;
          ED reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
          problemEntry.setText(reference);
          problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
          return true;
        }
      }
    }
    return false;
  }

  private void updateSubstanceAdministrationReferences(List<SubstanceAdministration> substanceAdministrations, LoincSectionCode loincSectionCode) {
    int i = 0;
    for (SubstanceAdministration ir : substanceAdministrations) {
      i++;
      ED reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
      ir.setText(reference);
      ir.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode().setOriginalText(EcoreUtil.copy(reference));
    }
  }

}
