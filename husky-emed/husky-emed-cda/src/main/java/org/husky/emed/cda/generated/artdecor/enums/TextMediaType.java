/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * Enumeration of TextMediaType values
 * <p>
 * EN: <p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>For any text</p><br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.840.1.113883.1.11.14825<br>
 * Effective date: 2014-03-26 00:00<br>
 * Version: DEFN=UV=VO=1360-20160323<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-09-08")
public enum TextMediaType implements ValueSetEnumInterface {

    /**
     * EN: HL7 Structured Narrative<br>
     */
    HL7_STRUCTURED_NARRATIVE_L1("text/x-hl7-text+xml",
                                "2.16.840.1.113883.5.79",
                                "HL7 Structured Narrative",
                                "HL7 Structured Narrative",
                                "TOTRANSLATE",
                                "TOTRANSLATE",
                                "TOTRANSLATE"),
    /**
     * EN: HL7 Text<br>
     */
    HL7_TEXT_L1("text/x-hl7-ft",
                "2.16.840.1.113883.5.79",
                "HL7 Text",
                "HL7 Text",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: HTML Text<br>
     */
    HTML_TEXT_L1("text/html",
                 "2.16.840.1.113883.5.79",
                 "HTML Text",
                 "HTML Text",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: Plain Text<br>
     */
    PLAIN_TEXT_L1("text/plain",
                  "2.16.840.1.113883.5.79",
                  "Plain Text",
                  "Plain Text",
                  "TOTRANSLATE",
                  "TOTRANSLATE",
                  "TOTRANSLATE"),
    /**
     * EN: RTF Text<br>
     */
    RTF_TEXT_L1("text/rtf",
                "2.16.840.1.113883.5.79",
                "RTF Text",
                "RTF Text",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE"),
    /**
     * EN: SGML Text<br>
     */
    SGML_TEXT_L1("text/sgml",
                 "2.16.840.1.113883.5.79",
                 "SGML Text",
                 "SGML Text",
                 "TOTRANSLATE",
                 "TOTRANSLATE",
                 "TOTRANSLATE"),
    /**
     * EN: XML Text<br>
     */
    XML_TEXT_L1("text/xml",
                "2.16.840.1.113883.5.79",
                "XML Text",
                "XML Text",
                "TOTRANSLATE",
                "TOTRANSLATE",
                "TOTRANSLATE");

    /**
     * EN: Code for HL7 Structured Narrative<br>
     */
    public static final String HL7_STRUCTURED_NARRATIVE_L1_CODE = "text/x-hl7-text+xml";

    /**
     * EN: Code for HL7 Text<br>
     */
    public static final String HL7_TEXT_L1_CODE = "text/x-hl7-ft";

    /**
     * EN: Code for HTML Text<br>
     */
    public static final String HTML_TEXT_L1_CODE = "text/html";

    /**
     * EN: Code for Plain Text<br>
     */
    public static final String PLAIN_TEXT_L1_CODE = "text/plain";

    /**
     * EN: Code for RTF Text<br>
     */
    public static final String RTF_TEXT_L1_CODE = "text/rtf";

    /**
     * EN: Code for SGML Text<br>
     */
    public static final String SGML_TEXT_L1_CODE = "text/sgml";

    /**
     * EN: Code for XML Text<br>
     */
    public static final String XML_TEXT_L1_CODE = "text/xml";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.14825";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "TextMediaType";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static TextMediaType getEnum(final String code) {
        for (final TextMediaType x : values()) {
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
            Enum.valueOf(TextMediaType.class,
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
        for (final TextMediaType x : values()) {
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
    TextMediaType(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
