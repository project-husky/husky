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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
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
		URL sourceUrl;
		try {
			sourceUrl = new URL("file://" + testValueSetPackageConfigFileName);
			LocalDateTime validFrom = DateUtil.localDateTime("11.06.2019 00:00:00");

			Version version = Version.builder().withLabel("0.9").withValidFrom(validFrom).build();
			IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
					.build();
			retVal = ValueSetPackageConfig.builder()
					.withDescription("This is a test package configuration")
					.withIdentificator(identificator).withSourceUrl(sourceUrl)
					.withStatus(ValueSetPackageStatus.ACTIVE).withVersion(version).build();
		} catch (MalformedURLException e) {
			// Do nothing
		}
		return retVal;
	}

	@Test
	public void saveLoadTest() {

		ValueSetPackageManager valueSetPackageManager = new ValueSetPackageManager();
		try {
			ValueSetPackageConfig valueSetPackageConfig = createValueSetPackageConfig();
			assertNotNull(valueSetPackageConfig);
			valueSetPackageManager.saveValueSetPackageConfig(valueSetPackageConfig,
					testValueSetPackageConfigFileName);
		} catch (IOException e) {
			fail("saveLoadTest: IOException");
		}

		// TODO delete file in order to clean up the building system
	}
}
