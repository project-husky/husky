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

import org.husky.xua.saml2.Status;
import org.husky.xua.saml2.StatusCode;
import org.husky.xua.saml2.impl.StatusBuilderImpl;
import org.husky.xua.saml2.impl.StatusImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatusBuilderImplTest {

	private StatusBuilderImpl builder;
	private org.opensaml.saml.saml2.core.Status testInnerObject;
	private StatusCode testStatusCode;
	private String testStatusMessage;

	@BeforeEach
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
