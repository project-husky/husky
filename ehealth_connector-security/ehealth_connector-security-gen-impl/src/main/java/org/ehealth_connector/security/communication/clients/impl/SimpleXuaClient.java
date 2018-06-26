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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.ehealth_connector.security.communication.clients.XuaClient;
import org.ehealth_connector.security.communication.config.XuaClientConfig;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.security.communication.xua.XUserAssertionRequest;
import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.EncryptedAssertion;
import org.ehealth_connector.security.serialization.impl.AssertionSerializerImpl;
import org.ehealth_connector.security.serialization.impl.EncryptedAssertionSerializerImpl;
import org.ehealth_connector.security.serialization.impl.XUserAssertionRequestSerializerImpl;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponseCollection;
import org.opensaml.soap.wstrust.WSTrustConstants;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenResponseCollectionUnmarshaller;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the simple xua client.</div>
 * <div class="de">Klasser die den simple Client implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SimpleXuaClient extends AbstractSoapClient<List<XUserAssertionResponse>>
		implements XuaClient {

	public SimpleXuaClient(XuaClientConfig clientConfiguration) {
		setLogger(LoggerFactory.getLogger(getClass()));
		setConfig(clientConfiguration);
	}

	private HttpEntity getSoapEntity(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest, WsaHeaderValue wsHeaders)
			throws SerializeException, ParserConfigurationException, TransformerException {

		final Element envelopElement = createEnvelope();

		Element headerAssertionElement = null;
		if (aSecurityHeaderElement instanceof Assertion) {
			headerAssertionElement = new AssertionSerializerImpl()
					.toXmlElement((Assertion) aSecurityHeaderElement);
		} else if (aSecurityHeaderElement instanceof EncryptedAssertion) {
			headerAssertionElement = new EncryptedAssertionSerializerImpl()
					.toXmlElement((EncryptedAssertion) aSecurityHeaderElement);
		}
		createHeader(headerAssertionElement, wsHeaders, envelopElement);

		// serialize the authnrequest to xml element
		final XUserAssertionRequestSerializerImpl serializer = new XUserAssertionRequestSerializerImpl();
		final Element authnRequestElement = serializer.toXmlElement(aRequest);

		createBody(authnRequestElement, envelopElement);

		final String body = createXmlString(envelopElement);

		getLogger().debug("SOAP Message\n" + body);

		// add string as body to httpentity
		final StringEntity stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(false);

		return stringEntity;
	}

	@Override
	protected List<XUserAssertionResponse> parseResponse(String httpResponse)
			throws ClientSendException {
		try {
			final Element reponseElement = getResponseElement(httpResponse, WSTrustConstants.WST_NS,
					RequestSecurityTokenResponseCollection.ELEMENT_LOCAL_NAME);

			// deserialize to the Response instance
			final RequestSecurityTokenResponseCollection wstResponseCollection = (RequestSecurityTokenResponseCollection) new RequestSecurityTokenResponseCollectionUnmarshaller()
					.unmarshall(reponseElement);

			final List<RequestSecurityTokenResponse> wstResponses = wstResponseCollection
					.getRequestSecurityTokenResponses();

			final List<XUserAssertionResponse> retVal = new ArrayList<>();

			wstResponses.forEach(c -> {
				retVal.add(new XUserAssertionResponseBuilderImpl().create(c));
			});

			return retVal;
		} catch (UnsupportedOperationException | IOException | TransformerFactoryConfigurationError
				| ParserConfigurationException | SAXException | UnmarshallingException
				| XPathExpressionException e) {
			throw new ClientSendException(e);
		}
	}

	@Override
	public List<XUserAssertionResponse> send(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest) throws ClientSendException {
		try {
			final HttpPost post = getHttpPost();

			final WsaHeaderValue wsHeaders = new WsaHeaderValue(
					"urn:uuid:" + UUID.randomUUID().toString(),
					"http://docs.oasis-open.org/ws-sx/ws-trust/200512/RST/Issue", null);

			post.setEntity(getSoapEntity(aSecurityHeaderElement, aRequest, wsHeaders));

			return execute(post);
		} catch (SerializeException | ParserConfigurationException | TransformerException
				| IOException e) {
			throw new ClientSendException(e);
		}
	}

}
