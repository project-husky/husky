/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.common.ch.enums.stable;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of HCProfessional.hcProfession values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.8.1<br>
 * Effective date: 2022-06-26 15:48<br>
 * Version: 202306.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-02")
public enum HcpProfession implements ValueSetEnumInterface {

    /**
     * EN: Activation therapy specialist.<br>
     * DE: Fachperson für Aktivierung.<br>
     * FR: spécialiste de l'activation.<br>
     * IT: specialista in attivazione.<br>
     */
    ACTIVATION_THERAPY_SPECIALIST("00100",
                                  "2.16.756.5.30.1.127.3.10.9",
                                  "Aktivierungsfachfrau/Aktivierungsfachmann",
                                  "Activation therapy specialist",
                                  "Fachperson für Aktivierung",
                                  "spécialiste de l'activation",
                                  "specialista in attivazione"),
    /**
     * EN: Biomedical analyst.<br>
     * DE: Biomedizinischer Analytiker/Biomedizinische Analytikerin.<br>
     * FR: technicien(ne) en analyses biomédicales.<br>
     * IT: tecnico(-a) in analisi biomediche.<br>
     */
    BIOMEDICAL_ANALYST("00300",
                       "2.16.756.5.30.1.127.3.10.9",
                       "Biomedizinische Analytikerin/Biomedizinischer Analytiker",
                       "Biomedical analyst",
                       "Biomedizinischer Analytiker/Biomedizinische Analytikerin",
                       "technicien(ne) en analyses biomédicales",
                       "tecnico(-a) in analisi biomediche"),
    /**
     * EN: Chiropractor.<br>
     * DE: Chiropraktiker/Chiropraktikerin.<br>
     * FR: chiropraticien(ne).<br>
     * IT: chiropratico(-a).<br>
     */
    CHIROPRACTOR("3842006",
                 "2.16.840.1.113883.6.96",
                 "Chiropractor (occupation)",
                 "Chiropractor",
                 "Chiropraktiker/Chiropraktikerin",
                 "chiropraticien(ne)",
                 "chiropratico(-a)"),
    /**
     * EN: Dental hygienist.<br>
     * DE: Dentalhygieniker/Dentalhygienikerin.<br>
     * FR: hygiéniste dentaire.<br>
     * IT: igienista dentale.<br>
     */
    DENTAL_HYGIENIST("00400",
                     "2.16.756.5.30.1.127.3.10.9",
                     "Dental hygienist",
                     "Dental hygienist",
                     "Dentalhygieniker/Dentalhygienikerin",
                     "hygiéniste dentaire",
                     "igienista dentale"),
    /**
     * EN: Dentist.<br>
     * DE: Zahnarzt/Zahnärztin.<br>
     * FR: dentiste.<br>
     * IT: dentista.<br>
     */
    DENTIST("106289002",
            "2.16.840.1.113883.6.96",
            "Dentist (occupation)",
            "Dentist",
            "Zahnarzt/Zahnärztin",
            "dentiste",
            "dentista"),
    /**
     * EN: Dietitian.<br>
     * DE: Ernährungsberater/Ernährungsberaterin.<br>
     * FR: diététicien(ne).<br>
     * IT: dietista.<br>
     */
    DIETITIAN("159033005",
              "2.16.840.1.113883.6.96",
              "Dietitian (occupation)",
              "Dietitian",
              "Ernährungsberater/Ernährungsberaterin",
              "diététicien(ne)",
              "dietista"),
    /**
     * EN: Druggist.<br>
     * DE: Drogist/Drogistin.<br>
     * FR: droguiste.<br>
     * IT: droghiere(-a).<br>
     */
    DRUGGIST("00500",
             "2.16.756.5.30.1.127.3.10.9",
             "Drogist/Drogistin",
             "Druggist",
             "Drogist/Drogistin",
             "droguiste",
             "droghiere(-a)"),
    /**
     * EN: Healthcare assistant.<br>
     * DE: Fachperson Gesundheit.<br>
     * FR: assistant(e) en soins et santé communautaire.<br>
     * IT: operatore(-trice) sociosanitario.<br>
     */
    HEALTHCARE_ASSISTANT("00700",
                         "2.16.756.5.30.1.127.3.10.9",
                         "Fachfrau Gesundheit/Fachmann Gesundheit",
                         "Healthcare assistant",
                         "Fachperson Gesundheit",
                         "assistant(e) en soins et santé communautaire",
                         "operatore(-trice) sociosanitario"),
    /**
     * EN: Medical masseur.<br>
     * DE: Medizinischer Masseur/Medizinische Masseurin.<br>
     * FR: masseur(-euse) médical.<br>
     * IT: massaggiatore(-trice) medicale.<br>
     */
    MEDICAL_MASSEUR("00900",
                    "2.16.756.5.30.1.127.3.10.9",
                    "Medizinische Masseurin/Medizinischer Masseur",
                    "Medical masseur",
                    "Medizinischer Masseur/Medizinische Masseurin",
                    "masseur(-euse) médical",
                    "massaggiatore(-trice) medicale"),
    /**
     * EN: Medical-technical radiology assistant.<br>
     * DE: Fachperson für medizinisch-technische Radiologie.<br>
     * FR: technicien(ne) en radiologie médicale.<br>
     * IT: tecnico(-a) di radiologia medica.<br>
     */
    MEDICAL_TECHNICAL_RADIOLOGY_ASSISTANT("00600",
                                          "2.16.756.5.30.1.127.3.10.9",
                                          "Fachfrau für medizinisch-technische Radiologie/Fachmann für medizinisch-technische Radiologie",
                                          "Medical-technical radiology assistant",
                                          "Fachperson für medizinisch-technische Radiologie",
                                          "technicien(ne) en radiologie médicale",
                                          "tecnico(-a) di radiologia medica"),
    /**
     * EN: Naturopathic practitioner.<br>
     * DE: Naturheilpraktiker/Naturheilpraktikerin.<br>
     * FR: naturopathe.<br>
     * IT: naturopata.<br>
     */
    NATUROPATHIC_PRACTITIONER("01000",
                              "2.16.756.5.30.1.127.3.10.9",
                              "Naturheilpraktikerin/Naturheilpraktiker",
                              "Naturopathic practitioner",
                              "Naturheilpraktiker/Naturheilpraktikerin",
                              "naturopathe",
                              "naturopata"),
    /**
     * EN: Occupational therapist.<br>
     * DE: Ergotherapeut/Ergotherapeutin.<br>
     * FR: ergothérapeute.<br>
     * IT: ergoterapista.<br>
     */
    OCCUPATIONAL_THERAPIST("80546007",
                           "2.16.840.1.113883.6.96",
                           "Occupational therapist (occupation)",
                           "Occupational therapist",
                           "Ergotherapeut/Ergotherapeutin",
                           "ergothérapeute",
                           "ergoterapista"),
    /**
     * EN: Operating room technician.<br>
     * DE: Fachperson Operationstechnik.<br>
     * FR: technicien(ne) en salle d'opération.<br>
     * IT: tecnico(-a) di sala operatoria.<br>
     */
    OPERATING_ROOM_TECHNICIAN("00800",
                              "2.16.756.5.30.1.127.3.10.9",
                              "Fachfrau Operationstechnik/Fachmann Operationstechnik",
                              "Operating room technician",
                              "Fachperson Operationstechnik",
                              "technicien(ne) en salle d'opération",
                              "tecnico(-a) di sala operatoria"),
    /**
     * EN: Optician.<br>
     * DE: Optiker/Optikerin.<br>
     * FR: opticien(ne).<br>
     * IT: ottico(-a).<br>
     */
    OPTICIAN("00200",
             "2.16.756.5.30.1.127.3.10.9",
             "Optician",
             "Optician",
             "Optiker/Optikerin",
             "opticien(ne)",
             "ottico(-a)"),
    /**
     * EN: Optometrist.<br>
     * DE: Optometrist/Optometristin.<br>
     * FR: optométriste.<br>
     * IT: optometrista.<br>
     */
    OPTOMETRIST("01100",
                "2.16.756.5.30.1.127.3.10.9",
                "Optometrist",
                "Optometrist",
                "Optometrist/Optometristin",
                "optométriste",
                "optometrista"),
    /**
     * EN: orthoptist.<br>
     * DE: Orthoptist/Orthoptistin.<br>
     * FR: orthoptiste.<br>
     * IT: ortottista.<br>
     */
    ORTHOPTIST("01200",
               "2.16.756.5.30.1.127.3.10.9",
               "Orthoptist",
               "orthoptist",
               "Orthoptist/Orthoptistin",
               "orthoptiste",
               "ortottista"),
    /**
     * EN: Osteopath.<br>
     * DE: Osteopath/Osteopathin.<br>
     * FR: ostéopathe.<br>
     * IT: osteopata.<br>
     */
    OSTEOPATH("01300",
              "2.16.756.5.30.1.127.3.10.9",
              "Osteopath",
              "Osteopath",
              "Osteopath/Osteopathin",
              "ostéopathe",
              "osteopata"),
    /**
     * EN: Other.<br>
     * DE: Andere.<br>
     * FR: autre.<br>
     * IT: altro.<br>
     */
    OTHER("00000",
          "2.16.756.5.30.1.127.3.10.9",
          "Other",
          "Other",
          "Andere",
          "autre",
          "altro"),
    /**
     * EN: Paramedic.<br>
     * DE: Rettungssanitäter/Rettungssanitäterin.<br>
     * FR: ambulancier(-ère).<br>
     * IT: soccorritore(-trice).<br>
     */
    PARAMEDIC("01500",
              "2.16.756.5.30.1.127.3.10.9",
              "Rettungssanitäterin/Rettungssanitäter",
              "Paramedic",
              "Rettungssanitäter/Rettungssanitäterin",
              "ambulancier(-ère)",
              "soccorritore(-trice)"),
    /**
     * EN: Pharmacist.<br>
     * DE: Apotheker/Apothekerin.<br>
     * FR: pharmacien(ne).<br>
     * IT: farmacista.<br>
     */
    PHARMACIST("46255001",
               "2.16.840.1.113883.6.96",
               "Pharmacist (occupation)",
               "Pharmacist",
               "Apotheker/Apothekerin",
               "pharmacien(ne)",
               "farmacista"),
    /**
     * EN: Physician.<br>
     * DE: Arzt/Ärztin.<br>
     * FR: médecin.<br>
     * IT: medico.<br>
     */
    PHYSICIAN("309343006",
              "2.16.840.1.113883.6.96",
              "Physician (occupation)",
              "Physician",
              "Arzt/Ärztin",
              "médecin",
              "medico"),
    /**
     * EN: Physiotherapist.<br>
     * DE: Physiotherapeut/Physiotherapeutin.<br>
     * FR: physiothérapeute.<br>
     * IT: fisioterapista.<br>
     */
    PHYSIOTHERAPIST("36682004",
                    "2.16.840.1.113883.6.96",
                    "Physiotherapist (occupation)",
                    "Physiotherapist",
                    "Physiotherapeut/Physiotherapeutin",
                    "physiothérapeute",
                    "fisioterapista"),
    /**
     * EN: Podiatrist.<br>
     * DE: Podologe/Podologin.<br>
     * FR: podologue.<br>
     * IT: podologo(-a).<br>
     */
    PODIATRIST("01400",
               "2.16.756.5.30.1.127.3.10.9",
               "Podologin/Podologe",
               "Podiatrist",
               "Podologe/Podologin",
               "podologue",
               "podologo(-a)"),
    /**
     * EN: Professional nurse.<br>
     * DE: Pflegefachmann/Pflegefachfrau.<br>
     * FR: infirmier(-ère).<br>
     * IT: infermiere(-a).<br>
     */
    PROFESSIONAL_NURSE("106292003",
                       "2.16.840.1.113883.6.96",
                       "Professional nurse (occupation)",
                       "Professional nurse",
                       "Pflegefachmann/Pflegefachfrau",
                       "infirmier(-ère)",
                       "infermiere(-a)"),
    /**
     * EN: Psychologist.<br>
     * DE: Psychologe/Psychologin.<br>
     * FR: psychologue.<br>
     * IT: psicologo(-a).<br>
     */
    PSYCHOLOGIST("59944000",
                 "2.16.840.1.113883.6.96",
                 "Psychologist (occupation)",
                 "Psychologist",
                 "Psychologe/Psychologin",
                 "psychologue",
                 "psicologo(-a)"),
    /**
     * EN: Registered midwife.<br>
     * DE: Registrierte Hebamme.<br>
     * FR: sage-femme.<br>
     * IT: levatrice.<br>
     */
    REGISTERED_MIDWIFE("309453006",
                       "2.16.840.1.113883.6.96",
                       "Registered midwife (occupation)",
                       "Registered midwife",
                       "Registrierte Hebamme",
                       "sage-femme",
                       "levatrice"),
    /**
     * EN: Speech/language therapist.<br>
     * DE: Sprachtherapeut/Sprachtherapeutin.<br>
     * FR: orthophoniste.<br>
     * IT: logopedista.<br>
     */
    SPEECH_LANGUAGE_THERAPIST("159026005",
                              "2.16.840.1.113883.6.96",
                              "Speech/language therapist (occupation)",
                              "Speech/language therapist",
                              "Sprachtherapeut/Sprachtherapeutin",
                              "orthophoniste",
                              "logopedista");

