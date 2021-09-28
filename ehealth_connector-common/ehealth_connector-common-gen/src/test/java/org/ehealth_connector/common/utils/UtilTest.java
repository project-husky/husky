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
package org.ehealth_connector.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.hl7cdar2.ENXP;
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
		enxp11.xmlContent = "ENXP11";
		testEnxpList1.add(enxp11);

		testEnxpList2 = new ArrayList<>();
		final ENXP enxp21 = new ENXP();
		enxp21.xmlContent = "ENXP21";
		testEnxpList2.add(enxp21);
		final ENXP enxp22 = new ENXP();
		enxp22.xmlContent = "ENXP22";
		testEnxpList2.add(enxp22);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.utils.Util#atLeastOne(java.util.List)}
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
