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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.ehealth_connector.common.enums.AddressUse;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test of class Telecoms
 */
public class TelecomsTest {

	private String numS1;
	private String numS2;

	private String telS1;
	private String telS2;
	private String testWebsite1;
	private String testWebsite2;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		numS1 = "1231425352";
		numS2 = "987653";
		telS1 = "+41.32.234.66.77";
		telS2 = "+44.32.234.66.99";
		testWebsite1 = "http://www.myweb.ch";
		testWebsite2 = "https://www.deiwebsite.ch";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Telecoms#addEMail(java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddEMail() {
		final Telecoms t = new Telecoms();

		t.addEMail("axel.helmer.job@gmail.com", AddressUse.BUSINESS);
		assertTrue(t.getEMails().containsKey("mailto:axel.helmer.job@gmail.com"));
		assertTrue(t.getEMails().containsValue(AddressUse.BUSINESS));

		t.addEMail("test@test.de", AddressUse.PRIVATE);
		assertTrue(t.getEMails().containsKey("mailto:test@test.de"));
		assertTrue(t.getEMails().containsValue(AddressUse.PRIVATE));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Telecoms#addFax(java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddFax() {
		final Telecoms t = new Telecoms();

		t.addFax(numS1, AddressUse.BUSINESS);
		t.addFax(numS2, AddressUse.MOBILE);
		assertTrue(t.getFaxes().containsKey("fax:" + numS1));
		assertTrue(t.getFaxes().containsValue(AddressUse.BUSINESS));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Telecoms#addPhone(java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddPhone() {
		final Telecoms t = new Telecoms();

		t.addPhone(telS1, AddressUse.BUSINESS);
		t.addPhone(telS2, AddressUse.MOBILE);
		assertTrue(t.getPhones().containsKey("tel:" + telS1));
		assertTrue(t.getPhones().containsValue(AddressUse.MOBILE));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Telecoms#addWebsite(java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddWebsite() {
		final Telecoms t = new Telecoms();

		t.addWebsite(testWebsite1, AddressUse.BUSINESS);
		t.addWebsite(testWebsite2, AddressUse.PRIVATE);
		assertTrue(t.getWebsites().containsKey(testWebsite1));
		assertTrue(t.getWebsites().containsValue(AddressUse.PRIVATE));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Telecoms#Telecoms(org.eclipse.emf.common.util.EList)}
	 * .
	 */
	@Test
	@Ignore
	public void testTelecomsEListOfTEL() {
		fail("Not yet implemented");
	}

}
