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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.ehealth_connector.communication.ch.testhelper.XdsChTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;

/**
 * Test of class GetFolderAndContentsQuery
 */
public class GetFolderAndContentsQueryTest extends XdsChTestUtils {

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
	 * {@link org.ehealth_connector.communication.ch.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.ehealth_connector.communication.ch.enums.FormatCode[], org.ehealth_connector.communication.ch.enums.ConfidentialityCode[])}
	 * .
	 */
	@Test
	public void testGetFolderAndContentsQueryStringBooleanFormatCodeArrayConfidentialityCodeArray() {
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
	 * {@link org.ehealth_connector.communication.ch.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.ehealth_connector.communication.ch.enums.FormatCode[], org.ehealth_connector.communication.ch.enums.ConfidentialityCode[], java.lang.String)}
	 * .
	 */
	@Test
	public void testGetFolderAndContentsQueryStringBooleanFormatCodeArrayConfidentialityCodeArrayString() {
		final GetFolderAndContentsQuery q2 = new GetFolderAndContentsQuery("1234", true,
				formatCodes, confidentialityCodes, "9876");
		assertTrue(
				q2.getIpfQuery()
						.getHomeCommunityId().contains("9876"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.ch.xd.storedquery.GetFolderAndContentsQuery#GetFolderAndContentsQuery(java.lang.String, boolean, org.ehealth_connector.communication.ch.enums.FormatCode[], org.ehealth_connector.communication.ch.enums.ConfidentialityCode[], java.lang.String, org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType)}
	 * .
	 */
	@Test
	public void testGetFolderAndContentsQueryStringBooleanFormatCodeArrayConfidentialityCodeArrayStringObjectType() {
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
