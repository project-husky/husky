/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.stable;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.typeCode values
 * <p>
 * EN: Type of document as per Annex 3 EPRO-FDHA. &lt;br/&gt; &lt;br/&gt; The code defines a document’s type (e.g. discharge report, laboratory report). Each document type should be assigned to precisely one document class. &lt;br/&gt;.<br>
 * DE: Typ des Dokumentes (2.16.756.5.30.1.127.3.10.1.27) gemäss Anhang 3 der Verordnungen zum EPDG. &lt;br/&gt; &lt;br/&gt; Der Code definiert den Typ eines Dokuments (z.B. Austrittsbericht, Labor-Bericht). Jeder Dokumenten-Typ sollte genau einer Dokumentenklasse zugeordnet sein. &lt;br/&gt;.<br>
 * FR: Type du document selon l'annexe 3 ODEP-DFI. &lt;br/&gt; &lt;br/&gt; Le code définit le type de document (p. ex. rapport de sortie, rapport de laboratoire). Chaque type de document doit être  associé à une seule classification. &lt;br/&gt;.<br>
 * IT: Tipo di documento secondo l'allegato 3 OCIP-DFI. &lt;br/&gt; &lt;br/&gt; Il codice definisce il tipo di documento (p. es. rapporto di dimissione, rapporto di laboratorio). Ciascun tipo di documento dovrebbe essere associato a una sola classe di documenti. &lt;br/&gt;.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.27<br>
 * Effective date: 2023-05-01 14:35<br>
 * Version: 202406.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2025-03-03")
public enum TypeCode implements ValueSetEnumInterface {

