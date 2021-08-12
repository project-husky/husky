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

import org.ehealth_connector.xua.saml2.Status;
import org.ehealth_connector.xua.saml2.StatusCode;
import org.ehealth_connector.xua.saml2.impl.StatusBuilderImpl;
import org.ehealth_connector.xua.saml2.impl.StatusImpl;
import org.junit.Before;
import org.junit.Test;

public class StatusBuilderImplTest {

	private StatusBuilderImpl builder;
	private org.opensaml.saml.saml2.core.Status testInnerObject;
	private StatusCode testStatusCode;
	private String testStatusMessage;

	@Before
	public void setUp() throws Exception {
		builder = new StatusBuilderImpl();
		testInnerObject = new org.opensaml.saml.saml2.core.impl.StatusBuilder().buildObject();
		final org.opensaml.saml.saml2.core.StatusCode testInnerStatusCode = new org.opensaml.saml.saml2.core.impl.StatusCodeBuilder()
				.buildObject();
		testInnerStatusCode.setValue(org.opensaml.saml.saml2.core.StatusCode.AUTHN_FAILED);
		testInnerObject.setStatusCode(testInnerStatusCode);
		testStatusCode = StatusCode.NO_AVAILABLE_IDP;

		testStatusMessage = "This is a Mesage of the Status";
	}

	@Test
	public void testCreateStatus() {
		final Status ref = builder.create(testInnerObject);
		assertEquals(testInnerObject, ((StatusImpl) ref).getWrappedObject());
	}

	@Test
	public void testStatusCode() {
		final Status ref = builder.statusCode(testStatusCode).create();
		assertEquals(testStatusCode, ref.getStatusCode());
	}

	@Test
	public void testStatusMessage() {
		final Status ref = builder.statusMessage(testStatusMessage).create();
		assertEquals(testStatusMessage, ref.getStatusMessage());
	}

}
