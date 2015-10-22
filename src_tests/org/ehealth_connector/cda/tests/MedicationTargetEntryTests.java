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

import org.ehealth_connector.cda.MedicationTargetEntry;
import org.ehealth_connector.cda.ch.enums.CdaChVacdImmunizations;
import org.ehealth_connector.common.Identificator;
import org.junit.Test;
import org.openhealthtools.ihe.utils.UUID;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class MedicationTargetEntryTests.
 */
public class MedicationTargetEntryTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws XPathExpressionException {
		MedicationTargetEntry entry = new MedicationTargetEntry();

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("observation[@classCode='OBS' and @moodCode='EVN']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("observation/statusCode[@code='completed']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"observation/templateId[@root='2.16.756.5.30.1.1.1.1.3.5.1' and @extension='CDA-CH.VACD.Body.MediL3.Reason']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	/*
	 * VARICELLA("68525005", "Varicella vaccination (procedure)")
	 */
	@Test
	public void testImmunizationTargetCode() throws XPathExpressionException {
		MedicationTargetEntry entry = new MedicationTargetEntry();
		entry.setImmunizationTargetCode(CdaChVacdImmunizations.VARICELLA.getCode());

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"observation/code[@code='68525005' and @codeSystem='2.16.756.5.30.1.127.3.3.3']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(CdaChVacdImmunizations.VARICELLA.getCode(), entry.getImmunizationTargetCode());
	}

	/*
	 * DIPHTHERIA("76668005", "Diphtheria vaccination (procedure)")
	 */
	@Test
	public void testImmunizationTargetEnum() throws XPathExpressionException {
		MedicationTargetEntry entry = new MedicationTargetEntry();
		entry.setImmunizationTarget(CdaChVacdImmunizations.DIPHTHERIA);

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"observation/code[@code='76668005' and @codeSystem='2.16.756.5.30.1.127.3.3.3']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(CdaChVacdImmunizations.DIPHTHERIA, entry.getImmunizationTarget());
	}

	@Test
	public void testSoftwareCreatedId() throws XPathExpressionException {

		MedicationTargetEntry entry = new MedicationTargetEntry();

		String uuid = UUID.generate();
		Identificator softwareId = new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", uuid);
		entry.setSoftwareCreatedId(softwareId);

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("observation/id[@root='2.16.756.5.30.1.1.1.1.3.5.1' and @extension='"
						+ uuid + "']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(softwareId, entry.getSoftwareCreatedId());
	}

	@Test
	public void testEquals() {

		Identificator softwareId1 = new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "1");
		Identificator softwareId2 = new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "2");

		MedicationTargetEntry empty = new MedicationTargetEntry();

		MedicationTargetEntry diptheria = new MedicationTargetEntry();
		diptheria.setImmunizationTarget(CdaChVacdImmunizations.DIPHTHERIA);

		MedicationTargetEntry varicella = new MedicationTargetEntry();
		varicella.setImmunizationTarget(CdaChVacdImmunizations.VARICELLA);

		MedicationTargetEntry software1 = new MedicationTargetEntry();
		software1.setSoftwareCreatedId(softwareId1);

		MedicationTargetEntry software2 = new MedicationTargetEntry();
		software2.setSoftwareCreatedId(softwareId2);

		MedicationTargetEntry varicellaSoft1 = new MedicationTargetEntry();
		varicellaSoft1.setImmunizationTarget(CdaChVacdImmunizations.VARICELLA);
		varicellaSoft1.setSoftwareCreatedId(softwareId1);

		MedicationTargetEntry varicellaSoft1Duply = new MedicationTargetEntry();
		varicellaSoft1Duply.setImmunizationTarget(CdaChVacdImmunizations.VARICELLA);
		varicellaSoft1Duply.setSoftwareCreatedId(softwareId1);

		assertEquals(varicellaSoft1, varicellaSoft1);
		assertEquals(varicellaSoft1, varicellaSoft1Duply);
		assertEquals(false, varicellaSoft1.equals(software1));
		assertEquals(false, varicellaSoft1.equals(software2));
		assertEquals(false, varicellaSoft1.equals(empty));
		assertEquals(false, varicellaSoft1.equals(varicella));
		assertEquals(false, software1.equals(software2));
		assertEquals(false, diptheria.equals(varicella));
		assertEquals(false, empty.equals(software1));
		assertEquals(false, empty.equals(varicella));
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		MedicationTargetEntry entry = new MedicationTargetEntry();

		entry.setTextReference("#reference1");

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("observation/text/reference[@value='#reference1']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
