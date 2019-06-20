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

import javax.annotation.Generated;

import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;

/**
 * ValueSetConfig is used by ValueSetPackageConfig for each ValueSet that is
 * part of the package.
 */
public class ValueSetConfig {

	/**
	 * Builder to build {@link ValueSetConfig}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private String className;
		private String projectFolder;
		private SourceFormatType sourceFormatType;
		private SourceSystemType sourceSystemType;
		private String sourceUrl;

		private Builder() {
		}

		public ValueSetConfig build() {
			return new ValueSetConfig(this);
		}

		public Builder withClassName(String className) {
			this.className = className;
			return this;
		}

		public Builder withProjectFolder(String projectFolder) {
			this.projectFolder = projectFolder;
			return this;
		}

		public Builder withSourceFormatType(SourceFormatType sourceFormatType) {
			this.sourceFormatType = sourceFormatType;
			return this;
		}

		public Builder withSourceSystemType(SourceSystemType sourceSystemType) {
			this.sourceSystemType = sourceSystemType;
			return this;
		}

		public Builder withSourceUrl(String sourceUrl) {
			this.sourceUrl = sourceUrl;
			return this;
		}
	}

	/**
	 * Creates builder to build {@link ValueSetConfig}.
	 * 
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The class name. */
	private String className;

	/** The project folder. */
	private String projectFolder;

	/** The source format type. */
	private SourceFormatType sourceFormatType;

	/** The source system type. */
	private SourceSystemType sourceSystemType;

	/** The source url. */
	private String sourceUrl;

	@Generated("SparkTools")
	private ValueSetConfig(Builder builder) {
		this.className = builder.className;
		this.projectFolder = builder.projectFolder;
		this.sourceFormatType = builder.sourceFormatType;
		this.sourceSystemType = builder.sourceSystemType;
		this.sourceUrl = builder.sourceUrl;
	}

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Gets the project folder.
	 *
	 * @return the project folder
	 */
	public String getProjectFolder() {
		return projectFolder;
	}

	/**
	 * Gets the source format type.
	 *
	 * @return the source format type
	 */
	public SourceFormatType getSourceFormatType() {
		return sourceFormatType;
	}

	/**
	 * Gets the source system type.
	 *
	 * @return the source system type
	 */
	public SourceSystemType getSourceSystemType() {
		return sourceSystemType;
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
	 * Sets the class name.
	 *
	 * @param className
	 *            the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Sets the project folder.
	 *
	 * @param projectFolder
	 *            the new project folder
	 */
	public void setProjectFolder(String projectFolder) {
		this.projectFolder = projectFolder;
	}

	/**
	 * Sets the source format type.
	 *
	 * @param sourceFormatType
	 *            the new source format type
	 */
	public void setSourceFormatType(SourceFormatType sourceFormatType) {
		this.sourceFormatType = sourceFormatType;
	}

	/**
	 * Sets the source system type.
	 *
	 * @param sourceSystemType
	 *            the new source system type
	 */
	public void setSourceSystemType(SourceSystemType sourceSystemType) {
		this.sourceSystemType = sourceSystemType;
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

}
