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

import org.husky.common.basetypes.NameBaseType;
import org.husky.common.enums.EntityNameUse;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.EN;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		String given = "John";
		String family = "Doe";
		String fullName = "My Name is John Doe :-)";
		EntityNameUse usage = EntityNameUse.LEGAL;

		NameBaseType personNameBt = NameBaseType.builder().withFamily(family).withGiven(given)
				.withUsage(usage).build();
		personNameBt.setName(fullName);

		Name personName1 = new Name(personNameBt);
		EN hl7CdaR2Type2 = personName1.getHl7CdaR2En();
		Name name2 = new Name(hl7CdaR2Type2);

		assertEquals(personName1, name2);

		personNameBt.setName(fullName);

		Name name3 = new Name(personNameBt);
		hl7CdaR2Type2 = name3.getHl7CdaR2En();
		Name name4 = new Name(hl7CdaR2Type2);

		assertEquals(name3, name4);

		// Null Flavor Tests
		EN nullHl7CdaR2Value = null;
		Name nullObj = new Name(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE_L2, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createEN();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Name(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN_L1, nullObj.getNullFlavor());

		// This is for debugging purposes, only. When enabled, you need to add
		// @XmlRootElement(name = "debug") to class EN
		// JAXBContext context;
		// try {
		// context = JAXBContext.newInstance(EN.class);
		// Marshaller mar = context.createMarshaller();
		// mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// mar.marshal(hl7CdaR2Type2,
		// new File(Util.getTempDirectory() +
		// FileUtil.getPlatformSpecificPathSeparator()
		// + hl7CdaR2Type2.getClass().getName() + ".xml"));
		// } catch (JAXBException e) {
		// e.printStackTrace();
		// }

	}
}
