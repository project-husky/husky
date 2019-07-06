/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.valueset.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.junit.Test;

/**
 * The Test Class for Designation.
 */
public class DesignationTest {
	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		LanguageCode languageCode = LanguageCode.GERMAN;
		DesignationType type = DesignationType.FULLY_SPECIFIED_NAME;
		String displayName = "displayName";

		Designation designation1 = Designation.builder().withDisplayName(displayName)
				.withLanguageCode(languageCode).withType(type).build();
		Designation designation2 = Designation.builder().withDisplayName(displayName)
				.withLanguageCode(languageCode).withType(type).build();

		assertEquals(designation1.hashCode(), designation2.hashCode());
		assertTrue(designation1.equals(designation2));

		assertEquals(languageCode, designation1.getLanguageCode());
		assertEquals(type, designation1.getType());
		assertEquals(displayName, designation1.getDisplayName());

	}

}
