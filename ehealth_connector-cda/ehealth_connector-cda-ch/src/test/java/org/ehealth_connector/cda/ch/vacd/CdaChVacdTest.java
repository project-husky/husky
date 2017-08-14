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
package org.ehealth_connector.cda.ch.vacd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.AbstractAllergyConcern;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.AbstractPregnancyHistory;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.Problem;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.AllergyProblem;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.PregnancyHistory;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdImmunizations;
import org.ehealth_connector.cda.ch.vacd.enums.ObservationInterpretationForImmunization;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.enums.RouteOfAdministration;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
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
public class CdaChVacdTest extends TestUtils {

	public static final int NUMBER_OF_CONTENT_MODULE_TESTS = 50;

	public static Author getArztAllzeitBereit() {
		final Name arztName = new Name("Allzeit", "Bereit", "Dr. med.");
		final Author arzt = new Author(arztName, "7608888888888");
		final Telecoms arztTelecoms = new Telecoms();
		arztTelecoms.addPhone("+41322345566", AddressUse.PRIVATE);
		arztTelecoms.addFax("+41322345567", AddressUse.BUSINESS);
		arzt.setTelecoms(arztTelecoms);
		return arzt;
	}

	public static Consumable getConsumableBoostrix() {
		final Consumable consumable = new Consumable("BOOSTRIX Polio Inj Susp");
		final Code whoAtc = new Code("2.16.840.1.113883.6.73", "J07CA02");
		final Organization organization = new Organization("GlaxoSmithKline");
		consumable.setManufacturer(organization);
		final Identificator gtin = new Identificator("1.3.160", "7680006370012");
		consumable.setManufacturedProductId(gtin);
		consumable.setLotNr("lotNr");
		consumable.setWhoAtcCode(whoAtc);
		return consumable;
	}

	public static MedicationTargetEntry getMedTargetEntryDiptherie() {
		final MedicationTargetEntry medicationTargetEntry = new MedicationTargetEntry();
		medicationTargetEntry.setImmunizationTarget(CdaChVacdImmunizations.DIPHTHERIA);
		medicationTargetEntry.setId(getSoftwareIdentificator());
		return medicationTargetEntry;
	}

	public static MedicationTargetEntry getMedTargetEntryHepA() {
		final MedicationTargetEntry medicationTargetEntry = new MedicationTargetEntry();
		medicationTargetEntry.setImmunizationTarget(CdaChVacdImmunizations.HEPA);
		medicationTargetEntry.setId(getSoftwareIdentificator());
		return medicationTargetEntry;
	}

	public static MedicationTargetEntry getMedTargetEntryHepB() {
		final MedicationTargetEntry medicationTargetEntry = new MedicationTargetEntry();
		medicationTargetEntry.setImmunizationTarget(CdaChVacdImmunizations.HEPB);
		medicationTargetEntry.setId(getSoftwareIdentificator());
		return medicationTargetEntry;
	}

	public static Identificator getSoftwareIdentificator() {
		return new Identificator("1.2.3.4", "1.2.3.4");
	}

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final XPathFactory xpathFactory = XPathFactory.newInstance();
	private final XPath xpath = xpathFactory.newXPath();
	// Test data
	private CdaChVacd d;
	private Consumable consumable1;
	private Problem problem1;
	private Immunization immunization1;

	private ActiveProblemConcern apce1;
	private PastProblemConcern ppc1;
	private AllergyConcern ac1;
	private ImmunizationRecommendation immunizationRecommendation1;
	private Problem problem2;
	private AbstractAllergyProblem allergyProblem1;
	private GestationalAge cr1;
	private LaboratoryObservation lss1;
	private PregnancyHistory ph1;
	private Immunization immunization2;
	private PastProblemConcern ppc2;

	private ActiveProblemConcern apce2;

	private AllergyConcern ac2;

	private LaboratoryObservation lss2;

	private PregnancyHistory ph2;

	private ImmunizationRecommendation immunizationRecommendation2;

	private Code whoAtcCode;

	public CdaChVacdTest() {
		super();
	}

