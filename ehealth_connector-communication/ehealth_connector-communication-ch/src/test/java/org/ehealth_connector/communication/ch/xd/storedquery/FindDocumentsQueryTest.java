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
package org.ehealth_connector.communication.ch.xd.storedquery;

import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.ehealth_connector.communication.ch.testhelper.XdsChTestUtils;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameter;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;
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
		final StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();

		sqpl.forEach(new Consumer<StoredQueryParameter>() {
			@Override
			public void accept(StoredQueryParameter t) {
				log.debug(t.getName() + ": " + t.getValue());
			}
		});

		assertTrue(sqpl.get("$XDSDocumentEntryPatientId").contains(patientId.getRoot()));
		assertTrue(sqpl.get("$XDSDocumentEntryPatientId").contains(patientId.getExtension()));

		assertTrue(sqpl.get("$XDSDocumentEntryStatus").contains(avaiabilityStatus.getCodeValue()));

		assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeFrom")
				.contains(eDateTimeRange1.getFromAsUsFormattedString()));
		assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeTo")
				.contains(eDateTimeRange1.getToAsUsFormattedString()));

		assertTrue(sqpl.get("$XDSDocumentEntryClassCode").contains(classCodes[0].getCodeValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryPracticeSettingCode")
				.contains(practiceSettingCodes[0].getCodeSystemValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryHealthcareFacilityTypeCode")
				.contains(healthCareFacilityCodes[0].getCodeValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryConfidentialityCode")
				.contains(confidentialityCodes[1].getCodeValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryFormatCode").contains(formatCodes[1].getCodeValue()));

		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getGivenName()));
		assertTrue(
				sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getFamilyName()));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getPrefix()));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getPrefix()));
	}

}
