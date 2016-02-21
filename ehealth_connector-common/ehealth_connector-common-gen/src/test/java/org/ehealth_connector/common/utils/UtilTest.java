/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;

/**
 * Test of Util
 */
public class UtilTest {

	private List<String> testFilledList;
	private List<?> testEmptyList;
	private List<?> testNullList;
	private EList<ENXP> testEnxpList1;
	private EList<ENXP> testEnxpList2;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testFilledList = new ArrayList<String>();
		testFilledList.add(new String("Test it"));
		testEmptyList = new ArrayList<>();
		testNullList = null;

		testEnxpList1 = new BasicEList<>();
		final ENXP enxp11 = DatatypesFactory.eINSTANCE.createENXP();
		enxp11.addText("ENXP11");
		testEnxpList1.add(enxp11);

		testEnxpList2 = new BasicEList<>();
		final ENXP enxp21 = DatatypesFactory.eINSTANCE.createENXP();
		enxp21.addText("ENXP21");
		testEnxpList2.add(enxp21);
		final ENXP enxp22 = DatatypesFactory.eINSTANCE.createENXP();
		enxp22.addText("ENXP22");
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
