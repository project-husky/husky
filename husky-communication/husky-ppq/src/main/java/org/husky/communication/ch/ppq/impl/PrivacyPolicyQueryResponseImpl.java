/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.ppq.impl;

import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.husky.xua.saml2.impl.StatusBuilderImpl;
import org.husky.xua.saml2.impl.StatusImpl;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ResponseType;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.saml.saml2.core.Response;
import org.opensaml.saml.saml2.core.impl.ResponseBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interfaces for PrivacyPolicyQueryResponse and SecurityObject.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interfaces PrivacyPolicyQueryResponse und SecurityObject.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
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
