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

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract class implementing common methods for the concrete IdpClient implementations.</div>
 * <div class="de">Abstrakte Klasse die die gemeinsamen Methoden für die konkreten IdpClient Implementationen implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractIdpClient implements IdpClient {

	public abstract RequestConfig getRequestConfig();

	public abstract CloseableHttpClient getHttpClient() throws ClientSendException;

	UrlEncodedFormEntity getUrlFormEntity(AuthnRequest aAuthnRequest)
			throws SerializeException, UnsupportedEncodingException {
		final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
		final byte[] authnByteArray = serializer.toXmlByteArray(aAuthnRequest);

		final List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("SAMLRequest", Base64.getEncoder().encodeToString(authnByteArray)));

		return new UrlEncodedFormEntity(urlParameters);
	}

	HttpPost getHttpPost(IdpClientConfig config) throws UnsupportedEncodingException, SerializeException {
		final HttpPost post = new HttpPost(config.getUrl());
		post.setConfig(getRequestConfig());
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

	Response parseResponse(CloseableHttpResponse response) throws ParseException, IOException, DeserializeException {
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
