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

		/** The class name. */
		private String className;

		/** The project folder. */
		private String projectFolder;

		/** The source format type. */
		private SourceFormatType sourceFormatType;

		/** The source system type. */
		private SourceSystemType sourceSystemType;

		/** The source url. */
		private URL sourceUrl;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the value set config
		 */
		public ValueSetConfig build() {
			return new ValueSetConfig(this);
		}

		/**
		 * With class name.
		 *
		 * @param className
		 *            the class name
		 * @return the builder
		 */
		public Builder withClassName(String className) {
			this.className = className;
			return this;
		}

		/**
		 * With project folder.
		 *
		 * @param projectFolder
		 *            the project folder
		 * @return the builder
		 */
		public Builder withProjectFolder(String projectFolder) {
			this.projectFolder = projectFolder;
			return this;
		}

		/**
		 * With source format type.
		 *
		 * @param sourceFormatType
		 *            the source format type
		 * @return the builder
		 */
		public Builder withSourceFormatType(SourceFormatType sourceFormatType) {
			this.sourceFormatType = sourceFormatType;
			return this;
		}

		/**
		 * With source system type.
		 *
		 * @param sourceSystemType
		 *            the source system type
		 * @return the builder
		 */
		public Builder withSourceSystemType(SourceSystemType sourceSystemType) {
			this.sourceSystemType = sourceSystemType;
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
	private URL sourceUrl;

	/**
	 * Instantiates a new value set config.
	 *
	 * @param builder
	 *            the builder
	 */
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

}
