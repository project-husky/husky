/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.common.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.husky.common.basetypes.TelecomBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.TelecomAddressUse;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Telecom;
import org.junit.jupiter.api.Test;

/**
 * The test class for Telecom.
 */
public class TelecomTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		TelecomAddressUse usage = TelecomAddressUse.ANSWERING_SERVICE;
		String value = "033 888 77 66";

		TelecomBaseType telecomBt = TelecomBaseType.builder().withUsage(usage).withValue(value)
				.build();

		Telecom telecom1 = new Telecom(telecomBt);
		TEL hl7CdaR2Type = telecom1.getHl7CdaR2Tel();
		Telecom telecom2 = new Telecom(hl7CdaR2Type);

		assertTrue(telecom1.equals(telecom2));

		// Null Flavor Tests
		TEL nullHl7CdaR2Value = null;
		Telecom nullObj = new Telecom(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createTEL();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Telecom(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN, nullObj.getNullFlavor());

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
