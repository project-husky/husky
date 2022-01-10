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
import org.husky.communication.ch.xd.storedquery.GetFolderAndContentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;

/**
 * Test of class GetFolderAndContentsQuery
 */
class GetFolderAndContentsQueryTest extends XdsChTestUtils {

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
	 * {@link org.husky.communication.ch.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.husky.communication.ch.enums.FormatCode[], org.husky.communication.ch.enums.ConfidentialityCode[])}
	 * .
	 */
	@Test
	void testGetFolderAndContentsQueryStringBooleanFormatCodeArrayConfidentialityCodeArray() {
		final GetFolderAndContentsQuery q1 = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes);

		assertTrue(q1
				.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) q1.getIpfQuery();

		assertEquals("1234", sqpl.getUuid());
		assertTrue(sqpl.getFormatCodes().stream().anyMatch(t -> t != null && t.getCode().equalsIgnoreCase(formatCodes[1].getCodeValue())));
		assertTrue(sqpl.getConfidentialityCodes().getOuterList().stream()
				.anyMatch(t -> t != null && t.stream()
						.anyMatch(code -> code.getCode().equalsIgnoreCase(confidentialityCodes[1].getCodeValue()))));
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.ch.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.husky.communication.ch.enums.FormatCode[], org.husky.communication.ch.enums.ConfidentialityCode[], java.lang.String)}
	 * .
	 */
	@Test
	void testGetFolderAndContentsQueryStringBooleanFormatCodeArrayConfidentialityCodeArrayString() {
		final GetFolderAndContentsQuery q2 = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes, "9876");
		assertTrue(
				q2.getIpfQuery()
						.getHomeCommunityId().contains("9876"));
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.ch.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.husky.communication.ch.enums.FormatCode[], org.husky.communication.ch.enums.ConfidentialityCode[], java.lang.String, org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType)}
	 * .
	 */
	@Test
	void testGetFolderAndContentsQueryStringBooleanFormatCodeArrayConfidentialityCodeArrayStringObjectType() {
		final GetFolderAndContentsQuery q3 = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes, "6565873dsdgsdg", DocumentEntryType.STABLE);

		assertTrue(q3
				.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) q3.getIpfQuery();

		assertTrue(
				sqpl.getDocumentEntryTypes().stream().anyMatch(t -> t != null
						&& t.getUuid().equalsIgnoreCase("urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1")));
	}

}
