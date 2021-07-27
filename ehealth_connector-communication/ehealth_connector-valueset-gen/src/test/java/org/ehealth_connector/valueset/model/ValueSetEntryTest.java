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

package org.ehealth_connector.valueset.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.valueset.enums.DesignationType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;
import org.junit.Test;

/**
 * The Test Class for ValueSetEntryTest.
 */
public class ValueSetEntryTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		// Basic ValueSetEntry elements tests
		CodeBaseType codeBaseType1 = CodeBaseType.builder().withCode("abstractcode1")
				.withCodeSystem("2.999").build();
		String defaultMappingName1 = "defaultMappingNameAbstract";
		int level1 = 1;
		ValueSetEntryType valueSetEntryType1 = ValueSetEntryType.ABSTRACT;

		ValueSetEntry valueSetEntry1 = ValueSetEntry.builder().withCodeBaseType(codeBaseType1)
				.withDefaultMappingName(defaultMappingName1).withLevel(level1)
				.withValueSetEntryType(valueSetEntryType1).build();

		ValueSetEntry valueSetEntryA = ValueSetEntry.builder().withCodeBaseType(codeBaseType1)
				.withDefaultMappingName(defaultMappingName1).withLevel(level1)
				.withValueSetEntryType(valueSetEntryType1).build();

		assertEquals(valueSetEntry1.hashCode(), valueSetEntryA.hashCode());
		assertTrue(valueSetEntry1.equals(valueSetEntryA));

		assertEquals(codeBaseType1, valueSetEntry1.getCodeBaseType());
		assertEquals(defaultMappingName1, valueSetEntry1.getDefaultMappingName());
		assertEquals(level1, valueSetEntry1.getLevel());
		assertEquals(valueSetEntryType1, valueSetEntry1.getValueSetEntryType());

		// ValueSetEntry children tests
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

		ValueSetEntry valueSetEntry2 = ValueSetEntry.builder().withCodeBaseType(codeBaseType2)
				.withDefaultMappingName(defaultMappingName2).withLevel(level2)
				.withValueSetEntryType(valueSetEntryType2).build();

		ValueSetEntry valueSetEntry3 = ValueSetEntry.builder().withCodeBaseType(codeBaseType3)
				.withDefaultMappingName(defaultMappingName3).withLevel(level3)
				.withValueSetEntryType(valueSetEntryType3).build();

		valueSetEntry1.addChild(valueSetEntry2);
		valueSetEntry1.addChild(valueSetEntry3);

		assertEquals(codeBaseType3, valueSetEntry1.getChildList().get(1).getCodeBaseType());
		assertEquals(defaultMappingName3,
				valueSetEntry1.getChildList().get(1).getDefaultMappingName());
		assertEquals(level3, valueSetEntry1.getChildList().get(1).getLevel());
		assertEquals(valueSetEntryType3,
				valueSetEntry1.getChildList().get(1).getValueSetEntryType());

		// Designation tests

		LanguageCode languageCode1 = LanguageCode.GERMAN;
		DesignationType type1 = DesignationType.FULLY_SPECIFIED_NAME;
		String displayName1 = "displayName1";

		Designation designation1 = Designation.builder().withDisplayName(displayName1)
				.withLanguageCode(languageCode1).withType(type1).build();

		LanguageCode languageCode2 = LanguageCode.FRENCH;
		DesignationType type2 = DesignationType.PREFERRED;
		String displayName2 = "displayName2";

		Designation designation2 = Designation.builder().withDisplayName(displayName2)
				.withLanguageCode(languageCode2).withType(type2).build();

		valueSetEntry1.addDesignation(designation1);
		valueSetEntry1.addDesignation(designation2);

		assertEquals(languageCode2, valueSetEntry1.getDesignationList().get(1).getLanguageCode());
		assertEquals(type2, valueSetEntry1.getDesignationList().get(1).getType());
		assertEquals(displayName2, valueSetEntry1.getDesignationList().get(1).getDisplayName());

		// ValueSetEntry mapping codes tests
		CodeBaseType mappingCode1 = CodeBaseType.builder().withCode("mappingcode1")
				.withCodeSystem("2.999").build();
		CodeBaseType mappingCode2 = CodeBaseType.builder().withCode("mappingcode2")
				.withCodeSystem("2.999").build();

		valueSetEntry1.addMappingCode(mappingCode1);
		valueSetEntry1.addMappingCode(mappingCode2);

		assertEquals(mappingCode1, valueSetEntry1.getMappingCodeList().get(0));
		assertEquals(2, valueSetEntry1.getMappingCodeList().size());

		// ValueSetEntry mapping names tests
		String mappingName1 = "mappingName1";
		String mappingName2 = "mappingName2";
		String mappingName3 = "mappingName3";

		valueSetEntry1.addMappingName(mappingName1);
		valueSetEntry1.addMappingName(mappingName2);
		valueSetEntry1.addMappingName(mappingName3);

		assertEquals(mappingName2, valueSetEntry1.getMappingNameList().get(1));
		assertEquals(3, valueSetEntry1.getMappingNameList().size());
	}

	@Test
	public void testEqualsAddContainsChild() {

		ValueSetEntry valueSetEntryA = new ValueSetEntry();
		ValueSetEntry valueSetEntryB = new ValueSetEntry();

		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		ValueSetEntry child1 = ValueSetEntry.builder().withDefaultMappingName("child-1").build();

		valueSetEntryA.addChild(child1);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addChild(child1);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		ValueSetEntry child2 = ValueSetEntry.builder().withDefaultMappingName("child-2").build();

		valueSetEntryA.addChild(child2);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addChild(child2);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		assertTrue(valueSetEntryA
				.containsChild(ValueSetEntry.builder().withDefaultMappingName("child-1").build()));
		assertTrue(valueSetEntryA.getChildList()
				.contains(ValueSetEntry.builder().withDefaultMappingName("child-1").build()));

	}

	@Test
	public void testEqualsAddContainsDesignation() {

		ValueSetEntry valueSetEntryA = new ValueSetEntry();
		ValueSetEntry valueSetEntryB = new ValueSetEntry();

		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		Designation designation1 = Designation.builder().withDisplayName("designation-1").build();

		valueSetEntryA.addDesignation(designation1);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addDesignation(designation1);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		Designation designation2 = Designation.builder().withDisplayName("designation-2").build();

		valueSetEntryA.addDesignation(designation2);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addDesignation(designation2);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		assertTrue(valueSetEntryA.containsDesignation(
				Designation.builder().withDisplayName("designation-1").build()));
		assertTrue(valueSetEntryA.getDesignationList()
				.contains(Designation.builder().withDisplayName("designation-1").build()));

	}

	@Test
	public void testEqualsAddContainsMappingCode() {

		ValueSetEntry valueSetEntryA = new ValueSetEntry();
		ValueSetEntry valueSetEntryB = new ValueSetEntry();

		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		CodeBaseType mappingCode1 = CodeBaseType.builder().withCode("code-1")
				.withCodeSystem("2.999").build();

		valueSetEntryA.addMappingCode(mappingCode1);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addMappingCode(mappingCode1);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		CodeBaseType mappingCode2 = CodeBaseType.builder().withCode("code-2")
				.withCodeSystem("2.999").build();

		valueSetEntryA.addMappingCode(mappingCode2);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addMappingCode(mappingCode2);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		assertTrue(valueSetEntryA.containsMappingCode(
				CodeBaseType.builder().withCode("code-1").withCodeSystem("2.999").build()));
		assertTrue(valueSetEntryA.getMappingCodeList().contains(
				CodeBaseType.builder().withCode("code-1").withCodeSystem("2.999").build()));

	}

	@Test
	public void testEqualsAddContainsMappingName() {

		ValueSetEntry valueSetEntryA = new ValueSetEntry();
		ValueSetEntry valueSetEntryB = new ValueSetEntry();

		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		String mappingName1 = "mapping-name-1";

		valueSetEntryA.addMappingName(mappingName1);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addMappingName(mappingName1);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		String mappingName2 = "mapping-name-2";

		valueSetEntryA.addMappingName(mappingName2);
		assertFalse(valueSetEntryA.equals(valueSetEntryB));
		assertFalse(valueSetEntryB.equals(valueSetEntryA));

		valueSetEntryB.addMappingName(mappingName2);
		assertTrue(valueSetEntryA.equals(valueSetEntryB));
		assertTrue(valueSetEntryB.equals(valueSetEntryA));

		assertTrue(valueSetEntryA.containsMappingName("mapping-name-1"));
		assertTrue(valueSetEntryA.getMappingNameList().contains("mapping-name-1"));

	}
}
