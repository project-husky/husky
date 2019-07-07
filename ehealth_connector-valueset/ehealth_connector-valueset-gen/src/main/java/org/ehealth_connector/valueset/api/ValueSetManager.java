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
import java.io.StringWriter;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.valueset.config.CustomizedYaml;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.exceptions.InitializationException;
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
	 * <div class="en">The JSONPath path to extract a value set from the JSON
	 * definition file</div>
	 */
	public static final String JSON_VALUE_SET_BASE_PATH = "$.valueSets[0].valueSet[0]";
	/**
	 * The default encoding used to encode URL parameter.
	 */
	static final String UTF8_ENCODING = "UTF-8";

	/**
	 * <div class="en">Build the complete URL to retrieve a value set from
	 * ART-DECOR.</div>
	 *
	 * <div class="de">Erstellt die vollständige URL, um einen Wertesatz von
	 * ART-DECOR abzurufen.</div>
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
	 * <div class="en">Instantiates a ValueSetManager. Default
	 * constructor.</div>
	 *
	 * <div class="de">Instanziiert einen ValueSetManager.
	 * Standardkonstruktor.</div>
	 */
	public ValueSetManager() {
	}

	/**
	 * <div class="en">Downloads a value set as defined in the given
	 * configuration.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz herunter wie in der angegebenen
	 * Konfiguration definiert.</div>
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
	 * @throws InitializationException
	 */
	public ValueSet downloadValueSet(ValueSetConfig valueSetConfig) throws MalformedURLException,
			IOException, ParserConfigurationException, SAXException, InitializationException {
		ValueSet retVal = null;
		if (valueSetConfig != null) {
			switch (valueSetConfig.getSourceSystemType()) {
			case ARTDECOR_FHIR:
				String sourceUrlString = valueSetConfig.getSourceUrl();
				String downloadedString = "";
				try {
					downloadedString = IOUtils.toString(new URL(sourceUrlString), UTF8_ENCODING);
					downloadedString = downloadedString.replaceAll("&lt;", "<");
					downloadedString = downloadedString.replaceAll("&gt;", ">");
					downloadedString = downloadedString.replaceAll("&amp;", "&");
					downloadedString = downloadedString.replaceAll("&#160;", "&nbsp;");
					downloadedString = downloadedString.replaceAll("&nbsp;", " ");
					downloadedString = downloadedString.replaceAll("\r\n", "\n");
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
				} catch (RuntimeException e) {
					throw new InitializationException(
							"The value set cannot be loaded. Please check the content of the file/stream. (downloadedString is: '"
									+ downloadedString + "')");
				} catch (IOException e) {
					throw new InitializationException(
							"The value set cannot be loaded. Please check the location. (downloadedString is: '"
									+ sourceUrlString + "')");

				}

				break;
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Downloads a value set as defined in the given
	 * configuration. It will be returned in raw dformat exactly as
	 * downloaded.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz herunter wie in der angegebenen
	 * Konfiguration definiert. Es wird im Roh-Format genau wie heruntergeladen
	 * zurückgegeben.</div>
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

	/**
	 * Evaluates the given XPath expression into a node list.
	 *
	 * @param xmlDoc
	 *            the xml doc
	 * @param xpathExpr
	 *            the xpath expr
	 * @return the node list
	 */
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

	/**
	 * Evaluates the given XPath expression as string.
	 *
	 * @param xmlDoc
	 *            the xml doc
	 * @param xpathExpr
	 *            the xpath expr
	 * @return the string
	 */
	private String evaluateXpathExprAsString(Document xmlDoc, String xpathExpr) {
		String retVal = null;

		NodeList nodes = evaluateXpathExprAsNodeList(xmlDoc, xpathExpr);

		if (nodes != null) {
			retVal = "";
			for (int i = 0; i < nodes.getLength(); i++) {
				if (i == 0)
					retVal = retVal + nodes.item(i).getTextContent().trim();
				else {
					StringWriter writer = new StringWriter();
					Transformer transformer;
					try {
						transformer = TransformerFactory.newInstance().newTransformer();
						transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
						transformer.transform(new DOMSource(nodes.item(i)),
								new StreamResult(writer));
						retVal = retVal + writer.toString();
					} catch (TransformerFactoryConfigurationError | TransformerException e) {
						// Do nothing
					}
				}
			}
		}
		return retVal.replaceAll("\r\n", "\n").replaceAll("\n", "");
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

	/**
	 * <div class="en">Loads a value set config from the given file.</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus der angegebenen
	 * Datei</div>
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
	 * <div class="en">Loads a value set config from the given stream.</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus dem angegebenen
	 * Stream</div>
	 *
	 * @param config
	 *            the config
	 * @return the value set config
	 */
	public ValueSetConfig loadValueSetConfig(InputStream config) {
		return loadValueSetConfig(new InputStreamReader(config, Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a value set config from the given stream
	 * reader.</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus dem angegebenen
	 * Streamreader</div>
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
	 * <div class="en">Loads a value set config from the given file (the given
	 * filename must contain the relative or full path to access the
	 * file).</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus der angegebenen
	 * Datei (der angegebene Dateiname muss den relativen oder vollständigen
	 * Pfad enthalten, um auf die Datei zuzugreifen)</div>
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
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in IHE SVS format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * IHE SVS-Format bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream, which is
	 * provided in IHE SVS format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * IHE-SVS-Format bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream reader, which is
	 * provided in IHE SVS format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream-Reader,
	 * der im IHE-SVS-Format bereitgestellt wird.</div>
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

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/Purpose//node()");
		if (textContent != null)
			valueSet.addDescription(new LangText(LanguageCode.ENGLISH, textContent));

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/@displayName");
		if (textContent != null)
			valueSet.setDisplayName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc, "//ValueSet/EffectiveDate/text()");
		if (textContent != null)
			version.setValidFrom(DateUtil.parseDateyyyyMMdd2(textContent));

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
		if (textContent != null) {
			String status = textContent;

			if ("active".equals(status.toLowerCase()))
				valueSet.setStatus(ValueSetStatus.FINAL);
			if ("inactive".equals(status.toLowerCase()))
				valueSet.setStatus(ValueSetStatus.DEPRECATED);

		}

		// This is for debugging purposes, only:
		// ValueSetManager mgr = new ValueSetManager();
		// mgr.saveValueSet(valueSet,
		// Util.getTempDirectory() + FileUtil.getPlatformSpecificPathSeparator()
		// + "testDownloadedValueSetIheSvs.yaml");

		return valueSet;
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in IHE SVS format (the given filename must contain the relative or full
	 * path to access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * IHE SVS-Format bereitgestellt wird (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
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
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in JSON format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * JSON bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream, which is
	 * provided in JSON format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * JSON bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream reader, which is
	 * provided in JSON format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream-Reader,
	 * der im JSON bereitgestellt wird.</div>
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
					valueSet.addDescription(new LangText(languageCode,
							content.replaceAll("\r\n", "\n").replaceAll("\n", "")));
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

		// This is for debugging purposes, only:
		// ValueSetManager mgr = new ValueSetManager();
		// mgr.saveValueSet(valueSet, Util.getTempDirectory()
		// + FileUtil.getPlatformSpecificPathSeparator() +
		// "testDownloadedValueSetJson.yaml");

		return valueSet;
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in JSON format (the given filename must contain the relative or full path
	 * to access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * JSON-Format bereitgestellt wird (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
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
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in XML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * XML-Format bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream, which is
	 * provided in XML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * XML-Format bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream reader, which is
	 * provided in XML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream-Reader,
	 * der im XML-Format bereitgestellt wird.</div>
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
							+ "')]/node()");
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
			version.setValidFrom(DateUtil.parseDateyyyyMMddTHHmmss(textContent));

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

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@name");
		if (textContent != null)
			valueSet.setName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@statusCode");
		if (textContent != null) {
			String status = textContent;

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
		// This is for debugging purposes, only:
		// ValueSetManager mgr = new ValueSetManager();
		// mgr.saveValueSet(valueSet, Util.getTempDirectory()
		// + FileUtil.getPlatformSpecificPathSeparator() +
		// "testDownloadedValueSetXml.yaml");

		return valueSet;
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in XML format (the given filename must contain the relative or full path
	 * to access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * XML-Format bereitgestellt wird (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
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
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in YAML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * YAML-Format bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given stream, which is
	 * provided in YAML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * YAML-Format bereitgestellt wird.</div>
	 *
	 * @param valueSet
	 *            the value set
	 * @return the value set
	 */
	public ValueSet loadValueSetYaml(InputStream valueSet) {
		return loadValueSetYaml(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a value set from the given stream reader, which is
	 * provided in YAML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream-Reader,
	 * der im YAML-Format bereitgestellt wird.</div>
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
	 * <div class="en">Loads a value set from the given file, which is provided
	 * in YAML format (the given filename must contain the relative or full path
	 * to access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * YAML-Format bereitgestellt wird (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
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
	 * <div class="en">Saves the given value set in YAML format to the given
	 * file.</div>
	 *
	 * <div class="de">Speichert den angegebenen Wertesatz im YAML-Format in der
	 * angegebenen Datei.</div>
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
	 * <div class="en">Saves the given value set in YAML format to the given
	 * file (the given filename must contain the relative or full path to access
	 * the file).</div>
	 *
	 * <div class="de">Speichert den angegebenen Wertesatz im YAML-Format in der
	 * angegebenen Datei (der angegebene Dateiname muss den relativen oder
	 * vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
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
	 * <div class="en">Saves the given value set configuration in YAML format to
	 * the given file.</div>
	 *
	 * <div class="de">Speichert die angegebene Wertesatz-Konfiguration im
	 * YAML-Format in der angegebenen Datei.</div>
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
	 * <div class="en">Saves the given value set configuration in YAML format to
	 * the given file (the given filename must contain the relative or full path
	 * to access the file).</div>
	 *
	 * <div class="de">Speichert die angegebene Wertesatz-Konfiguration im
	 * YAML-Format in der angegebenen Datei (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
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
