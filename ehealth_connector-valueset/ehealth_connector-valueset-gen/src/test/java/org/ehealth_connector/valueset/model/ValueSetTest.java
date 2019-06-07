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

import java.util.Date;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
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
		Date effectiveDate = DateUtil.date("06.06.2019");
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("1").build();
		String name = "myValueSetName";
		ValueSetStatus status = ValueSetStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.localDateTime("03.06.2019 00:00:00")).build();

		ValueSet valueSet = ValueSet.builder().withDescription(description)
				.withDisplayName(displayName).withEffectiveDate(effectiveDate)
				.withIdentificator(identificator).withName(name).withStatus(status)
				.withVersion(version).build();

		assertEquals(description, valueSet.getDescription());
		assertEquals(displayName, valueSet.getDisplayName());
		assertEquals(effectiveDate, valueSet.getEffectiveDate());
		assertEquals(identificator, valueSet.getIdentificator());
		assertEquals(name, valueSet.getName());
		assertEquals(status, valueSet.getStatus());
		assertEquals(version, valueSet.getVersion());

		// ValueSetEntry tests
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

		valueSet.addValueSetEntry(valueSetEntry1);
		valueSet.addValueSetEntry(valueSetEntry2);
		valueSet.addValueSetEntry(valueSetEntry3);

		assertEquals(valueSetEntry2, valueSet.listValueSetEntries().get(1));
		assertEquals(3, valueSet.listValueSetEntries().size());

		// ValueSet mapping Identificator tests
		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId1").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myId2").build();

		valueSet.addMappingIdentificator(mappingId1);
		valueSet.addMappingIdentificator(mappingId2);

		assertEquals(mappingId1, valueSet.listMappingIdentificators().get(0));
		assertEquals(2, valueSet.listMappingIdentificators().size());

		// ValueSet mapping names tests
		String mappingName1 = "mappingName1";
		String mappingName2 = "mappingName2";
		String mappingName3 = "mappingName3";
		String mappingName4 = "mappingName4";

		valueSet.addMappingName(mappingName1);
		valueSet.addMappingName(mappingName2);
		valueSet.addMappingName(mappingName3);
		valueSet.addMappingName(mappingName4);

		assertEquals(mappingName2, valueSet.listMappingNames().get(1));
		assertEquals(4, valueSet.listMappingNames().size());

	}

}
