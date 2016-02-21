/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.communication.xd.storedquery;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.testhelper.XdsTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQueryParameterList;

/**
 * Test of class FindFoldersStoredQuery
 */
public class FindFoldersStoredQueryTest extends XdsTestUtils {
	private Log log;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log = LogFactory.getLog(getClass());
	}

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
		assertEquals(patientId.getExtension(), extractByRegex("'(.*)\\^\\^\\^\\&.*\\&.*'", patientIdRootRef));

		final String statusRef = sqpl.get("$XDSFolderStatus");
		assertEquals(availabilityStatus.getName(),
				extractByRegex("\\(\\'urn:oasis:names:tc:ebxml-regrep:StatusType:(.*)\\'\\)", statusRef));

	}

}
