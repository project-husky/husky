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

package org.ehealth_connector.cda.ihe.pharm;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ihe.pharm.enums.SeverityObservation;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class SeverityOfConcernEntryTest.
 */
public class SeverityOfConcernEntryTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		final SeverityOfConcernEntry entry = new SeverityOfConcernEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.55']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//code[@code='SEV' and @codeSystem='2.16.840.1.113883.5.4' and @codeSystemName='HL7ActCode' and @displayName='Severity observation']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//statusCode[@code='completed']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testSeverityObservation() throws XPathExpressionException {
		final SeverityOfConcernEntry entry = new SeverityOfConcernEntry();
		entry.setSeverityObservation(SeverityObservation.LOW);

		final Document document = entry.getDocument();
		final XPathExpression expr = xpath
				.compile("//code[@code='L' and @codeSystem='2.16.840.1.113883.5.1063']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(SeverityObservation.LOW, entry.getSeverityObservation());

	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		final SeverityOfConcernEntry entry = new SeverityOfConcernEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("//text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
