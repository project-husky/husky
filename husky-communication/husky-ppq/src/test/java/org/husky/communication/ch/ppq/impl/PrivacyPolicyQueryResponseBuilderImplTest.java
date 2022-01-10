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
package org.husky.communication.ch.ppq.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.saml.saml2.core.Response;
import org.opensaml.saml.saml2.core.impl.ResponseBuilder;

class PrivacyPolicyQueryResponseBuilderImplTest extends InitializerTestHelper {

	private PrivacyPolicyQueryResponseBuilderImpl builder;
	private String testConsent;
	private Response testInternalObject;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new PrivacyPolicyQueryResponseBuilderImpl();
		testInternalObject = new ResponseBuilder().buildObject();

		testConsent = "MyConsent";
		testInternalObject.setConsent(testConsent);
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.ch.ppq.impl.PrivacyPolicyQueryResponseBuilderImpl#create(org.opensaml.saml.saml2.core.Response)}.
	 */
	@Test
	void testCreate() {
		final PrivacyPolicyQueryResponse ref = builder.create(testInternalObject);
		assertNotNull(ref);
		assertEquals(testInternalObject, ((PrivacyPolicyQueryResponseImpl) ref).getWrappedObject());
	}

}
