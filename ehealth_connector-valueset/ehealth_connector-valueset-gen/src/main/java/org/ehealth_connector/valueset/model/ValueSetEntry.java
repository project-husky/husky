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

import java.util.ArrayList;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;

/**
 * <div class="en">The Class ValueSetEntry is intended to collect all
 * information of a single entry of a value set (such as code, codesystem,
 * display names in multiple languages...).</div>
 *
 * <div class="de">Die Klasse ValueSetEntry dient zum Sammeln aller
 * Informationen eines einzelnen Wertesatz-Eintrags (z. B. Code, Codesystem,
 * Anzeigenamen in mehreren Sprachen ...).</div>
 */
public class ValueSetEntry {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSetEntry}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The child list. */
		private ArrayList<ValueSetEntry> childList;

		/** The code base type. */
		private CodeBaseType codeBaseType;

		/** The default mapping name. */
		private String defaultMappingName;

		/** The designation list. */
		private ArrayList<Designation> designationList;

		/** The level. */
		private int level;

		/** The mapping code list. */
		private ArrayList<CodeBaseType> mappingCodeList;

		/** The mapping name list. */
		private ArrayList<String> mappingNameList;

		/** The value set entry type. */
		private ValueSetEntryType valueSetEntryType;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the value set entry
		 */
		public ValueSetEntry build() {
			return new ValueSetEntry(this);
		}

		/**
		 * With child list.
		 *
		 * @param childList
		 *            the child list
		 * @return the builder
		 */
		public Builder withChildList(ArrayList<ValueSetEntry> childList) {
			this.childList = childList;
			return this;
		}

		/**
		 * With code base type.
		 *
		 * @param codeBaseType
		 *            the code base type
		 * @return the builder
		 */
		public Builder withCodeBaseType(CodeBaseType codeBaseType) {
			this.codeBaseType = codeBaseType;
			return this;
		}

		/**
		 * With default mapping name.
		 *
		 * @param defaultMappingName
		 *            the default mapping name
		 * @return the builder
		 */
		public Builder withDefaultMappingName(String defaultMappingName) {
			this.defaultMappingName = defaultMappingName;
			return this;
		}

		/**
		 * With designation list.
		 *
		 * @param designationList
		 *            the designation list
		 * @return the builder
		 */
		public Builder withDesignationList(ArrayList<Designation> designationList) {
			this.designationList = designationList;
			return this;
		}

		/**
		 * With level.
		 *
		 * @param level
		 *            the level
		 * @return the builder
		 */
		public Builder withLevel(int level) {
			this.level = level;
			return this;
		}

		/**
		 * With mapping code list.
		 *
		 * @param mappingCodeList
		 *            the mapping code list
		 * @return the builder
		 */
		public Builder withMappingCodeList(ArrayList<CodeBaseType> mappingCodeList) {
			this.mappingCodeList = mappingCodeList;
			return this;
		}

		/**
		 * With mapping name list.
		 *
		 * @param mappingNameList
		 *            the mapping name list
		 * @return the builder
		 */
		public Builder withMappingNameList(ArrayList<String> mappingNameList) {
			this.mappingNameList = mappingNameList;
			return this;
		}

		/**
		 * With value set entry type.
		 *
		 * @param valueSetEntryType
		 *            the value set entry type
		 * @return the builder
		 */
		public Builder withValueSetEntryType(ValueSetEntryType valueSetEntryType) {
			this.valueSetEntryType = valueSetEntryType;
			return this;
		}
	}

	/**
	 * Creates builder to build {@link ValueSetEntry}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The children. */
	private ArrayList<ValueSetEntry> childList;

	/** The code base type. */
	private CodeBaseType codeBaseType;

	/** The default mapping name. */
	private String defaultMappingName;

	/** The designation list. */
	private ArrayList<Designation> designationList;

	/** The level. */
	private int level = 0;

	/** The mapping code list. */
	private ArrayList<CodeBaseType> mappingCodeList;

	/** The mapping name list. */
	private ArrayList<String> mappingNameList;

	/** The value set entry type. */
	private ValueSetEntryType valueSetEntryType;

	/**
	 * <div class="en">Instantiates a new ValueSetEntry. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert ein neues ValueSetEntry.
	 * Standardkonstruktor.</div>
	 */
	public ValueSetEntry() {
	}

	/**
	 * Instantiates a new value set entry.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private ValueSetEntry(Builder builder) {
		this.childList = builder.childList;
		this.mappingCodeList = builder.mappingCodeList;
		this.mappingNameList = builder.mappingNameList;
		this.codeBaseType = builder.codeBaseType;
		this.defaultMappingName = builder.defaultMappingName;
		this.level = builder.level;
		this.valueSetEntryType = builder.valueSetEntryType;
		this.designationList = builder.designationList;
	}

	/**
	 * <div class="en">Adds a child value set.</div>
	 *
	 * <div class="de">Fügt einen untergeordneten Wertesatz hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addChild(ValueSetEntry value) {
		if (this.childList == null) {
			this.childList = new ArrayList<ValueSetEntry>();
		}
		this.childList.add(value);
	}

	/**
	 * <div class="en">Adds a designation.</div>
	 *
	 * <div class="de">Fügt eine Bezeichnung hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addDesignation(Designation value) {
		if (this.designationList == null) {
			this.designationList = new ArrayList<Designation>();
		}
		this.designationList.add(value);
	}

	/**
	 * <div class="en">Adds a mapping code.</div>
	 *
	 * <div class="de">Fügt einen Zuordnungscode hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addMappingCode(CodeBaseType value) {
		if (this.mappingCodeList == null) {
			this.mappingCodeList = new ArrayList<CodeBaseType>();
		}
		this.mappingCodeList.add(value);
	}

	/**
	 * <div class="en">Adds a mapping name.</div>
	 *
	 * <div class="de">Fügt einen Zuordnungsnamen hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addMappingName(String value) {
		if (this.mappingNameList == null) {
			this.mappingNameList = new ArrayList<String>();
		}
		this.mappingNameList.add(value);
	}

	/**
	 * <div class="en">Clears the child list.</div>
	 *
	 * <div class="de">Löscht die Liste untergeordneter ValueSets.</div>
	 */
	public void clearChildList() {
		this.childList = new ArrayList<ValueSetEntry>();
	}

	/**
	 * <div class="en">Clears the designation list.</div>
	 *
	 * <div class="de">Löscht die Bezeichnungsliste.</div>
	 */
	public void clearDesignationList() {
		this.designationList = new ArrayList<Designation>();
	}

	/**
	 * <div class="en">Clears the mapping code list.</div>
	 *
	 * <div class="de">Löscht die Mapping-Code-Liste.</div>
	 */
	public void clearMappingCodeList() {
		this.mappingCodeList = new ArrayList<CodeBaseType>();
	}

	/**
	 * <div class="en">Clears the mapping name list.</div>
	 *
	 * <div class="de">Löscht die Mapping-Namensliste.</div>
	 */
	public void clearMappingNameList() {
		this.mappingNameList = new ArrayList<String>();
	}

	/**
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the ValueSetEntry to compare
	 * @return true, if equal; false otherwise.
	 */
	public boolean equals(ValueSetEntry obj) {
		boolean retVal = true;
		if (retVal) {
			for (int i = 0; i < this.childList.size(); i++) {
				retVal = (this.childList.get(i).equals(obj.listChilds().get(i)));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			for (int i = 0; i < this.mappingCodeList.size(); i++) {
				retVal = (this.mappingCodeList.get(i).equals(obj.listMappingCodes().get(i)));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			for (int i = 0; i < this.mappingNameList.size(); i++) {
				retVal = (this.mappingNameList.get(i).equals(obj.listMappingNames().get(i)));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.codeBaseType == null)
				retVal = (obj.getCodeBaseType() == null);
			else
				retVal = this.codeBaseType.equals(obj.getCodeBaseType());
		}
		if (retVal) {
			if (this.defaultMappingName == null)
				retVal = (obj.getDefaultMappingName() == null);
			else
				retVal = this.defaultMappingName.equals(obj.getDefaultMappingName());
		}
		if (retVal) {
			retVal = (this.level == obj.getLevel());
		}
		if (retVal) {
			if (this.valueSetEntryType == null)
				retVal = (obj.getValueSetEntryType() == null);
			else
				retVal = this.valueSetEntryType.equals(obj.getValueSetEntryType());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the child list.</div>
	 *
	 * <div class="de">Ruft die Liste untergeordnetes ValueSets ab.</div>
	 *
	 * @return the child list
	 */
	public ArrayList<ValueSetEntry> getChildList() {
		return childList;
	}

	/**
	 * <div class="en">Gets the code.</div>
	 *
	 * <div class="de">Ruft den Code ab.</div>
	 *
	 * @return the code base type
	 */
	public CodeBaseType getCodeBaseType() {
		return codeBaseType;
	}

	/**
	 * <div class="en">Gets the default mapping name.</div>
	 *
	 * <div class="de">Ruft den Standardzuordnungsnamen ab.</div>
	 *
	 * @return the default mapping name
	 */
	public String getDefaultMappingName() {
		return defaultMappingName;
	}

	/**
	 * <div class="en">Gets the designation in the given language.</div>
	 *
	 * <div class="de">Ruft die Bezeichnung in der angegebenen Sprache ab.</div>
	 *
	 * @param language
	 *            the language
	 * @return the designation
	 */
	public String getDesignation(LanguageCode language, DesignationType designationType) {
		String retVal = null;
		for (Designation designation : listDesignations()) {
			if (language.equals(designation.getLanguageCode()) && (designationType == null))
				retVal = designation.getDisplayName();
			else if (language.equals(designation.getLanguageCode())
					&& (designationType.equals(designation.getType())))
				retVal = designation.getDisplayName();
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the designation list.</div>
	 *
	 * <div class="de">Ruft die Bezeichnungsliste ab.</div>
	 *
	 * @return the designation list
	 */
	public ArrayList<Designation> getDesignationList() {
		return designationList;
	}

	/**
	 * <div class="en">Gets the level.</div>
	 *
	 * <div class="de">Ruft das Level ab.</div>
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <div class="en">Gets the mapping code list.</div>
	 *
	 * <div class="de">Ruft die Zuordnungscodeliste ab.</div>
	 *
	 * @return the mapping code list
	 */
	public ArrayList<CodeBaseType> getMappingCodeList() {
		return mappingCodeList;
	}

	/**
	 * <div class="en">Gets the mapping name list.</div>
	 *
	 * <div class="de">Ruft die Zuordnungsnamensliste ab.</div>
	 *
	 * @return the mapping name list
	 */
	public ArrayList<String> getMappingNameList() {
		return mappingNameList;
	}

	/**
	 * <div class="en">Gets the value set entry type.</div>
	 *
	 * <div class="de">Ruft den Typ des Eintrags ab.</div>
	 *
	 * @return the value set entry type
	 */
	public ValueSetEntryType getValueSetEntryType() {
		return valueSetEntryType;
	}

	/**
	 * <div class="en">Gets the list of children.</div>
	 *
	 * <div class="de">Ruft die Liste untergeordnetes ValueSets ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<ValueSetEntry> listChilds() {
		if (this.childList == null) {
			this.childList = new ArrayList<ValueSetEntry>();
		}
		return this.childList;
	}

	/**
	 * <div class="en">Gets the list of designations.</div>
	 *
	 * <div class="de">Ruft die Liste der Bezeichnungen ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<Designation> listDesignations() {
		if (this.designationList == null) {
			this.designationList = new ArrayList<Designation>();
		}
		return this.designationList;
	}

	/**
	 * <div class="en">Gets the list of mapping codes.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungscodes ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<CodeBaseType> listMappingCodes() {
		if (this.mappingCodeList == null) {
			this.mappingCodeList = new ArrayList<CodeBaseType>();
		}
		return this.mappingCodeList;
	}

	/**
	 * <div class="en">Gets the list of mapping names.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungsnamen ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<String> listMappingNames() {
		if (this.mappingNameList == null) {
			this.mappingNameList = new ArrayList<String>();
		}
		return this.mappingNameList;
	}

	/**
	 * <div class="en">Sets the child list.</div>
	 *
	 * <div class="de">Legt die Liste untergeordnetes ValueSets fest.</div>
	 *
	 * @param childList
	 *            the new child list
	 */
	public void setChildList(ArrayList<ValueSetEntry> childList) {
		this.childList = childList;
	}

	/**
	 * <div class="en">Sets the code.</div>
	 *
	 * <div class="de">Legt den Code fest.</div>
	 *
	 * @param codeBaseType
	 *            the new code base type
	 */
	public void setCodeBaseType(CodeBaseType codeBaseType) {
		this.codeBaseType = codeBaseType;
	}

	/**
	 * <div class="en">Sets the default mapping name.</div>
	 *
	 * <div class="de">Legt den Standard-Zuordnungsnamen fest.</div>
	 *
	 * @param defaultMappingName
	 *            the new default mapping name
	 */
	public void setDefaultMappingName(String defaultMappingName) {
		this.defaultMappingName = defaultMappingName;
	}

	/**
	 * <div class="en">Sets the designation list.</div>
	 *
	 * <div class="de">Legt die Bezeichnungsliste fest.</div>
	 *
	 * @param designationList
	 *            the new designation list
	 */
	public void setDesignationList(ArrayList<Designation> designationList) {
		this.designationList = designationList;
	}

	/**
	 * <div class="en">Sets the level.</div>
	 *
	 * <div class="de">Legt den Level fest</div>
	 *
	 * @param level
	 *            the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * <div class="en">Sets the mapping code list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungscodes fest.</div>
	 *
	 * @param mappingCodeList
	 *            the new mapping code list
	 */
	public void setMappingCodeList(ArrayList<CodeBaseType> mappingCodeList) {
		this.mappingCodeList = mappingCodeList;
	}

	/**
	 * <div class="en">Sets the mapping name list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungsnamen fest.</div>
	 *
	 * @param mappingNameList
	 *            the new mapping name list
	 */
	public void setMappingNameList(ArrayList<String> mappingNameList) {
		this.mappingNameList = mappingNameList;
	}

	/**
	 * <div class="en">Sets the value set entry type.</div>
	 *
	 * <div class="de">Legt den Typ des Eintrags fest.</div>
	 *
	 * @param valueSetEntryType
	 *            the new value set entry type
	 */
	public void setValueSetEntryType(ValueSetEntryType valueSetEntryType) {
		this.valueSetEntryType = valueSetEntryType;
	}

}
