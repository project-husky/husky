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
package org.ehealth_connector.valueset.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.CustomizedYaml;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.model.Designation;
import org.ehealth_connector.valueset.model.ValueSet;
import org.ehealth_connector.valueset.model.ValueSetEntry;
import org.ehealth_connector.valueset.model.Version;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

/**
 *
 * <div class="en">TODO</div> <div class="de">TODO: Die Methode
 * dowloadValueSet(..) soll immer ein JSON der gleichen Struktur zurückliefern.
 * Die Konvertierung der verschiedenen Quellformate und abweichenden Strukturen
 * ist im Download- anstelle Load-Teil zu lösen. Eine zusätzliche
 * Download-Methode bietet die Option das ValueSet im RAW-Format des
 * Quellsystems 1:1 herunterzuladen. Diese Methode wird jedoch vom
 * ValueSetPackageManager nicht direkt genutzt jedoch intern in der Methode
 * downloadValueSet(..) verwendet.</div>
 */
public class ValueSetManager {

	/**
	 * <div class="en">The default encoding used to encode URL parameter.</div>
	 */
	private static final String UTF8_ENCODING = "UTF-8";
	/**
	 * <div class="en">The JSONPath path to extract a value set from the JSON
	 * definition file</div>
	 */
	public static final String JSON_VALUE_SET_BASE_PATH = "$.valueSets[0].valueSet[0]";

