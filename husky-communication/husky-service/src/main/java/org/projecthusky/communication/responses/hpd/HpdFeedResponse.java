/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.responses.hpd;

import static org.projecthusky.communication.utils.HpdUtils.getValidResponse;

import java.util.Objects;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.LDAPResult;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.LDAPResultCode;

/** Class responsible for creating response from
 * {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AddRequest}
 * {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DelRequest}
 */
public class HpdFeedResponse extends HpdResponse {
  @Override
  public HpdFeedResponse build(BatchResponse response) {
    LDAPResult result = getValidResponse(response, LDAPResult.class);
    if (Objects.nonNull(result)) {
      HpdFeedResponse hpdFeedResponse = new HpdFeedResponse();
      hpdFeedResponse.setRequestId(result.getRequestID());
      hpdFeedResponse.setResponseCode(result.getResultCode().getCode());
      setResponseDescription(hpdFeedResponse, result);

      return hpdFeedResponse;
    }
    throw new IllegalArgumentException("HpdFeedResponse mapping failed!");
  }

  /** When responseCode == 0 it means that the feed request was successful and the description should be success
   * When testing sometimes the description was null even when the request was a success reason why the method below was created
   */
  private void setResponseDescription(HpdFeedResponse hpdFeedResponse, LDAPResult result) {
    int responseCode = result.getResultCode().getCode();
    LDAPResultCode responseDescription = result.getResultCode().getDescr();
    if (responseCode == 0 && Objects.isNull(responseDescription)) {
      hpdFeedResponse.setDescription("success");
    }
  }
}
