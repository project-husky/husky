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
