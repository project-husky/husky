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
import org.ehealth_connector.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.author.authorRole values
 * <p>
 * EN: Role of the author. This code defines the role of the author of the document. This is a sub-attribute of epd_xds_author.<br>
 * DE: Rolle des Autors. Dieser Code definiert die Rolle des Authors vom Dokument. Dies ist ein Sub-Attribut von epd_xds_author.<br>
 * FR: Rôle de l'auteur. Ce code définit le rôle de l'auteur du document. Il s'agit d'un sous-attribut de epd_xds_author.<br>
 * IT: Ruolo dell'autore. Questo codice definisce il ruolo dell'autore del documento. È un sottoattributo di epd_xds_author.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.1.3<br>
 * Effective date: 2021-04-01 08:55<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum AuthorRole implements ValueSetEnumInterface {

    /**
     * EN: Assistant<br>
     * DE: Hilfsperson<br>
     * FR: Auxiliaire<br>
     * IT: Persona ausiliara<br>
     */
    ASSISTANT("ASS",
              "2.16.756.5.30.1.127.3.10.6",
              "Assistant",
              "Assistant",
              "Hilfsperson",
              "Auxiliaire",
              "Persona ausiliara"),
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
     * DE: Technischer Benutzer<br>
     * FR: Utilisateur technique<br>
     * IT: Utente tecnico<br>
     */
    TECHNICAL_USER("TCU",
                   "2.16.756.5.30.1.127.3.10.6",
                   "Technical user",
                   "Technical user",
                   "Technischer Benutzer",
                   "Utilisateur technique",
                   "Utente tecnico");

    /**
     * EN: Code for Assistant<br>
     * DE: Code für Hilfsperson<br>
     * FR: Code de Auxiliaire<br>
     * IT: Code per Persona ausiliara<br>
     */
    public static final String ASSISTANT_CODE = "ASS";

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
     * EN: Code for Representative<br>
     * DE: Code für Stellvertretung<br>
     * FR: Code de Représentant<br>
     * IT: Code per Rappresentante<br>
     */
    public static final String REPRESENTATIVE_CODE = "REP";

    /**
     * EN: Code for Technical user<br>
     * DE: Code für Technischer Benutzer<br>
     * FR: Code de Utilisateur technique<br>
     * IT: Code per Utente tecnico<br>
     */
    public static final String TECHNICAL_USER_CODE = "TCU";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.1.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.author.authorRole";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static AuthorRole getEnum(final String code) {
        for (final AuthorRole x : values()) {
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
            Enum.valueOf(AuthorRole.class,
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
        for (final AuthorRole x : values()) {
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
    AuthorRole(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
