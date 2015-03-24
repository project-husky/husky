/*******************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 License.
*
* Year of publication: 2015
*
*******************************************************************************/

package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;

import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.tests.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;

public class DocumentMetadataTest extends TestUtils {

	DocumentMetadata d = new DocumentMetadata();
	DocumentEntryType m = d.getMdhtDocumentEntryType();
	LocalizedStringType l;

	@Before
	public void initTestData() {
		// Test String with German, French and Italic special characters
		ts1 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		numS1 = "1231425352";
		numS2 = "987653";
		number = 121241241.212323;

		// Convenience API Types
		code1 = createCode1();
		code2 = createCode2();
		loincCode = new Code("2.16.840.1.113883.6.1", numS1);
	}

	@Test
	public void testClassCode() {
		d.setClassCode(new Code("1.3.6.1.4.1.21367.100.1", "DEMO-Consult",
				"Consultation")); // Just for the NIST-Repository: This code
		// should also be optional, but the NIST
		// repository prevents an automatic
		// derivation from the typeCode
		assertEquals("1.3.6.1.4.1.21367.100.1", m.getClassCode()
				.getSchemeName());
		assertEquals("DEMO-Consult", m.getClassCode().getCode());
		l = (LocalizedStringType) m.getClassCode().getDisplayName()
				.getLocalizedString().get(0);
		assertEquals("Consultation", l.getValue());
	}

	@Test
	public void testCodedLanguage() {
		d.setCodedLanguage(LanguageCode.GERMAN); // Can be extracted from CDA
		assertEquals(LanguageCode.GERMAN_CODE, m.getLanguageCode());
	}

	@Test
	public void testFormatCode() {
		d.setFormatCode(new Code("1.3.6.1.4.1.19376.1.2.3",
				"urn:ihe:iti:xds-sd:pdf:2008",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)")); // Can be
		// extracted
		// from CDA
		assertEquals("1.3.6.1.4.1.19376.1.2.3", m.getFormatCode()
				.getSchemeName());
		assertEquals("urn:ihe:iti:xds-sd:pdf:2008", m.getFormatCode().getCode());
		l = (LocalizedStringType) m.getFormatCode().getDisplayName()
				.getLocalizedString().get(0);
		assertEquals("1.3.6.1.4.1.19376.1.2.20 (Scanned Document)",
				l.getValue());
	}

	@Test
	public void testHealthcareFacilityTypeCode() {
		d.setHealthcareFacilityTypeCode(new Code("2.16.840.1.113883.5.11",
				"AMB", "Ambulance")); // The codes here are specific for the
		// affinity domain
		assertEquals("2.16.840.1.113883.5.11", m
				.getHealthCareFacilityTypeCode().getSchemeName());
		assertEquals("AMB", m.getHealthCareFacilityTypeCode().getCode());
		l = (LocalizedStringType) m.getHealthCareFacilityTypeCode()
				.getDisplayName().getLocalizedString().get(0);
		assertEquals("Ambulance", l.getValue());
	}

	@Test
	public void testPatientId() {
		d.setPatientId(new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000",
				"b8a9a9ad17b5429")); // Can be extracted from CDA
		assertEquals("1.3.6.1.4.1.21367.2005.13.20.3000", m.getPatientId()
				.getAssigningAuthorityUniversalId());
		assertEquals("b8a9a9ad17b5429", m.getPatientId().getIdNumber());
	}

	@Test
	public void testPracticeSettingCode() {
		d.setPracticeSettingCode(new Code("2.16.840.1.113883.6.96",
				"394802001", "General Medicine")); // The codes here are
		// specific for the affinity
		// domain
		assertEquals("2.16.840.1.113883.6.96", m.getPracticeSettingCode()
				.getSchemeName());
		assertEquals("394802001", m.getPracticeSettingCode().getCode());
		l = (LocalizedStringType) m.getPracticeSettingCode().getDisplayName()
				.getLocalizedString().get(0);
		assertEquals("General Medicine", l.getValue());
	}

	@Test
	public void testTypeCode() {
		d.setTypeCode(new Code("2.16.840.1.113883.6.1", "34133-9",
				"Summarization of Episode Note")); // Can be extracted from CDA
		assertEquals("2.16.840.1.113883.6.1", m.getTypeCode().getSchemeName());
		assertEquals("34133-9", m.getTypeCode().getCode());
		l = (LocalizedStringType) m.getTypeCode().getDisplayName()
				.getLocalizedString().get(0);
		assertEquals("Summarization of Episode Note", l.getValue());
	}
}
