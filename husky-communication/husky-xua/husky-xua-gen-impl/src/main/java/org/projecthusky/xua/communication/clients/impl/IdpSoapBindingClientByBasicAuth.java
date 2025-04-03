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
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.projecthusky.xua.deserialization.impl.ResponseDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.Response;
import org.projecthusky.xua.serialization.impl.AuthnRequestSerializerImpl;

import net.shibboleth.shared.xml.XMLParserException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;


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

	/**
	 * Constgructor with config as param
	 * 
	 * @param clientConfiguration the client configuration
	 */
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
		final byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.ISO_8859_1));
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
	 * @see org.projecthusky.xua.communication.clients.impl.AbstractIdpClient#getRequestConfig()
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
	 * @throws XMLParserException 
	 */
	private HttpEntity getSoapEntity(AuthnRequest aAuthnRequest)
			throws SerializeException, TransformerException, XMLParserException {

		// serialize the authnrequest to xml element
		final var serializer = new AuthnRequestSerializerImpl();
		final var authnRequestElement = serializer.toXmlElement(aAuthnRequest);

		// create xml dokument
		// Use the parser from the OpenSAML ParserPool because its implementation may be
		// different than
		// XmlFactories.newSafeDocumentBuilder()
		final var docBuilder = XMLObjectProviderRegistrySupport.getParserPool();
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
		final var stringEntity = new StringEntity(body, ContentType.APPLICATION_SOAP_XML, null, false); 
		return stringEntity;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.clients.impl.AbstractIdpClient#parseResponse(org.apache.http.client.methods.CloseableHttpResponse)
	 */
	@Override
	Response parseResponse(CloseableHttpResponse response) throws ClientSendException {
		try {

			// Use the parser from the OpenSAML ParserPool because its implementation may be
			// different than
			// XmlFactories.newSafeDocumentBuilder()
			final var soapDocument = XMLObjectProviderRegistrySupport.getParserPool()
					.parse(response.getEntity().getContent());

			// get the xml response node
			final var responseNode = soapDocument.getFirstChild().getLastChild().getFirstChild();

			final var doc = XMLObjectProviderRegistrySupport.getParserPool().newDocument();
			final var importedNode = doc.importNode(responseNode, true);
			doc.appendChild(importedNode);

			// deserialize to the Response instance
			final var deserializer = new ResponseDeserializerImpl();
			return deserializer.fromXmlElement(doc.getDocumentElement());
		} catch (UnsupportedOperationException | IOException | DeserializeException
				| TransformerFactoryConfigurationError | XMLParserException e) {
			throw new ClientSendException(e);
		}

	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.clients.IdpClient#send(org.projecthusky.xua.authentication.AuthnRequest)
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
