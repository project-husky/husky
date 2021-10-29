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
package org.ehealth_connector.emed.cda.models.common.basetypes;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.Util;

import javax.annotation.processing.Generated;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the basic information for a code according to HL7. This class does not have any foreign framework
 * dependencies and is therefore one of the base elements of the eHealth Connector. Note: qualifiers not supported, yet.
 */
public class CodeBaseType implements Serializable {

    /*
     * See getter/setter for more details to the class members.
     */

    /**
     * The Constant serialVersionUID.
     */
    @Serial
    private static final long serialVersionUID = -7581542143784688019L;
    /**
     * The code translation.
     */
    private final List<CodeBaseType> codeTranslationList = new ArrayList<>();
    /**
     * The display name translation.
     */
    private final List<LangText> displayNameTranslationList = new ArrayList<>();
    /**
     * The code.
     */
    @Nullable
    private String code;

    /**
     * The code system.
     */
    @Nullable
    private String codeSystem;

    /**
     * The code system name.
     */
    @Nullable
    private String codeSystemName;

    /**
     * The code system version.
     */
    @Nullable
    private String codeSystemVersion;
    /**
     * The display name.
     */
    @Nullable
    private String displayName;
    /**
     * The null flavor.
     */
    @Nullable
    private NullFlavor nullFlavor;
    /**
     * The original text.
     */
    @Nullable
    private String originalText;

    public CodeBaseType() {
    }

    /**
     * Instantiates a new code base type.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private CodeBaseType(final Builder builder) {
        this.code = builder.code;
        this.codeSystem = builder.codeSystem;
        this.codeSystemName = builder.codeSystemName;
        this.codeSystemVersion = builder.codeSystemVersion;
        this.codeTranslationList.addAll(builder.codeTranslationList);
        this.displayName = builder.displayName;
        this.displayNameTranslationList.addAll(builder.displayNameTranslationList);
        this.originalText = builder.originalText;
        this.nullFlavor = builder.nullFlavor;
    }

    /**
     * Creates builder to build {@link CodeBaseType}.
     *
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Adds the code translation. A set of other codes that translate this one into other code systems.
     *
     * @param codeTranslation The code translation
     */
    public void addCodeTranslation(@Nullable final CodeBaseType codeTranslation) {
        this.codeTranslationList.add(codeTranslation);
    }

    /**
     * Adds the display name translation. A translation of the display name in another spoken language.
     *
     * @param displayNameTranslation The display name translation
     */
    public void addDisplayNameTranslation(@Nullable final LangText displayNameTranslation) {
        this.displayNameTranslationList.add(displayNameTranslation);
    }

    /**
     * Adds the display name translation. A translation of the display name in another spoken language.
     *
     * @param lang The language
     * @param text The text
     */
    public void addDisplayNameTranslation(@Nullable final LanguageCode lang, @Nullable final String text) {
        addDisplayNameTranslation(new LangText(lang, text));
    }

    /**
     * Clears the code translation list.
     */
    public void clearCodeTranslationList() {
        this.codeTranslationList.clear();
    }

    /**
     * Clears the display name translation list.
     */
    public void clearDisplayNameTranslationList() {
        this.displayNameTranslationList.clear();
    }

