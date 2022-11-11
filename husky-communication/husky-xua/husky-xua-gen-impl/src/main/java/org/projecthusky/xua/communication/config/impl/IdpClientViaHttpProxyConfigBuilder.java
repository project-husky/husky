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
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client to communicate via a proxy.</div>
 * <div class="de">Klasse die das Interface ClienConfiguilder implementiert. Dient dazu eine Client Konfiguration zu bilden für die Kommunikation über einen Proxy.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientViaHttpProxyConfigBuilder implements ClientConfigBuilder {

	private IdpClientViaHttpProxyConfigImpl clientConfig;

	/**
	 * Default constructor
	 */
	public IdpClientViaHttpProxyConfigBuilder() {
		clientConfig = new IdpClientViaHttpProxyConfigImpl();
	}

	/**
	 * Method to create config.
	 * 
	 * @return the buildet config
	 */
	public IdpClientViaHttpProxyConfigImpl create() {
		return clientConfig;
	}

	/**
	 * Method to set
	 * 
	 * @param aProxyHost the proxy host
	 * @return this instance of the builder
	 */
	public IdpClientViaHttpProxyConfigBuilder proxyHost(String aProxyHost) {
		clientConfig.setProxyHost(aProxyHost);
		return this;
	}

	/**
	 * Method to set
	 * 
	 * @param aProxyPort the proxy port
	 * @return this instance of the builder
	 */
	public IdpClientViaHttpProxyConfigBuilder proxyPort(int aProxyPort) {
		clientConfig.setProxyPort(aProxyPort);
		return this;
	}

	/**
	 * Method to set
	 * 
	 * @param aProxyProtocol the proxy protocol
	 * @return this instance of the builder
	 */
	public IdpClientViaHttpProxyConfigBuilder proxyProtocol(String aProxyProtocol) {
		clientConfig.setProxyProtocol(aProxyProtocol);
		return this;
	}

	@Override
	public IdpClientViaHttpProxyConfigBuilder url(String aEndpointUrl) {
		clientConfig.setUrl(aEndpointUrl);
		return this;
	}

}
