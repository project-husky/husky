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

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponseBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TestClass to test the class PrivacyPolicyFeedResponseBuilderImpl
 */
class PrivacyPolicyFeedResponseBuilderImplTest {

	private PrivacyPolicyFeedResponseBuilder builder;
	private Exception testException;
	private PpfMethod testMethod;
	private String testStatus;

	/**
	 * Method to set up test parameters
	 *
	 * @throws Exception
	 *             will be thrown on error
	 */
	@BeforeEach
	public void setUp() throws Exception {
		builder = new PrivacyPolicyFeedResponseBuilderImpl();
		testException = new Exception("myTest Exception");
		testMethod = PpfMethod.DELETE_POLICY;
		testStatus = "MyStatus";
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#create()}.
	 */
	@Test
	void testCreate() {
		final PrivacyPolicyFeedResponse ref = builder.create();
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#exception(java.lang.Exception)}.
	 */
	@Test
	void testException() {

		final PrivacyPolicyFeedResponse ref = builder.exception(testException).create();
		assertNotNull(ref);
		assertEquals(testException, ref.getExceptions().get(0));
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#method(org.husky.xua.ch.ppq.PrivacyPolicyFeed.PpfMethod)}.
	 */
	@Test
	void testMethod() {
		final PrivacyPolicyFeedResponse ref = builder.method(testMethod).create();
		assertNotNull(ref);
		assertEquals(testMethod, ref.getMethod());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#status(java.lang.String)}.
	 */
	@Test
	void testStatus() {
		final PrivacyPolicyFeedResponse ref = builder.status(testStatus).create();
		assertNotNull(ref);
		assertEquals(testStatus, ref.getStatus());
	}

}
