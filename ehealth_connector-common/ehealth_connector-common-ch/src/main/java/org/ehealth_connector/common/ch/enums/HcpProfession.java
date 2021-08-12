/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of HCProfessional.hcProfession values
 *
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.756.5.30.1.127.3.10.8.1
 * Effective date: 2020-04-23 12:36
 * Version: 202004.0-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-04-22")
public enum HcpProfession implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Activation Therapy Specialist</div>
	 * <div class="de">Aktivierungsfachfrau/Aktivierungsfachmann</div>
	 * <div class="fr">Spécialiste en activation</div>
	 * <div class="it">Specialista in attivazione</div>
	 * <!-- @formatter:on -->
	 */
	ACTIVATION_THERAPY_SPECIALIST("00100", "2.16.756.5.30.1.127.3.10.9",
			"Aktivierungsfachfrau/Aktivierungsfachmann", "Activation Therapy Specialist",
			"Aktivierungsfachfrau/Aktivierungsfachmann", "Spécialiste en activation",
			"Specialista in attivazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Biomedical analyst</div>
	 * <div class="de">Biomedizinische Analytikerin/Biomedizinischer Analytiker</div>
	 * <div class="fr">Analyste biomédical</div>
	 * <div class="it">Tecnica in analisi biomediche/Tecnico in analisi biomediche</div>
	 * <!-- @formatter:on -->
	 */
	BIOMEDICAL_ANALYST("00300", "2.16.756.5.30.1.127.3.10.9",
			"Biomedizinische Analytikerin/Biomedizinischer Analytiker", "Biomedical analyst",
			"Biomedizinische Analytikerin/Biomedizinischer Analytiker", "Analyste biomédical",
			"Tecnica in analisi biomediche/Tecnico in analisi biomediche"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chiropractor</div>
	 * <div class="de">Chiropraktikerin/Chiropraktiker</div>
	 * <div class="fr">Chiropracteur</div>
	 * <div class="it">Chiropratico</div>
	 * <!-- @formatter:on -->
	 */
	CHIROPRACTOR("3842006", "2.16.840.1.113883.6.96", "Chiropractor (occupation)", "Chiropractor",
			"Chiropraktikerin/Chiropraktiker", "Chiropracteur", "Chiropratico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dental hygienist</div>
	 * <div class="de">Dentalhygienikerin/Dentalhygieniker</div>
	 * <div class="fr">Hygiéniste dentaire</div>
	 * <div class="it">Igienista dentale</div>
	 * <!-- @formatter:on -->
	 */
	DENTAL_HYGIENIST("00400", "2.16.756.5.30.1.127.3.10.9", "Dental hygienist", "Dental hygienist",
			"Dentalhygienikerin/Dentalhygieniker", "Hygiéniste dentaire", "Igienista dentale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dentist</div>
	 * <div class="de">Zahnärztin/Zahnarzt</div>
	 * <div class="fr">Dentiste</div>
	 * <div class="it">Dentista</div>
	 * <!-- @formatter:on -->
	 */
	DENTIST("106289002", "2.16.840.1.113883.6.96", "Dentist (occupation)", "Dentist",
			"Zahnärztin/Zahnarzt", "Dentiste", "Dentista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dietitian</div>
	 * <div class="de">Ernährungsberaterin/Ernährungsberater</div>
	 * <div class="fr">Diététicien</div>
	 * <div class="it">Dietista</div>
	 * <!-- @formatter:on -->
	 */
	DIETITIAN("159033005", "2.16.840.1.113883.6.96", "Dietitian (occupation)", "Dietitian",
			"Ernährungsberaterin/Ernährungsberater", "Diététicien", "Dietista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Druggist</div>
	 * <div class="de">Drogist/Drogistin</div>
	 * <div class="fr">Droguiste</div>
	 * <div class="it">Droghiere/a</div>
	 * <!-- @formatter:on -->
	 */
	DRUGGIST("00500", "2.16.756.5.30.1.127.3.10.9", "Drogist/Drogistin", "Druggist",
			"Drogist/Drogistin", "Droguiste", "Droghiere/a"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Healthcare assistant</div>
	 * <div class="de">Fachfrau Gesundheit/Fachmann Gesundheit</div>
	 * <div class="fr">Assistant/e en soins et santé communautaire</div>
	 * <div class="it">Operatrice sociosanitaria/Operatore sociosanitario</div>
	 * <!-- @formatter:on -->
	 */
	HEALTHCARE_ASSISTANT("00700", "2.16.756.5.30.1.127.3.10.9",
			"Fachfrau Gesundheit/Fachmann Gesundheit", "Healthcare assistant",
			"Fachfrau Gesundheit/Fachmann Gesundheit",
			"Assistant/e en soins et santé communautaire",
			"Operatrice sociosanitaria/Operatore sociosanitario"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical Masseur</div>
	 * <div class="de">Medizinische Masseurin/Medizinischer Masseur</div>
	 * <div class="fr">Masseur médical/masseuse médicale</div>
	 * <div class="it">Massaggiatrice medicale/Massaggiatore medicale</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_MASSEUR("00900", "2.16.756.5.30.1.127.3.10.9",
			"Medizinische Masseurin/Medizinischer Masseur", "Medical Masseur",
			"Medizinische Masseurin/Medizinischer Masseur", "Masseur médical/masseuse médicale",
			"Massaggiatrice medicale/Massaggiatore medicale"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical-technical Radiology Assistant</div>
	 * <div class="de">Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie</div>
	 * <div class="fr">Technicien/ne en radiologie médicale</div>
	 * <div class="it">Tecnica di radiologia medica/Tecnico di radiologia medica</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_TECHNICAL_RADIOLOGY_ASSISTANT("00600", "2.16.756.5.30.1.127.3.10.9",
			"Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie",
			"Medical-technical Radiology Assistant",
			"Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie",
			"Technicien/ne en radiologie médicale",
			"Tecnica di radiologia medica/Tecnico di radiologia medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Naturopathic Practitioner</div>
	 * <div class="de">Naturheilpraktikerin/Naturheilpraktiker</div>
	 * <div class="fr">Naturopathe</div>
	 * <div class="it">Naturopata</div>
	 * <!-- @formatter:on -->
	 */
	NATUROPATHIC_PRACTITIONER("01000", "2.16.756.5.30.1.127.3.10.9",
			"Naturheilpraktikerin/Naturheilpraktiker", "Naturopathic Practitioner",
			"Naturheilpraktikerin/Naturheilpraktiker", "Naturopathe", "Naturopata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Occupational therapist</div>
	 * <div class="de">Ergotherapeutin/Ergotherapeut</div>
	 * <div class="fr">Ergothérapeute</div>
	 * <div class="it">Ergoterapista</div>
	 * <!-- @formatter:on -->
	 */
	OCCUPATIONAL_THERAPIST("80546007", "2.16.840.1.113883.6.96",
			"Occupational therapist (occupation)", "Occupational therapist",
			"Ergotherapeutin/Ergotherapeut", "Ergothérapeute", "Ergoterapista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Operating Room Technician</div>
	 * <div class="de">Fachfrau Operationstechnik/Fachmann Operationstechnik</div>
	 * <div class="fr">Technicien/ne en salle d’opération</div>
	 * <div class="it">Tecnica di sala operatoria/Tecnico di sala operatoria</div>
	 * <!-- @formatter:on -->
	 */
	OPERATING_ROOM_TECHNICIAN("00800", "2.16.756.5.30.1.127.3.10.9",
			"Fachfrau Operationstechnik/Fachmann Operationstechnik", "Operating Room Technician",
			"Fachfrau Operationstechnik/Fachmann Operationstechnik",
			"Technicien/ne en salle d’opération",
			"Tecnica di sala operatoria/Tecnico di sala operatoria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Optician</div>
	 * <div class="de">Optikerin/Optiker</div>
	 * <div class="fr">Opticien</div>
	 * <div class="it">Ottico</div>
	 * <!-- @formatter:on -->
	 */
	OPTICIAN("00200", "2.16.756.5.30.1.127.3.10.9", "Optician", "Optician", "Optikerin/Optiker",
			"Opticien", "Ottico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Optometrist</div>
	 * <div class="de">Optometristin/Optometrist</div>
	 * <div class="fr">Optométriste</div>
	 * <div class="it">Optometrista</div>
	 * <!-- @formatter:on -->
	 */
	OPTOMETRIST("01100", "2.16.756.5.30.1.127.3.10.9", "Optometrist", "Optometrist",
			"Optometristin/Optometrist", "Optométriste", "Optometrista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orthoptist</div>
	 * <div class="de">Orthoptistin/ Orthoptist</div>
	 * <div class="fr">Orthoptiste</div>
	 * <div class="it">Ortottista</div>
	 * <!-- @formatter:on -->
	 */
	ORTHOPTIST("01200", "2.16.756.5.30.1.127.3.10.9", "Orthoptist", "Orthoptist",
			"Orthoptistin/ Orthoptist", "Orthoptiste", "Ortottista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Osteopath</div>
	 * <div class="de">Osteopathin/Osteopath</div>
	 * <div class="fr">Ostéopathe</div>
	 * <div class="it">Osteopata</div>
	 * <!-- @formatter:on -->
	 */
	OSTEOPATH("01300", "2.16.756.5.30.1.127.3.10.9", "Osteopath", "Osteopath",
			"Osteopathin/Osteopath", "Ostéopathe", "Osteopata"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Other</div>
	 * <div class="de">Andere</div>
	 * <div class="fr">Autre</div>
	 * <div class="it">Altro</div>
	 * <!-- @formatter:on -->
	 */
	OTHER("00000", "2.16.756.5.30.1.127.3.10.9", "Other", "Other", "Andere", "Autre", "Altro"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paramedic</div>
	 * <div class="de">Rettungssanitäterin/Rettungssanitäter</div>
	 * <div class="fr">Ambulancier/Ambulancière</div>
	 * <div class="it">Soccorritrice/Soccorritore</div>
	 * <!-- @formatter:on -->
	 */
	PARAMEDIC("01500", "2.16.756.5.30.1.127.3.10.9", "Rettungssanitäterin/Rettungssanitäter",
			"Paramedic", "Rettungssanitäterin/Rettungssanitäter", "Ambulancier/Ambulancière",
			"Soccorritrice/Soccorritore"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmacist</div>
	 * <div class="de">Apothekerin/Apotheker</div>
	 * <div class="fr">Pharmacien</div>
	 * <div class="it">Farmacista</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACIST("46255001", "2.16.840.1.113883.6.96", "Pharmacist (occupation)", "Pharmacist",
			"Apothekerin/Apotheker", "Pharmacien", "Farmacista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Physician</div>
	 * <div class="de">Ärztin/Arzt</div>
	 * <div class="fr">Médecin</div>
	 * <div class="it">Medico</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICIAN("309343006", "2.16.840.1.113883.6.96", "Physician (occupation)", "Physician",
			"Ärztin/Arzt", "Médecin", "Medico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Physiotherapist</div>
	 * <div class="de">Physiotherapeutin/Physiotherapeut</div>
	 * <div class="fr">Physiothérapeute</div>
	 * <div class="it">Fisioterapista</div>
	 * <!-- @formatter:on -->
	 */
	PHYSIOTHERAPIST("36682004", "2.16.840.1.113883.6.96", "Physiotherapist (occupation)",
			"Physiotherapist", "Physiotherapeutin/Physiotherapeut", "Physiothérapeute",
			"Fisioterapista"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Podiatrist</div>
	 * <div class="de">Podologin/Podologe</div>
	 * <div class="fr">Podologue</div>
	 * <div class="it">Podologa/Podologo</div>
	 * <!-- @formatter:on -->
	 */
	PODIATRIST("01400", "2.16.756.5.30.1.127.3.10.9", "Podologin/Podologe", "Podiatrist",
			"Podologin/Podologe", "Podologue", "Podologa/Podologo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Professional nurse</div>
	 * <div class="de">Pflegefachfrau/Pflegefachmann</div>
	 * <div class="fr">Infirmière professionnelle</div>
	 * <div class="it">Infermiere diplomato</div>
	 * <!-- @formatter:on -->
	 */
	PROFESSIONAL_NURSE("106292003", "2.16.840.1.113883.6.96", "Professional nurse (occupation)",
			"Professional nurse", "Pflegefachfrau/Pflegefachmann", "Infirmière professionnelle",
			"Infermiere diplomato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychologist</div>
	 * <div class="de">Psychologin/Psychologe</div>
	 * <div class="fr">Psychologue</div>
	 * <div class="it">Psicologo</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHOLOGIST("59944000", "2.16.840.1.113883.6.96", "Psychologist (occupation)", "Psychologist",
			"Psychologin/Psychologe", "Psychologue", "Psicologo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Registered midwife</div>
	 * <div class="de">Registrierte Hebamme</div>
	 * <div class="fr">Sage-femme agréée</div>
	 * <div class="it">Levatrice</div>
	 * <!-- @formatter:on -->
	 */
	REGISTERED_MIDWIFE("309453006", "2.16.840.1.113883.6.96", "Registered midwife (occupation)",
			"Registered midwife", "Registrierte Hebamme", "Sage-femme agréée", "Levatrice"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Speech/language therapist</div>
	 * <div class="de">Sprachtherapeutin/Sprachtherapeut</div>
	 * <div class="fr">Orthophoniste</div>
	 * <div class="it">Logopedista</div>
	 * <!-- @formatter:on -->
	 */
	SPEECH_LANGUAGE_THERAPIST("159026005", "2.16.840.1.113883.6.96",
			"Speech/language therapist (occupation)", "Speech/language therapist",
			"Sprachtherapeutin/Sprachtherapeut", "Orthophoniste", "Logopedista");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Activation Therapy Specialist</div>
	 * <div class="de">Code für Aktivierungsfachfrau/Aktivierungsfachmann</div>
	 * <div class="fr">Code de Spécialiste en activation</div>
	 * <div class="it">Code per Specialista in attivazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACTIVATION_THERAPY_SPECIALIST_CODE = "00100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Biomedical analyst</div>
	 * <div class="de">Code für Biomedizinische Analytikerin/Biomedizinischer Analytiker</div>
	 * <div class="fr">Code de Analyste biomédical</div>
	 * <div class="it">Code per Tecnica in analisi biomediche/Tecnico in analisi biomediche</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BIOMEDICAL_ANALYST_CODE = "00300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chiropractor</div>
	 * <div class="de">Code für Chiropraktikerin/Chiropraktiker</div>
	 * <div class="fr">Code de Chiropracteur</div>
	 * <div class="it">Code per Chiropratico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHIROPRACTOR_CODE = "3842006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dental hygienist</div>
	 * <div class="de">Code für Dentalhygienikerin/Dentalhygieniker</div>
	 * <div class="fr">Code de Hygiéniste dentaire</div>
	 * <div class="it">Code per Igienista dentale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTAL_HYGIENIST_CODE = "00400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dentist</div>
	 * <div class="de">Code für Zahnärztin/Zahnarzt</div>
	 * <div class="fr">Code de Dentiste</div>
	 * <div class="it">Code per Dentista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTIST_CODE = "106289002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dietitian</div>
	 * <div class="de">Code für Ernährungsberaterin/Ernährungsberater</div>
	 * <div class="fr">Code de Diététicien</div>
	 * <div class="it">Code per Dietista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIETITIAN_CODE = "159033005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Druggist</div>
	 * <div class="de">Code für Drogist/Drogistin</div>
	 * <div class="fr">Code de Droguiste</div>
	 * <div class="it">Code per Droghiere/a</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DRUGGIST_CODE = "00500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Healthcare assistant</div>
	 * <div class="de">Code für Fachfrau Gesundheit/Fachmann Gesundheit</div>
	 * <div class="fr">Code de Assistant/e en soins et santé communautaire</div>
	 * <div class="it">Code per Operatrice sociosanitaria/Operatore sociosanitario</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEALTHCARE_ASSISTANT_CODE = "00700";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical Masseur</div>
	 * <div class="de">Code für Medizinische Masseurin/Medizinischer Masseur</div>
	 * <div class="fr">Code de Masseur médical/masseuse médicale</div>
	 * <div class="it">Code per Massaggiatrice medicale/Massaggiatore medicale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_MASSEUR_CODE = "00900";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical-technical Radiology Assistant</div>
	 * <div class="de">Code für Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie</div>
	 * <div class="fr">Code de Technicien/ne en radiologie médicale</div>
	 * <div class="it">Code per Tecnica di radiologia medica/Tecnico di radiologia medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_TECHNICAL_RADIOLOGY_ASSISTANT_CODE = "00600";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Naturopathic Practitioner</div>
	 * <div class="de">Code für Naturheilpraktikerin/Naturheilpraktiker</div>
	 * <div class="fr">Code de Naturopathe</div>
	 * <div class="it">Code per Naturopata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NATUROPATHIC_PRACTITIONER_CODE = "01000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Occupational therapist</div>
	 * <div class="de">Code für Ergotherapeutin/Ergotherapeut</div>
	 * <div class="fr">Code de Ergothérapeute</div>
	 * <div class="it">Code per Ergoterapista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OCCUPATIONAL_THERAPIST_CODE = "80546007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Operating Room Technician</div>
	 * <div class="de">Code für Fachfrau Operationstechnik/Fachmann Operationstechnik</div>
	 * <div class="fr">Code de Technicien/ne en salle d’opération</div>
	 * <div class="it">Code per Tecnica di sala operatoria/Tecnico di sala operatoria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPERATING_ROOM_TECHNICIAN_CODE = "00800";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Optician</div>
	 * <div class="de">Code für Optikerin/Optiker</div>
	 * <div class="fr">Code de Opticien</div>
	 * <div class="it">Code per Ottico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPTICIAN_CODE = "00200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Optometrist</div>
	 * <div class="de">Code für Optometristin/Optometrist</div>
	 * <div class="fr">Code de Optométriste</div>
	 * <div class="it">Code per Optometrista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPTOMETRIST_CODE = "01100";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orthoptist</div>
	 * <div class="de">Code für Orthoptistin/ Orthoptist</div>
	 * <div class="fr">Code de Orthoptiste</div>
	 * <div class="it">Code per Ortottista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORTHOPTIST_CODE = "01200";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Osteopath</div>
	 * <div class="de">Code für Osteopathin/Osteopath</div>
	 * <div class="fr">Code de Ostéopathe</div>
	 * <div class="it">Code per Osteopata</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OSTEOPATH_CODE = "01300";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Other</div>
	 * <div class="de">Code für Andere</div>
	 * <div class="fr">Code de Autre</div>
	 * <div class="it">Code per Altro</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTHER_CODE = "00000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paramedic</div>
	 * <div class="de">Code für Rettungssanitäterin/Rettungssanitäter</div>
	 * <div class="fr">Code de Ambulancier/Ambulancière</div>
	 * <div class="it">Code per Soccorritrice/Soccorritore</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARAMEDIC_CODE = "01500";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmacist</div>
	 * <div class="de">Code für Apothekerin/Apotheker</div>
	 * <div class="fr">Code de Pharmacien</div>
	 * <div class="it">Code per Farmacista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACIST_CODE = "46255001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Physician</div>
	 * <div class="de">Code für Ärztin/Arzt</div>
	 * <div class="fr">Code de Médecin</div>
	 * <div class="it">Code per Medico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICIAN_CODE = "309343006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Physiotherapist</div>
	 * <div class="de">Code für Physiotherapeutin/Physiotherapeut</div>
	 * <div class="fr">Code de Physiothérapeute</div>
	 * <div class="it">Code per Fisioterapista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSIOTHERAPIST_CODE = "36682004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Podiatrist</div>
	 * <div class="de">Code für Podologin/Podologe</div>
	 * <div class="fr">Code de Podologue</div>
	 * <div class="it">Code per Podologa/Podologo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PODIATRIST_CODE = "01400";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Professional nurse</div>
	 * <div class="de">Code für Pflegefachfrau/Pflegefachmann</div>
	 * <div class="fr">Code de Infirmière professionnelle</div>
	 * <div class="it">Code per Infermiere diplomato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROFESSIONAL_NURSE_CODE = "106292003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychologist</div>
	 * <div class="de">Code für Psychologin/Psychologe</div>
	 * <div class="fr">Code de Psychologue</div>
	 * <div class="it">Code per Psicologo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHOLOGIST_CODE = "59944000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Registered midwife</div>
	 * <div class="de">Code für Registrierte Hebamme</div>
	 * <div class="fr">Code de Sage-femme agréée</div>
	 * <div class="it">Code per Levatrice</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REGISTERED_MIDWIFE_CODE = "309453006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Speech/language therapist</div>
	 * <div class="de">Code für Sprachtherapeutin/Sprachtherapeut</div>
	 * <div class="fr">Code de Orthophoniste</div>
	 * <div class="it">Code per Logopedista</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPEECH_LANGUAGE_THERAPIST_CODE = "159026005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.8.1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "HCProfessional.hcProfession";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static HcpProfession getEnum(final String code) {
		for (final HcpProfession x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(final String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(HcpProfession.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(final String codeValue) {
		for (final HcpProfession x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	HcpProfession(final String code, final String codeSystem, final String displayName,
			final String displayNameEn, final String displayNameDe, final String displayNameFr,
			final String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayNames = new HashMap<>();
		this.displayNames.put(null, displayName);
		this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
		this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
		this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
