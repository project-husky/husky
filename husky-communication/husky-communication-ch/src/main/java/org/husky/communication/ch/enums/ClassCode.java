/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.ch.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.classCode values
 * <p>
 * EN: Document class as per EPRO-FDHA Annex 3.<br>
 * DE: Dokumentenklasse gemäss EPDV-EDI Anhang 3.<br>
 * FR: Classification du document selon l'annexe 3 ODEP-DFI.<br>
 * IT: Classe del documento secondo l'allegato 3 OCIP-DFI.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.3<br>
 * Effective date: 2021-04-01 16:32<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-12-09")
public enum ClassCode implements ValueSetEnumInterface {

    /**
     * EN: Administrative documentation.<br>
     * DE: Administratives Dokument.<br>
     * FR: Document administratif.<br>
     * IT: Documento amministrativo.<br>
     */
    ADMINISTRATIVE_DOCUMENTATION("405624007",
                                 "2.16.840.1.113883.6.96",
                                 "Administrative documentation (record artifact)",
                                 "Administrative documentation",
                                 "Administratives Dokument",
                                 "Document administratif",
                                 "Documento amministrativo"),
    /**
     * EN: Advance directive report.<br>
     * DE: Patientenverfügung.<br>
     * FR: Directives anticipées.<br>
     * IT: Direttive del paziente.<br>
     */
    ADVANCE_DIRECTIVE_REPORT("371538006",
                             "2.16.840.1.113883.6.96",
                             "Advance directive report (record artifact)",
                             "Advance directive report",
                             "Patientenverfügung",
                             "Directives anticipées",
                             "Direttive del paziente"),
    /**
     * EN: Audit trail report.<br>
     * DE: Rückverfolgung der EPD Zugriffe.<br>
     * FR: Traçabilité des accès aux DEP.<br>
     * IT: Cronologia degli accessi alla CIP.<br>
     */
    AUDIT_TRAIL_REPORT("722160009",
                       "2.16.840.1.113883.6.96",
                       "Audit trail report (record artifact)",
                       "Audit trail report",
                       "Rückverfolgung der EPD Zugriffe",
                       "Traçabilité des accès aux DEP",
                       "Cronologia degli accessi alla CIP"),
    /**
     * EN: Care Plan.<br>
     * DE: Behandlungsplan.<br>
     * FR: Plan de traitement.<br>
     * IT: Piano di trattamento.<br>
     */
    CARE_PLAN("734163000",
              "2.16.840.1.113883.6.96",
              "Care Plan (record artifact)",
              "Care Plan",
              "Behandlungsplan",
              "Plan de traitement",
              "Piano di trattamento"),
    /**
     * EN: Clinical procedure report.<br>
     * DE: Interventionsbericht / Untersuchungsresultat.<br>
     * FR: Rapport d’intervention / résultat de l’analyse.<br>
     * IT: Rapporto operatorio / Referto di analisi.<br>
     */
    CLINICAL_PROCEDURE_REPORT("371525003",
                              "2.16.840.1.113883.6.96",
                              "Clinical procedure report (record artifact)",
                              "Clinical procedure report",
                              "Interventionsbericht / Untersuchungsresultat",
                              "Rapport d’intervention / résultat de l’analyse",
                              "Rapporto operatorio / Referto di analisi"),
    /**
     * EN: Consent report.<br>
     * DE: Einwilligung zur Behandlung.<br>
     * FR: Consentement au traitement.<br>
     * IT: Consenso al trattamento.<br>
     */
    CONSENT_REPORT("371537001",
                   "2.16.840.1.113883.6.96",
                   "Consent report (record artifact)",
                   "Consent report",
                   "Einwilligung zur Behandlung",
                   "Consentement au traitement",
                   "Consenso al trattamento"),
    /**
     * EN: Emergency medical identification record.<br>
     * DE: Notfall-ID / Ausweis.<br>
     * FR: ID d’urgence / carte d’urgence.<br>
     * IT: Identificativo d'emergenza / scheda d'emergenza.<br>
     */
    EMERGENCY_MEDICAL_IDENTIFICATION_RECORD("722216001",
                                            "2.16.840.1.113883.6.96",
                                            "Emergency medical identification record (record artifact)",
                                            "Emergency medical identification record",
                                            "Notfall-ID / Ausweis",
                                            "ID d’urgence / carte d’urgence",
                                            "Identificativo d'emergenza / scheda d'emergenza"),
    /**
     * EN: Obstetrical Record.<br>
     * DE: Schwangerschafts-/ Geburtsbericht.<br>
     * FR: Rapport de grossesse / de naissance.<br>
     * IT: Referto della gravidanza / del parto.<br>
     */
    OBSTETRICAL_RECORD("2171000195109",
                       "2.16.756.5.30.1.127.3.4",
                       "Obstetrical Record (record artifact)",
                       "Obstetrical Record",
                       "Schwangerschafts-/ Geburtsbericht",
                       "Rapport de grossesse / de naissance",
                       "Referto della gravidanza / del parto"),
    /**
     * EN: Order.<br>
     * DE: Untersuchungsauftrag.<br>
     * FR: Mandat d’analyse.<br>
     * IT: Prescrizione di analisi.<br>
     */
    ORDER("721963009",
          "2.16.840.1.113883.6.96",
          "Order (record artifact)",
          "Order",
          "Untersuchungsauftrag",
          "Mandat d’analyse",
          "Prescrizione di analisi"),
    /**
     * EN: Organ donor card.<br>
     * DE: Organspendeausweis.<br>
     * FR: Carte de donneur d’organes.<br>
     * IT: Tessera di donatore di organi.<br>
     */
    ORGAN_DONOR_CARD("772790007",
                     "2.16.840.1.113883.6.96",
                     "Organ donor card (record artifact)",
                     "Organ donor card",
                     "Organspendeausweis",
                     "Carte de donneur d’organes",
                     "Tessera di donatore di organi"),
    /**
     * EN: Patient record type.<br>
     * DE: Langzeitdokumentation.<br>
     * FR: Documentation à long terme.<br>
     * IT: Documentazione a lungo termine.<br>
     */
    PATIENT_RECORD_TYPE("184216000",
                        "2.16.840.1.113883.6.96",
                        "Patient record type (record artifact)",
                        "Patient record type",
                        "Langzeitdokumentation",
                        "Documentation à long terme",
                        "Documentazione a lungo termine"),
    /**
     * EN: Prescription record.<br>
     * DE: Verschreibung / Rezept.<br>
     * FR: Prescription / ordonnance.<br>
     * IT: Prescrizione medica.<br>
     */
    PRESCRIPTION_RECORD("440545006",
                        "2.16.840.1.113883.6.96",
                        "Prescription record (record artifact)",
                        "Prescription record",
                        "Verschreibung / Rezept",
                        "Prescription / ordonnance",
                        "Prescrizione medica"),
    /**
     * EN: Record artifact.<br>
     * DE: Nicht näher bezeichnetes Dokument.<br>
     * FR: Document non précisé.<br>
     * IT: Documento non meglio specificato.<br>
     */
    RECORD_ARTIFACT("419891008",
                    "2.16.840.1.113883.6.96",
                    "Record artifact (record artifact)",
                    "Record artifact",
                    "Nicht näher bezeichnetes Dokument",
                    "Document non précisé",
                    "Documento non meglio specificato"),
    /**
     * EN: Record of health event.<br>
     * DE: Dokument zu gesundheitsrelevantem Ereignis.<br>
     * FR: Document sur l’événement sanitaire.<br>
     * IT: Documento concernente un evento rilevante per la salute.<br>
     */
    RECORD_OF_HEALTH_EVENT("417319006",
                           "2.16.840.1.113883.6.96",
                           "Record of health event (record artifact)",
                           "Record of health event",
                           "Dokument zu gesundheitsrelevantem Ereignis",
                           "Document sur l’événement sanitaire",
                           "Documento concernente un evento rilevante per la salute"),
    /**
     * EN: Referral note.<br>
     * DE: Zuweisungsschreiben.<br>
     * FR: Lettre de référence.<br>
     * IT: Lettera d'invio.<br>
     */
    REFERRAL_NOTE("721927009",
                  "2.16.840.1.113883.6.96",
                  "Referral note (record artifact)",
                  "Referral note",
                  "Zuweisungsschreiben",
                  "Lettre de référence",
                  "Lettera d'invio"),
    /**
     * EN: Report of clinical encounter.<br>
     * DE: Bericht aufgrund einer Konsultation.<br>
     * FR: Rapport suite à une consultation.<br>
     * IT: Rapporto di visita medica.<br>
     */
    REPORT_OF_CLINICAL_ENCOUNTER("371531000",
                                 "2.16.840.1.113883.6.96",
                                 "Report of clinical encounter (record artifact)",
                                 "Report of clinical encounter",
                                 "Bericht aufgrund einer Konsultation",
                                 "Rapport suite à une consultation",
                                 "Rapporto di visita medica"),
    /**
     * EN: Summary clinical document.<br>
     * DE: Zusammenfassender Bericht.<br>
     * FR: Rapport de synthèse.<br>
     * IT: Rapporto riassuntivo.<br>
     */
    SUMMARY_CLINICAL_DOCUMENT("422735006",
                              "2.16.840.1.113883.6.96",
                              "Summary clinical document (record artifact)",
                              "Summary clinical document",
                              "Zusammenfassender Bericht",
                              "Rapport de synthèse",
                              "Rapporto riassuntivo");

