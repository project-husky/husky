/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/
package org.ehealth_connector.cda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;

import org.ehealth_connector.cda.ActiveProblemConcern;
import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.AllergyProblem;
import org.ehealth_connector.cda.Comment;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.CodedResults;
import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ImmunizationRecommendation;
import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.PastProblemConcern;
import org.ehealth_connector.cda.Pregnancy;
import org.ehealth_connector.cda.Problem;
import org.ehealth_connector.cda.ch.CdaChEdes;
import org.ehealth_connector.cda.ch.CdaChVacd;
import org.ehealth_connector.cda.ch.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.ch.enums.ObservationInterpretation;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.Performer1;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * 
 *
 */
public class CdaChVacdTest extends TestUtils {

  public static final int NUMBER_OF_CONTENT_MODULE_TESTS = 50;

  //Test data
  TestUtils t;
  CdaChVacd d;
  CdaChVacd testDoc2;

  Consumable consumable1;
  Problem problem1; 

  Immunization immunization1;
  ActiveProblemConcern apce1;
  PastProblemConcern ppc1;
  AllergyConcern ac1;
  Performer p1;

  ImmunizationRecommendation immunizationRecommendation1;
  SimpleDateFormat eurDateFormatter;

  private Problem problem2;
  private AllergyProblem allergyProblem1;

  private CodedResults cr1;
  private LaboratoryObservation lss1;
  private Pregnancy ph1;
  private Immunization immunization2;
  private PastProblemConcern ppc2;
  private ActiveProblemConcern apce2;
  private AllergyConcern ac2;
  private LaboratoryObservation lss2;
  private Pregnancy ph2;
  private ImmunizationRecommendation immunizationRecommendation2;
  private Comment c1;
  private Comment c2;

private Performer performer1;

private Performer performer2;

  public CdaChVacdTest () {
    super();
  }

  //2
  public ActiveProblemConcern createActiveProblems() {
    ActiveProblemConcern a = new ActiveProblemConcern();
    a.setId(id1);
    a.setStart(startDate);
    a.setStatus(ProblemConcernStatusCode.ACTIVE);
    a.setConcern(ts1);
    a.addProblemEntry(problem1);
    a.addProblemEntry(problem2);
    return a;
  }

  //4
  public AllergyConcern createAllergyConcern() {
    AllergyConcern a = new AllergyConcern();
    a.setId(id1);
    a.setStart(startDate);
    a.setEnd(endDate);
    a.setStatus(ProblemConcernStatusCode.COMPLETED);
    a.setConcern(ts3);
    a.addAllergyProblem(allergyProblem1);
    a.addAllergyProblem(allergyProblem1);
    return a;
  }

  private AllergyProblem createAllergyProblem() {
    AllergyProblem p = new AllergyProblem();
    p.setCode(AllergiesAndIntolerances.FOOD_ALLERGY);
    p.setId(id1);
    p.setStart(startDate);
    p.setNotOccured(true);
    p.addValue(problemCode);
    p.addValue(new Value(problemCode));
    p.addValue(new Value(problemCode));
    p.setCommentText(ts1);
    return p;
  }

  //6
  public CodedResults createCodedResults() {
    CodedResults g = new CodedResults();
    g.setAsboluteDays(70);  
    g.setWeeksAndDays(10, 0);
    g.setAsboluteDays(2); 
    g.setWeeksAndDays(0, 2);
    return g;
  }


  //12
  public Comment createComment() {
    org.ehealth_connector.cda.Comment c = new org.ehealth_connector.cda.Comment();

    c.setText(ts1);
    return c;
  }

  public Consumable createConsumable() {
    Consumable c = new Consumable(ts1);
    c.setManufacturedProductId(new Identificator(CodeSystems.GTIN.getCodeSystemId(), numS1));
    c.setTradeName(ts2);
    c.setWhoAtcCode(ts3);
    return consumable1;
  }

  public Consumable createConsumable1() {
    Consumable c = new Consumable(ts1, new Code(CodeSystems.GTIN.getCodeSystemId(), numS1), ts2);
    return c;
  }

