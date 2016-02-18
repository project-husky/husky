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

public class CdaChEdesCtnnTest extends TestUtils {

	private final Log log = LogFactory.getLog(MdhtFacade.class);

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	public CdaChEdesCtnnTest() {
		super();
	}

	@Test
	public void documenHeaderTest() throws XPathExpressionException {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		final Document document = cda.getDocument();

		// Notfallaustrittsbericht Pflege
		XPathExpression expr = xpath
				.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.1.1.12']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// Notfallaustrittsbericht V1
		expr = xpath.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// Composite Triage and Nursing Note
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.13.1.3']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// IHE PCC Medical Documents
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void narrativeSectionsTest() {
		String testText = "";
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		testText = "setNarrativeTextSectionAbilityToWork";
		cda.setNarrativeTextSectionAbilityToWork(testText);
		assertTrue(cda.getNarrativeTextSectionAbilityToWork().contains(testText));

		testText = "setNarrativeTextSectionAcuityAssessment";
		cda.setNarrativeTextSectionAcuityAssessment(testText);
		assertTrue(cda.getNarrativeTextSectionAcuityAssessment().contains(testText));

		testText = "setNarrativeTextSectionAllergiesAndOtherAdverseReactions";
		cda.setNarrativeTextSectionAllergiesAndOtherAdverseReactions(testText);
		assertTrue(
				cda.getNarrativeTextSectionAllergiesAndOtherAdverseReactions().contains(testText));

		testText = "setNarrativeTextSectionAssessments";
		cda.setNarrativeTextSectionAssessments(testText);
		assertTrue(cda.getNarrativeTextSectionAssessments().contains(testText));

		testText = "setNarrativeTextSectionChiefComplaint";
		cda.setNarrativeTextSectionChiefComplaint(testText);
		assertTrue(cda.getNarrativeTextSectionChiefComplaint().contains(testText));

		testText = "setNarrativeTextSectionCodedVitalSigns";
		cda.setNarrativeTextSectionCodedVitalSigns(testText);
		assertTrue(cda.getNarrativeTextSectionCodedVitalSigns().contains(testText));

		testText = "setNarrativeTextSectionEdDisposition";
		cda.setNarrativeTextSectionEdDisposition(testText);
		assertTrue(cda.getNarrativeTextSectionEdDisposition().contains(testText));

		testText = "setNarrativeTextSectionFamilyMedicalHistory";
		cda.setNarrativeTextSectionFamilyMedicalHistory(testText);
		assertTrue(cda.getNarrativeTextSectionFamilyMedicalHistory().contains(testText));

		testText = "setNarrativeTextSectionHistoryOfPastIllness";
		cda.setNarrativeTextSectionHistoryOfPastIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPastIllness().contains(testText));

		testText = "setNarrativeTextSectionHistoryOfPresentIllness";
		cda.setNarrativeTextSectionHistoryOfPresentIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPresentIllness().contains(testText));

		testText = "setNarrativeTextSectionImmunizations";
		cda.setNarrativeTextSectionImmunizations(testText);
		assertTrue(cda.getNarrativeTextSectionImmunizations().contains(testText));

