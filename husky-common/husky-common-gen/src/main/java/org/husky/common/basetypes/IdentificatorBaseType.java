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

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.husky.common.enums.NullFlavor;

/**
 * An identifier that uniquely identifies a thing or object. Examples are object identifier for HL7 RIM objects, medical
 * record number, order id, service catalog item id, Vehicle Identification Number (VIN), etc. Instance identifiers are
 * defined based on ISO object identifiers.
 */
public class IdentificatorBaseType implements Serializable {

    /*
     * See getter/setter for more details to the class members.
     */

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -8238734619665101769L;
    /**
     * The assigning authority name.
     */
    private String assigningAuthorityName;
    /**
     * The displayable.
     */
    private Boolean displayable;
    /**
     * The extension.
     */
    private String extension;
    /**
     * The null flavor.
     */
    private NullFlavor nullFlavor;
    /**
     * The root.
     */
    private String root;

    /**
     * Instantiates a new IdentificatorBaseType. Default constructor.
     */
    public IdentificatorBaseType() {
    }

    /**
     * Instantiates a new identificator base type.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private IdentificatorBaseType(Builder builder) {
        this.assigningAuthorityName = builder.assigningAuthorityName;
        this.displayable = builder.displayable;
        this.extension = builder.extension;
        this.root = builder.root;
        this.nullFlavor = builder.nullFlavor;
    }

    /**
     * Creates builder to build {@link IdentificatorBaseType}.
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
     * @param obj the IdentificatorBaseType to compare
     * @return true, if equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var retVal = true;
        if (obj == null)
            return false;
        if (!(obj instanceof IdentificatorBaseType))
            return false;
        // only business rules are applied, here. rest was initially implemented
        // and stays here for future use. If you use it, you need to imnplement
        // another method and not change the currenty methos.
        // if (retVal) {
        // if (this.assigningAuthorityName == null)
        // retVal = (obj.getAssigningAuthorityName() == null);
        // else
        // retVal =
        // this.assigningAuthorityName.equals(obj.getAssigningAuthorityName());
        // }
        // if (retVal)
        // retVal = (this.displayable == obj.isDisplayable());
        if (retVal) {
            if (this.extension == null) {
                retVal = (((IdentificatorBaseType) obj).getExtension() == null);
            } else {
                retVal = this.extension.equals(((IdentificatorBaseType) obj).getExtension());
            }
        }

        if (retVal) {
            if (this.root == null) {
                retVal = (((IdentificatorBaseType) obj).getRoot() == null);
            } else {
                retVal = this.root.equals(((IdentificatorBaseType) obj).getRoot());
            }
        }

        return retVal;
    }

    /**
     * Gets the assigning authority name.
     *
     * @return the assigning authority name
     */
    public String getAssigningAuthorityName() {
        return assigningAuthorityName;
    }

    /**
     * Sets the assigning authority name. See getter {@link IdentificatorBaseType#getAssigningAuthorityName} for more
     * details.
     *
     * @param assigningAuthorityName the new assigning authority name
     */
    public void setAssigningAuthorityName(String assigningAuthorityName) {
        this.assigningAuthorityName = assigningAuthorityName;
    }

    /**
     * Gets the extension. A character string as a unique identifier within the scope of the identifier root.
     *
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the extension. See getter {@link IdentificatorBaseType#getExtension} for more details.
     *
     * @param extension the new extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
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
     * Gets the OID or UUID of the domain. A unique identifier that guarantees the global uniqueness of the instance
     * identifier. The root alone may be the entire instance identifier (e.g. UUID without further definition by the
     * extension).
     *
     * @return the root
     */
    public String getRoot() {
        return root;
    }

    /**
     * Sets the root. See getter {@link IdentificatorBaseType#getRoot} for more details.
     *
     * @param root the new root
     */
    public void setRoot(String root) {
        this.root = root;
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
		return new HashCodeBuilder(17, 37).append(this.extension).append(this.root).toHashCode();
	}

    /**
     * Checks if is displayable. Specifies if the identifier is intended for human display and data entry (displayable =
     * true) as opposed to pure machine interoperation (displayable = false).
     *
     * @return true, if is displayable
     */
    public Boolean isDisplayable() {
        return displayable;
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
     * Sets the displayable flag. See getter {@link IdentificatorBaseType#isDisplayable} for more details.
     *
     * @param displayable the new displayable
     */
    public void setDisplayable(Boolean displayable) {
        this.displayable = displayable;
    }

    /**
     * Builds a string of the whole identificator.
     *
     * @return the string
     */
    @Override
    public String toString() {
        var retVal = new StringBuilder();

        if (getRoot() != null)
            retVal.append(getRoot());
        else
            retVal.append("no root !!");

        String extensionL = getExtension();
        String assigningAuthorityNameL = getAssigningAuthorityName();

        if (extensionL != null)
            retVal.append(" / " + extension);

        if (assigningAuthorityNameL != null) {
            retVal.append(" (");
            retVal.append(assigningAuthorityNameL);
            retVal.append(")");
        }

        return retVal.toString();
    }

    /**
     * Builder to build {@link IdentificatorBaseType}.
     */
    @Generated("SparkTools")
    public static final class Builder {

        /**
         * The assigning authority name.
         */
        private String assigningAuthorityName;

        /**
         * The displayable.
         */
        private Boolean displayable;

        /**
         * The extension.
         */
        private String extension;

        /**
         * The null flavor.
         */
        private NullFlavor nullFlavor;

        /**
         * The root.
         */
        private String root;

        /**
         * Instantiates a new builder.
         */
        private Builder() {
        }

        /**
         * Builds the.
         *
         * @return the identificator base type
         */
        public IdentificatorBaseType build() {
            return new IdentificatorBaseType(this);
        }

        /**
         * With assigning authority name.
         *
         * @param assigningAuthorityName the assigning authority name
         * @return the builder
         */
        public Builder withAssigningAuthorityName(String assigningAuthorityName) {
            this.assigningAuthorityName = assigningAuthorityName;
            return this;
        }

        /**
         * With displayable.
         *
         * @param displayable the displayable
         * @return the builder
         */
        public Builder withDisplayable(Boolean displayable) {
            this.displayable = displayable;
            return this;
        }

        /**
         * With extension.
         *
         * @param extension the extension
         * @return the builder
         */
        public Builder withExtension(String extension) {
            this.extension = extension;
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
         * With root.
         *
         * @param root the root
         * @return the builder
         */
        public Builder withRoot(String root) {
            this.root = root;
            return this;
        }
    }

}
