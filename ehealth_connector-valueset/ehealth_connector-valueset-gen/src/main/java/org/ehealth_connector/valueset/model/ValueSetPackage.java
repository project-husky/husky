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

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;

/**
 * <div class="en">The Class ValueSetPackage is intended to contain all
 * information about a package of multiple value sets.</div>
 *
 * <div class="de">Die Klasse ValueSetPackage dient zum Sammeln aller
 * Informationen zu einem Paket mit mehreren Wertesätzen.</div>
 */
public class ValueSetPackage {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSetPackage}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The description. */
		private String description;

		/** The identificator. */
		private IdentificatorBaseType identificator;

		/** The mapping identificator list. */
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

		/** The mapping name list. */
		private ArrayList<String> mappingNameList;

		/** The source url. */
		private String sourceUrl;

		/** The status. */
		private ValueSetPackageStatus status;

		/** The value set list. */
		private ArrayList<ValueSet> valueSetList;

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

	/** The description. */
	private String description;

	/** The identificator. */
	private IdentificatorBaseType identificator;

	/** The mapping identificator list. */
	private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

	/** The mapping name list. */
	private ArrayList<String> mappingNameList;

	/** The source url. */
	private String sourceUrl;

	/** The status. */
	private ValueSetPackageStatus status;

	/** The value set list. */
	private ArrayList<ValueSet> valueSetList;

	/** The version. */
	private Version version;

	/**
	 * <div class="en">Instantiates a new ValueSetPackage. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert ein neues ValueSetPackage.
	 * Standardkonstruktor.</div>
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
	 * <div class="en">Instantiates a new value set package from its
	 * config.</div>
	 *
	 * <div class="de">Instanziiert ein neues Wertesatzpaket aus seiner
	 * Konfiguration.</div>
	 */
	public ValueSetPackage(ValueSetPackageConfig valueSetPackageConfig) {

		// initialize the ValueSet List, but it can't actually be filled from
		// the config
		if (valueSetPackageConfig.getValueSetConfigList().size() > 0)
			this.valueSetList = new ArrayList<ValueSet>();

		this.description = valueSetPackageConfig.getDescription();
		this.identificator = valueSetPackageConfig.getIdentificator();
		this.sourceUrl = valueSetPackageConfig.getSourceUrl();
		this.status = valueSetPackageConfig.getStatus();
		this.version = valueSetPackageConfig.getVersion();
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
		if (this.mappingIdentificatorList == null) {
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		}
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
		if (this.mappingNameList == null) {
			this.mappingNameList = new ArrayList<String>();
		}
		this.mappingNameList.add(value);
	}

	/**
	 * <div class="en">Adds a value set.</div>
	 *
	 * <div class="de">Fügt einen Wertesatz hinzu.</div>
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
	 * <div class="en">Clears the value set list.</div>
	 *
	 * <div class="de">Löscht die Wertesatzliste.</div>
	 */
	public void clearValueSetList() {
		this.valueSetList = new ArrayList<ValueSet>();
	}

	/**
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the ValueSetPackage to compare
	 * @return true, if equal; false otherwise.
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
	 * <div class="en">Gets the mapping identificator list.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungskennungen ab.</div>
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
	 * <div class="en">Gets the source url (where to get the package).</div>
	 *
	 * <div class="de">Ruft die Quell-URL ab (woher das Paket stammt)</div>
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
	 * <div class="en">Gets the value set list.</div>
	 *
	 * <div class="de">Ruft die Wertesatzliste ab.</div>
	 *
	 * @return the value set list
	 */
	public ArrayList<ValueSet> getValueSetList() {
		return valueSetList;
	}

	/**
	 * <div class="en">Gets a value set by mapping identificator.</div>
	 *
	 * <div class="de">Ruft einen Wertesatz anhand des angegebenen
	 * Zuordnungscodes ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the value sety by mapping identificator
	 */
	public ValueSet getValueSetyByMappingIdentificator(IdentificatorBaseType value) {
		ValueSet retVal = null;
		for (ValueSet valueSet : listValueSets()) {
			if (valueSet.listMappingIdentificators().contains(value))
				retVal = valueSet;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the value set by mapping name.</div>
	 *
	 * <div class="de">Ruft einen Wertesatz anhand des angegebenen
	 * Zuordnungsnamens ab.</div>
	 *
	 * @param value
	 *            the value
	 * @return the value sety by mapping name
	 */
	public ValueSet getValueSetyByMappingName(String value) {
		ValueSet retVal = null;
		for (ValueSet valueSet : listValueSets()) {
			if (valueSet.listMappingNames().contains(value))
				retVal = valueSet;
		}
		return retVal;
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
	 * <div class="en">Gets the list of mapping identificators.</div>
	 *
	 * <div class="de">Ruft die Liste der Zuordnungsidentifikatoren ab.</div>
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
	 * <div class="en">Gets the list of value sets.</div>
	 *
	 * <div class="de">Ruft die Liste der Wertesätze ab.</div>
	 *
	 * @return the list
	 */
	public ArrayList<ValueSet> listValueSets() {
		if (this.valueSetList == null) {
			this.valueSetList = new ArrayList<ValueSet>();
		}
		return this.valueSetList;
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
	 * <div class="en">Sets the source url (where to get the package).</div>
	 *
	 * <div class="de">Legt die Quell-URL fest (wo das Paket abgeholt werden
	 * kann).</div>
	 *
	 * @param sourceUrl
	 *            the new source url
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	/**
	 * <div class="en">Sets the status.</div>
	 *
	 * <div class="de">Setzt den Status.</div>
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(ValueSetPackageStatus status) {
		this.status = status;
	}

	/**
	 * <div class="en">Sets the value set list.</div>
	 *
	 * <div class="de">Legt die Wertesatzliste fest.</div>
	 *
	 * @param valueSetList
	 *            the new value set list
	 */
	public void setValueSetList(ArrayList<ValueSet> valueSetList) {
		this.valueSetList = valueSetList;
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