    /**
     * EN: Code for Activation therapy specialist.<br>
     * DE: Code für Fachperson für Aktivierung.<br>
     * FR: Code de spécialiste de l'activation.<br>
     * IT: Code per specialista in attivazione.<br>
     */
    public static final String ACTIVATION_THERAPY_SPECIALIST_CODE = "00100";

    /**
     * EN: Code for Biomedical analyst.<br>
     * DE: Code für Biomedizinischer Analytiker/Biomedizinische Analytikerin.<br>
     * FR: Code de technicien(ne) en analyses biomédicales.<br>
     * IT: Code per tecnico(-a) in analisi biomediche.<br>
     */
    public static final String BIOMEDICAL_ANALYST_CODE = "00300";

    /**
     * EN: Code for Chiropractor.<br>
     * DE: Code für Chiropraktiker/Chiropraktikerin.<br>
     * FR: Code de chiropraticien(ne).<br>
     * IT: Code per chiropratico(-a).<br>
     */
    public static final String CHIROPRACTOR_CODE = "3842006";

    /**
     * EN: Code for Dental hygienist.<br>
     * DE: Code für Dentalhygieniker/Dentalhygienikerin.<br>
     * FR: Code de hygiéniste dentaire.<br>
     * IT: Code per igienista dentale.<br>
     */
    public static final String DENTAL_HYGIENIST_CODE = "00400";

