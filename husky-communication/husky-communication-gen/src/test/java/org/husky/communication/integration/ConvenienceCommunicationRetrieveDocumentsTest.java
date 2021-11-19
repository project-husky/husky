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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.DocumentRequest;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocument;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Severity;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class ConvenienceCommunicationRetrieveDocumentsTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConvenienceCommunicationRetrieveDocumentsTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";


	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void retrieveDocumentTest() throws Exception {
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
				"1.2.820.99999.15031207481211484821638086641062503555190193702785", "urn:oid:1.1.4567334.1.6");

		final RetrievedDocumentSet response = convenienceCommunication.retrieveDocument(documentRequest, null);
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(response.getErrors().isEmpty());
		assertFalse(response.getDocuments().isEmpty());

		assertEquals(1, response.getDocuments().size());

		RetrievedDocument retrievedDocument = response.getDocuments().get(0);

		assertEquals("application/pdf", retrievedDocument.getMimeType());

		try (var is = retrievedDocument.getDataHandler().getInputStream()) {
			byte[] bytesOfDocument = is.readAllBytes();
			assertNotNull(bytesOfDocument);
		}
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
		}
	}

	@Test
	public void retrieveDocumentUnknownIdTest() throws Exception {
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

		var documentRequest = new DocumentRequest("1", null, "1", "1");

		final RetrievedDocumentSet response = convenienceCommunication.retrieveDocument(documentRequest, null);
		assertEquals(Status.FAILURE, response.getStatus());
		assertTrue(response.getErrors().size() > 0);

		ErrorInfo error = response.getErrors().get(0);

		assertEquals(ErrorCode.DOCUMENT_UNIQUE_ID_ERROR, error.getErrorCode());
		assertEquals("1", error.getLocation());
		assertEquals(Severity.ERROR, error.getSeverity());
	}

}
