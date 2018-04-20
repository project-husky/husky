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
import java.nio.charset.Charset;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.security.deserialization.impl.ResponseDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.serialization.impl.AuthnRequestSerializerImpl;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the idp client with basic authentication.</div>
 * <div class="de">Klasse die den idp client mit basic authentication implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class IdpSoapBindingClientByBasicAuth extends AbstractIdpClient {

	private Logger logger = LoggerFactory.getLogger(getClass());

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

			addBasicAuthentication(post);

			return execute(post);
		} catch (final Throwable t) {
			throw new ClientSendException(t);
		}

	}

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add the basic authentication header.</div>
	 * <div class="de">Methode um den basic authentication header hinzuzufügen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param post
	 * <!-- @formatter:on -->
	 */
	private void addBasicAuthentication(HttpPost post) {
		final String auth = config.getBasicAuthUsername() + ":" + config.getBasicAuthPassword();
		final byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("ISO-8859-1")));
		final String authHeader = "Basic " + new String(encodedAuth);
		post.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
	}

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create the soap entity.</div>
	 * <div class="de">Methode um die SOAP Entity zu erstellen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAuthnRequest
	 * @return
	 * @throws SerializeException
	 * @throws SOAPException
	 * @throws IOException
	 * <!-- @formatter:on -->
	 * @throws InitializationException 
	 */
	private HttpEntity getSoapEntity(AuthnRequest aAuthnRequest)
			throws SerializeException, SOAPException, IOException, InitializationException {
		InitializationService.initialize();
		final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
		final Element authnRequestElement = serializer.toXmlElement(aAuthnRequest);

		final MessageFactory messageFactory = MessageFactory.newInstance();
		final SOAPMessage soapMessage = messageFactory.createMessage();

		final SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
		SOAPBody soapBody = soapEnvelope.getBody();
		soapBody = soapMessage.getSOAPBody();
		soapBody.addDocument(authnRequestElement.getOwnerDocument());

		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		soapMessage.writeTo(out);
		final String body = new String(out.toByteArray());

		final StringEntity stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(true);
		return stringEntity;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.clients.impl.AbstractIdpClient#parseResponse(org.apache.http.client.methods.CloseableHttpResponse)
	 */
	@Override
	Response parseResponse(CloseableHttpResponse response) throws ClientSendException {
		try {
			// create the SOAPMessage instance
			final SOAPMessage soapResponse = MessageFactory.newInstance().createMessage(null,
					response.getEntity().getContent());
			final ByteArrayOutputStream out = new ByteArrayOutputStream();
			soapResponse.writeTo(out);
			logger.debug(out.toString());

			// get the xml response node
			final Node responseNode = soapResponse.getSOAPBody().getFirstChild();

			// build new document
			final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			final Document doc = docBuilder.newDocument();

			// // clone and import the xml reponse node to the new document
			// final Node cloned = responseNode.cloneNode(true);
			// final Node adoptedNode = doc.adoptNode(cloned);
			// // doc.getDocumentElement().appendChild(adoptedNode);

			final Node importedNode = doc.importNode(responseNode, true);
			doc.appendChild(importedNode);

			// deserialize to the Response instance
			final ResponseDeserializerImpl deserializer = new ResponseDeserializerImpl();
			return deserializer.fromXmlElement(doc.getDocumentElement());
		} catch (UnsupportedOperationException | IOException | SOAPException | DeserializeException
				| TransformerFactoryConfigurationError | ParserConfigurationException e) {
			throw new ClientSendException(e);
		}

	}

	@Override
	public CloseableHttpClient getHttpClient() throws ClientSendException {
		return HttpClients.createDefault();
	}

}
