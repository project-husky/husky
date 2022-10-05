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
package org.projecthusky.valueset.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;

import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.DateUtil;
import org.projecthusky.common.utils.LangText;
import org.projecthusky.common.utils.Util;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.config.ValueSetPackageConfig;
import org.projecthusky.valueset.enums.SourceFormatType;
import org.projecthusky.valueset.enums.SourceSystemType;
import org.projecthusky.valueset.enums.ValueSetPackageStatus;
import org.projecthusky.valueset.enums.ValueSetStatus;
import org.projecthusky.valueset.exceptions.ConfigurationException;
import org.projecthusky.valueset.model.ValueSet;
import org.projecthusky.valueset.model.ValueSetPackage;
import org.projecthusky.valueset.model.Version;
import org.junit.jupiter.api.Test;

/**
 * The Test Class for ValueSetPackageManager.
 */
class ValueSetPackageManagerTest {

	private String testValueSetPackageConfigOnTheWeb = "https://medshare.net/fileadmin/downloads/ehc/testValueSetPackageConfig.yaml";
	private File testValueSetPackageConfigFile = new File(Util.getTempDirectory()
			+ "/testValueSetPackageConfig.yaml");
	private File testValueSetPackageFile = new File(Util.getTempDirectory()
			+ "/testValueSetPackage.yaml");

