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
package org.ehealth_connector.common.basetypes;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.utils.Util;

// TODO: Auto-generated Javadoc
/**
 * <div class="en">Details for all kinds of technology-mediated contact points
 * for a person or organization, including telephone, email, etc.<div>
 *
 * <div class="de">Details für alle Arten von Kontaktmöglichkeiten zu einer
 * Person oder Organisation, einschliesslich Telefon, E-Mail usw.<div>
 *
 */
public class TelecomBaseType implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link TelecomBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		/** The null flavor. */
		private NullFlavor nullFlavor;
		/** The usage. */
		private TelecomAddressUse usage;
		/** The value. */
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
		 * @param nullFlavor
		 *            the null flavor
		 * @return the builder
		 */
		public Builder withNullFlavor(NullFlavor nullFlavor) {
			this.nullFlavor = nullFlavor;
			return this;
		}

		/**
		 * With usage.
		 *
		 * @param usage
		 *            the usage
		 * @return the builder
		 */
		public Builder withUsage(TelecomAddressUse usage) {
			this.usage = usage;
			return this;
		}

		/**
		 * With value.
		 *
		 * @param value
		 *            the value
		 * @return the builder
		 */
		public Builder withValue(String value) {
			this.value = value;
			return this;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6908791040642752931L;

	/**
	 * Creates builder to build {@link TelecomBaseType}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The null flavor. */
	private NullFlavor nullFlavor;

	/** The usage. */
	private TelecomAddressUse usage;

	/** The value. */
	private String value;

	/**
	 * <div class="en">Instantiates a new TelecomBaseType. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen neuen TelecomBaseType.
	 * Standardkonstruktor.</div>
	 */
	public TelecomBaseType() {
	}

	/**
	 * Instantiates a new telecom base type.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private TelecomBaseType(Builder builder) {
		this.usage = builder.usage;
		this.value = builder.value;
		this.nullFlavor = builder.nullFlavor;
	}

	/**
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the TelecomBaseType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean retVal = true;
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
	 * <div class="en">Gets the type of usage (business, private, emergency,
	 * vacation, ...).</div>
	 *
	 * <div class="de">Ruft die Art der Nutzung ab (geschäftlich, privat,
	 * Notfall, Urlaub, ...).</div>
	 *
	 * @return the usage
	 */
	public TelecomAddressUse getUsage() {
		return usage;
	}

	/**
	 * <div class="en">Gets the value. This is the real phone number, eMail
	 * Address, URL, ...</div>
	 *
	 * <div class="de">Ruft den Wert ab. Dies ist die echte Telefonnummer,
	 * E-Mail-Adresse, URL, ...</div>
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
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
	 * <div class="en">Sets the value as phone number.</div>
	 *
	 * <div class="de">Legt den Wert als Telefonnummer fest</div>
	 *
	 *
	 * @param value
	 *            the new phone
	 */
	public void setFax(String value) {
		setValue("fax:" + value);
	}

	/**
	 * <div class="en">Sets the value as eMail Address.</div>
	 *
	 * <div class="de">Legt den Wert als eMail Adresse fest</div>
	 *
	 *
	 * @param value
	 *            the new phone
	 */
	public void setMail(String value) {
		setValue("mailto:" + value);
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
	 * <div class="en">Sets the value as phone number.</div>
	 *
	 * <div class="de">Legt den Wert als Telefonnummer fest</div>
	 *
	 *
	 * @param value
	 *            the new phone
	 */
	public void setPhone(String value) {
		setValue("tel:" + value);
	}

	/**
	 * <div class="en">Sets the type of usage (business, private, emergency,
	 * vacation, ...).</div>
	 *
	 * <div class="de">Legt die Art der Nutzung fest (geschäftlich, privat,
	 * Notfall, Urlaub, ...).</div>
	 *
	 * @param usage
	 *            the new usage
	 */
	public void setUsage(TelecomAddressUse usage) {
		this.usage = usage;
	}

	/**
	 * <div class="en">Sets the value. This is the real phone number, eMail
	 * Address, URL, ...</div>
	 *
	 * <div class="de">Legt den Wert fest. Dies ist die echte Telefonnummer,
	 * E-Mail-Adresse, URL, ...</div>
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * <div class="en">Builds a string of the telecom.</div>
	 *
	 * <div class="de">Erstellt einen String des Telecom elements.</div>
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getValue();
	}

}
