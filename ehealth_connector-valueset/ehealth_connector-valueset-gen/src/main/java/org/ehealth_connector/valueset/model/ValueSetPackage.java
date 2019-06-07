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

import java.net.MalformedURLException;
import java.net.URL;
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
		private ArrayList<IdentificatorBaseType> mappingIdentificatorList;
		private ArrayList<String> mappingNameList;
		private ArrayList<ValueSet> valueSetList;
		private String description;
		private IdentificatorBaseType identificator;
		private URL sourceUrl;
		private ValueSetPackageStatus status;
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

		public Builder withMappingIdentificatorList(
				ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
			this.mappingIdentificatorList = mappingIdentificatorList;
			return this;
		}

		public Builder withMappingNameList(ArrayList<String> mappingNameList) {
			this.mappingNameList = mappingNameList;
			return this;
		}

		public Builder withSourceUrl(URL sourceUrl) {
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
	 * Creates builder to build {@link ValueSetPackage}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	private ArrayList<IdentificatorBaseType> mappingIdentificatorList;

	private ArrayList<String> mappingNameList;

	private ArrayList<ValueSet> valueSetList;

	private String description;

	private IdentificatorBaseType identificator;

	private URL sourceUrl;

	private ValueSetPackageStatus status;

	private Version version;

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

	public void addMappingIdentificator(IdentificatorBaseType value) {
		if (this.mappingIdentificatorList == null) {
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		}
		this.mappingIdentificatorList.add(value);
	}

	public void addMappingName(String value) {
		if (this.mappingNameList == null) {
			this.mappingNameList = new ArrayList<String>();
		}
		this.mappingNameList.add(value);
	}

	public void addValueSet(ValueSet value) {
		if (this.valueSetList == null) {
			this.valueSetList = new ArrayList<ValueSet>();
		}
		this.valueSetList.add(value);
	}

	public String getDescription() {
		return description;
	}

	public IdentificatorBaseType getIdentificator() {
		return identificator;
	}

	public URL getSourceUrl() {
		return sourceUrl;
	}

	public String getSourceUrlString() {
		return sourceUrl.toString();
	}

	public ValueSetPackageStatus getStatus() {
		return status;
	}

	public Version getVersion() {
		return version;
	}

	public List<IdentificatorBaseType> listMappingIdentificators() {
		if (this.mappingIdentificatorList == null)
			this.mappingIdentificatorList = new ArrayList<IdentificatorBaseType>();
		return mappingIdentificatorList;
	}

	public List<String> listMappingNames() {
		if (this.mappingNameList == null) {
			this.mappingNameList = new ArrayList<String>();
		}
		return this.mappingNameList;
	}

	public List<ValueSet> listValueSets() {
		if (this.valueSetList == null) {
			this.valueSetList = new ArrayList<ValueSet>();
		}
		return this.valueSetList;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdentificator(IdentificatorBaseType identificator) {
		this.identificator = identificator;
	}

	public void setSourceUrl(URL sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public void setSourceUrlString(String sourceUrl) throws MalformedURLException {
		URL url = new URL(sourceUrl);
		this.sourceUrl = url;
	}

	public void setStatus(ValueSetPackageStatus status) {
		this.status = status;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

}
