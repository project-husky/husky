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
package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.mtps.enums.PosologyType;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PharmSubstitutionHandlingEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.SubstanceAdminSubstitution;
import org.ehealth_connector.cda.ihe.pharm.enums.TimingEvent;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 *
 */
public class CdaChMtpsMtpTest extends TestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final XPathFactory xpathFactory = XPathFactory.newInstance();
	private final XPath xpath = xpathFactory.newXPath();

	/**
	 *<div class="en">Test class for the PHARM MTP document.</div>
	 * <div class="de"></div>	 
	 */
	public CdaChMtpsMtpTest() {
		super();
	}

	/**
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private MedicationListSection deserializeCdaSection(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new MedicationListSection((org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp) CDAUtil.load(source));
	}

	/**
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private CdaChMtpsMtp deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChMtpsMtp((org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp) CDAUtil.load(source));
	}

	/**
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private MedicationListSection deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream, CHPackage.eINSTANCE.getCdaChMtpsMtp());
		return new MedicationListSection((org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp) clinicalDocument);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final MedicationListSection cda = new MedicationListSection(LanguageCode.FRENCH);
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final MedicationListSection cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);

		final String deserialized2 = this.serializeDocument(cda);
		log.debug(deserialized2);

		assertNotNull(cdaDeserialized.getMedicationTreatmentPlanSection());
		assertEquals("Plan de traitement médicamenteux",
				cdaDeserialized.getMedicationTreatmentPlanSection().getTitle());
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void deserializeCdaTest() throws Exception {
		final MedicationListSection cda = new MedicationListSection();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final MedicationListSection cdaDeserialized = deserializeCdaSection(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void deserializeCdaTestTemplateId() throws Exception {
		final MedicationListSection cda = new MedicationListSection();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final MedicationListSection cdaDeserialized = deserializeCdaSection(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	/**
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final MedicationListSection cda = new MedicationListSection();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
		assertEquals("Medication Treatment Plan", cda.getMedicationTreatmentPlanSection().getTitle());
	}

	/**
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	private String serializeDocument(MedicationListSection doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}

	/**
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	private String serializeDocument(CdaChMtpsMtp doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}

	/**
	 * @throws XPathExpressionException
	 */
	@Test
	public void testDocumenHeader() throws XPathExpressionException {
		final MedicationListSection cda = new MedicationListSection();
		final Document document = cda.getDocument();

		// realmCode
		XPathExpression expr = xpath.compile("//realmCode[@code='CHE']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// typeId
		expr = xpath.compile("//typeId[@root='2.16.840.1.113883.1.3' and @extension='POCD_HD000040']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// CH MTPS
		expr = xpath.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.8.1.12']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// ihe pharm mtp template id
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.1.6']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// ihe pharm mpt code
		expr = xpath.compile("/clinicaldocument/code[@code='77603-9']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	/**
	 * @throws XPathExpressionException
	 */
	@Test
	public void testDocumentSection() throws XPathExpressionException {
		final MedicationListSection cda = new MedicationListSection(LanguageCode.GERMAN);
		final Document document = cda.getDocument();

		XPathExpression expr = xpath.compile("//*/section/templateId[@root='1.3.6.1.4.1.19376.1.9.1.2.6']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//*/section/code[@code='77604-7' and @codeSystem='2.16.840.1.113883.6.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertNotNull(cda.getMedicationTreatmentPlanSection());
		assertEquals("Medikamentöser Behandlungsplan", cda.getMedicationTreatmentPlanSection().getTitle());
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testDocumentSectionDeserializeWithEntries() throws Exception {
		final CdaChMtpsMtp cda = new CdaChMtpsMtp();

		final MedicationTreatmentPlanItemEntry mtpEntry = new MedicationTreatmentPlanItemEntry();
		mtpEntry.setTextReference("#mtp");

		PharmSubstitutionHandlingEntry substitutionHandlingEntry = new PharmSubstitutionHandlingEntry();
		substitutionHandlingEntry.setSubstanceAdminSubstitution(SubstanceAdminSubstitution.THERAPEUTIC_ALTERNATIVE,
				LanguageCode.ENGLISH);
		mtpEntry.setPharmSubstitutionHandlingEntry(substitutionHandlingEntry);

		assertEquals(SubstanceAdminSubstitution.THERAPEUTIC_ALTERNATIVE,
				substitutionHandlingEntry.getSubstanceAdminSubstitution());

		mtpEntry.setSupplyQuantityValue(new BigDecimal(1.5));

		MedicationFrequencyContentModule frequency = new MedicationFrequencyContentModule(mtpEntry);
		frequency.setMedicationFrequency(PosologyType.N_TIMES_A_DAY, 2, new TimingEvent[] { TimingEvent.DURING_MEAL },
				null, 0, null, null);

		cda.setMedicationTreatmentPlanItemEntry(mtpEntry);

		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsMtp cdaDeserialized = deserializeCda(deserialized);

		assertTrue(cdaDeserialized != null);

		assertEquals("#mtp", cdaDeserialized.getMedicationTreatmentPlanEntry().getTextReference());

		assertEquals(new BigDecimal(1.5), cdaDeserialized.getMedicationTreatmentPlanEntry().getSupplyQuantityValue());

		assertEquals(SubstanceAdminSubstitution.THERAPEUTIC_ALTERNATIVE, cdaDeserialized
				.getMedicationTreatmentPlanEntry().getPharmSubstitutionHandlingEntry().getSubstanceAdminSubstitution());

		MedicationFrequencyContentModule frequencyDeserialized = new MedicationFrequencyContentModule(
				cdaDeserialized.getMedicationTreatmentPlanEntry());

		MedicationFrequency medicationFrequency = frequencyDeserialized.getMedicationFrequency();
		assertEquals(PosologyType.N_TIMES_A_DAY, medicationFrequency.getPosology());
		assertEquals(new Double(2.0), new Double(medicationFrequency.getPosologyFactor()));
		assertEquals(TimingEvent.DURING_MEAL, medicationFrequency.getTimingEvents()[0]);

	}
}
