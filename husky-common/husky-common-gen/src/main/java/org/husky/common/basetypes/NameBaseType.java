/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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

import org.husky.common.enums.EntityNameUse;
import org.husky.common.enums.NullFlavor;
import org.husky.common.utils.Util;

/**
 * <div class="en">A name for a person, organization, place or thing. A sequence
 * of name parts, such as given name or family name, prefix, suffix, etc.<div>
 *
 * <div class="de">Ein Name für eine Person, Organisation, einen Ort oder eine
 * Sache. Eine Folge von Namensteilen, wie Vorname oder Familienname, Präfix,
 * Suffix usw.<div>
 *
 */
public class NameBaseType implements Serializable {

	/**
	 *
	 * Important Note:
	 *
	 * This class has a builder, generated SparkTools, but it has been adopted,
	 * in order to fill default values for full name and usage. Thus, if you
	 * generate the builder again, you must re-implement the changes again (use
	 * diff to find them).
	 *
	 */

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link NameBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The delimiter. */
		private String delimiter;

		/** The family. */
		private String family;

		/** The given. */
		private String given;

		/** The name. */
		private String name;

		/** The null flavor. */
		private NullFlavor nullFlavor;

		/** The prefix. */
		private String prefix;

		/** The suffix. */
		private String suffix;

		/** The usage. */
		private EntityNameUse usage;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the name base type
		 */
		public NameBaseType build() {
			return new NameBaseType(this);
		}

		/**
		 * With delimiter.
		 *
		 * @param delimiter
		 *            the delimiter
		 * @return the builder
		 */
		public Builder withDelimiter(String delimiter) {
			this.delimiter = delimiter;
			return this;
		}

		/**
		 * With family.
		 *
		 * @param family
		 *            the family
		 * @return the builder
		 */
		public Builder withFamily(String family) {
			this.family = family;
			return this;
		}

		/**
		 * With given.
		 *
		 * @param given
		 *            the given
		 * @return the builder
		 */
		public Builder withGiven(String given) {
			this.given = given;
			return this;
		}

