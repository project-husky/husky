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
package org.projecthusky.communication.ch.ppq;

import java.util.ArrayList;
import java.util.List;

import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryModule;
import org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.projecthusky.communication.ch.ppq.api.config.PpClientConfig;
import org.projecthusky.communication.ch.ppq.impl.clients.ClientFactoryCh;
import org.projecthusky.xua.communication.impl.ConvenienceUserAccessAuthenticationImpl;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.Initializer;

/**
 * Class implementing the interface ConvenienceUserAccessAuthentication for CH.
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
		List<Initializer> initializers = new ArrayList<>();
		initializers.add(
				new org.projecthusky.communication.ch.ppq.epr.config.EprObjectProviderInitializer());
		initializers.add(new org.opensaml.xacml.config.impl.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.xacml.profile.saml.config.impl.XMLObjectProviderInitializer());
		for (Initializer initializer : initializers) {
			initializer.init();
		}

	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryModule#invokePrivacyPolicyFeed(org.projecthusky.xua.core.SecurityHeaderElement,
	 *      org.projecthusky.communication.ch.ppq.api.PrivacyPolicyFeed,
	 *      org.projecthusky.communication.ch.ppq.api.config.PpClientConfig)
	 */
	@Override
	public PrivacyPolicyFeedResponse invokePrivacyPolicyFeed(SecurityHeaderElement aAssertion,
			PrivacyPolicyFeed feed, PpClientConfig clientConfiguration) throws ClientSendException {
		final var client = ClientFactoryCh.getPpfClient(clientConfiguration);
		PrivacyPolicyFeedResponse response = client.send(aAssertion, feed);

		if (response != null) {
			return response;
		}

		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQueryModule#invokePrivacyPolicyQuery(org.projecthusky.xua.core.SecurityHeaderElement,
	 *      org.projecthusky.communication.ch.ppq.api.PrivacyPolicyQuery,
	 *      org.projecthusky.communication.ch.ppq.api.config.PpClientConfig)
	 */
	@Override
	public PrivacyPolicyQueryResponse invokePrivacyPolicyQuery(SecurityHeaderElement aAssertion,
			PrivacyPolicyQuery query, PpClientConfig clientConfiguration)
			throws ClientSendException {
		final var client = ClientFactoryCh.getPpqClient(clientConfiguration);
		return client.send(aAssertion, query);

	}

}
