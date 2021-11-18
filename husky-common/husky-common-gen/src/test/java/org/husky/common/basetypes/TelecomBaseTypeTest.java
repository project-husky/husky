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
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.common.basetypes.TelecomBaseType;
import org.husky.common.enums.TelecomAddressUse;
import org.junit.jupiter.api.Test;

/**
 * The test class for TelecomBaseType.
 */
public class TelecomBaseTypeTest {
	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {
		TelecomAddressUse usage = TelecomAddressUse.ANSWERING_SERVICE;
		String value = "033 888 77 66";

		TelecomBaseType telecom1 = TelecomBaseType.builder().withUsage(usage).withValue(value)
				.build();
		TelecomBaseType telecom2 = TelecomBaseType.builder().withUsage(usage).withValue(value)
				.build();

		assertEquals(telecom1.hashCode(), telecom2.hashCode());
		assertTrue(telecom1.equals(telecom2));

		assertEquals(usage, telecom1.getUsage());
		assertEquals(value, telecom1.getValue());

	}
}
