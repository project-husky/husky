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
 * Enumeration of EprAuditTrailConsumptionEventType values
 * <p>
 * EN: Audit Trail Consumption Event Types for CH:ATC.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.13.2<br>
 * Effective date: 2019-12-11 09:03<br>
 * Version: 201907.2-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-12-09")
public enum AuditTrailConsumptionEventType implements ValueSetEnumInterface {

    /**
     * EN: Accessing the Patient Audit Record Repository.<br>
     * DE: Auf die patientenbezogene Auditprotokoll-Ablage zugreifen.<br>
     * FR: En cours d’accès au dépôt de contrôle des dossiers de patients.<br>
     * IT: Accesso all'Audit Record Repository del paziente.<br>
     */
    ACCESSING_THE_PATIENT_AUDIT_RECORD_REPOSITORY("ATC_LOG_READ",
                                                  "2.16.756.5.30.1.127.3.10.7",
                                                  "Accessing the Patient Audit Record Repository",
                                                  "Accessing the Patient Audit Record Repository",
                                                  "Auf die patientenbezogene Auditprotokoll-Ablage zugreifen",
                                                  "En cours d’accès au dépôt de contrôle des dossiers de patients",
                                                  "Accesso all'Audit Record Repository del paziente"),
    /**
     * EN: Assign a Healthcare Professional to Blacklist.<br>
     * DE: Gesundheitsfachperson auf die schwarze Liste setzen.<br>
     * FR: Ajouter un professionnel de la santé à la liste noire.<br>
     * IT: Aggiungere un professionista della salute alla lista nera.<br>
     */
    ASSIGN_A_HEALTHCARE_PROFESSIONAL_TO_BLACKLIST("ATC_POL_INCL_BLACKLIST",
                                                  "2.16.756.5.30.1.127.3.10.7",
                                                  "Assign a Healthcare Professional to Blacklist",
                                                  "Assign a Healthcare Professional to Blacklist",
                                                  "Gesundheitsfachperson auf die schwarze Liste setzen",
                                                  "Ajouter un professionnel de la santé à la liste noire",
                                                  "Aggiungere un professionista della salute alla lista nera"),
    /**
     * EN: Authorize participants to access level/date.<br>
     * DE: Teilnehmende für Zugriffsstufe/Datum autorisieren.<br>
     * FR: Autoriser les participants pour ce niveau d’accès / à cette date.<br>
     * IT: Autorizzare i partecipanti ad accedere a un livello/una data.<br>
     */
    AUTHORIZE_PARTICIPANTS_TO_ACCESS_LEVEL_DATE("ATC_POL_CREATE_AUT_PART_AL",
                                                "2.16.756.5.30.1.127.3.10.7",
                                                "Authorize participants to access level/date",
                                                "Authorize participants to access level/date",
                                                "Teilnehmende für Zugriffsstufe/Datum autorisieren",
                                                "Autoriser les participants pour ce niveau d’accès / à cette date",
                                                "Autorizzare i partecipanti ad accedere a un livello/una data"),
    /**
     * EN: Disabling Emergency Access.<br>
     * DE: Notfall-Zugriff deaktivieren.<br>
     * FR: Désactiver l’accès d’urgence.<br>
     * IT: Disabilitare l'accesso di emergenza.<br>
     */
    DISABLING_EMERGENCY_ACCESS("ATC_POL_DIS_EMER_USE",
                               "2.16.756.5.30.1.127.3.10.7",
                               "Disabling Emergency Access",
                               "Disabling Emergency Access",
                               "Notfall-Zugriff deaktivieren",
                               "Désactiver l’accès d’urgence",
                               "Disabilitare l'accesso di emergenza"),
    /**
     * EN: Document or Document Metadata update.<br>
     * DE: Dokument- oder Dokument-Metadaten-Aktualisierung.<br>
     * FR: Mise à jour de documents ou de métadonnées de documents.<br>
     * IT: Aggiornamento di un documento o dei metadati di un documento.<br>
     */
    DOCUMENT_OR_DOCUMENT_METADATA_UPDATE("ATC_DOC_UPDATE",
                                         "2.16.756.5.30.1.127.3.10.7",
                                         "Document or Document Metadata update",
                                         "Document or Document Metadata update",
                                         "Dokument- oder Dokument-Metadaten-Aktualisierung",
                                         "Mise à jour de documents ou de métadonnées de documents",
                                         "Aggiornamento di un documento o dei metadati di un documento"),
    /**
     * EN: Document removal.<br>
     * DE: Dokumentlöschung.<br>
     * FR: Suppression de documents.<br>
     * IT: Rimozione di un documento.<br>
     */
    DOCUMENT_REMOVAL("ATC_DOC_DELETE",
                     "2.16.756.5.30.1.127.3.10.7",
                     "Document removal",
                     "Document removal",
                     "Dokumentlöschung",
                     "Suppression de documents",
                     "Rimozione di un documento"),
    /**
     * EN: Document retrieval.<br>
     * DE: Dokumentabruf.<br>
     * FR: Récupération de documents.<br>
     * IT: Ricerca di un documento.<br>
     */
    DOCUMENT_RETRIEVAL("ATC_DOC_READ",
                       "2.16.756.5.30.1.127.3.10.7",
                       "Document retrieval",
                       "Document retrieval",
                       "Dokumentabruf",
                       "Récupération de documents",
                       "Ricerca di un documento"),
    /**
     * EN: Document upload.<br>
     * DE: Dokument-Upload.<br>
     * FR: Chargement de documents.<br>
     * IT: Upload di un documento.<br>
     */
    DOCUMENT_UPLOAD("ATC_DOC_CREATE",
                    "2.16.756.5.30.1.127.3.10.7",
                    "Document upload",
                    "Document upload",
                    "Dokument-Upload",
                    "Chargement de documents",
                    "Upload di un documento"),
    /**
     * EN: Enabling Emergency Access.<br>
     * DE: Notfall-Zugriff aktivieren.<br>
     * FR: Autoriser l’accès d’urgence.<br>
     * IT: Abilitare l'accesso di emergenza.<br>
     */
    ENABLING_EMERGENCY_ACCESS("ATC_POL_ENA_EMER_USE",
                              "2.16.756.5.30.1.127.3.10.7",
                              "Enabling Emergency Access",
                              "Enabling Emergency Access",
                              "Notfall-Zugriff aktivieren",
                              "Autoriser l’accès d’urgence",
                              "Abilitare l'accesso di emergenza"),
    /**
     * EN: Exclude a Healthcare Professional from Blacklist.<br>
     * DE: Gesundheitsfachperson von der schwarzen Liste streichen.<br>
     * FR: Retirer un professionnel de la santé de la liste noire.<br>
     * IT: Rimuovere un professionista della salute dalla lista nera.<br>
     */
    EXCLUDE_A_HEALTHCARE_PROFESSIONAL_FROM_BLACKLIST("ATC_POL_EXL_BLACKLIST",
                                                     "2.16.756.5.30.1.127.3.10.7",
                                                     "Exclude a Healthcare Professional from Blacklist",
                                                     "Exclude a Healthcare Professional from Blacklist",
                                                     "Gesundheitsfachperson von der schwarzen Liste streichen",
                                                     "Retirer un professionnel de la santé de la liste noire",
                                                     "Rimuovere un professionista della salute dalla lista nera"),
    /**
     * EN: Remove authorization for participants to access level/date.<br>
     * DE: Autorisierung von Teilnehmenden für Zugriffsstufe/Datum aufheben.<br>
     * FR: Supprimer l’autorisation des participants à ce niveau d’accès / à cette date.<br>
     * IT: Rimuovere l'autorizzazione di accesso dei partecipanti al livello/alla data.<br>
     */
    REMOVE_AUTHORIZATION_FOR_PARTICIPANTS_TO_ACCESS_LEVEL_DATE("ATC_POL_REMOVE_AUT_PART_AL",
                                                               "2.16.756.5.30.1.127.3.10.7",
                                                               "Remove authorization for participants to access level/date",
                                                               "Remove authorization for participants to access level/date",
                                                               "Autorisierung von Teilnehmenden für Zugriffsstufe/Datum aufheben",
                                                               "Supprimer l’autorisation des participants à ce niveau d’accès / à cette date",
                                                               "Rimuovere l'autorizzazione di accesso dei partecipanti al livello/alla data"),
    /**
     * EN: Set or update the default Confidentiality Level for new documents.<br>
     * DE: Standard-Vertraulichkeitsstufe für neue Dokumente setzen oder aktualisieren.<br>
     * FR: Définir ou mettre à jour le niveau de confidentialité pour les nouveaux documents.<br>
     * IT: Impostare o aggiornare il livello di confidenzialità di default per i documenti nuovi.<br>
     */
    SET_OR_UPDATE_THE_DEFAULT_CONFIDENTIALITY_LEVEL_FOR_NEW_DOCUMENTS("ATC_POL_DEF_CONFLEVEL",
                                                                      "2.16.756.5.30.1.127.3.10.7",
                                                                      "Set or update the default Confidentiality Level for new documents",
                                                                      "Set or update the default Confidentiality Level for new documents",
                                                                      "Standard-Vertraulichkeitsstufe für neue Dokumente setzen oder aktualisieren",
                                                                      "Définir ou mettre à jour le niveau de confidentialité pour les nouveaux documents",
                                                                      "Impostare o aggiornare il livello di confidenzialità di default per i documenti nuovi"),
    /**
     * EN: Update access level/date of authorized participants.<br>
     * DE: Zugriffsstufe/Datum autorisierter Teilnehmender aktualisieren.<br>
     * FR: Mettre à jour le niveau d’accès / la date des participants autorisés.<br>
     * IT: Aggiornare il livello/la data di accesso dei partecipanti autorizzati.<br>
     */
    UPDATE_ACCESS_LEVEL_DATE_OF_AUTHORIZED_PARTICIPANTS("ATC_POL_UPDATE_AUT_PART_AL",
                                                        "2.16.756.5.30.1.127.3.10.7",
                                                        "Update access level/date of authorized participants",
                                                        "Update access level/date of authorized participants",
                                                        "Zugriffsstufe/Datum autorisierter Teilnehmender aktualisieren",
                                                        "Mettre à jour le niveau d’accès / la date des participants autorisés",
                                                        "Aggiornare il livello/la data di accesso dei partecipanti autorizzati");

