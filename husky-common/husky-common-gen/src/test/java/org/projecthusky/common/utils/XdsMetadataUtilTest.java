/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author roeland
 * @version 1.0
 * @since Mar 8, 2017 3:05:46 PM
 *
 */
class XdsMetadataUtilTest {

	private Calendar testCalendar;
	private String testDTM_Y;
	private String testDTM_YM;
	private String testDTM_YMD;
	private String testDTM_YMDH;
	private String testDTM_YMDHM;
	private String testDTM_YMDHMS;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testCalendar = Calendar.getInstance();
		testCalendar.set(1969, 4, 17, 23, 49, 1);
		testDTM_Y = "" + testCalendar.get(Calendar.YEAR);
		testDTM_YM = "" + testCalendar.get(Calendar.YEAR)
				+ String.format("%0" + 2 + "d", (testCalendar.get(Calendar.MONTH) + 1));

		testDTM_YMD = "" + testCalendar.get(Calendar.YEAR)
				+ String.format("%0" + 2 + "d", (testCalendar.get(Calendar.MONTH) + 1))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.DAY_OF_MONTH));
		testDTM_YMDH = "" + testCalendar.get(Calendar.YEAR)
				+ String.format("%0" + 2 + "d", (testCalendar.get(Calendar.MONTH) + 1))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.DAY_OF_MONTH))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.HOUR_OF_DAY));
		testDTM_YMDHM = "" + testCalendar.get(Calendar.YEAR)
				+ String.format("%0" + 2 + "d", (testCalendar.get(Calendar.MONTH) + 1))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.DAY_OF_MONTH))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.HOUR_OF_DAY))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.MINUTE));
		testDTM_YMDHMS = "" + testCalendar.get(Calendar.YEAR)
				+ String.format("%0" + 2 + "d", (testCalendar.get(Calendar.MONTH) + 1))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.DAY_OF_MONTH))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.HOUR_OF_DAY))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.MINUTE))
				+ String.format("%0" + 2 + "d", testCalendar.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYear() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(testDTM_Y);
		assertNotNull(ref1);
		final Calendar refCal1 = Calendar.getInstance();
		refCal1.setTime(ref1);
		assertEquals(testCalendar.get(Calendar.YEAR), refCal1.get(Calendar.YEAR));
		assertEquals(0, refCal1.get(Calendar.MONTH));
		assertEquals(1, refCal1.get(Calendar.DAY_OF_MONTH));
		assertEquals(0, refCal1.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, refCal1.get(Calendar.MINUTE));
		assertEquals(0, refCal1.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYearMonth() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(testDTM_YM);
		assertNotNull(ref1);
		final Calendar refCal1 = Calendar.getInstance();
		refCal1.setTime(ref1);
		assertEquals(testCalendar.get(Calendar.YEAR), refCal1.get(Calendar.YEAR));
		assertEquals(4, refCal1.get(Calendar.MONTH));
		assertEquals(1, refCal1.get(Calendar.DAY_OF_MONTH));
		assertEquals(0, refCal1.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, refCal1.get(Calendar.MINUTE));
		assertEquals(0, refCal1.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYearMonthDay() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(testDTM_YMD);
		assertNotNull(ref1);
		final Calendar refCal1 = Calendar.getInstance();
		refCal1.setTime(ref1);
		assertEquals(testCalendar.get(Calendar.YEAR), refCal1.get(Calendar.YEAR));
		assertEquals(4, refCal1.get(Calendar.MONTH));
		assertEquals(17, refCal1.get(Calendar.DAY_OF_MONTH));
		assertEquals(0, refCal1.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, refCal1.get(Calendar.MINUTE));
		assertEquals(0, refCal1.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYearMonthDayHour() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(testDTM_YMDH);
		assertNotNull(ref1);
		final Calendar refCal1 = Calendar.getInstance();
		refCal1.setTime(ref1);
		assertEquals(testCalendar.get(Calendar.YEAR), refCal1.get(Calendar.YEAR));
		assertEquals(4, refCal1.get(Calendar.MONTH));
		assertEquals(17, refCal1.get(Calendar.DAY_OF_MONTH));
		assertEquals(23, refCal1.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, refCal1.get(Calendar.MINUTE));
		assertEquals(0, refCal1.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYearMonthDayHourMinute() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(testDTM_YMDHM);
		assertNotNull(ref1);
		final Calendar refCal1 = Calendar.getInstance();
		refCal1.setTime(ref1);
		assertEquals(testCalendar.get(Calendar.YEAR), refCal1.get(Calendar.YEAR));
		assertEquals(4, refCal1.get(Calendar.MONTH));
		assertEquals(17, refCal1.get(Calendar.DAY_OF_MONTH));
		assertEquals(23, refCal1.get(Calendar.HOUR_OF_DAY));
		assertEquals(49, refCal1.get(Calendar.MINUTE));
		assertEquals(0, refCal1.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYearMonthDayHourMinuteSecond() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(testDTM_YMDHMS);
		assertNotNull(ref1);
		final Calendar refCal1 = Calendar.getInstance();
		refCal1.setTime(ref1);
		assertEquals(testCalendar.get(Calendar.YEAR), refCal1.get(Calendar.YEAR));
		assertEquals(4, refCal1.get(Calendar.MONTH));
		assertEquals(17, refCal1.get(Calendar.DAY_OF_MONTH));
		assertEquals(23, refCal1.get(Calendar.HOUR_OF_DAY));
		assertEquals(49, refCal1.get(Calendar.MINUTE));
		assertEquals(1, refCal1.get(Calendar.SECOND));
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.common.utils.XdsMetadataUtil#convertDtmStringToDate(java.lang.String)}.
	 */
	@Test
	void testConvertDtmStringToDateYearNullEmpty() {
		final Date ref1 = XdsMetadataUtil.convertDtmStringToDate(null);
		assertNull(ref1);

		final Date ref2 = XdsMetadataUtil.convertDtmStringToDate("");
		assertNull(ref2);
	}

}
