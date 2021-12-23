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
import org.husky.common.enums.PostalAddressUse;

/**
 * This class provides the basic information for a postal address according to the HL7 address entity. This class does
 * not have any foreign framework dependencies and is therefore one of the base elements of the Husky.
 */
public class AddressBaseType implements Serializable {

	/*
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -5851119541693670862L;
	/**
	 * The additional locator.
	 */
	private String additionalLocator;
	/**
	 * The building number.
	 */
	private String buildingNumber;
	/**
	 * The city.
	 */
	private String city;
	/**
	 * The country.
	 */
	private String country;
	/**
	 * The null flavor.
	 */
	private NullFlavor nullFlavor;
	/**
	 * The postal code.
	 */
	private String postalCode;
	/**
	 * The post box.
	 */
	private String postBox;
	/**
	 * The state.
	 */
	private String state;
	/**
	 * The street address line 1.
	 */
	private String streetAddressLine1;
	/**
	 * The street address line 2.
	 */
	private String streetAddressLine2;
	/**
	 * The street name.
	 */
	private String streetName;
	/**
	 * The usage.
	 */
	private PostalAddressUse usage;

	/**
	 * Instantiates a new AddressBaseType. Default constructor.
	 */
	public AddressBaseType() {
	}

	/**
	 * Instantiates a new address base type.
	 *
	 * @param builder the builder
	 */
	@Generated("SparkTools")
	private AddressBaseType(Builder builder) {
		this.additionalLocator = builder.additionalLocator;
		this.buildingNumber = builder.buildingNumber;
		this.city = builder.city;
		this.country = builder.country;
		this.postalCode = builder.postalCode;
		this.postBox = builder.postBox;
		this.state = builder.state;
		this.streetAddressLine1 = builder.streetAddressLine1;
		this.streetAddressLine2 = builder.streetAddressLine2;
		this.streetName = builder.streetName;
		this.nullFlavor = builder.nullFlavor;
		this.usage = builder.usage;
	}

	/**
	 * Creates builder to build {@link AddressBaseType}.
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
	 * @param obj the AddressBaseType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof AddressBaseType))
			return false;

		retVal = compareAdditionalLocator((AddressBaseType) obj);

		if (retVal) {
			retVal = compareBuildingNumber((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareCity((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareCountry((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = comparePostalCode((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = comparePostBox((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareState((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareStreetAddressLine1((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareStreetAddressLine2((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareStreetName((AddressBaseType) obj);
		}
		if (retVal) {
			retVal = compareUsage((AddressBaseType) obj);
		}
		return retVal;
	}

	private boolean compareAdditionalLocator(AddressBaseType obj) {
		if (this.additionalLocator == null)
			return (obj.getAdditionalLocator() == null);
		else
			return this.additionalLocator.equals(obj.getAdditionalLocator());
	}

	private boolean compareBuildingNumber(AddressBaseType obj) {
		if (this.buildingNumber == null)
			return obj.getBuildingNumber() == null;
		else
			return this.buildingNumber.equals(obj.getBuildingNumber());
	}

	private boolean compareCity(AddressBaseType obj) {
		if (this.city == null)
			return (obj.getCity() == null);
		else
			return this.city.equals(obj.getCity());
	}

	private boolean compareCountry(AddressBaseType obj) {
		if (this.country == null)
			return obj.getCountry() == null;
		else
			return this.country.equals(obj.getCountry());
	}

	private boolean comparePostalCode(AddressBaseType obj) {
		if (this.postalCode == null)
			return obj.getPostalCode() == null;
		else
			return this.postalCode.equals(obj.getPostalCode());
	}

	private boolean comparePostBox(AddressBaseType obj) {
		if (this.postBox == null)
			return obj.getPostBox() == null;
		else
			return this.postBox.equals(obj.getPostBox());
	}

	private boolean compareState(AddressBaseType obj) {
		if (this.state == null)
			return obj.getState() == null;
		else
			return this.state.equals(obj.getState());
	}

	private boolean compareStreetAddressLine1(AddressBaseType obj) {
		if (this.streetAddressLine1 == null)
			return obj.getStreetAddressLine1() == null;
		else
			return this.streetAddressLine1.equals(obj.getStreetAddressLine1());
	}

	private boolean compareStreetAddressLine2(AddressBaseType obj) {
		if (this.streetAddressLine2 == null)
			return obj.getStreetAddressLine2() == null;
		else
			return this.streetAddressLine2.equals(obj.getStreetAddressLine2());
	}

	private boolean compareStreetName(AddressBaseType obj) {
		if (this.streetName == null)
			return obj.getStreetName() == null;
		else
			return this.streetName.equals(obj.getStreetName());
	}

	private boolean compareUsage(AddressBaseType obj) {
		if (this.usage == null)
			return obj.getUsage() == null;
		else
			return this.usage.equals(obj.getUsage());
	}

    /**
     * Gets the additional locator. This can be a unit designator, such as apartment number, suite number, or floor.
     * There may be several unit designators in an address (e.g., "3rd floor, Appt. 342"). This can also be a designator
     * pointing away from the location, rather than specifying a smaller location within some larger one (e.g., Dutch
     * "t.o." means "opposite to" for house boats located across the street facing houses).
     *
     * @return the additional locator
     */
    public String getAdditionalLocator() {
        return additionalLocator;
    }

