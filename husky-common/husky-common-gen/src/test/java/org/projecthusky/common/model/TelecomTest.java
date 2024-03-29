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
package org.projecthusky.common.model;

import org.projecthusky.common.basetypes.TelecomBaseType;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.enums.TelecomAddressUse;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.TEL;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test class for Telecom.
 */
class TelecomTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		TelecomAddressUse usage = TelecomAddressUse.ANSWERING_SERVICE;
		String value = "033 888 77 66";

		TelecomBaseType telecomBt = TelecomBaseType.builder().withUsage(usage).withValue(value)
				.build();

		Telecom telecom1 = new Telecom(telecomBt);
		TEL hl7CdaR2Type = telecom1.getHl7CdaR2Tel();
		Telecom telecom2 = new Telecom(hl7CdaR2Type);

		assertEquals(telecom1, telecom2);

		// Null Flavor Tests
		TEL nullHl7CdaR2Value = null;
		Telecom nullObj = new Telecom(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE_L2, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createTEL();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Telecom(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN_L1, nullObj.getNullFlavor());

		// This is for debugging purposes, only. When enabled, you need to add
		// @XmlRootElement(name = "debug") to class TEL
		// JAXBContext context;
		// try {
		// context = JAXBContext.newInstance(TEL.class);
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
