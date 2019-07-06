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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.enums.DesignationType;
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
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the value set
		 */
		public ValueSet build() {
			return new ValueSet(this);
		}

		/**
		 * With description list.
		 *
		 * @param descriptionList
		 *            the description list
		 * @return the builder
		 */
		public Builder withDescriptionList(ArrayList<LangText> descriptionList) {
			this.descriptionList = descriptionList;
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
		 * With effective date.
		 *
		 * @param effectiveDate
		 *            the effective date
		 * @return the builder
		 */
		public Builder withEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate;
			return this;
		}

		/**
		 * With identificator.
		 *
		 * @param identificator
		 *            the identificator
		 * @return the builder
		 */
		public Builder withIdentificator(IdentificatorBaseType identificator) {
			this.identificator = identificator;
			return this;
		}

		/**
		 * With mapping identificator list.
		 *
		 * @param mappingIdentificatorList
		 *            the mapping identificator list
		 * @return the builder
		 */
		public Builder withMappingIdentificatorList(
				ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
			this.mappingIdentificatorList = mappingIdentificatorList;
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
		 * With status.
		 *
		 * @param status
		 *            the status
		 * @return the builder
		 */
		public Builder withStatus(ValueSetStatus status) {
			this.status = status;
			return this;
		}

		/**
		 * With value set entry list.
		 *
		 * @param valueSetEntryList
		 *            the value set entry list
		 * @return the builder
		 */
		public Builder withValueSetEntryList(ArrayList<ValueSetEntry> valueSetEntryList) {
			this.valueSetEntryList = valueSetEntryList;
			return this;
		}

		/**
		 * With version.
		 *
		 * @param version
		 *            the version
		 * @return the builder
		 */
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

				String enumConstantName_a = ValueSet
						.buildEnumName(a.getCodeBaseType().getDisplayName());
				String preferredDesignation_a = a.getDesignation(LanguageCode.ENGLISH,
						DesignationType.PREFERRED);
				if (preferredDesignation_a != null)
					enumConstantName_a = ValueSet.buildEnumName(preferredDesignation_a);

				String enumConstantName_b = ValueSet
						.buildEnumName(b.getCodeBaseType().getDisplayName());
				String preferredDesignation_b = b.getDesignation(LanguageCode.ENGLISH,
						DesignationType.PREFERRED);
				if (preferredDesignation_b != null)
					enumConstantName_b = ValueSet.buildEnumName(preferredDesignation_b);

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
	public static String buildEnumName(String displayName) throws IllegalArgumentException {
		if (displayName == null || displayName.trim().isEmpty()) {
			throw new IllegalArgumentException("displayName cannot be null or empty");
		}

		String enumName = displayName.trim().toUpperCase();

		enumName = enumName.replaceAll("CLIENT'S", "CLIENT");
		enumName = enumName.replaceAll("PATIENT'S", "PATIENT");
		enumName = enumName.replaceAll(" \\(IC\\)", "");

		enumName = enumName.replaceAll("&AMP;", "AND");

		enumName = enumName.replaceAll("\\W", "_");

		while (enumName.contains("__"))
			enumName = enumName.replaceAll("__", "_");

		while (enumName.endsWith("_"))
			enumName = enumName.substring(0, enumName.length() - 1);

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

	/**
	 * Instantiates a new value set.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private ValueSet(Builder builder) {
		this.mappingIdentificatorList = builder.mappingIdentificatorList;
		this.mappingNameList = builder.mappingNameList;
		this.valueSetEntryList = builder.valueSetEntryList;
		this.descriptionList = builder.descriptionList;
		this.displayName = builder.displayName;
		this.effectiveDate = builder.effectiveDate;
		this.identificator = builder.identificator;
		this.name = builder.name;
		this.status = builder.status;
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
	public boolean equals(ValueSet obj) {
		boolean retVal = true;
		if (retVal) {
			if (this.descriptionList == null)
				this.descriptionList = new ArrayList<LangText>();
			for (int i = 0; i < this.descriptionList.size(); i++) {
				retVal = obj.listDescriptions().contains(this.descriptionList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.mappingIdentificatorList == null)
				this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
			for (int i = 0; i < this.mappingIdentificatorList.size(); i++) {
				retVal = obj.listMappingIdentificators()
						.contains(this.mappingIdentificatorList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.mappingNameList == null)
				this.mappingNameList = new ArrayList<String>();
			for (int i = 0; i < this.mappingNameList.size(); i++) {
				retVal = obj.listMappingNames().contains(this.mappingNameList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.valueSetEntryList == null)
				this.valueSetEntryList = new ArrayList<ValueSetEntry>();
			for (int i = 0; i < this.valueSetEntryList.size(); i++) {
				retVal = obj.listValueSetEntries().contains(this.valueSetEntryList.get(i));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			if (this.displayName == null)
				retVal = (obj.getDisplayName() == null);
			else
				retVal = this.displayName.equals(obj.getDisplayName());
		}
		if (retVal) {
			if (this.effectiveDate == null)
				retVal = (obj.getEffectiveDate() == null);
			else
				retVal = this.effectiveDate.equals(obj.getEffectiveDate());
		}
		if (retVal) {
			if (this.identificator == null)
				retVal = (obj.getIdentificator() == null);
			else
				retVal = this.identificator.equals(obj.getIdentificator());
		}
		if (retVal) {
			if (this.name == null)
				retVal = (obj.getName() == null);
			else
				retVal = this.name.equals(obj.getName());
		}
		if (retVal) {
			if (this.status == null)
				retVal = (obj.getStatus() == null);
			else
				retVal = this.status.equals(obj.getStatus());
		}
		if (retVal) {
			if (this.version == null)
				retVal = (obj.getVersion() == null);
			else
				retVal = this.version.equals(obj.getVersion());
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
			if (valueSetEntry.getCodeBaseType() == value)
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
		for (ValueSetEntry valueSetEntry : listValueSetEntries()) {
			if (valueSetEntry.listMappingCodes().contains(value))
				retVal = valueSetEntry;
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
		for (ValueSetEntry valueSetEntry : listValueSetEntries()) {
			if (valueSetEntry.listMappingNames().contains(value))
				retVal = valueSetEntry;
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
	 * <div class="en">Gets the list of descriptions.</div>
	 *
	 * <div class="de">Ruft die Liste der Beschreibungen ab.</div>
	 *
	 * @return the array list
	 */
	public ArrayList<LangText> listDescriptions() {
		if (this.descriptionList == null) {
			this.descriptionList = new ArrayList<LangText>();
		}
		return this.descriptionList;
	}

	/**
	 * <div class="en">Gets the list of mapping identificators.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungskennungen ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<IdentificatorBaseType> listMappingIdentificators() {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		return mappingIdentificatorList;
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
	 * <div class="en">Gets the list of value set entries.</div>
	 *
	 * <div class="de">Ruft die Liste der Wertesatz-Einträge ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<ValueSetEntry> listValueSetEntries() {
		if (this.valueSetEntryList == null) {
			this.valueSetEntryList = new ArrayList<ValueSetEntry>();
		}
		return this.valueSetEntryList;
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
