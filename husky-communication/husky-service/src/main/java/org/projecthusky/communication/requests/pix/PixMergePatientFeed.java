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

  public static class PixMergePatientFeedBuilder {}

  @NonNull
  private Destination destination;
  /** Use providingOrganization instead */
  @Deprecated
  private Organization scopingOrganization;
  private Organization providerOrganization;
  @NonNull
  private String obsoletePatientID;
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

  public PixMergePatientRequest build() {
    PixMergePatientRequest request = new PixMergePatientRequest(destination.getSenderApplicationOid(), null,
        destination.getReceiverApplicationOid(), null);
    addIdentifiers(request);
    addNonMedicalIdentifiers(request);
    addObsoletePatientId(request);
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

  private void addAddresses(PixMergePatientRequest request) {
    for (Address address : addresses) {
      request.addPatientAddress(PixPdqV3Utils.createAd(address));
    }
  }

  private void addEmployeeOccupation(PixMergePatientRequest request) {
    PRPAIN201304UV02Type rootElement = request.getRootElement();
    PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    if (employeeOccupation != null) {
      var employee = new PRPAMT201303UV02Employee();
      employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupation.getText()));
      patientPerson.getAsEmployee().add(employee);
    }
  }

  private void addIdentifiers(PixMergePatientRequest request) {
    for (Identifier identifier : identifiers) {
      if ((identifier.getSystem().length() > 8)) {
        final String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
        if (homeCommunityOID != null && homeCommunityOID.equals(oid)) {
          request.addPatientID(identifier.getValue(), homeCommunityOID, homeCommunityNamespace);
        } else {
          request.addPatientID(identifier.getValue(), oid, "");
        }
      }
    }
  }

  private void addLanguages(PixMergePatientRequest request) {
    PRPAIN201304UV02Type rootElement = request.getRootElement();
    PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    for (CodeableConcept language : languages) {

      var communication = new PRPAMT201303UV02LanguageCommunication();
      communication.setLanguageCode(
          PixPdqV3Utils.createCE(new PatientCommunicationComponent().setLanguage(language).getLanguage().getText()));
      patientPerson.getLanguageCommunication().add(communication);
    }

  }

  private void addMaritalStatus(PixMergePatientRequest request) {
    if (maritalStatus != null) {
      request.setPatientMaritalStatus(maritalStatus.getCodingFirstRep().getCode());
    }
  }

  private void addNation(PixMergePatientRequest request) {
    if (nation != null) {
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

  private void addNonMedicalIdentifiers(PixMergePatientRequest request) {
    for (Identifier identifier : nonMedicalIdentifiers) {
      if ((identifier.getSystem().length() > 8)) {
        final String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
        request.addPatientOtherID(identifier.getValue(), oid);
      }
    }
  }

  private void addObsoletePatientId(PixMergePatientRequest request) {
    request.setObsoletePatientID(obsoletePatientID, homeCommunityOID, homeCommunityNamespace);
  }

  private void addPatientBirthday(PixMergePatientRequest request) {
    if (birthday != null) {
      DateType birthdate = new DateType();
      birthdate.setValue(birthday);
      request.setPatientBirthTime(birthdate.getValueAsString().replace("-", ""));
    }
  }

  private void addPatientGender(PixMergePatientRequest request) {
    if (gender != null) {
      request.setPatientGender(ConverterUtil.convertAdministrativeGenderToSingleCharString(gender));
    }
  }

  private void addPatientName(PixMergePatientRequest request) {
    if (patientName != null) {
      request.addPatientName(patientName.getFamily(), patientName.getGivenAsSingleString(), null,
          patientName.getPrefixAsSingleString(), patientName.getSuffixAsSingleString());
    }
  }

  private void addPatientsMothersMaidenName(PixMergePatientRequest request) {
    if (mothersMaidenName != null) {
      request.setPatientMothersMaidenName(mothersMaidenName.getFamily(), mothersMaidenName.getGivenAsSingleString(),
          null,
          mothersMaidenName.getPrefixAsSingleString(), mothersMaidenName.getSuffixAsSingleString());
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

  private void addReligion(PixMergePatientRequest request) {
    if (religion != null) {
      request.setPatientReligiousAffiliation(religion.getText());
    }
  }

  private void addTelecomContacts(PixMergePatientRequest request) {
    PRPAIN201304UV02Type rootElement = request.getRootElement();
    PRPAMT201303UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    for (ContactPoint contactPoint : telecomContacts) {
      patientPerson.getTelecom().add(V3PixSourceMessageHelper.createTEL(ConverterUtil.getTelecomValue(contactPoint),
          ConverterUtil.getTelecomAddressUse(contactPoint)));
    }
  }
}
