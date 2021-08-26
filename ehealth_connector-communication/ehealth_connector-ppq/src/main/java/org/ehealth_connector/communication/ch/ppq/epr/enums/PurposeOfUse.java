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
package org.ehealth_connector.communication.ch.ppq.epr.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * Enumeration of EprPurposeOfUse values
 * <p>
 * EN: Purpose Of Use as per Annex 5 EPRO-FDHA, Extension 1.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.15.2<br>
 * Effective date: 2020-02-26 17:24<br>
 * Version: 201907.2-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum PurposeOfUse implements ValueSetEnumInterface {

    /**
     * EN: Automatic Upload<br>
     * DE: Automatischer Upload<br>
     * FR: Upload automatique<br>
     * IT: Upload automatico<br>
     */
    AUTOMATIC_UPLOAD("AUTO",
                     "2.16.756.5.30.1.127.3.10.5",
                     "Automatic Upload",
                     "Automatic Upload",
                     "Automatischer Upload",
                     "Upload automatique",
                     "Upload automatico"),
    /**
     * EN: Emergency Access<br>
     * DE: Notfallzugriff<br>
     * FR: Accès d’urgence<br>
     * IT: Accesso di emergenza<br>
     */
    EMERGENCY_ACCESS("EMER",
                     "2.16.756.5.30.1.127.3.10.5",
                     "Emergency Access",
                     "Emergency Access",
                     "Notfallzugriff",
                     "Accès d’urgence",
                     "Accesso di emergenza"),
    /**
     * EN: Normal Access<br>
     * DE: Normaler Zugriff<br>
     * FR: Accès normal<br>
     * IT: Accesso normale<br>
     */
    NORMAL_ACCESS("NORM",
                  "2.16.756.5.30.1.127.3.10.5",
                  "Normal Access",
                  "Normal Access",
                  "Normaler Zugriff",
                  "Accès normal",
                  "Accesso normale");

    /**
     * EN: Code for Automatic Upload<br>
     * DE: Code für Automatischer Upload<br>
     * FR: Code de Upload automatique<br>
     * IT: Code per Upload automatico<br>
     */
    public static final String AUTOMATIC_UPLOAD_CODE = "AUTO";

    /**
     * EN: Code for Emergency Access<br>
     * DE: Code für Notfallzugriff<br>
     * FR: Code de Accès d’urgence<br>
     * IT: Code per Accesso di emergenza<br>
     */
    public static final String EMERGENCY_ACCESS_CODE = "EMER";

    /**
     * EN: Code for Normal Access<br>
     * DE: Code für Normaler Zugriff<br>
     * FR: Code de Accès normal<br>
     * IT: Code per Accesso normale<br>
     */
    public static final String NORMAL_ACCESS_CODE = "NORM";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.15.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "EprPurposeOfUse";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static PurposeOfUse getEnum(final String code) {
        for (final PurposeOfUse x : values()) {
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
            Enum.valueOf(PurposeOfUse.class,
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
        for (final PurposeOfUse x : values()) {
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
    PurposeOfUse(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
