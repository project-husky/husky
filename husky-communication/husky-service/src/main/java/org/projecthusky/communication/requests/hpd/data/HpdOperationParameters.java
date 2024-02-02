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

import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AttributeDescription;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AttributeValueAssertion;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.MatchingRuleAssertion;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SubstringFilter;
import org.projecthusky.communication.enums.HpdAttributeName;

public interface HpdOperationParameters {
  /**
   * Abstract method implemented by all child classes which returns an instance of the specific XMLType
   * {@link AttributeDescription}
   * {@link MatchingRuleAssertion}
   * {@link AttributeValueAssertion}
   * {@link SubstringFilter}
   */
  Object create();

  static HpdSimpleParameters createSimpleParameters(HpdAttributeName name, String value) {
    return new HpdSimpleParameters(name, value);
  }

  static HpdExtensibleMatchParameters createExtensibleMatchParameters(HpdAttributeName attributeName, String value,
      String matchingRule, boolean dnAttributes ) {
    return  new HpdExtensibleMatchParameters(attributeName.getName(), value, matchingRule, dnAttributes);
  }

  static HpdAttributePresentParameters createAttributePresentParameters(HpdAttributeName attributeName) {
    return new HpdAttributePresentParameters(attributeName.getName());
  }

  static HpdSubstringParameters createSubstringParameters(HpdAttributeName attributeName, String startsWith, String endsWith) {
    return new HpdSubstringParameters(attributeName.getName(), startsWith, endsWith);
  }
}
