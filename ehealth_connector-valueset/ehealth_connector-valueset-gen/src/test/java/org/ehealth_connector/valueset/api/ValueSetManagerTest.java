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
package org.ehealth_connector.valueset.api;

import java.util.Date;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.model.ValueSet;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;

/**
 * The Test Class for ValueSetManager.
 */
public class ValueSetManagerTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		String description1 = "description1";
		String displayName1 = "displayName1";
		Date effectiveDate1 = DateUtil.date("11.06.2019");
		IdentificatorBaseType identificator1 = IdentificatorBaseType.builder().withRoot("2.999.1")
				.withExtension("11").build();
		String name1 = "myValueSetName1";
		ValueSetStatus status1 = ValueSetStatus.ACTIVE;
		Version version1 = Version.builder().withLabel("1.1")
				.withValidFrom(DateUtil.date("11.06.2019 00:00:00")).build();

		ValueSet valueSet1 = ValueSet.builder().withDescription(description1)
				.withDisplayName(displayName1).withEffectiveDate(effectiveDate1)
				.withIdentificator(identificator1).withName(name1).withStatus(status1)
				.withVersion(version1).build();

		String description2 = "description2";
		String displayName2 = "displayName2";
		Date effectiveDate2 = DateUtil.date("12.06.2019");
		IdentificatorBaseType identificator2 = IdentificatorBaseType.builder().withRoot("2.999.2")
				.withExtension("12").build();
		String name2 = "myValueSetName2";
		ValueSetStatus status2 = ValueSetStatus.ACTIVE;
		Version version2 = Version.builder().withLabel("1.2")
				.withValidFrom(DateUtil.date("12.06.2019 00:00:00")).build();

		ValueSet valueSet2 = ValueSet.builder().withDescription(description2)
				.withDisplayName(displayName2).withEffectiveDate(effectiveDate2)
				.withIdentificator(identificator2).withName(name2).withStatus(status2)
				.withVersion(version2).build();

	}

}
