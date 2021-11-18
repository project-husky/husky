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
package org.husky.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.husky.common.hl7cdar2.ENXP;
import org.husky.common.utils.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of Util
 */
public class UtilTest {

	private List<String> testFilledList;
	private List<?> testEmptyList;
	private List<?> testNullList;
	private List<ENXP> testEnxpList1;
	private List<ENXP> testEnxpList2;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testFilledList = new ArrayList<String>();
		testFilledList.add(new String("Test it"));
		testEmptyList = new ArrayList<>();
		testNullList = null;

		testEnxpList1 = new ArrayList<>();
		final ENXP enxp11 = new ENXP();
		enxp11.setXmlMixed("ENXP11");
		testEnxpList1.add(enxp11);

		testEnxpList2 = new ArrayList<>();
		final ENXP enxp21 = new ENXP();
		enxp21.setXmlMixed("ENXP21");
		testEnxpList2.add(enxp21);
		final ENXP enxp22 = new ENXP();
		enxp22.setXmlMixed("ENXP22");
		testEnxpList2.add(enxp22);
	}

	/**
	 * Test method for
	 * {@link org.husky.common.utils.Util#atLeastOne(java.util.List)}
	 * .
	 */
	@Test
	public void testAtLeastOne() {
		assertTrue(Util.atLeastOne(testFilledList));
		assertFalse(Util.atLeastOne(testEmptyList));
		assertFalse(Util.atLeastOne(testNullList));
	}

	@Test
	public void testJoinEListStr() {
		final String ref1 = Util.joinEListStr(testEnxpList1);
		assertNotNull(ref1);
		assertEquals("ENXP11", ref1);

		final String ref2 = Util.joinEListStr(testEnxpList2);
		assertNotNull(ref2);
		assertEquals("ENXP21 ENXP22", ref2);
	}

}
