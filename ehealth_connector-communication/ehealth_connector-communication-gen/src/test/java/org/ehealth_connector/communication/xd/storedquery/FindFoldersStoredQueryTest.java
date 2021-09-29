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

package org.ehealth_connector.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindFoldersQuery;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test of class FindFoldersStoredQuery
 */
class FindFoldersStoredQueryTest extends XdsTestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.xd.storedquery.FindFoldersStoredQuery#FindFoldersStoredQuery(org.ehealth_connector.common.Identificator, org.ehealth_connector.communication.ch.enums.AvailabilityStatus)}
	 * .
	 *
	 * @throws MalformedStoredQueryException
	 */
	@Test
	void testFindFoldersStoredQuery() throws MalformedStoredQueryException {
		final FindFoldersStoredQuery q = new FindFoldersStoredQuery(patientId, availabilityStatus);

		assertTrue(q.getIpfQuery() instanceof FindFoldersQuery);

		FindFoldersQuery sqpl = (FindFoldersQuery) q.getIpfQuery();

		assertEquals(patientId.getRoot(), sqpl.getPatientId().getAssigningAuthority().getUniversalId());
		assertEquals(patientId.getExtension(), sqpl.getPatientId().getId());

		assertEquals(availabilityStatus.getQueryOpcode(), sqpl.getStatus().get(0).getQueryOpcode());

	}

}
