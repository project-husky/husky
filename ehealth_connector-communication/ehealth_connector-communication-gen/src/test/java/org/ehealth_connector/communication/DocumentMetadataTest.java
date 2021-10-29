/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.ehealth_connector.common.communication.DocumentMetadata;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.model.Code;
import org.ehealth_connector.common.model.Identificator;
import org.ehealth_connector.common.model.Patient;
import org.ehealth_connector.communication.testhelper.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;

public class DocumentMetadataTest extends TestUtils {

	private DocumentMetadata d = new DocumentMetadata();
	private LocalizedString l;
	private DocumentEntry m = d.getDocumentEntry();

	@BeforeEach
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
		loincCode = new Code("2.16.840.1.113883.6.1", numS1, null);
	}

	@Test
	void testAuthor() {
		author1 = createAuthor1();
		d.addAuthor(author1);
		assertTrue(isEqual(author1, d.getAuthors().get(0)));
	}

	@Test
	void testClassCode() {
		final Code cc = new Code("DEMO-Consult", "1.3.6.1.4.1.21367.100.1", "Consultation");
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
		l = m.getClassCode().getDisplayName();
		assertEquals("Consultation", l.getValue());
		assertTrue(isEqual(cc, d.getClassCode()));
	}

	@Test
	void testCodedLanguage() {
		d.setCodedLanguage(LanguageCode.GERMAN_CODE); // Can be extracted from
		// CDA
		assertEquals(LanguageCode.GERMAN_CODE, m.getLanguageCode());
	}

	@Test
	void testCreationTime() {
		startDate = createStartDate();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssXXX");
		System.out.println(sdf.format(startDate));
		System.out.println(ZonedDateTime.parse(sdf.format(startDate),
				DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.systemDefault())));

		d.setCreationTime(ZonedDateTime.parse(sdf.format(startDate),
				DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.systemDefault())));

		assertEquals(sdf.format(startDate),
				d.getCreationTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME.withZone(ZoneId.systemDefault())));
	}

	@Test
	void testFormatCode() {
		final Code fc = new Code("urn:ihe:iti:xds-sd:pdf:2008", "1.3.6.1.4.1.19376.1.2.3",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)");
		d.setFormatCode(fc); // Can be
		// extracted
		// from CDA
		assertEquals("1.3.6.1.4.1.19376.1.2.3", m.getFormatCode().getSchemeName());
		assertEquals("urn:ihe:iti:xds-sd:pdf:2008", m.getFormatCode().getCode());
		l = m.getFormatCode().getDisplayName();
		assertEquals("1.3.6.1.4.1.19376.1.2.20 (Scanned Document)", l.getValue());
		assertTrue(isEqual(fc, d.getFormatCode()));
	}

	@Test
	void testHealthcareFacilityTypeCode() {
		final Code hftc = new Code("AMB", "2.16.840.1.113883.5.11", "Ambulance");
		d.setHealthcareFacilityTypeCode(hftc); // The
		// codes
		// here
		// are
		// specific
		// for
		// the
		// affinity domain
		assertEquals("2.16.840.1.113883.5.11", m.getHealthcareFacilityTypeCode().getSchemeName());
		assertEquals("AMB", m.getHealthcareFacilityTypeCode().getCode());
		l = m.getHealthcareFacilityTypeCode().getDisplayName();
		assertEquals("Ambulance", l.getValue());
		assertTrue(isEqual(hftc, d.getHealthcareFacilityTypeCode()));
	}

	@Test
	void testMimeType() {
		numS1 = generateString(128);
		d.setMimeType(numS1);
		assertEquals(numS1, d.getMimeType());
	}

	@Test
	void testPatient() {
		final Patient p = createPatient();
		d.setPatient(p);
		assertTrue(isEqual(p, d.getPatient()));
	}

	@Test
	void testPatientId() {
		final Identificator id = new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000",
				"b8a9a9ad17b5429");
		d.setDestinationPatientId(id); // Can
		// be
		// extracted
		// from
		// CDA
		assertEquals("1.3.6.1.4.1.21367.2005.13.20.3000",
				m.getPatientId().getAssigningAuthority().getUniversalId());
		assertEquals("b8a9a9ad17b5429", m.getPatientId().getId());
		assertTrue(isEqual(id, d.getPatientId()));
	}

	@Test
	void testPracticeSettingCode() {
		final Code psc = new Code("394802001", "2.16.840.1.113883.6.96", "General Medicine");
		d.setPracticeSettingCode(psc); // The
		// codes
		// here
		// are
		// specific for the affinity
		// domain
		assertEquals("2.16.840.1.113883.6.96", m.getPracticeSettingCode().getSchemeName());
		assertEquals("394802001", m.getPracticeSettingCode().getCode());
		l = m.getPracticeSettingCode().getDisplayName();
		assertEquals("General Medicine", l.getValue());
		assertTrue(isEqual(psc, d.getPracticeSettingCode()));
	}

	@Test
	void testSourcePatientId() {
		id1 = createIdentificator1();
		d.setSourcePatientId(id1);
		assertTrue(isEqual(id1, d.getSourcePatientId()));
	}

	@Test
	void testTitle() {
		d.setTitle(numS1);
		assertEquals(numS1, d.getTitle());
	}

	@Test
	void testTypeCode() {
		final Code tc = new Code("34133-9", "2.16.840.1.113883.6.1", 
				"Summarization of Episode Note");
		d.setTypeCode(tc); // Can
		// be
		// extracted
		// from
		// CDA
		assertEquals("2.16.840.1.113883.6.1", m.getTypeCode().getSchemeName());
		assertEquals("34133-9", m.getTypeCode().getCode());
		l = m.getTypeCode().getDisplayName();
		assertEquals("Summarization of Episode Note", l.getValue());
		assertTrue(isEqual(tc, d.getTypeCode()));
	}

	@Test
	void testUniqueId() {
		d.setUniqueId(numS2);
		assertEquals(numS2, d.getUniqueId());
	}
}
