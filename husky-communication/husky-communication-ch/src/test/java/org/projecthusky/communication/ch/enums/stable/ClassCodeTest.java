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
package org.projecthusky.communication.ch.enums.stable;

import org.junit.jupiter.api.Test;

import static org.projecthusky.common.model.ValueSetEnumInterfaceTest.assertValueSetEnumEntries;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassCodeTest {

	@Test
	void testClassCode() {

		assertEquals("2.16.756.5.30.1.127.3.10.1.3", ClassCode.VALUE_SET_ID);
		assertValueSetEnumEntries(ClassCode.values());

	}

}
