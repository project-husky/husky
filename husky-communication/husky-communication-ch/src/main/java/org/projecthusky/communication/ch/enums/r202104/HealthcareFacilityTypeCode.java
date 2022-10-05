/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.r202104;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.healthcareFacilityTypeCode values
 * <p>
 * EN: Type of healthcare facility as per Annex 3; EPRO-FDHA. This code describes the type of healthcare facility in which the document was compiled during the treatment process. In conjunction with the authorisation control, the patient can use this information to assign all documents from a specific type of healthcare facility to a specific confidentiality level in their rights and attributes, for example.<br>
 * DE: Typ der Gesundheitseinrichtung gemäss Anhang 3 EPDV-EDI. Dieser Code beschreibt den Typ der Gesundheitseinrichtung, in der das Dokument während des Behandlungsprozesses erstellt wurde. Der Patient kann im Zusammenhang mit der Berechtigungsteuerung diese Information nutzen, um beispielsweise in seinen Rechteattributen allen Dokumenten aus einem bestimmten Gesundheitseinrichtungstyp eine bestimmte Vertraulichkeitsstufe zuzuordnen.<br>
 * FR: Type de l'institution de santé selon l'annexe 3 ODEP-DFI. Ce code décrit le type de l'institution de santé qui a élaboré le document pendant le processus thérapeutique. Le patient peut utiliser cette information pour gérer les droits d'accès et définir, dans les règles d'accès, un même niveau de confidentialité pour tous les documents émanant d'un type d'institution donné.<br>
 * IT: Tipo di istituzione sanitaria secondo l'allegato 3 OCIP-DFI. Questo codice descrive il tipo di istituzione sanitaria nella quale è stato creato il documento durante il processo terapeutico. Il paziente può utilizzare questa informazione in relazione al controllo delle autorizzazioni, ad esempio per attribuire un determinato grado di riservatezza a tutti i documenti provenienti da un determinato tipo di istituzione sanitaria.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.11<br>
 * Effective date: 2021-04-01 16:16<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-09-29")
public enum HealthcareFacilityTypeCode implements ValueSetEnumInterface {

