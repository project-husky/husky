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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.security.authentication.AuthenticationModule;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.clients.IdpClient;
import org.ehealth_connector.security.communication.clients.XuaClient;
import org.ehealth_connector.security.communication.clients.impl.ClientFactory;
import org.ehealth_connector.security.communication.config.IdpClientConfig;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.xua.XUserAssertionModule;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.Initializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ConvenienceUserAccessAuthentication.</div>
 * <div class="de">Klasse die das Interface ConvenienceUserAccessAuthentication implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ConvenienceUserAccessAuthenticationImpl implements AuthenticationModule, XUserAssertionModule {

	/**
	 * Instantiates a new instance and initializes the OpenSaml Libraries.
	 *
	 * @throws InitializationException
	 */
	public ConvenienceUserAccessAuthenticationImpl() throws InitializationException {

		// This makes sure the Marshallers are loaded for serialisation!
		// Note: the initial implementation did not work under .net. It has been
		// therefore changed as follows:
		final List<Initializer> initializers = new ArrayList<>();
		initializers.add(new org.ehealth_connector.security.hl7v3.config.XmlObjectProviderInitializer());
		initializers.add(new org.opensaml.core.metrics.impl.MetricRegistryInitializer());
		initializers.add(new org.opensaml.core.xml.config.GlobalParserPoolInitializer());
		initializers.add(new org.opensaml.core.xml.config.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.saml.config.SAMLConfigurationInitializer());
		initializers.add(new org.opensaml.saml.config.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.security.config.ClientTLSValidationConfiguratonInitializer());
		initializers.add(new org.opensaml.soap.config.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.xmlsec.config.ApacheXMLSecurityInitializer());
		initializers.add(new org.opensaml.xmlsec.config.GlobalAlgorithmRegistryInitializer());
		initializers.add(new org.opensaml.xmlsec.config.GlobalSecurityConfigurationInitializer());
		initializers.add(new org.opensaml.xmlsec.config.JavaCryptoValidationInitializer());
		initializers.add(new org.opensaml.xmlsec.config.XMLObjectProviderInitializer());

		for (final Initializer initializer : initializers) {
			initializer.init();
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.xua.XUserAssertionModule#invokeGetXUserAssertion(org.ehealth_connector.security.core.SecurityHeaderElement,
	 *      org.ehealth_connector.security.communication.xua.XUserAssertionRequest,
	 *      org.ehealth_connector.security.communication.config.XuaClientConfig)
	 */
	@Override
	public List<XUserAssertionResponse> invokeGetXUserAssertion(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest, XuaClientConfig clientConfiguration) throws ClientSendException {
		final XuaClient client = ClientFactory.getXuaClient(clientConfiguration);
		return client.send(aSecurityHeaderElement, aRequest);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.authentication.AuthenticationModule#invokeUserAuthentication(org.ehealth_connector.security.authentication.AuthnRequest,
	 *      org.ehealth_connector.security.communication.config.IdpClientConfig)
	 */
	@Override
	public Object invokeUserAuthentication(AuthnRequest aAuthnRequest, IdpClientConfig clientConfiguration)
			throws ClientSendException {
		final IdpClient client = ClientFactory.getIdpClient(clientConfiguration);
		return client.send(aAuthnRequest);
	}

}
