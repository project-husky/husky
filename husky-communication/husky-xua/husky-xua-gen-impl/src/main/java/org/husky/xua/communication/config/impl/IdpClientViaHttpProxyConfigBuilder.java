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
package org.husky.xua.communication.config.impl;

import org.husky.xua.communication.config.ClientConfigBuilder;

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

	public IdpClientViaHttpProxyConfigBuilder() {
		clientConfig = new IdpClientViaHttpProxyConfigImpl();
	}

	public IdpClientViaHttpProxyConfigImpl create() {
		return clientConfig;
	}

	public IdpClientViaHttpProxyConfigBuilder proxyHost(String aProxyHost) {
		clientConfig.setProxyHost(aProxyHost);
		return this;
	}

	public IdpClientViaHttpProxyConfigBuilder proxyPort(int aProxyPort) {
		clientConfig.setProxyPort(aProxyPort);
		return this;
	}

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
