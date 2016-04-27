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

package org.ehealth_connector.cda.ch.edes.enums;

import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CdaChEdes;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.PCCFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

public enum SectionsEDES implements ContentIdPrefix {
	//@formatter:off
	/** <div class="en">Ability to Work</div><div class="de">Arbeitsfähigkeit</div><div class="fr">Capacité de travail</div><div class="it">Abilità lavorativa</div>*/
	ABILITY_TO_WORK("X-ATWRK", "atw", "Arbeitsfähigkeit", "Capacité de travail", "Abilità lavorativa", "Ability to Work"),
	/** <div class="en">Active Problems</div><div class="de">Problemliste</div><div class="fr">Liste des problèmes</div><div class="it">Elenco dei problemi</div>*/
	ACTIVE_PROBLEMS("11450-4", "ap", "Problemliste", "Liste des problèmes", "Elenco dei problemi", "Active Problems"),
	/** <div class="en">Acuity Assessment</div><div class="de">Triage Beurteilung</div><div class="fr">Evaluation du triage</div><div class="it">Valutazione del triage</div>*/
	ACUITY_ASSESSMENT("11283-9", "acas", "Triage Beurteilung", "Evaluation du triage", "Valutazione del triage", "Acuity Assessment"),
	/** <div class="en">Advance Directives</div><div class="de">Patientenverfügungen</div><div class="fr">Directives anticipées</div><div class="it">Direttive anticipate</div>*/
	ADVANCE_DIRECTIVES("42348-3", "ad", "Patientenverfügungen", "Directives anticipées", "Direttive anticipate", "Advance Directives"),
	/** <div class="en">Allergies and Other Adverse Reactions</div><div class="de">Allergien und Unverträglichkeiten</div><div class="fr">Allergies et autres réactions indésirables</div><div class="it">Allergie e altre reazioni avverse</div>*/
	ALLERGIES_AND_OTHER_ADVERSE_REACTIONS("48765-2", "ar", "Allergien und Unverträglichkeiten","Allergies et autres réactions indésirables", "Allergie e altre reazioni avverse", "Allergies and Other Adverse Reactions"),
	/** <div class="en">Assessment and care plan</div><div class="de">Beurteilung und Behandlungsplan</div><div class="fr">Evaluation et attitude</div><div class="it">Valutazione e piano di trattamento</div>*/
	ASSESSMENT_AND_PLAN("51847-2", "aspl", "Beurteilung und Behandlungsplan", "Evaluation et attitude", "Valutazione e piano di trattamento", "Assessment and care plan"),
	/** <div class="en">Assessments</div><div class="de">Beurteilung</div><div class="fr">Evaluation</div><div class="it">Valutazione</div>*/
	ASSESSMENTS("51848-0", "as", "Beurteilung", "Evaluation", "Valutazione", "Assessments"),
	/** <div class="en">Care plan</div><div class="de">Behandlungsplan</div><div class="fr">Attitude</div><div class="it">Piano di trattamento</div>*/
	CARE_PLAN("18776-5", "cp", "Behandlungsplan", "Attitude", "Piano di trattamento", "Care plan"),
	/** <div class="en">Chief complaint</div><div class="de">Hauptbeschwerden des Patienten</div><div class="fr">Plainte principale</div><div class="it">Disturbi principali del paziente</div>*/
	CHIEF_COMPLAINT("10154-3", "cc", "Hauptbeschwerden des Patienten", "Plainte principale", "Disturbi principali del paziente", "Chief complaint"),
	/** <div class="en">Physical Examination</div><div class="de">Diagnostische Untersuchungen</div><div class="fr">Examen physique</div><div class="it">Esami diagnostici</div>*/
	CODED_PHYSICAL_EXAM("29545-1", "phex", "Diagnostische Untersuchungen", "Examen physique", "Esami diagnostici", "Physical Examination"),
	/** <div class="en">Coded Vital Signs</div><div class="de">Codierte Vitalzeichenliste</div><div class="fr">Signes vitaux codifiés</div><div class="it">Elenco codificato dei segni vitali</div>*/
	CODED_VITAL_SIGNS("8716-3", "cvit", "Codierte Vitalzeichenliste", "Signes vitaux codifiés", "Elenco codificato dei segni vitali", "Coded Vital Signs"),
	/** <div class="en">Current Medications</div><div class="de">Aktuelle Medikation</div><div class="fr">Médicaments actuels</div><div class="it">Medicamenti attuali</div>*/
	CURRENT_MEDICATIONS("10160-0", "cmed", "Aktuelle Medikation", "Médicaments actuels", "Medicamenti attuali", "Current Medications"),
	/** <div class="en">Consultations</div><div class="de">Konsultationen in der Notfallstation</div><div class="fr">Consultations aux urgences</div><div class="it">Consultazioni al pronto soccorso</div>*/
	ED_CONSULTATIONS("18693-2", "edcon", "Konsultationen in der Notfallstation", "Consultations aux urgences", "Consultazioni al pronto soccorso", "Consultations"),
	/** <div class="en">ED Diagnoses</div><div class="de">Notfalldiagnosen</div><div class="fr">Diagnostics aux urgences</div><div class="it">Diagnosi in urgenza</div>*/
	ED_DIAGNOSIS("11301-9", "eddia", "Notfalldiagnosen", "Diagnostics aux urgences", "Diagnosi in urgenza", "ED Diagnoses"),
	/** <div class="en">ED Disposition</div><div class="de">Angaben zum Austritt</div><div class="fr">Données de sortie</div><div class="it">Indicazioni all'uscita</div>*/
	ED_DISPOSITION("11302-7", "eddis", "Angaben zum Austritt", "Données de sortie", "Indicazioni all'uscita", "ED Disposition"),
	/** <div class="en">Family Medical History</div><div class="de">Familien Anamnese</div><div class="fr">Anamnèse familiale</div><div class="it">Anamnesi familiare</div>*/
	FAMILY_MEDICAL_HISTORY("10157-6", "fahi", "Familien Anamnese", "Anamnèse familiale", "Anamnesi familiare", "Family Medical History"),
	/** <div class="en">Immunizations</div><div class="de">Impfungen</div><div class="fr">Vaccinations</div><div class="it">Vaccinazioni</div>*/
	HISTORY_OF_IMMUNIZATION("11369-6", "hoi", "Impfungen", "Vaccinations", "Vaccinazioni", "Immunizations"),
	/** <div class="en">History of Past Illness</div><div class="de">Bisherige Krankheiten</div><div class="fr">Antécédants médicaux</div><div class="it">Storia medica</div>*/
	HISTORY_OF_PAST_ILLNESS("11348-0","hipai", "Bisherige Krankheiten", "Antécédants médicaux", "Storia medica","History of Past Illness"),
	/** <div class="en">Pregnancy History</div><div class="de">Schwangerschaften</div><div class="fr">Grossesses</div><div class="it">Gravidanze</div>*/
	HISTORY_OF_PREGNANCIES("10162-6", "hop", "Schwangerschaften", "Grossesses", "Gravidanze", "Pregnancy History"),
	/** <div class="en">History of Present Illness</div><div class="de">Notfallanamnese</div><div class="fr">Anamnèse actuelle</div><div class="it">Anamnesi del caso d'urgenza</div>*/
	HISTORY_OF_PRESENT_ILLNESS("10164-2", "hipri", "Notfallanamnese", "Anamnèse actuelle", "Anamnesi del caso d'urgenza", "History of Present Illness"),
	/** <div class="en">Medications at Discharge</div><div class="de">Medikamente bei Austritt</div><div class="fr">Médicaments à la sortie</div><div class="it">Medicamenti all'uscita</div>*/
	HOSPITAL_DISCHARGE_MEDICATIONS("10183-2", "hodm", "Medikamente bei Austritt", "Médicaments à la sortie", "Medicamenti all'uscita", "Medications at Discharge"),
	/** <div class="en">Intravenous Fluids Administered</div><div class="de">Verabreichte Infusionen</div><div class="fr">Liquides intraveineux administrés</div><div class="it">Infusioni somministrate</div>*/
	INTRAVENOUS_FLUIDS_ADMINISTERED("57072-1", "ifa", "Verabreichte Infusionen", "Liquides intraveineux administrés", "Infusioni somministrate", "Intravenous Fluids Administered"),
	/** <div class="en">List of Surgeries</div><div class="de">Frühere Operationen</div><div class="fr">Antécédents chirurgicaux</div><div class="it">Operazioni precedenti</div>*/
	LIST_OF_SURGERIES("47519-4", "los", "Frühere Operationen", "Antécédents chirurgicaux", "Operazioni precedenti", "List of Surgeries"),
	/** <div class="en">Medications administered</div><div class="de">Verabreichte Medikamente</div><div class="fr">Médicaments administrés</div><div class="it">Medicamenti somministrati</div>*/
	MEDICATIONS_ADMINISTERED("18610-6", "mad", "Verabreichte Medikamente", "Médicaments administrés", "Medicamenti somministrati", "Medications administered"),
	/** <div class="en">Transport Mode</div><div class="de">Angaben zum Eintritt</div><div class="fr">Mode de transport</div><div class="it">Indicazioni sull'entrata</div>*/
	MODE_OF_ARRIVAL("11459-5", "moa", "Angaben zum Eintritt", "Mode de transport", "Indicazioni sull'entrata", "Transport Mode"),
	/** <div class="en">Procedures Performed</div><div class="de">Prozedere</div><div class="fr">Interventions effectuées</div><div class="it">Trattamenti eseguiti</div>*/
	PROCEDURES("29544-3", "pr", "Prozedere", "Interventions effectuées", "Trattamenti eseguiti", "Procedures Performed"),
	/** <div class="en">Progress Note</div><div class="de">Genesungsfortschritt</div><div class="fr">Notes de suite</div><div class="it">Decorso</div>*/
	PROGRESS_NOTE("18733-6", "pn", "Genesungsfortschritt", "Notes de suite", "Decorso", "Progress Note"),
	/** <div class="en">Reason for visit</div><div class="de">Grund des Patienten für Besuch</div><div class="fr">Motif de consultation du patient</div><div class="it">Motivo della visita del paziente</div>*/
	REASON_FOR_VISIT("29299-5", "rfv", "Grund des Patienten für Besuch", "Motif de consultation du patient", "Motivo della visita del paziente", "Reason for visit"),
	/** <div class="en">Referral Source</div><div class="de">Einweisung durch</div><div class="fr">Admission par</div><div class="it">Ricovero tramite</div>*/
	REFERRAL_SOURCE("11293-8", "rs", "Einweisung durch", "Admission par", "Ricovero tramite", "Referral Source"),
	/** <div class="en">Comment</div><div class="de">Kommentar</div><div class="fr">Commentaire</div><div class="it">Osservazione</div>*/
	REMARKS("48767-8", "k", "Kommentar", "Commentaire", "Osservazione", "Comment"),
	/** <div class="en">Test Results</div><div class="de">Diagnostische Zusammenfassung</div><div class="fr">Résultats d'examens</div><div class="it">Riassunto degli esami diagnostici</div>*/
	RESULTS("30954-2", "res", "Diagnostische Zusammenfassung","Résultats d'examens", "Riassunto degli esami diagnostici", "Test Results"),
	/** <div class="en">Pertinent Review of Systems</div><div class="de">Systemanamnese</div><div class="fr">Anamnèse systématique</div><div class="it">Anamnesi sistemica</div>*/
	REVIEW_OF_SYSTEMS("10187-3", "ros", "Systemanamnese", "Anamnèse systématique", "Anamnesi sistemica", "Pertinent Review of Systems"),
	/** <div class="en">Social History;</div><div class="de">Sozial Anamnese</div><div class="fr">Anamnèse sociale</div><div class="it">Anamnesi sociale</div>*/
	SOCIAL_HISTORY("29762-2", "sohi", "Sozial Anamnese", "Anamnèse sociale", "Anamnesi sociale", "Social History");
	//@formatter:on

