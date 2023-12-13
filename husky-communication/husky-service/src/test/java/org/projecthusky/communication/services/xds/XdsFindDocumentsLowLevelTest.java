/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services.xds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.communication.requests.xds.XdsRegistryStoredFindDocumentsQuery;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
@ActiveProfiles("atna")
public class XdsFindDocumentsLowLevelTest {

	@Value(value = "${test.xds.xcq.uri:http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/xcq}")
	private String webserviceUri;

	@Autowired
	private HuskyWebServiceClient wsClient;

	private Destination dest;

	@BeforeEach
	public void setUp() {
		this.dest = new Destination();
		dest.setUri(URI.create(webserviceUri));
		dest.setSenderApplicationOid("1.2.3.4");
	}

	@Test
	public void whenPatientQueriedByName_thenPatientIsReturned() throws Exception {
		Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "4711");

		XdsRegistryStoredFindDocumentsQuery query = XdsRegistryStoredFindDocumentsQuery.builder().destination(dest)
				.patientID(identificator).availabilityStatus(AvailabilityStatus.APPROVED).build();
		QueryResponse queryResponse = this.wsClient.sendRegistryStoredFindDocumentsQuery(query, null, query.getDestination().getUri(), QueryReturnType.LEAF_CLASS, null);
		assertNotNull(queryResponse);
		assertTrue(queryResponse.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, queryResponse.getStatus());
		assertEquals(0, queryResponse.getReferences().size());
	}

	@Test
	void queryFindDocumentsMetadataOfPdf() throws Exception {
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");

		XdsRegistryStoredFindDocumentsQuery query = XdsRegistryStoredFindDocumentsQuery.builder().destination(dest)
				.patientID(patientId).availabilityStatus(AvailabilityStatus.APPROVED).build();
		final QueryResponse response = this.wsClient.sendRegistryStoredFindDocumentsQuery(query, null, query.getDestination().getUri(), QueryReturnType.LEAF_CLASS, null);

		// check if query was successful
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
    assertFalse(response.getDocumentEntries().isEmpty());
		//assertEquals(221, response.getDocumentEntries().size());

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
		assertEquals("Summary clinical document (record artifact)", documentEntry.getClassCode().getDisplayName().getValue());

		assertNotNull(documentEntry.getConfidentialityCodes().get(0));
		assertEquals("17621005", documentEntry.getConfidentialityCodes().get(0).getCode());
		assertEquals("Normal (qualifier value)", documentEntry.getConfidentialityCodes().get(0).getDisplayName().getValue());

		assertTrue(documentEntry.getEventCodeList().isEmpty());

		assertEquals("urn:ihe:iti:xds-sd:pdf:2008", documentEntry.getFormatCode().getCode());
		assertEquals("1.3.6.1.4.1.19376.1.2.3", documentEntry.getFormatCode().getSchemeName());
		assertEquals("1.3.6.1.4.1.19376.1.2.20 (Scanned Document)", documentEntry.getFormatCode().getDisplayName().getValue());

		assertEquals("394747008", documentEntry.getHealthcareFacilityTypeCode().getCode());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getHealthcareFacilityTypeCode().getSchemeName());
		assertEquals("Health Authority", documentEntry.getHealthcareFacilityTypeCode().getDisplayName().getValue());

		assertEquals("394810000", documentEntry.getPracticeSettingCode().getCode());
		assertEquals("Rheumatology (qualifier value)", documentEntry.getPracticeSettingCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getPracticeSettingCode().getSchemeName());

		assertEquals("371535009", documentEntry.getTypeCode().getCode());
		assertEquals("Transfer summary report (record artifact)", documentEntry.getTypeCode().getDisplayName().getValue());
		assertEquals("2.16.840.1.113883.6.96", documentEntry.getTypeCode().getSchemeName());

		// check patient details
		assertEquals("IHERED-1024", documentEntry.getPatientId().getId());
		assertEquals("1.3.6.1.4.1.21367.13.20.1000", documentEntry.getPatientId().getAssigningAuthority().getUniversalId());

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
		assertNull(documentEntry.getAuthors().get(0).getAuthorSpecialty().get(0).getAssigningAuthority().getUniversalId());
	}

}
