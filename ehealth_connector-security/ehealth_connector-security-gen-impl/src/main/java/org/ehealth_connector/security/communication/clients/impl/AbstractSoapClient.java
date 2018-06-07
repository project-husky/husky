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

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.ehealth_connector.security.communication.config.SoapClientConfig;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.exceptions.SoapException;
import org.ehealth_connector.security.pki.PkiManager;
import org.ehealth_connector.security.serialization.pki.PkiManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract Class implementing a soap client based on httpclient.</div>
 * <div class="de">Abstrakte Klasse welche einen soap client implementiert auf basis von httpclient.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractSoapClient<T> {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private SoapClientConfig config;

	private void paserSoapFault(String retVal) throws ParserConfigurationException, SAXException,
			IOException, XPathExpressionException, SoapException {
		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		final Document document = docBuilder.parse(new ByteArrayInputStream(retVal.getBytes()));

		String prefix = document.getDocumentElement().getPrefix();
		if (!StringUtils.isEmpty(prefix)) {
			prefix += ":";
		}

		final Node faultnode = getNode(document.getDocumentElement(),
				"/" + prefix + "Envelope/" + prefix + "Body/" + prefix + "Fault");
		final SoapException exception = getSoapException(faultnode);
		throw exception;
	}

	protected void createBody(Element aBodyElement, Element envelopElement)
			throws SerializeException {
		// create soap body
		final Element soapBody = envelopElement.getOwnerDocument()
				.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Body");
		envelopElement.appendChild(soapBody);

		// add authnrequest to soap body
		final Node importedNode = envelopElement.getOwnerDocument().importNode(aBodyElement, true);
		soapBody.appendChild(importedNode);
	}

	protected Element createEnvelope() throws ParserConfigurationException {
		// create xml dokument
		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		final Document soapDoc = docBuilder.newDocument();

		// create soap envelope
		final Element envelopElement = soapDoc
				.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
		soapDoc.appendChild(envelopElement);
		return envelopElement;
	}

	protected void createHeader(Element aSecurityHeaderElement, WsaHeaderValue wsHeaders,
			Element envelopElement) throws SerializeException {

		// create soap header
		final Element headerElement = envelopElement.getOwnerDocument()
				.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Header");
		envelopElement.appendChild(headerElement);

		final Element headerWsaAction = envelopElement.getOwnerDocument()
				.createElementNS("http://www.w3.org/2005/08/addressing", "Action");
		headerWsaAction.setTextContent(wsHeaders.getAction());
		headerElement.appendChild(headerWsaAction);

		final Element headerWsaMessageID = envelopElement.getOwnerDocument()
				.createElementNS("http://www.w3.org/2005/08/addressing", "MessageID");
		headerWsaMessageID.setTextContent(wsHeaders.getMessageId());
		headerElement.appendChild(headerWsaMessageID);

		final Element headerSecurityElement = envelopElement.getOwnerDocument().createElementNS(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
				"Security");
		headerElement.appendChild(headerSecurityElement);

		// add security header element (assertion) to the headers
		final Node importedHeaderNode = envelopElement.getOwnerDocument()
				.importNode(aSecurityHeaderElement, true);
		headerSecurityElement.appendChild(importedHeaderNode);
	}

	protected String createXmlString(Element aEnvelope) throws TransformerException {// transform
																						// to
																						// string
		final TransformerFactory tf = TransformerFactory.newInstance();
		final Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		final StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(aEnvelope.getOwnerDocument()),
				new StreamResult(writer));
		return writer.toString();

	}

	protected T execute(HttpPost post)
			throws ClientSendException, ClientProtocolException, IOException {
		final CloseableHttpClient httpclient = getHttpClient();

		final CloseableHttpResponse response = httpclient.execute(post);
		final HttpEntity errorEntity = response.getEntity();
		final String content = EntityUtils.toString(errorEntity);
		logger.debug("SOAP Message\n" + content);
		if ((response.getStatusLine() != null)
				&& (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
			return parseResponse(content);
		} else {

			return parseResponseError(content);
		}
	}

	protected SoapClientConfig getConfig() {
		return config;
	}

	protected CloseableHttpClient getHttpClient() throws ClientSendException {
		if (!StringUtils.isEmpty(config.getKeyStore())) {
			try {
				final PkiManager pki = new PkiManagerImpl();
				final KeyStore keyStore = pki.loadStore(new FileInputStream(config.getKeyStore()),
						config.getKeyStorePassword(), config.getKeyStoreType());

				final TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain,
						String authType) -> true;
				final SSLContext sslcontext = SSLContexts.custom()//
						.loadKeyMaterial(keyStore, config.getKeyStorePassword().toCharArray())//
						.loadTrustMaterial(keyStore, acceptingTrustStrategy)//
						.build();
				return HttpClients.custom().setSslcontext(sslcontext).build();
			} catch (KeyStoreException | KeyManagementException | UnrecoverableKeyException
					| NoSuchAlgorithmException | IOException e) {
				throw new ClientSendException(e);
			}
		}

		return HttpClients.createDefault();
	}

	protected HttpPost getHttpPost() throws UnsupportedEncodingException, SerializeException,
			ParserConfigurationException, TransformerException {
		final HttpPost post = new HttpPost(config.getUrl());
		post.setConfig(getRequestConfig());
		post.setHeader(HttpHeaders.CONTENT_TYPE, "application/soap+xml; charset=utf-8");
		return post;
	}

	protected Logger getLogger() {
		return logger;
	}

	protected Node getNode(Element element, String xPathExpression)
			throws XPathExpressionException {
		final XPath xPath = XPathFactory.newInstance().newXPath();
		xPath.setNamespaceContext(new NamespaceContext() {

			// The lookup for the namespace uris is delegated to the stored
			// document.
			@Override
			public String getNamespaceURI(String prefix) {
				if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
					return element.getOwnerDocument().lookupNamespaceURI(null);
				} else {
					return element.getOwnerDocument().lookupNamespaceURI(prefix);
				}
			}

			@Override
			public String getPrefix(String namespaceURI) {
				return element.getOwnerDocument().lookupPrefix(namespaceURI);
			}

			@Override
			@SuppressWarnings("rawtypes")
			public Iterator getPrefixes(String namespaceURI) {
				return null;
			}

		});

		final XPathExpression expr = xPath.compile(xPathExpression);

		return (Node) expr.evaluate(element, XPathConstants.NODE);

	}

	protected RequestConfig getRequestConfig() {
		return RequestConfig.custom().build();
	}

	protected Element getResponseElement(String content, String nameSpaceUri, String localName)
			throws ParserConfigurationException, UnsupportedOperationException, SAXException,
			IOException, XPathExpressionException {

		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		final Document soapDocument = docBuilder
				.parse(new ByteArrayInputStream(content.getBytes()));

		String prefix = soapDocument.getDocumentElement().getPrefix();
		if (!StringUtils.isEmpty(prefix)) {
			prefix += ":";
		}
		final Node bodyNode = getNode(soapDocument.getDocumentElement(),
				"/" + prefix + "Envelope/" + prefix + "Body");

		// final Node first = soapDocument.getFirstChild();
		// System.out.println("First: " + first.getNodeName());
		// final Node lastOfFirst = first.getLastChild();
		// System.out.println("LastOfFirst: " + lastOfFirst.getNodeName());
		// // get the xml response node
		// final Node responseNode = lastOfFirst.getFirstChild();
		// System.out.println("responseNode: " + responseNode.getNodeName());

		NodeList reponseNodes = ((Element) bodyNode).getElementsByTagNameNS("*", localName);
		if ((reponseNodes == null) || (reponseNodes.getLength() < 1)) {
			reponseNodes = ((Element) bodyNode).getElementsByTagNameNS(nameSpaceUri, localName);
		}
		if (reponseNodes.getLength() == 0) {
			throw new XPathExpressionException("No node of type " + localName + " found.");
		}
		final Node responseNode = reponseNodes.item(0);
		final Document doc = docBuilder.newDocument();
		final Node importedNode = doc.importNode(responseNode, true);
		doc.appendChild(importedNode);
		return doc.getDocumentElement();
	}

	protected SoapException getSoapException(Node faultnode) {
		String faultCode = "";
		String faultMessage = "";
		if (faultnode != null) {
			final NodeList childs = faultnode.getChildNodes();
			for (int j = 0; j < childs.getLength(); ++j) {
				final Node child = childs.item(j);
				System.out.println("NodeName: " + child.getNodeName());
				if ("faultcode".equalsIgnoreCase(child.getNodeName())) {
					faultCode = child.getTextContent();
				} else if ("faultstring".equalsIgnoreCase(child.getNodeName())) {
					faultMessage = child.getTextContent();
				} else if ("Code".equalsIgnoreCase(child.getNodeName())) {
					faultCode = child.getFirstChild().getTextContent();
				} else if ("Reason".equalsIgnoreCase(child.getNodeName())) {
					faultMessage = child.getFirstChild().getTextContent();
				} else if ("#text".equalsIgnoreCase(child.getNodeName())) {
					faultCode = "Reason";
					faultMessage = child.getTextContent();
				}
			}
		}

		if (!StringUtils.isEmpty(faultCode)) {
			return new SoapException(faultCode, faultMessage);
		} else {
			return new SoapException("Client", "No inforamtion available");
		}
	}

	protected abstract T parseResponse(String content) throws ClientSendException;

	protected T parseResponseError(String content) throws ClientSendException {
		try {
			String retVal = null;
			if (content.trim().startsWith("<") && content.trim().endsWith(">")) {
				retVal = content;
			} else {

				// final String pattern = "--" + boundary +
				// "\\R(.*?\\R*?)*?\\R--" + boundary + "--";
				// final String pattern = "<soap\\:Envelope
				// (.*?\\R*?)*?\\R</soap\\:Envelope>";
				final String pattern = "<([a-zA-Z:]+)Envelope(.+)>(.+)</([a-zA-Z:]+)Envelope>";
				final Pattern regex = Pattern.compile(pattern);
				final Matcher matcher = regex.matcher(content);
				while (matcher.find()) {
					retVal = matcher.group();
					break;
				}
			}

			if (retVal != null) {
				paserSoapFault(retVal);
			}
			throw new ClientSendException(
					"Error occurred. No detailed error information available");
		} catch (UnsupportedOperationException | TransformerFactoryConfigurationError
				| ParseException | IOException | ParserConfigurationException | SAXException
				| XPathExpressionException e) {
			throw new ClientSendException(e);
		}

	}

	protected void setConfig(SoapClientConfig config) {
		this.config = config;
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}
}
