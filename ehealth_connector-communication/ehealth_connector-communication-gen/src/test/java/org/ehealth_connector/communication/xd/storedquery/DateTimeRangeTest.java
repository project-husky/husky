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
package org.ehealth_connector.communication.xd.storedquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.ehealth_connector.common.mdht.enums.DateTimeRangeAttributes;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.query.MalformedQueryException;

/**
 * Test of class DateTimeRange
 */
public class DateTimeRangeTest {

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
	@Before
	public void setUp() throws Exception {
		testDate1 = DateUtil.parseDateyyyyMMddHHmmss("19800521022211");
		testDate2 = DateUtil.parseDateyyyyMMddHHmmss("20150521133459");

		testDateToStr1 = "20381231235959";
		testDateTo1 = DateUtil.parseDateyyyyMMddHHmmss(testDateToStr1);

		testDateToStr2 = "20270110003102";
		testDateTo2 = DateUtil.parseDateyyyyMMddHHmmss(testDateToStr2);
	}

	@Test
	public void testDateTimeRange() throws MalformedQueryException {

		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);
		assertTrue(d.getFrom().getTime() == testDate1.getTime());
		assertTrue(d.getTo().getTime() == testDate2.getTime());// 201401012300

		assertTrue(DateUtil.format(d.getFrom()).equals("19800521022211"));
		assertTrue(DateUtil.format(d.getTo()).equals("20150521133459"));

		assertEquals("19800521022211", d.getOhtDateTimeRange().getFrom());
		assertEquals("20150521133459", d.getOhtDateTimeRange().getTo());

	}

	@Test
	public void testSetGetFrom() throws MalformedQueryException {
		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);
		d.setFrom(testDateTo2);
		assertEquals(testDateTo2, d.getFrom());
	}

	@Test
	public void testSetGetTo() throws MalformedQueryException {
		final DateTimeRange d = new DateTimeRange(DateTimeRangeAttributes.CREATION_TIME, testDate1,
				testDate2);

		d.setTo(testDateTo1);

		assertEquals(testDateTo1, d.getTo());

		assertEquals(testDateToStr1, d.getToAsUsFormattedString());
	}
}
