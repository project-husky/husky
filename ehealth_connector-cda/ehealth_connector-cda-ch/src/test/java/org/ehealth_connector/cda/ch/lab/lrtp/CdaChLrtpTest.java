/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.lab.BloodGroupObservation;
import org.ehealth_connector.cda.ch.lab.CdaChV12LaboratoryReportTest;
import org.ehealth_connector.cda.ch.lab.StudiesSummarySection;
import org.ehealth_connector.cda.ch.lab.lrqc.enums.SpecialtySections;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.ReportScopes;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.mdht.IntendedRecipient;
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
public class CdaChLrtpTest extends CdaChV12LaboratoryReportTest {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	public CdaChLrtpTest() {
		super.init();
	}

	private CdaChLrtp deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		ChPackage.eINSTANCE.eClass();
		LABPackage.eINSTANCE.eClass();
		final ClinicalDocument clinicalDocument = CDAUtil.load(source);
		if (clinicalDocument instanceof org.openhealthtools.mdht.uml.cda.ch.CdaChLrtpV1) {
			CdaChLrtp test = new CdaChLrtp(
					(org.openhealthtools.mdht.uml.cda.ch.CdaChLrtpV1) clinicalDocument);
			return test;
		} else
			return null;
	}

	private CdaChLrtp deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				ChPackage.eINSTANCE.getCdaChLrtpV1());
		return new CdaChLrtp((org.openhealthtools.mdht.uml.cda.ch.CdaChLrtpV1) clinicalDocument);
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

		// LRTP specific
		VitalSignObservation vs = new VitalSignObservation();
		VitalSignsOrganizer vso = new VitalSignsOrganizer();
		BloodGroupObservation bgo = new BloodGroupObservation();

		lo.setCode(LabObsList.A11_HLA_ANTIGENE);
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		lo.addCommentEntry(sac);
		// lo.addSoasInfoEntry(sie);
		lbo.addLaboratoryObservation(lo);
		spa.addLaboratoryBatteryOrganizer(lbo);
		lrd.setSpecimenAct(spa);
		sps.setLaboratoryReportDataProcessingEntry(lrd);
		cda.addLaboratorySpecialtySection(sps);

		// LRTP specific
		vso.addVitalSignObservation(vs);
		cda.setVitalSignsOrganizer(vso);
		cda.setBloodGroupObservation(bgo);

		assertNotNull(cda.getLaboratorySpecialtySections());
		assertNotNull(cda.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry());
		assertNotNull(cda.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct());
		assertNotNull(
				cda.getLaboratorySpecialtySections().get(0).getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getLrtpLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cda.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrtpLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations().get(0));
		assertNotNull(
				cda.getLaboratorySpecialtySections().get(0).getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct().getLrtpLaboratoryBatteryOrganizers().get(0)
						.getLrtpLaboratoryObservations().get(0).getCommentEntryList().get(0));

		// LRTP specific
		// assertNotNull(cda.getLaboratoryBatteryOrganizerList().get(0).getLaboratoryObservations().get(0)
		// .getSoasInfoEnties().get(0));
		assertNotNull(cda.getVitalSignsOrganizer());
		assertNotNull(cda.getVitalSignsOrganizer().getVitalSignObservations().get(0));
		assertNotNull(cda.getBloodGroupObservation());

		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChLrtp cdaDeserialized = deserializeCda(deserialized);

		assertNotNull(cdaDeserialized.getLaboratorySpecialtySections());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct());
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrtpLaboratoryBatteryOrganizers().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrtpLaboratoryBatteryOrganizers().get(0).getLaboratoryObservations().get(0));
		assertNotNull(cdaDeserialized.getLaboratorySpecialtySections().get(0)
				.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.getLrtpLaboratoryBatteryOrganizers().get(0).getLrtpLaboratoryObservations().get(0)
				.getCommentEntryList().get(0));
		// assertNotNull(cda.getLaboratoryBatteryOrganizerList().get(0).getLaboratoryObservations().get(0)
		// .getSoasInfoEnties().get(0));
		assertNotNull(cda.getVitalSignsOrganizer());
		assertNotNull(cda.getVitalSignsOrganizer().getVitalSignObservations().get(0));
		assertNotNull(cda.getBloodGroupObservation());

		assertTrue(cdaDeserialized != null);
		assertEquals("Laboratory report",
				cdaDeserialized.getLaboratorySpecialtySections().get(0).getTitle());
		assertTrue(LabObsList.A11_HLA_ANTIGENE.getCode()
				.equals(cdaDeserialized.getLaboratorySpecialtySections().get(0)
						.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
						.getLrtpLaboratoryBatteryOrganizers().get(0).getLrtpLaboratoryObservations()
						.get(0).getCodeAsLoincEnum().getCode()));
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
		cda.addLaboratoryBatteryOrganizer(org, SpecialtySections.BLOOD_BANK_STUDIES.getCode());

		cda.getLaboratorySpecialtySections().get(0).setTextReference(
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
		assertNotNull(doc.getLaboratorySpecialtySections());
		Document document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));

		// Convenience LaboratoryBatteryOrganizer (automatic section creation)
		doc = new CdaChLrtp();
		LaboratoryObservation lo = new LaboratoryObservation();
		lo.setCode(LabObsList.A11_HLA_ANTIGENE);
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addLaboratoryObservation(lo);
		doc.addLaboratoryBatteryOrganizer(lbo, SpecialtySections.HLA_STUDIES.getCode());
		assertFalse(doc.getLrtpLaboratoryBatteryOrganizerList().isEmpty());
		document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1", null));
		assertTrue(xExist(document,
				"/clinicaldocument/component/structuredBody/component/section/code[@code='18724-5']"));
		// a second Laboratory Battery Organizer
		doc.addLaboratoryBatteryOrganizer(lbo, SpecialtySections.BLOOD_BANK_STUDIES.getCode());
		document = doc.getDocument();
		// there must be two Laboratory Battery Organizers in two
		// LaboratorySpecialtySections
		assertFalse(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.4", null));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']", 2));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.3.2.1']", 2));
		assertTrue(xCount(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1']", 2));

		// Convenience VitalSignsOrganizer (includes CodedVitalSignsSection)
		doc.setVitalSignsOrganizer(new VitalSignsOrganizer());
		assertNotNull(doc.getCodedVitalSignsSection());
		assertNotNull(doc.getVitalSignsOrganizer());
		document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.1.5.3.2", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.4.13.1", null));

		// Convenience BloodGroupObservation (includes StudiesSummarySection)
		doc.setBloodGroupObservation(new BloodGroupObservation());
		assertNotNull(doc.getStudiesSummarySection());
		assertNotNull(doc.getBloodGroupObservation());
		document = doc.getDocument();
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.Body.StudiesSummaryL2"));
		assertTrue(xExist(document, "//component/section/code[@code='30954-2']"));
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.Body.StudiesSummaryL3.Bloodgroup"));

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

		// DocumentationOf
		cda.addDocumentationOf(ReportScopes.DECEASED_DONOR);
		assertEquals(ReportScopes.DECEASED_DONOR, cda.getDocumentationOfs().get(0));
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

		StudiesSummarySection sss = new StudiesSummarySection();
		doc.setStudiesSummary(sss);
		doc.setNarrativeTextSectionStudiesSummarySection(ts3);
		assertEquals(ts3, doc.getNarrativeTextSectionStudiesSummarySection());

		CodedVitalSignsSection cvs = new CodedVitalSignsSection();
		doc.setCodedVitalSignsSection(cvs);
		doc.setNarrativeTextSectionCodedVitalSignsSection(ts4);
		assertEquals(ts4, doc.getNarrativeTextSectionCodedVitalSignsSection());

	}
}
