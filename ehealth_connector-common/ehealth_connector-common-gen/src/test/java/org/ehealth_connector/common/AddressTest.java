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
package org.ehealth_connector.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.enums.PostalAddressUse;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.model.Address;
import org.junit.jupiter.api.Test;

/**
 * The test class for Address.
 */
public class AddressTest {

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

		AddressBaseType addressBt = AddressBaseType.builder().withStreetName(streetName)
				.withBuildingNumber(buildingNumber).withPostalCode(postalCode).withCity(city)
				.withCountry(country).withAdditionalLocator(additionalLocator).withPostBox(postBox)
				.withState(state).withUsage(usage).build();

		Address address1 = new Address(addressBt);
		AD hl7CdaR2Type = address1.getHl7CdaR2Ad();
		Address address2 = new Address(hl7CdaR2Type);

		assertTrue(address1.equals(address2));

		addressBt.setStreetAddressLine1(streetAddressLine1);
		addressBt.setStreetAddressLine2(streetAddressLine2);

		Address address3 = new Address(addressBt);
		hl7CdaR2Type = address3.getHl7CdaR2Ad();
		Address address4 = new Address(hl7CdaR2Type);

		assertTrue(address3.equals(address4));

		// Null Flavor Tests
		AD nullHl7CdaR2Value = null;
		Address nullObj = new Address(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createAD();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Address(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN, nullObj.getNullFlavor());

		// This is for debugging purposes, only. When enabled, you need to add
		// @XmlRootElement(name = "debug") to class AD
		// JAXBContext context;
		// try {
		// context = JAXBContext.newInstance(AD.class);
		// Marshaller mar = context.createMarshaller();
		// mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// mar.marshal(hl7CdaR2Type,
		// new File(Util.getTempDirectory() +
		// FileUtil.getPlatformSpecificPathSeparator()
		// + hl7CdaR2Type.getClass().getName() + ".xml"));
		// } catch (JAXBException e) {
		// e.printStackTrace();
		// }

	}
}
