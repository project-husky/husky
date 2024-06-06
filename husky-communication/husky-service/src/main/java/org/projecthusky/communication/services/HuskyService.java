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

import java.io.IOException;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.r4.model.Organization;
import org.openehealth.ipf.commons.ihe.hl7v3.core.responses.PixV3QueryResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.projecthusky.common.communication.AtnaConfig;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.projecthusky.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Patient;
import org.projecthusky.communication.requests.xds.XdsDocumentWithMetadata;
import org.projecthusky.communication.requests.xds.XdsFindFoldersStoredQuery;
import org.projecthusky.communication.requests.pdq.PdqSearchQuery;
import org.projecthusky.communication.requests.pix.PixAddPatientFeed;
import org.projecthusky.communication.requests.pix.PixMergePatientFeed;
import org.projecthusky.communication.requests.pix.PixPatientIDQuery;
import org.projecthusky.communication.requests.pix.PixUpdatePatientFeed;
import org.projecthusky.communication.requests.xds.XdsRegistryStoredFindDocumentsQuery;
import org.projecthusky.communication.requests.xds.XdsDocumentSetRequest;
import org.projecthusky.communication.requests.xds.XdsProvideAndRetrieveDocumentSetQuery;
import org.projecthusky.communication.requests.hpd.HpdAddFeed;
import org.projecthusky.communication.requests.hpd.HpdBatchRequest;
import org.projecthusky.communication.requests.hpd.HpdDeleteFeed;
import org.projecthusky.communication.requests.hpd.HpdSearchQuery;
import org.projecthusky.communication.requests.svs.SvsValueSetRequest;
import org.projecthusky.communication.requests.xua.XuaRequest;
import org.projecthusky.communication.responses.pix.PixAddPatientResponse;
import org.projecthusky.communication.responses.hpd.HpdResponse;
import org.projecthusky.communication.responses.pix.PixPatientIDResult;
import org.projecthusky.communication.responses.pdq.PdqSearchQueryResponse;
import org.projecthusky.communication.responses.pdq.PdqSearchResults;
import org.projecthusky.communication.responses.svs.SvsValueSetResponse;
import org.projecthusky.communication.responses.xua.XuaResponse;
import org.projecthusky.communication.utils.PdqUtils;
import org.projecthusky.fhir.structures.gen.FhirPatient;
import org.projecthusky.valueset.exceptions.InitializationException;
import org.projecthusky.xua.exceptions.ClientSendException;
import org.projecthusky.xua.exceptions.SerializeException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;
import net.ihe.gazelle.hl7v3.mcciin000002UV01.MCCIIN000002UV01Type;
import net.ihe.gazelle.hl7v3.prpain201306UV02.PRPAIN201306UV02Type;
import org.xml.sax.SAXException;

/**
 * The main service class to use when working with the EPD web services. As it is marked as a @Component, it will be
 * immediately available in your application to reference.<br/> It provides query building capabilities and executing
 * those queries against a targeted service.<br/> Functionality built so far:
 * <ul>
 * <li>Searching for patients by Patient criteria - {@link PdqSearchQuery}.</li>
 * <li>Adding new patient - {@link PixAddPatientFeed}</li>
 * <li>Updating existing patient - {@link PixUpdatePatientFeed}</li>
 * <li>Searching for a Patient's documents - {@link XdsRegistryStoredFindDocumentsQuery}</li>
 * </ul>
 * Use it as follows:
 * <pre class="code">
 * &#064;Autowired
 * private HuskyService service; //get an instance of the service class
 * private String senderApp; //e.g. like the test-app: "1.2.3.4"
 * private String searchWebServiceUri; //The address where the webservice resides.
 *
 * public void doMyBusinessStuff() {
 *   {@link Destination} dest = Destination.builder().uri(URI.create(searchWebServiceUri)).senderApplicationOid(senderApp).build();
 *   {@link Name} patientName = new Name(Name.builder().withFamily("Anders").build()); //This was not refactored yet, so creation is a bit weird.
 *
 *   //Build the query, starting from the central service. Set all parameters you wish to send.
 *   {@link PdqSearchQuery} query = this.service.startBuildingSearchQuery(dest)
 *     .patientName(patientName).build();
 *
 *   //Send your search parameters (name) to the service and receive the results.
 *   {@link PdqSearchResults} result = this.service.send(query);
 *
 *   //see your results for the name given as search parameter:
 *   for ({@link FhirPatient} patient: result.getPatients()) {
 *   	//do business
 *   }
 * }
 * </pre>
 *
 * @author szalai
 * @see PdqSearchQuery
 * @see PdqSearchResults
 * @see PixAddPatientFeed
 * @see PixUpdatePatientFeed
 * @see XdsRegistryStoredFindDocumentsQuery
 * @see FhirPatient
 * @see Patient
 * @see Destination
 * @see HuskyWebServiceClient
 */