    /**
     * EN: Allergy record.<br>
     * DE: Allergieausweis.<br>
     * FR: carnet des allergies.<br>
     * IT: passaporto delle allergie.<br>
     */
    ALLERGY_RECORD("722446000",
                   "2.16.840.1.113883.6.96",
                   "Allergy record (record artifact)",
                   "Allergy record",
                   "Allergieausweis",
                   "carnet des allergies",
                   "passaporto delle allergie"),
    /**
     * EN: Consultation report.<br>
     * DE: Konsultationsbericht.<br>
     * FR: rapport de consultation.<br>
     * IT: rapporto di consultazione.<br>
     */
    CONSULTATION_REPORT("371530004",
                        "2.16.840.1.113883.6.96",
                        "Clinical consultation report (record artifact)",
                        "Consultation report",
                        "Konsultationsbericht",
                        "rapport de consultation",
                        "rapporto di consultazione"),
    /**
     * EN: Discharge summary.<br>
     * DE: Austrittsbericht.<br>
     * FR: rapport de sortie.<br>
     * IT: rapporto di dimissione.<br>
     */
    DISCHARGE_SUMMARY("373942005",
                      "2.16.840.1.113883.6.96",
                      "Discharge summary (record artifact)",
                      "Discharge summary",
                      "Austrittsbericht",
                      "rapport de sortie",
                      "rapporto di dimissione"),
    /**
     * EN: Emergency report.<br>
     * DE: Notfallbericht.<br>
     * FR: rapport d'urgence.<br>
     * IT: rapporto d'urgenza.<br>
     */
    EMERGENCY_REPORT("445300006",
                     "2.16.840.1.113883.6.96",
                     "Emergency department record (record artifact)",
                     "Emergency report",
                     "Notfallbericht",
                     "rapport d'urgence",
                     "rapporto d'urgenza"),
    /**
     * EN: History and physical report.<br>
     * DE: Anamnese.<br>
     * FR: anamnèse.<br>
     * IT: anamnesi.<br>
     */
    HISTORY_AND_PHYSICAL_REPORT("371529009",
                                "2.16.840.1.113883.6.96",
                                "History and physical report (record artifact)",
                                "History and physical report",
                                "Anamnese",
                                "anamnèse",
                                "anamnesi"),
    /**
     * EN: Image.<br>
     * DE: Bild.<br>
     * FR: image.<br>
     * IT: immagine.<br>
     */
    IMAGE("900000000000471006",
          "2.16.840.1.113883.6.96",
          "Image reference (foundation metadata concept)",
          "Image",
          "Bild",
          "image",
          "immagine"),
    /**
     * EN: Imaging Order.<br>
     * DE: Bildgebungsauftrag.<br>
     * FR: demande d'imagerie.<br>
     * IT: richiesta di immaginografia.<br>
     */
    IMAGING_ORDER("2161000195103",
                  "2.16.756.5.30.1.127.3.4",
                  "Imaging order (record artifact)",
                  "Imaging Order",
                  "Bildgebungsauftrag",
                  "demande d'imagerie",
                  "richiesta di immaginografia"),
    /**
     * EN: Imaging report.<br>
     * DE: Bericht zur Bildgebung.<br>
     * FR: rapport sur l'imagerie.<br>
     * IT: referto di immaginografia.<br>
     */
    IMAGING_REPORT("4201000179104",
                   "2.16.840.1.113883.6.96",
                   "Imaging report (record artifact)",
                   "Imaging report",
                   "Bericht zur Bildgebung",
                   "rapport sur l'imagerie",
                   "referto di immaginografia"),
    /**
     * EN: Immunization record.<br>
     * DE: Impfdokument.<br>
     * FR: document de vaccination.<br>
     * IT: documento di vaccinazione.<br>
     */
    IMMUNIZATION_RECORD("41000179103",
                        "2.16.840.1.113883.6.96",
                        "Immunization record (record artifact)",
                        "Immunization record",
                        "Impfdokument",
                        "document de vaccination",
                        "documento di vaccinazione"),
    /**
     * EN: Laboratory Order.<br>
     * DE: Laborauftrag.<br>
     * FR: demande de laboratoire.<br>
     * IT: richiesta di laboratorio.<br>
     */
    LABORATORY_ORDER("721965002",
                     "2.16.840.1.113883.6.96",
                     "Laboratory order (record artifact)",
                     "Laboratory Order",
                     "Laborauftrag",
                     "demande de laboratoire",
                     "richiesta di laboratorio"),
    /**
     * EN: Laboratory report.<br>
     * DE: Laborbericht.<br>
     * FR: rapport de laboratoire.<br>
     * IT: referto di laboratorio.<br>
     */
    LABORATORY_REPORT("4241000179101",
                      "2.16.840.1.113883.6.96",
                      "Laboratory report (record artifact)",
                      "Laboratory report",
                      "Laborbericht",
                      "rapport de laboratoire",
                      "referto di laboratorio"),
    /**
     * EN: Medical care plan.<br>
     * DE: Ärztlicher behandlungsplan.<br>
     * FR: plan de traitement médical.<br>
     * IT: piano di cure mediche.<br>
     */
    MEDICAL_CARE_PLAN("737427001",
                      "2.16.840.1.113883.6.96",
                      "Clinical management plan (record artifact)",
                      "Medical care plan",
                      "Ärztlicher behandlungsplan",
                      "plan de traitement médical",
                      "piano di cure mediche"),
    /**
     * EN: Medical certificate.<br>
     * DE: Ärztliches Attest.<br>
     * FR: certificat médical.<br>
     * IT: certificato medico.<br>
     */
    MEDICAL_CERTIFICATE("772786005",
                        "2.16.840.1.113883.6.96",
                        "Medical certificate (record artifact)",
                        "Medical certificate",
                        "Ärztliches Attest",
                        "certificat médical",
                        "certificato medico"),
    /**
     * EN: Medical Prescription record.<br>
     * DE: Arzneimittelrezept.<br>
     * FR: prescription de médicaments.<br>
     * IT: prescrizione di medicamenti.<br>
     */
    MEDICAL_PRESCRIPTION_RECORD("761938008",
                                "2.16.840.1.113883.6.96",
                                "Medicinal prescription record (record artifact)",
                                "Medical Prescription record",
                                "Arzneimittelrezept",
                                "prescription de médicaments",
                                "prescrizione di medicamenti"),
    /**
     * EN: Medication Card document.<br>
     * DE: Medikationsplan.<br>
     * FR: plan de médication.<br>
     * IT: piano dei medicamenti.<br>
     */
    MEDICATION_CARD_DOCUMENT("736378000",
                             "2.16.840.1.113883.6.96",
                             "Medication management plan (record artifact)",
                             "Medication Card document",
                             "Medikationsplan",
                             "plan de médication",
                             "piano dei medicamenti"),
    /**
     * EN: Medication dispense.<br>
     * DE: Medikamentenabgabe.<br>
     * FR: dispense de médicaments.<br>
     * IT: dispensazione di medicamenti.<br>
     */
    MEDICATION_DISPENSE("82291000195104",
                        "2.16.756.5.30.1.127.3.4",
                        "Medication dispense document (record artifact)",
                        "Medication dispense",
                        "Medikamentenabgabe",
                        "dispense de médicaments",
                        "dispensazione di medicamenti"),
    /**
     * EN: Medication list.<br>
     * DE: Medikationsliste.<br>
     * FR: liste des médicaments.<br>
     * IT: elenco dei medicamenti.<br>
     */
    MEDICATION_LIST("721912009",
                    "2.16.840.1.113883.6.96",
                    "Medication summary document (record artifact)",
                    "Medication list",
                    "Medikationsliste",
                    "liste des médicaments",
                    "elenco dei medicamenti"),
    /**
     * EN: Medication treatment plan.<br>
     * DE: Therapieentscheid Medikation.<br>
     * FR: plan de traitement medicament.<br>
     * IT: decisione di terapia medicament.<br>
     */
    MEDICATION_TREATMENT_PLAN("761931002",
                              "2.16.840.1.113883.6.96",
                              "Medication treatment plan report (record artifact)",
                              "Medication treatment plan",
                              "Therapieentscheid Medikation",
                              "plan de traitement medicament",
                              "decisione di terapia medicament"),
    /**
     * EN: Non-drug prescription.<br>
     * DE: Nicht-Arzneimittel-Verschreibung.<br>
     * FR: prescription non médicamenteuse.<br>
     * IT: prescrizione non di medicamenti.<br>
     */
    NON_DRUG_PRESCRIPTION("765492005",
                          "2.16.840.1.113883.6.96",
                          "Non-drug prescription record (record artifact)",
                          "Non-drug prescription",
                          "Nicht-Arzneimittel-Verschreibung",
                          "prescription non médicamenteuse",
                          "prescrizione non di medicamenti"),
    /**
     * EN: Non-medical report.<br>
     * DE: Nichtmedizinischer Bericht.<br>
     * FR: rapport non médical.<br>
     * IT: rapporto non medico.<br>
     */
    NON_MEDICAL_REPORT("445418005",
                       "2.16.840.1.113883.6.96",
                       "Professional allied to medicine clinical report (record artifact)",
                       "Non-medical report",
                       "Nichtmedizinischer Bericht",
                       "rapport non médical",
                       "rapporto non medico"),
    /**
     * EN: Nursing care plan.<br>
     * DE: Pflegeplan.<br>
     * FR: plan de soins infirmier.<br>
     * IT: piano di cure infermieristiche.<br>
     */
    NURSING_CARE_PLAN("773130005",
                      "2.16.840.1.113883.6.96",
                      "Nursing care plan (record artifact)",
                      "Nursing care plan",
                      "Pflegeplan",
                      "plan de soins infirmier",
                      "piano di cure infermieristiche"),
    /**
     * EN: Operative report.<br>
     * DE: Operationsbericht.<br>
     * FR: rapport d'opération.<br>
     * IT: rapporto operatorio.<br>
     */
    OPERATIVE_REPORT("371526002",
                     "2.16.840.1.113883.6.96",
                     "Operative report (record artifact)",
                     "Operative report",
                     "Operationsbericht",
                     "rapport d'opération",
                     "rapporto operatorio"),
    /**
     * EN: Pathology order.<br>
     * DE: Pathologieauftrag.<br>
     * FR: demande de pathologie.<br>
     * IT: richiesta di patologia.<br>
     */
    PATHOLOGY_ORDER("721966001",
                    "2.16.840.1.113883.6.96",
                    "Pathology order (record artifact)",
                    "Pathology order",
                    "Pathologieauftrag",
                    "demande de pathologie",
                    "richiesta di patologia"),
    /**
     * EN: Pathology report.<br>
     * DE: Pathologiebericht.<br>
     * FR: rapport de pathologie.<br>
     * IT: rapporto di patologia.<br>
     */
    PATHOLOGY_REPORT("371528001",
                     "2.16.840.1.113883.6.96",
                     "Pathology report (record artifact)",
                     "Pathology report",
                     "Pathologiebericht",
                     "rapport de pathologie",
                     "rapporto di patologia"),
    /**
     * EN: Picture/Video/Audio.<br>
     * DE: Bild/Video/Audio.<br>
     * FR: image/vidéo/audio.<br>
     * IT: immagine/video/audio.<br>
     */
    PICTURE_VIDEO_AUDIO("787148009",
                        "2.16.840.1.113883.6.96",
                        "Digital representation of specimen (record artifact)",
                        "Picture/Video/Audio",
                        "Bild/Video/Audio",
                        "image/vidéo/audio",
                        "immagine/video/audio"),
    /**
     * EN: Progress note.<br>
     * DE: Verlaufsbericht.<br>
     * FR: rapport de suivi.<br>
     * IT: referto sul decorso.<br>
     */
    PROGRESS_NOTE("371532007",
                  "2.16.840.1.113883.6.96",
                  "Progress report (record artifact)",
                  "Progress note",
                  "Verlaufsbericht",
                  "rapport de suivi",
                  "referto sul decorso"),
    /**
     * EN: Record artifact.<br>
     * DE: Sonstige Dokumentation.<br>
     * FR: autre documentation.<br>
     * IT: altra documentazione.<br>
     */
    RECORD_ARTIFACT("419891008",
                    "2.16.840.1.113883.6.96",
                    "Record artifact (record artifact)",
                    "Record artifact",
                    "Sonstige Dokumentation",
                    "autre documentation",
                    "altra documentazione"),
    /**
     * EN: Rehabilitation care plan.<br>
     * DE: Rehabilitationsplan.<br>
     * FR: plan de réhabilitation.<br>
     * IT: piano di riabilitazione.<br>
     */
    REHABILITATION_CARE_PLAN("736055001",
                             "2.16.840.1.113883.6.96",
                             "Rehabilitation care plan (record artifact)",
                             "Rehabilitation care plan",
                             "Rehabilitationsplan",
                             "plan de réhabilitation",
                             "piano di riabilitazione"),
    /**
     * EN: Transfer summary report.<br>
     * DE: Überweisungsbericht.<br>
     * FR: rapport de transfert.<br>
     * IT: rapporto di trasferimento.<br>
     */
    TRANSFER_SUMMARY_REPORT("371535009",
                            "2.16.840.1.113883.6.96",
                            "Transfer summary report (record artifact)",
                            "Transfer summary report",
                            "Überweisungsbericht",
                            "rapport de transfert",
                            "rapporto di trasferimento");

