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
package org.husky.valueset.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.enums.LanguageCode;
import org.husky.valueset.enums.DesignationType;
import org.husky.valueset.enums.ValueSetEntryType;

/**
 * <div class="en">The Class ValueSetEntry is intended to collect all
 * information of a single entry of a value set (such as code, codesystem,
 * display names in multiple languages...).</div>
 *
 * <div class="de">Die Klasse ValueSetEntry dient zum Sammeln aller
 * Informationen eines einzelnen Wertesatz-Eintrags (z. B. Code, Codesystem,
 * Anzeigenamen in mehreren Sprachen ...).</div>
 */
public class ValueSetEntry implements Serializable {

	/**
	 * Builder to build {@link ValueSetEntry}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The parent. */
		private ValueSetEntry parent;

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
		 * With parent.
		 *
		 * @param parent
		 *            the parent
		 * @return the builder
		 */
		public Builder withParent(ValueSetEntry parent) {
			this.parent = parent;
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
	 * See getter/setter for more details to the class members.
	 */

	private static final long serialVersionUID = 20533928572823276L;

	/**
	 * Creates builder to build {@link ValueSetEntry}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The parent. */
	private ValueSetEntry parent;

	/** The children. */
	private List<ValueSetEntry> childList;

	/** The code base type. */
	private CodeBaseType codeBaseType;

	/** The default mapping name. */
	private String defaultMappingName;

	/** The designation list. */
	private List<Designation> designationList;

	/** The level. */
	private int level = 0;

	/** The mapping code list. */
	private List<CodeBaseType> mappingCodeList;

	/** The mapping name list. */
	private List<String> mappingNameList;

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
		this.parent = builder.parent;
		this.childList = builder.childList;
		this.codeBaseType = builder.codeBaseType;
		this.defaultMappingName = builder.defaultMappingName;
		this.designationList = builder.designationList;
		this.level = builder.level;
		this.mappingCodeList = builder.mappingCodeList;
		this.mappingNameList = builder.mappingNameList;
		this.valueSetEntryType = builder.valueSetEntryType;
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
		if (this.childList == null)
			this.childList = new ArrayList<>();

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
		if (this.designationList == null)
			this.designationList = new ArrayList<>();

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
		if (this.mappingCodeList == null)
			this.mappingCodeList = new ArrayList<>();

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
		if (this.mappingNameList == null)
			this.mappingNameList = new ArrayList<>();

		this.mappingNameList.add(value);
	}

