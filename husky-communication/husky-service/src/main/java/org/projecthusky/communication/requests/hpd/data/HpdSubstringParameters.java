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
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SubstringFilter;

/**
 * Class below is used to create the {@link SubstringFilter } XMLType
 * Class used for creating substrings OperationType
 */
@Getter
@ToString
public class HpdSubstringParameters extends HpdCommonParameter {
  private final String startsWith;
  private final String endsWith;

  public HpdSubstringParameters(String name, String startsWith, String endsWith) {
    super(name);
    this.startsWith = startsWith;
    this.endsWith = endsWith;
  }

  @Override
  public SubstringFilter create() {
    SubstringFilter filter = new SubstringFilter();
    filter.setName(getName());
    filter.setInitial(startsWith);
    filter.setFinal(endsWith);

    return filter;
  }
}