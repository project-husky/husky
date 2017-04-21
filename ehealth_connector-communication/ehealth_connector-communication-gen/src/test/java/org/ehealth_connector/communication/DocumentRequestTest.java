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
package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class DocumentRequestTest extends TestUtils {

	String testUri = "ihexds.nist.gov";

	@Before
	public void setUp() {
		init();
	}

	@Test
	public void testDocumentRequest() throws URISyntaxException {
		final DocumentRequest dr = new DocumentRequest(ts1, new URI(testUri), ts2, ts3);

		assertEquals(ts1, dr.getRepositoryId());
		assertEquals(testUri, dr.getRepositoryUri().toString());
		assertEquals(ts2, dr.getDocumentId());
		assertEquals(ts3, dr.getHomeCommunityId());

	}
}
