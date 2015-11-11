/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.tests;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.ExternalReferenceEntry;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ExternalReferenceEntryTests.
 */
public class ExternalReferenceEntryTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testExternalDocument() throws XPathExpressionException {
		ExternalReferenceEntry entry = new ExternalReferenceEntry();

		ExternalDocumentEntry doc = new ExternalDocumentEntry();
		doc.setReference("http://www.bag.admin.ch/ekif/04423/04428/index.html",
				"Schweizerischer Impfplan");
		entry.setExternalDocumentEntry(doc);

		assertEquals(doc, entry.getExternalDocumentEntry());

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("reference/externalDocument/text/reference[@value='http://www.bag.admin.ch/ekif/04423/04428/index.html']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	@Test
	public void testSerializeEmpty() throws Exception {
		ExternalReferenceEntry entry = new ExternalReferenceEntry();

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("reference/templateId[@root='2.16.756.5.30.1.1.1.1.1' and @extension='CDA-CH.Body.ExtRef']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("reference[@typeCode='REFR']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

}