@Component
@Slf4j
public class HuskyService {

  private final HuskyWebServiceClient wsClient;

  public HuskyService(HuskyWebServiceClient wsClient) { //leverage constructor injection.
    this.wsClient = wsClient;
  }

  public void configAtna(AtnaConfig.AtnaConfigMode atna) {
    this.wsClient.setAtnaConfigMode(atna);
  }

  public void configSubmissionMode(SubmissionSetMetadataExtractionMode submissionSetExtractionMode) {
    this.wsClient.setSubmissionSetMetadataExtractionMode(submissionSetExtractionMode);
  }

  public void configMetadataExtractionMode(DocumentMetadataExtractionMode documentExtractionMode) {
    this.wsClient.setDocumentMetadataExtractionMode(documentExtractionMode);
  }

  /**
   * Use this method to start building a {@link PdqSearchQuery}. These queries are designed to search for patients by
   * different criteria.<br/> Previously they where called Patient Demographics Query (PDQ), as the official definition
   * states.<br/> Common criteria are:
   * <ul>
   * <li>Patient's name</li>
   * <li>Patient's ID</li>
   * <li>Patient's address</li>
   * <li>Patient's birthday</li>
   * <li>Patient's gender</li>
   * <li>Patient's telecom contact</li>
   * <li>etc</li>
   * </ul>
   * The criteria are interpreted in an <b>AND</b> logic!
   *
   * @return A SearchQueryBuilder to build a {@link PdqSearchQuery} with the parameters you wish.
   * @see <a href="https://www.e-health-suisse.ch/technik-semantik/epd-anbindung/informatikverantwortliche.html">Patient
   * suchen</a>
   */
  public PdqSearchQuery.PdqSearchQueryBuilder createPdqSearchQuery(Destination destination) {
    return PdqSearchQuery.builder().destination(destination);
  }

  /**
   * Use this method to build a {@link PixPatientIDQuery}, where the user can ask for all IDs known of a patient.
   */
  public PixPatientIDQuery.PixPatientIDQueryBuilder createPixPatientIDQuery(Destination destination) {
    return PixPatientIDQuery.builder().destination(destination);
  }

  /**
   * This method will start building a {@link PixAddPatientFeed}, which allows the user to create a new Patient in the
   * system.<br/> The properties of an {@link FhirPatient} are used as a template and expected to be filled.
   *
   * @param destination
   * @return PixAddPatientQueryBuilder
   * @see <a
   * href="https://www.e-health-suisse.ch/technik-semantik/epd-anbindung/informatikverantwortliche.html">Registry Stored
   * Query</a>
   */
  public PixAddPatientFeed.PixAddPatientFeedBuilder createPixAddPatientFeed(Destination destination,
      Organization providerOrganization) {
    return PixAddPatientFeed.builder().destination(destination).providerOrganization(providerOrganization);
  }

