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

package org.ehealth_connector.cda.ch.vacd;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdImmunizations;
import org.ehealth_connector.common.enums.EhcVersions;
import org.ehealth_connector.common.mdht.Identificator;
import org.junit.Test;
import org.openhealthtools.ihe.utils.UUID;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class MedicationTargetEntryTests.
 */
public class MedicationTargetEntryTest {

	private final XPathFactory xpathFactory = XPathFactory.newInstance();
	private final XPath xpath = xpathFactory.newXPath();

	@Test
	public void testEquals() {

		final Identificator softwareId1 = new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "1");
		final Identificator softwareId2 = new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "2");

		final MedicationTargetEntry empty = new MedicationTargetEntry();

		final MedicationTargetEntry diptheria = new MedicationTargetEntry();
		diptheria.setImmunizationTarget(CdaChVacdImmunizations.DIPHTHERIA);

		final MedicationTargetEntry varicella = new MedicationTargetEntry();
		varicella.setImmunizationTarget(CdaChVacdImmunizations.VARICELLA);

		final MedicationTargetEntry software1 = new MedicationTargetEntry();
		software1.setId(softwareId1);

		final MedicationTargetEntry software2 = new MedicationTargetEntry();
		software2.setId(softwareId2);

		final MedicationTargetEntry varicellaSoft1 = new MedicationTargetEntry();
		varicellaSoft1.setImmunizationTarget(CdaChVacdImmunizations.VARICELLA);
		varicellaSoft1.setId(softwareId1);

		final MedicationTargetEntry varicellaSoft1Duply = new MedicationTargetEntry();
		varicellaSoft1Duply.setImmunizationTarget(CdaChVacdImmunizations.VARICELLA);
		varicellaSoft1Duply.setId(softwareId1);

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

	/*
	 * VARICELLA("68525005", "Varicella vaccination (procedure)")
	 */
	@Test
	public void testImmunizationTargetCode() throws XPathExpressionException {
		final MedicationTargetEntry entry = new MedicationTargetEntry();
		entry.setImmunizationTargetCode(CdaChVacdImmunizations.VARICELLA.getCode());

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile(
				"observation/code[@code='68525005' and @codeSystem='2.16.840.1.113883.6.96']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(CdaChVacdImmunizations.VARICELLA.getCode(), entry.getImmunizationTargetCode());
	}

	/*
	 * DIPHTHERIA("76668005", "Diphtheria vaccination (procedure)")
	 */
	@Test
	public void testImmunizationTargetEnum() throws XPathExpressionException {
		final MedicationTargetEntry entry = new MedicationTargetEntry();
		entry.setImmunizationTarget(CdaChVacdImmunizations.DIPHTHERIA);

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile(
				"observation/code[@code='76668005' and @codeSystem='2.16.840.1.113883.6.96']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(CdaChVacdImmunizations.DIPHTHERIA, entry.getImmunizationTarget());
	}

	@Test
	public void testSerializeEmpty() throws XPathExpressionException {
		final MedicationTargetEntry entry = new MedicationTargetEntry();

		final Document document = entry.getDocument();

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

	@Test
	public void testSoftwareCreatedId() throws XPathExpressionException {

		final MedicationTargetEntry entry = new MedicationTargetEntry();

		final String uuid = UUID.generate();
		final Identificator softwareId = new Identificator(EhcVersions.getCurrentVersion().getOid(),
				uuid);
		entry.setId(softwareId);

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("observation/id[@root='"
				+ EhcVersions.getCurrentVersion().getOid() + "' and @extension='" + uuid + "']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(softwareId, entry.getId());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		final MedicationTargetEntry entry = new MedicationTargetEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("observation/text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
