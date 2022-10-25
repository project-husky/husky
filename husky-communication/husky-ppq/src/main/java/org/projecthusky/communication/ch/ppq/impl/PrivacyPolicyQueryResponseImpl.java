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
package org.projecthusky.communication.ch.ppq.impl;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.saml2.impl.AssertionBuilderImpl;
import org.projecthusky.xua.saml2.impl.StatusBuilderImpl;
import org.projecthusky.xua.saml2.impl.StatusImpl;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ResponseType;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Response;
import org.opensaml.saml.saml2.core.impl.ResponseBuilder;

/**
 * Class implementing the corresponding interfaces for PrivacyPolicyQueryResponse and SecurityObject.
 */
public class PrivacyPolicyQueryResponseImpl
		implements PrivacyPolicyQueryResponse, SecurityObject<Response> {

	private Response wrappedObject;

	protected PrivacyPolicyQueryResponseImpl(Response aInternalObject) {
		wrappedObject = aInternalObject;
	}

	protected PrivacyPolicyQueryResponseImpl(ResponseType aInternalObject) {

		wrappedObject = new ResponseBuilder().buildObject();
		wrappedObject.setStatus(
				((StatusImpl) new StatusBuilderImpl().create(aInternalObject.getStatus())).getWrappedObject());


		for (Object assertion : aInternalObject.getAssertionOrEncryptedAssertion()) {
			if (assertion instanceof AssertionType) {
					wrappedObject.getAssertions()
						.add((Assertion) new AssertionBuilderImpl().create((AssertionType) assertion)
									.getWrappedObject());
				}
			}

	}

	@Override
	public Response getWrappedObject() {
		return wrappedObject;
	}

}