  /**
   * This method will start building a {@link PixUpdatePatientFeed}, which allows the user to update an existing
   * patient in the system.<br/> The properties of an {@link FhirPatient} are used, fill them accordingly.
   *
   * @param destination
   * @param providerOrganization
   * @return PixUpdatePatientFeedBuilder
   */
  public PixUpdatePatientFeed.PixUpdatePatientFeedBuilder createPixUpdatePatientFeed(Destination destination,
      Organization providerOrganization) {
    return PixUpdatePatientFeed.builder().destination(destination).providerOrganization(providerOrganization);
  }

  /**
   * Use this method to build a {@link PixMergePatientFeed}, with which the user can merge two know patient objects
   * into one in case those two are the same person.<br/> This case is mostly used to correct user errors when the same
   * person is entered into a system multiple times and needs to be merged into one.
   *
   * @param destination
   * @param providerOrganization
   * @param obsolatePatientId
   * @param homeCommunityOID
   * @param homeCommunityNamespace
   * @return
   */
  public PixMergePatientFeed.PixMergePatientFeedBuilder createPixMergePatientFeed(Destination destination,
      Organization providerOrganization, String obsolatePatientId, String homeCommunityOID, String homeCommunityNamespace) {
    return PixMergePatientFeed.builder().destination(destination).providerOrganization(providerOrganization)
        .obsolatePatientID(obsolatePatientId).homeCommunityOID(homeCommunityOID)
        .homeCommunityNamespace(homeCommunityNamespace);
  }

  /**
   * This method will start building a {@link XdsRegistryStoredFindDocumentsQuery}, which allows the user to look for
   * documents of a Patient identified by the ID by various parameters.
   *
   * @return RegistryStoredFindDocumentsQueryBuilder
   * @see <a
   * href="https://www.e-health-suisse.ch/technik-semantik/epd-anbindung/informatikverantwortliche.html">Registry Stored
   * Query</a>
   */
  public XdsRegistryStoredFindDocumentsQuery.XdsRegistryStoredFindDocumentsQueryBuilder<?, ?> createRegistryStoredFindDocumentsQuery(
      Destination destination, Identificator patientID) {
    return XdsRegistryStoredFindDocumentsQuery.builder().destination(destination).patientID(patientID);
  }

  /**
   * This method will start building a {@link XdsDocumentSetRequest}, which allows the user to download the documents ofa
   * Patient.
   *
   * @param destination
   * @return
   */
  public XdsDocumentSetRequest.XdsDocumentSetRequestBuilder createDocumentSetRequest(Destination destination) {
    return XdsDocumentSetRequest.builder().destination(destination);
  }

  /**
   * This method will start building a {@link XdsDocumentWithMetadata}, which will be used to build the
   * {@link XdsProvideAndRetrieveDocumentSetQuery}
   */
  public XdsDocumentWithMetadata.XdsDocumentWithMetadataBuilder createDocumentWithMetadata() {
    return XdsDocumentWithMetadata.builder();
  }

  /**
   * This method will start building a {@link XdsProvideAndRetrieveDocumentSetQuery}, which will be sent to the webservice
   * and allows the user to add or replace an existing document
   */
  public XdsProvideAndRetrieveDocumentSetQuery.XdsProvideAndRetrieveDocumentSetQueryBuilder createProvideAndRetrieveDocumentSetQuery() {
    return XdsProvideAndRetrieveDocumentSetQuery.builder();
  }

  /**
   * This method will start building a {@link XuaRequest}, which will be sent to the webservice and
   * returns details about the identity of the authenticated user
   */
  public XuaRequest.XuaRequestBuilder createXuaRequest() {
    return XuaRequest.builder();
  }

  /**
   * This method will start building a {@link XdsFindFoldersStoredQuery}, which allows the user to search the folders of a
   * Patient.
   */
  public XdsFindFoldersStoredQuery.XdsFindFoldersStoredQueryBuilder<?, ?> createFindFoldersStoredQuery() {
    return XdsFindFoldersStoredQuery.builder();
  }