    /**
     * EN: Code for Allergy record.<br>
     * DE: Code für Allergieausweis.<br>
     * FR: Code de carnet des allergies.<br>
     * IT: Code per passaporto delle allergie.<br>
     */
    public static final String ALLERGY_RECORD_CODE = "722446000";

    /**
     * EN: Code for Consultation report.<br>
     * DE: Code für Konsultationsbericht.<br>
     * FR: Code de rapport de consultation.<br>
     * IT: Code per rapporto di consultazione.<br>
     */
    public static final String CONSULTATION_REPORT_CODE = "371530004";

    /**
     * EN: Code for Discharge summary.<br>
     * DE: Code für Austrittsbericht.<br>
     * FR: Code de rapport de sortie.<br>
     * IT: Code per rapporto di dimissione.<br>
     */
    public static final String DISCHARGE_SUMMARY_CODE = "373942005";

    /**
     * EN: Code for Emergency report.<br>
     * DE: Code für Notfallbericht.<br>
     * FR: Code de rapport d'urgence.<br>
     * IT: Code per rapporto d'urgenza.<br>
     */
    public static final String EMERGENCY_REPORT_CODE = "445300006";

    /**
     * EN: Code for History and physical report.<br>
     * DE: Code für Anamnese.<br>
     * FR: Code de anamnèse.<br>
     * IT: Code per anamnesi.<br>
     */
    public static final String HISTORY_AND_PHYSICAL_REPORT_CODE = "371529009";

