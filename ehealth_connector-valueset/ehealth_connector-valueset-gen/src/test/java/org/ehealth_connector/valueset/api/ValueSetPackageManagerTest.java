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

import java.io.IOException;
import java.util.Date;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;

/**
 * The Test Class for ValueSetPackageManager.
 */
public class ValueSetPackageManagerTest {

	private String testValueSetPackageConfigFileName = Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSetPackageConfig.yaml";

	private ValueSetPackageConfig createValueSetPackageConfig() {
		ValueSetPackageConfig retVal = null;
		String sourceUrl;
		sourceUrl = "file://" + testValueSetPackageConfigFileName;
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

	@Test
	public void dateMissingTest() {
		// TODO: Timestamp in validFrom nicht vorhanden -> ungültig
	}

	@Test
	public void dateOnlyTest() {
		// TODO: Timestamp in validFrom/To nur tagesganau
	}

	@Test
	public void saveLoadTest() {

		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();
		try {

			// Save a config
			ValueSetPackageConfig valueSetPackageConfig1 = createValueSetPackageConfig();
			assertNotNull(valueSetPackageConfig1);
			valueSetPackageManager.saveValueSetPackageConfig(valueSetPackageConfig1,
					testValueSetPackageConfigFileName);

			// load the saved config
			ValueSetPackageManager valueSetPackageManager2 = new ValueSetPackageManager();
			valueSetPackageManager2.loadValueSetPackageConfig(testValueSetPackageConfigFileName);
			ValueSetPackageConfig valueSetPackageConfig2 = valueSetPackageManager2
					.getLatestValueSetPackageConfig();

			assertEquals(valueSetPackageConfig1.getDescription(),
					valueSetPackageConfig2.getDescription());
			assertTrue(valueSetPackageConfig1.getIdentificator()
					.equals(valueSetPackageConfig2.getIdentificator()));
			assertTrue(valueSetPackageConfig1.getSourceUrl()
					.equals(valueSetPackageConfig2.getSourceUrl()));
			assertEquals(valueSetPackageConfig1.getStatus(), valueSetPackageConfig2.getStatus());
			assertTrue(valueSetPackageConfig1.getVersion()
					.equals(valueSetPackageConfig2.getVersion()));

		} catch (IOException e) {
			fail("saveLoadTest: IOException");
		}

		// TODO delete file in order to clean up the building system
	}

}
