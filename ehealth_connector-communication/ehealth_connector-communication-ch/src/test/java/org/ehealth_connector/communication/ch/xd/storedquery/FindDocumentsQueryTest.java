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
package org.ehealth_connector.communication.ch.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.communication.ch.testhelper.XdsChTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test of class FindDocumentsQuery
 */
public class FindDocumentsQueryTest extends XdsChTestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.ch.xd.storedquery.FindDocumentsQuery#FindDocumentsQuery(org.ehealth_connector.common.Identificator, org.ehealth_connector.communication.ch.enums.ClassCode[], org.ehealth_connector.communication.xd.storedquery.DateTimeRange[], org.ehealth_connector.communication.ch.enums.PracticeSettingCode[], org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode[], org.ehealth_connector.communication.ch.enums.ConfidentialityCode[], org.ehealth_connector.communication.ch.enums.FormatCode[], org.openhealthtools.ihe.common.hl7v2.XCN, org.ehealth_connector.communication.ch.enums.AvailabilityStatus)}
	 * .
	 */
	@Test
	public void testFindDocumentsQueryIdentificatorClassCodeArrayDateTimeRangeArrayPracticeSettingCodeArrayHealthcareFacilityTypeCodeArrayConfidentialityCodeArrayFormatCodeArrayXCNAvailabilityStatus() {
		// Constructor Test
		// Create a query
		final FindDocumentsQuery q = new FindDocumentsQuery(patientId, classCodes, eDateTimeRanges,
				practiceSettingCodes, healthCareFacilityCodes, confidentialityCodes, formatCodes,
				authorPerson, avaiabilityStatus);

		assertTrue(
				q.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery) q.getIpfQuery();

		// Check query parameters

		assertEquals(patientId.getRoot(), sqpl.getPatientId().getAssigningAuthority().getUniversalId());
		assertEquals(patientId.getExtension(), sqpl.getPatientId().getId());
		assertTrue(sqpl.getStatus().stream()
				.anyMatch(t -> t.getQueryOpcode().equalsIgnoreCase(avaiabilityStatus.getCodeValue())));

		assertEquals(DateUtil.formatDateTimeTzon(sqpl.getCreationTime().getFrom().getDateTime()),
				eDateTimeRange1.getFromAsUsFormattedString());

		assertEquals(DateUtil.formatDateTimeTzon(sqpl.getCreationTime().getTo().getDateTime()),
				eDateTimeRange1.getToAsUsFormattedString());

		assertTrue(sqpl.getClassCodes().stream()
				.anyMatch(t -> t != null && t.getCode().equalsIgnoreCase(classCodes[0].getCodeValue())));
		assertTrue(sqpl.getPracticeSettingCodes().stream()
				.anyMatch(t -> t.getCode().equalsIgnoreCase(practiceSettingCodes[0].getCodeValue())));
		assertTrue(sqpl.getHealthcareFacilityTypeCodes().stream()
				.anyMatch(t -> t.getCode().contains(healthCareFacilityCodes[0].getCodeValue())));
		assertTrue(sqpl.getConfidentialityCodes().getOuterList().stream()
				.anyMatch(t -> t.stream()
						.anyMatch(code -> code.getCode().equalsIgnoreCase(confidentialityCodes[1].getCodeValue()))));
		assertTrue(sqpl.getFormatCodes().stream()
				.anyMatch(t -> t.getCode().equalsIgnoreCase(formatCodes[1].getCodeValue())));

		sqpl.getTypedAuthorPersons().stream().forEach(t -> {
			System.out.println(t.getName().toString());
		});

		assertTrue(sqpl.getTypedAuthorPersons().stream()
				.anyMatch(t -> t.getName().getGivenName().equalsIgnoreCase(authorPerson.getName().getGiven())));
		assertTrue(
				sqpl.getTypedAuthorPersons().stream().anyMatch(
						t -> t.getName().getFamilyName().equalsIgnoreCase(authorPerson.getName().getFamily())));
		assertTrue(sqpl.getTypedAuthorPersons().stream()
				.anyMatch(t -> t.getName().getPrefix().equalsIgnoreCase(authorPerson.getName().getPrefix())));
		assertTrue(sqpl.getTypedAuthorPersons().stream().anyMatch(t -> t.getName().getSuffix() == null));
	}

}
