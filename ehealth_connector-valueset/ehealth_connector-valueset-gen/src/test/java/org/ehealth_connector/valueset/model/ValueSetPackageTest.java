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
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.valueset.enums.ValueSetEntryTypeEnum;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatusEnum;
import org.ehealth_connector.valueset.enums.ValueSetStatusEnum;
import org.junit.Test;

/**
 * The Test Class for ValueSetPackage.
 */
public class ValueSetPackageTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		// Basic ValueSetPackage elements tests
		String description = "description";
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myPackageId").build();
		URL sourceUrl = null;
		try {
			sourceUrl = new URL("http://foo.bar");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ValueSetPackageStatusEnum status = ValueSetPackageStatusEnum.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.localDateTime("03.06.2019 00:00:00")).build();

		ValueSetPackage valueSetPackage = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();

		assertEquals(description, valueSetPackage.getDescription());
		assertEquals(identificator, valueSetPackage.getIdentificator());
		assertEquals(sourceUrl, valueSetPackage.getSourceUrl());
		assertEquals(status, valueSetPackage.getStatus());
		assertEquals(version, valueSetPackage.getVersion());

		String sourceUrlInvalid = "sourceUrl";
		try {
			valueSetPackage.setSourceUrlString(sourceUrlInvalid);
			fail("Invalid URL must not pass");
		} catch (MalformedURLException e) {
			// Do nothing, all OK for this test, when the exception is raised!
		}

		// ValueSet tests
		String vsdescription1 = "vsdescription1";
		String vsdisplayName1 = "vsdisplayName1";
		Date vseffectiveDate1 = DateUtil.date("06.06.2019");
		IdentificatorBaseType vsidentificator1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("1").build();
		String vsname1 = "myValueSetName1";
		ValueSetStatusEnum vsstatus1 = ValueSetStatusEnum.ACTIVE;
		Version vsversion1 = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.localDateTime("03.06.2019 00:00:00")).build();

		String vsdescription2 = "vsdescription2";
		String vsdisplayName2 = "vsdisplayName2";
		Date vseffectiveDate2 = DateUtil.date("05.06.2019");
		IdentificatorBaseType vsidentificator2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("2").build();
		String vsname2 = "myValueSetName2";
		ValueSetStatusEnum vsstatus2 = ValueSetStatusEnum.DRAFT;
		Version vsversion2 = Version.builder().withLabel("2.0")
				.withValidFrom(DateUtil.localDateTime("03.06.2019 00:00:00")).build();

		ValueSet valueSet1 = ValueSet.builder().withDescription(vsdescription1)
				.withDisplayName(vsdisplayName1).withEffectiveDate(vseffectiveDate1)
				.withIdentificator(vsidentificator1).withName(vsname1).withStatus(vsstatus1)
				.withVersion(vsversion1).build();

		ValueSet valueSet2 = ValueSet.builder().withDescription(vsdescription2)
				.withDisplayName(vsdisplayName2).withEffectiveDate(vseffectiveDate2)
				.withIdentificator(vsidentificator2).withName(vsname2).withStatus(vsstatus2)
				.withVersion(vsversion2).build();

		CodeBaseType codeBaseType1 = CodeBaseType.builder().withCode("abstractcode1")
				.withCodeSystem("2.999").build();
		String defaultMappingName1 = "defaultMappingNameAbstract";
		int level1 = 1;
		ValueSetEntryTypeEnum valueSetEntryType1 = ValueSetEntryTypeEnum.ABSTRACT;

		CodeBaseType codeBaseType2 = CodeBaseType.builder().withCode("leafcode2")
				.withCodeSystem("2.999").build();
		String defaultMappingName2 = "defaultMappingNameLeaf2";
		int level2 = 2;
		ValueSetEntryTypeEnum valueSetEntryType2 = ValueSetEntryTypeEnum.LEAF;

		CodeBaseType codeBaseType3 = CodeBaseType.builder().withCode("leafcode3")
				.withCodeSystem("2.999").build();
		String defaultMappingName3 = "defaultMappingNameLeaf3";
		int level3 = 2;
		ValueSetEntryTypeEnum valueSetEntryType3 = ValueSetEntryTypeEnum.LEAF;

		ValueSetEntry valueSetEntry1 = ValueSetEntry.builder().withCodeBaseType(codeBaseType1)
				.withDefaultMappingName(defaultMappingName1).withLevel(level1)
				.withValueSetEntryType(valueSetEntryType1).build();

		ValueSetEntry valueSetEntry2 = ValueSetEntry.builder().withCodeBaseType(codeBaseType2)
				.withDefaultMappingName(defaultMappingName2).withLevel(level2)
				.withValueSetEntryType(valueSetEntryType2).build();

		ValueSetEntry valueSetEntry3 = ValueSetEntry.builder().withCodeBaseType(codeBaseType3)
				.withDefaultMappingName(defaultMappingName3).withLevel(level3)
				.withValueSetEntryType(valueSetEntryType3).build();

		valueSet1.addValueSetEntry(valueSetEntry1);
		valueSet2.addValueSetEntry(valueSetEntry2);
		valueSet2.addValueSetEntry(valueSetEntry3);

		valueSetPackage.addValueSet(valueSet1);
		valueSetPackage.addValueSet(valueSet2);

		assertEquals(valueSet1, valueSetPackage.listValueSets().get(0));
		assertEquals(2, valueSetPackage.listValueSets().size());

		// ValueSetPackage mapping Identificator tests
		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId1").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId2").build();

		valueSetPackage.addMappingIdentificator(mappingId1);
		valueSetPackage.addMappingIdentificator(mappingId2);

		assertEquals(mappingId1, valueSetPackage.listMappingIdentificators().get(0));
		assertEquals(2, valueSetPackage.listMappingIdentificators().size());

		// ValueSetPackage mapping names tests
		String mappingName1 = "mappingName1";

		valueSetPackage.addMappingName(mappingName1);

		assertEquals(mappingName1, valueSetPackage.listMappingNames().get(0));
		assertEquals(1, valueSetPackage.listMappingNames().size());

	}

}
