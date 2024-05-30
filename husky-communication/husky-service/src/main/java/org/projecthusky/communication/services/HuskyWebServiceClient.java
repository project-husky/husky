/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.ihe.gazelle.hl7v3.mcciin000002UV01.MCCIIN000002UV01Type;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02Type;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02Type;
import net.ihe.gazelle.hl7v3.prpain201306UV02.PRPAIN201306UV02Type;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.util.CastUtils;
import org.apache.cxf.headers.Header;
import org.apache.cxf.headers.Header.Direction;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.hl7v3.core.requests.PixV3QueryRequest;
import org.openehealth.ipf.commons.ihe.hl7v3.core.responses.PixV3QueryResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchRequest;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DsmlMessage;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.ErrorResponse;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.QueryRegistry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.RetrieveDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.opensaml.core.xml.XMLObject;
import org.projecthusky.common.communication.AtnaConfig;
import org.projecthusky.common.communication.AtnaConfig.AtnaConfigMode;
import org.projecthusky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.projecthusky.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.common.utils.xml.XmlMarshaller;
import org.projecthusky.common.utils.xml.XmlUnmarshaller;
import org.projecthusky.communication.DocumentRequest;
import org.projecthusky.communication.requests.hpd.HpdRequest;
import org.projecthusky.communication.requests.xds.XdsFindFoldersStoredQuery;
import org.projecthusky.communication.requests.xds.XdsProvideAndRetrieveDocumentSetQuery;
import org.projecthusky.communication.requests.xds.XdsRegistryStoredFindDocumentsQuery;
import org.projecthusky.communication.requests.xds.XdsDocumentSetRequest;
import org.projecthusky.communication.requests.hpd.HpdBatchRequest;
import org.projecthusky.communication.requests.hpd.HpdSearchQuery;
import org.projecthusky.communication.requests.pdq.PdqQuery;
import org.projecthusky.communication.requests.svs.SvsValueSetRequest;
import org.projecthusky.communication.requests.xua.XuaRequest;
import org.projecthusky.communication.responses.hpd.HpdFeedResponse;
import org.projecthusky.communication.responses.hpd.HpdQueryResponse;
import org.projecthusky.communication.responses.hpd.HpdResponse;
import org.projecthusky.communication.responses.svs.SvsValueSetResponse;
import org.projecthusky.communication.responses.xua.XuaResponse;
import org.projecthusky.communication.utils.HpdUtils;
import org.projecthusky.communication.utils.HuskyUtils;
import org.projecthusky.communication.utils.XDSUtils;
import org.projecthusky.valueset.api.ValueSetManager;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.exceptions.InitializationException;
import org.projecthusky.xua.communication.clients.impl.SimpleXuaClient;
import org.projecthusky.xua.communication.config.XuaClientConfig;
import org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.projecthusky.xua.communication.xua.XUserAssertionResponse;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.projecthusky.xua.serialization.impl.OpenSaml2SerializerImpl;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * This class is implemented for the mid/low-level access of the EPD Services.
 * <br/>
 * For the actual transfer of messages Apache Camel is used, which needs to be
 * provided by the application binding this service. In case of a Spring (Boot)
 * application this is covered by the default application context.
 *
 * @author szalai
 */
@Component
@Slf4j
public class HuskyWebServiceClient {
//	private static final String SERVER_IN_LOGGER = "#serverInLogger";
//	private static final String SERVER_OUT_LOGGER = "#serverOutLogger";
//	private static final String AUDIT_CONTEXT = "#auditContext";
//	private static final String HTTPS_LITERAL = "https://";
//	private static final String HTTP_LITERAL = "http://";
	private static final String LOG_SEND_REQUEST = "Sending request to '{}' endpoint";

	@Getter
	@Setter
	/** The ATNA config mode (secure or unsecure) */
	private AtnaConfig.AtnaConfigMode atnaConfigMode = AtnaConfigMode.UNSECURE;

	@Getter
	@Setter
	/**
	 * Determines if XDS document metadata will be extracted automatically (e.g.
	 * from CDA documents
	 */
	private DocumentMetadataExtractionMode documentMetadataExtractionMode = DocumentMetadataExtractionMode.DEFAULT_EXTRACTION;

	@Getter
	@Setter
	private SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode = SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION;

	private final CamelContext camelContext;
	private final AuditContext auditContext;

