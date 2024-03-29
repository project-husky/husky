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
package org.projecthusky.common.basetypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * The test class for IdentificatorBaseType.
 */
class IdentificatorBaseTypeTest {
	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		String assigningAuthorityName = "assigningAuthorityName";
		boolean displayable = false;
		String extension = "myextension";
		String root = "2.999";

		IdentificatorBaseType id1 = IdentificatorBaseType.builder()
				.withAssigningAuthorityName(assigningAuthorityName).withDisplayable(displayable)
				.withExtension(extension).withRoot(root).build();

		IdentificatorBaseType id2 = IdentificatorBaseType.builder()
				.withAssigningAuthorityName(assigningAuthorityName).withDisplayable(displayable)
				.withExtension(extension).withRoot(root).build();

		assertEquals(id1.hashCode(), id2.hashCode());
		assertEquals(id1, id2);

		assertEquals(assigningAuthorityName, id1.getAssigningAuthorityName());
		assertEquals(displayable, id1.isDisplayable());
		assertEquals(extension, id1.getExtension());
		assertEquals(root, id1.getRoot());

	}
}
