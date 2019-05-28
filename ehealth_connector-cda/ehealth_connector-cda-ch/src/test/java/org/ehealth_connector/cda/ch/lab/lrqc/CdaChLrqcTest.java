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
package org.ehealth_connector.cda.ch.lab.lrqc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.ParticipantClaimer;
import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.cda.ch.lab.CdaChV12LaboratoryReportTest;
import org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList;
import org.ehealth_connector.cda.ch.lab.lrqc.enums.QualabQcc;
import org.ehealth_connector.cda.ch.lab.lrqc.enums.SpecialtySections;
import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.AuthoringDevice;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.PostalAddressUse;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.ChPackage;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@SuppressWarnings("deprecation")
public class CdaChLrqcTest extends CdaChV12LaboratoryReportTest {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	public CdaChLrqcTest() {
		super.init();

	}

	private CdaChLrqc deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		ChPackage.eINSTANCE.eClass();
		LABPackage.eINSTANCE.eClass();
		final ClinicalDocument clinicalDocument = CDAUtil.load(source);
		if (clinicalDocument instanceof org.openhealthtools.mdht.uml.cda.ch.CdaChLrqcV1) {
			CdaChLrqc test = new CdaChLrqc(
					(org.openhealthtools.mdht.uml.cda.ch.CdaChLrqcV1) clinicalDocument);
			return test;
		} else
			return null;
	}

	private CdaChLrqc deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				ChPackage.eINSTANCE.getCdaChLrqcV1());
		return new CdaChLrqc((org.openhealthtools.mdht.uml.cda.ch.CdaChLrqcV1) clinicalDocument);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChLrqc cda = new CdaChLrqc();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrqc cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChLrqc cda = new CdaChLrqc();
		LaboratorySpecialtySection sps = new LaboratorySpecialtySection();
		LaboratoryReportDataProcessingEntry lrd = new LaboratoryReportDataProcessingEntry();
		BaseChSpecimenAct spa = new BaseChSpecimenAct();
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		LaboratoryObservation lo = new LaboratoryObservation();

		org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry sc = new org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry();
		SpecimenReceivedEntry sr = new SpecimenReceivedEntry();
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();

		ObservationMediaEntry ome = new ObservationMediaEntry();

		ome.addCommentEntry(sac);
		lbo.addObservationMediaEntry(ome);
		lo.setCode(LabObsList._5_FLUOROCYTOSINE_SUSCEPTIBILITY);
		lo.addCommentEntry(sac);
		lbo.addLaboratoryObservation(lo);
		spa.addLaboratoryBatteryOrganizer(lbo);
		sc.setSpecimenReceivedEntry(sr);
		spa.addSpecimenCollectionEntry(sc);
		lrd.setSpecimenAct(spa);
		sps.setLaboratoryReportDataProcessingEntry(lrd);
		cda.setLaboratorySpecialtySection(sps);

		assertNotNull(cda.getLaboratorySpecialtySection());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLrqcLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLrqcLaboratoryBatteryOrganizers().get(0)
				.getLaboratoryObservations().get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLrqcLaboratoryBatteryOrganizers().get(0)
				.getLrqcLaboratoryObservations().get(0).getCommentEntryList().get(0));

		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getSpecimenCollectionEntries().get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getSpecimenCollectionEntries().get(0).getSpecimenReceivedEntry());

		assertNotNull(cda.getLaboratoryBatteryOrganizerList().get(0).getObservationMediaEntries()
				.get(0).getCommentEntryList().get(0));

		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrqc cdaDeserialized = deserializeCda(deserialized);

		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrqcLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrqcLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrqcLaboratoryBatteryOrganizers().get(0).getLrqcLaboratoryObservations().get(0)
				.getCommentEntryList().get(0));
		assertNotNull(cda.getLaboratoryBatteryOrganizerList().get(0).getObservationMediaEntries()
				.get(0).getCommentEntryList().get(0));

		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getSpecimenCollectionEntries().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getSpecimenCollectionEntries().get(0).getSpecimenReceivedEntry());
		assertTrue(cdaDeserialized != null);
		assertEquals("Laboratory report",
				cdaDeserialized.getLaboratorySpecialtySection().getTitle());
		assertTrue(LabObsList._5_FLUOROCYTOSINE_SUSCEPTIBILITY.getCode()
				.equals(cdaDeserialized.getLaboratorySpecialtySection()
						.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
						.getLrqcLaboratoryBatteryOrganizers().get(0).getLrqcLaboratoryObservations()
						.get(0).getCodeAsEnum().getCode()));
	}

	@Test
	public void deserializeCdaTestTemplateId() throws Exception {
		final CdaChLrqc cda = new CdaChLrqc();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrqc cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChLrqc cda = new CdaChLrqc();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private String serializeDocument(CdaChLrqc doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}

	@Test
	public void testComment() throws XPathExpressionException {
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		sac.setContentIdReference("TestContentIdRef");

		LaboratoryObservation lo = new LaboratoryObservation();
		lo.addCommentEntry(sac);

		LaboratoryBatteryOrganizer org = new LaboratoryBatteryOrganizer();
		org.addLaboratoryObservation(lo);

		final CdaChLrqc cda = new CdaChLrqc();
		cda.addLaboratoryBatteryOrganizer(org, SpecialtySections.BLOOD_BANK_STUDIES.getCode());

		cda.getLaboratorySpecialtySection().setTextReference(
				"<table><tr><td>Dies ist ein Test<content ID=\"TestContentIdRef\">Hier steht der menschenlesbare Text</content></td></tr></table>");
		Document document = cda.getDocument();
		xExist(document, "//reference[@value='#TestContentIdRef']");
		xExist(document, "//content[@ID='TestContentIdRef']");
	}

	@Test
	public void testContentModules() throws XPathExpressionException {
		CdaChLrqc doc = new CdaChLrqc();

		// Specialty Section
		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();
		doc.setLaboratorySpecialtySection(lss);
		assertNotNull(doc.getLaboratorySpecialtySection());
		Document document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));

		// Convenience LaboratoryBatteryOrganizer (automatic section creation)
		doc = new CdaChLrqc();
		LaboratoryObservation lo = new LaboratoryObservation();
		lo.setCode(LabObsList._5_FLUOROCYTOSINE_SUSCEPTIBILITY);
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addLaboratoryObservation(lo);
		doc.addLaboratoryBatteryOrganizer(lbo,
				SpecialtySections.MICROBIAL_SUSCEPTIBILITY_TESTS_SET.getCode());
		assertFalse(doc.getLaboratoryBatteryOrganizerList().isEmpty());
		document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));
		assertTrue(xExist(document,
				"/clinicaldocument/component/structuredBody/component/section/code[@code='"
						+ LabObsList._5_FLUOROCYTOSINE_SUSCEPTIBILITY.getSectionCode() + "']"));
		// a second Laboratory Battery Organizer
		doc.addLaboratoryBatteryOrganizer(lbo, SpecialtySections.BLOOD_BANK_STUDIES.getCode());
		document = doc.getDocument();
		// there must be two Laboratory Battery Organizer
		assertFalse(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']", 2));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));
	}

	@Override
	@Test
	public void testDocumentHeader() throws XPathExpressionException {
		super.init();
		final CdaChLrqc cda = new CdaChLrqc(LanguageCode.ENGLISH);
		Document document = cda.getDocument();

		// LRQC
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.7.1", null));

		// realmCode
		assertTrue(xExist(document, "//realmCode[@code='CHE']"));

		// code
		assertTrue(xExist(document,
				"/clinicaldocument/code[@code='11502-2' and @codeSystem='2.16.840.1.113883.6.1' and @codeSystemName='LOINC' and @displayName='LABORATORY REPORT.TOTAL']"));

		// InFulfillmentOf
		cda.addInFulfillmentOf(QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ, "123");
		assertEquals("123", cda.getInFulfillmentOfOrderIds().get(0).getExtension());
		document = cda.getDocument();
		assertTrue(xExist(document,
				"/clinicaldocument/inFulfillmentOf/order/id[@root='"
						+ QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ.getCodeSystemOid()
						+ "' and @extension='123']"));

		// Recipient
		cda.addIntendedRecipient(QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ);
		assertFalse(cda.getIntendedRecipients().isEmpty());
		document = cda.getDocument();
		assertTrue(xExist(document, "/clinicaldocument/informationRecipient[@typeCode='PRCP']"));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.1.4", null));
		assertEquals(QualabQcc.CENTRE_SUISSE_DE_CONTRÔLE_DE_QUALITÉ_CSCQ.getCodeValue(),
				cda.getIntendedRecipientsLrqc().get(0).getIds().get(0).getExtension());

		// RecordTarget
		cda.setRecordTarget(id1);
		assertTrue(isEqual(id1, cda.getRecordTargetId()));
		document = cda.getDocument();
		assertTrue(xExist(document, "/clinicaldocument/recordTarget[@typeCode='RCT']"));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.1.2", null));
		assertTrue(
				xExist(document, "/clinicaldocument/recordTarget/patientRole[@classCode='PAT']"));
		assertTrue(xExist(document,
				"/clinicaldocument/recordTarget/patientRole/patient[@nullFlavor='OTH']"));

		// Human Author
		Author author = new Author(new Name("Axel", "Helmer"));
		author.setFunctionCode(new Code("3212", "2.16.840.1.113883.2.9.6.2.7", "ISCO-08",
				"Medical and pathology laboratory technicians"));
		author.setTime(super.endDate);
		author.setGln("987");
		author.addAddress(new Address("Baurat-Gerber-Str.", "18", "37073", "Göttingen",
				PostalAddressUse.PUBLIC));
		Telecoms t = new Telecoms();
		t.addPhone("+491794783239", TelecomAddressUse.PUBLIC);
		author.setTelecoms(t);
		cda.addAuthor(author);
		assertTrue(isEqual(author, cda.getAuthor()));

		// Software Author
		Author sAuth = new Author();
		sAuth.setAssignedAuthoringDevice(new AuthoringDevice(ts1));
		sAuth.setOrganization(organization1);
		cda.addAuthor(sAuth);
		assertEquals(ts1, cda.getAuthors().get(1).getCompleteName());

		// Custodian
		cda.setCustodian(organization1);
		assertNotNull(cda.getCustodianAsOrganization());

		// LegalAuthenticator
		cda.setLegalAuthenticator(author1);
		assertNotNull(cda.getLegalAuthenticatorAsAuthor());
		document = cda.getDocument();
		assertTrue(
				xExist(document, "/clinicaldocument/legalAuthenticator/signatureCode[@code='S']"));

		// Participant
		ParticipantClaimer p = new ParticipantClaimer("456", "999", true);
		cda.addParticipant(p);
		document = cda.getDocument();
		assertNotNull(cda.getParticipantsLrqc());
		assertEquals("456", cda.getParticipantsLrqc().get(0).getGlnIds().get(0));
		assertEquals("999", cda.getParticipantsLrqc().get(0).getZsrIds().get(0));
		assertTrue(xExist(document, "//participant[@typeCode='IND']"));
	}

	@Test
	public void testNarrativeText() {
		CdaChLrqc doc = new CdaChLrqc();

		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();
		doc.setLaboratorySpecialtySection(lss);
		doc.setNarrativeTextSectionLaboratorySpeciality(ts1);
		assertEquals(ts1, doc.getNarrativeTextSectionLaboratorySpeciality());
		doc.setNarrativeTextSectionLaboratorySpeciality(ts2);
		assertEquals(ts2, doc.getNarrativeTextSectionLaboratorySpeciality());
	}
}
