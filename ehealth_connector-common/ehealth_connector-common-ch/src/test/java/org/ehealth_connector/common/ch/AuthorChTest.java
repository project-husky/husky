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
package org.ehealth_connector.common.ch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.ch.enums.AuthorRole;
import org.ehealth_connector.common.ch.enums.AuthorSpeciality;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.testhelpers.AbstractTestHelper;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Before;
import org.junit.Test;

public class AuthorChTest {

	private Identificator testIdentificator1;

	private CodeSystems testCodeSystem1;

	private String testId1;

	private String testGivenName;
	private String testFamilyName;
	private Name testName1;

	private String testGln1;

	private Address testAddress;

	private Identificator testIdentificator2;

	private CodeSystems testCodeSystem2;

	private String testId2;

	private String testGivenName2;
	private String testFamilyName2;
	private Name testName2;

	private String testGln2;

	private Date testDate1;

	private String testStreet_1;

	private String testHouseNumber_1;

	private String testAddressline1_1;

	private String testZip_1;

	private String testCity_1;

	private AddressUse testUsage_1;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testCodeSystem1 = CodeSystems.GLN;
		testId1 = "1.2.3.4.5.6.7.8.9.0";
		testIdentificator1 = new Identificator(testCodeSystem1, testId1);

		testGivenName = "GivenAuthor";
		testFamilyName = "FamilyAuthor";
		testName1 = new Name(testGivenName, testFamilyName);

		testStreet_1 = "Musterstrasse";
		testHouseNumber_1 = "2";
		testAddressline1_1 = testStreet_1 + " " + testHouseNumber_1;
		testZip_1 = "9999";
		testCity_1 = "Musterhausen";
		testUsage_1 = AddressUse.BUSINESS;
		testAddress = new Address(testAddressline1_1, testZip_1, testCity_1, testUsage_1);

		testGln1 = "7601001401563";

		testCodeSystem2 = CodeSystems.GTIN;
		testId2 = "100.99.88.77.66";
		testIdentificator2 = new Identificator(testCodeSystem2, testId2);

		testGivenName2 = "Given My Author";
		testFamilyName2 = "Family My Author";
		testName2 = new Name(testGivenName2, testFamilyName2);

		testGln2 = "7601001401564";

		testDate1 = DateUtil.date("28.02.2018");
	}

	@Test
	public void testAuthorCh() {
		final AuthorCh b1 = new AuthorCh();

		b1.addId(testIdentificator2);
		b1.setRoleFunction(AuthorRole.ANDERE);
		b1.setSpeciality(AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG);

		assertTrue(AbstractTestHelper.isEqual(testIdentificator2, b1.getIds().get(0)));
		assertEquals(AuthorRole.ANDERE.getCode().getCode(), b1.getRoleFunction().getCode());
		assertEquals(AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG,
				b1.getSpecialityEnum());

		final AuthorCh b2 = new AuthorCh();
		b2.addId(testIdentificator1);
		b2.setRoleFunction(AuthorRole.APOTHEKER);
		b2.setSpeciality(AuthorSpeciality.FACHARZTINFACHARZT_FUR_CHIRURGIE);

		assertTrue(AbstractTestHelper.isEqual(testIdentificator1, b2.getIds().get(0)));
		assertEquals(AuthorRole.APOTHEKER.getCode().getCode(), b2.getRoleFunction().getCode());
		assertEquals(AuthorSpeciality.FACHARZTINFACHARZT_FUR_CHIRURGIE, b2.getSpecialityEnum());

	}

	@Test
	public void testAuthorChAuthor() {
		final Author a = new Author();
		a.addAddress(testAddress);
		a.addId(testIdentificator1);
		a.addName(testName1);
		a.setGln(testGln1);
		a.setTime(testDate1);

		final AuthorCh autCh = new AuthorCh(a);

		assertEquals(testDate1, autCh.getTimeAsDate());

		assertEquals(testAddress.getCity(), autCh.getAddress().getCity());
		assertNotNull(autCh.getIds());
		assertFalse(autCh.getIds().isEmpty());
		assertEquals(testIdentificator1, autCh.getIds().get(0));
		assertEquals(testName1.getFamilyName(), autCh.getName().getFamilyName());
	}

	@Test
	public void testAuthorCd() {
		final org.ehealth_connector.common.ch.AuthorCh b = new org.ehealth_connector.common.ch.AuthorCh();

		b.addId(testIdentificator1);
		assertTrue(isEqual(testIdentificator1, b.getIds().get(0)));

		b.setRoleFunction(AuthorRole.ANDERE);
		assertEquals(AuthorRole.ANDERE.getCode().getCode(), b.getRoleFunction().getCode());

		b.setSpeciality(AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG);
		assertEquals(AuthorSpeciality.ANDERE_GESUNDHEITSBEZOGENE_FACHRICHTUNG,
				b.getSpecialityEnum());
	}

	private boolean isEqual(Identificator i1, Identificator i2) {
		if (!i1.getRoot().equals(i2.getRoot()))
			return false;
		if (!i1.getExtension().equals(i2.getExtension()))
			return false;
		return true;
	}
}