    /**
     * EN: Code for Accessing the Patient Audit Record Repository.<br>
     * DE: Code für Auf die patientenbezogene Auditprotokoll-Ablage zugreifen.<br>
     * FR: Code de En cours d’accès au dépôt de contrôle des dossiers de patients.<br>
     * IT: Code per Accesso all'Audit Record Repository del paziente.<br>
     */
    public static final String ACCESSING_THE_PATIENT_AUDIT_RECORD_REPOSITORY_CODE = "ATC_LOG_READ";

    /**
     * EN: Code for Assign a Healthcare Professional to Blacklist.<br>
     * DE: Code für Gesundheitsfachperson auf die schwarze Liste setzen.<br>
     * FR: Code de Ajouter un professionnel de la santé à la liste noire.<br>
     * IT: Code per Aggiungere un professionista della salute alla lista nera.<br>
     */
    public static final String ASSIGN_A_HEALTHCARE_PROFESSIONAL_TO_BLACKLIST_CODE = "ATC_POL_INCL_BLACKLIST";

    /**
     * EN: Code for Authorize participants to access level/date.<br>
     * DE: Code für Teilnehmende für Zugriffsstufe/Datum autorisieren.<br>
     * FR: Code de Autoriser les participants pour ce niveau d’accès / à cette date.<br>
     * IT: Code per Autorizzare i partecipanti ad accedere a un livello/una data.<br>
     */
    public static final String AUTHORIZE_PARTICIPANTS_TO_ACCESS_LEVEL_DATE_CODE = "ATC_POL_CREATE_AUT_PART_AL";