	/**
	 * <div class="en">Clears the child list.</div>
	 *
	 * <div class="de">Löscht die Liste untergeordneter ValueSets.</div>
	 */
	public void clearChildList() {
		this.childList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the designation list.</div>
	 *
	 * <div class="de">Löscht die Bezeichnungsliste.</div>
	 */
	public void clearDesignationList() {
		this.designationList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the mapping code list.</div>
	 *
	 * <div class="de">Löscht die Mapping-Code-Liste.</div>
	 */
	public void clearMappingCodeList() {
		this.mappingCodeList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the mapping name list.</div>
	 *
	 * <div class="de">Löscht die Mapping-Namensliste.</div>
	 */
	public void clearMappingNameList() {
		this.mappingNameList = new ArrayList<>();
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
	public boolean containsChild(ValueSetEntry value) {
		if (childList != null) {
			for (ValueSetEntry entry : childList) {
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
	public boolean containsDesignation(Designation value) {
		if (designationList != null) {
			for (Designation entry : designationList) {
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
	public boolean containsMappingCode(CodeBaseType value) {
		if (mappingCodeList != null) {
			for (CodeBaseType entry : mappingCodeList) {
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
	public boolean containsMappingName(String value) {
		if (mappingNameList != null) {
			for (String entry : mappingNameList) {
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
	 *            the ValueSetEntry to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof ValueSetEntry))
			return false;

		retVal = compareValueChildList((ValueSetEntry) obj);

		if (retVal) {
			retVal = compareDesignationList((ValueSetEntry) obj);
		}
		if (retVal) {
			retVal = compareMappingCodeList((ValueSetEntry) obj);
		}
		if (retVal) {
			retVal = compareMappingNameList((ValueSetEntry) obj);
		}
		if (retVal) {
			retVal = compareCodeBaseType((ValueSetEntry) obj);
		}
		if (retVal) {
			retVal = compareDefaultMappingName((ValueSetEntry) obj);
		}
		if (retVal) {
			retVal = (this.level == ((ValueSetEntry) obj).getLevel());
		}
		if (retVal) {
			retVal = compareValueSetEntryType((ValueSetEntry) obj);
		}
		return retVal;
	}

	private boolean compareValueSetEntryType(ValueSetEntry obj) {
		if (this.valueSetEntryType == null)
			return obj.getValueSetEntryType() == null;
		else
			return this.valueSetEntryType.equals(obj.getValueSetEntryType());
	}

	private boolean compareDefaultMappingName(ValueSetEntry obj) {
		if (this.defaultMappingName == null)
			return obj.getDefaultMappingName() == null;
		else
			return this.defaultMappingName.equals(obj.getDefaultMappingName());
	}

	private boolean compareCodeBaseType(ValueSetEntry obj) {
		if (this.codeBaseType == null)
			return obj.getCodeBaseType() == null;
		else
			return this.codeBaseType.equals(obj.getCodeBaseType());
	}

	private boolean compareDesignationList(ValueSetEntry obj) {
		if (this.designationList == null) {
			this.designationList = new ArrayList<>();
		}

		var retVal = this.designationList.size() == obj.getDesignationList().size();
		if (retVal) {
			for (var i = 0; i < this.designationList.size(); i++) {
				retVal = obj.containsDesignation(this.designationList.get(i));
				if (!retVal) {
					return false;
				}
			}
		}

		return retVal;
	}

	private boolean compareMappingCodeList(ValueSetEntry obj) {
		if (this.mappingCodeList == null) {
			this.mappingCodeList = new ArrayList<>();
		}

		var retVal = this.mappingCodeList.size() == obj.getMappingCodeList().size();
		if (retVal) {
			for (var i = 0; i < this.mappingCodeList.size(); i++) {
				retVal = obj.containsMappingCode(this.mappingCodeList.get(i));
				if (!retVal) {
					return false;
				}
			}
		}

		return retVal;
	}

	private boolean compareMappingNameList(ValueSetEntry obj) {
		if (this.mappingNameList == null)
			this.mappingNameList = new ArrayList<>();
		var retVal = this.mappingNameList.size() == obj.getMappingNameList().size();
		if (retVal) {
			for (var i = 0; i < this.mappingNameList.size(); i++) {
				retVal = obj.containsMappingName(this.mappingNameList.get(i));
				if (!retVal) {
					return false;
				}
			}
		}

		return retVal;
	}

	private boolean compareValueChildList(ValueSetEntry obj) {
		if (this.childList == null) {
			this.childList = new ArrayList<>();
		}

		var retVal = this.childList.size() == obj.getChildList().size();
		if (retVal) {
			for (var i = 0; i < this.childList.size(); i++) {
				retVal = obj.containsChild(this.childList.get(i));
				if (!retVal) {
					return false;
				}
			}
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
	public List<ValueSetEntry> getChildList() {
		if (childList == null) {
			childList = new ArrayList<>();
		}
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
	 * @param designationType
	 *            the designation type
	 * @return the designation
	 */
	public String getDesignation(LanguageCode language, DesignationType designationType) {
		String retVal = null;
		for (Designation designation : getDesignationList()) {
			if (language.equals(designation.getLanguageCode())) {
				retVal = designation.getDisplayName();
			}
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
	public List<Designation> getDesignationList() {
		if (designationList == null) {
			designationList = new ArrayList<>();
		}
		return designationList;
	}

	/**
	 * <div class="en">Gets the enum constant name.</div>
	 *
	 * @return the enum constant name
	 */
	public String getEnumConstantName() {
		String preferredDesignation = this.getDesignation(LanguageCode.ENGLISH,
				DesignationType.PREFERRED);
		if (preferredDesignation != null) {
			return ValueSet.buildEnumName(preferredDesignation, this.getLevel());
		}
		return ValueSet.buildEnumName(this.getCodeBaseType().getDisplayName(), this.getLevel());
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
	public List<CodeBaseType> getMappingCodeList() {
		if (mappingCodeList == null) {
			mappingCodeList = new ArrayList<>();
		}
		return mappingCodeList;
	}

	/**
	 * <div class="en">Gets the mapping name list.</div>
	 *
	 * <div class="de">Ruft die Zuordnungsnamensliste ab.</div>
	 *
	 * @return the mapping name list
	 */
	public List<String> getMappingNameList() {
		if (mappingNameList == null) {
			mappingNameList = new ArrayList<>();
		}
		return mappingNameList;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public ValueSetEntry getParent() {
		return parent;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.childList).append(this.designationList).append(this.mappingCodeList)
				.append(this.mappingNameList).append(this.codeBaseType).append(this.defaultMappingName)
				.append(this.level).append(this.valueSetEntryType).toHashCode();
	}

	/**
	 * <div class="en">Sets the child list.</div>
	 *
	 * <div class="de">Legt die Liste untergeordnetes ValueSets fest.</div>
	 *
	 * @param childList
	 *            the new child list
	 */
	public void setChildList(List<ValueSetEntry> childList) {
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
	public void setDesignationList(List<Designation> designationList) {
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
	public void setMappingCodeList(List<CodeBaseType> mappingCodeList) {
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
	public void setMappingNameList(List<String> mappingNameList) {
		this.mappingNameList = mappingNameList;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent
	 *            the new parent
	 */
	public void setParent(ValueSetEntry parent) {
		this.parent = parent;
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
