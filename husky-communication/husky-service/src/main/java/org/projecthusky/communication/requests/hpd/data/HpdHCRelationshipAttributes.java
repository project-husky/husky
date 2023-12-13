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
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AddRequest;
import org.projecthusky.communication.enums.HpdAttributeName;
import org.projecthusky.communication.utils.HpdUtils;

/**
 * Class used for creating the HDP Relationship Attributes
 *
 * Refer to the following documentation for a detailed description of the mandatory fields
 * <a href="https://www.ihe.net/uploadedFiles/Documents/ITI/IHE_ITI_Suppl_HPD.pdf"></a>
 * <a href="https://www.fedlex.admin.ch/filestore/fedlex.data.admin.ch/eli/oce/2022/39/de/pdf-a/fedlex-data-admin-ch-eli-oce-2022-39-de-pdf-a.pdf></a>
 *
 */
@Getter
@ToString
@Slf4j
public class HpdHCRelationshipAttributes extends HpdEntity {
  private final String commonName;
  private final String owner;

  public HpdHCRelationshipAttributes(String owner, String commonName, String dn, List<String> objectClass,
      Map<HpdAttributeName, List<String>> optionalAttributes) {
    super(dn, objectClass, optionalAttributes);
    this.commonName = commonName;
    this.owner = owner;
  }

  @Override
  public AddRequest createAddRequest() {
    AddRequest addRequest = new AddRequest();
    addRequest.setDn(getDistinguishedName());

    HpdUtils.addHpdAttribute(addRequest, HpdAttributeName.COMMON_NAME, commonName);
    HpdUtils.addHpdAttribute(addRequest, HpdAttributeName.OWNER, owner);
    HpdUtils.addHpdAttributes(addRequest, HpdAttributeName.OBJECT_CLASS, getObjectClass());

    HpdUtils.setOptionalAttributes(addRequest, getOptionalAttributes());

    return addRequest;
  }

  @Override
  public boolean isValid() {
    boolean isValid = true;

    if (Objects.isNull(getDistinguishedName())) {
      log.error("Distinguished name must not be null!");
      isValid = false;
    }

    if (Objects.isNull(getObjectClass())) {
      log.error("Object class must not be null!");
      isValid = false;
    }

    if (getObjectClass().size() < 2)  {
      log.error("Object class must contain at least 2 elements!");
      isValid = false;
    }

    if (Objects.isNull(commonName)) {
      log.error("Common name must not be null!");
      isValid = false;
    }

    if (Objects.isNull(owner)) {
      log.error("Owner must not be null!");
      isValid = false;
    }
    return isValid;
  }
}