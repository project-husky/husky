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

package org.ehealth_connector.cda.ihe.pharm;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class MedicationTreatmentPlanItemEntry.
 */
public class MedicationTreatmentPlanItemEntryTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testInstructionsEntry() throws Exception {

		final MedicationTreatmentPlanItemEntry entry = new MedicationTreatmentPlanItemEntry();

		MedicationFullfillmentInstructionsEntry medicalFullfillmentInstruction = new MedicationFullfillmentInstructionsEntry();
		medicalFullfillmentInstruction.setTextReference("#abc");
		entry.setMedicationFullfillmentInstructions(medicalFullfillmentInstruction);
		assertEquals("#abc", entry.getMedicationFullfillmentInstructions().getTextReference());

		MedicationFullfillmentInstructionsEntry medicalFullfillmentInstructionDisrupt = new MedicationFullfillmentInstructionsEntry();
		medicalFullfillmentInstructionDisrupt.setTextReference("#ghi");
		entry.setMedicationFullfillmentInstructions(medicalFullfillmentInstructionDisrupt);
		assertEquals("#ghi", entry.getMedicationFullfillmentInstructions().getTextReference());

		PatientMedicalInstructionsEntry patientInstructions = new PatientMedicalInstructionsEntry();
		patientInstructions.setTextReference("#def");
		entry.setPatientMedicalInstructions(patientInstructions);

		assertEquals("#ghi", entry.getMedicationFullfillmentInstructions().getTextReference());
		assertEquals("#def", entry.getPatientMedicalInstructions().getTextReference());

		PatientMedicalInstructionsEntry patientInstructionsDisrupt = new PatientMedicalInstructionsEntry();
		patientInstructionsDisrupt.setTextReference("#jkl");
		entry.setPatientMedicalInstructions(patientInstructionsDisrupt);

		assertEquals("#ghi", entry.getMedicationFullfillmentInstructions().getTextReference());
		assertEquals("#jkl", entry.getPatientMedicalInstructions().getTextReference());

		entry.getDocument();
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final MedicationTreatmentPlanItemEntry entry = new MedicationTreatmentPlanItemEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.7']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// CCD
		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.24']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE PHARM
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.6']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE PCC
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.7']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE PCC
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.7.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//statusCode[@code='completed']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

}
