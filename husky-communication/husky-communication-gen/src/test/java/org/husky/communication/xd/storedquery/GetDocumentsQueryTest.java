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
