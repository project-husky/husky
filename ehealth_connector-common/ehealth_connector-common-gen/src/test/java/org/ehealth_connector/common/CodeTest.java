/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.ehealth_connector.common.enums.CodeSystems;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test of class Code
 */
public class CodeTest {

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#Code(java.lang.String, java.lang.String)}
	 * .
	 */
	@Ignore
	@Test
	public void testCodeStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#Code(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Ignore
	@Test
	public void testCodeStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#Code(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Ignore
	@Test
	public void testCodeStringStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#setCD(org.openhealthtools.mdht.uml.hl7.datatypes.CD)}
	 * .
	 */
	@Ignore
	@Test
	public void testSetCD() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#setCode(java.lang.String)}.
	 */
	@Ignore
	@Test
	public void testSetCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#setCodeSystem(java.lang.String)}
	 * .
	 */
	@Ignore
	@Test
	public void testSetCodeSystem() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#setCodeSystemName(java.lang.String)}
	 * .
	 */
	@Ignore
	@Test
	public void testSetCodeSystemName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Code#setNullFlavor(org.ehealth_connector.common.enums.NullFlavor)}
	 * .
	 */
	@Ignore
	@Test
	public void testSetNullFlavor() {
		fail("Not yet implemented");
	}

	@Test
	public void testCodeSystemCode() {
		final Code actStatus = new Code(CodeSystems.ActStatus, "1");
		final Code gtinCode = new Code(CodeSystems.GTIN, "2");

		assertEquals(actStatus.getCodeSystem(), CodeSystems.ActStatus.getCodeSystemId());
		assertEquals(actStatus.getCodeSystemName(), CodeSystems.ActStatus.getCodeSystemName());
		assertEquals(actStatus.getCode(), "1");

		assertEquals(gtinCode.getCodeSystem(), CodeSystems.GTIN.getCodeSystemId());
		assertEquals(gtinCode.getCodeSystemName(), CodeSystems.GTIN.getCodeSystemName());
		assertEquals(gtinCode.getCode(), "2");
	}

}
