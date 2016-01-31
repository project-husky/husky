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
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class MedicationTreatmentPlanItemEntry.
 * see general base tests also in PrescriptionItemEntryTest
 */
public class MedicationListSectionTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerialize() throws Exception {
		
		final MedicationListSection section = new MedicationListSection(LanguageCode.ENGLISH);
		
		final MedicationTreatmentPlanItemEntry mtpEntry = new MedicationTreatmentPlanItemEntry();
		mtpEntry.setTextReference("#mtp");
		section.addMedicationTreatmentPlanItemEntry(mtpEntry);
		
		final PrescriptionItemEntry preEntry = new PrescriptionItemEntry();
		preEntry.setTextReference("#pre");
		section.addPrescriptionItemEntry(preEntry);
		
		final Document document = section.getDocument();

		// Section
		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.2.5']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		
		assertEquals("#mtp",section.getMedicationTreatmentPlanItemEntries().get(0).getTextReference());
		assertEquals("#pre",section.getPrescriptionItemEntries().get(0).getTextReference());
	}

}
