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
import org.husky.common.enums.NullFlavor;

/**
 * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form
 * of collective action. Includes companies, institutions, corporations, departments, community groups, healthcare
 * practice groups, payer/insurer, etc.
 */
public class OrganizationBaseType implements Serializable {

    /*
     * See getter/setter for more details to the class members.
     */

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2506412743872695565L;
    /**
     * The address list.
     */
    private List<AddressBaseType> addressList;
    /**
     * The identificator list.
     */
    private List<IdentificatorBaseType> identificatorList;
    /**
     * The name list.
     */
    private List<NameBaseType> nameList;
    /**
     * The null flavor.
     */
    private NullFlavor nullFlavor;
    /**
     * The primary address.
     */
    private AddressBaseType primaryAddress;
    /**
     * The primary identificator.
     */
    private IdentificatorBaseType primaryIdentificator;
    /**
     * The primary name.
     */
    private NameBaseType primaryName;
    /**
     * The primary telecom.
     */
    private TelecomBaseType primaryTelecom;
    /**
     * The telecom list.
     */
    private List<TelecomBaseType> telecomList;

    /**
     * Instantiates a new OrganizationBaseType. Default constructor.
     */
    public OrganizationBaseType() {
    }

    /**
     * Instantiates a new organization base type.
     *
     * @param builder the builder
     */
    @Generated("SparkTools")
    private OrganizationBaseType(Builder builder) {
        this.addressList = builder.addressList;
        this.identificatorList = builder.identificatorList;
        this.nameList = builder.nameList;
        this.primaryAddress = builder.primaryAddress;
        this.primaryIdentificator = builder.primaryIdentificator;
        this.primaryName = builder.primaryName;
        this.primaryTelecom = builder.primaryTelecom;
        this.nullFlavor = builder.nullFlavor;
        this.telecomList = builder.telecomList;
    }

    /**
     * Creates builder to build {@link OrganizationBaseType}.
     *
     * @return created builder
     */
    @Generated("SparkTools")
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Adds an address. The first one becomes the primary address by default.
     *
     * @param value the value
     */
    public void addAddress(AddressBaseType value) {
        if (this.addressList == null) {
            this.addressList = new ArrayList<>();
            if (primaryAddress == null)
                primaryAddress = value;
        }
        this.addressList.add(value);
    }

    /**
     * Adds an identificator. The first one becomes the primary identificator by default.
     *
     * @param value the value
     */
    public void addIdentificator(IdentificatorBaseType value) {
        if (this.identificatorList == null) {
            this.identificatorList = new ArrayList<>();
            if (primaryIdentificator == null)
                primaryIdentificator = value;
        }
        this.identificatorList.add(value);
    }

    /**
     * Adds a name. The first one becomes the primary name by default.
     *
     * @param value the value
     */
    public void addName(NameBaseType value) {
        if (this.nameList == null) {
            this.nameList = new ArrayList<>();
            if (primaryName == null)
                primaryName = value;
        }
        this.nameList.add(value);
    }

    /**
     * Adds a telecom Element. The first one becomes the primary telecom by default.
     *
     * @param value the value
     */
    public void addTelecom(TelecomBaseType value) {
        if (this.telecomList == null) {
            this.telecomList = new ArrayList<>();
            if (primaryTelecom == null)
                primaryTelecom = value;
        }
        this.telecomList.add(value);
    }

    /**
     * Clears the address list.
     */
    public void clearAddressList() {
        this.addressList = new ArrayList<>();
    }

    /**
     * Clears the identificator list.
     */
    public void clearIdentificatorList() {
        this.identificatorList = new ArrayList<>();
    }

    /**
     * Clears the name list.
     */
    public void clearNameList() {
        this.nameList = new ArrayList<>();
    }

    /**
     * Clears the telecom list.
     */
    public void clearTelecomList() {
        this.telecomList = new ArrayList<>();
    }

