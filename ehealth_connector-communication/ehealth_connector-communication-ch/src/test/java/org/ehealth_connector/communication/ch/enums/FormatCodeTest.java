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
package org.ehealth_connector.communication.ch.enums;

import static org.ehealth_connector.common.mdht.ValueSetEnumInterfaceTest.assertValueSetEnumEntries;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FormatCodeTest {

	@Test
	public void testFormatCode() {

		assertEquals("2.16.756.5.30.1.127.3.10.1.9", FormatCode.VALUE_SET_ID);
		assertValueSetEnumEntries(FormatCode.values());

	}

}
