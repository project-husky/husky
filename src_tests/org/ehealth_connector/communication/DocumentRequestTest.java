package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.ehealth_connector.cda.tests.CdaUtilTest;
import org.junit.Before;
import org.junit.Test;

public class DocumentRequestTest extends CdaUtilTest {

	String testUri = "ihexds.nist.gov";

	@Override
	@Before
	public void init() {
		super.init();
	}

	@Test
	public void wrappedClassTest() {
		try {
			DocumentRequest dr = new DocumentRequest(ts1, new URI(testUri), ts2, ts3);

			assertEquals(ts1, dr.getRepositoryId());
			assertEquals(testUri, dr.getRepositoryUri().toString());
			assertEquals(ts2, dr.getDocumentId());
			assertEquals(ts3, dr.getHomeCommunityId());

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
