package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReportTest;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.IntendedRecipient;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class CdaChLrtpTest extends AbstractLaboratoryReportTest {

	private final Log log = LogFactory.getLog(MdhtFacade.class);

	public CdaChLrtpTest() {
		super.init();

	}

	private CdaChLrtp deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		CHPackage.eINSTANCE.eClass();
		LABPackage.eINSTANCE.eClass();
		final ClinicalDocument clinicalDocument = CDAUtil.load(source);
		if (clinicalDocument instanceof org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp) {
			CdaChLrtp test = new CdaChLrtp(
					(org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp) clinicalDocument);
			return test;
		} else
			return null;
	}

	private CdaChLrtp deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChLrtp());
		return new CdaChLrtp((org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp) clinicalDocument);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChLrtp cda = new CdaChLrtp();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrtp cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChLrtp cda = new CdaChLrtp();
		LaboratorySpecialtySection sps = new LaboratorySpecialtySection();
		LaboratoryReportDataProcessingEntry lrd = new LaboratoryReportDataProcessingEntry();
		SpecimenAct spa = new SpecimenAct();
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		LaboratoryObservation lo = new LaboratoryObservation();

		lo.setCode(LabObsList.A11_HLA_ANTIGENE);
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		lo.addCommentEntry(sac);
		lbo.addLaboratoryObservation(lo);
		spa.addLaboratoryBatteryOrganizer(lbo);
		lrd.setSpecimenAct(spa);
		sps.setLaboratoryReportDataProcessingEntry(lrd);
		cda.addLaboratorySpecialtySection(sps);

		assertNotNull(cda.getLaboratorySpecialtySection());
		assertNotNull(
				cda.getLaboratorySpecialtySection().get(0).getLaboratoryReportDataProcessingEntry());
		assertNotNull(cda.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct());
		assertNotNull(
				cda.getLaboratorySpecialtySection().get(0).getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0).getLaboratoryObservations().get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0).getLaboratoryObservations().get(0).getCommentEntryList().get(0));
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrtp cdaDeserialized = deserializeCda(deserialized);

		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0).getLaboratoryObservations().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0).getLaboratoryObservations().get(0).getCommentEntryList().get(0));

		assertTrue(cdaDeserialized != null);
		assertEquals("Laboratory Specialty Section",
				cdaDeserialized.getLaboratorySpecialtySection().get(0).getTitle());
		assertTrue(LabObsList.A11_HLA_ANTIGENE.getCode()
				.equals(cdaDeserialized.getLaboratorySpecialtySection().get(0)
						.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
						.getLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations().get(0)
						.getCodeAsLoincEnum().getCode()));
	}

	@Test
	public void deserializeCdaTestTemplateId() throws Exception {
		final CdaChLrtp cda = new CdaChLrtp();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrtp cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChLrtp cda = new CdaChLrtp();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private String serializeDocument(CdaChLrtp doc) throws Exception {
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

		final CdaChLrtp cda = new CdaChLrtp();
		cda.addLaboratoryBatteryOrganizer(org);

		cda.getLaboratorySpecialtySection().get(0).setTextReference(
				"<table><tr><td>Dies ist ein Test<content ID=\"TestContentIdRef\">Hier steht der menschenlesbare Text</content></td></tr></table>");
		Document document = cda.getDocument();
		xExist(document, "//reference[@value='#TestContentIdRef']");
		xExist(document, "//content[@ID='TestContentIdRef']");
	}

	@Test
	public void testContentModules() throws XPathExpressionException {
		CdaChLrtp doc = new CdaChLrtp();

		// Specialty Section
		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();
		doc.addLaboratorySpecialtySection(lss);
		assertNotNull(doc.getLaboratorySpecialtySection());
		Document document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));

		// Convenience LaboratoryBatteryOrganizer (automatic section creation)
		doc = new CdaChLrtp();
		LaboratoryObservation lo = new LaboratoryObservation();
		lo.setCode(LabObsList.A11_HLA_ANTIGENE);
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addLaboratoryObservation(lo);
		doc.addLaboratoryBatteryOrganizer(lbo);
		assertFalse(doc.getLaboratoryBatteryOrganizerList().isEmpty());
		document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));
		assertTrue(xExist(document,
				"/clinicaldocument/component/structuredBody/component/section/code[@code='18724-5']"));
		// a second Laboratory Battery Organizer
		doc.addLaboratoryBatteryOrganizer(lbo);
		document = doc.getDocument();
		// there must be two Laboratory Battery Organizers in two
		// LaboratorySpecialtySections
		assertFalse(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']", 2));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.3.2.1']", 2));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1']", 2));
	}

	@Override
	@Test
	public void testDocumentHeader() throws XPathExpressionException {
		final CdaChLrtp cda = new CdaChLrtp();
		final Document document = cda.getDocument();

		// LRTP
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.4.1", null));

		// Referral Ordering Physician
		cda.addReferralOrderingPhysician(new ReferralOrderingPhysician());
		assertNotNull(cda.getReferralOrderingPhysicians());

		// Intended Recipient
		cda.addIntendedRecipient(new IntendedRecipient());
		assertFalse(cda.getIntendedRecipients().isEmpty());

		// Empty Custodian
		cda.setEmtpyCustodian();
		assertNotNull(cda.getCustodian());

		// Author
		cda.addAuthor(new Author());
		assertFalse(cda.getAuthors().isEmpty());
	}

	@Test
	public void testNarrativeText() {
		CdaChLrtp doc = new CdaChLrtp();

		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();
		doc.addLaboratorySpecialtySection(lss);
		doc.setNarrativeTextSectionLaboratorySpeciality(ts1);
		assertEquals(ts1, doc.getNarrativeTextSectionLaboratorySpeciality());
		doc.setNarrativeTextSectionLaboratorySpeciality(ts2);
		assertEquals(ts2, doc.getNarrativeTextSectionLaboratorySpeciality());
	}
}
