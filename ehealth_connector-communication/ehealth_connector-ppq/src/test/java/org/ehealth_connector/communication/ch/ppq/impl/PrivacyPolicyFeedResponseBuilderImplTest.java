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

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponseBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * TestClass to test the class PrivacyPolicyFeedResponseBuilderImpl
 */
public class PrivacyPolicyFeedResponseBuilderImplTest {

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
	@Before
	public void setUp() throws Exception {
		builder = new PrivacyPolicyFeedResponseBuilderImpl();
		testException = new Exception("myTest Exception");
		testMethod = PpfMethod.DeletePolicy;
		testStatus = "MyStatus";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#create()}.
	 */
	@Test
	public void testCreate() {
		final PrivacyPolicyFeedResponse ref = builder.create();
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#exception(java.lang.Exception)}.
	 */
	@Test
	public void testException() {

		final PrivacyPolicyFeedResponse ref = builder.exception(testException).create();
		assertNotNull(ref);
		assertEquals(testException, ref.getExceptions().get(0));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#method(org.ehealth_connector.xua.ch.ppq.PrivacyPolicyFeed.PpfMethod)}.
	 */
	@Test
	public void testMethod() {
		final PrivacyPolicyFeedResponse ref = builder.method(testMethod).create();
		assertNotNull(ref);
		assertEquals(testMethod, ref.getMethod());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl#status(java.lang.String)}.
	 */
	@Test
	public void testStatus() {
		final PrivacyPolicyFeedResponse ref = builder.status(testStatus).create();
		assertNotNull(ref);
		assertEquals(testStatus, ref.getStatus());
	}

}
