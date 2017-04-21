/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

import static org.junit.Assert.assertEquals;

import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test of class FindFoldersStoredQuery
 */
public class FindFoldersStoredQueryTest extends XdsTestUtils {

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
	public void testFindFoldersStoredQuery() throws MalformedStoredQueryException {
		final FindFoldersStoredQuery q = new FindFoldersStoredQuery(patientId, availabilityStatus);

		final StoredQueryParameterList sqpl = q.getOhtStoredQuery().getQueryParameters();

		final String patientIdRootRef = sqpl.get("$XDSFolderPatientId");
		assertEquals(patientId.getRoot(), extractByRegex(".*\\&(.*)\\&.*", patientIdRootRef));
		assertEquals(patientId.getExtension(),
				extractByRegex("'(.*)\\^\\^\\^\\&.*\\&.*'", patientIdRootRef));

		final String statusRef = sqpl.get("$XDSFolderStatus");
		assertEquals(availabilityStatus.getName(), extractByRegex(
				"\\(\\'urn:oasis:names:tc:ebxml-regrep:StatusType:(.*)\\'\\)", statusRef));

	}

}
