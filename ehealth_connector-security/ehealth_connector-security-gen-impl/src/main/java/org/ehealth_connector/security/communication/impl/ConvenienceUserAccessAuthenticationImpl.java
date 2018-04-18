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
package org.ehealth_connector.security.communication.impl;

import java.util.List;

import org.ehealth_connector.security.authentication.AuthenticationModule;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.clients.XuaClient;
import org.ehealth_connector.security.communication.clients.impl.AbstractIdpClient;
import org.ehealth_connector.security.communication.clients.impl.ClientFactory;
import org.ehealth_connector.security.communication.config.IdpClientConfig;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.xua.XUserAssertionModule;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.saml2.Response;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ConvenienceUserAccessAuthentication.</div>
 * <div class="de">Klasse die das Interface ConvenienceUserAccessAuthentication implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class ConvenienceUserAccessAuthenticationImpl implements AuthenticationModule, XUserAssertionModule {

	/**
	 * {@inheritDoc}
	 * 
	 * @throws ClientSendException
	 *
	 * @see org.ehealth_connector.security.communication.ConvenienceUserAccessAuthentication#invokeUserAuthentication(org.ehealth_connector.security.authentication.AuthnRequest,
	 *      org.ehealth_connector.security.communication.config.IdpClientConfig)
	 */
	@Override
	public Response invokeUserAuthentication(AuthnRequest aAuthnRequest, IdpClientConfig clientConfiguration)
			throws ClientSendException {
		final AbstractIdpClient client = ClientFactory.getIdpClient(clientConfiguration);
		return client.send(aAuthnRequest);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.ConvenienceUserAccessAuthentication#invokeGetXUserAssertion(org.ehealth_connector.security.saml2.Assertion,
	 *      org.ehealth_connector.security.communication.xua.XUserAssertionRequest,
	 *      org.ehealth_connector.security.communication.config.XuaClientConfig)
	 */
	@Override
	public List<XUserAssertionResponse> invokeGetXUserAssertion(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest, XuaClientConfig clientConfiguration) throws ClientSendException {
		final XuaClient client = ClientFactory.getXuaClient(clientConfiguration);
		return client.send(aSecurityHeaderElement, aRequest);
	}

}
