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

import java.security.KeyStore;

import org.projecthusky.xua.communication.config.ClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client to communicate with client certificate.</div>
 * <div class="de">Klasse die das Interface ClienConfiguilder implementiert. Dient dazu eine Client Konfiguration zu bilden für die Kommunikation mit Client Zertifikat.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientCertificateAuthConfigBuilder implements ClientConfigBuilder {

	private IdpClientCertificateAuthConfigImpl clientConfig;

	/**
	 * Default constructor
	 */
	public IdpClientCertificateAuthConfigBuilder() {
		clientConfig = new IdpClientCertificateAuthConfigImpl();
	}

	/**
	 * method to create
	 * 
	 * @return the client config
	 */
	public IdpClientCertificateAuthConfigImpl create() {
		return clientConfig;
	}

	/**
	 * Method to set
	 * 
	 * @param clientKeyStore the keystore to be set
	 * @return this builder instance
	 */
	public IdpClientCertificateAuthConfigBuilder keyStore(KeyStore clientKeyStore) {
		clientConfig.setClientKeyStore(clientKeyStore);
		return this;
	}

	/**
	 * Method to set
	 * 
	 * @param testStorePassword the password to be set
	 * @return this builder instance
	 */
	public IdpClientCertificateAuthConfigBuilder keyStorePassword(String testStorePassword) {
		clientConfig.setClientKeyStorePassword(testStorePassword);
		return this;
	}

	@Override
	public IdpClientCertificateAuthConfigBuilder url(String aEndpointUrl) {
		clientConfig.setUrl(aEndpointUrl);
		return this;
	}

}
