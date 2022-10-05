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
package org.projecthusky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.testhelper.TestApplication;
import org.projecthusky.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Severity;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * The purpose of this test class is to check whether the submission of
 * documents (XDS ITI-41) works.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class ConvenienceCommunicationSubmitDocumentTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConvenienceCommunicationSubmitDocumentTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	private AffinityDomain affinityDomain = null;


	/**
	 * This method creates and start spring test application. Moreover, it sets the
	 * endpoint of XDS service for submitting documents.
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		// create and start spring test application
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();

		// sets XDS service endpoint
		affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);

		// here, all cached documents in ConvenienceCommunication are removed to avoid
		// sending unwanted documents
		convenienceCommunication.clearDocuments();
	}

	/**
	 * This method checks if initialization of {@link ConvenienceCommunication} was
	 * correct.
	 */
	@Test
	void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.projecthusky.xua.core.SecurityHeaderElement, String)}
	 * when a PDF document is submitted with separate submission set metadata.
	 * 
	 * @throws Exception
	 */
	@Test
	void submitPdfDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.clearDocuments();

		// PDF document is added to convenienceCommunication object, extracting all the
		// metadata that can be extracted.
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());

		// The metadata is set explicitly here
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");
		setMetadataForPdf(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		// submit added documents
		var response = convenienceCommunication.submit(subSet, null, null);

		// checks whether the document has been successfully submitted
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.projecthusky.xua.core.SecurityHeaderElement, String)}
	 * when a CDA document is submitted with separate submission set metadata.
	 * 
	 * @throws Exception
	 */
	@Test
	void submitCdaDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.clearDocuments();

		// CDA document is added to convenienceCommunication object, extracting all the
		// metadata that can be extracted. In the case of CDA documents, some metadata
		// can be extracted automatically.
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());

		// The metadata is set explicitly here
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2599");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		// submit added documents
		var response = convenienceCommunication.submit(subSet, null, null);

		// checks whether the document has been successfully submitted
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.projecthusky.xua.core.SecurityHeaderElement, String)}
	 * when a CDA document is submitted with invalid metadata.
	 * 
	 * @throws Exception
	 */
	@Test
	void submitDocumentWrongMetadataTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.clearDocuments();

		// CDA document is added to convenienceCommunication object, extracting all the
		// metadata that can be extracted. In the case of CDA documents, some metadata
		// can be extracted automatically.
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());

		// The metadata is set explicitly here. In this test case an incorrect class
		// code is set.
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		metdata.setClassCode(new Code("1", "1.2.3.4.5", "display"));
		setSubmissionMetadata(subSet, patientId);

		// submit added documents
		var response = convenienceCommunication.submit(subSet, null, null);

		// checks whether the submission of the document failed
		assertEquals(Status.FAILURE, response.getStatus());
		assertTrue(response.getErrors().size() > 0);

		// checks if XDSRegistryMetadataError is returned
		ErrorInfo error = response.getErrors().get(0);
		assertEquals(ErrorCode.REGISTRY_METADATA_ERROR, error.getErrorCode());
		assertEquals("CodeValidation", error.getLocation());
		assertEquals(Severity.ERROR, error.getSeverity());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#submitReplacement(SubmissionSetMetadata, String, org.projecthusky.xua.core.SecurityHeaderElement, String)}
	 * when an existing CDA document is to be replaced by a new one.
	 * 
	 * @throws Exception
	 */
	@Test
	void replaceCdaDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.clearDocuments();

		// Here the version 1 of the CDA document is transmitted, which should be
		// replaced afterwards
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		// submit added documents
		var response = convenienceCommunication.submit(subSet, null, null);

		// The entry UUID of the first submitted document is stored here, since it is
		// needed when replacing the document.
		String entryUuid = convenienceCommunication.getTxnData().getDocuments().get(0).getDocumentEntry()
				.getEntryUuid();

		// checks whether the document has been successfully submitted
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		// Here the version 2 of the CDA document is transmitted, which should replace
		// the first CDA document
		convenienceCommunication.clearDocuments();
		metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCdaV2());
		subSet = new SubmissionSetMetadata();
		patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		// method to replace existing document with passed entry UUID is called. All
		// added documents are submitted
		response = convenienceCommunication.submitReplacement(subSet, entryUuid, null, null);

		// checks whether the document has been successfully replaced
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

}
