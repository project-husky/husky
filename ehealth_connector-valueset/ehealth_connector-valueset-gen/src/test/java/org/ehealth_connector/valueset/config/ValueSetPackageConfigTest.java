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
package org.ehealth_connector.valueset.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.valueset.enums.SourceFormatType;
import org.ehealth_connector.valueset.enums.SourceSystemType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;

/**
 * The Test Class for ValueSetPackageConfig.
 */
public class ValueSetPackageConfigTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		// Basic ValueSetPackageConfig elements tests
		LocalDateTime validFrom = DateUtil.localDateTime("03.06.2019 00:00:00");

		String description = "description";
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.withExtension("myExt").build();
		ValueSetPackageStatus status = ValueSetPackageStatus.ACTIVE;
		Version version = Version.builder().withLabel("1.0").withValidFrom(validFrom).build();
		URL sourceUrl = null;
		try {
			sourceUrl = new URL("http://foo.bar");
		} catch (MalformedURLException e) {
			fail("sourceUrl: MalformedURLException");
		}
		String sourceUrlString = "http://foo.bar/string";

		ValueSetPackageConfig valueSetPackageConfig = ValueSetPackageConfig.builder()
				.withDescription(description).withIdentificator(identificator)
				.withSourceUrl(sourceUrl).withStatus(status).withVersion(version).build();

		assertEquals(description, valueSetPackageConfig.getDescription());
		assertEquals(identificator, valueSetPackageConfig.getIdentificator());
		assertEquals(status, valueSetPackageConfig.getStatus());
		assertEquals(version, valueSetPackageConfig.getVersion());
		assertEquals(sourceUrl, valueSetPackageConfig.getSourceUrl());

		try {
			valueSetPackageConfig.setSourceUrlString(sourceUrlString);
		} catch (MalformedURLException e) {
			fail("sourceUrl: MalformedURLException");
		}
		assertEquals(sourceUrlString, valueSetPackageConfig.getSourceUrlString());

		// Testing List of ValueSetConfigs
		String className1 = "className1";
		String projectFolder1 = "//projectFolder1";
		SourceFormatType sourceFormatType1 = SourceFormatType.JSON;
		SourceSystemType sourceSystemType1 = SourceSystemType.ARTDECOR_FHIR;
		URL sourceUrl1 = null;
		try {
			sourceUrl1 = new URL("http://foo.bar1");
		} catch (MalformedURLException e) {
			fail("sourceUrl1: MalformedURLException");
		}

		ValueSetConfig valueSetConfig1 = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder1).withSourceFormatType(sourceFormatType1)
				.withSourceSystemType(sourceSystemType1).withSourceUrl(sourceUrl1).build();

		String className2 = "className2";
		String projectFolder2 = "//projectFolder2";
		SourceFormatType sourceFormatType2 = SourceFormatType.IHESVS;
		SourceSystemType sourceSystemType2 = SourceSystemType.ARTDECOR_FHIR;
		URL sourceUrl2 = null;
		try {
			sourceUrl2 = new URL("http://foo.bar2");
		} catch (MalformedURLException e) {
			fail("sourceUrl2: MalformedURLException");
		}

		ValueSetConfig valueSetConfig2 = ValueSetConfig.builder().withClassName(className2)
				.withProjectFolder(projectFolder2).withSourceFormatType(sourceFormatType2)
				.withSourceSystemType(sourceSystemType2).withSourceUrl(sourceUrl2).build();

		valueSetPackageConfig.addValueSetConfig(valueSetConfig1);
		valueSetPackageConfig.addValueSetConfig(valueSetConfig2);

		assertEquals(2, valueSetPackageConfig.listValueSetConfigs().size());
		assertEquals(className2, valueSetPackageConfig.listValueSetConfigs().get(1).getClassName());
		assertEquals(projectFolder2,
				valueSetPackageConfig.listValueSetConfigs().get(1).getProjectFolder());
		assertEquals(sourceFormatType2,
				valueSetPackageConfig.listValueSetConfigs().get(1).getSourceFormatType());
		assertEquals(sourceSystemType2,
				valueSetPackageConfig.listValueSetConfigs().get(1).getSourceSystemType());
		assertEquals(sourceUrl2, valueSetPackageConfig.listValueSetConfigs().get(1).getSourceUrl());

	}
}
