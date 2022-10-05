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
package org.projecthusky.communication.ch.ppq.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.projecthusky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.projecthusky.xua.saml2.impl.AssertionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.impl.AssertionUnmarshaller;
import org.w3c.dom.Element;

/**
 * TestClass to test the class PrivacyPolicyFeedBuilderImpl
 */
class PrivacyPolicyFeedBuilderImplTest extends InitializerTestHelper {

	private PrivacyPolicyFeedBuilderImpl builder;
	private PpfMethod testMethod;
	private Assertion testAssertion;

	/**
	 * Method to set up test parameters
	 *
	 * @throws Exception
	 *             will be thrown on error
	 */
	@BeforeEach
	public void setUp() throws Exception {
		builder = new PrivacyPolicyFeedBuilderImpl();
		testMethod = PpfMethod.ADD_POLICY;

		final Element xmlElement = loadXmlDokument("/ch-ppq/add_policy_request_assertion_only.xml");
		testAssertion = (Assertion) new AssertionUnmarshaller().unmarshall(xmlElement);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl#create()}.
	 */
	@Test
	void testCreate() {
		final PrivacyPolicyFeed ref = builder.create();
		assertNotNull(ref);
		assertNotNull(ref.getAssertion());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl#create(org.opensaml.saml.saml2.core.Assertion)}.
	 */
	@Test
	void testCreateAssertion() {
		final PrivacyPolicyFeed ref = builder.create(testAssertion);
		assertNotNull(ref);
		assertNotNull(ref.getAssertion());
		assertEquals(testAssertion, ((AssertionImpl) ref.getAssertion()).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.ch.ppq.impl.PrivacyPolicyFeedBuilderImpl#method(org.projecthusky.xua.ch.ppq.PrivacyPolicyFeed.PpfMethod)}.
	 */
	@Test
	void testMethod() {
		final PrivacyPolicyFeed ref = builder.method(testMethod).create();
		assertNotNull(ref);
		assertEquals(testMethod, ref.getMethod());
	}

}
