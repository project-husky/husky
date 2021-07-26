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
package org.ehealth_connector.security.saml2.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.ehealth_connector.security.saml2.EncryptedAssertion;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.xmlsec.encryption.EncryptedData;

public class EncryptedAssertionBuilderImplTest {

	private EncryptedAssertionBuilderImpl builder;
	private String testId;
	private org.opensaml.saml.saml2.core.EncryptedAssertion testInnerObject;

	@Before
	public void setUp() throws Exception {
		builder = new EncryptedAssertionBuilderImpl();
		testInnerObject = new org.opensaml.saml.saml2.core.impl.EncryptedAssertionBuilder()
				.buildObject();
		final EncryptedData newEncryptedData = new org.opensaml.xmlsec.encryption.impl.EncryptedDataBuilder()
				.buildObject();
		testId = UUID.randomUUID().toString();
		newEncryptedData.setID(testId);
		testInnerObject.setEncryptedData(newEncryptedData);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.EncryptedAssertionBuilderImpl#create()}.
	 */
	@Test
	public void testCreate() {
		final EncryptedAssertion ref = builder.create();
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.EncryptedAssertionBuilderImpl#create(org.opensaml.saml.saml2.core.EncryptedAssertion)}.
	 */
	@Test
	public void testCreateEncryptedAssertion() {
		final EncryptedAssertion ref = builder.create(testInnerObject);
		assertEquals(testInnerObject, ((EncryptedAssertionImpl) ref).getWrappedObject());
	}

}
