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
package org.husky.valueset.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.utils.Util;
import org.husky.valueset.config.ValueSetPackageConfig;
import org.husky.valueset.enums.ValueSetPackageStatus;

/**
 * <div class="en">The Class ValueSetPackage is intended to contain all
 * information about a package of multiple value sets.</div>
 *
 * <div class="de">Die Klasse ValueSetPackage dient zum Sammeln aller
 * Informationen zu einem Paket mit mehreren Wertesätzen.</div>
 */
public class ValueSetPackage implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSetPackage}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String description;
		private IdentificatorBaseType identificator;
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;
		private ArrayList<String> mappingNameList;
		private String sourceUrl;
		private ValueSetPackageStatus status;
		private ArrayList<ValueSet> valueSetList;
		private Version version;

		private Builder() {
		}

		public ValueSetPackage build() {
			return new ValueSetPackage(this);
		}

		public Builder withDescription(String description) {
			this.description = description;
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

		public Builder withMappingNameList(ArrayList<String> mappingNameList) {
			this.mappingNameList = mappingNameList;
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

		public Builder withValueSetList(ArrayList<ValueSet> valueSetList) {
			this.valueSetList = valueSetList;
			return this;
		}

		public Builder withVersion(Version version) {
			this.version = version;
			return this;
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -3720393996655001381L;

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
	private List<IdentificatorBaseType> mappingIdentificatorList;

	/** The mapping name list. */
	private List<String> mappingNameList;

	/** The source url. */
	private String sourceUrl;

	/** The status. */
	private ValueSetPackageStatus status;

	/** The value set list. */
	private List<ValueSet> valueSetList;

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

	@Generated("SparkTools")
	private ValueSetPackage(Builder builder) {
		this.description = builder.description;
		this.identificator = builder.identificator;
		this.mappingIdentificatorList = builder.mappingIdentificatorList;
		this.mappingNameList = builder.mappingNameList;
		this.sourceUrl = builder.sourceUrl;
		this.status = builder.status;
		this.valueSetList = builder.valueSetList;
		this.version = builder.version;
	}

	/**
	 * <div class="en">Instantiates a new value set package from its config.</div>
	 *
	 * <div class="de">Instanziiert ein neues Wertesatzpaket aus seiner
	 * Konfiguration.</div>
	 */
	public ValueSetPackage(ValueSetPackageConfig valueSetPackageConfig) {

		// initialize the ValueSet List, but it can't actually be filled from
		// the config
		if (!valueSetPackageConfig.getValueSetConfigList().isEmpty())
			this.valueSetList = new ArrayList<>();

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
	 * @param value the value
	 */
	public void addMappingIdentificator(IdentificatorBaseType value) {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<>();

		this.mappingIdentificatorList.add(value);
	}

	/**
	 * <div class="en">Adds a mapping name.</div>
	 *
	 * <div class="de">Fügt einen Zuordnungsnamen hinzu.</div>
	 *
	 * @param value the value
	 */
	public void addMappingName(String value) {
		if (this.mappingNameList == null)
			this.mappingNameList = new ArrayList<>();

		this.mappingNameList.add(value);
	}

	/**
	 * <div class="en">Adds a value set.</div>
	 *
	 * <div class="de">Fügt einen Wertesatz hinzu.</div>
	 *
	 * @param value the value
	 */
	public void addValueSet(ValueSet value) {
		if (this.valueSetList == null)
			this.valueSetList = new ArrayList<>();

		this.valueSetList.add(value);
	}

	/**
	 * <div class="en">Clears the mapping identificator list.</div>
	 *
	 * <div class="de">Löscht die Liste der Zuordnungsidentifikatoren.</div>
	 */
	public void clearMappingIdentificatorList() {
		this.mappingIdentificatorList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the mapping name list.</div>
	 *
	 * <div class="de">Löscht die Liste der Zuordnungsnamen.</div>
	 */
	public void clearMappingNameList() {
		this.mappingNameList = new ArrayList<>();
	}

	/**
	 * <div class="en">Clears the value set list.</div>
	 *
	 * <div class="de">Löscht die Wertesatzliste.</div>
	 */
	public void clearValueSetList() {
		this.valueSetList = new ArrayList<>();
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
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert enthält.</div>
	 * Contains.
	 *
	 * @param value the value
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
	 * <div class="de">Überprüft, ob die Liste den angegebenen Wert enthält.</div>
	 * Contains.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	public boolean containsValueSet(ValueSet value) {
		if (valueSetList != null) {
			for (ValueSet entry : valueSetList) {
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
	 * @param obj the ValueSetPackage to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof ValueSetPackage))
			return false;

		if (retVal) {
			if (this.mappingIdentificatorList == null)
				this.mappingIdentificatorList = new ArrayList<>();
			retVal = (this.mappingIdentificatorList.size() == ((ValueSetPackage) obj).getMappingIdentificatorList()
					.size());
			if (retVal) {
				for (var i = 0; i < this.mappingIdentificatorList.size(); i++) {
					retVal = ((ValueSetPackage) obj).containsMappingIdentificator(this.mappingIdentificatorList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.mappingNameList == null)
				this.mappingNameList = new ArrayList<>();
			retVal = (this.mappingNameList.size() == ((ValueSetPackage) obj).getMappingNameList().size());
			if (retVal) {
				for (var i = 0; i < this.mappingNameList.size(); i++) {
					retVal = ((ValueSetPackage) obj).containsMappingName(this.mappingNameList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.valueSetList == null)
				this.valueSetList = new ArrayList<>();
			retVal = (this.valueSetList.size() == ((ValueSetPackage) obj).getValueSetList().size());
			if (retVal) {
				for (var i = 0; i < this.valueSetList.size(); i++) {
					retVal = ((ValueSetPackage) obj).containsValueSet(this.valueSetList.get(i));
					if (!retVal)
						break;
				}
			}
		}
		if (retVal) {
			if (this.description == null)
				retVal = (((ValueSetPackage) obj).getDescription() == null);
			else
				retVal = this.description.equals(((ValueSetPackage) obj).getDescription());
		}
		if (retVal) {
			if (this.identificator == null)
				retVal = (((ValueSetPackage) obj).getIdentificator() == null);
			else
				retVal = this.identificator.equals(((ValueSetPackage) obj).getIdentificator());
		}
		if (retVal) {
			if (this.sourceUrl == null)
				retVal = (((ValueSetPackage) obj).getSourceUrl() == null);
			else
				retVal = this.sourceUrl.equals(((ValueSetPackage) obj).getSourceUrl());
		}
		if (retVal) {
			if (this.status == null)
				retVal = (((ValueSetPackage) obj).getStatus() == null);
			else
				retVal = this.status.equals(((ValueSetPackage) obj).getStatus());
		}
		if (retVal) {
			if (this.version == null)
				retVal = (((ValueSetPackage) obj).getVersion() == null);
			else
				retVal = this.version.equals(((ValueSetPackage) obj).getVersion());
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
	public List<IdentificatorBaseType> getMappingIdentificatorList() {
		if (mappingIdentificatorList == null) {
			mappingIdentificatorList = new ArrayList<>();
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
	public List<String> getMappingNameList() {
		if (mappingNameList == null) {
			mappingNameList = new ArrayList<>();
		}
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
	public List<ValueSet> getValueSetList() {
		if (valueSetList == null) {
			valueSetList = new ArrayList<>();
		}
		return valueSetList;
	}

	/**
	 * <div class="en">Gets a value set by mapping identificator.</div>
	 *
	 * <div class="de">Ruft einen Wertesatz anhand des angegebenen Zuordnungscodes
	 * ab.</div>
	 *
	 * @param value the value
	 * @return the value sety by mapping identificator
	 */
	public ValueSet getValueSetyByMappingIdentificator(IdentificatorBaseType value) {
		ValueSet retVal = null;
		for (ValueSet valueSet : getValueSetList()) {
			for (IdentificatorBaseType mapping : valueSet.getMappingIdentificatorList()) {
				if (mapping.equals(value))
					retVal = valueSet;
				if (retVal != null)
					break;
			}
			if (retVal != null)
				break;
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the value set by mapping name.</div>
	 *
	 * <div class="de">Ruft einen Wertesatz anhand des angegebenen Zuordnungsnamens
	 * ab.</div>
	 *
	 * @param value the value
	 * @return the value sety by mapping name
	 */
	public ValueSet getValueSetyByMappingName(String value) {
		ValueSet retVal = null;
		for (ValueSet valueSet : getValueSetList()) {
			for (String mapping : valueSet.getMappingNameList()) {
				if (mapping.equals(value))
					retVal = valueSet;
				if (retVal != null)
					break;
			}
			if (retVal != null)
				break;
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
	 * <div class="en">Sets the description.</div>
	 *
	 * <div class="de">Legt die Beschreibung fest.</div>
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * <div class="en">Sets the identificator.</div>
	 *
	 * <div class="de">Legt den Identifikator fest.</div>
	 *
	 * @param identificator the new identificator
	 */
	public void setIdentificator(IdentificatorBaseType identificator) {
		this.identificator = identificator;
	}

	/**
	 * <div class="en">Sets the mapping identificator list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungsidentifikatoren fest.</div>
	 *
	 * @param mappingIdentificatorList the new mapping identificator list
	 */
	public void setMappingIdentificatorList(List<IdentificatorBaseType> mappingIdentificatorList) {
		this.mappingIdentificatorList = mappingIdentificatorList;
	}

	/**
	 * <div class="en">Sets the mapping name list.</div>
	 *
	 * <div class="de">Legt die Liste der Zuordnungsnamen fest.</div>
	 *
	 * @param mappingNameList the new mapping name list
	 */
	public void setMappingNameList(List<String> mappingNameList) {
		this.mappingNameList = mappingNameList;
	}

	/**
	 * <div class="en">Sets the source url (where to get the package).</div>
	 *
	 * <div class="de">Legt die Quell-URL fest (wo das Paket abgeholt werden
	 * kann).</div>
	 *
	 * @param sourceUrl the new source url
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	/**
	 * <div class="en">Sets the status.</div>
	 *
	 * <div class="de">Setzt den Status.</div>
	 *
	 * @param status the new status
	 */
	public void setStatus(ValueSetPackageStatus status) {
		this.status = status;
	}

	/**
	 * <div class="en">Sets the value set list.</div>
	 *
	 * <div class="de">Legt die Wertesatzliste fest.</div>
	 *
	 * @param valueSetList the new value set list
	 */
	public void setValueSetList(List<ValueSet> valueSetList) {
		this.valueSetList = valueSetList;
	}

	/**
	 * <div class="en">Sets the version.</div>
	 *
	 * <div class="de">Legt die Version fest.</div>
	 *
	 * @param version the new version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}
}
