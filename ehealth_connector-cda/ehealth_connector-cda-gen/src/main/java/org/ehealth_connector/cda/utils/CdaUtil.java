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
package org.ehealth_connector.cda.utils;

import java.io.File;

import javax.xml.bind.Binder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.ehealth_connector.common.mdht.enums.EhcVersions;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class CdaUtil {

	/**
	 * Generate comment.
	 *
	 * @return the string
	 */
	public static String generateXmlHeaderComment() {
		return "Document based on CDA R2 generated by "
				+ EhcVersions.getCurrentVersion().getSystemVersionName() + ", Release Date "
				+ EhcVersions.getCurrentVersion().getReleaseDate();
	}

	public static void saveJaxbObjectToFile(Object jaxbObject, File outputFile, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException {
		// JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
		// Marshaller mar = context.createMarshaller();
		// mar.setProperty("com.sun.xml.bind.namespacePrefixMapper", new
		// CdaNamespacePrefixMapper());
		// mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// mar.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
		// mar.setProperty("com.sun.xml.bind.xmlHeaders",
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		// mar.marshal(jaxbObject, outputFile);

		final JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document doc = builder.getDOMImplementation().createDocument(null, null, null);

		final Binder<Node> binder = context.createBinder();
		final Comment comment = doc.createComment(CdaUtil.generateXmlHeaderComment());
		doc.appendChild(comment);
		doc.appendChild(doc.createProcessingInstruction("xml-stylesheet",
				"type=\"text/css\" href=\"" + css + "\""));
		doc.appendChild(doc.createProcessingInstruction("xml-stylesheet",
				"type=\"text/xsl\" href=\"" + xsl + "\""));

		binder.marshal(jaxbObject, doc);

		final DOMSource domSource = new DOMSource(doc);
		final StreamResult streamResult = new StreamResult(outputFile);
		final TransformerFactory tf = TransformerFactory.newInstance();
		final Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.transform(domSource, streamResult);

	}

	public static void saveJaxbObjectToFile(Object jaxbObject, String outputFileName, String xsl,
			String css) throws JAXBException, ParserConfigurationException, TransformerException {
		saveJaxbObjectToFile(jaxbObject, new File(outputFileName), xsl, css);
	}

}
