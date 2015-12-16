/* **********************************************************************
 * Author: roeland
 * Date  : Dec 15, 2015
 * File  : SectionAnnotationCommentEntryTest.java
 * **********************************************************************
 * ehealth_connector-cda-gen
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */
package org.ehealth_connector.cda.ch;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 15, 2015 9:07:53 AM
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
	 * {@link org.ehealth_connector.cda.ch.SectionAnnotationCommentEntry#setContentIdReference(java.lang.String)}
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
