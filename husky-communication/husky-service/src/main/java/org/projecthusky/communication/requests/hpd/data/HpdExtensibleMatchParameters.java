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
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.MatchingRuleAssertion;

/**
 * Class below is used to create the {@link MatchingRuleAssertion} XMLType
 * Class used for creating extensibleMatch OperationType
 */
@Getter
@ToString
public class HpdExtensibleMatchParameters extends HpdCommonParameter {
  private final String value;
  private final String matchingRule;
  private final boolean dnAttributes;

  public HpdExtensibleMatchParameters(String name, String value, String matchingRule, boolean dnAttributes) {
    super(name);
    this.value = value;
    this.matchingRule = matchingRule;
    this.dnAttributes = dnAttributes;
  }

  public MatchingRuleAssertion create() {
    MatchingRuleAssertion assertion = new MatchingRuleAssertion();
    assertion.setName(getName());
    assertion.setValue(value);
    assertion.setMatchingRule(matchingRule);
    assertion.setDnAttributes(dnAttributes);

    return assertion;
  }
}
