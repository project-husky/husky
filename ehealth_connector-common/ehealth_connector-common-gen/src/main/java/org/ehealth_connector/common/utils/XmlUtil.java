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
package org.ehealth_connector.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtil {

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
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		InputStreamReader inputReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		InputSource inputSource = new InputSource(inputReader);
		inputSource.setEncoding("UTF-8");

		return builder.parse(inputSource);
	}

	/**
	 * Writes the given document to the given xml file.
	 *
	 * @param fDoc
	 *            the f doc
	 * @param out
	 *            the out
	 * @throws Exception
	 *             the exception
	 */
	public static void writeXmlDocumentToFile(Document fDoc, File out) throws Exception {
		// if file doesnt exists, then create it
		boolean exists = false;
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
	 * @param fDoc
	 *            the f doc
	 * @param out
	 *            the out
	 * @throws Exception
	 *             the exception
	 */
	public static void writeXmlDocumentToOutputStream(Document fDoc, OutputStream out)
			throws Exception {
		fDoc.setXmlStandalone(true);
		DOMSource docSource = new DOMSource(fDoc);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "no");
		// out.write("<?xml version=\"1.0\"
		// encoding=\"UTF-8\"?>".getBytes("UTF-8"));
		transformer.transform(docSource, new StreamResult(out));
		out.flush();
		out.close();
	}
}