	/**
	 * <div class="en">Build the complete URL to retrieve a value set JSON
	 * configuration from ART-DECOR.</div>
	 *
	 * @param baseUrl
	 *            The base URL that includes host, path and prefix.
	 * @param id
	 *            the id
	 * @param effectiveDate
	 *            the effective date
	 * @return The complete URL to download a value set in JSON format.
	 * @throws MalformedURLException
	 *             When the provided baseUrl is invalid.
	 */
	public static URL buildValueSetArtDecorUrl(String baseUrl, IdentificatorBaseType id,
			Date effectiveDate) throws MalformedURLException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			return new URL(baseUrl + "&id="
					+ java.net.URLEncoder.encode(id.getRoot(), UTF8_ENCODING) + "&effectiveDate="
					+ java.net.URLEncoder.encode(dateFormat.format(effectiveDate), UTF8_ENCODING));
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			throw new MalformedURLException(unsupportedEncodingException.getMessage());
		}
	}

	/**
	 * The language code. According to its value the descriptions from the
	 * ART-DECOR Value-Set will be loaded
	 */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new value set manager. Default constructor (loads
	 * descriptions in English).
	 */
	public ValueSetManager() {
		this.languageCode = LanguageCode.ENGLISH;
	}

	/**
	 * Instantiates a new value set manager (loads descriptions in the given
	 * language).
	 *
	 * @param languageCode
	 *            the language code
	 */
	public ValueSetManager(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * Download value set.
	 *
	 * @param valueSetConfig
	 *            the value set config
	 * @return the value set
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ValueSet downloadValueSet(ValueSetConfig valueSetConfig)
			throws MalformedURLException, IOException {
		ValueSet retVal = null;
		if (valueSetConfig != null) {
			switch (valueSetConfig.getSourceSystemType()) {
			case ARTDECOR_FHIR:
				String downloadedString = IOUtils.toString(new URL(valueSetConfig.getSourceUrl()),
						UTF8_ENCODING);
				switch (valueSetConfig.getSourceFormatType()) {
				case JSON:
					retVal = loadValueSetJson(IOUtils.toInputStream(downloadedString));
					break;
				case XML:
					retVal = loadValueSetXml(IOUtils.toInputStream(downloadedString));
					break;
				case IHESVS:
					retVal = loadValueSetIheSvs(IOUtils.toInputStream(downloadedString));
					break;
				}
				break;
			}
		}
		return retVal;
	}

	/**
	 * Download value set raw.
	 *
	 * @param valueSetConfig
	 *            the value set config
	 * @return the output stream
	 */
	public OutputStream downloadValueSetRaw(ValueSetConfig valueSetConfig) {
		// TODO
		return null;
	}

	public Map<String, Object> getValueSetJsonMap(InputStreamReader reader) throws IOException {
		String json = IOUtils.toString(reader);
		Map<String, Object> retVal = JsonPath.read(json, JSON_VALUE_SET_BASE_PATH);
		return retVal;
	}

	/**
	 * Load value set config.
	 *
	 * @param config
	 *            the config
	 * @return the value set config
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSetConfig loadValueSetConfig(File config) throws FileNotFoundException {
		return loadValueSetConfig(new FileInputStream(config));
	}

	/**
	 * Load value set config.
	 *
	 * @param config
	 *            the config
	 * @return the value set config
	 */
	public ValueSetConfig loadValueSetConfig(InputStream config) {
		return loadValueSetConfig(new InputStreamReader(config, Charsets.UTF_8));
	}

	/**
	 * Load value set config.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set config
	 */
	public ValueSetConfig loadValueSetConfig(InputStreamReader reader) {
		ValueSetConfig valueSetConfig = CustomizedYaml.getCustomizedYaml().loadAs(reader,
				ValueSetConfig.class);
		return valueSetConfig;
	}

	/**
	 * Load value set config.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set config
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSetConfig loadValueSetConfig(String fileName) throws FileNotFoundException {
		return loadValueSetConfig(new File(fileName));
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSet loadValueSetIheSvs(File valueSet) throws FileNotFoundException {
		return loadValueSetIheSvs(new FileInputStream(valueSet));
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 */
	public ValueSet loadValueSetIheSvs(InputStream valueSet) {
		return loadValueSetIheSvs(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set
	 */
	public ValueSet loadValueSetIheSvs(InputStreamReader reader) {
		ValueSet valueSet = null;
		// TODO
		return valueSet;
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSet loadValueSetIheSvs(String fileName) throws FileNotFoundException {
		return loadValueSetIheSvs(new File(fileName));
	}

	/**
	 * Load value set json.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(File valueSet) throws IOException {
		return loadValueSetJson(new FileInputStream(valueSet));
	}

	/**
	 * Load value set json.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(InputStream valueSet) throws IOException {
		return loadValueSetJson(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * Load value set json.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(InputStreamReader reader) throws IOException {
		ValueSet valueSet = new ValueSet();
		Version version = new Version();
		Map<String, Object> map = getValueSetJsonMap(reader);
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();

			if ("id".contentEquals(key) && (entry.getValue() != null))
				valueSet.setIdentificator(IdentificatorBaseType.builder()
						.withRoot(entry.getValue().toString()).build());
			if ("name".contentEquals(key) && (entry.getValue() != null))
				valueSet.setName(entry.getValue().toString());
			if ("displayName".contentEquals(key) && (entry.getValue() != null))
				valueSet.setDisplayName(entry.getValue().toString());
			if ("versionLabel".contentEquals(key) && (entry.getValue() != null))
				version.setLabel(entry.getValue().toString());
			if ("effectiveDate".contentEquals(key) && (entry.getValue() != null))
				version.setValidFrom(
						DateUtil.parseDateyyyyMMddTHHmmss(entry.getValue().toString()));
			if ("statusCode".contentEquals(key) && (entry.getValue() != null)) {
				String status = entry.getValue().toString();

				// new: Value set just created and is new and work in progress
				// to become a draft/finalized value set. Beyond the author,
				// nobody should look at this value set unless it's status code
				// is draft or finalized.
				if ("new".equals(status.toLowerCase()))
					valueSet.setStatus(ValueSetStatus.NEW);
				// draft: Value set under development (nascent). Metadata and
				// value set may be incomplete. Entered primarily to encourage
				// other users to be aware of ongoing process.
				if ("draft".equals(status.toLowerCase()))
					valueSet.setStatus(ValueSetStatus.DRAFT);

				// final: Value set has been published by the custodian
				// organization and deemed fit for use. May have associated
				// adoption and annotation metadata
				if ("final".equals(status.toLowerCase()))
					valueSet.setStatus(ValueSetStatus.FINAL);

				// deprecated: Value set retired: No longer fit for use.
				// Information available for historical reference.
				if ("deprecated".equals(status.toLowerCase()))
					valueSet.setStatus(ValueSetStatus.DEPRECATED);

				// rejected: Value set is rejected
				if ("rejected".equals(status.toLowerCase()))
					valueSet.setStatus(ValueSetStatus.REJECTED);

				// cancelled: Value set is withdrawn
				if ("cancelled".equals(status.toLowerCase()))
					valueSet.setStatus(ValueSetStatus.CANCELLED);

			}
			if ("desc".contentEquals(key) && (entry.getValue() != null)
					&& (entry.getValue().getClass() == JSONArray.class)) {
				JSONArray descs = (JSONArray) entry.getValue();
				for (Object object : descs) {
					@SuppressWarnings("unchecked")
					Map<String, Object> subMap = (Map<String, Object>) object;
					boolean thisIsTheSelection = false;
					String content = "";
					for (Entry<String, Object> subEntry : subMap.entrySet()) {
						String subKey = subEntry.getKey();
						if ("language".contentEquals(subKey) && (subEntry.getValue() != null)) {
							String lang = subEntry.getValue().toString();
							if (this.languageCode.getCodeValue().equals(lang))
								thisIsTheSelection = true;
							else if (this.languageCode.getCodeValue().substring(0, 2)
									.equals(lang.substring(0, 2)))
								thisIsTheSelection = true;
						}
						if ("content".contentEquals(subKey) && (subEntry.getValue() != null))
							content = subEntry.getValue().toString();
					}
					if (thisIsTheSelection)
						valueSet.setDescription(content);
				}
			}
			if ("publishingAuthority".contentEquals(key) && (entry.getValue() != null)
					&& (entry.getValue().getClass() == JSONArray.class)) {
				JSONArray descs = (JSONArray) entry.getValue();
				OrganizationBaseType org = new OrganizationBaseType();
				AddressBaseType addr = null;
				for (Object object : descs) {
					@SuppressWarnings("unchecked")
					Map<String, Object> subMap = (Map<String, Object>) object;
					for (Entry<String, Object> subEntry : subMap.entrySet()) {
						String subKey = subEntry.getKey();
						if ("name".contentEquals(subKey) && (subEntry.getValue() != null)) {
							org.addName(subEntry.getValue().toString());
						}
						if ("addrLine".contentEquals(subKey) && (subEntry.getValue() != null)) {
							JSONArray contents = (JSONArray) subEntry.getValue();
							String addrLine1 = null;
							String addrLine2 = null;
							for (Object object2 : contents) {
								@SuppressWarnings("unchecked")
								Map<String, Object> subMap2 = (Map<String, Object>) object2;
								String type = null;
								String content = null;
								for (Entry<String, Object> subEntry2 : subMap2.entrySet()) {
									type = null;
									String subKey2 = subEntry2.getKey();
									if ("type".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										type = subEntry2.getValue().toString();

									if ("content".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										content = subEntry2.getValue().toString();
								}
								// type:uri is not implemented, yet. Feel free
								// to add when you use it.
								if (type == null) {
									if (addrLine1 == null)
										addrLine1 = content;
									else if (addrLine2 == null)
										addrLine2 = content;
								}
							}
							if (addrLine1 != null) {
								addr = AddressBaseType.builder().withStreetAddressLine1(addrLine1)
										.build();
							}
							if (addrLine2 != null) {
								addr.setStreetAddressLine2(addrLine2);
							}
						}
					}
				}
				if (addr != null)
					org.addAddress(addr);
				version.setPublishingAuthority(org);
			}
			if ("conceptList".contentEquals(key) && (entry.getValue() != null)
					&& (entry.getValue().getClass() == JSONArray.class)) {
				JSONArray concepts = (JSONArray) entry.getValue();
				for (Object object : concepts) {
					@SuppressWarnings("unchecked")
					Map<String, Object> subMap = (Map<String, Object>) object;
					for (Entry<String, Object> subEntry : subMap.entrySet()) {
						String subKey = subEntry.getKey();
						if ("concept".contentEquals(subKey) && (subEntry.getValue() != null)) {
							JSONArray contents = (JSONArray) subEntry.getValue();
							ValueSetEntry valueSetEntry = new ValueSetEntry();
							for (Object object2 : contents) {
								@SuppressWarnings("unchecked")
								Map<String, Object> subMap2 = (Map<String, Object>) object2;
								String entryCode = null;
								String entryCodeSystem = null;
								String entryDisplayName = null;
								String entryLevel = null;
								String entryType = null;
								for (Entry<String, Object> subEntry2 : subMap2.entrySet()) {
									String subKey2 = subEntry2.getKey();
									if ("code".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										entryCode = subEntry2.getValue().toString();
									if ("codeSystem".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										entryCodeSystem = subEntry2.getValue().toString();
									if ("displayName".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										entryDisplayName = subEntry2.getValue().toString();
									if ("level".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										entryLevel = subEntry2.getValue().toString();
									if ("type".contentEquals(subKey2)
											&& (subEntry2.getValue() != null))
										entryType = subEntry2.getValue().toString();
									if ("designation".contentEquals(subKey2)
											&& (subEntry2.getValue() != null)) {
										JSONArray designations = (JSONArray) subEntry2.getValue();
										Designation designation = new Designation();
										for (Object object3 : designations) {
											@SuppressWarnings("unchecked")
											Map<String, Object> subMap3 = (Map<String, Object>) object3;
											for (Entry<String, Object> subEntry3 : subMap3
													.entrySet()) {
												String subKey3 = subEntry3.getKey();
												if ("language".contentEquals(subKey3)
														&& (subEntry3.getValue() != null)) {
													LanguageCode languageCode = LanguageCode
															.getEnum(subEntry3.getValue().toString()
																	.toLowerCase());
													if (languageCode == null)
														languageCode = LanguageCode
																.getEnum(subEntry3.getValue()
																		.toString().toLowerCase()
																		.substring(0, 2));
													designation.setLanguageCode(languageCode);
												}
												if ("type".contentEquals(subKey3)
														&& (subEntry3.getValue() != null)) {
													if ("abbreviation".equals(subEntry3.getValue()
															.toString().toLowerCase()))
														designation.setType(
																DesignationType.ABBREVIATION);
													if ("fsn".equals(subEntry3.getValue().toString()
															.toLowerCase()))
														designation.setType(
																DesignationType.FULLY_SPECIFIED_NAME);
													if ("preferred".equals(subEntry3.getValue()
															.toString().toLowerCase()))
														designation
																.setType(DesignationType.PREFERRED);
													if ("synonym".equals(subEntry3.getValue()
															.toString().toLowerCase()))
														designation
																.setType(DesignationType.SYNONYM);
												}
												if ("displayName".contentEquals(subKey3)
														&& (subEntry3.getValue() != null))
													designation.setDisplayName(
															subEntry3.getValue().toString());
											}
											// valueSetEntry.addDesignation(designation);
										}
									}
								}
								int level = 0;
								try {
									level = Integer.parseInt(entryLevel);
								} catch (Exception e) {
									// do nothing; default is 0.
								}
								CodeBaseType code = CodeBaseType.builder().withCode(entryCode)
										.withCodeSystem(entryCodeSystem)
										.withDisplayName(entryDisplayName).build();
								valueSetEntry.setCodeBaseType(code);
								valueSetEntry.setLevel(level);

								valueSet.addValueSetEntry(valueSetEntry);
							}
						}
					}
				}
			}

		}
		valueSet.setVersion(version);

		// TODO remove following lines (debug only)
		ValueSetManager mgr = new ValueSetManager();

		mgr.saveValueSet(valueSet, Util.getTempDirectory()
				+ FileUtil.getPlatformSpecificPathSeparator() + "testDownloadedValueSet.yaml");

		return valueSet;
	}

	/**
	 * Load value set json.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(String fileName) throws IOException {
		return loadValueSetJson(new File(fileName));
	}

	/**
	 * Load value set xml.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSet loadValueSetXml(File valueSet) throws FileNotFoundException {
		return loadValueSetXml(new FileInputStream(valueSet));
	}

	/**
	 * Load value set xml.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 */
	public ValueSet loadValueSetXml(InputStream valueSet) {
		return loadValueSetXml(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * Load value set xml.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set
	 */
	public ValueSet loadValueSetXml(InputStreamReader reader) {
		ValueSet valueSet = null;
		// TODO
		return valueSet;
	}

	/**
	 * Load value set xml.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSet loadValueSetXml(String fileName) throws FileNotFoundException {
		return loadValueSetXml(new File(fileName));
	}

	/**
	 * Load value set yaml.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSet loadValueSetYaml(File valueSet) throws FileNotFoundException {
		return loadValueSetYaml(new FileInputStream(valueSet));
	}

	/**
	 * Load value set yaml.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 */
	public ValueSet loadValueSetYaml(InputStream valueSet) {
		return loadValueSetYaml(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * Load value set yaml.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set
	 */
	public ValueSet loadValueSetYaml(InputStreamReader reader) {
		ValueSet valueSet = CustomizedYaml.getCustomizedYaml().loadAs(reader, ValueSet.class);
		return valueSet;
	}

	/**
	 * Load value set yaml.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public ValueSet loadValueSetYaml(String fileName) throws FileNotFoundException {
		return loadValueSetYaml(new File(fileName));
	}

	/**
	 * Save value set.
	 *
	 * @param valueSet
	 *            the value set
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, File file) throws IOException {
		FileUtils.writeByteArrayToFile(file,
				CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSet).getBytes(Charsets.UTF_8));
	}

	/**
	 * Save value set.
	 *
	 * @param valueSet
	 *            the value set
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, String fileName) throws IOException {
		saveValueSet(valueSet, new File(fileName));
	}

	/**
	 * Save value set config.
	 *
	 * @param valueSetConfig
	 *            the value set config
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetConfig(ValueSetConfig valueSetConfig, File file) throws IOException {
		FileUtils.writeByteArrayToFile(file, CustomizedYaml.getCustomizedYaml()
				.dumpAsMap(valueSetConfig).getBytes(Charsets.UTF_8));
	}

	/**
	 * Save value set config.
	 *
	 * @param valueSetConfig
	 *            the value set config
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetConfig(ValueSetConfig valueSetConfig, String fileName)
			throws IOException {
		saveValueSetConfig(valueSetConfig, new File(fileName));
	}

}
