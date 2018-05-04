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
package org.ehealth_connector.communication.ch.impl;

import org.ehealth_connector.communication.ch.clients.PpqClient;
import org.ehealth_connector.communication.ch.clients.impl.ClientFactoryCh;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQueryModule;
import org.ehealth_connector.communication.ch.ppq.config.PpqClientConfig;
import org.ehealth_connector.security.communication.impl.ConvenienceUserAccessAuthenticationImpl;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.saml2.Response;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ConvenienceUserAccessAuthentication for CH.</div>
 * <div class="de">Klasse die das Interface ConvenienceUserAccessAuthentication für CH implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class ConvenienceUserAccessAuthenticationChImpl extends ConvenienceUserAccessAuthenticationImpl
		implements PrivacyPolicyQueryModule {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @throws ClientSendException
	 *
	 * @see org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQueryModule#invokePPQ(org.ehealth_connector.security.saml2.Assertion,
	 *      org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery, org.ehealth_connector.communication.ch.ppq.config.PpqClientConfig)
	 */
	@Override
	public Response invokePPQ(SecurityHeaderElement aAssertion, PrivacyPolicyQuery query,
			PpqClientConfig clientConfiguration) throws ClientSendException {
		if (!initialized)
			throw new ClientSendException("Opensaml Libs are not initialized");
		final PpqClient client = ClientFactoryCh.getPpqClient(clientConfiguration);
		return client.send(aAssertion, query);
	}

}
