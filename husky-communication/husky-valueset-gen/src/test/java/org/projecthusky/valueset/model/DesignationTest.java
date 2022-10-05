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
package org.projecthusky.valueset.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.valueset.enums.DesignationType;
import org.junit.jupiter.api.Test;

/**
 * The Test Class for Designation.
 */
class DesignationTest {
	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		LanguageCode languageCode = LanguageCode.GERMAN;
		DesignationType type = DesignationType.FULLY_SPECIFIED_NAME;
		String displayName = "displayName";

		Designation designation1 = Designation.builder().withDisplayName(displayName)
				.withLanguageCode(languageCode).withType(type).build();
		Designation designation2 = Designation.builder().withDisplayName(displayName)
				.withLanguageCode(languageCode).withType(type).build();

		assertEquals(designation1.hashCode(), designation2.hashCode());
		assertEquals(designation1, designation2);

		assertEquals(languageCode, designation1.getLanguageCode());
		assertEquals(type, designation1.getType());
		assertEquals(displayName, designation1.getDisplayName());

	}

}