    /**
     * EN: Code for Disabling Emergency Access.<br>
     * DE: Code für Notfall-Zugriff deaktivieren.<br>
     * FR: Code de Désactiver l’accès d’urgence.<br>
     * IT: Code per Disabilitare l'accesso di emergenza.<br>
     */
    public static final String DISABLING_EMERGENCY_ACCESS_CODE = "ATC_POL_DIS_EMER_USE";

    /**
     * EN: Code for Document or Document Metadata update.<br>
     * DE: Code für Dokument- oder Dokument-Metadaten-Aktualisierung.<br>
     * FR: Code de Mise à jour de documents ou de métadonnées de documents.<br>
     * IT: Code per Aggiornamento di un documento o dei metadati di un documento.<br>
     */
    public static final String DOCUMENT_OR_DOCUMENT_METADATA_UPDATE_CODE = "ATC_DOC_UPDATE";

    /**
     * EN: Code for Document removal.<br>
     * DE: Code für Dokumentlöschung.<br>
     * FR: Code de Suppression de documents.<br>
     * IT: Code per Rimozione di un documento.<br>
     */
    public static final String DOCUMENT_REMOVAL_CODE = "ATC_DOC_DELETE";

    /**
     * EN: Code for Document retrieval.<br>
     * DE: Code für Dokumentabruf.<br>
     * FR: Code de Récupération de documents.<br>
     * IT: Code per Ricerca di un documento.<br>
     */
    public static final String DOCUMENT_RETRIEVAL_CODE = "ATC_DOC_READ";

