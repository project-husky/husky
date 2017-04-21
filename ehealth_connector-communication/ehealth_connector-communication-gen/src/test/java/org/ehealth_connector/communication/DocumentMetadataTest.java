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

package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;

public class DocumentMetadataTest extends TestUtils {

	private DocumentMetadata d = new DocumentMetadata();
	private LocalizedStringType l;
	private DocumentEntryType m = d.getMdhtDocumentEntryType();

	@Before
	public void initTestData() {
		super.init();
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
	public void testAuthor() {
		author1 = createAuthor1();
		d.addAuthor(author1);
		assertTrue(isEqual(author1, d.getAuthors().get(0)));
	}

	@Test
	public void testClassCode() {
		final Code cc = new Code("1.3.6.1.4.1.21367.100.1", "DEMO-Consult", "Consultation");
		d.setClassCode(cc); // Just
		// for
		// the
		// NIST-Repository:
		// This
		// code
		// should also be optional, but the NIST
		// repository prevents an automatic
		// derivation from the typeCode
		assertEquals("1.3.6.1.4.1.21367.100.1", m.getClassCode().getSchemeName());
		assertEquals("DEMO-Consult", m.getClassCode().getCode());
		l = (LocalizedStringType) m.getClassCode().getDisplayName().getLocalizedString().get(0);
		assertEquals("Consultation", l.getValue());
		assertTrue(isEqual(cc, d.getClassCode()));
	}

	@Test
	public void testCodedLanguage() {
		d.setCodedLanguage(LanguageCode.GERMAN_CODE); // Can be extracted from
		// CDA
		assertEquals(LanguageCode.GERMAN_CODE, m.getLanguageCode());
	}

	@Test
	public void testConfidentialityCode() {
		code1 = createCode1();
		d.addConfidentialityCode(code1);
		d.addConfidentialityCode(Confidentiality.CH_30003);
		assertTrue(isEqual(code1, d.getConfidentialityCodes().get(0)));
		assertEquals(Confidentiality.CH_30003.getCodeValue(),
				d.getConfidentialityCodes().get(1).getCode());
	}

	@Test
	public void testCreationTime() {
		startDate = createStartDate();
		d.setCreationTime(startDate);
		assertEquals(startDate.getTime(), d.getCreationTime().getTime());
	}

	@Test
	public void testFormatCode() {
		final Code fc = new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:iti:xds-sd:pdf:2008",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)");
		d.setFormatCode(fc); // Can be
		// extracted
		// from CDA
		assertEquals("1.3.6.1.4.1.19376.1.2.3", m.getFormatCode().getSchemeName());
		assertEquals("urn:ihe:iti:xds-sd:pdf:2008", m.getFormatCode().getCode());
		l = (LocalizedStringType) m.getFormatCode().getDisplayName().getLocalizedString().get(0);
		assertEquals("1.3.6.1.4.1.19376.1.2.20 (Scanned Document)", l.getValue());
		assertTrue(isEqual(fc, d.getFormatCode()));
	}

	@Test
	public void testHealthcareFacilityTypeCode() {
		final Code hftc = new Code("2.16.840.1.113883.5.11", "AMB", "Ambulance");
		d.setHealthcareFacilityTypeCode(hftc); // The
		// codes
		// here
		// are
		// specific
		// for
		// the
		// affinity domain
		assertEquals("2.16.840.1.113883.5.11", m.getHealthCareFacilityTypeCode().getSchemeName());
		assertEquals("AMB", m.getHealthCareFacilityTypeCode().getCode());
		l = (LocalizedStringType) m.getHealthCareFacilityTypeCode().getDisplayName()
				.getLocalizedString().get(0);
		assertEquals("Ambulance", l.getValue());
		assertTrue(isEqual(hftc, d.getHealthcareFacilityTypeCode()));
	}

	@Test
	public void testMimeType() {
		numS1 = generateString(128);
		d.setMimeType(numS1);
		assertEquals(numS1, d.getMimeType());
	}

	@Test
	public void testPatient() {
		final Patient p = createPatient();
		d.setPatient(p);
		assertTrue(isEqual(p, d.getPatient()));
	}

	@Test
	public void testPatientId() {
		final Identificator id = new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000",
				"b8a9a9ad17b5429");
		d.setDestinationPatientId(id); // Can
		// be
		// extracted
		// from
		// CDA
		assertEquals("1.3.6.1.4.1.21367.2005.13.20.3000",
				m.getPatientId().getAssigningAuthorityUniversalId());
		assertEquals("b8a9a9ad17b5429", m.getPatientId().getIdNumber());
		assertTrue(isEqual(id, d.getPatientId()));
	}

	@Test
	public void testPracticeSettingCode() {
		final Code psc = new Code("2.16.840.1.113883.6.96", "394802001", "General Medicine");
		d.setPracticeSettingCode(psc); // The
		// codes
		// here
		// are
		// specific for the affinity
		// domain
		assertEquals("2.16.840.1.113883.6.96", m.getPracticeSettingCode().getSchemeName());
		assertEquals("394802001", m.getPracticeSettingCode().getCode());
		l = (LocalizedStringType) m.getPracticeSettingCode().getDisplayName().getLocalizedString()
				.get(0);
		assertEquals("General Medicine", l.getValue());
		assertTrue(isEqual(psc, d.getPracticeSettingCode()));
	}

	@Test
	public void testSourcePatientId() {
		id1 = createIdentificator1();
		d.setSourcePatientId(id1);
		assertTrue(isEqual(id1, d.getSourcePatientId()));
	}

	@Test
	public void testTitle() {
		d.setTitle(numS1);
		assertEquals(numS1, d.getTitle());
	}

	@Test
	public void testTypeCode() {
		final Code tc = new Code("2.16.840.1.113883.6.1", "34133-9",
				"Summarization of Episode Note");
		d.setTypeCode(tc); // Can
		// be
		// extracted
		// from
		// CDA
		assertEquals("2.16.840.1.113883.6.1", m.getTypeCode().getSchemeName());
		assertEquals("34133-9", m.getTypeCode().getCode());
		l = (LocalizedStringType) m.getTypeCode().getDisplayName().getLocalizedString().get(0);
		assertEquals("Summarization of Episode Note", l.getValue());
		assertTrue(isEqual(tc, d.getTypeCode()));
	}

	@Test
	public void testUniqueId() {
		d.setUniqueId(numS2);
		assertEquals(numS2, d.getUniqueId());
	}
}
