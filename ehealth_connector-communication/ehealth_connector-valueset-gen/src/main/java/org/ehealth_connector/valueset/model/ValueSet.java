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
package org.ehealth_connector.valueset.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.enums.ValueSetStatus;

/**
 * <div class="en">The Class ValueSet is intended to collect all metadata of a
 * value set (such as id, name, version, date ...) and all Entries (codes) of
 * the value set.</div>
 *
 * <div class="de">Die Klasse ValueSet dient zum Sammeln aller Metadaten eines
 * Wertesatzes (wie ID, Name, Version, Datum ...) und aller Einträge (Codes) des
 * Wertesatzes.</div>
 */
public class ValueSet implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSet}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private ArrayList<LangText> descriptionList;
		private String displayName;
		private Date effectiveDate;
		private IdentificatorBaseType identificator;
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;
		private ArrayList<String> mappingNameList;
		private String name;
		private ValueSetStatus status;
		private ArrayList<ValueSetEntry> valueSetEntryList;
		private Version version;

		private Builder() {
		}

		public ValueSet build() {
			return new ValueSet(this);
		}

		public Builder withDescriptionList(ArrayList<LangText> descriptionList) {
			this.descriptionList = descriptionList;
			return this;
		}

		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public Builder withEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
			return this;
		}

		public Builder withIdentificator(IdentificatorBaseType identificator) {
			this.identificator = identificator;
			return this;
		}

		public Builder withMappingIdentificatorList(
				ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
			this.mappingIdentificatorList = mappingIdentificatorList;
			return this;
		}

		public Builder withMappingNameList(ArrayList<String> mappingNameList) {
			this.mappingNameList = mappingNameList;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withStatus(ValueSetStatus status) {
			this.status = status;
			return this;
		}

		public Builder withValueSetEntryList(ArrayList<ValueSetEntry> valueSetEntryList) {
			this.valueSetEntryList = valueSetEntryList;
			return this;
		}

		public Builder withVersion(Version version) {
			this.version = version;
			return this;
		}
	}

	/**
	 * <div class="en">The Class
	 * ValueSetEntryPreferredEnglishDesignationComparator is intended to sort
	 * the value set entries in the same order as the Eclipse source code sorter
	 * will do. This is just to optimize the generated Java code.
	 */
	private class ValueSetEntryEnumNameComparator implements Comparator<ValueSetEntry> {

		/**
		 *
		 * Compares two observations on their date descending.
		 *
		 * {@inheritDoc}
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(ValueSetEntry a, ValueSetEntry b) {
			if ((a == null) && (b == null))
				return 0;
			else if ((a == null) && (b != null))
				return -1;
			else if ((a != null) && (b == null))
				return 1;
			else {

				String enumConstantName_a = a.getEnumConstantName();
				String enumConstantName_b = b.getEnumConstantName();

				if ((enumConstantName_a == null) && (enumConstantName_b == null))
					return 0;
				else if ((enumConstantName_a == null) && (enumConstantName_b != null))
					return -1;
				else if ((enumConstantName_a != null) && (enumConstantName_b == null))
					return 1;
				else
					return enumConstantName_a.compareTo(enumConstantName_b);
			}
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 3651683518612813256L;

	/**
	 * <div class="en">Builds a Java compatible enum element name from a
	 * string.</div>
	 *
	 * <div class="de">Erstellt einen Java-kompatiblen Enum-Elementnamen aus
	 * einer Zeichenfolge.</div>
	 *
	 * @param displayName
	 *            The string to build the enum name from.
	 * @return An all upper case string with every non-word character replaced
	 *         with an underscore.
	 * @throws IllegalArgumentException
	 *             When the provided displayName is null or empty.
	 */
	public static String buildEnumName(String displayName, int hierarchyLevel)
			throws IllegalArgumentException {
		if (displayName == null || displayName.trim().isEmpty()) {
			throw new IllegalArgumentException("displayName cannot be null or empty");
		}

		String enumName = displayName.trim().toUpperCase();

		enumName = enumName.replaceAll("CLIENT'S", "CLIENT");
		enumName = enumName.replaceAll("PATIENT'S", "PATIENT");
		enumName = enumName.replaceAll(" \\(IC\\)", "");
		enumName = enumName.replaceAll("&AMP;", "AND");
		enumName = enumName.replaceAll("%", "PERCENT");
		enumName = enumName.replaceAll("Μ", "U"); // That's not a 'M', that's an uppercased 'µ'
		enumName = enumName.replaceAll("\\*", "STAR");
		enumName = enumName.replaceAll("\\(S\\)", "");
		enumName = enumName.replaceAll("-", "_");
		enumName = enumName.replaceAll("\\W", "_");
		enumName = enumName.replaceAll("_+", "_");


		while (enumName.endsWith("_"))
			enumName = enumName.substring(0, enumName.length() - 1);

		// enums starting with a number
		// (e.g. 3 Self-Sustaining Sequence Replication)
		// https://art-decor.org/art-decor/decor-valuesets--cdachvacd-?id=2.16.840.1.113883.1.11.14079&effectiveDate=2014-03-26T00:00:00&language=en-US
		if (enumName.substring(0, 1).matches("[0-9]")) {
			String number = "";
			switch (enumName.substring(0, 1)) {
			case "0":
				number = "Zero";
				break;
			case "1":
				number = "One";
				break;
			case "2":
				number = "Two";
				break;
			case "3":
				number = "Three";
				break;
			case "4":
				number = "Four";
				break;
			case "5":
				number = "Five";
				break;
			case "6":
				number = "Six";
				break;
			case "7":
				number = "Seven";
				break;
			case "8":
				number = "Eight";
				break;
			case "9":
				number = "Nine";
				break;
			}
			number = number.toUpperCase();
			enumName = number + "_" + enumName.substring(2, enumName.length());
		}

		if (hierarchyLevel > 0)
			enumName += "_L" + Integer.toString(hierarchyLevel);

		return enumName;
	}

	/**
	 * Creates builder to build {@link ValueSet}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The description list. */
	private ArrayList<LangText> descriptionList;

	/** The display name. */
	private String displayName;

	/** The effective date. */
	private Date effectiveDate;

	/** The identificator. */
	private IdentificatorBaseType identificator;

	/** The mapping identificator list. */
	private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

	/** The mapping name list. */
	private ArrayList<String> mappingNameList;

	/** The name. */
	private String name;

	/** The status. */
	private ValueSetStatus status;

	/** The value set entry list. */
	private ArrayList<ValueSetEntry> valueSetEntryList;

	/** The version. */
	private Version version;

	/**
	 * <div class="en">Instantiates a new ValueSet. Default constructor.</div>
	 *
	 * <div class="de">Instanziiert ein neues ValueSet.
	 * Standardkonstruktor.</div>
	 */
	public ValueSet() {
	}

	@Generated("SparkTools")
	private ValueSet(Builder builder) {
		this.descriptionList = builder.descriptionList;
		this.displayName = builder.displayName;
		this.effectiveDate = builder.effectiveDate;
		this.identificator = builder.identificator;
		this.mappingIdentificatorList = builder.mappingIdentificatorList;
		this.mappingNameList = builder.mappingNameList;
		this.name = builder.name;
		this.status = builder.status;
		this.valueSetEntryList = builder.valueSetEntryList;
		this.version = builder.version;
	}

	/**
	 * <div class="en">Adds a description.</div>
	 *
	 * <div class="de">Fügt eine Beschreibung hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addDescription(LangText value) {
		if (this.descriptionList == null)
			this.descriptionList = new ArrayList<LangText>();

		this.descriptionList.add(value);
	}

	private void addEntryList(ArrayList<ValueSetEntry> globalList,
			ArrayList<ValueSetEntry> valueSetEntryList) {
		if (valueSetEntryList != null) {
			for (ValueSetEntry valueSetEntry : valueSetEntryList) {
				globalList.add(valueSetEntry);
			}
		}
	}

	private ArrayList<ValueSetEntry> addEntryListRecursive(ArrayList<ValueSetEntry> globalList,
			ArrayList<ValueSetEntry> valueSetEntryList) {
		ArrayList<ValueSetEntry> retVal = new ArrayList<ValueSetEntry>();
		retVal.addAll(globalList);
		if (valueSetEntryList != null) {
			for (ValueSetEntry valueSetEntry : valueSetEntryList) {
				// This is for debugging purposes, only
				// String entryName = ValueSet
				// .buildEnumName(valueSetEntry.getCodeBaseType().getDisplayName());

				boolean isAlreadyThere = false;
				for (ValueSetEntry temp : globalList) {
					isAlreadyThere = (temp.equals(valueSetEntry));
					if (isAlreadyThere)
						break;
				}

				if (!isAlreadyThere)
					retVal.add(valueSetEntry);

				ArrayList<ValueSetEntry> children = valueSetEntry.getChildList();
				if (children != null)
					if (children.size() > 0)
						retVal = addEntryListRecursive(retVal, children);
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Adds a mapping identificator.</div>
	 *
	 * <div class="de">Fügt einen Zuordnungsidentifikator hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addMappingIdentificator(IdentificatorBaseType value) {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();

		this.mappingIdentificatorList.add(value);
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
			this.mappingNameList = new ArrayList<String>();

		this.mappingNameList.add(value);
	}

	/**
	 * <div class="en">Adds a value set entry.</div>
	 *
	 * <div class="de">Fügt einen Wertesatzeintrag hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addValueSetEntry(ValueSetEntry value) {
		if (this.valueSetEntryList == null)
			this.valueSetEntryList = new ArrayList<ValueSetEntry>();

		this.valueSetEntryList.add(value);
	}

	/**
	 * <div class="en">Clears the description list.</div>
	 *
	 * <div class="de">Löscht die Beschreibungsliste.</div>
	 */
	public void clearDescriptionList() {
		this.valueSetEntryList = new ArrayList<ValueSetEntry>();
	}

	/**
	 * <div class="en">Clears the mapping identificator list.</div>
	 *
	 * <div class="de">Löscht die Liste der Zuordnungsidentifikatoren.</div>
	 */
	public void clearMappingIdentificatorList() {
		this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
	}

	/**
	 * <div class="en">Clears the mapping name list.</div>
	 *
	 * <div class="de">Löscht die Liste der Zuordnungsnamen.</div>
	 */
	public void clearMappingNameList() {
		this.mappingNameList = new ArrayList<String>();
	}

	/**
	 * <div class="en">Clears the value set entry list.</div>
	 *
	 * <div class="de">Löscht die Wertesatz-Eintragsliste.</div>
	 */
	public void clearValueSetEntryList() {
		this.valueSetEntryList = new ArrayList<ValueSetEntry>();
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
	public boolean containsDescription(LangText value) {
		if (descriptionList != null) {
			for (LangText entry : descriptionList) {
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
	public boolean containsMappingIdentificator(IdentificatorBaseType value) {
		if (mappingIdentificatorList != null) {
			for (IdentificatorBaseType entry : mappingIdentificatorList) {
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
	public boolean containsValueSetEntry(ValueSetEntry value) {
		if (valueSetEntryList != null) {
			for (ValueSetEntry entry : valueSetEntryList) {
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
	 *            the ValueSet to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof ValueSet))
			return false;

		if (retVal) {
			if (this.descriptionList == null)
				this.descriptionList = new ArrayList<LangText>();
			retVal = (this.descriptionList.size() == ((ValueSet) obj).getDescriptionList().size());
			if (retVal) {
				for (int i = 0; i < this.descriptionList.size(); i++) {
					retVal = ((ValueSet) obj).containsDescription(this.descriptionList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.mappingIdentificatorList == null)
				this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
			retVal = (this.mappingIdentificatorList.size() == ((ValueSet) obj)
					.getMappingIdentificatorList().size());
			if (retVal) {
				for (int i = 0; i < this.mappingIdentificatorList.size(); i++) {
					retVal = ((ValueSet) obj)
							.containsMappingIdentificator(this.mappingIdentificatorList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.mappingNameList == null)
				this.mappingNameList = new ArrayList<String>();
			retVal = (this.mappingNameList.size() == ((ValueSet) obj).getMappingNameList().size());
			if (retVal) {
				for (int i = 0; i < this.mappingNameList.size(); i++) {
					retVal = ((ValueSet) obj).containsMappingName(this.mappingNameList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.valueSetEntryList == null)
				this.valueSetEntryList = new ArrayList<ValueSetEntry>();
			retVal = (this.valueSetEntryList.size() == ((ValueSet) obj).getValueSetEntryList()
					.size());
			if (retVal) {
				for (int i = 0; i < this.valueSetEntryList.size(); i++) {
					retVal = ((ValueSet) obj).containsValueSetEntry(this.valueSetEntryList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.displayName == null)
				retVal = (((ValueSet) obj).getDisplayName() == null);
			else
				retVal = this.displayName.equals(((ValueSet) obj).getDisplayName());
		}
		if (retVal) {
			if (this.effectiveDate == null)
				retVal = (((ValueSet) obj).getEffectiveDate() == null);
			else
				retVal = this.effectiveDate.equals(((ValueSet) obj).getEffectiveDate());
		}
		if (retVal) {
			if (this.identificator == null)
				retVal = (((ValueSet) obj).getIdentificator() == null);
			else
				retVal = this.identificator.equals(((ValueSet) obj).getIdentificator());
		}
		if (retVal) {
			if (this.name == null)
				retVal = (((ValueSet) obj).getName() == null);
			else
				retVal = this.name.equals(((ValueSet) obj).getName());
		}
		if (retVal) {
			if (this.status == null)
				retVal = (((ValueSet) obj).getStatus() == null);
			else
				retVal = this.status.equals(((ValueSet) obj).getStatus());
		}
		if (retVal) {
			if (this.version == null)
				retVal = (((ValueSet) obj).getVersion() == null);
			else
				retVal = this.version.equals(((ValueSet) obj).getVersion());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the description in the given language.</div>
	 *
	 * <div class="de">Ruft die Beschreibung in der angegebenen Sprache
	 * ab.</div>
	 *
	 * @param language
	 *            the language
	 * @return the description
	 */
	public String getDescription(LanguageCode language) {
		String retVal = null;
		if (descriptionList != null) {
			for (int i = 0; i < this.descriptionList.size(); i++) {
				LangText langText = this.descriptionList.get(i);
				if (language.equals(langText.getLangCode())) {
					retVal = langText.getLangText();
					break;
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the description list.</div>
	 *
	 * <div class="de">Ruft die Beschreibungsliste ab.</div>
	 *
	 * @return the description list
	 */
	public ArrayList<LangText> getDescriptionList() {
		if (descriptionList == null) {
			descriptionList = new ArrayList<LangText>();
		}
		return descriptionList;
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
	 * <div class="en">Gets the effective date.</div>
	 *
	 * <div class="de">Ruft das Datum des Inkrafttretens ab.</div>
	 *
	 * @return the effective date
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * <div class="en">Gets the identificator.</div>
	 *
	 * <div class="de">Ruft den Identifikator ab.</div>
	 *
	 * @return the identificator
	 */
	public IdentificatorBaseType getIdentificator() {
		return identificator;
	}

	/**
	 * <div class="en">Gets the mapping identificator list.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungsidentifikatoren ab.</div>
	 *
	 * @return the mapping identificator list
	 */
	public ArrayList<IdentificatorBaseType> getMappingIdentificatorList() {
		if (mappingIdentificatorList == null) {
			mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		}
		return mappingIdentificatorList;
	}

	/**
	 * <div class="en">Gets the mapping name list.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungsnamen ab.</div>
	 *
	 * @return the mapping name list
	 */
	public ArrayList<String> getMappingNameList() {
		if (mappingNameList == null) {
			mappingNameList = new ArrayList<String>();
		}
		return mappingNameList;
	}

	/**
	 * <div class="en">Gets the name.</div>
	 *
	 * <div class="de">Ruft den Namen ab.</div>
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * <div class="en">Gets the sorted entry list.</div>
	 *
	 * <div class="de">Ruft die sortierte Eintragsliste ab.</div>
	 *
	 * @return the sorted entry list
	 */
	public ArrayList<ValueSetEntry> getSortedEntryList() {
		ArrayList<ValueSetEntry> retVal = new ArrayList<ValueSetEntry>();
		addEntryList(retVal, valueSetEntryList);
		retVal.sort(new ValueSetEntryEnumNameComparator());
		return retVal;
	}

	/**
	 * <div class="en">Gets the sorted entry list. Contains also value set
	 * entries from children.</div>
	 *
	 * <div class="de">Ruft die sortierte Eintragsliste ab. Enthält auch
	 * Werteeinträge von untergeordneten Elementen.</div>
	 *
	 * @return the sorted entry list
	 */
	public ArrayList<ValueSetEntry> getSortedEntryListRecursive() {
		ArrayList<ValueSetEntry> retVal = new ArrayList<ValueSetEntry>();
		retVal = addEntryListRecursive(retVal, valueSetEntryList);
		retVal.sort(new ValueSetEntryEnumNameComparator());
		return retVal;
	}

	/**
	 * <div class="en">Gets the status.</div>
	 *
	 * <div class="de">Ruft den Status ab.</div>
	 *
	 * @return the status
	 */
	public ValueSetStatus getStatus() {
		return status;
	}

	/**
	 * <div class="en">Gets the value set entry by code.</div>
	 *
	 * <div class="de">Ruft den Wertesatz-Eintrag anhand seines Codes ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the value set entry by code
	 */
	public ValueSetEntry getValueSetEntryByCode(CodeBaseType value) {
		ValueSetEntry retVal = null;
		for (ValueSetEntry valueSetEntry : valueSetEntryList) {
			if (valueSetEntry.getCodeBaseType().equals(value))
				retVal = valueSetEntry;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the value set entry by mapping code.</div>
	 *
	 * <div class="de">Ruft den Wertesatz-Eintrag anhand des angegebenen
	 * Zuordnungscodes ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the value set entry by mapping code
	 */
	public ValueSetEntry getValueSetEntryByMappingCode(CodeBaseType value) {
		ValueSetEntry retVal = null;
		for (ValueSetEntry valueSetEntry : getValueSetEntryList()) {
			for (CodeBaseType mapping : valueSetEntry.getMappingCodeList()) {
				if (mapping.equals(value))
					retVal = valueSetEntry;
				if (retVal != null)
					break;
			}
			if (retVal != null)
				break;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the value set entry by mapping name.</div>
	 *
	 * <div class="de">Ruft den Wertesatz-Eintrag anhand des angegebenen
	 * Zuordnungsnamenss ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the value set entry by mapping name
	 */
	public ValueSetEntry getValueSetEntryByMappingName(String value) {
		ValueSetEntry retVal = null;
		for (ValueSetEntry valueSetEntry : getValueSetEntryList()) {
			if (value != null)
				if (value.equals(valueSetEntry.getDefaultMappingName()))
					retVal = valueSetEntry;
			if (retVal == null) {
				for (String mapping : valueSetEntry.getMappingNameList()) {
					if (mapping.equals(value))
						retVal = valueSetEntry;
					if (retVal != null)
						break;
				}
			}
			if (retVal != null)
				break;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the value set entry list.</div>
	 *
	 * <div class="de">Ruft die Liste der Wertesatz-Einträge ab.</div>
	 *
	 * @return the value set entry list
	 */
	public ArrayList<ValueSetEntry> getValueSetEntryList() {
		if (valueSetEntryList == null) {
			valueSetEntryList = new ArrayList<ValueSetEntry>();
		}
		return valueSetEntryList;
	}

	/**
	 * <div class="en">Gets the version.</div>
	 *
	 * <div class="de">Ruft die Version ab.</div>
	 *
	 * @return the version
	 */
	public Version getVersion() {
		return version;
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
	 * <div class="en">Sets the description list.</div>
	 *
	 * <div class="de">Legt die Liste der Wertesatz-Einträge fest.</div>
	 *
	 * @param descriptionList
	 *            the new description list
	 */
	public void setDescriptionList(ArrayList<LangText> descriptionList) {
		this.descriptionList = descriptionList;
	}

	/**
	 * <div class="en">Sets the display name.</div>
	 *
	 * <div class="de">Legt den Anzeigenamen fest.</div>
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Sets the effective date.</div>
	 *
	 * <div class="de">Legt den Anzeigenamen fest.</div>
	 *
	 * @param effectiveDate
	 *            the new effective date
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * <div class="en">Sets the identificator.</div>
	 *
	 * <div class="de">Legt den Identifikator fest.</div>
	 *
	 * @param identificator
	 *            the new identificator
	 */
	public void setIdentificator(IdentificatorBaseType identificator) {
		this.identificator = identificator;
	}

	/**
	 * <div class="en">Sets the mapping identificator list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungsidentifikatoren fest.</div>
	 *
	 * @param mappingIdentificatorList
	 *            the new mapping identificator list
	 */
	public void setMappingIdentificatorList(
			ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
		this.mappingIdentificatorList = mappingIdentificatorList;
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
	 * <div class="en">Sets the name.</div>
	 *
	 * <div class="de">Legt den Namen fest.</div>
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <div class="en">Sets the status.</div>
	 *
	 * <div class="de">Setzt den Status.</div>
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(ValueSetStatus status) {
		this.status = status;
	}

	/**
	 * <div class="en">Sets the value set entry list.</div>
	 *
	 * <div class="de">Legt die Liste der Ertesatz-Einträge fest.</div>
	 *
	 * @param valueSetEntryList
	 *            the new value set entry list
	 */
	public void setValueSetEntryList(ArrayList<ValueSetEntry> valueSetEntryList) {
		this.valueSetEntryList = valueSetEntryList;
	}

	/**
	 * <div class="en">Sets the version.</div>
	 *
	 * <div class="de">Legt die Version fest.</div>
	 *
	 * @param version
	 *            the new version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * <div class="en">Sorts the value set entries by their Java Enum
	 * name.</div>
	 *
	 * <div class="de">Sortiert die Wertemengeneinträge nach ihrem
	 * Java-Enum-Namen.</div>
	 *
	 * @return the array list
	 */
	public ArrayList<ValueSetEntry> sortValueSetEntriesByEnumName() {
		if (this.valueSetEntryList == null) {
			this.valueSetEntryList = new ArrayList<ValueSetEntry>();
		}
		this.valueSetEntryList.sort(new ValueSetEntryEnumNameComparator());
		return this.valueSetEntryList;
	}
}
