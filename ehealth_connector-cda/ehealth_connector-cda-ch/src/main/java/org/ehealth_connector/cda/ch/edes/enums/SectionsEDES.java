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
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.edes.enums;

import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CdaChEdes;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.pcc.PCCFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

public enum SectionsEDES implements ContentIdPrefix {
	//@formatter:off
	ABILITY_TO_WORK("X-ATWRK", "atw", "Arbeitsfähigkeit", "Capacité de travail", "Abilità lavorativa", "Ability to Work"),
	ACTIVE_PROBLEMS("11450-4", "ap", "Problemliste", "Liste des problèmes", "Elenco dei problemi", "Active Problems"),
	ACUITY_ASSESSMENT("11283-9", "acas", "Triage Beurteilung", "Evaluation du triage", "Valutazione del triage", "Acuity Assessment"),
	ADVANCE_DIRECTIVES("42348-3", "ad", "Patientenverfügungen", "Directives anticipées", "Direttive anticipate", "Advance Directives"),
	ALLERGIES_AND_OTHER_ADVERSE_REACTIONS("48765-2", "ar", "Allergien und Unverträglichkeiten","Allergies et autres réactions indésirables", "Allergie e altre reazioni avverse", "Allergies and Other Adverse Reactions"),
	ASSESSMENT_AND_PLAN("51847-2", "aspl", "Beurteilung und Behandlungsplan", "Evaluation et attitude", "Valutazione e piano di trattamento", "Assessment and care plan"),
	ASSESSMENTS("51848-0", "as", "Beurteilung", "Evaluation", "Valutazione", "Assessments"),
	CARE_PLAN("18776-5", "cp", "Behandlungsplan", "Attitude", "Piano di trattamento", "Care plan"),
	CHIEF_COMPLAINT("10154-3", "cc", "Hauptbeschwerden des Patienten", "Plainte principale", "Disturbi principali del paziente", "Chief complaint"),
	CODED_PHYSICAL_EXAM("29545-1", "phex", "Diagnostische Untersuchungen", "Examen physique", "Esami diagnostici", "Physical Examination"),
	CODED_VITAL_SIGNS("8716-3", "cvit", "Codierte Vitalzeichenliste", "Signes vitaux codifiés", "Elenco codificato dei segni vitali", "Coded Vital Signs"),
	CURRENT_MEDICATIONS("10160-0", "cmed", "Aktuelle Medikation", "Médicaments actuels", "Medicamenti attuali", "Current Medications"),
	ED_CONSULTATIONS("18693-2", "edcon", "Konsultationen in der Notfallstation", "Consultations aux urgences", "Consultazioni al pronto soccorso", "Consultations"),
	ED_DIAGNOSIS("11301-9", "eddia", "Notfalldiagnosen", "Diagnostics aux urgences", "Diagnosi in urgenza", "ED Diagnoses"),
	ED_DISPOSITION("11302-7", "eddis", "Angaben zum Austritt", "Données de sortie", "Indicazioni all'uscita", "ED Disposition"),
	FAMILY_MEDICAL_HISTORY("10157-6", "fahi", "Familien Anamnese", "Anamnèse familiale", "Anamnesi familiare", "Family Medical History"),
	HISTORY_OF_IMMUNIZATION("11369-6", "hoi", "Impfungen", "Vaccinations", "Vaccinazioni", "Immunizations"),
	HISTORY_OF_PAST_ILLNESS("11348-0","hipai", "Bisherige Krankheiten", "Antécédants médicaux", "Storia medica","History of Past Illness"),
	HISTORY_OF_PREGNANCIES("10162-6", "hop", "Schwangerschaften", "Grossesses", "Gravidanze", "Pregnancy History"),
	HISTORY_OF_PRESENT_ILLNESS("10164-2", "hipri", "Notfallanamnese", "Anamnèse actuelle", "Anamnesi del caso d'urgenza", "History of Present Illness"),
	HOSPITAL_DISCHARGE_MEDICATIONS("10183-2", "hodm", "Medikamente bei Austritt", "Médicaments à la sortie", "Medicamenti all'uscita", "Medications at Discharge"),
	INTRAVENOUS_FLUIDS_ADMINISTERED("57072-1", "ifa", "Verabreichte Infusionen", "Liquides intraveineux administrés", "Infusioni somministrate", "Intravenous Fluids Administered"),
	LIST_OF_SURGERIES("47519-4", "los", "Frühere Operationen", "Antécédents chirurgicaux", "Operazioni precedenti", "List of Surgeries"),
	MEDICATIONS_ADMINISTERED("18610-6", "mad", "Verabreichte Medikamente", "Médicaments administrés", "Medicamenti somministrati", "Medications administered"),
	MODE_OF_ARRIVAL("11459-5", "moa", "Angaben zum Eintritt", "Mode de transport", "Indicazioni sull'entrata", "Transport Mode"),
	PROCEDURES("29544-3", "pr", "Prozedere", "Interventions effectuées", "Trattamenti eseguiti", "Procedures Performed"),
	PROGRESS_NOTE("18733-6", "pn", "Genesungsfortschritt", "Notes de suite", "Decorso", "Progress Note"),
	REASON_FOR_VISIT("29299-5", "rfv", "Grund des Patienten für Besuch", "Motif de consultation du patient", "Motivo della visita del paziente", "Reason for visit"),
	REFERRAL_SOURCE("11293-8", "rs", "Einweisung durch", "Admission par", "Ricovero tramite", "Referral Source"),
	REMARKS("48767-8", "k", "Kommentar", "Commentaire", "Osservazione", "Comment"),
	RESULTS("30954-2", "res", "Diagnostische Zusammenfassung","Résultats d'examens", "Riassunto degli esami diagnostici", "Test Results"),
	REVIEW_OF_SYSTEMS("10187-3", "ros", "Systemanamnese", "Anamnèse systématique", "Anamnesi sistemica", "Pertinent Review of Systems"),
	SOCIAL_HISTORY("29762-2", "sohi", "Sozial Anamnese", "Anamnèse sociale", "Anamnesi sociale", "Social History");
	//@formatter:on

