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
package org.projecthusky.valueset.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.LangText;
import org.projecthusky.valueset.enums.ValueSetStatus;

/**
 * 
 * <div class="en">The Class ValueSet is intended to collect all metadata of a
 * value set (such as id, name, version, date ...) and all Entries (codes) of
 * the value set.</div>
 *
 * <div class="de">Die Klasse ValueSet dient zum Sammeln aller Metadaten eines
 * Wertesatzes (wie ID, Name, Version, Datum ...) und aller Einträge (Codes) des
 * Wertesatzes.</div>
 */
public class ValueSet extends ValueSetBase implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSet}.
	 */
	@SuppressWarnings("common-java:DuplicatedBlocks")
	@Generated("SparkTools")
	public static final class Builder {
		private ArrayList<LangText> descriptionList;
		private String displayName;
		private Date effectiveDate;
		private String name;
		private ValueSetStatus status;
		private ArrayList<ValueSetEntry> valueSetEntryList;
		private IdentificatorBaseType identificator;
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;
		private ArrayList<String> mappingNameList;
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

		public Builder withMappingIdentificatorList(ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
			this.mappingIdentificatorList = mappingIdentificatorList;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withMappingNameList(ArrayList<String> mappingNameList) {
			this.mappingNameList = mappingNameList;
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
	 * <div class="en">The Class ValueSetEntryPreferredEnglishDesignationComparator
	 * is intended to sort the value set entries in the same order as the Eclipse
	 * source code sorter will do. This is just to optimize the generated Java code.
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
			else if ((a == null))
				return -1;
			else if ((b == null))
				return 1;
			else {

				var enumConstantNameA = a.getEnumConstantName();
				var enumConstantNameB = b.getEnumConstantName();

				if ((enumConstantNameA == null) && (enumConstantNameB == null))
					return 0;
				else if ((enumConstantNameA == null))
					return -1;
				else if ((enumConstantNameB == null))
					return 1;
				else
					return enumConstantNameA.compareTo(enumConstantNameB);
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
	 * <div class="de">Erstellt einen Java-kompatiblen Enum-Elementnamen aus einer
	 * Zeichenfolge.</div>
	 *
	 * @param displayName The string to build the enum name from.
	 * @return An all upper case string with every non-word character replaced with
	 *         an underscore.
	 * @throws IllegalArgumentException When the provided displayName is null or
	 *                                  empty.
	 */
	public static String buildEnumName(String displayName, int hierarchyLevel) throws IllegalArgumentException {
		if (displayName == null || displayName.trim().isEmpty()) {
			throw new IllegalArgumentException("displayName cannot be null or empty");
		}

		String enumName = displayName.trim().toUpperCase();

		enumName = enumName.replace("CLIENT'S", "CLIENT");
		enumName = enumName.replace("PATIENT'S", "PATIENT");
		enumName = enumName.replace(" (IC)", "");
		enumName = enumName.replace("&AMP;", "AND");
		enumName = enumName.replace("%", "PERCENT");
		enumName = enumName.replace("Μ", "U"); // That's not a 'M', that's an uppercased 'µ'
		enumName = enumName.replace("*", "STAR");
		enumName = enumName.replace("(S)", "");
		enumName = enumName.replace("-", "_");
		enumName = enumName.replaceAll("\\W", "_");
		enumName = enumName.replaceAll("_+", "_");

		if (enumName.endsWith("_")) {
			enumName = enumName.substring(0, enumName.length() - 1);
		}

		// enums starting with a number
		// (e.g. 3 Self-Sustaining Sequence Replication)
		// https://art-decor.org/art-decor/decor-valuesets--cdachvacd-?id=2.16.840.1.113883.1.11.14079&effectiveDate=2014-03-26T00:00:00&language=en-US
		if (enumName.substring(0, 1).matches("[0-9]")) {
			var number = getNumberLiteral(enumName.substring(0, 1));

			number = number.toUpperCase();

			if (enumName.length() > 2) {
				enumName = number + "_" + enumName.substring(2, enumName.length());
			} else {
				enumName = number + "_" + enumName;
			}

		}

		if (hierarchyLevel > 0)
			enumName += "_L" + Integer.toString(hierarchyLevel);

		return enumName;
	}

	/* falsely identified as duplicate code */
	private static String getNumberLiteral(String subString) {
		if ("0".equalsIgnoreCase(subString)) {
			return "Zero";
		} else if ("1".equalsIgnoreCase(subString)) {
			return "One";
		} else if ("2".equalsIgnoreCase(subString)) {
			return "Two";
		} else if ("3".equalsIgnoreCase(subString)) {
			return "Three";
		} else if ("4".equalsIgnoreCase(subString)) {
			return "Four";
		} else if ("5".equalsIgnoreCase(subString)) {
			return "Five";
		} else if ("6".equalsIgnoreCase(subString)) {
			return "Six";
		} else if ("7".equalsIgnoreCase(subString)) {
			return "Seven";
		} else if ("8".equalsIgnoreCase(subString)) {
			return "Eight";
		} else if ("9".equalsIgnoreCase(subString)) {
			return "Nine";
		} else {
			return "";
		}
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
	private List<LangText> descriptionList;

	/** The display name. */
	private String displayName;

	/** The effective date. */
	private Date effectiveDate;

	/** The name. */
	private String name;

	/** The status. */
	private ValueSetStatus status;

	/** The value set entry list. */
	private List<ValueSetEntry> valueSetEntryList;

	/**
	 * <div class="en">Instantiates a new ValueSet. Default constructor.</div>
	 *
	 * <div class="de">Instanziiert ein neues ValueSet. Standardkonstruktor.</div>
	 */
	public ValueSet() {
	}

	@Generated("SparkTools")
	private ValueSet(Builder builder) {
		this.descriptionList = builder.descriptionList;
		this.displayName = builder.displayName;
		this.effectiveDate = builder.effectiveDate;
		this.name = builder.name;
		this.status = builder.status;
		this.valueSetEntryList = builder.valueSetEntryList;

		this.setIdentificator(builder.identificator);
		this.setMappingIdentificatorList(builder.mappingIdentificatorList);
		this.setMappingNameList(builder.mappingNameList);
		this.setVersion(builder.version);
	}

	/**
	 * <div class="en">Adds a description.</div>
	 *
	 * <div class="de">Fügt eine Beschreibung hinzu.</div>
	 *
	 * @param value the value
	 */
	public void addDescription(LangText value) {
		if (this.descriptionList == null)
			this.descriptionList = new ArrayList<>();

		this.descriptionList.add(value);
	}

	private void addEntryList(List<ValueSetEntry> globalList, List<ValueSetEntry> valueSetEntryList) {
		if (valueSetEntryList != null) {
			for (ValueSetEntry valueSetEntry : valueSetEntryList) {
				globalList.add(valueSetEntry);
			}
		}
	}

	private List<ValueSetEntry> addEntryListRecursive(List<ValueSetEntry> globalList,
			List<ValueSetEntry> valueSetEntryList) {
		List<ValueSetEntry> retVal = new ArrayList<>();
		retVal.addAll(globalList);
		if (valueSetEntryList != null) {
			for (ValueSetEntry valueSetEntry : valueSetEntryList) {
				retVal = addEntryToList(globalList, valueSetEntry, retVal);

			}
		}
		return retVal;
	}

	private List<ValueSetEntry> addEntryToList(List<ValueSetEntry> globalList, ValueSetEntry valueSetEntry,
			List<ValueSetEntry> retVal) {
		var isAlreadyThere = false;
		for (ValueSetEntry temp : globalList) {
			isAlreadyThere = (temp.equals(valueSetEntry));
			if (isAlreadyThere)
				break;
		}

		if (!isAlreadyThere)
			retVal.add(valueSetEntry);

		List<ValueSetEntry> children = valueSetEntry.getChildList();
		if (children != null && !children.isEmpty())
			retVal = addEntryListRecursive(retVal, children);

		return retVal;
	}

	/**
	 * <div class="en">Adds a value set entry.</div>
	 *
	 * <div class="de">Fügt einen Wertesatzeintrag hinzu.</div>
	 *
	 * @param value the value
	 */
	public void addValueSetEntry(ValueSetEntry value) {
		if (this.valueSetEntryList == null)
			this.valueSetEntryList = new ArrayList<>();

		this.valueSetEntryList.add(value);
	}

	/**
	 * <div class="en">Clears the description list.</div>
	 *
	 * <div class="de">Löscht die Beschreibungsliste.</div>
	 */
	public void clearDescriptionList() {
		this.valueSetEntryList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the value set entry list.</div>
	 *
	 * <div class="de">Löscht die Wertesatz-Eintragsliste.</div>
	 */
	public void clearValueSetEntryList() {
		this.valueSetEntryList = new ArrayList<>();
	}

	/**
	 * <div class="en">Checks whether the list member contains the given
	 * value.</div>
	 *
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert enthält.</div>
	 * Contains.
	 *
	 * @param value the value
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
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert enthält.</div>
	 * Contains.
	 *
	 * @param value the value
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
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf ihrem
	 * Inhalt).</div>
	 *
	 * @param obj the ValueSet to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof ValueSet))
			return false;

		retVal = compareDescriptionList((ValueSet) obj);

		if (retVal) {
			retVal = compareMappingIdentificatorList((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareMappingNameList((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareValueSetEntryList((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareDisplayName((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareEffectiveDate((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareIdentificator((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareName((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareStatus((ValueSet) obj);
		}
		if (retVal) {
			retVal = compareVersion((ValueSet) obj);
		}
		return retVal;
	}

	private boolean compareStatus(ValueSet obj) {
		var retVal = true;
		if (this.status == null)
			retVal = (obj.getStatus() == null);
		else
			retVal = this.status.equals(obj.getStatus());

		return retVal;
	}

	private boolean compareName(ValueSet obj) {
		var retVal = true;
		if (this.name == null)
			retVal = (obj.getName() == null);
		else
			retVal = this.name.equals(obj.getName());

		return retVal;
	}

	private boolean compareEffectiveDate(ValueSet obj) {
		var retVal = true;
		if (this.effectiveDate == null)
			retVal = obj.getEffectiveDate() == null;
		else
			retVal = this.effectiveDate.equals(obj.getEffectiveDate());

		return retVal;
	}

	private boolean compareDisplayName(ValueSet obj) {
		var retVal = true;
		if (this.displayName == null)
			retVal = (obj.getDisplayName() == null);
		else
			retVal = this.displayName.equals(obj.getDisplayName());

		return retVal;
	}

	private boolean compareValueSetEntryList(ValueSet obj) {
		var retVal = true;
		if (this.valueSetEntryList == null)
			this.valueSetEntryList = new ArrayList<>();
		retVal = (this.valueSetEntryList.size() == obj.getValueSetEntryList().size());
		if (retVal) {
			for (var i = 0; i < this.valueSetEntryList.size(); i++) {
				retVal = obj.containsValueSetEntry(this.valueSetEntryList.get(i));
				if (!retVal)
					break;
			}
		}

		return retVal;
	}

	private boolean compareDescriptionList(ValueSet obj) {
		var retVal = true;
		if (this.descriptionList == null)
			this.descriptionList = new ArrayList<>();
		retVal = (this.descriptionList.size() == obj.getDescriptionList().size());
		if (retVal) {
			for (var i = 0; i < this.descriptionList.size(); i++) {
				retVal = obj.containsDescription(this.descriptionList.get(i));
				if (!retVal)
					break;
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets the description in the given language.</div>
	 *
	 * <div class="de">Ruft die Beschreibung in der angegebenen Sprache ab.</div>
	 *
	 * @param language the language
	 * @return the description
	 */
	public String getDescription(LanguageCode language) {
		String retVal = null;
		if (descriptionList != null) {
			for (var i = 0; i < this.descriptionList.size(); i++) {
				var langText = this.descriptionList.get(i);
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
	public List<LangText> getDescriptionList() {
		if (descriptionList == null) {
			descriptionList = new ArrayList<>();
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
	public List<ValueSetEntry> getSortedEntryList() {
		List<ValueSetEntry> retVal = new ArrayList<>();
		addEntryList(retVal, valueSetEntryList);
		retVal.sort(new ValueSetEntryEnumNameComparator());
		return retVal;
	}

	/**
	 * <div class="en">Gets the sorted entry list. Contains also value set entries
	 * from children.</div>
	 *
	 * <div class="de">Ruft die sortierte Eintragsliste ab. Enthält auch
	 * Werteeinträge von untergeordneten Elementen.</div>
	 *
	 * @return the sorted entry list
	 */
	public List<ValueSetEntry> getSortedEntryListRecursive() {
		List<ValueSetEntry> retVal = new ArrayList<>();
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
	 * @param value the value
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
	 * @param value the value
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
	 * @param value the value
	 * @return the value set entry by mapping name
	 */
	public ValueSetEntry getValueSetEntryByMappingName(String value) {
		ValueSetEntry retVal = null;
		for (ValueSetEntry valueSetEntry : getValueSetEntryList()) {
			if (value != null && value.equals(valueSetEntry.getDefaultMappingName()))
				retVal = valueSetEntry;
			if (retVal == null) {
				retVal = getValueSetEntryBySingleMappingName(valueSetEntry, value);
			}
			if (retVal != null)
				break;
		}
		return retVal;
	}

	private ValueSetEntry getValueSetEntryBySingleMappingName(ValueSetEntry valueSetEntry, String value) {
		ValueSetEntry retVal = null;
		for (String mapping : valueSetEntry.getMappingNameList()) {
			if (mapping.equals(value))
				retVal = valueSetEntry;
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
	public List<ValueSetEntry> getValueSetEntryList() {
		if (valueSetEntryList == null) {
			valueSetEntryList = new ArrayList<>();
		}
		return valueSetEntryList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getVersion()).append(this.status).append(this.name)
				.append(this.getIdentificator()).append(this.effectiveDate).append(this.displayName)
				.append(this.valueSetEntryList).append(this.getMappingNameList())
				.append(this.getMappingIdentificatorList())
				.append(this.descriptionList).toHashCode();
	}

	/**
	 * <div class="en">Sets the description list.</div>
	 *
	 * <div class="de">Legt die Liste der Wertesatz-Einträge fest.</div>
	 *
	 * @param descriptionList the new description list
	 */
	public void setDescriptionList(List<LangText> descriptionList) {
		this.descriptionList = descriptionList;
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
	 * <div class="en">Sets the effective date.</div>
	 *
	 * <div class="de">Legt den Anzeigenamen fest.</div>
	 *
	 * @param effectiveDate the new effective date
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * <div class="en">Sets the name.</div>
	 *
	 * <div class="de">Legt den Namen fest.</div>
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <div class="en">Sets the status.</div>
	 *
	 * <div class="de">Setzt den Status.</div>
	 *
	 * @param status the new status
	 */
	public void setStatus(ValueSetStatus status) {
		this.status = status;
	}

	/**
	 * <div class="en">Sets the value set entry list.</div>
	 *
	 * <div class="de">Legt die Liste der Ertesatz-Einträge fest.</div>
	 *
	 * @param valueSetEntryList the new value set entry list
	 */
	public void setValueSetEntryList(List<ValueSetEntry> valueSetEntryList) {
		this.valueSetEntryList = valueSetEntryList;
	}

	/**
	 * <div class="en">Sorts the value set entries by their Java Enum name.</div>
	 *
	 * <div class="de">Sortiert die Wertemengeneinträge nach ihrem
	 * Java-Enum-Namen.</div>
	 *
	 * @return the array list
	 */
	public List<ValueSetEntry> sortValueSetEntriesByEnumName() {
		if (this.valueSetEntryList == null) {
			this.valueSetEntryList = new ArrayList<>();
		}
		this.valueSetEntryList.sort(new ValueSetEntryEnumNameComparator());
		return this.valueSetEntryList;
	}
}
