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
package org.projecthusky.common.basetypes;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.projecthusky.common.enums.EntityNameUse;
import org.projecthusky.common.enums.NullFlavor;

/**
 * A name for a person, organization, place or thing. A sequence of name parts,
 * such as given name or family name, prefix, suffix, etc.
 */
public class NameBaseType implements Serializable {

	/*
	 *
	 * Important Note:
	 *
	 * This class has a builder, generated SparkTools, but it has been adopted, in
	 * order to fill default values for full name and usage. Thus, if you generate
	 * the builder again, you must re-implement the changes again (use diff to find
	 * them).
	 *
	 */

	/*
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -3673361087444594377L;
	/**
	 * The name delimiter.
	 */
	private String delimiter;
	/**
	 * The family name.
	 */
	private String family;
	/**
	 * The given name.
	 */
	private String given;
	/**
	 * The principal name.
	 */
	private String name;
	/**
	 * The nullFlavor.
	 */
	private NullFlavor nullFlavor;
	/**
	 * The name prefix.
	 */
	private String prefix;
	/**
	 * The name suffix.
	 */
	private String suffix;
	/**
	 * The name usage.
	 */
	private EntityNameUse usage = EntityNameUse.LEGAL;

	/**
	 * Instantiates a new name base type. Default constructor.
	 */
	public NameBaseType() {
	}

	/**
	 * Instantiates a new name base type.
	 *
	 * @param builder the builder
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
	 * Creates builder to build {@link NameBaseType}.
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
	 * @param obj the NameType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof NameBaseType))
			return false;

		retVal = compareDelimiter((NameBaseType) obj);

		if (retVal) {
			retVal = compareFamily((NameBaseType) obj);
		}
		if (retVal) {
			retVal = compareGiven((NameBaseType) obj);
		}
		if (retVal) {
			retVal = comparePrefix((NameBaseType) obj);
		}
		if (retVal) {
			retVal = compareSuffix((NameBaseType) obj);
		}
		if (retVal) {
			retVal = compareUsage((NameBaseType) obj);
		}
		return retVal;
	}

	private boolean compareDelimiter(NameBaseType obj) {
		if (this.delimiter == null)
			return obj.getDelimiter() == null;
		else
			return this.delimiter.equals(obj.getDelimiter());
	}

	private boolean compareFamily(NameBaseType obj) {
		if (this.family == null)
			return (obj.getFamily() == null);
		else
			return this.family.equals(obj.getFamily());
	}

	private boolean compareGiven(NameBaseType obj) {
		if (this.given == null)
			return obj.getGiven() == null;
		else
			return this.given.equals(obj.getGiven());
	}

	private boolean comparePrefix(NameBaseType obj) {
		if (this.prefix == null)
			return obj.getPrefix() == null;
		else
			return this.prefix.equals(obj.getPrefix());
	}

	private boolean compareSuffix(NameBaseType obj) {
		if (this.suffix == null)
			return (obj.getSuffix() == null);
		else
			return this.suffix.equals(obj.getSuffix());
	}

	private boolean compareUsage(NameBaseType obj) {
		if (this.usage == null)
			return obj.getUsage() == null;
		else
			return this.usage.equals(obj.getUsage());
	}

	/**
	 * Gets the name delimiter. A delimiter has no meaning other than being
	 * literally printed in this name representation. A delimiter has no implicit
	 * leading and trailing white space.
	 *
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * Sets the name delimiter. A delimiter has no meaning other than being
	 * literally printed in this name representation. A delimiter has no implicit
	 * leading and trailing white space.
	 *
	 * @param delimiter the new delimiter
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
		this.name = getFullName();
	}

	/**
	 * Gets the family name. This is the name that links to the genealogy. In some
	 * cultures (e.g. Eritrea) the family name of a son is the first name of his
	 * father.
	 *
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * Sets the family name. This is the name that links to the genealogy. In some
	 * cultures (e.g. Eritrea) the family name of a son is the first name of his
	 * father.
	 *
	 * @param family the new family
	 */
	public void setFamily(String family) {
		this.family = family;
		this.name = getFullName();
	}

