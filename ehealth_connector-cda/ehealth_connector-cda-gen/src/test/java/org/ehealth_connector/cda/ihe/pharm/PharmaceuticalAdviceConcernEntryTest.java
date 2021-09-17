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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.BaseProblemConcern;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PharmaceuticalAdviceConcernEntryTest.
 */
public class PharmaceuticalAdviceConcernEntryTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testEffectiveTime() throws Exception {

		Date date = DateUtil.parseDateyyyyMMddHHmmss("20160824123926");
		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();
		entry.setEffectiveTime(date);

		final Document document = entry.getDocument();
		XPathExpression expr = xpath.compile("//effectiveTime/low[@value='20160824123926']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(date, entry.getEffectiveTime());
	}

	@Test
	public void testIdentifier() throws Exception {

		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();

		entry.setId(new Identificator("oid", "id"));
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//id[@root='oid' and @extension='id']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testProblemConcernEntry() throws Exception {
		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();

		BaseProblemConcern problemConcernEntry = new BaseProblemConcern();

		entry.addProblemConcernEntry(problemConcernEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//entryRelationship[@typeCode='SUBJ' and @inversionInd='false']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testReferenceEntries() throws Exception {
		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();

		PrescriptionItemReferenceEntry prescriptionItemReferenceEntry = new PrescriptionItemReferenceEntry();
		prescriptionItemReferenceEntry.setId(new Identificator("oid2", "id2"));
		entry.setPrescriptionItemReferenceEntry(prescriptionItemReferenceEntry);

		DispenseItemReferenceEntry dispenseItemReferenceEntry = new DispenseItemReferenceEntry();
		dispenseItemReferenceEntry.setId(new Identificator("oid3", "id3"));
		entry.setDispenseItemReferenceEntry(dispenseItemReferenceEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='REFR']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());

		assertEquals("oid2", entry.getPrescriptionItemReferenceEntry().getId().getRoot());
		assertEquals("id2", entry.getPrescriptionItemReferenceEntry().getId().getExtension());

		assertEquals("oid3", entry.getDispenseItemReferenceEntry().getId().getRoot());
		assertEquals("id3", entry.getDispenseItemReferenceEntry().getId().getExtension());

	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.5']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.27']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.5.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		xpath.compile("//code[@nullFalvor='NA']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//statusCode[@code='active']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testSeverityOfConcern() throws Exception {
		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();

		SeverityOfConcernEntry severityOfConcernEntry = new SeverityOfConcernEntry();
		severityOfConcernEntry.setTextReference("#reference1");

		entry.setSeverityOfConcernEntry(severityOfConcernEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//entryRelationship[@typeCode='SUBJ' and @inversionInd='true']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getSeverityOfConcernEntry().getTextReference());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		final PharmaceuticalAdviceConcernEntry entry = new PharmaceuticalAdviceConcernEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("//text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
