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

package org.ehealth_connector.cda.ihe.pharm;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.PharmaceuticalAdviceStatusList;
import org.ehealth_connector.common.Identificator;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PharmaceuticalAdviceItemEntry.
 */
public class PharmaceuticalAdviceItemEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testExternalDocumentEntry() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		ExternalDocumentEntry externalDocumentEntry = new ExternalDocumentEntry();
		externalDocumentEntry.setId(new Identificator("oid", "id"));

		entry.setExternalDocumentEntry(externalDocumentEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//reference[@typeCode='XCRPT']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//reference/externalDocument/id[@root='oid' and @extension='id']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("oid", entry.getExternalDocumentEntry().getId().getRoot());
		assertEquals("id", entry.getExternalDocumentEntry().getId().getExtension());
	}

	@Test
	public void testStatusCodeActive() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();
		entry.setStatusCodeActive();

		final Document document = entry.getDocument();
		XPathExpression expr = xpath.compile("//statusCode[@code='active']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testIdentifier() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		entry.setId(new Identificator("oid", "id"));
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//id[@root='oid' and @extension='id']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testPharmaceuticalAdviceStatus() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();
		entry.setPharmaceuticalAdviceStatus(PharmaceuticalAdviceStatusList.CANCEL);
		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//code[@code='CANCEL' and @codeSystem='1.3.6.1.4.1.19376.1.9.2.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		assertEquals(PharmaceuticalAdviceStatusList.CANCEL,
				entry.getPharmaceuticalAdviceStatusList());
	}

	@Test
	public void testPrecondition() throws Exception {
		CriterionEntry criterionEntry = new CriterionEntry();
		criterionEntry.setTextReference("#abc");

		CriterionEntry criterionEntry2 = new CriterionEntry();
		criterionEntry2.setTextReference("#def");

		PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();
		entry.addPreconditionEntry(criterionEntry);

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//precondition/criterion/text/reference[@value='#abc']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		assertEquals("#abc", entry.getPreconditionEntries().get(0).getTextReference());

		entry.addPreconditionEntry(criterionEntry2);
		assertEquals(2, entry.getPreconditionEntries().size());
		document = entry.getDocument();
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.3']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("//text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
