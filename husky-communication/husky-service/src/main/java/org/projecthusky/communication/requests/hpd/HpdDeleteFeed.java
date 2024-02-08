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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DelRequest;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DsmlMessage;

@Getter
@AllArgsConstructor
@ToString
@Slf4j
public class HpdDeleteFeed extends HpdRequest {
  @Override
  public DsmlMessage build() {
    DelRequest delRequest = new DelRequest();
    delRequest.setDn(getDistinguishedName());

    return delRequest;
  }
}
