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

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
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
		String sourceUrl = "http://foo.bar";
		ValueSetPackageStatus status = ValueSetPackageStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtilMdht.date("03.06.2019 00:00:00")).build();

		ValueSetPackage valueSetPackage1 = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();
		ValueSetPackage valueSetPackage2 = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();

		assertEquals(valueSetPackage1.hashCode(), valueSetPackage2.hashCode());
		assertTrue(valueSetPackage1.equals(valueSetPackage2));

		assertEquals(description, valueSetPackage1.getDescription());
		assertEquals(identificator, valueSetPackage1.getIdentificator());
		assertEquals(sourceUrl, valueSetPackage1.getSourceUrl());
		assertEquals(status, valueSetPackage1.getStatus());
		assertEquals(version, valueSetPackage1.getVersion());

		// ValueSet tests
		String vsdescription1 = "vsdescription1";
		String vsdisplayName1 = "vsdisplayName1";
		Date vseffectiveDate1 = DateUtilMdht.date("06.06.2019");
		IdentificatorBaseType vsidentificator1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("1").build();
		String vsname1 = "myValueSetName1";
		ValueSetStatus vsstatus1 = ValueSetStatus.FINAL;
		Version vsversion1 = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtilMdht.date("03.06.2019 00:00:00")).build();
		String mappingNameVs1 = "mappingNameVs1";
		IdentificatorBaseType mappingIdVs1 = IdentificatorBaseType.builder().withRoot("2.999.9991")
				.withExtension("myValueSet1").build();

		String vsdescription2 = "vsdescription2";
		String vsdisplayName2 = "vsdisplayName2";
		Date vseffectiveDate2 = DateUtilMdht.date("05.06.2019");
		IdentificatorBaseType vsidentificator2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("2").build();
		String vsname2 = "myValueSetName2";
		ValueSetStatus vsstatus2 = ValueSetStatus.DRAFT;
		Version vsversion2 = Version.builder().withLabel("2.0")
				.withValidFrom(DateUtilMdht.date("03.06.2019 00:00:00")).build();
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

		assertEquals(valueSet1, valueSetPackage1.listValueSets().get(0));
		assertEquals(2, valueSetPackage1.listValueSets().size());

		// ValueSetPackage mapping Identificator tests
		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId1").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId2").build();

		valueSetPackage1.addMappingIdentificator(mappingId1);
		valueSetPackage1.addMappingIdentificator(mappingId2);

		assertEquals(mappingId1, valueSetPackage1.listMappingIdentificators().get(0));
		assertEquals(2, valueSetPackage1.listMappingIdentificators().size());

		// ValueSetPackage mapping names tests
		String mappingName1 = "mappingName1";

		valueSetPackage1.addMappingName(mappingName1);

		assertEquals(mappingName1, valueSetPackage1.listMappingNames().get(0));
		assertEquals(1, valueSetPackage1.listMappingNames().size());

		assertTrue(valueSet1.equals(valueSetPackage1.getValueSetyByMappingName(mappingNameVs1)));
		assertTrue(valueSet2
				.equals(valueSetPackage1.getValueSetyByMappingIdentificator(mappingIdVs2)));

	}

}
