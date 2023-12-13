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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest.DerefAliasesType;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest.SearchScope;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.requests.hpd.data.HpdFilterOperation;
import org.projecthusky.communication.requests.hpd.data.HpdFilterOperation.OperationType;
import org.projecthusky.communication.requests.hpd.data.HpdOperationParameters;
import org.projecthusky.communication.requests.hpd.data.HpdSimpleParameters;
import org.projecthusky.communication.requests.hpd.data.HpdSubstringParameters;
import org.projecthusky.communication.enums.HpdAttributeName;
import org.projecthusky.communication.requests.hpd.HpdAddFeed;
import org.projecthusky.communication.requests.hpd.HpdBatchRequest;
import org.projecthusky.communication.requests.hpd.HpdSearchQuery;
import org.projecthusky.communication.responses.hpd.HpdResponse;
import org.projecthusky.communication.services.HuskyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class,
    IpfApplicationConfig.class})
class HpdSearchRequestTest {
  private static final String SPITAL_X = "Spital X";
  private static final String KLINIK_HOHEWEG = "Klinik Höheweg";
  private static final String PRAXIS_AM_KREUZWEG = "Praxis am Kreuzweg";
  private static final String IDENTIFIER_VALUE = "RefData:GLN:7601000000002:ACTIVE";
  private static final String DN_ORG = "ou=HCRegulatedOrganization,dc=HPD,o=BAG,c=CH";
  private static final String DN_INDIVIDUAL = "ou=HCProfessional,dc=HPD,o=BAG,c=CH";
  private static final String HOSPITAL = "Hospital";
  private static final String STARTS_WITH = "Klin";
  private static final String ENDS_WITH = "weg";
  private static final String PRACTITIONER_NAME = "Marianne Loser";
  private static final String DR_MED = "Dr. Med.";
  private static final String EXCEPTION_MESSAGE = "Invalid request: mandatory constraints are not fulfilled!";
  private static final String HC_REGISTRATION_STATUS = "Unknown";
  private static final String RELATIONSHIP_CN = "1.1.1:1616607308848Relationship";
  private static final String RELATIONSHIP_DN = "cn=1.1.1:1616607308848Relationship,ou=Relationship,dc=HPD,o=BAG,c=CH";
  private static final String GROUP_OF_NAMES = "groupOfNames";
  private static final String TOP = "top";

  @Value(value = "${test.hpd.uri:https://epdplayground.i4mi.bfh.ch:7443/HPD/services/HPDService}")
  private String webserviceUri;

  @Autowired
  private HuskyService huskyService;

  private Destination dest;

  @BeforeEach
  public void setUp() {
    this.dest = new Destination();
    this.dest.setUri(URI.create(webserviceUri));
  }

  @Test
  void searchRequest_equalityMatchAndApproxMatchNeg_gazelle_returnsHospitalNameAndDesc() throws Exception {
    String gazelleURI = "https://ehealthsuisse.ihe-europe.net/HPDSimulator-ejb/ProviderInformationDirectory_Service/ProviderInformationDirectory_PortType";
    dest = new Destination();
    dest.setUri(URI.create(gazelleURI));

    HpdSimpleParameters equalityMatchOperation = HpdOperationParameters.createSimpleParameters(
        HpdAttributeName.HC_REGISTERED_NAME, SPITAL_X);

    HpdSimpleParameters approxMatchOperation =
        HpdOperationParameters.createSimpleParameters(HpdAttributeName.HC_IDENTIFIER, IDENTIFIER_VALUE);

    HpdFilterOperation equality = new HpdFilterOperation(false, equalityMatchOperation, OperationType.EQUALITY_MATCH);
    HpdFilterOperation approx = new HpdFilterOperation(false, approxMatchOperation, OperationType.APPROX_MATCH);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .resultAttributeNames(List.of(HpdAttributeName.ORGANIZATION.getName(), HpdAttributeName.DESCRIPTION.getName()))
        .isOrRequest(true)
        .primitiveFilters(List.of(equality, approx))
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);
    Set<String> attributeNames = response.getAttributes().keySet();
    Collection<List<String>> values = response.getAttributes().values();