    /**
     * EN: Code for Administrative documentation.<br>
     * DE: Code für Administratives Dokument.<br>
     * FR: Code de Document administratif.<br>
     * IT: Code per Documento amministrativo.<br>
     */
    public static final String ADMINISTRATIVE_DOCUMENTATION_CODE = "405624007";

    /**
     * EN: Code for Advance directive report.<br>
     * DE: Code für Patientenverfügung.<br>
     * FR: Code de Directives anticipées.<br>
     * IT: Code per Direttive del paziente.<br>
     */
    public static final String ADVANCE_DIRECTIVE_REPORT_CODE = "371538006";

    /**
     * EN: Code for Audit trail report.<br>
     * DE: Code für Rückverfolgung der EPD Zugriffe.<br>
     * FR: Code de Traçabilité des accès aux DEP.<br>
     * IT: Code per Cronologia degli accessi alla CIP.<br>
     */
    public static final String AUDIT_TRAIL_REPORT_CODE = "722160009";

    /**
     * EN: Code for Care Plan.<br>
     * DE: Code für Behandlungsplan.<br>
     * FR: Code de Plan de traitement.<br>
     * IT: Code per Piano di trattamento.<br>
     */
    public static final String CARE_PLAN_CODE = "734163000";

    /**
     * EN: Code for Clinical procedure report.<br>
     * DE: Code für Interventionsbericht / Untersuchungsresultat.<br>
     * FR: Code de Rapport d’intervention / résultat de l’analyse.<br>
     * IT: Code per Rapporto operatorio / Referto di analisi.<br>
     */
    public static final String CLINICAL_PROCEDURE_REPORT_CODE = "371525003";

