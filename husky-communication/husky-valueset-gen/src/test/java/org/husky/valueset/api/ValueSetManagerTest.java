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
package org.husky.valueset.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.enums.LanguageCode;
import org.husky.common.utils.DateUtil;
import org.husky.common.utils.LangText;
import org.husky.common.utils.Util;
import org.husky.valueset.config.ValueSetConfig;
import org.husky.valueset.enums.SourceFormatType;
import org.husky.valueset.enums.SourceSystemType;
import org.husky.valueset.enums.ValueSetEntryType;
import org.husky.valueset.enums.ValueSetStatus;
import org.husky.valueset.model.ValueSet;
import org.husky.valueset.model.ValueSetEntry;
import org.husky.valueset.model.Version;
import org.junit.jupiter.api.Test;

/**
 * The Test Class for ValueSetManager.
 */
class ValueSetManagerTest {

	/** The test value set config file. */
	private File testValueSetConfigFile = new File(Util.getTempDirectory()
			+ "/testValueSetConfig.yaml");

	/** The test value set yaml file. */
	private File testValueSetYamlFile = new File(Util.getTempDirectory()
			+ "/testValueSet.yaml");

	/**
	 * Save load value set config test.
	 *
	 * @throws IOException
	 */
	@Test
	void saveLoadValueSetConfigTest() throws IOException {
		ValueSetManager valueSetManager = new ValueSetManager();

		String className = "className";
		String projectFolder = "//projectFolder";
		SourceFormatType sourceFormatType = SourceFormatType.JSON;
		SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;
		String sourceUrl = "http://foo.bar";

		ValueSetConfig valueSetConfig = ValueSetConfig.builder().withClassName(className)
				.withProjectFolder(projectFolder).withSourceFormatType(sourceFormatType)
				.withSourceSystemType(sourceSystemType).withSourceUrl(sourceUrl).build();

		// Prepare cleanup after test
		testValueSetConfigFile.deleteOnExit();

		valueSetManager.saveValueSetConfig(valueSetConfig, testValueSetConfigFile);

		// load the saved config
		ValueSetManager valueSetManager2 = new ValueSetManager();
		ValueSetConfig valueSetConfig2 = valueSetManager2
				.loadValueSetConfig(testValueSetConfigFile);

		assertEquals(className, valueSetConfig2.getClassName());
		assertEquals(projectFolder, valueSetConfig2.getProjectFolder());
		assertEquals(sourceFormatType, valueSetConfig2.getSourceFormatType());
		assertEquals(sourceSystemType, valueSetConfig2.getSourceSystemType());
		assertEquals(sourceUrl, valueSetConfig2.getSourceUrl());

	}

	/**
	 * Save load value set yaml test.
	 *
	 * @throws IOException
	 */
	@Test
	void saveLoadValueSetYamlTest() throws IOException {
		ValueSetManager valueSetManager = new ValueSetManager();

		// Save a ValueSet
		String description = "description";
		String displayName = "displayName";
		Date effectiveDate = DateUtil.parseDateyyyyMMdd("20190611");
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999.1")
				.withExtension("1").build();
		String name = "myValueSetName";
		ValueSetStatus status = ValueSetStatus.FINAL;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190622000000")).build();

		ValueSet valueSet = ValueSet.builder().withDisplayName(displayName)
				.withEffectiveDate(effectiveDate).withIdentificator(identificator).withName(name)
				.withStatus(status).withVersion(version).build();
		valueSet.addDescription(new LangText(LanguageCode.ENGLISH, description));

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

		// Prepare cleanup after test
		testValueSetYamlFile.deleteOnExit();

		valueSetManager.saveValueSet(valueSet, testValueSetYamlFile);

		// load the saved Value Set
		ValueSetManager valueSetManager2 = new ValueSetManager();
		ValueSet valueSet2 = valueSetManager2.loadValueSetYaml(testValueSetYamlFile);

		assertEquals(description, valueSet2.getDescription(LanguageCode.ENGLISH));
		assertEquals(valueSetEntry1.getCodeBaseType().getCode(),
				valueSet2.getValueSetEntryList().get(0).getCodeBaseType().getCode());
		assertEquals("bbb", valueSet2.getMappingIdentificatorList().get(1).getExtension());
		assertEquals(mappingName1, valueSet2.getMappingNameList().get(0));
	}

}