	public HuskyWebServiceClient(final CamelContext camelContext, final AuditContext auditContext) {
		this.camelContext = camelContext;
		this.auditContext = auditContext;
	}

	protected void addWssHeader(SecurityHeaderElement securityHeaderElement, Exchange exchange)
			throws SerializeException, ParserConfigurationException {
		log.debug("Adding WSS Headers...");
		Element wssElement = new OpenSaml2SerializerImpl()
				.serializeToXml((XMLObject) securityHeaderElement.getWrappedObject());

		DocumentBuilder docBuilder = XmlFactories.newSafeDocumentBuilder();
		Document doc = docBuilder.newDocument();

		Element wsseElement = doc.createElementNS(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "wsse:Security");

		QName wsseQName = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
				"Security", "wsse");

		Node replaceNode = wsseElement.getOwnerDocument().importNode(wssElement, true);
		wsseElement.appendChild(replaceNode);

		Map<QName, org.apache.cxf.headers.Header> soapHeaders = CastUtils
				.cast((Map<QName, org.apache.cxf.headers.Header>) exchange.getIn()
						.getHeader(AbstractWsEndpoint.OUTGOING_SOAP_HEADERS));

		if (soapHeaders == null) {
			soapHeaders = new HashMap<>();
		}

		try {
			Header newHeader = new Header(wsseQName, wsseElement);
			newHeader.setDirection(Direction.DIRECTION_OUT);
			soapHeaders.put(wsseQName, newHeader);
			exchange.getIn().setHeader(AbstractWsEndpoint.OUTGOING_SOAP_HEADERS, soapHeaders);
		} catch (Exception e) {
			log.error("Exception caught while creating the WSS header", e);
		}

	}

	protected void addHttpHeader(Exchange exchange, Map<String, String> outgoingHttpHeaders) {
		log.debug("Adding HTTP Headers...");
		Map<String, String> outgoingHeaders = CastUtils
				.cast((Map<String, String>) exchange.getIn().getHeader(AbstractWsEndpoint.OUTGOING_HTTP_HEADERS));

		if (outgoingHeaders == null) {
			outgoingHeaders = new HashMap<>();
		}

		for (Entry<String, String> entry : outgoingHttpHeaders.entrySet()) {
			if (entry != null && entry.getValue() != null && entry.getKey() != null) {
				outgoingHeaders.put(entry.getKey(), entry.getValue());
			}
		}

		exchange.getIn().setHeader(AbstractWsEndpoint.OUTGOING_HTTP_HEADERS, outgoingHeaders);
	}

	public Exchange send(String endpoint, Object body, SecurityHeaderElement securityHeaderElement, String messageId,
			Map<String, String> outgoingHttpHeaders)
			throws SerializeException, ParserConfigurationException, IOException {
		log.debug("Sending message...");
		Exchange exchange = new DefaultExchange(camelContext);
		exchange.getIn().setBody(body);

		if (securityHeaderElement != null) {
			addWssHeader(securityHeaderElement, exchange);
		}

		if (outgoingHttpHeaders != null && !outgoingHttpHeaders.isEmpty()) {
			addHttpHeader(exchange, outgoingHttpHeaders);
		}

		try (ProducerTemplate template = camelContext.createProducerTemplate()) {
			Exchange result = template.send(endpoint, exchange);
			if (result.getException() != null) {
				throw new RuntimeException(result.getException());
			}
			return result;
		}
	}

	public PRPAIN201306UV02Type sendPdqSearchQueryRequest(PdqQuery request, SecurityHeaderElement security, URI pdqDest,
			String messageId)
			throws JAXBException, DataBindingException, ParserConfigurationException, SerializeException, IOException {

		String endpoint = HuskyUtils.createEndpoint(HuskyUtils.PDQV3_ITI47, //
				pdqDest, //
				pdqDest.toString().contains(HuskyUtils.HTTPS_LITERAL), //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));

		String message = XmlMarshaller.marshall(request.getRootElement());

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				"application/soap+xml; charset=UTF-8; action=\"urn:hl7-org:v3:PRPA_IN201305UV02\"");

		Exchange exchange = this.send(endpoint, message, security, messageId, outgoingHeaders);

		String xml = exchange.getMessage().getBody(String.class);

		return XmlUnmarshaller.unmarshallStringAsType(xml, PRPAIN201306UV02Type.class);
	}

	public MCCIIN000002UV01Type sendPixAddPatientRequest(PRPAIN201301UV02Type request, SecurityHeaderElement assertion,
			URI pdqDest, String action, String messageId)
			throws JAXBException, SerializeException, ParserConfigurationException, IOException {
		Marshaller marshaller = createMarshaller(JAXBContext.newInstance(PRPAIN201301UV02Type.class));

		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(request, stringWriter);

		String xml = sendITI44Query(stringWriter.toString(), assertion, pdqDest, action, messageId);

		Unmarshaller unmarshaller = JAXBContext.newInstance(MCCIIN000002UV01Type.class).createUnmarshaller();
		return (MCCIIN000002UV01Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	public MCCIIN000002UV01Type sendPixUpdatePatientRequest(PRPAIN201302UV02Type request,
			SecurityHeaderElement assertion, URI pdqDest, String action, String messageId)
			throws JAXBException, SerializeException, ParserConfigurationException, IOException {
		Marshaller marshaller = createMarshaller(JAXBContext.newInstance(PRPAIN201302UV02Type.class));

		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(request, stringWriter);

		String xml = sendITI44Query(stringWriter.toString(), assertion, pdqDest, action, messageId);

		Unmarshaller unmarshaller = JAXBContext.newInstance(MCCIIN000002UV01Type.class).createUnmarshaller();
		return (MCCIIN000002UV01Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	public MCCIIN000002UV01Type sendITI44Query(PRPAIN201304UV02Type request, SecurityHeaderElement assertion,
			URI pdqDest, String action, String messageId)
			throws JAXBException, SerializeException, ParserConfigurationException, IOException {

		Marshaller marshaller = createMarshaller(JAXBContext.newInstance(PRPAIN201304UV02Type.class));

		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(request, stringWriter);

		String xml = sendITI44Query(stringWriter.toString(), assertion, pdqDest, action, messageId);

		Unmarshaller unmarshaller = JAXBContext.newInstance(MCCIIN000002UV01Type.class).createUnmarshaller();
		return (MCCIIN000002UV01Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	private String sendITI44Query(String request, SecurityHeaderElement assertion, URI pdqDest, String action,
			String messageId) throws SerializeException, ParserConfigurationException, IOException {
		String endpoint = HuskyUtils.createEndpoint(HuskyUtils.PIXV3_ITI44, //
				pdqDest, //
				pdqDest.toString().contains(HuskyUtils.HTTPS_LITERAL), //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));

		log.info("Sending request to '{}' endpoint", endpoint);

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				String.format("application/soap+xml; charset=UTF-8; action=\"%s\"", action));

		Exchange exchange = send(endpoint, request, assertion, messageId, outgoingHeaders);

		return exchange.getMessage().getBody(String.class);
	}

	public PixV3QueryResponse sendQuery(PixV3QueryRequest request, SecurityHeaderElement assertion, URI pdqDest,
			String messageId) throws Exception {
		String endpoint = HuskyUtils.createEndpoint(HuskyUtils.PIXV3_ITI45, //
				pdqDest, //
				pdqDest.toString().contains(HuskyUtils.HTTPS_LITERAL), //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				"application/soap+xml; charset=UTF-8; action=\"urn:hl7-org:v3:PRPA_IN201309UV02\"");

		Exchange exchange = send(endpoint, request, assertion, messageId, outgoingHeaders);

		return exchange.getMessage().getBody(PixV3QueryResponse.class);
	}

	public QueryResponse sendRegistryStoredFindDocumentsQuery(XdsRegistryStoredFindDocumentsQuery query,
			SecurityHeaderElement securityHeader, URI destination, QueryReturnType returnType, String messageId)
			throws SerializeException, ParserConfigurationException, IOException {
		QueryRegistry queryRegistry = new QueryRegistry(query.getIpfQuery());
		queryRegistry.setReturnType(returnType);

//		String endpoint = createEndpoint(destination.toString(), XDS_ITI18);
		final String strippedUrl = destination.toString()
				.replace(HuskyUtils.HTTPS_LITERAL, "").replace(HuskyUtils.HTTP_LITERAL, "");
		String endpoint = HuskyUtils.createEndpoint(HuskyUtils.XDS_ITI18, //
				strippedUrl, //
				destination.toString().contains(HuskyUtils.HTTPS_LITERAL), //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));
		Exchange exchange = send(endpoint, queryRegistry, securityHeader, messageId, null);

		return exchange.getMessage().getBody(QueryResponse.class);
	}

	public RetrievedDocumentSet send(XdsDocumentSetRequest request, SecurityHeaderElement securityHeader,
			URI destination, String messageId) throws SerializeException, ParserConfigurationException, IOException {
		RetrieveDocumentSet retrieveDocumentSet = new RetrieveDocumentSet();

		for (final DocumentRequest element : request.getDocumentRequests()) {
			if (element != null) {
				retrieveDocumentSet.addReferenceTo(element.getIpfDocumentEntry());
			}
		}

		String endpoint = HuskyUtils.createEndpoint(HuskyUtils.XDS_ITI43, //
				destination, //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));
		Exchange exchange = send(endpoint, retrieveDocumentSet, securityHeader, messageId, null);

		return exchange.getMessage().getBody(RetrievedDocumentSet.class);
	}

	/**
	 * It implements the following IHE transaction: [ITI-40] Provide Identity
	 * Assertions
	 */
	public XuaResponse send(XuaRequest xuaRequest) throws ClientSendException {
		SimpleXuaClient xuaClient = new SimpleXuaClient(createXuaClientConfig(xuaRequest));

		List<XUserAssertionResponse> xuaResponses = xuaClient.send(xuaRequest.getIdpAssertion(), xuaRequest.build());

		// TODO: Fix implementation of the AssertionBuilderImpl to retrieve the
		// Assertion with the signature in place
		return new XuaResponse(xuaResponses.get(0).getAssertion());
	}

	/**
	 * It implements the following IHE transaction: [ITI-41] Provide and Register
	 * Document Set – b
	 * <p>
	 * Using this method, both extraction modes can be set explicitly, e.g. if the
	 * default option is not suitable for all kinds of request.
	 */
	public Response sendProvideAndRegisterDocumentSetRequest(XdsProvideAndRetrieveDocumentSetQuery documentSet,
			SubmissionSetMetadataExtractionMode extractionMode,
			DocumentMetadataExtractionMode documentMetadataExtractionMode)
			throws SerializeException, ParserConfigurationException, IOException {
		ProvideAndRegisterDocumentSet txnData = createProvideAndRegisterDocumentSet(documentSet);

		documentSet.getDocumentWithMetadata()
				.forEach(docMetadata -> XDSUtils.addDocument(docMetadata, txnData, documentMetadataExtractionMode));

		XDSUtils.setDefaultKeystoreTruststore(documentSet.getDestination());

		if (extractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			log.debug("extract submission set metadata");
			XDSUtils.generateDefaultSubmissionSetAttributes(txnData);
			XDSUtils.linkDocumentEntryWithSubmissionSet(txnData);
		}

		if (documentSet.getAssociation() != null) {
			txnData.getAssociations().add(documentSet.getAssociation());
			log.debug("set association data");
			if (txnData.getDocuments() != null && !txnData.getDocuments().isEmpty()
					&& txnData.getDocuments().get(0) != null) {
				documentSet.getAssociation()
						.setSourceUuid(txnData.getDocuments().get(0).getDocumentEntry().getEntryUuid());
			} else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()
					&& txnData.getFolders().get(0) != null) {
				documentSet.getAssociation().setSourceUuid(txnData.getFolders().get(0).getEntryUuid());
			}
		}

		log.debug("prepare submit of document");
		String endpoint = HuskyUtils.createEndpoint(HuskyUtils.XDS_ITI41, //
				documentSet.getDestination().getUri(), //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));
		
		Exchange exchange = send(endpoint, txnData, documentSet.getXuaToken(), null, null);

		return exchange.getMessage().getBody(Response.class);
	}

	public Response sendProvideAndRegisterDocumentSetRequest(XdsProvideAndRetrieveDocumentSetQuery documentSet)
			throws SerializeException, ParserConfigurationException, IOException {
		return sendProvideAndRegisterDocumentSetRequest(documentSet, submissionSetMetadataExtractionMode,
				documentMetadataExtractionMode);
	}

	/** It implements the following IHE transaction: [ITI-18] Find folders */
	public QueryResponse sendQueryFoldersRequest(XdsFindFoldersStoredQuery findFoldersStoredQuery)
			throws SerializeException, ParserConfigurationException, IOException {
		return this.sendRegistryStoredFindDocumentsQuery(findFoldersStoredQuery, null,
				findFoldersStoredQuery.getDestination().getUri(), QueryReturnType.LEAF_CLASS, null);
	}

	/**
	 * It implements the following IHE transaction: [ITI-48] Retrieve value set and
	 * value set raw
	 */
	public SvsValueSetResponse downloadValueSet(SvsValueSetRequest valueSetRequest, boolean isUseRaw)
			throws IOException, ParserConfigurationException, InitializationException, SAXException {
		ValueSetConfig valueSetConfig = valueSetRequest.build();
		ValueSetManager valueSetManager = new ValueSetManager();
		return isUseRaw
				? SvsValueSetResponse.builder().valueSetRaw(valueSetManager.downloadValueSetRaw(valueSetConfig)).build()
				: SvsValueSetResponse.builder().valueSet(valueSetManager.downloadValueSet(valueSetConfig)).build();
	}

	/**
	 * It implements the following IHE transactions: [ITI-58] Provider Information
	 * Query - Search Request [ITI-59] Provider Information Feed - Add Request
	 * [ITI-59] Provider Information Feed - Delete Request
	 */
	public HpdResponse sendHpdBatchRequest(HpdBatchRequest hpdBatchRequest)
			throws SerializeException, ParserConfigurationException, IOException {
		BatchRequest request = new BatchRequest();
		String protocolPrefix = hpdBatchRequest.getHpdRequests().stream()
				.map(hpdRequest -> hpdRequest instanceof HpdSearchQuery ? HuskyUtils.HPD_ITI_58 : HuskyUtils.HPD_ITI_59).findFirst()
				.orElseThrow();

		hpdBatchRequest.getHpdRequests().forEach(hpdRequest -> {
			DsmlMessage dsmlMessage = hpdRequest.build();
			request.getBatchRequests().add(dsmlMessage);
		});

		String endpoint = HuskyUtils.createEndpoint(protocolPrefix, //
				hpdBatchRequest.getDestination().getUri(), //
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE));
		Exchange exchange = send(endpoint, request, null, null, null);
		BatchResponse batchResponse = exchange.getMessage().getBody(BatchResponse.class);

		handleErrorResponse(batchResponse);

		return switch (protocolPrefix) {
		case HuskyUtils.HPD_ITI_58:
			yield new HpdQueryResponse().build(batchResponse);
		case HuskyUtils.HPD_ITI_59:
			yield new HpdFeedResponse().build(batchResponse);
		default:
			yield null;
		};
	}

	/**
	 * Method that can be used for sending an individual request e.g.
	 * {@link org.projecthusky.communication.requests.hpd.HpdAddFeed}
	 */
	public HpdResponse sendHpdRequest(HpdRequest hpdRequest)
			throws SerializeException, ParserConfigurationException, IOException {
		HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder().hpdRequest(hpdRequest).build();
		return sendHpdBatchRequest(hpdBatchRequest);
	}

	private static Marshaller createMarshaller(JAXBContext newInstance) throws JAXBException {
		Marshaller marshaller = newInstance.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		return marshaller;
	}

	private XuaClientConfig createXuaClientConfig(XuaRequest xuaRequest) {
		return new XuaClientConfigBuilderImpl().clientKeyStore(xuaRequest.getClientKeyStore())
				.clientKeyStorePassword(xuaRequest.getClientKeyStorePass())
				.clientKeyStoreType(xuaRequest.getClientKeyStoreType()).url(xuaRequest.getRepositoryUri()).create();
	}

	private ProvideAndRegisterDocumentSet createProvideAndRegisterDocumentSet(
			XdsProvideAndRetrieveDocumentSetQuery documentSet) {
		ProvideAndRegisterDocumentSet txnData = new ProvideAndRegisterDocumentSet();
		txnData.setSubmissionSet(new SubmissionSet());
		documentSet.getSubmissionSetMetadata().toOhtSubmissionSetType(txnData.getSubmissionSet());
		return txnData;
	}

	private void handleErrorResponse(BatchResponse response) {
		ErrorResponse errorResponse = HpdUtils.getValidResponse(response, ErrorResponse.class);
		Optional.ofNullable(errorResponse).ifPresent(err -> {
			String errorMessage = "Request failed with the following message: " + err.getMessage();
			if (err.getType() != null && err.getType().value() != null) {
				errorMessage += " and error type " + err.getType().value();
			}
			throw new IllegalArgumentException(errorMessage);
		});
	}
}