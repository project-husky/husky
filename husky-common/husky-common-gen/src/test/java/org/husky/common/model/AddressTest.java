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

import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.enums.CountryCode;
import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.PostalAddressUse;
import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test class for Address.
 */
class AddressTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

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

		assertEquals(address1, address2);

		addressBt.setStreetAddressLine1(streetAddressLine1);
		addressBt.setStreetAddressLine2(streetAddressLine2);

		Address address3 = new Address(addressBt);
		hl7CdaR2Type = address3.getHl7CdaR2Ad();
		Address address4 = new Address(hl7CdaR2Type);

		assertEquals(address3, address4);

		// Null Flavor Tests
		AD nullHl7CdaR2Value = null;
		Address nullObj = new Address(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE_L2, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createAD();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Address(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN_L1, nullObj.getNullFlavor());

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