    /**
     * Checks whether the list member contains the given value.
     *
     * @param value The value
     * @return {@code true}, if successful
     */
    public boolean contains(final CodeBaseType value) {
        for (CodeBaseType entry : codeTranslationList) {
            if (entry.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the list member contains the given value.
     *
     * @param value The value
     * @return {@code true}, if successful
     */
    public boolean contains(final LangText value) {
        for (LangText entry : displayNameTranslationList) {
            if (entry.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the two objects are equal (based on their content).
     *
     * @param obj The CodeBaseType to compare
     * @return {@code true}, if equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(@Nullable final Object obj) {
        boolean retVal = true;
        if (obj == null)
            return false;

        if (!(obj instanceof CodeBaseType))
            return false;

        // only business rules are applied, here. Rest was initially implemented
        // and stays here for future use. If you use it, you need to implement
        // another method and not change the current method.
        // if (retVal) {
        // if (this.codeTranslationList == null)
        // this.codeTranslationList = new ArrayList<CodeBaseType>();
        // for (int i = 0; i < this.codeTranslationList.size(); i++) {
        // retVal = (obj.contains(this.codeTranslationList.get(i)));
        // if (!retVal)
        // break;
        // }
        // }
        // if (retVal) {
        // if (this.displayNameTranslationList == null)
        // this.displayNameTranslationList = new ArrayList<LangText>();
        // for (int i = 0; i < this.displayNameTranslationList.size(); i++) {
        // retVal = obj.contains(this.displayNameTranslationList.get(i));
        // if (!retVal)
        // break;
        // }
        // }
        if (retVal) {
            if (this.code == null)
                retVal = (((CodeBaseType) obj).getCode() == null);
            else
                retVal = this.code.equals(((CodeBaseType) obj).getCode());
        }
        if (retVal) {
            if (this.codeSystem == null)
                retVal = (((CodeBaseType) obj).getCodeSystem() == null);
            else
                retVal = this.codeSystem.equals(((CodeBaseType) obj).getCodeSystem());
        }
        // if (retVal) {
        // if (this.codeSystemName == null)
        // retVal = (obj.getCodeSystemName() == null);
        // else
        // retVal = this.codeSystemName.equals(obj.getCodeSystemName());
        // }
        // if (retVal) {
        // if (this.codeSystemVersion == null)
        // retVal = (obj.getCodeSystemVersion() == null);
        // else
        // retVal = this.codeSystemVersion.equals(obj.getCodeSystemVersion());
        // }
        // if (retVal) {
        // if (this.displayName == null)
        // retVal = (obj.getDisplayName() == null);
        // else
        // retVal = this.displayName.equals(obj.getDisplayName());
        // }
        // if (retVal) {
        // if (this.originalText == null)
        // retVal = (obj.getOriginalText() == null);
        // else
        // retVal = this.originalText.equals(obj.getOriginalText());
        // }
        return retVal;
    }

    /**
     * Gets the code. The plain code symbol defined by the code system. For example, "784.0" is the code symbol of the
     * ICD-10 code "784.0" for headache. It's value is unique within all values defined in the CodeSystem.
     *
     * @return the code
     */
    @Nullable
    public String getCode() {
        return code;
    }

    /**
     * Sets the code. See getter {@link CodeBaseType#getCode} for more details.
     *
     * @param code The new code
     */
    public void setCode(@Nullable final String code) {
        this.code = code;
    }

    /**
     * Gets OID or UUID of the code system.
     *
     * @return the code system
     */
    @Nullable
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     * Sets the code system. See getter {@link CodeBaseType#getCodeSystem} for more details.
     *
     * @param codeSystem The new code system
     */
    public void setCodeSystem(@Nullable final String codeSystem) {
        this.codeSystem = codeSystem;
    }

    /**
     * Gets the name of the code system.
     *
     * @return the code system name
     */
    @Nullable
    public String getCodeSystemName() {
        return codeSystemName;
    }

    /**
     * Sets the code system name. See getter {@link CodeBaseType#getCodeSystemName} for more details.
     *
     * @param codeSystemName The new code system name
     */
    public void setCodeSystemName(@Nullable final String codeSystemName) {
        this.codeSystemName = codeSystemName;
    }

    /**
     * Gets the code system version. If applicable, a version descriptor defined specifically for the given code
     * system.
     *
     * @return the code system version
     */
    @Nullable
    public String getCodeSystemVersion() {
        return codeSystemVersion;
    }

    /**
     * Sets the code system version. See getter {@link CodeBaseType#getCodeSystemVersion} for more details.
     *
     * @param codeSystemVersion The new code system version
     */
    public void setCodeSystemVersion(@Nullable final String codeSystemVersion) {
        this.codeSystemVersion = codeSystemVersion;
    }

    /**
     * Gets the code translation list for the current code.
     *
     * @return the code translation list
     */
    public List<CodeBaseType> getCodeTranslationList() {
        return codeTranslationList;
    }

    /**
     * Sets the code translation list. See getter {@link CodeBaseType#getCodeTranslationList} for more details.
     *
     * @param codeTranslationList The new code translation list
     */
    public void setCodeTranslationList(@Nullable final List<CodeBaseType> codeTranslationList) {
        this.codeTranslationList.clear();
        if (codeTranslationList != null) {
            this.codeTranslationList.addAll(codeTranslationList);
        }
    }

    /**
     * Gets the display name of the code. It is usually an English text.
     *
     * @return the display name
     */
    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name. See getter {@link CodeBaseType#getDisplayName} for more details.
     *
     * @param displayName The new display name
     */
    public void setDisplayName(@Nullable final String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the translation list for the display name. This List may contain translations of the display name in other
     * spoken languages.
     *
     * @return the display name translation list
     */
    public List<LangText> getDisplayNameTranslationList() {
        return displayNameTranslationList;
    }

    /**
     * Sets the display name translation list. See getter {@link CodeBaseType#getDisplayNameTranslationList} for more
     * details.
     *
     * @param displayNameTranslationList The new display name translation list
     */
    public void setDisplayNameTranslationList(@Nullable final List<LangText> displayNameTranslationList) {
        this.displayNameTranslationList.clear();
        if (displayNameTranslationList != null) {
            this.displayNameTranslationList.addAll(displayNameTranslationList);
        }
    }

    /**
     * Gets the null flavor.
     *
     * @return the null flavor
     */
    @Nullable
    public NullFlavor getNullFlavor() {
        return nullFlavor;
    }

    /**
     * Gets the original text. It contains the original text describing the current code.
     *
     * @return the original text
     */
    @Nullable
    public String getOriginalText() {
        return originalText;
    }

    /**
     * Sets the original text. See getter {@link CodeBaseType#getOriginalText} for more details.
     *
     * @param originalText The new original text
     */
    public void setOriginalText(@Nullable final String originalText) {
        this.originalText = originalText;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Util.getChecksum(this);
    }

    /**
     * Checks if the current instance is null flavored.
     *
     * @return true, if is null flavor
     */
    public boolean isNullFlavor() {
        return (nullFlavor != null);
    }

    /**
     * Sets the null flavor.
     *
     * @param nullFlavor The new null flavor
     */
    public void setNullFlavor(@Nullable final NullFlavor nullFlavor) {
        this.nullFlavor = nullFlavor;
    }

    /**
     * Builds a string of the whole code.
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder();

        if (getCode() != null)
            retVal.append(getCode() + " / ");
        else
            retVal.append("no code !! / ");

        if (getCodeSystem() != null)
            retVal.append(getCodeSystem());
        else
            retVal.append("no code system !!");

        String displayName = getDisplayName();
        String codeSystemName = getCodeSystemName();
        if ((displayName != null) || (codeSystemName != null)) {
            retVal.append(" (");

            if (displayName != null)
                retVal.append(displayName);

            if (codeSystemName != null) {
                if (displayName != null)
                    retVal.append(" / ");

                retVal.append(codeSystemName);
            }

            retVal.append(")");
        }

        return retVal.toString();
    }

    /**
     * Builder to build {@link CodeBaseType}.
     */
    @Generated("SparkTools")
    public static final class Builder {

        /**
         * The code translation list.
         */
        private final List<CodeBaseType> codeTranslationList = new ArrayList<>();
        /**
         * The display name translation list.
         */
        private final List<LangText> displayNameTranslationList = new ArrayList<>();
        /**
         * The code.
         */
        private String code;
        /**
         * The code system.
         */
        private String codeSystem;
        /**
         * The code system name.
         */
        private String codeSystemName;
        /**
         * The code system version.
         */
        private String codeSystemVersion;
        /**
         * The display name.
         */
        private String displayName;
        /**
         * The null flavor.
         */
        private NullFlavor nullFlavor;

        /**
         * The original text.
         */
        private String originalText;

        /**
         * Instantiates a new builder.
         */
        private Builder() {
        }

        /**
         * Builds the.
         *
         * @return the code base type
         */
        public CodeBaseType build() {
            return new CodeBaseType(this);
        }

        /**
         * With code.
         *
         * @param code the code
         * @return the builder
         */
        public Builder withCode(final String code) {
            this.code = code;
            return this;
        }

        /**
         * With code system.
         *
         * @param codeSystem the code system
         * @return the builder
         */
        public Builder withCodeSystem(final String codeSystem) {
            this.codeSystem = codeSystem;
            return this;
        }

        /**
         * With code system name.
         *
         * @param codeSystemName the code system name
         * @return the builder
         */
        public Builder withCodeSystemName(final String codeSystemName) {
            this.codeSystemName = codeSystemName;
            return this;
        }

        /**
         * With code system version.
         *
         * @param codeSystemVersion the code system version
         * @return the builder
         */
        public Builder withCodeSystemVersion(final String codeSystemVersion) {
            this.codeSystemVersion = codeSystemVersion;
            return this;
        }

        /**
         * With code translation list.
         *
         * @param codeTranslationList the code translation list
         * @return the builder
         */
        public Builder withCodeTranslationList(final List<CodeBaseType> codeTranslationList) {
            this.codeTranslationList.clear();
            if (codeTranslationList != null) {
                this.codeTranslationList.addAll(codeTranslationList);
            }
            return this;
        }

        /**
         * With display name.
         *
         * @param displayName the display name
         * @return the builder
         */
        public Builder withDisplayName(final String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * With display name translation list.
         *
         * @param displayNameTranslationList the display name translation list
         * @return the builder
         */
        public Builder withDisplayNameTranslationList(final List<LangText> displayNameTranslationList) {
            this.displayNameTranslationList.clear();
            if (displayNameTranslationList != null) {
                this.displayNameTranslationList.addAll(displayNameTranslationList);
            }
            return this;
        }

        /**
         * With null flavor.
         *
         * @param nullFlavor The null flavor
         * @return the builder
         */
        public Builder withNullFlavor(final NullFlavor nullFlavor) {
            this.nullFlavor = nullFlavor;
            return this;
        }

        /**
         * With original text.
         *
         * @param originalText The original text
         * @return the builder
         */
        public Builder withOriginalText(final String originalText) {
            this.originalText = originalText;
            return this;
        }
    }

}