	public static SectionsEDES getEnum(Section section) {
		CE code = section.getCode();
		if (code != null) {
			for (SectionsEDES sectionsEDES : values()) {
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

	public Section createSection() {
		switch (name()) {
		case "ABILITY_TO_WORK":
			return CHFactory.eINSTANCE.createAbilityToWorkSection().init();
		case "ACTIVE_PROBLEMS":
			return IHEFactory.eINSTANCE.createActiveProblemsSection().init();
		case "ACUITY_ASSESSMENT":
			return PCCFactory.eINSTANCE.createAcuityAssessmentSection().init();
		case "ADVANCE_DIRECTIVES":
			return IHEFactory.eINSTANCE.createAdvanceDirectivesSection().init();
		case "ALLERGIES_AND_OTHER_ADVERSE_REACTIONS":
			return IHEFactory.eINSTANCE.createAllergiesReactionsSection().init();
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
			return IHEFactory.eINSTANCE.createMedicationsSection().init();
		case "ED_CONSULTATIONS":
			return PCCFactory.eINSTANCE.createConsultationsSection().init();
		case "ED_DIAGNOSIS":
			return PCCFactory.eINSTANCE.createEDDiagnosesSection().init();
		case "ED_DISPOSITION":
			return PCCFactory.eINSTANCE.createEDDispositionSection().init();
		case "FAMILY_MEDICAL_HISTORY":
			return IHEFactory.eINSTANCE.createFamilyMedicalHistorySection().init();
		case "HISTORY_OF_PAST_ILLNESS":
			return IHEFactory.eINSTANCE.createHistoryOfPastIllnessSection().init();
		case "HISTORY_OF_PREGNANCIES":
			return IHEFactory.eINSTANCE.createPregnancyHistorySection().init();
		case "HISTORY_OF_PRESENT_ILLNESS":
			return IHEFactory.eINSTANCE.createHistoryOfPresentIllness().init();
		case "HISTORY_OF_IMMUNIZATION":
			return IHEFactory.eINSTANCE.createImmunizationsSection().init();
		case "HOSPITAL_DISCHARGE_MEDICATIONS":
			return IHEFactory.eINSTANCE.createHospitalDischargeMedicationsSection().init();
		case "INTRAVENOUS_FLUIDS_ADMINISTERED":
			return PCCFactory.eINSTANCE.createIntravenousFluidsAdministeredSection().init();
		case "LIST_OF_SURGERIES":
			return IHEFactory.eINSTANCE.createSurgeriesSection().init();
		case "MEDICATIONS_ADMINISTERED":
			return IHEFactory.eINSTANCE.createMedicationsAdministeredSection().init();
		case "MODE_OF_ARRIVAL":
			return PCCFactory.eINSTANCE.createModeOfArrivalSection().init();
		case "CODED_PHYSICAL_EXAM":
			return IHEFactory.eINSTANCE.createPhysicalExamSection().init();
		case "PROCEDURES":
			return IHEFactory.eINSTANCE.createProceduresAndInterventionsSection().init();
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

	public String getLoincCode() {
		return loincCode;
	}

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

	public String getSectionTitleDe() {
		return sectionTitleDe;
	}

	public String getSectionTitleEn() {
		return sectionTitleEn;
	}

	public String getSectionTitleFr() {
		return sectionTitleFr;
	}

	public String getSectionTitleIt() {
		return sectionTitleIt;
	}
}
