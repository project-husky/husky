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
package org.ehealth_connector.codegenerator.ch.valuesets.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ValueSetConfigurationTest {

	@Test
	public void testValueSetConfiguration() {

		String baseUrl = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json";
		final String id = "2.16.756.5.30.1.127.3.10.1.1.3";
		final String projectFolder = "ehealthconnector/ehealth_connector-common/ehealth_connector-common-ch";
		final String className = "org.ehealth_connector.common.ch.enums.AuthorRole";
		final String effectiveDate = "2018-01-31T14:06:48";
		final String codeSystemName = "epd_xds_authorRole";

		ValueSetConfiguration configuration = new ValueSetConfiguration();
		configuration.setBaseUrl(baseUrl);

		ValueSet valueSet = new ValueSet();
		valueSet.setId(id);
		valueSet.setProjectFolder(projectFolder);
		valueSet.setClassName(className);
		valueSet.setEffectiveDate(effectiveDate);
		valueSet.setCodeSystemName(codeSystemName);
		configuration.setValueSets(Arrays.asList(valueSet));

		assertEquals(baseUrl, configuration.getBaseUrl());
		assertEquals(id, configuration.getValueSets().get(0).getId());
		assertEquals(projectFolder, configuration.getValueSets().get(0).getProjectFolder());
		assertEquals(className, configuration.getValueSets().get(0).getClassName());
		assertEquals(effectiveDate, configuration.getValueSets().get(0).getEffectiveDate());
		assertEquals(codeSystemName, configuration.getValueSets().get(0).getCodeSystemName());

	}

}
