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
package org.projecthusky.communication.manual.xds;

import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
public class XdsRetrieveDocumentsManualTest {
//	@Autowired
//    private ConvenienceCommunication convenienceCommunication;

	@Autowired
	private HuskyWebServiceClient wsClient;

    @Value(value = "${test.epdpg.xds.ret.uri:https://epdplayground.i4mi.bfh.ch:6443/Repository/services/RepositoryService}")
    private String repositoryURL;

    final private String applicationOid = "2.16.840.1.113883.3.72.6.5.100.1399";
    final private String facilityOid = "Waldpsital Bern";
    final private String senderApplicationOid = "1.2.3.4";

    // data taken from the RegistryStoredQuery for two documents
    final String documentId_1 = "2.25.90799173491713586491471839779315544798";
    final String repositoryId_1 = "1.1.1.2.31";
    final String homeCommunityId_1 = "urn:oid:1.1.1";

    final String documentId_2 = "2.25.253445961889251413523507992196901058285";
    final String repositoryId_2 = "1.1.1.2.31";
    final String homeCommunityId_2 = "urn:oid:1.1.1";


//	@Test
//    void retrieveDocumentsTest() throws Exception {
//		// sets XDS service endpoint
//		final AffinityDomain affinityDomain = new AffinityDomain();
//		final Destination dest = new Destination();
//
//		dest.setUri(new URI(repositoryURL));
//
//		dest.setSenderApplicationOid(senderApplicationOid);
//
//		dest.setReceiverApplicationOid(applicationOid);
//		dest.setReceiverFacilityOid(facilityOid);
//
//		affinityDomain.setRegistryDestination(dest);
//		affinityDomain.setRepositoryDestination(dest);
//
//		convenienceCommunication.setAffinityDomain(affinityDomain);
//
//		// set identifiers (unique ID, repository ID and home community ID) of one document
//		var documentRequest_1 = new DocumentRequest(repositoryId_1, null, documentId_1, homeCommunityId_1);
//		var documentRequest_2 = new DocumentRequest(repositoryId_2, null, documentId_2, homeCommunityId_2);
//
//		var documentRequests = new DocumentRequest[]{documentRequest_1, documentRequest_2};
//
//		// set the audit config mode to activate the ATNA logs. Please note that you
//		// need to configure additional properties for the ATNA communication
//		// in file application.properties
//		convenienceCommunication.setAtnaConfig(AtnaConfig.AtnaConfigMode.SECURE);
//
//		final RetrievedDocumentSet response = convenienceCommunication.retrieveDocuments(documentRequests, null,
//		        String.format("test_%s", UUID.randomUUID().toString()));
//
//		// check if request was successful
//		assertEquals(Status.SUCCESS, response.getStatus());
//		assertTrue(response.getErrors().isEmpty());
//
//		// check if document is returned
//		assertFalse(response.getDocuments().isEmpty());
//		assertEquals(2, response.getDocuments().size());
//
//		for (RetrievedDocument retrievedDocument : response.getDocuments()){
//
//		    // check mime type
//		    assertEquals("application/fhir+json", retrievedDocument.getMimeType());
//
//		    // check for content
//		    try (var is = retrievedDocument.getDataHandler().getInputStream()) {
//		        byte[] bytesOfDocument = is.readAllBytes();
//		        assertNotNull(bytesOfDocument);
//		    }
//		}
//	}

//	@Test
//	void retreiveDocumentsWithBuilder() throws Exception {
//		Destination dest = Destination.builder().uri(URI.create(repositoryURL))
//				.senderApplicationOid(senderApplicationOid).receiverApplicationOid(applicationOid).receiverFacilityOid(facilityOid).build();
//		DocumentSetRequest request = DocumentSetRequest.builder().destination(dest)
//			.documentRequest(new DocumentRequest(repositoryId_1, null, documentId_1, homeCommunityId_1))
//			.documentRequest(new DocumentRequest(repositoryId_2, null, documentId_2, homeCommunityId_2))
//			.build();
//
//		RetrievedDocumentSet set = this.wsClient.send(request, null, dest.getUri(), null);
//		assertEquals(Status.SUCCESS, set.getStatus());
//		assertTrue(set.getErrors().isEmpty());
//
//		// check if document is returned
//		assertFalse(set.getDocuments().isEmpty());
//		assertEquals(2, set.getDocuments().size());
//
//		for (RetrievedDocument retrievedDocument : set.getDocuments()){
//
//		    // check mime type
//		    assertEquals("application/fhir+json", retrievedDocument.getMimeType());
//
//		    // check for content
//		    try (var is = retrievedDocument.getDataHandler().getInputStream()) {
//		        byte[] bytesOfDocument = is.readAllBytes();
//		        assertNotNull(bytesOfDocument);
//		    }
//		}
//	}

}