    /**
     * EN: Accident and Emergency department.<br>
     * DE: Notfall-/Rettungsdienste.<br>
     * FR: Service d'urgence et de sauvetage.<br>
     * IT: Servizio di pronto soccorso e di salvataggio.<br>
     */
    ACCIDENT_AND_EMERGENCY_DEPARTMENT("225728007",
                                      "2.16.840.1.113883.6.96",
                                      "Accident and Emergency department (environment)",
                                      "Accident and Emergency department",
                                      "Notfall-/Rettungsdienste",
                                      "Service d'urgence et de sauvetage",
                                      "Servizio di pronto soccorso e di salvataggio"),
    /**
     * EN: Ambulatory care site.<br>
     * DE: Ambulante Einrichtung/Ambulatorium.<br>
     * FR: Etablissement ambulatoire.<br>
     * IT: Struttura ambulatoriale, incl. gli studi medici.<br>
     */
    AMBULATORY_CARE_SITE("35971002",
                         "2.16.840.1.113883.6.96",
                         "Ambulatory care site (environment)",
                         "Ambulatory care site",
                         "Ambulante Einrichtung/Ambulatorium",
                         "Etablissement ambulatoire",
                         "Struttura ambulatoriale, incl. gli studi medici"),
    /**
     * EN: Client's or patient's home.<br>
     * DE: Domizil des Patienten.<br>
     * FR: Domicile du patient.<br>
     * IT: Domicilio del paziente.<br>
     */
    CLIENT_OR_PATIENT_HOME("394778007",
                           "2.16.840.1.113883.6.96",
                           "Client's or patient's home (environment)",
                           "Client's or patient's home",
                           "Domizil des Patienten",
                           "Domicile du patient",
                           "Domicilio del paziente"),
    /**
     * EN: Diagnostic institution.<br>
     * DE: Institution für medizinische Diagnostik.<br>
     * FR: Institut d’aide au diagnostic.<br>
     * IT: Istituto di diagnostica medica.<br>
     */
    DIAGNOSTIC_INSTITUTION("722171005",
                           "2.16.840.1.113883.6.96",
                           "Diagnostic institution (environment)",
                           "Diagnostic institution",
                           "Institution für medizinische Diagnostik",
                           "Institut d’aide au diagnostic",
                           "Istituto di diagnostica medica"),
    /**
     * EN: General practice premises.<br>
     * DE: Arztpraxis.<br>
     * FR: Cabinet médical.<br>
     * IT: Studio medico.<br>
     */
    GENERAL_PRACTICE_PREMISES("264358009",
                              "2.16.840.1.113883.6.96",
                              "General practice premises (environment)",
                              "General practice premises",
                              "Arztpraxis",
                              "Cabinet médical",
                              "Studio medico"),
    /**
     * EN: Health Authority.<br>
     * DE: Gesundheitsbehörde.<br>
     * FR: Autorité sanitaire.<br>
     * IT: Autorità sanitaria.<br>
     */
    HEALTH_AUTHORITY("394747008",
                     "2.16.840.1.113883.6.96",
                     "Health Authority (qualifier value)",
                     "Health Authority",
                     "Gesundheitsbehörde",
                     "Autorité sanitaire",
                     "Autorità sanitaria"),
    /**
     * EN: Hospital.<br>
     * DE: Stationäre Einrichtung/Spital.<br>
     * FR: Hôpital.<br>
     * IT: Ospedale.<br>
     */
    HOSPITAL("22232009",
             "2.16.840.1.113883.6.96",
             "Hospital (environment)",
             "Hospital",
             "Stationäre Einrichtung/Spital",
             "Hôpital",
             "Ospedale"),
    /**
     * EN: Military health institution.<br>
     * DE: Armeeärztliche Dienste.<br>
     * FR: Service sanitaire de l'armée.<br>
     * IT: Servizio di medicina militare.<br>
     */
    MILITARY_HEALTH_INSTITUTION("722172003",
                                "2.16.840.1.113883.6.96",
                                "Military health institution (environment)",
                                "Military health institution",
                                "Armeeärztliche Dienste",
                                "Service sanitaire de l'armée",
                                "Servizio di medicina militare"),
    /**
     * EN: Nursing home.<br>
     * DE: Pflegeheim.<br>
     * FR: Etablissement médico-social.<br>
     * IT: Casa di cura.<br>
     */
    NURSING_HOME("42665001",
                 "2.16.840.1.113883.6.96",
                 "Nursing home (environment)",
                 "Nursing home",
                 "Pflegeheim",
                 "Etablissement médico-social",
                 "Casa di cura"),
    /**
     * EN: Other Site of Care.<br>
     * DE: Andere Gesundheitsorganisation.<br>
     * FR: Autres prestataires de soins.<br>
     * IT: Altre organizzazioni sanitarie.<br>
     */
    OTHER_SITE_OF_CARE("43741000",
                       "2.16.840.1.113883.6.96",
                       "Site of care (environment)",
                       "Other Site of Care",
                       "Andere Gesundheitsorganisation",
                       "Autres prestataires de soins",
                       "Altre organizzazioni sanitarie"),
    /**
     * EN: Pharmacy.<br>
     * DE: Apotheke.<br>
     * FR: Pharmacie.<br>
     * IT: Farmacia.<br>
     */
    PHARMACY("264372000",
             "2.16.840.1.113883.6.96",
             "Pharmacy (environment)",
             "Pharmacy",
             "Apotheke",
             "Pharmacie",
             "Farmacia"),
    /**
     * EN: Prison based care site.<br>
     * DE: Gesundheitseinrichtung in der Haftanstalt.<br>
     * FR: Service de santé en milieu carcéral.<br>
     * IT: Struttura sanitaria in uno stabilimento carcerario.<br>
     */
    PRISON_BASED_CARE_SITE("722173008",
                           "2.16.840.1.113883.6.96",
                           "Prison based care site (environment)",
                           "Prison based care site",
                           "Gesundheitseinrichtung in der Haftanstalt",
                           "Service de santé en milieu carcéral",
                           "Struttura sanitaria in uno stabilimento carcerario"),
    /**
     * EN: Private home-based care.<br>
     * DE: Organisation für Pflege zu Hause.<br>
     * FR: Soins à domicile.<br>
     * IT: Servizio di assistenza e cura a domicilio.<br>
     */
    PRIVATE_HOME_BASED_CARE("66280005",
                            "2.16.840.1.113883.6.96",
                            "Private home-based care (environment)",
                            "Private home-based care",
                            "Organisation für Pflege zu Hause",
                            "Soins à domicile",
                            "Servizio di assistenza e cura a domicilio"),
    /**
     * EN: Rehabilitation hospital.<br>
     * DE: Organisation für stationäre Rehabilitation.<br>
     * FR: Réadaptation stationnaire.<br>
     * IT: Istituto di riabilitazione stazionaria.<br>
     */
    REHABILITATION_HOSPITAL("80522000",
                            "2.16.840.1.113883.6.96",
                            "Rehabilitation hospital (environment)",
                            "Rehabilitation hospital",
                            "Organisation für stationäre Rehabilitation",
                            "Réadaptation stationnaire",
                            "Istituto di riabilitazione stazionaria"),
    /**
     * EN: Telemedicine institution.<br>
     * DE: Telemedizinische Einrichtung.<br>
     * FR: Institut de télémédecine.<br>
     * IT: Centro di telemedicina.<br>
     */
    TELEMEDICINE_INSTITUTION("288565001",
                             "2.16.840.1.113883.6.96",
                             "Medical center (environment)",
                             "Telemedicine institution",
                             "Telemedizinische Einrichtung",
                             "Institut de télémédecine",
                             "Centro di telemedicina");

    /**
     * EN: Code for Accident and Emergency department.<br>
     * DE: Code für Notfall-/Rettungsdienste.<br>
     * FR: Code de Service d'urgence et de sauvetage.<br>
     * IT: Code per Servizio di pronto soccorso e di salvataggio.<br>
     */
    public static final String ACCIDENT_AND_EMERGENCY_DEPARTMENT_CODE = "225728007";

