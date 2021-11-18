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

package org.husky.communication.xd.storedquery;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.husky.communication.testhelper.XdsTestUtils;
import org.husky.communication.xd.storedquery.GetDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of class GetDocumentsQuery
 */
class GetDocumentsQueryTest extends XdsTestUtils {

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
	 * {@link org.husky.communication.xd.storedquery.GetDocumentsQuery#GetDocumentsQuery(java.lang.String[], boolean)}
	 * .
	 *
	 * @throws MalformedStoredQueryException
	 */
	@Test
	void testGetDocumentsQueryStringArrayBoolean() {
		final GetDocumentsQuery q = new GetDocumentsQuery(docIds, true);

		assertTrue(
				q.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsQuery) q.getIpfQuery();

		assertTrue(sqpl.getUuids().stream()
				.anyMatch(t -> t.contains(docIds.get(0))));
		assertTrue(sqpl.getUuids().stream()
				.anyMatch(t -> t.contains(docIds.get(1))));
	}

}
