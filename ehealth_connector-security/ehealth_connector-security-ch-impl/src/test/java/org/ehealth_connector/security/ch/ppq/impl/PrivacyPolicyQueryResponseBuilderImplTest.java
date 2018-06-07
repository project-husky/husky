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
package org.ehealth_connector.security.ch.ppq.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.ch.ppq.PrivacyPolicyQueryResponse;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.saml.saml2.core.Response;
import org.opensaml.saml.saml2.core.impl.ResponseBuilder;

public class PrivacyPolicyQueryResponseBuilderImplTest extends InitializerTestHelper {

	private PrivacyPolicyQueryResponseBuilderImpl builder;
	private Response testInternalObject;
	private String testConsent;

	@Before
	public void setUp() throws Exception {
		builder = new PrivacyPolicyQueryResponseBuilderImpl();
		testInternalObject = new ResponseBuilder().buildObject();

		testConsent = "MyConsent";
		testInternalObject.setConsent(testConsent);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryResponseBuilderImpl#create(org.opensaml.saml.saml2.core.Response)}.
	 */
	@Test
	public void testCreate() {
		final PrivacyPolicyQueryResponse ref = builder.create(testInternalObject);
		assertNotNull(ref);
		assertEquals(testInternalObject, ((PrivacyPolicyQueryResponseImpl) ref).getWrappedObject());
	}

}
