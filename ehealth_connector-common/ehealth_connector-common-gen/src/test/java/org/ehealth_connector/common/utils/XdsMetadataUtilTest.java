/* **********************************************************************
 * Author: roeland
 * Date  : Mar 8, 2017
 * File  : XdsMetadataUtilTest.java
 * **********************************************************************
 * ehealth_connector-common-gen
 *
 * Copyright (c) 2017
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */
package org.ehealth_connector.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Mar 8, 2017 3:05:46 PM
 *
 */
public class XdsMetadataUtilTest {

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
	@Before
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
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYearNullEmpty() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(null);
		assertNull(ref1);

		final Date ref2 = XdsMetadataUtil.convertDTMStringToDate("");
		assertNull(ref2);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYear() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(testDTM_Y);
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
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYearMonth() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(testDTM_YM);
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
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYearMonthDay() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(testDTM_YMD);
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
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYearMonthDayHour() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(testDTM_YMDH);
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
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYearMonthDayHourMinute() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(testDTM_YMDHM);
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
	 * {@link org.ehealth_connector.common.utils.XdsMetadataUtil#convertDTMStringToDate(java.lang.String)}.
	 */
	@Test
	public void testConvertDTMStringToDateYearMonthDayHourMinuteSecond() {
		final Date ref1 = XdsMetadataUtil.convertDTMStringToDate(testDTM_YMDHMS);
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

}
