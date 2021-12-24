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
package org.husky.common.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.basetypes.NameBaseType;
import org.husky.common.basetypes.OrganizationBaseType;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.PostalAddressUse;
import org.husky.common.enums.TelecomAddressUse;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.testhelpers.AbstractTestHelper;
import org.husky.common.utils.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test of class Author
 */

public class AuthorTest {

	public static final int NUMBER_OF_RANDOM_STRING_LETTERS = 129;

	private POCDMT000040Author testAuthorMdht;

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

	private org.husky.common.enums.PostalAddressUse testUsage_1;

	private String testStreet_2;

	private String testHouseNumber_2;

	private String testAddressline1_2;

	private String testZip_2;

	private String testCity_2;

	private org.husky.common.enums.PostalAddressUse testUsage_2;

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

	private Telecom testTelecoms;

	private String testOrgPhone1;

	private TelecomAddressUse testOrgPhoneUsage1;

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
	@BeforeEach
	public void setUp() throws Exception {

		testAuthorMdht = new POCDMT000040Author();

		testTs1 = new TS();
		testTs1.setValue("10:00:12");
		testAuthorMdht.setTime(testTs1);

		testGivenName = "GivenAuthor";
		testFamilyName = "FamilyAuthor";
		testName1 = new Name();
		testName1.setGiven(testGivenName);
		testName1.setFamily(testFamilyName);

		testGivenName2 = "Given My Author";
		testFamilyName2 = "Family My Author";
		testName2 = new Name();
		testName2.setGiven(testGivenName2);
		testName2.setFamily(testFamilyName2);

		testGln1 = "7601001401563";
		testGln2 = "7601001401564";

		testStreet_1 = "Musterstrasse";
		testHouseNumber_1 = "2";
		testAddressline1_1 = testStreet_1 + " " + testHouseNumber_1;
		testZip_1 = "9999";
		testCity_1 = "Musterhausen";
		testUsage_1 = PostalAddressUse.WORK_PLACE;
		testAddress = new Address(new AddressBaseType());
		testAddress.setStreetAddressLine1(testAddressline1_1);
		testAddress.setPostalCode(testZip_1);
		testAddress.setCity(testCity_1);
		testAddress.setUsage(testUsage_1);

		testStreet_2 = "Meistergasse";
		testHouseNumber_2 = "11";
		testAddressline1_2 = testStreet_2 + " " + testHouseNumber_2;
		testZip_2 = "1234";
		testCity_2 = "Meisterdorf";
		testUsage_2 = PostalAddressUse.PRIMARY_HOME;
		testAddress2 = new Address(new AddressBaseType());
		testAddress2.setStreetAddressLine1(testAddressline1_2);
		testAddress2.setPostalCode(testZip_2);
		testAddress2.setCity(testCity_2);
		testAddress2.setUsage(testUsage_2);

		testCodeSystem1 = CodeSystems.GLN;
		testId1 = "1.2.3.4.5.6.7.8.9.0";
		testIdentificator1 = new Identificator(testCodeSystem1.getCodeSystemId(), testId1);

		testCodeSystem2 = CodeSystems.GTIN;
		testId2 = "100.99.88.77.66";
		testIdentificator2 = new Identificator(testCodeSystem2.getCodeSystemId(), testId2);

		testOrgName1 = "Arpage AG";
		testOrgcanization1 = new Organization(new OrganizationBaseType());
		NameBaseType orgName = new NameBaseType();
		orgName.setName(testOrgName1);
		testOrgcanization1.setPrimaryName(orgName);

		testTelecoms = new Telecom();
		testOrgPhone1 = "+41 44 500 55 20";
		testOrgPhoneUsage1 = TelecomAddressUse.BUSINESS;
		testTelecoms.setPhone(testOrgPhone1);
		testTelecoms.setUsage(testOrgPhoneUsage1);
		testOrgcanization1.setPrimaryTelecom(testTelecoms);

		ts1 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = AbstractTestHelper.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);

		// Convenience API Types
		code1 = new Code(ts1, ts2, ts3);
		code2 = new Code(ts5, ts4, ts3);