    /**
     * EN: Code for Dentist.<br>
     * DE: Code für Zahnarzt/Zahnärztin.<br>
     * FR: Code de dentiste.<br>
     * IT: Code per dentista.<br>
     */
    public static final String DENTIST_CODE = "106289002";

    /**
     * EN: Code for Dietitian.<br>
     * DE: Code für Ernährungsberater/Ernährungsberaterin.<br>
     * FR: Code de diététicien(ne).<br>
     * IT: Code per dietista.<br>
     */
    public static final String DIETITIAN_CODE = "159033005";

    /**
     * EN: Code for Druggist.<br>
     * DE: Code für Drogist/Drogistin.<br>
     * FR: Code de droguiste.<br>
     * IT: Code per droghiere(-a).<br>
     */
    public static final String DRUGGIST_CODE = "00500";

    /**
     * EN: Code for Healthcare assistant.<br>
     * DE: Code für Fachperson Gesundheit.<br>
     * FR: Code de assistant(e) en soins et santé communautaire.<br>
     * IT: Code per operatore(-trice) sociosanitario.<br>
     */
    public static final String HEALTHCARE_ASSISTANT_CODE = "00700";

    /**
     * EN: Code for Medical masseur.<br>
     * DE: Code für Medizinischer Masseur/Medizinische Masseurin.<br>
     * FR: Code de masseur(-euse) médical.<br>
     * IT: Code per massaggiatore(-trice) medicale.<br>
     */
    public static final String MEDICAL_MASSEUR_CODE = "00900";

