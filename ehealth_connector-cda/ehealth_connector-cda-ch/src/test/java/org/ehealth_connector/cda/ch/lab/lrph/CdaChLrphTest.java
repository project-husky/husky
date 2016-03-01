package org.ehealth_connector.cda.ch.lab.lrph;

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
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed;
import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class CdaChLrphTest extends AbstractLaboratoryReportTest {

	private final Log log = LogFactory.getLog(MdhtFacade.class);

	private CdaChLrph deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		CHPackage.eINSTANCE.eClass();
		LABPackage.eINSTANCE.eClass();
		final ClinicalDocument clinicalDocument = CDAUtil.load(source);
		if (clinicalDocument instanceof org.openhealthtools.mdht.uml.cda.ch.CdaChLrph) {
			CdaChLrph test = new CdaChLrph(
					(org.openhealthtools.mdht.uml.cda.ch.CdaChLrph) clinicalDocument);
			return test;
		} else
			return null;
	}

	private CdaChLrph deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChLrph());
		return new CdaChLrph((org.openhealthtools.mdht.uml.cda.ch.CdaChLrph) clinicalDocument);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChLrph cda = new CdaChLrph();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrph cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChLrph cda = new CdaChLrph();
		LaboratorySpecialtySection sps = new LaboratorySpecialtySection();
		LaboratoryReportDataProcessingEntry lrd = new LaboratoryReportDataProcessingEntry();
		SpecimenAct spa = new SpecimenAct();
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		LaboratoryObservation lo = new LaboratoryObservation();

		org.ehealth_connector.cda.ch.lab.lrph.SpecimenCollectionEntry sc = new org.ehealth_connector.cda.ch.lab.lrph.SpecimenCollectionEntry();
		SpecimenReceivedEntry sr = new SpecimenReceivedEntry();
		LaboratoryIsolateOrganizer lio = new LaboratoryIsolateOrganizer();
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		NotificationOrganizer no = new NotificationOrganizer();
		OutbreakIdentificationObservation oi = new OutbreakIdentificationObservation();

		lo.setCode(LabObsListSnomed.BRUCELLA);
		lo.addCommentEntry(sac);
		lbo.addLaboratoryObservation(lo);
		no.setOutbreakIdentification(oi);
		spa.setNotificationOrganizer(no);
		spa.addLaboratoryBatteryOrganizer(lbo);
		sc.setSpecimenReceivedEntry(sr);
		spa.setSpecimenCollectionEntry(sc);
		spa.addLaboratoryIsolateOrganizer(lio);
		lrd.setSpecimenAct(spa);
		sps.setLaboratoryReportDataProcessingEntry(lrd);
		cda.setLaboratorySpecialtySection(sps);

		assertNotNull(cda.getLaboratorySpecialtySection());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations()
				.get(0));
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations().get(0)
				.getCommentEntryList().get(0));

		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getSpecimenCollectionEntry());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getSpecimenCollectionEntry().getSpecimenReceivedEntry());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getLaboratoryIsolateOrganizers());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getNotificationOrganizer());
		assertNotNull(cda.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
				.getSpecimenAct().getNotificationOrganizer().getOutbreakIdentificationObservation());

		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrph cdaDeserialized = deserializeCda(deserialized);

		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection());
		assertNotNull(
				cdaDeserialized.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct());
		assertNotNull(
				cdaDeserialized.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0).getLaboratoryObservations().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getLaboratoryBatteryOrganizers()
				.get(0).getLaboratoryObservations().get(0).getCommentEntryList().get(0));

		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getSpecimenCollectionEntry());
		assertNotNull(
				cdaDeserialized.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getSpecimenCollectionEntry().getSpecimenReceivedEntry());
		assertNotNull(
				cdaDeserialized.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getLaboratoryIsolateOrganizers());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySection()
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct().getNotificationOrganizer());
		assertNotNull(
				cdaDeserialized.getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getNotificationOrganizer().getOutbreakIdentificationObservation());

		assertTrue(cdaDeserialized != null);
		assertEquals("Laboratory Specialty Section",
				cdaDeserialized.getLaboratorySpecialtySection().getTitle());
		assertTrue(
				LabObsListSnomed.BRUCELLA.getCode()
						.equals(cdaDeserialized.getLaboratorySpecialtySection()
								.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
								.getLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations().get(0)
								.getCodeAsSnomedEnum().getCode()));
	}

	@Test
	public void deserializeCdaTestTemplateId() throws Exception {
		final CdaChLrph cda = new CdaChLrph();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrph cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChLrph cda = new CdaChLrph();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private String serializeDocument(CdaChLrph doc) throws Exception {
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

		final CdaChLrph cda = new CdaChLrph();
		cda.addLaboratoryBatteryOrganizer(org);

		cda.getLaboratorySpecialtySection().setTextReference(
				"<table><tr><td>Dies ist ein Test<content ID=\"TestContentIdRef\">Hier steht der menschenlesbare Text</content></td></tr></table>");
		Document document = cda.getDocument();
		xExist(document, "//reference[@value='#TestContentIdRef']");
		xExist(document, "//content[@ID='TestContentIdRef']");
	}

	@Test
	public void testContentModules() throws XPathExpressionException {
		CdaChLrph doc = new CdaChLrph();

		// Specialty Section
		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();
		doc.setLaboratorySpecialtySection(lss);
		assertNotNull(doc.getLaboratorySpecialtySection());
		Document document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));

		// Convenience LaboratoryBatteryOrganizer (automatic section creation)
		doc = new CdaChLrph();
		LaboratoryObservation lo = new LaboratoryObservation();
		lo.setCode(LabObsListLoinc.BRUCELLA);
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addLaboratoryObservation(lo);
		doc.addLaboratoryBatteryOrganizer(lbo);
		assertFalse(doc.getLaboratoryBatteryOrganizerList().isEmpty());
		document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));
		assertTrue(xExist(document,
				"/clinicaldocument/component/structuredBody/component/section/code[@code='18769-0']"));
		// a second Laboratory Battery Organizer
		doc.addLaboratoryBatteryOrganizer(lbo);
		document = doc.getDocument();
		// there must be two Laboratory Battery Organizer
		assertFalse(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']", 2));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));

		// // Laboratory Isolate Organizer
		// doc.addLaboratoryIsolateOrganizer(new LaboratoryIsolateOrganizer());
		// assertFalse(doc.getLaboratoryIsolateOrganizerList().isEmpty());
		// document = doc.getDocument();
		// assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.5",
		// nullt));
		// assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4",
		// null));
		// assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1",
		// null));
		// assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));

		//

	}

	@Override
	@Test
	public void testDocumentHeader() throws XPathExpressionException {
		final CdaChLrph cda = new CdaChLrph();
		final Document document = cda.getDocument();

		// LRPH
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.3.1", null));
	}

	@Test
	public void testNarrativeText() {
		super.init();
		CdaChLrph doc = new CdaChLrph();

		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();
		doc.setLaboratorySpecialtySection(lss);
		doc.setNarrativeTextSectionLaboratorySpeciality(ts1);
		assertEquals(ts1, doc.getNarrativeTextSectionLaboratorySpeciality());
	}
}
