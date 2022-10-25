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
package org.projecthusky.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.projecthusky.common.enums.DateTimeRangeAttributes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of class DateTimeRange
 */
class DateTimeRangeTest {

	private ZonedDateTime testDate1;
	private ZonedDateTime testDate2;
	private String testDateToStr1;
	private ZonedDateTime testDateTo1;
	private ZonedDateTime testDateTo2;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testDate1 = ZonedDateTime.of(1980, 5, 21, 2, 22, 11, 0, ZoneOffset.UTC);
		testDate2 = ZonedDateTime.of(2015, 5, 21, 13, 34, 59, 0, ZoneOffset.UTC);

		testDateToStr1 = "20381231235959";
		testDateTo1 = ZonedDateTime.of(2038, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC);

		testDateTo2 = ZonedDateTime.of(2027, 1, 10, 0, 31, 2, 0, ZoneOffset.UTC);
	}

	@Test
	void testDateTimeRange() {

		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);
		assertEquals(d.getFrom().toInstant(), testDate1.toInstant());
		assertEquals(d.getTo().toInstant(), testDate2.toInstant());// 201401012300

		assertEquals("19800521022211",
				d.getFrom().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC)));
		assertEquals("20150521133459",
				d.getTo().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC)));

		assertEquals("19800521022211", d.getOhtDateTimeRange().getFrom().getDateTime()
				.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC)));
		assertEquals("20150521133459", d.getOhtDateTimeRange().getTo().getDateTime()
				.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC)));

	}

	@Test
	void testSetGetFrom() {
		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);
		d.setFrom(testDateTo2, null);
		assertEquals(testDateTo2.toInstant(), d.getFrom().toInstant());
	}

	@Test
	void testSetGetTo() {
		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);

		d.setTo(testDateTo1, null);

		assertEquals(testDateTo1.toInstant(), d.getTo().toInstant());

		assertEquals(testDateToStr1,
				d.getTo()
						.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC)));
	}
}