    /**
     * EN: Code for Medical-technical radiology assistant.<br>
     * DE: Code für Fachperson für medizinisch-technische Radiologie.<br>
     * FR: Code de technicien(ne) en radiologie médicale.<br>
     * IT: Code per tecnico(-a) di radiologia medica.<br>
     */
    public static final String MEDICAL_TECHNICAL_RADIOLOGY_ASSISTANT_CODE = "00600";

    /**
     * EN: Code for Naturopathic practitioner.<br>
     * DE: Code für Naturheilpraktiker/Naturheilpraktikerin.<br>
     * FR: Code de naturopathe.<br>
     * IT: Code per naturopata.<br>
     */
    public static final String NATUROPATHIC_PRACTITIONER_CODE = "01000";

    /**
     * EN: Code for Occupational therapist.<br>
     * DE: Code für Ergotherapeut/Ergotherapeutin.<br>
     * FR: Code de ergothérapeute.<br>
     * IT: Code per ergoterapista.<br>
     */
    public static final String OCCUPATIONAL_THERAPIST_CODE = "80546007";

    /**
     * EN: Code for Operating room technician.<br>
     * DE: Code für Fachperson Operationstechnik.<br>
     * FR: Code de technicien(ne) en salle d'opération.<br>
     * IT: Code per tecnico(-a) di sala operatoria.<br>
     */
    public static final String OPERATING_ROOM_TECHNICIAN_CODE = "00800";

    /**
     * EN: Code for Optician.<br>
     * DE: Code für Optiker/Optikerin.<br>
     * FR: Code de opticien(ne).<br>
     * IT: Code per ottico(-a).<br>
     */
    public static final String OPTICIAN_CODE = "00200";

