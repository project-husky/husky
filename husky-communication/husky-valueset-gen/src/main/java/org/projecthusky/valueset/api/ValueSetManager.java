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
package org.projecthusky.valueset.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.projecthusky.common.basetypes.AddressBaseType;
import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.CustomizedYaml;
import org.projecthusky.common.utils.LangText;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.enums.DesignationType;
import org.projecthusky.valueset.enums.SourceSystemType;
import org.projecthusky.valueset.enums.ValueSetEntryType;
import org.projecthusky.valueset.enums.ValueSetStatus;
import org.projecthusky.valueset.exceptions.InitializationException;
import org.projecthusky.valueset.model.CustomNamespaceContext;
import org.projecthusky.valueset.model.Designation;
import org.projecthusky.valueset.model.ValueSet;
import org.projecthusky.valueset.model.ValueSetEntry;
import org.projecthusky.valueset.model.Version;
import org.projecthusky.valueset.utils.VsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

/**
 *
 * <div class="en">Manages the handling of ValueSets such as download from an
 * URL, save to and load from a file.</div>
 *
 * <div class="de">Verwaltet die Verarbeitung von ValueSets, z. B. Herunterladen
 * von einer URL, Speichern in und Laden aus einer Datei.</div>
 */
public class ValueSetManager {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(ValueSetManager.class);

	private static final String ELEMENT_NAME_CODE_SYSTEM = "codeSystem";
	private static final String ELEMENT_NAME_CODE = "code";
	private static final String ELEMENT_NAME_DISPLAY_NAME = "displayName";
	private static final String ELEMENT_NAME_LANGUAGE = "language";

	/**
	 * <div class="en">The JSONPath path to extract a value set from the JSON
	 * definition file</div>
	 */
	public static final String JSON_VALUE_SET_BASE_PATH = "$.valueSet[0]";

