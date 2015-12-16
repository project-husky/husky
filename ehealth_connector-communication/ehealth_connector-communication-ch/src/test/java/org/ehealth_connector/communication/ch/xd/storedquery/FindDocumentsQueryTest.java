/* **********************************************************************
 * Author: roeland
 * Date  : Dec 15, 2015
 * File  : FindDocumentsQueryTest.java
 * **********************************************************************
 * ehealth_connector-communication-ch
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */
package org.ehealth_connector.communication.ch.xd.storedquery;

import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.ch.testhelper.XdsChTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameter;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 15, 2015 3:15:07 PM
 *
 */
public class FindDocumentsQueryTest extends XdsChTestUtils {

	private Log log;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log = LogFactory.getLog(getClass());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.ch.xd.storedquery.FindDocumentsQuery#FindDocumentsQuery(org.ehealth_connector.common.Identificator, org.ehealth_connector.communication.ch.enums.ClassCode[], org.ehealth_connector.communication.xd.storedquery.DateTimeRange[], org.ehealth_connector.communication.ch.enums.PracticeSettingCode[], org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode[], org.ehealth_connector.communication.ch.enums.ConfidentialityCode[], org.ehealth_connector.communication.ch.enums.FormatCode[], org.openhealthtools.ihe.common.hl7v2.XCN, org.ehealth_connector.communication.ch.enums.AvailabilityStatus)}
	 * .
	 */
	@Test
	public void testFindDocumentsQueryIdentificatorClassCodeArrayDateTimeRangeArrayPracticeSettingCodeArrayHealthcareFacilityTypeCodeArrayConfidentialityCodeArrayFormatCodeArrayXCNAvailabilityStatus() {
		// Constructor Test
		// Create a query
		final FindDocumentsQuery q = new FindDocumentsQuery(patientId, classCodes, eDateTimeRanges, practiceSettingCodes,
				healthCareFacilityCodes, confidentialityCodes, formatCodes, authorPerson, avaiabilityStatus);

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

		assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeFrom").contains(eDateTimeRange1.getFromAsUsFormattedString()));
		assertTrue(sqpl.get("$XDSDocumentEntryCreationTimeTo").contains(eDateTimeRange1.getToAsUsFormattedString()));

		assertTrue(sqpl.get("$XDSDocumentEntryClassCode").contains(classCodes[0].getCodeValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryPracticeSettingCode").contains(practiceSettingCodes[0].getCodeSystemOid()));
		assertTrue(sqpl.get("$XDSDocumentEntryHealthcareFacilityTypeCode").contains(healthCareFacilityCodes[0].getCodeValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryConfidentialityCode").contains(confidentialityCodes[1].getCodeValue()));
		assertTrue(sqpl.get("$XDSDocumentEntryFormatCode").contains(formatCodes[1].getCodeValue()));

		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getGivenName()));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getFamilyName()));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getPrefix()));
		assertTrue(sqpl.get("$XDSDocumentEntryAuthorPerson").contains(authorPerson.getPrefix()));
	}

}
