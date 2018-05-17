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
package org.ehealth_connector.security.ch.ppq.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.ehealth_connector.security.ch.ppq.PrivacyPolicyQuery;
import org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl;
import org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryImpl;
import org.ehealth_connector.security.hl7v3.InstanceIdentifier;
import org.ehealth_connector.security.hl7v3.impl.InstanceIdentifierBuilder;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.xacml.profile.saml.XACMLPolicyQueryType;
import org.opensaml.xacml.profile.saml.impl.XACMLPolicyQueryTypeUnmarshaller;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class PrivacyPolicyQueryBuilderImplTest extends InitializerTestHelper {

	private PrivacyPolicyQueryBuilderImpl builder;
	private XACMLPolicyQueryType testXacmlPolicyQuery;

	private String testId;

	private Calendar testIssueInstant;

	private String testIssuer;

	private String testVersion;

	private String testConsent;

	private String testDestination;

	private String testInstanceIdentifierRoot;
	private String testInstanceIdentifierExt;
	private InstanceIdentifier testInstanceIdentifier;

	@Before
	public void setUp() throws Exception {
		builder = new PrivacyPolicyQueryBuilderImpl();
		testXacmlPolicyQuery = loadTestPolicySet();
		testId = UUID.randomUUID().toString();
		testIssueInstant = Calendar.getInstance();
		testIssuer = "An Issuert does it";
		testVersion = "2.0";
		testConsent = "This is the consent of";
		testDestination = "The destination";

		testInstanceIdentifierRoot = "2.16.756.5.30.1.127.3.10.3";
		testInstanceIdentifierExt = "761337610455909127";

		testInstanceIdentifier = new InstanceIdentifierBuilder().buildObject();
		testInstanceIdentifier.setRoot(testInstanceIdentifierRoot);
		testInstanceIdentifier.setExtension(testInstanceIdentifierExt);
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#id(java.lang.String)}.
	 */
	@Test
	public void testId() {
		final PrivacyPolicyQuery ref = builder.id(testId).create();
		assertNotNull(ref);
		assertEquals(testId, ref.getId());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#issueInstant(java.util.Calendar)}.
	 */
	@Test
	public void testIssueInstant() {
		final PrivacyPolicyQuery ref = builder.issueInstant(testIssueInstant).create();
		assertNotNull(ref);
		assertEquals(testIssueInstant, ref.getIssueInstant());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#issuer(java.lang.String)}.
	 */
	@Test
	public void testIssuer() {
		final PrivacyPolicyQuery ref = builder.issuer(testIssuer).create();
		assertNotNull(ref);
		assertEquals(testIssuer, ref.getIssuer());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#version(java.lang.String)}.
	 */
	@Test
	public void testVersion() {
		final PrivacyPolicyQuery ref = builder.version(testVersion).create();
		assertNotNull(ref);
		assertEquals(testVersion, ref.getVersion());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#version(java.lang.String)}.
	 */
	@Test
	public void testInstanceIdentifier() {
		final PrivacyPolicyQuery ref = builder.instanceIdentifier(testInstanceIdentifier).create();
		assertNotNull(ref);
		assertEquals(testInstanceIdentifier, ref.getInstanceIdentifier());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#consent(java.lang.String)}.
	 */
	@Test
	public void testConsent() {
		final PrivacyPolicyQuery ref = builder.consent(testConsent).create();
		assertNotNull(ref);
		assertEquals(testConsent, ref.getConsent());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#destination(java.lang.String)}.
	 */
	@Test
	public void testDestination() {
		final PrivacyPolicyQuery ref = builder.destination(testDestination).create();
		assertNotNull(ref);
		assertEquals(testDestination, ref.getDestination());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyQueryBuilderImpl#create(org.opensaml.xacml.profile.saml.XACMLPolicyQueryType)}.
	 */
	@Test
	public void testCreateXACMLPolicyQueryType() {
		final PrivacyPolicyQuery ref = builder.create(testXacmlPolicyQuery);
		assertNotNull(ref);
		assertEquals(testXacmlPolicyQuery, ((PrivacyPolicyQueryImpl) ref).getWrappedObject());
	}

	private XACMLPolicyQueryType loadTestPolicySet()
			throws UnmarshallingException, SAXException, IOException, ParserConfigurationException {
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		final Document doc = dbf.newDocumentBuilder()
				.parse(this.getClass().getResourceAsStream("/xacml/xacml_policy_query.xml"));
		return (XACMLPolicyQueryType) new XACMLPolicyQueryTypeUnmarshaller().unmarshall(doc.getDocumentElement());
	}

}
