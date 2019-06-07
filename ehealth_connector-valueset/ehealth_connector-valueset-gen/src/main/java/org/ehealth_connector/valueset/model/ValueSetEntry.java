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

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueSetEntry.
 */
public class ValueSetEntry {

	/**
	 * Builder to build {@link ValueSetEntry}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The children. */
		private ArrayList<ValueSetEntry> children;

		/** The mapping code list. */
		private ArrayList<CodeBaseType> mappingCodeList;

		/** The mapping name list. */
		private ArrayList<String> mappingNameList;

		/** The code base type. */
		private CodeBaseType codeBaseType;

		/** The default mapping name. */
		private String defaultMappingName;

		/** The level. */
		private int level;

		/** The value set entry type. */
		private ValueSetEntryType valueSetEntryType;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the value set entry
		 */
		public ValueSetEntry build() {
			return new ValueSetEntry(this);
		}

		/**
		 * With children.
		 *
		 * @param children
		 *            the children
		 * @return the builder
		 */
		public Builder withChildren(ArrayList<ValueSetEntry> children) {
			this.children = children;
			return this;
		}

		/**
		 * With code base type.
		 *
		 * @param codeBaseType
		 *            the code base type
		 * @return the builder
		 */
		public Builder withCodeBaseType(CodeBaseType codeBaseType) {
			this.codeBaseType = codeBaseType;
			return this;
		}

		/**
		 * With default mapping name.
		 *
		 * @param defaultMappingName
		 *            the default mapping name
		 * @return the builder
		 */
		public Builder withDefaultMappingName(String defaultMappingName) {
			this.defaultMappingName = defaultMappingName;
			return this;
		}

		/**
		 * With level.
		 *
		 * @param level
		 *            the level
		 * @return the builder
		 */
		public Builder withLevel(int level) {
			this.level = level;
			return this;
		}

		/**
		 * With mapping code list.
		 *
		 * @param mappingCodeList
		 *            the mapping code list
		 * @return the builder
		 */
		public Builder withMappingCodeList(ArrayList<CodeBaseType> mappingCodeList) {
			this.mappingCodeList = mappingCodeList;
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
		 * With value set entry type.
		 *
		 * @param valueSetEntryType
		 *            the value set entry type
		 * @return the builder
		 */
		public Builder withValueSetEntryType(ValueSetEntryType valueSetEntryType) {
			this.valueSetEntryType = valueSetEntryType;
			return this;
		}
	}

	/**
	 * Creates builder to build {@link ValueSetEntry}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The children. */
	private ArrayList<ValueSetEntry> children;

	/** The mapping code list. */
	private ArrayList<CodeBaseType> mappingCodeList;

	/** The mapping name list. */
	private ArrayList<String> mappingNameList;

	/** The code base type. */
	private CodeBaseType codeBaseType;

	/** The default mapping name. */
	private String defaultMappingName;

	/** The level. */
	private int level;

	/** The value set entry type. */
	private ValueSetEntryType valueSetEntryType;

	/**
	 * Instantiates a new value set entry.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private ValueSetEntry(Builder builder) {
		this.children = builder.children;
		this.mappingCodeList = builder.mappingCodeList;
		this.mappingNameList = builder.mappingNameList;
		this.codeBaseType = builder.codeBaseType;
		this.defaultMappingName = builder.defaultMappingName;
		this.level = builder.level;
		this.valueSetEntryType = builder.valueSetEntryType;
	}

	/**
	 * Adds the child.
	 *
	 * @param value
	 *            the value
	 */
	public void addChild(ValueSetEntry value) {
		if (this.children == null) {
			this.children = new ArrayList<ValueSetEntry>();
		}
		this.children.add(value);
	}

	/**
	 * Adds the mapping code.
	 *
	 * @param value
	 *            the value
	 */
	public void addMappingCode(CodeBaseType value) {
		if (this.mappingCodeList == null) {
			this.mappingCodeList = new ArrayList<CodeBaseType>();
		}
		this.mappingCodeList.add(value);
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
	 * Gets the code base type.
	 *
	 * @return the code base type
	 */
	public CodeBaseType getCodeBaseType() {
		return codeBaseType;
	}

	/**
	 * Gets the default mapping name.
	 *
	 * @return the default mapping name
	 */
	public String getDefaultMappingName() {
		return defaultMappingName;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets the value set entry type.
	 *
	 * @return the value set entry type
	 */
	public ValueSetEntryType getValueSetEntryType() {
		return valueSetEntryType;
	}

	/**
	 * List children.
	 *
	 * @return the list
	 */
	public List<ValueSetEntry> listChildren() {
		if (this.children == null) {
			this.children = new ArrayList<ValueSetEntry>();
		}
		return this.children;
	}

	/**
	 * List mapping codes.
	 *
	 * @return the list
	 */
	public List<CodeBaseType> listMappingCodes() {
		if (this.mappingCodeList == null) {
			this.mappingCodeList = new ArrayList<CodeBaseType>();
		}
		return this.mappingCodeList;
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
	 * Sets the code base type.
	 *
	 * @param codeBaseType
	 *            the new code base type
	 */
	public void setCodeBaseType(CodeBaseType codeBaseType) {
		this.codeBaseType = codeBaseType;
	}

	/**
	 * Sets the default mapping name.
	 *
	 * @param defaultMappingName
	 *            the new default mapping name
	 */
	public void setDefaultMappingName(String defaultMappingName) {
		this.defaultMappingName = defaultMappingName;
	}

	/**
	 * Sets the level.
	 *
	 * @param level
	 *            the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Sets the value set entry type.
	 *
	 * @param valueSetEntryType
	 *            the new value set entry type
	 */
	public void setValueSetEntryType(ValueSetEntryType valueSetEntryType) {
		this.valueSetEntryType = valueSetEntryType;
	}

}
