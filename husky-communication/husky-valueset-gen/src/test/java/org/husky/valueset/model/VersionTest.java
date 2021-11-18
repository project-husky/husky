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
package org.husky.valueset.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.husky.common.basetypes.NameBaseType;
import org.husky.common.basetypes.OrganizationBaseType;
import org.husky.common.utils.DateUtil;
import org.husky.valueset.model.Version;
import org.junit.jupiter.api.Test;

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
		Date validFrom = DateUtil.parseDateyyyyMMddHHmmss("20190603000000");
		Date validTo = DateUtil.parseDateyyyyMMddHHmmss("20191231235959");

		Version version1 = Version.builder().withLabel(label)
				.withPublishingAuthority(publishingAuthority).withValidFrom(validFrom)
				.withValidTo(validTo).build();
		Version version2 = Version.builder().withLabel(label)
				.withPublishingAuthority(publishingAuthority).withValidFrom(validFrom)
				.withValidTo(validTo).build();

		assertEquals(version1.hashCode(), version2.hashCode());
		assertEquals(version1, version2);

		assertEquals(label, version1.getLabel());
		assertEquals(publishingAuthority, version1.getPublishingAuthority());
		assertEquals(validFrom, version1.getValidFrom());
		assertEquals(validTo, version1.getValidTo());
	}

}
