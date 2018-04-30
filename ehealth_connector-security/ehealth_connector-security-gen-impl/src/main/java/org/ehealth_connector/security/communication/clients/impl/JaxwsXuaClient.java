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
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.net.ssl.SSLContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.apache.commons.lang.StringUtils;
import org.apache.http.ssl.SSLContexts;
import org.ehealth_connector.security.communication.clients.XuaClient;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.soap.impl.HeaderAddAssertionSoapHandler;
import org.ehealth_connector.security.communication.soap.impl.LogSoapMessageHandler;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderSoapHandler;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.deserialization.impl.AbstractDeserializerImpl;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.DeserializeException;
import org.ehealth_connector.security.pki.PkiManager;
import org.ehealth_connector.security.serialization.impl.XUserAssertionRequestSerializerImpl;
import org.ehealth_connector.security.serialization.pki.PkiManagerImpl;
import org.oasis_open.docs.ws_sx.ws_trust._200512.CompleteSTSPort;
import org.oasis_open.docs.ws_sx.ws_trust._200512.ExtendedSTSPort;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityToken;
import org.oasis_open.docs.ws_sx.ws_trust._200512.STSPort;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponseCollection;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the default xua client.</div>
 * <div class="de">Klasser die den default Client implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class JaxwsXuaClient implements XuaClient {

	private XuaClientConfig config;

	public JaxwsXuaClient(XuaClientConfig clientConfiguration) {
		config = clientConfiguration;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.ehealth_connector.security.communication.clients.XuaClient#send(org.ehealth_connector.security.saml2.Assertion,
	 *      org.ehealth_connector.security.communication.xua.XUserAssertionRequest)
	 */
	@Override
	public List<XUserAssertionResponse> send(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest) throws ClientSendException {

		final RequestSecurityToken request = convertToServiceObjects(aRequest);
		final STSPort port = createPort(aSecurityHeaderElement);

		final org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenResponseCollection wsResponse = port
				.issueToken(request);

		return convertFromServiceObjects(wsResponse);
	}

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get a new soap port instance.</div>
	 * <div class="de">Methode um eine neue soap port instanz zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAssertion
	 * <div class="en">the assertion to be added to the soap header.</div>
	 * <div class="de">die Assertion die dem soap header hinzugefügt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the new soap port instance.</div>
	 * <div class="de">die neue SoapPort Instanz.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown an error occures.</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	private org.oasis_open.docs.ws_sx.ws_trust._200512.STSPort createPort(SecurityHeaderElement aSecurityHeaderElement)
			throws ClientSendException {
		try {
			final URL wsdlLocationFile = this.getClass().getResource("/wsdl/STS.wsdl");
			final URL wsdlLocation = new URL(config.getUrl());
			final QName serviceName = new QName(config.getServiceNamespace(), config.getServiceName());

			// final String keystore = new File(config.getKeyStore()).getAbsolutePath();
			// System.setProperty("javax.net.ssl.keyStore", keystore);
			// System.setProperty("javax.net.ssl.keyStorePassword", config.getKeyStorePassword());
			// System.setProperty("javax.net.ssl.keyStoreType", config.getKeyStoreType());
			//
			// System.setProperty("javax.net.ssl.trustStore", keystore);
			// System.setProperty("javax.net.ssl.trustStorePassword", config.getKeyStorePassword());
			// System.setProperty("javax.net.ssl.trustStoreType", config.getKeyStoreType());

			final org.oasis_open.docs.ws_sx.ws_trust._200512.SecurityTokenService service = new org.oasis_open.docs.ws_sx.ws_trust._200512.SecurityTokenService(
					wsdlLocation, serviceName);

			final WsaHeaderValue wsHeaders = new WsaHeaderValue("urn:uuid:" + UUID.randomUUID().toString(),
					"http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue", null);

			service.setHandlerResolver(new HandlerResolver() {

				@SuppressWarnings("rawtypes")
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					final List<Handler> handlerList = new ArrayList<>();
					handlerList.add(new WsaHeaderSoapHandler(wsHeaders));
					handlerList.add(new HeaderAddAssertionSoapHandler(aSecurityHeaderElement));
					handlerList.add(new LogSoapMessageHandler());
					return handlerList;
				}
			});

			final Iterator<QName> ports = service.getPorts();
			ports.forEachRemaining(c -> {
				LoggerFactory.getLogger(getClass()).debug("{" + c.getNamespaceURI() + "}" + c.getLocalPart());
			});
			STSPort port = null;
			try {
				port = service.getPort(new QName(config.getPortNamespace(), config.getPortName()),
						CompleteSTSPort.class);
			} catch (final Exception e) {
				try {
					port = service.getPort(new QName(config.getPortNamespace(), config.getPortName()),
							ExtendedSTSPort.class);
				} catch (final Exception e1) {
					port = service.getPort(new QName(config.getPortNamespace(), config.getPortName()), STSPort.class);
				}
			}

			final BindingProvider bp = (BindingProvider) port;
			final Map<String, List<String>> requestHeaders = new LinkedHashMap<>();
			final List<String> acceptList = new ArrayList<>();
			acceptList.add("*/*");
			requestHeaders.put("Accept", acceptList);// Collections.singletonList("text/xml"));

			if (!StringUtils.isEmpty(config.getKeyStore())) {

				final PkiManager pki = new PkiManagerImpl();
				final KeyStore keyStore = pki.loadStore(new FileInputStream(config.getKeyStore()),
						config.getKeyStorePassword(), config.getKeyStoreType());
				final SSLContext sslcontext = SSLContexts.custom()//
						.loadKeyMaterial(keyStore, config.getKeyStorePassword().toCharArray())//
						.loadTrustMaterial(new File(config.getKeyStore()), config.getKeyStorePassword().toCharArray())//
						.build();
				bp.getRequestContext().put("com.sun.xml.ws.transport.https.client.SSLSocketFactory",
						sslcontext.getSocketFactory());
			}

			return port;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to convert XUserAssertionRequest to the webservice representing class RequestSecurityToken.</div>
	 * <div class="de">Methode um einen XUserAssertionRequest in die Webservice representierende Klasse RequestSecurityToken umzuwandeln.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param aRequest
	 * <div class="en">the XUserAssertionRequest.</div>
	 * <div class="de">die XUserAssertionRequest.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the RequestSecurityToken.</div>
	 * <div class="de">die RequestSecurityToken.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	private RequestSecurityToken convertToServiceObjects(XUserAssertionRequest aRequest) throws ClientSendException {
		try {
			// System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
			// "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
			// final Element rstElement = new XUserAssertionRequestSerializerImpl().toXmlElement(aRequest);
			//
			// final JAXBContext jaxbContext = JAXBContext
			// .newInstance(org.oasis_open.docs.ws_sx.ws_trust._200512.ObjectFactory.class);
			// final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			//
			// final org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityToken request =
			// (org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityToken) unmarshaller
			// .unmarshal(rstElement);

			final byte[] xmlbytes = new XUserAssertionRequestSerializerImpl().toXmlByteArray(aRequest);

			final JAXBContext jc = JAXBContext
					.newInstance(org.oasis_open.docs.ws_sx.ws_trust._200512.ObjectFactory.class);
			final XMLInputFactory xif = XMLInputFactory.newFactory();
			xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true); // this is the magic line
			final StreamSource source = new StreamSource(new ByteArrayInputStream(xmlbytes));
			final XMLStreamReader xsr = xif.createXMLStreamReader(source);
			final Unmarshaller unmarshaller = jc.createUnmarshaller();
			final org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityToken request = (org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityToken) unmarshaller
					.unmarshal(xsr);

			return request;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to convert the webservice representing class RequestSecurityTokenResponseCollection to List<XUserAssertionResponse>.</div>
	 * <div class="de">Methode um die Webservice representierende Klasse RequestSecurityTokenResponseCollection in eine List<XUserAssertionResponse> umzuwandeln.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param wsResponse
	 * <div class="en">the RequestSecurityTokenResponseCollection.</div>
	 * <div class="de">die RequestSecurityTokenResponseCollection.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the RequestSecurityToken.</div>
	 * <div class="de">die RequestSecurityToken.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	private List<XUserAssertionResponse> convertFromServiceObjects(
			org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenResponseCollection wsResponse)
			throws ClientSendException {
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance("org.oasis_open.docs.ws_sx.ws_trust._200512");
			final Marshaller marshaller = jaxbContext.createMarshaller();

			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			final Document doc = dbf.newDocumentBuilder().newDocument();

			marshaller.marshal(wsResponse, doc);

			final RequestSecurityTokenResponseCollection response = new AbstractDeserializerImpl<RequestSecurityTokenResponseCollection, RequestSecurityTokenResponseCollection>() {

				@Override
				public RequestSecurityTokenResponseCollection fromXmlElement(Element aXmlElement)
						throws DeserializeException {
					return getOpenSamlDeserializer().deserializeFromXml(aXmlElement);
				}

				@Override
				public RequestSecurityTokenResponseCollection fromXmlString(String aXmlString)
						throws DeserializeException {
					return null;
				}

				@Override
				public RequestSecurityTokenResponseCollection fromXmlByteArray(byte[] aByteArray)
						throws DeserializeException {
					return null;
				}

			}.fromXmlElement(doc.getDocumentElement());

			final List<RequestSecurityTokenResponse> tokenResponses = response.getRequestSecurityTokenResponses();

			final List<XUserAssertionResponse> retVal = new ArrayList<>();
			tokenResponses.forEach(c -> {
				retVal.add(new XUserAssertionResponseBuilderImpl().create(c));
			});

			return retVal;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

}
