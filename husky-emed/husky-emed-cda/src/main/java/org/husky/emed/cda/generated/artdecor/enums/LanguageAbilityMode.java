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
package org.husky.emed.cda.generated.artdecor.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of LanguageAbilityMode values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A value representing the method of expression of the language.</p><p> <i>Example:</i> Expressed spoken, expressed written, expressed signed, received spoken, received written, received signed.</p><br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.12249<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-09-08")
public enum LanguageAbilityMode implements ValueSetEnumInterface {

    /**
     * EN: Expressed signed<br>
     */
    EXPRESSED_SIGNED("ESGN",
                     "2.16.840.1.113883.5.60",
                     "Expressed signed",
                     "Expressed signed",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Expressed spoken<br>
     */
    EXPRESSED_SPOKEN("ESP",
                     "2.16.840.1.113883.5.60",
                     "Expressed spoken",
                     "Expressed spoken",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE"),
    /**
     * EN: Expressed written<br>
     */
    EXPRESSED_WRITTEN("EWR",
                      "2.16.840.1.113883.5.60",
                      "Expressed written",
                      "Expressed written",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Received signed<br>
     */
    RECEIVED_SIGNED("RSGN",
                    "2.16.840.1.113883.5.60",
                    "Received signed",
                    "Received signed",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Received spoken<br>
     */
    RECEIVED_SPOKEN("RSP",
                    "2.16.840.1.113883.5.60",
                    "Received spoken",
                    "Received spoken",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Received written<br>
     */
    RECEIVED_WRITTEN("RWR",
                     "2.16.840.1.113883.5.60",
                     "Received written",
                     "Received written",
                     "TOTRANSLATE",
                     "TOTRANSLATE",
                     "TOTRANSLATE");

    /**
     * EN: Code for Expressed signed<br>
     */
    public static final String EXPRESSED_SIGNED_CODE = "ESGN";

    /**
     * EN: Code for Expressed spoken<br>
     */
    public static final String EXPRESSED_SPOKEN_CODE = "ESP";

    /**
     * EN: Code for Expressed written<br>
     */
    public static final String EXPRESSED_WRITTEN_CODE = "EWR";

    /**
     * EN: Code for Received signed<br>
     */
    public static final String RECEIVED_SIGNED_CODE = "RSGN";

    /**
     * EN: Code for Received spoken<br>
     */
    public static final String RECEIVED_SPOKEN_CODE = "RSP";

    /**
     * EN: Code for Received written<br>
     */
    public static final String RECEIVED_WRITTEN_CODE = "RWR";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.12249";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "LanguageAbilityMode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static LanguageAbilityMode getEnum(final String code) {
        for (final LanguageAbilityMode x : values()) {
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
            Enum.valueOf(LanguageAbilityMode.class,
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
        for (final LanguageAbilityMode x : values()) {
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
    LanguageAbilityMode(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
