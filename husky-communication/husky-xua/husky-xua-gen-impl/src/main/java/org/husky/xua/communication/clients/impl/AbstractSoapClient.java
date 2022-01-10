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
package org.husky.xua.communication.clients.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.xua.communication.config.SoapClientConfig;
import org.husky.xua.communication.config.SoapClientConfig.SoapVersion;
import org.husky.xua.communication.soap.impl.WsaHeaderValue;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.exceptions.SoapException;
import org.husky.xua.pki.PkiManager;
import org.husky.xua.pki.impl.PkiManagerImpl;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.shibboleth.utilities.java.support.xml.XMLParserException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract Class implementing a soap client based on httpclient.</div>
 * <div class="de">Abstrakte Klasse welche einen SOAP Client implementiert auf Basis von Httpclient.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractSoapClient<T> {

	/**
	 * The configuration of the soap client
	 */
	private SoapClientConfig config;

	/**
	 * The logger
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * creates body of soap message
	 * 
	 * @param aBodyElement   body element
	 * @param envelopElement soap envelope element
	 */
	protected void createBody(Element aBodyElement, Element envelopElement) {
		// create soap body
		final var soapBody = envelopElement.getOwnerDocument().createElementNS(getSoapNs(),
				"Body");
		envelopElement.appendChild(soapBody);

		// add authnrequest to soap body
		final var importedNode = envelopElement.getOwnerDocument().importNode(aBodyElement, true);
		soapBody.appendChild(importedNode);
	}

	/**
	 * creates SOAP envelope
	 * 
	 * @return created soap envelope
	 * 
	 * @throws ParserConfigurationException
	 */
	protected Element createEnvelope() throws ParserConfigurationException {
		// create xml dokument
		final var docBuilder = XmlFactories.newSafeDocumentBuilder();
		final var soapDoc = docBuilder.newDocument();

		// create soap envelope

		final String soapNs = getSoapNs();
		final var envelopElement = soapDoc.createElementNS(soapNs, "Envelope");

		soapDoc.appendChild(envelopElement);
		return envelopElement;
	}

	/**
	 * creates SOAP header
	 * 
	 * @param aSecurityHeaderElement SOAP security header element
	 * @param wsHeaders              WSA headers
	 * @param envelopElement         soap envelope
	 */
	protected void createHeader(Element aSecurityHeaderElement, WsaHeaderValue wsHeaders,
			Element envelopElement) {

		// create soap header
		final var headerElement = envelopElement.getOwnerDocument().createElementNS(getSoapNs(),
				"Header");
		envelopElement.appendChild(headerElement);

		final var headerWsaAction = envelopElement.getOwnerDocument()
				.createElementNS("http://www.w3.org/2005/08/addressing", "Action");
		headerWsaAction.setTextContent(wsHeaders.getAction());
		headerElement.appendChild(headerWsaAction);

		final var headerWsaMessageID = envelopElement.getOwnerDocument()
				.createElementNS("http://www.w3.org/2005/08/addressing", "MessageID");
		headerWsaMessageID.setTextContent(wsHeaders.getMessageId());
		headerElement.appendChild(headerWsaMessageID);

		final var headerSecurityElement = envelopElement.getOwnerDocument().createElementNS(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
				"Security");
		headerElement.appendChild(headerSecurityElement);

		// add security header element (assertion) to the headers
		if (aSecurityHeaderElement != null) {
			final var importedHeaderNode = envelopElement.getOwnerDocument()
					.importNode(aSecurityHeaderElement, true);
			headerSecurityElement.appendChild(importedHeaderNode);
		}
	}

	/**
	 * creates XML String from passed SOAP envelope
	 * 
	 * @param aEnvelope soap envelope
	 * 
	 * @return XML String
	 * @throws TransformerException
	 */
	protected String createXmlString(Element aEnvelope) throws TransformerException {// transform
																						// to
																						// string
		final var tf = TransformerFactory.newInstance();
		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		final var transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		final var writer = new StringWriter();
		transformer.transform(new DOMSource(aEnvelope.getOwnerDocument()),
				new StreamResult(writer));
		return writer.toString();

	}

	/**
	 * sends soap message
	 * 
	 * @param post http post
	 * 
	 * @return response
	 * 
	 * @throws ClientSendException
	 * @throws IOException
	 */
	protected T execute(HttpPost post)
			throws ClientSendException, IOException {
		final CloseableHttpClient httpclient = getHttpClient();
		final CloseableHttpResponse response = httpclient.execute(post);

		final HttpEntity responseEntity = response.getEntity();
		logger.debug(responseEntity.getContentType().getValue());

		var content = EntityUtils.toString(responseEntity);

		if (responseEntity.getContentType().getValue().startsWith("multipart")) {
			logger.debug("Multiparted Message\n {}", content);

			final byte[] boundary = getBoundary(responseEntity.getContentType().getValue());
			logger.debug("Boundary: {}", boundary);

			final var multipartStream = new MultipartStream(
					new ByteArrayInputStream(content.getBytes()), boundary, 16384, null);

			boolean nextPart = multipartStream.skipPreamble();
			while (nextPart) {
				final String header = multipartStream.readHeaders();
				logger.debug("");
				logger.debug("Headers:");
				logger.debug(header);
				logger.debug("Body:");
				final var out = new ByteArrayOutputStream();
				multipartStream.readBodyData(out);
				content = out.toString();
				logger.debug(content);
				out.close();
				logger.debug("");
				nextPart = multipartStream.readBoundary();
			}

		}
		logger.debug("SOAP Message\n {}", content);

		if ((response.getStatusLine() != null)
				&& (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
			return parseResponse(content);
		} else {
			return parseResponseError(content);
		}
	}

	protected byte[] getBoundary(String value) {
		final String[] splits = value.split(";");
		for (final String split : splits) {
			if (split.trim().startsWith("boundary")) {
				String boundaryWith = split.trim().split("=")[1];
				boundaryWith = boundaryWith.substring(1, boundaryWith.length() - 1);
				return boundaryWith.getBytes();
			}
		}
		return new byte[0];
	}

	/**
	 * Method to get soap client configuration
	 * 
	 * @return configuration
	 */
	protected SoapClientConfig getConfig() {
		return config;
	}

	/**
	 * Method to get HTTP client. This HTTP client uses keystore details from
	 * configuration
	 * 
	 * @return closeable HTTP client
	 * @throws ClientSendException
	 */
	protected CloseableHttpClient getHttpClient() throws ClientSendException {
		if (!StringUtils.isEmpty(config.getKeyStore())) {
			try (var fis = new FileInputStream(config.getKeyStore())) {
				final PkiManager pki = new PkiManagerImpl();
				final var keyStore = pki.loadStore(fis,
						config.getKeyStorePassword(), config.getKeyStoreType());

				final TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain,
						String authType) -> true;
				final var sslcontext = SSLContexts.custom()//
						.loadKeyMaterial(keyStore, config.getKeyStorePassword().toCharArray())//
						.loadTrustMaterial(keyStore, acceptingTrustStrategy)//
						.build();
				return HttpClients.custom().setSSLContext(sslcontext).build();
			} catch (KeyStoreException | KeyManagementException | UnrecoverableKeyException
					| NoSuchAlgorithmException | IOException e) {
				throw new ClientSendException(e);
			}
		}

		return HttpClients.createDefault();
	}

	/**
	 * Method to get HTTP Post with URI from configuration. Application/soap+xml ist
	 * set as content type header.
	 * 
	 * @return
	 */
	protected HttpPost getHttpPost() {
		final var post = new HttpPost(config.getUrl());
		post.setConfig(getRequestConfig());
		post.setHeader(HttpHeaders.CONTENT_TYPE, "application/soap+xml; charset=utf-8");
		return post;
	}

	/**
	 * Method to get Logger
	 * 
	 * @return logger
	 */
	protected Logger getLogger() {
		return logger;
	}

	/**
	 * Method to get Node of element with passed XPath expression.
	 * 
	 * @param element         element to search in
	 * @param xPathExpression XPath expression
	 * 
	 * @return found node
	 * @throws XPathExpressionException
	 */
	protected Node getNode(Element element, String xPathExpression)
			throws XPathExpressionException {
		final var xPath = XPathFactory.newInstance().newXPath();
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
			public Iterator<String> getPrefixes(String namespaceURI) {
				return null;
			}

		});

		final XPathExpression expr = xPath.compile(xPathExpression);

		return (Node) expr.evaluate(element, XPathConstants.NODE);

	}

	/**
	 * Method to get request configuration
	 * 
	 * @return request configuration
	 */
	protected RequestConfig getRequestConfig() {
		return RequestConfig.custom().build();
	}

	/**
	 * Method to get response element as {@link Element} from content. The passed
	 * local name and namespace is used to filter the response element.
	 * 
	 * @param content      response as xml
	 * @param nameSpaceUri namespace
	 * @param localName    name of element
	 * 
	 * @return response element
	 * 
	 * @throws UnsupportedOperationException
	 * @throws XPathExpressionException
	 * @throws XMLParserException
	 */
	protected Element getResponseElement(String content, String nameSpaceUri, String localName)
			throws UnsupportedOperationException, XPathExpressionException, XMLParserException {

		// Use the parser from the OpenSAML ParserPool because its implementation may be
		// different than
		// XmlFactories.newSafeDocumentBuilder()
		final var docBuilder = XMLObjectProviderRegistrySupport.getParserPool();
		final var soapDocument = docBuilder
				.parse(new ByteArrayInputStream(content.getBytes()));

		String prefix = soapDocument.getDocumentElement().getPrefix();
		if (!StringUtils.isEmpty(prefix)) {
			prefix += ":";
		}
		final var bodyNode = getNode(soapDocument.getDocumentElement(),
				"/" + prefix + "Envelope/" + prefix + "Body");

		NodeList reponseNodes = ((Element) bodyNode).getElementsByTagNameNS("*", localName);
		if ((reponseNodes == null) || (reponseNodes.getLength() < 1)) {
			reponseNodes = ((Element) bodyNode).getElementsByTagNameNS(nameSpaceUri, localName);
		}
		if (reponseNodes.getLength() == 0) {
			throw new XPathExpressionException("No node of type " + localName + " found.");
		}
		final var responseNode = reponseNodes.item(0);
		final var doc = docBuilder.newDocument();
		final var importedNode = doc.importNode(responseNode, true);
		doc.appendChild(importedNode);
		return doc.getDocumentElement();
	}

	/**
	 * Method to get soap exception of Axis2 fault Node.
	 * 
	 * @param faultnode
	 * 
	 * @return extracted SOAP exception
	 */
	protected SoapException getSoapException(Node faultnode) {
		var faultCode = "";
		var faultMessage = "";
		if (faultnode != null) {
			String prefix = faultnode.getPrefix();
			if (!"".equals(prefix)) {
				prefix += ":";
			}
			final NodeList childs = faultnode.getChildNodes();
			for (var j = 0; j < childs.getLength(); ++j) {
				final Node child = childs.item(j);
				logger.debug("NodeName: {}", child.getNodeName());
				if ("faultcode".equalsIgnoreCase(child.getNodeName())) {
					faultCode = child.getTextContent();
				} else if ("faultstring".equalsIgnoreCase(child.getNodeName())) {
					faultMessage = child.getTextContent();
				} else if ((prefix + "Code").equalsIgnoreCase(child.getNodeName())) {
					faultCode = child.getFirstChild().getTextContent();
				} else if ((prefix + "Reason").equalsIgnoreCase(child.getNodeName())) {
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

	private String getSoapNs() {
		if (SoapVersion.SOAP_12.equals(config.getSoapVersion())) {
			return "http://www.w3.org/2003/05/soap-envelope";
		} else {
			return "http://schemas.xmlsoap.org/soap/envelope/";
		}

	}

	/**
	 * Method to extract response from XML String
	 * 
	 * @param content XML String
	 * 
	 * @return extracted element
	 * 
	 * @throws ClientSendException
	 */
	protected abstract T parseResponse(String content) throws ClientSendException;

	/**
	 * Method to extract error from XML response
	 * 
	 * @param content XML String
	 * 
	 * @return extracted error
	 * 
	 * @throws ClientSendException
	 */
	protected T parseResponseError(String content) throws ClientSendException {
		logger.debug("parseResponseError: {}", content);
		try {
			String retVal = null;
			if (content.trim().startsWith("<") && content.trim().endsWith(">")) {
				retVal = content;
			} else {
				final var regex = Pattern
						.compile("<([a-zA-Z:]{0,200})Envelope(.{0,10000})>(.{1,100000})</([a-zA-Z:]{0,200})Envelope>");
				final var matcher = regex.matcher(content);
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
				| ParseException | XPathExpressionException | XMLParserException e) {
			throw new ClientSendException(e);
		}

	}

	private void paserSoapFault(String retVal) throws XPathExpressionException, SoapException, XMLParserException {
		// Use the parser from the OpenSAML ParserPool because its implementation may be
		// different than
		// XmlFactories.newSafeDocumentBuilder()
		final var docBuilder = XMLObjectProviderRegistrySupport.getParserPool();
		final var document = docBuilder.parse(new ByteArrayInputStream(retVal.getBytes()));

		String prefix = document.getDocumentElement().getPrefix();
		if (!StringUtils.isEmpty(prefix)) {
			prefix += ":";
		}

		final var faultnode = getNode(document.getDocumentElement(),
				"/" + prefix + "Envelope/" + prefix + "Body/" + prefix + "Fault");
		throw getSoapException(faultnode);
	}

	/**
	 * Method to set SOAP client configuration
	 * 
	 * @param config
	 */
	protected void setConfig(SoapClientConfig config) {
		this.config = config;
	}

	/**
	 * Method to set logger
	 * 
	 * @param logger
	 */
	protected void setLogger(Logger logger) {
		this.logger = logger;
	}
}
