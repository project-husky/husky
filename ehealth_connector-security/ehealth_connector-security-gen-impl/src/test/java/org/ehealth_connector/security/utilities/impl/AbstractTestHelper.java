/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.utilities.impl;

import java.util.Calendar;
import java.util.UUID;

import org.junit.Before;
import org.junit.BeforeClass;
import org.opensaml.DefaultBootstrap;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.core.NameID;

/**
 * @since Feb 21, 2018 2:57:35 PM
 *
 */
public abstract class AbstractTestHelper {

	protected String testId;
	protected Calendar testIssueInstant;
	protected Integer testAssertionConsumerServiceIndex;
	protected String testAssertionConsumerServiceURL;
	protected Integer testAttributeConsumingServiceIndex;
	protected String testDestination;
	protected String testProviderName;
	protected String testConsent;
	protected String testProtocolBinding;
	protected Boolean testForceAuthn;
	protected String testIssuer;
	protected Boolean testNameIdPolicyAllowCreate;
	protected String testNameIdPolicyFormat;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Initialize the library
		DefaultBootstrap.bootstrap();
	}

	@Before
	public void setUp() throws Exception {

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

}
