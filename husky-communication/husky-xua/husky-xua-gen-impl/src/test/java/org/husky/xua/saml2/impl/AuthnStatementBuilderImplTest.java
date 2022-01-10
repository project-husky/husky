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

import java.util.Calendar;
import java.util.UUID;

import org.husky.xua.saml2.AuthnStatementBuilder;
import org.husky.xua.saml2.impl.AuthnStatementBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AuthnStatementType;
import org.opensaml.saml.saml2.core.impl.AuthnContextClassRefImpl;

class AuthnStatementBuilderImplTest {

	private AuthnStatementBuilder builder;
	private String testAuthnContextClassRef;
	private Calendar testAuthnInstance;
	private String testSessionIndex;
	private Calendar testSessionNotOnOrAfter;

	@BeforeEach
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
	 * {@link org.husky.xua.saml2.impl.AuthnStatementBuilderImpl#authnContextClassRef(java.lang.String)}.
	 */
	@Test
	void testAuthnContextClassRef() {
		final AuthnStatementType ref = builder.authnContextClassRef(testAuthnContextClassRef).create();
		assertEquals(testAuthnContextClassRef,
				((AuthnContextClassRefImpl) ref.getAuthnContext().getContent().get(0).getValue())
						.getURI());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AuthnStatementBuilderImpl#authnInstant(java.util.Calendar)}.
	 */
	@Test
	void testAuthnInstant() {
		final AuthnStatementType ref = builder.authnInstant(testAuthnInstance).create();
		assertEquals(testAuthnInstance.getTimeInMillis(),
				ref.getAuthnInstant().toGregorianCalendar().getTimeInMillis());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AuthnStatementBuilderImpl#sessionIndex(java.lang.String)}.
	 */
	@Test
	void testSessionIndex() {
		final AuthnStatementType ref = builder.sessionIndex(testSessionIndex).create();
		assertEquals(testSessionIndex, ref.getSessionIndex());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.AuthnStatementBuilderImpl#sessionNotOnOrAfter(java.util.Calendar)}.
	 */
	@Test
	void testSessionNotOnOrAfter() {
		final AuthnStatementType ref = builder.sessionNotOnOrAfter(testSessionNotOnOrAfter).create();
		assertEquals(testSessionNotOnOrAfter.getTimeInMillis(),
				ref.getSessionNotOnOrAfter().toGregorianCalendar().getTimeInMillis());
	}

}