    /**
     * EN: Code for Optometrist.<br>
     * DE: Code für Optometrist/Optometristin.<br>
     * FR: Code de optométriste.<br>
     * IT: Code per optometrista.<br>
     */
    public static final String OPTOMETRIST_CODE = "01100";

    /**
     * EN: Code for orthoptist.<br>
     * DE: Code für Orthoptist/Orthoptistin.<br>
     * FR: Code de orthoptiste.<br>
     * IT: Code per ortottista.<br>
     */
    public static final String ORTHOPTIST_CODE = "01200";

    /**
     * EN: Code for Osteopath.<br>
     * DE: Code für Osteopath/Osteopathin.<br>
     * FR: Code de ostéopathe.<br>
     * IT: Code per osteopata.<br>
     */
    public static final String OSTEOPATH_CODE = "01300";

    /**
     * EN: Code for Other.<br>
     * DE: Code für Andere.<br>
     * FR: Code de autre.<br>
     * IT: Code per altro.<br>
     */
    public static final String OTHER_CODE = "00000";

    /**
     * EN: Code for Paramedic.<br>
     * DE: Code für Rettungssanitäter/Rettungssanitäterin.<br>
     * FR: Code de ambulancier(-ère).<br>
     * IT: Code per soccorritore(-trice).<br>
     */
    public static final String PARAMEDIC_CODE = "01500";

    /**
     * EN: Code for Pharmacist.<br>
     * DE: Code für Apotheker/Apothekerin.<br>
     * FR: Code de pharmacien(ne).<br>
     * IT: Code per farmacista.<br>
     */
    public static final String PHARMACIST_CODE = "46255001";

    /**
     * EN: Code for Physician.<br>
     * DE: Code für Arzt/Ärztin.<br>
     * FR: Code de médecin.<br>
     * IT: Code per medico.<br>
     */
    public static final String PHYSICIAN_CODE = "309343006";

    /**
     * EN: Code for Physiotherapist.<br>
     * DE: Code für Physiotherapeut/Physiotherapeutin.<br>
     * FR: Code de physiothérapeute.<br>
     * IT: Code per fisioterapista.<br>
     */
    public static final String PHYSIOTHERAPIST_CODE = "36682004";

    /**
     * EN: Code for Podiatrist.<br>
     * DE: Code für Podologe/Podologin.<br>
     * FR: Code de podologue.<br>
     * IT: Code per podologo(-a).<br>
     */
    public static final String PODIATRIST_CODE = "01400";

    /**
     * EN: Code for Professional nurse.<br>
     * DE: Code für Pflegefachmann/Pflegefachfrau.<br>
     * FR: Code de infirmier(-ère).<br>
     * IT: Code per infermiere(-a).<br>
     */
    public static final String PROFESSIONAL_NURSE_CODE = "106292003";

    /**
     * EN: Code for Psychologist.<br>
     * DE: Code für Psychologe/Psychologin.<br>
     * FR: Code de psychologue.<br>
     * IT: Code per psicologo(-a).<br>
     */
    public static final String PSYCHOLOGIST_CODE = "59944000";

    /**
     * EN: Code for Registered midwife.<br>
     * DE: Code für Registrierte Hebamme.<br>
     * FR: Code de sage-femme.<br>
     * IT: Code per levatrice.<br>
     */
    public static final String REGISTERED_MIDWIFE_CODE = "309453006";

    /**
     * EN: Code for Speech/language therapist.<br>
     * DE: Code für Sprachtherapeut/Sprachtherapeutin.<br>
     * FR: Code de orthophoniste.<br>
     * IT: Code per logopedista.<br>
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
    @Nullable
    public static HcpProfession getEnum(@Nullable final String code) {
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
    public static boolean isEnumOfValueSet(@Nullable final String enumName) {
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
    public static boolean isInValueSet(@Nullable final String codeValue) {
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
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String codeSystem;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

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
    HcpProfession(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.codeSystem = Objects.requireNonNull(codeSystem);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
        final var codeSystem = CodeSystems.getEnum(this.codeSystem);
        if (codeSystem != null) {
            return codeSystem.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    @NonNull
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @Override
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch(languageCode) {
            case ENGLISH ->
                this.displayNames[1];
            case GERMAN ->
                this.displayNames[2];
            case FRENCH ->
                this.displayNames[3];
            case ITALIAN ->
                this.displayNames[4];
            default ->
                "TOTRANSLATE";
        };
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    @NonNull
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
