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
package org.husky.communication;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.husky.communication.DocumentRequest;
import org.husky.communication.testhelper.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocumentRequestTest extends TestUtils {

	String testUri = "ihexds.nist.gov";

	@BeforeEach
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