	// 2
	public ActiveProblemConcern createActiveProblems() {
		final ActiveProblemConcern a = new ActiveProblemConcern();
		a.addId(id1);
		a.setStart(startDate);
		a.setStatus(ProblemConcernStatusCode.ACTIVE);
		a.setConcern(ts1);
		a.addProblemEntry(problem1);
		a.addProblemEntry(problem2);
		return a;
	}

	// 4
	public AllergyConcern createAllergyConcern() {
		final AllergyConcern a = new AllergyConcern();
		a.addId(id1);
		a.setStart(startDate);
		a.setEnd(endDate);
		a.setStatus(ProblemConcernStatusCode.COMPLETED);
		a.setConcern(ts3);
		a.addAllergyProblem(allergyProblem1);
		a.addAllergyProblem(allergyProblem1);
		return a;
	}

	private AbstractAllergyProblem createAllergyProblem() {
		final AbstractAllergyProblem p = new AllergyProblem();
		p.setCode(AllergiesAndIntolerances.FOOD_ALLERGY);
		p.setId(id1);
		p.setStartDate(startDate);
		p.setNotOccured(true);
		p.addValue(problemCode);
		p.addValue(new Value(problemCode));
		p.addValue(new Value(problemCode));
		p.setCommentText(ts1);
		return p;
	}

	// 6
	public GestationalAge createCodedResults() {
		final GestationalAge g = new GestationalAge();
		g.setAsboluteDays(70);
		g.setWeeksAndDays(10, 0);
		g.setAsboluteDays(2);
		g.setWeeksAndDays(0, 2);
		return g;
	}

	// 12
	public SectionAnnotationCommentEntry createComment() {
		final SectionAnnotationCommentEntry commentEntry = new SectionAnnotationCommentEntry();
		commentEntry.setAnnotationCommentText(ts1);
		return commentEntry;
	}

	public Consumable createConsumable() {
		final Consumable c = new Consumable(ts1);
		c.setManufacturedProductId(new Identificator(CodeSystems.GTIN.getCodeSystemId(), numS1));
		c.setTradeName(ts2);
		c.setWhoAtcCode(code2);
		c.setLotNr(numS2);
		return consumable1;
	}

	public Consumable createConsumable1() {
		final Consumable c = new Consumable(ts1,
				new Code(CodeSystems.GTIN.getCodeSystemId(), numS1), code1);
		return c;
	}

	public Consumable createConsumable2() {
		final Consumable c = new Consumable(ts5, new Code(CodeSystems.GLN.getCodeSystemId(), numS2),
				code2);
		return c;
	}

	public CdaChVacd createHeader() {
		// Physician
		final Author arzt = getArztAllzeitBereit();

		final Organization arztPraxis = new Organization("Gruppenpraxis CH", "7608888888888");
		final Address arztPraxisAdresse = new Address("Doktorgasse", "2", "8888", "Musterhausen",
				AddressUse.BUSINESS);
		arztPraxis.addAddress(arztPraxisAdresse);
		arztPraxis.setTelecoms(arzt.getTelecoms());

		// Patient
		final Name patientName = new Name("Franzine", "Muster");
		final Patient patient = new Patient(patientName, AdministrativeGender.FEMALE,
				DateUtil.date("10.02.1967"));
		final Address patientAdresse = new Address("Leidensweg", "10", "9876", "Specimendorf",
				AddressUse.PRIVATE);
		final Telecoms patientTelecoms = new Telecoms();
		patientTelecoms.addPhone("+41326851234", AddressUse.PRIVATE);
		patient.setTelecoms(patientTelecoms);

		// Adding an id using an OID that is already known by the convenience
		// API (AHV-Nr/No AVS/SSN)
		patient.addId(new Identificator(CodeSystems.SwissSSNDeprecated.getCodeSystemId(),
				"123.71.332.115"));
		// Adding an id using an OID that is not known by the convenience API,
		// yet
		patient.addId(new Identificator("2.16.756.5.30.1.123.100.1.1.1", "8077560000000000000000"));

		patient.addAddress(patientAdresse);

		// Create eVACDOC (Header)
		final CdaChVacd doc = new CdaChVacd();
		doc.setLanguageCode(LanguageCode.GERMAN);
		doc.setPatient(patient);
		doc.setCustodian(arztPraxis);
		doc.addAuthor(arzt);
		return doc;
	}

