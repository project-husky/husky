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
import org.ehealth_connector.common.utils.Util;

/**
 * <div class="en"> An identifier that uniquely identifies a thing or object.
 * Examples are object identifier for HL7 RIM objects, medical record number,
 * order id, service catalog item id, Vehicle Identification Number (VIN), etc.
 * Instance identifiers are defined based on ISO object identifiers. <div>
 *
 * <div class="de">Ein Bezeichner, der eine Sache oder ein Objekt eindeutig
 * identifiziert. Beispiele sind Objektkennungen für HL7-RIM-Objekte, Nummer der
 * Patientenakte, Bestellnummer, Artikelnummer aus einem Servicekatalog,
 * Fahrzeugidentifikationsnummer usw. Instanzkennungen werden auf der Grundlage
 * von ISO-Objektkennungen definiert.<div>
 *
 */
public class IdentificatorBaseType implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link IdentificatorBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The assigning authority name. */
		private String assigningAuthorityName;

		/** The displayable. */
		private Boolean displayable;

		/** The extension. */
		private String extension;

		/** The null flavor. */
		private NullFlavor nullFlavor;

		/** The root. */
		private String root;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the identificator base type
		 */
		public IdentificatorBaseType build() {
			return new IdentificatorBaseType(this);
		}

		/**
		 * With assigning authority name.
		 *
		 * @param assigningAuthorityName
		 *            the assigning authority name
		 * @return the builder
		 */
		public Builder withAssigningAuthorityName(String assigningAuthorityName) {
			this.assigningAuthorityName = assigningAuthorityName;
			return this;
		}

		/**
		 * With displayable.
		 *
		 * @param displayable
		 *            the displayable
		 * @return the builder
		 */
		public Builder withDisplayable(Boolean displayable) {
			this.displayable = displayable;
			return this;
		}

		/**
		 * With extension.
		 *
		 * @param extension
		 *            the extension
		 * @return the builder
		 */
		public Builder withExtension(String extension) {
			this.extension = extension;
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
		 * With root.
		 *
		 * @param root
		 *            the root
		 * @return the builder
		 */
		public Builder withRoot(String root) {
			this.root = root;
			return this;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8238734619665101769L;

	/**
	 * Creates builder to build {@link IdentificatorBaseType}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The assigning authority name. */
	private String assigningAuthorityName;

	/** The displayable. */
	private Boolean displayable;

	/** The extension. */
	private String extension;

	/** The null flavor. */
	private NullFlavor nullFlavor;

	/** The root. */
	private String root;

	/**
	 * <div class="en">Instantiates a new IdentificatorBaseType. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen neuen IdentificatorBaseType.
	 * Standardkonstruktor.</div>
	 */
	public IdentificatorBaseType() {
	}

	/**
	 * Instantiates a new identificator base type.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private IdentificatorBaseType(Builder builder) {
		this.assigningAuthorityName = builder.assigningAuthorityName;
		this.displayable = builder.displayable;
		this.extension = builder.extension;
		this.root = builder.root;
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
	 *            the IdentificatorBaseType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean retVal = true;
		if (obj == null)
			return false;
		if (!(obj instanceof IdentificatorBaseType))
			return false;
		// only business rules are applied, here. rest was initially implemented
		// and stays here for future use. If you use it, you need to imnplement
		// another method and not change the currenty methos.
		// if (retVal) {
		// if (this.assigningAuthorityName == null)
		// retVal = (obj.getAssigningAuthorityName() == null);
		// else
		// retVal =
		// this.assigningAuthorityName.equals(obj.getAssigningAuthorityName());
		// }
		// if (retVal)
		// retVal = (this.displayable == obj.isDisplayable());
		if (retVal)
			if (this.extension == null)
				retVal = (((IdentificatorBaseType) obj).getExtension() == null);
			else
				retVal = this.extension.equals(((IdentificatorBaseType) obj).getExtension());
		if (retVal)
			if (this.root == null)
				retVal = (((IdentificatorBaseType) obj).getRoot() == null);
			else
				retVal = this.root.equals(((IdentificatorBaseType) obj).getRoot());
		return retVal;
	}

	/**
	 * <div class="en">Gets the assigning authority name.</div>
	 *
	 * <div class="de">Ruft den namen der zuständigen Herausgeberin ab.</div>
	 *
	 * @return the assigning authority name
	 */
	public String getAssigningAuthorityName() {
		return assigningAuthorityName;
	}

	/**
	 * <div class="en">Gets the extension. A character string as a unique
	 * identifier within the scope of the identifier root.</div>
	 *
	 * <div class="de">Ruft die Erweiterung ab. Eine, innerhalb der Domäne
	 * (root) eindeutige Zeichenfolge.</div>
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
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
	 * <div class="en">Gets the OID or UUID of the domain. A unique identifier
	 * that guarantees the global uniqueness of the instance identifier. The
	 * root alone may be the entire instance identifier (e.g. UUID without
	 * further definition by the extension).</div>
	 *
	 * <div class="de">Ruft die OID oder UUID der Domäne ab. Ein eindeutiger
	 * Bezeichner, der die globale Eindeutigkeit der Domäne garantiert. Die Root
	 * alleine kann die gesamte Instanzkennung sein. (z. B. UUID ohne weitere
	 * Definition durch die Erweiterung)</div>
	 *
	 * @return the root
	 */
	public String getRoot() {
		return root;
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
	 * <div class="en">Checks if is displayable. Specifies if the identifier is
	 * intended for human display and data entry (displayable = true) as opposed
	 * to pure machine interoperation (displayable = false).</div>
	 *
	 * <div class="de">Prüft, ob anzeigbar. Gibt an, ob der Bezeichner für die
	 * Anzeige und Dateneingabe durch den Benutzer vorgesehen ist (anzeigbar =
	 * true) und nicht für die reine Maschineninteraktion (anzeigbar =
	 * false).</div>
	 *
	 * @return true, if is displayable
	 */
	public Boolean isDisplayable() {
		return displayable;
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
	 * <div class="en">Sets the assigning authority name. See getter
	 * {@link IdentificatorBaseType#getAssigningAuthorityName} for more
	 * details.</div>
	 *
	 * <div class="de">Legt den Namen der zuständigen Herausgeberin fest. Siehe
	 * Getter {@link IdentificatorBaseType#getAssigningAuthorityName} für
	 * weitere Details.</div>
	 *
	 * @param assigningAuthorityName
	 *            the new assigning authority name
	 */
	public void setAssigningAuthorityName(String assigningAuthorityName) {
		this.assigningAuthorityName = assigningAuthorityName;
	}

	/**
	 * <div class="en">Sets the displayable flag. See getter
	 * {@link IdentificatorBaseType#isDisplayable} for more details.</div>
	 *
	 * <div class="de">Legt Setzt das Flag 'anzeigbar' fest. Siehe Getter
	 * {@link IdentificatorBaseType#isDisplayable} für weitere Details.</div>
	 *
	 * @param displayable
	 *            the new displayable
	 */
	public void setDisplayable(Boolean displayable) {
		this.displayable = displayable;
	}

	/**
	 * <div class="en">Sets the extension. See getter
	 * {@link IdentificatorBaseType#getExtension} for more details.</div>
	 *
	 * <div class="de">Legt die Erweiterung fest. Siehe Getter
	 * {@link IdentificatorBaseType#getExtension} für weitere Details.</div>
	 *
	 * @param extension
	 *            the new extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
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
	 * <div class="en">Sets the root. See getter
	 * {@link IdentificatorBaseType#getRoot} for more details.</div>
	 *
	 * <div class="de">Legt die Domäne fest. Siehe Getter
	 * {@link IdentificatorBaseType#getRoot} für weitere Details.</div>
	 *
	 * @param root
	 *            the new root
	 */
	public void setRoot(String root) {
		this.root = root;
	}

	/**
	 * <div class="en">Builds a string of the whole identificator.</div>
	 *
	 * <div class="de">Erstellt einen String des gesamten Identifikators.</div>
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder retVal = new StringBuilder();

		if (getRoot() != null)
			retVal.append(getRoot());
		else
			retVal.append("no root !!");

		String extension = getExtension();
		String assigningAuthorityName = getAssigningAuthorityName();

		if (extension != null)
			retVal.append(" / " + extension);

		if (assigningAuthorityName != null) {
			retVal.append(" (");
			retVal.append(assigningAuthorityName);
			retVal.append(")");
		}

		return retVal.toString();
	}

}
