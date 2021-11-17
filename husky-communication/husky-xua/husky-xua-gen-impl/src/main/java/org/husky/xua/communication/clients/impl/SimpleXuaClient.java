/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.xua.communication.clients.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.husky.xua.communication.clients.XuaClient;
import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.soap.impl.WsaHeaderValue;
import org.husky.xua.communication.xua.XUserAssertionRequest;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.exceptions.ClientSendException;
import org.husky.xua.exceptions.SerializeException;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.EncryptedAssertion;
import org.husky.xua.serialization.impl.AssertionSerializerImpl;
import org.husky.xua.serialization.impl.EncryptedAssertionSerializerImpl;
import org.husky.xua.serialization.impl.UsernameTokenSerializerImpl;
import org.husky.xua.serialization.impl.XUserAssertionRequestSerializerImpl;
import org.husky.xua.wssecurity.UsernameToken;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponseCollection;
import org.opensaml.soap.wstrust.WSTrustConstants;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenResponseCollectionUnmarshaller;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.xml.XMLParserException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the simple xua client.</div>
 * <div class="de">Klasse die den Simple Client implementiert.</div>
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

		final var envelopElement = createEnvelope();

		Element headerAssertionElement = null;
		if (aSecurityHeaderElement instanceof Assertion) {
			headerAssertionElement = new AssertionSerializerImpl()
					.toXmlElement((Assertion) aSecurityHeaderElement);
		} else if (aSecurityHeaderElement instanceof EncryptedAssertion) {
			headerAssertionElement = new EncryptedAssertionSerializerImpl()
					.toXmlElement((EncryptedAssertion) aSecurityHeaderElement);
		} else if (aSecurityHeaderElement instanceof UsernameToken) {
			headerAssertionElement = new UsernameTokenSerializerImpl()
					.toXmlElement((UsernameToken) aSecurityHeaderElement);
		}
		createHeader(headerAssertionElement, wsHeaders, envelopElement);

		// serialize the authnrequest to xml element
		final var serializer = new XUserAssertionRequestSerializerImpl();
		final var authnRequestElement = serializer.toXmlElement(aRequest);

		createBody(authnRequestElement, envelopElement);

		final var body = createXmlString(envelopElement);

		getLogger().debug("SOAP Message\n {}", body);

		// add string as body to httpentity
		final var stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(false);

		return stringEntity;
	}

	@Override
	protected List<XUserAssertionResponse> parseResponse(String httpResponse)
			throws ClientSendException {
		try {
			final var reponseElement = getResponseElement(httpResponse, WSTrustConstants.WST_NS,
					RequestSecurityTokenResponseCollection.ELEMENT_LOCAL_NAME);

			// deserialize to the Response instance
			final RequestSecurityTokenResponseCollection wstResponseCollection = (RequestSecurityTokenResponseCollection) new RequestSecurityTokenResponseCollectionUnmarshaller()
					.unmarshall(reponseElement);

			final List<RequestSecurityTokenResponse> wstResponses = wstResponseCollection
					.getRequestSecurityTokenResponses();

			final List<XUserAssertionResponse> retVal = new ArrayList<>();

			wstResponses.forEach(c -> 
				retVal.add(new XUserAssertionResponseBuilderImpl().create(c))
			);

			return retVal;
		} catch (UnsupportedOperationException | TransformerFactoryConfigurationError | UnmarshallingException
				| XPathExpressionException | XMLParserException e) {
			throw new ClientSendException(e);
		}
	}

	@Override
	public List<XUserAssertionResponse> send(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest) throws ClientSendException {
		try {
			final var post = getHttpPost();

			final var wsHeaders = new WsaHeaderValue(
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
