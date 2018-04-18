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
package org.ehealth_connector.communication.ch.clients.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.ehealth_connector.communication.ch.clients.PpqClient;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeed;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeedResponse;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQuery;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyQueryResponse;
import org.ehealth_connector.communication.ch.ppq.config.PpqClientConfig;
import org.ehealth_connector.communication.ch.ppq.impl.PrivacyPolicyFeedResponseBuilderImpl;
import org.ehealth_connector.security.communication.soap.impl.HeaderAddAssertionSoapHandler;
import org.ehealth_connector.security.communication.soap.impl.LogSoapMessageHandler;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderSoapHandler;
import org.ehealth_connector.security.communication.soap.impl.WsaHeaderValue;
import org.ehealth_connector.security.deserialization.impl.PrivacyPolicyQueryResponseDeserialiser;
import org.ehealth_connector.security.exceptions.ClientSendException;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.serialization.impl.PrivacyPolicyFeedSerializerImpl;
import org.ehealth_connector.security.serialization.impl.PrivacyPolicyQuerySerializerImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import oasis.names.tc.saml._2_0.protocol.Response;
import oasis.names.tc.xacml._2_0.profile.saml2_0.v2.schema.protocol.XACMLPolicyQuery;
import suisse.health.e._2015.PpqPolicyAdministration;
import suisse.health.e._2015.PpqServicePort;
import suisse.health.e._2015.policy_administration.AssertionBasedRequestType;
import suisse.health.e._2015.policy_administration.EpdPolicyRepositoryResponse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the default ppq client.</div>
 * <div class="de">Klasser die den default PPQ Client implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class DefaultPpqClient implements PpqClient {

	private PpqClientConfig config;

	public DefaultPpqClient(PpqClientConfig clientConfiguration) {
		config = clientConfiguration;
	}

	@Override
	public PrivacyPolicyQueryResponse send(Assertion aAssertion, PrivacyPolicyQuery ppQuery)
			throws ClientSendException {

		final XACMLPolicyQuery ppqServiceObj = convertToServiceObjects(ppQuery);

		final PpqServicePort port = createPort(aAssertion,
				"urn:e-health-suisse:2015:policy-administration:PolicyQuery");

		final Response wsResponse = port.policyQuery(ppqServiceObj);

		return convertFromServiceObjects(wsResponse);
	}

	public PrivacyPolicyFeedResponse managePolicy(Assertion aAssertion, PrivacyPolicyFeed ppFeed)
			throws ClientSendException {

		final PpfMethod ppfM = ppFeed.getMethod();

		final AssertionBasedRequestType parameters = convertToServiceObjects(ppFeed);

		final PpqServicePort port = createPort(aAssertion,
				"urn:e-health-suisse:2015:policy-administration:" + ppfM.toString());

		EpdPolicyRepositoryResponse wsResponse = null;
		if (PpfMethod.AddPolicy.equals(ppfM)) {
			wsResponse = port.addPolicy(parameters);
		} else if (PpfMethod.UpdatePolicy.equals(ppfM)) {
			wsResponse = port.addPolicy(parameters);
		} else if (PpfMethod.DeletePolicy.equals(ppfM)) {
			wsResponse = port.addPolicy(parameters);
		}

		return convertFromServiceObjects(wsResponse, ppFeed.getMethod());
	}

	private PrivacyPolicyQueryResponse convertFromServiceObjects(Response wsResponse) throws ClientSendException {
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance("oasis.names.tc.saml._2_0.protocol");
			final Marshaller marshaller = jaxbContext.createMarshaller();

			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			final Document doc = dbf.newDocumentBuilder().newDocument();
			marshaller.marshal(wsResponse, doc);

			final PrivacyPolicyQueryResponse response = new PrivacyPolicyQueryResponseDeserialiser()
					.fromXmlElement(doc.getDocumentElement());

			return response;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

	private PrivacyPolicyFeedResponse convertFromServiceObjects(EpdPolicyRepositoryResponse wsResponse,
			PpfMethod ppfMethod) {

		return new PrivacyPolicyFeedResponseBuilderImpl().status(wsResponse.getStatus()).method(ppfMethod).create();

	}

	private PpqServicePort createPort(Assertion aAssertion, String aAction) throws ClientSendException {
		try {

			final WsaHeaderValue wsaValues = new WsaHeaderValue("urn:uuid:" + UUID.randomUUID().toString(), aAction,
					config.getUrl());

			final URL wsdlLocation = new URL(config.getUrl());
			final QName serviceName = new QName(config.getServiceNamespace(), config.getServiceName());

			final PpqPolicyAdministration service = new PpqPolicyAdministration(wsdlLocation, serviceName);

			service.setHandlerResolver(new HandlerResolver() {

				@SuppressWarnings("rawtypes")
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					final List<Handler> handlerList = new ArrayList<>();
					handlerList.add(new WsaHeaderSoapHandler(wsaValues));
					handlerList.add(new HeaderAddAssertionSoapHandler(aAssertion));
					handlerList.add(new LogSoapMessageHandler());
					return handlerList;
				}
			});
			final PpqServicePort port = service.getPort(new QName(config.getPortNamespace(), config.getPortName()),
					PpqServicePort.class);
			return port;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

	private XACMLPolicyQuery convertToServiceObjects(PrivacyPolicyQuery ppQuery) throws ClientSendException {
		try {
			final Element ppqElement = new PrivacyPolicyQuerySerializerImpl().toXmlElement(ppQuery);

			final JAXBContext jaxbContext = JAXBContext
					.newInstance("oasis.names.tc.xacml._2_0.profile.saml2_0.v2.schema.protocol");
			final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			final XACMLPolicyQuery request = (XACMLPolicyQuery) unmarshaller.unmarshal(ppqElement);
			return request;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

	private AssertionBasedRequestType convertToServiceObjects(PrivacyPolicyFeed ppFeed) throws ClientSendException {
		try {
			final Element ppfElement = new PrivacyPolicyFeedSerializerImpl().toXmlElement(ppFeed);

			final JAXBContext jaxbContext = JAXBContext.newInstance("oasis.names.tc.saml._2_0.assertion");
			final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			final oasis.names.tc.saml._2_0.assertion.Assertion wsAssertion = (oasis.names.tc.saml._2_0.assertion.Assertion) unmarshaller
					.unmarshal(ppfElement);

			final AssertionBasedRequestType request = new suisse.health.e._2015.policy_administration.ObjectFactory()
					.createAssertionBasedRequestType();
			request.setAssertion(wsAssertion);
			return request;
		} catch (final Exception e) {
			throw new ClientSendException("Error convertion to service objects.", e);
		}
	}

}
