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
import java.util.List;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.valueset.config.ValueSetPackageConfig;
import org.projecthusky.valueset.enums.ValueSetPackageStatus;

/**
 * <div class="en">The Class ValueSetPackage is intended to contain all
 * information about a package of multiple value sets.</div>
 *
 * <div class="de">Die Klasse ValueSetPackage dient zum Sammeln aller
 * Informationen zu einem Paket mit mehreren Wertesätzen.</div>
 */
/* contains generated code */
@SuppressWarnings("java:DuplicatedBlocks")
public class ValueSetPackage extends ValueSetBase implements Serializable {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link ValueSetPackage}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String description;
		private String sourceUrl;
		private ValueSetPackageStatus status;
		private ArrayList<ValueSet> valueSetList;
		private IdentificatorBaseType identificator;
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;
		private ArrayList<String> mappingNameList;
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

	/** The source url. */
	private String sourceUrl;

	/** The status. */
	private ValueSetPackageStatus status;

	/** The value set list. */
	private List<ValueSet> valueSetList;

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
		this.sourceUrl = builder.sourceUrl;
		this.status = builder.status;
		this.valueSetList = builder.valueSetList;

		this.setIdentificator(builder.identificator);
		this.setMappingIdentificatorList(builder.mappingIdentificatorList);
		this.setMappingNameList(builder.mappingNameList);
		this.setVersion(builder.version);
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
		this.sourceUrl = valueSetPackageConfig.getSourceUrl();
		this.status = valueSetPackageConfig.getStatus();

		this.setIdentificator(valueSetPackageConfig.getIdentificator());
		this.setVersion(valueSetPackageConfig.getVersion());
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

		retVal = compareMappingIdentificatorList((ValueSetPackage) obj);

		if (retVal) {
			retVal = compareMappingNameList((ValueSetPackage) obj);
		}
		if (retVal) {
			retVal = compareValueSetList((ValueSetPackage) obj);
		}
		if (retVal) {
			retVal = compareDescription((ValueSetPackage) obj);
		}
		if (retVal) {
			retVal = compareIdentificator((ValueSetPackage) obj);
		}
		if (retVal) {
			retVal = compareSourceUrl((ValueSetPackage) obj);
		}
		if (retVal) {
			retVal = compareStatus((ValueSetPackage) obj);
		}
		if (retVal) {
			retVal = compareVersion((ValueSetPackage) obj);
		}
		return retVal;
	}

	private boolean compareValueSetList(ValueSetPackage obj) {
		if (this.valueSetList == null) {
			this.valueSetList = new ArrayList<>();
		}

		var retVal = this.valueSetList.size() == obj.getValueSetList().size();
		if (retVal) {
			for (var i = 0; i < this.valueSetList.size(); i++) {
				retVal = obj.containsValueSet(this.valueSetList.get(i));
				if (!retVal) {
					return false;
				}
			}
		}

		return retVal;
	}

	private boolean compareDescription(ValueSetPackage obj) {
		if (this.description == null)
			return obj.getDescription() == null;
		else
			return this.description.equals(obj.getDescription());
	}

	private boolean compareSourceUrl(ValueSetPackage obj) {
		if (this.sourceUrl == null)
			return obj.getSourceUrl() == null;
		else
			return this.sourceUrl.equals(obj.getSourceUrl());
	}

	private boolean compareStatus(ValueSetPackage obj) {
		if (this.status == null)
			return (obj.getStatus() == null);
		else
			return this.status.equals(obj.getStatus());
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getMappingIdentificatorList()).append(this.getMappingNameList())
				.append(this.valueSetList).append(this.description).append(this.getIdentificator())
				.append(this.sourceUrl).append(this.status).append(this.getVersion()).toHashCode();
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

}
