package org.projecthusky.communication.services.xds;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Severity;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.requests.xds.XdsDocumentWithMetadata;
import org.projecthusky.communication.requests.xds.XdsProvideAndRetrieveDocumentSetQuery;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.communication.utils.XdsTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The purpose of this test class is to check whether the submission of documents (XDS ITI-41) works.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class})
@EnableAutoConfiguration
class XdsSubmitDocumentTest extends XdsTestUtils {
  @Autowired
  private HuskyService huskyService;

  @Value(value = "${test.xds.pnr.uri:http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb}")
  private String pnrUri;

  final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
  final private String facilityName = null;

  final private String senderApplicationOid = "1.2.3.4";


  /**
   * This method creates and start spring test application. Moreover, it sets the endpoint of XDS service for submitting
   * documents.
   *
   * @throws java.lang.Exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    // create and start spring test application
    var app = new SpringApplication(TestApplication.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    app.run();
  }

  /**
   * This method checks if initialization of {@link ConvenienceCommunication} was correct.
   */
  @Test
  void contextLoads() {
    assertNotNull(huskyService);
  }

  /**
   * This test checks the behavior of the
   * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.projecthusky.xua.core.SecurityHeaderElement,
   * String)} when a PDF document is submitted with separate submission set metadata.
   *
   * @throws Exception
   */
  @Test
  void submitPdfDocTest() throws Exception {
    DocumentMetadata documentMetadata = new DocumentMetadata();
    Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");
    setMetadataForPdf(documentMetadata, patientId);

    XdsDocumentWithMetadata.XdsDocumentWithMetadataBuilder builder = this.huskyService.createDocumentWithMetadata();
    XdsDocumentWithMetadata documentWithMetadata = builder.documentMetadata(documentMetadata).dataStream(getDocPdf())
        .documentDescriptor(DocumentDescriptor.PDF)
        .build();

    SubmissionSetMetadata subSet = new SubmissionSetMetadata();
    setSubmissionMetadata(subSet, patientId);

    XdsProvideAndRetrieveDocumentSetQuery.XdsProvideAndRetrieveDocumentSetQueryBuilder documentSetQueryBuilder =
        this.huskyService.createProvideAndRetrieveDocumentSetQuery();
    XdsProvideAndRetrieveDocumentSetQuery provideAndRetrieveDocumentSetQuery =
        documentSetQueryBuilder.documentWithMetadata(List.of(documentWithMetadata)).destination(createDestination())
        .submissionSetMetadata(subSet).build();

    // submit added documents
    Response response = huskyService.send(provideAndRetrieveDocumentSetQuery);

    assertTrue(response.getErrors().isEmpty());
    assertEquals(Status.SUCCESS, response.getStatus());
  }

  /**
   * This test checks the behavior of the
   * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.projecthusky.xua.core.SecurityHeaderElement,
   * String)} when a CDA document is submitted with separate submission set metadata.
   *
   * @throws Exception
   */
  @Test
  void submitCdaDocTest() throws Exception {
    DocumentMetadata documentMetadata = new DocumentMetadata();
    Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2599");
    setMetadataForCda(documentMetadata, patientId);

    XdsDocumentWithMetadata documentWithMetadata = this.huskyService.createDocumentWithMetadata().documentMetadata(documentMetadata)
        .dataStream(getDocCda()).documentDescriptor(DocumentDescriptor.CDA_R2).build();

    SubmissionSetMetadata subSet = new SubmissionSetMetadata();
    setSubmissionMetadata(subSet, patientId);

    XdsProvideAndRetrieveDocumentSetQuery provideAndRetrieveDocumentSetQuery =
        this.huskyService.createProvideAndRetrieveDocumentSetQuery().documentWithMetadata(List.of(documentWithMetadata))
            .submissionSetMetadata(subSet).destination(createDestination()).build();

    // submit added documents
    Response response = huskyService.send(provideAndRetrieveDocumentSetQuery);

    assertTrue(response.getErrors().isEmpty());
    assertEquals(Status.SUCCESS, response.getStatus());
  }

