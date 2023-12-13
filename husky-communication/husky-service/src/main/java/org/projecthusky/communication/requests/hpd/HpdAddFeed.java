/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.hpd;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DsmlMessage;
import org.projecthusky.communication.requests.hpd.data.HpdHCProfessional;
import org.projecthusky.communication.requests.hpd.data.HpdHCRegulatedOrganization;
import org.projecthusky.communication.requests.hpd.data.HpdHCRelationshipAttributes;
import org.projecthusky.communication.requests.hpd.data.HpdEntity;
import org.projecthusky.communication.enums.HpdAttributeName;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class HpdAddFeed extends HpdRequest {
  /**
   * Refer to the following documentation
   * <a href="https://www.ihe.net/uploadedFiles/Documents/ITI/IHE_ITI_Suppl_HPD.pdf"></a>
   * <a href="https://www.fedlex.admin.ch/filestore/fedlex.data.admin.ch/eli/oce/2022/39/de/pdf-a/fedlex-data-admin-ch-eli-oce-2022-39-de-pdf-a.pdf></a>
   * for a detailed description of the mandatory fields
   */
  private HpdEntity hpdEntity;

  /**
   * Responsible for filling the HPD Individual Provider Attributes
   *
   * @param dn                   Distinguished Name of the Provider Entry to be created
   * @param uid                  Unique Entry Identifier
   * @param hcIdentifier         Provider Identifiers
   * @param objectClass          The documentation above contains details about what objectClass is
   * @param optionalAttributes   Optional Provider Attributes
   * @param cn                   Provider Known Names
   * @param sn                   Provider Last Name
   * @param givenName            Provider First Name
   * @param hcProfession         Provider Type
   * @param displayName          Provider Primary Name
   * @param hcRegistrationStatus Only valid value is "Unknown" (case-insensitive)
   */
  public void createHCProfessional(String dn, String uid, List<String> hcIdentifier,
      List<String> objectClass, Map<HpdAttributeName, List<String>> optionalAttributes, List<String> cn, String sn,
      String givenName, List<String> hcProfession, String displayName, List<String> hcRegistrationStatus) {
    hpdEntity = new HpdHCProfessional(dn, uid, hcIdentifier, objectClass, optionalAttributes, cn, sn, givenName,
        hcProfession, displayName, hcRegistrationStatus);
  }

  /**
   * Responsible for filling the HPD Organizational Provider Attributes
   *
   * @param dn                 Distinguished Name of the Provider Entry to be created
   * @param uid                Unique Entity Identifier
   * @param hcIdentifier       Org Identifiers
   * @param objectClass        The documentation above contains details about what objectClass is
   * @param optionalAttributes Optional Org Attributes
   * @param businessCategory   Org Type
   * @param hcRegisteredName   Organization Name
   * @param organizations      Organization Known Names
   */
  public void createHCRegulatedOrganization(String dn, String uid, List<String> hcIdentifier,
      List<String> objectClass, Map<HpdAttributeName, List<String>> optionalAttributes, List<String> businessCategory,
      List<String> hcRegisteredName, List<String> organizations) {
    hpdEntity = new HpdHCRegulatedOrganization(dn, uid, hcIdentifier, objectClass, optionalAttributes, businessCategory,
        hcRegisteredName, organizations);
  }

  /**
   * Responsible for filling the HPD Relationship Attributes
   *
   * @param owner              Owning Organization
   * @param commonName         Relationship Name
   * @param dn                 Distinguished Name of the Provider Entry to be created
   * @param objectClass        The documentation above contains details about what objectClass is
   * @param optionalAttributes Optional Relationship Attributes
   */
  public void createHCRelationshipAttributes(String owner, String commonName, String dn,
      List<String> objectClass, Map<HpdAttributeName, List<String>> optionalAttributes) {
    hpdEntity = new HpdHCRelationshipAttributes(owner, commonName, dn, objectClass, optionalAttributes);
  }

  @Override
  public DsmlMessage build() {
    return hpdEntity.createAddRequest();
  }

  @Override
  public boolean isValid() {
    return Optional.ofNullable(hpdEntity)
        .map(HpdEntity::isValid)
        .orElse(false);
  }
}