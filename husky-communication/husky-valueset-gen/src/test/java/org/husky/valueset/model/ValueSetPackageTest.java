/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.valueset.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.enums.LanguageCode;
import org.husky.common.utils.DateUtil;
import org.husky.common.utils.LangText;
import org.husky.valueset.enums.ValueSetEntryType;
import org.husky.valueset.enums.ValueSetPackageStatus;
import org.husky.valueset.enums.ValueSetStatus;
import org.husky.valueset.model.ValueSet;
import org.husky.valueset.model.ValueSetEntry;
import org.husky.valueset.model.ValueSetPackage;
import org.husky.valueset.model.Version;
import org.junit.jupiter.api.Test;

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
		String sourceUrl = "http://foo.bar";
		ValueSetPackageStatus status = ValueSetPackageStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190603000000")).build();

		ValueSetPackage valueSetPackage1 = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();
		ValueSetPackage valueSetPackage2 = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();

		assertEquals(valueSetPackage1.hashCode(), valueSetPackage2.hashCode());
		assertEquals(valueSetPackage1, valueSetPackage2);

		assertEquals(description, valueSetPackage1.getDescription());
		assertEquals(identificator, valueSetPackage1.getIdentificator());
		assertEquals(sourceUrl, valueSetPackage1.getSourceUrl());
		assertEquals(status, valueSetPackage1.getStatus());
		assertEquals(version, valueSetPackage1.getVersion());

		// ValueSet tests
		String vsdescription1 = "vsdescription1";
		String vsdisplayName1 = "vsdisplayName1";
		Date vseffectiveDate1 = DateUtil.parseDateyyyyMMdd("20190606");
		IdentificatorBaseType vsidentificator1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("1").build();
		String vsname1 = "myValueSetName1";
		ValueSetStatus vsstatus1 = ValueSetStatus.FINAL;
		Version vsversion1 = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190603000000")).build();
		String mappingNameVs1 = "mappingNameVs1";
		IdentificatorBaseType mappingIdVs1 = IdentificatorBaseType.builder().withRoot("2.999.9991")
				.withExtension("myValueSet1").build();

		String vsdescription2 = "vsdescription2";
		String vsdisplayName2 = "vsdisplayName2";
		Date vseffectiveDate2 = DateUtil.parseDateyyyyMMdd("20190605");
		IdentificatorBaseType vsidentificator2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("2").build();
		String vsname2 = "myValueSetName2";
		ValueSetStatus vsstatus2 = ValueSetStatus.DRAFT;
		Version vsversion2 = Version.builder().withLabel("2.0")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190603000000")).build();
		String mappingNameVs2 = "mappingNameVs2";
		IdentificatorBaseType mappingIdVs2 = IdentificatorBaseType.builder().withRoot("2.999.9992")
				.withExtension("myValueSet2").build();

		ValueSet valueSet1 = ValueSet.builder().withDisplayName(vsdisplayName1)
				.withEffectiveDate(vseffectiveDate1).withIdentificator(vsidentificator1)
				.withName(vsname1).withStatus(vsstatus1).withVersion(vsversion1).build();
		valueSet1.addDescription(new LangText(LanguageCode.ENGLISH, vsdescription1));
		valueSet1.addMappingName(mappingNameVs1);
		valueSet1.addMappingIdentificator(mappingIdVs1);

		ValueSet valueSet2 = ValueSet.builder().withDisplayName(vsdisplayName2)
				.withEffectiveDate(vseffectiveDate2).withIdentificator(vsidentificator2)
				.withName(vsname2).withStatus(vsstatus2).withVersion(vsversion2).build();
		valueSet2.addDescription(new LangText(LanguageCode.ENGLISH, vsdescription2));
		valueSet2.addMappingName(mappingNameVs2);
		valueSet2.addMappingIdentificator(mappingIdVs2);

		CodeBaseType codeBaseType1 = CodeBaseType.builder().withCode("abstractcode1")
				.withCodeSystem("2.999").build();
		String defaultMappingName1 = "defaultMappingNameAbstract";
		int level1 = 1;
		ValueSetEntryType valueSetEntryType1 = ValueSetEntryType.ABSTRACT;

		CodeBaseType codeBaseType2 = CodeBaseType.builder().withCode("leafcode2")
				.withCodeSystem("2.999").build();
		String defaultMappingName2 = "defaultMappingNameLeaf2";
		int level2 = 2;
		ValueSetEntryType valueSetEntryType2 = ValueSetEntryType.LEAF;

		CodeBaseType codeBaseType3 = CodeBaseType.builder().withCode("leafcode3")
				.withCodeSystem("2.999").build();
		String defaultMappingName3 = "defaultMappingNameLeaf3";
		int level3 = 2;
		ValueSetEntryType valueSetEntryType3 = ValueSetEntryType.LEAF;

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

		valueSetPackage1.addValueSet(valueSet1);
		valueSetPackage1.addValueSet(valueSet2);

		assertEquals(valueSet1, valueSetPackage1.getValueSetList().get(0));
		assertEquals(2, valueSetPackage1.getValueSetList().size());

		// ValueSetPackage mapping Identificator tests
		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId1").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId2").build();

		valueSetPackage1.addMappingIdentificator(mappingId1);
		valueSetPackage1.addMappingIdentificator(mappingId2);

		assertEquals(mappingId1, valueSetPackage1.getMappingIdentificatorList().get(0));
		assertEquals(2, valueSetPackage1.getMappingIdentificatorList().size());

		// ValueSetPackage mapping names tests
		String mappingName1 = "mappingName1";

		valueSetPackage1.addMappingName(mappingName1);

		assertEquals(mappingName1, valueSetPackage1.getMappingNameList().get(0));
		assertEquals(1, valueSetPackage1.getMappingNameList().size());

		assertTrue(valueSet1.equals(valueSetPackage1.getValueSetyByMappingName(mappingNameVs1)));
		assertTrue(valueSet2
				.equals(valueSetPackage1.getValueSetyByMappingIdentificator(mappingIdVs2)));

	}

	@Test
	public void testEqualsAddContainsMappingIdentificator() {

		ValueSetPackage valueSetPackageA = new ValueSetPackage();
		ValueSetPackage valueSetPackageB = new ValueSetPackage();

		assertEquals(valueSetPackageA, valueSetPackageB);
		assertEquals(valueSetPackageB, valueSetPackageA);

		IdentificatorBaseType mappingIdentificator1 = IdentificatorBaseType.builder()
				.withRoot("2.999").withExtension("identificator-1").build();

		valueSetPackageA.addMappingIdentificator(mappingIdentificator1);
		assertNotEquals(valueSetPackageA, valueSetPackageB);
		assertNotEquals(valueSetPackageB, valueSetPackageA);

		valueSetPackageB.addMappingIdentificator(mappingIdentificator1);
		assertEquals(valueSetPackageA, valueSetPackageB);
		assertEquals(valueSetPackageB, valueSetPackageA);

		assertTrue(valueSetPackageA.containsMappingIdentificator(IdentificatorBaseType.builder()
				.withRoot("2.999").withExtension("identificator-1").build()));
		assertTrue(valueSetPackageA.getMappingIdentificatorList().contains(IdentificatorBaseType
				.builder().withRoot("2.999").withExtension("identificator-1").build()));

	}

	@Test
	public void testEqualsAddContainsMappingName() {

		ValueSetPackage valueSetPackageA = new ValueSetPackage();
		ValueSetPackage valueSetPackageB = new ValueSetPackage();

		assertEquals(valueSetPackageA, valueSetPackageB);
		assertEquals(valueSetPackageB, valueSetPackageA);

		String mappingName1 = "name-1";

		valueSetPackageA.addMappingName(mappingName1);
		assertNotEquals(valueSetPackageA, valueSetPackageB);
		assertNotEquals(valueSetPackageB, valueSetPackageA);

		valueSetPackageB.addMappingName(mappingName1);
		assertEquals(valueSetPackageA, valueSetPackageB);
		assertEquals(valueSetPackageB, valueSetPackageA);

		assertTrue(valueSetPackageA.containsMappingName("name-1"));
		assertTrue(valueSetPackageA.getMappingNameList().contains("name-1"));

	}

	@Test
	public void testEqualsAddContainsValueSet() {

		ValueSetPackage valueSetPackageA = new ValueSetPackage();
		ValueSetPackage valueSetPackageB = new ValueSetPackage();

		assertEquals(valueSetPackageA, valueSetPackageB);
		assertEquals(valueSetPackageB, valueSetPackageA);

		ValueSet valueSet1 = ValueSet.builder().withName("value-set-1").build();

		valueSetPackageA.addValueSet(valueSet1);
		assertNotEquals(valueSetPackageA, valueSetPackageB);
		assertNotEquals(valueSetPackageB, valueSetPackageA);

		valueSetPackageB.addValueSet(valueSet1);
		assertEquals(valueSetPackageA, valueSetPackageB);
		assertEquals(valueSetPackageB, valueSetPackageA);

		assertTrue(valueSetPackageA
				.containsValueSet(ValueSet.builder().withName("value-set-1").build()));
		assertTrue(valueSetPackageA.getValueSetList()
				.contains(ValueSet.builder().withName("value-set-1").build()));

	}

}