  public Consumable createConsumable2() {
    Consumable c = new Consumable(ts5, new Code(CodeSystems.GLN.getCodeSystemId(), numS2), ts4);
    return c;
  }

  public CdaChVacd createHeader() {
    // Physician
    Name arztName = new Name("Allzeit", "Bereit", "Dr. med.");
    Author arzt = new Author(arztName, "7608888888888");

    Telecoms arztTelecoms = new Telecoms();
    arztTelecoms.addPhone("+41322345566", AddressUse.PRIVATE);
    arztTelecoms.addFax("+41322345567", AddressUse.BUSINESS);
    arzt.setTelecoms(arztTelecoms);

    Organization arztPraxis = new Organization("Gruppenpraxis CH", "7608888888888");
    Address arztPraxisAdresse =
        new Address("Doktorgasse", "2", "8888", "Musterhausen", AddressUse.BUSINESS);
    arztPraxis.addAddress(arztPraxisAdresse);
    arztPraxis.setTelecoms(arztTelecoms);

    // Patient
    Name patientName = new Name("Franzine", "Muster");
    Patient patient =
        new Patient(patientName, AdministrativeGender.FEMALE, DateUtil.date("10.02.1967"));
    Address patientAdresse =
        new Address("Leidensweg", "10", "9876", "Specimendorf", AddressUse.PRIVATE);
    Telecoms patientTelecoms = new Telecoms();
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
    CdaChVacd doc = new CdaChVacd();
    doc.setLanguageCode(LanguageCode.GERMAN);
    doc.setPatient(patient);
    doc.setCustodian(arztPraxis);
    doc.addAuthor(arzt);
    return doc;
  }

  //1  
  public Immunization createImmunization() {
    Immunization i = new Immunization();
    i.setApplyDate(startDate);
    i.setAuthor(author1);
    i.setConsumable(consumable1);
    i.setDosage(number);
    i.addId(id1);
    i.setRouteOfAdministration(RouteOfAdministration.DIFFUSION_TRANSDERMAL);
    i.setCommentText(ts1);
    i.setPerformer(author1);
    i.addReason(code1);
    i.addReason(code2);
    return i;
  }

  //11
  public ImmunizationRecommendation createImmunizationRecommendation() {
    ImmunizationRecommendation i = new ImmunizationRecommendation();
    i.setAuthor(author2);
    i.addId(id2);
    i.setProposed();
    i.setPossibleAppliance(startDate, endDate);
    i.setShallNotBeAdministerd(true);
    i.setConsumable(consumable1); 
    i.addId(id1);
    i.setDosage(number);
    i.setPerformer(performer1);
    i.setCommentText(ts1);
    return i;
  }

  //8
  public LaboratoryObservation createLaboratoryObservation() {
    LaboratoryObservation l = new LaboratoryObservation();
    l.setCode(loincCode);  
    l.setLaboratory(organization1, endDate);
    l.setEffectiveTime(startDate);
    l.setImmuneProtection(true);
    l.setInterpretationCode(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN);
    l.addValue(code2);
    l.addValue(value1);
    l.setCommentText(ts1);
    return l;
  }

  //3
  private PastProblemConcern createPastProblemConcern() {
    PastProblemConcern p = new PastProblemConcern();
    p.setId(id1);
    p.setStart(startDate);
    p.setEnd(endDate);
    p.setStatus(ProblemConcernStatusCode.COMPLETED);
    p.setConcern(ts1);
    p.addProblemEntry(problem1);
    p.addProblemEntry(problem2);
    return p;
  }

  //9
  public Pregnancy createPregnancy() {
    Pregnancy p = new Pregnancy(); 
    p.setEstimatedBirthDate(startDate);
    return p;
  }

  public Problem createProblemEntry() {
    Problem p = new Problem();
    p.setCode(problemCode);
    p.setId(id1);
    p.setStart(startDate);
    p.setNotOccured(true);
    p.addValue(problemCode);
    p.addValue(new Value(problemCode));
    p.addValue(new Value(problemCode));
    return p;
  }

