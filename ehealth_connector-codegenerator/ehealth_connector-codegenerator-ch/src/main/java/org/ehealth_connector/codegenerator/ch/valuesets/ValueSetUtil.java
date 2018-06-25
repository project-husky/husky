/*
 *
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

package org.ehealth_connector.codegenerator.ch.valuesets;

import static java.net.URLEncoder.encode;
import static org.ehealth_connector.common.enums.LanguageCode.ENGLISH;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.codegenerator.ch.valuesets.model.ValueSet;
import org.ehealth_connector.codegenerator.ch.valuesets.model.ValueSetConfiguration;
import org.ehealth_connector.common.enums.LanguageCode;
import org.yaml.snakeyaml.Yaml;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.jayway.jsonpath.JsonPath;

/**
 * <div class="en">Contains helper methods and constants that are used to
 * dynamically generate the value sets.</div>
 */
public final class ValueSetUtil {

	/**
	 * <div class="en">The path to the configuration YAML file.</div>
	 */
	private static final String CONFIG_FILE_LOCATION = "src/main/resources/valuesets/valuesets-sources-201704.3-beta.yaml";

	/**
	 * <div class="en">The default charset used to encode files.</div>
	 */
	public static final Charset DEFAULT_CHARSET = Charsets.UTF_8;

	/**
	 * <div class="en">The default encoding used to encode URL parameter.</div>
	 */
	private static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * <div class="en">The path where the resources needed for the generation
	 * are stored, relative to the project root directory.</div>
	 */
	private static final String RESOURCE_LOCATION = "target";

	/**
	 * <div class="en">The JSONPath path to extract a value set from the JSON
	 * definition file</div>
	 */
	public static final String VALUE_SET_BASE_PATH = "$.valueSets[0].valueSet[0]";

	/**
	 * <div class="en">The JSONPath path to extract the concept definitions from
	 * a value set object.</div>
	 */
	public static final String VALUE_SET_CONCEPTS_PATH = "$.conceptList[*].concept[*]";

	/**
	 * <div class="en">Builds a Java compatible enum element name from a
	 * string.</div>
	 *
	 * @param displayName
	 *            The string to build the enum name from.
	 * @return An all upper case string with every non-word character replaced
	 *         with an underscore.
	 * @throws IllegalArgumentException
	 *             When the provided displayName is null or empty.
	 */
	public static String buildEnumName(String displayName) throws IllegalArgumentException {
		if (displayName == null || displayName.trim().isEmpty()) {
			throw new IllegalArgumentException("displayName cannot be null or empty");
		}

		String enumName = displayName.trim().toUpperCase();

		enumName = enumName.replaceAll("CLIENT'S", "CLIENT");
		enumName = enumName.replaceAll("PATIENT'S", "PATIENT");
		enumName = enumName.replaceAll(" \\(IC\\)", "");

		enumName = enumName.replaceAll("&AMP;", "AND");

		return enumName.replaceAll("\\W", "_");
	}

	/**
	 * <div class="en">Build the complete URL to retrieve a value set JSON
	 * configuration.</div>
	 *
	 * @param baseUrl
	 *            The base URL that includes host, path and prefix.
	 * @param valueSet
	 *            The parsed value set configuration containing the ID and date
	 *            to use.
	 * @return The complete URL to download a value set in JSON format.
	 * @throws MalformedURLException
	 *             When the provided baseUrl is invalid.
	 */
	public static URL buildValueSetUrl(String baseUrl, ValueSet valueSet)
			throws MalformedURLException {
		try {
			return new URL(baseUrl + "&id=" + encode(valueSet.getId(), DEFAULT_ENCODING)
					+ "&effectiveDate=" + encode(valueSet.getEffectiveDate(), DEFAULT_ENCODING));
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			throw new MalformedURLException(unsupportedEncodingException.getMessage());
		}
	}

	/**
	 * <div class="en">Reads the display name from a concept object parsed from
	 * JSON.</div>
	 *
	 * @param language
	 *            The language to find the display name in.
	 * @param concept
	 *            The concept object parsed from JSON.
	 * @return The display name or null if not found.
	 * @throws IllegalStateException
	 *             When no designation found for the provided language
	 */
	@SuppressWarnings("unchecked")
	public static String getDisplayName(LanguageCode language, Map<String, Object> concept)
			throws IllegalStateException {
		if (language == null) {
			return concept.get("displayName").toString();
		}

		List<Map<String, String>> designations = (List<Map<String, String>>) concept
				.get("designation");

		if (designations != null) {
			for (Map<String, String> designation : designations) {
				String designationLanguage = designation.get("language");
				if (designationLanguage != null
						&& designationLanguage.startsWith(language.getCodeValue())) {
					return designation.get("displayName");
				}
			}

			// nothing found for desired language, return the default for
			// english
			if (language == ENGLISH) {
				return getDisplayName(null, concept);
			}
			throw new IllegalStateException("no designation found for language " + language);
		} else
			return concept.get("displayName").toString();
	}

