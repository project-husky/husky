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
package org.husky.common.basetypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.enums.CountryCode;
import org.husky.common.enums.PostalAddressUse;
import org.junit.jupiter.api.Test;

/**
 * The test class for AddressBaseType.
 */
public class AddressBaseTypeTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		String streetName = "Leidensgasse";
		String buildingNumber = "1";
		String postalCode = "8888";
		String city = "Musterhausen";
		String country = CountryCode.SWITZERLAND.getCodeAlpha3();
		PostalAddressUse usage = PostalAddressUse.CONFIDENTIAL;

		String additionalLocator = "additionalLocator";
		String postBox = "postBox";
		String state = "state";

		String streetAddressLine1 = "Teststrasse 99";
		String streetAddressLine2 = "Postfach 999";

		AddressBaseType address1 = AddressBaseType.builder().withStreetName(streetName)
				.withBuildingNumber(buildingNumber).withPostalCode(postalCode).withCity(city)
				.withCountry(country).withAdditionalLocator(additionalLocator).withPostBox(postBox)
				.withState(state).withUsage(usage).build();

		AddressBaseType address2 = AddressBaseType.builder().withStreetName(streetName)
				.withBuildingNumber(buildingNumber).withPostalCode(postalCode).withCity(city)
				.withCountry(country).withAdditionalLocator(additionalLocator).withPostBox(postBox)
				.withState(state).withUsage(usage).build();

		assertEquals(address1.hashCode(), address2.hashCode());
		assertTrue(address1.equals(address2));

		assertEquals(streetName, address1.getStreetName());
		assertEquals(buildingNumber, address1.getBuildingNumber());
		assertEquals(postalCode, address1.getPostalCode());
		assertEquals(city, address1.getCity());
		assertEquals(country, address1.getCountry());
		assertEquals(usage, address1.getUsage());
		assertEquals(additionalLocator, address1.getAdditionalLocator());
		assertEquals(postBox, address1.getPostBox());
		assertEquals(state, address1.getState());
		assertEquals(null, address1.getStreetAddressLine1());
		assertEquals(null, address1.getStreetAddressLine2());

		address1.setStreetAddressLine1(streetAddressLine1);
		assertEquals(streetAddressLine1, address1.getStreetAddressLine1());

		address1.setStreetAddressLine2(streetAddressLine2);
		assertEquals(streetAddressLine2, address1.getStreetAddressLine2());

	}

}
