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
package org.ehealth_connector.security.communication.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.ConvenienceUserAccessAuthentication;
import org.ehealth_connector.security.communication.config.IdpClientConfig;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.ehealth_connector.security.communication.config.impl.IdpClientViaHttpProxyConfigImpl;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ConvenienceUserAccessAuthentication.</div>
 * <div class="de">Klasse die das Interface ConvenienceUserAccessAuthentication implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class ConvenienceUserAccessAuthenticationImpl implements ConvenienceUserAccessAuthentication {

	/**
	 * {@inheritDoc}
	 * 
	 * @throws ClientSendException
	 *
	 * @see org.ehealth_connector.security.communication.ConvenienceUserAccessAuthentication#getAuthentication(org.ehealth_connector.security.authentication.AuthnRequest,
	 *      org.ehealth_connector.security.communication.config.IdpClientConfig)
	 */
	@Override
	public Response getAuthentication(AuthnRequest aAuthnRequest, IdpClientConfig clientConfiguration)
			throws ClientSendException {

		final IdpClient client = getIdpClient(clientConfiguration);

		final Response response = client.send(aAuthnRequest);

		return response;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.ConvenienceUserAccessAuthentication#getXUserAssertion(org.ehealth_connector.security.saml2.Assertion,
	 *      org.ehealth_connector.security.communication.xua.XUserAssertionRequest,
	 *      org.ehealth_connector.security.communication.config.XuaClientConfig)
	 */
	@Override
	public XUserAssertionResponse getXUserAssertion(Assertion aAssertion, XUserAssertionRequest aRequest,
			XuaClientConfig clientConfiguration) {

		final RequestSecurityTokenResponse aInternalObject = null;
		return new XUserAssertionResponseBuilderImpl().create(aInternalObject);
	}

	private IdpClient getIdpClient(IdpClientConfig clientConfiguration) {
		if (clientConfiguration instanceof IdpClientViaHttpProxyConfigImpl) {
			return new IdpClientByProxy((IdpClientViaHttpProxyConfigImpl) clientConfiguration);
		} else if (clientConfiguration instanceof IdpClientCertificateAuthConfigImpl) {
			return new IdpClientByCert((IdpClientCertificateAuthConfigImpl) clientConfiguration);
		}
		return null;
	}

	protected abstract class IdpClient {

		abstract Response send(AuthnRequest aAuthnRequest) throws ClientSendException;

		abstract RequestConfig getRequestConfig();

		abstract CloseableHttpClient getHttpClient() throws ClientSendException;

		UrlEncodedFormEntity getUrlFormEntity(AuthnRequest aAuthnRequest)
				throws SerializeException, UnsupportedEncodingException {
			final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
			final byte[] authnByteArray = serializer.toXmlByteArray(aAuthnRequest);

			final List<NameValuePair> urlParameters = new ArrayList<>();
			urlParameters
					.add(new BasicNameValuePair("SAMLRequest", Base64.getEncoder().encodeToString(authnByteArray)));

			return new UrlEncodedFormEntity(urlParameters);
		}

		HttpPost getHttpPost(AuthnRequest aAuthnRequest, IdpClientConfig config)
				throws UnsupportedEncodingException, SerializeException {
			final HttpPost post = new HttpPost(config.getUrl());
			post.setConfig(getRequestConfig());
			post.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
			post.setEntity(getUrlFormEntity(aAuthnRequest));
			return post;
		}

		Response execute(HttpPost post) throws Throwable {
			final CloseableHttpClient httpclient = getHttpClient();// HttpClients.createDefault();
			final CloseableHttpResponse response = httpclient.execute(post);
			if ((response.getStatusLine() != null) && (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {

				return parseResponse(response);
			} else {
				throw new Throwable("No valid response found: " + response);
			}
		}

		Response parseResponse(CloseableHttpResponse response)
				throws ParseException, IOException, DeserializeException {
			final String responseEntity = EntityUtils.toString(response.getEntity());
			final org.jsoup.nodes.Document doc = Jsoup.parse(responseEntity);
			final Elements samlElements = doc.getElementsByAttributeValue("name", "SAMLResponse");
			final Element samlElement = samlElements.first();
			final String samlResponseBase64String = samlElement.attr("value");

			final byte[] reponseByteArray = Base64.getDecoder().decode(samlResponseBase64String);

			final ResponseDeserializerImpl deserializer = new ResponseDeserializerImpl();

			return deserializer.fromXmlByteArray(reponseByteArray);
		}

	}

	protected class IdpClientByProxy extends IdpClient {

		private IdpClientViaHttpProxyConfigImpl config;

		public IdpClientByProxy(IdpClientViaHttpProxyConfigImpl clientConfiguration) {
			config = clientConfiguration;

		}

		@Override
		RequestConfig getRequestConfig() {
			final HttpHost proxy = new HttpHost(config.getProxyHost(), config.getProxyPort(),
					config.getProxyProtocol());
			return RequestConfig.custom().setProxy(proxy).build();
		}

		@Override
		public Response send(AuthnRequest aAuthnRequest) throws ClientSendException {
			try {
				final HttpPost post = getHttpPost(aAuthnRequest, config);

				return execute(post);
			} catch (final Throwable t) {
				throw new ClientSendException(t);
			}

		}

		@Override
		CloseableHttpClient getHttpClient() throws ClientSendException {
			return HttpClients.createDefault();
		}

	}

	protected class IdpClientByCert extends IdpClient {

		private IdpClientCertificateAuthConfigImpl config;

		public IdpClientByCert(IdpClientCertificateAuthConfigImpl clientConfiguration) {
			config = clientConfiguration;

		}

		@Override
		public Response send(AuthnRequest aAuthnRequest) throws ClientSendException {
			try {
				final HttpPost post = getHttpPost(aAuthnRequest, config);

				return execute(post);
			} catch (final Throwable t) {
				throw new ClientSendException(t);
			}
		}

		@Override
		RequestConfig getRequestConfig() {
			return RequestConfig.custom().build();
		}

		@Override
		CloseableHttpClient getHttpClient() throws ClientSendException {
			try {
				final SSLContext sslContext = SSLContexts.custom()
						.loadKeyMaterial(config.getClientKeyStore(), config.getClientKeyStorePassword()).build();
				return HttpClients.custom().setSslcontext(sslContext).build();
			} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException
					| KeyStoreException e) {
				throw new ClientSendException(e);
			}

		}

	}

}
