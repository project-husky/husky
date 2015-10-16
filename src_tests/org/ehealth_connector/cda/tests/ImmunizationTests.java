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
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.MedicationTargetEntry;
import org.ehealth_connector.cda.ch.enums.CdaChVacdImmunizations;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ImmunizationTests.
 */
public class ImmunizationTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	// <substanceadministration xmlns="urn:hl7-org:v3" classCode="SBADM"
	// moodCode="EVN" negationInd="false">
	// <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.12"/>
	// <templateId root="2.16.840.1.113883.10.20.1.24"/>
	// <templateId root="2.16.756.5.30.1.1.1.1.1"
	// extension="CDA-CH.Body.MediL3"/>
	// <code code="IMMUNIZ" codeSystem="2.16.840.1.113883.5.4"
	// codeSystemName="HL7ActCode"/>
	// <statusCode code="completed"/>
	// <priorityCode nullFlavor="UNK"/>
	// <routeCode nullFlavor="UNK"/>
	// <doseQuantity nullFlavor="UNK"/>
	// </substanceadministration>

	@Test
	public void testSerializeEmpty() throws Exception {
		Immunization immunization = new Immunization();

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.12']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.24']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//templateId[@root='2.16.756.5.30.1.1.1.1.1' and @extension='CDA-CH.Body.MediL3']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testAddMedicationTarget() throws Exception {

		Immunization immunization = new Immunization();

		assertEquals(0, immunization.getMedicationTargetEntries().size());

		MedicationTargetEntry medicationTargetEntry = new MedicationTargetEntry();
		medicationTargetEntry.setImmunizationTarget(CdaChVacdImmunizations.HEPB);
		immunization.addMedicationTargetEntry(medicationTargetEntry);

		assertEquals(1, immunization.getMedicationTargetEntries().size());
		assertEquals(medicationTargetEntry, immunization.getMedicationTargetEntries().get(0));

		Document document = immunization.getDocument();

		XPathExpression expr = xpath.compile(
				"//templateId[@root='2.16.756.5.30.1.1.1.1.1' and @extension='CDA-CH.Body.MediL3']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"substanceadministration/entryRelationship[@typeCode='RSON' and @negationInd='false']/observation[@classCode='OBS' and @moodCode='EVN']/templateId[@root='2.16.756.5.30.1.1.1.1.3.5.1' and @extension='CDA-CH.VACD.Body.MediL3.Reason']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

}
