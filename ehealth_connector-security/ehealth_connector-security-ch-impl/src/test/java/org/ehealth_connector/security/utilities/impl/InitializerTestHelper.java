package org.ehealth_connector.security.utilities.impl;

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

import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.serialization.OpenSaml2Serializer;
import org.ehealth_connector.security.serialization.impl.OpenSaml2SerializerImpl;
import org.junit.BeforeClass;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.XMLObject;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public abstract class InitializerTestHelper {
	@BeforeClass
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