  /**
   * This test checks the behavior of the
   * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.projecthusky.xua.core.SecurityHeaderElement,
   * String)} when a CDA document is submitted with invalid metadata.
   *
   * @throws Exception
   */
  @Test
  void submitDocumentWrongMetadataTest() throws Exception {
    DocumentMetadata documentMetadata = new DocumentMetadata();
    Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2599");
    // The metadata is set explicitly here. In this test case an incorrect class
    // code is set.
    setMetadataForCda(documentMetadata, patientId);
    documentMetadata.setClassCode(new Code("1", "1.2.3.4.5", "display"));

    XdsDocumentWithMetadata documentWithMetadata = this.huskyService.createDocumentWithMetadata().documentMetadata(documentMetadata)
        .dataStream(getDocCda()).documentDescriptor(DocumentDescriptor.CDA_R2).build();

    SubmissionSetMetadata subSet = new SubmissionSetMetadata();
    setSubmissionMetadata(subSet, patientId);

    XdsProvideAndRetrieveDocumentSetQuery provideAndRetrieveDocumentSetQuery =
        this.huskyService.createProvideAndRetrieveDocumentSetQuery().documentWithMetadata(List.of(documentWithMetadata))
            .submissionSetMetadata(subSet).destination(createDestination()).build();

    // submit added documents
    Response response = huskyService.send(provideAndRetrieveDocumentSetQuery);

    // checks whether the submission of the document failed
    assertEquals(Status.FAILURE, response.getStatus());
    assertFalse(response.getErrors().isEmpty());

    // checks if XDSRegistryMetadataError is returned
    ErrorInfo error = response.getErrors().get(0);
    assertEquals(ErrorCode.REGISTRY_METADATA_ERROR, error.getErrorCode());
    assertEquals("CodeValidation", error.getLocation());
    assertEquals(Severity.ERROR, error.getSeverity());
  }

  /**
   * This test checks the behavior of the
   * {@link ConvenienceCommunication#submitReplacement(SubmissionSetMetadata, String,
   * org.projecthusky.xua.core.SecurityHeaderElement, String)} when an existing CDA document is to be replaced by a new
   * one.
   *
   * @throws Exception
   */
  @Test
  void replaceCdaDocTest() throws Exception {
    // Here the version 1 of the CDA document is transmitted, which should be replaced afterwards
    DocumentMetadata documentMetadata = new DocumentMetadata();
    Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
    setMetadataForCda(documentMetadata, patientId);

    XdsDocumentWithMetadata documentWithMetadata = this.huskyService.createDocumentWithMetadata().documentMetadata(documentMetadata)
        .dataStream(getDocCda()).documentDescriptor(DocumentDescriptor.CDA_R2).build();

    SubmissionSetMetadata subSet = new SubmissionSetMetadata();
    setSubmissionMetadata(subSet, patientId);

    XdsProvideAndRetrieveDocumentSetQuery provideAndRetrieveDocumentSetQuery =
        this.huskyService.createProvideAndRetrieveDocumentSetQuery().documentWithMetadata(List.of(documentWithMetadata))
            .submissionSetMetadata(subSet).destination(createDestination()).build();

    // submit added documents
    Response response = huskyService.send(provideAndRetrieveDocumentSetQuery);

    // checks whether the document has been successfully submitted
    assertTrue(response.getErrors().isEmpty());
    assertEquals(Status.SUCCESS, response.getStatus());

    // The entry UUID of the first submitted document is stored here, since it is
    // needed when replacing the document.
    String entryUuid = provideAndRetrieveDocumentSetQuery.getDocumentWithMetadata().get(0).getDocumentMetadata()
        .getDocumentEntry().getEntryUuid();

    // Here the version 2 of the CDA document is transmitted, which should replace
    // the first CDA document
    documentMetadata = new DocumentMetadata();
    patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
    setMetadataForCda(documentMetadata, patientId);

    documentWithMetadata = this.huskyService.createDocumentWithMetadata().documentMetadata(documentMetadata)
        .dataStream(getDocCdaV2()).documentDescriptor(DocumentDescriptor.CDA_R2).build();

    subSet = new SubmissionSetMetadata();
    setSubmissionMetadata(subSet, patientId);

    provideAndRetrieveDocumentSetQuery =
        this.huskyService.createProvideAndRetrieveDocumentSetQuery().documentWithMetadata(List.of(documentWithMetadata))
            .submissionSetMetadata(subSet).destination(createDestination()).association(createAssociation(entryUuid)).build();

    // method to replace existing document with passed entry UUID is called. All
    // added documents are submitted
    response = huskyService.send(provideAndRetrieveDocumentSetQuery);

    // checks whether the document has been successfully replaced
    assertTrue(response.getErrors().isEmpty());
    assertEquals(Status.SUCCESS, response.getStatus());
  }

  private Association createAssociation(String entryUuid) {
    Association association = new Association();
    association.setAssociationType(AssociationType.REPLACE);
    association.setAvailabilityStatus(AvailabilityStatus.APPROVED);
    association.setTargetUuid(entryUuid);
    association.assignEntryUuid();
    return association;
  }

  private Destination createDestination() {
    final Destination dest = new Destination();

    try {
      dest.setUri(new URI(pnrUri));
    } catch (final URISyntaxException e) {
      e.printStackTrace();
    }
    dest.setSenderApplicationOid(senderApplicationOid);
    dest.setReceiverApplicationOid(applicationName);
    dest.setReceiverFacilityOid(facilityName);
    return dest;
  }
}
