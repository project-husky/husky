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
package org.ehealth_connector.communication.ch.ppq.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.ehealth_connector.security.saml2.impl.AssertionImpl;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.impl.AssertionUnmarshaller;
import org.w3c.dom.Element;

/**
 * TestClass to test the class PrivacyPolicyFeedBuilderImpl
 */
public class PrivacyPolicyFeedBuilderImplTest extends InitializerTestHelper {

	private PrivacyPolicyFeedBuilderImpl builder;
	private PpfMethod testMethod;
	private Assertion testAssertion;

	/**
	 * Method to set up test parameters
	 *
	 * @throws Exception
	 *             will be thrown on error
	 */
	@Before
	public void setUp() throws Exception {
		builder = new PrivacyPolicyFeedBuilderImpl();
		testMethod = PpfMethod.AddPolicy;

		final Element xmlElement = loadXmlDokument("/ch-ppq/add_policy_request_assertion_only.xml");
		testAssertion = (Assertion) new AssertionUnmarshaller().unmarshall(xmlElement);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl#create()}.
	 */
	@Test
	public void testCreate() {
		final PrivacyPolicyFeed ref = builder.create();
		assertNotNull(ref);
		assertNotNull(ref.getAssertion());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl#create(org.opensaml.saml.saml2.core.Assertion)}.
	 */
	@Test
	public void testCreateAssertion() {
		final PrivacyPolicyFeed ref = builder.create(testAssertion);
		assertNotNull(ref);
		assertNotNull(ref.getAssertion());
		assertEquals(testAssertion, ((AssertionImpl) ref.getAssertion()).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl#method(org.ehealth_connector.security.ch.ppq.PrivacyPolicyFeed.PpfMethod)}.
	 */
	@Test
	public void testMethod() {
		final PrivacyPolicyFeed ref = builder.method(testMethod).create();
		assertNotNull(ref);
		assertEquals(testMethod, ref.getMethod());
	}

}