  /**
   * This method will start building a {@link SvsValueSetRequest}, which allows to download a value set
   */
  public SvsValueSetRequest.SvsValueSetRequestBuilder createValueSetRequest() {
    return SvsValueSetRequest.builder();
  }

  /**  This method will start building a {@link HpdSearchQuery}, which is needed to create the HPD request */
  public HpdSearchQuery.HpdSearchQueryBuilder createHpdSearchQuery() {
    return HpdSearchQuery.builder();
  }

  /** This method will start building a {@link HpdAddFeed}, which is needed to create the HPD request */
  public HpdAddFeed createHpdAddFeed() {
    return new HpdAddFeed();
  }

  /** This method will start building a {@link HpdDeleteFeed}, which is needed to create the HPD request */
  public HpdDeleteFeed createHpdDeleteFeed() {
    return new HpdDeleteFeed();
  }

  /** This method will start building a {@link HpdBatchRequest}, which contain multiple HPD requests.
   * The request also provides more options like how to process the request (sequential or in parallel),
   * how to retrieve the response (sequential or unordered) and how to proceed in case of an error (resume or exit).
   */
  public HpdBatchRequest.HpdBatchRequestBuilder createHpdBatchRequest() {
    return HpdBatchRequest.builder();
  }

  /**
   * Send your built {@link PdqSearchQuery} through the Internet and receive the results from the webservice.
   *
   * @param patientSearchQuery A {@link PdqSearchQuery} previously built.
   * @return A {@link PdqSearchResults} object containing the matching {@link FhirPatient} objects in a list.
   * @throws DataBindingException
   * @throws JAXBException
   * @throws ParserConfigurationException
   * @throws SerializeException
   * @throws IOException
   * @throws RuntimeException             - For errors/exceptions happening in the webservice there will be a
   *                                      RuntimeException wrapped SOAPException thrown.
   */
  public PdqSearchResults send(PdqSearchQuery patientSearchQuery)
      throws DataBindingException, JAXBException, ParserConfigurationException, SerializeException, IOException {
    Assert.notNull(patientSearchQuery, "The search query can not be null.");
    log.debug("A Search Query is initiated for send: {}", patientSearchQuery);
    PRPAIN201306UV02Type sendITI47Query = this.wsClient.sendPdqSearchQueryRequest(patientSearchQuery.build(), null,
        patientSearchQuery.getDestination().getUri(), null);
    PdqSearchQueryResponse response = new PdqSearchQueryResponse(sendITI47Query);
    PdqSearchResults results = new PdqSearchResults(
        PdqUtils.getPatientsFromSearchQueryResponse(response));
    log.debug("Patients found for the properties: {}", results.getPatients().size());
    return results;
  }

  /**
   * Send your built {@link PixAddPatientFeed} through the Internet to the webservice and receive an answer, whether
   * the Patient was added or not.
   *
   * @param addPatientFeed
   * @return True if the patient was added without error. Errors are reported as exceptions.
   * @throws JAXBException
   * @throws SerializeException
   * @throws ParserConfigurationException
   * @throws IOException
   * @throws RuntimeException             - For errors/exceptions happening in the webservice there will be a
   *                                      RuntimeException wrapped SOAPException thrown.
   */
  public boolean send(PixAddPatientFeed addPatientFeed)
      throws JAXBException, SerializeException, ParserConfigurationException, IOException {
    Assert.notNull(addPatientFeed, "The patient creation query can not be null.");
    MCCIIN000002UV01Type iti44QueryResponseType = this.wsClient.sendPixAddPatientRequest(
        addPatientFeed.build().getRootElement(), null, addPatientFeed.getDestination().getUri(),
        "urn:hl7-org:v3:PRPA_IN201301UV02", null);
    PixAddPatientResponse response = new PixAddPatientResponse(iti44QueryResponseType);
    return !response.hasError(); //Inverting error flag to indicate success with true returned.
  }

