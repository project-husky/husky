/*
 *
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
package org.ehealth_connector.codegenerator.ch.valuesets;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.ehealth_connector.codegenerator.ch.valuesets.model.ValueSet;
import org.junit.Test;

public class ValueSetUtilTest {

	@Test
	public void testBuildEnumName() {

		assertEquals("HOSPITAL", ValueSetUtil.buildEnumName("Hospital"));

		assertEquals("LABORATORY_SERVICE", ValueSetUtil.buildEnumName("Laboratory service"));

		assertEquals("ANY_TEXT_AND_ANY_TEXT",
				ValueSetUtil.buildEnumName("Any text &amp; any text"));

		assertEquals("ACCIDENT_AND_EMERGENCY",
				ValueSetUtil.buildEnumName("Accident &amp; emergency"));

		assertEquals("CLIENT_OR_PATIENT_HOME",
				ValueSetUtil.buildEnumName("Client's or patient's home"));

	}

	@Test
	public void testBuildValueSetUrl() throws MalformedURLException {

		final String baseUrl = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=json";

		ValueSet valueSet = new ValueSet();
		valueSet.setId("2.16.756.5.30.1.127.3.10.1.1.3");
		valueSet.setEffectiveDate("2018-01-31T14:06:48");

		URL expectedUrl = new URL(baseUrl
				+ "&id=2.16.756.5.30.1.127.3.10.1.1.3&effectiveDate=2018-01-31T14%3A06%3A48");

		assertEquals(expectedUrl, ValueSetUtil.buildValueSetUrl(baseUrl, valueSet));
		
	}

}
