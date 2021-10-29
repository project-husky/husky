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
package org.husky.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.communication.testhelper.XdsTestUtils;
import org.husky.communication.xd.storedquery.GetFolderAndContentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;

/**
 * Test of class GetFolderAndContentsQuery
 */
class GetFolderAndContentsQueryTest extends XdsTestUtils {

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.husky.common.Code[], org.husky.common.Code[])}
	 * .
	 */
	@Test
	void testGetFolderAndContentsQueryStringBooleanCodeArrayCodeArray() {
		final GetFolderAndContentsQuery q = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes);

		assertTrue(
				q.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) q.getIpfQuery();

		assertEquals("1234", sqpl.getUuid());
		assertTrue(
				sqpl.getFormatCodes().stream()
						.anyMatch(t -> t.getCode().equalsIgnoreCase(formatCodes.get(0).getCode())));
		assertTrue(sqpl.getConfidentialityCodes().getOuterList().stream()
				.anyMatch(t -> t.stream()
						.anyMatch(
								code -> code != null && code.getCode().equals(confidentialityCodes.get(0).getCode()))));
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.husky.common.Code[], org.husky.common.Code[], java.lang.String)}
	 * .
	 */
	@Test
	void testGetFolderAndContentsQueryStringBooleanCodeArrayCodeArrayString() {
		final GetFolderAndContentsQuery q2 = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes, "9876");
		assertTrue(q2.getIpfQuery().getHomeCommunityId().contains("9876"));
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.husky.common.Code[], org.husky.common.Code[], java.lang.String, org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType)}
	 * .
	 */
	@Test
	void testGetFolderAndContentsQueryStringBooleanCodeArrayCodeArrayStringObjectType() {
		final GetFolderAndContentsQuery q3 = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes, "6565873dsdgsdg", DocumentEntryType.STABLE);

		assertTrue(
				q3.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) q3.getIpfQuery();

		assertTrue(sqpl.getDocumentEntryTypes().stream()
				.anyMatch(t -> t != null && t.getUuid() != null
						&& t.getUuid().equals("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1")));
	}

}