	/**
	 * Get the corresponding Enum constant for the section.
	 *
	 * @param section
	 *            the Section to lookup
	 * @return the Enum constant or null if not found
	 */
	public static SectionsEDES getEnum(Section section) {
		final CE code = section.getCode();
		if (code != null) {
			for (final SectionsEDES sectionsEDES : values()) {
				if (code.getCode().equals(sectionsEDES.getLoincCode())) {
					return sectionsEDES;
				}
			}
		}
		return null;
	}

	private String contentIdPrefix;

	private String loincCode;

	private String sectionTitleDe;

	private String sectionTitleEn;

	private String sectionTitleFr;

	private String sectionTitleIt;

	SectionsEDES(String loincCode, String contentIdPrefix, String sectionTitleDe,
			String sectionTitleFr, String sectionTitleIt, String sectionTitleEn) {
		this.loincCode = loincCode;
		this.contentIdPrefix = contentIdPrefix;
		this.sectionTitleDe = sectionTitleDe;
		this.sectionTitleFr = sectionTitleFr;
		this.sectionTitleIt = sectionTitleIt;
		this.sectionTitleEn = sectionTitleEn;
	}

	/**
	 * Create and initialize a new section corresponding to the Enum constant.
	 *
	 * @return initialized section
	 */
	public Section createSection() {
		final SectionsDefaultInitializer initializer = new SectionsDefaultInitializer();
		switch (name()) {
		case "ABILITY_TO_WORK":
			return CHFactory.eINSTANCE.createAbilityToWorkSection().init();
		case "ACTIVE_PROBLEMS":
			return initializer.init(IHEFactory.eINSTANCE.createActiveProblemsSection().init());
		case "ACUITY_ASSESSMENT":
			return initializer.init(PCCFactory.eINSTANCE.createAcuityAssessmentSection().init());
		case "ADVANCE_DIRECTIVES":
			return IHEFactory.eINSTANCE.createAdvanceDirectivesSection().init();
		case "ALLERGIES_AND_OTHER_ADVERSE_REACTIONS":
			return initializer.init(IHEFactory.eINSTANCE.createAllergiesReactionsSection().init());
		case "ASSESSMENT_AND_PLAN":
			return IHEFactory.eINSTANCE.createAssessmentAndPlanSection().init();
		case "ASSESSMENTS":
			return PCCFactory.eINSTANCE.createAssessmentsSection().init();
		case "CARE_PLAN":
			return IHEFactory.eINSTANCE.createCarePlanSection().init();
		case "CHIEF_COMPLAINT":
			return IHEFactory.eINSTANCE.createChiefComplaintSection().init();
		case "CODED_VITAL_SIGNS":
			return IHEFactory.eINSTANCE.createCodedVitalSignsSection().init();
		case "CURRENT_MEDICATIONS":
			return initializer.init(IHEFactory.eINSTANCE.createMedicationsSection().init());
		case "ED_CONSULTATIONS":
			return PCCFactory.eINSTANCE.createConsultationsSection().init();
		case "ED_DIAGNOSIS":
			return initializer.init(PCCFactory.eINSTANCE.createEDDiagnosesSection().init());
		case "ED_DISPOSITION":
			return initializer.init(PCCFactory.eINSTANCE.createEDDispositionSection().init());
		case "FAMILY_MEDICAL_HISTORY":
			return IHEFactory.eINSTANCE.createFamilyMedicalHistorySection().init();
		case "HISTORY_OF_PAST_ILLNESS":
			return IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
		case "HISTORY_OF_PREGNANCIES":
			return IHEFactory.eINSTANCE.createPregnancyHistorySection().init();
		case "HISTORY_OF_PRESENT_ILLNESS":
			return IHEFactory.eINSTANCE.createHistoryOfPresentIllness().init();
		case "HISTORY_OF_IMMUNIZATION":
			return initializer.init(IHEFactory.eINSTANCE.createImmunizationsSection().init());
		case "HOSPITAL_DISCHARGE_MEDICATIONS":
			return IHEFactory.eINSTANCE.createHospitalDischargeMedicationsSection().init();
		case "INTRAVENOUS_FLUIDS_ADMINISTERED":
			return PCCFactory.eINSTANCE.createIntravenousFluidsAdministeredSection().init();
		case "LIST_OF_SURGERIES":
			return IHEFactory.eINSTANCE.createSurgeriesSection().init();
		case "MEDICATIONS_ADMINISTERED":
			return IHEFactory.eINSTANCE.createMedicationsAdministeredSection().init();
		case "MODE_OF_ARRIVAL":
			return initializer.init(PCCFactory.eINSTANCE.createModeOfArrivalSection().init());
		case "CODED_PHYSICAL_EXAM":
			return IHEFactory.eINSTANCE.createPhysicalExamSection().init();
		case "PROCEDURES":
			return initializer
					.init(IHEFactory.eINSTANCE.createProceduresAndInterventionsSection().init());
		case "PROGRESS_NOTE":
			return PCCFactory.eINSTANCE.createProgressNoteSection().init();
		case "REASON_FOR_VISIT":
			return PCCFactory.eINSTANCE.createReasonForVisitSection().init();
		case "REFERRAL_SOURCE":
			return PCCFactory.eINSTANCE.createReferralSourceSection().init();
		case "REMARKS":
			return CHFactory.eINSTANCE.createRemarksSection().init();
		case "RESULTS":
			return CHFactory.eINSTANCE.createCodedResultsSection().init();
		case "REVIEW_OF_SYSTEMS":
			return IHEFactory.eINSTANCE.createReviewOfSystemsSection().init();
		case "SOCIAL_HISTORY":
			return IHEFactory.eINSTANCE.createSocialHistorySection().init();
		}
		return null;
	}

