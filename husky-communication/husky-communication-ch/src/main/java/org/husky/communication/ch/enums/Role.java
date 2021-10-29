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
package org.husky.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of EprRole values
 * <p>
 * EN: Role codes as per Annex 5 EPRO-FDHA, version July 2019<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.15.1<br>
 * Effective date: 2019-12-11 17:01<br>
 * Version: 201907.2-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum Role implements ValueSetEnumInterface {

    /**
     * EN: Assistant<br>
     * DE: Hilfsperson<br>
     * FR: Assistant<br>
     * IT: Assistente<br>
     */
    ASSISTANT("ASS",
              "2.16.756.5.30.1.127.3.10.6",
              "Assistant",
              "Assistant",
              "Hilfsperson",
              "Assistant",
              "Assistente"),
    /**
     * EN: Document Administrator<br>
     * DE: Dokumentenadministrator<br>
     * FR: Administrateur des documents<br>
     * IT: Amministratore documenti<br>
     */
    DOCUMENT_ADMINISTRATOR("DADM",
                           "2.16.756.5.30.1.127.3.10.6",
                           "Document Administrator",
                           "Document Administrator",
                           "Dokumentenadministrator",
                           "Administrateur des documents",
                           "Amministratore documenti"),
    /**
     * EN: Healthcare professional<br>
     * DE: Gesundheitsfachperson<br>
     * FR: Professionnel de la santé<br>
     * IT: Professionista della salute<br>
     */
    HEALTHCARE_PROFESSIONAL("HCP",
                            "2.16.756.5.30.1.127.3.10.6",
                            "Healthcare professional",
                            "Healthcare professional",
                            "Gesundheitsfachperson",
                            "Professionnel de la santé",
                            "Professionista della salute"),
    /**
     * EN: Patient<br>
     * DE: Patient<br>
     * FR: Patient<br>
     * IT: Paziente<br>
     */
    PATIENT("PAT",
            "2.16.756.5.30.1.127.3.10.6",
            "Patient",
            "Patient",
            "Patient",
            "Patient",
            "Paziente"),
    /**
     * EN: Policy Administrator<br>
     * DE: Datenschutzrichtlinien-Administrator<br>
     * FR: Administrateur des directives de protection des données<br>
     * IT: Amministratore diritti di accesso<br>
     */
    POLICY_ADMINISTRATOR("PADM",
                         "2.16.756.5.30.1.127.3.10.6",
                         "Policy Administrator",
                         "Policy Administrator",
                         "Datenschutzrichtlinien-Administrator",
                         "Administrateur des directives de protection des données",
                         "Amministratore diritti di accesso"),
    /**
     * EN: Representative<br>
     * DE: Stellvertretung<br>
     * FR: Représentant<br>
     * IT: Rappresentante<br>
     */
    REPRESENTATIVE("REP",
                   "2.16.756.5.30.1.127.3.10.6",
                   "Representative",
                   "Representative",
                   "Stellvertretung",
                   "Représentant",
                   "Rappresentante"),
    /**
     * EN: Technical user<br>
     * DE: Technischer Nutzer<br>
     * FR: Utilisateur technique<br>
     * IT: Utente tecnico<br>
     */
    TECHNICAL_USER("TCU",
                   "2.16.756.5.30.1.127.3.10.6",
                   "Technical user",
                   "Technical user",
                   "Technischer Nutzer",
                   "Utilisateur technique",
                   "Utente tecnico");

    /**
     * EN: Code for Assistant<br>
     * DE: Code für Hilfsperson<br>
     * FR: Code de Assistant<br>
     * IT: Code per Assistente<br>
     */
    public static final String ASSISTANT_CODE = "ASS";

    /**
     * EN: Code for Document Administrator<br>
     * DE: Code für Dokumentenadministrator<br>
     * FR: Code de Administrateur des documents<br>
     * IT: Code per Amministratore documenti<br>
     */
    public static final String DOCUMENT_ADMINISTRATOR_CODE = "DADM";

    /**
     * EN: Code for Healthcare professional<br>
     * DE: Code für Gesundheitsfachperson<br>
     * FR: Code de Professionnel de la santé<br>
     * IT: Code per Professionista della salute<br>
     */
    public static final String HEALTHCARE_PROFESSIONAL_CODE = "HCP";

    /**
     * EN: Code for Patient<br>
     * DE: Code für Patient<br>
     * FR: Code de Patient<br>
     * IT: Code per Paziente<br>
     */
    public static final String PATIENT_CODE = "PAT";

    /**
     * EN: Code for Policy Administrator<br>
     * DE: Code für Datenschutzrichtlinien-Administrator<br>
     * FR: Code de Administrateur des directives de protection des données<br>
     * IT: Code per Amministratore diritti di accesso<br>
     */
    public static final String POLICY_ADMINISTRATOR_CODE = "PADM";

    /**
     * EN: Code for Representative<br>
     * DE: Code für Stellvertretung<br>
     * FR: Code de Représentant<br>
     * IT: Code per Rappresentante<br>
     */
    public static final String REPRESENTATIVE_CODE = "REP";

    /**
     * EN: Code for Technical user<br>
     * DE: Code für Technischer Nutzer<br>
     * FR: Code de Utilisateur technique<br>
     * IT: Code per Utente tecnico<br>
     */
    public static final String TECHNICAL_USER_CODE = "TCU";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.15.1";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "EprRole";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static Role getEnum(final String code) {
        for (final Role x : values()) {
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
            Enum.valueOf(Role.class,
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
        for (final Role x : values()) {
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
    Role(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
