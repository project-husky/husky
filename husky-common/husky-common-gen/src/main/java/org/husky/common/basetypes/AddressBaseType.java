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
package org.husky.common.basetypes;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.PostalAddressUse;
import org.husky.common.utils.Util;

/**
 * <div class="en">This class provides the basic information for a postal
 * address according to the HL7 address entity. This class does not have any
 * foreign framework dependencies and is therefore one of the base elements of
 * the eHealth Connector.<div>
 *
 * <div class="de">Diese Klasse enthält die Basisinformationen für eine
 * Postanschrift gemäss der HL7 V3-Adressentität. Diese Klasse hat keine fremden
 * Framework-Abhängigkeiten und ist daher eines der Basiselemente des eHealth
 * Connector.<div>
 *
 */
public class AddressBaseType implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link AddressBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The additional locator. */
		private String additionalLocator;

		/** The building number. */
		private String buildingNumber;

		/** The city. */
		private String city;

		/** The country. */
		private String country;

		/** The null flavor. */
		private NullFlavor nullFlavor;

		/** The postal code. */
		private String postalCode;

		/** The post box. */
		private String postBox;

		/** The state. */
		private String state;

		/** The street address line 1. */
		private String streetAddressLine1;

		/** The street address line 2. */
		private String streetAddressLine2;

		/** The street name. */
		private String streetName;

		/** The usage. */
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
		 * @param additionalLocator
		 *            the additional locator
		 * @return the builder
		 */
		public Builder withAdditionalLocator(String additionalLocator) {
			this.additionalLocator = additionalLocator;
			return this;
		}

		/**
		 * With building number.
		 *
		 * @param buildingNumber
		 *            the building number
		 * @return the builder
		 */
		public Builder withBuildingNumber(String buildingNumber) {
			this.buildingNumber = buildingNumber;
			return this;
		}

		/**
		 * With city.
		 *
		 * @param city
		 *            the city
		 * @return the builder
		 */
		public Builder withCity(String city) {
			this.city = city;
			return this;
		}

		/**
		 * With country.
		 *
		 * @param country
		 *            the country
		 * @return the builder
		 */
		public Builder withCountry(String country) {
			this.country = country;
			return this;
		}

		/**
		 * With null flavor.
		 *
		 * @param nullFlavor
		 *            the null flavor
		 * @return the builder
		 */
		public Builder withNullFlavor(NullFlavor nullFlavor) {
			this.nullFlavor = nullFlavor;
			return this;
		}

		/**
		 * With postal code.
		 *
		 * @param postalCode
		 *            the postal code
		 * @return the builder
		 */
		public Builder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		/**
		 * With post box.
		 *
		 * @param postBox
		 *            the post box
		 * @return the builder
		 */
		public Builder withPostBox(String postBox) {
			this.postBox = postBox;
			return this;
		}

		/**
		 * With state.
		 *
		 * @param state
		 *            the state
		 * @return the builder
		 */
		public Builder withState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * With street address line 1.
		 *
		 * @param streetAddressLine1
		 *            the street address line 1
		 * @return the builder
		 */
		public Builder withStreetAddressLine1(String streetAddressLine1) {
			this.streetAddressLine1 = streetAddressLine1;
			return this;
		}

		/**
		 * With street address line 2.
		 *
		 * @param streetAddressLine2
		 *            the street address line 2
		 * @return the builder
		 */
		public Builder withStreetAddressLine2(String streetAddressLine2) {
			this.streetAddressLine2 = streetAddressLine2;
			return this;
		}

		/**
		 * With street name.
		 *
		 * @param streetName
		 *            the street name
		 * @return the builder
		 */
		public Builder withStreetName(String streetName) {
			this.streetName = streetName;
			return this;
		}

		/**
		 * With usage.
		 *
		 * @param usage
		 *            the usage
		 * @return the builder
		 */
		public Builder withUsage(PostalAddressUse usage) {
			this.usage = usage;
			return this;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5851119541693670862L;

	/**
	 * Creates builder to build {@link AddressBaseType}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The additional locator. */
	private String additionalLocator;

	/** The building number. */
	private String buildingNumber;

	/** The city. */
	private String city;

	/** The country. */
	private String country;

	/** The null flavor. */
	private NullFlavor nullFlavor;

	/** The postal code. */
	private String postalCode;

	/** The post box. */
	private String postBox;

	/** The state. */
	private String state;

	/** The street address line 1. */
	private String streetAddressLine1;

	/** The street address line 2. */
	private String streetAddressLine2;

	/** The street name. */
	private String streetName;

	/** The usage. */
	private PostalAddressUse usage;

	/**
	 * <div class="en">Instantiates a new AddressBaseType. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen neuen AddressBaseType.
	 * Standardkonstruktor.</div>
	 */
	public AddressBaseType() {
	}

	/**
	 * Instantiates a new address base type.
	 *
	 * @param builder
	 *            the builder
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
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the AddressBaseType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof AddressBaseType))
			return false;

		if (retVal) {
			if (this.additionalLocator == null)
				retVal = (((AddressBaseType) obj).getAdditionalLocator() == null);
			else
				retVal = this.additionalLocator
						.equals(((AddressBaseType) obj).getAdditionalLocator());
		}
		if (retVal) {
			if (this.buildingNumber == null)
				retVal = (((AddressBaseType) obj).getBuildingNumber() == null);
			else
				retVal = this.buildingNumber.equals(((AddressBaseType) obj).getBuildingNumber());
		}
		if (retVal) {
			if (this.city == null)
				retVal = (((AddressBaseType) obj).getCity() == null);
			else
				retVal = this.city.equals(((AddressBaseType) obj).getCity());
		}
		if (retVal) {
			if (this.country == null)
				retVal = (((AddressBaseType) obj).getCountry() == null);
			else
				retVal = this.country.equals(((AddressBaseType) obj).getCountry());
		}
		if (retVal) {
			if (this.postalCode == null)
				retVal = (((AddressBaseType) obj).getPostalCode() == null);
			else
				retVal = this.postalCode.equals(((AddressBaseType) obj).getPostalCode());
		}
		if (retVal) {
			if (this.postBox == null)
				retVal = (((AddressBaseType) obj).getPostBox() == null);
			else
				retVal = this.postBox.equals(((AddressBaseType) obj).getPostBox());
		}
		if (retVal) {
			if (this.state == null)
				retVal = (((AddressBaseType) obj).getState() == null);
			else
				retVal = this.state.equals(((AddressBaseType) obj).getState());
		}
		if (retVal) {
			if (this.streetAddressLine1 == null)
				retVal = (((AddressBaseType) obj).getStreetAddressLine1() == null);
			else
				retVal = this.streetAddressLine1
						.equals(((AddressBaseType) obj).getStreetAddressLine1());
		}
		if (retVal) {
			if (this.streetAddressLine2 == null)
				retVal = (((AddressBaseType) obj).getStreetAddressLine2() == null);
			else
				retVal = this.streetAddressLine2
						.equals(((AddressBaseType) obj).getStreetAddressLine2());
		}
		if (retVal) {
			if (this.streetName == null)
				retVal = (((AddressBaseType) obj).getStreetName() == null);
			else
				retVal = this.streetName.equals(((AddressBaseType) obj).getStreetName());
		}
		if (retVal) {
			if (this.usage == null)
				retVal = (((AddressBaseType) obj).getUsage() == null);
			else
				retVal = this.usage.equals(((AddressBaseType) obj).getUsage());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the additional locator. This can be a unit
	 * designator, such as apartment number, suite number, or floor. There may
	 * be several unit designators in an address (e.g., "3rd floor, Appt. 342").
	 * This can also be a designator pointing away from the location, rather
	 * than specifying a smaller location within some larger one (e.g., Dutch
	 * "t.o." means "opposite to" for house boats located across the street
	 * facing houses).</div>
	 *
	 * <div class="de">Ruft die Zusatzangabe ab. Dies kann eine
	 * Einheitenbezeichnung sein, z. B. Wohnungsnummer oder Etage. Eine Adresse
	 * kann mehrere Zusatzangaben im gleichen Feld enthalten (z. B. "3rd floor,
	 * Appt. 342"). Dies kann auch ein Bezeichner sein, der vom Standort weg
	 * zeigt, anstatt einen kleineren Standort in einem größeren anzugeben (z.
	 * B. "t.o." bedeutet in den Niederlanden "gegenüber" für Hausboote, die
	 * sich gegenüber den Häusern befinden).</div>
	 *
	 * @return the additional locator
	 */
	public String getAdditionalLocator() {
		return additionalLocator;
	}

	/**
	 * <div class="en">Gets the building number. The number of a building, house
	 * or lot alongside the street. Also known as "primary street number". This
	 * does not number the street but rather the building.</div>
	 *
	 * <div class="de">Ruft die Gebäudenummer ab. Die Nummer eines Gebäudes,
	 * Hauses oder Grundstücks neben der Straße. Auch als "primäre Hausnummer"
	 * bekannt. Das ist nicht die Straße, sondern das Gebäude.</div>
	 *
	 * @return the building number
	 */
	public String getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * <div class="en">Gets the city. The name of the city, town, village, or
	 * other community or delivery center.</div>
	 *
	 * <div class="de">Ruft den Ort ab. Der Name der Stadt, des Dorfes oder
	 * einer anderen Gemeinde oder eines anderen Lieferzentrums.</div>
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <div class="en">Gets the country.</div>
	 *
	 * <div class="de">Ruft das Land ab.</div>
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * <div class="en">Gets the null flavor.</div>
	 *
	 * <div class="de">Ruft den nullFlavor ab.</div>
	 *
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor() {
		return nullFlavor;
	}

	/**
	 * <div class="en">Gets the postal code. A postal code designating a region
	 * defined by the postal service.</div>
	 *
	 * <div class="de">Ruft die Postleitzahl ab. Eine Postleitzahl, die eine vom
	 * Postdienst definierte Region bezeichnet.</div>
	 *
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <div class="en"> Gets the post box. A numbered box located in a post
	 * station.</div>
	 *
	 * <div class="de">Ruft das Postfach ab. Eine nummerierte Box in einer
	 * Poststation.</div>
	 *
	 * @return the post box
	 */
	public String getPostBox() {
		return postBox;
	}

	/**
	 * <div class="en">Gets the state. A sub-unit of a country with limited
	 * sovereignty in a federally organized country (e.g. Switzerland:
	 * canton).</div>
	 *
	 * <div class="de">Ruft den Staat ab. Eine Untereinheit eines Landes mit
	 * begrenzter Souveränität in einem föderalistisch organisierten Land (z. B.
	 * Schweiz: Kanton).</div>
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * <div class="en">Gets the street address line 1. Can be used for an
	 * additional locator, a delivery address or a street address. </div>
	 *
	 * <div class="de">Ruft die Adresszeile 1 ab. Sie kann für eine
	 * Zusatzangabe, eine Lieferadresse oder eine Strassenadresse verwendet
	 * werden.</div>
	 *
	 * @return the street address line 1
	 */
	public String getStreetAddressLine1() {
		return streetAddressLine1;
	}

	/**
	 * <div class="en">Gets the street address line 2. Can be used for an
	 * additional locator, a delivery address or a street address. </div>
	 *
	 * <div class="de">Ruft die Adresszeile 2 ab. Sie kann für eine
	 * Zusatzangabe, eine Lieferadresse oder eine Strassenadresse verwendet
	 * werden.</div>
	 *
	 * @return the street address line 2
	 */
	public String getStreetAddressLine2() {
		return streetAddressLine2;
	}

	/**
	 * <div class="en">Gets the street name. The name of a roadway or artery
	 * recognized by a municipality.</div>
	 *
	 * <div class="de">Ruft den Straßennamen ab. Der Name einer von einer
	 * Gemeinde anerkannten Haupt- oder Nebenstrasse.</div>
	 *
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * <div class="en">Gets type of usage (such as private, business,
	 * ...).</div>
	 *
	 * <div class="de">Ruft die Art der Nutzung ab (wie privat, geschäftlich,
	 * ...).</div>
	 *
	 * @return the usage
	 */
	public PostalAddressUse getUsage() {
		return usage;
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
	 * <div class="en">Checks if the current instance is null flavored.</div>
	 *
	 * <div class="de">Überprüft, ob die aktuelle Instanz mit Null-Flavor
	 * versehen ist.</div>
	 *
	 * @return true, if is null flavor
	 */
	public boolean isNullFlavor() {
		return (nullFlavor != null);
	}

	/**
	 * <div class="en">Sets the additional locator. See getter
	 * {@link AddressBaseType#getAdditionalLocator} for more details.</div>
	 *
	 * <div class="de">Legt die Zusatzangabe fest. Siehe Getter
	 * {@link AddressBaseType#getAdditionalLocator} für weitere Details.</div>
	 *
	 * @param additionalLocator
	 *            the new additional locator
	 */
	public void setAdditionalLocator(String additionalLocator) {
		this.additionalLocator = additionalLocator;
	}

	/**
	 * <div class="en">Sets the building number. See getter
	 * {@link AddressBaseType#getBuildingNumber} for more details.</div>
	 *
	 * <div class="de">Legt die Gebäudenummer fest. Siehe Getter
	 * {@link AddressBaseType#getBuildingNumber} für weitere Details.</div>
	 *
	 * @param buildingNumber
	 *            the new building number
	 */
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	/**
	 * <div class="en">Sets the city. See getter {@link AddressBaseType#getCity}
	 * for more details.</div>
	 *
	 * <div class="de">Legt den Ort fest. Siehe Getter
	 * {@link AddressBaseType#getBuildingNumber} für weitere Details.</div>
	 *
	 * @param city
	 *            the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * <div class="en">Sets the country.See getter
	 * {@link AddressBaseType#getCountry} for more details.</div>
	 *
	 * <div class="de">Legt das Land fest. Siehe Getter
	 * {@link AddressBaseType#getBuildingNumber} für weitere Details.</div>
	 *
	 * @param country
	 *            the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * <div class="en">Sets the null flavor.</div>
	 *
	 * <div class="de">Legt den nullFlavor fest.</div>
	 *
	 * @param nullFlavor
	 *            the new null flavor
	 */
	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}

	/**
	 * <div class="en">Sets the postal code. See getter
	 * {@link AddressBaseType#getPostalCode} for more details.</div>
	 *
	 * <div class="de">Legt die Postleitzahl fest. Siehe Getter
	 * {@link AddressBaseType#getBuildingNumber} für weitere Details.</div>
	 *
	 * @param postalCode
	 *            the new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * <div class="en">Sets the post box. See getter
	 * {@link AddressBaseType#getPostBox} for more details.</div>
	 *
	 * <div class="de">Legt das Postfach fest. Siehe Getter
	 * {@link AddressBaseType#getPostBox} für weitere Details.</div>
	 *
	 * @param postBox
	 *            the new post box
	 */
	public void setPostBox(String postBox) {
		this.postBox = postBox;
	}

	/**
	 * <div class="en">Sets the state See getter
	 * {@link AddressBaseType#getState} for more details.</div>
	 *
	 * <div class="de">Legt den Staat/Kanton fest. Siehe Getter
	 * {@link AddressBaseType#getState} für weitere Details.</div>
	 *
	 * @param state
	 *            the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * <div class="en">Sets the street address line 1. See getter
	 * {@link AddressBaseType#getStreetAddressLine1} for more details.</div>
	 *
	 * <div class="de">Legt die Adresszeile 1 fest. Siehe Getter
	 * {@link AddressBaseType#getStreetAddressLine1} für weitere Details.</div>
	 *
	 * @param streetAddressLine1
	 *            the new street address line 1
	 */
	public void setStreetAddressLine1(String streetAddressLine1) {
		this.streetAddressLine1 = streetAddressLine1;
	}

	/**
	 * <div class="en">Sets the street address line 2. See getter
	 * {@link AddressBaseType#getStreetAddressLine2} for more details.</div>
	 *
	 * <div class="de">Legt die Adresszeile 2 fest. Siehe Getter
	 * {@link AddressBaseType#getStreetAddressLine2} für weitere Details.</div>
	 *
	 * @param streetAddressLine2
	 *            the new street address line 2
	 */
	public void setStreetAddressLine2(String streetAddressLine2) {
		this.streetAddressLine2 = streetAddressLine2;
	}

	/**
	 * <div class="en">Sets the street name.See getter
	 * {@link AddressBaseType#getStreetName} for more details.</div>
	 *
	 * <div class="de">Legt die Strasse fest. Siehe Getter
	 * {@link AddressBaseType#getStreetName} für weitere Details.</div>
	 *
	 * @param streetName
	 *            the new street name
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * <div class="en">Sets the type of usage. See getter
	 * {@link AddressBaseType#getUsage} for more details.</div>
	 *
	 * <div class="de">Legt die Art der Nutzung fest. Siehe Getter
	 * {@link AddressBaseType#getUsage} für weitere Details.</div>
	 *
	 * @param usage
	 *            the new usage
	 */
	public void setUsage(PostalAddressUse usage) {
		this.usage = usage;
	}

	/**
	 * <div class="en">Builds a string of the whole address.</div>
	 *
	 * <div class="de">Erstellt einen String der gesamten Adresse.</div>
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

}
