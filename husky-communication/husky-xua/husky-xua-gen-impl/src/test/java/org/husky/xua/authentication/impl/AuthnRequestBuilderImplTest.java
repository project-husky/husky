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
package org.husky.xua.authentication.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.UUID;

import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.authentication.AuthnRequestBuilder;
import org.husky.xua.authentication.impl.AuthnRequestBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.saml.common.xml.SAMLConstants;
import org.opensaml.saml.saml2.core.NameID;

class AuthnRequestBuilderImplTest {

	private Integer testAssertionConsumerServiceIndex;
	private String testAssertionConsumerServiceURL;
	private Integer testAttributeConsumingServiceIndex;
	public AuthnRequestBuilder testBuilder;
	private String testConsent;
	private String testDestination;
	private Boolean testForceAuthn;
	private String testId;
	private Calendar testIssueInstant;
	private String testIssuer;
	private Boolean testNameIdPolicyAllowCreate;
	private String testNameIdPolicyFormat;
	private String testProtocolBinding;
	private String testProviderName;

	@BeforeEach
	public void setUp() throws Exception {
		testBuilder = new AuthnRequestBuilderImpl();
		testId = UUID.randomUUID().toString();
		testIssueInstant = Calendar.getInstance();
		testAssertionConsumerServiceIndex = Integer.valueOf(111);
		testAssertionConsumerServiceURL = "https://test.it.now.ch/do/it/now/good";
		testAttributeConsumingServiceIndex = Integer.valueOf(222);
		testDestination = "https://test.soe.healthcare/idp";
		testProviderName = "IG eHealthConnector";
		testConsent = "MyConsent";
		testProtocolBinding = SAMLConstants.POST_METHOD;
		testForceAuthn = true;
		testIssuer = "MyIssuer";
		testNameIdPolicyAllowCreate = true;
		testNameIdPolicyFormat = NameID.TRANSIENT;
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#assertionConsumerServiceIndex(java.lang.Integer)}.
	 */
	@Test
	void testAssertionConsumerServiceIndex() {
		final AuthnRequest request = testBuilder
				.assertionConsumerServiceIndex(testAssertionConsumerServiceIndex).create();
		assertEquals(testAssertionConsumerServiceIndex, request.getAssertionConsumerServiceIndex());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#assertionConsumerServiceUrl(java.lang.String)}.
	 */
	@Test
	void testAssertionConsumerServiceURL() {
		final AuthnRequest request = testBuilder
				.assertionConsumerServiceUrl(testAssertionConsumerServiceURL).create();
		assertEquals(testAssertionConsumerServiceURL, request.getAssertionConsumerServiceUrl());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#attributeConsumingServiceIndex(java.lang.Integer)}.
	 */
	@Test
	void testAttributeConsumingServiceIndex() {
		final AuthnRequest request = testBuilder
				.attributeConsumingServiceIndex(testAttributeConsumingServiceIndex).create();
		assertEquals(testAttributeConsumingServiceIndex,
				request.getAttributeConsumingServiceIndex());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#consent(java.lang.String)}.
	 */
	@Test
	void testConsent() {
		final AuthnRequest request = testBuilder.consent(testConsent).create();
		assertEquals(testConsent, request.getConsent());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#destination(java.lang.String)}.
	 */
	@Test
	void testDestination() {
		final AuthnRequest request = testBuilder.destination(testDestination).create();
		assertEquals(testDestination, request.getDestination());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#forceAuthn(java.lang.Boolean)}.
	 */
	@Test
	void testForceAuthn() {
		final AuthnRequest request = testBuilder.forceAuthn(testForceAuthn).create();
		assertEquals(testForceAuthn, request.getForceAuthn());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#id(java.lang.String)}.
	 */
	@Test
	void testId() {
		final AuthnRequest request = testBuilder.id(testId).create();
		assertEquals(testId, request.getId());
	}

	@Test
	void testIdIssueInstant() {
		final AuthnRequest request = testBuilder.id(testId).issueInstant(testIssueInstant).create();
		assertEquals(testId, request.getId());
		assertEquals(testIssueInstant, request.getIssueInstant());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#issueInstant(java.util.Calendar)}.
	 */
	@Test
	void testIssueInstant() {
		final AuthnRequest request = testBuilder.issueInstant(testIssueInstant).create();
		assertEquals(testIssueInstant, request.getIssueInstant());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#issuer(java.lang.String)}.
	 */
	@Test
	void testIssuer() {
		final AuthnRequest request = testBuilder.issuer(testIssuer).create();
		assertEquals(testIssuer, request.getIssuer());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#nameIdPolicyAllowCreate(java.lang.Boolean)}.
	 */
	@Test
	void testNameIdPolicyAllowCreate() {
		final AuthnRequest request = testBuilder
				.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate).create();
		assertEquals(testNameIdPolicyAllowCreate, request.getNameIdPolicyAllowCreate());
	}

	@Test
	void testNameIdPolicyAllowCreateFormat() {
		final AuthnRequest request = testBuilder
				.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate)
				.nameIdPolicyFormat(testNameIdPolicyFormat).create();
		assertEquals(testNameIdPolicyAllowCreate, request.getNameIdPolicyAllowCreate());
		assertEquals(testNameIdPolicyFormat, request.getNameIdPolicyFormat());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#nameIdPolicyFormat(java.lang.String)}.
	 */
	@Test
	void testNameIdPolicyFormat() {
		final AuthnRequest request = testBuilder.nameIdPolicyFormat(testNameIdPolicyFormat)
				.create();
		assertEquals(testNameIdPolicyFormat, request.getNameIdPolicyFormat());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#protocolBinding(java.lang.String)}.
	 */
	@Test
	void testProtocolBinding() {
		final AuthnRequest request = testBuilder.protocolBinding(testProtocolBinding).create();
		assertEquals(testProtocolBinding, request.getProtocolBinding());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.authentication.impl.AuthnRequestBuilderImpl#providerName(java.lang.String)}.
	 */
	@Test
	void testProviderName() {
		final AuthnRequest request = testBuilder.providerName(testProviderName).create();
		assertEquals(testProviderName, request.getProviderName());
	}
}