	/**
	 * <div class="en">Create a file instance to a Java source file by its fully
	 * qualified class name and a base folder.</div>
	 *
	 * @param baseJavaFolder
	 *            The base source folder the Java code resides in.
	 * @param fullyQualifiedClassName
	 *            The class name including the package name.
	 * @return A file instance of the Java file.
	 */
	public static File getSourceFileName(String baseJavaFolder, String fullyQualifiedClassName) {
		return new File(new File(baseJavaFolder, "src/main/java"),
				fullyQualifiedClassName.replaceAll("\\.", "/") + ".java");
	}

	/**
	 * <div class="en">Returns the JSON value set definition file on the local
	 * file system.</div>
	 *
	 * @param baseDir
	 *            The base directory to look for the value set definition in.
	 * @param valueSet
	 *            The value set configuration of the value set that should be
	 *            loaded.
	 * @return The JSON value set definition file.
	 */
	public static File getValueSetDefinitionFile(String baseDir, ValueSet valueSet) {
		File valueSetDefinitionFile = new File(new File(baseDir, RESOURCE_LOCATION),
				valueSet.getCodeSystemName() + ".json");
		return valueSetDefinitionFile;
	}

	/**
	 * <div class="en">Load the configuration file and parse it into the
	 * appropriate configuration classes.</div>
	 *
	 * @return A fully initialized configuration object containing the values of
	 *         the config file.
	 * @throws IOException
	 *             If the configuration file cannot be found or read.
	 */
	public static ValueSetConfiguration loadConfiguration(String basePath) throws IOException {
		File configFile = new File(basePath, CONFIG_FILE_LOCATION);
		String valueSetConfiguration = FileUtils.readFileToString(configFile, DEFAULT_CHARSET);
		Yaml yaml = new Yaml();
		return yaml.loadAs(valueSetConfiguration, ValueSetConfiguration.class);
	}

	/**
	 * <div class="en">Retrieves the primary type from a compilation unit.</div>
	 *
	 * @param javaSource
	 *            Parsed AST representation of a Java file.
	 * @return Parsed AST representation of the primary type found in the source
	 *         file.
	 * @throws IOException
	 *             If there is no primary type found or the Compilation unit was
	 *             not loaded from a file and the primary type could therefore
	 *             not be established.
	 * @throws InvalidClassException
	 *             When failed to load primary type from compilation unit.
	 */
	public static TypeDeclaration<?> loadPrimaryType(CompilationUnit javaSource)
			throws IOException, InvalidClassException {
		return javaSource.getPrimaryType().orElseThrow(() -> new InvalidClassException(
				"Failed to load primary type from compilation unit"));
	}

	/**
	 * <div class="en">Loads the JSON value set definition file. If it's not
	 * present on the local file system, it can be downloaded from the art-decor
	 * server.</div>
	 *
	 * @param baseDir
	 *            The base directory to look for the value set definition in.
	 * @param valueSet
	 *            The value set configuration of the value set that should be
	 *            loaded.
	 * @param downloadIfNotInFileSystem
	 *            Download the JSON file from the server if not present on the
	 *            local file system.
	 * @param baseUrl
	 *            The base URL to use when downloading the JSON file from the
	 *            server.
	 * @return A Map representing the value set definition parsed from the JSON
	 *         file.
	 * @throws IOException
	 *             If the file cannot be loaded or parsed.
	 * @throws FileNotFoundException
	 *             If the value set definition file not exists.
	 *
	 */
	public static Map<String, Object> loadValueSetDefinition(String baseDir, ValueSet valueSet,
			boolean downloadIfNotInFileSystem, String baseUrl)
			throws IOException, FileNotFoundException {

		String valueSetDefinition;
		File valueSetDefinitionFile = getValueSetDefinitionFile(baseDir, valueSet);

		// download the latest version of the value set definition from
		// art-decor.org
		// if it does not exist locally yet
		if (!valueSetDefinitionFile.exists() && downloadIfNotInFileSystem) {
			valueSetDefinition = IOUtils.toString(buildValueSetUrl(baseUrl, valueSet),
					DEFAULT_ENCODING);
			FileUtils.write(valueSetDefinitionFile, valueSetDefinition, DEFAULT_ENCODING);
		} else if (!valueSetDefinitionFile.exists()) {
			throw new FileNotFoundException(valueSetDefinitionFile.getName());
		} else {
			valueSetDefinition = FileUtils.readFileToString(valueSetDefinitionFile,
					DEFAULT_CHARSET);
		}

		// get the value set with the defined date
		return JsonPath.read(valueSetDefinition, VALUE_SET_BASE_PATH);
	}
}
