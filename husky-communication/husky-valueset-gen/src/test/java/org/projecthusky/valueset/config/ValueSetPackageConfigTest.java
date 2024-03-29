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
package org.projecthusky.valueset.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.utils.DateUtil;
import org.projecthusky.valueset.enums.SourceFormatType;
import org.projecthusky.valueset.enums.SourceSystemType;
import org.projecthusky.valueset.enums.ValueSetPackageStatus;
import org.projecthusky.valueset.model.Version;
import org.junit.jupiter.api.Test;

/**
 * The Test Class for ValueSetPackageConfig.
 */
class ValueSetPackageConfigTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		// Basic ValueSetPackageConfig elements tests
		Date validFrom = DateUtil.parseDateyyyyMMddHHmmss("20190603000000");

		String description = "description";
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myExt").build();
		ValueSetPackageStatus status = ValueSetPackageStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0").withValidFrom(validFrom).build();
		String sourceUrl = "http://foo.bar";

		ValueSetPackageConfig valueSetPackageConfig = ValueSetPackageConfig.builder()
				.withDescription(description).withIdentificator(identificator)
				.withSourceUrl(sourceUrl).withStatus(status).withVersion(version).build();

		assertEquals(description, valueSetPackageConfig.getDescription());
		assertEquals(identificator, valueSetPackageConfig.getIdentificator());
		assertEquals(status, valueSetPackageConfig.getStatus());
		assertEquals(version, valueSetPackageConfig.getVersion());
		assertEquals(sourceUrl, valueSetPackageConfig.getSourceUrl());

		// Testing List of ValueSetConfigs
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
		SourceFormatType sourceFormatType2 = SourceFormatType.IHESVS;
		SourceSystemType sourceSystemType2 = SourceSystemType.ARTDECOR_FHIR;
		String sourceUrl2 = "http://foo.bar2";

		ValueSetConfig valueSetConfig2 = ValueSetConfig.builder().withClassName(className2)
				.withProjectFolder(projectFolder2).withSourceFormatType(sourceFormatType2)
				.withSourceSystemType(sourceSystemType2).withSourceUrl(sourceUrl2).build();

		valueSetPackageConfig.addValueSetConfig(valueSetConfig1);
		valueSetPackageConfig.addValueSetConfig(valueSetConfig2);

		assertEquals(2, valueSetPackageConfig.getValueSetConfigList().size());
		assertEquals(className2,
				valueSetPackageConfig.getValueSetConfigList().get(1).getClassName());
		assertEquals(projectFolder2,
				valueSetPackageConfig.getValueSetConfigList().get(1).getProjectFolder());
		assertEquals(sourceFormatType2,
				valueSetPackageConfig.getValueSetConfigList().get(1).getSourceFormatType());
		assertEquals(sourceSystemType2,
				valueSetPackageConfig.getValueSetConfigList().get(1).getSourceSystemType());

	}

	/**
	 * Test method for {@link ValueSetPackageConfig#getValueSetConfigList()}.
	 */
	@Test
	void testGetValueSetConfigList() {

		ValueSetPackageConfig config = new ValueSetPackageConfig();
		assertNotNull(config.getValueSetConfigList());

		ValueSetPackageConfig configBuild = ValueSetPackageConfig.builder().build();
		assertNotNull(configBuild.getValueSetConfigList());

	}

}
