/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.beta;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.classCode values
 * <p>
 * EN: Document class as per EPRO-FDHA Annex 3.<br>
 * DE: Dokumentenklasse gemäss EPDV-EDI Anhang 3.<br>
 * FR: Classification du document selon l'annexe 3 ODEP-DFI.<br>
 * IT: Classe del documento secondo l'allegato 3 OCIP-DFI.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.3<br>
 * Effective date: 2022-06-25 19:03<br>
 * Version: 202304.0-beta<br>
 * Status: DRAFT
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-09-29")
public enum ClassCode implements ValueSetEnumInterface {

    /**
     * EN: Administrative document.<br>
     * DE: Administratives Dokument.<br>
     * FR: document administratif.<br>
     * IT: documento amministrativo.<br>
     */
    ADMINISTRATIVE_DOCUMENT("405624007",
                            "2.16.840.1.113883.6.96",
                            "Administrative documentation (record artifact)",
                            "Administrative document",
                            "Administratives Dokument",
                            "document administratif",
                            "documento amministrativo"),
    /**
     * EN: Advance directives.<br>
     * DE: Patientenverfügung.<br>
     * FR: directives anticipées.<br>
     * IT: direttive anticipate.<br>
     */
    ADVANCE_DIRECTIVES("371538006",
                       "2.16.840.1.113883.6.96",
                       "Advance directive report (record artifact)",
                       "Advance directives",
                       "Patientenverfügung",
                       "directives anticipées",
                       "direttive anticipate"),
    /**
     * EN: Birth report.<br>
     * DE: Schwangerschaftsbericht.<br>
     * FR: rapport de grossesse.<br>
     * IT: rapporto di gravidanza.<br>
     */
    BIRTH_REPORT("2171000195109",
                 "2.16.756.5.30.1.127.3.4",
                 "Obstetrical record (record artifact)",
                 "Birth report",
                 "Schwangerschaftsbericht",
                 "rapport de grossesse",
                 "rapporto di gravidanza"),
    /**
     * EN: Care plan.<br>
     * DE: Behandlungsplan.<br>
     * FR: plans de soins.<br>
     * IT: piano di cura.<br>
     */
    CARE_PLAN("734163000",
              "2.16.840.1.113883.6.96",
              "Care plan (record artifact)",
              "Care plan",
              "Behandlungsplan",
              "plans de soins",
              "piano di cura"),
    /**
     * EN: Consent.<br>
     * DE: Einverständniserklärung.<br>
     * FR: consentement.<br>
     * IT: consenso.<br>
     */
    CONSENT("371537001",
            "2.16.840.1.113883.6.96",
            "Consent report (record artifact)",
            "Consent",
            "Einverständniserklärung",
            "consentement",
            "consenso"),
    /**
     * EN: Emergency ID card.<br>
     * DE: Notfallkarte.<br>
     * FR: carte d'urgence.<br>
     * IT: tessera di emergenza.<br>
     */
    EMERGENCY_ID_CARD("722216001",
                      "2.16.840.1.113883.6.96",
                      "Emergency medical identification record (record artifact)",
                      "Emergency ID card",
                      "Notfallkarte",
                      "carte d'urgence",
                      "tessera di emergenza"),
    /**
     * EN: Event report.<br>
     * DE: Dokument zu gesundheitsrelevantem Ereignis.<br>
     * FR: document sur l'événement sanitaire.<br>
     * IT: documento concernente un evento rilevante per la salute.<br>
     */
    EVENT_REPORT("417319006",
                 "2.16.840.1.113883.6.96",
                 "Record of health event (record artifact)",
                 "Event report",
                 "Dokument zu gesundheitsrelevantem Ereignis",
                 "document sur l'événement sanitaire",
                 "documento concernente un evento rilevante per la salute"),
    /**
     * EN: Order.<br>
     * DE: Untersuchungsauftrag.<br>
     * FR: demande d'examen.<br>
     * IT: richiesta di esami.<br>
     */
    ORDER("721963009",
          "2.16.840.1.113883.6.96",
          "Order (record artifact)",
          "Order",
          "Untersuchungsauftrag",
          "demande d'examen",
          "richiesta di esami"),
    /**
     * EN: Organ donor card.<br>
     * DE: Organspendeausweis.<br>
     * FR: carte de donneur d'organes.<br>
     * IT: tessera di donatore di organi.<br>
     */
    ORGAN_DONOR_CARD("772790007",
                     "2.16.840.1.113883.6.96",
                     "Organ donor card (record artifact)",
                     "Organ donor card",
                     "Organspendeausweis",
                     "carte de donneur d'organes",
                     "tessera di donatore di organi"),
    /**
     * EN: Other documentation.<br>
     * DE: Sonstige Dokumentation.<br>
     * FR: autre documentation.<br>
     * IT: altra documentazione.<br>
     */
    OTHER_DOCUMENTATION("419891008",
                        "2.16.840.1.113883.6.96",
                        "Record artifact (record artifact)",
                        "Other documentation",
                        "Sonstige Dokumentation",
                        "autre documentation",
                        "altra documentazione"),
    /**
     * EN: Patient documentation.<br>
     * DE: Patientendokumentation.<br>
     * FR: documentation du patient.<br>
     * IT: documentazione del paziente.<br>
     */
    PATIENT_DOCUMENTATION("184216000",
                          "2.16.840.1.113883.6.96",
                          "Patient record type (record artifact)",
                          "Patient documentation",
                          "Patientendokumentation",
                          "documentation du patient",
                          "documentazione del paziente"),
    /**
     * EN: Prescription.<br>
     * DE: Rezept.<br>
     * FR: ordonnance.<br>
     * IT: prescrizione medica.<br>
     */
    PRESCRIPTION("440545006",
                 "2.16.840.1.113883.6.96",
                 "Prescription record (record artifact)",
                 "Prescription",
                 "Rezept",
                 "ordonnance",
                 "prescrizione medica"),
    /**
     * EN: Procedure report.<br>
     * DE: Interventionsbericht.<br>
     * FR: rapport d'intervention.<br>
     * IT: rapporto operatorio.<br>
     */
    PROCEDURE_REPORT("371525003",
                     "2.16.840.1.113883.6.96",
                     "Clinical procedure report (record artifact)",
                     "Procedure report",
                     "Interventionsbericht",
                     "rapport d'intervention",
                     "rapporto operatorio"),
    /**
     * EN: Record access.<br>
     * DE: Rückverfolgung der EPD Zugriffe.<br>
     * FR: traçabilité des accès aux DEP.<br>
     * IT: calloutronologia degli accessi alla CIP.<br>
     */
    RECORD_ACCESS("722160009",
                  "2.16.840.1.113883.6.96",
                  "Audit trail report (record artifact)",
                  "Record access",
                  "Rückverfolgung der EPD Zugriffe",
                  "traçabilité des accès aux DEP",
                  "calloutronologia degli accessi alla CIP"),
    /**
     * EN: Referral note.<br>
     * DE: Zuweisungsschreiben.<br>
     * FR: lettre de référence.<br>
     * IT: lettera d'invio.<br>
     */
    REFERRAL_NOTE("721927009",
                  "2.16.840.1.113883.6.96",
                  "Referral note (record artifact)",
                  "Referral note",
                  "Zuweisungsschreiben",
                  "lettre de référence",
                  "lettera d'invio"),
    /**
     * EN: Report of clinical encounter.<br>
     * DE: Konsultationsbericht.<br>
     * FR: rapport de consultation.<br>
     * IT: rapporto di visita medica.<br>
     */
    REPORT_OF_CLINICAL_ENCOUNTER("371531000",
                                 "2.16.840.1.113883.6.96",
                                 "Report of clinical encounter (record artifact)",
                                 "Report of clinical encounter",
                                 "Konsultationsbericht",
                                 "rapport de consultation",
                                 "rapporto di visita medica"),
    /**
     * EN: Summary.<br>
     * DE: Zusammenfassung.<br>
     * FR: résumé.<br>
     * IT: riepilogo.<br>
     */
    SUMMARY("422735006",
            "2.16.840.1.113883.6.96",
            "Summary clinical document (record artifact)",
            "Summary",
            "Zusammenfassung",
            "résumé",
            "riepilogo");

