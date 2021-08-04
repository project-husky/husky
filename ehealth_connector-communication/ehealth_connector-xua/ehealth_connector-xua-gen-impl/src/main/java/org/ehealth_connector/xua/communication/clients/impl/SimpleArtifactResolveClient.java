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

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.StringEntity;
import org.ehealth_connector.xua.communication.clients.ArtifactResolveClient;
import org.ehealth_connector.xua.communication.config.SoapClientConfig;
import org.ehealth_connector.xua.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.xua.deserialization.impl.ArtifactResponseDeserializerImpl;
import org.ehealth_connector.xua.exceptions.ClientSendException;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.saml2.ArtifactResolve;
import org.ehealth_connector.xua.saml2.ArtifactResponse;
import org.ehealth_connector.xua.saml2.impl.ArtifactResolveImpl;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
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

	private HttpEntity getSoapEntity(ArtifactResolve aArtifactResolve) throws
			ParserConfigurationException, TransformerException, MarshallingException {

		final var envelopElement = createEnvelope();

		final var wsHeaders = new WsaHeaderValue(
				"urn:uuid:" + UUID.randomUUID().toString(), null, null);

		createHeader(null, wsHeaders, envelopElement);

		// serialize the authnrequest to xml element
		final var marshallerFactory = XMLObjectProviderRegistrySupport
				.getMarshallerFactory();
		final var marshaller = marshallerFactory
				.getMarshaller(((ArtifactResolveImpl) aArtifactResolve).getWrappedObject());

		final var policyElement = marshaller
				.marshall(((ArtifactResolveImpl) aArtifactResolve).getWrappedObject());

		createBody(policyElement, envelopElement);

		final var body = createXmlString(envelopElement);

		getLogger().debug("SOAP Message\n {}", body);

		// add string as body to httpentity
		final var stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(false);

		return stringEntity;
	}

	@Override
	protected ArtifactResponse parseResponse(String content) throws ClientSendException {
		try {
			final var docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware(true);
			docFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			docFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
			final var docBuilder = docFactory.newDocumentBuilder();
			final var soapDocument = docBuilder
					.parse(new ByteArrayInputStream(content.getBytes()));

			// get the xml response node
			final var responseNode = soapDocument.getFirstChild().getLastChild().getFirstChild();

			final var doc = docBuilder.newDocument();
			final var importedNode = doc.importNode(responseNode, true);
			doc.appendChild(importedNode);

			// deserialize to the rtifactResponse instance
			final var deserializer = new ArtifactResponseDeserializerImpl();
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
			final var post = getHttpPost();
			post.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
			post.setEntity(getSoapEntity(aArtifactResolve));
			post.addHeader("Accept", "text/xml");

			return execute(post);
		} catch (final Exception t) {
			throw new ClientSendException(t);
		}
	}

}
