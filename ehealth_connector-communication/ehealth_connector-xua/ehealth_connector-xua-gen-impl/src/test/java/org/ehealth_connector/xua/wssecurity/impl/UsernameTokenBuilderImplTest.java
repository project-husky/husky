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
package org.ehealth_connector.xua.wssecurity.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Base64;
import java.util.Random;

import org.ehealth_connector.xua.wssecurity.UsernameToken;
import org.ehealth_connector.xua.wssecurity.impl.UsernameTokenBuilderImpl;
import org.ehealth_connector.xua.wssecurity.impl.UsernameTokenImpl;
import org.junit.Before;
import org.junit.Test;

public class UsernameTokenBuilderImplTest {

	private UsernameTokenBuilderImpl builder;
	private org.opensaml.soap.wssecurity.UsernameToken testInternalObject;
	private String testNonce;
	private String testPassword;
	private String testUsername;

	@Before
	public void setUp() throws Exception {
		builder = new UsernameTokenBuilderImpl();
		testUsername = "MyNameIsHarry";
		testPassword = "MyPlainPassword";

		final byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		// SecureRandom.getInstanceStrong().nextBytes(bytes);
		testNonce = Base64.getEncoder().encodeToString(bytes);

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.wssecurity.impl.UsernameTokenBuilderImpl#create(org.opensaml.soap.wssecurity.UsernameToken)}.
	 */
	@Test
	public void testCreateUsernameToken() {
		final UsernameToken ref = builder.create(testInternalObject);
		assertNotNull(ref);
		assertEquals(testInternalObject, ((UsernameTokenImpl) ref).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.wssecurity.impl.UsernameTokenBuilderImpl#nonce(java.lang.String)}.
	 */
	@Test
	public void testNonce() {
		final UsernameToken ref = builder.nonce(testNonce).create();
		assertNotNull(ref);
		assertEquals(testNonce, ref.getNonce());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.wssecurity.impl.UsernameTokenBuilderImpl#password(java.lang.String)}.
	 */
	@Test
	public void testPassword() {
		final UsernameToken ref = builder.password(testPassword).create();
		assertNotNull(ref);
		assertEquals(testPassword, ref.getPassword());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.wssecurity.impl.UsernameTokenBuilderImpl#username(java.lang.String)}.
	 */
	@Test
	public void testUsername() {
		final UsernameToken ref = builder.username(testUsername).create();
		assertNotNull(ref);
		assertEquals(testUsername, ref.getUsername());
	}

}