	/**
	 * <div class="en">Build the complete URL to retrieve a value set from
	 * ART-DECOR.</div>
	 *
	 * <div class="de">Erstellt die vollständige URL, um einen Wertesatz von
	 * ART-DECOR abzurufen.</div>
	 *
	 * @param baseUrl       The base URL that includes host, path and prefix.
	 * @param id            the id
	 * @param effectiveDate the effective date
	 * @return The complete URL to download a value set in JSON format.
	 * @throws MalformedURLException When the provided baseUrl is invalid.
	 */
	public static URL buildValueSetArtDecorUrl(String baseUrl, IdentificatorBaseType id, Date effectiveDate)
			throws MalformedURLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return new URL(
				baseUrl + "&id=" + java.net.URLEncoder.encode(id.getRoot(), StandardCharsets.UTF_8) + "&effectiveDate="
						+ java.net.URLEncoder.encode(dateFormat.format(effectiveDate), StandardCharsets.UTF_8));
	}

	/**
	 * <div class="en">Downloads a value set as defined in the given
	 * configuration.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz herunter wie in der angegebenen
	 * Konfiguration definiert.</div>
	 *
	 * @param valueSetConfig the value set config
	 * @return the value set
	 * @throws MalformedURLException        the malformed URL exception
	 * @throws IOException                  Signals that an I/O exception has
	 *                                      occurred.
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws InitializationException
	 */
	public ValueSet downloadValueSet(ValueSetConfig valueSetConfig)
			throws IOException, ParserConfigurationException, SAXException, InitializationException {
		ValueSet retVal = null;
		if (valueSetConfig != null && SourceSystemType.ARTDECOR_FHIR.equals(valueSetConfig.getSourceSystemType())) {
			var sourceUrlString = valueSetConfig.getSourceUrl();
			var downloadedString = "";
			try {
				downloadedString = VsUtils.downloadAsString(new URL(sourceUrlString));
				downloadedString = downloadedString.replace("&lt;", "<");
				downloadedString = downloadedString.replace("&gt;", ">");
				downloadedString = downloadedString.replace("&amp;", "&");
				downloadedString = downloadedString.replace("&#160;", "&nbsp;");
				downloadedString = downloadedString.replace("&nbsp;", " ");
				downloadedString = downloadedString.replace("\r\n", "\n");
				switch (valueSetConfig.getSourceFormatType()) {
				case JSON:
					retVal = loadValueSetJson(IOUtils.toInputStream(downloadedString, StandardCharsets.UTF_8));
					break;
				case XML:
					retVal = loadValueSetXml(IOUtils.toInputStream(downloadedString, StandardCharsets.UTF_8));
					break;
				case IHESVS:
					retVal = loadValueSetIheSvs(IOUtils.toInputStream(downloadedString, StandardCharsets.UTF_8));
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

		}
		return retVal;
	}

	/**
	 * <div class="en">Downloads a value set as defined in the given configuration.
	 * It will be returned in raw dformat exactly as downloaded.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz herunter wie in der angegebenen
	 * Konfiguration definiert. Es wird im Roh-Format genau wie heruntergeladen
	 * zurückgegeben.</div>
	 *
	 * @param valueSetConfig the value set config
	 * @return the output stream
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public byte[] downloadValueSetRaw(ValueSetConfig valueSetConfig) throws IOException {
		byte[] retVal = null;
		if (valueSetConfig != null && SourceSystemType.ARTDECOR_FHIR.equals(valueSetConfig.getSourceSystemType())) {
			retVal = VsUtils.downloadAsByteArray(new URL(valueSetConfig.getSourceUrl()));
		}
		return retVal;
	}

	/**
	 * Evaluates the given XPath expression into a node list.
	 *
	 * @param xmlDoc    the xml doc
	 * @param xpathExpr the xpath expr
	 * @return the node list
	 */
	private NodeList evaluateXpathExprAsNodeList(Document xmlDoc, String xpathExpr) {
		NodeList retVal = null;

		var xpathFactory = XPathFactory.newInstance();
		var xpath = xpathFactory.newXPath();
		xpath.setNamespaceContext(new CustomNamespaceContext());
		XPathExpression expr;

		try {
			expr = xpath.compile(xpathExpr);
			retVal = (NodeList) expr.evaluate(xmlDoc, XPathConstants.NODESET);

		} catch (XPathExpressionException e) {
			log.error(e.getMessage(), e);
		}

		return retVal;

	}

	/**
	 * Evaluates the given XPath expression as string.
	 *
	 * @param xmlDoc    the xml doc
	 * @param xpathExpr the xpath expr
	 * @return the string
	 */
	private String evaluateXpathExprAsString(Document xmlDoc, String xpathExpr) {
		var retVal = new StringBuilder("");

		var nodes = evaluateXpathExprAsNodeList(xmlDoc, xpathExpr);

		if (nodes != null) {
			for (var i = 0; i < nodes.getLength(); i++) {
				if (i == 0) {
					retVal.append(nodes.item(i).getTextContent().trim());
				} else {
					var writer = new StringWriter();
					Transformer transformer;
					try {
						var transformerFactory = TransformerFactory.newInstance();
						transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
						transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
						transformer = transformerFactory.newTransformer();
						transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
						transformer.transform(new DOMSource(nodes.item(i)), new StreamResult(writer));
						retVal.append(writer.toString());
					} catch (TransformerFactoryConfigurationError | TransformerException e) {
						// Do nothing
					}
				}
			}
		}

		return retVal.toString().replace("\r\n", "\n").replace("\n", "");
	}

	/**
	 * Gets the language code from a given textContent out of JSON or XML (including
	 * IHE SVS).
	 *
	 * @param textContent the text content
	 * @return the language code
	 */
	private LanguageCode getLanguageCode(String textContent) {
		var languageCode = LanguageCode.getEnum(textContent);
		if (languageCode == null)
			languageCode = LanguageCode.getEnum(textContent.substring(0, 2));
		return languageCode;
	}

	/**
	 * Gets the value set as a json map.
	 *
	 * @param reader the reader
	 * @return the value set as a json map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private Map<String, Object> getValueSetJsonMap(InputStreamReader reader) throws IOException {
		var json = IOUtils.toString(reader);
		return JsonPath.read(json, JSON_VALUE_SET_BASE_PATH);
	}

	/**
	 * <div class="en">Loads a value set config from the given file.</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus der angegebenen
	 * Datei</div>
	 *
	 * @param config the config
	 * @return the value set config
	 * @throws IOException
	 */
	public ValueSetConfig loadValueSetConfig(File config) throws IOException {
		try (var is = new FileInputStream(config)) {
			return loadValueSetConfig(is);
		}
	}

	/**
	 * <div class="en">Loads a value set config from the given stream.</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus dem angegebenen
	 * Stream</div>
	 *
	 * @param inputStream the config
	 * @return the value set config
	 */
	public ValueSetConfig loadValueSetConfig(InputStream inputStream) {
		var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		return CustomizedYaml.getCustomizedYaml().loadAs(reader, ValueSetConfig.class);
	}

	/**
	 * <div class="en">Loads a value set config from the given file (the given
	 * filename must contain the relative or full path to access the file).</div>
	 *
	 * <div class="de">Lädt eine Wertesatzkonfiguration aus der angegebenen Datei
	 * (der angegebene Dateiname muss den relativen oder vollständigen Pfad
	 * enthalten, um auf die Datei zuzugreifen)</div>
	 *
	 * @param fileName the file name
	 * @return the value set config
	 * @throws IOException
	 */
	public ValueSetConfig loadValueSetConfig(String fileName) throws IOException {
		return loadValueSetConfig(new File(fileName));
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * IHE SVS format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im IHE
	 * SVS-Format bereitgestellt wird.</div>
	 *
	 * @param valueSet the value set
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetIheSvs(File valueSet) throws IOException, ParserConfigurationException, SAXException {
		try (var is = new FileInputStream(valueSet)) {
			return loadValueSetIheSvs(is);
		}
	}

	/**
	 * <div class="en">Loads a value set from the given stream, which is provided in
	 * IHE SVS format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * IHE-SVS-Format bereitgestellt wird.</div>
	 *
	 * @param inputStream the value set
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetIheSvs(InputStream inputStream)
			throws IOException, ParserConfigurationException, SAXException {
		var valueSet = new ValueSet();
		var version = new Version();
		String textContent;
		Document xmlDoc = getDocument(inputStream);

		textContent = evaluateXpathExprAsString(xmlDoc, "//ihesvs:ValueSet/@id");
		if (textContent != null)
			valueSet.setIdentificator(IdentificatorBaseType.builder().withRoot(textContent).build());

		textContent = evaluateXpathExprAsString(xmlDoc, "//ihesvs:ValueSet/ihesvs:Purpose//node()");
		if (textContent != null)
			valueSet.addDescription(new LangText(LanguageCode.ENGLISH, textContent));

		textContent = evaluateXpathExprAsString(xmlDoc, "//ihesvs:ValueSet/@displayName");
		if (textContent != null)
			valueSet.setDisplayName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc, "//ihesvs:ValueSet/ihesvs:EffectiveDate/text()");
		if (textContent != null)
			version.setValidFrom(getValidFromDate(textContent));

		textContent = evaluateXpathExprAsString(xmlDoc, "//ihesvs:ValueSet/@version");
		if (textContent != null)
			version.setLabel(textContent);

		ArrayList<LanguageCode> langCodes = new ArrayList<>();
		NodeList nodeList;
		nodeList = evaluateXpathExprAsNodeList(xmlDoc, "//ihesvs:ValueSet/ihesvs:ConceptList/@lang");

		if (nodeList != null) {
			for (var i = 0; i < nodeList.getLength(); i++) {
				var languageCode = getLanguageCode(nodeList.item(i).getTextContent().trim());
				if (languageCode != null)
					langCodes.add(languageCode);
			}
		}

		nodeList = evaluateXpathExprAsNodeList(xmlDoc, "//ihesvs:ValueSet/ihesvs:ConceptList[1]/ihesvs:Concept");

		if (nodeList != null) {
			valueSet.getValueSetEntryList().addAll(getValueSetEntries(nodeList, langCodes, xmlDoc));
		}

		valueSet.setVersion(version);

		// Name is not available in IHE SVS format

		textContent = evaluateXpathExprAsString(xmlDoc, "//ihesvs:ValueSet/ihesvs:Status/text()");
		if (textContent != null) {
			valueSet.setStatus(getValueSetStatus(textContent));
		}

		return valueSet;
	}

	private List<ValueSetEntry> getValueSetEntries(NodeList nodeList, ArrayList<LanguageCode> langCodes,
			Document xmlDoc) {
		List<ValueSetEntry> entries = new LinkedList<>();
		String textContent = null;

		if (nodeList != null) {
			for (var i = 0; i < nodeList.getLength(); i++) {
				var node = nodeList.item(i);
				if ("Concept".equals(node.getNodeName())) {
					var valueSetEntry = new ValueSetEntry();
					var code = createCode(node);

					valueSetEntry.setCodeBaseType(code);

					for (LanguageCode languageCode : langCodes) {
						textContent = evaluateXpathExprAsString(xmlDoc,
								"//ihesvs:ValueSet/ihesvs:ConceptList[@lang='" + languageCode.getCodeValue()
										+ "' or starts-with(@lang,'" + languageCode.getCodeValue()
										+ "')]/Concept[@code='" + code.getCode() + "' and @codeSystem='"
										+ code.getCodeSystem() + "']/@displayName");
						if (textContent != null) {
							var designation = Designation.builder().withLanguageCode(languageCode)
									.withDisplayName(textContent).build();
							valueSetEntry.addDesignation(designation);
						}
					}

					entries.add(valueSetEntry);
				}
			}
		}

		return entries;
	}

	private ValueSetStatus getValueSetStatus(String status) {
		if ("active".equalsIgnoreCase(status))
			return ValueSetStatus.FINAL;
		if ("inactive".equalsIgnoreCase(status))
			return ValueSetStatus.DEPRECATED;

		return null;
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * IHE SVS format (the given filename must contain the relative or full path to
	 * access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im IHE
	 * SVS-Format bereitgestellt wird (der angegebene Dateiname muss den relativen
	 * oder vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param fileName the file name
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetIheSvs(String fileName) throws IOException, ParserConfigurationException, SAXException {
		return loadValueSetIheSvs(new File(fileName));
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * JSON format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im JSON
	 * bereitgestellt wird.</div>
	 *
	 * @param valueSet the value set
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(File valueSet) throws IOException {
		try (var is = new FileInputStream(valueSet)) {
			return loadValueSetJson(is);
		}
	}

	/**
	 * <div class="en">Loads a value set from the given stream, which is provided in
	 * JSON format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im JSON
	 * bereitgestellt wird.</div>
	 *
	 * @param inputStream the value set
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(InputStream inputStream) throws IOException {
		var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		var valueSet = new ValueSet();
		var version = new Version();
		valueSet.setVersion(version);
		Map<String, Object> map = getValueSetJsonMap(reader);
		for (Entry<String, Object> entry : map.entrySet()) {
			setValueSetValues(valueSet, entry.getKey(), entry.getValue());
		}

		return valueSet;

	}

	private void setValueSetValues(ValueSet valueSet, String key, Object value) {
		if (value == null) {
			return;
		}

		if ("id".contentEquals(key)) {
			valueSet.setIdentificator(IdentificatorBaseType.builder().withRoot(value.toString()).build());
		} else if ("name".contentEquals(key)) {
			valueSet.setName(value.toString());
		} else if (ELEMENT_NAME_DISPLAY_NAME.contentEquals(key)) {
			valueSet.setDisplayName(value.toString());
		} else if ("versionLabel".contentEquals(key)) {
			valueSet.getVersion().setLabel(value.toString());
		} else if ("effectiveDate".contentEquals(key)) {
			valueSet.getVersion().setValidFrom(getValidFromDate(value.toString()));
		} else if ("statusCode".contentEquals(key)) {
			var status = value.toString();
			valueSet.setStatus(getStatusCode(status));
		} else if ("desc".contentEquals(key)
				&& (value.getClass() == JSONArray.class)) {
			JSONArray descs = (JSONArray) value;
			valueSet.getDescriptionList().addAll(getDescriptions(descs));
		} else if ("publishingAuthority".contentEquals(key)
				&& (value.getClass() == JSONArray.class)) {
			JSONArray descs = (JSONArray) value;
			valueSet.getVersion().setPublishingAuthority(getPublishingAuthority(descs));
		} else if ("conceptList".contentEquals(key) 
				&& (value.getClass() == JSONArray.class)) {
			JSONArray concepts = (JSONArray) value;
			addValueSetEntries(concepts, valueSet);
		}
	}

	private Date getValidFromDate(String value) {
		try {
			SimpleDateFormat sdf = null;
			if (value.length() == 10) {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			}

			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date: [" + value + "]. Expected format is yyyy-MM-ddTHH:mm:ss.", e);
		}
	}

	private OrganizationBaseType getPublishingAuthority(JSONArray descs) {
		var org = new OrganizationBaseType();
		AddressBaseType addr = null;
		for (Object object : descs) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subMap = (Map<String, Object>) object;
			for (Entry<String, Object> subEntry : subMap.entrySet()) {
				String subKey = subEntry.getKey();
				if ("name".contentEquals(subKey) && (subEntry.getValue() != null)) {
					org.addName(NameBaseType.builder().withName(subEntry.getValue().toString()).build());
				}
				if ("addrLine".contentEquals(subKey) && (subEntry.getValue() != null)) {
					JSONArray contents = (JSONArray) subEntry.getValue();
					addr = getAddress(contents);
				}
			}
		}
		if (addr != null)
			org.addAddress(addr);

		return org;
	}

	private AddressBaseType getAddress(JSONArray contents) {
		var addr = AddressBaseType.builder().build();
		for (Object object2 : contents) {
			extractAddressLines(addr, object2);
		}

		return addr;
	}

	/* complexity currently 16 (borderline) => do not fix */
	@SuppressWarnings("java:S3776")
	private void extractAddressLines(AddressBaseType addr, Object object2) {
		String type = null;
		String content = null;
		if (object2 instanceof String contentString) {
			content = contentString;
		} else if (object2 instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subMap2 = (Map<String, Object>) object2;
			for (Entry<String, Object> subEntry2 : subMap2.entrySet()) {
				type = null;
				String subKey2 = subEntry2.getKey();
				if ("type".contentEquals(subKey2) && (subEntry2.getValue() != null))
					type = subEntry2.getValue().toString();

				if ("content".contentEquals(subKey2) && (subEntry2.getValue() != null))
					content = subEntry2.getValue().toString();
			}
		}

		// type:uri is not implemented, yet. Feel free
		// to add when you use it.
		if (type == null) {
			if (addr.getStreetAddressLine1() == null) {
				addr.setStreetAddressLine1(content);
			} else if (addr.getStreetAddressLine2() == null) {
				addr.setStreetAddressLine2(content);
			}
		}
	}

	private List<LangText> getDescriptions(JSONArray descs) {
		List<LangText> descriptions = new LinkedList<>();
		for (Object object : descs) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subMap = (Map<String, Object>) object;
			var content = "";
			LanguageCode languageCode = null;
			for (Entry<String, Object> subEntry : subMap.entrySet()) {
				String subKey = subEntry.getKey();
				if (ELEMENT_NAME_LANGUAGE.contentEquals(subKey) && (subEntry.getValue() != null)) {
					String lang = subEntry.getValue().toString();
					languageCode = getLanguageCode(lang);
				}
				if (("content".equals(subKey) || "#text".equals(subKey)) && (subEntry.getValue() != null))
					content = subEntry.getValue().toString();
			}
			descriptions.add(new LangText(languageCode,
					content.replace("\r\n", "\n").replace("\n", "").replaceAll("\\s+", " ").trim()));
		}

		return descriptions;
	}

	private void addValueSetEntries(JSONArray concepts, ValueSet valueSet) {
		ValueSetEntry lastValueSetEntry = null;
		for (Object object : concepts) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subMap = (Map<String, Object>) object;
			for (Entry<String, Object> subEntry : subMap.entrySet()) {
				String subKey = subEntry.getKey();
				if ("concept".contentEquals(subKey) && (subEntry.getValue() != null)) {
					JSONArray contents = (JSONArray) subEntry.getValue();
					for (Object object2 : contents) {
						lastValueSetEntry = addValueSetEntry(object2, valueSet, lastValueSetEntry);
					}
				}
			}
		}
	}

	/* complexity borderline => do not fix */
	@SuppressWarnings("java:S3776")
	private ValueSetEntry addValueSetEntry(Object object2, ValueSet valueSet, ValueSetEntry lastValueSetEntry) {

		var valueSetEntry = getValueSetEntry(object2);

		if (lastValueSetEntry == null)
			// it is the very first entry. Thus it will
			// be added to the main list
			valueSet.addValueSetEntry(valueSetEntry);
		else {
			// note for developers:
			// This code was tested with this value Set:
			// http://ehealthsuisse.art-decor.org/ch-epr-html-20190701T210605/voc-2.16.756.5.30.1.127.3.10.1.30-2018-03-06T135538.html
			// This value Set has 2 hierarchy levels,
			// only. If you get into trouble with
			// valueSets having 3 and more hierarchy
			// levels, feel free to contribute bug fixes
			// if needed.
			if (lastValueSetEntry.getLevel() == valueSetEntry.getLevel()) {
				// the new entry is a sibling of the
				// last one. Therefore it will be added
				// to the same parent
				if (lastValueSetEntry.getParent() == null)
					// there is no parent. The entry is
					// added to the main list
					valueSet.addValueSetEntry(valueSetEntry);
				else {
					// there is a parent. The entry is
					// added to the parent
					valueSetEntry.setParent(lastValueSetEntry.getParent());
					lastValueSetEntry.getParent().addChild(valueSetEntry);
				}
			}

			if (lastValueSetEntry.getLevel() < valueSetEntry.getLevel()) {
				// the new entry has a deeper level as
				// the last one. It becomes a child of
				// the last one and the last one becomes
				// his parent
				valueSetEntry.setParent(lastValueSetEntry);
				lastValueSetEntry.addChild(valueSetEntry);
			}

			if (lastValueSetEntry.getLevel() > valueSetEntry.getLevel()) {
				// the new entry has a higher level as
				// the last one. It gets added to the
				// parent list.
				if (lastValueSetEntry.getParent() == null || lastValueSetEntry.getParent().getParent() == null)
					// there is no parent. The entry is
					// added to the main list
					valueSet.addValueSetEntry(valueSetEntry);
				else {
					// there is a parent. The entry is
					// added to the parent
					valueSetEntry.setParent(lastValueSetEntry.getParent().getParent());
					lastValueSetEntry.getParent().getParent().addChild(valueSetEntry);
				}
			}

		}
		return valueSetEntry;
	}

	private ValueSetEntry getValueSetEntry(Object object2) {
		var valueSetEntry = new ValueSetEntry();

		@SuppressWarnings("unchecked")
		Map<String, Object> subMap2 = (Map<String, Object>) object2;
		valueSetEntry.setCodeBaseType(CodeBaseType.builder().build());

		for (Entry<String, Object> subEntry2 : subMap2.entrySet()) {
			setValueSetEntryValues(valueSetEntry, subEntry2.getKey(), subEntry2.getValue());
		}

		return valueSetEntry;
	}

	private void setValueSetEntryValues(ValueSetEntry valueSetEntry, String subKey2, Object value) {
		if (value == null) {
			return;
		}

		if (ELEMENT_NAME_CODE.contentEquals(subKey2)) {
			valueSetEntry.getCodeBaseType().setCode(value.toString());
		} else if (ELEMENT_NAME_CODE_SYSTEM.contentEquals(subKey2)) {
			valueSetEntry.getCodeBaseType().setCodeSystem(value.toString());
		} else if (ELEMENT_NAME_DISPLAY_NAME.contentEquals(subKey2)) {
			valueSetEntry.getCodeBaseType().setDisplayName(value.toString());
		} else if ("level".contentEquals(subKey2)) {
			valueSetEntry.setLevel(getLevel(value.toString()));
		} else if ("type".contentEquals(subKey2)) {
			valueSetEntry.setValueSetEntryType(ValueSetEntryType.getEnum(value.toString()));
		} else if ("designation".contentEquals(subKey2)) {
			JSONArray designations = (JSONArray) value;
			valueSetEntry.getDesignationList().addAll(getDesignations(designations));
		}
	}

	private int getLevel(String levelLit) {
		var level = 0;
		try {
			level = Integer.parseInt(levelLit);
		} catch (Exception e) {
			// do nothing; default is 0.
		}

		return level;
	}

	private List<Designation> getDesignations(JSONArray designations) {
		List<Designation> designationList = new LinkedList<>();
		for (Object object3 : designations) {
			@SuppressWarnings("unchecked")
			Map<String, Object> subMap3 = (Map<String, Object>) object3;
			var designation = new Designation();
			for (Entry<String, Object> subEntry3 : subMap3.entrySet()) {
				String subKey3 = subEntry3.getKey();
				if (ELEMENT_NAME_LANGUAGE.contentEquals(subKey3) && (subEntry3.getValue() != null)) {
					
					designation.setLanguageCode(getLanguageCode(subEntry3.getValue()));
				}
				if ("type".contentEquals(subKey3) && (subEntry3.getValue() != null)) {
					designation.setType(getDesignationType(subEntry3.getValue().toString()));
				}
				if (ELEMENT_NAME_DISPLAY_NAME.contentEquals(subKey3) && (subEntry3.getValue() != null))
					designation.setDisplayName(subEntry3.getValue().toString());
			}
			designationList.add(designation);
		}

		return designationList;
	}
	
	private LanguageCode getLanguageCode(Object value) {
		var languageCode = LanguageCode.getEnum(value.toString().toLowerCase());
		if (languageCode == null)
			languageCode = LanguageCode
					.getEnum(value.toString().toLowerCase().substring(0, 2));

		return languageCode;
	}

	private DesignationType getDesignationType(String type) {
		if ("abbreviation".equalsIgnoreCase(type))
			return DesignationType.ABBREVIATION;
		if ("fsn".equalsIgnoreCase(type))
			return DesignationType.FULLY_SPECIFIED_NAME;
		if ("preferred".equalsIgnoreCase(type))
			return DesignationType.PREFERRED;
		if ("synonym".equalsIgnoreCase(type))
			return DesignationType.SYNONYM;

		return null;
	}

	private ValueSetStatus getStatusCode(String status) {
		// new: Value set just created and is new and work in progress
		// to become a draft/finalized value set. Beyond the author,
		// nobody should look at this value set unless it's status code
		// is draft or finalized.
		if ("new".equalsIgnoreCase(status))
			return ValueSetStatus.NEW;
		// draft: Value set under development (nascent). Metadata and
		// value set may be incomplete. Entered primarily to encourage
		// other users to be aware of ongoing process.
		if ("draft".equalsIgnoreCase(status))
			return ValueSetStatus.DRAFT;

		// final: Value set has been published by the custodian
		// organization and deemed fit for use. May have associated
		// adoption and annotation metadata
		if ("final".equalsIgnoreCase(status))
			return ValueSetStatus.FINAL;

		// deprecated: Value set retired: No longer fit for use.
		// Information available for historical reference.
		if ("deprecated".equalsIgnoreCase(status))
			return ValueSetStatus.DEPRECATED;

		// rejected: Value set is rejected
		if ("rejected".equalsIgnoreCase(status))
			return ValueSetStatus.REJECTED;

		// cancelled: Value set is withdrawn
		if ("cancelled".equalsIgnoreCase(status))
			return ValueSetStatus.CANCELLED;

		return null;
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * JSON format (the given filename must contain the relative or full path to
	 * access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * JSON-Format bereitgestellt wird (der angegebene Dateiname muss den relativen
	 * oder vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param fileName the file name
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetJson(String fileName) throws IOException {
		return loadValueSetJson(new File(fileName));
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * XML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * XML-Format bereitgestellt wird.</div>
	 *
	 * @param valueSet the value set
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetXml(File valueSet) throws IOException, ParserConfigurationException, SAXException {
		try (var is = new FileInputStream(valueSet)) {
			return loadValueSetXml(is);
		}
	}

	/**
	 * <div class="en">Loads a value set from the given stream, which is provided in
	 * XML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * XML-Format bereitgestellt wird.</div>
	 *
	 * @param inputStream the value set
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetXml(InputStream inputStream)
			throws IOException, ParserConfigurationException, SAXException {
		var valueSet = new ValueSet();
		var version = new Version();
		String textContent;
		Document xmlDoc = getDocument(inputStream);

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@id");
		if (textContent != null)
			valueSet.setIdentificator(IdentificatorBaseType.builder().withRoot(textContent).build());

		valueSet.getDescriptionList().addAll(getDescriptions(xmlDoc));

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@displayName");
		if (textContent != null)
			valueSet.setDisplayName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@effectiveDate");
		if (textContent != null)
			version.setValidFrom(getValidFromDate(textContent));

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@versionLabel");
		if (textContent != null)
			version.setLabel(textContent);

		var nodeList = evaluateXpathExprAsNodeList(xmlDoc, "/valueSets/project/valueSet/conceptList/concept");

		if (nodeList != null) {
			for (var i = 0; i < nodeList.getLength(); i++) {
				valueSet.addValueSetEntry(getValueSetEntry(nodeList.item(i), xmlDoc));
			}
		}

		valueSet.setVersion(version);

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@name");
		if (textContent != null)
			valueSet.setName(textContent);

		textContent = evaluateXpathExprAsString(xmlDoc, "//valueSets/project/valueSet/@statusCode");
		if (textContent != null) {
			String status = textContent;
			valueSet.setStatus(getStatusCode(status));
		}

		return valueSet;
	}

	private List<LangText> getDescriptions(Document xmlDoc) {
		List<LangText> descriptions = new LinkedList<>();
		ArrayList<LanguageCode> langCodes = new ArrayList<>();
		var nodeList = evaluateXpathExprAsNodeList(xmlDoc, "//valueSets/project/valueSet/desc/@language");

		if (nodeList != null) {
			for (var i = 0; i < nodeList.getLength(); i++) {
				var languageCode = getLanguageCode(nodeList.item(i).getTextContent().trim());
				if (languageCode != null)
					langCodes.add(languageCode);
			}
		}

		String textContent = null;
		for (LanguageCode languageCode : langCodes) {
			textContent = evaluateXpathExprAsString(xmlDoc,
					"//valueSets/project/valueSet/desc[@language='" + languageCode.getCodeValue()
							+ "' or starts-with(@language,'" + languageCode.getCodeValue() + "')]/node()");
			if (textContent != null)
				descriptions.add(new LangText(languageCode, textContent));

		}

		return descriptions;
	}

	private ValueSetEntry getValueSetEntry(Node node, Document xmlDoc) {
		var valueSetEntry = new ValueSetEntry();
		var code = createCode(node);

		String textContent = node.getAttributes().getNamedItem("level").getNodeValue();
		if (textContent != null)
			valueSetEntry.setLevel(Integer.parseInt(textContent));

		textContent = node.getAttributes().getNamedItem("type").getNodeValue();
		if (textContent != null) {
			valueSetEntry.setValueSetEntryType(ValueSetEntryType.getEnum(textContent));
		}

		NodeList subNnodeList;
		subNnodeList = evaluateXpathExprAsNodeList(xmlDoc, "/valueSets/project/valueSet/conceptList/concept[@code='"
				+ code.getCode() + "' and @codeSystem='" + code.getCodeSystem() + "']/designation");

		if (subNnodeList != null) {
			for (var j = 0; j < subNnodeList.getLength(); j++) {
				valueSetEntry.addDesignation(getDesignation(subNnodeList.item(j)));
			}
		}

		valueSetEntry.setCodeBaseType(code);

		return valueSetEntry;
	}

	private Designation getDesignation(Node subNode) {
		var designation = new Designation();

		String textContent = subNode.getAttributes().getNamedItem(ELEMENT_NAME_LANGUAGE).getNodeValue();
		if (textContent != null) {
			var languageCode = LanguageCode.getEnum(textContent.toLowerCase());
			if (languageCode == null)
				languageCode = LanguageCode.getEnum(textContent.toLowerCase().substring(0, 2));
			designation.setLanguageCode(languageCode);
		}

		textContent = subNode.getAttributes().getNamedItem("type").getNodeValue();
		if (textContent != null) {
			designation.setType(DesignationType.getEnum(textContent));
		}

		textContent = subNode.getAttributes().getNamedItem(ELEMENT_NAME_DISPLAY_NAME).getNodeValue();
		if (textContent != null)
			designation.setDisplayName(textContent);

		return designation;
	}

	private Document getDocument(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

		DocumentBuilder docBuilder = XmlFactories.newSafeDocumentBuilder();

		try (InputStream is = IOUtils.toInputStream(IOUtils.toString(reader), StandardCharsets.UTF_8)) {
			return docBuilder.parse(is);
		}
	}

	private CodeBaseType createCode(org.w3c.dom.Node node) {
		var code = new CodeBaseType();

		String textContent = node.getAttributes().getNamedItem(ELEMENT_NAME_CODE).getNodeValue();
		if (textContent != null)
			code.setCode(textContent);

		textContent = node.getAttributes().getNamedItem(ELEMENT_NAME_CODE_SYSTEM).getNodeValue();
		if (textContent != null)
			code.setCodeSystem(textContent);

		textContent = node.getAttributes().getNamedItem(ELEMENT_NAME_DISPLAY_NAME).getNodeValue();
		if (textContent != null)
			code.setDisplayName(textContent);

		return code;
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * XML format (the given filename must contain the relative or full path to
	 * access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * XML-Format bereitgestellt wird (der angegebene Dateiname muss den relativen
	 * oder vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param fileName the file name
	 * @return the value set
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public ValueSet loadValueSetXml(String fileName) throws IOException, ParserConfigurationException, SAXException {
		return loadValueSetXml(new File(fileName));
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * YAML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * YAML-Format bereitgestellt wird.</div>
	 *
	 * @param valueSet the value set
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetYaml(File valueSet) throws IOException {
		try (var is = new FileInputStream(valueSet)) {
			return loadValueSetYaml(is);
		}
	}

	/**
	 * <div class="en">Loads a value set from the given stream, which is provided in
	 * YAML format.</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus dem angegebenen Stream, der im
	 * YAML-Format bereitgestellt wird.</div>
	 *
	 * @param inputStream the value set
	 * @return the value set
	 */
	public ValueSet loadValueSetYaml(InputStream inputStream) {
		var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		return CustomizedYaml.getCustomizedYaml().loadAs(reader, ValueSet.class);
	}

	/**
	 * <div class="en">Loads a value set from the given file, which is provided in
	 * YAML format (the given filename must contain the relative or full path to
	 * access the file).</div>
	 *
	 * <div class="de">Lädt einen Wertesatz aus der angegebenen Datei, die im
	 * YAML-Format bereitgestellt wird (der angegebene Dateiname muss den relativen
	 * oder vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param fileName the file name
	 * @return the value set
	 * @throws IOException
	 */
	public ValueSet loadValueSetYaml(String fileName) throws IOException {
		return loadValueSetYaml(new File(fileName));
	}

	/**
	 * <div class="en">Saves the given value set in YAML format to the given
	 * file.</div>
	 *
	 * <div class="de">Speichert den angegebenen Wertesatz im YAML-Format in der
	 * angegebenen Datei.</div>
	 *
	 * @param valueSet the value set
	 * @param file     the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, File file) throws IOException {
		try (var fileOutputStream = new FileOutputStream(file)) {
			saveValueSet(valueSet, fileOutputStream);
		}
	}

	/**
	 * <div class="en">Saves the given value set in YAML format to the given output
	 * stream.</div>
	 *
	 * <div class="de">Speichert den angegebenen Wertesatz im YAML-Format in der
	 * angegebenen Datei.</div>
	 *
	 * @param valueSet     the value set
	 * @param outputStream the outputStream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, OutputStream outputStream) throws IOException {
		var writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
		writer.write(CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSet));
		writer.flush();
		writer.close();
	}

	/**
	 * <div class="en">Saves the given value set in YAML format to the given file
	 * (the given filename must contain the relative or full path to access the
	 * file).</div>
	 *
	 * <div class="de">Speichert den angegebenen Wertesatz im YAML-Format in der
	 * angegebenen Datei (der angegebene Dateiname muss den relativen oder
	 * vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param valueSet the value set
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, String fileName) throws IOException {
		saveValueSet(valueSet, new File(fileName));
	}

	/**
	 * <div class="en">Saves the given value set configuration in YAML format to the
	 * given file.</div>
	 *
	 * <div class="de">Speichert die angegebene Wertesatz-Konfiguration im
	 * YAML-Format in der angegebenen Datei.</div>
	 *
	 * @param valueSetConfig the value set config
	 * @param file           the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveValueSetConfig(ValueSetConfig valueSetConfig, File file) throws IOException {
		try (var fileOutputStream = new FileOutputStream(file)) {
			saveValueSetConfig(valueSetConfig, fileOutputStream);
		}
	}

	/**
	 * <div class="en">Saves the given value set configuration in YAML format to the
	 * given output stream.</div>
	 *
	 * <div class="de">Speichert die angegebene Wertesatz-Konfiguration im
	 * YAML-Format in der angegebenen Datei.</div>
	 *
	 * @param valueSetConfig the value set config
	 * @param outputStream   the outputStream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveValueSetConfig(ValueSetConfig valueSetConfig, OutputStream outputStream) throws IOException {
		var writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
		writer.write(CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSetConfig));
		writer.flush();
		writer.close();
	}

	/**
	 * <div class="en">Saves the given value set configuration in YAML format to the
	 * given file (the given filename must contain the relative or full path to
	 * access the file).</div>
	 *
	 * <div class="de">Speichert die angegebene Wertesatz-Konfiguration im
	 * YAML-Format in der angegebenen Datei (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
	 *
	 * @param valueSetConfig the value set config
	 * @param fileName       the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveValueSetConfig(ValueSetConfig valueSetConfig, String fileName) throws IOException {
		saveValueSetConfig(valueSetConfig, new File(fileName));
	}

}
