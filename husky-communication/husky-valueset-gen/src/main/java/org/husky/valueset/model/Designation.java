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
package org.husky.valueset.model;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.husky.common.enums.LanguageCode;
import org.husky.common.utils.Util;
import org.husky.valueset.enums.DesignationType;

/**
 * <div class="en">Designations are language dependent display names for the
 * code. For any language there might be multiple, each specifying the type
 * (fully specified name, preferred, synonym, ...).<div>
 *
 * <div class="de">Bezeichnungen sind sprachabhängige Anzeigenamen für den Code.
 * Für jede Sprache kann es mehrere geben, die jeweils den Typ angeben
 * (vollständiger Name, bevorzugter Name, Synonym, ...).<div>
 */
public class Designation implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link Designation}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The display name. */
		private String displayName;

		/** The language code. */
		private LanguageCode languageCode;

		/** The type. */
		private DesignationType type;

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
		 * @param displayName the display name
		 * @return the builder
		 */
		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		/**
		 * With language code.
		 *
		 * @param languageCode the language code
		 * @return the builder
		 */
		public Builder withLanguageCode(LanguageCode languageCode) {
			this.languageCode = languageCode;
			return this;
		}

		/**
		 * With type.
		 *
		 * @param type the type
		 * @return the builder
		 */
		public Builder withType(DesignationType type) {
			this.type = type;
			return this;
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -2551878616152131257L;

	/**
	 * Creates builder to build {@link Designation}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The display name. */
	private String displayName;

	/** The language code. */
	private LanguageCode languageCode;

	/** The type. */
	private DesignationType type;

	/**
	 * <div class="en">Instantiates a new Designation. Default constructor.</div>
	 *
	 * <div class="de">Instanziiert eine neue Designation.
	 * Standardkonstruktor.</div>
	 */
	public Designation() {
	}

	/**
	 * Instantiates a new designation.
	 *
	 * @param builder the builder
	 */
	@Generated("SparkTools")
	private Designation(Builder builder) {
		this.languageCode = builder.languageCode;
		this.type = builder.type;
		this.displayName = builder.displayName;
	}

	/**
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf ihrem
	 * Inhalt).</div>
	 *
	 * @param obj the Designation to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof Designation))
			return false;

		if (this.languageCode == null)
			retVal = (((Designation) obj).getLanguageCode() == null);
		else
			retVal = (this.languageCode == ((Designation) obj).getLanguageCode());

		if (retVal) {
			if (this.type == null)
				retVal = (((Designation) obj).getType() == null);
			else
				retVal = (this.type == ((Designation) obj).getType());
		}
		if (retVal) {
			if (this.displayName == null)
				retVal = (((Designation) obj).getDisplayName() == null);
			else
				retVal = this.displayName.equals(((Designation) obj).getDisplayName());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the display name.</div>
	 *
	 * <div class="de">Ruft den Anzeigenamen ab.</div>
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <div class="en">Gets the language code.</div>
	 *
	 * <div class="de">Ruft den Sprachcode ab.</div>
	 *
	 * @return the language code
	 */
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	/**
	 * <div class="en">Gets the designations type (fully specified name, preferred,
	 * synonym, ...).</div>
	 *
	 * <div class="de">Ruft den Bezeichnungstyp ab (vollständig angegebener Name,
	 * bevorzugt, synonym, ...).</div>
	 *
	 * @return the type
	 */
	public DesignationType getType() {
		return type;
	}

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
	 * <div class="en">Sets the display name.</div>
	 *
	 * <div class="de">Legt den Anzeigenamen fest.</div>
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Sets the language code.</div>
	 *
	 * <div class="de">Legt den Sprachcode fest.</div>
	 *
	 * @param languageCode the new language code
	 */
	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * <div class="en">Sets the designations type (fully specified name, preferred,
	 * synonym, ...).</div>
	 *
	 * <div class="de">Legt den Bezeichnungstyp fest (vollständiger Name, bevorzugt,
	 * synonym, ...).</div>
	 *
	 * @param type the new type
	 */
	public void setType(DesignationType type) {
		this.type = type;
	}
}
