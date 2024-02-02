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
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AttributeValueAssertion;
import org.projecthusky.communication.enums.HpdAttributeName;

/**
 * Class used for creating  {@link AttributeValueAssertion } XMLType
 * Class used for creating 4 OperationTypes e.g. equalityMatch, approxMatch, greaterOrEqual, lessOrEqual all of which
 * have the same common fields (name and value)
 */
@Getter
@ToString
public class HpdSimpleParameters extends HpdCommonParameter {
  private final String value;

  public HpdSimpleParameters(String name, String value) {
    super(name);
    this.value = value;
  }

  public HpdSimpleParameters(HpdAttributeName attributeName, String value) {
    super(attributeName.getName());
    this.value = value;
  }

  public AttributeValueAssertion create() {
    AttributeValueAssertion assertion = new AttributeValueAssertion();
    assertion.setName(getName());
    assertion.setValue(value);

    return assertion;
  }
}
