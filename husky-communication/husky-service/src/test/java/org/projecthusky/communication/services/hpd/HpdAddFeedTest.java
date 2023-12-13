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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.requests.hpd.HpdAddFeed;
import org.projecthusky.communication.requests.hpd.HpdBatchRequest;
import org.projecthusky.communication.requests.hpd.HpdDeleteFeed;
import org.projecthusky.communication.responses.hpd.HpdResponse;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.xua.exceptions.SerializeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class,
    IpfApplicationConfig.class})
class HpdAddFeedTest {
  private static final String PROFESSIONAL_DN = "uid=CommunityC:11100000010,OU=HCProfessional,DC=HPD,O=BAG,C=CH";
  private static final String ORGANIZATION_DN = "uid=CommunityC:22200000010,ou=HCRegulatedOrganization,DC=HPD,O=BAG,C=CH";
  private static final String RELATIONSHIP_DN = "cn=1.1.1:1616607308848Relationship,ou=Relationship,dc=HPD,o=BAG,c=CH";
  private static final String PROFESSIONAL_UID = "CommunityC:11100000010";
  private static final String ORGANIZATION_UID = "CommunityC:22200000010";
  private static final String PROFESSIONAL_IDENTIFIER = "RefData:GLN:7601000000002:ACTIVE";
  private static final String ORGANIZATION_IDENTIFIER = "RefData:OID:1.2.1.999994:ACTIVE";
  private static final String HC_PROFESSIONAL = "HCProfessional";
  private static final String HC_PROFESSION = "BAG:2.16.840.1.113883.6.96:9343006";
  private static final String HC_ORG_PROFESSION = "BAG:2.16.840.1.113883.6.96:9343006";
  private static final String HC_REGISTRATION_STATUS = "Unknown";
  private static final String INET_ORG_PERSON = "inetOrgPerson";
  private static final String HPD_PROVIDER = "HPDProvider";
  private static final String CN = "Gregory House";
  private static final String RELATIONSHIP_CN = "1.1.1:1616607308848Relationship";
  private static final String SN = "House";
  private static final String DISPLAY_NAME = "Dr. House";
  private static final String GIVEN_NAME = "Gregory";
  private static final String ORGANIZATION_REGISTERED_NAME = "Spital Projectathon 2022";
  private static final String GROUP_OF_NAMES = "groupOfNames";
  private static final String TOP = "top";
  private static final String EXPECTED_MESSAGE = "Invalid request: mandatory constraints are not fulfilled!";
  private static final String SUCCESS = "success";

  @Value(value = "${test.hpd.uri:https://ehealthsuisse.ihe-europe.net/HPDSimulator-ejb/ProviderInformationDirectory_Service/ProviderInformationDirectory_PortType}")
  private String webserviceUri;

  @Autowired
  private HuskyService huskyService;

  private Destination dest;

  @BeforeEach
  void setUp() {
    dest = new Destination();
    dest.setUri(URI.create(webserviceUri));
  }

  @Test
  void addRequest_professionalProvider_gazelle_returnsCodeZero() throws Exception {
    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCProfessional(PROFESSIONAL_DN, PROFESSIONAL_UID,
        List.of(PROFESSIONAL_IDENTIFIER), List.of(HC_PROFESSIONAL, INET_ORG_PERSON, HPD_PROVIDER), null,
        List.of(CN), SN, GIVEN_NAME, List.of(HC_PROFESSION), DISPLAY_NAME, List.of(HC_REGISTRATION_STATUS));

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
  }

  @Test
  void addRequest_regulatedOrganizationProvider_gazelle_returnsCodeZero() throws Exception {
    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCRegulatedOrganization(
        ORGANIZATION_DN, ORGANIZATION_UID, List.of(ORGANIZATION_IDENTIFIER), List.of(HC_PROFESSIONAL, INET_ORG_PERSON, HPD_PROVIDER), null,
        List.of(HC_ORG_PROFESSION), List.of(ORGANIZATION_REGISTERED_NAME), List.of(ORGANIZATION_REGISTERED_NAME));

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
  }

  @Test
  void addRequest_relationshipAttributes_gazelle_returnsCodeZero() throws Exception {
    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCRelationshipAttributes(HC_REGISTRATION_STATUS,
        RELATIONSHIP_CN, RELATIONSHIP_DN, List.of(GROUP_OF_NAMES, TOP), null);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
    assertEquals(SUCCESS, response.getDescription());
  }

  @Test
  void addRequest_professionalProvider_mandatoryFieldsNullBlankOrEmptyList_shouldThrowException() {
    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCProfessional(null, PROFESSIONAL_UID,
        List.of(PROFESSIONAL_IDENTIFIER), List.of(HC_PROFESSIONAL, INET_ORG_PERSON, HPD_PROVIDER), null,
        List.of(CN), SN, GIVEN_NAME, Collections.emptyList(), null, List.of(HC_REGISTRATION_STATUS));

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(dest)
        .build();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.huskyService.send(hpdBatchRequest));

    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(EXPECTED_MESSAGE));
  }

  @Test
  void addRequest_regulatedOrganizationProvider_mandatoryFieldsNullOrEmptyList_shouldThrowException() {
    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCRegulatedOrganization(
        ORGANIZATION_DN, null, List.of(ORGANIZATION_IDENTIFIER), List.of(HC_PROFESSIONAL), null,
        List.of(ORGANIZATION_IDENTIFIER), List.of(ORGANIZATION_REGISTERED_NAME), Collections.emptyList());

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(dest)
        .build();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.huskyService.send(hpdBatchRequest));

    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(EXPECTED_MESSAGE));
  }

  @Test
  void addRequest_relationshipAttributes_mandatoryFieldsNullOrBlank_shouldThrowException() {
    HpdAddFeed hpdAddRequest = new HpdAddFeed();
    hpdAddRequest.createHCRelationshipAttributes("", RELATIONSHIP_CN, RELATIONSHIP_DN, List.of(GROUP_OF_NAMES), null);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(dest)
        .build();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.huskyService.send(hpdBatchRequest));

    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(EXPECTED_MESSAGE));
  }

  @Test
  void addRequest_relationshipAttributes_destinationURINull_shouldThrowException() {
    HpdAddFeed hpdAddRequest = new HpdAddFeed();
    hpdAddRequest.createHCRelationshipAttributes("", ORGANIZATION_UID, ORGANIZATION_DN, List.of(GROUP_OF_NAMES),
        null);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest))
        .destination(new Destination())
        .build();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.huskyService.send(hpdBatchRequest));

    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(EXPECTED_MESSAGE));
  }

  @Test
  void batchRequest_addRequestAndDeleteRequest_shouldReturnResponseCodeZero()
      throws SerializeException, JAXBException, ParserConfigurationException, IOException {
    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCRelationshipAttributes(HC_REGISTRATION_STATUS,
        RELATIONSHIP_CN, RELATIONSHIP_DN, List.of(GROUP_OF_NAMES, TOP), null);

    HpdDeleteFeed hpdDeleteRequest = new HpdDeleteFeed();
    hpdDeleteRequest.setDistinguishedName(RELATIONSHIP_DN);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(hpdAddRequest, hpdDeleteRequest))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    assertNotNull(response);
    assertEquals(0, response.getResponseCode());
  }
}