/*
 *
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
package org.ehealth_connector.cda.ch;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * Test of SectionAnnotationCommentEntry
 *
 */
public class SectionAnnotationCommentEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final SectionAnnotationCommentEntry entry = new SectionAnnotationCommentEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("act/templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.2']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("act/templateId[@root='2.16.840.1.113883.10.20.1.40']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("act/code[@code='48767-8' and @codeSystem='2.16.840.1.113883.6.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("act/statusCode[@code='completed']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.SectionAnnotationCommentEntry#setContentIdReference(java.lang.String)}
	 * .
	 *
	 * @throws XPathExpressionException
	 */
	@Test
	public void testSetContentIdReference() throws XPathExpressionException {
		final SectionAnnotationCommentEntry entry = new SectionAnnotationCommentEntry();

		entry.setContentIdReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("act/text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getContentIdReference());
	}

}
