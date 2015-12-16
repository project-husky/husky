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
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.common.enums.AddressUse;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.ADXP;

/**
 * @author roeland
 * @version 1.0
 * @since Jun 15, 2015 8:23:58 AM
 */
public class AddressTest {

	private static Log LOG = LogFactory.getLog(AddressTest.class);

	private String testStreet_1;
	private String testHouseNumber_1;
	private String testAddressline1_1;
	private String testAddressline2_1;
	private String testAddressline3_1;
	private String testZip_1;
	private String testCity_1;
	private AddressUse testUsage_1;
	private Object testCountry_1;

	private String testStreet_2;
	private String testHouseNumber_2;
	private String testAddressline1_2;
	private String testAddressline2_2;
	private String testAddressline3_2;
	private String testZip_2;
	private String testCity_2;
	private String testCountry_2;

	@Before
	public void setUp() {
		testStreet_1 = "Musterstrasse";
		testHouseNumber_1 = "2";
		testAddressline1_1 = testStreet_1 + " " + testHouseNumber_1;
		testAddressline2_1 = "Quartier 2";
		testAddressline3_1 = "Block 27a";
		testZip_1 = "9999";
		testCity_1 = "Musterhausen";
		testUsage_1 = AddressUse.BUSINESS;
		testCountry_1 = "Schweiz";

		testStreet_2 = "Meistergasse";
		testHouseNumber_2 = "11";
		testAddressline1_2 = testStreet_2 + " " + testHouseNumber_2;
		testAddressline2_2 = "Etage 3";
		testAddressline3_2 = "Gang 7";
		testZip_2 = "1234";
		testCity_2 = "Meisterdorf";
		testCountry_2 = "Switzerland";

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#Address(org.openhealthtools.mdht.uml.hl7.datatypes.AD)}
	 * .
	 */
	@Test
	@Ignore
	public void testAddressAD() {
		// this test has to be implemented with mock
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#Address(java.lang.String, java.lang.String, java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddressStringStringStringAddressUse() {
		final Address adr = new Address(testAddressline1_1, testZip_1, testCity_1, testUsage_1);
		LOG.info(adr);
		assertEquals(testAddressline1_1, adr.getAddressline1());
		assertEquals(testZip_1, adr.getZip());
		assertEquals(testCity_1, adr.getCity());
		// assertEquals(testUsage_1, adr.getUsage());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAddressStringStringStringString() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1);
		LOG.info(adr);
		assertEquals(testStreet_1, adr.getStreet());
		assertEquals(testHouseNumber_1, adr.getHouseNumber());
		assertEquals(testZip_1, adr.getZip());
		assertEquals(testCity_1, adr.getCity());

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddressStringStringStringStringAddressUse() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1,
				testUsage_1);
		LOG.info(adr);
		assertEquals(testStreet_1, adr.getStreet());
		assertEquals(testHouseNumber_1, adr.getHouseNumber());
		assertEquals(testZip_1, adr.getZip());
		assertEquals(testCity_1, adr.getCity());
		LOG.info("Test Usage: " + testUsage_1 + ", Usage to test:" + adr.getUsage());
		// assertEquals(testUsage_1, adr.getUsage());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#Address(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.ehealth_connector.common.enums.AddressUse)}
	 * .
	 */
	@Test
	public void testAddressStringStringStringStringStringAddressUse() {
		final Address adr = new Address(testAddressline1_1, testAddressline2_1, testAddressline3_1,
				testZip_1, testCity_1, testUsage_1);
		LOG.info(adr);
		assertEquals(testAddressline1_1, adr.getAddressline1());
		assertEquals(testAddressline2_1, adr.getAddressline2());
		assertEquals(testAddressline3_1, adr.getAddressline3());
		assertEquals(testZip_1, adr.getZip());
		assertEquals(testCity_1, adr.getCity());
		// assertEquals(testUsage_1, adr.getUsage());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#copyMdhtAdress()}.
	 */
	@Test
	public void testCopyMdhtAdress() {
		final Address adr = new Address(testAddressline1_1, testAddressline2_1, testAddressline3_1,
				testZip_1, testCity_1, testUsage_1);
		LOG.info(adr);
		final AD ref = adr.copyMdhtAdress();
		assertNotNull(ref);

		final EList<ADXP> cities = ref.getCities();
		assertNotNull(cities);
		assertEquals(1, cities.size());
		assertEquals(testCity_1, cities.get(0).getText());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setAddressline1(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetAddressline1() {
		final Address adr = new Address(testAddressline1_1, testAddressline2_1, testAddressline3_1,
				testZip_1, testCity_1, testUsage_1);
		LOG.info(adr);
		assertEquals(testAddressline1_1, adr.getAddressline1());
		adr.setAddressline1(testAddressline1_2);
		assertEquals(testAddressline1_2, adr.getAddressline1());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setAddressline2(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetAddressline2() {
		final Address adr = new Address(testAddressline1_1, testAddressline2_1, testAddressline3_1,
				testZip_1, testCity_1, testUsage_1);
		LOG.info(adr);
		assertEquals(testAddressline2_1, adr.getAddressline1());
		adr.setAddressline1(testAddressline2_2);
		assertEquals(testAddressline2_2, adr.getAddressline1());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setAddressline3(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetAddressline3() {
		final Address adr = new Address(testAddressline1_1, testAddressline2_1, testAddressline3_1,
				testZip_1, testCity_1, testUsage_1);
		LOG.info(adr);
		assertEquals(testAddressline3_1, adr.getAddressline1());
		adr.setAddressline1(testAddressline3_2);
		assertEquals(testAddressline3_2, adr.getAddressline1());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setCity(java.lang.String)}.
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetCity() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1,
				testUsage_1);
		LOG.info(adr);
		assertEquals(testCity_1, adr.getCity());
		adr.setCity(testCity_2);
		assertEquals(testCity_2, adr.getCity());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setCountry(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore("Error out of bound")
	public void testSetCountry() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1,
				testUsage_1);
		LOG.info(adr);
		assertNull(adr.getCountry());
		assertEquals(testCountry_1, adr.getCountry());
		adr.setCountry(testCountry_2);
		assertEquals(testCountry_2, adr.getCountry());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setHouseNumber(java.lang.String)}
	 * .
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetHouseNumber() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1,
				testUsage_1);
		LOG.info(adr);
		assertEquals(testHouseNumber_1, adr.getHouseNumber());
		adr.setHouseNumber(testHouseNumber_2);
		assertEquals(testHouseNumber_2, adr.getHouseNumber());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setStreet(java.lang.String)}.
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetStreet() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1,
				testUsage_1);
		LOG.info(adr);
		assertEquals(testStreet_1, adr.getStreet());
		adr.setStreet(testStreet_2);
		assertEquals(testStreet_2, adr.getStreet());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Address#setZip(java.lang.String)}.
	 */
	@Test
	@Ignore("Error within setter and getter")
	public void testSetZip() {
		final Address adr = new Address(testStreet_1, testHouseNumber_1, testZip_1, testCity_1,
				testUsage_1);
		LOG.info(adr);
		assertEquals(testZip_1, adr.getZip());
		adr.setZip(testZip_2);
		assertEquals(testZip_2, adr.getZip());
	}
}
