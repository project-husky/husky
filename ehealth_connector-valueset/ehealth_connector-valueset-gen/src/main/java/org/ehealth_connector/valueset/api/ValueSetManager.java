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
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

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
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.CustomizedYaml;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.model.Designation;
import org.ehealth_connector.valueset.model.ValueSet;
import org.ehealth_connector.valueset.model.ValueSetEntry;
import org.ehealth_connector.valueset.model.Version;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

/**
 *
 * <div class="en">Manages the handling of ValueSets such as download from an
 * URL, save to and load from a file.</div> <div class="de">Verwaltet die
 * Verarbeitung von ValueSets, z. B. Herunterladen von einer URL, Speichern in
 * und Laden aus einer Datei.</div>
 */
public class ValueSetManager {

	/**
	 * <div class="en">The default encoding used to encode URL parameter.</div>
	 */
	static final String UTF8_ENCODING = "UTF-8";
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
	 * Instantiates a new value set manager. Default constructor.
	 */
	public ValueSetManager() {
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
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet downloadValueSet(ValueSetConfig valueSetConfig)
			throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
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
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public byte[] downloadValueSetRaw(ValueSetConfig valueSetConfig)
			throws MalformedURLException, IOException {
		byte[] retVal = null;
		if (valueSetConfig != null) {
			switch (valueSetConfig.getSourceSystemType()) {
			case ARTDECOR_FHIR:
				retVal = IOUtils.toByteArray(new URL(valueSetConfig.getSourceUrl()));
				break;
			}
		}
		return retVal;
	}

	private NodeList evaluateXpathExprAsNodeList(Document xmlDoc, String xpathExpr) {
		NodeList retVal = null;

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		XPathExpression expr;

		try {
			expr = xpath.compile(xpathExpr);
			retVal = (NodeList) expr.evaluate(xmlDoc, XPathConstants.NODESET);

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return retVal;

	}

	private String evaluateXpathExprAsString(Document xmlDoc, String xpathExpr) {
		String retVal = null;

		NodeList nodes = evaluateXpathExprAsNodeList(xmlDoc, xpathExpr);

		if (nodes != null)
			if (nodes.getLength() > 0)
				retVal = nodes.item(0).getTextContent().trim();

		return retVal;
	}

	/**
	 * Gets the language code from a given textContent out of JSON or XML
	 * (including IHE SVS).
	 *
	 * @param textContent
	 *            the text content
	 * @return the language code
	 */
	private LanguageCode getLanguageCode(String textContent) {
		LanguageCode languageCode = LanguageCode.getEnum(textContent);
		if (languageCode == null)
			languageCode = LanguageCode.getEnum(textContent.substring(0, 2));
		return languageCode;
	}

	public Map<String, Object> getValueSetJsonMap(InputStreamReader reader) throws IOException {
		String json = IOUtils.toString(reader);
		Map<String, Object> retVal = JsonPath.read(json, JSON_VALUE_SET_BASE_PATH);
		return retVal;
	}

	public ValueSet loadValueSet(ValueSetConfig valueSetConfig, String cachePath) {
		ValueSet retVal = null;
		if (valueSetConfig != null) {
			switch (valueSetConfig.getSourceSystemType()) {
			// case ARTDECOR_FHIR:
			// switch (valueSetConfig.getSourceFormatType()) {
			// case JSON:
			// retVal = loadValueSetJson(cachePath xxx);
			// break;
			// case XML:
			// retVal =
			// loadValueSetXml(IOUtils.toInputStream(downloadedString));
			// break;
			// case IHESVS:
			// retVal =
			// loadValueSetIheSvs(IOUtils.toInputStream(downloadedString));
			// break;
			// }
			// break;
			// }
			}
		}
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
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetIheSvs(File valueSet)
			throws IOException, ParserConfigurationException, SAXException {
		return loadValueSetIheSvs(new FileInputStream(valueSet));
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetIheSvs(InputStream valueSet)
			throws IOException, ParserConfigurationException, SAXException {
		return loadValueSetIheSvs(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ValueSet loadValueSetIheSvs(InputStreamReader reader)
			throws IOException, ParserConfigurationException, SAXException {
		ValueSet valueSet = new ValueSet();
		Version version = new Version();

		String textContent;
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docBuilderFactory.newDocumentBuilder();
		Document xmlDoc = docBuilder
				.parse(IOUtils.toInputStream(IOUtils.toString(reader), Charsets.UTF_8));

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/@id");
		if (textContent != null)
			valueSet.setIdentificator(
					IdentificatorBaseType.builder().withRoot(textContent).build());

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/Purpose/text()");
		if (textContent != null)
			valueSet.addDescription(new LangText(LanguageCode.ENGLISH, textContent));

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/@displayName");
		if (textContent != null)
			valueSet.setDisplayName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/EffectiveDate/text()");
		if (textContent != null)
			version.setValidFrom(DateUtil.parseDateyyyyMMdd(textContent));

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/@version");
		if (textContent != null)
			version.setLabel(textContent);

		ArrayList<LanguageCode> langCodes = new ArrayList<LanguageCode>();
		NodeList nodeList;
		nodeList = evaluateXpathExprAsNodeList(xmlDoc, "//ValueSet/ConceptList/@lang");
		for (int i = 0; i < nodeList.getLength(); i++) {
			LanguageCode languageCode = getLanguageCode(nodeList.item(i).getTextContent().trim());
			if (languageCode != null)
				langCodes.add(languageCode);
		}

		nodeList = evaluateXpathExprAsNodeList(xmlDoc, "//ValueSet/ConceptList[1]/Concept");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if ("Concept".equals(node.getNodeName())) {
				ValueSetEntry valueSetEntry = new ValueSetEntry();
				CodeBaseType code = new CodeBaseType();

				textContent = node.getAttributes().getNamedItem("code").getNodeValue();
				if (textContent != null)
					code.setCode(textContent);

				textContent = node.getAttributes().getNamedItem("codeSystem").getNodeValue();
				if (textContent != null)
					code.setCodeSystem(textContent);

				textContent = node.getAttributes().getNamedItem("displayName").getNodeValue();
				if (textContent != null)
					code.setDisplayName(textContent);

				valueSetEntry.setCodeBaseType(code);

				for (LanguageCode languageCode : langCodes) {
					textContent = evaluateXpathExprAsString(xmlDoc,
							"//ValueSet/ConceptList[@lang='" + languageCode.getCodeValue()
									+ "' or starts-with(@lang,'" + languageCode.getCodeValue()
									+ "')]/Concept[@code='" + code.getCode() + "' and @codeSystem='"
									+ code.getCodeSystem() + "']/@displayName");
					if (textContent != null) {
						Designation designation = Designation.builder()
								.withLanguageCode(languageCode).withDisplayName(textContent)
								.build();
						valueSetEntry.addDesignation(designation);
					}
				}

				valueSet.addValueSetEntry(valueSetEntry);
			}
		}

		valueSet.setVersion(version);

		// Name is not available in IHE SVS format
		// valueSet.setName(name);
		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/Status/text()");
		if (textContent != null)
			valueSet.setStatus(ValueSetStatus.getCodeIheSvs(textContent));

		// TODO remove following lines (debug only)
		ValueSetManager mgr = new ValueSetManager();

		mgr.saveValueSet(valueSet,
				Util.getTempDirectory() + FileUtil.getPlatformSpecificPathSeparator()
						+ "testDownloadedValueSetIheSvs.yaml");

		return valueSet;
	}

	/**
	 * Load value set ihe svs.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetIheSvs(String fileName)
			throws IOException, ParserConfigurationException, SAXException {
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
					String content = "";
					LanguageCode languageCode = null;
					for (Entry<String, Object> subEntry : subMap.entrySet()) {
						String subKey = subEntry.getKey();
						if ("language".contentEquals(subKey) && (subEntry.getValue() != null)) {
							String lang = subEntry.getValue().toString();
							languageCode = getLanguageCode(lang);
						}
						if ("content".contentEquals(subKey) && (subEntry.getValue() != null))
							content = subEntry.getValue().toString();
					}
					valueSet.addDescription(new LangText(languageCode, content));
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
							for (Object object2 : contents) {
								ValueSetEntry valueSetEntry = new ValueSetEntry();
								ValueSetEntryType valueSetEntryType = null;
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
											&& (subEntry2.getValue() != null)) {
										entryType = subEntry2.getValue().toString();
										valueSetEntryType = ValueSetEntryType.getEnum(entryType);
									}
									if ("designation".contentEquals(subKey2)
											&& (subEntry2.getValue() != null)) {
										JSONArray designations = (JSONArray) subEntry2.getValue();
										for (Object object3 : designations) {
											@SuppressWarnings("unchecked")
											Map<String, Object> subMap3 = (Map<String, Object>) object3;
											Designation designation = new Designation();
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
											valueSetEntry.addDesignation(designation);
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
								valueSetEntry.setValueSetEntryType(valueSetEntryType);
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
				+ FileUtil.getPlatformSpecificPathSeparator() + "testDownloadedValueSetJson.yaml");

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
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetXml(File valueSet)
			throws IOException, ParserConfigurationException, SAXException {
		return loadValueSetXml(new FileInputStream(valueSet));
	}

	/**
	 * Load value set xml.
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetXml(InputStream valueSet)
			throws IOException, ParserConfigurationException, SAXException {
		return loadValueSetXml(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * Load value set xml.
	 *
	 * @param reader
	 *            the reader
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetXml(InputStreamReader reader)
			throws IOException, ParserConfigurationException, SAXException {
		ValueSet valueSet = new ValueSet();
		Version version = new Version();

		String textContent;
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docBuilderFactory.newDocumentBuilder();
		Document xmlDoc = docBuilder
				.parse(IOUtils.toInputStream(IOUtils.toString(reader), Charsets.UTF_8));

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@id");
		if (textContent != null)
			valueSet.setIdentificator(
					IdentificatorBaseType.builder().withRoot(textContent).build());

		ArrayList<LanguageCode> langCodes = new ArrayList<LanguageCode>();
		NodeList nodeList = evaluateXpathExprAsNodeList(xmlDoc,
				"//valueSets/project/valueSet/desc/@language");
		for (int i = 0; i < nodeList.getLength(); i++) {
			LanguageCode languageCode = getLanguageCode(nodeList.item(i).getTextContent().trim());
			if (languageCode != null)
				langCodes.add(languageCode);
		}

		for (LanguageCode languageCode : langCodes) {
			textContent = evaluateXpathExprAsString(xmlDoc,
					"//valueSets/project/valueSet/desc[@language='" + languageCode.getCodeValue()
							+ "' or starts-with(@language,'" + languageCode.getCodeValue()
							+ "')]/text()");
			if (textContent != null)
				valueSet.addDescription(new LangText(languageCode, textContent));

		}

		textContent = evaluateXpathExprAsString(xmlDoc,
				"//valueSets/project/valueSet/@displayName");
		if (textContent != null)
			valueSet.setDisplayName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc,
				"//valueSets/project/valueSet/@effectiveDate");
		if (textContent != null)
			version.setValidFrom(DateUtil.parseDateyyyyMMdd(textContent));

		textContent = evaluateXpathExprAsString(xmlDoc,
				"//valueSets/project/valueSet/@versionLabel");
		if (textContent != null)
			version.setLabel(textContent);

		nodeList = evaluateXpathExprAsNodeList(xmlDoc,
				"/valueSets/project/valueSet/conceptList/concept");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			ValueSetEntry valueSetEntry = new ValueSetEntry();
			CodeBaseType code = new CodeBaseType();

			textContent = node.getAttributes().getNamedItem("code").getNodeValue();
			if (textContent != null)
				code.setCode(textContent);

			textContent = node.getAttributes().getNamedItem("codeSystem").getNodeValue();
			if (textContent != null)
				code.setCodeSystem(textContent);

			textContent = node.getAttributes().getNamedItem("displayName").getNodeValue();
			if (textContent != null)
				code.setDisplayName(textContent);

			textContent = node.getAttributes().getNamedItem("level").getNodeValue();
			if (textContent != null)
				valueSetEntry.setLevel(Integer.parseInt(textContent));

			textContent = node.getAttributes().getNamedItem("type").getNodeValue();
			if (textContent != null) {
				valueSetEntry.setValueSetEntryType(ValueSetEntryType.getEnum(textContent));
			}

			NodeList subNnodeList;
			subNnodeList = evaluateXpathExprAsNodeList(xmlDoc,
					"/valueSets/project/valueSet/conceptList/concept[@code='" + code.getCode()
							+ "' and @codeSystem='" + code.getCodeSystem() + "']/designation");
			for (int j = 0; j < subNnodeList.getLength(); j++) {
				Node subNode = subNnodeList.item(j);
				Designation designation = new Designation();

				textContent = subNode.getAttributes().getNamedItem("language").getNodeValue();
				if (textContent != null) {
					LanguageCode languageCode = LanguageCode.getEnum(textContent.toLowerCase());
					if (languageCode == null)
						languageCode = LanguageCode
								.getEnum(textContent.toLowerCase().substring(0, 2));
					designation.setLanguageCode(languageCode);
				}

				textContent = subNode.getAttributes().getNamedItem("type").getNodeValue();
				if (textContent != null) {
					designation.setType(DesignationType.getEnum(textContent));
				}

				textContent = subNode.getAttributes().getNamedItem("displayName").getNodeValue();
				if (textContent != null)
					designation.setDisplayName(textContent);

				valueSetEntry.addDesignation(designation);
			}

			valueSetEntry.setCodeBaseType(code);

			valueSet.addValueSetEntry(valueSetEntry);
		}

		valueSet.setVersion(version);

		// Name is not available in IHE SVS format
		// valueSet.setName(name);
		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/Status/text()");
		if (textContent != null)
			valueSet.setStatus(ValueSetStatus.getCodeIheSvs(textContent));

		// TODO remove following lines (debug only)
		ValueSetManager mgr = new ValueSetManager();

		mgr.saveValueSet(valueSet, Util.getTempDirectory()
				+ FileUtil.getPlatformSpecificPathSeparator() + "testDownloadedValueSetXml.yaml");

		return valueSet;
	}

	/**
	 * Load value set xml.
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetXml(String fileName)
			throws IOException, ParserConfigurationException, SAXException {
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
