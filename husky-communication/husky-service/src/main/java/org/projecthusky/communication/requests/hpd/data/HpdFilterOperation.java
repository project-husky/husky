/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.hpd.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class HpdFilterOperation {
  private final boolean isNegated;
  private final HpdOperationParameters operation;
  private final OperationType operationType;

  @Getter
  public enum OperationType {
    APPROX_MATCH("approxMatch"),
    EQUALITY_MATCH("equalityMatch"),
    EXTENSIBLE_MATCH("extensibleMatch"),
    GREATER_OR_EQUAL("greaterOrEqual"),
    LESS_OR_EQUAL("lessOrEqual"),
    PRESENT("present"),
    SUBSTRINGS("substrings");

    private final String value;

    OperationType(String value) {
      this.value = value;
    }
  }
}
