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
package org.ehealth_connector.xua.saml2.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.UUID;

import org.ehealth_connector.xua.saml2.Response;
import org.ehealth_connector.xua.saml2.impl.ResponseBuilderImpl;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class ResponseBuilderImplTest {

	private ResponseBuilderImpl responseBuilder;
	private String testConsent;
	private String testId;
	private DateTime testIssueInstant;

	@Before
	public void setUp() throws Exception {
		responseBuilder = new ResponseBuilderImpl();

		testConsent = "Test a consent";
		testIssueInstant = DateTime.now();
		testId = UUID.randomUUID().toString();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.ResponseBuilderImpl#create()}.
	 */
	@Test
	public void testCreate() {
		final Response ref = responseBuilder.create();

		assertNull(ref.getConsent());
		assertNull(ref.getId());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.ResponseBuilderImpl#create(org.opensaml.saml.saml2.core.Response)}.
	 */
	@Test
	public void testCreateResponse() {
		final org.opensaml.saml.saml2.core.Response innerResponse = new org.opensaml.saml.saml2.core.impl.ResponseBuilder()
				.buildObject();
		innerResponse.setConsent(testConsent);
		innerResponse.setIssueInstant(testIssueInstant);
		innerResponse.setID(testId);

		final Response ref = responseBuilder.create(innerResponse);

		assertNotNull(ref);
		assertEquals(testConsent, ref.getConsent());
		assertEquals(testId, ref.getId());
		assertEquals(testIssueInstant.getMillis(), ref.getIssueInstant().getTimeInMillis());
	}

}
