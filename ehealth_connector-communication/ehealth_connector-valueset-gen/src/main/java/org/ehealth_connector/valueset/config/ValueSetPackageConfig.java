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
package org.ehealth_connector.valueset.config;

import java.util.ArrayList;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.model.Version;

/**
 * <div class="en">The Class ValueSetPackageConfig contains all relevant
 * information (the configuration) for the ValueSetPackageManager.</div>
 *
 * <div class="de">Die Klasse ValueSetPackageConfig enthält alle relevanten
 * Informationen (die Konfiguration) für den ValueSetPackageManager.</div>
 */
public class ValueSetPackageConfig {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSetPackageConfig}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The description. */
		private String description;

		/** The identificator. */
		private IdentificatorBaseType identificator;

		/** The source url. */
		private String sourceUrl;

		/** The status. */
		private ValueSetPackageStatus status;

		/** The value set config list. */
		private ArrayList<ValueSetConfig> valueSetConfigList;

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

	/** The source url. */
	private String sourceUrl;

	/** The status. */
	private ValueSetPackageStatus status;

	/** The value set config list. */
	private ArrayList<ValueSetConfig> valueSetConfigList;

	/** The version. */
	private Version version;

	/**
	 * <div class="en">Instantiates a new ValueSetPackageConfig. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert eine neue ValueSetPackageConfig.
	 * Standardkonstruktor.</div>
	 */
	public ValueSetPackageConfig() {
	}

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
	 * <div class="en">Adds a value set configuration.</div>
	 *
	 * <div class="de">Fügt eine Wertesatzkonfiguration hinzu.</div>
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
	 * <div class="en">Gets the description.</div>
	 *
	 * <div class="de">Ruft die Beschreibung ab.</div>
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * <div class="en">Gets the source url, where to download the
	 * ValueSetPackage configuration.</div>
	 *
	 * <div class="de">Ruft die Quell-URL ab, wo die
	 * ValueSetPackage-Konfiguration heruntergeladen werden kann.</div>
	 *
	 * @return the source url
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}

	/**
	 * <div class="en">Gets the status.</div>
	 *
	 * <div class="de">Ruft den Status ab.</div>
	 *
	 * @return the status
	 */
	public ValueSetPackageStatus getStatus() {
		return status;
	}

	/**
	 * <div class="en">Gets the value set config list.</div>
	 *
	 * <div class="de">Ruft die Wertesatz-Konfigurationsliste ab.</div>
	 *
	 * @return the value set config list
	 */
	public ArrayList<ValueSetConfig> getValueSetConfigList() {
		if (valueSetConfigList == null) {
			valueSetConfigList = new ArrayList<ValueSetConfig>();
		}
		return valueSetConfigList;
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

	/**
	 * <div class="en">Sets the description.</div>
	 *
	 * <div class="de">Legt die Beschreibung fest.</div>
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * <div class="en">Sets the source url, where the ValueSetPackage
	 * configuration can be downloaded.</div>
	 *
	 * <div class="de">Legt die Quell-URL fest, wo die
	 * ValueSetPackage-Konfiguration heruntergeladen werden kann.</div>
	 *
	 * @param sourceUrl
	 *            the new source url
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	/**
	 * <div class="en">Sets the Status.</div>
	 *
	 * <div class="de">Legt den Status fest.</div>
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(ValueSetPackageStatus status) {
		this.status = status;
	}

	/**
	 * <div class="en">Sets the value set config list.</div>
	 *
	 * <div class="de">Legt die Liste der Wertesatz-Konfigurationen fest.</div>
	 *
	 * @param valueSetConfigList
	 *            the new value set config list
	 */
	public void setValueSetConfigList(ArrayList<ValueSetConfig> valueSetConfigList) {
		this.valueSetConfigList = valueSetConfigList;
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

}
