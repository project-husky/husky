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
 * Enumeration of HCProfessional.hcProfession values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.8.1<br>
 * Effective date: 2020-04-23 12:36<br>
 * Version: 202004.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum HcpProfession implements ValueSetEnumInterface {

    /**
     * EN: Activation Therapy Specialist<br>
     * DE: Aktivierungsfachfrau/Aktivierungsfachmann<br>
     * FR: Spécialiste en activation<br>
     * IT: Specialista in attivazione<br>
     */
    ACTIVATION_THERAPY_SPECIALIST("00100",
                                  "2.16.756.5.30.1.127.3.10.9",
                                  "Aktivierungsfachfrau/Aktivierungsfachmann",
                                  "Activation Therapy Specialist",
                                  "Aktivierungsfachfrau/Aktivierungsfachmann",
                                  "Spécialiste en activation",
                                  "Specialista in attivazione"),
    /**
     * EN: Biomedical analyst<br>
     * DE: Biomedizinische Analytikerin/Biomedizinischer Analytiker<br>
     * FR: Analyste biomédical<br>
     * IT: Tecnica in analisi biomediche/Tecnico in analisi biomediche<br>
     */
    BIOMEDICAL_ANALYST("00300",
                       "2.16.756.5.30.1.127.3.10.9",
                       "Biomedizinische Analytikerin/Biomedizinischer Analytiker",
                       "Biomedical analyst",
                       "Biomedizinische Analytikerin/Biomedizinischer Analytiker",
                       "Analyste biomédical",
                       "Tecnica in analisi biomediche/Tecnico in analisi biomediche"),
    /**
     * EN: Chiropractor<br>
     * DE: Chiropraktikerin/Chiropraktiker<br>
     * FR: Chiropracteur<br>
     * IT: Chiropratico<br>
     */
    CHIROPRACTOR("3842006",
                 "2.16.840.1.113883.6.96",
                 "Chiropractor (occupation)",
                 "Chiropractor",
                 "Chiropraktikerin/Chiropraktiker",
                 "Chiropracteur",
                 "Chiropratico"),
    /**
     * EN: Dental hygienist<br>
     * DE: Dentalhygienikerin/Dentalhygieniker<br>
     * FR: Hygiéniste dentaire<br>
     * IT: Igienista dentale<br>
     */
    DENTAL_HYGIENIST("00400",
                     "2.16.756.5.30.1.127.3.10.9",
                     "Dental hygienist",
                     "Dental hygienist",
                     "Dentalhygienikerin/Dentalhygieniker",
                     "Hygiéniste dentaire",
                     "Igienista dentale"),
    /**
     * EN: Dentist<br>
     * DE: Zahnärztin/Zahnarzt<br>
     * FR: Dentiste<br>
     * IT: Dentista<br>
     */
    DENTIST("106289002",
            "2.16.840.1.113883.6.96",
            "Dentist (occupation)",
            "Dentist",
            "Zahnärztin/Zahnarzt",
            "Dentiste",
            "Dentista"),
    /**
     * EN: Dietitian<br>
     * DE: Ernährungsberaterin/Ernährungsberater<br>
     * FR: Diététicien<br>
     * IT: Dietista<br>
     */
    DIETITIAN("159033005",
              "2.16.840.1.113883.6.96",
              "Dietitian (occupation)",
              "Dietitian",
              "Ernährungsberaterin/Ernährungsberater",
              "Diététicien",
              "Dietista"),
    /**
     * EN: Druggist<br>
     * DE: Drogist/Drogistin<br>
     * FR: Droguiste<br>
     * IT: Droghiere/a<br>
     */
    DRUGGIST("00500",
             "2.16.756.5.30.1.127.3.10.9",
             "Drogist/Drogistin",
             "Druggist",
             "Drogist/Drogistin",
             "Droguiste",
             "Droghiere/a"),
    /**
     * EN: Healthcare assistant<br>
     * DE: Fachfrau Gesundheit/Fachmann Gesundheit<br>
     * FR: Assistant/e en soins et santé communautaire<br>
     * IT: Operatrice sociosanitaria/Operatore sociosanitario<br>
     */
    HEALTHCARE_ASSISTANT("00700",
                         "2.16.756.5.30.1.127.3.10.9",
                         "Fachfrau Gesundheit/Fachmann Gesundheit",
                         "Healthcare assistant",
                         "Fachfrau Gesundheit/Fachmann Gesundheit",
                         "Assistant/e en soins et santé communautaire",
                         "Operatrice sociosanitaria/Operatore sociosanitario"),
    /**
     * EN: Medical Masseur<br>
     * DE: Medizinische Masseurin/Medizinischer Masseur<br>
     * FR: Masseur médical/masseuse médicale<br>
     * IT: Massaggiatrice medicale/Massaggiatore medicale<br>
     */
    MEDICAL_MASSEUR("00900",
                    "2.16.756.5.30.1.127.3.10.9",
                    "Medizinische Masseurin/Medizinischer Masseur",
                    "Medical Masseur",
                    "Medizinische Masseurin/Medizinischer Masseur",
                    "Masseur médical/masseuse médicale",
                    "Massaggiatrice medicale/Massaggiatore medicale"),
    /**
     * EN: Medical-technical Radiology Assistant<br>
     * DE: Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie<br>
     * FR: Technicien/ne en radiologie médicale<br>
     * IT: Tecnica di radiologia medica/Tecnico di radiologia medica<br>
     */
    MEDICAL_TECHNICAL_RADIOLOGY_ASSISTANT("00600",
                                          "2.16.756.5.30.1.127.3.10.9",
                                          "Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie",
                                          "Medical-technical Radiology Assistant",
                                          "Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie",
                                          "Technicien/ne en radiologie médicale",
                                          "Tecnica di radiologia medica/Tecnico di radiologia medica"),
    /**
     * EN: Naturopathic Practitioner<br>
     * DE: Naturheilpraktikerin/Naturheilpraktiker<br>
     * FR: Naturopathe<br>
     * IT: Naturopata<br>
     */
    NATUROPATHIC_PRACTITIONER("01000",
                              "2.16.756.5.30.1.127.3.10.9",
                              "Naturheilpraktikerin/Naturheilpraktiker",
                              "Naturopathic Practitioner",
                              "Naturheilpraktikerin/Naturheilpraktiker",
                              "Naturopathe",
                              "Naturopata"),
    /**
     * EN: Occupational therapist<br>
     * DE: Ergotherapeutin/Ergotherapeut<br>
     * FR: Ergothérapeute<br>
     * IT: Ergoterapista<br>
     */
    OCCUPATIONAL_THERAPIST("80546007",
                           "2.16.840.1.113883.6.96",
                           "Occupational therapist (occupation)",
                           "Occupational therapist",
                           "Ergotherapeutin/Ergotherapeut",
                           "Ergothérapeute",
                           "Ergoterapista"),
    /**
     * EN: Operating Room Technician<br>
     * DE: Fachfrau Operationstechnik/Fachmann Operationstechnik<br>
     * FR: Technicien/ne en salle d’opération<br>
     * IT: Tecnica di sala operatoria/Tecnico di sala operatoria<br>
     */
    OPERATING_ROOM_TECHNICIAN("00800",
                              "2.16.756.5.30.1.127.3.10.9",
                              "Fachfrau Operationstechnik/Fachmann Operationstechnik",
                              "Operating Room Technician",
                              "Fachfrau Operationstechnik/Fachmann Operationstechnik",
                              "Technicien/ne en salle d’opération",
                              "Tecnica di sala operatoria/Tecnico di sala operatoria"),
    /**
     * EN: Optician<br>
     * DE: Optikerin/Optiker<br>
     * FR: Opticien<br>
     * IT: Ottico<br>
     */
    OPTICIAN("00200",
             "2.16.756.5.30.1.127.3.10.9",
             "Optician",
             "Optician",
             "Optikerin/Optiker",
             "Opticien",
             "Ottico"),
    /**
     * EN: Optometrist<br>
     * DE: Optometristin/Optometrist<br>
     * FR: Optométriste<br>
     * IT: Optometrista<br>
     */
    OPTOMETRIST("01100",
                "2.16.756.5.30.1.127.3.10.9",
                "Optometrist",
                "Optometrist",
                "Optometristin/Optometrist",
                "Optométriste",
                "Optometrista"),
    /**
     * EN: Orthoptist<br>
     * DE: Orthoptistin/ Orthoptist<br>
     * FR: Orthoptiste<br>
     * IT: Ortottista<br>
     */
    ORTHOPTIST("01200",
               "2.16.756.5.30.1.127.3.10.9",
               "Orthoptist",
               "Orthoptist",
               "Orthoptistin/ Orthoptist",
               "Orthoptiste",
               "Ortottista"),
    /**
     * EN: Osteopath<br>
     * DE: Osteopathin/Osteopath<br>
     * FR: Ostéopathe<br>
     * IT: Osteopata<br>
     */
    OSTEOPATH("01300",
              "2.16.756.5.30.1.127.3.10.9",
              "Osteopath",
              "Osteopath",
              "Osteopathin/Osteopath",
              "Ostéopathe",
              "Osteopata"),
    /**
     * EN: Other<br>
     * DE: Andere<br>
     * FR: Autre<br>
     * IT: Altro<br>
     */
    OTHER("00000",
          "2.16.756.5.30.1.127.3.10.9",
          "Other",
          "Other",
          "Andere",
          "Autre",
          "Altro"),
    /**
     * EN: Paramedic<br>
     * DE: Rettungssanitäterin/Rettungssanitäter<br>
     * FR: Ambulancier/Ambulancière<br>
     * IT: Soccorritrice/Soccorritore<br>
     */
    PARAMEDIC("01500",
              "2.16.756.5.30.1.127.3.10.9",
              "Rettungssanitäterin/Rettungssanitäter",
              "Paramedic",
              "Rettungssanitäterin/Rettungssanitäter",
              "Ambulancier/Ambulancière",
              "Soccorritrice/Soccorritore"),
    /**
     * EN: Pharmacist<br>
     * DE: Apothekerin/Apotheker<br>
     * FR: Pharmacien<br>
     * IT: Farmacista<br>
     */
    PHARMACIST("46255001",
               "2.16.840.1.113883.6.96",
               "Pharmacist (occupation)",
               "Pharmacist",
               "Apothekerin/Apotheker",
               "Pharmacien",
               "Farmacista"),
    /**
     * EN: Physician<br>
     * DE: Ärztin/Arzt<br>
     * FR: Médecin<br>
     * IT: Medico<br>
     */
    PHYSICIAN("309343006",
              "2.16.840.1.113883.6.96",
              "Physician (occupation)",
              "Physician",
              "Ärztin/Arzt",
              "Médecin",
              "Medico"),
    /**
     * EN: Physiotherapist<br>
     * DE: Physiotherapeutin/Physiotherapeut<br>
     * FR: Physiothérapeute<br>
     * IT: Fisioterapista<br>
     */
    PHYSIOTHERAPIST("36682004",
                    "2.16.840.1.113883.6.96",
                    "Physiotherapist (occupation)",
                    "Physiotherapist",
                    "Physiotherapeutin/Physiotherapeut",
                    "Physiothérapeute",
                    "Fisioterapista"),
    /**
     * EN: Podiatrist<br>
     * DE: Podologin/Podologe<br>
     * FR: Podologue<br>
     * IT: Podologa/Podologo<br>
     */
    PODIATRIST("01400",
               "2.16.756.5.30.1.127.3.10.9",
               "Podologin/Podologe",
               "Podiatrist",
               "Podologin/Podologe",
               "Podologue",
               "Podologa/Podologo"),
    /**
     * EN: Professional nurse<br>
     * DE: Pflegefachfrau/Pflegefachmann<br>
     * FR: Infirmière professionnelle<br>
     * IT: Infermiere diplomato<br>
     */
    PROFESSIONAL_NURSE("106292003",
                       "2.16.840.1.113883.6.96",
                       "Professional nurse (occupation)",
                       "Professional nurse",
                       "Pflegefachfrau/Pflegefachmann",
                       "Infirmière professionnelle",
                       "Infermiere diplomato"),
    /**
     * EN: Psychologist<br>
     * DE: Psychologin/Psychologe<br>
     * FR: Psychologue<br>
     * IT: Psicologo<br>
     */
    PSYCHOLOGIST("59944000",
                 "2.16.840.1.113883.6.96",
                 "Psychologist (occupation)",
                 "Psychologist",
                 "Psychologin/Psychologe",
                 "Psychologue",
                 "Psicologo"),
    /**
     * EN: Registered midwife<br>
     * DE: Registrierte Hebamme<br>
     * FR: Sage-femme agréée<br>
     * IT: Levatrice<br>
     */
    REGISTERED_MIDWIFE("309453006",
                       "2.16.840.1.113883.6.96",
                       "Registered midwife (occupation)",
                       "Registered midwife",
                       "Registrierte Hebamme",
                       "Sage-femme agréée",
                       "Levatrice"),
    /**
     * EN: Speech/language therapist<br>
     * DE: Sprachtherapeutin/Sprachtherapeut<br>
     * FR: Orthophoniste<br>
     * IT: Logopedista<br>
     */
    SPEECH_LANGUAGE_THERAPIST("159026005",
                              "2.16.840.1.113883.6.96",
                              "Speech/language therapist (occupation)",
                              "Speech/language therapist",
                              "Sprachtherapeutin/Sprachtherapeut",
                              "Orthophoniste",
                              "Logopedista");

    /**
     * EN: Code for Activation Therapy Specialist<br>
     * DE: Code für Aktivierungsfachfrau/Aktivierungsfachmann<br>
     * FR: Code de Spécialiste en activation<br>
     * IT: Code per Specialista in attivazione<br>
     */
    public static final String ACTIVATION_THERAPY_SPECIALIST_CODE = "00100";

    /**
     * EN: Code for Biomedical analyst<br>
     * DE: Code für Biomedizinische Analytikerin/Biomedizinischer Analytiker<br>
     * FR: Code de Analyste biomédical<br>
     * IT: Code per Tecnica in analisi biomediche/Tecnico in analisi biomediche<br>
     */
    public static final String BIOMEDICAL_ANALYST_CODE = "00300";

    /**
     * EN: Code for Chiropractor<br>
     * DE: Code für Chiropraktikerin/Chiropraktiker<br>
     * FR: Code de Chiropracteur<br>
     * IT: Code per Chiropratico<br>
     */
    public static final String CHIROPRACTOR_CODE = "3842006";

    /**
     * EN: Code for Dental hygienist<br>
     * DE: Code für Dentalhygienikerin/Dentalhygieniker<br>
     * FR: Code de Hygiéniste dentaire<br>
     * IT: Code per Igienista dentale<br>
     */
    public static final String DENTAL_HYGIENIST_CODE = "00400";

    /**
     * EN: Code for Dentist<br>
     * DE: Code für Zahnärztin/Zahnarzt<br>
     * FR: Code de Dentiste<br>
     * IT: Code per Dentista<br>
     */
    public static final String DENTIST_CODE = "106289002";

    /**
     * EN: Code for Dietitian<br>
     * DE: Code für Ernährungsberaterin/Ernährungsberater<br>
     * FR: Code de Diététicien<br>
     * IT: Code per Dietista<br>
     */
    public static final String DIETITIAN_CODE = "159033005";

    /**
     * EN: Code for Druggist<br>
     * DE: Code für Drogist/Drogistin<br>
     * FR: Code de Droguiste<br>
     * IT: Code per Droghiere/a<br>
     */
    public static final String DRUGGIST_CODE = "00500";

    /**
     * EN: Code for Healthcare assistant<br>
     * DE: Code für Fachfrau Gesundheit/Fachmann Gesundheit<br>
     * FR: Code de Assistant/e en soins et santé communautaire<br>
     * IT: Code per Operatrice sociosanitaria/Operatore sociosanitario<br>
     */
    public static final String HEALTHCARE_ASSISTANT_CODE = "00700";

    /**
     * EN: Code for Medical Masseur<br>
     * DE: Code für Medizinische Masseurin/Medizinischer Masseur<br>
     * FR: Code de Masseur médical/masseuse médicale<br>
     * IT: Code per Massaggiatrice medicale/Massaggiatore medicale<br>
     */
    public static final String MEDICAL_MASSEUR_CODE = "00900";

    /**
     * EN: Code for Medical-technical Radiology Assistant<br>
     * DE: Code für Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie<br>
     * FR: Code de Technicien/ne en radiologie médicale<br>
     * IT: Code per Tecnica di radiologia medica/Tecnico di radiologia medica<br>
     */
    public static final String MEDICAL_TECHNICAL_RADIOLOGY_ASSISTANT_CODE = "00600";

    /**
     * EN: Code for Naturopathic Practitioner<br>
     * DE: Code für Naturheilpraktikerin/Naturheilpraktiker<br>
     * FR: Code de Naturopathe<br>
     * IT: Code per Naturopata<br>
     */
    public static final String NATUROPATHIC_PRACTITIONER_CODE = "01000";

    /**
     * EN: Code for Occupational therapist<br>
     * DE: Code für Ergotherapeutin/Ergotherapeut<br>
     * FR: Code de Ergothérapeute<br>
     * IT: Code per Ergoterapista<br>
     */
    public static final String OCCUPATIONAL_THERAPIST_CODE = "80546007";

    /**
     * EN: Code for Operating Room Technician<br>
     * DE: Code für Fachfrau Operationstechnik/Fachmann Operationstechnik<br>
     * FR: Code de Technicien/ne en salle d’opération<br>
     * IT: Code per Tecnica di sala operatoria/Tecnico di sala operatoria<br>
     */
    public static final String OPERATING_ROOM_TECHNICIAN_CODE = "00800";

    /**
     * EN: Code for Optician<br>
     * DE: Code für Optikerin/Optiker<br>
     * FR: Code de Opticien<br>
     * IT: Code per Ottico<br>
     */
    public static final String OPTICIAN_CODE = "00200";

    /**
     * EN: Code for Optometrist<br>
     * DE: Code für Optometristin/Optometrist<br>
     * FR: Code de Optométriste<br>
     * IT: Code per Optometrista<br>
     */
    public static final String OPTOMETRIST_CODE = "01100";

    /**
     * EN: Code for Orthoptist<br>
     * DE: Code für Orthoptistin/ Orthoptist<br>
     * FR: Code de Orthoptiste<br>
     * IT: Code per Ortottista<br>
     */
    public static final String ORTHOPTIST_CODE = "01200";

    /**
     * EN: Code for Osteopath<br>
     * DE: Code für Osteopathin/Osteopath<br>
     * FR: Code de Ostéopathe<br>
     * IT: Code per Osteopata<br>
     */
    public static final String OSTEOPATH_CODE = "01300";

    /**
     * EN: Code for Other<br>
     * DE: Code für Andere<br>
     * FR: Code de Autre<br>
     * IT: Code per Altro<br>
     */
    public static final String OTHER_CODE = "00000";

    /**
     * EN: Code for Paramedic<br>
     * DE: Code für Rettungssanitäterin/Rettungssanitäter<br>
     * FR: Code de Ambulancier/Ambulancière<br>
     * IT: Code per Soccorritrice/Soccorritore<br>
     */
    public static final String PARAMEDIC_CODE = "01500";

    /**
     * EN: Code for Pharmacist<br>
     * DE: Code für Apothekerin/Apotheker<br>
     * FR: Code de Pharmacien<br>
     * IT: Code per Farmacista<br>
     */
    public static final String PHARMACIST_CODE = "46255001";

    /**
     * EN: Code for Physician<br>
     * DE: Code für Ärztin/Arzt<br>
     * FR: Code de Médecin<br>
     * IT: Code per Medico<br>
     */
    public static final String PHYSICIAN_CODE = "309343006";

    /**
     * EN: Code for Physiotherapist<br>
     * DE: Code für Physiotherapeutin/Physiotherapeut<br>
     * FR: Code de Physiothérapeute<br>
     * IT: Code per Fisioterapista<br>
     */
    public static final String PHYSIOTHERAPIST_CODE = "36682004";

    /**
     * EN: Code for Podiatrist<br>
     * DE: Code für Podologin/Podologe<br>
     * FR: Code de Podologue<br>
     * IT: Code per Podologa/Podologo<br>
     */
    public static final String PODIATRIST_CODE = "01400";

    /**
     * EN: Code for Professional nurse<br>
     * DE: Code für Pflegefachfrau/Pflegefachmann<br>
     * FR: Code de Infirmière professionnelle<br>
     * IT: Code per Infermiere diplomato<br>
     */
    public static final String PROFESSIONAL_NURSE_CODE = "106292003";

    /**
     * EN: Code for Psychologist<br>
     * DE: Code für Psychologin/Psychologe<br>
     * FR: Code de Psychologue<br>
     * IT: Code per Psicologo<br>
     */
    public static final String PSYCHOLOGIST_CODE = "59944000";

    /**
     * EN: Code for Registered midwife<br>
     * DE: Code für Registrierte Hebamme<br>
     * FR: Code de Sage-femme agréée<br>
     * IT: Code per Levatrice<br>
     */
    public static final String REGISTERED_MIDWIFE_CODE = "309453006";

    /**
     * EN: Code for Speech/language therapist<br>
     * DE: Code für Sprachtherapeutin/Sprachtherapeut<br>
     * FR: Code de Orthophoniste<br>
     * IT: Code per Logopedista<br>
     */
    public static final String SPEECH_LANGUAGE_THERAPIST_CODE = "159026005";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.8.1";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "HCProfessional.hcProfession";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
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
     * Checks if a given enum is part of this value set.
     *
     * @param enumName The name of the enum.
     * @return {@code true} if the name is found in this value set, {@code false} otherwise.
     */
    public static boolean isEnumOfValueSet(final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(HcpProfession.class,
                         enumName);
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Checks if a given code value is in this value set.
     *
     * @param codeValue The code value.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
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
     * Machine interpretable and (inside this class) unique code.
     */
    private String code;

    /**
     * Identifier of the referencing code system.
     */
    private String codeSystem;

    /**
     * The display names per language.
     */
    private Map<LanguageCode, String> displayNames;

    /**
     * Instantiates this enum with a given code and display names.
     *
     * @param code          The code value.
     * @param codeSystem    The code system (OID).
     * @param displayName   The default display name.
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    HcpProfession(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
        this.code = code;
        this.codeSystem = codeSystem;
        this.displayNames = new HashMap<>();
        this.displayNames.put(null,
                              displayName);
        this.displayNames.put(LanguageCode.ENGLISH,
                              displayNameEn);
        this.displayNames.put(LanguageCode.GERMAN,
                              displayNameDe);
        this.displayNames.put(LanguageCode.FRENCH,
                              displayNameFr);
        this.displayNames.put(LanguageCode.ITALIAN,
                              displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemName() {
        final CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
        if (cs != null) {
            return cs.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param. If there is no english translation, the default display name
     *      is returned.
     *
     * @param languageCode The language code to get the display name for.
     * @return the display name in the desired language. if language not found, display name in german will be returned.
     */
    @Override
    public String getDisplayName(final LanguageCode languageCode) {
        final String displayName = this.displayNames.get(languageCode);
        if (displayName == null && languageCode == LanguageCode.ENGLISH) {
            return this.displayNames.get(null);
        }
        return displayName;
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
