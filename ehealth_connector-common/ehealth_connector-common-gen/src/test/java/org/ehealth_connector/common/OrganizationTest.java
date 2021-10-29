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

import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.basetypes.TelecomBaseType;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.enums.PostalAddressUse;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization;
import org.ehealth_connector.common.model.Organization;
import org.junit.jupiter.api.Test;

/**
 * The test class for Organization.
 */
public class OrganizationTest {
	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		NameBaseType name2;

		String streetName = "Leidensgasse";
		String buildingNumber = "1";
		String postalCode = "8888";
		String city = "Musterhausen";
		String country = CountryCode.SWITZERLAND.getCodeAlpha3();
		PostalAddressUse postalUsage = PostalAddressUse.CONFIDENTIAL;

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

		extension = "myextension2";
		root = "2.999.2";

		IdentificatorBaseType id2 = IdentificatorBaseType.builder().withExtension(extension)
				.withRoot(root).build();

		name2 = NameBaseType.builder().withName("OrgName2").build();

		TelecomAddressUse telecomUsage = TelecomAddressUse.ANSWERING_SERVICE;
		String value = "033 888 77 66";

		telecomUsage = TelecomAddressUse.MOBILE;
		value = "079 222 33 44";

		TelecomBaseType telecom2 = TelecomBaseType.builder().withUsage(telecomUsage)
				.withValue(value).build();

		OrganizationBaseType organizationBt = OrganizationBaseType.builder()
				.withPrimaryAddress(address2).withPrimaryIdentificator(id2).withPrimaryName(name2)
				.withPrimaryTelecom(telecom2).build();

		Organization organization1 = new Organization(organizationBt);
		POCDMT000040Organization hl7CdaR2Type = organization1.getHl7CdaR2Pocdmt000040Organization();
		Organization organization2 = new Organization(hl7CdaR2Type);

		assertTrue(organization1.equals(organization2));

		// Null Flavor Tests (note, that POCD_MT000040.Organization does not
		// currently is an extension of ANY (see POCD_MT000040.xsd) and
		// therefore the HL7 CDA R2 datatype does not provide the nullflavor
		// property
		POCDMT000040Organization nullHl7CdaR2Value = null;
		Organization nullObj = new Organization(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE, nullObj.getNullFlavor());

		// This is for debugging purposes, only. When enabled, you need to add
		// @XmlRootElement(name = "debug") to class POCDMT000040Organization
		// JAXBContext context;
		// try {
		// context = JAXBContext.newInstance(POCDMT000040Organization.class);
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
