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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.common.basetypes.CodeBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;
import org.ehealth_connector.valueset.enums.ValueSetEntryType;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.exceptions.InitializationException;
import org.ehealth_connector.valueset.model.ValueSet;
import org.ehealth_connector.valueset.model.ValueSetEntry;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * The Test Class for ValueSetManager.
 */
public class ValueSetManagerTest {

	/** The test value set config file. */
	private File testValueSetConfigFile = new File(Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSetConfig.yaml");

	/** The test value set yaml file. */
	private File testValueSetYamlFile = new File(Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSet.yaml");

	@Test
	public void downloadRawTest() {
		String testUrl = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json&id=2.16.756.5.30.1.127.3.10.1";
		try {
			String downloadedString = IOUtils.toString(new URL(testUrl),
					ValueSetManager.UTF8_ENCODING);
			ValueSetManager valueSetManager = new ValueSetManager();
			ValueSetConfig valueSetConfig = ValueSetConfig.builder()
					.withSourceSystemType(SourceSystemType.ARTDECOR_FHIR).withSourceUrl(testUrl)
					.build();
			byte[] downloadedByteArray = valueSetManager.downloadValueSetRaw(valueSetConfig);
			String byteArrayString = new String(downloadedByteArray, Charsets.UTF_8);
			assertEquals(downloadedString, byteArrayString);

		} catch (MalformedURLException e) {
			fail("downloadRawTest: MalformedURLException");
		} catch (IOException e) {
			fail("downloadRawTest: IOException");
		}
	}

	@Test
	public void downloadValueSetTest() {
		String baseUrlJson = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json";
		String baseUrlIheSvs = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=svs";
		String baseUrlXml = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=xml";

		String projectFolder = "file://"
				+ "C:\\src\\git\\eHC_VS\\common\\ehealth_connector-common-ch\\src\\main\\java\\org\\ehealth_connector\\common\\ch\\enums";

		SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;

		String className1 = "AuthorRole";
		IdentificatorBaseType authorRoleId = IdentificatorBaseType.builder()
				.withRoot("2.16.756.5.30.1.127.3.10.1.1.3").build();
		Date authorRoleTimeStamp = DateUtil.parseDateyyyyMMddTHHmmss("2018-06-13T07:40:11");
		URL authorRoleSourceUrlJson;
		String authorRoleSourceUrlJsonString = "";
		try {
			authorRoleSourceUrlJson = ValueSetManager.buildValueSetArtDecorUrl(baseUrlJson,
					authorRoleId, authorRoleTimeStamp);
			authorRoleSourceUrlJsonString = authorRoleSourceUrlJson.toString();
		} catch (MalformedURLException e) {
			fail("createValueSetPackageConfig2: authorRoleSourceUrlJson: MalformedURLException");
		}

		ValueSetConfig valueSetConfigJson = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.JSON)
				.withSourceSystemType(sourceSystemType).withSourceUrl(authorRoleSourceUrlJsonString)
				.build();

		URL authorRoleSourceUrlIheSvs;
		String authorRoleSourceUrlIheSvsString = "";
		try {
			authorRoleSourceUrlIheSvs = ValueSetManager.buildValueSetArtDecorUrl(baseUrlIheSvs,
					authorRoleId, authorRoleTimeStamp);
			authorRoleSourceUrlIheSvsString = authorRoleSourceUrlIheSvs.toString();
		} catch (MalformedURLException e) {
			fail("createValueSetPackageConfig2: authorRoleSourceUrlIheSvs: MalformedURLException");
		}

		// System.out.println("authorRoleSourceUrlIheSvsString = " +
		// authorRoleSourceUrlIheSvsString);

		ValueSetConfig valueSetConfigIheSvs = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.IHESVS)
				.withSourceSystemType(sourceSystemType)
				.withSourceUrl(authorRoleSourceUrlIheSvsString).build();

		URL authorRoleSourceUrlXml;
		String authorRoleSourceUrlXmlString = "";
		try {
			authorRoleSourceUrlXml = ValueSetManager.buildValueSetArtDecorUrl(baseUrlXml,
					authorRoleId, authorRoleTimeStamp);
			authorRoleSourceUrlXmlString = authorRoleSourceUrlXml.toString();
		} catch (MalformedURLException e) {
			fail("createValueSetPackageConfig2: authorRoleSourceUrlXml: MalformedURLException");
		}

		// System.out.println("authorRoleSourceUrlXmlString = " +
		// authorRoleSourceUrlXmlString);

		ValueSetConfig valueSetConfigXml = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.XML)
				.withSourceSystemType(sourceSystemType).withSourceUrl(authorRoleSourceUrlXmlString)
				.build();

