/* **********************************************************************
 * Author: roeland
 * Date  : Dec 16, 2015
 * File  : GetFolderAndContentsQueryTest.java
 * **********************************************************************
 * ehealth_connector-communication-gen
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
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 16, 2015 11:15:27 AM
 *
 */
public class GetFolderAndContentsQueryTest extends XdsTestUtils {

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
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.ehealth_connector.common.Code[], org.ehealth_connector.common.Code[])}
	 * .
	 */
	@Test
	public void testGetFolderAndContentsQueryStringBooleanCodeArrayCodeArray() {
		final GetFolderAndContentsQuery q1 = new GetFolderAndContentsQuery("1234", true, formatCodes, confidentialityCodes);
		final StoredQueryParameterList sqpl1 = q1.getOhtStoredQuery().getQueryParameters();

		assertTrue(sqpl1.get("$XDSFolderEntryUUID").contains("1234"));
		assertTrue(sqpl1.get("$XDSDocumentEntryFormatCode").contains(formatCodes[0].getCode()));
		assertTrue(sqpl1.get("$XDSDocumentEntryConfidentialityCode").contains(confidentialityCodes[0].getCode()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.ehealth_connector.common.Code[], org.ehealth_connector.common.Code[], java.lang.String)}
	 * .
	 */
	@Test
	public void testGetFolderAndContentsQueryStringBooleanCodeArrayCodeArrayString() {
		final GetFolderAndContentsQuery q2 = new GetFolderAndContentsQuery("1234", true, formatCodes, confidentialityCodes, "9876");
		assertTrue(q2.getOhtStoredQuery().getHomeCommunityId().contains("9876"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.ehealth_connector.common.Code[], org.ehealth_connector.common.Code[], java.lang.String, org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType)}
	 * .
	 */
	@Test
	public void testGetFolderAndContentsQueryStringBooleanCodeArrayCodeArrayStringObjectType() {
		final GetFolderAndContentsQuery q3 = new GetFolderAndContentsQuery("1234", true, formatCodes, confidentialityCodes,
				"6565873dsdgsdg", ObjectType.STATIC);
		assertTrue(q3.getOhtStoredQuery().getQueryParameters().get("$XDSDocumentEntryType")
				.contains("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1"));
	}

}