  /**
   * Send your built {@link PixUpdatePatientFeed} through the Internet to the webservice and receive an answer (updated
   * or error).
   *
   * @param updatePatientFeed
   * @return True if the patient was updated without error. Errors are reported as exceptions.
   * @throws JAXBException
   * @throws SerializeException
   * @throws ParserConfigurationException
   * @throws IOException
   */
  public boolean send(PixUpdatePatientFeed updatePatientFeed)
      throws JAXBException, SerializeException, ParserConfigurationException, IOException {
    Assert.notNull(updatePatientFeed, "The patient update query can not be null.");
    MCCIIN000002UV01Type iti44QueryResponseType = this.wsClient.sendPixUpdatePatientRequest(
        updatePatientFeed.build().getRootElement(), null, updatePatientFeed.getDestination().getUri(),
        "urn:hl7-org:v3:PRPA_IN201302UV02", null);
    PixAddPatientResponse response = new PixAddPatientResponse(iti44QueryResponseType);
    return !response.hasError(); //Inverting error flag to indicate success with true returned.
  }

  /**
   * Send the built {@link PixMergePatientFeed} through the Internet to the webservice and receive an answer.
   *
   * @param mergePatientFeed
   * @return
   * @throws JAXBException
   * @throws SerializeException
   * @throws ParserConfigurationException
   * @throws IOException
   */
  public boolean send(PixMergePatientFeed mergePatientFeed)
      throws JAXBException, SerializeException, ParserConfigurationException, IOException {
    Assert.notNull(mergePatientFeed, "The patient merge query can not be null.");
    MCCIIN000002UV01Type mergePatientXMLResponse = this.wsClient.sendITI44Query(
        mergePatientFeed.build().getRootElement(), null, mergePatientFeed.getDestination().getUri(),
        "urn:hl7-org:v3:PRPA_IN201304UV02", null);
    PixAddPatientResponse response = new PixAddPatientResponse(mergePatientXMLResponse);
    return !response.hasError(); //Inverting error flag to indicate success with true returned.
  }

  /**
   * Send the built {@link PixPatientIDQuery} through the Internet to the webservice and receive an answer.
   *
   * @param searchPatientIDQuery
   * @return
   * @throws Exception
   */
  public PixPatientIDResult send(PixPatientIDQuery searchPatientIDQuery) throws Exception {
    Assert.notNull(searchPatientIDQuery, "The patient ID search query can not be null.");
    PixV3QueryResponse response = this.wsClient.sendQuery(searchPatientIDQuery.build(), null,
        searchPatientIDQuery.getDestination().getUri(), null);
    PixPatientIDResult.PixPatientIDResultBuilder result = PixPatientIDResult.builder();
    for (String domainId : searchPatientIDQuery.getQueryDomainOids()) {
      result.patientID(PdqUtils.getPatientDomainId(response, domainId));
    }
    return result.build();
  }

  /**
   * Send your built {@link XdsDocumentSetRequest} through the Internet to the webservice and receive the documents of the
   * Patient.
   *
   * @param retrievedDocumentsRequest
   * @return
   * @throws SerializeException
   * @throws ParserConfigurationException
   * @throws IOException
   */
  public RetrievedDocumentSet send(XdsDocumentSetRequest retrievedDocumentsRequest)
      throws SerializeException, ParserConfigurationException, IOException {
    Assert.notNull(retrievedDocumentsRequest, "The document set request query can not be null.");
    return this.wsClient.send(retrievedDocumentsRequest, null, retrievedDocumentsRequest.getDestination().getUri(),
        null);
  }