    /**
     * EN: Code for Image.<br>
     * DE: Code für Bild.<br>
     * FR: Code de image.<br>
     * IT: Code per immagine.<br>
     */
    public static final String IMAGE_CODE = "900000000000471006";

    /**
     * EN: Code for Imaging Order.<br>
     * DE: Code für Bildgebungsauftrag.<br>
     * FR: Code de demande d'imagerie.<br>
     * IT: Code per richiesta di immaginografia.<br>
     */
    public static final String IMAGING_ORDER_CODE = "2161000195103";

    /**
     * EN: Code for Imaging report.<br>
     * DE: Code für Bericht zur Bildgebung.<br>
     * FR: Code de rapport sur l'imagerie.<br>
     * IT: Code per referto di immaginografia.<br>
     */
    public static final String IMAGING_REPORT_CODE = "4201000179104";

    /**
     * EN: Code for Immunization record.<br>
     * DE: Code für Impfdokument.<br>
     * FR: Code de document de vaccination.<br>
     * IT: Code per documento di vaccinazione.<br>
     */
    public static final String IMMUNIZATION_RECORD_CODE = "41000179103";

    /**
     * EN: Code for Laboratory Order.<br>
     * DE: Code für Laborauftrag.<br>
     * FR: Code de demande de laboratoire.<br>
     * IT: Code per richiesta di laboratorio.<br>
     */
    public static final String LABORATORY_ORDER_CODE = "721965002";

