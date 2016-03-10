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
package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PharmaceuticalAdviceItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Test cases
 */
public class CdaChMtpsPmlTest extends TestUtils {

	private final Log log = LogFactory.getLog(MdhtFacade.class);

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	public CdaChMtpsPmlTest() {
		super();
	}

	private CdaChMtpsPml deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChMtpsPml(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPml) CDAUtil.load(source));
	}

	private CdaChMtpsPml deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChMtpsPml());
		return new CdaChMtpsPml((org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPml) clinicalDocument);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsPml cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);

		final String deserialized2 = this.serializeDocument(cda);
		log.debug(deserialized2);

		assertNotNull(cdaDeserialized.getMedicationListSection());
		assertEquals("Medication List", cdaDeserialized.getMedicationListSection().getTitle());
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsPml cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private String serializeDocument(CdaChMtpsPml doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}

	@Test
	public void testDocumenHeader() throws XPathExpressionException {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final Document document = cda.getDocument();

		// realmCode
		XPathExpression expr = xpath.compile("//realmCode[@code='CH']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// typeId
		expr = xpath.compile("//typeId[@root='2.16.840.1.113883.1.3' and @extension='POCD_HD000040']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// CH PML
		expr = xpath.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.8.1.14']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// ihe pharm pmö
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.1.5']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// ihe pharm dis code
		expr = xpath.compile("//code[@code='56445-0']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testDocumentSection() throws XPathExpressionException {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final Document document = cda.getDocument();

		XPathExpression expr = xpath
				.compile("//*/section/templateId[@root='1.3.6.1.4.1.19376.1.9.1.2.5']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//*/code[@code='10160-0' and @codeSystem='2.16.840.1.113883.6.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertNotNull(cda.getMedicationListSection());
		assertEquals("Medication List", cda.getMedicationListSection().getTitle());
	}

	@Test
	public void testDocumentSectionDeserializeWithEntries() throws Exception {

		final CdaChMtpsPml cda = new CdaChMtpsPml();

		final MedicationTreatmentPlanItemEntry mtpEntry = new MedicationTreatmentPlanItemEntry();
		mtpEntry.setTextReference("#mtp");
		cda.getMedicationListSection().addMedicationTreatmentPlanItemEntry(mtpEntry);

		final PrescriptionItemEntry preEntry = new PrescriptionItemEntry();
		preEntry.setTextReference("#pre");
		cda.getMedicationListSection().addPrescriptionItemEntry(preEntry);

		final DispenseItemEntry disEntry = new DispenseItemEntry();
		disEntry.setTextReference("#dis");
		cda.getMedicationListSection().addDispenseItemEntry(disEntry);

		final PharmaceuticalAdviceItemEntry padvEntry = new PharmaceuticalAdviceItemEntry();
		padvEntry.setTextReference("#padv");
		cda.getMedicationListSection().addPharmaceuticalAdviceItemEntry(padvEntry);

		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsPml cdaDeserialized = deserializeCda(deserialized);

		assertTrue(cdaDeserialized != null);

		assertEquals("#mtp", cdaDeserialized.getMedicationListSection()
				.getMedicationTreatmentPlanItemEntries().get(0).getTextReference());
		assertEquals("#pre", cdaDeserialized.getMedicationListSection().getPrescriptionItemEntries()
				.get(0).getTextReference());
		assertEquals("#dis", cdaDeserialized.getMedicationListSection().getDispenseItemEntries().get(0)
				.getTextReference());
		assertEquals("#padv", cdaDeserialized.getMedicationListSection()
				.getPharmaceuticalAdviceItemEntries().get(0).getTextReference());

	}

}
