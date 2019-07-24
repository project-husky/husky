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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.enums.ValueSetStatus;
import org.ehealth_connector.valueset.exceptions.ConfigurationException;
import org.ehealth_connector.valueset.model.ValueSet;
import org.ehealth_connector.valueset.model.ValueSetPackage;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;

/**
 * The Test Class for ValueSetPackageManager.
 */
public class ValueSetPackageManagerTest {

	private String testValueSetPackageConfigOnTheWeb = "https://medshare.net/fileadmin/downloads/ehc/testValueSetPackageConfig.yaml";
	private File testValueSetPackageConfigFile = new File(Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSetPackageConfig.yaml");
	private File testValueSetPackageFile = new File(Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSetPackage.yaml");

	private ValueSetPackageConfig createValueSetPackageConfig1() {
		ValueSetPackageConfig retVal = null;
		String sourceUrl;
		sourceUrl = "file://" + testValueSetPackageConfigFile;
		Date validFrom = DateUtil.date("11.06.2019 00:00:00");

		Version version = Version.builder().withLabel("0.9").withValidFrom(validFrom).build();
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.build();
		retVal = ValueSetPackageConfig.builder()
				.withDescription("This is a test package configuration")
				.withIdentificator(identificator).withSourceUrl(sourceUrl)
				.withStatus(ValueSetPackageStatus.ACTIVE).withVersion(version).build();

		String className1 = "className1";
		String projectFolder1 = "//projectFolder1";
		SourceFormatType sourceFormatType1 = SourceFormatType.JSON;
		SourceSystemType sourceSystemType1 = SourceSystemType.ARTDECOR_FHIR;
		String sourceUrl1 = "http://foo.bar1";

		ValueSetConfig valueSetConfig1 = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder1).withSourceFormatType(sourceFormatType1)
				.withSourceSystemType(sourceSystemType1).withSourceUrl(sourceUrl1).build();

		String className2 = "className2";
		String projectFolder2 = "//projectFolder2";
		SourceFormatType sourceFormatType2 = SourceFormatType.XML;
		SourceSystemType sourceSystemType2 = SourceSystemType.ARTDECOR_FHIR;
		String sourceUrl2 = "http://foo.bar2";

		ValueSetConfig valueSetConfig2 = ValueSetConfig.builder().withClassName(className2)
				.withProjectFolder(projectFolder2).withSourceFormatType(sourceFormatType2)
				.withSourceSystemType(sourceSystemType2).withSourceUrl(sourceUrl2).build();

		retVal.addValueSetConfig(valueSetConfig1);
		retVal.addValueSetConfig(valueSetConfig2);

		return retVal;
	}

	/**
	 * Creates the value set package config 2. This is for debug purposes, only.
	 * Run this method in downloadSaveLoadTestConfig and upload it to the
	 * desired web server, in case you need to have a new version oof the file
	 * or to have it on another server.
	 *
	 * @return the value set package config
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("unused")
	private ValueSetPackageConfig createValueSetPackageConfig2() throws MalformedURLException {
		ValueSetPackageConfig retVal = null;
		String sourceUrl;
		String baseUrl = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json";
		OrganizationBaseType org = new OrganizationBaseType();
		org.setPrimaryName("eHealthConnector Unit Test");

		sourceUrl = testValueSetPackageConfigOnTheWeb;
		Date validFrom = DateUtil.date("23.06.2019 00:00:00");

		Version version = Version.builder().withLabel("1.0").withValidFrom(validFrom)
				.withPublishingAuthority(org).build();
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.build();
		retVal = ValueSetPackageConfig.builder()
				.withDescription("This is a test package configuration, hosted on the web")
				.withIdentificator(identificator).withSourceUrl(sourceUrl)
				.withStatus(ValueSetPackageStatus.ACTIVE).withVersion(version).build();

		String projectFolder = "file://"
				+ "C:\\src\\git\\eHC_VS\\common\\ehealth_connector-common-ch\\src\\main\\java\\org\\ehealth_connector\\common\\ch\\enums";
		SourceFormatType sourceFormatType = SourceFormatType.JSON;
		SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;

		String className1 = "AuthorRole";
		IdentificatorBaseType authorRoleId = IdentificatorBaseType.builder()
				.withRoot("2.16.756.5.30.1.127.3.10.1.1.3").build();
		Date authorRoleTimeStamp = DateUtil.parseDateyyyyMMddTHHmmss("2018-06-13T07:40:11");
		URL authorRoleSourceUrl;
		String authorRoleSourceUrlString = "";

		authorRoleSourceUrl = ValueSetManager.buildValueSetArtDecorUrl(baseUrl, authorRoleId,
				authorRoleTimeStamp);
		authorRoleSourceUrlString = authorRoleSourceUrl.toString();

		ValueSetConfig valueSetConfig1 = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(sourceFormatType)
				.withSourceSystemType(sourceSystemType).withSourceUrl(authorRoleSourceUrlString)
				.build();

		String className2 = "EprDocumentAvailabilityStatus";
		IdentificatorBaseType documentAvailabilityStatusId = IdentificatorBaseType.builder()
				.withRoot("2.16.756.5.30.1.127.3.10.1.2").build();
		Date documentAvailabilityStatusTimeStamp = DateUtil
				.parseDateyyyyMMddTHHmmss("2018-06-13T07:48:02");
		URL documentAvailabilityStatusSourceUrl;
		String documentAvailabilityStatusSourceUrlString = "";

		documentAvailabilityStatusSourceUrl = ValueSetManager.buildValueSetArtDecorUrl(baseUrl,
				documentAvailabilityStatusId, documentAvailabilityStatusTimeStamp);
		documentAvailabilityStatusSourceUrlString = documentAvailabilityStatusSourceUrl.toString();

		ValueSetConfig valueSetConfig2 = ValueSetConfig.builder().withClassName(className2)
				.withProjectFolder(projectFolder).withSourceFormatType(sourceFormatType)
				.withSourceSystemType(sourceSystemType)
				.withSourceUrl(documentAvailabilityStatusSourceUrlString).build();

		retVal.addValueSetConfig(valueSetConfig1);
		retVal.addValueSetConfig(valueSetConfig2);

		return retVal;
	}

	@Test
	public void dateMissingTest() {
		// Timestamp in validFrom does not exist -> invalid
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();
		try {

			// load the prepared config
			final URL test1Url = new URL(this.getClass()
					.getResource("/ValueSetPackageConfig_FromDateMissing.yaml").toString());
			final File testFile = new File(URLDecoder.decode(test1Url.getPath(), "UTF-8"));
			valueSetPackageManager.loadValueSetPackageConfig(testFile);
			fail("dateMissingTest: This configuration must not load, because it does not contaion a validFrom timestamp");
		} catch (IOException e) {
			fail("dateMissingTest: IOException");
		} catch (ConfigurationException e) {
			// All ok here.
			// This configuration must not load, because it does
			// not contain a validFrom timestamp
		}
	}

	@Test
	public void downloadSaveLoadPackageConfigTest()
			throws MalformedURLException, IOException, ConfigurationException {

		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();

		// Debug only: This is to save a config for upload to a web server:
		// ValueSetPackageConfig valueSetPackageConfig2 =
		// createValueSetPackageConfig2();
		// assertNotNull(valueSetPackageConfig2);
		// valueSetPackageManager.saveValueSetPackageConfig(valueSetPackageConfig2,
		// testValueSetPackageConfigFileName);

		// download and save a package config
		ValueSetPackageConfig valueSetPackageConfig1 = valueSetPackageManager
				.downloadValueSetPackageConfig(testValueSetPackageConfigOnTheWeb);

		assertEquals(testValueSetPackageConfigOnTheWeb, valueSetPackageConfig1.getSourceUrl());

		// Prepare cleanup
		testValueSetPackageConfigFile.deleteOnExit();

		valueSetPackageManager.saveValueSetPackageConfig(valueSetPackageConfig1,
				testValueSetPackageConfigFile);
		ValueSetPackageConfig valueSetPackageConfig2 = valueSetPackageManager
				.loadValueSetPackageConfig(testValueSetPackageConfigFile);

		assertEquals(valueSetPackageConfig1.getDescription(),
				valueSetPackageConfig2.getDescription());
		assertEquals(valueSetPackageConfig1.getVersion().getLabel(),
				valueSetPackageConfig2.getVersion().getLabel());
		assertEquals(valueSetPackageConfig1.getValueSetConfigList().size(),
				valueSetPackageConfig2.getValueSetConfigList().size());

	}

	@Test
	public void getLatestValueSetPackageConfigByStatusTest() throws MalformedURLException,
			UnsupportedEncodingException, FileNotFoundException, ConfigurationException {
		ValueSetPackageManager valueSetPackageManager = loadPackageConfigs();
		ValueSetPackageConfig valueSetPackageConfig;

		valueSetPackageConfig = valueSetPackageManager
				.getLatestValueSetPackageConfigByStatus(ValueSetPackageStatus.ACTIVE);
		assertEquals("0.7-active", valueSetPackageConfig.getVersion().getLabel());

		valueSetPackageConfig = valueSetPackageManager
				.getLatestValueSetPackageConfigByStatus(ValueSetPackageStatus.RETIRED);
		assertEquals("0.6-retired", valueSetPackageConfig.getVersion().getLabel());

		valueSetPackageConfig = valueSetPackageManager
				.getLatestValueSetPackageConfigByStatus(ValueSetPackageStatus.DRAFT);
		assertEquals("0.9-draft", valueSetPackageConfig.getVersion().getLabel());

		valueSetPackageConfig = valueSetPackageManager
				.getLatestValueSetPackageConfigByStatus(ValueSetPackageStatus.UNKNOWN);
		assertEquals("0.10-unknown", valueSetPackageConfig.getVersion().getLabel());
	}

	@Test
	public void getLatestValueSetPackageConfigTest() throws MalformedURLException,
			UnsupportedEncodingException, FileNotFoundException, ConfigurationException {
		ValueSetPackageManager valueSetPackageManager = loadPackageConfigs();
		ValueSetPackageConfig valueSetPackageConfig = valueSetPackageManager
				.getLatestValueSetPackageConfig();

		assertEquals("0.7-active", valueSetPackageConfig.getVersion().getLabel());
	}

	@Test
	public void getValueSetPackageConfigByStatusAndDateTest() throws MalformedURLException,
			UnsupportedEncodingException, FileNotFoundException, ConfigurationException {
		ValueSetPackageManager valueSetPackageManager = loadPackageConfigs();
		ValueSetPackageConfig valueSetPackageConfig;

		valueSetPackageConfig = valueSetPackageManager.getValueSetPackageConfigByStatusAndDate(
				ValueSetPackageStatus.ACTIVE, DateUtil.date("11.06.2019"));
		assertEquals("0.8-active", valueSetPackageConfig.getVersion().getLabel());

		valueSetPackageConfig = valueSetPackageManager.getValueSetPackageConfigByStatusAndDate(
				ValueSetPackageStatus.ACTIVE, DateUtil.date("31.12.2021"));
		assertEquals("0.7-active", valueSetPackageConfig.getVersion().getLabel());

	}

	public ValueSetPackageManager loadPackageConfigs() throws MalformedURLException,
			UnsupportedEncodingException, FileNotFoundException, ConfigurationException {
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();

		// load the prepared config
		final URL test1Url = new URL(
				this.getClass().getResource("/ValueSetPackageConfig1.yaml").toString());
		final File testFile1 = new File(URLDecoder.decode(test1Url.getPath(), "UTF-8"));
		valueSetPackageManager.loadValueSetPackageConfig(testFile1);

		final URL test2Url = new URL(
				this.getClass().getResource("/ValueSetPackageConfig2.yaml").toString());
		final File testFile2 = new File(URLDecoder.decode(test2Url.getPath(), "UTF-8"));
		valueSetPackageManager.loadValueSetPackageConfig(testFile2);

		final URL test3Url = new URL(
				this.getClass().getResource("/ValueSetPackageConfig3.yaml").toString());
		final File testFile3 = new File(URLDecoder.decode(test3Url.getPath(), "UTF-8"));
		valueSetPackageManager.loadValueSetPackageConfig(testFile3);

		final URL test4Url = new URL(
				this.getClass().getResource("/ValueSetPackageConfig4.yaml").toString());
		final File testFile4 = new File(URLDecoder.decode(test4Url.getPath(), "UTF-8"));
		valueSetPackageManager.loadValueSetPackageConfig(testFile4);

		final URL test5Url = new URL(
				this.getClass().getResource("/ValueSetPackageConfig5.yaml").toString());
		final File testFile5 = new File(URLDecoder.decode(test5Url.getPath(), "UTF-8"));
		valueSetPackageManager.loadValueSetPackageConfig(testFile5);

		return valueSetPackageManager;

	}

	@Test
	public void saveLoadTestConfig() throws IOException, ConfigurationException {

		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();

		// Save a config
		ValueSetPackageConfig valueSetPackageConfig1 = createValueSetPackageConfig1();
		assertNotNull(valueSetPackageConfig1);
		valueSetPackageManager.saveValueSetPackageConfig(valueSetPackageConfig1,
				testValueSetPackageConfigFile);

		// Prepare cleanup
		testValueSetPackageConfigFile.deleteOnExit();

		// load the saved config
		ValueSetPackageManager valueSetPackageManager2 = new ValueSetPackageManager();
		valueSetPackageManager2.loadValueSetPackageConfig(testValueSetPackageConfigFile);
		ValueSetPackageConfig valueSetPackageConfig2 = valueSetPackageManager2
				.getLatestValueSetPackageConfig();

		assertEquals(valueSetPackageConfig1.getDescription(),
				valueSetPackageConfig2.getDescription());
		assertTrue(valueSetPackageConfig1.getIdentificator()
				.equals(valueSetPackageConfig2.getIdentificator()));
		assertTrue(valueSetPackageConfig1.getSourceUrl()
				.equals(valueSetPackageConfig2.getSourceUrl()));
		assertEquals(valueSetPackageConfig1.getStatus(), valueSetPackageConfig2.getStatus());
		assertTrue(valueSetPackageConfig1.getVersion().equals(valueSetPackageConfig2.getVersion()));

	}

	@Test
	public void saveLoadTestPackage() throws IOException {
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();

		// Save a package
		String description = "descriptionTest";
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myPackageId").build();
		String sourceUrl = "http://foo.bar";
		ValueSetPackageStatus status = ValueSetPackageStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.date("03.06.2019 00:00:00")).build();

		ValueSetPackage valueSetPackage = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();

		String description1 = "description1";
		String displayName1 = "displayName1";
		Date effectiveDate1 = DateUtil.date("11.06.2019");
		IdentificatorBaseType identificator1 = IdentificatorBaseType.builder().withRoot("2.999.1")
				.withExtension("1").build();
		String name1 = "myValueSetName1";
		ValueSetStatus status1 = ValueSetStatus.FINAL;
		Version version1 = Version.builder().withLabel("1.1")
				.withValidFrom(DateUtil.date("01.06.2019 00:00:00")).build();

		ValueSet valueSet1 = ValueSet.builder().withDisplayName(displayName1)
				.withEffectiveDate(effectiveDate1).withIdentificator(identificator1).withName(name1)
				.withStatus(status1).withVersion(version1).build();
		valueSet1.addDescription(new LangText(LanguageCode.ENGLISH, description1));

		String description2 = "description2";
		String displayName2 = "displayName2";
		Date effectiveDate2 = DateUtil.date("12.06.2019");
		IdentificatorBaseType identificator2 = IdentificatorBaseType.builder().withRoot("2.999.2")
				.withExtension("2").build();
		String name2 = "myValueSetName2";
		ValueSetStatus status2 = ValueSetStatus.FINAL;
		Version version2 = Version.builder().withLabel("1.2")
				.withValidFrom(DateUtil.date("02.06.2019 00:00:00")).build();

		ValueSet valueSet2 = ValueSet.builder().withDisplayName(displayName2)
				.withEffectiveDate(effectiveDate2).withIdentificator(identificator2).withName(name2)
				.withStatus(status2).withVersion(version2).build();
		valueSet2.addDescription(new LangText(LanguageCode.ENGLISH, description2));

		valueSetPackage.addValueSet(valueSet1);
		valueSetPackage.addValueSet(valueSet2);

		IdentificatorBaseType mappingId1 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("AAA").build();
		IdentificatorBaseType mappingId2 = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("BBB").build();

		valueSetPackage.addMappingIdentificator(mappingId1);
		valueSetPackage.addMappingIdentificator(mappingId2);

		String mappingName1 = "mappingName1";
		String mappingName2 = "mappingName2";

		valueSetPackage.addMappingName(mappingName1);
		valueSetPackage.addMappingName(mappingName2);

		// Prepare cleanup
		testValueSetPackageFile.deleteOnExit();

		valueSetPackageManager.saveValueSetPackage(valueSetPackage, testValueSetPackageFile);

		// load the saved package
		ValueSetPackageManager valueSetPackageManager2 = new ValueSetPackageManager();
		ValueSetPackage valueSetPackage2 = valueSetPackageManager2
				.loadValueSetPackage(testValueSetPackageFile);

		assertEquals(description, valueSetPackage2.getDescription());
		assertEquals(valueSet2.getName(), valueSetPackage2.listValueSets().get(1).getName());
		assertEquals("BBB", valueSetPackage2.listMappingIdentificators().get(1).getExtension());
		assertEquals(mappingName1, valueSetPackage2.listMappingNames().get(0));

	}

	@Test
	public void versionMissingTest() {
		// Timestamp in validFrom nicht vorhanden -> ungültig
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();
		try {

			// load the prepared config
			final URL test1Url = new URL(this.getClass()
					.getResource("/ValueSetPackageConfig_VersionMissing.yaml").toString());
			final File testFile = new File(URLDecoder.decode(test1Url.getPath(), "UTF-8"));
			valueSetPackageManager.loadValueSetPackageConfig(testFile);
			fail("dateMissingTest: This configuration must not load, because it does not contain a version element");
		} catch (IOException e) {
			fail("versionMissingTest: IOException");
		} catch (ConfigurationException e) {
			// All ok here.
			// This configuration must not load, because it does
			// not contain a version element
		}
	}
}
