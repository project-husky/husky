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
package org.ehealth_connector.communication.ch.ppq.utilities.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.serialization.OpenSaml2Serializer;
import org.ehealth_connector.xua.serialization.impl.OpenSaml2SerializerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.XMLObject;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public abstract class InitializerTestHelper {
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// Initialize the library
		InitializationService.initialize();
	}

	public Element loadXmlDokument(String aPath)
			throws SAXException, IOException, ParserConfigurationException {
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		final Document doc = dbf.newDocumentBuilder()
				.parse(this.getClass().getResourceAsStream(aPath));
		return doc.getDocumentElement();
	}

	public void logXmlObject(Element element) {
		try {
			final Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "no");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(4));

			final ByteArrayOutputStream bas = new ByteArrayOutputStream();
			tr.transform(new DOMSource(element), new StreamResult(bas));
			LoggerFactory.getLogger(getClass()).info("\n" + bas.toString());
		} catch (final TransformerException e) {
			LoggerFactory.getLogger(getClass()).error("Error", e);
		}
	}

	public void logXmlObject(XMLObject aXmlObject) {
		try {
			final OpenSaml2Serializer openSamlSerializer = new OpenSaml2SerializerImpl();
			final String xmlString = openSamlSerializer.serializeToString(aXmlObject);
			LoggerFactory.getLogger(getClass()).info("\n" + xmlString);
		} catch (final SerializeException e) {
			LoggerFactory.getLogger(getClass()).error("Error", e);
		}
	}

}
