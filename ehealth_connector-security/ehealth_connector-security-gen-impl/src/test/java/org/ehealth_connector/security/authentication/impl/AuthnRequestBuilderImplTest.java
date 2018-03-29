/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication.impl;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.UUID;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.AuthnRequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.NameID;

/**
 * @since Feb 20, 2018 3:17:34 PM
 *
 */
public class AuthnRequestBuilderImplTest {

	public AuthnRequestBuilder testBuilder;
	private String testId;
	private Calendar testIssueInstant;
	private Integer testAssertionConsumerServiceIndex;
	private String testAssertionConsumerServiceURL;
	private Integer testAttributeConsumingServiceIndex;
	private String testDestination;
	private String testProviderName;
	private String testConsent;
	private String testProtocolBinding;
	private Boolean testForceAuthn;
	private String testIssuer;
	private Boolean testNameIdPolicyAllowCreate;
	private String testNameIdPolicyFormat;

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
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#id(java.lang.String)}.
	 */
	@Test
	public void testId() {
		final AuthnRequest request = testBuilder.id(testId).createAuthnRequest();
		assertEquals(testId, request.getID());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#issueInstant(java.util.Calendar)}.
	 */
	@Test
	public void testIssueInstant() {
		final AuthnRequest request = testBuilder.issueInstant(testIssueInstant).createAuthnRequest();
		assertEquals(testIssueInstant, request.getIssueInstant());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#assertionConsumerServiceIndex(java.lang.Integer)}.
	 */
	@Test
	public void testAssertionConsumerServiceIndex() {
		final AuthnRequest request = testBuilder.assertionConsumerServiceIndex(testAssertionConsumerServiceIndex)
				.createAuthnRequest();
		assertEquals(testAssertionConsumerServiceIndex, request.getAssertionConsumerServiceIndex());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#assertionConsumerServiceURL(java.lang.String)}.
	 */
	@Test
	public void testAssertionConsumerServiceURL() {
		final AuthnRequest request = testBuilder.assertionConsumerServiceURL(testAssertionConsumerServiceURL)
				.createAuthnRequest();
		assertEquals(testAssertionConsumerServiceURL, request.getAssertionConsumerServiceURL());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#attributeConsumingServiceIndex(java.lang.Integer)}.
	 */
	@Test
	public void testAttributeConsumingServiceIndex() {
		final AuthnRequest request = testBuilder.attributeConsumingServiceIndex(testAttributeConsumingServiceIndex)
				.createAuthnRequest();
		assertEquals(testAttributeConsumingServiceIndex, request.getAttributeConsumingServiceIndex());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#destination(java.lang.String)}.
	 */
	@Test
	public void testDestination() {
		final AuthnRequest request = testBuilder.destination(testDestination).createAuthnRequest();
		assertEquals(testDestination, request.getDestination());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#providerName(java.lang.String)}.
	 */
	@Test
	public void testProviderName() {
		final AuthnRequest request = testBuilder.providerName(testProviderName).createAuthnRequest();
		assertEquals(testProviderName, request.getProviderName());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#protocolBinding(java.lang.String)}.
	 */
	@Test
	public void testProtocolBinding() {
		final AuthnRequest request = testBuilder.protocolBinding(testProtocolBinding).createAuthnRequest();
		assertEquals(testProtocolBinding, request.getProtocolBinding());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#consent(java.lang.String)}.
	 */
	@Test
	public void testConsent() {
		final AuthnRequest request = testBuilder.consent(testConsent).createAuthnRequest();
		assertEquals(testConsent, request.getConsent());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#forceAuthn(java.lang.Boolean)}.
	 */
	@Test
	public void testForceAuthn() {
		final AuthnRequest request = testBuilder.forceAuthn(testForceAuthn).createAuthnRequest();
		assertEquals(testForceAuthn, request.getForceAuthn());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#issuer(java.lang.String)}.
	 */
	@Test
	public void testIssuer() {
		final AuthnRequest request = testBuilder.issuer(testIssuer).createAuthnRequest();
		assertEquals(testIssuer, request.getIssuer());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#nameIdPolicyAllowCreate(java.lang.Boolean)}.
	 */
	@Test
	public void testNameIdPolicyAllowCreate() {
		final AuthnRequest request = testBuilder.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate)
				.createAuthnRequest();
		assertEquals(testNameIdPolicyAllowCreate, request.getNameIdPolicyAllowCreate());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.authentication.impl.AuthnRequestBuilderImpl#nameIdPolicyFormat(java.lang.String)}.
	 */
	@Test
	public void testNameIdPolicyFormat() {
		final AuthnRequest request = testBuilder.nameIdPolicyFormat(testNameIdPolicyFormat).createAuthnRequest();
		assertEquals(testNameIdPolicyFormat, request.getNameIdPolicyFormat());
	}

	@Test
	public void testIdIssueInstant() {
		final AuthnRequest request = testBuilder.id(testId).issueInstant(testIssueInstant).createAuthnRequest();
		assertEquals(testId, request.getID());
		assertEquals(testIssueInstant, request.getIssueInstant());
	}

	@Test
	public void testNameIdPolicyAllowCreateFormat() {
		final AuthnRequest request = testBuilder.nameIdPolicyAllowCreate(testNameIdPolicyAllowCreate)
				.nameIdPolicyFormat(testNameIdPolicyFormat).createAuthnRequest();
		assertEquals(testNameIdPolicyAllowCreate, request.getNameIdPolicyAllowCreate());
		assertEquals(testNameIdPolicyFormat, request.getNameIdPolicyFormat());
	}
}
