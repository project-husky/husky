/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.ehealth_connector.common.enums.DateTimeRangeAttributes;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of class DateTimeRange
 */
class DateTimeRangeTest {

	private Date testDate1;
	private Date testDate2;
	private String testDateToStr1;
	private Date testDateTo1;
	private String testDateToStr2;
	private Date testDateTo2;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testDate1 = DateUtil.parseDateyyyyMMddHHmmss("19800521022211");
		testDate2 = DateUtil.parseDateyyyyMMddHHmmss("20150521133459");

		testDateToStr1 = "20381231235959";
		testDateTo1 = DateUtil.parseDateyyyyMMddHHmmss(testDateToStr1);

		testDateToStr2 = "20270110003102";
		testDateTo2 = DateUtil.parseDateyyyyMMddHHmmss(testDateToStr2);
	}

	@Test
	void testDateTimeRange() {

		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);
		assertEquals(d.getFrom().toInstant(), testDate1.toInstant());
		assertEquals(d.getTo().toInstant(), testDate2.toInstant());// 201401012300

		assertEquals(DateUtil.formatDateTime(d.getFrom()), "19800521022211");
		assertEquals(DateUtil.formatDateTime(d.getTo()), "20150521133459");

		assertEquals("19800521022211", d.getOhtDateTimeRange().getFrom().getDateTime()
				.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault())));
		assertEquals("20150521133459", d.getOhtDateTimeRange().getTo().getDateTime()
				.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault())));

	}

	@Test
	void testSetGetFrom() {
		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);
		d.setFrom(testDateTo2);
		assertEquals(testDateTo2.toInstant(), d.getFrom().toInstant());
	}

	@Test
	void testSetGetTo() {
		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);

		d.setTo(testDateTo1);

		assertEquals(testDateTo1.toInstant(), d.getTo().toInstant());

		assertEquals(testDateToStr1,
				d.getTo()
						.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault())));
	}
}