		ValueSetManager valueSetManager = new ValueSetManager();
		try {
			ValueSet valueSetJson = valueSetManager.downloadValueSet(valueSetConfigJson);
			ValueSet valueSetIheSvs = valueSetManager.downloadValueSet(valueSetConfigIheSvs);
			ValueSet valueSetXml = valueSetManager.downloadValueSet(valueSetConfigXml);

			// 1. Compare Json and IHE SVS

			// This is for debugging purposes, only:
			// valueSetManager.saveValueSet(valueSetJson,
			// "/temp/valueSetJson.json");
			// valueSetManager.saveValueSet(valueSetIheSvs,
			// "/temp/valueSetIheSvs.xml");
			// valueSetManager.saveValueSet(valueSetXml,
			// "/temp/valueSetXml.xml");

			assertTrue(valueSetJson.getIdentificator().equals(valueSetIheSvs.getIdentificator()));
			assertEquals(valueSetJson.getDisplayName(), valueSetIheSvs.getDisplayName());
			// cannot be tested, as this information is not available in the
			// IHE SVS format:
			// assertEquals(valueSetJson.getName(), valueSetIheSvs.getName());
			assertEquals(valueSetJson.getStatus(), valueSetIheSvs.getStatus());
			assertTrue(valueSetJson.getVersion().equals(valueSetIheSvs.getVersion()));

			// IHE SVS does only provide Purpose (which is loaded as English
			// description)
			assertTrue(valueSetJson.getDescription(LanguageCode.ENGLISH)
					.equals(valueSetIheSvs.getDescription(LanguageCode.ENGLISH)));

			for (ValueSetEntry vse : valueSetJson.listValueSetEntries()) {
				ValueSetEntry obj = valueSetIheSvs.getValueSetEntryByCode(vse.getCodeBaseType());
				assertEquals(vse.getDesignationList().size(), obj.getDesignationList().size());
				assertEquals(vse.getLevel(), obj.getLevel());
				// cannot be tested, as this information is not available in the
				// IHE SVS format:
				// assertEquals(vse.getValueSetEntryType(),
				// obj.getValueSetEntryType());
			}

			// 2. Compare Json and XML

			assertTrue(valueSetJson.getIdentificator().equals(valueSetXml.getIdentificator()));
			assertEquals(valueSetJson.getDisplayName(), valueSetXml.getDisplayName());
			// cannot be tested, as this information is not available in the
			// XML format:
			assertEquals(valueSetJson.getName(), valueSetXml.getName());
			assertEquals(valueSetJson.getStatus(), valueSetXml.getStatus());
			assertTrue(valueSetJson.getVersion().equals(valueSetXml.getVersion()));

			for (LangText jsonDesc : valueSetJson.listDescriptions()) {
				String xmlDesc = valueSetXml.getDescription(jsonDesc.getLangCode());
				assertTrue(jsonDesc.getLangText().equals(xmlDesc));
			}

			for (ValueSetEntry vse : valueSetJson.listValueSetEntries()) {
				ValueSetEntry obj = valueSetXml.getValueSetEntryByCode(vse.getCodeBaseType());
				assertEquals(vse.getDesignationList().size(), obj.getDesignationList().size());
				assertEquals(vse.getLevel(), obj.getLevel());
				// cannot be tested, as this information is not available in the
				// XML format:
				assertEquals(vse.getValueSetEntryType(), obj.getValueSetEntryType());
			}

		} catch (IOException e) {
			fail("downloadValueSetJsonTest: IOException");
		} catch (ParserConfigurationException e) {
			fail("downloadValueSetJsonTest: ParserConfigurationException");
		} catch (SAXException e) {
			fail("downloadValueSetJsonTest: SAXException");
		} catch (InitializationException e) {
			fail("downloadValueSetJsonTest: InitializationException");
		}

	}

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

		// Prepare cleanup after test
		testValueSetConfigFile.deleteOnExit();

		try {
			valueSetManager.saveValueSetConfig(valueSetConfig, testValueSetConfigFile);
		} catch (IOException e) {
			fail("saveLoadTest: IOException");
		}

		// load the saved config
		ValueSetManager valueSetManager2 = new ValueSetManager();
		try {
			ValueSetConfig valueSetConfig2 = valueSetManager2
					.loadValueSetConfig(testValueSetConfigFile);

			assertEquals(className, valueSetConfig2.getClassName());
			assertEquals(projectFolder, valueSetConfig2.getProjectFolder());
			assertEquals(sourceFormatType, valueSetConfig2.getSourceFormatType());
			assertEquals(sourceSystemType, valueSetConfig2.getSourceSystemType());
			assertEquals(sourceUrl, valueSetConfig2.getSourceUrl());

		} catch (FileNotFoundException e) {
			fail("saveLoadTest: FileNotFoundException");
		}

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
		ValueSetStatus status = ValueSetStatus.FINAL;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.date("22.06.2019 00:00:00")).build();

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

		// Prepare cleanup after test
		testValueSetYamlFile.deleteOnExit();

		try {
			valueSetManager.saveValueSet(valueSet, testValueSetYamlFile);
		} catch (IOException e) {
			fail("saveLoadTest: IOException");
		}

		// load the saved Value Set
		ValueSetManager valueSetManager2 = new ValueSetManager();
		try {
			ValueSet valueSet2 = valueSetManager2.loadValueSetYaml(testValueSetYamlFile);

			assertEquals(description, valueSet2.getDescription(LanguageCode.ENGLISH));
			assertEquals(valueSetEntry1.getCodeBaseType().getCode(),
					valueSet2.listValueSetEntries().get(0).getCodeBaseType().getCode());
			assertEquals("bbb", valueSet2.listMappingIdentificators().get(1).getExtension());
			assertEquals(mappingName1, valueSet2.listMappingNames().get(0));

		} catch (FileNotFoundException e) {
			fail("saveLoadTest: FileNotFoundException");
		}

	}

}
