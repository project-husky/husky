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
package org.projecthusky.xua.communication.config.impl;

import org.projecthusky.xua.communication.config.ClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client to communicate with client certificate.</div>
 * <div class="de">Klasse die das Interface ClienConfiguilder implementiert. Dient dazu eine Client Konfiguration zu bilden für die Kommunikation mit Client Zertifikat.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl implements ClientConfigBuilder {

	private IdpClientByBrowserAndProtocolHandlerConfigImpl clientConfig;

	/**
	 * Default constructor
	 */
	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl() {
		clientConfig = new IdpClientByBrowserAndProtocolHandlerConfigImpl();
		clientConfig.setSamlRequestType(IdpClientByBrowserAndProtocolHandlerConfigImpl.SamlRequestType.SAMLART);
	}

	/**
	 * Method to create the config
	 * 
	 * @return the config buildet
	 */
	public IdpClientByBrowserAndProtocolHandlerConfigImpl create() {
		return clientConfig;
	}

	/**
	 * Method to set
	 * @param aProtocolHandlerName the protocol handler name
	 * @return this builder instance
	 */
	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl protocolHandlerName(String aProtocolHandlerName) {
		clientConfig.setProtocolHandlerName(aProtocolHandlerName);
		return this;
	}

	/**
	 * Method to set
	 * @param samlRequestType the saml request typ
	 * @return this builder instance
	 */
	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl samlRequestType(
			IdpClientByBrowserAndProtocolHandlerConfigImpl.SamlRequestType samlRequestType) {
		clientConfig.setSamlRequestType(samlRequestType);
		return this;
	}

	@Override
	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl url(String aEndpointUrl) {
		clientConfig.setUrl(aEndpointUrl);
		return this;
	}

}