  /**
   * Send your built {@link XdsRegistryStoredFindDocumentsQuery} through the Internet to the webservice and receive the
   * document handlers.
   *
   * @return {@link QueryResponse}
   * @throws Exception
   */
  public QueryResponse send(XdsRegistryStoredFindDocumentsQuery query) throws Exception {
    Assert.notNull(query, "The find documents query can not be null.");
    return this.wsClient.sendRegistryStoredFindDocumentsQuery(query, null,
        query.getDestination().getUri(), QueryReturnType.LEAF_CLASS, null);
  }

  /**
   * Use the {@link XuaRequest} which is sent to the webservice and returns details about the identity of the authenticated user
   *
   * @return {@link XuaResponse}
   * @throws ClientSendException
   */
  public XuaResponse send(XuaRequest xuaRequest) throws ClientSendException {
    return this.wsClient.send(xuaRequest);
  }

  /**
   * Use the {@link XdsProvideAndRetrieveDocumentSetQuery} to build the ProvideAndRetrieveDocumentSet request which is
   * sent to the webservice and adds or replaces an existing document
   *
   * @return {@link Response}
   * @throws SerializeException
   * @throws ParserConfigurationException
   * @throws IOException
   */
  public Response send(XdsProvideAndRetrieveDocumentSetQuery documentSet)
      throws SerializeException, ParserConfigurationException, IOException {
    return this.wsClient.sendProvideAndRegisterDocumentSetRequest(documentSet);
  }

  /**
   * Send your built {@link XdsFindFoldersStoredQuery} to the webservice to find folders (XDSFolder objects) in the
   * registry for a given patientID with matching 'status' attribute
   *
   * @return {@link QueryResponse}
   * @throws SerializeException
   * @throws ParserConfigurationException
   * @throws IOException
   */
  public QueryResponse send(XdsFindFoldersStoredQuery findFoldersStoredQuery)
      throws SerializeException, ParserConfigurationException, IOException {
    return this.wsClient.sendQueryFoldersRequest(findFoldersStoredQuery);
  }

  /**
   * <div class="en">Downloads a value set as defined in the given configuration,
   * or in raw dformat exactly as downloaded </div>
   * @param valueSetRequest request used to create the value set config
   * @param isUseRaw flag that signals if the response is needed in raw dformat
   * @return ValueSetResponse object that contains both formats of the response
   * @throws IOException                  Signals that an I/O exception has
   *                                      occurred.
   * @throws SAXException
   * @throws ParserConfigurationException
   * @throws InitializationException
   */
  public SvsValueSetResponse send(SvsValueSetRequest valueSetRequest, boolean isUseRaw)
      throws IOException, ParserConfigurationException, InitializationException, SAXException {
    return this.wsClient.downloadValueSet(valueSetRequest, isUseRaw);
  }

  /**
   * Creates {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest} which queries the Healthcare
   * Provider Directory returning a {@link BatchResponse} containing informations regarding the:
   * Individual Provider
   * Organizational Provider
   * Relationship
   *
   * Creates {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AddRequest} which writes to the Healthcare
   * Provider Directory a: Individual Provider, Organizational Provider or a Relationship returning a {@link BatchResponse}
   * containing a response code for success and error
   *
   * Creates {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DelRequest} which deletes from the Healthcare
   * Provider Directory a: Individual Provider, Organizational Provider or a Relationship returning a {@link BatchResponse}
   * containing a response code for success and error
   *
   * @param hpdBatchRequest contains a batch of {@link org.projecthusky.communication.requests.hpd.HpdRequest}
   *
   * @return {@link HpdResponse}
   * @throws SerializeException
   * @throws JAXBException
   * @throws ParserConfigurationException
   * @throws IOException
   */
  public HpdResponse send(HpdBatchRequest hpdBatchRequest)
      throws SerializeException, JAXBException, ParserConfigurationException, IOException {
    if (!hpdBatchRequest.isValid()) {
      throw new IllegalArgumentException("Invalid request: mandatory constraints are not fulfilled!");
    }
    return this.wsClient.sendHpdBatchRequest(hpdBatchRequest);
  }
}