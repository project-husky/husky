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

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.communication.SubmissionSetMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;

class SubmissionSetMetadataTest extends TestUtils {

	private SubmissionSetMetadata s;

	@BeforeEach
	public void initTestData() {
		s = new SubmissionSetMetadata();

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

		author1 = createAuthor1();
		id1 = createIdentificator1();
	}

	@Test
	void testAuthor() {
		s.setAuthor(author1);
		assertTrue(isEqual(author1, s.getAuthor().get(0)));
	}

	@Test
	void testAvailabilityStatus() {
		s.setAvailabilityStatus(AvailabilityStatus.DEPRECATED);
		assertEquals(AvailabilityStatus.DEPRECATED, s.getAvailabilityStatus());
	}

	@Test
	void testComments() {
		s.setComments(ts1);
		assertEquals(ts1, s.getComments());
	}

	@Test
	void testContentType() {
		s.setContentTypeCode(code1);
		assertTrue(isEqual(code1, s.getContentTypeCode()));
	}

	@Test
	void testPatientId() {
		s.setDestinationPatientId(id1);
		assertTrue(isEqual(id1, s.getPatientId()));
	}

	@Test
	void testSourceId() {
		s.setSourceId(numS2);
		assertEquals(numS2, s.getSourceId());
	}

	@Test
	void testTitle() {
		s.setTitle(ts2);
		assertEquals(ts2, s.getTitle());
	}

}
