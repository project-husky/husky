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
import java.util.List;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;

/**
 * The Class ValueSetPackage.
 */
public class ValueSetPackage {

	/**
	 * Builder to build {@link ValueSetPackage}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The mapping identificator list. */
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

		/** The mapping name list. */
		private ArrayList<String> mappingNameList;

		/** The value set list. */
		private ArrayList<ValueSet> valueSetList;

		/** The description. */
		private String description;

		/** The identificator. */
		private IdentificatorBaseType identificator;

		/** The source url. */
		private String sourceUrl;

		/** The status. */
		private ValueSetPackageStatus status;

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
		 * @return the value set package
		 */
		public ValueSetPackage build() {
			return new ValueSetPackage(this);
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
		 * With source url.
		 *
		 * @param sourceUrl
		 *            the source url
		 * @return the builder
		 */
		public Builder withSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
			return this;
		}

		/**
		 * With status.
		 *
		 * @param status
		 *            the status
		 * @return the builder
		 */
		public Builder withStatus(ValueSetPackageStatus status) {
			this.status = status;
			return this;
		}

		/**
		 * With value set list.
		 *
		 * @param valueSetList
		 *            the value set list
		 * @return the builder
		 */
		public Builder withValueSetList(ArrayList<ValueSet> valueSetList) {
			this.valueSetList = valueSetList;
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
	 * Creates builder to build {@link ValueSetPackage}.
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

	/** The value set list. */
	private ArrayList<ValueSet> valueSetList;

	/** The description. */
	private String description;

	/** The identificator. */
	private IdentificatorBaseType identificator;

	/** The source url. */
	private String sourceUrl;

	/** The status. */
	private ValueSetPackageStatus status;

	/** The version. */
	private Version version;

	/**
	 * Instantiates a new value set package. Default constructor.
	 */
	public ValueSetPackage() {
	}

	/**
	 * Instantiates a new value set package.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private ValueSetPackage(Builder builder) {
		this.mappingIdentificatorList = builder.mappingIdentificatorList;
		this.mappingNameList = builder.mappingNameList;
		this.valueSetList = builder.valueSetList;
		this.description = builder.description;
		this.identificator = builder.identificator;
		this.sourceUrl = builder.sourceUrl;
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
	 * Adds the value set.
	 *
	 * @param value
	 *            the value
	 */
	public void addValueSet(ValueSet value) {
		if (this.valueSetList == null) {
			this.valueSetList = new ArrayList<ValueSet>();
		}
		this.valueSetList.add(value);
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
	 * Clear value set list.
	 */
	public void clearValueSetList() {
		this.valueSetList = new ArrayList<ValueSet>();
	}

	/**
	 * Checks whether the to objects are equal (based on their content).
	 *
	 * @param obj
	 *            the obj to compare
	 * @return true, if equal
	 */
	public boolean equals(ValueSetPackage obj) {
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
			for (int i = 0; i < this.valueSetList.size(); i++) {
				retVal = (this.valueSetList.get(i).equals(obj.listValueSets().get(i)));
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
			if (this.identificator == null)
				retVal = (obj.getIdentificator() == null);
			else
				retVal = this.identificator.equals(obj.getIdentificator());
		}
		if (retVal) {
			if (this.sourceUrl == null)
				retVal = (obj.getSourceUrl() == null);
			else
				retVal = this.sourceUrl.equals(obj.getSourceUrl());
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
	 * Gets the source url.
	 *
	 * @return the source url
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ValueSetPackageStatus getStatus() {
		return status;
	}

	/**
	 * Gets the value set list.
	 *
	 * @return the value set list
	 */
	public ArrayList<ValueSet> getValueSetList() {
		return valueSetList;
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
	 * List value sets.
	 *
	 * @return the list
	 */
	public List<ValueSet> listValueSets() {
		if (this.valueSetList == null) {
			this.valueSetList = new ArrayList<ValueSet>();
		}
		return this.valueSetList;
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
	 * Sets the source url.
	 *
	 * @param sourceUrl
	 *            the new source url
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	/**
	 * Sets the source url string.
	 *
	 * @param sourceUrl
	 *            the new source url string
	 */
	public void setSourceUrlString(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(ValueSetPackageStatus status) {
		this.status = status;
	}

	/**
	 * Sets the value set list.
	 *
	 * @param valueSetList
	 *            the new value set list
	 */
	public void setValueSetList(ArrayList<ValueSet> valueSetList) {
		this.valueSetList = valueSetList;
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