	/**
	 * Find the section section corresponding to the Enum constant in an
	 * CdaChEdes document.
	 *
	 * @param edesDocument
	 * @return the section or null if not found
	 */
	public Section findSection(CdaChEdes edesDocument) {
		for (final Section section : edesDocument.getSections()) {
			if (section.getCode() != null) {
				if (loincCode.equals(section.getCode().getCode())) {
					return section;
				}
			}
		}
		return null;
	}

	@Override
	public String getContentIdPrefix() {
		return contentIdPrefix;
	}

	/**
	 * Gets the Loinc code of the element
	 * 
	 * @return the Loinc code
	 */
	public String getLoincCode() {
		return loincCode;
	}

	/**
	 * Get the title of the section corresponding to the Enum constant, using
	 * the LanguageCode.
	 *
	 * @param languageCode
	 *            LanguageCode the title should be in
	 * @return the title of the section
	 */
	public String getSectionTitle(LanguageCode languageCode) {
		String lcStr = LanguageCode.ENGLISH.getCodeValue();
		if (languageCode != null) {
			lcStr = languageCode.getCodeValue().toLowerCase();
		}
		if (lcStr.equals(LanguageCode.GERMAN.getCodeValue().toLowerCase()))
			return getSectionTitleDe();
		if (lcStr.equals(LanguageCode.FRENCH.getCodeValue().toLowerCase()))
			return getSectionTitleFr();
		if (lcStr.equals(LanguageCode.ITALIAN.getCodeValue().toLowerCase()))
			return getSectionTitleIt();
		if ("de".equals(lcStr))
			return getSectionTitleDe();
		if ("fr".equals(lcStr))
			return getSectionTitleFr();
		if ("it".equals(lcStr))
			return getSectionTitleIt();
		if ("en".equals(lcStr))
			return getSectionTitleEn();
		return getSectionTitleDe();
	}

	private String getSectionTitleDe() {
		return sectionTitleDe;
	}

	private String getSectionTitleEn() {
		return sectionTitleEn;
	}

	private String getSectionTitleFr() {
		return sectionTitleFr;
	}

	private String getSectionTitleIt() {
		return sectionTitleIt;
	}
}