	/**
	 * Gets the full name.
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
	 * Gets the given name (be careful when calling it "first name" since this given
	 * names do not always come first).
	 *
	 * @return the given
	 */
	public String getGiven() {
		return given;
	}

	/**
	 * Sets the given name (be careful when calling it "first name" since this given
	 * names do not always come first).
	 *
	 * @param given the new given
	 */
	public void setGiven(String given) {
		this.given = given;
		this.name = getFullName();
	}

	/**
	 * Gets the whole name. By default, it gets assembled by the different name
	 * parts, but if there are none, you may also set this directly.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the whole name. By default, it gets assembled by the different name
	 * parts, but if there are none, you may also set this directly.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the nullFlavor.
	 *
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor() {
		return nullFlavor;
	}

	/**
	 * Gets the name prefix. A prefix has a strong association to the immediately
	 * following name part.
	 *
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Sets the name prefix. A prefix has a strong association to the immediately
	 * following name part.
	 *
	 * @param prefix the new prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
		this.name = getFullName();
	}

	/**
	 * Gets the name suffix. A suffix has a strong association to the immediately
	 * preceding name part.
	 *
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Sets the name suffix. A suffix has a strong association to the immediately
	 * preceding name part.
	 *
	 * @param suffix the new suffix
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
		this.name = getFullName();
	}

	/**
	 * Gets the name usage. Gets the type of usage (legal, artist, pseudonym, ...).
	 *
	 * @return the usage
	 */
	public EntityNameUse getUsage() {
		return usage;
	}

	/**
	 * Sets the name usage. Gets the type of usage (legal, artist, pseudonym, ...).
	 *
	 * @param usage the new usage
	 */
	public void setUsage(EntityNameUse usage) {
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
		return new HashCodeBuilder(17, 37).append(this.delimiter).append(this.family).append(this.given)
				.append(this.prefix).append(this.suffix).toHashCode();
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
	 * Sets the nullFlavor.
	 *
	 * @param nullFlavor the new null flavor
	 */
	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}

	/**
	 * Builds a string of the name.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Builder to build {@link NameBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/**
		 * The delimiter.
		 */
		private String delimiter;

		/**
		 * The family.
		 */
		private String family;

		/**
		 * The given.
		 */
		private String given;

		/**
		 * The name.
		 */
		private String name;

		/**
		 * The null flavor.
		 */
		private NullFlavor nullFlavor;

		/**
		 * The prefix.
		 */
		private String prefix;

		/**
		 * The suffix.
		 */
		private String suffix;

		/**
		 * The usage.
		 */
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
		 * @param delimiter the delimiter
		 * @return the builder
		 */
		public Builder withDelimiter(String delimiter) {
			this.delimiter = delimiter;
			return this;
		}

		/**
		 * With family.
		 *
		 * @param family the family
		 * @return the builder
		 */
		public Builder withFamily(String family) {
			this.family = family;
			return this;
		}

		/**
		 * With given.
		 *
		 * @param given the given
		 * @return the builder
		 */
		public Builder withGiven(String given) {
			this.given = given;
			return this;
		}

		/**
		 * With name.
		 *
		 * @param name the name
		 * @return the builder
		 */
		public Builder withName(String name) {
			this.name = name;
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
		 * With prefix.
		 *
		 * @param prefix the prefix
		 * @return the builder
		 */
		public Builder withPrefix(String prefix) {
			this.prefix = prefix;
			return this;
		}

		/**
		 * With suffix.
		 *
		 * @param suffix the suffix
		 * @return the builder
		 */
		public Builder withSuffix(String suffix) {
			this.suffix = suffix;
			return this;
		}

		/**
		 * With usage.
		 *
		 * @param usage the usage
		 * @return the builder
		 */
		public Builder withUsage(EntityNameUse usage) {
			this.usage = usage;
			return this;
		}
	}

}
