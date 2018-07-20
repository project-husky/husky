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
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the IdP Client with basic authentication.</div>
 * <div class="de">Klasse die den IdP Client mit Basic Authentication implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpSoapBindingClientByBasicAuth extends AbstractIdpClient {

	private IdpClientBasicAuthConfigImpl config;

	public IdpSoapBindingClientByBasicAuth(IdpClientBasicAuthConfigImpl clientConfiguration) {
		config = clientConfiguration;

	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add the basic authentication header.</div>
	 * <div class="de">Methode um den Basic Authentication Header hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param post
	 * <!-- @formatter:on -->
	 */
	private void addBasicAuthentication(HttpPost post) {
		final String auth = config.getBasicAuthUsername() + ":" + config.getBasicAuthPassword();
		final byte[] encodedAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("ISO-8859-1")));
		final String authHeader = "Basic " + new String(encodedAuth);
		post.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
	}

	@Override
	public CloseableHttpClient getHttpClient() throws ClientSendException {
		return HttpClients.createDefault();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.clients.impl.AbstractIdpClient#getRequestConfig()
	 */
	@Override
	public RequestConfig getRequestConfig() {
		return RequestConfig.custom().setAuthenticationEnabled(true).build();
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create the soap entity.</div>
	 * <div class="de">Methode um die SOAP Entity zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAuthnRequest
	 * <div class="en">the authnrequest to be sent.</div>
	 * <div class="de">Der AuthnRequest der geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the httpentity with the soap message as body.</div>
	 * <div class="de">Die Httpentity mit der SOAP Nachricht als Body.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SerializeException
	 * <div class="en">will be thrown on error occuring during serialization.</div>
	 * <div class="de">wird geworfen wenn ein Fehler bei der Serialisierung auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ParserConfigurationException
	 * <div class="en">will be thrown on error occuring during parser configuration.</div>
	 * <div class="de">wird geworfen wenn ein Fehler bei der Parser Konfiguration auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws TransformerException
	 * <div class="en">will be thrown on error occuring during transformation.</div>
	 * <div class="de">wird geworfen wenn ein Fehler bei der Transformierung auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	private HttpEntity getSoapEntity(AuthnRequest aAuthnRequest)
			throws SerializeException, ParserConfigurationException, TransformerException {

		// serialize the authnrequest to xml element
		final AuthnRequestSerializerImpl serializer = new AuthnRequestSerializerImpl();
		final Element authnRequestElement = serializer.toXmlElement(aAuthnRequest);

		// create xml dokument
		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		final Document soapDoc = docBuilder.newDocument();

		// create soap envelope
		final Element envelopElement = soapDoc
				.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
		soapDoc.appendChild(envelopElement);

		// create soap body
		final Element soapBody = soapDoc
				.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Body");
		envelopElement.appendChild(soapBody);

		// add authnrequest to soap body
		final Node importedNode = soapDoc.importNode(authnRequestElement, true);
		soapBody.appendChild(importedNode);

		// transform to string
		final TransformerFactory tf = TransformerFactory.newInstance();
		final Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		final StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(soapDoc), new StreamResult(writer));
		final String body = writer.toString();

		// add string as body to httpentity
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
			final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			final Document soapDocument = docBuilder.parse(response.getEntity().getContent());

			// get the xml response node
			final Node responseNode = soapDocument.getFirstChild().getLastChild().getFirstChild();

			final Document doc = docBuilder.newDocument();
			final Node importedNode = doc.importNode(responseNode, true);
			doc.appendChild(importedNode);

			// deserialize to the Response instance
			final ResponseDeserializerImpl deserializer = new ResponseDeserializerImpl();
			return deserializer.fromXmlElement(doc.getDocumentElement());
		} catch (UnsupportedOperationException | IOException | DeserializeException
				| TransformerFactoryConfigurationError | ParserConfigurationException
				| SAXException e) {
			throw new ClientSendException(e);
		}

	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.clients.IdpClient#send(org.ehealth_connector.security.authentication.AuthnRequest)
	 */
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

}
