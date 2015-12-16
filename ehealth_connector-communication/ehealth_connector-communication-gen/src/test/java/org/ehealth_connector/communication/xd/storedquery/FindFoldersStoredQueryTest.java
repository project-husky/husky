/* **********************************************************************
 * Author: roeland
 * Date  : Sep 7, 2015
 * File  : FindFoldersStoredQueryTest.java
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * @author roeland
 * @version 1.0
 * @since Sep 7, 2015 6:27:27 AM
 */
public class FindFoldersStoredQueryTest extends XdsTestUtils {
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
	 * {@link org.ehealth_connector.communication.xd.storedquery.FindFoldersStoredQuery#FindFoldersStoredQuery(org.ehealth_connector.common.Identificator, org.ehealth_connector.communication.ch.enums.AvailabilityStatus)}
	 * .
	 * 
	 * @throws MalformedStoredQueryException
	 */
	@Test
	public void testFindFoldersStoredQuery() throws MalformedStoredQueryException {
		final FindFoldersStoredQuery q = new FindFoldersStoredQuery(patientId, availabilityStatus);

		final StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();

		final String patientIdRootRef = sqpl.get("$XDSFolderPatientId");
		assertEquals(patientId.getRoot(), extractByRegex(".*\\&(.*)\\&.*", patientIdRootRef));
		assertEquals(patientId.getExtension(), extractByRegex("'(.*)\\^\\^\\^\\&.*\\&.*'", patientIdRootRef));

		final String statusRef = sqpl.get("$XDSFolderStatus");
		assertEquals(availabilityStatus.getName(),
				extractByRegex("\\(\\'urn:oasis:names:tc:ebxml-regrep:StatusType:(.*)\\'\\)", statusRef));

	}

}
