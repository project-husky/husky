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
package org.husky.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Deprecated(forRemoval = true) // Replaced by the package org.husky.common.utils.xml
public class XmlUtil {

	/**
	 * This class is not instantiable.
	 */
	private XmlUtil() {
		throw new IllegalStateException("This is a utility class!");
	}

	/**
	 * Creates a JAXBElement from the given parameters. This method is provided,
	 * because the QName cannot be used in .Net (using javax.xml.namespace; us
	 * invalid because namespace is a system keyword in .Net).
	 *
	 * @param namespace
	 *            the namespace
	 * @param clazz
	 *            the clazz
	 * @param obj
	 *            the obj
	 * @return the jaxb element
	 */
	public static <T> JAXBElement<T> getJaxbElement(String namespace, String xmlElementName,
													Class<T> clazz, T obj) {
		return new JAXBElement<>(new QName(namespace, xmlElementName), clazz, obj);
	}

	/**
	 * Gets the xml document from the given stream.
	 *
	 * @param inputStream
	 *            the input stream
	 * @return the xml document
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the SAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document getXmlDocument(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		var factory = DocumentBuilderFactory.newInstance();
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		var builder = factory.newDocumentBuilder();

		var inputReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		var inputSource = new InputSource(inputReader);
		inputSource.setEncoding(StandardCharsets.UTF_8.name());

		return builder.parse(inputSource);
	}

	/**
	 * Writes the given document to the given xml file.
	 *
	 * @param fDoc the f doc
	 * @param out  the out
	 * @throws IOException
	 * @throws TransformerException
	 * @throws TransformerFactoryConfigurationError
	 * @throws Exception                            the exception
	 */
	public static void writeXmlDocumentToFile(Document fDoc, File out)
			throws IOException, TransformerFactoryConfigurationError, TransformerException {
		// if file doesn't exists, then create it
		var exists = false;
		if (out.exists()) {
			exists = !Files.deleteIfExists(out.toPath());
		}

		if (!exists) {
			exists = out.createNewFile();
		}

		writeXmlDocumentToOutputStream(fDoc, new FileOutputStream(out));
	}

	/**
	 * Writes the given document as xml to the given output stream.
	 *
	 * @param fDoc the f doc
	 * @param out  the out
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 * @throws IOException
	 * @throws Exception                            the exception
	 */
	public static void writeXmlDocumentToOutputStream(Document fDoc, OutputStream out)
			throws TransformerFactoryConfigurationError, TransformerException, IOException {
		fDoc.setXmlStandalone(true);
		var docSource = new DOMSource(fDoc);
		var factory = TransformerFactory.newInstance();
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

		var transformer = factory.newTransformer();
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, StandardCharsets.UTF_8.name());
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "no");
		transformer.transform(docSource, new StreamResult(out));
		out.flush();
		out.close();
	}
}
