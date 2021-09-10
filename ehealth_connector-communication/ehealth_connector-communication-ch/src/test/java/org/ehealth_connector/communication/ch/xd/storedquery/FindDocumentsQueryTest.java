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


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Map.Entry;

import org.ehealth_connector.communication.ch.testhelper.XdsChTestUtils;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryList;
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

		// Check query parameters
		final Map<String, QueryList<String>> sqpl = q.getIpfQuery().getExtraParameters();

		for (Entry<String, QueryList<String>> item : sqpl.entrySet()) {
			item.getValue().getOuterList().stream().forEach(t -> {
				log.debug(item.getKey() + ": " + t);
			});
		}

		assertTrue(sqpl.get("$XDSDocumentEntryPatientId").getOuterList().stream()
				.anyMatch(t -> t.contains(patientId.getRoot())));
		assertTrue(sqpl.get("$XDSDocumentEntryPatientId").getOuterList().stream()
				.anyMatch(t -> t.contains(patientId.getExtension())));

		assertTrue(sqpl.get("$XDSDocumentEntryStatus").getOuterList().stream()
				.anyMatch(t -> t.contains(avaiabilityStatus.getCodeValue())));

		assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeFrom").getOuterList().stream()
				.anyMatch(t -> t.contains(eDateTimeRange1.getFromAsUsFormattedString())));
		assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeTo").getOuterList().stream()
				.anyMatch(t -> t.contains(eDateTimeRange1.getToAsUsFormattedString())));

		assertTrue(sqpl.get("$XDSDocumentEntryClassCode").getOuterList().stream()
				.anyMatch(t -> t.contains(classCodes[0].getCodeValue())));
		assertTrue(sqpl.get("$XDSDocumentEntryPracticeSettingCode").getOuterList().stream()
				.anyMatch(t -> t.contains(practiceSettingCodes[0].getCodeSystemId())));
		assertTrue(sqpl.get("$XDSDocumentEntryHealthcareFacilityTypeCode").getOuterList().stream()
				.anyMatch(t -> t.contains(healthCareFacilityCodes[0].getCodeValue())));
		assertTrue(sqpl.get("$XDSDocumentEntryConfidentialityCode").getOuterList().stream()
				.anyMatch(t -> t.contains(confidentialityCodes[1].getCodeValue())));
		assertTrue(sqpl.get("$XDSDocumentEntryFormatCode").getOuterList().stream()
				.anyMatch(t -> t.contains(formatCodes[1].getCodeValue())));

		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").getOuterList().stream()
				.anyMatch(t -> t.contains(authorPerson.getName().getGiven())));
		assertTrue(
				sqpl.get("$XDSDocumentEntryAuthorPerson").getOuterList().stream()
						.anyMatch(t -> t.contains(authorPerson.getName().getFamily())));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").getOuterList().stream()
				.anyMatch(t -> t.contains(authorPerson.getName().getPrefix())));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").getOuterList().stream()
				.anyMatch(t -> t.contains(authorPerson.getName().getSuffix())));
	}

}
