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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.enums.LanguageCode;
import org.husky.common.utils.DateUtil;
import org.husky.common.utils.LangText;
import org.husky.valueset.enums.ValueSetEntryType;
import org.husky.valueset.enums.ValueSetStatus;
import org.husky.valueset.model.ValueSet;
import org.husky.valueset.model.ValueSetEntry;
import org.husky.valueset.model.Version;
import org.junit.jupiter.api.Test;

/**
 * The Test Class for ValueSet.
 */
class ValueSetTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		// Basic ValueSet elements tests
		String description = "description";
		String displayName = "displayName";
		Date effectiveDate = DateUtil.parseDateyyyyMMdd("20190606");
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("1").build();
		String name = "myValueSetName";
		ValueSetStatus status = ValueSetStatus.FINAL;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190603000000")).build();

		ValueSet valueSet1 = ValueSet.builder().withDisplayName(displayName)
				.withEffectiveDate(effectiveDate).withIdentificator(identificator).withName(name)
				.withStatus(status).withVersion(version).build();
		ValueSet valueSet2 = ValueSet.builder().withDisplayName(displayName)
				.withEffectiveDate(effectiveDate).withIdentificator(identificator).withName(name)
				.withStatus(status).withVersion(version).build();

		assertEquals(valueSet1.hashCode(), valueSet2.hashCode());
		assertEquals(valueSet1, valueSet2);

		valueSet1.addDescription(new LangText(LanguageCode.ENGLISH, description));
		assertEquals(description, valueSet1.getDescription(LanguageCode.ENGLISH));
		assertTrue(valueSet1.containsDescription(new LangText(LanguageCode.ENGLISH, description)));

		assertEquals(displayName, valueSet1.getDisplayName());
		assertEquals(effectiveDate, valueSet1.getEffectiveDate());
		assertEquals(identificator, valueSet1.getIdentificator());
		assertEquals(name, valueSet1.getName());
		assertEquals(status, valueSet1.getStatus());
		assertEquals(version, valueSet1.getVersion());

		// ValueSetEntry tests
		CodeBaseType codeBaseType1 = CodeBaseType.builder().withCode("abstractcode1")
				.withCodeSystem("2.999").build();
		String defaultMappingName1 = "defaultMappingNameAbstract";
		int level1 = 1;
		ValueSetEntryType valueSetEntryType1 = ValueSetEntryType.ABSTRACT;
		CodeBaseType mappingCode1 = CodeBaseType.builder().withCode("mappingCodeAbstract1")
				.withCodeSystem("2.999.999.1").build();

		CodeBaseType codeBaseType2 = CodeBaseType.builder().withCode("leafcode2")
				.withCodeSystem("2.999").build();
		String defaultMappingName2 = "defaultMappingNameLeaf2";
		int level2 = 2;
		ValueSetEntryType valueSetEntryType2 = ValueSetEntryType.LEAF;
		CodeBaseType mappingCode2 = CodeBaseType.builder().withCode("mappingCodeAbstract2")
				.withCodeSystem("2.999.999.2").build();

		CodeBaseType codeBaseType3 = CodeBaseType.builder().withCode("leafcode3")
				.withCodeSystem("2.999").build();
		String defaultMappingName3 = "mappingNameLeaf3";
		int level3 = 2;
		ValueSetEntryType valueSetEntryType3 = ValueSetEntryType.LEAF;
		CodeBaseType mappingCode3 = CodeBaseType.builder().withCode("defaultMappingCodeAbstract3")
				.withCodeSystem("2.999.999.3").build();

		ValueSetEntry valueSetEntry1 = ValueSetEntry.builder().withCodeBaseType(codeBaseType1)
				.withDefaultMappingName(defaultMappingName1).withLevel(level1)
				.withValueSetEntryType(valueSetEntryType1).build();
		valueSetEntry1.addMappingCode(mappingCode1);

		ValueSetEntry valueSetEntry2 = ValueSetEntry.builder().withCodeBaseType(codeBaseType2)
				.withDefaultMappingName(defaultMappingName2).withLevel(level2)
				.withValueSetEntryType(valueSetEntryType2).build();
		valueSetEntry2.addMappingCode(mappingCode2);

		ValueSetEntry valueSetEntry3 = ValueSetEntry.builder().withCodeBaseType(codeBaseType3)
				.withDefaultMappingName(defaultMappingName3).withLevel(level3)
				.withValueSetEntryType(valueSetEntryType3).build();
		valueSetEntry3.addMappingCode(mappingCode3);

		valueSet1.addValueSetEntry(valueSetEntry1);
		valueSet1.addValueSetEntry(valueSetEntry2);
		valueSet1.addValueSetEntry(valueSetEntry3);

		assertEquals(valueSetEntry2, valueSet1.getValueSetEntryList().get(1));
		assertEquals(3, valueSet1.getValueSetEntryList().size());

		// ValueSet mapping Identificator tests
		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId1").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId2").build();

		valueSet1.addMappingIdentificator(mappingId1);
		valueSet1.addMappingIdentificator(mappingId2);

		assertEquals(mappingId1, valueSet1.getMappingIdentificatorList().get(0));
		assertEquals(2, valueSet1.getMappingIdentificatorList().size());

		// ValueSet mapping names tests
		String mappingName1 = "mappingName1";
		String mappingName2 = "mappingName2";
		String mappingName3 = "mappingName3";
		String mappingName4 = "mappingName4";

		valueSet1.addMappingName(mappingName1);
		valueSet1.addMappingName(mappingName2);
		valueSet1.addMappingName(mappingName3);
		valueSet1.addMappingName(mappingName4);

		assertEquals(mappingName2, valueSet1.getMappingNameList().get(1));
		assertEquals(4, valueSet1.getMappingNameList().size());
		
		assertEquals(valueSetEntry1, valueSet1.getValueSetEntryByMappingName(defaultMappingName1));
		assertEquals(valueSetEntry2, valueSet1.getValueSetEntryByMappingCode(mappingCode2));
	}

	@Test
	void testEqualsAddContainsDescription() {

		ValueSet valueSetA = new ValueSet();
		ValueSet valueSetB = new ValueSet();

		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		LangText description1 = new LangText(LanguageCode.ENGLISH, "description-1");

		valueSetA.addDescription(description1);
		assertNotEquals(valueSetA, valueSetB);
		assertNotEquals(valueSetB, valueSetA);

		valueSetB.addDescription(description1);
		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		assertTrue(
				valueSetA.containsDescription(new LangText(LanguageCode.ENGLISH, "description-1")));
		assertTrue(valueSetA.getDescriptionList()
				.contains(new LangText(LanguageCode.ENGLISH, "description-1")));

	}

	@Test
	void testEqualsAddContainsMappingIdentificator() {

		ValueSet valueSetA = new ValueSet();
		ValueSet valueSetB = new ValueSet();

		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		IdentificatorBaseType mappingIdentificator1 = IdentificatorBaseType.builder()
				.withRoot("2.999").withExtension("identificator-1").build();

		valueSetA.addMappingIdentificator(mappingIdentificator1);
		assertNotEquals(valueSetA, valueSetB);
		assertNotEquals(valueSetB, valueSetA);

		valueSetB.addMappingIdentificator(mappingIdentificator1);
		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		assertTrue(valueSetA.containsMappingIdentificator(IdentificatorBaseType.builder()
				.withRoot("2.999").withExtension("identificator-1").build()));
		assertTrue(valueSetA.getMappingIdentificatorList().contains(IdentificatorBaseType.builder()
				.withRoot("2.999").withExtension("identificator-1").build()));
	}

	@Test
	void testEqualsAddContainsMappingName() {

		ValueSet valueSetA = new ValueSet();
		ValueSet valueSetB = new ValueSet();

		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		String mappingName1 = "name-1";

		valueSetA.addMappingName(mappingName1);
		assertNotEquals(valueSetA, valueSetB);
		assertNotEquals(valueSetB, valueSetA);

		valueSetB.addMappingName(mappingName1);
		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		assertTrue(valueSetA.containsMappingName("name-1"));
		assertTrue(valueSetA.getMappingNameList().contains("name-1"));
	}

	@Test
	void testEqualsAddContainsValueSetEntry() {

		ValueSet valueSetA = new ValueSet();
		ValueSet valueSetB = new ValueSet();

		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		ValueSetEntry valueSetEntry1 = ValueSetEntry.builder()
				.withDefaultMappingName("default-mapping-name-1").build();

		valueSetA.addValueSetEntry(valueSetEntry1);
		assertNotEquals(valueSetA, valueSetB);
		assertNotEquals(valueSetB, valueSetA);

		valueSetB.addValueSetEntry(valueSetEntry1);
		assertEquals(valueSetA, valueSetB);
		assertEquals(valueSetB, valueSetA);

		assertTrue(valueSetA.containsValueSetEntry(
				ValueSetEntry.builder().withDefaultMappingName("default-mapping-name-1").build()));
		assertTrue(valueSetA.getValueSetEntryList().contains(
				ValueSetEntry.builder().withDefaultMappingName("default-mapping-name-1").build()));
	}

}