    /**
     * EN: Code for Document upload.<br>
     * DE: Code für Dokument-Upload.<br>
     * FR: Code de Chargement de documents.<br>
     * IT: Code per Upload di un documento.<br>
     */
    public static final String DOCUMENT_UPLOAD_CODE = "ATC_DOC_CREATE";

    /**
     * EN: Code for Enabling Emergency Access.<br>
     * DE: Code für Notfall-Zugriff aktivieren.<br>
     * FR: Code de Autoriser l’accès d’urgence.<br>
     * IT: Code per Abilitare l'accesso di emergenza.<br>
     */
    public static final String ENABLING_EMERGENCY_ACCESS_CODE = "ATC_POL_ENA_EMER_USE";

    /**
     * EN: Code for Exclude a Healthcare Professional from Blacklist.<br>
     * DE: Code für Gesundheitsfachperson von der schwarzen Liste streichen.<br>
     * FR: Code de Retirer un professionnel de la santé de la liste noire.<br>
     * IT: Code per Rimuovere un professionista della salute dalla lista nera.<br>
     */
    public static final String EXCLUDE_A_HEALTHCARE_PROFESSIONAL_FROM_BLACKLIST_CODE = "ATC_POL_EXL_BLACKLIST";

    /**
     * EN: Code for Remove authorization for participants to access level/date.<br>
     * DE: Code für Autorisierung von Teilnehmenden für Zugriffsstufe/Datum aufheben.<br>
     * FR: Code de Supprimer l’autorisation des participants à ce niveau d’accès / à cette date.<br>
     * IT: Code per Rimuovere l'autorizzazione di accesso dei partecipanti al livello/alla data.<br>
     */
    public static final String REMOVE_AUTHORIZATION_FOR_PARTICIPANTS_TO_ACCESS_LEVEL_DATE_CODE = "ATC_POL_REMOVE_AUT_PART_AL";

    /**
     * EN: Code for Set or update the default Confidentiality Level for new documents.<br>
     * DE: Code für Standard-Vertraulichkeitsstufe für neue Dokumente setzen oder aktualisieren.<br>
     * FR: Code de Définir ou mettre à jour le niveau de confidentialité pour les nouveaux documents.<br>
     * IT: Code per Impostare o aggiornare il livello di confidenzialità di default per i documenti nuovi.<br>
     */
    public static final String SET_OR_UPDATE_THE_DEFAULT_CONFIDENTIALITY_LEVEL_FOR_NEW_DOCUMENTS_CODE = "ATC_POL_DEF_CONFLEVEL";

    /**
     * EN: Code for Update access level/date of authorized participants.<br>
     * DE: Code für Zugriffsstufe/Datum autorisierter Teilnehmender aktualisieren.<br>
     * FR: Code de Mettre à jour le niveau d’accès / la date des participants autorisés.<br>
     * IT: Code per Aggiornare il livello/la data di accesso dei partecipanti autorizzati.<br>
     */
    public static final String UPDATE_ACCESS_LEVEL_DATE_OF_AUTHORIZED_PARTICIPANTS_CODE = "ATC_POL_UPDATE_AUT_PART_AL";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.13.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "EprAuditTrailConsumptionEventType";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.756.5.30.1.127.3.10.7";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static AuditTrailConsumptionEventType getEnum(@Nullable final String code) {
        for (final AuditTrailConsumptionEventType x : values()) {
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
            Enum.valueOf(AuditTrailConsumptionEventType.class,
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
        for (final AuditTrailConsumptionEventType x : values()) {
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
    AuditTrailConsumptionEventType(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
