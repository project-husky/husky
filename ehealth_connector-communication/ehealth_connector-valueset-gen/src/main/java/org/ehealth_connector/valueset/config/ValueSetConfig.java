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

import javax.annotation.processing.Generated;

import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;

/**
 * <div class="en">ValueSetConfig is used by ValueSetPackageConfig for each
 * ValueSet that is part of the package.</div>
 *
 * <div class="de">Die ValueSetConfig wird von ValueSetPackageConfig für jeden
 * Wertesatz verwendet, der Teil des Pakets ist.</div>
 */
public class ValueSetConfig {

	/**
	 * See getter/setter for more details to the class members.
	 */

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
		private String sourceUrl;

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

	/**
	 * <div class="en">Instantiates a new ValueSetConfig. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert eine neue ValueSetConfig.
	 * Standardkonstruktor.</div>
	 */
	public ValueSetConfig() {
	}

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
	 * <div class="en">Gets the fully qualified class name of the desired Enum
	 * to be created.</div>
	 *
	 * <div class="de">Ruft den vollständig qualifizierten Klassennamen der
	 * gewünschten, zu erstellenden Enumeration ab.</div>
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <div class="en">Gets the project folder, where to save the enum. The
	 * folder is expected to be relative to the execution directory.</div>
	 *
	 * <div class="de">Ruft den Projektordner ab, in dem die Enumeration
	 * gespeichert werden soll. Es wird erwartet, dass der Ordner relativ zum
	 * Ausführungsverzeichnis ist.</div>
	 *
	 * @return the project folder
	 */
	public String getProjectFolder() {
		return projectFolder;
	}

	/**
	 * <div class="en">Gets the source format type (format, in which the
	 * ValueSet is provided by the publishing authority).</div>
	 *
	 * <div class="de">Ruft den Quellformattyp ab (Format, in dem das ValueSet
	 * von der Veröffentlichungsbehörde bereitgestellt wird).</div>
	 *
	 * @return the source format type
	 */
	public SourceFormatType getSourceFormatType() {
		return sourceFormatType;
	}

	/**
	 * <div class="en">Gets the source system type (type of the system, that is
	 * maintained by the publishing authority for ValueSet publications).</div>
	 *
	 * <div class="de">Ruft den Quellsystemtyp ab (Typ des Systems, der von der
	 * Veröffentlichungsbehörde für die ValueSet-Veröffentlichungen unterhalten
	 * wird).</div>
	 *
	 * @return the source system type
	 */
	public SourceSystemType getSourceSystemType() {
		return sourceSystemType;
	}

	/**
	 * <div class="en">Gets the source url, where the ValueSet can be
	 * downloaded, from.</div>
	 *
	 * <div class="de">Ruft die Quell-URL ab, von der das ValueSet
	 * heruntergeladen werden kann.</div>
	 *
	 * @return the source url
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}

	/**
	 * <div class="en">Sets the class name. See getter
	 * {@link ValueSetConfig#getClassName} for more details.</div>
	 *
	 * <div class="de">Legt den Klassennamen fest. Siehe Getter
	 * {@link ValueSetConfig#getClassName} für weitere Details.</div>
	 *
	 * @param className
	 *            the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * <div class="en">Sets the project folder. See getter
	 * {@link ValueSetConfig#getProjectFolder} for more details.</div>
	 *
	 * <div class="de">Legt den Projektordner fest. Siehe Getter
	 * {@link ValueSetConfig#getProjectFolder} für weitere Details.</div>
	 *
	 * @param projectFolder
	 *            the new project folder
	 */
	public void setProjectFolder(String projectFolder) {
		this.projectFolder = projectFolder;
	}

	/**
	 * <div class="en">Sets the source format type. See getter
	 * {@link ValueSetConfig#getSourceFormatType} for more details.</div>
	 *
	 * <div class="de">Legt den Quellformattyp fest. Siehe Getter
	 * {@link ValueSetConfig#getSourceFormatType} für weitere Details.</div>
	 *
	 * @param sourceFormatType
	 *            the new source format type
	 */
	public void setSourceFormatType(SourceFormatType sourceFormatType) {
		this.sourceFormatType = sourceFormatType;
	}

	/**
	 * <div class="en">Sets the source system type. See getter
	 * {@link ValueSetConfig#getSourceSystemType} for more details.</div>
	 *
	 * <div class="de">Legt den Quellsystemtyp fest. Siehe Getter
	 * {@link ValueSetConfig#getSourceSystemType} für weitere Details.</div>
	 *
	 * @param sourceSystemType
	 *            the new source system type
	 */
	public void setSourceSystemType(SourceSystemType sourceSystemType) {
		this.sourceSystemType = sourceSystemType;
	}

	/**
	 * <div class="en">Sets the source url. See getter
	 * {@link ValueSetConfig#getSourceUrl} for more details.</div>
	 *
	 * <div class="de">Legt die Quell-URL fest. Siehe Getter
	 * {@link ValueSetConfig#getSourceUrl} für weitere Details.</div>
	 *
	 * @param sourceUrl
	 *            the new source url
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

}
