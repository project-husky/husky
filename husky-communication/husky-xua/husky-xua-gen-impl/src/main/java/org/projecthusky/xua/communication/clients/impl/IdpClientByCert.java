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
package org.projecthusky.xua.communication.clients.impl;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.saml2.Response;

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
