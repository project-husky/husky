/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.valueset.model;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.valueset.enums.DesignationType;

/**
 * The Class Designation. See also
 * https://art-decor.org/mediawiki/index.php?title=DECOR-terminology
 */
public class Designation {

	/**
	 * Builder to build {@link Designation}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The language code. */
		private LanguageCode languageCode;

		/** The type. */
		private DesignationType type;

		/** The display name. */
		private String displayName;

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
		 * @param displayName
		 *            the display name
		 * @return the builder
		 */
		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		/**
		 * With language code.
		 *
		 * @param languageCode
		 *            the language code
		 * @return the builder
		 */
		public Builder withLanguageCode(LanguageCode languageCode) {
			this.languageCode = languageCode;
			return this;
		}

		/**
		 * With type.
		 *
		 * @param type
		 *            the type
		 * @return the builder
		 */
		public Builder withType(DesignationType type) {
			this.type = type;
			return this;
		}
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

	/** The language code. */
	private LanguageCode languageCode;

	/** The type. */
	private DesignationType type;

	/** The display name. */
	private String displayName;

	/**
	 * Instantiates a new designation. Default constructor.
	 */
	public Designation() {
	}

	/**
	 * Instantiates a new designation.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private Designation(Builder builder) {
		this.languageCode = builder.languageCode;
		this.type = builder.type;
		this.displayName = builder.displayName;
	}

	/**
	 * Checks whether the to objects are equal (based on their content).
	 *
	 * @param obj
	 *            the obj to compare
	 * @return true, if equal
	 */
	public boolean equals(Designation obj) {
		boolean retVal = true;
		if (retVal) {
			if (this.languageCode == null)
				retVal = (obj.getLanguageCode() == null);
			else
				retVal = (this.languageCode == obj.getLanguageCode());
		}
		if (retVal) {
			if (this.type == null)
				retVal = (obj.getType() == null);
			else
				retVal = (this.type == obj.getType());
		}
		if (retVal) {
			if (this.displayName == null)
				retVal = (obj.getDisplayName() == null);
			else
				retVal = this.displayName.equals(obj.getDisplayName());
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
	 * Gets the language code.
	 *
	 * @return the language code
	 */
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public DesignationType getType() {
		return type;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Sets the language code.
	 *
	 * @param languageCode
	 *            the new language code
	 */
	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(DesignationType type) {
		this.type = type;
	}

}
