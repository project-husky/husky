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
 * Enumeration of HealthStatus_value values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.11.3<br>
 * Effective date: 2016-09-26 14:09<br>
 * Version: 2014<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-09-08")
public enum HealthStatusValue implements ValueSetEnumInterface {

    /**
     * EN: Alive and well<br>
     */
    ALIVE_AND_WELL("81323004",
                   "2.16.840.1.113883.6.96",
                   "Alive and well",
                   "Alive and well",
                   "TOTRANSLATE",
                   "TOTRANSLATE",
                   "TOTRANSLATE"),
    /**
     * EN: Chronically ill<br>
     */
    CHRONICALLY_ILL("161901003",
                    "2.16.840.1.113883.6.96",
                    "Chronically ill",
                    "Chronically ill",
                    "TOTRANSLATE",
                    "TOTRANSLATE",
                    "TOTRANSLATE"),
    /**
     * EN: Deceased<br>
     */
    DECEASED("419099009",
             "2.16.840.1.113883.6.96",
             "Deceased",
             "Deceased",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: Disabled<br>
     */
    DISABLED("21134002",
             "2.16.840.1.113883.6.96",
             "Disabled",
             "Disabled",
             "TOTRANSLATE",
             "TOTRANSLATE",
             "TOTRANSLATE"),
    /**
     * EN: In remission<br>
     */
    IN_REMISSION("313386006",
                 "2.16.840.1.113883.6.96",
                 "In remission",
                 "In remission",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Severely disabled<br>
     */
    SEVERELY_DISABLED("161045001",
                      "2.16.840.1.113883.6.96",
                      "Severely disabled",
                      "Severely disabled",
                      "TOTRANSLATE",
                      "TOTRANSLATE",
                      "TOTRANSLATE"),
    /**
     * EN: Severely ill<br>
     */
    SEVERELY_ILL("271593001",
                 "2.16.840.1.113883.6.96",
                 "Severely ill",
                 "Severely ill",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Symptom free<br>
     */
    SYMPTOM_FREE("162467007",
                 "2.16.840.1.113883.6.96",
                 "Symptom free",
                 "Symptom free",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE");

    /**
     * EN: Code for Alive and well<br>
     */
    public static final String ALIVE_AND_WELL_CODE = "81323004";

    /**
     * EN: Code for Chronically ill<br>
     */
    public static final String CHRONICALLY_ILL_CODE = "161901003";

    /**
     * EN: Code for Deceased<br>
     */
    public static final String DECEASED_CODE = "419099009";

    /**
     * EN: Code for Disabled<br>
     */
    public static final String DISABLED_CODE = "21134002";

    /**
     * EN: Code for In remission<br>
     */
    public static final String IN_REMISSION_CODE = "313386006";

    /**
     * EN: Code for Severely disabled<br>
     */
    public static final String SEVERELY_DISABLED_CODE = "161045001";

    /**
     * EN: Code for Severely ill<br>
     */
    public static final String SEVERELY_ILL_CODE = "271593001";

    /**
     * EN: Code for Symptom free<br>
     */
    public static final String SYMPTOM_FREE_CODE = "162467007";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "1.3.6.1.4.1.19376.1.5.3.1.11.3";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "HealthStatus_value";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static HealthStatusValue getEnum(final String code) {
        for (final HealthStatusValue x : values()) {
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
            Enum.valueOf(HealthStatusValue.class,
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
        for (final HealthStatusValue x : values()) {
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
    HealthStatusValue(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
