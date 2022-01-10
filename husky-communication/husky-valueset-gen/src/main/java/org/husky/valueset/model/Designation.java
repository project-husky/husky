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
package org.husky.valueset.model;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.husky.common.enums.LanguageCode;
import org.husky.valueset.enums.DesignationType;

/**
 * Designations are language dependent display names for the code. For any language there might be multiple, each
 * specifying the type (fully specified name, preferred, synonym, ...).
 */
public class Designation implements Serializable {

    /*
     * See getter/setter for more details to the class members.
     */

    /**
     *
     */
    private static final long serialVersionUID = -2551878616152131257L;
    /**
     * The display name.
     */
    private String displayName;
    /**
     * The language code.
     */
    private LanguageCode languageCode;
    /**
     * The type.
     */
    private DesignationType type;

    /**
     * Instantiates a new Designation. Default constructor.
     */
    public Designation() {
    }

    /**
     * Instantiates a new designation.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private Designation(Builder builder) {
        this.languageCode = builder.languageCode;
        this.type = builder.type;
        this.displayName = builder.displayName;
    }

    /**
     * Creates builder to build {@link Designation}.
     *
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Checks whether the two objects are equal (based on their content).
     *
     * @param obj the Designation to compare
     * @return true, if equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var retVal = true;
        if (obj == null)
            return false;

        if (!(obj instanceof Designation))
            return false;

        if (this.languageCode == null)
            retVal = (((Designation) obj).getLanguageCode() == null);
        else
            retVal = (this.languageCode == ((Designation) obj).getLanguageCode());

        if (retVal) {
            if (this.type == null)
                retVal = (((Designation) obj).getType() == null);
            else
                retVal = (this.type == ((Designation) obj).getType());
        }
        if (retVal) {
            if (this.displayName == null)
                retVal = (((Designation) obj).getDisplayName() == null);
            else
                retVal = this.displayName.equals(((Designation) obj).getDisplayName());
        }
        return retVal;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the language code.
     *
     * @return the language code
     */
    public LanguageCode getLanguageCode() {
        return languageCode;
    }

    /**
     * Sets the language code.
     *
     * @param languageCode the new language code
     */
    public void setLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode;
    }

    /**
     * Gets the designations type (fully specified name, preferred, synonym, ...).
     *
     * @return the type
     */
    public DesignationType getType() {
        return type;
    }

    /**
     * Sets the designations type (fully specified name, preferred, synonym, ...).
     *
     * @param type the new type
     */
    public void setType(DesignationType type) {
        this.type = type;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.languageCode).append(this.type).append(this.displayName)
				.toHashCode();
    }

    /**
     * Builder to build {@link Designation}.
     */
    @Generated("SparkTools")
    public static final class Builder {

        /**
         * The display name.
         */
        private String displayName;

        /**
         * The language code.
         */
        private LanguageCode languageCode;

        /**
         * The type.
         */
        private DesignationType type;

        /**
         * Instantiates a new builder.
         */
        private Builder() {
        }

        /**
         * Builds the.
         *
         * @return the designation
         */
        public Designation build() {
            return new Designation(this);
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
         * With language code.
         *
         * @param languageCode the language code
         * @return the builder
         */
        public Builder withLanguageCode(LanguageCode languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * With type.
         *
         * @param type the type
         * @return the builder
         */
        public Builder withType(DesignationType type) {
            this.type = type;
            return this;
        }
    }
}
