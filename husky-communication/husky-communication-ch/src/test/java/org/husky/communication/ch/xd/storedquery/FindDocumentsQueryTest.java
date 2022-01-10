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
package org.husky.communication.ch.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.communication.ch.testhelper.XdsChTestUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test of class FindDocumentsQuery
 */
class FindDocumentsQueryTest extends XdsChTestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Test method for
	 * {@link org.husky.communication.ch.xd.storedquery.FindDocumentsQuery#FindDocumentsQuery(org.husky.common.Identificator, org.husky.communication.ch.enums.ClassCode[], org.husky.communication.xd.storedquery.DateTimeRange[], org.husky.communication.ch.enums.PracticeSettingCode[], org.husky.communication.ch.enums.HealthcareFacilityTypeCode[], org.husky.communication.ch.enums.ConfidentialityCode[], org.husky.communication.ch.enums.FormatCode[], org.openhealthtools.ihe.common.hl7v2.XCN, org.husky.communication.ch.enums.AvailabilityStatus)}
	 * .
	 */
	@Test
	void testFindDocumentsQueryIdentificatorClassCodeArrayDateTimeRangeArrayPracticeSettingCodeArrayHealthcareFacilityTypeCodeArrayConfidentialityCodeArrayFormatCodeArrayXCNAvailabilityStatus() {
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

		assertEquals(sqpl.getCreationTime().getFrom().toHL7(),
				eDateTimeRange1.getFromAsUsFormattedString());

		assertEquals(sqpl.getCreationTime().getTo().toHL7(),
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
