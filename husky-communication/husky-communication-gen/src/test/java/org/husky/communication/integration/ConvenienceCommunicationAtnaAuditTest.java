package org.husky.communication.integration;

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

import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.AtnaConfig.AtnaConfigMode;
import org.husky.common.communication.Destination;
import org.husky.common.communication.DocumentMetadata;
import org.husky.common.communication.SubmissionSetMetadata;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.model.Identificator;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.DocumentRequest;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdsTestUtils;
import org.husky.communication.xd.storedquery.GetDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.ObjectReference;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocument;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
public class ConvenienceCommunicationAtnaAuditTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvenienceCommunicationAtnaAuditTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	@Autowired
	protected AuditContext auditContext;

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
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/xcq"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
	}

	@Test
	public void queryGetDocumentsMetadataOfCdaWithAuditMessage() throws Exception {

		List<String> uniqueIds = new LinkedList<>();
		uniqueIds.add("1.2.820.99999.18508463736145106181926975526539403561455330316563");

		GetDocumentsQuery getDocumentsQuery = new GetDocumentsQuery(uniqueIds, false, "urn:oid:1.1.4567334.1.6");

		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.setAtnaConfig(AtnaConfigMode.SECURE);

		final QueryResponse response = convenienceCommunication.queryDocumentReferencesOnly(getDocumentsQuery, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(!response.getReferences().isEmpty());
		assertEquals(1, response.getReferences().size());

		ObjectReference objectRef = response.getReferences().iterator().next();
		assertEquals("urn:uuid:afd9bee4-4c30-4b58-a0e7-e301c799047b", objectRef.getId());
		assertEquals("urn:oid:1.1.4567334.1.6", objectRef.getHome());

		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110112\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-18\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	@Test
	public void retrieveDocumentCdaTest() throws Exception {
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

		var documentRequest = new DocumentRequest("1.1.4567332.1.75", null,
				"1.2.820.99999.18508463736145106181926975526539403561455330316563", "urn:oid:1.1.4567334.1.6");

		final RetrievedDocumentSet response = convenienceCommunication.retrieveDocument(documentRequest, null);
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(response.getErrors().isEmpty());
		assertFalse(response.getDocuments().isEmpty());

		assertEquals(1, response.getDocuments().size());

		RetrievedDocument retrievedDocument = response.getDocuments().get(0);

		assertEquals("text/xml", retrievedDocument.getMimeType());

		try (var is = retrievedDocument.getDataHandler().getInputStream()) {
			byte[] bytesOfDocument = is.readAllBytes();
			assertNotNull(bytesOfDocument);
			assertTrue(bytesOfDocument.length > 0);
		}

		checkAuditLogging();

		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110107\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-43\""));
	}

	@Test
	public void submitPdfDocTest() throws Exception {
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

		convenienceCommunication.clearDocuments();
		DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForPdf(metdata, patientId);
		setSubmissionMetadata(subSet, patientId);
		var response = convenienceCommunication.submit(subSet, null);

		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		checkAuditLogging();

		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110106\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-41\""));
	}

	private String checkAuditLogging() throws IOException {
		File originLogFile = new File("log/Spring-TestEHC.log");

		String logContent = new String(Files.readAllBytes(originLogFile.toPath()));

		assertFalse(logContent.contains("Failed to send ATNA audit event to destination"));
		assertTrue(logContent.contains("Auditing"));

		return logContent;
	}

}
