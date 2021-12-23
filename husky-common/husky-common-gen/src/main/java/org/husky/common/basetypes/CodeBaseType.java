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
package org.husky.common.basetypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.NullFlavor;
import org.husky.common.utils.LangText;

/**
 * This class provides the basic information for a code according to HL7. This class does not have any foreign framework
 * dependencies and is therefore one of the base elements of the Husky. Note: qualifiers not supported, yet.
 */
public class CodeBaseType implements Serializable {

    /*
     * See getter/setter for more details to the class members.
     */

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -7581542143784688019L;
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
     * The code translation.
     */
    private List<CodeBaseType> codeTranslationList;
    /**
     * The display name.
     */
    private String displayName;
    /**
     * The display name translation.
     */
    private List<LangText> displayNameTranslationList;
    /**
     * The null flavor.
     */
    private NullFlavor nullFlavor;
    /**
     * The original text.
     */
    private String originalText;

    /**
     * Instantiates a new CodeBaseType. Default constructor.
     */
    public CodeBaseType() {
    }

    /**
     * Instantiates a new code base type.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private CodeBaseType(Builder builder) {
        this.code = builder.code;
        this.codeSystem = builder.codeSystem;
        this.codeSystemName = builder.codeSystemName;
        this.codeSystemVersion = builder.codeSystemVersion;
        this.codeTranslationList = builder.codeTranslationList;
        this.displayName = builder.displayName;
        this.displayNameTranslationList = builder.displayNameTranslationList;
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
     * @param codeTranslation the code translation
     */
    public void addCodeTranslation(CodeBaseType codeTranslation) {
        if (this.codeTranslationList == null)
            this.codeTranslationList = new ArrayList<>();
        this.codeTranslationList.add(codeTranslation);
    }

    /**
     * Adds the display name translation. A translation of the display name in another spoken language.
     *
     * @param displayNameTranslation the display name translation
     */
    public void addDisplayNameTranslation(LangText displayNameTranslation) {
        if (this.displayNameTranslationList == null)
            this.displayNameTranslationList = new ArrayList<>();
        this.displayNameTranslationList.add(displayNameTranslation);
    }

    /**
     * Adds the display name translation. A translation of the display name in another spoken language.
     *
     * @param lang the language
     * @param text the text
     */
    public void addDisplayNameTranslation(LanguageCode lang, String text) {
        addDisplayNameTranslation(new LangText(lang, text));
    }

    /**
     * Clears the code translation list.
     */
    public void clearCodeTranslationList() {
        this.codeTranslationList = new ArrayList<>();
    }

    /**
     * Clears the display name translation list.
     */
    public void clearDisplayNameTranslationList() {
        this.displayNameTranslationList = new ArrayList<>();
    }

