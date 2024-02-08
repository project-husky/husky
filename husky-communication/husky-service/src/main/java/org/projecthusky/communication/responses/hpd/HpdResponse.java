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

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class HpdResponse {
  /** Fields needed for creating the response from
   * {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AddRequest }
   * {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DelRequest }
   */
  private int responseCode;
  private String description;
  /** Field common to all Response type classes */
  private String requestId;
  /** Field needed for creating the response from {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest } */
  private Map<String, List<String>> attributes;

  /** Method implemented by all child classes for creating the specific response class */
  public abstract HpdResponse build(BatchResponse response);


}