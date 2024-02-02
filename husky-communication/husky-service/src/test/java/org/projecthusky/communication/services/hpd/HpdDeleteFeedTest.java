/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services.hpd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.requests.hpd.HpdBatchRequest;
import org.projecthusky.communication.requests.hpd.HpdDeleteFeed;
import org.projecthusky.communication.responses.hpd.HpdResponse;
import org.projecthusky.communication.services.HuskyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class,
    IpfApplicationConfig.class})
public class HpdDeleteFeedTest {
  private static final String PROFESSIONAL_DN = "uid=CommunityC:11100000010,OU=HCProfessional,DC=HPD,O=BAG,C=CH";
  private static final String ORGANIZATION_DN = "uid=CommunityC:22200000010,ou=HCRegulatedOrganization,DC=HPD,O=BAG,C=CH";
  private static final String UNKNOWN_DN = "uid=Unknown,ou=HCRegulatedOrganization,DC=HPD,O=BAG,C=CH";
  private static final String EXCEPTION_MESSAGE = "Invalid request: mandatory constraints are not fulfilled!";

  @Value(value = "${test.hpd.uri:https://ehealthsuisse.ihe-europe.net/HPDSimulator-ejb/ProviderInformationDirectory_Service/ProviderInformationDirectory_PortType}")
  private String webserviceUri;

  @Autowired
  private HuskyService huskyService;

  private Destination dest;

  @BeforeEach
  void setUp() {
    this.dest = new Destination();
    this.dest.setUri(URI.create(webserviceUri));
  }

  @Test
  void deleteRequest_professionalProvider_gazelle_returnsCodeZero() throws Exception {
    HpdDeleteFeed hpdDeleteRequest = new HpdDeleteFeed();
    hpdDeleteRequest.setDistinguishedName(PROFESSIONAL_DN);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdDeleteRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
  }

  @Test
  void deleteRequest_regulatedOrganizationProvider_gazelle_returnsCodeZero() throws Exception {
    HpdDeleteFeed hpdDeleteRequest = new HpdDeleteFeed();
    hpdDeleteRequest.setDistinguishedName(ORGANIZATION_DN);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdDeleteRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
  }

  @Test
  void deleteRequest_relationshipAttributes_gazelle_returnsCodeZero() throws Exception {
    HpdDeleteFeed hpdDeleteRequest = new HpdDeleteFeed();
    hpdDeleteRequest.setDistinguishedName(UNKNOWN_DN);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdDeleteRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
  }

  @Test
  void deleteRequest_nullDn_shouldThrowException() {
    HpdDeleteFeed request = this.huskyService.createHpdDeleteFeed();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    assertThrows(IllegalArgumentException.class, () -> this.huskyService.send(hpdBatchRequest));
  }

  @Test
  void deleteRequest_nullDestination_shouldThrowException() {
    HpdDeleteFeed request = this.huskyService.createHpdDeleteFeed();
    request.setDistinguishedName(UNKNOWN_DN);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .build();

    assertThrows(IllegalArgumentException.class, () -> this.huskyService.send(hpdBatchRequest));
  }

  @Test
  void deleteRequest_nullDestinationUri_shouldThrowException() {
    HpdDeleteFeed hpdDeleteRequest = this.huskyService.createHpdDeleteFeed();
    hpdDeleteRequest.setDistinguishedName(UNKNOWN_DN);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdDeleteRequest))
        .destination(new Destination())
        .build();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.huskyService.send(hpdBatchRequest));

    String message = exception.getMessage();

    assertEquals(EXCEPTION_MESSAGE, message);
  }
}