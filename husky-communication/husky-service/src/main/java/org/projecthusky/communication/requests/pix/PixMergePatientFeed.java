/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.requests.pix;

import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.mpi.impl.pix.V3PixSourceMessageHelper;
import org.projecthusky.communication.utils.ConverterUtil;
import org.projecthusky.communication.utils.PixPdqV3Utils;
import org.projecthusky.fhir.structures.gen.FhirCommon;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Person;

/**
 * This class is designed to collect the parameters of the merge patient service call at high level and transform them
 * into the request object, that is sent to the service.
 *
 * @author szalai
 */
@Builder
@Getter
@ToString
public class PixMergePatientFeed {

  @NonNull
  private Destination destination;
  /** Use providingOrganization instead */
  @Deprecated
  private Organization scopingOrganization;
  private Organization providerOrganization;
  @NonNull
  private String obsolatePatientID;
  @NonNull
  private String homeCommunityOID;
  @NonNull
  private String homeCommunityNamespace;
  @Singular
  private List<Identifier> identifiers;
  @Singular
  private List<Identifier> nonMedicalIdentifiers; //The "otherOIDs" feature from PixPdqQuery
  private HumanName patientName;
  private Date birthday;
  private AdministrativeGender gender;
  private HumanName mothersMaidenName;
  @Singular
  private List<Address> addresses;
  private CodeableConcept nation;
  private CodeableConcept religion;
  private CodeableConcept maritalStatus;
  @Singular
  private List<CodeableConcept> languages;
  @Singular
  private List<ContactPoint> telecomContacts;
  private CodeableConcept employeeOccupation;
  
  public static class PixMergePatientFeedBuilder {}

  public PixMergePatientRequest build() {
    PixMergePatientRequest request = new PixMergePatientRequest(this.destination.getSenderApplicationOid(), null,
        this.destination.getReceiverApplicationOid(), null);
    addIdentifiers(request);
    addNonMedicalIdentifiers(request);
    addObsolatePatientId(request);
    addPatientName(request);
    addPatientBirthday(request);
    addPatientGender(request);
    addPatientsMothersMaidenName(request);
    addAddresses(request);
    addNation(request);
    addReligion(request);
    addMaritalStatus(request);
    addLanguages(request);
    addTelecomContacts(request);
    addProviderOrganization(request);
    addEmployeeOccupation(request);
    return request;
  }

  private void addObsolatePatientId(PixMergePatientRequest request) {
    request.setObsoletePatientID(obsolatePatientID, homeCommunityOID, homeCommunityNamespace);
  }

  private void addEmployeeOccupation(PixMergePatientRequest request) {
    PRPAIN201304UV02Type rootElement = request.getRootElement();
    PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    if (this.employeeOccupation != null) {
      var employee = new PRPAMT201303UV02Employee();
      employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupation.getText()));
      patientPerson.getAsEmployee().add(employee);
    }
  }

  private void addProviderOrganization(PixMergePatientRequest request) {
    if (providerOrganization == null && scopingOrganization != null) {
      providerOrganization = scopingOrganization;
    }

    if (providerOrganization != null) {
      String organizationName = "";
      String telecomValue = "NOTPROVIDED";
      
      if (providerOrganization.getName() != null) {
        organizationName = providerOrganization.getName();
      }

      if (providerOrganization.getTelecom() != null && !providerOrganization.getTelecom().isEmpty()) {
        var contactPoint = providerOrganization.getTelecomFirstRep();
        if (contactPoint != null) {
          telecomValue = contactPoint.getValue();
        }
      }
      request.setProviderOrganization(providerOrganization.getIdentifier(), organizationName, telecomValue);
    }
  }

  private void addTelecomContacts(PixMergePatientRequest request) {
    PRPAIN201304UV02Type rootElement = request.getRootElement();
    PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    for (ContactPoint contactPoint : this.telecomContacts) {
      patientPerson.getTelecom().add(V3PixSourceMessageHelper.createTEL(ConverterUtil.getTelecomValue(contactPoint),
          ConverterUtil.getTelecomAddressUse(contactPoint)));
    }

  }

  private void addLanguages(PixMergePatientRequest request) {
    PRPAIN201304UV02Type rootElement = request.getRootElement();
    PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    for (CodeableConcept language : this.languages) {

      var communication = new PRPAMT201303UV02LanguageCommunication();
      communication.setLanguageCode(
          PixPdqV3Utils.createCE(new PatientCommunicationComponent().setLanguage(language).getLanguage().getText()));
      patientPerson.getLanguageCommunication().add(communication);
    }

  }

  private void addMaritalStatus(PixMergePatientRequest request) {
    if (this.maritalStatus != null) {
      request.setPatientMaritalStatus(maritalStatus.getCodingFirstRep().getCode());
    }
  }

  private void addReligion(PixMergePatientRequest request) {
    if (this.religion != null) {
      request.setPatientReligiousAffiliation(religion.getText());
    }
  }

  private void addNation(PixMergePatientRequest request) {
    if (this.nation != null) {
      PRPAIN201304UV02Type rootElement = request.getRootElement();
      PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0)
          .getRegistrationEvent()
          .getSubject1().getPatient().getPatientPerson();

      var citizenNation = new PRPAMT201303UV02Nation();
      citizenNation.setCode(PixPdqV3Utils.createCE(nation.getText()));
      var citizen = new PRPAMT201303UV02Citizen();
      citizen.setPoliticalNation(citizenNation);
      patientPerson.getAsCitizen().add(citizen);
    }

  }

  private void addAddresses(PixMergePatientRequest request) {
    for (Address address : this.addresses) {
      request.addPatientAddress(PixPdqV3Utils.createAd(address));
    }
  }

  private void addPatientsMothersMaidenName(PixMergePatientRequest request) {
    if (this.mothersMaidenName != null) {
      request.setPatientMothersMaidenName(mothersMaidenName.getFamily(), mothersMaidenName.getGivenAsSingleString(),
          null,
          mothersMaidenName.getPrefixAsSingleString(), mothersMaidenName.getSuffixAsSingleString());
    }
  }

  private void addPatientGender(PixMergePatientRequest request) {
    if (this.gender != null) {
      request.setPatientGender(ConverterUtil.convertAdministrativeGenderToSingleCharString(gender));
    }
  }

  private void addPatientBirthday(PixMergePatientRequest request) {
    if (this.birthday != null) {
      DateType birthdate = new DateType();
      birthdate.setValue(this.birthday);
      request.setPatientBirthTime(birthdate.getValueAsString().replace("-", ""));
    }
  }

  private void addPatientName(PixMergePatientRequest request) {
    if (this.patientName != null) {
      request.addPatientName(this.patientName.getFamily(), this.patientName.getGivenAsSingleString(), null,
          this.patientName.getPrefixAsSingleString(), this.patientName.getSuffixAsSingleString());
    }
  }

  private void addNonMedicalIdentifiers(PixMergePatientRequest request) {
    for (Identifier identifier : this.nonMedicalIdentifiers) {
      if ((identifier.getSystem().length() > 8)) {
        final String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
        request.addPatientOtherID(identifier.getValue(), oid);
      }
    }

  }

  private void addIdentifiers(PixMergePatientRequest request) {
    for (Identifier identifier : this.identifiers) {
      if ((identifier.getSystem().length() > 8)) {
        final String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
        if (this.homeCommunityOID != null && this.homeCommunityOID.equals(oid)) {
          request.addPatientID(identifier.getValue(), this.homeCommunityOID, this.homeCommunityNamespace);
        } else {
          request.addPatientID(identifier.getValue(), oid, "");
        }
      }
    }
  }

}