		testDate1 = DateUtil.parseDateyyyyMMdd("20180228");
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#addAddress(org.husky.common.model.Address)}
	 * .
	 */
	@Test
	public void testAddGetAddress() {
		final Author auth = new Author(testName1);
		auth.addAddress(testAddress);
		final Address ref = auth.getAddress();
		assertEquals(testAddress.getStreetAddressLine1(), ref.getStreetAddressLine1());

		final List<Address> addrs1 = auth.getAddresses();
		assertNotNull(addrs1);
		assertEquals(1, addrs1.size());
		assertEquals(testAddress.getStreetAddressLine1(), addrs1.get(0).getStreetAddressLine1());

		auth.addAddress(testAddress2);
		final List<Address> addrs2 = auth.getAddresses();
		assertNotNull(addrs2);
		assertEquals(2, addrs2.size());
		assertEquals(testAddress.getStreetAddressLine1(), addrs2.get(0).getStreetAddressLine1());
		assertEquals(testAddress2.getStreetAddressLine1(), addrs2.get(1).getStreetAddressLine1());

	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#addId(org.husky.common.model.Identificator)}
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
	 * {@link org.husky.common.model.Author#addName(org.husky.common.model.Name)}
	 * .
	 */
	@Test
	public void testAddName() {
		final Author auth = new Author(testName1);
		final Name ref = auth.getName();
		assertEquals(testName1.getFamily(), ref.getFamily());
		final List<Name> names1 = auth.getNames();
		assertNotNull(names1);
		assertEquals(1, names1.size());
		assertEquals(testName1.getFamily(), names1.get(0).getFamily());

		auth.addName(testName2);
		final List<Name> names2 = auth.getNames();
		assertNotNull(names2);
		assertEquals(2, names2.size());
		assertEquals(testName1.getFamily(), names2.get(0).getFamily());
		assertEquals(testName2.getFamily(), names2.get(1).getFamily());
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

		Calendar cal = new GregorianCalendar();
		cal.setTime(testDate1);
		a.setTime(cal);

		a.setRoleFunction(code1);
		assertTrue(AbstractTestHelper.isEqual(code1, a.getRoleFunction()));

		a.setSpeciality(code2);
		assertTrue(AbstractTestHelper.isEqual(code2, a.getSpeciality()));
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#Author(org.husky.common.model.openhealthtools.mdht.uml.cda.Author)}
	 * .
	 */
	@Test
	@Disabled
	public void testAuthorAuthor() {
		final Author auth = new Author(testAuthorMdht);
		final POCDMT000040Author ref = auth.getAuthorMdht();
		assertNotNull(testAuthorMdht);
		assertEquals(testTs1, ref.getTime());
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#Author(org.husky.common.model.Name)}
	 * .
	 */
	@Test
	public void testAuthorName() {
		final Author auth = new Author(testName1);
		final Name ref = auth.getName();
		assertEquals(testFamilyName, ref.getFamily());
		assertEquals(testGivenName, ref.getGiven());
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#Author(org.husky.common.model.Name, java.lang.String)}
	 * .
	 */
	@Test
	public void testAuthorNameString() {
		final Author auth = new Author(testName1, testGln1);

		final Name ref = auth.getName();
		assertEquals(testFamilyName, ref.getFamily());
		assertEquals(testGivenName, ref.getGiven());

		assertEquals(testGln1, auth.getGln());
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#getCompleteName()}.
	 */
	@Test
	public void testGetCompleteName() {
		final Author auth = new Author(testName1);
		final String ref = auth.getCompleteName();
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#getGlnAsIdentificator()}.
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
	 * {@link org.husky.common.model.Author#getGln()}.
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
	 * {@link org.husky.common.model.Author#getOrganization()}.
	 */
	@Test
	public void testSetGetOrganization() {
		final Author auth = new Author(testName1, testGln1);
		auth.setOrganization(testOrgcanization1);

		final Organization ref = auth.getOrganization();
		assertNotNull(ref);
		assertEquals(testOrgcanization1.getPrimaryName().getName(), ref.getPrimaryName().getName());
		assertEquals(testOrgcanization1.getPrimaryTelecom().getValue(), ref.getPrimaryTelecom().getValue());
	}

	/**
	 * Test method for
	 * {@link org.husky.common.model.Author#getTelecoms()} .
	 */
	@Test
	public void testSetGetTelecoms() {
		final Author auth = new Author(testName1, testGln1);
		auth.setTelecoms(List.of(testTelecoms));

		final Telecom ref = auth.getTelecoms().get(0);
		assertNotNull(ref);
		assertEquals(testTelecoms.getValue(), ref.getValue());
	}
}