    /**
     * Checks whether the list member contains the given value.
     *
     * @param value the value
     * @return true, if successful
     */
    public boolean contains(AddressBaseType value) {
        if (addressList != null) {
            for (AddressBaseType entry : addressList) {
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
    public boolean contains(IdentificatorBaseType value) {
        if (addressList != null) {
            for (IdentificatorBaseType entry : identificatorList) {
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
    public boolean contains(NameBaseType value) {
        if (addressList != null) {
            for (NameBaseType entry : nameList) {
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
    public boolean contains(TelecomBaseType value) {
        if (addressList != null) {
            for (TelecomBaseType entry : telecomList) {
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
     * @param obj the OrganizationBaseType to compare
     * @return true, if equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        var retVal = true;
        if (obj == null)
            return false;
        if (!(obj instanceof OrganizationBaseType))
            return false;

		retVal = compareAddressList((OrganizationBaseType) obj);

        if (retVal) {
			retVal = compareIdentificatorList((OrganizationBaseType) obj);
        }
        if (retVal) {
			retVal = compareNameList((OrganizationBaseType) obj);
        }
        if (retVal) {
			retVal = compareTelecomList((OrganizationBaseType) obj);
        }
        return retVal;
    }

	private boolean compareAddressList(OrganizationBaseType obj) {
		var retVal = true;
		if (this.addressList == null)
			this.addressList = new ArrayList<>();
		for (var i = 0; i < this.addressList.size(); i++) {
			retVal = obj.contains(this.addressList.get(i));
			if (!retVal)
				return false;
		}

		return retVal;
	}

	private boolean compareIdentificatorList(OrganizationBaseType obj) {
		var retVal = true;
		if (this.identificatorList == null)
			this.identificatorList = new ArrayList<>();
		for (var i = 0; i < this.identificatorList.size(); i++) {
			retVal = obj.contains(this.identificatorList.get(i));
			if (!retVal)
				return false;
		}

		return retVal;
	}

	private boolean compareNameList(OrganizationBaseType obj) {
		var retVal = true;
		if (this.nameList == null)
			this.nameList = new ArrayList<>();
		for (var i = 0; i < this.nameList.size(); i++) {
			retVal = obj.contains(this.nameList.get(i));
			if (!retVal)
				return false;
		}

		return retVal;
	}

	private boolean compareTelecomList(OrganizationBaseType obj) {
		var retVal = true;
		if (this.telecomList == null)
			this.telecomList = new ArrayList<>();
		for (var i = 0; i < this.telecomList.size(); i++) {
			retVal = obj.contains(this.telecomList.get(i));
			if (!retVal)
				return false;
		}

		return retVal;
	}

    /**
     * Gets the address list.
     *
     * @return the address list
     */
    public List<AddressBaseType> getAddressList() {
        if (this.addressList == null)
            this.addressList = new ArrayList<>();
        return addressList;
    }

    /**
     * Sets the address list.
     *
     * @param addressList the new address list
     */
    public void setAddressList(List<AddressBaseType> addressList) {
        this.addressList = addressList;
    }

    /**
     * Gets the identificator list.
     *
     * @return the identificator list
     */
    public List<IdentificatorBaseType> getIdentificatorList() {
        if (this.identificatorList == null)
            this.identificatorList = new ArrayList<>();
        return identificatorList;
    }

    /**
     * Sets the identificator list.
     *
     * @param identificatorList the new identificator list
     */
    public void setIdentificatorList(List<IdentificatorBaseType> identificatorList) {
        this.identificatorList = identificatorList;
    }

    /**
     * Gets the name list.
     *
     * @return the name list
     */
    public List<NameBaseType> getNameList() {
        if (this.nameList == null)
            this.nameList = new ArrayList<>();
        return nameList;
    }

    /**
     * Sets the name list.
     *
     * @param nameList the new name list
     */
    public void setNameList(List<NameBaseType> nameList) {
        this.nameList = nameList;
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
     * Gets the primary address.
     *
     * @return the primary address
     */
    public AddressBaseType getPrimaryAddress() {
        return primaryAddress;
    }

    /**
     * Sets the primary address. See getter {@link OrganizationBaseType#getPrimaryAddress} for more details.
     *
     * @param primaryAddress the new primary address
     */
    public void setPrimaryAddress(AddressBaseType primaryAddress) {
        this.primaryAddress = primaryAddress;
        if (primaryAddress != null)
            addAddress(primaryAddress);
    }

    /**
     * Gets the primary identificator.
     *
     * @return the primary identificator
     */
    public IdentificatorBaseType getPrimaryIdentificator() {
        return primaryIdentificator;
    }

    /**
     * Sets the primary identificator. See getter {@link OrganizationBaseType#getPrimaryIdentificator} for more
     * details.
     *
     * @param primaryIdentificator the new primary identificator
     */
    public void setPrimaryIdentificator(IdentificatorBaseType primaryIdentificator) {
        this.primaryIdentificator = primaryIdentificator;
        if (primaryIdentificator != null)
            addIdentificator(primaryIdentificator);
    }

    /**
     * Gets the primary name.
     *
     * @return the primary name
     */
    public NameBaseType getPrimaryName() {
        return primaryName;
    }

    /**
     * Sets the primary name. It will not automatically be added to the list of names. See getter {@link
     * OrganizationBaseType#getPrimaryName} for more details.
     *
     * @param primaryName the new primary name
     */
    public void setPrimaryName(NameBaseType primaryName) {
        this.primaryName = primaryName;
        if (primaryName != null)
            addName(primaryName);
    }

    /**
     * Gets the primary telecom.
     *
     * @return the primary telecom
     */
    public TelecomBaseType getPrimaryTelecom() {
        return primaryTelecom;
    }

    /**
     * Sets the primary telecom. It will not automatically be added to the list of telecoms. See getter {@link
     * OrganizationBaseType#getPrimaryTelecom} for more details.
     *
     * @param primaryTelecom the new primary telecom
     */
    public void setPrimaryTelecom(TelecomBaseType primaryTelecom) {
        this.primaryTelecom = primaryTelecom;
        if (primaryTelecom != null)
            addTelecom(primaryTelecom);
    }

    /**
     * Gets the telecom list.
     *
     * @return the telecom list
     */
    public List<TelecomBaseType> getTelecomList() {
        if (this.telecomList == null)
            this.telecomList = new ArrayList<>();
        return telecomList;
    }

    /**
     * Sets the telecom list.
     *
     * @param telecomList the new telecom list
     */
    public void setTelecomList(List<TelecomBaseType> telecomList) {
        this.telecomList = telecomList;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(17, 37);

		for (var address : this.addressList) {
			builder.append(address.hashCode());
		}

		for (var id : this.identificatorList) {
			builder.append(id.hashCode());
		}

		for (var name : this.nameList) {
			builder.append(name.hashCode());
		}

		for (var telecom : this.telecomList) {
			builder.append(telecom.hashCode());
		}

		return builder.toHashCode();
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
     * Builds a string of the organization (primaryName and primaryAddress, only).
     *
     * @return the string
     */
    @Override
    public String toString() {
        var retVal = new StringBuilder();

        retVal.append(getPrimaryName().toString());
        retVal.append("\n");
        retVal.append(getPrimaryAddress().toString());

        return retVal.toString();
    }

    /**
     * Builder to build {@link OrganizationBaseType}.
     */
    @Generated("SparkTools")
    public static final class Builder {

        /**
         * The address list.
         */
        private List<AddressBaseType> addressList;

        /**
         * The identificator list.
         */
        private List<IdentificatorBaseType> identificatorList;

        /**
         * The name list.
         */
        private List<NameBaseType> nameList;

        /**
         * The null flavor.
         */
        private NullFlavor nullFlavor;

        /**
         * The primary address.
         */
        private AddressBaseType primaryAddress;

        /**
         * The primary identificator.
         */
        private IdentificatorBaseType primaryIdentificator;

        /**
         * The primary name.
         */
        private NameBaseType primaryName;

        /**
         * The primary telecom.
         */
        private TelecomBaseType primaryTelecom;

        /**
         * The telecom list.
         */
        private List<TelecomBaseType> telecomList;

        /**
         * Instantiates a new builder.
         */
        private Builder() {
        }

        /**
         * Builds the.
         *
         * @return the organization base type
         */
        public OrganizationBaseType build() {
            return new OrganizationBaseType(this);
        }

        /**
         * With address list.
         *
         * @param addressList the address list
         * @return the builder
         */
        public Builder withAddressList(ArrayList<AddressBaseType> addressList) {
            this.addressList = addressList;
            return this;
        }

        /**
         * With identificator list.
         *
         * @param identificatorList the identificator list
         * @return the builder
         */
        public Builder withIdentificatorList(ArrayList<IdentificatorBaseType> identificatorList) {
            this.identificatorList = identificatorList;
            return this;
        }

        /**
         * With name list.
         *
         * @param nameList the name list
         * @return the builder
         */
        public Builder withNameList(ArrayList<NameBaseType> nameList) {
            this.nameList = nameList;
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
         * With primary address.
         *
         * @param primaryAddress the primary address
         * @return the builder
         */
        public Builder withPrimaryAddress(AddressBaseType primaryAddress) {
            this.primaryAddress = primaryAddress;
            return this;
        }

        /**
         * With primary identificator.
         *
         * @param primaryIdentificator the primary identificator
         * @return the builder
         */
        public Builder withPrimaryIdentificator(IdentificatorBaseType primaryIdentificator) {
            this.primaryIdentificator = primaryIdentificator;
            return this;
        }

        /**
         * With primary name.
         *
         * @param primaryName the primary name
         * @return the builder
         */
        public Builder withPrimaryName(NameBaseType primaryName) {
            this.primaryName = primaryName;
            return this;
        }

        /**
         * With primary telecom.
         *
         * @param primaryTelecom the primary telecom
         * @return the builder
         */
        public Builder withPrimaryTelecom(TelecomBaseType primaryTelecom) {
            this.primaryTelecom = primaryTelecom;
            return this;
        }

        /**
         * With telecom list.
         *
         * @param telecomList the telecom list
         * @return the builder
         */
        public Builder withTelecomList(ArrayList<TelecomBaseType> telecomList) {
            this.telecomList = telecomList;
            return this;
        }
    }

}
