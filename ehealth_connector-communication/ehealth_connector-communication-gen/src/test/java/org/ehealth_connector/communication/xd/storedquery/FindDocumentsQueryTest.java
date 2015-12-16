/* **********************************************************************
 * Author: roeland
 * Date  : Sep 7, 2015
 * File  : FindDocumentsQueryTest.java
 * **********************************************************************
 * ehealth_connector-communication
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */

package org.ehealth_connector.communication.xd.storedquery;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameter;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * @author roeland
 * @version 1.0
 * @since Sep 7, 2015 6:19:01 AM
 */
public class FindDocumentsQueryTest extends XdsTestUtils {

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

	@Test
	public void testFindDocumentsQueryIdentificatorAvailabilityStatus() throws MalformedStoredQueryException {

		final FindDocumentsQuery q = new FindDocumentsQuery(patientId, availabilityStatus);

		// Check query parameters
		final StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();

		sqpl.forEach(new Consumer<StoredQueryParameter>() {
			@Override
			public void accept(StoredQueryParameter t) {
				log.debug(t.getName() + ": " + t.getValue());
			}
		});

		final String patientIdRootRef = sqpl.get("$XDSDocumentEntryPatientId");
		assertEquals(patientId.getRoot(), extractByRegex(".*\\&(.*)\\&.*", patientIdRootRef));
		assertEquals(patientId.getExtension(), extractByRegex("'(.*)\\^\\^\\^\\&.*\\&.*'", patientIdRootRef));

		final String entryStatusRef = sqpl.get("$XDSDocumentEntryStatus");
		assertEquals(availabilityStatus.getName(),
				extractByRegex("\\(\\'urn:oasis:names:tc:ebxml-regrep:StatusType:(.*)\\'\\)", entryStatusRef));
	}

}