    /**
     * Sets the additional locator. See getter {@link AddressBaseType#getAdditionalLocator} for more details.
     *
     * @param additionalLocator the new additional locator
     */
    public void setAdditionalLocator(String additionalLocator) {
        this.additionalLocator = additionalLocator;
    }

    /**
     * Gets the building number. The number of a building, house or lot alongside the street. Also known as "primary
     * street number". This does not number the street but rather the building.
     *
     * @return the building number
     */
    public String getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Sets the building number. See getter {@link AddressBaseType#getBuildingNumber} for more details.
     *
     * @param buildingNumber the new building number
     */
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    /**
     * Gets the city. The name of the city, town, village, or other community or delivery center.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city. See getter {@link AddressBaseType#getCity} for more details.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.See getter {@link AddressBaseType#getCountry} for more details.
     *
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
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
     * Gets the postal code. A postal code designating a region defined by the postal service.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code. See getter {@link AddressBaseType#getPostalCode} for more details.
     *
     * @param postalCode the new postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the post box. A numbered box located in a post station.
     *
     * @return the post box
     */
    public String getPostBox() {
        return postBox;
    }

    /**
     * Sets the post box. See getter {@link AddressBaseType#getPostBox} for more details.
     *
     * @param postBox the new post box
     */
    public void setPostBox(String postBox) {
        this.postBox = postBox;
    }

    /**
     * Gets the state. A sub-unit of a country with limited sovereignty in a federally organized country (e.g.
     * Switzerland: canton).
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state See getter {@link AddressBaseType#getState} for more details.
     *
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the street address line 1. Can be used for an additional locator, a delivery address or a street address.
     *
     * @return the street address line 1
     */
    public String getStreetAddressLine1() {
        return streetAddressLine1;
    }

    /**
     * Sets the street address line 1. See getter {@link AddressBaseType#getStreetAddressLine1} for more details.
     *
     * @param streetAddressLine1 the new street address line 1
     */
    public void setStreetAddressLine1(String streetAddressLine1) {
        this.streetAddressLine1 = streetAddressLine1;
    }

    /**
     * Gets the street address line 2. Can be used for an additional locator, a delivery address or a street address.
     *
     * @return the street address line 2
     */
    public String getStreetAddressLine2() {
        return streetAddressLine2;
    }

    /**
     * Sets the street address line 2. See getter {@link AddressBaseType#getStreetAddressLine2} for more details.
     *
     * @param streetAddressLine2 the new street address line 2
     */
    public void setStreetAddressLine2(String streetAddressLine2) {
        this.streetAddressLine2 = streetAddressLine2;
    }

    /**
     * Gets the street name. The name of a roadway or artery recognized by a municipality.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name.See getter {@link AddressBaseType#getStreetName} for more details.
     *
     * @param streetName the new street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets type of usage (such as private, business, ...).
     *
     * @return the usage
     */
    public PostalAddressUse getUsage() {
        return usage;
    }

    /**
     * Sets the type of usage. See getter {@link AddressBaseType#getUsage} for more details.
     *
     * @param usage the new usage
     */
    public void setUsage(PostalAddressUse usage) {
        this.usage = usage;
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
		return new HashCodeBuilder(17, 37).append(this.additionalLocator).append(this.buildingNumber).append(this.city)
				.append(this.country).append(this.postalCode).append(this.postBox).append(this.state)
				.append(this.streetAddressLine1).append(this.streetAddressLine2).append(this.streetName).toHashCode();
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
     * Builds a string of the whole address.
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder retVal = new StringBuilder();

        if (getStreetAddressLine1() != null)
            retVal.append(getStreetAddressLine1() + "\n");
        if (getStreetAddressLine2() != null)
            retVal.append(getStreetAddressLine2() + "\n");
        if (getPostalCode() != null)
            retVal.append(getPostalCode() + " ");
        if (getCity() != null)
            retVal.append(getCity() + "\n");
        if (getState() != null)
            retVal.append(getState() + "\n");
        if (getCountry() != null)
            retVal.append(getCountry() + "\n");

        return retVal.toString();
    }

    /**
     * Builder to build {@link AddressBaseType}.
     */
    @Generated("SparkTools")
    public static final class Builder {

        /**
		 * The additional locator.
		 */
		private String additionalLocator;

		/**
		 * The building number.
		 */
		private String buildingNumber;

		/**
		 * The city.
		 */
		private String city;

		/**
		 * The country.
		 */
		private String country;

		/**
		 * The null flavor.
		 */
		private NullFlavor nullFlavor;

		/**
		 * The postal code.
		 */
		private String postalCode;

		/**
		 * The post box.
		 */
		private String postBox;

		/**
		 * The state.
		 */
		private String state;

		/**
		 * The street address line 1.
		 */
		private String streetAddressLine1;

		/**
		 * The street address line 2.
		 */
		private String streetAddressLine2;

		/**
		 * The street name.
		 */
		private String streetName;

		/**
		 * The usage.
		 */
		private PostalAddressUse usage;

		/**
		 * Instantiates a new builder.
		 */
        private Builder() {
        }

        /**
         * Builds the.
         *
         * @return the address base type
         */
        public AddressBaseType build() {
            return new AddressBaseType(this);
        }

        /**
         * With additional locator.
         *
         * @param additionalLocator the additional locator
         * @return the builder
         */
        public Builder withAdditionalLocator(String additionalLocator) {
            this.additionalLocator = additionalLocator;
            return this;
        }

        /**
         * With building number.
         *
         * @param buildingNumber the building number
         * @return the builder
         */
        public Builder withBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }

        /**
         * With city.
         *
         * @param city the city
         * @return the builder
         */
        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        /**
         * With country.
         *
         * @param country the country
         * @return the builder
         */
        public Builder withCountry(String country) {
            this.country = country;
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
         * With postal code.
         *
         * @param postalCode the postal code
         * @return the builder
         */
        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        /**
         * With post box.
         *
         * @param postBox the post box
         * @return the builder
         */
        public Builder withPostBox(String postBox) {
            this.postBox = postBox;
            return this;
        }

        /**
         * With state.
         *
         * @param state the state
         * @return the builder
         */
        public Builder withState(String state) {
            this.state = state;
            return this;
        }

        /**
         * With street address line 1.
         *
         * @param streetAddressLine1 the street address line 1
         * @return the builder
         */
        public Builder withStreetAddressLine1(String streetAddressLine1) {
            this.streetAddressLine1 = streetAddressLine1;
            return this;
        }

        /**
         * With street address line 2.
         *
         * @param streetAddressLine2 the street address line 2
         * @return the builder
         */
        public Builder withStreetAddressLine2(String streetAddressLine2) {
            this.streetAddressLine2 = streetAddressLine2;
            return this;
        }

        /**
         * With street name.
         *
         * @param streetName the street name
         * @return the builder
         */
        public Builder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        /**
         * With usage.
         *
         * @param usage the usage
         * @return the builder
         */
        public Builder withUsage(PostalAddressUse usage) {
            this.usage = usage;
            return this;
        }
    }

}
