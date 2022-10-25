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
package org.projecthusky.xua.utilities.impl;

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

import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.serialization.OpenSaml2Serializer;
import org.projecthusky.xua.serialization.impl.OpenSaml2SerializerImpl;
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