	private ValueSetPackageConfig createValueSetPackageConfig1() {
		ValueSetPackageConfig retVal = null;
		String sourceUrl;
		sourceUrl = "file://" + testValueSetPackageConfigFile;
		Date validFrom = DateUtil.parseDateyyyyMMddHHmmss("20190611000000");

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
		org.setPrimaryName(NameBaseType.builder().withName("Husky Unit Test").build());

		sourceUrl = testValueSetPackageConfigOnTheWeb;
		Date validFrom = DateUtil.parseDateyyyyMMddHHmmss("20190623000000");

		Version version = Version.builder().withLabel("1.0").withValidFrom(validFrom)
				.withPublishingAuthority(org).build();
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.build();
		retVal = ValueSetPackageConfig.builder()
				.withDescription("This is a test package configuration, hosted on the web")
				.withIdentificator(identificator).withSourceUrl(sourceUrl)
				.withStatus(ValueSetPackageStatus.ACTIVE).withVersion(version).build();

		String projectFolder = Util.getCurrentDirectory()
				+ "../../common/husky-common-ch/src/main/java/org/husky/common/ch/enums";
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
	void dateMissingTest() throws IOException {
		// Timestamp in validFrom does not exist -> invalid
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();
		try {

			// load the prepared config
			final URL test1Url = new URL(this.getClass()
					.getResource("/ValueSetPackageConfig_FromDateMissing.yaml").toString());
			final File testFile = new File(URLDecoder.decode(test1Url.getPath(), "UTF-8"));
			valueSetPackageManager.loadValueSetPackageConfig(testFile);
			fail("dateMissingTest: This configuration must not load, because it does not contaion a validFrom timestamp");
		} catch (ConfigurationException e) {
			// All ok here.
			// This configuration must not load, because it does
			// not contain a validFrom timestamp
		}
	}

	@Test
	void getLatestValueSetPackageConfigByStatusTest()
			throws ConfigurationException, IOException {
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
	void getLatestValueSetPackageConfigTest() throws ConfigurationException, IOException {
		ValueSetPackageManager valueSetPackageManager = loadPackageConfigs();
		ValueSetPackageConfig valueSetPackageConfig = valueSetPackageManager
				.getLatestValueSetPackageConfig();

		assertEquals("0.7-active", valueSetPackageConfig.getVersion().getLabel());
	}

	@Test
	void getValueSetPackageConfigByStatusAndDateTest()
			throws ConfigurationException, IOException {
		ValueSetPackageManager valueSetPackageManager = loadPackageConfigs();
		ValueSetPackageConfig valueSetPackageConfig;

		valueSetPackageConfig = valueSetPackageManager.getValueSetPackageConfigByStatusAndDate(
				ValueSetPackageStatus.ACTIVE, DateUtil.parseDateyyyyMMdd("20190611"));
		assertEquals("0.8-active", valueSetPackageConfig.getVersion().getLabel());

		valueSetPackageConfig = valueSetPackageManager.getValueSetPackageConfigByStatusAndDate(
				ValueSetPackageStatus.ACTIVE, DateUtil.parseDateyyyyMMdd("20211231"));
		assertEquals("0.7-active", valueSetPackageConfig.getVersion().getLabel());

	}

	public ValueSetPackageManager loadPackageConfigs() throws ConfigurationException, IOException {
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
	void saveLoadTestConfig() throws IOException, ConfigurationException {

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
		assertEquals(valueSetPackageConfig1.getIdentificator(), valueSetPackageConfig2.getIdentificator());
		assertEquals(valueSetPackageConfig1.getSourceUrl(), valueSetPackageConfig2.getSourceUrl());
		assertEquals(valueSetPackageConfig1.getStatus(), valueSetPackageConfig2.getStatus());
		assertEquals(valueSetPackageConfig1.getVersion(), valueSetPackageConfig2.getVersion());

	}

	@Test
	void saveLoadTestPackage() throws IOException {
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();

		// Save a package
		String description = "descriptionTest";
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myPackageId").build();
		String sourceUrl = "http://foo.bar";
		ValueSetPackageStatus status = ValueSetPackageStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190603000000")).build();

		ValueSetPackage valueSetPackage = ValueSetPackage.builder().withDescription(description)
				.withIdentificator(identificator).withSourceUrl(sourceUrl).withStatus(status)
				.withVersion(version).build();

		String description1 = "description1";
		String displayName1 = "displayName1";
		Date effectiveDate1 = DateUtil.parseDateyyyyMMdd("20190611");
		IdentificatorBaseType identificator1 = IdentificatorBaseType.builder().withRoot("2.999.1")
				.withExtension("1").build();
		String name1 = "myValueSetName1";
		ValueSetStatus status1 = ValueSetStatus.FINAL;
		Version version1 = Version.builder().withLabel("1.1")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190601000000")).build();

		ValueSet valueSet1 = ValueSet.builder().withDisplayName(displayName1)
				.withEffectiveDate(effectiveDate1).withIdentificator(identificator1).withName(name1)
				.withStatus(status1).withVersion(version1).build();
		valueSet1.addDescription(new LangText(LanguageCode.ENGLISH, description1));

		String description2 = "description2";
		String displayName2 = "displayName2";
		Date effectiveDate2 = DateUtil.parseDateyyyyMMdd("20190612");
		IdentificatorBaseType identificator2 = IdentificatorBaseType.builder().withRoot("2.999.2")
				.withExtension("2").build();
		String name2 = "myValueSetName2";
		ValueSetStatus status2 = ValueSetStatus.FINAL;
		Version version2 = Version.builder().withLabel("1.2")
				.withValidFrom(DateUtil.parseDateyyyyMMddHHmmss("20190602000000")).build();

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
		assertEquals(valueSet2.getName(), valueSetPackage2.getValueSetList().get(1).getName());
		assertEquals("BBB", valueSetPackage2.getMappingIdentificatorList().get(1).getExtension());
		assertEquals(mappingName1, valueSetPackage2.getMappingNameList().get(0));

	}

	@Test
	void versionMissingTest() throws IOException {
		// Timestamp in validFrom nicht vorhanden -> ungültig
		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();
		try {

			// load the prepared config
			final URL test1Url = new URL(this.getClass()
					.getResource("/ValueSetPackageConfig_VersionMissing.yaml").toString());
			final File testFile = new File(URLDecoder.decode(test1Url.getPath(), "UTF-8"));
			valueSetPackageManager.loadValueSetPackageConfig(testFile);
			fail("dateMissingTest: This configuration must not load, because it does not contain a version element");
		} catch (ConfigurationException e) {
			// All ok here.
			// This configuration must not load, because it does
			// not contain a version element
		}
	}
}
