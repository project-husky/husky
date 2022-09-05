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

import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Person;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdsTestUtils;
import org.husky.communication.xd.storedquery.FindDocumentsQuery;
import org.husky.communication.xd.storedquery.GetDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.ObjectReference;
import org.openehealth.ipf.commons.ihe.xds.core.responses.*;
import org.opensaml.core.config.InitializationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The purpose of this test class is to check whether document metadata
 * retrieval (XDS ITI-18) works with a wide variety of parameters.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class CHRegistryStoredQueryTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CHRegistryStoredQueryTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	@Autowired
	protected AuditContext auditContext;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	private AffinityDomain affinityDomain = null;

	/**
	 * This method initializes opensaml, creates and start spring test application and sets the
	 * endpoint of XDS service for querying metadata.
	 *
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {

		// initialize the open saml factories
		InitializationService.initialize();

		// create and start spring test application
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();

		// sets XDS service endpoint
		affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(new URI(
					"http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/xcq"));

		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);
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
	 * {@link ConvenienceCommunication#queryDocuments(org.husky.communication.xd.storedquery.AbstractStoredQuery, org.husky.xua.core.SecurityHeaderElement, String messageId)}
	 * 
	 * @throws Exception
	 */
	@Test
	@SuppressWarnings("java:S5961")
	void queryFindDocumentsMetadataOfPdf() throws Exception {

		convenienceCommunication.setAffinityDomain(affinityDomain);

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		// query metadata of documents with patient ID and approved as availability status
		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null, null);

		// check if query was successful
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(response.getDocumentEntries().size() > 0);

		DocumentEntry documentEntry = response.getDocumentEntries().get(0);

		// check if identifiers (unique ID, repository ID and home community ID) are
		// equal
		assertEquals("1.2.820.99999.15031207481211484821638086641062503555190193702785", documentEntry.getUniqueId());
		assertEquals("1.1.4567332.1.75", documentEntry.getRepositoryUniqueId());
		assertEquals("urn:oid:1.1.4567334.1.6", documentEntry.getHomeCommunityId());
		assertEquals("urn:uuid:b8f37101-8842-4e2c-b1e7-bc421d0dc01f", documentEntry.getEntryUuid());

		assertEquals(AvailabilityStatus.APPROVED, documentEntry.getAvailabilityStatus());
		assertEquals("application/pdf", documentEntry.getMimeType());

		assertNull(documentEntry.getComments());
		assertNull(documentEntry.getDocumentAvailability());

		assertEquals("Informed Consent", documentEntry.getTitle().getValue());
		assertEquals("20211012082534", documentEntry.getCreationTime().toHL7());

		// check different codes
		assertEquals("de-CH", documentEntry.getLanguageCode());

		assertNotNull(documentEntry.getClassCode());
		assertEquals("422735006", documentEntry.getClassCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getClassCode().getSchemeName());
		assertEquals("Summary clinical document (record artifact)",
				documentEntry.getClassCode().getDisplayName().getValue());

		assertNotNull(documentEntry.getConfidentialityCodes().get(0));
		assertEquals("17621005", documentEntry.getConfidentialityCodes().get(0).getCode());
		assertEquals("Normal (qualifier value)",
				documentEntry.getConfidentialityCodes().get(0).getDisplayName().getValue());

		assertTrue(documentEntry.getEventCodeList().isEmpty());

		assertEquals("urn:ihe:iti:xds-sd:pdf:2008", documentEntry.getFormatCode().getCode());
		assertEquals("1.3.6.1.4.1.19376.1.2.3", documentEntry.getFormatCode().getSchemeName());
		assertEquals("1.3.6.1.4.1.19376.1.2.20 (Scanned Document)",
				documentEntry.getFormatCode().getDisplayName().getValue());

		assertEquals("394747008", documentEntry.getHealthcareFacilityTypeCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getHealthcareFacilityTypeCode().getSchemeName());
		assertEquals("Health Authority",
				documentEntry.getHealthcareFacilityTypeCode().getDisplayName().getValue());

		assertEquals("394810000", documentEntry.getPracticeSettingCode().getCode());
		assertEquals("Rheumatology (qualifier value)",
				documentEntry.getPracticeSettingCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getPracticeSettingCode().getSchemeName());

		assertEquals("371535009", documentEntry.getTypeCode().getCode());
		assertEquals("Transfer summary report (record artifact)",
				documentEntry.getTypeCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getTypeCode().getSchemeName());

		// check patient details
		assertEquals("IHERED-1024", documentEntry.getPatientId().getId());
		assertEquals("1.3.6.1.4.1.21367.13.20.1000",
				documentEntry.getPatientId().getAssigningAuthority().getUniversalId());

		assertEquals("2342134localid", documentEntry.getSourcePatientId().getId());
		assertEquals("1.2.3.4", documentEntry.getSourcePatientId().getAssigningAuthority().getUniversalId());

		// check author details
		assertFalse(documentEntry.getAuthors().isEmpty());
		assertNotNull(documentEntry.getAuthors().get(0));
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorPerson());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorPerson().getName());
		assertEquals("Bereit", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getFamilyName());
		assertEquals("Allzeit", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getGivenName());
		assertEquals("Dr.", documentEntry.getAuthors().get(0).getAuthorPerson().getName().getPrefix());

		assertNotNull(documentEntry.getAuthors().get(0).getAuthorRole());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorRole().get(0));
		assertEquals("221", documentEntry.getAuthors().get(0).getAuthorRole().get(0).getId());
		assertEquals("2.16.840.1.113883.2.9.6.2.7",
				documentEntry.getAuthors().get(0).getAuthorRole().get(0).getAssigningAuthority().getUniversalId());

		assertNotNull(documentEntry.getAuthors().get(0).getAuthorSpecialty());
		assertNotNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0));
		assertNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getId());
		assertNull(
				documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getAssigningAuthority().getUniversalId());
	}


}
