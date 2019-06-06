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

import java.time.LocalDateTime;

import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.utils.DateUtil;
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
		OrganizationBaseType publishingAuthority = OrganizationBaseType.builder()
				.withPrimaryName("eHC").build();
		LocalDateTime validFrom = DateUtil.localDateTime("03.06.2019 00:00:00");
		LocalDateTime validTo = DateUtil.localDateTime("31.12.2019 23:59:59");

		Version version = Version.builder().withLabel(label)
				.withPublishingAuthority(publishingAuthority).withValidFrom(validFrom)
				.withValidTo(validTo).build();

		assertEquals(label, version.getLabel());
		assertEquals(publishingAuthority, version.getPublishingAuthority());
		assertEquals(validFrom, version.getValidFrom());
		assertEquals(validTo, version.getValidTo());
	}

}
