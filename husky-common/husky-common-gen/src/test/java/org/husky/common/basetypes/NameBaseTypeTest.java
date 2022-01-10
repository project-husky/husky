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

import org.husky.common.enums.EntityNameUse;
import org.junit.jupiter.api.Test;

/**
 * The test class for NameBaseType.
 */
class NameBaseTypeTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		String delimiter = ".";
		String family = "family";
		String given = "given";
		String prefix = "prefix";
		String suffix = "suffix";
		EntityNameUse usage = EntityNameUse.PHONETIC;

		String name1 = "prefix.given.family.suffix";
		String name2 = "My own name";

		NameBaseType nameBaseType = NameBaseType.builder().withDelimiter(delimiter)
				.withFamily(family).withGiven(given).withPrefix(prefix).withSuffix(suffix)
				.withUsage(usage).build();

		assertEquals(delimiter, nameBaseType.getDelimiter());
		assertEquals(family, nameBaseType.getFamily());
		assertEquals(given, nameBaseType.getGiven());
		assertEquals(prefix, nameBaseType.getPrefix());
		assertEquals(suffix, nameBaseType.getSuffix());
		assertEquals(usage, nameBaseType.getUsage());

		assertEquals(name1, nameBaseType.getFullName());
		assertEquals(null, nameBaseType.getName());

		nameBaseType.setName(name2);
		assertEquals(name2, nameBaseType.getName());

		nameBaseType.setDelimiter(" ");
		assertEquals(name1.replace(".", " "), nameBaseType.getName());

	}

}
