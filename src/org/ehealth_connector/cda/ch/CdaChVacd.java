/********************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 ********************************************************************************/

package org.ehealth_connector.cda.ch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ActiveProblemConcern;
import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.CodedResults;
import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ImmunizationRecommendation;
import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.PastProblemConcern;
import org.ehealth_connector.cda.Pregnancy;
import org.ehealth_connector.cda.ProblemConcern;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.ch.enums.ProblemsSpecialConditions;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.cda.ch.textbuilder.AllergyConcernTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.ImmunizationRecommendationTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.ImmunizationTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.LaboratoryObservationTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.ProblemConcernEntryTextBuilder;
import org.ehealth_connector.cda.ch.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Patient;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection;
import org.openhealthtools.mdht.uml.cda.ch.LaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ch.LaboratoryReportDataProcessingEntry;
import org.openhealthtools.mdht.uml.cda.ch.SpecimenAct;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil.Query;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.ADXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de" Ein CDA Dokument, welches der Spezifikation CDA-CH-VACD entspricht.</div> <div
 * class="fr">Class CdaChVacd.</div> <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends CdaCh {

  /** The Constant OID_VACD. */
  public static final String OID_VACD = "2.16.756.5.30.1.1.1.1.3.1.1";

  /** The Constant eVACDOCTitle. */
  public static final String eVACDOCTitle = "eVACDOC";

  public static final boolean CDALevel2TextGeneration = false;

  /** The query. */
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
    setTitle(eVACDOCTitle);
    fixGeneralHeaderConstraintTemplateId();
    query = new Query(doc);
  }

  /**
   * Erstellt ein neues eVACDOC CDA Dokument.
   *
   * @param language Sprache des Dokments
   * @param immunization Impfung
   */
  public CdaChVacd(LanguageCode language, Immunization immunization) {
    this();
    setLanguageCode(language);
    addStylesheet(null);
    addImmunization(immunization);
  }

  /**
   * Erstellt ein neues eVACDOC CDA Dokument.
   *
   * @param language <br>
   *        <div class="de">Sprache des Dokments</div> <div class="fr"></div> <div class="it"></div>
   * @param immunization <br>
   *        <div class="de">Impfung</div> <div class="fr"></div> <div class="it"></div>
   * @param stylesheet Stylesheet, welches im CDA mittels <?xml-stylesheet> für die menschlich
   *        Lesbare Darstellung referenziert werden soll.
   */
  public CdaChVacd(LanguageCode language, Immunization immunization, String stylesheet) {
    this();
    setLanguageCode(language);
    addStylesheet(stylesheet);
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

  /**
   * <div class="en">Adds the active problem concern.</div> <div class="de">Fügt ein Aktives Leiden
   * hinzu</div> <div class="fr"></div> <div class="it"></div>
   *
   * @param activeProblemConcern <br>
   *        <div class="en"> active problem concern</div> <div class="de"> Das aktive Leiden</div>
   *        <div class="fr"></div> <div class="it"></div>
   */
  public void addActiveProblemConcern(ActiveProblemConcern activeProblemConcern) {
    org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection aps;

    // find or create (and add) the Section
    aps = getDoc().getActiveProblemsSection();
    if (aps == null) {
      aps = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
      aps.setTitle(Util.st(SectionsVACD.ACTIVE_PROBLEMS.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(aps);
    }

    // add the MDHT Object to the section
    aps.addAct(activeProblemConcern.copyMdhtProblemConcernEntry());

    
    // update the MDHT Object content references to CDA level 1 text
    if (updateProblemConcernReferences(aps.getActs(), SectionsVACD.ACTIVE_PROBLEMS)) {
      if (CDALevel2TextGeneration) {
      // create the CDA level 1 text
      aps.createStrucDocText(generateNarrativeTextActiveProblemConcerns());
    }
      else {
        setNarrativeTextActiveProblemConcerns("");
      }}
    else {
      aps.createStrucDocText("Keine Angaben");
      activeProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
    }
  }

  /**
   * <div class="de">Fügt ein Allergie-Leiden hinzu</div> <div class="fr"></div> <div
   * class="it"></div>
   *
   * @param allergyConcern <br>
   *        <div class="de">Allergie leiden</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addAllergyProblemConcern(AllergyConcern allergyConcern) {
    org.openhealthtools.mdht.uml.cda.ihe.AllergiesReactionsSection ars;

    // find or create (and add) the Section
    ars = getDoc().getAllergiesReactionsSection();
    if (ars == null) {
      ars = IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
      ars.setTitle(Util.st(SectionsVACD.ALLERGIES_REACTIONS.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(ars);
    }

    // add the MDHT Object to the section
    ars.addAct(allergyConcern.copyMdhtAllergyConcern());

    // create the CDA level 2 text (either generated or empty text with content reference)

    // update the MDHT Object content references to CDA level 1 text
    if (updateAllergyConcernReferences(ars.getActs(), SectionsVACD.ALLERGIES_REACTIONS)) {
      if (CDALevel2TextGeneration) {
        // create the CDA level 1 text
        ars.createStrucDocText(generateNarrativeTextAllergyProblemConcerns());
      } 
      else {
        setNarrativeTextAllergyProblemConcerns("");
      }
    }
      else {
        ars.createStrucDocText("Keine Angaben");
        allergyConcern.copyMdhtAllergyConcern().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
      }
  }

  /**
   * <div class="de">Fügt einen Kommentar hinzu</div> <div class="fr"></div> <div class="it"></div>
   *
   * @param comment <br>
   *        <div class="de">Kommentar</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addComment(String comment) {
    Section rs;
    SimpleTextBuilder sb;

    // find or create (and add) the Section
    rs = findRemarksSection();
    if (rs == null) {
      rs = CHFactory.eINSTANCE.createRemarksSection().init();
      rs.setTitle(Util.st(SectionsVACD.REMARKS.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(rs);
    }

    // create add the MDHT Object to the section
    Comment mComment = IHEFactory.eINSTANCE.createComment().init();
    rs.addAct(mComment);

    ED reference;
    if (CDALevel2TextGeneration) {
      // update the MDHT Object content references to CDA level 1 text
      if (rs.getText() != null) {

        String oldSectionText = Util.extractStringFromNonQuotedStrucDocText(rs.getText());
        sb = new SimpleTextBuilder(SectionsVACD.REMARKS, comment, oldSectionText);
      } else {
        sb = new SimpleTextBuilder(SectionsVACD.REMARKS, comment);
      }

      reference = Util.createReference(sb.getNewTextContentIDNr(), SectionsVACD.REMARKS.getContentIdPrefix());

      // create the CDA level 1 text
      rs.createStrucDocText(sb.toString());
    } 
    else {
      setNarrativeTextComments("");
      reference = Util.createReference(1, SectionsVACD.REMARKS.getContentIdPrefix());
    }
    mComment.setText(reference);

  }

  /**
   * <div class="de">Fügt eine Impfung hinzu.</div> <div class="fr"></div> <div class="it"></div>
   *
   * @param immunization <br>
   *        <div class="de">Impfung</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addImmunization(org.ehealth_connector.cda.Immunization immunization) {
    org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection immunizationSection;

    // find or create (and add) the Section
    immunizationSection = getDoc().getImmunizationsSection();
    if (immunizationSection == null) {
      immunizationSection = CHFactory.eINSTANCE.createImmunizationsSection().init();
      immunizationSection.setTitle(Util.st(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(immunizationSection);
    }

    // add the MDHT Object to the section
    immunizationSection.addSubstanceAdministration(immunization.copyMdhtImmunization());


    // update the MDHT Object content references to CDA level 2 text
    updateSubstanceAdministrationReferences(immunizationSection.getSubstanceAdministrations(), SectionsVACD.HISTORY_OF_IMMUNIZATION);

    // create the CDA level 2 text (either generated or empty text with content reference)
    if (CDALevel2TextGeneration) {
      immunizationSection.createStrucDocText(generateNarrativeTextImmunizations());
    } 
    else {
      setNarrativeTextImmunizations("");
    }
  }

  /**
   * <div class="de">Fügt eine Impfempfehlung hinzu</div> <div class="fr"></div> <div
   * class="it"></div>
   *
   * @param immunizationRecommendation <br>
   *        <div class="de">Impfempfehlung</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addImmunizationRecommendation(ImmunizationRecommendation immunizationRecommendation) {
    org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection immunizationRecommendationsSection;

    // find or create (and add) the Section
    immunizationRecommendationsSection = getDoc().getImmunizationRecommendationSection();
    if (immunizationRecommendationsSection == null) {
      immunizationRecommendationsSection = CHFactory.eINSTANCE.createImmunizationRecommendationSection().init();
      immunizationRecommendationsSection.setTitle(Util.st(SectionsVACD.TREATMENT_PLAN.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(immunizationRecommendationsSection);
    }

    // add the MDHT Object to the section
    immunizationRecommendationsSection.addSubstanceAdministration(immunizationRecommendation.copyMdhtImmunizationRecommendation());

    // update the MDHT Object content references to CDA level 1 text
    updateSubstanceAdministrationReferences(immunizationRecommendationsSection.getSubstanceAdministrations(), SectionsVACD.TREATMENT_PLAN);

    // create the CDA level 2 text (either generated or empty text with content reference)
    if (CDALevel2TextGeneration) {
      immunizationRecommendationsSection.createStrucDocText(generateNarrativeTextImmunizationRecommendations());
    } 
    else {
      setNarrativeTextImmunizationRecommendations("");
    }
  }

  /**
   * <div class="de">Fügt einen Laborbefund hinzu</div> <div class="fr"></div> <div
   * class="it"></div>
   *
   * @param laboratoryObservation <br>
   *        <div class="de">Der Laborbefund</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addLaboratoryObservation(org.ehealth_connector.cda.LaboratoryObservation laboratoryObservation) {
    org.openhealthtools.mdht.uml.cda.ch.LaboratorySpecialitySection lss;
    LaboratoryReportDataProcessingEntry lrdpe;
    SpecimenAct spa;
    LaboratoryObservationTextBuilder tb;

    // FIXME: Dieser Teil muss in dem Objekt selbst ausgeführt werden. Also
    // in LaboratoryObservation die Battery etc. erzeugen.
    // find or create (and add) the Section
    lss = getDoc().getLaboratorySpecialitySection();
    if (lss == null) {
      lss = CHFactory.eINSTANCE.createLaboratorySpecialitySection().init();
      lrdpe = CHFactory.eINSTANCE.createLaboratoryReportDataProcessingEntry().init();
      spa = CHFactory.eINSTANCE.createSpecimenAct().init();

      lss.getEntries().add(lrdpe);
      lrdpe.setAct(spa);

      lss.setTitle(Util.st(SectionsVACD.SEROLOGY_STUDIES.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(lss);
    }
    // If the section is already present, get instances of the templates
    else {
      lrdpe = (LaboratoryReportDataProcessingEntry) lss.getEntries().get(0);
      spa = (SpecimenAct) lrdpe.getAct();
    }

    // Create a new Laboratory Battery Organizer for each Observation that
    // is added through this constructor and add it to the specimen act.
    LaboratoryBatteryOrganizer lbo = CHFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init();
    spa.addOrganizer(lbo);

    // add the MDHT Object to the section
    lbo.addObservation(laboratoryObservation.copyMdhtLaboratoryObservation());

    // Set the Type codes
    lbo.getComponents().get(lbo.getComponents().size() - 1).setTypeCode(ActRelationshipHasComponent.COMP);
    spa.getEntryRelationships().get(spa.getEntryRelationships().size() - 1).setTypeCode(x_ActRelationshipEntryRelationship.COMP);

    // TODO update the MDHT Object content references to CDA level 1 text
    // (if necessary)
    updateLaboratoryObservationReferences(spa, SectionsVACD.SEROLOGY_STUDIES);

    // create the CDA level 2 text (either generated or empty text with content reference)
    if (CDALevel2TextGeneration) {
      lss.createStrucDocText(generateNarrativeTextImmunizationRecommendations());
    } 
    else {
      setNarrativeTextLaboratoryObservation("-");
    }
  }

  /**
   * <div class="de">Fügt ein vergangenes Leiden hinzu</div> <div class="fr"></div> <div
   * class="it"></div>
   *
   * @param pastProblemConcern <br>
   *        <div class="de"> past problem concern</div> <div class="fr"></div> <div
   *        class="it"></div>
   */
  public void addPastProblemConcern(PastProblemConcern pastProblemConcern) {
    org.openhealthtools.mdht.uml.cda.ihe.HistoryOfPastIllnessSection hopis;

    // find or create (and add) the Section
    hopis = getDoc().getHistoryOfPastIllnessSection();
    if (hopis == null) {
      hopis = IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
      hopis.setTitle(Util.st(SectionsVACD.HISTORY_OF_PAST_ILLNESS.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(hopis);
    }

    // add the MDHT Object to the section
    hopis.addAct(pastProblemConcern.copyMdhtProblemConcernEntry());

    // update the MDHT Object content references to CDA level 1 text
    if (updateProblemConcernReferences(hopis.getActs(), SectionsVACD.HISTORY_OF_PAST_ILLNESS)) {
      // create the CDA level 2 text (either generated or empty text with content reference)
      if (CDALevel2TextGeneration) {
        hopis.createStrucDocText(generateNarrativeTextPastProblemConcernEntries());
      } 
      else {
        setNarrativeTextPastProblemConcerns("");
      }
    } else {
      hopis.createStrucDocText("");
      pastProblemConcern.copyMdhtProblemConcernEntry().getEntryRelationships().get(0).getObservation().setText(Util.createEd(""));
    }
  }

  /**
   * <div class="de">Fügt eine Schwangerschaft hinzu</div> <div class="fr"></div> <div
   * class="it"></div>
   *
   * @param pregnancy <br>
   *        <div class="de">Schwangerschaft</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addPregnancy(Pregnancy pregnancy) {
    org.openhealthtools.mdht.uml.cda.ihe.PregnancyHistorySection phs;
    SimpleTextBuilder sb;

    // TODO Change to max one section in the model
    phs = getDoc().getPregnancyHistorySection();

    if (phs == null) {
      phs = IHEFactory.eINSTANCE.createPregnancyHistorySection().init();
      phs.setTitle(Util.st(SectionsVACD.HISTORY_OF_PREGNANCIES.getSectionTitle(doc.getLanguageCode())));
      doc.addSection(phs);
    }
   
    // create the CDA level 2 text (either generated or empty text with content reference)
    ED reference;
    if (CDALevel2TextGeneration) {
      // create the CDA level 1 text and update the MDHT Object content
      // references to CDA level 1 text
      String pregnancyText = "Voraussichtlicher Geburtstermin: " + pregnancy.getEstimatedBirthdate();
      if (phs.getText() != null) {
        String oldSectionText = Util.extractStringFromNonQuotedStrucDocText(phs.getText());
        sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_PREGNANCIES, pregnancyText, oldSectionText);
      } else {
        sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_PREGNANCIES, pregnancyText);
      }

       reference = Util.createReference(sb.getNewTextContentIDNr(), SectionsVACD.HISTORY_OF_PREGNANCIES.getContentIdPrefix());
      phs.createStrucDocText(sb.toString());
    } 
    else {
      setNarrativeTextPregnancies("");
      reference = Util.createReference(1, SectionsVACD.HISTORY_OF_PREGNANCIES.getContentIdPrefix());
    }
    pregnancy.getMdhtPregnancy().setText(reference);
    phs.addObservation(pregnancy.copyMdhtPregnancy());
  }

  private Section findRemarksSection() {
    for (Section section : doc.getSections()) {
      if (section.getCode() != null) {
        if (SectionsVACD.isRemarks(section.getCode().getCode())) {
          return section;
        }
      }
    }
    return null;
  }

  private void fixGeneralHeaderConstraintTemplateId() {
    for (int i = 0; i < doc.getTemplateIds().size(); i++) {
      if (doc.getTemplateIds().get(i).getRoot().equals("2.16.840.1.113883.10.20.3")) {
        doc.getTemplateIds().remove(i);
      }
    }
  }

  /**
   * Liefert den menschenlesbaren Text des Kapitels zu Aktiven Leiden zurück
   *
   * @return the active problem concerns text
   */
  public String generateNarrativeTextActiveProblemConcerns() {
    ArrayList<ProblemConcern> problemConcernEntryList = new ArrayList<ProblemConcern>();
    // Convert from the specific PastProblemConcern Type to the more
    // genearal PastProblemConcern
    for (ActiveProblemConcern prob : getActiveProblemConcerns()) {
      problemConcernEntryList.add(prob);
    }

    ProblemConcernEntryTextBuilder b = new ProblemConcernEntryTextBuilder(problemConcernEntryList, SectionsVACD.ACTIVE_PROBLEMS);
    return b.toString();
  }

  /**
   * Liefert den Text des Kapitels Allergie Leiden zurück
   *
   * @return the allergy problem concerns text
   */
  public String generateNarrativeTextAllergyProblemConcerns() {
    AllergyConcernTextBuilder b = new AllergyConcernTextBuilder(getAllergyProblemConcerns(), SectionsVACD.ALLERGIES_REACTIONS);
    return b.toString();
  }

  /**
   * <div class="de">Liefert den menschenlesbaren Text zu dem Kaptiel Impfempfehlungen zurück</div>
   * <div class="fr"></div> <div class="it"></div>
   *
   * @return <div class="en">the immunization recommendations text</div>
   */
  public String generateNarrativeTextImmunizationRecommendations() {
    ImmunizationRecommendationTextBuilder b = new ImmunizationRecommendationTextBuilder(getImmunizationRecommendations());
    return b.toString();
  }

  /**
   * Gets the immunization text.
   *
   * @return the immunization text
   */
  public String generateNarrativeTextImmunizations() {
    ImmunizationTextBuilder b = new ImmunizationTextBuilder(getImmunizations());
    return b.toString();
  }

  /**
   * Liefert den menschenlesbaren Text zu dem Kapitel Laborresultate zurück
   *
   * @return the laboratory observations text
   */
  public String generateNarrativeTextLaboratoryObservations() {
    LaboratoryObservationTextBuilder b = new LaboratoryObservationTextBuilder(getLaboratoryObservations(), SectionsVACD.SEROLOGY_STUDIES);
    return b.toString();
  }

  /**
   * Liefert den menschenlesbaren Text zu allen vergangenen Leiden zurück
   *
   * @return the past problem concern entries text
   */
  public String generateNarrativeTextPastProblemConcernEntries() {
    ArrayList<ProblemConcern> problemConcernEntryList = new ArrayList<ProblemConcern>();
    // Convert from the specific PastProblemConcern Type to the more
    // genearal PastProblemConcern
    for (PastProblemConcern prob : getPastProblemConcerns()) {
      problemConcernEntryList.add(prob);
    }

    ProblemConcernEntryTextBuilder b = new ProblemConcernEntryTextBuilder(problemConcernEntryList, SectionsVACD.HISTORY_OF_PAST_ILLNESS);
    return b.toString();
  }

  /**
   * <div class="de">Liefert alle Aktiven Leiden zurück</div> <div class="fr"></div> <div
   * class="it"></div>
   * 
   * @return the active problem concerns
   */
  public ArrayList<ActiveProblemConcern> getActiveProblemConcerns() {
    // Search for the right section
    Section aps = getDoc().getActiveProblemsSection();
    if (aps == null) {
      return null;
    }
    EList<Act> acts = aps.getActs();

    ArrayList<ActiveProblemConcern> problemConcernEntries = new ArrayList<ActiveProblemConcern>();
    for (Act act : acts) {
      ActiveProblemConcern problemConcernEntry = new ActiveProblemConcern((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
      problemConcernEntries.add(problemConcernEntry);
    }
    return problemConcernEntries;
  }

  /**
   * Liefert alle Allergie Leiden zurück
   *
   * @return the allergy problem concerns
   */
  public ArrayList<AllergyConcern> getAllergyProblemConcerns() {
    // Search for the right section
    Section ars = getDoc().getAllergiesReactionsSection();
    if (ars == null) {
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

  /**
   * Liefert die Kommentare zurück
   *
   * @return the comment
   */
  public String getComment() {
    Section rs;
    org.ehealth_connector.cda.Comment comment;

    // find the Section
    rs = findRemarksSection();
    if (rs == null) {
      return null;
    }
    comment = new org.ehealth_connector.cda.Comment(rs.getText().getText());

    return comment.getText();
  }

  public Code getConfidentialityCode() {
    if (doc.getConfidentialityCode() != null) {
      return new Code(doc.getConfidentialityCode());
    }
    return null;
  }

  /**
   * Liefert das MDHT-VACD-Objekt zurück.
   *
   * @return the doc
   */
  public VACD getDoc() {
    return (VACD) doc;
  }

  /**
   * Liefert das Gestationsalter zurück
   *
   * @return the gestational age
   */
  public CodedResults getCodedResults() {
    return new CodedResults(getDoc().getCodedResultsSection());
  }

  /**
   * Liefert den menschenlesbaren Text zu dem Gestationsalter zurück
   *
   * @return the gestational age text
   */
  public String getCodedResultsText() {
    return getCodedResults().getCodedResultsText();
  }

  /**
   * Liefert alle Impfempfehlungen zurück
   *
   * @return Liste von Impfempfehlungen
   */
  public ArrayList<ImmunizationRecommendation> getImmunizationRecommendations() {
    // Search for the right section
    Section tps = getDoc().getImmunizationRecommendationSection();
    if (tps == null) {
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

  /**
   * Liefert alle Impfungen zurück
   *
   * @return Liste von Impfungen
   */
  public ArrayList<Immunization> getImmunizations() {
    EList<org.openhealthtools.mdht.uml.cda.ch.Immunization> il = getDoc().getImmunizationsSection().getImmunizations();

    ArrayList<Immunization> immunizations = new ArrayList<Immunization>();
    for (org.openhealthtools.mdht.uml.cda.ch.Immunization i : il) {
      Immunization immunization = new Immunization(i);
      immunizations.add(immunization);
    }
    return immunizations;
  }

  /**
   * Liefert alle Laborresultate zurück
   *
   * @return Liste von Laborresultaten
   */
  public ArrayList<org.ehealth_connector.cda.LaboratoryObservation> getLaboratoryObservations() {
    // Search for the right section
    Section los = getDoc().getLaboratorySpecialitySection();
    if (los == null) {
      return null;
    }
    EList<Entry> entries = los.getEntries();

    ArrayList<org.ehealth_connector.cda.LaboratoryObservation> labObservations = new ArrayList<org.ehealth_connector.cda.LaboratoryObservation>();
    for (Entry entry : entries) {
      org.openhealthtools.mdht.uml.cda.ch.LaboratoryReportDataProcessingEntry mLabRdpe = (org.openhealthtools.mdht.uml.cda.ch.LaboratoryReportDataProcessingEntry) entry;
      org.openhealthtools.mdht.uml.cda.ch.SpecimenAct mSpecAct = (org.openhealthtools.mdht.uml.cda.ch.SpecimenAct) mLabRdpe.getAct();
      for (org.openhealthtools.mdht.uml.cda.ch.LaboratoryBatteryOrganizer mLabOrg : mSpecAct.getLaboratoryBatteryOrganizers()) {
        for (org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation mLo : mLabOrg.getLaboratoryObservations()) {
          org.ehealth_connector.cda.LaboratoryObservation lo = new org.ehealth_connector.cda.LaboratoryObservation(mLo);
          labObservations.add(lo);
        }
      }
    }
    return labObservations;
  }

  /**
   * Liefert alle vergangen Leiden zurück
   *
   * @return the past problem concern entries
   */
  public ArrayList<PastProblemConcern> getPastProblemConcerns() {
    // Search for the right section
    Section hopis = getDoc().getHistoryOfPastIllnessSection();
    if (hopis == null) {
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

  /**
   * Liefert alle Schwangerschaften zurück
   *
   * @return Liste von Schwangerschaften
   */
  public ArrayList<Pregnancy> getPregnancies() {
    // Search for the right section
    PregnancyHistorySection phs = getDoc().getPregnancyHistorySection();
    if (phs == null) {
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
   * Pseudonymisierung eines ClinicalDocument nach der CDA-CH-VACD Spezifikation (siehe CDA-CH-VACD,
   * UseCases ab Kapitel 6.3 und insbesondere Kapitel "7.4 CDA Header", Regel <CH-VACD-HPAT> )
   */
  public void pseudonymization() {
    for (PatientRole mPatientRole : getDoc().getPatientRoles()) {
      mPatientRole = getDoc().getPatientRoles().get(0);
      Patient mPatient = mPatientRole.getPatient();

      // Name
      mPatient.getNames().clear();
      PN pn = DatatypesFactory.eINSTANCE.createPN();
      pn.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.MSK);
      mPatient.getNames().add(pn);

      // Street
      for (AD ad : mPatientRole.getAddrs()) {
        ad.getStreetAddressLines().clear();
        ad.getStreetNames().clear();
        ADXP adxp = DatatypesFactory.eINSTANCE.createADXP();
        adxp.setNullFlavor(NullFlavor.MSK);
        ad.getStreetNames().add(adxp);
      }

      // Phone
      mPatientRole.getTelecoms().clear();
      TEL tel = DatatypesFactory.eINSTANCE.createTEL();
      tel.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.MSK);
      mPatientRole.getTelecoms().add(tel);
    }

  }

  /**
   * Setzt das MDHT-VACD-Objekt.
   *
   * @param doc the new doc
   */
  public void setDoc(VACD doc) {
    this.doc = doc;
  }
  
  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextImmunizations() {
    return (getNarrativeText(getDoc().getImmunizationsSection()));
  }

  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextImmunizations(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_IMMUNIZATION, text);
    getDoc().getImmunizationsSection().createStrucDocText(sb.toString());
  }

  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextActiveProblemConcerns() {
    return getNarrativeText(getDoc().getActiveProblemsSection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextActiveProblemConcerns(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.ACTIVE_PROBLEMS, text);
    getDoc().getActiveProblemsSection().createStrucDocText(sb.toString());
  }

  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextAllergyProblemConcerns() {
    return getNarrativeText(getDoc().getAllergiesReactionsSection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextAllergyProblemConcerns(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.ALLERGIES_REACTIONS, text);
    getDoc().getAllergiesReactionsSection().createStrucDocText(sb.toString());
  }

  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextCodedResults() {
    return getNarrativeText(getDoc().getCodedResultsSection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextCodedResults(String text) {
    getDoc().getCodedResultsSection().createStrucDocText(text);
  }

  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextPastProblemConcerns() {
    return getNarrativeText(getDoc().getHistoryOfPastIllnessSection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextPastProblemConcerns(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_PAST_ILLNESS, text);
    getDoc().getHistoryOfPastIllnessSection().createStrucDocText(sb.toString());
  }
  
  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextLaboratoryObservation() {
    return getNarrativeText(getDoc().getLaboratorySpecialitySection());
  }

  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextLaboratoryObservation(String text) {
//    SimpleTextBuilder sb;
//    sb = new SimpleTextBuilder(SectionsVACD.SEROLOGY_STUDIES, text);
//    getDoc().getLaboratorySpecialitySection().createStrucDocText(sb.toString());
    getDoc().getLaboratorySpecialitySection().createStrucDocText(text);
  }

  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextPregnancies() {
    return getNarrativeText(getDoc().getPregnancyHistorySection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextPregnancies(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.HISTORY_OF_PREGNANCIES, text);
    getDoc().getPregnancyHistorySection().createStrucDocText(sb.toString());
  }

  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextImmunizationRecommendation() {
    return getNarrativeText(getDoc().getImmunizationRecommendationSection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextImmunizationRecommendations(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.TREATMENT_PLAN, text);
    getDoc().getImmunizationRecommendationSection().createStrucDocText(sb.toString());
  }
  
  /**
   * <div class="en">Gets the human readable CDA section text for the according section</div> <div
   * class="de">Liefert den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @eturn <div class="en"> the text of the human readable part of the cda document</div>
   *        <div class="de"> der text des menschlenlesbaren Teils des CDA-Dokuments</div>
   * 
   */
  public String getNarrativeTextComments() {
    return getNarrativeText(findRemarksSection());
  }
  
  /**
   * <div class="en">Sets the human readable CDA section text for the according section</div> <div
   * class="de">Setzt den menschenlesbaren CDA Section Text für die entsprechende Section</div>
   * 
   *
   * @param text <div class="en"> the new text for the human readable part of the cda document</div>
   *        <div class="de"> der neue text für den menschlenlesbaren Teil des CDA-Dokuments</div>
   * 
   */
  public void setNarrativeTextComments(String text) {
    SimpleTextBuilder sb;
    sb = new SimpleTextBuilder(SectionsVACD.REMARKS, text);
    findRemarksSection().createStrucDocText(sb.toString());
  }


  /**
   * Setzt das Gestationsalter
   *
   * @param gestationalAge the new gestational age
   */
  public void addCodedResults(CodedResults gestationalAge) {
    SimpleTextBuilder sb;

    // update the MDHT Object content references to CDA level 1 text
    sb = new SimpleTextBuilder(SectionsVACD.CODED_RESULTS, gestationalAge.getCodedResultsText());

    ED reference = Util.createReference(sb.getNewTextContentIDNr(), SectionsVACD.CODED_RESULTS.getContentIdPrefix());
    gestationalAge.getMdhtGestationalAgeWeeksObservation().setText(EcoreUtil.copy(reference));
    gestationalAge.getMdhtGestationalAgeDaysObservation().setText(EcoreUtil.copy(reference));

    // create the CDA level 1 text
    gestationalAge.getMdhtCodedResultsSection().createStrucDocText(sb.toString());

    gestationalAge.getMdhtCodedResultsSection().setTitle(Util.st(SectionsVACD.CODED_RESULTS.getSectionTitle(doc.getLanguageCode())));

    doc.addSection(gestationalAge.copyMdhtCodedResultsSection());
  }

  private boolean updateAllergyConcernReferences(EList<Act> acts, SectionsVACD loincSectionCode) {
    int i = 0;
    for (Act act : acts) {
      int j = 0;
      i++;
      org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) act;
      for (ProblemEntry problemEntry : problemConcernEntry.getAllergyIntolerances()) {
        // Check if the problem is not unknown (leads to no reference,
        // because there is no problem)
        Code code = new Code(problemEntry.getCode());
        if (code.getCodeSystem().equals("2.16.840.1.113883.6.96") && code.getCode().equals(ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
          return false;
        } else {
          // Create references to level 1 text
          ED reference;
          if (CDALevel2TextGeneration) {
            reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
          }
          else {
            reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
          }
          problemEntry.setText(EcoreUtil.copy(reference));
          problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
        }
        for (EntryRelationship er : problemEntry.getEntryRelationships()) {
          j++;
          er = Util.updateRefIfComment(er, String.valueOf(i) + String.valueOf(j), loincSectionCode);
        }
      }
    }
    return true;
  }

  private void updateLaboratoryObservationReferences(SpecimenAct spa, SectionsVACD loincSectionCode) {
    for (int i = 0; i < spa.getLaboratoryBatteryOrganizers().size(); i++) {
      LaboratoryBatteryOrganizer lba = spa.getLaboratoryBatteryOrganizers().get(i);
      for (int j = 0; j < lba.getLaboratoryObservations().size(); j++) {
        org.openhealthtools.mdht.uml.cda.ch.LaboratoryObservation lo = lba.getLaboratoryObservations().get(j);
        for (int k = 0; k < lo.getEntryRelationships().size(); k++) {
          EntryRelationship er = lo.getEntryRelationships().get(k);
          if (Util.isComment(er)) {
            k++;
              er = Util.updateRefIfComment(er, String.valueOf(i + 1) + String.valueOf(j + 1) + String.valueOf(k + 1), loincSectionCode);
          }
        }
      }
    }
  }

  private boolean updateProblemConcernReferences(EList<Act> acts, SectionsVACD loincSectionCode) {
    int i = 0;
    for (Act act : acts) {
      org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act;
      for (ProblemEntry problemEntry : problemConcernEntry.getProblemEntries()) {
        // Check if the problem is not unknown (leads to no reference,
        // because there is no problem)
        Code code = new Code(problemEntry.getCode());
        if (code.getCodeSystem().equals("2.16.840.1.113883.6.96") && code.getCode().equals(ProblemsSpecialConditions.HISTORY_OF_PAST_ILLNESS_UNKNOWN.getCode())) {
          return false;
        } else {
          // Create references to level 1 text
          i++;
          ED reference;
          if (CDALevel2TextGeneration) {
            reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
          }
          else {
            reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
          }
          problemEntry.setText(EcoreUtil.copy(reference));
          problemEntry.getCode().setOriginalText(EcoreUtil.copy(reference));
        }
      }
    }
    return true;
  }

  private void updateSubstanceAdministrationReferences(List<SubstanceAdministration> substanceAdministrations, SectionsVACD loincSectionCode) {
    ED reference;
    int i = 0;
    for (SubstanceAdministration ir : substanceAdministrations) {
      i++;
      if (CDALevel2TextGeneration) {
        reference = Util.createReference(i, loincSectionCode.getContentIdPrefix());
      } else {
        reference = Util.createReference(1, loincSectionCode.getContentIdPrefix());
      }

      ir.setText(reference);
      if (ir.getConsumable() != null) {
        if (ir.getConsumable().getManufacturedProduct() != null) {
          if (ir.getConsumable().getManufacturedProduct().getManufacturedMaterial() != null) {
            if (ir.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode() != null) {
              ir.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode().setOriginalText(EcoreUtil.copy(reference));
            }
            for (EntryRelationship er : ir.getEntryRelationships()) {
              er = Util.updateRefIfComment(er, String.valueOf(i), loincSectionCode);
            }
          }
        }
      }
    }
  }
  
  private String getNarrativeText(Section s) {
    if(s!= null && s!=null) {
      StrucDocText t =  s.getText();
      return Util.extractStringFromNonQuotedStrucDocText(t);
    }
    return null;
  }
}
