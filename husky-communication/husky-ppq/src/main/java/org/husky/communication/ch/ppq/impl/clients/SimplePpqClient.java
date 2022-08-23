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
package org.husky.communication.ch.ppq.impl.clients;

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.herasaf.xacml.core.context.impl.AttributeType;
import org.herasaf.xacml.core.context.impl.AttributeValueType;
import org.herasaf.xacml.core.context.impl.RequestType;
import org.husky.communication.CamelService;
import org.husky.communication.ch.ppq.api.PrivacyPolicyQuery;
import org.husky.communication.ch.ppq.api.PrivacyPolicyQueryResponse;
import org.husky.communication.ch.ppq.api.clients.PpqClient;
import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.impl.PrivacyPolicyQueryResponseBuilderImpl;
import org.husky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.IiDataTypeAttribute;
import org.openehealth.ipf.commons.ihe.xacml20.stub.hl7v3.II;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.ResponseType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.protocol.XACMLPolicyQueryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class implementing the simple ppq client.
 */
public class SimplePpqClient extends CamelService implements PpqClient {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(SimplePpqClient.class);

	private PpClientConfig config;

	public SimplePpqClient(PpClientConfig clientConfiguration) {
		this.config = clientConfiguration;
	}

	public PrivacyPolicyQueryResponse send(SecurityHeaderElement aAssertion, PrivacyPolicyQuery query) {

		try {
			if (query != null) {
				XACMLPolicyQueryType requestToSend = convertPrivacyPolicyQuery(query);

				var secure = config.getUrl().contains("https://");
				final var serverInLogger = "#serverInLogger";
				final var serverOutLogger = "#serverOutLogger";
				final var endpoint = String.format(
						"ch-ppq2://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=#auditContext",
						config.getUrl().replace("http://", "").replace("https://", ""), serverInLogger, serverInLogger,
						serverOutLogger,
						serverOutLogger, secure, getAuditContext().isAuditEnabled());

				final var exchange = send(endpoint, requestToSend, aAssertion, null, null);

				var response = exchange.getMessage().getBody(ResponseType.class);
				return new PrivacyPolicyQueryResponseBuilderImpl().create(response);

			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}

	private XACMLPolicyQueryType convertPrivacyPolicyQuery(PrivacyPolicyQuery query) {
		var request = new XACMLPolicyQueryType();

		request.setConsent(query.getConsent());
		request.setDestination(query.getDestination());
		request.setID(query.getId());
		request.setVersion("2.0");

		XMLGregorianCalendar xmlGregCal = null;
		try {
			final var retVal = new GregorianCalendar();
			retVal.setTimeInMillis(query.getIssueInstant().getTimeInMillis());
			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
			request.setIssueInstant(xmlGregCal);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}

		var requestType = new RequestType();
		var resourceType = new org.herasaf.xacml.core.context.impl.ResourceType();
		var attributeType = new AttributeType();
		attributeType.setAttributeId("urn:e-health-suisse:2015:epr-spid");
		attributeType.setDataType(new IiDataTypeAttribute());
		var attributeValueType = new AttributeValueType();

		if (query.getInstanceIdentifier() != null) {
			var instanceIdent = new II();
			instanceIdent.setExtension(query.getInstanceIdentifier().getExtension());
			instanceIdent.setRoot(query.getInstanceIdentifier().getRoot());
			attributeValueType.getContent()
					.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "InstanceIdentifier"), II.class, instanceIdent));
		}

		attributeType.getAttributeValues().add(attributeValueType);
		resourceType.getAttributes().add(attributeType);
		requestType.getResources().add(resourceType);

		request.getRequestOrPolicySetIdReferenceOrPolicyIdReference()
				.add(new JAXBElement<>(new QName("urn:oasis:names:tc:xacml:2.0:context:schema:os", "Request"),
						RequestType.class, requestType));

		return request;

	}

}