    /**
     * EN: Code for Administrative document.<br>
     * DE: Code für Administratives Dokument.<br>
     * FR: Code de document administratif.<br>
     * IT: Code per documento amministrativo.<br>
     */
    public static final String ADMINISTRATIVE_DOCUMENT_CODE = "405624007";

    /**
     * EN: Code for Advance directives.<br>
     * DE: Code für Patientenverfügung.<br>
     * FR: Code de directives anticipées.<br>
     * IT: Code per direttive anticipate.<br>
     */
    public static final String ADVANCE_DIRECTIVES_CODE = "371538006";

    /**
     * EN: Code for Birth report.<br>
     * DE: Code für Schwangerschaftsbericht.<br>
     * FR: Code de rapport de grossesse.<br>
     * IT: Code per rapporto di gravidanza.<br>
     */
    public static final String BIRTH_REPORT_CODE = "2171000195109";

    /**
     * EN: Code for Care plan.<br>
     * DE: Code für Behandlungsplan.<br>
     * FR: Code de plans de soins.<br>
     * IT: Code per piano di cura.<br>
     */
    public static final String CARE_PLAN_CODE = "734163000";

    /**
     * EN: Code for Consent.<br>
     * DE: Code für Einverständniserklärung.<br>
     * FR: Code de consentement.<br>
     * IT: Code per consenso.<br>
     */
    public static final String CONSENT_CODE = "371537001";

