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
package org.husky.common.ch.enums.stable;

import org.junit.jupiter.api.Test;

import static org.husky.common.model.ValueSetEnumInterfaceTest.assertValueSetEnumEntries;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfidentialityCodeTest {

	@Test
	void testConfidentialityCode() {

		assertEquals("2.16.756.5.30.1.127.3.10.1.5", ConfidentialityCode.VALUE_SET_ID);
		assertValueSetEnumEntries(ConfidentialityCode.values());

	}

}
