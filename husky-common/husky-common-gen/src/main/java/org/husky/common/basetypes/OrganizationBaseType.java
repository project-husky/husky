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
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.enums.NullFlavor;
import org.husky.common.utils.Util;

/**
 * <div class="en">A formally or informally recognized grouping of people or
 * organizations formed for the purpose of achieving some form of collective
 * action. Includes companies, institutions, corporations, departments,
 * community groups, healthcare practice groups, payer/insurer, etc.<div>
 *
 *
 * <div class="de">Eine formell oder informell anerkannte Gruppe von Personen
 * oder Organisationen, die zum Zweck der Erreichung einer Form von kollektivem
 * Handeln gegründet wurde. Umfasst Unternehmen, Institutionen, Kooperationen,
 * Abteilungen, Gemeinschaften, Gruppenpraxen, Garanten, Versicherer usw.<div>
 *
 */
public class OrganizationBaseType implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link OrganizationBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The address list. */
		private List<AddressBaseType> addressList;

		/** The identificator list. */
		private List<IdentificatorBaseType> identificatorList;

		/** The name list. */
		private List<NameBaseType> nameList;

		/** The null flavor. */
		private NullFlavor nullFlavor;

		/** The primary address. */
		private AddressBaseType primaryAddress;

		/** The primary identificator. */
		private IdentificatorBaseType primaryIdentificator;

		/** The primary name. */
		private NameBaseType primaryName;

		/** The primary telecom. */
		private TelecomBaseType primaryTelecom;

		/** The telecom list. */
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
		 * @param addressList
		 *            the address list
		 * @return the builder
		 */
		public Builder withAddressList(ArrayList<AddressBaseType> addressList) {
			this.addressList = addressList;
			return this;
		}

		/**
		 * With identificator list.
		 *
		 * @param identificatorList
		 *            the identificator list
		 * @return the builder
		 */
		public Builder withIdentificatorList(ArrayList<IdentificatorBaseType> identificatorList) {
			this.identificatorList = identificatorList;
			return this;
		}

		/**
		 * With name list.
		 *
		 * @param nameList
		 *            the name list
		 * @return the builder
		 */
		public Builder withNameList(ArrayList<NameBaseType> nameList) {
			this.nameList = nameList;
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
		 * With primary address.
		 *
		 * @param primaryAddress
		 *            the primary address
		 * @return the builder
		 */
		public Builder withPrimaryAddress(AddressBaseType primaryAddress) {
			this.primaryAddress = primaryAddress;
			return this;
		}

		/**
		 * With primary identificator.
		 *
		 * @param primaryIdentificator
		 *            the primary identificator
		 * @return the builder
		 */
		public Builder withPrimaryIdentificator(IdentificatorBaseType primaryIdentificator) {
			this.primaryIdentificator = primaryIdentificator;
			return this;
		}

		/**
		 * With primary name.
		 *
		 * @param primaryName
		 *            the primary name
		 * @return the builder
		 */
		public Builder withPrimaryName(NameBaseType primaryName) {
			this.primaryName = primaryName;
			return this;
		}

		/**
		 * With primary telecom.
		 *
		 * @param primaryTelecom
		 *            the primary telecom
		 * @return the builder
		 */
		public Builder withPrimaryTelecom(TelecomBaseType primaryTelecom) {
			this.primaryTelecom = primaryTelecom;
			return this;
		}

		/**
		 * With telecom list.
		 *
		 * @param telecomList
		 *            the telecom list
		 * @return the builder
		 */
		public Builder withTelecomList(ArrayList<TelecomBaseType> telecomList) {
			this.telecomList = telecomList;
			return this;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2506412743872695565L;

	/**
	 * Creates builder to build {@link OrganizationBaseType}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The address list. */
	private List<AddressBaseType> addressList;

	/** The identificator list. */
	private List<IdentificatorBaseType> identificatorList;

	/** The name list. */
	private List<NameBaseType> nameList;

	/** The null flavor. */
	private NullFlavor nullFlavor;

	/** The primary address. */
	private AddressBaseType primaryAddress;

	/** The primary identificator. */
	private IdentificatorBaseType primaryIdentificator;

	/** The primary name. */
	private NameBaseType primaryName;

	/** The primary telecom. */
	private TelecomBaseType primaryTelecom;

	/** The telecom list. */
	private List<TelecomBaseType> telecomList;

	/**
	 * <div class="en">Instantiates a new OrganizationBaseType. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen neuen OrganizationBaseType.
	 * Standardkonstruktor.</div>
	 */
	public OrganizationBaseType() {
	}

	/**
	 * Instantiates a new organization base type.
	 *
	 * @param builder
	 *            the builder
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
	 * <div class="en">Adds an address. The first one becomes the primary
	 * address by default.</div>
	 *
	 * <div class="de">Fügt eine Adresse hinzu. Die erste Adresse wird
	 * standardmäßig zur primären Adresse.</div>
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Adds an identificator. The first one becomes the primary
	 * identificator by default.</div>
	 *
	 * <div class="de">Fügt einen Identifikator hinzu. Der erste wird
	 * standardmässig zum primären Identifikator.</div>
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Adds a name. The first one becomes the primary name by
	 * default.</div>
	 *
	 * <div class="de">Fügt einen Namen hinzu. Der erste wird standardmässig zum
	 * primären Namen.</div>
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Adds a telecom Element. The first one becomes the primary
	 * telecom by default.</div>
	 *
	 * <div class="de">Fügt ein Telekommunikationselement hinzu. Die erste wird
	 * standardmäßig zur primären Telekommunikation.</div>
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Clears the address list.</div>
	 *
	 * <div class="de">Löscht die Adressliste.</div>
	 */
	public void clearAddressList() {
		this.addressList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the identificator list.</div>
	 *
	 * <div class="de">Löscht die Identifikatorliste.</div>
	 */
	public void clearIdentificatorList() {
		this.identificatorList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the name list.</div>
	 *
	 * <div class="de">Löscht die Namensliste.</div>
	 */
	public void clearNameList() {
		this.nameList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the telecom list.</div>
	 *
	 * <div class="de">Löscht die Telekommunikationsliste.</div>
	 */
	public void clearTelecomList() {
		this.telecomList = new ArrayList<>();
	}

	/**
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert
	 * enthält.</div> Contains.
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert
	 * enthält.</div> Contains.
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert
	 * enthält.</div> Contains.
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert
	 * enthält.</div> Contains.
	 *
	 * @param value
	 *            the value
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
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the OrganizationBaseType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;
		if (!(obj instanceof OrganizationBaseType))
			return false;
		if (retVal) {
			if (this.addressList == null)
				this.addressList = new ArrayList<>();
			for (var i = 0; i < this.addressList.size(); i++) {
				retVal = ((OrganizationBaseType) obj).contains(this.addressList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.identificatorList == null)
				this.identificatorList = new ArrayList<>();
			for (var i = 0; i < this.identificatorList.size(); i++) {
				retVal = ((OrganizationBaseType) obj).contains(this.identificatorList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.nameList == null)
				this.nameList = new ArrayList<>();
			for (var i = 0; i < this.nameList.size(); i++) {
				retVal = ((OrganizationBaseType) obj).contains(this.nameList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.telecomList == null)
				this.telecomList = new ArrayList<>();
			for (var i = 0; i < this.telecomList.size(); i++) {
				retVal = ((OrganizationBaseType) obj).contains(this.telecomList.get(i));
				if (!retVal)
					break;
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the address list.</div>
	 *
	 * <div class="de">Ruft die Adressliste ab.</div>
	 *
	 * @return the address list
	 */
	public List<AddressBaseType> getAddressList() {
		if (this.addressList == null)
			this.addressList = new ArrayList<>();
		return addressList;
	}

	/**
	 * <div class="en">Gets the identificator list.</div>
	 *
	 * <div class="de">Ruft die Identifikatorliste ab.</div>
	 *
	 * @return the identificator list
	 */
	public List<IdentificatorBaseType> getIdentificatorList() {
		if (this.identificatorList == null)
			this.identificatorList = new ArrayList<>();
		return identificatorList;
	}

	/**
	 * <div class="en">Gets the name list.</div>
	 *
	 * <div class="de">Ruft die Namensliste ab.</div>
	 *
	 * @return the name list
	 */
	public List<NameBaseType> getNameList() {
		if (this.nameList == null)
			this.nameList = new ArrayList<>();
		return nameList;
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
	 * <div class="en">Gets the primary address.</div>
	 *
	 * <div class="de">Ruft die primäre Adresse ab.</div>
	 *
	 * @return the primary address
	 */
	public AddressBaseType getPrimaryAddress() {
		return primaryAddress;
	}

	/**
	 * <div class="en">Gets the primary identificator.</div>
	 *
	 * <div class="de">Ruft den primären Bezeichner ab.</div>
	 *
	 * @return the primary identificator
	 */
	public IdentificatorBaseType getPrimaryIdentificator() {
		return primaryIdentificator;
	}

	/**
	 * <div class="en">Gets the primary name.</div>
	 *
	 * <div class="de">Ruft den primären Namen ab.</div>
	 *
	 * @return the primary name
	 */
	public NameBaseType getPrimaryName() {
		return primaryName;
	}

	/**
	 * <div class="en">Gets the primary telecom.</div>
	 *
	 * <div class="de">Ruft die primäre Telekommunikation ab.</div>
	 *
	 * @return the primary telecom
	 */
	public TelecomBaseType getPrimaryTelecom() {
		return primaryTelecom;
	}

	/**
	 * <div class="en">Gets the telecom list.</div>
	 *
	 * <div class="de">Ruft die Telekommunikationsliste ab.</div>
	 *
	 * @return the telecom list
	 */
	public List<TelecomBaseType> getTelecomList() {
		if (this.telecomList == null)
			this.telecomList = new ArrayList<>();
		return telecomList;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
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
	 * <div class="en">Sets the address list.</div>
	 *
	 * <div class="de">Legt die Adressliste fest.</div>
	 *
	 * @param addressList
	 *            the new address list
	 */
	public void setAddressList(List<AddressBaseType> addressList) {
		this.addressList = addressList;
	}

	/**
	 * <div class="en">Sets the identificator list.</div>
	 *
	 * <div class="de">Legt die Identifikatorliste fest.</div>
	 *
	 * @param identificatorList
	 *            the new identificator list
	 */
	public void setIdentificatorList(List<IdentificatorBaseType> identificatorList) {
		this.identificatorList = identificatorList;
	}

	/**
	 * <div class="en">Sets the name list.</div>
	 *
	 * <div class="de">Legt die Namensliste fest.</div>
	 *
	 * @param nameList
	 *            the new name list
	 */
	public void setNameList(List<NameBaseType> nameList) {
		this.nameList = nameList;
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
	 * <div class="en">Sets the primary address. See getter
	 * {@link OrganizationBaseType#getPrimaryAddress} for more details.</div>
	 *
	 * <div class="de">Legt die prim,äre Adresse fest. Siehe Getter
	 * {@link OrganizationBaseType#getPrimaryAddress} für weitere Details.</div>
	 *
	 * @param primaryAddress
	 *            the new primary address
	 */
	public void setPrimaryAddress(AddressBaseType primaryAddress) {
		this.primaryAddress = primaryAddress;
		if (primaryAddress != null)
			addAddress(primaryAddress);
	}

	/**
	 * <div class="en">Sets the primary identificator. See getter
	 * {@link OrganizationBaseType#getPrimaryIdentificator} for more
	 * details.</div>
	 *
	 * <div class="de">Legt den primären Identifikator fest. Siehe Getter
	 * {@link OrganizationBaseType#getPrimaryIdentificator} für weitere
	 * Details.</div>
	 *
	 * @param primaryIdentificator
	 *            the new primary identificator
	 */
	public void setPrimaryIdentificator(IdentificatorBaseType primaryIdentificator) {
		this.primaryIdentificator = primaryIdentificator;
		if (primaryIdentificator != null)
			addIdentificator(primaryIdentificator);
	}

	/**
	 * <div class="en">Sets the primary name. It will not automatically be added
	 * to the list of names. See getter
	 * {@link OrganizationBaseType#getPrimaryName} for more details.</div>
	 *
	 * <div class="de">Legt den primären Namen fest. Siehe Getter
	 * {@link OrganizationBaseType#getPrimaryName} für weitere Details.</div>
	 *
	 * @param primaryName
	 *            the new primary name
	 */
	public void setPrimaryName(NameBaseType primaryName) {
		this.primaryName = primaryName;
		if (primaryName != null)
			addName(primaryName);
	}

	/**
	 * <div class="en">Sets the primary telecom. It will not automatically be
	 * added to the list of telecoms. See getter
	 * {@link OrganizationBaseType#getPrimaryTelecom} for more details.</div>
	 *
	 * <div class="de">Legt das primäre Telekommunikationselement fest. Siehe
	 * Getter {@link OrganizationBaseType#getPrimaryTelecom} für weitere
	 * Details.</div>
	 *
	 * @param primaryTelecom
	 *            the new primary telecom
	 */
	public void setPrimaryTelecom(TelecomBaseType primaryTelecom) {
		this.primaryTelecom = primaryTelecom;
		if (primaryTelecom != null)
			addTelecom(primaryTelecom);
	}

	/**
	 * <div class="en">Sets the telecom list.</div>
	 *
	 * <div class="de">Legt die Telekommunikationsliste fest.</div>
	 *
	 * @param telecomList
	 *            the new telecom list
	 */
	public void setTelecomList(List<TelecomBaseType> telecomList) {
		this.telecomList = telecomList;
	}

	/**
	 * <div class="en">Builds a string of the organization (primaryName and
	 * primaryAddress, only).</div>
	 *
	 * <div class="de">Erstellt einen String der Organisation (nur primärer
	 * Namen und primäre Adresse).</div>
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

}
