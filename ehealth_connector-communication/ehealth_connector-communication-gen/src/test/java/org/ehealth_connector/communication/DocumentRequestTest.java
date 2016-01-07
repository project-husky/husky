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
