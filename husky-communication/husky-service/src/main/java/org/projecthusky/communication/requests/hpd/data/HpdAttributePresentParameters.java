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
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AttributeDescription;

/**
 * The class is used to create the {@link AttributeDescription } XMLType
 * Class used for creating present OperationType
 */
@Getter
@ToString
public class HpdAttributePresentParameters extends HpdCommonParameter {

  public HpdAttributePresentParameters(String name) {
    super(name);
  }

  public AttributeDescription create() {
    AttributeDescription attribute = new AttributeDescription();
    attribute.setName(getName());

    return attribute;
  }
}
