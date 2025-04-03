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


import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpHost;
import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.config.impl.IdpClientViaHttpProxyConfigImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.saml2.Response;

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

	/**
	 * Constgructor with config as param
	 * 
	 * @param clientConfiguration the client configuration
	 */
	public IdpClientByProxy(IdpClientViaHttpProxyConfigImpl clientConfiguration) {
		config = clientConfiguration;

	}

	@Override
	public CloseableHttpClient getHttpClient() throws ClientSendException {
		return HttpClients.createDefault();
	}

	@Override
	public RequestConfig getRequestConfig() {
		final var proxy = new HttpHost(config.getProxyHost(), config.getProxyPort());
		
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
