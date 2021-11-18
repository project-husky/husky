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
package org.husky.xua.wssecurity.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Base64;
import java.util.Random;

import org.husky.xua.wssecurity.UsernameToken;
import org.husky.xua.wssecurity.impl.UsernameTokenBuilderImpl;
import org.husky.xua.wssecurity.impl.UsernameTokenImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsernameTokenBuilderImplTest {

	private UsernameTokenBuilderImpl builder;
	private org.opensaml.soap.wssecurity.UsernameToken testInternalObject;
	private String testNonce;
	private String testPassword;
	private String testUsername;

	@BeforeEach
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
	 * {@link org.husky.xua.wssecurity.impl.UsernameTokenBuilderImpl#create(org.opensaml.soap.wssecurity.UsernameToken)}.
	 */
	@Test
	public void testCreateUsernameToken() {
		final UsernameToken ref = builder.create(testInternalObject);
		assertNotNull(ref);
		assertEquals(testInternalObject, ((UsernameTokenImpl) ref).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.wssecurity.impl.UsernameTokenBuilderImpl#nonce(java.lang.String)}.
	 */
	@Test
	public void testNonce() {
		final UsernameToken ref = builder.nonce(testNonce).create();
		assertNotNull(ref);
		assertEquals(testNonce, ref.getNonce());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.wssecurity.impl.UsernameTokenBuilderImpl#password(java.lang.String)}.
	 */
	@Test
	public void testPassword() {
		final UsernameToken ref = builder.password(testPassword).create();
		assertNotNull(ref);
		assertEquals(testPassword, ref.getPassword());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.wssecurity.impl.UsernameTokenBuilderImpl#username(java.lang.String)}.
	 */
	@Test
	public void testUsername() {
		final UsernameToken ref = builder.username(testUsername).create();
		assertNotNull(ref);
		assertEquals(testUsername, ref.getUsername());
	}

}
