package org.ehealth_connector.cda.tests;

import static org.junit.Assert.assertEquals;

import org.ehealth_connector.cda.ch.testhelper.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.junit.Before;
import org.junit.Test;

public class CdaUtilTest extends TestUtils {

	public CdaUtilTest() {
		super();
	}

	@Before
	public void init() {

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
		address1 = createAddress1();
	}

	@Test
	public void setTest() {
		assertEquals(code1, this.code1);
	}
}
