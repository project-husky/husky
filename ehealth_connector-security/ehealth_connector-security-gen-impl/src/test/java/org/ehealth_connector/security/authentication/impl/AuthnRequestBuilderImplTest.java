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
package org.ehealth_connector.security.authentication.impl;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.UUID;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.AuthnRequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.saml.common.xml.SAMLConstants;
import org.opensaml.saml.saml2.core.NameID;

public class AuthnRequestBuilderImplTest {

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

	@Before
	public void setUp() throws Exception {
		testBuilder = new AuthnRequestBuilderImpl();
		testId = UUID.randomUUID().toString();
		testIssueInstant = Calendar.getInstance();
		testAssertionConsumerServiceIndex = new Integer(111);
		testAssertionConsumerServiceURL = "https://test.it.now.ch/do/it/now/good";
		testAttributeConsumingServiceIndex = new Integer(222);
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
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#assertionConsumerServiceIndex(java.lang.Integer)}.
	 */
	@Test
	public void testAssertionConsumerServiceIndex() {
		final AuthnRequest request = testBuilder
				.assertionConsumerServiceIndex(testAssertionConsumerServiceIndex).create();
		assertEquals(testAssertionConsumerServiceIndex, request.getAssertionConsumerServiceIndex());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#assertionConsumerServiceUrl(java.lang.String)}.
	 */
	@Test
	public void testAssertionConsumerServiceURL() {
		final AuthnRequest request = testBuilder
				.assertionConsumerServiceUrl(testAssertionConsumerServiceURL).create();
		assertEquals(testAssertionConsumerServiceURL, request.getAssertionConsumerServiceUrl());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#attributeConsumingServiceIndex(java.lang.Integer)}.
	 */
	@Test
	public void testAttributeConsumingServiceIndex() {
		final AuthnRequest request = testBuilder
				.attributeConsumingServiceIndex(testAttributeConsumingServiceIndex).create();
		assertEquals(testAttributeConsumingServiceIndex,
				request.getAttributeConsumingServiceIndex());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#consent(java.lang.String)}.
	 */
	@Test
	public void testConsent() {
		final AuthnRequest request = testBuilder.consent(testConsent).create();
		assertEquals(testConsent, request.getConsent());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#destination(java.lang.String)}.
	 */
	@Test
	public void testDestination() {
		final AuthnRequest request = testBuilder.destination(testDestination).create();
		assertEquals(testDestination, request.getDestination());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#forceAuthn(java.lang.Boolean)}.
	 */
	@Test
	public void testForceAuthn() {
		final AuthnRequest request = testBuilder.forceAuthn(testForceAuthn).create();
		assertEquals(testForceAuthn, request.getForceAuthn());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#id(java.lang.String)}.
	 */
	@Test
	public void testId() {
		final AuthnRequest request = testBuilder.id(testId).create();
		assertEquals(testId, request.getId());
	}

	@Test
	public void testIdIssueInstant() {
		final AuthnRequest request = testBuilder.id(testId).issueInstant(testIssueInstant).create();
		assertEquals(testId, request.getId());
		assertEquals(testIssueInstant, request.getIssueInstant());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#issueInstant(java.util.Calendar)}.
	 */
	@Test
	public void testIssueInstant() {
		final AuthnRequest request = testBuilder.issueInstant(testIssueInstant).create();
		assertEquals(testIssueInstant, request.getIssueInstant());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#issuer(java.lang.String)}.
	 */
	@Test
	public void testIssuer() {
		final AuthnRequest request = testBuilder.issuer(testIssuer).create();
		assertEquals(testIssuer, request.getIssuer());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#nameIdPolicyAllowCreate(java.lang.Boolean)}.
	 */
	@Test
	public void testNameIdPolicyAllowCreate() {
		final AuthnRequest request = testBuilder
				.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate).create();
		assertEquals(testNameIdPolicyAllowCreate, request.getNameIdPolicyAllowCreate());
	}

	@Test
	public void testNameIdPolicyAllowCreateFormat() {
		final AuthnRequest request = testBuilder
				.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate)
				.nameIdPolicyFormat(testNameIdPolicyFormat).create();
		assertEquals(testNameIdPolicyAllowCreate, request.getNameIdPolicyAllowCreate());
		assertEquals(testNameIdPolicyFormat, request.getNameIdPolicyFormat());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#nameIdPolicyFormat(java.lang.String)}.
	 */
	@Test
	public void testNameIdPolicyFormat() {
		final AuthnRequest request = testBuilder.nameIdPolicyFormat(testNameIdPolicyFormat)
				.create();
		assertEquals(testNameIdPolicyFormat, request.getNameIdPolicyFormat());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#protocolBinding(java.lang.String)}.
	 */
	@Test
	public void testProtocolBinding() {
		final AuthnRequest request = testBuilder.protocolBinding(testProtocolBinding).create();
		assertEquals(testProtocolBinding, request.getProtocolBinding());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#providerName(java.lang.String)}.
	 */
	@Test
	public void testProviderName() {
		final AuthnRequest request = testBuilder.providerName(testProviderName).create();
		assertEquals(testProviderName, request.getProviderName());
	}
}
