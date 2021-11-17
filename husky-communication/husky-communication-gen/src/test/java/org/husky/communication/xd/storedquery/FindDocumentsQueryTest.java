/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
import org.husky.communication.xd.storedquery.FindDocumentsQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test of class FindDocumentsQuery
 */
class FindDocumentsQueryTest extends XdsTestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Test
	void testFindDocumentsQueryIdentificatorAvailabilityStatus() {

		final FindDocumentsQuery q = new FindDocumentsQuery(patientId, availabilityStatus);

		assertTrue(
				q.getIpfQuery() instanceof org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery);

		var sqpl = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery) q.getIpfQuery();

		assertEquals(patientId.getRoot(), sqpl.getPatientId().getAssigningAuthority().getUniversalId());
		assertEquals(patientId.getExtension(), sqpl.getPatientId().getId());

		assertEquals(availabilityStatus.getQueryOpcode(), sqpl.getStatus().get(0).getQueryOpcode());
	}

}
