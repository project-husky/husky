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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.clients.IdpClient;
import org.projecthusky.xua.communication.config.IdpClientConfig;
import org.projecthusky.xua.deserialization.impl.ResponseDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.Response;
import org.projecthusky.xua.serialization.impl.AuthnRequestSerializerImpl;
import org.jsoup.Jsoup;
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
	 * @throws ClientSendException 
	 * @throws IOException 
	 * @throws  
	 * @throws Throwable
	 * <div class="en">will be thrown if an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Response execute(HttpPost post) throws ClientSendException, IOException {
		final CloseableHttpClient httpclient = getHttpClient();

		final CloseableHttpResponse response = httpclient.execute(post);
		if ((response.getStatusLine() != null)
				&& (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {

			return parseResponse(response);
		} else {
			throw new NoHttpResponseException("No valid response found: " + response);
		}
	}

	/**
	 * Method to get http client
	 * 
	 * @return closeable http client
	 * @throws ClientSendException will be thrown if an error occures.
	 */
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
		final var post = new HttpPost(config.getUrl());
		post.setConfig(getRequestConfig());
		return post;
	}

	/**
	 * Method to get request config
	 * 
	 * @return request config
	 */
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
		final var serializer = new AuthnRequestSerializerImpl();
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
			final var responseEntity = EntityUtils.toString(response.getEntity());
			logger.debug("Response:\n {}", responseEntity);
			final org.jsoup.nodes.Document doc = Jsoup.parse(responseEntity);
			final var samlElements = doc.getElementsByAttributeValue("name", "SAMLResponse");
			final var samlElement = samlElements.first();
			final var samlResponseBase64String = samlElement.attr("value");

			final byte[] reponseByteArray = Base64.getDecoder().decode(samlResponseBase64String);

			final var deserializer = new ResponseDeserializerImpl();

			return deserializer.fromXmlByteArray(reponseByteArray);
		} catch (ParseException | IOException | DeserializeException e) {
			throw new ClientSendException(e);
		}
	}
}