    /**
     * EN: Code for Consent report.<br>
     * DE: Code für Einwilligung zur Behandlung.<br>
     * FR: Code de Consentement au traitement.<br>
     * IT: Code per Consenso al trattamento.<br>
     */
    public static final String CONSENT_REPORT_CODE = "371537001";

    /**
     * EN: Code for Emergency medical identification record.<br>
     * DE: Code für Notfall-ID / Ausweis.<br>
     * FR: Code de ID d’urgence / carte d’urgence.<br>
     * IT: Code per Identificativo d'emergenza / scheda d'emergenza.<br>
     */
    public static final String EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_CODE = "722216001";

    /**
     * EN: Code for Obstetrical Record.<br>
     * DE: Code für Schwangerschafts-/ Geburtsbericht.<br>
     * FR: Code de Rapport de grossesse / de naissance.<br>
     * IT: Code per Referto della gravidanza / del parto.<br>
     */
    public static final String OBSTETRICAL_RECORD_CODE = "2171000195109";

    /**
     * EN: Code for Order.<br>
     * DE: Code für Untersuchungsauftrag.<br>
     * FR: Code de Mandat d’analyse.<br>
     * IT: Code per Prescrizione di analisi.<br>
     */
    public static final String ORDER_CODE = "721963009";

    /**
     * EN: Code for Organ donor card.<br>
     * DE: Code für Organspendeausweis.<br>
     * FR: Code de Carte de donneur d’organes.<br>
     * IT: Code per Tessera di donatore di organi.<br>
     */
    public static final String ORGAN_DONOR_CARD_CODE = "772790007";

    /**
     * EN: Code for Patient record type.<br>
     * DE: Code für Langzeitdokumentation.<br>
     * FR: Code de Documentation à long terme.<br>
     * IT: Code per Documentazione a lungo termine.<br>
     */
    public static final String PATIENT_RECORD_TYPE_CODE = "184216000";

    /**
     * EN: Code for Prescription record.<br>
     * DE: Code für Verschreibung / Rezept.<br>
     * FR: Code de Prescription / ordonnance.<br>
     * IT: Code per Prescrizione medica.<br>
     */
    public static final String PRESCRIPTION_RECORD_CODE = "440545006";

    /**
     * EN: Code for Record artifact.<br>
     * DE: Code für Nicht näher bezeichnetes Dokument.<br>
     * FR: Code de Document non précisé.<br>
     * IT: Code per Documento non meglio specificato.<br>
     */
    public static final String RECORD_ARTIFACT_CODE = "419891008";

    /**
     * EN: Code for Record of health event.<br>
     * DE: Code für Dokument zu gesundheitsrelevantem Ereignis.<br>
     * FR: Code de Document sur l’événement sanitaire.<br>
     * IT: Code per Documento concernente un evento rilevante per la salute.<br>
     */
    public static final String RECORD_OF_HEALTH_EVENT_CODE = "417319006";

    /**
     * EN: Code for Referral note.<br>
     * DE: Code für Zuweisungsschreiben.<br>
     * FR: Code de Lettre de référence.<br>
     * IT: Code per Lettera d'invio.<br>
     */
    public static final String REFERRAL_NOTE_CODE = "721927009";

    /**
     * EN: Code for Report of clinical encounter.<br>
     * DE: Code für Bericht aufgrund einer Konsultation.<br>
     * FR: Code de Rapport suite à une consultation.<br>
     * IT: Code per Rapporto di visita medica.<br>
     */
    public static final String REPORT_OF_CLINICAL_ENCOUNTER_CODE = "371531000";

    /**
     * EN: Code for Summary clinical document.<br>
     * DE: Code für Zusammenfassender Bericht.<br>
     * FR: Code de Rapport de synthèse.<br>
     * IT: Code per Rapporto riassuntivo.<br>
     */
    public static final String SUMMARY_CLINICAL_DOCUMENT_CODE = "422735006";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.classCode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ClassCode getEnum(@Nullable final String code) {
        for (final ClassCode x : values()) {
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
            Enum.valueOf(ClassCode.class,
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
        for (final ClassCode x : values()) {
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
    ClassCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
