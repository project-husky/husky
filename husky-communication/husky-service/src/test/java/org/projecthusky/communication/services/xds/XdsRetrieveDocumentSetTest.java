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
package org.projecthusky.communication.services.xds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocument;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.DocumentRequest;
import org.projecthusky.communication.requests.xds.XdsDocumentSetRequest;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.services.HuskyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
@ActiveProfiles("atna")
public class XdsRetrieveDocumentSetTest {

  @Autowired
  private HuskyService service;

  @Value(value = "${test.epdpg.xds.ret.uri:https://epdplayground.i4mi.bfh.ch:6443/Repository/services/RepositoryService}")
  private String repositoryURL;

  @Test
  void retrieveDocuments() throws Exception {
    String applicationOid = "2.16.840.1.113883.3.72.6.5.100.1399";
    String facilityOid = "Waldpsital Bern";
    String senderApplicationOid = "1.2.3.4";

    final String documentId_1 = "2.25.90799173491713586491471839779315544798";
    final String repositoryId_1 = "1.1.1.2.31";
    final String homeCommunityId_1 = "urn:oid:1.1.1";

    final String documentId_2 = "2.25.253445961889251413523507992196901058285";
    final String repositoryId_2 = "1.1.1.2.31";
    final String homeCommunityId_2 = "urn:oid:1.1.1";

    Destination dest = new Destination();
    dest.setUri(URI.create(repositoryURL));
    dest.setSenderApplicationOid(senderApplicationOid);
    dest.setReceiverApplicationOid(applicationOid);
    dest.setReceiverFacilityOid(facilityOid);

    XdsDocumentSetRequest request = XdsDocumentSetRequest.builder().destination(dest)
        .documentRequest(new DocumentRequest(repositoryId_1, null, documentId_1, homeCommunityId_1))
        .documentRequest(new DocumentRequest(repositoryId_2, null, documentId_2, homeCommunityId_2))
        .build();

    RetrievedDocumentSet set = this.service.send(request);
    assertEquals(Status.SUCCESS, set.getStatus());
    assertTrue(set.getErrors().isEmpty());

    // check if document is returned
    assertFalse(set.getDocuments().isEmpty());
    assertEquals(2, set.getDocuments().size());

    for (RetrievedDocument retrievedDocument : set.getDocuments()) {

      // check mime type
      assertEquals("application/fhir+json", retrievedDocument.getMimeType());

      // check for content
      try (var is = retrievedDocument.getDataHandler().getInputStream()) {
        byte[] bytesOfDocument = is.readAllBytes();
        assertNotNull(bytesOfDocument);
      }
    }
  }

}
