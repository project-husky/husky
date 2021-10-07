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
package org.ehealth_connector.common.ch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.ch.enums.AuthorRole;
import org.ehealth_connector.common.ch.enums.AuthorSpeciality;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.PostalAddressUse;
import org.ehealth_connector.common.testhelpers.AbstractTestHelper;
import org.ehealth_connector.common.utils.DateUtil;
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
		final org.ehealth_connector.common.ch.AuthorCh b = new org.ehealth_connector.common.ch.AuthorCh();

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
