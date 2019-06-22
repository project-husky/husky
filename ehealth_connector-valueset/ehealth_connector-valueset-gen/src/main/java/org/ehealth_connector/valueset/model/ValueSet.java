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
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
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

		/** The description. */
		private String description;

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
		 * With description.
		 *
		 * @param description
		 *            the description
		 * @return the builder
		 */
		public Builder withDescription(String description) {
			this.description = description;
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

	/** The description. */
	private String description;

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
		this.description = builder.description;
		this.displayName = builder.displayName;
		this.effectiveDate = builder.effectiveDate;
		this.identificator = builder.identificator;
		this.name = builder.name;
		this.status = builder.status;
		this.version = builder.version;
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
			if (this.description == null)
				retVal = (obj.getDescription() == null);
			else
				retVal = this.description.equals(obj.getDescription());
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
		// TODO
		return null;
	}

	/**
	 * Gets the value set entry by mapping name.
	 *
	 * @param value
	 *            the value
	 * @return the value set entry by mapping name
	 */
	public ValueSetEntry getValueSetEntryByMappingName(String value) {
		// TODO
		return null;
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
	 * List mapping identificators.
	 *
	 * @return the list
	 */
	public List<IdentificatorBaseType> listMappingIdentificators() {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		return mappingIdentificatorList;
	}

	/**
	 * List mapping names.
	 *
	 * @return the list
	 */
	public List<String> listMappingNames() {
		if (this.mappingNameList == null) {
			this.mappingNameList = new ArrayList<String>();
		}
		return this.mappingNameList;
	}

	/**
	 * List value set entries.
	 *
	 * @return the list
	 */
	public List<ValueSetEntry> listValueSetEntries() {
		if (this.valueSetEntryList == null) {
			this.valueSetEntryList = new ArrayList<ValueSetEntry>();
		}
		return this.valueSetEntryList;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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

}
