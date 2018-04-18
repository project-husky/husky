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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the idp client with basic authentication.</div>
 * <div class="de">Klasse die den idp client mit basic authentication implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class IdpSoapBindingClientByBasicAuth extends AbstractIdpClient {

	private IdpClientBasicAuthConfigImpl config;

	public IdpSoapBindingClientByBasicAuth(IdpClientBasicAuthConfigImpl clientConfiguration) {
		config = clientConfiguration;

	}

	@Override
	public RequestConfig getRequestConfig() {
		return RequestConfig.custom().setAuthenticationEnabled(true).build();
	}

	@Override
	public Response send(AuthnRequest aAuthnRequest) throws ClientSendException {
		try {
			final HttpPost post = getHttpPost(config);
			post.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
			post.setEntity(getSoapEntity(aAuthnRequest));
			post.addHeader("Accept", "text/xml");

			return execute(post);
		} catch (final Throwable t) {
			throw new ClientSendException(t);
		}

	}

	private HttpEntity getSoapEntity(AuthnRequest aAuthnRequest) throws SerializeException, SOAPException, IOException {
		final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
		final Element authnByteArray = serializer.toXmlElement(aAuthnRequest);

		final MessageFactory messageFactory = MessageFactory.newInstance();
		final SOAPMessage soapMessage = messageFactory.createMessage();

		// Retrieve different parts
		final SOAPPart soapPart = soapMessage.getSOAPPart();
		final SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();

		// Two ways to extract body
		SOAPBody soapBody = soapEnvelope.getBody();
		soapBody = soapMessage.getSOAPBody();
		soapBody.addDocument(authnByteArray.getOwnerDocument());

		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		soapMessage.writeTo(out);
		final String body = new String(out.toByteArray());

		final StringEntity stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(true);
		return stringEntity;
	}

	@Override
	public CloseableHttpClient getHttpClient() throws ClientSendException {

		final CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(AuthScope.ANY,
				new UsernamePasswordCredentials(config.getBasicAuthUsername(), config.getBasicAuthPassword()));

		return HttpClients.custom().setDefaultRequestConfig(getRequestConfig())
				.setDefaultCredentialsProvider(credsProvider).build();
	}
}
