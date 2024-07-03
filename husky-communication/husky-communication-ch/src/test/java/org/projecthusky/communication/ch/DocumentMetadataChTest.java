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
package org.projecthusky.communication.ch;


import org.projecthusky.common.ch.enums.stable.ConfidentialityCode;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.communication.ch.enums.stable.*;
import org.projecthusky.communication.testhelper.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DocumentMetadataChTest extends TestUtils {

	DocumentMetadataCh m = new DocumentMetadataCh();

	@Test
	void testClassCodeEnum() {
		m.setClassCode(ClassCode.CARE_PLAN);
		assertTrue(isEqual(ClassCode.CARE_PLAN.getCode(), m.getClassCodeEnum().getCode()));
	}

	@Test
	void testCodedLanguageEnum() {
		m.setCodedLanguage(LanguageCode.FRENCH);
		assertEquals(LanguageCode.FRENCH, m.getLanguageCodeEnum());
	}

	@Test
	void testConfidentialityCodeEnum() {
		m.addConfidentialityCode(ConfidentialityCode.NORMAL);
		assertTrue(isEqual(ConfidentialityCode.NORMAL.getCode(),
				m.getConfidentialityCodesEnum().get(0).getCode()));
	}

	@Test
	void testHealthcareFacilityEnum() {
		m.setHealthcareFacilityTypeCode(HealthcareFacilityTypeCode.AMBULATORY_CARE_SITE);
		assertEquals(HealthcareFacilityTypeCode.AMBULATORY_CARE_SITE,
				m.getHealthcareFacilityTypeCodeEnum());
	}

	@Test
	void testMimeTypeEnum() {
		m.setMimeType(MimeType.CDA_LEVEL_1_MULTIPART);
		assertEquals(MimeType.CDA_LEVEL_1_MULTIPART.getCodeValue(), m.getMimeType());
	}

	@Test
	void testPracticeSettingEnum() {
		m.setPracticeSettingCode(PracticeSettingCode.CLINICAL_IMMUNOLOGY_ALLERGY);
		assertEquals(PracticeSettingCode.CLINICAL_IMMUNOLOGY_ALLERGY,
				m.getPracticeSettingCodeEnum());
	}

	@Test
	void testTypeCodeEnum() {
		m.setTypeCode(TypeCode.DISCHARGE_SUMMARY);
		assertEquals(TypeCode.DISCHARGE_SUMMARY, m.getTypeCodeEnum());
	}
}
