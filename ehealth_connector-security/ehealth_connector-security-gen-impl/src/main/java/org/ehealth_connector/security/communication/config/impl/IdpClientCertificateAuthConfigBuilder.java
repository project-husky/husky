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
package org.ehealth_connector.security.communication.config.impl;

import java.security.KeyStore;

import org.ehealth_connector.security.communication.config.ClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client to communicate with client certificate.</div>
 * <div class="de">Klasser die das Interface ClienConfiguilder implementiert. Dient dazu eine Clientkonfiguration zu bilden für die Kommunikation mit Clientzertifikat.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientCertificateAuthConfigBuilder implements ClientConfigBuilder {

	private IdpClientCertificateAuthConfigImpl clientConfig;

	public IdpClientCertificateAuthConfigBuilder() {
		clientConfig = new IdpClientCertificateAuthConfigImpl();
	}

	IdpClientCertificateAuthConfigImpl create() {
		return clientConfig;
	}

	IdpClientCertificateAuthConfigBuilder keyStore(KeyStore clientKeyStore) {
		clientConfig.setClientKeyStore(clientKeyStore);
		return this;
	}

	public IdpClientCertificateAuthConfigBuilder keyStorePassword(String testStorePassword) {
		clientConfig.setClientKeyStorePassword(testStorePassword);
		return this;
	}

	@Override
	public IdpClientCertificateAuthConfigBuilder url(String aEndpointUrl) {
		return null;
	}

}
