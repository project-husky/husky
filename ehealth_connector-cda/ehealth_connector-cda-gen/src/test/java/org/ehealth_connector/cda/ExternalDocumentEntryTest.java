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

package org.ehealth_connector.cda;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ExternalDocumentEntryTests.
 */
public class ExternalDocumentEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		ExternalDocumentEntry entry = new ExternalDocumentEntry();

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("externaldocument/templateId[@root='2.16.840.1.113883.10.20.1.36']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("externaldocument[@classCode='DOC' and @moodCode='EVN']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		ExternalDocumentEntry entry = new ExternalDocumentEntry();

		entry.setReference("http://www.bag.admin.ch/ekif/04423/04428/index.html",
				"Schweizerischer Impfplan");

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"externaldocument/text/reference[@value='http://www.bag.admin.ch/ekif/04423/04428/index.html']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("http://www.bag.admin.ch/ekif/04423/04428/index.html",
				entry.getReferenceUrl());

		assertEquals("Schweizerischer Impfplan", entry.getReferenceNarrativeText());

	}

}
