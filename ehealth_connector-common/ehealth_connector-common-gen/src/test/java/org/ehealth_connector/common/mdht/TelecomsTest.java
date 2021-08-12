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
package org.ehealth_connector.common.mdht;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.ehealth_connector.common.enums.TelecomAddressUse;
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
	 * {@link org.ehealth_connector.common.mdht.Telecoms#addEMail(java.lang.String, org.ehealth_connector.common.enums.TelecomAddressUse)}
	 * .
	 */
	@Test
	public void testAddEMail() {
		final Telecoms t = new Telecoms();

		t.addEMail("axel.helmer.job@gmail.com", TelecomAddressUse.BUSINESS);
		assertTrue(t.getEMails().containsKey("mailto:axel.helmer.job@gmail.com"));
		assertTrue(t.getEMails().containsValue(TelecomAddressUse.BUSINESS));

		t.addEMail("test@test.de", TelecomAddressUse.PRIVATE);
		assertTrue(t.getEMails().containsKey("mailto:test@test.de"));
		assertTrue(t.getEMails().containsValue(TelecomAddressUse.PRIVATE));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.mdht.Telecoms#addFax(java.lang.String, org.ehealth_connector.common.enums.TelecomAddressUse)}
	 * .
	 */
	@Test
	public void testAddFax() {
		final Telecoms t = new Telecoms();

		t.addFax(numS1, TelecomAddressUse.BUSINESS);
		t.addFax(numS2, TelecomAddressUse.MOBILE);
		assertTrue(t.getFaxes().containsKey("fax:" + numS1));
		assertTrue(t.getFaxes().containsValue(TelecomAddressUse.BUSINESS));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.mdht.Telecoms#addPhone(java.lang.String, org.ehealth_connector.common.enums.TelecomAddressUse)}
	 * .
	 */
	@Test
	public void testAddPhone() {
		final Telecoms t = new Telecoms();

		t.addPhone(telS1, TelecomAddressUse.BUSINESS);
		t.addPhone(telS2, TelecomAddressUse.MOBILE);
		assertTrue(t.getPhones().containsKey("tel:" + telS1));
		assertTrue(t.getPhones().containsValue(TelecomAddressUse.MOBILE));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.mdht.Telecoms#addWebsite(java.lang.String, org.ehealth_connector.common.enums.TelecomAddressUse)}
	 * .
	 */
	@Test
	public void testAddWebsite() {
		final Telecoms t = new Telecoms();

		t.addWebsite(testWebsite1, TelecomAddressUse.BUSINESS);
		t.addWebsite(testWebsite2, TelecomAddressUse.PRIVATE);
		assertTrue(t.getWebsites().containsKey(testWebsite1));
		assertTrue(t.getWebsites().containsValue(TelecomAddressUse.PRIVATE));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.mdht.Telecoms#Telecoms(org.eclipse.emf.common.util.EList)}
	 * .
	 */
	@Test
	@Ignore
	public void testTelecomsEListOfTEL() {
		fail("Not yet implemented");
	}

}
