/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DispenseSupplyType values
 * <p>
 * EN: No designation found.<br>
 * DE: IHE DIS 6.3.4.5.3.4 Code<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.77.4.11.7<br>
 * Effective date: 2017-01-10 20:44<br>
 * Version: 2021<br>
 * Status: DRAFT
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-11-24")
public enum DispenseSupplyType implements ValueSetEnumInterface {

    /**
     * EN: First Fill - Complete<br>
     * DE: Erstbefüllung - Voll<br>
     * FR: Premier remplissage - complet<br>
     * IT: Prima consegna - completa<br>
     */
    FIRST_FILL_COMPLETE("FFC",
                        "2.16.840.1.113883.5.4",
                        "First Fill - Complete",
                        "First Fill - Complete",
                        "Erstbefüllung - Voll",
                        "Premier remplissage - complet",
                        "Prima consegna - completa"),
    /**
     * EN: First Fill - Part Fill<br>
     * DE: Erstbefüllung - Teilbefüllung<br>
     * FR: Premier remplissage - partiel<br>
     * IT: Prima consegna - parziale<br>
     */
    FIRST_FILL_PART_FILL("FFP",
                         "2.16.840.1.113883.5.4",
                         "First Fill - Part Fill",
                         "First Fill - Part Fill",
                         "Erstbefüllung - Teilbefüllung",
                         "Premier remplissage - partiel",
                         "Prima consegna - parziale"),
    /**
     * EN: Refill - Complete<br>
     * DE: Nachfüllung - Voll<br>
     * FR: Prochain remplissage - complet<br>
     * IT: Consegna successiva - completa<br>
     */
    REFILL_COMPLETE("RFC",
                    "2.16.840.1.113883.5.4",
                    "Refill - Complete",
                    "Refill - Complete",
                    "Nachfüllung - Voll",
                    "Prochain remplissage - complet",
                    "Consegna successiva - completa"),
    /**
     * EN: Refill - Part Fill<br>
     * DE: Nachfüllung - Teilbefüllung<br>
     * FR: Prochain remplissage - partiel<br>
     * IT: Consegna successiva - parziale<br>
     */
    REFILL_PART_FILL("RFP",
                     "2.16.840.1.113883.5.4",
                     "Refill - Part Fill",
                     "Refill - Part Fill",
                     "Nachfüllung - Teilbefüllung",
                     "Prochain remplissage - partiel",
                     "Consegna successiva - parziale");

    /**
     * EN: Code for First Fill - Complete<br>
     * DE: Code für Erstbefüllung - Voll<br>
     * FR: Code de Premier remplissage - complet<br>
     * IT: Code per Prima consegna - completa<br>
     */
    public static final String FIRST_FILL_COMPLETE_CODE = "FFC";

    /**
     * EN: Code for First Fill - Part Fill<br>
     * DE: Code für Erstbefüllung - Teilbefüllung<br>
     * FR: Code de Premier remplissage - partiel<br>
     * IT: Code per Prima consegna - parziale<br>
     */
    public static final String FIRST_FILL_PART_FILL_CODE = "FFP";

    /**
     * EN: Code for Refill - Complete<br>
     * DE: Code für Nachfüllung - Voll<br>
     * FR: Code de Prochain remplissage - complet<br>
     * IT: Code per Consegna successiva - completa<br>
     */
    public static final String REFILL_COMPLETE_CODE = "RFC";

    /**
     * EN: Code for Refill - Part Fill<br>
     * DE: Code für Nachfüllung - Teilbefüllung<br>
     * FR: Code de Prochain remplissage - partiel<br>
     * IT: Code per Consegna successiva - parziale<br>
     */
    public static final String REFILL_PART_FILL_CODE = "RFP";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.77.4.11.7";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DispenseSupplyType";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.5.4";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static DispenseSupplyType getEnum(final String code) {
        for (final DispenseSupplyType x : values()) {
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
            Enum.valueOf(DispenseSupplyType.class,
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
        for (final DispenseSupplyType x : values()) {
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
    DispenseSupplyType(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
