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
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.testhelpers.AbstractTestHelper;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.impl.DatatypesFactoryImpl;

/**
 * @author roeland
 * @version 1.0
 * @since Jun 18, 2015 8:42:51 PM
 */

public class AuthorTest {

	public static final int NUMBER_OF_RANDOM_STRING_LETTERS = 129;

	private org.openhealthtools.mdht.uml.cda.Author testAuthorMdht;

	private String testGivenName;
	private String testFamilyName;

	private Name testName1;

	private String testGln1;

	private Address testAddress;

	private String testStreet_1;

	private String testHouseNumber_1;

	private String testAddressline1_1;

	private String testZip_1;

	private String testCity_1;

	private AddressUse testUsage_1;

	private String testStreet_2;

	private String testHouseNumber_2;

	private String testAddressline1_2;

	private String testZip_2;

	private String testCity_2;

	private AddressUse testUsage_2;

	private Address testAddress2;

	private Identificator testIdentificator1;

	private CodeSystems testCodeSystem1;

	private String testId1;

	private Identificator testIdentificator2;

	private CodeSystems testCodeSystem2;

	private String testId2;

	private TS testTs1;

	private Name testName2;

	private String testGivenName2;

	private String testFamilyName2;

	private String testGln2;

	private Organization testOrgcanization1;

	private String testOrgName1;

	private Telecoms testTelecoms;

	private String testOrgPhone1;

	private AddressUse testOrgPhoneUsage1;

	private Date testDate1;

	private Code code1;

	private Code code2;

	public String ts1;

	public String ts2;

	public String ts3;

	public String ts4;

	public String ts5;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		testAuthorMdht = CDAFactory.eINSTANCE.createAuthor();

		final DatatypesFactory dttF = new DatatypesFactoryImpl();
		testTs1 = dttF.createTS();
		testTs1.setValue("10:00:12");
		testAuthorMdht.setTime(testTs1);

		testGivenName = "GivenAuthor";
		testFamilyName = "FamilyAuthor";
		testName1 = new Name(testGivenName, testFamilyName);

		testGivenName2 = "Given My Author";
		testFamilyName2 = "Family My Author";
		testName2 = new Name(testGivenName2, testFamilyName2);

		testGln1 = "7601001401563";
		testGln2 = "7601001401564";

		testStreet_1 = "Musterstrasse";
		testHouseNumber_1 = "2";
		testAddressline1_1 = testStreet_1 + " " + testHouseNumber_1;
		testZip_1 = "9999";
		testCity_1 = "Musterhausen";
		testUsage_1 = AddressUse.BUSINESS;
		testAddress = new Address(testAddressline1_1, testZip_1, testCity_1, testUsage_1);

		testStreet_2 = "Meistergasse";
		testHouseNumber_2 = "11";
		testAddressline1_2 = testStreet_2 + " " + testHouseNumber_2;
		testZip_2 = "1234";
		testCity_2 = "Meisterdorf";
		testUsage_2 = AddressUse.PRIVATE;
		testAddress2 = new Address(testAddressline1_2, testZip_2, testCity_2, testUsage_2);

		testCodeSystem1 = CodeSystems.GLN;
		testId1 = "1.2.3.4.5.6.7.8.9.0";
		testIdentificator1 = new Identificator(testCodeSystem1, testId1);

		testCodeSystem2 = CodeSystems.GTIN;
		testId2 = "100.99.88.77.66";
		testIdentificator2 = new Identificator(testCodeSystem2, testId2);

		testOrgName1 = "Arpage AG";
		testOrgcanization1 = new Organization(testOrgName1);

		testTelecoms = new Telecoms();
		testOrgPhone1 = "+41 44 500 55 20";
		testOrgPhoneUsage1 = AddressUse.BUSINESS;
		testTelecoms.addPhone(testOrgPhone1, testOrgPhoneUsage1);
		testOrgcanization1.setTelecoms(testTelecoms);

