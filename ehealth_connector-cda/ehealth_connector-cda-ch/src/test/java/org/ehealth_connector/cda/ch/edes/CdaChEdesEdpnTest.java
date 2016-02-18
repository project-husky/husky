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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationVitalSign;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CdaChEdesEdpnTest extends TestUtils {

	private final Log log = LogFactory.getLog(MdhtFacade.class);

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	public CdaChEdesEdpnTest() {
		super();
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

	@Test
	public void narrativeSectionsTest() {
		String testText = "Narrative ...\nText.";
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();

		cda.setNarrativeTextSectionAbilityToWork(testText);
		assertTrue(cda.getNarrativeTextSectionAbilityToWork().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAbilityToWork().contains(
				SectionsEDES.ABILITY_TO_WORK.getContentIdPrefix()));

		cda.setNarrativeTextSectionActiveProblems(testText);
		assertTrue(cda.getNarrativeTextSectionActiveProblems().contains(testText));
		assertTrue(cda.getNarrativeTextSectionActiveProblems().contains(
				SectionsEDES.ACTIVE_PROBLEMS.getContentIdPrefix()));

		cda.setNarrativeTextSectionAdvanceDirectives(testText);
		assertTrue(cda.getNarrativeTextSectionAdvanceDirectives().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAdvanceDirectives().contains(
				SectionsEDES.ADVANCE_DIRECTIVES.getContentIdPrefix()));

		cda.setNarrativeTextSectionAllergiesReactions(testText);
		assertTrue(cda.getNarrativeTextSectionAllergiesReactions().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAllergiesReactions().contains(
				SectionsEDES.ALLERGIES_REACTIONS.getContentIdPrefix()));

		cda.setNarrativeTextSectionAssessmentAndPlan(testText);
		assertTrue(cda.getNarrativeTextSectionAssessmentAndPlan().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAssessmentAndPlan().contains(
				SectionsEDES.ASSESSMENT_AND_PLAN.getContentIdPrefix()));

		cda.setNarrativeTextSectionAssessments(testText);
		assertTrue(cda.getNarrativeTextSectionAssessments().contains(testText));
		assertTrue(cda.getNarrativeTextSectionAssessments().contains(
				SectionsEDES.ASSESSMENTS.getContentIdPrefix()));

		cda.setNarrativeTextSectionCarePlan(testText);
		assertTrue(cda.getNarrativeTextSectionCarePlan().contains(testText));
		assertTrue(cda.getNarrativeTextSectionCarePlan().contains(
				SectionsEDES.CARE_PLAN.getContentIdPrefix()));

		cda.setNarrativeTextSectionChiefComplaint(testText);
		assertTrue(cda.getNarrativeTextSectionChiefComplaint().contains(testText));
		assertTrue(cda.getNarrativeTextSectionChiefComplaint().contains(
				SectionsEDES.CHIEF_COMPLAINT.getContentIdPrefix()));

		cda.setNarrativeTextSectionCodedVitalSigns(testText);
		assertTrue(cda.getNarrativeTextSectionCodedVitalSigns().contains(testText));
		assertTrue(cda.getNarrativeTextSectionCodedVitalSigns().contains(
				SectionsEDES.CODED_VITAL_SIGNS.getContentIdPrefix()));

		cda.setNarrativeTextSectionConsultations(testText);
		assertTrue(cda.getNarrativeTextSectionConsultations().contains(testText));
		assertTrue(cda.getNarrativeTextSectionConsultations().contains(
				SectionsEDES.ED_CONSULTATIONS.getContentIdPrefix()));

		cda.setNarrativeTextSectionEDDiagnoses(testText);
		assertTrue(cda.getNarrativeTextSectionEDDiagnoses().contains(testText));
		assertTrue(cda.getNarrativeTextSectionEDDiagnoses().contains(
				SectionsEDES.ED_DIAGNOSIS.getContentIdPrefix()));

		cda.setNarrativeTextSectionEDDisposition(testText);
		assertTrue(cda.getNarrativeTextSectionEDDisposition().contains(testText));
		assertTrue(cda.getNarrativeTextSectionEDDisposition().contains(
				SectionsEDES.ED_DISPOSITION.getContentIdPrefix()));

		cda.setNarrativeTextSectionFamilyMedicalHistory(testText);
		assertTrue(cda.getNarrativeTextSectionFamilyMedicalHistory().contains(testText));
		assertTrue(cda.getNarrativeTextSectionFamilyMedicalHistory().contains(
				SectionsEDES.FAMILY_MEDICAL_HISTORY.getContentIdPrefix()));

		cda.setNarrativeTextSectionHistoryOfPastIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPastIllness().contains(testText));
		assertTrue(cda.getNarrativeTextSectionHistoryOfPastIllness().contains(
				SectionsEDES.HISTORY_OF_PAST_ILLNESS.getContentIdPrefix()));

		cda.setNarrativeTextSectionHistoryOfPresentIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPresentIllness().contains(testText));
		assertTrue(cda.getNarrativeTextSectionHistoryOfPresentIllness().contains(
				SectionsEDES.HISTORY_OF_PRESENT_ILLNESS.getContentIdPrefix()));

		cda.setNarrativeTextSectionHospitalDischargeMedications(testText);
		assertTrue(cda.getNarrativeTextSectionHospitalDischargeMedications().contains(testText));
		assertTrue(cda.getNarrativeTextSectionHospitalDischargeMedications().contains(
				SectionsEDES.HOSPITAL_DISCHARGE_MEDICATIONS.getContentIdPrefix()));

		cda.setNarrativeTextSectionImmunizations(testText);
		assertTrue(cda.getNarrativeTextSectionImmunizations().contains(testText));
		assertTrue(cda.getNarrativeTextSectionImmunizations().contains(
				SectionsEDES.HISTORY_OF_IMMUNIZATION.getContentIdPrefix()));

		cda.setNarrativeTextSectionIntravenousFluidsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionIntravenousFluidsAdministered().contains(testText));
		assertTrue(cda.getNarrativeTextSectionIntravenousFluidsAdministered().contains(
				SectionsEDES.INTRAVENOUS_FLUIDS_ADMINISTERED.getContentIdPrefix()));

		cda.setNarrativeTextSectionMedicationsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionMedicationsAdministered().contains(testText));
		assertTrue(cda.getNarrativeTextSectionMedicationsAdministered().contains(
				SectionsEDES.MEDICATIONS_ADMINISTERED.getContentIdPrefix()));

		cda.setNarrativeTextSectionMedications(testText);
		assertTrue(cda.getNarrativeTextSectionMedications().contains(testText));
		assertTrue(cda.getNarrativeTextSectionMedications().contains(
				SectionsEDES.CURRENT_MEDICATIONS.getContentIdPrefix()));

		cda.setNarrativeTextSectionModeOfArrival(testText);
		assertTrue(cda.getNarrativeTextSectionModeOfArrival().contains(testText));
		assertTrue(cda.getNarrativeTextSectionModeOfArrival().contains(
				SectionsEDES.MODE_OF_ARRIVAL.getContentIdPrefix()));

		cda.setNarrativeTextSectionPhysicalExam(testText);
		assertTrue(cda.getNarrativeTextSectionPhysicalExam().contains(testText));
		assertTrue(cda.getNarrativeTextSectionPhysicalExam().contains(
				SectionsEDES.PHYSICAL_EXAMINATION.getContentIdPrefix()));

		cda.setNarrativeTextSectionPregnancyHistory(testText);
		assertTrue(cda.getNarrativeTextSectionPregnancyHistory().contains(testText));
		assertTrue(cda.getNarrativeTextSectionPregnancyHistory().contains(
				SectionsEDES.HISTORY_OF_PREGNANCIES.getContentIdPrefix()));

		cda.setNarrativeTextSectionProceduresAndInterventions(testText);
		assertTrue(cda.getNarrativeTextSectionProceduresAndInterventions().contains(testText));
		assertTrue(cda.getNarrativeTextSectionProceduresAndInterventions().contains(
				SectionsEDES.PROCEDURES.getContentIdPrefix()));

		cda.setNarrativeTextSectionProgressNote(testText);
		assertTrue(cda.getNarrativeTextSectionProgressNote().contains(testText));
		assertTrue(cda.getNarrativeTextSectionProgressNote().contains(
				SectionsEDES.PROGRESS_NOTE.getContentIdPrefix()));

		cda.setNarrativeTextSectionReasonForVisit(testText);
		assertTrue(cda.getNarrativeTextSectionReasonForVisit().contains(testText));
		assertTrue(cda.getNarrativeTextSectionReasonForVisit().contains(
				SectionsEDES.REASON_FOR_VISIT.getContentIdPrefix()));

		cda.setNarrativeTextSectionReferralSource(testText);
		assertTrue(cda.getNarrativeTextSectionReferralSource().contains(testText));
		assertTrue(cda.getNarrativeTextSectionReferralSource().contains(
				SectionsEDES.REFERRAL_SOURCE.getContentIdPrefix()));

		cda.setNarrativeTextSectionCodedResults(testText);
		assertTrue(cda.getNarrativeTextSectionCodedResults().contains(testText));
		assertTrue(cda.getNarrativeTextSectionCodedResults().contains(
				SectionsEDES.RESULTS.getContentIdPrefix()));

		cda.setNarrativeTextSectionReviewOfSystems(testText);
		assertTrue(cda.getNarrativeTextSectionReviewOfSystems().contains(testText));
		assertTrue(cda.getNarrativeTextSectionReviewOfSystems().contains(
				SectionsEDES.REVIEW_OF_SYSTEMS.getContentIdPrefix()));

		cda.setNarrativeTextSectionRemarks(testText);
		assertTrue(cda.getNarrativeTextSectionRemarks().contains(testText));
		assertTrue(cda.getNarrativeTextSectionRemarks().contains(
				SectionsEDES.REMARKS.getContentIdPrefix()));

		cda.setNarrativeTextSectionSocialHistory(testText);
		assertTrue(cda.getNarrativeTextSectionSocialHistory().contains(testText));
		assertTrue(cda.getNarrativeTextSectionSocialHistory().contains(
				SectionsEDES.SOCIAL_HISTORY.getContentIdPrefix()));

		cda.setNarrativeTextSectionSurgeriesSection(testText);
		assertTrue(cda.getNarrativeTextSectionSurgeriesSection().contains(testText));
		assertTrue(cda.getNarrativeTextSectionSurgeriesSection().contains(
				SectionsEDES.LIST_OF_SURGERIES.getContentIdPrefix()));
	}

	@Test
	public void sectionsLanguageCodeTest() {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		cda.setLanguageCode(LanguageCode.GERMAN);

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_SYSTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.HIGH, ActSite.LEFT_ARM,
				new Value("140", Ucum.MilliMetersOfMercury)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.HIGH, ActSite.LEFT_ARM,
				new Value("90", Ucum.MilliMetersOfMercury)), null);

		String narrativeGerman = cda.getNarrativeTextSectionCodedVitalSigns();
		assertTrue(narrativeGerman.contains("Körpergewicht"));
		assertTrue(narrativeGerman.contains("Körpergrösse"));
		assertTrue(narrativeGerman.contains("Linker Arm"));
	}

	@Test
	public void codedVitalSignsSerializationTest() throws Exception {
		final CdaChEdesEdpn cda = new CdaChEdesEdpn();
		cda.setLanguageCode(LanguageCode.GERMAN);

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)), null);

		final String deserialized = serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesEdpn cdaDeserialized = deserializeCdaDirect(deserialized);

		assertEquals(LanguageCode.GERMAN_CODE, cdaDeserialized.getLanguageCode().getCodeValue());
		List<VitalSignObservation> observations = cdaDeserialized.getCodedVitalSignObservations();
		assertFalse(observations.isEmpty());
		assertEquals(2, observations.size());

		VitalSignObservation vsObservation = getVitalSignObservation(VitalSignCodes.BODY_HEIGHT,
				observations);
		assertNotNull(vsObservation);
		assertEquals("LOINC", vsObservation.getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.BODY_HEIGHT.getLoinc(), vsObservation.getCode().getCode());
		assertEquals(Ucum.CentiMeter.getCodeValue(), vsObservation.getValue()
				.getPhysicalQuantityUnit());
	}

	private VitalSignObservation getVitalSignObservation(VitalSignCodes vsCode,
			List<VitalSignObservation> observations) {
		for (VitalSignObservation vitalSignObservation : observations) {
			if (vitalSignObservation.getCode().getCode().equals(vsCode.getLoinc())) {
				return vitalSignObservation;
			}
		}
		return null;
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

	private CdaChEdesEdpn deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChEdesEdpn(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn) CDAUtil.load(source));
	}

	private CdaChEdesEdpn deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChEdesEdpn());
		return new CdaChEdesEdpn(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn) clinicalDocument);
	}

	private String serializeDocument(CdaChEdesEdpn doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}
}