    /**
     * EN: Code for Emergency ID card.<br>
     * DE: Code für Notfallkarte.<br>
     * FR: Code de carte d'urgence.<br>
     * IT: Code per tessera di emergenza.<br>
     */
    public static final String EMERGENCY_ID_CARD_CODE = "722216001";

    /**
     * EN: Code for Event report.<br>
     * DE: Code für Dokument zu gesundheitsrelevantem Ereignis.<br>
     * FR: Code de document sur l'événement sanitaire.<br>
     * IT: Code per documento concernente un evento rilevante per la salute.<br>
     */
    public static final String EVENT_REPORT_CODE = "417319006";

    /**
     * EN: Code for Order.<br>
     * DE: Code für Untersuchungsauftrag.<br>
     * FR: Code de demande d'examen.<br>
     * IT: Code per richiesta di esami.<br>
     */
    public static final String ORDER_CODE = "721963009";

    /**
     * EN: Code for Organ donor card.<br>
     * DE: Code für Organspendeausweis.<br>
     * FR: Code de carte de donneur d'organes.<br>
     * IT: Code per tessera di donatore di organi.<br>
     */
    public static final String ORGAN_DONOR_CARD_CODE = "772790007";

    /**
     * EN: Code for Other documentation.<br>
     * DE: Code für Sonstige Dokumentation.<br>
     * FR: Code de autre documentation.<br>
     * IT: Code per altra documentazione.<br>
     */
    public static final String OTHER_DOCUMENTATION_CODE = "419891008";

    /**
     * EN: Code for Patient documentation.<br>
     * DE: Code für Patientendokumentation.<br>
     * FR: Code de documentation du patient.<br>
     * IT: Code per documentazione del paziente.<br>
     */
    public static final String PATIENT_DOCUMENTATION_CODE = "184216000";

    /**
     * EN: Code for Prescription.<br>
     * DE: Code für Rezept.<br>
     * FR: Code de ordonnance.<br>
     * IT: Code per prescrizione medica.<br>
     */
    public static final String PRESCRIPTION_CODE = "440545006";

    /**
     * EN: Code for Procedure report.<br>
     * DE: Code für Interventionsbericht.<br>
     * FR: Code de rapport d'intervention.<br>
     * IT: Code per rapporto operatorio.<br>
     */
    public static final String PROCEDURE_REPORT_CODE = "371525003";

    /**
     * EN: Code for Record access.<br>
     * DE: Code für Rückverfolgung der EPD Zugriffe.<br>
     * FR: Code de traçabilité des accès aux DEP.<br>
     * IT: Code per calloutronologia degli accessi alla CIP.<br>
     */
    public static final String RECORD_ACCESS_CODE = "722160009";

    /**
     * EN: Code for Referral note.<br>
     * DE: Code für Zuweisungsschreiben.<br>
     * FR: Code de lettre de référence.<br>
     * IT: Code per lettera d'invio.<br>
     */
    public static final String REFERRAL_NOTE_CODE = "721927009";

    /**
     * EN: Code for Report of clinical encounter.<br>
     * DE: Code für Konsultationsbericht.<br>
     * FR: Code de rapport de consultation.<br>
     * IT: Code per rapporto di visita medica.<br>
     */
    public static final String REPORT_OF_CLINICAL_ENCOUNTER_CODE = "371531000";

    /**
     * EN: Code for Summary.<br>
     * DE: Code für Zusammenfassung.<br>
     * FR: Code de résumé.<br>
     * IT: Code per riepilogo.<br>
     */
    public static final String SUMMARY_CODE = "422735006";

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
