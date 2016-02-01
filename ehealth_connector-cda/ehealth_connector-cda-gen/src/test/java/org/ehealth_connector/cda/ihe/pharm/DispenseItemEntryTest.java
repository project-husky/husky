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

import static org.junit.Assert.*;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.pharm.enums.MedicationsSpecialConditions;
import org.ehealth_connector.common.Identificator;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class DispenseItemEntry.
 */
public class DispenseItemEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testExternalDocumentEntry() throws Exception {

		final DispenseItemEntry entry = new DispenseItemEntry();

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
	public void testIdentifier() throws Exception {

		final DispenseItemEntry entry = new DispenseItemEntry();

		entry.setId(new Identificator("oid", "id"));
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//id[@root='oid' and @extension='id']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testInstructionsEntry() throws Exception {

		DispenseItemEntry entry = new DispenseItemEntry();

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
		assertNotNull(entry.getPatientMedicalInstructions());
		entry.getDocument();
		
		assertEquals("#def", entry.getPatientMedicalInstructions().getTextReference());
		
		PatientMedicalInstructionsEntry patientInstructionsDisrupt = new PatientMedicalInstructionsEntry();
		patientInstructionsDisrupt.setTextReference("#jkl");
		entry.setPatientMedicalInstructions(patientInstructionsDisrupt);

		assertEquals("#ghi", entry.getMedicationFullfillmentInstructions().getTextReference());
		assertEquals("#jkl", entry.getPatientMedicalInstructions().getTextReference());
		
	}

	@Test
	public void testMedicationsSpecialConditions() throws Exception {

		final DispenseItemEntry entry = new DispenseItemEntry();

		entry.setMedicationsSpecialConditions(MedicationsSpecialConditions.DRUG_TREATMENT_UNKNOWN,
				LanguageCode.ENGLISH);
		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//code[@code='182904002' and @codeSystem='2.16.840.1.113883.6.96']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		assertEquals(MedicationsSpecialConditions.DRUG_TREATMENT_UNKNOWN,
				entry.getMedicationsSpecialConditions());
	}

	@Test
	public void testPrecondition() throws Exception {
		CriterionEntry criterionEntry = new CriterionEntry();
		criterionEntry.setTextReference("#abc");

		CriterionEntry criterionEntry2 = new CriterionEntry();
		criterionEntry2.setTextReference("#def");

		DispenseItemEntry entry = new DispenseItemEntry();
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
		final DispenseItemEntry entry = new DispenseItemEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.4']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// CCD
		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.34']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE PCC
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.7.3']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		final DispenseItemEntry entry = new DispenseItemEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("//text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}
	
	@Test
	public void testReferenceEntries() throws Exception {

		final DispenseItemEntry entry = new DispenseItemEntry();
		
		MedicationTreatmentPlanItemReferenceEntry medicationTreatmentPlanItemReferenceEntry = new MedicationTreatmentPlanItemReferenceEntry();
		medicationTreatmentPlanItemReferenceEntry.setId(new Identificator("oid", "id"));
		entry.setMedicationTreatmentPlanItemReferenceEntry(medicationTreatmentPlanItemReferenceEntry);
		
		PrescriptionItemReferenceEntry prescriptionItemReferenceEntry = new PrescriptionItemReferenceEntry();
		prescriptionItemReferenceEntry.setId(new Identificator("oid2", "id2"));
		entry.setPrescriptionItemReferenceEntry(prescriptionItemReferenceEntry);

		PharmaceuticalAdviceItemReferenceEntry pharmaceuticalAdviceItemReferenceEntry = new PharmaceuticalAdviceItemReferenceEntry();
		pharmaceuticalAdviceItemReferenceEntry.setId(new Identificator("oid3", "id3"));
		entry.setPharmaceuticalAdviceItemReferenceEntry(pharmaceuticalAdviceItemReferenceEntry);

		
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='REFR']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(3, nodes.getLength());

		assertEquals("oid", entry.getMedicationTreatmentPlanItemReferenceEntry().getId().getRoot());
		assertEquals("id", entry.getMedicationTreatmentPlanItemReferenceEntry().getId().getExtension());
		
		assertEquals("oid2", entry.getPrescriptionItemReferenceEntry().getId().getRoot());
		assertEquals("id2", entry.getPrescriptionItemReferenceEntry().getId().getExtension());

		assertEquals("oid3", entry.getPharmaceuticalAdviceItemReferenceEntry().getId().getRoot());
		assertEquals("id3", entry.getPharmaceuticalAdviceItemReferenceEntry().getId().getExtension());

	}

}
