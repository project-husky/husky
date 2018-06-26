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
package org.ehealth_connector.security.communication.clients.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.clients.IdpClient;
import org.ehealth_connector.security.communication.config.IdpClientConfig;
import org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract class implementing common methods for the concrete IdpClient implementations.</div>
 * <div class="de">Abstrakte Klasse die die gemeinsamen Methoden für die konkreten IdpClient Implementationen implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractIdpClient implements IdpClient {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to execute a HTTP post request</div>
	 * <div class="de">Methode um eine HTTP post Abfrage auszuführen</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param post
	 * <div class="en">the http post to be executed.</div>
	 * <div class="de">der http post der ausgeführt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the Response</div>
	 * <div class="de">der Response</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws Throwable
	 * <div class="en">will be thrown if an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Response execute(HttpPost post) throws Throwable {
		final CloseableHttpClient httpclient = getHttpClient();

		final CloseableHttpResponse response = httpclient.execute(post);
		if ((response.getStatusLine() != null)
				&& (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {

			return parseResponse(response);
		} else {
			throw new Throwable("No valid response found: " + response);
		}
	}

	public abstract CloseableHttpClient getHttpClient() throws ClientSendException;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create and configure the HTTPPost instance.</div>
	 * <div class="de">Methode um eine HTTPPost Instanz zu erstellen und zu konfigurieren.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param config
	 * <div class="en">the client configuration</div>
	 * <div class="de">Die Client Konfiguration</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the created HTTP Post instance</div>
	 * <div class="de">die erstellte HTTP Post Instanz</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws UnsupportedEncodingException
	 * <div class="en">will be thrown if an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	HttpPost getHttpPost(IdpClientConfig config) throws UnsupportedEncodingException {
		final HttpPost post = new HttpPost(config.getUrl());
		post.setConfig(getRequestConfig());
		return post;
	}

	protected Logger getLogger() {
		return logger;
	}

	public abstract RequestConfig getRequestConfig();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create an UrlEncodedFormEntity with the authn request.</div>
	 * <div class="de">Methode um eine UrlEncodedFormEntity mit dem AuthnRequest zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAuthnRequest
	 * @return
	 * @throws SerializeException
	 * @throws UnsupportedEncodingException
	 * <!-- @formatter:on -->
	 */
	UrlEncodedFormEntity getUrlFormEntity(AuthnRequest aAuthnRequest)
			throws SerializeException, UnsupportedEncodingException {
		final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
		final byte[] authnByteArray = serializer.toXmlByteArray(aAuthnRequest);

		final List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("SAMLRequest",
				Base64.getEncoder().encodeToString(authnByteArray)));

		return new UrlEncodedFormEntity(urlParameters);
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to parse the http response content to the Response.</div>
	 * <div class="de">Methode um den http Inhalt in ein Response umzuwandeln.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param response
	 * <div class="en">the http response</div>
	 * <div class="de">die http response</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the Response</div>
	 * <div class="de">die Response</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Response parseResponse(CloseableHttpResponse response) throws ClientSendException {
		try {
			final String responseEntity = EntityUtils.toString(response.getEntity());
			logger.debug("Response:\n" + responseEntity);
			final org.jsoup.nodes.Document doc = Jsoup.parse(responseEntity);
			final Elements samlElements = doc.getElementsByAttributeValue("name", "SAMLResponse");
			final Element samlElement = samlElements.first();
			final String samlResponseBase64String = samlElement.attr("value");

			final byte[] reponseByteArray = Base64.getDecoder().decode(samlResponseBase64String);

			final ResponseDeserializerImpl deserializer = new ResponseDeserializerImpl();

			return deserializer.fromXmlByteArray(reponseByteArray);
		} catch (ParseException | IOException | DeserializeException e) {
			throw new ClientSendException(e);
		}
	}
}
