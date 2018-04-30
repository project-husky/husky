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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
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

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.ehealth_connector.security.communication.clients.XuaClient;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.pki.PkiManager;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.EncryptedAssertion;
import org.ehealth_connector.security.serialization.impl.AssertionSerializerImpl;
import org.ehealth_connector.security.serialization.impl.EncryptedAssertionSerializerImpl;
import org.ehealth_connector.security.serialization.impl.XUserAssertionRequestSerializerImpl;
import org.ehealth_connector.security.serialization.pki.PkiManagerImpl;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponseCollection;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenResponseCollectionUnmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the simple xua client.</div>
 * <div class="de">Klasser die den simple Client implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class SimpleXuaClient implements XuaClient {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private XuaClientConfig config;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param clientConfiguration the client configuration
	 * <!-- @formatter:on -->
	 */
	public SimpleXuaClient(XuaClientConfig clientConfiguration) {
		config = clientConfiguration;
	}

	@Override
	public List<XUserAssertionResponse> send(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest) throws ClientSendException {
		try {
			final HttpPost post = getHttpPost(config);
			post.setHeader(HttpHeaders.CONTENT_TYPE, "application/soap+xml; charset=utf-8");
			post.setEntity(getSoapEntity(aSecurityHeaderElement, aRequest));
			return execute(post);
		} catch (final Throwable t) {
			throw new ClientSendException(t);
		}
	}

	private HttpEntity getSoapEntity(SecurityHeaderElement aSecurityHeaderElement, XUserAssertionRequest aRequest)
			throws SerializeException, ParserConfigurationException, TransformerException {

		// create xml dokument
		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		final Document soapDoc = docBuilder.newDocument();

		// create soap envelope
		final Element envelopElement = soapDoc.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
		soapDoc.appendChild(envelopElement);

		final WsaHeaderValue wsHeaders = new WsaHeaderValue("urn:uuid:" + UUID.randomUUID().toString(),
				"http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue", null);

		createHeader(aSecurityHeaderElement, wsHeaders, soapDoc, envelopElement);

		createBody(aRequest, soapDoc, envelopElement);

		// transform to string
		final TransformerFactory tf = TransformerFactory.newInstance();
		final Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		final StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(soapDoc), new StreamResult(writer));
		final String body = writer.toString();

		logger.debug("SOAP Message\n" + body);

		// add string as body to httpentity
		final StringEntity stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(false);

		return stringEntity;
	}

	private void createBody(XUserAssertionRequest aRequest, Document soapDoc, Element envelopElement)
			throws SerializeException {
		// create soap body
		final Element soapBody = soapDoc.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Body");
		envelopElement.appendChild(soapBody);

		// serialize the authnrequest to xml element
		final XUserAssertionRequestSerializerImpl serializer = new XUserAssertionRequestSerializerImpl();
		final Element authnRequestElement = serializer.toXmlElement(aRequest);

		// add authnrequest to soap body
		final Node importedNode = soapDoc.importNode(authnRequestElement, true);
		soapBody.appendChild(importedNode);
	}

	private void createHeader(SecurityHeaderElement aSecurityHeaderElement, WsaHeaderValue wsHeaders, Document soapDoc,
			Element envelopElement) throws SerializeException {
		// create soap header
		final Element headerElement = soapDoc.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Header");
		envelopElement.appendChild(headerElement);

		final Element headerWsaAction = soapDoc.createElementNS("http://www.w3.org/2005/08/addressing", "Action");
		headerWsaAction.setTextContent(wsHeaders.getAction());
		headerElement.appendChild(headerWsaAction);

		final Element headerWsaMessageID = soapDoc.createElementNS("http://www.w3.org/2005/08/addressing", "MessageID");
		headerWsaMessageID.setTextContent(wsHeaders.getMessageId());
		headerElement.appendChild(headerWsaMessageID);

		final Element headerSecurityElement = soapDoc.createElementNS(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
		headerElement.appendChild(headerSecurityElement);

		Element headerAssertionElement = null;
		if (aSecurityHeaderElement instanceof Assertion) {
			headerAssertionElement = new AssertionSerializerImpl().toXmlElement((Assertion) aSecurityHeaderElement);
		} else if (aSecurityHeaderElement instanceof EncryptedAssertion) {
			headerAssertionElement = new EncryptedAssertionSerializerImpl()
					.toXmlElement((EncryptedAssertion) aSecurityHeaderElement);
		}

		// add authnrequest to soap body
		final Node importedHeaderNode = soapDoc.importNode(headerAssertionElement, true);
		headerSecurityElement.appendChild(importedHeaderNode);
	}

	List<XUserAssertionResponse> execute(HttpPost post) throws Throwable {
		final CloseableHttpClient httpclient = getHttpClient();

		final CloseableHttpResponse response = httpclient.execute(post);
		if ((response.getStatusLine() != null) && (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {

			return parseResponse(response);
		} else {
			final String error = parseResponseError(response);

			throw new Throwable("No valid response found: " + error);
		}
	}

	HttpPost getHttpPost(XuaClientConfig config) throws UnsupportedEncodingException {
		final HttpPost post = new HttpPost(config.getUrl());
		post.setConfig(getRequestConfig());
		return post;
	}

	public RequestConfig getRequestConfig() {
		return RequestConfig.custom().setAuthenticationEnabled(true).build();
	}

	private List<XUserAssertionResponse> parseResponse(CloseableHttpResponse response) throws ClientSendException {
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
			final RequestSecurityTokenResponseCollection wstResponseCollection = (RequestSecurityTokenResponseCollection) new RequestSecurityTokenResponseCollectionUnmarshaller()
					.unmarshall(doc.getDocumentElement());
			final List<RequestSecurityTokenResponse> wstResponses = wstResponseCollection
					.getRequestSecurityTokenResponses();

			final List<XUserAssertionResponse> retVal = new ArrayList<>();
			wstResponses.forEach(c -> {
				retVal.add(new XUserAssertionResponseBuilderImpl().create(c));
			});

			return retVal;
		} catch (UnsupportedOperationException | IOException | TransformerFactoryConfigurationError
				| ParserConfigurationException | SAXException | UnmarshallingException e) {
			throw new ClientSendException(e);
		}
	}

	private String parseResponseError(CloseableHttpResponse response) throws ClientSendException {
		try {
			String retVal = null;
			final HttpEntity errorEntity = response.getEntity();
			final String content = EntityUtils.toString(errorEntity);
			logger.debug("SOAP Message\n" + content);
			if (errorEntity.getContentType().getValue().startsWith("multipart")) {
				final String boundary = getBoundary(errorEntity);

				// final String pattern = "--" + boundary + "\\R(.*?\\R*?)*?\\R--" + boundary + "--";
				// final String pattern = "<soap\\:Envelope (.*?\\R*?)*?\\R</soap\\:Envelope>";
				final String pattern = "<([a-zA-Z:]+)Envelope(.+)>(.+)</([a-zA-Z:]+)Envelope>";
				final Pattern regex = Pattern.compile(pattern);
				final Matcher matcher = regex.matcher(content);
				while (matcher.find()) {
					retVal = matcher.group();
					break;
				}

			}

			if (retVal != null) {
				return paserSoapFault(retVal);
			}

			return "Error";
		} catch (UnsupportedOperationException | TransformerFactoryConfigurationError | ParseException | IOException
				| ParserConfigurationException | SAXException e) {
			throw new ClientSendException(e);
		}
	}

	private String paserSoapFault(String retVal) throws ParserConfigurationException, SAXException, IOException {
		final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		final Document document = docBuilder.parse(new ByteArrayInputStream(retVal.getBytes()));
		final NodeList faultnodes = document.getDocumentElement().getFirstChild().getFirstChild().getChildNodes();

		final StringBuffer st = new StringBuffer();

		for (int i = 0; i < faultnodes.getLength(); ++i) {
			final Node node = faultnodes.item(i);
			if (st.length() > 0) {
				st.append(", ");
			}
			st.append(node.getNodeName());
			st.append(": ");
			st.append(node.getTextContent());

		}
		st.insert(0, "Soap Fault: ");

		return st.toString();
	}

	private String getBoundary(HttpEntity errorEntity) {
		String retVal = null;
		final Header contentType = errorEntity.getContentType();
		final HeaderElement[] elements = contentType.getElements();
		for (final HeaderElement element : elements) {
			final NameValuePair[] nameValues = element.getParameters();
			final StringBuffer stb = new StringBuffer();
			for (final NameValuePair nameValue : nameValues) {
				if ("boundary".equalsIgnoreCase(nameValue.getName())) {
					retVal = nameValue.getValue();
					break;
				}
			}
		}
		return retVal;
	}

	public CloseableHttpClient getHttpClient() throws ClientSendException {
		if (!StringUtils.isEmpty(config.getKeyStore())) {
			try {
				final PkiManager pki = new PkiManagerImpl();
				final KeyStore keyStore = pki.loadStore(new FileInputStream(config.getKeyStore()),
						config.getKeyStorePassword(), config.getKeyStoreType());
				final SSLContext sslcontext = SSLContexts.custom()//
						.loadKeyMaterial(keyStore, config.getKeyStorePassword().toCharArray())//
						.loadTrustMaterial(new File(config.getKeyStore()), config.getKeyStorePassword().toCharArray())//
						.build();
				return HttpClients.custom().setSslcontext(sslcontext).build();
			} catch (KeyStoreException | KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException
					| CertificateException | IOException e) {
				throw new ClientSendException(e);
			}
		}

		return HttpClients.createDefault();
	}

}
