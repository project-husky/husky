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
package org.ehealth_connector.common.basetypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ehealth_connector.common.enums.EntityNameUse;
import org.junit.jupiter.api.Test;

/**
 * The test class for NameBaseType.
 */
public class NameBaseTypeTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

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
