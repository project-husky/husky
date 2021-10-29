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
package org.husky.xua.communication.clients.impl;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.saml2.Response;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the IdP Client with cert authentication.</div>
 * <div class="de">Klasse die den IdP Client mit Cert Authentication implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientByCert extends AbstractHttpFormIdpClient {

	private IdpClientCertificateAuthConfigImpl config;

	public IdpClientByCert(IdpClientCertificateAuthConfigImpl clientConfiguration) {
		config = clientConfiguration;

	}

	@Override
	public CloseableHttpClient getHttpClient() throws ClientSendException {
		try {
			final var sslContext = SSLContexts.custom()
					.loadKeyMaterial(config.getClientKeyStore(), config.getClientKeyStorePassword())
					.build();
			return HttpClients.custom().setSSLContext(sslContext).build();
		} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException
				| KeyStoreException e) {
			throw new ClientSendException(e);
		}

	}

	@Override
	public RequestConfig getRequestConfig() {
		return RequestConfig.custom().build();
	}

	@Override
	public Response send(AuthnRequest aAuthnRequest) throws ClientSendException {
		try {
			final var post = getHttpPost(aAuthnRequest, config);

			return execute(post);
		} catch (final Exception t) {
			throw new ClientSendException(t);
		}
	}

}