  @Before 
  public void initTestData() {  
    t = new TestUtils();

    //Dates
    startDateString = "28.02.2015";
    endDateString = "28.02.2018";

    startDate = DateUtil.date("28.02.2015");
    endDate = DateUtil.date("28.02.2018");

    //Test String with German, French and Italic special characters
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

    //Convenience API Types
    code1 = createCode1();
    code2 = createCode2();
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
    performer1 = createPerformer1();
    performer2 = createPerformer2();
    organization1 = createOrganization1();
    consumable1 = createConsumable1();
    consumable1 = createConsumable2();
    problem1 = createProblemEntry();
    problem2 = createProblemEntry();

    allergyProblem1 = createAllergyProblem();

  }
 
  //2
  @Test
  public void testActiveProblemsSetterGetter() {
    ActiveProblemConcern a = new ActiveProblemConcern();

    a.setId(id1);
    assertEquals(true, TestUtils.isEqual(id1, a.getId()));

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

  //4
  @Test
  public void testAllergyConcernSetterGetter() {
    AllergyConcern a = new AllergyConcern();

    a.setId(id1);
    assertEquals(true, TestUtils.isEqual(id1, a.getId()));

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
    AllergyProblem p = new AllergyProblem();

    p.setId(id1);
    assertEquals(true, TestUtils.isEqual(id1, p.getId()));

    p.setStart(startDate);
    assertEquals(startDateString, p.getStart());

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
  public void testCdaChVacdSectionTitleLanguage() {
    d = createHeader();
    
    //Test Section Titles in dependence of the document languageCode
    immunization1 = createImmunization();
    immunization2 = createImmunization();
    d.setLanguageCode(LanguageCode.GERMAN);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleDe(), d.getDoc().getImmunizationsSection().getTitle().getText());
    
    d = createHeader();
    d.setLanguageCode(LanguageCode.FRENCH);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleFr(), d.getDoc().getImmunizationsSection().getTitle().getText());
    
    d = createHeader();
    d.setLanguageCode(LanguageCode.ITALIAN);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleIt(), d.getDoc().getImmunizationsSection().getTitle().getText());
    
    CS cs = DatatypesFactory.eINSTANCE.createCS();
    