		testText = "setNarrativeTextSectionIntravenousFluidsAdministered";
		cda.setNarrativeTextSectionIntravenousFluidsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionIntravenousFluidsAdministered().contains(testText));

		testText = "setNarrativeTextSectionMedicationsAdministered";
		cda.setNarrativeTextSectionMedicationsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionMedicationsAdministered().contains(testText));

		testText = "setNarrativeTextSectionMedications";
		cda.setNarrativeTextSectionMedications(testText);
		assertTrue(cda.getNarrativeTextSectionMedications().contains(testText));

		testText = "setNarrativeTextSectionModeOfArrival";
		cda.setNarrativeTextSectionModeOfArrival(testText);
		assertTrue(cda.getNarrativeTextSectionModeOfArrival().contains(testText));

		testText = "setNarrativeTextSectionPregnancyHistory";
		cda.setNarrativeTextSectionPregnancyHistory(testText);
		assertTrue(cda.getNarrativeTextSectionPregnancyHistory().contains(testText));

		testText = "setNarrativeTextSectionProceduresAndInterventions";
		cda.setNarrativeTextSectionProceduresAndInterventions(testText);
		assertTrue(cda.getNarrativeTextSectionProceduresAndInterventions().contains(testText));

		testText = "setNarrativeTextSectionReasonForVisit";
		cda.setNarrativeTextSectionReasonForVisit(testText);
		assertTrue(cda.getNarrativeTextSectionReasonForVisit().contains(testText));

		testText = "setNarrativeTextSectionRemarks";
		cda.setNarrativeTextSectionRemarks(testText);
		assertTrue(cda.getNarrativeTextSectionRemarks().contains(testText));

		testText = "setNarrativeTextSectionSocialHistory";
		cda.setNarrativeTextSectionSocialHistory(testText);
		assertTrue(cda.getNarrativeTextSectionSocialHistory().contains(testText));

		testText = "setNarrativeTextSectionListOfSurgeries";
		cda.setNarrativeTextSectionListOfSurgeries(testText);
		assertTrue(cda.getNarrativeTextSectionListOfSurgeries().contains(testText));
	}

	@Test
	public void sectionsLanguageCodeTest() {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		cda.setLanguageCode(LanguageCode.GERMAN);

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_SYSTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.HIGH, ActSite.RIGHT_FOOT,
				new Value("140", Ucum.MilliMetersOfMercury)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.HIGH, ActSite.RIGHT_FOOT,
				new Value("90", Ucum.MilliMetersOfMercury)), null);

		String narrativeGerman = cda.getNarrativeTextSectionCodedVitalSigns();
		assertTrue(narrativeGerman.contains("Körpergewicht"));
		assertTrue(narrativeGerman.contains("Körpergrösse"));
		assertTrue(narrativeGerman.contains("Rechter Fuss"));
	}

	@Test
	public void narrativeSectionsSerializationTest() throws Exception {
		String testText = "Narrative ...\nText.";
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		cda.setNarrativeTextSectionAcuityAssessment(testText);
		cda.setNarrativeTextSectionModeOfArrival(testText);
		cda.setNarrativeTextSectionRemarks(testText);
		cda.setNarrativeTextSectionAbilityToWork(testText);

		final String deserialized = serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesCtnn cdaDeserialized = deserializeCdaDirect(deserialized);

		assertTrue(cdaDeserialized.getNarrativeTextSectionModeOfArrival().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionModeOfArrival()
				.contains(SectionsEDES.MODE_OF_ARRIVAL.getContentIdPrefix()));

		assertTrue(cdaDeserialized.getNarrativeTextSectionAcuityAssessment().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionAcuityAssessment()
				.contains(SectionsEDES.ACUITY_ASSESSMENT.getContentIdPrefix()));

		assertTrue(cdaDeserialized.getNarrativeTextSectionRemarks().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionRemarks()
				.contains(SectionsEDES.REMARKS.getContentIdPrefix()));

		assertTrue(cdaDeserialized.getNarrativeTextSectionAbilityToWork().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionAbilityToWork()
				.contains(SectionsEDES.ABILITY_TO_WORK.getContentIdPrefix()));
	}

	@Test
	public void codedVitalSignsTest() {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.HEART_BEAT, effectiveTime,
				new Value("62", Ucum.PerMinute)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_SYSTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.NORMAL, ActSite.LEFT_ARM,
				new Value("120", Ucum.MilliMetersOfMercury)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.NORMAL, ActSite.LEFT_ARM,
				new Value("80", Ucum.MilliMetersOfMercury)), null);

		List<VitalSignObservation> observations = cda.getCodedVitalSignObservations();
		assertFalse(observations.isEmpty());
		assertEquals(5, observations.size());

		VitalSignObservation vsObservation = getVitalSignObservation(VitalSignCodes.BODY_HEIGHT,
				observations);
		assertNotNull(vsObservation);

		assertEquals("LOINC", vsObservation.getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.BODY_HEIGHT.getLoinc(), vsObservation.getCode().getCode());
		assertEquals(Ucum.CentiMeter.getCodeValue(),
				vsObservation.getValue().getPhysicalQuantityUnit());

		vsObservation = getVitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC,
				observations);
		assertNotNull(vsObservation);

		assertEquals("LOINC", vsObservation.getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.INTRAVASCULAR_DIASTOLIC.getLoinc(),
				vsObservation.getCode().getCode());
		assertEquals(Ucum.MilliMetersOfMercury.getCodeValue(),
				vsObservation.getValue().getPhysicalQuantityUnit());
		assertEquals(ObservationInterpretationVitalSign.NORMAL.getCodeValue(),
				vsObservation.getInterpretationCode().getCode());
		assertEquals(ActSite.LEFT_ARM.getCodeValue(), vsObservation.getTargetSiteCode().getCode());
	}

	@Test
	public void codedVitalSignsSerializationTest() throws Exception {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)), null);

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)), null);

		final String deserialized = serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesCtnn cdaDeserialized = deserializeCdaDirect(deserialized);

		List<VitalSignObservation> observations = cdaDeserialized.getCodedVitalSignObservations();
		assertFalse(observations.isEmpty());
		assertEquals(2, observations.size());

		VitalSignObservation vsObservation = getVitalSignObservation(VitalSignCodes.BODY_HEIGHT,
				observations);
		assertNotNull(vsObservation);

		assertEquals("LOINC", vsObservation.getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.BODY_HEIGHT.getLoinc(), vsObservation.getCode().getCode());
		assertEquals(Ucum.CentiMeter.getCodeValue(),
				vsObservation.getValue().getPhysicalQuantityUnit());
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
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesCtnn cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesCtnn cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	@Test
	public void deserializeCdaTestTemplateId() throws Exception {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesCtnn cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	private CdaChEdesCtnn deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChEdesCtnn(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn) CDAUtil.load(source));
	}

	private CdaChEdesCtnn deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChEdesCtnn());
		return new CdaChEdesCtnn(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn) clinicalDocument);
	}

	private String serializeDocument(CdaChEdesCtnn doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}
}