    /**
     * EN: Code for Laboratory report.<br>
     * DE: Code für Laborbericht.<br>
     * FR: Code de rapport de laboratoire.<br>
     * IT: Code per referto di laboratorio.<br>
     */
    public static final String LABORATORY_REPORT_CODE = "4241000179101";

    /**
     * EN: Code for Medical care plan.<br>
     * DE: Code für Ärztlicher behandlungsplan.<br>
     * FR: Code de plan de traitement médical.<br>
     * IT: Code per piano di cure mediche.<br>
     */
    public static final String MEDICAL_CARE_PLAN_CODE = "737427001";

    /**
     * EN: Code for Medical certificate.<br>
     * DE: Code für Ärztliches Attest.<br>
     * FR: Code de certificat médical.<br>
     * IT: Code per certificato medico.<br>
     */
    public static final String MEDICAL_CERTIFICATE_CODE = "772786005";

    /**
     * EN: Code for Medical Prescription record.<br>
     * DE: Code für Arzneimittelrezept.<br>
     * FR: Code de prescription de médicaments.<br>
     * IT: Code per prescrizione di medicamenti.<br>
     */
    public static final String MEDICAL_PRESCRIPTION_RECORD_CODE = "761938008";

    /**
     * EN: Code for Medication Card document.<br>
     * DE: Code für Medikationsplan.<br>
     * FR: Code de plan de médication.<br>
     * IT: Code per piano dei medicamenti.<br>
     */
    public static final String MEDICATION_CARD_DOCUMENT_CODE = "736378000";

    /**
     * EN: Code for Medication dispense.<br>
     * DE: Code für Medikamentenabgabe.<br>
     * FR: Code de dispense de médicaments.<br>
     * IT: Code per dispensazione di medicamenti.<br>
     */
    public static final String MEDICATION_DISPENSE_CODE = "82291000195104";

    /**
     * EN: Code for Medication list.<br>
     * DE: Code für Medikationsliste.<br>
     * FR: Code de liste des médicaments.<br>
     * IT: Code per elenco dei medicamenti.<br>
     */
    public static final String MEDICATION_LIST_CODE = "721912009";

