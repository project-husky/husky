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

import java.util.Calendar;
import java.util.UUID;

import org.ehealth_connector.xua.saml2.AuthnStatement;
import org.ehealth_connector.xua.saml2.AuthnStatementBuilder;
import org.ehealth_connector.xua.saml2.impl.AuthnStatementBuilderImpl;
import org.junit.Before;
import org.junit.Test;

public class AuthnStatementBuilderImplTest {

	private AuthnStatementBuilder builder;
	private String testAuthnContextClassRef;
	private Calendar testAuthnInstance;
	private String testSessionIndex;
	private Calendar testSessionNotOnOrAfter;

	@Before
	public void setUp() throws Exception {
		builder = new AuthnStatementBuilderImpl();
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -120);
		testAuthnInstance = (Calendar) cal.clone();
		cal.add(Calendar.DAY_OF_YEAR, 50);
		testSessionNotOnOrAfter = (Calendar) cal.clone();

		testSessionIndex = UUID.randomUUID().toString();
		testAuthnContextClassRef = "uri:test:saml:authn:context:class:ref";
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.AuthnStatementBuilderImpl#authnContextClassRef(java.lang.String)}.
	 */
	@Test
	public void testAuthnContextClassRef() {
		final AuthnStatement ref = builder.authnContextClassRef(testAuthnContextClassRef).create();
		assertEquals(testAuthnContextClassRef, ref.getAuthnContextClassRef());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.AuthnStatementBuilderImpl#authnInstant(java.util.Calendar)}.
	 */
	@Test
	public void testAuthnInstant() {
		final AuthnStatement ref = builder.authnInstant(testAuthnInstance).create();
		assertEquals(testAuthnInstance, ref.getAuthnInstant());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.AuthnStatementBuilderImpl#sessionIndex(java.lang.String)}.
	 */
	@Test
	public void testSessionIndex() {
		final AuthnStatement ref = builder.sessionIndex(testSessionIndex).create();
		assertEquals(testSessionIndex, ref.getSessionIndex());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.AuthnStatementBuilderImpl#sessionNotOnOrAfter(java.util.Calendar)}.
	 */
	@Test
	public void testSessionNotOnOrAfter() {
		final AuthnStatement ref = builder.sessionNotOnOrAfter(testSessionNotOnOrAfter).create();
		assertEquals(testSessionNotOnOrAfter, ref.getSessionNotOnOrAfter());
	}

}