	// 1
	public Immunization createImmunization() {
		final Immunization i = new Immunization();
		i.setApplyDate(startDate);
		i.setAuthor(author1);
		i.setConsumable(consumable1);
		i.setDosage(number);
		i.addId(id1);
		i.setRouteOfAdministration(RouteOfAdministration.DIFFUSION_TRANSDERMAL);
		i.setCommentText(ts1);
		i.setPerformer(author1);
		i.setIntended();
		return i;
	}

	// 11
	public ImmunizationRecommendation createImmunizationRecommendation() {
		final ImmunizationRecommendation i = new ImmunizationRecommendation();
		i.setAuthor(author2);
		i.addId(id2);
		i.setProposed();
		i.setPossibleAppliance(startDate, endDate);
		i.setShallNotBeAdministerd();
		i.setConsumable(consumable1);
		i.addId(id1);
		i.setDosage(number);
		i.setCommentText(ts1);
		i.setIntended();
		return i;
	}

	// 8
	public LaboratoryObservation createLaboratoryObservation() {
		final LaboratoryObservation l = new LaboratoryObservation();
		l.setCode(loincCode);
		l.setLaboratory(organization1, endDate);
		l.setEffectiveTime(startDate);
		l.setInterpretationCode(
				ObservationInterpretationForImmunization.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN);
		l.addValue(code2);
		l.addValue(value1);
		l.setCommentText(ts1);
		return l;
	}

	// 3
	private PastProblemConcern createPastProblemConcern() {
		final PastProblemConcern p = new PastProblemConcern();
		p.addId(id1);
		p.setStart(startDate);
		p.setEnd(endDate);
		p.setStatus(ProblemConcernStatusCode.COMPLETED);
		p.setConcern(ts1);
		p.addProblemEntry(problem1);
		p.addProblemEntry(problem2);
		return p;
	}

	// 9
	public PregnancyHistory createPregnancy() {
		final PregnancyHistory p = new PregnancyHistory();
		p.setEstimatedBirthDate(startDate);
		return p;
	}