    /**
     * EN: Code for Medication treatment plan.<br>
     * DE: Code für Therapieentscheid Medikation.<br>
     * FR: Code de plan de traitement medicament.<br>
     * IT: Code per decisione di terapia medicament.<br>
     */
    public static final String MEDICATION_TREATMENT_PLAN_CODE = "761931002";

    /**
     * EN: Code for Non-drug prescription.<br>
     * DE: Code für Nicht-Arzneimittel-Verschreibung.<br>
     * FR: Code de prescription non médicamenteuse.<br>
     * IT: Code per prescrizione non di medicamenti.<br>
     */
    public static final String NON_DRUG_PRESCRIPTION_CODE = "765492005";

    /**
     * EN: Code for Non-medical report.<br>
     * DE: Code für Nichtmedizinischer Bericht.<br>
     * FR: Code de rapport non médical.<br>
     * IT: Code per rapporto non medico.<br>
     */
    public static final String NON_MEDICAL_REPORT_CODE = "445418005";

    /**
     * EN: Code for Nursing care plan.<br>
     * DE: Code für Pflegeplan.<br>
     * FR: Code de plan de soins infirmier.<br>
     * IT: Code per piano di cure infermieristiche.<br>
     */
    public static final String NURSING_CARE_PLAN_CODE = "773130005";

    /**
     * EN: Code for Operative report.<br>
     * DE: Code für Operationsbericht.<br>
     * FR: Code de rapport d'opération.<br>
     * IT: Code per rapporto operatorio.<br>
     */
    public static final String OPERATIVE_REPORT_CODE = "371526002";

    /**
     * EN: Code for Pathology order.<br>
     * DE: Code für Pathologieauftrag.<br>
     * FR: Code de demande de pathologie.<br>
     * IT: Code per richiesta di patologia.<br>
     */
    public static final String PATHOLOGY_ORDER_CODE = "721966001";

    /**
     * EN: Code for Pathology report.<br>
     * DE: Code für Pathologiebericht.<br>
     * FR: Code de rapport de pathologie.<br>
     * IT: Code per rapporto di patologia.<br>
     */
    public static final String PATHOLOGY_REPORT_CODE = "371528001";

    /**
     * EN: Code for Picture/Video/Audio.<br>
     * DE: Code für Bild/Video/Audio.<br>
     * FR: Code de image/vidéo/audio.<br>
     * IT: Code per immagine/video/audio.<br>
     */
    public static final String PICTURE_VIDEO_AUDIO_CODE = "787148009";

    /**
     * EN: Code for Progress note.<br>
     * DE: Code für Verlaufsbericht.<br>
     * FR: Code de rapport de suivi.<br>
     * IT: Code per referto sul decorso.<br>
     */
    public static final String PROGRESS_NOTE_CODE = "371532007";

    /**
     * EN: Code for Record artifact.<br>
     * DE: Code für Sonstige Dokumentation.<br>
     * FR: Code de autre documentation.<br>
     * IT: Code per altra documentazione.<br>
     */
    public static final String RECORD_ARTIFACT_CODE = "419891008";

    /**
     * EN: Code for Rehabilitation care plan.<br>
     * DE: Code für Rehabilitationsplan.<br>
     * FR: Code de plan de réhabilitation.<br>
     * IT: Code per piano di riabilitazione.<br>
     */
    public static final String REHABILITATION_CARE_PLAN_CODE = "736055001";

    /**
     * EN: Code for Transfer summary report.<br>
     * DE: Code für Überweisungsbericht.<br>
     * FR: Code de rapport de transfert.<br>
     * IT: Code per rapporto di trasferimento.<br>
     */
    public static final String TRANSFER_SUMMARY_REPORT_CODE = "371535009";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.27";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.typeCode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static TypeCode getEnum(@Nullable final String code) {
        for (final TypeCode x : values()) {
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
            Enum.valueOf(TypeCode.class,
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
        for (final TypeCode x : values()) {
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
    TypeCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
