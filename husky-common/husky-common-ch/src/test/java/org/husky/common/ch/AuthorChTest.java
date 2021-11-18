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
package org.husky.common.ch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.ch.AuthorCh;
import org.husky.common.ch.enums.AuthorRole;
import org.husky.common.ch.enums.AuthorSpeciality;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.PostalAddressUse;
import org.husky.common.model.Address;
import org.husky.common.model.Author;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.testhelpers.AbstractTestHelper;
import org.husky.common.utils.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorChTest {

	private Address testAddress;

	private String testAddressline1_1;

	private String testCity_1;

	private CodeSystems testCodeSystem1;
	private CodeSystems testCodeSystem2;
	private Date testDate1;

	private String testFamilyName;

	private String testFamilyName2;

	private String testGivenName;

	private String testGivenName2;

	private String testGln1;

	private String testHouseNumber_1;
	private String testId1;
	private String testId2;

	private Identificator testIdentificator1;

	private Identificator testIdentificator2;

	private Name testName1;
	private Name testName2;

	private String testStreet_1;

	private PostalAddressUse testUsage_1;

	private String testZip_1;

	private boolean isEqual(Identificator i1, Identificator i2) {
		if (!i1.getRoot().equals(i2.getRoot()))
			return false;
		if (!i1.getExtension().equals(i2.getExtension()))
			return false;
		return true;
	}

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testCodeSystem1 = CodeSystems.GLN;
		testId1 = "1.2.3.4.5.6.7.8.9.0";
		testIdentificator1 = new Identificator();
		testIdentificator1.setRoot(testCodeSystem1.getCodeSystemId());
		testIdentificator1.setExtension(testId1);

		testGivenName = "GivenAuthor";
		testFamilyName = "FamilyAuthor";
		testName1 = new Name();
		testName1.setGiven(testGivenName);
		testName1.setFamily(testFamilyName);

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

		testGln1 = "7601001401563";

		testCodeSystem2 = CodeSystems.GTIN;
		testId2 = "100.99.88.77.66";
		testIdentificator2 = new Identificator();
		testIdentificator2.setRoot(testCodeSystem2.getCodeSystemId());
		testIdentificator2.setExtension(testId2);

		testGivenName2 = "Given My Author";
		testFamilyName2 = "Family My Author";
		testName2 = new Name();
		testName2.setGiven(testGivenName2);
		testName2.setFamily(testFamilyName2);

		testDate1 = DateUtil.parseDateyyyyMMdd("20180228");
	}

	@Test
	public void testAuthorCd() {
		final org.husky.common.ch.AuthorCh b = new org.husky.common.ch.AuthorCh();

		b.addId(testIdentificator1);
		assertTrue(isEqual(testIdentificator1, b.getIds().get(0)));

		b.setRoleFunction(AuthorRole.HEALTHCARE_PROFESSIONAL);
		assertEquals(AuthorRole.HEALTHCARE_PROFESSIONAL.getCode().getCode(),
				b.getRoleFunction().getCode());

		b.setSpeciality(AuthorSpeciality.ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY);
		assertEquals(AuthorSpeciality.ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY, b.getSpecialityEnum());
	}

	@Test
	public void testAuthorCh() {
		final AuthorCh b1 = new AuthorCh();

		b1.addId(testIdentificator2);
		b1.setRoleFunction(AuthorRole.HEALTHCARE_PROFESSIONAL);
		b1.setSpeciality(AuthorSpeciality.ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY);

		assertTrue(AbstractTestHelper.isEqual(testIdentificator2, b1.getIds().get(0)));
		assertEquals(AuthorRole.HEALTHCARE_PROFESSIONAL.getCode().getCode(),
				b1.getRoleFunction().getCode());
		assertEquals(AuthorSpeciality.ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY, b1.getSpecialityEnum());

		final AuthorCh b2 = new AuthorCh();
		b2.addId(testIdentificator1);
		b2.setRoleFunction(AuthorRole.HEALTHCARE_PROFESSIONAL);
		b2.setSpeciality(AuthorSpeciality.CARDIOLOGY);

		assertTrue(AbstractTestHelper.isEqual(testIdentificator1, b2.getIds().get(0)));
		assertEquals(AuthorRole.HEALTHCARE_PROFESSIONAL.getCode().getCode(),
				b2.getRoleFunction().getCode());
		assertEquals(AuthorSpeciality.CARDIOLOGY, b2.getSpecialityEnum());

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
		assertEquals(testName1.getFamily(), autCh.getName().getFamily());
	}
}
