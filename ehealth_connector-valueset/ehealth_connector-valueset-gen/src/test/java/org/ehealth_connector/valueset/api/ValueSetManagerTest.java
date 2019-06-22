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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.model.ValueSet;
import org.ehealth_connector.valueset.model.ValueSetEntry;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;

/**
 * The Test Class for ValueSetManager.
 */
public class ValueSetManagerTest {

	/** The test value set config file name. */
	private String testValueSetConfigFileName = Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSetConfig.yaml";

	/** The test value set yaml file name. */
	private String testValueSetYamlFileName = Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSet.yaml";

	/**
	 * Save load value set config test.
	 */
	@Test
	public void saveLoadValueSetConfigTest() {
		ValueSetManager valueSetManager = new ValueSetManager();

		String className = "className";
		String projectFolder = "//projectFolder";
		SourceFormatType sourceFormatType = SourceFormatType.JSON;
		SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;
		String sourceUrl = "http://foo.bar";

		ValueSetConfig valueSetConfig = ValueSetConfig.builder().withClassName(className)
				.withProjectFolder(projectFolder).withSourceFormatType(sourceFormatType)
				.withSourceSystemType(sourceSystemType).withSourceUrl(sourceUrl).build();
		try {
			valueSetManager.saveValueSetConfig(valueSetConfig, testValueSetConfigFileName);
		} catch (IOException e) {
			fail("saveLoadTest: IOException");
		}

		// load the saved config
		ValueSetManager valueSetManager2 = new ValueSetManager();
		try {
			ValueSetConfig valueSetConfig2 = valueSetManager2
					.loadValueSetConfig(testValueSetConfigFileName);

			assertEquals(className, valueSetConfig2.getClassName());
			assertEquals(projectFolder, valueSetConfig2.getProjectFolder());
			assertEquals(sourceFormatType, valueSetConfig2.getSourceFormatType());
			assertEquals(sourceSystemType, valueSetConfig2.getSourceSystemType());
			assertEquals(sourceUrl, valueSetConfig2.getSourceUrl());

		} catch (FileNotFoundException e) {
			fail("saveLoadTest: FileNotFoundException");
		}

	}

	@Test
	public void saveLoadValueSetJsonTest() {
		// TODO
	}

	/**
	 * Save load value set yaml test.
	 */
	@Test
	public void saveLoadValueSetYamlTest() {
		ValueSetManager valueSetManager = new ValueSetManager();

		// Save a ValueSet
		String description = "description";
		String displayName = "displayName";
		Date effectiveDate = DateUtil.date("11.06.2019");
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999.1")
				.withExtension("1").build();
		String name = "myValueSetName";
		ValueSetStatus status = ValueSetStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.date("22.06.2019 00:00:00")).build();

		ValueSet valueSet = ValueSet.builder().withDescription(description)
				.withDisplayName(displayName).withEffectiveDate(effectiveDate)
				.withIdentificator(identificator).withName(name).withStatus(status)
				.withVersion(version).build();

		CodeBaseType codeBaseType1 = CodeBaseType.builder().withCode("abstractcode1")
				.withCodeSystem("2.999.1").build();
		String defaultMappingName1 = "defaultMappingNameAbstract1";
		int level1 = 1;
		ValueSetEntryType valueSetEntryType1 = ValueSetEntryType.ABSTRACT;

		ValueSetEntry valueSetEntry1 = ValueSetEntry.builder().withCodeBaseType(codeBaseType1)
				.withDefaultMappingName(defaultMappingName1).withLevel(level1)
				.withValueSetEntryType(valueSetEntryType1).build();

		CodeBaseType codeBaseType2 = CodeBaseType.builder().withCode("leafcode2")
				.withCodeSystem("2.999.2").build();
		String defaultMappingName2 = "defaultMappingNameAbstract2";
		int level2 = 2;
		ValueSetEntryType valueSetEntryType2 = ValueSetEntryType.LEAF;

		ValueSetEntry valueSetEntry2 = ValueSetEntry.builder().withCodeBaseType(codeBaseType2)
				.withDefaultMappingName(defaultMappingName2).withLevel(level1)
				.withValueSetEntryType(valueSetEntryType2).build();

		valueSet.addValueSetEntry(valueSetEntry1);
		valueSet.addValueSetEntry(valueSetEntry2);

		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("aaa").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("bbb").build();

		valueSet.addMappingIdentificator(mappingId1);
		valueSet.addMappingIdentificator(mappingId2);

		String mappingName1 = "mappingName1";
		String mappingName2 = "mappingName2";

		valueSet.addMappingName(mappingName1);
		valueSet.addMappingName(mappingName2);

		try {
			valueSetManager.saveValueSet(valueSet, testValueSetYamlFileName);
		} catch (IOException e) {
			fail("saveLoadTest: IOException");
		}

		// load the saved Value Set
		ValueSetManager valueSetManager2 = new ValueSetManager();
		try {
			ValueSet valueSet2 = valueSetManager2.loadValueSetYaml(testValueSetYamlFileName);

			assertEquals(description, valueSet2.getDescription());
			assertEquals(valueSetEntry1.getCodeBaseType().getCode(),
					valueSet2.listValueSetEntries().get(0).getCodeBaseType().getCode());
			assertEquals("bbb", valueSet2.listMappingIdentificators().get(1).getExtension());
			assertEquals(mappingName1, valueSet2.listMappingNames().get(0));

		} catch (FileNotFoundException e) {
			fail("saveLoadTest: FileNotFoundException");
		}

	}

}
