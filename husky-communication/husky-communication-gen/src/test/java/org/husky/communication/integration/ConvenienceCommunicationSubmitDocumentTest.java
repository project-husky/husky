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
package org.husky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.communication.DocumentMetadata;
import org.husky.common.communication.SubmissionSetMetadata;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdsTestUtils;
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
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class ConvenienceCommunicationSubmitDocumentTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConvenienceCommunicationSubmitDocumentTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	private AffinityDomain affinityDomain = null;


	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();

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

		convenienceCommunication.clearDocuments();
	}

	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void submitPdfDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");
		setMetadataForPdf(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);
		var response = convenienceCommunication.submit(subSet, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	@Test
	public void submitCdaDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2599");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		var response = convenienceCommunication.submit(subSet, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	@Test
	public void submitDocumentWrongMetadataTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		metdata.setClassCode(new Code("1", "1.2.3.4.5", "display"));
		setSubmissionMetadata(subSet, patientId);

		var response = convenienceCommunication.submit(subSet, null);

		assertEquals(Status.FAILURE, response.getStatus());
		assertTrue(response.getErrors().size() > 0);

		ErrorInfo error = response.getErrors().get(0);
		assertEquals(ErrorCode.REGISTRY_METADATA_ERROR, error.getErrorCode());
		assertEquals("CodeValidation", error.getLocation());
		assertEquals(Severity.ERROR, error.getSeverity());
	}

	@Test
	public void replaceCdaDocTest() throws Exception {
		convenienceCommunication.setAffinityDomain(affinityDomain);

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		var response = convenienceCommunication.submit(subSet, null);

		String entryUuid = convenienceCommunication.getTxnData().getDocuments().get(0).getDocumentEntry()
				.getEntryUuid();

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		convenienceCommunication.clearDocuments();
		metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCdaV2());
		subSet = new SubmissionSetMetadata();
		patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);

		response = convenienceCommunication.submitReplacement(subSet, entryUuid, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

}
