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
package org.ehealth_connector.valueset.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.model.Version;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueSetPackageConfig contains all relevant information (the
 * configuration) for the ValueSetPackageManager.
 */
public class ValueSetPackageConfig {

	/**
	 * Builder to build {@link ValueSetPackageConfig}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String description;
		private IdentificatorBaseType identificator;
		private ValueSetPackageStatus status;
		private Version version;
		private String sourceUrl;
		private ArrayList<ValueSetConfig> valueSetConfigList;

		private Builder() {
		}

		public ValueSetPackageConfig build() {
			return new ValueSetPackageConfig(this);
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withIdentificator(IdentificatorBaseType identificator) {
			this.identificator = identificator;
			return this;
		}

		public Builder withSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
			return this;
		}

		public Builder withStatus(ValueSetPackageStatus status) {
			this.status = status;
			return this;
		}

		public Builder withValueSetConfigList(ArrayList<ValueSetConfig> valueSetConfigList) {
			this.valueSetConfigList = valueSetConfigList;
			return this;
		}

		public Builder withVersion(Version version) {
			this.version = version;
			return this;
		}
	}

	/**
	 * Creates builder to build {@link ValueSetPackageConfig}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The description. */
	private String description;

	/** The identificator. */
	private IdentificatorBaseType identificator;

	/** The status. */
	private ValueSetPackageStatus status;

	/** The version. */
	private Version version;

	/** The source url. */
	private String sourceUrl;

	/** The value set config list. */
	private ArrayList<ValueSetConfig> valueSetConfigList;

	public ValueSetPackageConfig() {
	}

	@Generated("SparkTools")
	private ValueSetPackageConfig(Builder builder) {
		this.description = builder.description;
		this.identificator = builder.identificator;
		this.status = builder.status;
		this.version = builder.version;
		this.sourceUrl = builder.sourceUrl;
		this.valueSetConfigList = builder.valueSetConfigList;
	}

	/**
	 * Adds the value set config.
	 *
	 * @param value
	 *            the value
	 */
	public void addValueSetConfig(ValueSetConfig value) {
		if (this.valueSetConfigList == null) {
			this.valueSetConfigList = new ArrayList<ValueSetConfig>();
		}
		this.valueSetConfigList.add(value);

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
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * List value set configs.
	 *
	 * @return the list
	 */
	public List<ValueSetConfig> listValueSetConfig() {
		if (this.valueSetConfigList == null) {
			this.valueSetConfigList = new ArrayList<ValueSetConfig>();
		}
		return this.valueSetConfigList;

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

	public void setSourceUrl(String sourceUrl) {
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
	 * Sets the version.
	 *
	 * @param version
	 *            the new version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}

}
