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

import lombok.Getter;
import lombok.ToString;
import org.projecthusky.communication.enums.HpdAttributeName;

@Getter
@ToString
public abstract class HpdCommonParameter implements HpdOperationParameters {
  /**
   * Common field for all subclasses
   * {@link HpdSimpleParameters }
   * {@link HpdAttributePresentParameters }
   * {@link HpdExtensibleMatchParameters }
   * {@link HpdSubstringParameters }
   */
  private final String name;

  public HpdCommonParameter(String name) {
    this.name = name;
  }

  public HpdCommonParameter(HpdAttributeName attributeName) {
    this.name = attributeName.getName();
  }
}