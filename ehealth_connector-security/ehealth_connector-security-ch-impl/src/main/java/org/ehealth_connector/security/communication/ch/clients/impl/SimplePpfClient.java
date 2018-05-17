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
package org.ehealth_connector.security.communication.ch.clients.impl;

import java.io.IOException;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.ehealth_connector.security.ch.epr.policyadmin.EprPolicyRepositoryResponse;
import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlAssertionBasedRequest;
import org.ehealth_connector.security.ch.epr.policyadmin.impl.AddPolicyRequestBuilder;
import org.ehealth_connector.security.ch.epr.policyadmin.impl.DeletePolicyRequestBuilder;
import org.ehealth_connector.security.ch.epr.policyadmin.impl.UpdatePolicyRequestBuilder;
import org.ehealth_connector.security.ch.ppq.PrivacyPolicyFeed;
import org.ehealth_connector.security.ch.ppq.PrivacyPolicyFeedResponse;
import org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl;
import org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyFeedResponseImpl;
import org.ehealth_connector.security.communication.ch.clients.PpfClient;
import org.ehealth_connector.security.communication.ch.ppq.config.PpClientConfig;
import org.ehealth_connector.security.communication.clients.impl.AbstractSoapClient;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.security.core.SecurityHeaderElement;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.exceptions.SerializeException;
import org.ehealth_connector.security.exceptions.SoapException;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.EncryptedAssertion;
import org.ehealth_connector.security.serialization.impl.AssertionSerializerImpl;
import org.ehealth_connector.security.serialization.impl.EncryptedAssertionSerializerImpl;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the simple ppq client.</div>
 * <div class="de">Klasser die den Simple PPQ Client implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class SimplePpfClient extends AbstractSoapClient<PrivacyPolicyFeedResponse> implements PpfClient {

	private static final String EHS_2015_POLYADMIN = "urn:e-health-suisse:2015:policy-administration:";

	public SimplePpfClient(PpClientConfig clientConfiguration) {
		setLogger(LoggerFactory.getLogger(getClass()));
		setConfig(clientConfiguration);
	}

	@Override
	public PrivacyPolicyFeedResponse send(SecurityHeaderElement aAssertion, PrivacyPolicyFeed request)
			throws ClientSendException {

		try {
			final HttpPost post = getHttpPost();

			final String actionString = EHS_2015_POLYADMIN + request.getMethod().name();

			final WsaHeaderValue wsHeaders = new WsaHeaderValue("urn:uuid:" + UUID.randomUUID().toString(),
					actionString, null);

			post.setEntity(getSoapEntity(aAssertion, request, wsHeaders));

			final PrivacyPolicyFeedResponseImpl response = (PrivacyPolicyFeedResponseImpl) execute(post);
			response.setMethod(request.getMethod());
			return response;
		} catch (final Throwable t) {
			throw new ClientSendException(t);
		}
	}

	private HttpEntity getSoapEntity(SecurityHeaderElement aSecurityHeaderElement, PrivacyPolicyFeed feed,
			WsaHeaderValue wsHeaders)
			throws ParserConfigurationException, SerializeException, TransformerException, MarshallingException {
		final Element envelopElement = createEnvelope();

		Element headerAssertionElement = null;
		if (aSecurityHeaderElement instanceof Assertion) {
			headerAssertionElement = new AssertionSerializerImpl().toXmlElement((Assertion) aSecurityHeaderElement);
		} else if (aSecurityHeaderElement instanceof EncryptedAssertion) {
			headerAssertionElement = new EncryptedAssertionSerializerImpl()
					.toXmlElement((EncryptedAssertion) aSecurityHeaderElement);
		}
		createHeader(headerAssertionElement, wsHeaders, envelopElement);

		OpenSamlAssertionBasedRequest opensamlFeed = null;
		if (PrivacyPolicyFeed.PpfMethod.AddPolicy.equals(feed.getMethod())) {
			opensamlFeed = new AddPolicyRequestBuilder().assertion(feed.getAssertion()).buildObject();
		} else if (PrivacyPolicyFeed.PpfMethod.UpdatePolicy.equals(feed.getMethod())) {
			opensamlFeed = new UpdatePolicyRequestBuilder().assertion(feed.getAssertion()).buildObject();
		} else if (PrivacyPolicyFeed.PpfMethod.DeletePolicy.equals(feed.getMethod())) {
			opensamlFeed = new DeletePolicyRequestBuilder().assertion(feed.getAssertion()).buildObject();
		}

		// serialize the authnrequest to xml element
		final MarshallerFactory marshallerFactory = XMLObjectProviderRegistrySupport.getMarshallerFactory();
		final Marshaller marshaller = marshallerFactory.getMarshaller(opensamlFeed);

		final Element policyElement = marshaller.marshall(opensamlFeed);

		createBody(policyElement, envelopElement);

		final String body = createXmlString(envelopElement);

		getLogger().debug("SOAP Message\n" + body);

		// add string as body to httpentity
		final StringEntity stringEntity = new StringEntity(body, "UTF-8");
		stringEntity.setChunked(false);

		return stringEntity;
	}

	@Override
	protected PrivacyPolicyFeedResponse parseResponse(String httpResponse) throws ClientSendException {
		try {

			final Element reponseElement = getResponseElement(httpResponse, EprPolicyRepositoryResponse.DEFAULT_NS_URI,
					EprPolicyRepositoryResponse.DEFAULT_ELEMENT_LOCAL_NAME);
			final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport.getUnmarshallerFactory();
			final Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(reponseElement);

			final EprPolicyRepositoryResponse response = (EprPolicyRepositoryResponse) unmarshaller
					.unmarshall(reponseElement);

			if (PrivacyPolicyFeedResponse.FAILURE.equals(response.getStatus())) {
				return parseResponseError(httpResponse);
			}

			return new PrivacyPolicyFeedResponseBuilderImpl().status(response.getStatus()).create();
		} catch (UnsupportedOperationException | IOException | TransformerFactoryConfigurationError
				| ParserConfigurationException | SAXException | UnmarshallingException | XPathExpressionException e) {
			throw new ClientSendException(e);
		}
	}

	@Override
	protected PrivacyPolicyFeedResponse parseResponseError(String httpResponse) throws ClientSendException {
		try {
			final Element reponseElement = getResponseElement(httpResponse, EprPolicyRepositoryResponse.DEFAULT_NS_URI,
					EprPolicyRepositoryResponse.DEFAULT_ELEMENT_LOCAL_NAME);
			final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport.getUnmarshallerFactory();
			final Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(reponseElement);

			final EprPolicyRepositoryResponse response = (EprPolicyRepositoryResponse) unmarshaller
					.unmarshall(reponseElement);

			final PrivacyPolicyFeedResponse ppfResponse = new PrivacyPolicyFeedResponseBuilderImpl()
					.status(response.getStatus()).create();

			try {
				final Element faultElement = getResponseElement(httpResponse, "http://www.w3.org/2003/05/soap-envelope",
						"Fault");
				if (faultElement != null) {
					final SoapException exception = getSoapException(faultElement);
					ppfResponse.getExceptions().add(exception);
				}

			} catch (final XPathExpressionException e) {
				getLogger().trace("Error", e);
			}
			try {
				final Element faultText = getResponseElement(httpResponse, "http://www.w3.org/2003/05/soap-envelope",
						"Text");
				if (faultText != null) {
					final SoapException exception = getSoapException(faultText);
					ppfResponse.getExceptions().add(exception);
				}
			} catch (final XPathExpressionException e) {
				getLogger().trace("Error", e);
			}

			return ppfResponse;
		} catch (UnsupportedOperationException | TransformerFactoryConfigurationError | ParseException | IOException
				| ParserConfigurationException | SAXException | UnmarshallingException | XPathExpressionException e) {
			throw new ClientSendException(e);
		}
	}

}