    assertNotNull(response);
    assertTrue(attributeNames.contains(HpdAttributeName.ORGANIZATION.getName()));
    assertTrue(attributeNames.contains(HpdAttributeName.DESCRIPTION.getName()));
    assertTrue(values.stream().anyMatch(list -> list.contains(SPITAL_X)));
    assertTrue(values.stream().anyMatch(list -> list.contains(HOSPITAL)));
  }

  @Test
  void searchRequest_andOperationWithSubstringFilter_EPDPlayground_returnsKlinicAttrNameAndValue()
      throws Exception {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.HC_REGISTERED_NAME, STARTS_WITH, ENDS_WITH);

    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .resultAttributeNames(List.of(HpdAttributeName.HC_REGISTERED_NAME.getName()))
        .isAndRequest(true)
        .primitiveFilters(List.of(substring))
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);
    Set<String> attributeNames = response.getAttributes().keySet();
    Collection<List<String>> values = response.getAttributes().values();

    assertNotNull(response);
    assertTrue(attributeNames.contains(HpdAttributeName.HC_REGISTERED_NAME.getName()));
    assertTrue(values.stream().anyMatch(list -> list.contains(KLINIK_HOHEWEG)));
  }

  @Test
  void searchRequest_substringAndOperWithEqualityMatchNegated_EPDPlayground_returnsListContainingKlinikName()
      throws Exception {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.HC_REGISTERED_NAME, STARTS_WITH, null);

    HpdSimpleParameters equalityMatchOperation =
        HpdOperationParameters.createSimpleParameters(HpdAttributeName.HC_REGISTERED_NAME, KLINIK_HOHEWEG);

    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);
    HpdFilterOperation equality = new HpdFilterOperation(true, equalityMatchOperation, OperationType.EQUALITY_MATCH);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .resultAttributeNames(List.of(HpdAttributeName.HC_REGISTERED_NAME.getName()))
        .isAndRequest(true)
        .primitiveFilters(List.of(substring, equality))
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);
    Collection<List<String>> values = response.getAttributes().values();

    assertNotNull(response);
    assertFalse(values.stream().anyMatch(list -> list.contains(KLINIK_HOHEWEG)));
  }

  @Test
  void searchRequest_equalityMatchOrganization_EPDPlayground_returnsListContainingAttrNames() throws Exception {
    HpdSimpleParameters simpleParameters = HpdOperationParameters.createSimpleParameters(
        HpdAttributeName.HC_REGISTERED_NAME, PRAXIS_AM_KREUZWEG);

    HpdFilterOperation filter = new HpdFilterOperation(false, simpleParameters, OperationType.EQUALITY_MATCH);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .resultAttributeNames(List.of(HpdAttributeName.HPD_PROVIDER_LANGUAGE_SUPPORTED.getName(),
            HpdAttributeName.HPD_PROVIDER_PRACTICE_ADDRESS.getName()))
        .primitiveFilters(List.of(filter))
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);
    Set<String> attributeNames = response.getAttributes().keySet();

    assertNotNull(response);
    assertTrue(attributeNames.contains(HpdAttributeName.HPD_PROVIDER_PRACTICE_ADDRESS.getName()));
    assertTrue(attributeNames.contains(HpdAttributeName.HPD_PROVIDER_LANGUAGE_SUPPORTED.getName()));
  }

  @Test
  void searchRequest_equalityMatchIndividualProviderSimpleOper_EPDPlayground_returnsPractitionerName()
      throws Exception {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.TITLE, DR_MED, null);
    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .primitiveFilters(List.of(substring))
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_INDIVIDUAL)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    HpdResponse response = this.huskyService.send(hpdBatchRequest);

    Collection<List<String>> values = response.getAttributes().values();

    assertNotNull(response);
    assertTrue(values.stream().anyMatch(list -> list.contains(PRACTITIONER_NAME)));
  }

  @Test
  void searchRequest_mandatoryFieldsNull_shouldThrowException() {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.TITLE, DR_MED, null);
    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .isAndRequest(true)
        .primitiveFilters(List.of(substring))
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.huskyService.send(hpdBatchRequest));

    String message = exception.getMessage();

    assertEquals(EXCEPTION_MESSAGE, message);
  }

  @Test
  void searchRequest_emptyOperationList_shouldThrowException() {
    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .isAndRequest(true)
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE).build();
    request.setDistinguishedName(DN_ORG);

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(dest)
        .build();

    assertThrows(IllegalArgumentException.class, () -> this.huskyService.send(hpdBatchRequest));
  }

  @Test
  void searchRequest_nullDestination_shouldThrowException() {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.TITLE, DR_MED, null);
    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .primitiveFilters(List.of(substring))
        .isAndRequest(true)
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .build();

    assertThrows(IllegalArgumentException.class, () -> this.huskyService.send(hpdBatchRequest));
  }

  @Test
  void searchRequest_nullDestinationUri_shouldThrowException() {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.TITLE, DR_MED, null);
    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .primitiveFilters(List.of(substring))
        .isAndRequest(true)
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request))
        .destination(new Destination())
        .build();

    assertThrows(IllegalArgumentException.class, () -> this.huskyService.send(hpdBatchRequest));
  }

  @Test
  void batchRequest_searchRequestAndAddRequestTogether_shouldFailValidationAndThrowException() {
    HpdSubstringParameters substringOperation = HpdOperationParameters.createSubstringParameters(
        HpdAttributeName.TITLE, DR_MED, null);
    HpdFilterOperation substring = new HpdFilterOperation(false, substringOperation, OperationType.SUBSTRINGS);

    HpdAddFeed hpdAddRequest = huskyService.createHpdAddFeed();
    hpdAddRequest.createHCRelationshipAttributes(HC_REGISTRATION_STATUS,
        RELATIONSHIP_CN, RELATIONSHIP_DN, List.of(GROUP_OF_NAMES, TOP), null);

    HpdSearchQuery request = this.huskyService.createHpdSearchQuery()
        .primitiveFilters(List.of(substring))
        .isAndRequest(true)
        .derefAliases(DerefAliasesType.NEVER_DEREF_ALIASES)
        .scope(SearchScope.WHOLE_SUBTREE)
        .distinguishedName(DN_ORG)
        .build();

    HpdBatchRequest hpdBatchRequest = HpdBatchRequest.builder()
        .hpdRequests(List.of(request, hpdAddRequest))
        .destination(dest)
        .build();

    assertThrows(IllegalArgumentException.class, () -> this.huskyService.send(hpdBatchRequest));
  }
}