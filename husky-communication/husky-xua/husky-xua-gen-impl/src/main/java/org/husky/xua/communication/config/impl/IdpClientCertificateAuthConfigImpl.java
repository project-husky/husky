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

import java.security.KeyStore;

import org.husky.xua.communication.config.IdpClientConfig;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface IdpClientCertificateAuthConfigImpl</div>
 * <div class="de">Implementations Klasse von Interface IdpClientCertificateAuthConfigImpl</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientCertificateAuthConfigImpl extends AbstractClientConfig
		implements IdpClientConfig {

	private KeyStore clientKeyStore;

	private char[] clientKeyStorePassword;

	protected IdpClientCertificateAuthConfigImpl() {

	}

	public KeyStore getClientKeyStore() {
		return clientKeyStore;
	}

	public char[] getClientKeyStorePassword() {
		return clientKeyStorePassword;
	}

	public void setClientKeyStore(KeyStore clientKeyStore) {
		this.clientKeyStore = clientKeyStore;
	}

	public void setClientKeyStorePassword(String aPassword) {
		if ((aPassword != null) && !aPassword.isEmpty()) {
			clientKeyStorePassword = aPassword.toCharArray();
		}
	}

}
