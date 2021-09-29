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
package org.ehealth_connector.communication.ch.ppq;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryModule;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.ehealth_connector.xua.communication.impl.ConvenienceUserAccessAuthenticationImpl;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.Initializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ConvenienceUserAccessAuthentication for CH.</div>
 * <div class="de">Klasse die das Interface ConvenienceUserAccessAuthentication für CH implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ConvenienceUserAccessAuthenticationChImpl
		extends ConvenienceUserAccessAuthenticationImpl implements PrivacyPolicyQueryModule {

	/**
	 * Instantiates a new instance and initializes the OpenSaml Libraries.
	 *
	 * @throws InitializationException
	 */
	public ConvenienceUserAccessAuthenticationChImpl() throws InitializationException {
		super();

		// This makes sure the Marshallers are loaded for serialisation!
		// Note: the initial implementation did not work under .net. It has been
		// therefore changed as follows:
		List<Initializer> initializers = new ArrayList<Initializer>();
		initializers.add(
				new org.ehealth_connector.communication.ch.ppq.epr.config.EprObjectProviderInitializer());
		initializers.add(new org.opensaml.xacml.config.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.xacml.profile.saml.config.XMLObjectProviderInitializer());
		for (Initializer initializer : initializers) {
			initializer.init();
		}

	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryModule#invokePrivacyPolicyFeed(org.ehealth_connector.xua.core.SecurityHeaderElement,
	 *      org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed,
	 *      org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig)
	 */
	@Override
	public PrivacyPolicyFeedResponse invokePrivacyPolicyFeed(SecurityHeaderElement aAssertion,
			PrivacyPolicyFeed feed, PpClientConfig clientConfiguration) throws ClientSendException {
		final var client = ClientFactoryCh.getPpfClient(clientConfiguration);
		PrivacyPolicyFeedResponse response = client.send(aAssertion, feed);

		if (response != null) {

		}

		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQueryModule#invokePrivacyPolicyQuery(org.ehealth_connector.xua.core.SecurityHeaderElement,
	 *      org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyQuery,
	 *      org.ehealth_connector.communication.ch.ppq.api.config.PpClientConfig)
	 */
	@Override
	public PrivacyPolicyQueryResponse invokePrivacyPolicyQuery(SecurityHeaderElement aAssertion,
			PrivacyPolicyQuery query, PpClientConfig clientConfiguration)
			throws ClientSendException {
		final var client = ClientFactoryCh.getPpqClient(clientConfiguration);
		return client.send(aAssertion, query);

	}

}
