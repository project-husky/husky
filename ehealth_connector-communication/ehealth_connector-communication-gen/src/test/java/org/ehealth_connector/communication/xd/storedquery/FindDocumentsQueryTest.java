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

import java.util.Map;
import java.util.Map.Entry;

import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryList;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test of class FindDocumentsQuery
 */
class FindDocumentsQueryTest extends XdsTestUtils {

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Test
	void testFindDocumentsQueryIdentificatorAvailabilityStatus()
			throws MalformedStoredQueryException {

		final FindDocumentsQuery q = new FindDocumentsQuery(patientId, availabilityStatus);

		// Check query parameters
		final Map<String, QueryList<String>> sqpl = q.getIpfQuery().getExtraParameters();

		for (Entry<String, QueryList<String>> sqpl1 : sqpl.entrySet()) {
			if (sqpl1.getKey() != null && sqpl1.getValue() != null) {
				sqpl1.getValue().getOuterList().stream().forEach(t -> {
					log.debug(sqpl1.getKey() + ": " + t);
				});
			}

		}

		final QueryList<String> patientIdRootRef = sqpl.get("$XDSDocumentEntryPatientId");
		assertEquals(patientId.getRoot(), extractByRegex(".*\\&(.*)\\&.*", patientIdRootRef.getOuterList()));
		assertEquals(patientId.getExtension(),
				extractByRegex("'(.*)\\^\\^\\^\\&.*\\&.*'", patientIdRootRef.getOuterList()));

		final QueryList<String> entryStatusRef = sqpl.get("$XDSDocumentEntryStatus");
		assertEquals(availabilityStatus.getQueryOpcode(),
				extractByRegex(
						"\\(\\'urn:oasis:names:tc:ebxml-regrep:StatusType:(.*)\\'\\)", entryStatusRef.getOuterList()));
	}

}
