package org.projecthusky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.communication.AtnaConfig.AtnaConfigMode;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.DocumentRequest;
import org.projecthusky.communication.testhelper.TestApplication;
import org.projecthusky.communication.testhelper.XdsTestUtils;
import org.projecthusky.communication.xd.storedquery.GetDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.ObjectReference;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocument;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * This test class is to check whether ATNA audit messages are sent in the
 * course of XDS transactions. This is tested by checking whether audit entries
 * have been written to the LOG file.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
class ConvenienceCommunicationAtnaAuditTest extends XdsTestUtils {

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	@Autowired
	protected AuditContext auditContext;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	/**
	 * This method creates and start spring test application
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();
	}

	/**
	 * This tests whether an audit event with type ITI-18 and ID 110112 is sent when
	 * requesting the metadata of a document.
	 * 
	 * @throws Exception
	 */
	@Test
	void queryGetDocumentsMetadataOfCdaWithAuditMessage() throws Exception {

		// sets the endpoint of XDS service for querying metadata
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/xcq"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.setAtnaConfig(AtnaConfigMode.SECURE);

		// sets the unique ID of the document for which the metadata should be retrieved
		List<String> uniqueIds = new LinkedList<>();
		uniqueIds.add("1.2.820.99999.18508463736145106181926975526539403561455330316563");

		GetDocumentsQuery getDocumentsQuery = new GetDocumentsQuery(uniqueIds, false, "urn:oid:1.1.4567334.1.6");

		// In this example, only the references to the documents are retrieved in
		// metadata.
		final QueryResponse response = convenienceCommunication.queryDocumentReferencesOnly(getDocumentsQuery, null,
				null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		// check if references are returned.
		assertTrue(!response.getReferences().isEmpty());
		assertTrue(response.getReferences().size() > 0);

		// check if retrieved reference is correct
		ObjectReference objectRef = response.getReferences().iterator().next();
		assertEquals("urn:uuid:afd9bee4-4c30-4b58-a0e7-e301c799047b", objectRef.getId());
		assertEquals("urn:oid:1.1.4567334.1.6", objectRef.getHome());

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110112\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-18\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	/**
	 * This tests whether an audit event with type ITI-43 and ID 110107 is sent when
	 * a document is retrieved.
	 * 
	 * @throws Exception
	 */
	@Test
	void retrieveDocumentCdaTest() throws Exception {

		// sets the endpoint of XDS service for retrieving documents
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/ret"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
		convenienceCommunication.setAffinityDomain(affinityDomain);

		// sets the unique ID, repository ID and home community ID of the document which
		// should be retrieved
		var documentRequest = new DocumentRequest("1.1.4567332.1.75", null,
				"1.2.820.99999.18508463736145106181926975526539403561455330316563", "urn:oid:1.1.4567334.1.6");

		// send request to retrieve document
		final RetrievedDocumentSet response = convenienceCommunication.retrieveDocument(documentRequest, null, null);

		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(response.getErrors().isEmpty());

		// check if the document is returned
		assertFalse(response.getDocuments().isEmpty());
		assertEquals(1, response.getDocuments().size());

		RetrievedDocument retrievedDocument = response.getDocuments().get(0);

		// check if returned document is a XML document
		assertEquals("text/xml", retrievedDocument.getMimeType());

		try (var is = retrievedDocument.getDataHandler().getInputStream()) {
			byte[] bytesOfDocument = is.readAllBytes();
			assertNotNull(bytesOfDocument);
			assertTrue(bytesOfDocument.length > 0);
		}

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110107\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-43\""));
	}

	/**
	 * This tests whether an audit event with type ITI-41 and ID 110106 is sent when
	 * submitting a document.
	 * 
	 * @throws Exception
	 */
	@Test
	void submitPdfDocTest() throws Exception {
		// sets the endpoint of XDS service for submitting documents
		var affinityDomain = new AffinityDomain();
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
		convenienceCommunication.setAffinityDomain(affinityDomain);

		// here, all cached documents in ConvenienceCommunication are removed to avoid
		// sending unwanted documents
		convenienceCommunication.clearDocuments();

		// This adds the document to be sent to the object. In the course of this some
		// metadata is extracted.
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		// Here the metadata to be set explicitly are set
		setMetadataForPdf(metdata, patientId);
		// sets the metadata of the submission set
		setSubmissionMetadata(subSet, patientId);

		// send request to submit document
		var response = convenienceCommunication.submit(subSet, null, null);

		// check if request was successful
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110106\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-41\""));
	}

	/**
	 * This method extracts content of LOG file and checks if auditing is basically
	 * enabled.
	 * 
	 * @return
	 * @throws IOException
	 */
	private String checkAuditLogging() throws IOException {
		File originLogFile = new File("log/Spring-TestEHC.log");

		// extract content of log file
		String logContent = new String(Files.readAllBytes(originLogFile.toPath()));

		// check if ATNA audit events could be sent
		assertFalse(logContent.contains("Failed to send ATNA audit event to destination"));

		// check if ATNA auditing is basically enabled
		assertTrue(logContent.contains("Auditing"));

		return logContent;
	}

}