    /**
     * Checks whether the list member contains the given value.
     *
     * @param value the value
     * @return true, if successful
     */
    public boolean contains(CodeBaseType value) {
        if (codeTranslationList != null) {
            for (CodeBaseType entry : codeTranslationList) {
                if (entry.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks whether the list member contains the given value.
     *
     * @param value the value
     * @return true, if successful
     */
    public boolean contains(LangText value) {
        if (displayNameTranslationList != null) {
            for (LangText entry : displayNameTranslationList) {
                if (entry.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks whether the two objects are equal (based on their content).
     *
     * @param obj the CodeBaseType to compare
     * @return true, if equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var retVal = true;
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
    public String getCode() {
        return code;
    }

    /**
     * Sets the code. See getter {@link CodeBaseType#getCode} for more details.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets OID or UUID of the code system.
     *
     * @return the code system
     */
    public String getCodeSystem() {
        return codeSystem;
    }

    /**
     * Sets the code system. See getter {@link CodeBaseType#getCodeSystem} for more details.
     *
     * @param codeSystem the new code system
     */
    public void setCodeSystem(String codeSystem) {
        this.codeSystem = codeSystem;
    }

    /**
     * Gets the name of the code system.
     *
     * @return the code system name
     */
    public String getCodeSystemName() {
        return codeSystemName;
    }

    /**
     * Sets the code system name. See getter {@link CodeBaseType#getCodeSystemName} for more details.
     *
     * @param codeSystemName the new code system name
     */
    public void setCodeSystemName(String codeSystemName) {
        this.codeSystemName = codeSystemName;
    }

    /**
     * Gets the code system version. If applicable, a version descriptor defined specifically for the given code
     * system.
     *
     * @return the code system version
     */
    public String getCodeSystemVersion() {
        return codeSystemVersion;
    }

    /**
     * Sets the code system version. See getter {@link CodeBaseType#getCodeSystemVersion} for more details.
     *
     * @param codeSystemVersion the new code system version
     */
    public void setCodeSystemVersion(String codeSystemVersion) {
        this.codeSystemVersion = codeSystemVersion;
    }

    /**
     * Gets the code translation list for the current code.
     *
     * @return the code translation list
     */
    public List<CodeBaseType> getCodeTranslationList() {
        if (this.codeTranslationList == null)
            this.codeTranslationList = new ArrayList<>();
        return codeTranslationList;
    }

    /**
     * Sets the code translation list. See getter {@link CodeBaseType#getCodeTranslationList} for more details.
     *
     * @param codeTranslationList the new code translation list
     */
    public void setCodeTranslationList(List<CodeBaseType> codeTranslationList) {
        this.codeTranslationList = codeTranslationList;
    }

    /**
     * Gets the display name of the code. It is usually an English text.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name. See getter {@link CodeBaseType#getDisplayName} for more details.
     *
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the translation list for the display name. This List may contain translations of the display name in other
     * spoken languages.
     *
     * @return the display name translation list
     */
    public List<LangText> getDisplayNameTranslationList() {
        if (this.displayNameTranslationList == null)
            this.displayNameTranslationList = new ArrayList<>();
        return displayNameTranslationList;
    }

    /**
     * Sets the display name translation list. See getter {@link CodeBaseType#getDisplayNameTranslationList} for more
     * details.
     *
     * @param displayNameTranslationList the new display name translation list
     */
    public void setDisplayNameTranslationList(List<LangText> displayNameTranslationList) {
        this.displayNameTranslationList = displayNameTranslationList;
    }

    /**
     * Gets the null flavor.
     *
     * @return the null flavor
     */
    public NullFlavor getNullFlavor() {
        return nullFlavor;
    }

    /**
     * Gets the original text. It contains the original text describing the current code.
     *
     * @return the original text
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * Sets the original text. See getter {@link CodeBaseType#getOriginalText} for more details.
     *
     * @param originalText the new original text
     */
    public void setOriginalText(String originalText) {
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
		return new HashCodeBuilder(17, 37).append(this.code).append(this.codeSystem).toHashCode();
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
     * @param nullFlavor the new null flavor
     */
    public void setNullFlavor(NullFlavor nullFlavor) {
        this.nullFlavor = nullFlavor;
    }

    /**
     * Builds a string of the whole code.
     *
     * @return the string
     */
    @Override
    public String toString() {
        var retVal = new StringBuilder();

        if (getCode() != null)
            retVal.append(getCode() + " / ");
        else
            retVal.append("no code !! / ");

        if (getCodeSystem() != null)
            retVal.append(getCodeSystem());
        else
            retVal.append("no code system !!");

        var displayNameL = getDisplayName();
        var codeSystemNameL = getCodeSystemName();
        if ((displayNameL != null) || (codeSystemNameL != null)) {
            retVal.append(" (");

            if (displayNameL != null)
                retVal.append(displayNameL);

            if (codeSystemNameL != null) {
                if (displayNameL != null)
                    retVal.append(" / ");

                retVal.append(codeSystemNameL);
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
         * The code translation list.
         */
        private List<CodeBaseType> codeTranslationList;

        /**
         * The display name.
         */
        private String displayName;

        /**
         * The display name translation list.
         */
        private List<LangText> displayNameTranslationList;

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
        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        /**
         * With code system.
         *
         * @param codeSystem the code system
         * @return the builder
         */
        public Builder withCodeSystem(String codeSystem) {
            this.codeSystem = codeSystem;
            return this;
        }

        /**
         * With code system name.
         *
         * @param codeSystemName the code system name
         * @return the builder
         */
        public Builder withCodeSystemName(String codeSystemName) {
            this.codeSystemName = codeSystemName;
            return this;
        }

        /**
         * With code system version.
         *
         * @param codeSystemVersion the code system version
         * @return the builder
         */
        public Builder withCodeSystemVersion(String codeSystemVersion) {
            this.codeSystemVersion = codeSystemVersion;
            return this;
        }

        /**
         * With code translation list.
         *
         * @param codeTranslationList the code translation list
         * @return the builder
         */
        public Builder withCodeTranslationList(List<CodeBaseType> codeTranslationList) {
            this.codeTranslationList = codeTranslationList;
            return this;
        }

        /**
         * With display name.
         *
         * @param displayName the display name
         * @return the builder
         */
        public Builder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * With display name translation list.
         *
         * @param displayNameTranslationList the display name translation list
         * @return the builder
         */
        public Builder withDisplayNameTranslationList(
                ArrayList<LangText> displayNameTranslationList) {
            this.displayNameTranslationList = displayNameTranslationList;
            return this;
        }

        /**
         * With null flavor.
         *
         * @param nullFlavor the null flavor
         * @return the builder
         */
        public Builder withNullFlavor(NullFlavor nullFlavor) {
            this.nullFlavor = nullFlavor;
            return this;
        }

        /**
         * With original text.
         *
         * @param originalText the original text
         * @return the builder
         */
        public Builder withOriginalText(String originalText) {
            this.originalText = originalText;
            return this;
        }
    }

}
