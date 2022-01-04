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
package org.husky.common.basetypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.husky.common.enums.CountryCode;
import org.husky.common.enums.PostalAddressUse;
import org.husky.common.enums.TelecomAddressUse;
import org.junit.jupiter.api.Test;

/**
 * The test class for OrganizationBaseType.
 */
class OrganizationBaseTypeTest {
	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		NameBaseType name1;
		NameBaseType name2;

		String streetName = "Leidensgasse";
		String buildingNumber = "1";
		String postalCode = "8888";
		String city = "Musterhausen";
		String country = CountryCode.SWITZERLAND.getCodeAlpha3();
		PostalAddressUse postalUsage = PostalAddressUse.CONFIDENTIAL;

		AddressBaseType address1 = AddressBaseType.builder().withStreetName(streetName)
				.withBuildingNumber(buildingNumber).withPostalCode(postalCode).withCity(city)
				.withCountry(country).withUsage(postalUsage).build();

		streetName = "Zweitstrasse";
		buildingNumber = "2";
		postalCode = "9999";
		city = "Zweitort";
		country = CountryCode.SWITZERLAND.getCodeAlpha3();
		postalUsage = PostalAddressUse.VACATION_HOME;

		AddressBaseType address2 = AddressBaseType.builder().withStreetName(streetName)
				.withBuildingNumber(buildingNumber).withPostalCode(postalCode).withCity(city)
				.withCountry(country).withUsage(postalUsage).build();

		String extension = "myextension1";
		String root = "2.999.1";

		IdentificatorBaseType id1 = IdentificatorBaseType.builder().withExtension(extension)
				.withRoot(root).build();

		extension = "myextension2";
		root = "2.999.2";

		IdentificatorBaseType id2 = IdentificatorBaseType.builder().withExtension(extension)
				.withRoot(root).build();

		name1 = NameBaseType.builder().withName("OrgName1").build();
		name2 = NameBaseType.builder().withName("OrgName2").build();

		TelecomAddressUse telecomUsage = TelecomAddressUse.ANSWERING_SERVICE;
		String value = "033 888 77 66";

		TelecomBaseType telecom1 = TelecomBaseType.builder().withUsage(telecomUsage)
				.withValue(value).build();

		telecomUsage = TelecomAddressUse.MOBILE;
		value = "079 222 33 44";

		TelecomBaseType telecom2 = TelecomBaseType.builder().withUsage(telecomUsage)
				.withValue(value).build();

		OrganizationBaseType org1 = OrganizationBaseType.builder().withPrimaryAddress(address2)
				.withPrimaryIdentificator(id2).withPrimaryName(name2).withPrimaryTelecom(telecom2)
				.build();

		OrganizationBaseType org2 = OrganizationBaseType.builder().withPrimaryAddress(address2)
				.withPrimaryIdentificator(id2).withPrimaryName(name2).withPrimaryTelecom(telecom2)
				.build();

		assertEquals(org1.hashCode(), org2.hashCode());
		assertEquals(org1, org2);

		// Check setting primary elements
		assertEquals(address2, org1.getPrimaryAddress());
		assertEquals(id2, org1.getPrimaryIdentificator());
		assertEquals(name2, org1.getPrimaryName());
		assertEquals(telecom2, org1.getPrimaryTelecom());

		// add elements
		org1.addAddress(address1);
		org1.addIdentificator(id1);
		org1.addName(name1);
		org1.addTelecom(telecom1);

		org1.addAddress(address2);
		org1.addIdentificator(id2);
		org1.addName(name2);
		org1.addTelecom(telecom2);

		// check added elements
		assertEquals(address1, org1.getAddressList().get(0));
		assertEquals(id2, org1.getIdentificatorList().get(1));
		assertEquals(name1, org1.getNameList().get(0));
		assertEquals(telecom2, org1.getTelecomList().get(1));

		// Check primary elements still remain the ones, initially set
		assertEquals(address2, org1.getPrimaryAddress());
		assertEquals(id2, org1.getPrimaryIdentificator());
		assertEquals(name2, org1.getPrimaryName());
		assertEquals(telecom2, org1.getPrimaryTelecom());

		// Set new primary elements
		org1.setPrimaryAddress(address1);
		org1.setPrimaryIdentificator(id1);
		org1.setPrimaryName(name1);
		org1.setPrimaryTelecom(telecom1);

		// Check newly set primary elements
		assertEquals(address1, org1.getPrimaryAddress());
		assertEquals(id1, org1.getPrimaryIdentificator());
		assertEquals(name1, org1.getPrimaryName());
		assertEquals(telecom1, org1.getPrimaryTelecom());

		// Create a new list by only adding elements
		org1 = new OrganizationBaseType();
		org1.addAddress(address1);
		org1.addIdentificator(id2);
		org1.addName(name1);
		org1.addTelecom(telecom2);

		// Check primary elements are automatically set
		assertEquals(address1, org1.getPrimaryAddress());
		assertEquals(id2, org1.getPrimaryIdentificator());
		assertEquals(name1, org1.getPrimaryName());
		assertEquals(telecom2, org1.getPrimaryTelecom());

	}
}
