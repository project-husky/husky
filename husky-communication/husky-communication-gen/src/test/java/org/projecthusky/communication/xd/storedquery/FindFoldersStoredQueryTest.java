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

package org.projecthusky.communication.xd.storedquery;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.projecthusky.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindFoldersQuery;
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
	 * {@link org.projecthusky.communication.xd.storedquery.FindFoldersStoredQuery#FindFoldersStoredQuery(org.projecthusky.common.Identificator, org.projecthusky.communication.ch.enums.AvailabilityStatus)}
	 * .
	 *
	 * @throws MalformedStoredQueryException
	 */
	@Test
	void testFindFoldersStoredQuery() {
		final FindFoldersStoredQuery q = new FindFoldersStoredQuery(patientId, availabilityStatus);

		assertTrue(q.getIpfQuery() instanceof FindFoldersQuery);

		FindFoldersQuery sqpl = (FindFoldersQuery) q.getIpfQuery();

		assertEquals(patientId.getRoot(), sqpl.getPatientId().getAssigningAuthority().getUniversalId());
		assertEquals(patientId.getExtension(), sqpl.getPatientId().getId());

		assertEquals(availabilityStatus.getQueryOpcode(), sqpl.getStatus().get(0).getQueryOpcode());

	}

}
