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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Person;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.testhelper.TestApplication;
import org.projecthusky.communication.testhelper.XdsTestUtils;
import org.projecthusky.communication.xd.storedquery.FindDocumentsQuery;
import org.projecthusky.communication.xd.storedquery.GetDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.ObjectReference;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
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
 * The purpose of this test class is to check whether document metadata
 * retrieval (XDS ITI-18) works with a wide variety of parameters.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class ConvenienceCommunicationQueryDocumentsTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConvenienceCommunicationQueryDocumentsTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	@Autowired
	protected AuditContext auditContext;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	private AffinityDomain affinityDomain = null;

	/**
	 * This method creates and start spring test application. Moreover, it sets the
	 * endpoint of XDS service for querying metadata.
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
	 * {@link ConvenienceCommunication#queryDocuments(org.projecthusky.communication.xd.storedquery.AbstractStoredQuery, org.projecthusky.xua.core.SecurityHeaderElement)}
	 * when no documents are found.
	 * 
	 * @throws Exception
	 */
	@Test
	void queryFindDocumentsEmptyResponseTest() throws Exception {

		// ID of the patient for whom the metadata is to be searched for
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2737");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);
		
		// query metadata of documents
		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery,
				null, null);

		// check if errors are returned
		assertTrue(response.getErrors().isEmpty());

		// check if no document metadata are returned
		assertTrue(response.getDocuments().isEmpty());
		assertTrue(response.getDocumentEntries().isEmpty());

		// check if query was successful
		assertEquals(Status.SUCCESS, response.getStatus());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#queryDocuments(org.projecthusky.communication.xd.storedquery.AbstractStoredQuery, org.projecthusky.xua.core.SecurityHeaderElement)}
	 * if no patient ID is passed.
	 * 
	 * @throws Exception
	 */
	@Test
	void queryFindDocumentsNoPatientIdExpectedErrorTest() throws Exception {

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(null, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);

		// query metadata of documents
		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null, null);

		// check if query failed
		assertEquals(Status.FAILURE, response.getStatus());
		assertFalse(response.getErrors().isEmpty());

		// check details of returned errors
		assertEquals(2, response.getErrors().size());

		ErrorInfo error = response.getErrors().get(0);
		assertEquals(ErrorCode.REGISTRY_ERROR, error.getErrorCode());
		assertEquals("StoredQuery.java", error.getLocation());
		assertEquals(Severity.ERROR, error.getSeverity());

		error = response.getErrors().get(1);
		assertEquals(ErrorCode.REGISTRY_ERROR, error.getErrorCode());
		assertEquals("QueryRequestMessageValidator", error.getLocation());
		assertEquals(Severity.ERROR, error.getSeverity());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#queryDocuments(org.projecthusky.communication.xd.storedquery.AbstractStoredQuery, org.projecthusky.xua.core.SecurityHeaderElement)}
	 * when at least metadata is found for one PDF document
	 * 
	 * @throws Exception
	 */
	/* test function to checks  attributes - no need to reduce number of assertions */
	@Test
	@SuppressWarnings("java:S5961")
	void queryFindDocumentsMetadataOfPdf() throws Exception {

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);

		// query metadata of documents with patient ID and approved as availability
		// status
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

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#queryDocuments(org.projecthusky.communication.xd.storedquery.AbstractStoredQuery, org.projecthusky.xua.core.SecurityHeaderElement)}
	 * when at least metadata is found for one CDA document with following metadata:
	 * 
	 * <ul>
	 * <li>patient ID</li>
	 * <li>class code</li>
	 * <li>practice setting</li>
	 * <li>health care facility</li>
	 * <li>confidentiality</li>
	 * <li>format</li>
	 * <li>given and last name of author</li>
	 * <li>approved as availability status</li>
	 * </ul>
	 * 
	 * @throws Exception
	 */
	/* test function to checks  attributes - no need to reduce number of assertions */
	@Test
	@SuppressWarnings("java:S5961")
	void queryFindDocumentsMetadataOfCda() throws Exception {

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2599");

		List<Code> classCodes = List
				.of(
						new Code("417319006", "2.16.840.1.113883.6.96", "Record of health event (record artifact)"));
		List<Code> practiceSettingCodes = List
				.of(new Code("394802001", "2.16.840.1.113883.6.96", "General medicine (qualifier value)"));
		List<Code> healthcareFacilityCodes = List
				.of(new Code("394747008", "2.16.840.1.113883.6.96", "Health Authority"));
		List<Code> confidentialityCodes = List
				.of(new Code("17621005", "2.16.840.1.113883.6.96", "Normal (qualifier value)"));
		List<Code> formatCodes = List
				.of(new Code("urn:ihe:pcc:ic:2009", "1.3.6.1.4.1.19376.1.2.3", "Immunization Content (IC)"));

		Person person = new Person();
		var name = new Name();
		name.setFamily("Bereit");
		name.setGiven("Allzeit");
		name.setPrefix("Dr.");
		person.addName(name);

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, classCodes, null,
				practiceSettingCodes, healthcareFacilityCodes, confidentialityCodes, formatCodes, person,
				AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);

		// query metadata of documents
		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null, null);

		// check if query was successful
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
		assertTrue(response.getDocumentEntries().size() > 0);

		DocumentEntry documentEntry = response.getDocumentEntries().get(0);

		// check if identifiers (unique ID, repository ID and home community ID) are
		// equal
		assertEquals("1.2.820.99999.18508463736145106181926975526539403561455330316563", documentEntry.getUniqueId());
		assertEquals("1.1.4567332.1.75", documentEntry.getRepositoryUniqueId());
		assertEquals("urn:oid:1.1.4567334.1.6", documentEntry.getHomeCommunityId());
		assertEquals("urn:uuid:afd9bee4-4c30-4b58-a0e7-e301c799047b", documentEntry.getEntryUuid());

		assertEquals(AvailabilityStatus.APPROVED, documentEntry.getAvailabilityStatus());
		assertEquals("text/xml", documentEntry.getMimeType());

		assertNull(documentEntry.getComments());
		assertNull(documentEntry.getDocumentAvailability());

		assertNull(documentEntry.getTitle());
		assertEquals("20211012111457", documentEntry.getCreationTime().toHL7());

		// check different codes
		assertEquals("fr-CH", documentEntry.getLanguageCode());

		assertNotNull(documentEntry.getClassCode());
		assertEquals("417319006", documentEntry.getClassCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getClassCode().getSchemeName());
		assertEquals("Record of health event (record artifact)",
				documentEntry.getClassCode().getDisplayName().getValue());

		assertNotNull(documentEntry.getConfidentialityCodes().get(0));
		assertEquals("17621005", documentEntry.getConfidentialityCodes().get(0).getCode());
		assertEquals("Normal (qualifier value)",
				documentEntry.getConfidentialityCodes().get(0).getDisplayName().getValue());

		assertTrue(documentEntry.getEventCodeList().isEmpty());

		assertEquals("urn:ihe:pcc:ic:2009", documentEntry.getFormatCode().getCode());
		assertEquals("1.3.6.1.4.1.19376.1.2.3", documentEntry.getFormatCode().getSchemeName());
		assertEquals("Immunization Content (IC)",
				documentEntry.getFormatCode().getDisplayName().getValue());

		assertEquals("394747008", documentEntry.getHealthcareFacilityTypeCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getHealthcareFacilityTypeCode().getSchemeName());
		assertEquals("Health Authority", documentEntry.getHealthcareFacilityTypeCode().getDisplayName().getValue());

		assertEquals("394802001", documentEntry.getPracticeSettingCode().getCode());
		assertEquals("General medicine (qualifier value)",
				documentEntry.getPracticeSettingCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getPracticeSettingCode().getSchemeName());

		assertEquals("41000179103", documentEntry.getTypeCode().getCode());
		assertEquals("Immunization record",
				documentEntry.getTypeCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getTypeCode().getSchemeName());

		// check patient details
		assertEquals("IHEBLUE-2599", documentEntry.getPatientId().getId());
		assertEquals("1.3.6.1.4.1.21367.13.20.3000",
				documentEntry.getPatientId().getAssigningAuthority().getUniversalId());

		assertEquals("23423452342134localid", documentEntry.getSourcePatientId().getId());
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

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#queryDocumentReferencesOnly(org.projecthusky.communication.xd.storedquery.AbstractStoredQuery, org.projecthusky.xua.core.SecurityHeaderElement)}
	 * when only the reference to a document is to be returned in the query.
	 * 
	 * @throws Exception
	 */
	@Test
	void queryGetDocumentsMetadataOfCda() throws Exception {

		// unique IDs of documents for which the document references are searched for
		List<String> uniqueIds = new LinkedList<>();
		uniqueIds.add("1.2.820.99999.18508463736145106181926975526539403561455330316563");

		GetDocumentsQuery getDocumentsQuery = new GetDocumentsQuery(uniqueIds, false, "urn:oid:1.1.4567334.1.6");

		convenienceCommunication.setAffinityDomain(affinityDomain);

		final QueryResponse response = convenienceCommunication.queryDocumentReferencesOnly(getDocumentsQuery, null,
				String.format("urn:uuid:testMessage-%s", UUID.randomUUID().toString()));

		// check if query was successful
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());

		// check if references are returned.
		assertTrue(response.getReferences().size() > 0);

		// check if retrieved reference is correct
		ObjectReference objectRef = response.getReferences().iterator().next();
		assertEquals("urn:uuid:afd9bee4-4c30-4b58-a0e7-e301c799047b", objectRef.getId());
		assertEquals("urn:oid:1.1.4567334.1.6", objectRef.getHome());
	}
}