    cs.setCode("de");
    d = createHeader();
    d.getDoc().setLanguageCode(cs);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleDe(), d.getDoc().getImmunizationsSection().getTitle().getText());
    
    d = createHeader();
    cs.setCode("FR");
    d.getDoc().setLanguageCode(cs);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleFr(), d.getDoc().getImmunizationsSection().getTitle().getText());
    
    d = createHeader();
    cs.setCode("It");
    d.getDoc().setLanguageCode(cs);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleIt(), d.getDoc().getImmunizationsSection().getTitle().getText());
    
    d = createHeader();
    cs.setCode("eN");
    d.getDoc().setLanguageCode(cs);
    d.addImmunization(immunization1);
    assertEquals(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitleEn(), d.getDoc().getImmunizationsSection().getTitle().getText());
  }
  
  @Test
  public void testCdaChVacd() {
    d = createHeader();  

    //Body Sections
    immunization1 = createImmunization();
    immunization2 = createImmunization();
    d.addImmunization(immunization1);
    d.addImmunization(immunization2);
    d.setNarrativeTextImmunizations(ts1);
    assertTrue(d.getNarrativeTextImmunizations().contains(ts1));

    ppc1 = createPastProblemConcern();
    ppc2 = createPastProblemConcern();
    d.addPastProblemConcern(ppc1);
    d.addPastProblemConcern(ppc2);
    d.setNarrativeTextPastProblemConcerns(ts2);
    assertTrue(d.getNarrativeTextPastProblemConcerns().contains(ts2));
    
    apce1 = createActiveProblems();
    apce2 = createActiveProblems();
    d.addActiveProblemConcern(apce1);
    d.addActiveProblemConcern(apce2);
    d.setNarrativeTextActiveProblemConcerns(ts3);
    assertTrue(d.getNarrativeTextActiveProblemConcerns().contains(ts3));

    ac1 = createAllergyConcern();
    ac2 = createAllergyConcern();
    d.addAllergyProblemConcern(ac1);
    d.addAllergyProblemConcern(ac2);
    d.setNarrativeTextAllergyProblemConcerns(ts4);
    assertTrue(d.getNarrativeTextAllergyProblemConcerns().contains(ts4));

    cr1 = createCodedResults();
    d.setCodedResults(cr1);
    d.setNarrativeTextCodedResults(ts5);
    assertTrue(d.getNarrativeTextCodedResults().contains(ts5));

    lss1 = createLaboratoryObservation();
    lss2 = createLaboratoryObservation();
    d.addLaboratoryObservation(lss1);
    d.addLaboratoryObservation(lss2);
    d.setNarrativeTextLaboratoryObservation(ts1);
    assertTrue(d.getNarrativeTextLaboratoryObservation().contains(ts1));

    ph1 = createPregnancy();
    ph2 = createPregnancy();
    d.addPregnancy(ph1);
    d.addPregnancy(ph2);
    d.setNarrativeTextPregnancies(ts2);
    assertTrue(d.getNarrativeTextPregnancies().contains(ts2));

    immunizationRecommendation1 = createImmunizationRecommendation();
    immunizationRecommendation2 = createImmunizationRecommendation();
    d.addImmunizationRecommendation(immunizationRecommendation1);
    d.addImmunizationRecommendation(immunizationRecommendation2);
    d.setNarrativeTextImmunizationRecommendations(ts3);
    assertTrue(d.getNarrativeTextImmunizationRecommendation().contains(ts3));

    c1 = createComment();
    c2 = createComment();
    d.addComment(ts1);
    d.addComment(ts2);
    d.setNarrativeTextComments(ts4);
    assertTrue(d.getNarrativeTextComments().contains(ts4));

    try {
      d.saveToFile("C:/temp/testVACD.xml");
    } catch (Exception e) {
      e.printStackTrace();
    }

    testDoc2 = new CdaChVacd(d.getDoc());
    //testDocMetadata("MDHT Document", testDoc2);
    //testProblemEntrySetterGetter();
  }


  //6
  @Test
  public void testCodedResultsSetterGetter() {
    CodedResults g = new CodedResults();

    g.setAsboluteDays(70);
    assertEquals(70, g.getAboluteDays());
    assertEquals(10, g.getWeeksOfWeeksAndDays());
    assertEquals(0,g.getDaysOfWeeksAndDays());

    g.setWeeksAndDays(10, 0);
    assertEquals(10, g.getWeeksOfWeeksAndDays());
    assertEquals(0,g.getDaysOfWeeksAndDays());
    assertEquals(70, g.getAboluteDays());

    g.setAsboluteDays(2);
    assertEquals(2, g.getAboluteDays());
    assertEquals(0, g.getWeeksOfWeeksAndDays());
    assertEquals(2,g.getDaysOfWeeksAndDays());

    g.setWeeksAndDays(0, 2);
    assertEquals(0, g.getWeeksOfWeeksAndDays());
    assertEquals(2,g.getDaysOfWeeksAndDays());
    assertEquals(2, g.getAboluteDays());
  }

  //12
  @Test
  public void testCommentSetterGetter() {
    org.ehealth_connector.cda.Comment c = new org.ehealth_connector.cda.Comment();

    c.setText(ts1);
    assertEquals(ts1, c.getText());
  }

  @Test
  public void testConsumableSetterGetter() {
    Consumable c = new Consumable(ts1);

    c.setManufacturedProductId(new Identificator(CodeSystems.GTIN.getCodeSystemId(), numS1));
    assertEquals(true, TestUtils.isEqual(new Identificator(CodeSystems.GTIN.getCodeSystemId(), numS1), c.getManufacturedProductId()));

    c.setTradeName(ts2);
    assertEquals(ts2, c.getTradeName());

    c.setWhoAtcCode(ts3);
    assertEquals(ts3, c.getWhoAtcCode().getCode());
    
    c.setManufacturer(organization1);
    assertTrue(isEqual(organization1, c.getManufacturer()));
  }

  public void testDocMetadata(String constructorName, CdaChEdes doc) {
    assertNotNull(constructorName+" Constructor - DocumentRoot is null", doc.docRoot);
    assertNotNull(constructorName+" Constructor - Document is null", doc.getDoc());
    assertEquals(constructorName+" Constructor - Wrong Language Code set", "de-CH", doc.getDoc().getLanguageCode().getCode());
  }

  //11
  @Test
  public void testImmunizationRecommendationSetterGetter() {
    ImmunizationRecommendation i = new ImmunizationRecommendation();

    i.setAuthor(author2);
    assertEquals(true, TestUtils.isEqual(author2, i.getAuthor()));

    i.addId(id2);
    assertEquals(true, TestUtils.isEqual(id2, i.getId()));

    i.setProposed();
    assertEquals(true, i.getProposed());
    assertEquals(false, i.getIntended());

    i.setPossibleAppliance(startDate, endDate);
    assertEquals(startDateString+" - "+endDateString, i.getPossibleAppliance());

    i.setShallNotBeAdministerd(true);
    assertEquals(true, i.gettShallNotBeAdministerd());

    i.setConsumable(consumable1);
    assertEquals(true, TestUtils.isEqual(consumable1, i.getConsumable()));
    
    i.setDosage(number);
    assertEquals(number, Double.valueOf(i.getDosage().getPhysicalQuantityValue()));
    
    i.setPerformer(performer1);
    assertTrue(isEqual(name1,i.getPerformer().getName()));
    
    i.addReason(code1);
    assertNotNull(i.getReasons());
    assertTrue(isEqual(code1, i.getReasons().get(0)));
    
    i.addReason(code2);
    assertTrue(isEqual(code2, i.getReasons().get(1)));
    
    i.setCommentText(ts2);
    assertEquals(ts2,i.getCommentText());
  }

  //1
  @Test
  public void testImmunizationSetterGetter() {
    Immunization i = new Immunization();

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
    
    i.addReason(code1);
    assertNotNull(i.getReasons());
    assertTrue(isEqual(code1, i.getReasons().get(0)));
    
    i.addReason(code2);
    assertTrue(isEqual(code2, i.getReasons().get(1)));
    
    i.setCommentText(ts1);
    assertEquals(ts1,i.getCommentText());
  }

  //8
  @Test
  public void testLaboratoryObservationSetterGetter() {
    LaboratoryObservation l = new LaboratoryObservation();

    l.setCode(code1);
    assertTrue(TestUtils.isEqual(code1, l.getCode()));

    l.setLaboratory(organization1, endDate);
    assertTrue(TestUtils.isEqual(organization1, l.getLaboratory()));
    assertEquals(endDate.getTime(), l.getDateTimeOfResult().getTime());

    l.setEffectiveTime(startDate);
    //assertEquals(startDate.getTime(), l.getDateTimeOfResult().getTime());
    assertEquals(startDate.getTime(), l.getEffectiveTime().getTime());

    l.setImmuneProtection(true);
    assertTrue(l.getImmuneProtection());

    l.setInterpretationCode(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN);
    assertEquals(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN.getCodeValue(), l.getInterpretationCode());

    l.addValue(code2);
    assertTrue(TestUtils.isEqual(code2, l.getValue().getCode()));

    l.addValue(value1);
    assertTrue(TestUtils.isEqual(value1, l.getValues().get(1)));
    
    l.setCommentText(ts1);
    assertEquals(ts1, l.getCommentText());
    String t = l.getCommentRef();
  }

  //3
  @Test
  public void testPastProblemConcernSetterGetter() {
    PastProblemConcern p = new PastProblemConcern();

    p.setId(id1);
    assertEquals(true, TestUtils.isEqual(id1, p.getId()));

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

  //9
  @Test
  public void testPregnancySetterGetter() {
    Pregnancy p = new Pregnancy();

    p.setEstimatedBirthDate(startDate);
    assertEquals(startDateString, p.getEstimatedBirthdate());
  }

  @Test
  public void testProblemEntrySetterGetter() {
    Problem p = new Problem();

    p.setCode(code1);
    assertEquals(true, TestUtils.isEqual(code1, p.getCode()));

    p.setId(id1);
    assertEquals(true, TestUtils.isEqual(id1, p.getId()));

    p.setStart(startDate);
    assertEquals(startDateString, p.getStart());

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
