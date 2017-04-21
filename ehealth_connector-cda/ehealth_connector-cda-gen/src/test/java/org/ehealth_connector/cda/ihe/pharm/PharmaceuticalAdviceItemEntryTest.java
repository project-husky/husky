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
import javax.xml.xpath.XPathExpressionException;

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

	private XPath xpath = PharmXPath.getXPath();

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
	public void testIdentifier() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		entry.setId(new Identificator("oid", "id"));
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//id[@root='oid' and @extension='id']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testMedictionTreatmentPlanEntries() throws Exception {
		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		MedicationTreatmentPlanItemEntry newMedicationTreatmentPlanItemEntry = new MedicationTreatmentPlanItemEntry();
		newMedicationTreatmentPlanItemEntry.setId(new Identificator("oid4", "id4"));
		entry.setNewMedicationTreatmentPlanItemEntry(newMedicationTreatmentPlanItemEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='REFR']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("oid4", entry.getNewMedicationTreatmentPlanItemEntry().getId().getRoot());
		assertEquals("id4", entry.getNewMedicationTreatmentPlanItemEntry().getId().getExtension());
	}

	@Test
	public void testNewPresciption() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		assertEquals(null, entry.getNewPresciptionEntry());

		PrescriptionItemEntry newPresriptionEntry = new PrescriptionItemEntry();
		newPresriptionEntry.setId(new Identificator("oid", "id"));
		entry.setNewPresciptionEntry(newPresriptionEntry);

		final Document document = entry.getDocument();
		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='REFR']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("oid", entry.getNewPresciptionEntry().getId().getRoot());
		assertEquals("id", entry.getNewPresciptionEntry().getId().getExtension());
	}

	@Test
	public void testPharmaceuticalAdviceConcernEntry() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		final PharmaceuticalAdviceConcernEntry concernEntry = new PharmaceuticalAdviceConcernEntry();
		concernEntry.setTextReference("Test");
		entry.setPharmaceuticalAdviceConcernEntry(concernEntry);

		final Document document = entry.getDocument();

		assertEquals(entry.getPharmaceuticalAdviceConcernEntry().getTextReference(), "#Test");

		XPathExpression expr = xpath
				.compile("//entryRelationship[@typeCode='SUBJ' and @inversionInd='false']");
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
	public void testReferenceEntries() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();

		PrescriptionItemReferenceEntry prescriptionItemReferenceEntry = new PrescriptionItemReferenceEntry();
		prescriptionItemReferenceEntry.setId(new Identificator("oid2", "id2"));
		entry.setPrescriptionItemReferenceEntry(prescriptionItemReferenceEntry);

		DispenseItemReferenceEntry dispenseItemReferenceEntry = new DispenseItemReferenceEntry();
		dispenseItemReferenceEntry.setId(new Identificator("oid3", "id3"));
		entry.setDispenseItemReferenceEntry(dispenseItemReferenceEntry);

		MedicationTreatmentPlanItemEntry newMedicationTreatmentPlanItemEntry = new MedicationTreatmentPlanItemEntry();
		newMedicationTreatmentPlanItemEntry.setId(new Identificator("oid4", "id4"));
		entry.setNewMedicationTreatmentPlanItemEntry(newMedicationTreatmentPlanItemEntry);

		MedicationTreatmentPlanItemReferenceEntry medicationTreatmentPlanItemReferenceEntry = new MedicationTreatmentPlanItemReferenceEntry();
		medicationTreatmentPlanItemReferenceEntry.setId(new Identificator("oid", "id"));
		entry.setMedicationTreatmentPlanItemReferenceEntry(
				medicationTreatmentPlanItemReferenceEntry);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//entryRelationship[@typeCode='REFR']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(4, nodes.getLength());

		assertEquals("oid", entry.getMedicationTreatmentPlanItemReferenceEntry().getId().getRoot());
		assertEquals("id",
				entry.getMedicationTreatmentPlanItemReferenceEntry().getId().getExtension());

		assertEquals("oid2", entry.getPrescriptionItemReferenceEntry().getId().getRoot());
		assertEquals("id2", entry.getPrescriptionItemReferenceEntry().getId().getExtension());

		assertEquals("oid3", entry.getDispenseItemReferenceEntry().getId().getRoot());
		assertEquals("id3", entry.getDispenseItemReferenceEntry().getId().getExtension());

		assertEquals("oid4", entry.getNewMedicationTreatmentPlanItemEntry().getId().getRoot());
		assertEquals("id4", entry.getNewMedicationTreatmentPlanItemEntry().getId().getExtension());

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
	public void testStatusCodeActive() throws Exception {

		final PharmaceuticalAdviceItemEntry entry = new PharmaceuticalAdviceItemEntry();
		entry.setStatusCodeActive();

		final Document document = entry.getDocument();
		XPathExpression expr = xpath.compile("//statusCode[@code='active']");
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
