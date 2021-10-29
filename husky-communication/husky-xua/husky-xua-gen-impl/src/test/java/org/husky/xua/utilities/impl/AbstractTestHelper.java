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
package org.husky.xua.utilities.impl;

import java.util.Calendar;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.opensaml.saml.common.xml.SAMLConstants;
import org.opensaml.saml.saml2.core.NameID;

public abstract class AbstractTestHelper extends InitializerTestHelper {

	protected Integer testAssertionConsumerServiceIndex;
	protected String testAssertionConsumerServiceURL;
	protected Integer testAttributeConsumingServiceIndex;
	protected String testAttributeName;
	protected String testAttributeValue;
	protected String testConsent;
	protected String testDestination;
	protected Boolean testForceAuthn;
	protected String testId;
	protected Calendar testIssueInstant;
	protected String testIssuer;
	protected Boolean testNameIdPolicyAllowCreate;
	protected String testNameIdPolicyFormat;
	protected String testProtocolBinding;
	protected String testProviderName;

	@BeforeEach
	public void setUp() throws Exception {

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
		testAttributeName = "My Attribute Name";
		testAttributeValue = "My Attribute Value";
	}

}
