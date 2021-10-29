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

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.communication.config.impl.IdpClientViaHttpProxyConfigImpl;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.saml2.Response;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the IdP Client using auth proxy like e.g. HIN Client.</div>
 * <div class="de">Klasse die den IdP Client unter Verwendung eines auth proxy wie beispielsweis den HIN Client verwendet.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientByProxy extends AbstractHttpFormIdpClient {

	private IdpClientViaHttpProxyConfigImpl config;

	public IdpClientByProxy(IdpClientViaHttpProxyConfigImpl clientConfiguration) {
		config = clientConfiguration;

	}

	@Override
	public CloseableHttpClient getHttpClient() throws ClientSendException {
		return HttpClients.createDefault();
	}

	@Override
	public RequestConfig getRequestConfig() {
		final var proxy = new HttpHost(config.getProxyHost(), config.getProxyPort(),
				config.getProxyProtocol());
		return RequestConfig.custom().setProxy(proxy).build();
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
