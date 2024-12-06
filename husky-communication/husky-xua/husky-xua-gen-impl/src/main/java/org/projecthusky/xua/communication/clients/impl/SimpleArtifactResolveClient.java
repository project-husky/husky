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

import java.io.ByteArrayInputStream;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.StringEntity;
import org.projecthusky.xua.communication.clients.ArtifactResolveClient;
import org.projecthusky.xua.communication.config.SoapClientConfig;
import org.projecthusky.xua.communication.soap.impl.WsaHeaderValue;
import org.projecthusky.xua.deserialization.impl.ArtifactResponseDeserializerImpl;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.DeserializeException;
import org.projecthusky.xua.saml2.ArtifactResolve;
import org.projecthusky.xua.saml2.ArtifactResponse;
import org.projecthusky.xua.saml2.impl.ArtifactResolveImpl;

import net.shibboleth.shared.xml.XMLParserException;

import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;


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

	/**
	 * Constructor with param.
	 * @param clientConfiguration the client configuration
	 */
	public SimpleArtifactResolveClient(SoapClientConfig clientConfiguration) {
		setConfig(clientConfiguration);
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
			// Use the parser from the OpenSAML ParserPool because its implementation may be
			// different than
			// XmlFactories.newSafeDocumentBuilder()
			final var docBuilder = XMLObjectProviderRegistrySupport.getParserPool();
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
		} catch (UnsupportedOperationException | DeserializeException | TransformerFactoryConfigurationError
				| XMLParserException e) {
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
