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

import java.util.Date;

import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.junit.Test;

/**
 * The Test Class for Version.
 */
public class VersionTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		String label = "1.0";
		NameBaseType name = NameBaseType.builder().withName("eHC").build();

		OrganizationBaseType publishingAuthority = OrganizationBaseType.builder()
				.withPrimaryName(name).build();
		Date validFrom = DateUtilMdht.date("03.06.2019 00:00:00");
		Date validTo = DateUtilMdht.date("31.12.2019 23:59:59");

		Version version1 = Version.builder().withLabel(label)
				.withPublishingAuthority(publishingAuthority).withValidFrom(validFrom)
				.withValidTo(validTo).build();
		Version version2 = Version.builder().withLabel(label)
				.withPublishingAuthority(publishingAuthority).withValidFrom(validFrom)
				.withValidTo(validTo).build();

		assertEquals(version1.hashCode(), version2.hashCode());
		assertTrue(version1.equals(version2));

		assertEquals(label, version1.getLabel());
		assertEquals(publishingAuthority, version1.getPublishingAuthority());
		assertEquals(validFrom, version1.getValidFrom());
		assertEquals(validTo, version1.getValidTo());
	}

}
