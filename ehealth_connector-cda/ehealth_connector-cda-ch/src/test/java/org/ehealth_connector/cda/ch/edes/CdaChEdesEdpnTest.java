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
package org.ehealth_connector.cda.ch.edes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.BaseVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationForVitalSign;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEdes;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.ChPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@SuppressWarnings("deprecation")
public class CdaChEdesEdpnTest extends TestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final XPathFactory xpathFactory = XPathFactory.newInstance();
	private final XPath xpath = xpathFactory.newXPath();

	public CdaChEdesEdpnTest() {
		super();
	}

	@Test
	public void codedVitalSignsSerializationTest() throws Exception {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		cda.setLanguageCode(LanguageCode.GERMAN);
		VitalSignsOrganizer organizer = new VitalSignsOrganizer();

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(organizer, new VitalSignObservation(VitalSignCodes.BODY_HEIGHT,
				effectiveTime, new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(organizer, new VitalSignObservation(VitalSignCodes.BODY_WEIGHT,
				effectiveTime, new Value("80", Ucum.KiloGram)), null);

		final String deserialized = serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesEdpn cdaDeserialized = deserializeCdaDirect(deserialized);

		assertEquals(LanguageCode.GERMAN_CODE, cdaDeserialized.getLanguageCode().getCodeValue());
		List<BaseVitalSignObservation> observations = cdaDeserialized.getCodedVitalSigns();
		assertFalse(observations.isEmpty());
		assertEquals(2, observations.size());

		BaseVitalSignObservation vsObservation = getVitalSignObservation(VitalSignCodes.BODY_HEIGHT,
				observations);
		assertNotNull(vsObservation);
		assertEquals("LOINC", vsObservation.getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.BODY_HEIGHT.getLoinc(), vsObservation.getCode().getCode());
		assertEquals(Ucum.CentiMeter.getCodeValue(),
				vsObservation.getValue().getPhysicalQuantityUnit());
	}

	private CdaChEdesEdpn deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChEdesEdpn(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesV1Edpn) CDAUtil.load(source));
	}

	private CdaChEdesEdpn deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				ChPackage.eINSTANCE.getCdaChEdesV1Edpn());
		return new CdaChEdesEdpn(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesV1Edpn) clinicalDocument);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesEdpn cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesEdpn cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTestTemplateId() throws Exception {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesEdpn cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void documenHeaderTest() throws XPathExpressionException {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		final Document document = cda.getDocument();

		// Notfallaustrittsbericht Ärzte
		XPathExpression expr = xpath
				.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.1.1.11']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// Notfallaustrittsbericht V1
		expr = xpath.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE EDES ED Physician Note
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.13.1.4']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE PCC Medical Documents
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	private BaseVitalSignObservation getVitalSignObservation(VitalSignCodes vsCode,
			List<BaseVitalSignObservation> observations) {
		for (BaseVitalSignObservation vitalSignObservation : observations) {
			if (vitalSignObservation.getCode().getCode().equals(vsCode.getLoinc())) {
				return vitalSignObservation;
			}
		}
		return null;
	}

	@Test
	public void narrativeSectionsTest() {
		String testText = "";
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();

		testText = "setNarrativeTextSectionAbilityToWork";
		cda.setNarrativeTextSectionAbilityToWork(testText);
		assertTrue(cda.getNarrativeTextSectionAbilityToWork().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAbilityToWork()
				.contains(SectionsEdes.ABILITY_TO_WORK.getContentIdPrefix()));

		testText = "setNarrativeTextSectionActiveProblems";
		cda.setNarrativeTextSectionActiveProblems(testText);
		assertTrue(cda.getNarrativeTextSectionActiveProblems().contains(testText));
		assertTrue(cda.getNarrativeTextSectionActiveProblems()
				.contains(SectionsEdes.ACTIVE_PROBLEMS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionAdvanceDirectives";
		cda.setNarrativeTextSectionAdvanceDirectives(testText);
		assertTrue(cda.getNarrativeTextSectionAdvanceDirectives().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAdvanceDirectives()
				.contains(SectionsEdes.ADVANCE_DIRECTIVES.getContentIdPrefix()));

		testText = "setNarrativeTextSectionAllergiesAndOtherAdverseReactions";
		cda.setNarrativeTextSectionAllergiesAndOtherAdverseReactions(testText);
		assertTrue(
				cda.getNarrativeTextSectionAllergiesAndOtherAdverseReactions().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAllergiesAndOtherAdverseReactions()
				.contains(SectionsEdes.ALLERGIES_AND_OTHER_ADVERSE_REACTIONS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionAssessmentAndPlan";
		cda.setNarrativeTextSectionAssessmentAndPlan(testText);
		assertTrue(cda.getNarrativeTextSectionAssessmentAndPlan().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAssessmentAndPlan()
				.contains(SectionsEdes.ASSESSMENT_AND_PLAN.getContentIdPrefix()));

		testText = "setNarrativeTextSectionAssessments";
		cda.setNarrativeTextSectionAssessments(testText);
		assertTrue(cda.getNarrativeTextSectionAssessments().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAssessments()
				.contains(SectionsEdes.ASSESSMENTS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionCarePlan";
		cda.setNarrativeTextSectionCarePlan(testText);
		assertTrue(cda.getNarrativeTextSectionCarePlan().contains(testText));
		assertTrue(cda.getNarrativeTextSectionCarePlan()
				.contains(SectionsEdes.CARE_PLAN.getContentIdPrefix()));

		testText = "setNarrativeTextSectionChiefComplaint";
		cda.setNarrativeTextSectionChiefComplaint(testText);
		assertTrue(cda.getNarrativeTextSectionChiefComplaint().contains(testText));
		assertTrue(cda.getNarrativeTextSectionChiefComplaint()
				.contains(SectionsEdes.CHIEF_COMPLAINT.getContentIdPrefix()));

		testText = "setNarrativeTextSectionCodedVitalSigns";
		cda.setNarrativeTextSectionCodedVitalSigns(testText);
		assertTrue(cda.getNarrativeTextSectionCodedVitalSigns().contains(testText));
		assertTrue(cda.getNarrativeTextSectionCodedVitalSigns()
				.contains(SectionsEdes.CODED_VITAL_SIGNS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionEdConsultations";
		cda.setNarrativeTextSectionEdConsultations(testText);
		assertTrue(cda.getNarrativeTextSectionEdConsultations().contains(testText));
		assertTrue(cda.getNarrativeTextSectionEdConsultations()
				.contains(SectionsEdes.ED_CONSULTATIONS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionEdDiagnosis";
		cda.setNarrativeTextSectionEdDiagnosis(testText);
		assertTrue(cda.getNarrativeTextSectionEdDiagnosis().contains(testText));
		assertTrue(cda.getNarrativeTextSectionEdDiagnosis()
				.contains(SectionsEdes.ED_DIAGNOSIS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionEdDisposition";
		cda.setNarrativeTextSectionEdDisposition(testText);
		assertTrue(cda.getNarrativeTextSectionEdDisposition().contains(testText));
		assertTrue(cda.getNarrativeTextSectionEdDisposition()
				.contains(SectionsEdes.ED_DISPOSITION.getContentIdPrefix()));

		testText = "setNarrativeTextSectionFamilyMedicalHistory";
		cda.setNarrativeTextSectionFamilyMedicalHistory(testText);
		assertTrue(cda.getNarrativeTextSectionFamilyMedicalHistory().contains(testText));
		assertTrue(cda.getNarrativeTextSectionFamilyMedicalHistory()
				.contains(SectionsEdes.FAMILY_MEDICAL_HISTORY.getContentIdPrefix()));

		testText = "setNarrativeTextSectionHistoryOfPastIllness";
		cda.setNarrativeTextSectionHistoryOfPastIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPastIllness().contains(testText));
		assertTrue(cda.getNarrativeTextSectionHistoryOfPastIllness()
				.contains(SectionsEdes.HISTORY_OF_PAST_ILLNESS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionHistoryOfPresentIllness";
		cda.setNarrativeTextSectionHistoryOfPresentIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPresentIllness().contains(testText));
		assertTrue(cda.getNarrativeTextSectionHistoryOfPresentIllness()
				.contains(SectionsEdes.HISTORY_OF_PRESENT_ILLNESS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionHospitalDischargeMedications";
		cda.setNarrativeTextSectionHospitalDischargeMedications(testText);
		assertTrue(cda.getNarrativeTextSectionHospitalDischargeMedications().contains(testText));
		assertTrue(cda.getNarrativeTextSectionHospitalDischargeMedications()
				.contains(SectionsEdes.HOSPITAL_DISCHARGE_MEDICATIONS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionImmunizations";
		cda.setNarrativeTextSectionImmunizations(testText);
		assertTrue(cda.getNarrativeTextSectionImmunizations().contains(testText));
		assertTrue(cda.getNarrativeTextSectionImmunizations()
				.contains(SectionsEdes.HISTORY_OF_IMMUNIZATION.getContentIdPrefix()));

		testText = "setNarrativeTextSectionIntravenousFluidsAdministered";
		cda.setNarrativeTextSectionIntravenousFluidsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionIntravenousFluidsAdministered().contains(testText));
		assertTrue(cda.getNarrativeTextSectionIntravenousFluidsAdministered()
				.contains(SectionsEdes.INTRAVENOUS_FLUIDS_ADMINISTERED.getContentIdPrefix()));

		testText = "setNarrativeTextSectionMedicationsAdministered";
		cda.setNarrativeTextSectionMedicationsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionMedicationsAdministered().contains(testText));
		assertTrue(cda.getNarrativeTextSectionMedicationsAdministered()
				.contains(SectionsEdes.MEDICATIONS_ADMINISTERED.getContentIdPrefix()));

		testText = "setNarrativeTextSectionMedications";
		cda.setNarrativeTextSectionMedications(testText);
		assertTrue(cda.getNarrativeTextSectionMedications().contains(testText));
		assertTrue(cda.getNarrativeTextSectionMedications()
				.contains(SectionsEdes.CURRENT_MEDICATIONS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionModeOfArrival";
		cda.setNarrativeTextSectionModeOfArrival(testText);
		assertTrue(cda.getNarrativeTextSectionModeOfArrival().contains(testText));
		assertTrue(cda.getNarrativeTextSectionModeOfArrival()
				.contains(SectionsEdes.MODE_OF_ARRIVAL.getContentIdPrefix()));

		testText = "setNarrativeTextSectionCodedPhysicalExam";
		cda.setNarrativeTextSectionCodedPhysicalExam(testText);
		assertTrue(cda.getNarrativeTextSectionCodedPhysicalExam().contains(testText));
		assertTrue(cda.getNarrativeTextSectionCodedPhysicalExam()
				.contains(SectionsEdes.CODED_PHYSICAL_EXAM.getContentIdPrefix()));

		testText = "setNarrativeTextSectionPregnancyHistory";
		cda.setNarrativeTextSectionPregnancyHistory(testText);
		assertTrue(cda.getNarrativeTextSectionPregnancyHistory().contains(testText));
		assertTrue(cda.getNarrativeTextSectionPregnancyHistory()
				.contains(SectionsEdes.HISTORY_OF_PREGNANCIES.getContentIdPrefix()));

		testText = "setNarrativeTextSectionProceduresAndInterventions";
		cda.setNarrativeTextSectionProceduresAndInterventions(testText);
		assertTrue(cda.getNarrativeTextSectionProceduresAndInterventions().contains(testText));
		assertTrue(cda.getNarrativeTextSectionProceduresAndInterventions()
				.contains(SectionsEdes.PROCEDURES.getContentIdPrefix()));

		testText = "setNarrativeTextSectionProgressNote";
		cda.setNarrativeTextSectionProgressNote(testText);
		assertTrue(cda.getNarrativeTextSectionProgressNote().contains(testText));
		assertTrue(cda.getNarrativeTextSectionProgressNote()
				.contains(SectionsEdes.PROGRESS_NOTE.getContentIdPrefix()));

		testText = "setNarrativeTextSectionReasonForVisit";
		cda.setNarrativeTextSectionReasonForVisit(testText);
		assertTrue(cda.getNarrativeTextSectionReasonForVisit().contains(testText));
		assertTrue(cda.getNarrativeTextSectionReasonForVisit()
				.contains(SectionsEdes.REASON_FOR_VISIT.getContentIdPrefix()));

		testText = "setNarrativeTextSectionReferralSource";
		cda.setNarrativeTextSectionReferralSource(testText);
		assertTrue(cda.getNarrativeTextSectionReferralSource().contains(testText));
		assertTrue(cda.getNarrativeTextSectionReferralSource()
				.contains(SectionsEdes.REFERRAL_SOURCE.getContentIdPrefix()));

		testText = "setNarrativeTextSectionResults";
		cda.setNarrativeTextSectionResults(testText);
		assertTrue(cda.getNarrativeTextSectionResults().contains(testText));
		assertTrue(cda.getNarrativeTextSectionResults()
				.contains(SectionsEdes.RESULTS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionReviewOfSystems";
		cda.setNarrativeTextSectionReviewOfSystems(testText);
		assertTrue(cda.getNarrativeTextSectionReviewOfSystems().contains(testText));
		assertTrue(cda.getNarrativeTextSectionReviewOfSystems()
				.contains(SectionsEdes.REVIEW_OF_SYSTEMS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionRemarks";
		cda.setNarrativeTextSectionRemarks(testText);
		assertTrue(cda.getNarrativeTextSectionRemarks().contains(testText));
		assertTrue(cda.getNarrativeTextSectionRemarks()
				.contains(SectionsEdes.REMARKS.getContentIdPrefix()));

		testText = "setNarrativeTextSectionSocialHistory";
		cda.setNarrativeTextSectionSocialHistory(testText);
		assertTrue(cda.getNarrativeTextSectionSocialHistory().contains(testText));
		assertTrue(cda.getNarrativeTextSectionSocialHistory()
				.contains(SectionsEdes.SOCIAL_HISTORY.getContentIdPrefix()));

		testText = "setNarrativeTextSectionListOfSurgeries";
		cda.setNarrativeTextSectionListOfSurgeries(testText);
		assertTrue(cda.getNarrativeTextSectionListOfSurgeries().contains(testText));
		assertTrue(cda.getNarrativeTextSectionListOfSurgeries()
				.contains(SectionsEdes.LIST_OF_SURGERIES.getContentIdPrefix()));
	}

	@Test
	public void sectionsLanguageCodeTest() {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		cda.setLanguageCode(LanguageCode.GERMAN);
		VitalSignsOrganizer organizer = new VitalSignsOrganizer();

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(organizer, new VitalSignObservation(VitalSignCodes.BODY_HEIGHT,
				effectiveTime, new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(organizer, new VitalSignObservation(VitalSignCodes.BODY_WEIGHT,
				effectiveTime, new Value("80", Ucum.KiloGram)), null);

		cda.addCodedVitalSign(organizer,
				new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_SYSTOLIC, effectiveTime,
						ObservationInterpretationForVitalSign.HIGH, ActSite.LEFT_ARM,
						new Value("140", Ucum.MilliMetersOfMercury)),
				null);

		cda.addCodedVitalSign(organizer,
				new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC, effectiveTime,
						ObservationInterpretationForVitalSign.HIGH, ActSite.LEFT_ARM,
						new Value("90", Ucum.MilliMetersOfMercury)),
				null);

		String narrativeGerman = cda.getNarrativeTextSectionCodedVitalSigns();
		assertTrue(narrativeGerman.contains("Körpergewicht"));
		assertTrue(narrativeGerman.contains("Körpergrösse"));
		assertTrue(narrativeGerman.contains("Linker Arm"));
	}

	private String serializeDocument(CdaChEdesEdpn doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}
}
