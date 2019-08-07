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
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.junit.Test;

/**
 * The Test Class for ValueSet.
 */
public class ValueSetTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		// Basic ValueSet elements tests
		String description = "description";
		String displayName = "displayName";
		Date effectiveDate = DateUtilMdht.date("06.06.2019");
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("1").build();
		String name = "myValueSetName";
		ValueSetStatus status = ValueSetStatus.FINAL;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtilMdht.date("03.06.2019 00:00:00")).build();

		ValueSet valueSet1 = ValueSet.builder().withDisplayName(displayName)
				.withEffectiveDate(effectiveDate).withIdentificator(identificator).withName(name)
				.withStatus(status).withVersion(version).build();
		ValueSet valueSet2 = ValueSet.builder().withDisplayName(displayName)
				.withEffectiveDate(effectiveDate).withIdentificator(identificator).withName(name)
				.withStatus(status).withVersion(version).build();

		assertEquals(valueSet1.hashCode(), valueSet2.hashCode());
		assertTrue(valueSet1.equals(valueSet2));

		valueSet1.addDescription(new LangText(LanguageCode.ENGLISH, description));
		assertEquals(description, valueSet1.getDescription(LanguageCode.ENGLISH));

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

		assertEquals(valueSetEntry2, valueSet1.listValueSetEntries().get(1));
		assertEquals(3, valueSet1.listValueSetEntries().size());

		// ValueSet mapping Identificator tests
		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId1").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId2").build();

		valueSet1.addMappingIdentificator(mappingId1);
		valueSet1.addMappingIdentificator(mappingId2);

		assertEquals(mappingId1, valueSet1.listMappingIdentificators().get(0));
		assertEquals(2, valueSet1.listMappingIdentificators().size());

		// ValueSet mapping names tests
		String mappingName1 = "mappingName1";
		String mappingName2 = "mappingName2";
		String mappingName3 = "mappingName3";
		String mappingName4 = "mappingName4";

		valueSet1.addMappingName(mappingName1);
		valueSet1.addMappingName(mappingName2);
		valueSet1.addMappingName(mappingName3);
		valueSet1.addMappingName(mappingName4);

		assertEquals(mappingName2, valueSet1.listMappingNames().get(1));
		assertEquals(4, valueSet1.listMappingNames().size());

		assertTrue(valueSetEntry1
				.equals(valueSet1.getValueSetEntryByMappingName(defaultMappingName1)));
		assertTrue(valueSetEntry2.equals(valueSet1.getValueSetEntryByMappingCode(mappingCode2)));
	}

}
