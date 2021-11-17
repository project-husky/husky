/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * Enumeration of DocumentEntry.confidentialityCode values
 * <p>
 * EN: Document confidentiality as per Annex; EPRO-FDHA.<br>
 * DE: Vertraulichkeitsstufe gemäss Anhang 3 EPDV-EDI.<br>
 * FR: Niveau de confidentialité selon l'annexe 3 ODEP-DFI.<br>
 * IT: Grado di riservatezza secondo l'allegato 3 OCIP-DFI.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.5<br>
 * Effective date: 2021-04-01 17:05<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-09-08")
public enum DocumentEntryConfidentialityCode implements ValueSetEnumInterface {

    /**
     * EN: Normally accessible<br>
     * DE: Normal zugängliche Dokumente<br>
     * FR: Normal<br>
     * IT: Dati normalmente accessibili<br>
     */
    NORMALLY_ACCESSIBLE("17621005",
                        "2.16.840.1.113883.6.96",
                        "Normal (qualifier value)",
                        "Normally accessible",
                        "Normal zugängliche Dokumente",
                        "Normal",
                        "Dati normalmente accessibili"),
    /**
     * EN: Restricted accessible<br>
     * DE: Eingeschränkt zugängliche Dokumente<br>
     * FR: Restreint<br>
     * IT: Dati limitatamente accessibili<br>
     */
    RESTRICTED_ACCESSIBLE("263856008",
                          "2.16.840.1.113883.6.96",
                          "Restricted (qualifier value)",
                          "Restricted accessible",
                          "Eingeschränkt zugängliche Dokumente",
                          "Restreint",
                          "Dati limitatamente accessibili"),
    /**
     * EN: Secret<br>
     * DE: Geheime Dokumente<br>
     * FR: Secret<br>
     * IT: Dati segreti<br>
     */
    SECRET("1141000195107",
           "2.16.756.5.30.1.127.3.4",
           "Secret (qualifier value)",
           "Secret",
           "Geheime Dokumente",
           "Secret",
           "Dati segreti");

    /**
     * EN: Code for Normally accessible<br>
     * DE: Code für Normal zugängliche Dokumente<br>
     * FR: Code de Normal<br>
     * IT: Code per Dati normalmente accessibili<br>
     */
    public static final String NORMALLY_ACCESSIBLE_CODE = "17621005";

    /**
     * EN: Code for Restricted accessible<br>
     * DE: Code für Eingeschränkt zugängliche Dokumente<br>
     * FR: Code de Restreint<br>
     * IT: Code per Dati limitatamente accessibili<br>
     */
    public static final String RESTRICTED_ACCESSIBLE_CODE = "263856008";

    /**
     * EN: Code for Secret<br>
     * DE: Code für Geheime Dokumente<br>
     * FR: Code de Secret<br>
     * IT: Code per Dati segreti<br>
     */
    public static final String SECRET_CODE = "1141000195107";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.5";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.confidentialityCode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static DocumentEntryConfidentialityCode getEnum(final String code) {
        for (final DocumentEntryConfidentialityCode x : values()) {
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
            Enum.valueOf(DocumentEntryConfidentialityCode.class,
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
        for (final DocumentEntryConfidentialityCode x : values()) {
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
    DocumentEntryConfidentialityCode(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
