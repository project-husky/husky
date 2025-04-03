/**
 * 
 */
package org.projecthusky.xua.communication.clients.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.xua.exceptions.ClientSendException;

/**
 * 
 */
class SimpleXuaClientTest {

	private StringEntity testSimpleResponseEntity;
	private HttpEntity testMultipartedResponseEntity;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		InputStream instream = this.getClass()
				.getResourceAsStream("/wstrust/XUserAssertionResponse.xml");
		ContentType contentType = ContentType.create("application/soap+xml", "UTF-8");
		testSimpleResponseEntity = new StringEntity(new String(instream.readAllBytes(), "UTF-8"),
				contentType);
		testMultipartedResponseEntity = MultipartEntityBuilder.create().addBinaryBody("TEST", instream, contentType, null).build();
	}

	@Test
	void testExtractResponseSimple() throws ClientSendException, IOException {
		SimpleXuaClient client = new SimpleXuaClient(null);
		String ref = client.extractResponse(testSimpleResponseEntity);
		assertNotNull(ref);

		assertTrue(ref.contains("José"));
	}

	@Test
	@Disabled
	void testExtractResponseMultiparted() throws ClientSendException, IOException {
		SimpleXuaClient client = new SimpleXuaClient(null);
		String ref = client.extractResponse(testMultipartedResponseEntity);
	}

}
