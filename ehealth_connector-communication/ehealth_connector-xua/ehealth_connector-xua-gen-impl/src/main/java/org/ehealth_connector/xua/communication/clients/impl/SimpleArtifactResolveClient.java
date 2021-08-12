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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.ehealth_connector.xua.communication.clients.ArtifactResolveClient;
import org.ehealth_connector.xua.communication.config.SoapClientConfig;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.saml2.ArtifactResolve;
import org.ehealth_connector.xua.saml2.ArtifactResponse;
import org.ehealth_connector.xua.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.xua.deserialization.impl.ArtifactResponseDeserializerImpl;
import org.ehealth_connector.xua.saml2.impl.ArtifactResolveImpl;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
public class SimpleArtifactResolveClient extends AbstractSoapClient<ArtifactResponse>
		implements ArtifactResolveClient {

	public SimpleArtifactResolveClient(SoapClientConfig config) {
		setConfig(config);
	}

	private HttpEntity getSoapEntity(ArtifactResolve aArtifactResolve) throws SerializeException,
			ParserConfigurationException, TransformerException, MarshallingException {

		final Element envelopElement = createEnvelope();

		// final Element headerAssertionElement = new
		// ArtifactResolveSerializerImpl().toXmlElement(aArtifactResolve);

		final WsaHeaderValue wsHeaders = new WsaHeaderValue(
				"urn:uuid:" + UUID.randomUUID().toString(), null, null);

		createHeader(null, wsHeaders, envelopElement);

		// serialize the authnrequest to xml element
		final MarshallerFactory marshallerFactory = XMLObjectProviderRegistrySupport
				.getMarshallerFactory();
		final Marshaller marshaller = marshallerFactory
				.getMarshaller(((ArtifactResolveImpl) aArtifactResolve).getWrappedObject());

		final Element policyElement = marshaller
				.marshall(((ArtifactResolveImpl) aArtifactResolve).getWrappedObject());

		createBody(policyElement, envelopElement);

		final String body = createXmlString(envelopElement);

		getLogger().debug("SOAP Message\n" + body);

		// add string as body to httpentity
		final StringEntity stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(false);

		return stringEntity;
	}

	@Override
	protected ArtifactResponse parseResponse(String content) throws ClientSendException {
		try {
			final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			final Document soapDocument = docBuilder
					.parse(new ByteArrayInputStream(content.getBytes()));

			// get the xml response node
			final Node responseNode = soapDocument.getFirstChild().getLastChild().getFirstChild();

			final Document doc = docBuilder.newDocument();
			final Node importedNode = doc.importNode(responseNode, true);
			doc.appendChild(importedNode);

			// deserialize to the rtifactResponse instance
			final ArtifactResponseDeserializerImpl deserializer = new ArtifactResponseDeserializerImpl();
			return deserializer.fromXmlElement(doc.getDocumentElement());
		} catch (UnsupportedOperationException | IOException | DeserializeException
				| TransformerFactoryConfigurationError | ParserConfigurationException
				| SAXException e) {
			throw new ClientSendException(e);
		}
	}

	@Override
	public ArtifactResponse send(ArtifactResolve aArtifactResolve) throws ClientSendException {
		try {
			final HttpPost post = getHttpPost();
			post.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
			post.setEntity(getSoapEntity(aArtifactResolve));
			post.addHeader("Accept", "text/xml");

			return execute(post);
		} catch (final Throwable t) {
			throw new ClientSendException(t);
		}
	}

}
