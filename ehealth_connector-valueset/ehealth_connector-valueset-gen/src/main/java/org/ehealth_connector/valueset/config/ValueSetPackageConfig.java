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

import java.net.MalformedURLException;
import java.net.URL;
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

		/** The description. */
		private String description;

		/** The identificator. */
		private IdentificatorBaseType identificator;

		/** The status. */
		private ValueSetPackageStatus status;

		/** The version. */
		private Version version;

		/** The source url. */
		private URL sourceUrl;

		/** The value set config list. */
		private ArrayList<ValueSetConfig> valueSetConfigList;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the value set package config
		 */
		public ValueSetPackageConfig build() {
			return new ValueSetPackageConfig(this);
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
		 * With source url.
		 *
		 * @param sourceUrl
		 *            the source url
		 * @return the builder
		 */
		public Builder withSourceUrl(URL sourceUrl) {
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
		 * With value set config list.
		 *
		 * @param valueSetConfigList
		 *            the value set config list
		 * @return the builder
		 */
		public Builder withValueSetConfigList(ArrayList<ValueSetConfig> valueSetConfigList) {
			this.valueSetConfigList = valueSetConfigList;
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
	private URL sourceUrl;

	/** The value set config list. */
	private ArrayList<ValueSetConfig> valueSetConfigList;

	/**
	 * Instantiates a new value set package config.
	 *
	 * @param builder
	 *            the builder
	 */
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

	/**
	 * Gets the source url.
	 *
	 * @return the source url
	 */
	public URL getSourceUrl() {
		return sourceUrl;
	}

	/**
	 * Gets the source url string.
	 *
	 * @return the source url string
	 */
	public String getSourceUrlString() {
		return sourceUrl.toString();
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
	public List<ValueSetConfig> listValueSetConfigs() {
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

	/**
	 * Sets the source url.
	 *
	 * @param sourceUrl
	 *            the new source url
	 */
	public void setSourceUrl(URL sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	/**
	 * Sets the source url string.
	 *
	 * @param sourceUrl
	 *            the new source url string
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	public void setSourceUrlString(String sourceUrl) throws MalformedURLException {
		URL url = new URL(sourceUrl);
		this.sourceUrl = url;
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
