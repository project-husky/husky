package org.ehealth_connector.cda.tests;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.ehealth_connector.cda.ActiveProblemConcernEntry;
import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.AllergyProblem;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.GestationalAge;
import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ImmunizationRecommendation;
import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.PastProblemConcern;
import org.ehealth_connector.cda.ProblemEntry;
import org.ehealth_connector.cda.ch.CdaChEdes;
import org.ehealth_connector.cda.ch.CdaChVacd;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.cda.ch.enums.ObservationInterpretation;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.tests.AllTests;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class CdaChVacdTest {
  public static final int NUMBER_OF_RANDOM_STRING_LETTERS = 129;
  public static final int NUMBER_OF_CONTENT_MODULE_TESTS = 50;

  //Test data
  CdaChVacd testDoc;
  CdaChVacd testDoc2;

  String startDateString;
  String endDateString;
  Date startDate;
  Date endDate;
  String ts1;
  String ts2;
  String ts3;
  String ts4;
  String ts5;
  String numS1;
  String numS2;
  Double number;
  String telS1;
  String telS2;
  
  Code code1;
  Code code2;
  Value value1;
  Value value2;
  Identificator id1;
  Identificator id2;
  
  Name name1;
  Name name2;
  Author author1;
  Author author2;
  Organization organization1;
  Consumable consumable1;
  ProblemEntry problem1; 
  
  Immunization immunization1;
  ActiveProblemConcernEntry apce1;
  PastProblemConcern ppc1;
  AllergyConcern ac1;
  
  ImmunizationRecommendation immunizationRecommendation1;

  

  SimpleDateFormat eurDateFormatter;
  Object gtinCode;
  private ProblemEntry problem2;
  private AllergyProblem allergyProblem1;
  private Telecoms telecoms1;


  @Before 
  public void initTestData() {
    //Dates
    eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    startDateString = "28.02.2015";
    endDateString = "28.02.2018";
    
    startDate = DateUtil.date("28.02.2015");
    endDate = DateUtil.date("28.02.2018");

    //Test String with German, French and Italic special characters
    ts1 = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
    ts2 = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
    ts3 = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
    ts4 = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
    ts5 = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
    numS1 = "1231425352";
    numS2 = "987653";
    number = 121241241.212323;
    telS1 = "+41.32.234.66.77";
    telS2 = "+44.32.234.66.99";
    
    //Convenience API Types
    code1 = createCode1();
    code2 = createCode2();
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

  /**
   * <div class="de">Testet die verschiedenen Konstruktoren eines EDES Dokuments</div>
   */
  @Test
  public void setterGetterTest() {
    testDoc = new CdaChVacd();
    
//    consumable1 = testConsumableSetterGetter();
//    problem1 = testProblemEntrySetterGetter();
    
    //Body Sections
//    immunization1 = testImmunizationSetterGetter();
//    ppc1 = testPastProblemConcernGetterSetter();
//    apce1 = testActiveProblemsGetterSetter();
//    ac1 = testAllergyConcernSetterGetter();
//    immunizationRecommendation1 = testImmunizationRecommendationGetterSetter();
    
    testDoc2 = new CdaChVacd(testDoc.getDoc());
    //testDocMetadata("MDHT Document", testDoc2);
    //testProblemEntrySetterGetter();
  }

  @Test
  public void testProblemEntrySetterGetter() {
    ProblemEntry p = new ProblemEntry();
    
    p.setCode(code1);
    assertEquals(true, isEqual(code1, p.getCode()));
    
    p.setId(id1);
    assertEquals(true, isEqual(id1, p.getId()));
    
    p.setStart(startDate);
    assertEquals(startDateString, p.getStart());
    
    p.setNotOccured(true);
    assertEquals(true, p.getProblemNotOccured());
    
    p.addValue(code2);
    assertEquals(true, isEqual(code2, p.getValue().getCode()));
    
    p.addValue(value1);
    assertEquals(true, isEqual(value1, p.getValues().get(1)));
    
    p.addValue(value2);
    assertEquals(true, isEqual(value2, p.getValues().get(2)));
  }
  
  @Test
  public void testAllergyProblemSetterGetter() {
    AllergyProblem p = new AllergyProblem();
    
    p.setId(id1);
    assertEquals(true, isEqual(id1, p.getId()));
    
    p.setStart(startDate);
    assertEquals(startDateString, p.getStart());
    
    p.setNotOccured(true);
    assertEquals(true, p.getNotOccured());
    
    p.addValue(code2);
    assertEquals(true, isEqual(code2, p.getValue().getCode()));
    
    p.addValue(value1);
    assertEquals(true, isEqual(value1, p.getValues().get(1)));
    
    p.addValue(value2);
    assertEquals(true, isEqual(value2, p.getValues().get(2)));
  }

  @Test
  public void testConsumableSetterGetter() {
    Consumable c = new Consumable(ts1);
    
    c.setManufacturedProductId(new Code(CodeSystems.GTIN.getCodeSystemId(), numS1));
    assertEquals(true, isEqual(new Code(CodeSystems.GTIN.getCodeSystemId(), numS1), c.getManufacturedProductId()));
    
    c.setTradeName(ts2);
    assertEquals(ts2, c.getTradeName());
    
    c.setWhoAtcCode(ts3);
    assertEquals(ts3, c.getWhoAtcCode().getCode());
  }
  
  //1
  @Test
  public void testImmunizationSetterGetter() {
    Immunization i = new Immunization();
    
    i.setApplyDate(startDate);
    assertEquals(startDate, i.getApplyDate());
    
    i.setAuthor(author1);
    assertEquals(true, isEqual(author1, i.getAuthor()));
    
    i.setConsumable(consumable1);
    assertEquals(true, isEqual(consumable1, i.getConsumable()));
    
    i.setDosage(number);
    assertEquals(number, Double.valueOf(i.getDosage().getPhysicalQuantityValue()));
    
    i.setId(id1);
    assertEquals(id1, id1);
    
    i.setRouteOfAdministration(RouteOfAdministration.DIFFUSION_TRANSDERMAL);
    assertEquals(RouteOfAdministration.DIFFUSION_TRANSDERMAL, i.getRouteOfAdministration());
  }
  
  //2
  @Test
  public void testActiveProblemsSetterGetter() {
    ActiveProblemConcernEntry a = new ActiveProblemConcernEntry();
    
    a.setId(id1);
    assertEquals(true, isEqual(id1, a.getId()));
    
    a.setStart(startDate);
    assertEquals(startDateString, a.getStart());
    
    a.setEnd(endDate);
    assertEquals(endDateString, a.getEnd());
    
    a.setStatus(ProblemConcernStatusCode.ACTIVE);
    assertEquals(ProblemConcernStatusCode.ACTIVE, a.getStatus());
    
    a.setConcern(ts1);
    assertEquals(ts1, a.getConcern());
    
    a.addProblemEntry(problem1);
    assertTrue(isEqual(problem1, a.getProblemEntry()));
    
    a.addProblemEntry(problem2);
    assertTrue(isEqual(problem2, a.getProblemEntries().get(1)));
  }
  
  //3
  @Test
  public void testPastProblemConcernSetterGetter() {
    PastProblemConcern p = new PastProblemConcern();
    
    p.setId(id1);
    assertEquals(true, isEqual(id1, p.getId()));
    
    p.setStart(startDate);
    assertEquals(startDateString, p.getStart());
    
    p.setEnd(endDate);
    assertEquals(endDateString, p.getEnd());
    
    p.setStatus(ProblemConcernStatusCode.ACTIVE);
    assertEquals(ProblemConcernStatusCode.ACTIVE, p.getStatus());
    
    p.setConcern(ts1);
    assertEquals(ts1, p.getConcern());
  }
  
  //4
  @Test
  public void testAllergyConcernSetterGetter() {
    AllergyConcern a = new AllergyConcern();
    
    a.setId(id1);
    assertEquals(true, isEqual(id1, a.getId()));
    
    a.setStart(startDate);
    assertEquals(startDateString, a.getStart());
    
    a.setEnd(endDate);
    assertEquals(endDateString, a.getEnd());
    
    a.setStatus(ProblemConcernStatusCode.COMPLETED);
    assertEquals(ProblemConcernStatusCode.COMPLETED, a.getStatus());
    
    a.setConcern(ts3);
    assertEquals(ts3, a.getConcern());
    
    a.addAllergyProblem(allergyProblem1);
    assertTrue(isEqual(allergyProblem1, a.getAllergyProblems().get(0)));
    
    a.addAllergyProblem(allergyProblem1);
    assertTrue(isEqual(allergyProblem1, a.getAllergyProblems().get(1)));
  }
  
  //6
  @Test
  public void testCodedResultsSetterGetter() {
    GestationalAge g = new GestationalAge();
    
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
  
  //8
  @Test
  public void testLaboratoryObservation() {
    LaboratoryObservation l = new LaboratoryObservation();
    
    l.setCode(code1);
    assertTrue(isEqual(code1, l.getCode()));
    
    l.setLaboratory(organization1, endDate);
    assertTrue(isEqual(organization1, l.getLaboratory()));
    assertEquals(endDate.getTime(), l.getDateTimeOfResult().getTime());
    
    l.setEffectiveTime(startDate);
    //assertEquals(startDate.getTime(), l.getDateTimeOfResult().getTime());
    assertEquals(startDate.getTime(), l.getEffectiveTime().getTime());
    
    l.setImmuneProtection(true);
    assertTrue(l.getImmuneProtection());
    
    l.setInterpretationCode(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN);
    assertEquals(ObservationInterpretation.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN.getCodeValue(), l.getInterpretationCode());
    
    l.addValue(code2);
    assertTrue(isEqual(code2, l.getValue().getCode()));
    
    l.addValue(value1);
    assertTrue(isEqual(value1, l.getValues().get(1)));
  }
  
  //11
  @Test
  public void testImmunizationRecommendationSetterGetter() {
    ImmunizationRecommendation i = new ImmunizationRecommendation();
    
    i.setAuthor(author2);
    assertEquals(true, isEqual(author2, i.getAuthor()));
    
    i.setId(id2);
    assertEquals(true, isEqual(id2, i.getId()));
    
    i.setIntendedOrProposed(true);
    assertEquals(true, i.getIntendedOrProposed());
    
    i.setPossibleAppliance(startDate, endDate);
    assertEquals(startDateString+" - "+endDateString, i.getPossibleAppliance());
    
    i.setShallNotBeAdministerd(true);
    assertEquals(true, i.gettShallNotBeAdministerd());
    
    i.setConsumable(consumable1);
    assertEquals(true, isEqual(consumable1, i.getConsumable()));
  }

  public void testDocMetadata(String constructorName, CdaChEdes doc) {
    assertNotNull(constructorName+" Constructor - DocumentRoot is null", doc.docRoot);
    assertNotNull(constructorName+" Constructor - Document is null", doc.getDoc());
    assertEquals(constructorName+" Constructor - Wrong Language Code set", "de-CH", doc.getDoc().getLanguageCode().getCode());
  }

  /**
   * Test method for {@link ehealthconnector.cda.documents.ch.CdaChEdes#cAddProblemConcern(ehealthconnector.cda.documents.ch.ProblemConcernEntry)}.
   */
  //	@Test
  //	public void testCAddProblemConcern() {
  //		// Create medical payload (Body)
  //		Code niereninsuffiziez = new Code(CodeSystems.IcrDha080401Disease.getCodeSystemId(), testString);
  //		ProblemEntry problem = new ProblemEntry(false, startDate,endDate, niereninsuffiziez);
  //
  //		// Problem "Bauchschmerzen"
  //		ProblemConcernEntry leiden = new ProblemConcernEntry(testString,
  //				ConvenienceUtilsEnums.StatusCode.completed, startDate,endDate);
  //		leiden.addProblemEntry(problem);
  //		testDoc.addProblemConcern(leiden);
  //
  //		ArrayList<ProblemConcernEntry> problemConcernEntries = testDoc.getProblemConcernEntries();
  //
  //		assertEquals("ProblemConcernEntry Concern not found in document",testString, problemConcernEntries.get(0).getProblemConcern());
  //		assertEquals("ProblemConcernEntry startDate not found in document",startDateString, problemConcernEntries.get(0).getStartOfConcern());
  //		assertEquals("ProblemConcernEntry endDate not found in document",endDateString, problemConcernEntries.get(0).getEndOfConcern());
  //	}

  /**
   * <div class="de">Testet das Hinzufügen mehrerer Leiden mit zugehörigen Problemen zu einem Dokument</div>
   * <div class="fr">Test c add problem concern list.</div>
   * <div class="it">Test c add problem concern list.</div>
   */
  //	@Test
  //	public void testCAddProblemConcernList() {
  //		ProblemConcernEntry problemConcernEntry = null;
  //
  //		//Create three different ProblemEntries
  //		Code code1 = new Code(ConvenienceUtilsEnums.KnownOID.IcrDha080401Disease, "code1");
  //		ProblemEntry problem1 = new ProblemEntry(false, startDate, endDate, code1);
  //		Code code2 = new Code(ConvenienceUtilsEnums.KnownOID.IcrDha080401Disease, "code2");
  //		ProblemEntry problem2 = new ProblemEntry(false, startDate, endDate, code2);
  //		Code code3 = new Code(ConvenienceUtilsEnums.KnownOID.IcrDha080401Disease, "code3");
  //		ProblemEntry problem3 = new ProblemEntry(false, startDate, endDate, code3);
  //
  //		for (int i = 0; i <= NUMBER_OF_CONTENT_MODULE_TESTS; i++) {
  //			testString = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  //
  //			// Create a problemConcernEntry and add the three ProblemEntries
  //			problemConcernEntry = new ProblemConcernEntry(testString,
  //					ConvenienceUtilsEnums.StatusCode.completed, startDate,endDate);
  //			problemConcernEntry.addProblemEntry(problem1);
  //			problemConcernEntry.addProblemEntry(problem2);
  //			problemConcernEntry.addProblemEntry(problem3);
  //
  //			//Add the problemConcernEntry to the document
  //			testDoc.addProblemConcern(problemConcernEntry);
  //
  //			//Get the (unordered) list of all ProblemConcernEntries in the document and check if one of these Entries contains the test Data. 
  //			//If so, check if this ProblemConcernEntry contains all of the three problems.
  //			//If so, the test is passed.
  //			boolean testDataInDocument = false;
  //			for (ProblemConcernEntry testDocProblemConcernEntry :  testDoc.getProblemConcernEntries()) {
  //				
  //				//Problem Concern Entry ok?
  //				if (testDocProblemConcernEntry.getProblemConcern().equals(testString) 
  //						&& testDocProblemConcernEntry.getStartOfConcern().equals(startDateString) 
  //						&& testDocProblemConcernEntry.getEndOfConcern().equals(endDateString)) {
  //					
  //					//Problems ok?
  //					if (testDocProblemConcernEntry.getProblemEntry(0).getCodedProblem().getCode().equals("code1") 
  //							&& testDocProblemConcernEntry.getProblemEntry(1).getCodedProblem().getCode().equals("code2")
  //							&& testDocProblemConcernEntry.getProblemEntry(2).getCodedProblem().getCode().equals("code3")) {
  //						
  //						//Everything ok? => Test Passed
  //						testDataInDocument = true;
  //						break;
  //					}
  //				}
  //			}
  //			assertTrue("ProblemConcernEntry Date (concern || startDate || endDate) not found in document",testDataInDocument);
  //		}
  //		System.out.println("\n\n**** Test Document after adding a list of ProblemConcernEntries: *****\n");
  //		testDoc.addProblemConcern(problemConcernEntry);
  //		testDoc.printXmlToConsole();
  //	}

  /**
   * <div class="de">Testet das Hinzufügen mehrerer medizinischer Probleme zu einerm Leiden</div>
   */
  //	@Test
  //	public void testCAddProblemEntryListToProblemConcernEntry() {
  //		// Create a problemConcernEntry
  ////		ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry("ProblemConcernEntry that holds "+NUMBER_OF_CONTENT_MODULE_TESTS+" Problems",
  ////				ConvenienceUtilsEnums.StatusCode.completed, startDate,endDate);
  ////
  ////		for (int problemCounter = 0; problemCounter <= NUMBER_OF_CONTENT_MODULE_TESTS; problemCounter++) {
  ////			testString = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
  ////
  ////			// Create medical payload (Body)
  ////			Code niereninsuffiziez = new Code(ConvenienceUtilsEnums.KnownOID.IcrDha080401Disease, testString);
  ////			ProblemEntry problem = new ProblemEntry(false, startDate, endDate, niereninsuffiziez);
  ////			System.out.println("testString in problem: "+problem.getCodedProblem().getCode());
  ////
  ////			problemConcernEntry.addProblemEntry(problem);
  ////			System.out.println("testString in problemConcernEntry cGetProblemEntry: "+problemConcernEntry.getProblemEntry(problemCounter).getCodedProblem().getCode());
  ////
  ////			assertEquals("ProblemEntry Concern not found in document",testString, problemConcernEntry.getProblemEntry(problemCounter).getCodedProblem().getCode());
  ////			assertEquals("ProblemEntry startDate not found in document",startDateString, problemConcernEntry.getProblemEntry(problemCounter).getStartOfProblem());
  ////			assertEquals("ProblemEntry endDate not found in document",endDateString, problemConcernEntry.getProblemEntry(problemCounter).getEndOfProblem());
  ////		}
  ////		System.out.println("\n\n**** Test Document after adding a list of ProblemEntries to a problemConcernEntry, which is added to the test document: *****\n");
  ////		testDoc.addProblemConcern(problemConcernEntry);
  ////		testDoc.printXmlToConsole();
  //	}
  
  //Create Test Objects
  public Code createCode1() {
    Code code = new Code(ts1, ts2, ts3, ts4);
    return code;
  }
  
  public Code createCode2() {
    Code code = new Code(ts5, ts4, ts3, ts2);
    return code;
  }
  
  public Code createGtinCode() {
    Code code = new Code(CodeSystems.GTIN, ts3);
    return code;
  }
  
  private Value createValue2() {
    Value value = new Value(ts1, ts2);
    return value;
  }

  private Value createValue1() {
    Value value = new Value("500", "ml");
    return value;
  }
  
  public Identificator createIdentificator1() {
     Identificator id = new Identificator(CodeSystems.GLN, numS1);
    return id;
  }
  
  public Identificator createIdentificator2() {
    Identificator id = new Identificator(CodeSystems.ICD10, numS2);
   return id;
 }
  
  public Name createName1() {
    Name n = new Name(ts1, ts2, ts3, ts4);
    return n;
  }
  
  public Name createName2() {
    Name n = new Name(ts5, ts4, ts3, ts2);
    return n;
  }
  
  public Author createAuthor1() {
    Author a = new Author(createName1(), numS1);
    return a;
  }
  
  public Author createAuthor2() {
    Author a = new Author(createName2(), numS2);
    return a;
  }
  
  public Organization createOrganization1() {
    Organization o = new Organization(ts1, numS1);
    o.setTelecoms(telecoms1);
    return o;
  }
  
  public Telecoms createTelecoms1() {
    Telecoms t = new Telecoms();
    t.addEMail(telS1, AddressUse.BUSINESS);
    t.addEMail(telS2, AddressUse.PRIVATE);
    t.addFax(telS1, AddressUse.BUSINESS);
    t.addFax(telS2, AddressUse.PRIVATE);
    t.addPhone(telS1, AddressUse.BUSINESS);
    t.addPhone(telS2, AddressUse.PRIVATE);
    return t;
  }
  
  public Consumable createConsumable1() {
    Consumable c = new Consumable(ts1, new Code(CodeSystems.GTIN.getCodeSystemId(), numS1), ts2);
    return c;
  }
  
  public Consumable createConsumable2() {
    Consumable c = new Consumable(ts5, new Code(CodeSystems.GLN.getCodeSystemId(), numS2), ts4);
    return c;
  }
  
  public ProblemEntry createProblemEntry() {
    ProblemEntry p = new ProblemEntry();
    
    p.setCode(code1);
    p.setId(id1);
    p.setStart(startDate);
    p.setNotOccured(true);
    p.addValue(code2);
    p.addValue(value1);
    p.addValue(value2);
    
    return p;
  }
  

  private AllergyProblem createAllergyProblem() {
    AllergyProblem p = new AllergyProblem();
    
    p.setId(id1);
    p.setStart(startDate);
    p.setNotOccured(true);
    p.addValue(code2);
    p.addValue(value1);
    p.addValue(value2);
    return p;
  }

  public Consumable createConsumable() {
    Consumable c = new Consumable(ts1);
    
    c.setManufacturedProductId(new Code(CodeSystems.GTIN.getCodeSystemId(), numS1));
    c.setTradeName(ts2);
    c.setWhoAtcCode(ts3);
    
    return consumable1;
  }
  //1  
  public Immunization createImmunization() {
    Immunization i = new Immunization();
    
    i.setApplyDate(startDate);
    i.setAuthor(author1);
    i.setConsumable(consumable1);
    i.setDosage(number);
    i.setId(id1);
    i.setRouteOfAdministration(RouteOfAdministration.DIFFUSION_TRANSDERMAL);
    
    return i;
  }
  
  //2
  public ActiveProblemConcernEntry createActiveProblems() {
    ActiveProblemConcernEntry a = new ActiveProblemConcernEntry();
    
    a.setId(id1);
    a.setStart(startDate);
    a.setEnd(endDate);
    a.setStatus(ProblemConcernStatusCode.ACTIVE);
    a.setConcern(ts1);
    
    return a;
  }
  
  //3
  private PastProblemConcern createPastProblemConcern() {
    PastProblemConcern p = new PastProblemConcern();
    
    p.setId(id1);
    p.setStart(startDate);
    p.setEnd(endDate);
    p.setStatus(ProblemConcernStatusCode.ACTIVE);
    p.setConcern(ts1);
    
    return p;
  }
  
  //4
  public AllergyConcern createAllergyConcern() {
    AllergyConcern a = new AllergyConcern();
    
    a.setId(id1);
    a.setStart(startDate);
    a.setEnd(endDate);
    a.setStatus(ProblemConcernStatusCode.COMPLETED);
    a.setConcern(ts3);
    
    return a;
  }
  
  
  
  //11
  public ImmunizationRecommendation createImmunizationRecommendation() {
    ImmunizationRecommendation i = new ImmunizationRecommendation();
    
    i.setAuthor(author2);
    i.setId(id2);
    i.setIntendedOrProposed(true);
    i.setPossibleAppliance(startDate, endDate);
    i.setShallNotBeAdministerd(true);
    i.setConsumable(consumable1); 
    return i;
  }
 
  
  //Compare Test Objects
  public boolean isEqual(Value v1, Value v2) {
    //Check Code
    if (v1.getCode()!=null) {
      if (!isEqual(v1.getCode(), v2.getCode())) return false;
      if (!v1.isCode()==v2.isCode()) return false;
    }
    
    //Check PQ
    if (v1.getPhysicalQuantityUnit()!=null) {
      if (!v1.getPhysicalQuantityUnit().equals(v2.getPhysicalQuantityUnit())) return false;
      if (!v1.isPhysicalQuantity()==v2.isPhysicalQuantity()) return false;
    }
  
    if (v1.getPhysicalQuantityValue()!=null) {
      if (!v1.getPhysicalQuantityValue().equals(v2.getPhysicalQuantityValue())) return false;
    }
    
    
    return true;
  }
  
  public boolean isEqual(Code c1, Code c2) {
//    if (c1==null && c2==null) {
//      return true;
//    }
//    
    if (!c1.getCode().equals(c2.getCode())) return false;
    if (c1.getCodeSystem()!=null) {
       if (!c1.getCodeSystem().equals(c2.getCodeSystem())) return false;
    }
    else {
      if (c2.getCodeSystem()!=null) return false;
    }
    if (c1.getDisplayName()!=null) {
      if (!c1.getDisplayName().equals(c2.getDisplayName())) return false;
    }
    else {
      if (c2.getDisplayName()!=null) return false;
    }
    return true;
  }
  
  public boolean isEqual(Identificator i1, Identificator i2) {
    if (!i1.getRoot().equals(i2.getRoot())) return false;
    if (!i1.getExtension().equals(i2.getExtension())) return false;
    return true;
  }
  
  public boolean isEqual(Name n1, Name n2) {
    if (!n1.getPrefixes().equals(n2.getPrefixes())) return false;
    if (!n1.getGivenNames().equals(n2.getGivenNames())) return false;
    if (!n1.getFamilyNames().equals(n2.getFamilyNames())) return false;
    if (!n1.getSuffixes().equals(n2.getSuffixes())) return false;
    return true;
  }
  
  public boolean isEqual(Author a1, Author a2) {
    if (!a1.getGln().equals(a2.getGln())) return false;
    for (int i = 0; i<a1.getIds().size(); i++) {
      if (!isEqual(a1.getIds().get(i), a2.getIds().get(i))) return false;
    }
    return true;
  }
  
  public boolean isEqual(Telecoms t1, Telecoms t2) {
    if (t1.getEMails()!=null) {
      for (int i = 0; i<t1.getEMails().size();i++) {
        if (t1.getEMails().get(i) != t2.getEMails().get(i)) return false;
      }
    }
    if (t1.getFaxes()!=null) {
      for (int i = 0; i<t1.getFaxes().size();i++) {
        if (t1.getFaxes().get(i) != t2.getFaxes().get(i)) return false;
      }
    }
    if (t1.getPhones()!=null) {
      for (int i = 0; i<t1.getPhones().size();i++) {
        if (t1.getPhones().get(i) != t2.getPhones().get(i)) return false;
      }
    }
    
    return true;
  }
  
  public boolean isEqual(Organization o1, Organization o2) {
    if (!o1.getId().equals(o2.getId())) return false;
    if (!o1.getName().equals(o2.getName())) return false;
    if (!isEqual(o1.getTelecoms(), o2.getTelecoms())) return false;
    return true;
  }
  
  public boolean isEqual(Consumable c1, Consumable c2) {
    if (!isEqual(c1.getManufacturedMaterialCode(), c2.getManufacturedMaterialCode())) return false;
    if (!isEqual(c1.getManufacturedProductId(), c2.getManufacturedProductId())) return false;
    if (!c1.getTradeName().equals(c2.getTradeName())) return false;
    if (!isEqual(c1.getWhoAtcCode(),c2.getWhoAtcCode())) return false;
    return true;
  }
  
  public boolean isEqual(ProblemEntry p1, ProblemEntry p2) {
    if (!isEqual(p1.getCode(),p2.getCode())) return false;
    if (p1.getEnd() != null && !p1.getEnd().equals(p2.getEnd())) return false;
    if (p1.getStart()!=null && !p1.getStart().equals(p2.getStart())) return false;
    if (!isEqual(p1.getId(), p2.getId())) return false;
    for (int i = 0; i<p1.getValues().size();i++) {
      if (!isEqual(p1.getValues().get(i), p2.getValues().get(i))) return false;
    }
    return true;
  }
  
  public boolean isEqual(AllergyProblem p1, AllergyProblem p2) {
    if (!isEqual(p1.getCode(),p2.getCode())) return false;
    if (p1.getEnd() != null && !p1.getEnd().equals(p2.getEnd())) return false;
    if (p1.getStart()!=null && !p1.getStart().equals(p2.getStart())) return false;
    if (!isEqual(p1.getId(), p2.getId())) return false;
    for (int i = 0; i<p1.getValues().size();i++) {
      if (!isEqual(p1.getValues().get(i), p2.getValues().get(i))) return false;
    }
    return true;
  }
}
