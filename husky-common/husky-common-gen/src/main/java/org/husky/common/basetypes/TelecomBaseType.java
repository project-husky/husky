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
import org.husky.common.enums.TelecomAddressUse;

/**
 * Details for all kinds of technology-mediated contact points for a person or organization, including telephone, email,
 * etc.
 */
public class TelecomBaseType implements Serializable {

    /*
     * See getter/setter for more details to the class members.
     */

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 6908791040642752931L;
    /**
     * The null flavor.
     */
    private NullFlavor nullFlavor;
    /**
     * The usage.
     */
    private TelecomAddressUse usage;
    /**
     * The value.
     */
    private String value;

    /**
     * Instantiates a new TelecomBaseType. Default constructor.
     */
    public TelecomBaseType() {
    }

    /**
     * Instantiates a new telecom base type.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private TelecomBaseType(Builder builder) {
        this.usage = builder.usage;
        this.value = builder.value;
        this.nullFlavor = builder.nullFlavor;
    }

    /**
     * Creates builder to build {@link TelecomBaseType}.
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
     * @param obj the TelecomBaseType to compare
     * @return true, if equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var retVal = true;
        if (obj == null)
            return false;
        if (!(obj instanceof TelecomBaseType))
            return false;
        if (retVal) {
            if (this.usage == null)
                retVal = (((TelecomBaseType) obj).getUsage() == null);
            else
                retVal = this.usage.equals(((TelecomBaseType) obj).getUsage());
        }
        if (retVal) {
            if (this.value == null)
                retVal = (((TelecomBaseType) obj).getValue() == null);
            else
                retVal = this.value.equals(((TelecomBaseType) obj).getValue());
        }
        return retVal;
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
     * Gets the type of usage (business, private, emergency, vacation, ...).
     *
     * @return the usage
     */
    public TelecomAddressUse getUsage() {
        return usage;
    }

    /**
     * Sets the type of usage (business, private, emergency, vacation, ...).
     *
     * @param usage the new usage
     */
    public void setUsage(TelecomAddressUse usage) {
        this.usage = usage;
    }

    /**
     * Gets the value. This is the real phone number, eMail Address, URL, ...
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value. This is the real phone number, eMail Address, URL, ...
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
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
		return new HashCodeBuilder(17, 37).append(this.value).append(this.usage != null ? this.usage.hashCode() : null)
				.toHashCode();
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
     * Sets the value as phone number.
     *
     * @param value the new phone
     */
    public void setFax(String value) {
        setValue("fax:" + value);
    }

    /**
     * Sets the value as eMail Address.
     *
     * @param value the new phone
     */
    public void setMail(String value) {
        setValue("mailto:" + value);
    }

    /**
     * Sets the value as phone number.
     *
     * @param value the new phone
     */
    public void setPhone(String value) {
        setValue("tel:" + value);
    }

    /**
     * Builds a string of the telecom.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return getValue();
    }

    /**
     * Builder to build {@link TelecomBaseType}.
     */
    @Generated("SparkTools")
    public static final class Builder {
        /**
         * The null flavor.
         */
        private NullFlavor nullFlavor;
        /**
         * The usage.
         */
        private TelecomAddressUse usage;
        /**
         * The value.
         */
        private String value;

        /**
         * Instantiates a new builder.
         */
        private Builder() {
        }

        /**
         * Builds the.
         *
         * @return the telecom base type
         */
        public TelecomBaseType build() {
            return new TelecomBaseType(this);
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
         * With usage.
         *
         * @param usage the usage
         * @return the builder
         */
        public Builder withUsage(TelecomAddressUse usage) {
            this.usage = usage;
            return this;
        }

        /**
         * With value.
         *
         * @param value the value
         * @return the builder
         */
        public Builder withValue(String value) {
            this.value = value;
            return this;
        }
    }

}