		/**
		 * With name.
		 *
		 * @param name
		 *            the name
		 * @return the builder
		 */
		public Builder withName(String name) {
			this.name = name;
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
		 * With prefix.
		 *
		 * @param prefix
		 *            the prefix
		 * @return the builder
		 */
		public Builder withPrefix(String prefix) {
			this.prefix = prefix;
			return this;
		}

		/**
		 * With suffix.
		 *
		 * @param suffix
		 *            the suffix
		 * @return the builder
		 */
		public Builder withSuffix(String suffix) {
			this.suffix = suffix;
			return this;
		}

		/**
		 * With usage.
		 *
		 * @param usage
		 *            the usage
		 * @return the builder
		 */
		public Builder withUsage(EntityNameUse usage) {
			this.usage = usage;
			return this;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3673361087444594377L;

	/**
	 * Creates builder to build {@link NameBaseType}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The name delimiter. */
	private String delimiter;

	/** The family name. */
	private String family;

	/** The given name. */
	private String given;

	/** The principal name. */
	private String name;

	/** The nullFlavor. */
	private NullFlavor nullFlavor;

	/** The name prefix. */
	private String prefix;

	/** The name suffix. */
	private String suffix;

	/** The name usage. */
	private EntityNameUse usage = EntityNameUse.LEGAL;

	/**
	 * <div class="en">Instantiates a new name base type. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen neuen Namensbasistyp.
	 * Standardkonstruktor.</div>
	 *
	 */
	public NameBaseType() {
	}

	/**
	 * Instantiates a new name base type.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private NameBaseType(Builder builder) {
		this.delimiter = builder.delimiter;
		this.family = builder.family;
		this.given = builder.given;
		this.name = builder.name;
		this.nullFlavor = builder.nullFlavor;
		this.prefix = builder.prefix;
		this.suffix = builder.suffix;
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
	 *            the NameType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof NameBaseType))
			return false;

		if (retVal) {
			if (this.delimiter == null)
				retVal = (((NameBaseType) obj).getDelimiter() == null);
			else
				retVal = this.delimiter.equals(((NameBaseType) obj).getDelimiter());
		}
		if (retVal) {
			if (this.family == null)
				retVal = (((NameBaseType) obj).getFamily() == null);
			else
				retVal = this.family.equals(((NameBaseType) obj).getFamily());
		}
		if (retVal) {
			if (this.given == null)
				retVal = (((NameBaseType) obj).getGiven() == null);
			else
				retVal = this.given.equals(((NameBaseType) obj).getGiven());
		}
		if (retVal) {
			if (this.prefix == null)
				retVal = (((NameBaseType) obj).getPrefix() == null);
			else
				retVal = this.prefix.equals(((NameBaseType) obj).getPrefix());
		}
		if (retVal) {
			if (this.suffix == null)
				retVal = (((NameBaseType) obj).getSuffix() == null);
			else
				retVal = this.suffix.equals(((NameBaseType) obj).getSuffix());
		}
		if (retVal) {
			if (this.usage == null)
				retVal = (((NameBaseType) obj).getUsage() == null);
			else
				retVal = this.usage.equals(((NameBaseType) obj).getUsage());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the name delimiter. A delimiter has no meaning other
	 * than being literally printed in this name representation. A delimiter has
	 * no implicit leading and trailing white space.<div>
	 *
	 * <div class="de">Ruft das Namens-Trennzeichen ab. Ein Trennzeichen hat
	 * keine andere Bedeutung, als in dieser Namensdarstellung wörtlich gedruckt
	 * zu werden. Ein Trennzeichen hat kein führendes und nachfolgendes
	 * Leerzeichen.<div>
	 *
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * <div class="en">Gets the family name. This is the name that links to the
	 * genealogy. In some cultures (e.g. Eritrea) the family name of a son is
	 * the first name of his father.<div>
	 *
	 * <div class="de">Ruft den Familiennamen ab. Dies ist der Name, der auf die
	 * Genealogie verweist. In einigen Kulturen (z. B. Eritrea) ist der
	 * Familienname eines Sohnes der Vorname seines Vaters.<div>
	 *
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * <div class="en">Gets the full name.<div>
	 *
	 * <div class="de">Ruft den vollen Namen ab.<div>
	 *
	 * @return the full name
	 */
	public String getFullName() {
		var sb = new StringBuilder();
		var myDelimiter = " ";
		if (delimiter != null)
			myDelimiter = delimiter;

		if (prefix != null) {
			sb.append(prefix);
			sb.append(myDelimiter);
		}

		if (given != null) {
			sb.append(given);
			sb.append(myDelimiter);
		}

		if (family != null) {
			sb.append(family);
		}

		if (suffix != null) {
			sb.append(myDelimiter);
			sb.append(suffix);
		}

		if (sb.length() != 0)
			return sb.toString();
		else
			return name;
	}

	/**
	 * <div class="en">Gets the given name (be careful when calling it "first
	 * name" since this given names do not always come first).<div>
	 *
	 * <div class="de">Ruft den Vornamen ab (English: given name. Sei
	 * vorsichtig, ihn "first name" zu nennen, da diese Vornamen nicht immer an
	 * erster Stelle stehen).<div>
	 *
	 *
	 * @return the given
	 */
	public String getGiven() {
		return given;
	}

	/**
	 * <div class="en">Gets the whole name. By default, it gets assembled by the
	 * different name parts, but if there are none, you may also set this
	 * directly.<div>
	 *
	 * <div class="de">Ruft den vollständigen Namen ab. Standardmässig wird er
	 * aus den verschiedenen Namensteilen zusammengesetzt. Wenn jedoch keine
	 * vorhanden sind, kann er auch direkt festlegen.<div>
	 *
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <div class="en">Gets the nullFlavor.<div>
	 *
	 * <div class="de">Ruft den nullFlavor ab.<div>
	 *
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor() {
		return nullFlavor;
	}

	/**
	 * <div class="en">Gets the name prefix. A prefix has a strong association
	 * to the immediately following name part.<div>
	 *
	 * <div class="de">Ruft den Namens-Präfix ab. Ein Präfix ist stark mit dem
	 * unmittelbar folgenden Namensteil verknüpft.<div>
	 *
	 *
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <div class="en">Gets the name suffix. A suffix has a strong association
	 * to the immediately preceding name part.<div>
	 *
	 * <div class="de">Ruft den Namens-Suffix ab. Ein Suffix ist stark mit dem
	 * unmittelbar vorhergehenden Namensteil verknüpft.<div>
	 *
	 *
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * <div class="en">Gets the name usage. Gets the type of usage (legal,
	 * artist, pseudonym, ...).<div>
	 *
	 * <div class="de">Ruft die Verwendung des Namens ab (legaler Name,
	 * Künstler, Pseudonym, ...).<div>
	 *
	 *
	 * @return the usage
	 */
	public EntityNameUse getUsage() {
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
	 * <div class="en">Sets the name delimiter. A delimiter has no meaning other
	 * than being literally printed in this name representation. A delimiter has
	 * no implicit leading and trailing white space.<div>
	 *
	 * <div class="de">Legt das Namens-Trennzeichen fest. Ein Trennzeichen hat
	 * keine andere Bedeutung, als in dieser Namensdarstellung wörtlich gedruckt
	 * zu werden. Ein Trennzeichen hat kein führendes und nachfolgendes
	 * Leerzeichen.<div>
	 *
	 * @param delimiter
	 *            the new delimiter
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
		this.name = getFullName();
	}

	/**
	 * <div class="en">Sets the family name. This is the name that links to the
	 * genealogy. In some cultures (e.g. Eritrea) the family name of a son is
	 * the first name of his father.<div>
	 *
	 * <div class="de">Legt den Familiennamen fest. Dies ist der Name, der auf
	 * die Genealogie verweist. In einigen Kulturen (z. B. Eritrea) ist der
	 * Familienname eines Sohnes der Vorname seines Vaters.<div>
	 *
	 * @param family
	 *            the new family
	 */
	public void setFamily(String family) {
		this.family = family;
		this.name = getFullName();
	}

	/**
	 * <div class="en">Sets the given name (be careful when calling it "first
	 * name" since this given names do not always come first).<div>
	 *
	 * <div class="de">Legt den Vornamen fest (English: given name. Sei
	 * vorsichtig, ihn "first name" zu nennen, da diese Vornamen nicht immer an
	 * erster Stelle stehen).<div>
	 *
	 * @param given
	 *            the new given
	 */
	public void setGiven(String given) {
		this.given = given;
		this.name = getFullName();
	}

	/**
	 * <div class="en">Gets the whole name. By default, it gets assembled by the
	 * different name parts, but if there are none, you may also set this
	 * directly.<div>
	 *
	 * <div class="de">Ruft den vollständigen Namen ab. Standardmässig wird er
	 * aus den verschiedenen Namensteilen zusammengesetzt. Wenn jedoch keine
	 * vorhanden sind, kann er auch direkt festlegen.<div>
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <div class="en">Sets the nullFlavor.<div>
	 *
	 * <div class="de">Legt den nullFlavor fest.<div>
	 *
	 * @param nullFlavor
	 *            the new null flavor
	 */
	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}

	/**
	 * <div class="en">Sets the name prefix. A prefix has a strong association
	 * to the immediately following name part.<div>
	 *
	 * <div class="de">Legt den Namens-Präfix fest. Ein Präfix ist stark mit dem
	 * unmittelbar folgenden Namensteil verknüpft.<div>
	 *
	 * @param prefix
	 *            the new prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
		this.name = getFullName();
	}

	/**
	 * <div class="en">Sets the name suffix. A suffix has a strong association
	 * to the immediately preceding name part.<div>
	 *
	 * <div class="de">Legt den Namen-Suffix fest. Ein Suffix ist stark mit dem
	 * unmittelbar vorhergehenden Namensteil verknüpft.<div>
	 *
	 * @param suffix
	 *            the new suffix
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
		this.name = getFullName();
	}

	/**
	 * <div class="en">Sets the name usage. Gets the type of usage (legal,
	 * artist, pseudonym, ...).<div>
	 *
	 * <div class="de">Legt die Verwendung des Namens fest (legaler Name,
	 * Künstler, Pseudonym, ...).<div>
	 *
	 * @param usage
	 *            the new usage
	 */
	public void setUsage(EntityNameUse usage) {
		this.usage = usage;
	}

	/**
	 * <div class="en">Builds a string of the name.</div>
	 *
	 * <div class="de">Erstellt einen String des Namens.</div>
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return name;
	}

}
