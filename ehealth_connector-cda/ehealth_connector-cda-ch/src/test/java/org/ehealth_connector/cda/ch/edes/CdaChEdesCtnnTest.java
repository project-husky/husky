package org.ehealth_connector.cda.ch.edes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		String testText = "Narrative ...\nText.";
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		cda.setNarrativeTextSectionAbilityToWork(testText);
		assertTrue(cda.getNarrativeTextSectionAbilityToWork().contains(testText));

		cda.setNarrativeTextSectionAcuityAssessment(testText);
		assertTrue(cda.getNarrativeTextSectionAcuityAssessment().contains(testText));

		cda.setNarrativeTextSectionAllergiesReactions(testText);
		assertTrue(cda.getNarrativeTextSectionAllergiesReactions().contains(testText));

		cda.setNarrativeTextSectionAssessments(testText);
		assertTrue(cda.getNarrativeTextSectionAssessments().contains(testText));

		cda.setNarrativeTextSectionChiefComplaint(testText);
		assertTrue(cda.getNarrativeTextSectionChiefComplaint().contains(testText));

		cda.setNarrativeTextSectionCodedVitalSigns(testText);
		assertTrue(cda.getNarrativeTextSectionCodedVitalSigns().contains(testText));

		cda.setNarrativeTextSectionEDDisposition(testText);
		assertTrue(cda.getNarrativeTextSectionEDDisposition().contains(testText));

		cda.setNarrativeTextSectionFamilyMedicalHistory(testText);
		assertTrue(cda.getNarrativeTextSectionFamilyMedicalHistory().contains(testText));

		cda.setNarrativeTextSectionHistoryOfPastIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPastIllness().contains(testText));

		cda.setNarrativeTextSectionHistoryOfPresentIllness(testText);
		assertTrue(cda.getNarrativeTextSectionHistoryOfPresentIllness().contains(testText));

		cda.setNarrativeTextSectionImmunizations(testText);
		assertTrue(cda.getNarrativeTextSectionImmunizations().contains(testText));

		cda.setNarrativeTextSectionIntravenousFluidsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionIntravenousFluidsAdministered().contains(testText));

		cda.setNarrativeTextSectionMedicationsAdministered(testText);
		assertTrue(cda.getNarrativeTextSectionMedicationsAdministered().contains(testText));

		cda.setNarrativeTextSectionMedications(testText);
		assertTrue(cda.getNarrativeTextSectionMedications().contains(testText));

		cda.setNarrativeTextSectionModeOfArrival(testText);
		assertTrue(cda.getNarrativeTextSectionModeOfArrival().contains(testText));

		cda.setNarrativeTextSectionPregnancyHistory(testText);
		assertTrue(cda.getNarrativeTextSectionPregnancyHistory().contains(testText));

		cda.setNarrativeTextSectionProceduresAndInterventions(testText);
		assertTrue(cda.getNarrativeTextSectionProceduresAndInterventions().contains(testText));

		cda.setNarrativeTextSectionReasonForVisit(testText);
		assertTrue(cda.getNarrativeTextSectionReasonForVisit().contains(testText));

		cda.setNarrativeTextSectionRemarks(testText);
		assertTrue(cda.getNarrativeTextSectionRemarks().contains(testText));

		cda.setNarrativeTextSectionSocialHistory(testText);
		assertTrue(cda.getNarrativeTextSectionSocialHistory().contains(testText));

		cda.setNarrativeTextSectionSurgeriesSection(testText);
		assertTrue(cda.getNarrativeTextSectionSurgeriesSection().contains(testText));
	}

	@Test
	public void sectionsLanguageCodeTest() {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();
		cda.setLanguageCode(LanguageCode.GERMAN);

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_SYSTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.HIGH, ActSite.RIGHT_FOOT,
				new Value("140", Ucum.MilliMetersOfMercury)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.HIGH, ActSite.RIGHT_FOOT,
				new Value("90", Ucum.MilliMetersOfMercury)));

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
		assertTrue(cdaDeserialized.getNarrativeTextSectionModeOfArrival().contains(
				SectionsEDES.MODE_OF_ARRIVAL.getContentIdPrefix()));

		assertTrue(cdaDeserialized.getNarrativeTextSectionAcuityAssessment().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionAcuityAssessment().contains(
				SectionsEDES.ACUITY_ASSESSMENT.getContentIdPrefix()));

		assertTrue(cdaDeserialized.getNarrativeTextSectionRemarks().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionRemarks().contains(
				SectionsEDES.REMARKS.getContentIdPrefix()));

		assertTrue(cdaDeserialized.getNarrativeTextSectionAbilityToWork().contains(testText));
		assertTrue(cdaDeserialized.getNarrativeTextSectionAbilityToWork().contains(
				SectionsEDES.ABILITY_TO_WORK.getContentIdPrefix()));
	}

	@Test
	public void codedVitalSignsTest() {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.HEART_BEAT, effectiveTime,
				new Value("62", Ucum.PerMinute)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_SYSTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.NORMAL, ActSite.LEFT_ARM,
				new Value("120", Ucum.MilliMetersOfMercury)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.INTRAVASCULAR_DIASTOLIC,
				effectiveTime, ObservationInterpretationVitalSign.NORMAL, ActSite.LEFT_ARM,
				new Value("80", Ucum.MilliMetersOfMercury)));

		List<VitalSignObservation> observations = cda.getCodedVitalSignObservations();
		assertFalse(observations.isEmpty());
		assertEquals(5, observations.size());

		assertEquals("LOINC", observations.get(0).getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.BODY_HEIGHT.getLoinc(), observations.get(0).getCode().getCode());
		assertEquals(Ucum.CentiMeter.getCodeValue(), observations.get(0).getValue()
				.getPhysicalQuantityUnit());

		assertEquals("LOINC", observations.get(4).getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.INTRAVASCULAR_DIASTOLIC.getLoinc(), observations.get(4)
				.getCode().getCode());
		assertEquals(Ucum.MilliMetersOfMercury.getCodeValue(), observations.get(4).getValue()
				.getPhysicalQuantityUnit());
		assertEquals(ObservationInterpretationVitalSign.NORMAL.getCodeValue(), observations.get(4)
				.getInterpretationCode().getCode());
		assertEquals(ActSite.LEFT_ARM.getCodeValue(), observations.get(4).getTargetSiteCode()
				.getCode());
	}

	@Test
	public void codedVitalSignsSerializationTest() throws Exception {
		final CdaChEdesCtnn cda = new CdaChEdesCtnn();

		Date effectiveTime = DateUtil.dateAndTime("01.01.2001 10:00");

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_HEIGHT, effectiveTime,
				new Value("180", Ucum.CentiMeter)));

		cda.addCodedVitalSign(new VitalSignObservation(VitalSignCodes.BODY_WEIGHT, effectiveTime,
				new Value("80", Ucum.KiloGram)));

		final String deserialized = serializeDocument(cda);
		log.debug(deserialized);
		final CdaChEdesCtnn cdaDeserialized = deserializeCdaDirect(deserialized);

		List<VitalSignObservation> observations = cdaDeserialized.getCodedVitalSignObservations();
		assertFalse(observations.isEmpty());
		assertEquals(2, observations.size());

		assertEquals("LOINC", observations.get(0).getCode().getCodeSystemName());
		assertEquals(VitalSignCodes.BODY_HEIGHT.getLoinc(), observations.get(0).getCode().getCode());
		assertEquals(Ucum.CentiMeter.getCodeValue(), observations.get(0).getValue()
				.getPhysicalQuantityUnit());
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
