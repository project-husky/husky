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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeDocumentRoot;
import org.ehc.cda.AllergyIntolerance;
import org.ehc.cda.Disease;
import org.ehc.cda.Immunization;
import org.ehc.cda.ImmunizationTextBuilder;
import org.ehc.cda.LoincSectionCode;
import org.ehc.cda.Medication;
import org.ehc.cda.PastIllnessBuilder;
import org.ehc.cda.ProblemConcernEntry;
import org.ehc.cda.ProblemConcernTextBuilder;
//import org.ehc.cda.ProblemConcernTextBuilder;
import org.ehc.cda.Serologie;
import org.ehc.cda.Treatment;
import org.ehc.cda.TreatmentBuilder;
import org.ehc.cda.TreatmentPlanTextBuilder;
import org.ehc.cda.Value;
import org.ehc.cda.converter.MedicationConverter;
import org.ehc.common.CSUtil;
import org.ehc.common.ConvenienceUtilsEnums;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.ehc.common.ConvenienceUtilsEnums.Language;
import org.ehc.common.ConvenienceUtilsEnums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.Encounter;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Procedure;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
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
import org.openhealthtools.mdht.uml.cda.util.CDAUtil.Query;
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
	ActiveProblemsSection mActiveProblemsSection;

  /**
   * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-VACD Objekts. Beide repräsentieren ein Impfdokument.</div>
   * <div class="fr"></div>
   *
   * @param doc 
   *      <div class="de">CdaChVacd</div>
   *      <div class="fr"></div>
   */
  public CdaChVacd(VACD doc) {
      super();
      this.setDoc(doc);
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
	}
	
	 /**
     * Liefert das MDHT-VACD-Objekt zurück
     *
     * @return the doc
     */
    public VACD getDoc () {
        return (VACD) this.doc;
    }

    /**
     * Setzt das MDHT-CDAEDESCTNN-Objekt
     *
     * @param doc the new doc
     */
    public void setDoc(VACD doc) {
        this.doc = doc;
    }
    
    /**
     * Fügt ein Leiden hinzu.
     *
     * @param problemConcern Das Leiden
     */
    public void addProblemConcern(
            org.ehc.cda.ProblemConcernEntry problemConcern) {

        org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection;
        ProblemConcernTextBuilder tb;
        StrucDocText sectionTextStrucDoc;
    	String activeProblemsSectionText;
        
        //Check if this section has already be created, if not create it
        if (this.getDoc().getActiveProblemsSection() == null) {
            activeProblemsSection = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
            this.getDoc().addSection(activeProblemsSection);
            sectionTextStrucDoc = CDAFactory.eINSTANCE.createStrucDocText();
            sectionTextStrucDoc.addText("");
        }
        else {
            activeProblemsSection = this.getDoc().getActiveProblemsSection();
        }
        
        //Update existing Entries with the reference to the CDA level 1 text and create the level 1 text.
        activeProblemsSectionText = Util.extractStringFromNonQuotedStrucDocText(activeProblemsSection.getText());
        ArrayList<ProblemConcernEntry> problemConcernEntries = this.getProblemConcernEntries();
        tb = new ProblemConcernTextBuilder(problemConcernEntries, problemConcern, activeProblemsSectionText);
        problemConcern = tb.getProblemConcernEntry();
        
        //Update the section text.
        //This is a workaround for the following problem: 
        //- The sectionText can only be created once with the createSectionText Method
        //- The StrucDocText Object can´t create text with xml-elements inside. These will be quoted.
        //The Workaround crates a special text object, which can´t be read by the getText Method. So the current state of the section text is stored in the activeProblemSectionText field.
        activeProblemsSectionText = tb.getSectionText();
        sectionTextStrucDoc = Util.createNonQotedStrucDocText(activeProblemsSectionText);
        activeProblemsSection.setText(sectionTextStrucDoc);
        
        //insert the values which are special for VACD Document
        //TODO Enum einfügen
        //problemConcern.getMdhtProblemEntryList().get(0).setStatusCode(ConvenienceUtilsEnums.StatusCode.completed);	//Status code of the problem has to be "completed"
        problemConcern.getProblemConcernEntry().getIds().add(Util.ii("1.3.6.1.4.1.19376.1.5.3.1.4.5"));					//Add the ProblemEntry Template ID
        //Add the code for "Komplikations- oder Expositionsrisiken"
        CD komplikationsExpositionsrisikoCode = DatatypesFactory.eINSTANCE.createCD();
        komplikationsExpositionsrisikoCode.setCodeSystem("2.16.840.1.113883.6.96");
        komplikationsExpositionsrisikoCode.setCode("55607006");
        komplikationsExpositionsrisikoCode.setCodeSystemName("SNOMED CT");
        komplikationsExpositionsrisikoCode.setDisplayName("Problem");
        problemConcern.getMdhtProblemEntryList().get(0).setCode(komplikationsExpositionsrisikoCode);
        
        //create a copy of the given object and its sub-objects
        org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntryMdht = EcoreUtil.copy(problemConcern.getProblemConcernEntry());
        activeProblemsSection.addAct(problemConcernEntryMdht);
        problemConcernEntryMdht.getEntryRelationships().get(0).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
        problemConcernEntryMdht.getEntryRelationships().get(0).setInversionInd(false);
    }
    
    public ProblemConcernEntry getActiveProblemConcern (int leidenNr) {
        ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) this.getDoc().getActiveProblemsSection().getActs().get(leidenNr));
        return problemConcernEntry;
    }
    
    /**
     * Liefert alle Leiden im eVACDOC.
     *
     * @return Liste von Leiden
     */
    public ArrayList<ProblemConcernEntry> getProblemConcernEntries() {
        // Get the ActiveProblemSection from the Document
        query = new Query(this.doc);
    	org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = query.getSections(org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection.class).get(0);
    	if (activeProblemsSection.getActs()==null) {
    		return null;
    	}
    	else {
        // Create a List with Problem ConcernEntries
        ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();

        System.out.println("Assembling ProblemConcernEntryList");
        // Check if an Act is a problemConcernEntry. If so, create an
        // eHealthConnector ProblemConcernObject and add it to the list.
        for (Act act : activeProblemsSection.getActs()) {
            if (act instanceof org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) {
                ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
                problemConcernEntryList.add(problemConcernEntry);
                System.out.println("List Item Code: "+problemConcernEntry.getProblemConcern());
            }
        }

        return problemConcernEntryList;
    	}
    }

	/**
	 * C add allergy.
	 *
	 * @param allergie <br>
	 * 		<div class="de"> allergie</div>
	 * 		<div class="fr"> allergie</div>
	 * 		<div class="it"> allergie</div>
	 */
	public void addAllergy(AllergyIntolerance allergy) {
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
	
	private Observation createObservation(Serologie serologie) {
		Observation observation = CDAFactory.eINSTANCE.createObservation();
		observation.setClassCode(ActClassObservation.OBS);
		observation.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observation.getTemplateIds().add(Util.ii("1.3.6.1.4.1.19376.1.3.1.6"));
		observation.setCode(createCode(serologie));
		observation.setStatusCode(CSUtil.completed());
		observation.setEffectiveTime(Util.convertDate(serologie.getDate()));
		return observation;
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
		section.getTemplateIds().add(Util.ii("1.3.6.1.4.1.19376.1.3.3.2.1"));
		section.setCode(createLaboratorySpecialityCode());
		section.setTitle(Util.st("Laborbefund"));
		return section;
	}
	
	private Section createTreatmentPlanSection() {
		Section section = CDAFactory.eINSTANCE.createSection();
		section.setTitle(Util.st("Impfempfehlung"));
		section.getTemplateIds().add(Util.ii("1.3.6.1.4.1.19376.1.3.3.2.1"));
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
	public void addImmunization(Medication medication, Value dosage, Date date, org.ehc.common.Author arzt) {
		MedicationConverter c = new MedicationConverter(medication);
		org.openhealthtools.mdht.uml.cda.ihe.Immunization immunization = c.convert();
		
		getImmunizationSection().addSubstanceAdministration(immunization);
	}
	
	public void addImmunization(org.ehc.cda.Immunization immunization, org.ehc.common.Author author) {
	    ImmunizationsSection immunizationSection = this.getImmunizationSection();
		org.openhealthtools.mdht.uml.cda.ihe.Immunization iheImmunization = EcoreUtil.copy(immunization.getImmunization());
		
		iheImmunization.getAuthors().add(EcoreUtil.copy(author.getAuthorMdht()));
				
		immunizationSection.addSubstanceAdministration(iheImmunization);
		
		//Update the content references to cda level 1 text
		int numberOfImmunizations = immunizationSection.getSubstanceAdministrations().size();
		ED reference = Util.createReference(numberOfImmunizations, "i");
		SubstanceAdministration substanceAdministration = immunizationSection.getSubstanceAdministrations().get(numberOfImmunizations-1);
		
		substanceAdministration.setText(reference);
		substanceAdministration.getConsumable().getManufacturedProduct().getManufacturedMaterial().getCode().setOriginalText(EcoreUtil.copy(reference));
		
		immunizationSection.createStrucDocText(getImmunizationText());
	}
	
	private String getImmunizationText() {
		ImmunizationTextBuilder b = new ImmunizationTextBuilder(getImmunizations());
		return b.toString();
	}
	
	private String getTreatmentPlanText() {
		TreatmentPlanTextBuilder b = new TreatmentPlanTextBuilder(getImmunizations());
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
		procedure.setEffectiveTime(Util.createUnknownTime());
		return procedure;
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
		section.setTitle(Util.st("Bisherige Krankheiten"));
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
		section.setTitle(Util.st("Impfungen"));
		return section;
	}

	public void addProblemConcernEntry(org.ehc.cda.ProblemConcernEntry problemConcernEntry) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblem = problemConcernEntry.getProblemConcernEntry();
		
		getActiveProblemsSection().addAct(iheProblem);
	}
	
	public void addHistoryOfPastIllnessEntry(org.ehc.cda.ProblemConcernEntry problemConcernEntry) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry iheProblem = problemConcernEntry.getProblemConcernEntry();
		
		getHistoryOfPastIllnessSection().addAct(iheProblem);
	}
	
	/**
	 * Adds an entry to the "HISTORY OF PAST ILLNESS" section.
	 * 
	 * @param disease
	 */
	public void addPastIllNess(Disease disease) {
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
	public void addTreatment(Treatment treatment) {
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
	
	private org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry createProblemEntry(Disease disease) {
		org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry entry = IHEFactory.eINSTANCE.createProblemEntry();
		entry.setClassCode(ActClassObservation.OBS);
		entry.setMoodCode(x_ActMoodDocumentObservation.EVN);
		
		entry.getTemplateIds().add(Util.ii("1.3.6.1.4.1.19376.1.5.3.1.4.5"));
		entry.getTemplateIds().add(Util.ii("2.16.840.1.113883.10.20.1.28"));
		entry.getTemplateIds().add(Util.ii("2.16.840.1.113883.10.20.1.54"));
		
		entry.getIds().add(Util.ii("2.16.756.5.30.1.1.1.1.3.1.1", "B3DC860A-D59C-42E2-9527-BE21A0D0334F"));
		
		entry.setCode(createCode(disease));
		entry.setText(Util.createProblemEntryText());
		entry.setStatusCode(CSUtil.completed());
		entry.setEffectiveTime(Util.createUnknownLowHighTimeNullFlavor());
		entry.getValues().add(createCode(disease));
		return entry;
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
	public List<Immunization> getImmunizations() {
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
	
//	/**
//	 * Liefert alle Leiden im eVACDOC.
//	 *
//	 * @return Liste von Leiden
//	 */
//	public ArrayList<ProblemConcernEntry> getProblemConcernEntries() {
//	  // Get a list of ActiveProblemSections from the Document
//	  System.out.println("\nUsing CDAUtil Query/Filter Operations (programmatic access for Java gurus)");
//	  Query query = new Query(doc);
//	  List<org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection> mdhtActiveProblemsSectionList = query.getSections(org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection.class);
//
//		// Create a List of eHC Problem ConcernEntries
//		ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();
//
//		for(org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection: mdhtActiveProblemsSectionList) {
//		// Check if an Act is a problemConcernEntry. If so, create an
//	        // eHealthConnector ProblemConcernObject with it and add it to the list.
//	        for (Act act : activeProblemsSection.getActs()) {
//	            if (act instanceof org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) {
//	                ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry(
//	                        (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
//	                problemConcernEntryList.add(problemConcernEntry);
//	            }
//	        }
//		}
//		
//
//		return problemConcernEntryList;
//	}
	

//	/**
//	 * Fügt ein Leiden hinzu.
//	 *
//	 * @param problemConcern            Das Leiden
//	 */
//	public void addProblemConcern(
//			org.ehc.cda.ProblemConcernEntry problemConcern) {
//		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = IHEFactory.eINSTANCE
//				.createActiveProblemsSection().init();
//		doc.addSection(activeProblemsSection);
//		
//	    org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry leidenMdht = problemConcern.getProblemConcernEntry();
//
//		ProblemConcernTextBuilder problemTextBuilder = new ProblemConcernTextBuilder(this.getProblemConcernEntries());
//		// set up the narrative (human-readable) text portion of the ActiveProblems
//		// section
//		activeProblemsSection.createStrucDocText(problemTextBuilder.toString());
//		//activeProblemsSection.createStrucDocText("TEST");
//		activeProblemsSection.addAct(leidenMdht);
//	}
	
//	/**
//	 * Set title and effectiveTime, otherwise document is NOT XML schema compliant.
//	 * 
//	 * @see ehealthconnector.cda.documents.ch.CdaCh#setChMetadata(ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.Language, java.lang.String)
//	 */
//	@Override
//	public void setChMetadata(Language language, String stylesheet) {
//		super.setChMetadata(language, stylesheet);
//		
//		setParentTemplateIds();
//		
//		doc.setTitle(st("eVACDOC"));
//		doc.setEffectiveTime(DateUtil.nowAsTS());
//	}
//	
//	/**
//	 * Sets the parent template ids
//	 * Schematron validation checks for this ids !
//	 */
//	private void setParentTemplateIds() {
//		// IHE PCC Medical Documents Specification
//		doc.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.1.1"));
//	
//		// IHE Immunization Detail Specification
//		doc.getTemplateIds().add(ii("1.3.6.1.4.1.19376.1.5.3.1.1.18.1.2"));
//		
//		// CDA-CH
//		doc.getTemplateIds().add(ii("2.16.756.5.30.1.1.1.1", "CDA-CH"));
//
//		// eVACDOC (VACD) V1
//		
//		// TODO: acutually validator crashes when setting this !!??
////		doc.getTemplateIds().add(ii("2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH-VACD"));
//		
//		// fix missing extension value in MDHT model.
//		for (II templateId : doc.getTemplateIds()) {
//			if ("2.16.756.5.30.1.1.1.1.3.5.1".equals(templateId.getRoot())) {
//				templateId.setExtension("CDA-CH-VACD");
//			}
//		}
//	}
//	
//	/**
//	 * Erstellt ein neues eVACDOC CDA Dokument
//	 * 
//	 * @param language
//	 *            Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
//	 * @param stylesheet
//	 *            Stylesheet, welches im CDA mittels <?xml-stylesheet> fuer die
//	 *            menschlich Lesbare Darstellung referenziert werden soll.
//	 */
//	public CdaChVacd(Language language, String stylesheet, Object old) {
//		doc = CHFactory.eINSTANCE.createVACD().init();
//
//		// Set language of the document
//		doc.setLanguageCode(Util.createLanguageCode(language));
//
//		// Set OID of the document
//		II docID = DatatypesFactory.eINSTANCE.createII();
//		doc.setId(docID);
//		docID.setRoot("MDHT");
//		docID.setExtension("1817558763");
//
//		// Set Type ID
//		InfrastructureRootTypeId typeId = CDAFactory.eINSTANCE
//				.createInfrastructureRootTypeId();
//		doc.setTypeId(typeId);
//		typeId.setRoot("2.16.840.1.113883.1.3");
//		typeId.setExtension("POCD_HD000040");
//
//		// set title
//		doc.setTitle(st("eVACDOC"));
//
//		// set effective time
//		doc.setEffectiveTime(DateUtil.nowAsTS());
//		
//		// Set Confidentially Code
//		CE confidentialityCode = DatatypesFactory.eINSTANCE.createCE();
//		doc.setConfidentialityCode(confidentialityCode);
//		confidentialityCode.setCode("1941043196");
//
//		initDocumentRoot(stylesheet);
//	}
//	
//	private void initDocumentRoot(String stylesheet) {
//		// Create document root
//		docRoot = CDAFactory.eINSTANCE.createDocumentRoot();
//
//		// Add the stylesheet processing instructions to the document root using featuremaputil
//		if (stylesheet != null) {
//		FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(), "xml-stylesheet", "type=\"text/xsl\" href=\"" + stylesheet
//						+ "\" ");
//		}
//
//		// Set the CDA document
//		docRoot.setClinicalDocument(doc);
//
//		// set xml namespace
//		docRoot.getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);
//	}
}
