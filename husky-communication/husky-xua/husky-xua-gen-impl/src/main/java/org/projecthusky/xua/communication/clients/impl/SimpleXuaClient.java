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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.projecthusky.xua.communication.clients.XuaClient;
import org.projecthusky.xua.communication.config.XuaClientConfig;
import org.projecthusky.xua.communication.soap.impl.WsaHeaderValue;
import org.projecthusky.xua.communication.xua.XUserAssertionRequest;
import org.projecthusky.xua.communication.xua.XUserAssertionResponse;
import org.projecthusky.xua.communication.xua.impl.XUserAssertionResponseBuilderImpl;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.saml2.Assertion;
import org.projecthusky.xua.saml2.EncryptedAssertion;
import org.projecthusky.xua.serialization.impl.AssertionSerializerImpl;
import org.projecthusky.xua.serialization.impl.EncryptedAssertionSerializerImpl;
import org.projecthusky.xua.serialization.impl.UsernameTokenSerializerImpl;
import org.projecthusky.xua.serialization.impl.XUserAssertionRequestSerializerImpl;
import org.projecthusky.xua.wssecurity.UsernameToken;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponseCollection;
import org.opensaml.soap.wstrust.WSTrustConstants;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenResponseCollectionUnmarshaller;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import net.shibboleth.shared.xml.XMLParserException;

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

	/**
	 * Constructor with param.
	 * @param clientConfiguration the client configuration
	 */
	public SimpleXuaClient(XuaClientConfig clientConfiguration) {
		setLogger(LoggerFactory.getLogger(getClass()));
		setConfig(clientConfiguration);
	}

	private HttpEntity getSoapEntity(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest, WsaHeaderValue wsHeaders)
			throws SerializeException, ParserConfigurationException, TransformerException {

		final var envelopElement = createEnvelope();

		Element headerAssertionElement = null;
		if (aSecurityHeaderElement instanceof Assertion assertion) {
			headerAssertionElement = new AssertionSerializerImpl()
					.toXmlElement(assertion);
		} else if (aSecurityHeaderElement instanceof EncryptedAssertion assertion) {
			headerAssertionElement = new EncryptedAssertionSerializerImpl()
					.toXmlElement(assertion);
		} else if (aSecurityHeaderElement instanceof UsernameToken token) {
			headerAssertionElement = new UsernameTokenSerializerImpl()
					.toXmlElement(token);
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
