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

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AddRequest;
import org.projecthusky.communication.enums.HpdAttributeName;
import org.projecthusky.communication.utils.HpdUtils;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public abstract class HpdEntity {
  /** Common attributes used by all child classes */
  private String distinguishedName;
  private String uid;
  private List<String> hcIdentifier;
  private List<String> objectClass;
  /** Used for enhancing the search, can be null or empty */
  private Map<HpdAttributeName, List<String>> optionalAttributes;

  public HpdEntity(String dn, List<String> objectClass, Map<HpdAttributeName, List<String>> optionalAttributes) {
    this.distinguishedName = dn;
    this.objectClass = objectClass;
    this.optionalAttributes = optionalAttributes;
  }

  /**
   * Abstract method implemented by all child classes which returns an instance of the
   * {@link AddRequest} XMLType
   *
   */
  public abstract AddRequest createAddRequest();

  /**
   * Abstract method implemented by all child classes used for validating mandatory constraints
   */
  public boolean isValid() {
    if (HpdUtils.hasNullOrBlank(distinguishedName, uid, objectClass, hcIdentifier)
        || hcIdentifier.isEmpty()
        || objectClass.size() < 2) {
      log.error("Mandatory validation constraints have not been fulfilled!");
      return false;
    }
    return true;
  }
}