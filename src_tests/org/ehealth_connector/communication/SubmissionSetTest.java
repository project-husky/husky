package org.ehealth_connector.communication;

import static org.junit.Assert.*;

import org.ehealth_connector.cda.tests.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.junit.Before;
import org.junit.Test;

public class SubmissionSetTest extends TestUtils {
	
	private SubmissionSetMetadata s;

	@Before
	public void initTestData() {
		s = new SubmissionSetMetadata();
		
		// Test String with German, French and Italic special characters
		ts1 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		numS1 = "1231425352";
		numS2 = "987653";
		number = 121241241.212323;

		// Convenience API Types
		code1 = createCode1();
		code2 = createCode2();
		loincCode = new Code("2.16.840.1.113883.6.1", numS1);
		
		author1 = createAuthor1();
		id1 = createIdentificator1();
	}
	
	@Test
	public void testAuthor() {
		s.setAuthor(author1);
		assertTrue(isEqual(author1, s.getAuthor()));
	}
	
	@Test
	public void testAvailabilityStatus() {
		s.setAvailabilityStatus(AvailabilityStatus.DEPRECATED);
		assertEquals(AvailabilityStatus.DEPRECATED, s.getAvailabilityStatus());
	}
	
	@Test
	public void testComments() {
		s.setComments(ts1);
		assertEquals(ts1, s.getComments());
	}
	
	@Test
	public void testContentType() {
		s.setContentTypeCode(code1);
		assertTrue(isEqual(code1, s.getContentTypeCode()));
	}
	
	@Test
	public void testPatientId() {
		s.setPatientId(id1);
		assertTrue(isEqual(id1, s.getPatientId()));
	}
	
	@Test
	public void testSourceId() {
		s.setSourceId(numS2);
		assertEquals(numS2, s.getSourceId());
	}
	
	@Test
	public void testTitle() {
		s.setTitle(ts2);
		assertEquals(ts2, s.getTitle());
	}
	
}
