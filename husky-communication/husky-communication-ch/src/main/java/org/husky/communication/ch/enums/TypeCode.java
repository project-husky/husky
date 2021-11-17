/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.typeCode values
 * <p>
 * EN: Type of document as per Annex 3 EPRO-FDHA.<br clear="none"/><br clear="none"/>The code defines a document’s type (e.g. discharge report, laboratory report). Each document type should be assigned to precisely one document class.<br clear="none"/><br>
 * DE: Typ des Dokumentes (2.16.756.5.30.1.127.3.10.1.27) gemäss Anhang 3 der Verordnungen zum EPDG.<br clear="none"/><br clear="none"/>Der Code definiert den Typ eines Dokuments (z.B. Austrittsbericht, Labor-Bericht). Jeder Dokumenten-Typ sollte genau einer Dokumentenklasse zugeordnet sein.<br clear="none"/><br>
 * FR: Type du document selon l'annexe 3 ODEP-DFI.<br clear="none"/><br clear="none"/>Le code définit le type de document (p. ex. rapport de sortie, rapport de laboratoire). Chaque type de document doit être associé à une seule classification.<br clear="none"/><br>
 * IT: Tipo di documento secondo l'allegato 3 OCIP-DFI.<br clear="none"/><br clear="none"/>Il codice definisce il tipo di documento (p. es. rapporto di dimissione, rapporto di laboratorio). Ciascun tipo di documento dovrebbe essere associato a una sola classe di documenti.<br clear="none"/><br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.27<br>
 * Effective date: 2021-04-01 16:49<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum TypeCode implements ValueSetEnumInterface {

    /**
     * EN: Allergy record<br>
     * DE: Allergieausweis<br>
     * FR: Carnet des allergies<br>
     * IT: Passaporto delle allergie<br>
     */
    ALLERGY_RECORD("722446000",
                   "2.16.840.1.113883.6.96",
                   "Allergy record (record artifact)",
                   "Allergy record",
                   "Allergieausweis",
                   "Carnet des allergies",
                   "Passaporto delle allergie"),
    /**
     * EN: Clinical Management plan<br>
     * DE: Behandlungsplan<br>
     * FR: Plan de traitement<br>
     * IT: Piano di trattamento<br>
     */
    CLINICAL_MANAGEMENT_PLAN("737427001",
                             "2.16.840.1.113883.6.96",
                             "Clinical management plan (record artifact)",
                             "Clinical Management plan",
                             "Behandlungsplan",
                             "Plan de traitement",
                             "Piano di trattamento"),
    /**
     * EN: Consultation report<br>
     * DE: Beurteilung durch Fachspezialisten<br>
     * FR: Évaluation par des spécialistes<br>
     * IT: Valutazione dello specialista<br>
     */
    CONSULTATION_REPORT("371530004",
                        "2.16.840.1.113883.6.96",
                        "Clinical consultation report (record artifact)",
                        "Consultation report",
                        "Beurteilung durch Fachspezialisten",
                        "Évaluation par des spécialistes",
                        "Valutazione dello specialista"),
    /**
     * EN: Discharge summary<br>
     * DE: Austrittsbericht<br>
     * FR: Rapport de sortie<br>
     * IT: Rapporto di dimissione<br>
     */
    DISCHARGE_SUMMARY("373942005",
                      "2.16.840.1.113883.6.96",
                      "Discharge summary (record artifact)",
                      "Discharge summary",
                      "Austrittsbericht",
                      "Rapport de sortie",
                      "Rapporto di dimissione"),
    /**
     * EN: Emergency department record<br>
     * DE: Notfallberichtt<br>
     * FR: Rapport d’urgence<br>
     * IT: Referto di pronto soccorso<br>
     */
    EMERGENCY_DEPARTMENT_RECORD("445300006",
                                "2.16.840.1.113883.6.96",
                                "Emergency department record (record artifact)",
                                "Emergency department record",
                                "Notfallberichtt",
                                "Rapport d’urgence",
                                "Referto di pronto soccorso"),
    /**
     * EN: History and physical report<br>
     * DE: Anamnese / Untersuchungsbericht<br>
     * FR: Anamnèse / rapport d’analyse<br>
     * IT: Anamnesi / Rapporto di visita medica<br>
     */
    HISTORY_AND_PHYSICAL_REPORT("371529009",
                                "2.16.840.1.113883.6.96",
                                "History and physical report (record artifact)",
                                "History and physical report",
                                "Anamnese / Untersuchungsbericht",
                                "Anamnèse / rapport d’analyse",
                                "Anamnesi / Rapporto di visita medica"),
    /**
     * EN: Image<br>
     * DE: Bild<br>
     * FR: Image<br>
     * IT: Immagine<br>
     */
    IMAGE("900000000000471006",
          "2.16.840.1.113883.6.96",
          "Image reference (foundation metadata concept)",
          "Image",
          "Bild",
          "Image",
          "Immagine"),
    /**
     * EN: Imaging Order<br>
     * DE: Bildgebungsauftrag<br>
     * FR: Mandat d’imagerie<br>
     * IT: Richiesta di immaginografia<br>
     */
    IMAGING_ORDER("2161000195103",
                  "2.16.756.5.30.1.127.3.4",
                  "Imaging order (record artifact)",
                  "Imaging Order",
                  "Bildgebungsauftrag",
                  "Mandat d’imagerie",
                  "Richiesta di immaginografia"),
    /**
     * EN: Imaging report<br>
     * DE: Befundbericht zur Bildgebung<br>
     * FR: Rapport de résultat relatif à l’imagerie<br>
     * IT: Referto di immaginografia<br>
     */
    IMAGING_REPORT("4201000179104",
                   "2.16.840.1.113883.6.96",
                   "Imaging report (record artifact)",
                   "Imaging report",
                   "Befundbericht zur Bildgebung",
                   "Rapport de résultat relatif à l’imagerie",
                   "Referto di immaginografia"),
    /**
     * EN: Immunization record<br>
     * DE: Impfausweis<br>
     * FR: Carnet de vaccination<br>
     * IT: Certificato di vaccinazione<br>
     */
    IMMUNIZATION_RECORD("41000179103",
                        "2.16.840.1.113883.6.96",
                        "Immunization record (record artifact)",
                        "Immunization record",
                        "Impfausweis",
                        "Carnet de vaccination",
                        "Certificato di vaccinazione"),
    /**
     * EN: Laboratory Order<br>
     * DE: Laborauftrag<br>
     * FR: Mandat d’analyse en laboratoire<br>
     * IT: Richiesta di analisi di laboratorio<br>
     */
    LABORATORY_ORDER("721965002",
                     "2.16.840.1.113883.6.96",
                     "Laboratory order (record artifact)",
                     "Laboratory Order",
                     "Laborauftrag",
                     "Mandat d’analyse en laboratoire",
                     "Richiesta di analisi di laboratorio"),
    /**
     * EN: Laboratory report<br>
     * DE: Laborbericht<br>
     * FR: Rapport de laboratoire<br>
     * IT: Referto di laboratorio<br>
     */
    LABORATORY_REPORT("4241000179101",
                      "2.16.840.1.113883.6.96",
                      "Laboratory report (record artifact)",
                      "Laboratory report",
                      "Laborbericht",
                      "Rapport de laboratoire",
                      "Referto di laboratorio"),
    /**
     * EN: Medical certificate<br>
     * DE: Ärztliches Attest<br>
     * FR: Certificat médical<br>
     * IT: Certificato medico<br>
     */
    MEDICAL_CERTIFICATE("772786005",
                        "2.16.840.1.113883.6.96",
                        "Medical certificate (record artifact)",
                        "Medical certificate",
                        "Ärztliches Attest",
                        "Certificat médical",
                        "Certificato medico"),
    /**
     * EN: Medical Prescription record<br>
     * DE: Arzneimittel-Verschreibung / Rezept<br>
     * FR: Prescription de médicaments / ordonnance<br>
     * IT: Prescrizione di medicamenti<br>
     */
    MEDICAL_PRESCRIPTION_RECORD("761938008",
                                "2.16.840.1.113883.6.96",
                                "Medical prescription record (record artifact)",
                                "Medical Prescription record",
                                "Arzneimittel-Verschreibung / Rezept",
                                "Prescription de médicaments / ordonnance",
                                "Prescrizione di medicamenti"),
    /**
     * EN: Medication summary document<br>
     * DE: Medikationsliste<br>
     * FR: Liste de médication<br>
     * IT: Elenco dei medicamenti<br>
     */
    MEDICATION_SUMMARY_DOCUMENT("721912009",
                                "2.16.840.1.113883.6.96",
                                "Medication summary document (record artifact)",
                                "Medication summary document",
                                "Medikationsliste",
                                "Liste de médication",
                                "Elenco dei medicamenti"),
    /**
     * EN: Non-drug prescription<br>
     * DE: Nicht-Arzneimittel-Verschreibung / Rezept<br>
     * FR: Prescription sans médicaments / ordonnance<br>
     * IT: Prescrizione non di medicamenti<br>
     */
    NON_DRUG_PRESCRIPTION("765492005",
                          "2.16.840.1.113883.6.96",
                          "Non-drug prescription record (record artifact)",
                          "Non-drug prescription",
                          "Nicht-Arzneimittel-Verschreibung / Rezept",
                          "Prescription sans médicaments / ordonnance",
                          "Prescrizione non di medicamenti"),
    /**
     * EN: Nursing care plan<br>
     * DE: Pflegeplan<br>
     * FR: Plan de soins<br>
     * IT: Piano di cura<br>
     */
    NURSING_CARE_PLAN("773130005",
                      "2.16.840.1.113883.6.96",
                      "Nursing care plan (record artifact)",
                      "Nursing care plan",
                      "Pflegeplan",
                      "Plan de soins",
                      "Piano di cura"),
    /**
     * EN: Operative report<br>
     * DE: Operationsbericht<br>
     * FR: Rapport d’opération<br>
     * IT: Rapporto operatorio<br>
     */
    OPERATIVE_REPORT("371526002",
                     "2.16.840.1.113883.6.96",
                     "Operative report (record artifact)",
                     "Operative report",
                     "Operationsbericht",
                     "Rapport d’opération",
                     "Rapporto operatorio"),
    /**
     * EN: Pathology order<br>
     * DE: Pathologieauftrag<br>
     * FR: Mandat de rapport d’examen pathologique <br>
     * IT: Richiesta di esame istologico<br>
     */
    PATHOLOGY_ORDER("721966001",
                    "2.16.840.1.113883.6.96",
                    "Pathology order (record artifact)",
                    "Pathology order",
                    "Pathologieauftrag",
                    "Mandat de rapport d’examen pathologique ",
                    "Richiesta di esame istologico"),
    /**
     * EN: Pathology report<br>
     * DE: Pathologiebericht<br>
     * FR: Rapport d’examen pathologique<br>
     * IT: Referto istologico<br>
     */
    PATHOLOGY_REPORT("371528001",
                     "2.16.840.1.113883.6.96",
                     "Pathology report (record artifact)",
                     "Pathology report",
                     "Pathologiebericht",
                     "Rapport d’examen pathologique",
                     "Referto istologico"),
    /**
     * EN: Professional allied to medicine clinical report<br>
     * DE: Dokument ausserhalb des Behandlungskontextes<br>
     * FR: Document hors contexte de traitement<br>
     * IT: Documento al di fuori del contesto trattato<br>
     */
    PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT("445418005",
                                                    "2.16.840.1.113883.6.96",
                                                    "Professional allied to medicine clinical report (record artifact)",
                                                    "Professional allied to medicine clinical report",
                                                    "Dokument ausserhalb des Behandlungskontextes",
                                                    "Document hors contexte de traitement",
                                                    "Documento al di fuori del contesto trattato"),
    /**
     * EN: Progress note<br>
     * DE: Verlaufsbericht<br>
     * FR: Rapport d’historique<br>
     * IT: Rapporto sul decorso<br>
     */
    PROGRESS_NOTE("371532007",
                  "2.16.840.1.113883.6.96",
                  "Progress report (record artifact)",
                  "Progress note",
                  "Verlaufsbericht",
                  "Rapport d’historique",
                  "Rapporto sul decorso"),
    /**
     * EN: Record artifact<br>
     * DE: Nicht näher bezeichnetes Dokument<br>
     * FR: Document non précisé<br>
     * IT: Documento non meglio specificato<br>
     */
    RECORD_ARTIFACT("419891008",
                    "2.16.840.1.113883.6.96",
                    "Record artifact (record artifact)",
                    "Record artifact",
                    "Nicht näher bezeichnetes Dokument",
                    "Document non précisé",
                    "Documento non meglio specificato"),
    /**
     * EN: Rehabilitation care plan<br>
     * DE: Rehabilitationsplan<br>
     * FR: Plan de réhabilitation<br>
     * IT: Piano di riabilitazione<br>
     */
    REHABILITATION_CARE_PLAN("736055001",
                             "2.16.840.1.113883.6.96",
                             "Rehabilitation care plan (record artifact)",
                             "Rehabilitation care plan",
                             "Rehabilitationsplan",
                             "Plan de réhabilitation",
                             "Piano di riabilitazione"),
    /**
     * EN: Transfer summary report<br>
     * DE: Überweisungsbericht<br>
     * FR: Rapport de transfert<br>
     * IT: Rapporto di trasferimento<br>
     */
    TRANSFER_SUMMARY_REPORT("371535009",
                            "2.16.840.1.113883.6.96",
                            "Transfer summary report (record artifact)",
                            "Transfer summary report",
                            "Überweisungsbericht",
                            "Rapport de transfert",
                            "Rapporto di trasferimento");

    /**
     * EN: Code for Allergy record<br>
     * DE: Code für Allergieausweis<br>
     * FR: Code de Carnet des allergies<br>
     * IT: Code per Passaporto delle allergie<br>
     */
    public static final String ALLERGY_RECORD_CODE = "722446000";

    /**
     * EN: Code for Clinical Management plan<br>
     * DE: Code für Behandlungsplan<br>
     * FR: Code de Plan de traitement<br>
     * IT: Code per Piano di trattamento<br>
     */
    public static final String CLINICAL_MANAGEMENT_PLAN_CODE = "737427001";

    /**
     * EN: Code for Consultation report<br>
     * DE: Code für Beurteilung durch Fachspezialisten<br>
     * FR: Code de Évaluation par des spécialistes<br>
     * IT: Code per Valutazione dello specialista<br>
     */
    public static final String CONSULTATION_REPORT_CODE = "371530004";

    /**
     * EN: Code for Discharge summary<br>
     * DE: Code für Austrittsbericht<br>
     * FR: Code de Rapport de sortie<br>
     * IT: Code per Rapporto di dimissione<br>
     */
    public static final String DISCHARGE_SUMMARY_CODE = "373942005";

    /**
     * EN: Code for Emergency department record<br>
     * DE: Code für Notfallberichtt<br>
     * FR: Code de Rapport d’urgence<br>
     * IT: Code per Referto di pronto soccorso<br>
     */
    public static final String EMERGENCY_DEPARTMENT_RECORD_CODE = "445300006";

    /**
     * EN: Code for History and physical report<br>
     * DE: Code für Anamnese / Untersuchungsbericht<br>
     * FR: Code de Anamnèse / rapport d’analyse<br>
     * IT: Code per Anamnesi / Rapporto di visita medica<br>
     */
    public static final String HISTORY_AND_PHYSICAL_REPORT_CODE = "371529009";

    /**
     * EN: Code for Image<br>
     * DE: Code für Bild<br>
     * FR: Code de Image<br>
     * IT: Code per Immagine<br>
     */
    public static final String IMAGE_CODE = "900000000000471006";

    /**
     * EN: Code for Imaging Order<br>
     * DE: Code für Bildgebungsauftrag<br>
     * FR: Code de Mandat d’imagerie<br>
     * IT: Code per Richiesta di immaginografia<br>
     */
    public static final String IMAGING_ORDER_CODE = "2161000195103";

    /**
     * EN: Code for Imaging report<br>
     * DE: Code für Befundbericht zur Bildgebung<br>
     * FR: Code de Rapport de résultat relatif à l’imagerie<br>
     * IT: Code per Referto di immaginografia<br>
     */
    public static final String IMAGING_REPORT_CODE = "4201000179104";

    /**
     * EN: Code for Immunization record<br>
     * DE: Code für Impfausweis<br>
     * FR: Code de Carnet de vaccination<br>
     * IT: Code per Certificato di vaccinazione<br>
     */
    public static final String IMMUNIZATION_RECORD_CODE = "41000179103";

    /**
     * EN: Code for Laboratory Order<br>
     * DE: Code für Laborauftrag<br>
     * FR: Code de Mandat d’analyse en laboratoire<br>
     * IT: Code per Richiesta di analisi di laboratorio<br>
     */
    public static final String LABORATORY_ORDER_CODE = "721965002";

    /**
     * EN: Code for Laboratory report<br>
     * DE: Code für Laborbericht<br>
     * FR: Code de Rapport de laboratoire<br>
     * IT: Code per Referto di laboratorio<br>
     */
    public static final String LABORATORY_REPORT_CODE = "4241000179101";

    /**
     * EN: Code for Medical certificate<br>
     * DE: Code für Ärztliches Attest<br>
     * FR: Code de Certificat médical<br>
     * IT: Code per Certificato medico<br>
     */
    public static final String MEDICAL_CERTIFICATE_CODE = "772786005";

    /**
     * EN: Code for Medical Prescription record<br>
     * DE: Code für Arzneimittel-Verschreibung / Rezept<br>
     * FR: Code de Prescription de médicaments / ordonnance<br>
     * IT: Code per Prescrizione di medicamenti<br>
     */
    public static final String MEDICAL_PRESCRIPTION_RECORD_CODE = "761938008";

    /**
     * EN: Code for Medication summary document<br>
     * DE: Code für Medikationsliste<br>
     * FR: Code de Liste de médication<br>
     * IT: Code per Elenco dei medicamenti<br>
     */
    public static final String MEDICATION_SUMMARY_DOCUMENT_CODE = "721912009";

    /**
     * EN: Code for Non-drug prescription<br>
     * DE: Code für Nicht-Arzneimittel-Verschreibung / Rezept<br>
     * FR: Code de Prescription sans médicaments / ordonnance<br>
     * IT: Code per Prescrizione non di medicamenti<br>
     */
    public static final String NON_DRUG_PRESCRIPTION_CODE = "765492005";

    /**
     * EN: Code for Nursing care plan<br>
     * DE: Code für Pflegeplan<br>
     * FR: Code de Plan de soins<br>
     * IT: Code per Piano di cura<br>
     */
    public static final String NURSING_CARE_PLAN_CODE = "773130005";

    /**
     * EN: Code for Operative report<br>
     * DE: Code für Operationsbericht<br>
     * FR: Code de Rapport d’opération<br>
     * IT: Code per Rapporto operatorio<br>
     */
    public static final String OPERATIVE_REPORT_CODE = "371526002";

    /**
     * EN: Code for Pathology order<br>
     * DE: Code für Pathologieauftrag<br>
     * FR: Code de Mandat de rapport d’examen pathologique <br>
     * IT: Code per Richiesta di esame istologico<br>
     */
    public static final String PATHOLOGY_ORDER_CODE = "721966001";

    /**
     * EN: Code for Pathology report<br>
     * DE: Code für Pathologiebericht<br>
     * FR: Code de Rapport d’examen pathologique<br>
     * IT: Code per Referto istologico<br>
     */
    public static final String PATHOLOGY_REPORT_CODE = "371528001";

    /**
     * EN: Code for Professional allied to medicine clinical report<br>
     * DE: Code für Dokument ausserhalb des Behandlungskontextes<br>
     * FR: Code de Document hors contexte de traitement<br>
     * IT: Code per Documento al di fuori del contesto trattato<br>
     */
    public static final String PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT_CODE = "445418005";

    /**
     * EN: Code for Progress note<br>
     * DE: Code für Verlaufsbericht<br>
     * FR: Code de Rapport d’historique<br>
     * IT: Code per Rapporto sul decorso<br>
     */
    public static final String PROGRESS_NOTE_CODE = "371532007";

    /**
     * EN: Code for Record artifact<br>
     * DE: Code für Nicht näher bezeichnetes Dokument<br>
     * FR: Code de Document non précisé<br>
     * IT: Code per Documento non meglio specificato<br>
     */
    public static final String RECORD_ARTIFACT_CODE = "419891008";

    /**
     * EN: Code for Rehabilitation care plan<br>
     * DE: Code für Rehabilitationsplan<br>
     * FR: Code de Plan de réhabilitation<br>
     * IT: Code per Piano di riabilitazione<br>
     */
    public static final String REHABILITATION_CARE_PLAN_CODE = "736055001";

    /**
     * EN: Code for Transfer summary report<br>
     * DE: Code für Überweisungsbericht<br>
     * FR: Code de Rapport de transfert<br>
     * IT: Code per Rapporto di trasferimento<br>
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
    public static TypeCode getEnum(final String code) {
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
    public static boolean isEnumOfValueSet(final String enumName) {
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
    public static boolean isInValueSet(final String codeValue) {
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
    TypeCode(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
