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
package org.husky.valueset.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.husky.valueset.config.ValueSetConfig;
import org.husky.valueset.enums.SourceFormatType;
import org.husky.valueset.enums.SourceSystemType;
import org.junit.jupiter.api.Test;

/**
 * The Test Class for ValueSetConfig.
 */
class ValueSetConfigTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

		// Basic ValueSetConfig elements tests
		String className = "className";
		String projectFolder = "//projectFolder";
		SourceFormatType sourceFormatType = SourceFormatType.JSON;
		SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;
		String sourceUrl = "http://foo.bar";

		ValueSetConfig valueSetConfig = ValueSetConfig.builder().withClassName(className)
				.withProjectFolder(projectFolder).withSourceFormatType(sourceFormatType)
				.withSourceSystemType(sourceSystemType).withSourceUrl(sourceUrl).build();

		assertEquals(className, valueSetConfig.getClassName());
		assertEquals(projectFolder, valueSetConfig.getProjectFolder());
		assertEquals(sourceFormatType, valueSetConfig.getSourceFormatType());
		assertEquals(sourceSystemType, valueSetConfig.getSourceSystemType());
		assertEquals(sourceUrl, valueSetConfig.getSourceUrl());

	}
}
