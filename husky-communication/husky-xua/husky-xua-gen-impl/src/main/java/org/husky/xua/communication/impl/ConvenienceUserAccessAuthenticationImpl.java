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
package org.husky.xua.communication.impl;

import java.util.ArrayList;
import java.util.List;

import org.husky.xua.authentication.AuthenticationModule;
import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.husky.xua.communication.config.IdpClientConfig;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.xua.XUserAssertionModule;
import org.husky.xua.communication.xua.XUserAssertionRequest;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.exceptions.ClientSendException;
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
public class ConvenienceUserAccessAuthenticationImpl
		implements AuthenticationModule, XUserAssertionModule {

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
		initializers.add(
				new org.husky.xua.hl7v3.config.XmlObjectProviderInitializer());
		initializers.add(new org.opensaml.core.metrics.impl.MetricRegistryInitializer());
		initializers.add(new org.opensaml.core.xml.config.GlobalParserPoolInitializer());
		initializers.add(new org.opensaml.core.xml.config.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.saml.config.impl.SAMLConfigurationInitializer());
		initializers.add(new org.opensaml.saml.config.impl.XMLObjectProviderInitializer());
		initializers
				.add(new org.opensaml.security.config.impl.ClientTLSValidationConfiguratonInitializer());
		initializers.add(new org.opensaml.soap.config.impl.XMLObjectProviderInitializer());
		initializers.add(new org.opensaml.xmlsec.config.impl.ApacheXMLSecurityInitializer());
		initializers.add(new org.opensaml.xmlsec.config.GlobalAlgorithmRegistryInitializer());
		initializers.add(new org.opensaml.xmlsec.config.impl.GlobalSecurityConfigurationInitializer());
		initializers.add(new org.opensaml.xmlsec.config.impl.JavaCryptoValidationInitializer());
		initializers.add(new org.opensaml.xmlsec.config.impl.XMLObjectProviderInitializer());

		for (final Initializer initializer : initializers) {
			initializer.init();
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.xua.XUserAssertionModule#invokeGetXUserAssertion(org.husky.xua.core.SecurityHeaderElement,
	 *      org.husky.xua.communication.xua.XUserAssertionRequest,
	 *      org.husky.xua.communication.config.XuaClientConfig)
	 */
	@Override
	public List<XUserAssertionResponse> invokeGetXUserAssertion(
			SecurityHeaderElement aSecurityHeaderElement, XUserAssertionRequest aRequest,
			XuaClientConfig clientConfiguration) throws ClientSendException {
		final var client = ClientFactory.getXuaClient(clientConfiguration);
		return client.send(aSecurityHeaderElement, aRequest);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.authentication.AuthenticationModule#invokeUserAuthentication(org.husky.xua.authentication.AuthnRequest,
	 *      org.husky.xua.communication.config.IdpClientConfig)
	 */
	@Override
	public Object invokeUserAuthentication(AuthnRequest aAuthnRequest,
			IdpClientConfig clientConfiguration) throws ClientSendException {
		final var client = ClientFactory.getIdpClient(clientConfiguration);
		return client.send(aAuthnRequest);
	}

}
