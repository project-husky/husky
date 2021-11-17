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
package org.husky.xua.communication.xua.impl;

import java.util.List;

import javax.xml.namespace.QName;

import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestedSecurityToken;
import org.opensaml.soap.wstrust.Status;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XUserAssertionResponse and SecurityObject</div>
 * <div class="de">Implementations Klasse von Interface XUserAssertionResponse und SecurityObject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionResponseImpl implements XUserAssertionResponse,
		SecurityObject<org.opensaml.soap.wstrust.RequestSecurityTokenResponse> {

	private RequestSecurityTokenResponse responseCollection;

	protected XUserAssertionResponseImpl(
			RequestSecurityTokenResponse aRequestSecurityTokenResponse) {
		responseCollection = aRequestSecurityTokenResponse;
	}

	@Override
	public Assertion getAssertion() {
		final List<XMLObject> requestedTokens = responseCollection.getUnknownXMLObjects(new QName(
				"http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedSecurityToken"));
		if (!requestedTokens.isEmpty()) {
			final RequestedSecurityToken token = (RequestedSecurityToken) requestedTokens.get(0);
			return new AssertionBuilderImpl()
					.create((org.opensaml.saml.saml2.core.Assertion) token.getUnknownXMLObject());

		}
		return null;
	}

	@Override
	public String getContext() {
		return responseCollection.getContext();
	}

	@Override
	public String getStatus() {
		final List<XMLObject> statusses = responseCollection.getUnknownXMLObjects(
				new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Status"));
		if (!statusses.isEmpty() && (statusses.get(0) != null)
				&& (((Status) statusses.get(0)).getCode() != null)) {
			return ((Status) statusses.get(0)).getCode().getURI();
		}
		return null;
	}

	@Override
	public RequestSecurityTokenResponse getWrappedObject() {
		return responseCollection;
	}
}
