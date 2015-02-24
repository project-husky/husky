package org.ehc.cda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.ehc.cda.ProblemConcernEntry;
import org.ehc.cda.ProblemEntry;
import org.ehc.cda.ch.CdaChEdes;
import org.ehc.cda.ch.enums.CodeSystems;
import org.ehc.cda.ch.enums.LanguageCode;
import org.ehc.common.Code;
import org.ehc.common.ConvenienceUtilsEnums;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class CdaChEdesTest {
	public static final int NUMBER_OF_RANDOM_STRING_LETTERS = 129;
	public static final int NUMBER_OF_CONTENT_MODULE_TESTS = 50;

	CdaChEdes testDoc;
	CdaChEdes testDoc2;
	String startDateString;
	String endDateString;
	Date startDate;
	Date endDate;
	String testString; 

	SimpleDateFormat eurDateFormatter; 


	@Before 
	public void initTestData() {
		//Dates
		eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		startDateString = "08.10.2013";
		endDateString = "28.01.2014";
		try {
			startDate = eurDateFormatter.parse(startDateString);
			endDate = eurDateFormatter.parse(endDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Test String with German, French and Italic special sharacters
		testString = AllTests.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);

		//Start the construcorTest at first
		constructorTests();
	}


	/**
	 * <div class="de">Testet die verschiedenen Konstruktoren eines EDES Dokuments</div>
	 * <div class="fr">Constructor tests.</div>
	 * <div class="it">Constructor tests.</div>
	 */
	@Test
	public void constructorTests() {
		testDoc = new CdaChEdes(LanguageCode.GERMAN, testString);
		testDocMetadata("Language, Stylesheet", testDoc);

		testDoc2 = new CdaChEdes(testDoc.getDoc());
		testDocMetadata("MDHT Document", testDoc2);
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
	 * <div class="fr">Test c add problem entry list to problem concern entry.</div>
	 * <div class="it">Test c add problem entry list to problem concern entry.</div>
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
}
