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
package org.projecthusky.xua.communication.xua.impl.ch.integration;

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
		testProviderName = "IG Husky";
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
