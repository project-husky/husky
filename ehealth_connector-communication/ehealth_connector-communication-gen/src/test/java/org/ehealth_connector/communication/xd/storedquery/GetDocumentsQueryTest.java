/* **********************************************************************
 * Author: roeland
 * Date  : Sep 7, 2015
 * File  : GetDocumentsQueryTest.java
 * **********************************************************************
 * ehealth_connector-communication
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */

package org.ehealth_connector.communication.xd.storedquery;

import static org.junit.Assert.assertTrue;

import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * @author roeland
 * @version 1.0
 * @since Sep 7, 2015 6:28:46 AM
 */
public class GetDocumentsQueryTest extends XdsTestUtils {

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetDocumentsQuery#GetDocumentsQuery(java.lang.String[], boolean)}
	 * .
	 * 
	 * @throws MalformedStoredQueryException
	 */
	@Test
	public void testGetDocumentsQueryStringArrayBoolean() throws MalformedStoredQueryException {
		final GetDocumentsQuery q = new GetDocumentsQuery(docIds, true);

		final StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();

		assertTrue(sqpl.get("$XDSDocumentEntryEntryUUID").contains(docIds[0]));
		assertTrue(sqpl.get("$XDSDocumentEntryEntryUUID").contains(docIds[1]));
	}

}
