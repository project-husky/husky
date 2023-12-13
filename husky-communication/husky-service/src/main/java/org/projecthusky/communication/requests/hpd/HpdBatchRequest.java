/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.hpd;

import java.util.List;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchRequest.RequestErrorHandlingType;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchRequest.RequestProcessingType;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchRequest.RequestResponseOrder;
import org.projecthusky.common.communication.Destination;

@Getter
@Builder
@ToString
@Slf4j
public class HpdBatchRequest {
  private String principal;
  @Singular
  private List<HpdRequest> hpdRequests;
  private String requestId;
  /** How to process the request SEQUENTIAL or in PARALLEL */
  private RequestProcessingType processingType;
  /** How to receive the response SEQUENTIAL or UNORDERED */
  private RequestResponseOrder requestResponseOrder;
  /** What to do in case of an error RESUME or EXIT */
  private RequestErrorHandlingType errorHandlingType;
  /** Used for creating the endpoint of the webservice */
  private Destination destination;

  public boolean isValid() {
    if (hpdRequests.stream().anyMatch(request -> !request.isValid())) {
      log.error("Invalid HpdRequest: mandatory constraints are not fulfilled!");
      return false;
    }

    // Check for simultaneous query and feed requests
    long queryCount = hpdRequests.stream().filter(request -> request instanceof HpdSearchQuery).count();
    long feedCount = hpdRequests.size() - queryCount;

    if (queryCount > 0 && feedCount > 0) {
      log.error("Invalid request: Batch request can't contain simultaneously a query and a feed request!");
      return false;
    }

    if (Objects.isNull(destination) || Objects.isNull(destination.getUri())) {
      log.error("Invalid request: Destination and destination uri must not be null!");
      return false;
    }

    return true;
  }
}
