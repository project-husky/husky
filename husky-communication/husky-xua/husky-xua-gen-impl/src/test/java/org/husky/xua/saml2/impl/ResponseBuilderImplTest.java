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
package org.husky.xua.saml2.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.UUID;

import org.husky.xua.saml2.Response;
import org.husky.xua.saml2.impl.ResponseBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResponseBuilderImplTest {

	private ResponseBuilderImpl responseBuilder;
	private String testConsent;
	private String testId;
	private Instant testIssueInstant;

	@BeforeEach
	public void setUp() throws Exception {
		responseBuilder = new ResponseBuilderImpl();

		testConsent = "Test a consent";
		testIssueInstant = Instant.now();
		testId = UUID.randomUUID().toString();
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.ResponseBuilderImpl#create()}.
	 */
	@Test
	void testCreate() {
		final Response ref = responseBuilder.create();

		assertNull(ref.getConsent());
		assertNull(ref.getId());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.ResponseBuilderImpl#create(org.opensaml.saml.saml2.core.Response)}.
	 */
	@Test
	void testCreateResponse() {
		final org.opensaml.saml.saml2.core.Response innerResponse = new org.opensaml.saml.saml2.core.impl.ResponseBuilder()
				.buildObject();
		innerResponse.setConsent(testConsent);
		innerResponse.setIssueInstant(testIssueInstant);
		innerResponse.setID(testId);

		final Response ref = responseBuilder.create(innerResponse);

		assertNotNull(ref);
		assertEquals(testConsent, ref.getConsent());
		assertEquals(testId, ref.getId());
		assertEquals(testIssueInstant.toEpochMilli(), ref.getIssueInstant().getTimeInMillis());
	}

}
