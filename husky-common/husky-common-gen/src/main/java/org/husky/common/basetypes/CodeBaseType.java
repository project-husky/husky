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

import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.NullFlavor;
import org.husky.common.utils.LangText;
import org.husky.common.utils.Util;

/**
 * <div class="en">This class provides the basic information for a code
 * according to HL7. This class does not have any foreign framework dependencies
 * and is therefore one of the base elements of the Husky. Note:
 * qualifiers not supported, yet.<div>
 *
 * <div class="de">Diese Klasse enthält die BasisCodeBaseTypeinformationen für
 * einen Code gemäss HL7. Diese Klasse hat keine fremden
 * Framework-Abhängigkeiten und ist daher eines der Basiselemente des eHealth
 * Connector. Hinweis: qualifiers sind noch nicht implementiert.<div>
 *
 */
public class CodeBaseType implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link CodeBaseType}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The code. */
		private String code;

		/** The code system. */
		private String codeSystem;

		/** The code system name. */
		private String codeSystemName;

		/** The code system version. */
		private String codeSystemVersion;

		/** The code translation list. */
		private List<CodeBaseType> codeTranslationList;

		/** The display name. */
		private String displayName;

		/** The display name translation list. */
		private List<LangText> displayNameTranslationList;

		/** The null flavor. */
		private NullFlavor nullFlavor;

		/** The original text. */
		private String originalText;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the code base type
		 */
		public CodeBaseType build() {
			return new CodeBaseType(this);
		}

		/**
		 * With code.
		 *
		 * @param code
		 *            the code
		 * @return the builder
		 */
		public Builder withCode(String code) {
			this.code = code;
			return this;
		}

		/**
		 * With code system.
		 *
		 * @param codeSystem
		 *            the code system
		 * @return the builder
		 */
		public Builder withCodeSystem(String codeSystem) {
			this.codeSystem = codeSystem;
			return this;
		}

		/**
		 * With code system name.
		 *
		 * @param codeSystemName
		 *            the code system name
		 * @return the builder
		 */
		public Builder withCodeSystemName(String codeSystemName) {
			this.codeSystemName = codeSystemName;
			return this;
		}

		/**
		 * With code system version.
		 *
		 * @param codeSystemVersion
		 *            the code system version
		 * @return the builder
		 */
		public Builder withCodeSystemVersion(String codeSystemVersion) {
			this.codeSystemVersion = codeSystemVersion;
			return this;
		}

		/**
		 * With code translation list.
		 *
		 * @param codeTranslationList
		 *            the code translation list
		 * @return the builder
		 */
		public Builder withCodeTranslationList(List<CodeBaseType> codeTranslationList) {
			this.codeTranslationList = codeTranslationList;
			return this;
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
		 * With display name translation list.
		 *
		 * @param displayNameTranslationList
		 *            the display name translation list
		 * @return the builder
		 */
		public Builder withDisplayNameTranslationList(
				ArrayList<LangText> displayNameTranslationList) {
			this.displayNameTranslationList = displayNameTranslationList;
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
		 * With original text.
		 *
		 * @param originalText
		 *            the original text
		 * @return the builder
		 */
		public Builder withOriginalText(String originalText) {
			this.originalText = originalText;
			return this;
		}
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7581542143784688019L;

	/**
	 * Creates builder to build {@link CodeBaseType}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The code. */
	private String code;

	/** The code system. */
	private String codeSystem;

	/** The code system name. */
	private String codeSystemName;

	/** The code system version. */
	private String codeSystemVersion;

	/** The code translation. */
	private List<CodeBaseType> codeTranslationList;

	/** The display name. */
	private String displayName;

	/** The display name translation. */
	private List<LangText> displayNameTranslationList;

	/** The null flavor. */
	private NullFlavor nullFlavor;

	/** The original text. */
	private String originalText;

	/**
	 * <div class="en">Instantiates a new CodeBaseType. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen neuen CodeBaseType.
	 * Standardkonstruktor.</div>
	 */
	public CodeBaseType() {
	}

	/**
	 * Instantiates a new code base type.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private CodeBaseType(Builder builder) {
		this.code = builder.code;
		this.codeSystem = builder.codeSystem;
		this.codeSystemName = builder.codeSystemName;
		this.codeSystemVersion = builder.codeSystemVersion;
		this.codeTranslationList = builder.codeTranslationList;
		this.displayName = builder.displayName;
		this.displayNameTranslationList = builder.displayNameTranslationList;
		this.originalText = builder.originalText;
		this.nullFlavor = builder.nullFlavor;
	}

	/**
	 * <div class="en">Adds the code translation. A set of other codes that
	 * translate this one into other code systems.</div>
	 *
	 * <div class="de">Fügt die Code-Übersetzung hinzu. Eine Reihe anderer
	 * Codes, die diesen Code in andere Codesysteme übersetzen.</div>
	 *
	 *
	 * @param codeTranslation
	 *            the code translation
	 */
	public void addCodeTranslation(CodeBaseType codeTranslation) {
		if (this.codeTranslationList == null)
			this.codeTranslationList = new ArrayList<>();
		this.codeTranslationList.add(codeTranslation);
	}

	/**
	 * <div class="en">Adds the display name translation. A translation of the
	 * display name in another spoken language.</div>
	 *
	 * <div class="de">Fügt die Anzeigenamenübersetzung hinzu. Eine Übersetzung
	 * des Anzeigenamens in eine andere gesprochene Sprache.</div>
	 *
	 * @param displayNameTranslation
	 *            the display name translation
	 */
	public void addDisplayNameTranslation(LangText displayNameTranslation) {
		if (this.displayNameTranslationList == null)
			this.displayNameTranslationList = new ArrayList<>();
		this.displayNameTranslationList.add(displayNameTranslation);
	}

	/**
	 * <div class="en">Adds the display name translation. A translation of the
	 * display name in another spoken language.</div>
	 *
	 * <div class="de">Fügt die Anzeigenamenübersetzung hinzu. Eine Übersetzung
	 * des Anzeigenamens in eine andere gesprochene Sprache.</div>
	 *
	 * @param lang
	 *            the language
	 * @param text
	 *            the text
	 */
	public void addDisplayNameTranslation(LanguageCode lang, String text) {
		addDisplayNameTranslation(new LangText(lang, text));
	}

	/**
	 * <div class="en">Clears the code translation list.</div>
	 *
	 * <div class="de">Löscht die Code-Übersetzungsliste.</div>
	 */
	public void clearCodeTranslationList() {
		this.codeTranslationList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the display name translation list.</div>
	 *
	 * <div class="de">Löscht die Liste der Anzeigenamenübersetzungen.</div>
	 */
	public void clearDisplayNameTranslationList() {
		this.displayNameTranslationList = new ArrayList<>();
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
	public boolean contains(CodeBaseType value) {
		if (codeTranslationList != null) {
			for (CodeBaseType entry : codeTranslationList) {
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
	public boolean contains(LangText value) {
		if (displayNameTranslationList != null) {
			for (LangText entry : displayNameTranslationList) {
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
	 *            the CodeBaseType to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof CodeBaseType))
			return false;

		// only business rules are applied, here. Rest was initially implemented
		// and stays here for future use. If you use it, you need to implement
		// another method and not change the current method.
		// if (retVal) {
		// if (this.codeTranslationList == null)
		// this.codeTranslationList = new ArrayList<CodeBaseType>();
		// for (int i = 0; i < this.codeTranslationList.size(); i++) {
		// retVal = (obj.contains(this.codeTranslationList.get(i)));
		// if (!retVal)
		// break;
		// }
		// }
		// if (retVal) {
		// if (this.displayNameTranslationList == null)
		// this.displayNameTranslationList = new ArrayList<LangText>();
		// for (int i = 0; i < this.displayNameTranslationList.size(); i++) {
		// retVal = obj.contains(this.displayNameTranslationList.get(i));
		// if (!retVal)
		// break;
		// }
		// }
		if (retVal) {
			if (this.code == null)
				retVal = (((CodeBaseType) obj).getCode() == null);
			else
				retVal = this.code.equals(((CodeBaseType) obj).getCode());
		}
		if (retVal) {
			if (this.codeSystem == null)
				retVal = (((CodeBaseType) obj).getCodeSystem() == null);
			else
				retVal = this.codeSystem.equals(((CodeBaseType) obj).getCodeSystem());
		}
		// if (retVal) {
		// if (this.codeSystemName == null)
		// retVal = (obj.getCodeSystemName() == null);
		// else
		// retVal = this.codeSystemName.equals(obj.getCodeSystemName());
		// }
		// if (retVal) {
		// if (this.codeSystemVersion == null)
		// retVal = (obj.getCodeSystemVersion() == null);
		// else
		// retVal = this.codeSystemVersion.equals(obj.getCodeSystemVersion());
		// }
		// if (retVal) {
		// if (this.displayName == null)
		// retVal = (obj.getDisplayName() == null);
		// else
		// retVal = this.displayName.equals(obj.getDisplayName());
		// }
		// if (retVal) {
		// if (this.originalText == null)
		// retVal = (obj.getOriginalText() == null);
		// else
		// retVal = this.originalText.equals(obj.getOriginalText());
		// }
		return retVal;
	}

	/**
	 * <div class="en">Gets the code. The plain code symbol defined by the code
	 * system. For example, "784.0" is the code symbol of the ICD-10 code
	 * "784.0" for headache. It's value is unique within all values defined in
	 * the CodeSystem.</div>
	 *
	 * <div class="de">Ruft den Code ab. Das vom Codesystem festgelegte
	 * Klartext-Symbol. Beispielsweise ist "784.0" das Codesymbol des
	 * ICD-10-Codes "784.0" für Kopfschmerzen. Der Wert ist innerhalb aller im
	 * CodeSystem definierten Werte eindeutig.</div>
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <div class="en">Gets OID or UUID of the code system.</div>
	 *
	 * <div class="de">Ruft die OID oder UUID des Codesystems ab.</div>
	 *
	 * @return the code system
	 */
	public String getCodeSystem() {
		return codeSystem;
	}

	/**
	 * <div class="en">Gets the name of the code system.</div>
	 *
	 * <div class="de">Ruft den Namen des Codesystems ab.</div>
	 *
	 * @return the code system name
	 */
	public String getCodeSystemName() {
		return codeSystemName;
	}

	/**
	 * <div class="en">Gets the code system version. If applicable, a version
	 * descriptor defined specifically for the given code system.</div>
	 *
	 * <div class="de">Ruft die Codesystemversion ab. Gegebenenfalls ein
	 * speziell für das jeweilige Codesystem definierter
	 * Versionsdeskriptor.</div>
	 *
	 * @return the code system version
	 */
	public String getCodeSystemVersion() {
		return codeSystemVersion;
	}

	/**
	 * <div class="en">Gets the code translation list for the current
	 * code.</div>
	 *
	 * <div class="de">Ruft die Codeübersetzungsliste für den aktuellen Code
	 * ab.</div>
	 *
	 * @return the code translation list
	 */
	public List<CodeBaseType> getCodeTranslationList() {
		if (this.codeTranslationList == null)
			this.codeTranslationList = new ArrayList<>();
		return codeTranslationList;
	}

	/**
	 * <div class="en">Gets the display name of the code. It is usually an
	 * English text.</div>
	 *
	 * <div class="de">Ruft den Anzeigenamen des Codes ab. Es ist normalerweise
	 * ein englischer Text.</div>
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <div class="en">Gets the translation list for the display name. This List
	 * may contain translations of the display name in other spoken
	 * languages.</div>
	 *
	 * <div class="de">Ruft die Übersetzungsliste für den Anzeigenamen ab. Diese
	 * Liste enthält möglicherweise Übersetzungen des Anzeigenamens in andere
	 * gesprochene Sprachen.</div>
	 *
	 * @return the display name translation list
	 */
	public List<LangText> getDisplayNameTranslationList() {
		if (this.displayNameTranslationList == null)
			this.displayNameTranslationList = new ArrayList<>();
		return displayNameTranslationList;
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
	 * <div class="en">Gets the original text. It contains the original text
	 * describing the current code.</div>
	 *
	 * <div class="de">Ruft den Originaltext ab. Es enthält den Originaltext,
	 * der den aktuellen Code beschreibt.</div>
	 *
	 * @return the original text
	 */
	public String getOriginalText() {
		return originalText;
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
	 * <div class="en">Sets the code. See getter {@link CodeBaseType#getCode}
	 * for more details.</div>
	 *
	 * <div class="de">Legt den Code fest. Siehe Getter
	 * {@link CodeBaseType#getCode} für weitere Details.</div>
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * <div class="en">Sets the code system. See getter
	 * {@link CodeBaseType#getCodeSystem} for more details.</div>
	 *
	 * <div class="de">Legt das Code System fest. Siehe Getter
	 * {@link CodeBaseType#getCodeSystem} für weitere Details.</div>
	 *
	 * @param codeSystem
	 *            the new code system
	 */
	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	/**
	 * <div class="en">Sets the code system name. See getter
	 * {@link CodeBaseType#getCodeSystemName} for more details.</div>
	 *
	 * <div class="de">Legt den Namen des Code Systems fest. Siehe Getter
	 * {@link CodeBaseType#getCodeSystemName} für weitere Details.</div>
	 *
	 * @param codeSystemName
	 *            the new code system name
	 */
	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}

	/**
	 * <div class="en">Sets the code system version. See getter
	 * {@link CodeBaseType#getCodeSystemVersion} for more details.</div>
	 *
	 * <div class="de">Legt die Version des Code Systems fest. Siehe Getter
	 * {@link CodeBaseType#getCodeSystemVersion} für weitere Details.</div>
	 *
	 * @param codeSystemVersion
	 *            the new code system version
	 */
	public void setCodeSystemVersion(String codeSystemVersion) {
		this.codeSystemVersion = codeSystemVersion;
	}

	/**
	 * <div class="en">Sets the code translation list. See getter
	 * {@link CodeBaseType#getCodeTranslationList} for more details.</div>
	 *
	 * <div class="de">Legt die Code-Übersetzungsliste fest. Siehe Getter
	 * {@link CodeBaseType#getCodeTranslationList} für weitere Details.</div>
	 *
	 * @param codeTranslationList
	 *            the new code translation list
	 */
	public void setCodeTranslationList(List<CodeBaseType> codeTranslationList) {
		this.codeTranslationList = codeTranslationList;
	}

	/**
	 * <div class="en">Sets the display name. See getter
	 * {@link CodeBaseType#getDisplayName} for more details.</div>
	 *
	 * <div class="de">Legt den Anzeigenamen fest. Siehe Getter
	 * {@link CodeBaseType#getDisplayName} für weitere Details.</div>
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Sets the display name translation list. See getter
	 * {@link CodeBaseType#getDisplayNameTranslationList} for more
	 * details.</div>
	 *
	 * <div class="de">Legt die Übersetzungsliste für den Anzeigenamen fest.
	 * Siehe Getter {@link CodeBaseType#getDisplayNameTranslationList} für
	 * weitere Details.</div>
	 *
	 * @param displayNameTranslationList
	 *            the new display name translation list
	 */
	public void setDisplayNameTranslationList(List<LangText> displayNameTranslationList) {
		this.displayNameTranslationList = displayNameTranslationList;
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
	 * <div class="en">Sets the original text. See getter
	 * {@link CodeBaseType#getOriginalText} for more details.</div>
	 *
	 * <div class="de">Legt den original Text fest. Siehe Getter
	 * {@link CodeBaseType#getOriginalText} für weitere Details.</div>
	 *
	 * @param originalText
	 *            the new original text
	 */
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	/**
	 * <div class="en">Builds a string of the whole code.</div>
	 *
	 * <div class="de">Erstellt einen String des gesamten Codes.</div>
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		var retVal = new StringBuilder();

		if (getCode() != null)
			retVal.append(getCode() + " / ");
		else
			retVal.append("no code !! / ");

		if (getCodeSystem() != null)
			retVal.append(getCodeSystem());
		else
			retVal.append("no code system !!");

		var displayNameL = getDisplayName();
		var codeSystemNameL = getCodeSystemName();
		if ((displayNameL != null) || (codeSystemNameL != null)) {
			retVal.append(" (");

			if (displayNameL != null)
				retVal.append(displayNameL);

			if (codeSystemNameL != null) {
				if (displayNameL != null)
					retVal.append(" / ");

				retVal.append(codeSystemNameL);
			}

			retVal.append(")");
		}

		return retVal.toString();
	}

}
