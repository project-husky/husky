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

import java.math.BigDecimal;

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
 * The Class PrescriptionItemEntry.
 */
public class PrescriptionItemEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testExternalDocumentEntry() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

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
	public void testSubstitutionHandlingEntry() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		
		PharmSubstitutionHandlingEntry substitutionHandlingEntry = new PharmSubstitutionHandlingEntry();
		entry.setPharmSubstitutionHandlingEntry(substitutionHandlingEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='COMP']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//independentInd[@value='false']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		
		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.24']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testIdentifier() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

		entry.setId(new Identificator("oid", "id"));
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//id[@root='oid' and @extension='id']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testInstructionsEntry() throws Exception {

		PrescriptionItemEntry entry = new PrescriptionItemEntry();

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
	public void testMedicationsSpecialConditions() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

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

		PrescriptionItemEntry entry = new PrescriptionItemEntry();
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
	public void testQuantityPrescribed() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

		entry.setSupplyQuantityValue(new BigDecimal(1.5));

		assertEquals(new BigDecimal(1.5), entry.getSupplyQuantityValue());

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='COMP']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//supply/quantity[@value='1.5']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//independentInd[@value='false']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		
		entry.setSupplyQuantityValue(new BigDecimal(2.5));
		assertEquals(new BigDecimal(2.5), entry.getSupplyQuantityValue());
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.2']");
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
	
	@Test
	public void testMedicationTreatmentPlanItemReferenceEntry() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();
		MedicationTreatmentPlanItemReferenceEntry medicationTreatmentPlanItemReferenceEntry = new MedicationTreatmentPlanItemReferenceEntry();
		medicationTreatmentPlanItemReferenceEntry.setId(new Identificator("oid", "id"));
		
		entry.setMedicationTreatmentPlanItemReferenceEntry(medicationTreatmentPlanItemReferenceEntry);
		
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='REFR']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//id[@root='oid' and @extension='id']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//code[@code='MTPItem']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());


		assertEquals("oid", entry.getMedicationTreatmentPlanItemReferenceEntry().getId().getRoot());
		assertEquals("id", entry.getMedicationTreatmentPlanItemReferenceEntry().getId().getExtension());
	}
	
	@Test
	public void testSetReasonForPrescription() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

		entry.setReasonFor(new Identificator("oid", "id"));

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='RSON']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//act[@classCode='ACT' and @moodCode='EVN']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.4.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//id[@root='oid' and @extension='id']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("oid", entry.getReasonFor().getRoot());
		assertEquals("id", entry.getReasonFor().getExtension());
		
		entry.setReasonFor(new Identificator("oid2", "id2"));
		assertEquals("oid2", entry.getReasonFor().getRoot());
		assertEquals("id2", entry.getReasonFor().getExtension());

	}


	@Test
	public void testTextReference() throws XPathExpressionException {
		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("//text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}
	
	

}