		ts1 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);

		// Convenience API Types
		code1 = new Code(ts1, ts2, ts3, ts4);
		code2 = new Code(ts5, ts4, ts3, ts2);

		testDate1 = DateUtil.date("28.02.2018");
	}

	@Test
	public void testAuthor() {
		final Author a = new Author();
		a.addAddress(testAddress);
		a.addAddress(testAddress);
		a.addId(testIdentificator1);
		a.addId(testIdentificator2);
		a.addName(testName1);
		a.addName(testName2);
		a.setGln(testGln1);
		a.setGln(testGln2);
		a.setTime(testDate1);

		a.setRoleFunction(code1);
		assertTrue(AbstractTestHelper.isEqual(code1, a.getRoleFunction()));

		a.setSpeciality(code2);
		assertTrue(AbstractTestHelper.isEqual(code2, a.getSpeciality()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#Author(org.ehealth_connector.common.Name)}
	 * .
	 */
	@Test
	public void testAuthorName() {
		final Author auth = new Author(testName1);
		final Name ref = auth.getName();
		assertEquals(testFamilyName, ref.getFamilyName());
		assertEquals(testGivenName, ref.getGivenNames());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#Author(org.ehealth_connector.common.Name, java.lang.String)}
	 * .
	 */
	@Test
	public void testAuthorNameString() {
		final Author auth = new Author(testName1, testGln1);

		final Name ref = auth.getName();
		assertEquals(testFamilyName, ref.getFamilyName());
		assertEquals(testGivenName, ref.getGivenNames());

		assertEquals(testGln1, auth.getGln());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#Author(org.openhealthtools.mdht.uml.cda.Author)}
	 * .
	 */
	@Test
	@Ignore
	public void testAuthorAuthor() {
		final Author auth = new Author(testAuthorMdht);
		final org.openhealthtools.mdht.uml.cda.Author ref = auth.getAuthorMdht();
		assertNotNull(testAuthorMdht);
		assertEquals(testTs1, ref.getTime());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#copyMdhtAuthor()}.
	 */
	@Test
	public void testCopyMdhtAuthor() {
		final Author auth = new Author(testAuthorMdht);
		final org.openhealthtools.mdht.uml.cda.Author ref = auth.copyMdhtAuthor();
		assertEquals(testAuthorMdht.getTime().getValue(), ref.getTime().getValue());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#addAddress(org.ehealth_connector.common.Address)}
	 * .
	 */
	@Test
	public void testAddGetAddress() {
		final Author auth = new Author(testName1);
		auth.addAddress(testAddress);
		final Address ref = auth.getAddress();
		assertEquals(testAddress.getAddressline1(), ref.getAddressline1());

		final List<Address> addrs1 = auth.getAddresses();
		assertNotNull(addrs1);
		assertEquals(1, addrs1.size());
		assertEquals(testAddress.getAddressline1(), addrs1.get(0).getAddressline1());

		auth.addAddress(testAddress2);
		final List<Address> addrs2 = auth.getAddresses();
		assertNotNull(addrs2);
		assertEquals(2, addrs2.size());
		assertEquals(testAddress.getAddressline1(), addrs2.get(0).getAddressline1());
		assertEquals(testAddress2.getAddressline1(), addrs2.get(1).getAddressline1());

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#addId(org.ehealth_connector.common.Identificator)}
	 * .
	 */
	@Test
	public void testAddId() {
		final Author auth = new Author(testName1);
		auth.addId(testIdentificator1);
		final List<Identificator> ids1 = auth.getIds();
		assertNotNull(ids1);
		assertEquals(1, ids1.size());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#addName(org.ehealth_connector.common.Name)}
	 * .
	 */
	@Test
	public void testAddName() {
		final Author auth = new Author(testName1);
		final Name ref = auth.getName();
		assertEquals(testName1.getFamilyName(), ref.getFamilyName());
		final List<Name> names1 = auth.getNames();
		assertNotNull(names1);
		assertEquals(1, names1.size());
		assertEquals(testName1.getFamilyName(), names1.get(0).getFamilyName());

		auth.addName(testName2);
		final List<Name> names2 = auth.getNames();
		assertNotNull(names2);
		assertEquals(2, names2.size());
		assertEquals(testName1.getFamilyName(), names2.get(0).getFamilyName());
		assertEquals(testName2.getFamilyName(), names2.get(1).getFamilyName());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#getCompleteName()}.
	 */
	@Test
	public void testGetCompleteName() {
		final Author auth = new Author(testName1);
		final String ref = auth.getCompleteName();
		assertNotNull(ref);
	}

	/**
	 * Test method for {@link org.ehealth_connector.common.Author#getGln()}.
	 */
	@Test
	// @Ignore("setGln does not replace the gln set by constructor")
	public void testSetGetGln() {
		final Author auth = new Author(testName1, testGln1);
		assertEquals(testGln1, auth.getGln());

		// auth.setGln(testGln2);
		// assertEquals(testGln2, auth.getGln());

		final Author auth2 = new Author(testName1);
		auth2.setGln(testGln2);
		assertEquals(testGln2, auth2.getGln());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#getGlnAsIdentificator()}.
	 */
	@Test
	public void testGetGlnAsIdentificator() {
		final Author auth = new Author(testName1, testGln1);
		assertEquals(testGln1, auth.getGln());

		final Identificator ref = auth.getGlnAsIdentificator();
		assertNotNull(ref);
		assertEquals(testGln1, ref.getExtension());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.common.Author#getOrganization()}.
	 */
	@Test
	public void testSetGetOrganization() {
		final Author auth = new Author(testName1, testGln1);
		auth.setOrganization(testOrgcanization1);

		final Organization ref = auth.getOrganization();
		assertNotNull(ref);
		assertEquals(testOrgcanization1.getName(), ref.getName());
		assertEquals(testOrgcanization1.getTelecoms().getPhones().get(testOrgPhone1),
				ref.getTelecoms().getPhones().get(testOrgPhone1));
	}

	/**
	 * Test method for {@link org.ehealth_connector.common.Author#getTelecoms()}
	 * .
	 */
	@Test
	public void testSetGetTelecoms() {
		final Author auth = new Author(testName1, testGln1);
		auth.setTelecoms(testTelecoms);

		final Telecoms ref = auth.getTelecoms();
		assertNotNull(ref);
		assertEquals(testTelecoms.getPhones().get(testOrgPhone1),
				ref.getPhones().get(testOrgPhone1));
	}

	/**
	 * Test method for {@link org.ehealth_connector.common.Author#getTime()}.
	 */
	@Test
	@Ignore
	public void testSetGetTime() {
		final Author auth = new Author(testName1, testGln1);
		auth.setTime(testDate1);

		final String ref = auth.getTimeAsString();
		assertNotNull(ref);
	}
}
