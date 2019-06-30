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
import java.util.Comparator;
import java.util.Date;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.ehealth_connector.valueset.enums.ValueSetStatus;

/**
 * The Class ValueSet.
 */
public class ValueSet {

	/**
	 * Builder to build {@link ValueSet}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The mapping identificator list. */
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

		/** The mapping name list. */
		private ArrayList<String> mappingNameList;

		/** The value set entry list. */
		private ArrayList<ValueSetEntry> valueSetEntryList;

		/** The description list. */
		private ArrayList<LangText> descriptionList;

		/** The display name. */
		private String displayName;

		/** The effective date. */
		private Date effectiveDate;

		/** The identificator. */
		private IdentificatorBaseType identificator;

		/** The name. */
		private String name;

		/** The status. */
		private ValueSetStatus status;

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
	 * The Class ValueSetEntryPreferredEnglishDesignationComparator.
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
	 * <div class="en">Builds a Java compatible enum element name from a
	 * string.</div>
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

	/** The mapping identificator list. */
	private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

	/** The mapping name list. */
	private ArrayList<String> mappingNameList;

	/** The value set entry list. */
	private ArrayList<ValueSetEntry> valueSetEntryList;

	/** The description list. */
	private ArrayList<LangText> descriptionList;

	/** The display name. */
	private String displayName;

	/** The effective date. */
	private Date effectiveDate;

	/** The identificator. */
	private IdentificatorBaseType identificator;

	/** The name. */
	private String name;

	/** The status. */
	private ValueSetStatus status;

	/** The version. */
	private Version version;

	/**
	 * Instantiates a new value set. Default constructor.
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
	 * Adds the description.
	 *
	 * @param value
	 *            the value
	 */
	public void addDescription(LangText value) {
		if (this.descriptionList == null) {
			this.descriptionList = new ArrayList<LangText>();
		}
		this.descriptionList.add(value);
	}

	/**
	 * Adds the mapping identificator.
	 *
	 * @param value
	 *            the value
	 */
	public void addMappingIdentificator(IdentificatorBaseType value) {
		if (this.mappingIdentificatorList == null) {
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		}
		this.mappingIdentificatorList.add(value);
	}

	/**
	 * Adds the mapping name.
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
	 * Adds the value set entry.
	 *
	 * @param value
	 *            the value
	 */
	public void addValueSetEntry(ValueSetEntry value) {
		if (this.valueSetEntryList == null) {
			this.valueSetEntryList = new ArrayList<ValueSetEntry>();
		}
		this.valueSetEntryList.add(value);
	}

	/**
	 * Clear description list.
	 */
	public void clearDescriptionList() {
		this.valueSetEntryList = new ArrayList<ValueSetEntry>();
	}

	/**
	 * Clear mapping identificator list.
	 */
	public void clearMappingIdentificatorList() {
		this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
	}

	/**
	 * Clear mapping name list.
	 */
	public void clearMappingNameList() {
		this.mappingNameList = new ArrayList<String>();
	}

	/**
	 * Clear value set entry list.
	 */
	public void clearValueSetEntryList() {
		this.valueSetEntryList = new ArrayList<ValueSetEntry>();
	}

	/**
	 * Checks whether the to objects are equal (based on their content).
	 *
	 * @param obj
	 *            the obj to compare
	 * @return true, if equal
	 */
	public boolean equals(ValueSet obj) {
		boolean retVal = true;
		if (retVal) {
			for (int i = 0; i < this.mappingIdentificatorList.size(); i++) {
				retVal = (this.mappingIdentificatorList.get(i)
						.equals(obj.listMappingIdentificators().get(i)));
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
			for (int i = 0; i < this.valueSetEntryList.size(); i++) {
				retVal = (this.valueSetEntryList.get(i).equals(obj.listValueSetEntries().get(i)));
				if (!retVal)
					break;
			}
		}
		if (retVal) {
			for (int i = 0; i < this.descriptionList.size(); i++) {
				retVal = (this.descriptionList.get(i).equals(obj.listDescriptions().get(i)));
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
	 * Gets the description in the given language.
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
	 * Gets the description list.
	 *
	 * @return the description list
	 */
	public ArrayList<LangText> getDescriptionList() {
		return descriptionList;
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
	 * Gets the effective date.
	 *
	 * @return the effective date
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Gets the identificator.
	 *
	 * @return the identificator
	 */
	public IdentificatorBaseType getIdentificator() {
		return identificator;
	}

	/**
	 * Gets the mapping identificator list.
	 *
	 * @return the mapping identificator list
	 */
	public ArrayList<IdentificatorBaseType> getMappingIdentificatorList() {
		return mappingIdentificatorList;
	}

	/**
	 * Gets the mapping name list.
	 *
	 * @return the mapping name list
	 */
	public ArrayList<String> getMappingNameList() {
		return mappingNameList;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ValueSetStatus getStatus() {
		return status;
	}

	/**
	 * Gets the value set entry by code.
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
	 * Gets the value set entry by mapping code.
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
	 * Gets the value set entry by mapping name.
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
	 * Gets the value set entry list.
	 *
	 * @return the value set entry list
	 */
	public ArrayList<ValueSetEntry> getValueSetEntryList() {
		return valueSetEntryList;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * List descriptions.
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
	 * ArrayList mapping identificators.
	 *
	 * @return the list
	 */
	public ArrayList<IdentificatorBaseType> listMappingIdentificators() {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		return mappingIdentificatorList;
	}

	/**
	 * ArrayList mapping names.
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
	 * ArrayList value set entries.
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
	 * Sets the description list.
	 *
	 * @param descriptionList
	 *            the new description list
	 */
	public void setDescriptionList(ArrayList<LangText> descriptionList) {
		this.descriptionList = descriptionList;
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
	 * Sets the effective date.
	 *
	 * @param effectiveDate
	 *            the new effective date
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Sets the identificator.
	 *
	 * @param identificator
	 *            the new identificator
	 */
	public void setIdentificator(IdentificatorBaseType identificator) {
		this.identificator = identificator;
	}

	/**
	 * Sets the mapping identificator list.
	 *
	 * @param mappingIdentificatorList
	 *            the new mapping identificator list
	 */
	public void setMappingIdentificatorList(
			ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
		this.mappingIdentificatorList = mappingIdentificatorList;
	}

	/**
	 * Sets the mapping name list.
	 *
	 * @param mappingNameList
	 *            the new mapping name list
	 */
	public void setMappingNameList(ArrayList<String> mappingNameList) {
		this.mappingNameList = mappingNameList;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(ValueSetStatus status) {
		this.status = status;
	}

	/**
	 * Sets the value set entry list.
	 *
	 * @param valueSetEntryList
	 *            the new value set entry list
	 */
	public void setValueSetEntryList(ArrayList<ValueSetEntry> valueSetEntryList) {
		this.valueSetEntryList = valueSetEntryList;
	}

	/**
	 * Sets the version.
	 *
	 * @param version
	 *            the new version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

	/**
	 * Sort value set entries by preferred English designation.
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
