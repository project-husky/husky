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
package org.ehealth_connector.xua.communication.clients.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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
import org.ehealth_connector.xua.authentication.AuthnRequest;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.xua.deserialization.impl.ResponseDeserializerImpl;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.saml2.Response;
import org.ehealth_connector.xua.serialization.impl.AuthnRequestSerializerImpl;
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

	
	private static final String SOAPNS = "http://schemas.xmlsoap.org/soap/envelope/";
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
				.encode(auth.getBytes(StandardCharsets.ISO_8859_1));
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
	 * @see org.ehealth_connector.xua.communication.clients.impl.AbstractIdpClient#getRequestConfig()
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
		final var serializer = new AuthnRequestSerializerImpl();
		final var authnRequestElement = serializer.toXmlElement(aAuthnRequest);

		// create xml dokument
		final var docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final var docBuilder = docFactory.newDocumentBuilder();
		final var soapDoc = docBuilder.newDocument();

		// create soap envelope
		final var envelopElement = soapDoc.createElementNS(SOAPNS, "Envelope");
		soapDoc.appendChild(envelopElement);

		final var soapHeader = soapDoc.createElementNS(SOAPNS, "Header");
		envelopElement.appendChild(soapHeader);

		// create soap body
		final var soapBody = soapDoc.createElementNS(SOAPNS, "Body");
		envelopElement.appendChild(soapBody);

		// add authnrequest to soap body
		final var importedNode = soapDoc.importNode(authnRequestElement, true);
		soapBody.appendChild(importedNode);

		// transform to string
		final var tf = TransformerFactory.newInstance();
		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		final var transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		final var writer = new StringWriter();
		transformer.transform(new DOMSource(soapDoc), new StreamResult(writer));
		final var body = writer.toString();

		// add string as body to httpentity
		final var stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(true);
		return stringEntity;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.communication.clients.impl.AbstractIdpClient#parseResponse(org.apache.http.client.methods.CloseableHttpResponse)
	 */
	@Override
	Response parseResponse(CloseableHttpResponse response) throws ClientSendException {
		try {
			final var docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			docFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			docFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
			final var docBuilder = docFactory.newDocumentBuilder();
			final var soapDocument = docBuilder.parse(response.getEntity().getContent());

			// get the xml response node
			final var responseNode = soapDocument.getFirstChild().getLastChild().getFirstChild();

			final var doc = docBuilder.newDocument();
			final var importedNode = doc.importNode(responseNode, true);
			doc.appendChild(importedNode);

			// deserialize to the Response instance
			final var deserializer = new ResponseDeserializerImpl();
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
	 * @see org.ehealth_connector.xua.communication.clients.IdpClient#send(org.ehealth_connector.xua.authentication.AuthnRequest)
	 */
	@Override
	public Response send(AuthnRequest aAuthnRequest) throws ClientSendException {
		try {
			final var post = getHttpPost(config);
			post.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
			post.setEntity(getSoapEntity(aAuthnRequest));
			post.addHeader("Accept", "text/xml");

			addBasicAuthentication(post);

			return execute(post);
		} catch (final Exception t) {
			throw new ClientSendException(t);
		}

	}

}