	public Problem createProblemEntry() {
		final Problem p = new Problem();
		p.setCode(problemCode);
		p.setId(id1);
		p.setStartDate(startDate);
		p.setNotOccured(true);
		p.addValue(problemCode);
		p.addValue(new Value(problemCode));
		p.addValue(new Value(problemCode));
		return p;
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChVacd vacd = new CdaChVacd();
		final String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		final ClinicalDocument vacdDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	private VACD deserializeVacd(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return (VACD) CDAUtil.load(source);
	}

	private VACD deserializeVacDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getVACD());
		return (VACD) clinicalDocument;
	}

	@Test
	public void deserializeVacDirectTest() throws Exception {
		final CdaChVacd vacd = new CdaChVacd();
		final String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		final VACD vacdDeserialized = deserializeVacDirect(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Test
	public void deserializeVacdTest() throws Exception {
		final CdaChVacd vacd = new CdaChVacd();
		final String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		final VACD vacdDeserialized = deserializeVacd(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Test
	public void deserializeVacdTestTemplateId() throws Exception {
		CHPackage.eINSTANCE.eClass();
		CHPackage.eINSTANCE.getVACD();
		final CdaChVacd vacd = new CdaChVacd();
		final String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		final VACD vacdDeserialized = deserializeVacd(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Before
	public void initTestData() {

		// Dates
		startDateString = "28.02.2015";
		endDateString = "28.02.2018";

		startDate = DateUtil.date("28.02.2015");
		endDate = DateUtil.date("28.02.2018");

		// Test String with German, French and Italic special characters
		ts1 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		numS1 = "1231425352";
		numS2 = "987653";
		number = 121241241.212323;
		telS1 = "+41.32.234.66.77";
		telS2 = "+44.32.234.66.99";

		// Convenience API Types
		code1 = createCode1();
		code2 = createCode2();
		whoAtcCode = new Code(CodeSystems.WHOATCCode.getCodeSystemId(), numS1, numS2);
		loincCode = new Code("2.16.840.1.113883.6.1", numS1);
		problemCode = new Code("2.16.840.1.113883.6.139", numS2);
		value1 = createValue1();
		value2 = createValue2();
		gtinCode = createGtinCode();
		id1 = createIdentificator1();
		id2 = createIdentificator2();
		telecoms1 = createTelecoms1();
		name1 = createName1();
		name2 = createName2();
		author1 = createAuthor1();
		author2 = createAuthor2();
		organization1 = createOrganization1();
		consumable1 = createConsumable1();
		consumable1 = createConsumable2();
		problem1 = createProblemEntry();
		problem2 = createProblemEntry();

		allergyProblem1 = createAllergyProblem();
	}

	private String serializeDocument(CdaChVacd vacd) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(vacd.getDoc(), boas);
		return boas.toString();
	}

	// 2
	@Test
	public void testActiveProblemsSetterGetter() {
		final ActiveProblemConcern a = new ActiveProblemConcern();

		a.addId(id1);
		assertEquals(true, TestUtils.isEqual(id1, a.getIds().get(0)));

		a.setStart(startDate);
		assertEquals(startDateString, a.getStart());

		a.setEnd(endDate);
		assertEquals(endDateString, a.getEnd());

		a.setStatus(ProblemConcernStatusCode.ACTIVE);
		assertEquals(ProblemConcernStatusCode.ACTIVE, a.getStatus());

		a.setConcern(ts1);
		assertEquals(ts1, a.getConcern());

		a.addProblemEntry(problem1);
		assertTrue(TestUtils.isEqual(problem1, a.getProblemEntry()));

		a.addProblemEntry(problem2);
		assertTrue(TestUtils.isEqual(problem2, a.getProblemEntries().get(1)));
	}

	// 4
	@Test
	public void testAllergyConcernSetterGetter() {
		final AbstractAllergyConcern a = new AllergyConcern();

		a.addId(id1);
		assertEquals(true, TestUtils.isEqual(id1, a.getIds().get(0)));

		a.setStart(startDate);
		assertEquals(startDateString, a.getStart());

		a.setEnd(endDate);
		assertEquals(endDateString, a.getEnd());

		a.setStatus(ProblemConcernStatusCode.COMPLETED);
		assertEquals(ProblemConcernStatusCode.COMPLETED, a.getStatus());

		a.setConcern(ts3);
		assertEquals(ts3, a.getConcern());

		a.addAllergyProblem(allergyProblem1);
		assertTrue(TestUtils.isEqual(allergyProblem1, a.getAllergyProblems().get(0)));

		a.addAllergyProblem(allergyProblem1);
		assertTrue(TestUtils.isEqual(allergyProblem1, a.getAllergyProblems().get(1)));
	}

	@Test
	public void testAllergyProblemSetterGetter() {
		final AbstractAllergyProblem p = new AllergyProblem();

		p.setId(id1);
		assertEquals(true, TestUtils.isEqual(id1, p.getId()));

		p.setStartDate(startDate);
		assertEquals(startDate, p.getStartDate());

		p.setNotOccured(true);
		assertEquals(true, p.getNotOccured());

		p.addValue(code2);
		assertEquals(true, TestUtils.isEqual(code2, p.getValue().getCode()));

		p.addValue(value1);
		assertEquals(true, TestUtils.isEqual(value1, p.getValues().get(1)));

		p.addValue(value2);
		assertEquals(true, TestUtils.isEqual(value2, p.getValues().get(2)));

		p.setCommentText(ts1);
		assertEquals(ts1, p.getCommentText());
	}

	@Test
	public void testCdaChVacd() {
		d = createHeader();

		// Body Sections
		immunization1 = createImmunization();
		immunization2 = createImmunization();
		d.addImmunization(immunization1);
		d.addImmunization(immunization2);
		d.setNarrativeTextSectionImmunizations(ts1);
		assertTrue(d.getNarrativeTextSectionImmunizations().contains(ts1));

		ppc1 = createPastProblemConcern();
		ppc2 = createPastProblemConcern();
		d.addPastProblemConcern(ppc1);
		d.addPastProblemConcern(ppc2);
		d.setNarrativeTextSectionHistoryOfPastIllnes(ts2);
		assertTrue(d.getNarrativeTextSectionHistoryOfPastIllnes().contains(ts2));

		apce1 = createActiveProblems();
		apce2 = createActiveProblems();
		d.addActiveProblemConcern(apce1);
		d.addActiveProblemConcern(apce2);
		d.setNarrativeTextSectionActiveProblems(ts3);
		assertTrue(d.getNarrativeTextSectionActiveProblems().contains(ts3));

		ac1 = createAllergyConcern();
		ac2 = createAllergyConcern();
		d.addAllergyConcern(ac1);
		d.addAllergyConcern(ac2);
		d.setNarrativeTextSectionAllergiesAndOtherAdverseReactions(ts4);
		assertTrue(d.getNarrativeTextSectionAllergiesAndOtherAdverseReactions().contains(ts4));

		cr1 = createCodedResults();
		d.addCodedResults(cr1);
		d.setNarrativeTextSectionCodedResults(ts5);
		assertTrue(d.getNarrativeTextSectionCodedResults().contains(ts5));

		lss1 = createLaboratoryObservation();
		lss2 = createLaboratoryObservation();
		d.addLaboratoryObservation(lss1);
		d.addLaboratoryObservation(lss2);
		d.setNarrativeTextSectionLaboratorySpeciality(ts1);
		assertTrue(d.getNarrativeTextSectionLaboratorySpecialty().contains(ts1));

		ph1 = createPregnancy();
		ph2 = createPregnancy();
		d.addPregnancyHistory(ph1);
		d.addPregnancyHistory(ph2);
		d.setNarrativeTextSectionHistoryOfPregnancies(ts2);
		assertTrue(d.getNarrativeTextSectionHistoryOfPregnancies().contains(ts2));

		immunizationRecommendation1 = createImmunizationRecommendation();
		immunizationRecommendation2 = createImmunizationRecommendation();
		d.addImmunizationRecommendation(immunizationRecommendation1);
		d.addImmunizationRecommendation(immunizationRecommendation2);
		d.setNarrativeTextSectionImmunizationRecommendations(ts3);
		assertTrue(d.getNarrativeTextSectionImmunizationRecommendations().contains(ts3));

		d.addComment(ts1);
		d.addComment(ts2);
		d.setNarrativeTextSectionRemarks(ts4);
		assertTrue(d.getNarrativeTextSectionRemarks().contains(ts4));

		try {
			d.saveToFile(getTempFilePath("testVACD.xml"));
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCdaChVacdSectionTitleLanguage() {
		d = createHeader();

		// Test Section Titles in dependence of the document languageCode
		immunization1 = createImmunization();
		immunization2 = createImmunization();
		d.setLanguageCode(LanguageCode.GERMAN);
		d.addImmunization(immunization1);
		assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleDe(),
				d.getDoc().getImmunizationsSection().getTitle().getText());

		d = createHeader();
		d.setLanguageCode(LanguageCode.FRENCH);
		d.addImmunization(immunization1);
		assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleFr(),
				d.getDoc().getImmunizationsSection().getTitle().getText());

		d = createHeader();
		d.setLanguageCode(LanguageCode.ITALIAN);
		d.addImmunization(immunization1);
		assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleIt(),
				d.getDoc().getImmunizationsSection().getTitle().getText());

		d = createHeader();
		d.setLanguageCode(LanguageCode.GERMAN);
		d.addImmunization(immunization1);
		assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleDe(),
				d.getDoc().getImmunizationsSection().getTitle().getText());

		d = createHeader();
		d.setLanguageCode(LanguageCode.FRENCH);
		d.addImmunization(immunization1);
		assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleFr(),
				d.getDoc().getImmunizationsSection().getTitle().getText());

		d = createHeader();
		d.setLanguageCode(LanguageCode.ITALIAN);
		d.addImmunization(immunization1);
		assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleIt(),
				d.getDoc().getImmunizationsSection().getTitle().getText());

	}

	// 6
	@Test
	public void testCodedResultsSetterGetter() {
		final GestationalAge g = new GestationalAge();

		g.setAsboluteDays(70);
		assertEquals(70, g.getAbsoluteDays());
		assertEquals(10, g.getWeeksOfWeeksAndDays());
		assertEquals(0, g.getDaysOfWeeksAndDays());

		g.setWeeksAndDays(10, 0);
		assertEquals(10, g.getWeeksOfWeeksAndDays());
		assertEquals(0, g.getDaysOfWeeksAndDays());
		assertEquals(70, g.getAbsoluteDays());

		g.setAsboluteDays(2);
		assertEquals(2, g.getAbsoluteDays());
		assertEquals(0, g.getWeeksOfWeeksAndDays());
		assertEquals(2, g.getDaysOfWeeksAndDays());

		g.setWeeksAndDays(0, 2);
		assertEquals(0, g.getWeeksOfWeeksAndDays());
		assertEquals(2, g.getDaysOfWeeksAndDays());
		assertEquals(2, g.getAbsoluteDays());
	}

	@Test
	public void testConsumableSetterGetter() {
		final Consumable c = new Consumable(ts1);

		c.setManufacturedProductId(new Identificator(CodeSystems.GTIN.getCodeSystemId(), numS1));
		assertEquals(true,
				TestUtils.isEqual(new Identificator(CodeSystems.GTIN.getCodeSystemId(), numS1),
						c.getManufacturedProductId()));

		c.setTradeName(ts2);
		assertEquals(ts2, c.getTradeName());

		c.setWhoAtcCode(whoAtcCode);
		assertTrue(isEqual(whoAtcCode, c.getWhoAtcCode()));

		c.setManufacturer(organization1);
		assertTrue(isEqual(organization1, c.getManufacturer()));

		c.setLotNr(numS2);
		assertEquals(numS2, c.getLotNr());
	}

	public void testDocMetadata(String constructorName, CdaChVacd doc) {
		assertNotNull(constructorName + " Constructor - DocumentRoot is null", doc.getDocRoot());
		assertNotNull(constructorName + " Constructor - Document is null", doc.getDoc());
		assertEquals(constructorName + " Constructor - Wrong Language Code set", "de-CH",
				doc.getDoc().getLanguageCode().getCode());
	}

	@Test
	public void testDocumentReplaceIdentifier() throws Exception {
		final CdaChVacd vacd = new CdaChVacd();
		assertEquals(null, vacd.getDocumentToReplaceIdentifier());
		final Identificator identificator = new Identificator("root", "ext");
		vacd.setDocumentToReplaceIdentifier(identificator);
		assertEquals(identificator, vacd.getDocumentToReplaceIdentifier());

		final Document document = vacd.getDocument();
		final XPathExpression expr = xpath.compile(
				"clinicaldocument/relatedDocument[@typeCode='RPLC']/parentDocument/id[@root='root' and @extension='ext']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	// 11
	@Test
	public void testImmunizationRecommendationSetterGetter() {
		final ImmunizationRecommendation i = new ImmunizationRecommendation();

		i.setAuthor(author2);
		assertEquals(true, TestUtils.isEqual(author2, i.getAuthor()));

		i.addId(id2);
		assertEquals(true, TestUtils.isEqual(id2, i.getId()));

		i.setProposed();
		assertEquals(true, i.getProposed());
		assertEquals(false, i.getIntended());

		i.setIntended();
		assertEquals(true, i.getIntended());
		assertEquals(false, i.getProposed());

		i.setPossibleAppliance(startDate, endDate);
		assertEquals(startDateString + " - " + endDateString, i.getPossibleApplianceString());

		i.setConsumable(consumable1);
		assertEquals(true, TestUtils.isEqual(consumable1, i.getConsumable()));

		i.setDosage(number);
		assertEquals(number, Double.valueOf(i.getDosage().getPhysicalQuantityValue()));

		i.setCommentText(ts2);
		assertEquals(ts2, i.getCommentText());

	}

	// 1
	@Test
	@Ignore
	public void testImmunizationSetterGetter() {
		final Immunization i = new Immunization();

		i.setApplyDate(startDate);
		assertEquals(startDate, i.getApplyDate());

		i.setAuthor(author1);
		assertEquals(true, TestUtils.isEqual(author1, i.getAuthor()));

		i.setConsumable(consumable1);
		assertEquals(true, TestUtils.isEqual(consumable1, i.getConsumable()));

		i.setDosage(number);
		assertEquals(number, Double.valueOf(i.getDosage().getPhysicalQuantityValue()));

		i.addId(id1);
		assertEquals(id1, id1);

		i.setPriorityCode(code2);
		assertTrue(isEqual(code2, i.getPriorityCode()));

		i.setRouteOfAdministration(RouteOfAdministration.DIFFUSION_TRANSDERMAL);
		assertEquals(RouteOfAdministration.DIFFUSION_TRANSDERMAL, i.getRouteOfAdministration());

		i.setPerformer(author1);
		assertNotNull(i.getPerformer());
		assertTrue(isEqual(author1.getName(), i.getPerformer().getName()));

		assertFalse(i.getIntended());
		i.setIntended();
		assertTrue(i.getIntended());
	}

	// 8
	@Test
	public void testLaboratoryObservationSetterGetter() {
		final LaboratoryObservation l = new LaboratoryObservation();

		l.setCode(code1);
		assertTrue(TestUtils.isEqual(code1, l.getCode()));

		l.setLaboratory(organization1, endDate);
		assertTrue(TestUtils.isEqual(organization1, l.getLaboratory()));
		assertEquals(endDate.getTime(), l.getDateTimeOfResult().getTime());

		l.setEffectiveTime(startDate);
		// assertEquals(startDate.getTime(), l.getDateTimeOfResult().getTime());
		assertEquals(startDate.getTime(), l.getEffectiveTime().getTime());

		l.setInterpretationCode(
				ObservationInterpretationForImmunization.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN);
		assertEquals(
				ObservationInterpretationForImmunization.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN
						.getCodeValue(),
				l.getInterpretationCode().getCode());

		l.addValue(code2);
		assertTrue(TestUtils.isEqual(code2, l.getValue().getCode()));

		l.addValue(value1);
		assertTrue(TestUtils.isEqual(value1, l.getValues().get(1)));

		l.setCommentText(ts1);
		assertEquals(ts1, l.getCommentText());
		l.getCommentRef();
	}

	// 3
	@Test
	public void testPastProblemConcernSetterGetter() {
		final PastProblemConcern p = new PastProblemConcern();

		p.addId(id1);
		assertEquals(true, TestUtils.isEqual(id1, p.getIds().get(p.getIds().size() - 1)));

		p.setStart(startDate);
		assertEquals(startDateString, p.getStart());

		p.setEnd(endDate);
		assertEquals(endDateString, p.getEnd());

		p.setStatus(ProblemConcernStatusCode.COMPLETED);
		assertEquals(ProblemConcernStatusCode.COMPLETED, p.getStatus());

		p.setConcern(ts1);
		assertEquals(ts1, p.getConcern());

		p.addProblemEntry(problem1);
		assertTrue(TestUtils.isEqual(problem1, p.getProblemEntry()));

		p.addProblemEntry(problem2);
		assertTrue(TestUtils.isEqual(problem2, p.getProblemEntries().get(1)));
	}

	// 9
	@Test
	public void testPregnancySetterGetter() {
		final AbstractPregnancyHistory p = new PregnancyHistory();

		p.setEstimatedBirthDate(startDate);
		assertEquals(startDateString, p.getEstimatedBirthdate());
	}

	@Test
	public void testProblemEntrySetterGetter() {
		final Problem p = new Problem();

		p.setCode(code1);
		assertEquals(true, TestUtils.isEqual(code1, p.getCode()));

		p.setId(id1);
		assertEquals(true, TestUtils.isEqual(id1, p.getId()));

		p.setNotOccured(true);
		assertEquals(true, p.getProblemNotOccured());

		p.addValue(code2);
		assertEquals(true, TestUtils.isEqual(code2, p.getValue().getCode()));

		p.addValue(value1);
		assertEquals(true, TestUtils.isEqual(value1, p.getValues().get(1)));

		p.addValue(value2);
		assertEquals(true, TestUtils.isEqual(value2, p.getValues().get(2)));
	}

}