    /**
     * EN: Code for Ambulatory care site.<br>
     * DE: Code für Ambulante Einrichtung/Ambulatorium.<br>
     * FR: Code de Etablissement ambulatoire.<br>
     * IT: Code per Struttura ambulatoriale, incl. gli studi medici.<br>
     */
    public static final String AMBULATORY_CARE_SITE_CODE = "35971002";

    /**
     * EN: Code for Client's or patient's home.<br>
     * DE: Code für Domizil des Patienten.<br>
     * FR: Code de Domicile du patient.<br>
     * IT: Code per Domicilio del paziente.<br>
     */
    public static final String CLIENT_OR_PATIENT_HOME_CODE = "394778007";

    /**
     * EN: Code for Diagnostic institution.<br>
     * DE: Code für Institution für medizinische Diagnostik.<br>
     * FR: Code de Institut d’aide au diagnostic.<br>
     * IT: Code per Istituto di diagnostica medica.<br>
     */
    public static final String DIAGNOSTIC_INSTITUTION_CODE = "722171005";

    /**
     * EN: Code for General practice premises.<br>
     * DE: Code für Arztpraxis.<br>
     * FR: Code de Cabinet médical.<br>
     * IT: Code per Studio medico.<br>
     */
    public static final String GENERAL_PRACTICE_PREMISES_CODE = "264358009";

    /**
     * EN: Code for Health Authority.<br>
     * DE: Code für Gesundheitsbehörde.<br>
     * FR: Code de Autorité sanitaire.<br>
     * IT: Code per Autorità sanitaria.<br>
     */
    public static final String HEALTH_AUTHORITY_CODE = "394747008";

    /**
     * EN: Code for Hospital.<br>
     * DE: Code für Stationäre Einrichtung/Spital.<br>
     * FR: Code de Hôpital.<br>
     * IT: Code per Ospedale.<br>
     */
    public static final String HOSPITAL_CODE = "22232009";

    /**
     * EN: Code for Military health institution.<br>
     * DE: Code für Armeeärztliche Dienste.<br>
     * FR: Code de Service sanitaire de l'armée.<br>
     * IT: Code per Servizio di medicina militare.<br>
     */
    public static final String MILITARY_HEALTH_INSTITUTION_CODE = "722172003";

    /**
     * EN: Code for Nursing home.<br>
     * DE: Code für Pflegeheim.<br>
     * FR: Code de Etablissement médico-social.<br>
     * IT: Code per Casa di cura.<br>
     */
    public static final String NURSING_HOME_CODE = "42665001";

    /**
     * EN: Code for Other Site of Care.<br>
     * DE: Code für Andere Gesundheitsorganisation.<br>
     * FR: Code de Autres prestataires de soins.<br>
     * IT: Code per Altre organizzazioni sanitarie.<br>
     */
    public static final String OTHER_SITE_OF_CARE_CODE = "43741000";

    /**
     * EN: Code for Pharmacy.<br>
     * DE: Code für Apotheke.<br>
     * FR: Code de Pharmacie.<br>
     * IT: Code per Farmacia.<br>
     */
    public static final String PHARMACY_CODE = "264372000";

    /**
     * EN: Code for Prison based care site.<br>
     * DE: Code für Gesundheitseinrichtung in der Haftanstalt.<br>
     * FR: Code de Service de santé en milieu carcéral.<br>
     * IT: Code per Struttura sanitaria in uno stabilimento carcerario.<br>
     */
    public static final String PRISON_BASED_CARE_SITE_CODE = "722173008";

    /**
     * EN: Code for Private home-based care.<br>
     * DE: Code für Organisation für Pflege zu Hause.<br>
     * FR: Code de Soins à domicile.<br>
     * IT: Code per Servizio di assistenza e cura a domicilio.<br>
     */
    public static final String PRIVATE_HOME_BASED_CARE_CODE = "66280005";

    /**
     * EN: Code for Rehabilitation hospital.<br>
     * DE: Code für Organisation für stationäre Rehabilitation.<br>
     * FR: Code de Réadaptation stationnaire.<br>
     * IT: Code per Istituto di riabilitazione stazionaria.<br>
     */
    public static final String REHABILITATION_HOSPITAL_CODE = "80522000";

    /**
     * EN: Code for Telemedicine institution.<br>
     * DE: Code für Telemedizinische Einrichtung.<br>
     * FR: Code de Institut de télémédecine.<br>
     * IT: Code per Centro di telemedicina.<br>
     */
    public static final String TELEMEDICINE_INSTITUTION_CODE = "288565001";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.11";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.healthcareFacilityTypeCode";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.6.96";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static HealthcareFacilityTypeCode getEnum(@Nullable final String code) {
        for (final HealthcareFacilityTypeCode x : values()) {
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
            Enum.valueOf(HealthcareFacilityTypeCode.class,
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
        for (final HealthcareFacilityTypeCode x : values()) {
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
    HealthcareFacilityTypeCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
