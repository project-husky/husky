/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent;
import org.openehealth.ipf.commons.ihe.hl7v3.core.responses.PixV3QueryResponse;
import org.projecthusky.communication.mpi.impl.PdqV3Query;
import org.projecthusky.communication.mpi.impl.PixPdqV3QueryBase;
import org.projecthusky.communication.responses.pdq.PdqSearchQueryResponse;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.fhir.structures.gen.FhirPatient;

import net.ihe.gazelle.hl7v3.coctmt030007UV.COCTMT030007UVPerson;
import net.ihe.gazelle.hl7v3.coctmt150003UV03.COCTMT150003UV03ContactParty;
import net.ihe.gazelle.hl7v3.datatypes.AD;
import net.ihe.gazelle.hl7v3.datatypes.AdxpStreetAddressLine;
import net.ihe.gazelle.hl7v3.datatypes.CE;
import net.ihe.gazelle.hl7v3.datatypes.EN;
import net.ihe.gazelle.hl7v3.datatypes.EnFamily;
import net.ihe.gazelle.hl7v3.datatypes.EnGiven;
import net.ihe.gazelle.hl7v3.datatypes.EnPrefix;
import net.ihe.gazelle.hl7v3.datatypes.EnSuffix;
import net.ihe.gazelle.hl7v3.datatypes.II;
import net.ihe.gazelle.hl7v3.datatypes.ON;
import net.ihe.gazelle.hl7v3.datatypes.PN;
import net.ihe.gazelle.hl7v3.datatypes.TEL;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02BirthPlace;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02PersonalRelationship;
import net.ihe.gazelle.hl7v3.voc.HomeAddressUse;
import net.ihe.gazelle.hl7v3.voc.WorkPlaceAddressUse;

/**
 * A util class designed specifically to extract a list of {@link FhirPatient}s from a {@link PdqSearchQueryResponse}.<br!>
 * Most code was copied over from {@link PdqV3Query} and {@link PixPdqV3QueryBase}.
 *
 * @author szalai
 */
public class PdqUtils {

  public static String getPatientDomainId(PixV3QueryResponse v3PixConsumerResponse, String rootOid) {
    String retVal = null;
    if ((rootOid != null) && (v3PixConsumerResponse != null) && ((!v3PixConsumerResponse.getPatientIds().isEmpty())
        || (!v3PixConsumerResponse.getAsOtherIDs().isEmpty()))) {

      for (var i = 0; i < v3PixConsumerResponse.getPatientIds().size(); i++) {
        final II id = v3PixConsumerResponse.getPatientIds().get(i);
        if (id != null && id.getRoot() != null && id.getRoot().equals(rootOid)) {
          retVal = id.getExtension();
        }
      }
      if (retVal == null) {
        retVal = getIdFromOthers(v3PixConsumerResponse, rootOid);
      }
    }
    return retVal;
  }

  private static String getIdFromOthers(PixV3QueryResponse v3PixConsumerResponse, String rootOid) {
    for (var i = 0; i < v3PixConsumerResponse.getAsOtherIDs().size(); i++) {
      final II id = v3PixConsumerResponse.getAsOtherIDs().get(i).getId().get(0);
      if (id != null && id.getRoot() != null && id.getRoot().equals(rootOid)) {
        return id.getExtension();
      }
    }
    return null;
  }

  public static List<FhirPatient> getPatientsFromSearchQueryResponse(PdqSearchQueryResponse response) {
    var success = false;
    if (response != null) {
      success = !response.hasError();
      if (success) {
        final List<FhirPatient> listFhirPatients = new ArrayList<>(response.getNumRecordsCurrent());
        for (var i = 0; i < response.getNumRecordsCurrent(); ++i) {
          final var fhirPatient = new FhirPatient();
          addDemographicData(getPatientByIndex(response, i), fhirPatient);
          listFhirPatients.add(fhirPatient);
        }
        return listFhirPatients;
      }
    }
    return new LinkedList<>();
  }

  private static PRPAMT201310UV02Patient getPatientByIndex(PdqSearchQueryResponse v3PdqConsumerResponse,
      int patientIndex) {
    return v3PdqConsumerResponse.getPdqResponse().getControlActProcess().getSubject().get(patientIndex)
        .getRegistrationEvent().getSubject1().getPatient();
  }

  private static void addDemographicData(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if (pdqPatient == null) {
      return;
    }
    setScopingOrganization(pdqPatient, patient);
    addPatientIds(pdqPatient, patient);
    addPatientName(pdqPatient, patient);
    setPatientBirthTime(pdqPatient, patient);
    setPatientGender(pdqPatient, patient);
    addPatientAddresses(pdqPatient, patient);
    addPatientTelecoms(pdqPatient, patient);
    addLanguageCommunications(pdqPatient, patient);
    setPatientMaritalStatus(pdqPatient, patient);
    setDeceased(pdqPatient, patient);
    setMultipeBirth(pdqPatient, patient);
    setPatientMothersMaidenName(pdqPatient, patient);
    setBirthPlace(pdqPatient, patient);
    setPatientReligiousAffiliation(pdqPatient, patient);
    setNation(pdqPatient, patient);
    setEmployee(pdqPatient, patient);
  }

  /**
   * Sets the scoping organization from the pdq message to the patient.
   *
   * @param pdqPatient the pdq patient
   * @param patient    the patient
   */
  private static void setScopingOrganization(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if (pdqPatient.getProviderOrganization() != null) {
      final var organization = new Organization();
      patient.getManagingOrganization().setResource(organization);

      if ((pdqPatient.getProviderOrganization().getId() != null)
          && (!pdqPatient.getProviderOrganization().getId().isEmpty())) {
        for (final II id : pdqPatient.getProviderOrganization().getId()) {
          if (id != null && id.getRoot() != null) {
            final var identifier = new Identifier();
            identifier.setValue(FhirCommon.addUrnOid(id.getRoot()));
            organization.getIdentifier().add(identifier);
          }
        }
      }

      final List<ON> ons = pdqPatient.getProviderOrganization().getName();
      if ((ons != null) && (!ons.isEmpty())) {
        organization.setName(getMixedValue(ons.get(0).getMixed()));
      }

      organization.getTelecom()
          .addAll(getContactPointsFromContactParties(pdqPatient.getProviderOrganization().getContactParty()));
    }
  }

  private static void addPatientIds(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if (pdqPatient.getId() != null) {
      for (final II patientId : pdqPatient.getId()) {
        final var identifier = new Identifier();
        identifier.setSystem(FhirCommon.addUrnOid(patientId.getRoot()));
        identifier.setValue(patientId.getExtension());
        patient.getIdentifier().add(identifier);
      }
    }

    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getAsOtherIDs() != null)) {
      for (final var asOtherId : pdqPatient.getPatientPerson().getAsOtherIDs()) {
        if ((asOtherId.getId() != null) && (!asOtherId.getId().isEmpty())) {
          final II patientId = asOtherId.getId().get(0);
          if (patientId != null) {
            final var identifier = new Identifier();
            identifier.setSystem(FhirCommon.addUrnOid(patientId.getRoot()));
            identifier.setValue(patientId.getExtension());
            patient.getIdentifier().add(identifier);
          }
        }
      }
    }
  }

  private static List<ContactPoint> getContactPointsFromContactParties(
      List<COCTMT150003UV03ContactParty> contactParties) {
    List<ContactPoint> telecoms = new LinkedList<>();
    if ((contactParties != null) && (!contactParties.isEmpty())) {
      final List<TEL> tels = contactParties.get(0).getTelecom();
      if ((tels != null) && (!tels.isEmpty())) {
        final var tel = tels.get(0);
        if ((tel.getValue() != null) && tel.getValue().startsWith("tel:")) {
          final var contactPoint = new ContactPoint();
          contactPoint.setValue(tel.getValue().substring(4));
          contactPoint.setSystem(ContactPointSystem.PHONE);
          telecoms.add(contactPoint);
        }
      }
    }
    return telecoms;
  }

  private static void addPatientName(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    final List<PN> pns = pdqPatient.getPatientPerson().getName();
    for (var i = 0; i < pns.size(); ++i) {
      final var pn = pns.get(i);
      patient.getName().add(createHumanName(pn));
    }
  }

  private static HumanName createHumanName(EN en) {
    final var humanNameType = new HumanName();
    if (en.getGiven() != null) {
      for (final EnGiven given : en.getGiven()) {
        humanNameType.addGiven(getMixedValue(given.getMixed()));
      }
    }
    if (en.getFamily() != null) {
      for (final EnFamily family : en.getFamily()) {
        humanNameType.setFamily(getMixedValue(family.getMixed()));
      }
    }
    if (en.getPrefix() != null) {
      for (final EnPrefix prefix : en.getPrefix()) {
        humanNameType.addPrefix(getMixedValue(prefix.getMixed()));
      }
    }
    if (en.getSuffix() != null) {
      for (final EnSuffix suffix : en.getSuffix()) {
        humanNameType.addPrefix(getMixedValue(suffix.getMixed()));
      }
    }

    return humanNameType;
  }

  private static String getMixedValue(List<Serializable> mixed) {
    var returnValue = "";
    // if we have a mixed
    if (!mixed.isEmpty() && mixed.get(0) instanceof String mixedStr) {
      returnValue = mixedStr;
    }
    return returnValue;
  }

  private static void setPatientBirthTime(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getBirthTime() != null)) {
      final var ts = pdqPatient.getPatientPerson().getBirthTime();
      final String date = ts.getValue();
      if ((date != null) && (date.length() >= 4)) {
        var dateFhir = date.substring(0, 4);
        if (date.length() >= 6) {
          dateFhir += "-" + date.substring(4, 6);
        }
        if (date.length() >= 8) {
          dateFhir += "-" + date.substring(6, 8);
        }
        patient.getBirthDateElement().setValueAsString(dateFhir);
      }
    }

  }

  private static void setPatientGender(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null)
        && (pdqPatient.getPatientPerson().getAdministrativeGenderCode() != null)) {
      final CE gender = pdqPatient.getPatientPerson().getAdministrativeGenderCode();
      if ("M".equals(gender.getCode())) {
        patient.setGender(AdministrativeGender.MALE);
      } else if ("F".equals(gender.getCode())) {
        patient.setGender(AdministrativeGender.FEMALE);
      } else if ("U".equals(gender.getCode())) {
        patient.setGender(AdministrativeGender.OTHER);
      }
    }
  }

  private static void addPatientAddresses(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getAddr() != null)) {
      for (final AD ad : pdqPatient.getPatientPerson().getAddr()) {
        patient.getAddress().add(getAddressFromAD(ad));
      }
    }
  }

  private static org.hl7.fhir.r4.model.Address getAddressFromAD(AD ad) {
    final var address = new org.hl7.fhir.r4.model.Address();
    if (ad.getUse() != null) {
      address.setUse(getAddressUse(ad.getUse()));
    }
    if ((ad.getStreetAddressLine() != null) && (!ad.getStreetAddressLine().isEmpty())) {
      for (final AdxpStreetAddressLine addressStreetLine : ad.getStreetAddressLine()) {
        address.addLine(getMixedValue(addressStreetLine.getMixed()));
      }
    }
    if ((ad.getCity() != null) && (!ad.getCity().isEmpty())) {
      address.setCity(getMixedValue(ad.getCity().get(0).getMixed()));
    }
    if ((ad.getState() != null) && (!ad.getState().isEmpty())) {
      address.setState(getMixedValue(ad.getState().get(0).getMixed()));
    }
    if ((ad.getPostalCode() != null) && (!ad.getPostalCode().isEmpty())) {
      address.setPostalCode(getMixedValue(ad.getPostalCode().get(0).getMixed()));
    }
    if ((ad.getCountry() != null) && (!ad.getCountry().isEmpty())) {
      address.setCountry(getMixedValue(ad.getCountry().get(0).getMixed()));
    }
    return address;
  }

  private static AddressUse getAddressUse(String use) {
    if ("H".equals(use)) {
      return AddressUse.HOME;
    }
    if ("WP".equals(use)) {
      return AddressUse.WORK;
    }
    if ("TMP".equals(use)) {
      return AddressUse.TEMP;
    }
    if ("OLD".equals(use)) {
      return AddressUse.OLD;
    }

    return null;
  }

  private static void addPatientTelecoms(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getTelecom() != null)
        && (!pdqPatient.getPatientPerson().getTelecom().isEmpty())) {
      for (final TEL tel : pdqPatient.getPatientPerson().getTelecom()) {
        final var contactPoint = new ContactPoint();
        if ((tel.getValue() != null) && tel.getValue().startsWith("tel:")) {
          contactPoint.setValue(tel.getValue().substring(4));
          contactPoint.setSystem(ContactPointSystem.PHONE);
          contactPoint.setUse(getContactPointUse(tel.getUse()));
          patient.getTelecom().add(contactPoint);
        }
        if ((tel.getValue() != null) && tel.getValue().startsWith("mailto:")) {
          contactPoint.setValue(tel.getValue().substring(7));
          contactPoint.setSystem(ContactPointSystem.EMAIL);
          contactPoint.setUse(getContactPointUse(tel.getUse()));
          patient.getTelecom().add(contactPoint);
        }
      }
    }
  }

  private static ContactPointUse getContactPointUse(String use) {
    if (use.contains(WorkPlaceAddressUse.WP.value())) {
      return ContactPointUse.WORK;
    } else if (use.contains(HomeAddressUse.H.value()) || use.contains(HomeAddressUse.HP.value())) {
      return ContactPointUse.HOME;
    } else if ((!use.isEmpty()) && "MC".equals(use)) {
      return ContactPointUse.MOBILE;
    }

    return null;
  }

  private static void addLanguageCommunications(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null)
        && (pdqPatient.getPatientPerson().getLanguageCommunication() != null)) {
      for (final PRPAMT201310UV02LanguageCommunication languageCommunication : pdqPatient.getPatientPerson()
          .getLanguageCommunication()) {
        if ((languageCommunication.getLanguageCode() != null)
            && (languageCommunication.getLanguageCode().getCode() != null)) {
          final var communication = new PatientCommunicationComponent();
          final var language = new CodeableConcept();
          language.setText(languageCommunication.getLanguageCode().getCode());
          communication.setLanguage(language);
          patient.getCommunication().add(communication);

        }
      }
    }
  }

  private static void setPatientMaritalStatus(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getMaritalStatusCode() != null)) {
      final CE maritalStatusCode = pdqPatient.getPatientPerson().getMaritalStatusCode();
      if (maritalStatusCode.getCode() != null) {
        final var maritalStatus = new CodeableConcept();
        maritalStatus.setText(maritalStatusCode.getCode());
        patient.setMaritalStatus(maritalStatus);
      }
    }
  }

  private static void setDeceased(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if (pdqPatient.getPatientPerson() != null) {
      if (pdqPatient.getPatientPerson().getDeceasedInd() != null
          && pdqPatient.getPatientPerson().getDeceasedInd().value != null
          && pdqPatient.getPatientPerson().getDeceasedInd().value.booleanValue()) {
        final var dt = new BooleanType();
        dt.setValue(pdqPatient.getPatientPerson().getDeceasedInd().value);
        patient.setDeceased(dt);
      }
      if (pdqPatient.getPatientPerson().getDeceasedTime() != null) {
        patient.setDeceased(DateTimeType.parseV3(pdqPatient.getPatientPerson().getDeceasedTime().getValue()));
      }
    }
  }

  private static void setMultipeBirth(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if (pdqPatient.getPatientPerson() != null) {
      if ((pdqPatient.getPatientPerson().getMultipleBirthInd() != null)
          && pdqPatient.getPatientPerson().getMultipleBirthInd().value != null
          && pdqPatient.getPatientPerson().getMultipleBirthInd().value.booleanValue()) {
        final var dt = new BooleanType();
        dt.setValue(pdqPatient.getPatientPerson().getMultipleBirthInd().value);
        patient.setMultipleBirth(dt);
      }
      if (pdqPatient.getPatientPerson().getMultipleBirthOrderNumber() != null) {
        final Integer birthOrderNumber = pdqPatient.getPatientPerson().getMultipleBirthOrderNumber().getValue();
        patient.setMultipleBirth(new IntegerType(birthOrderNumber.intValue()));
      }
    }
  }

  private static void setPatientMothersMaidenName(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null)
        && (pdqPatient.getPatientPerson().getPersonalRelationship() != null)) {
      for (final PRPAMT201310UV02PersonalRelationship personalRelationship : pdqPatient.getPatientPerson()
          .getPersonalRelationship()) {
        if ((personalRelationship.getCode() != null) && "MTH".equals(personalRelationship.getCode().getCode())
            && "2.16.840.1.113883.5.111".equals(personalRelationship.getCode().getCodeSystem())) {
          patient.setMothersMaidenName(getMothersMaidenName(personalRelationship));
        }
      }
    }
  }

  private static HumanName getMothersMaidenName(PRPAMT201310UV02PersonalRelationship personalRelationship) {
    final COCTMT030007UVPerson motherRelationShipHolder = personalRelationship.getRelationshipHolder1();
    if ((motherRelationShipHolder != null) && (motherRelationShipHolder.getName() != null)) {
      final List<EN> names = motherRelationShipHolder.getName();
      if ((names != null) && (!names.isEmpty())) {
        // ITI 2b Rev. 11.0 Final Text – 2014-09-23
        // MothersMaidenName Parameter (approx 6645)
        // This optional parameter specifies the maiden name
        // of the mother of the person whose
        // information is being queried. For this parameter
        // item, a single person name (PN) data item shall
        // be specified in the Person.value attribute.
        return createHumanName(names.get(0));
      }
    }
    return null;
  }

  private static void setBirthPlace(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getBirthPlace() != null)) {
      final PRPAMT201310UV02BirthPlace birthplace = pdqPatient.getPatientPerson().getBirthPlace();
      final var addr = birthplace.getAddr();
      if (addr != null) {
        patient.setBirthPlace(getAddressFromAD(addr));
      }
    }
  }

  private static void setPatientReligiousAffiliation(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null)
        && (pdqPatient.getPatientPerson().getReligiousAffiliationCode() != null)) {
      final CE religiousAffiliation = pdqPatient.getPatientPerson().getReligiousAffiliationCode();
      if (religiousAffiliation.getCode() != null) {
        final var religion = new CodeableConcept();
        religion.setText(religiousAffiliation.getCode());
        patient.setReligiousAffiliation(religion);
      }
    }
  }

  private static void setNation(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient.getPatientPerson() != null) && (pdqPatient.getPatientPerson().getAsCitizen() != null)) {
      final List<PRPAMT201310UV02Citizen> citizens = pdqPatient.getPatientPerson().getAsCitizen();
      if (!citizens.isEmpty()) {
        final PRPAMT201310UV02Nation nation = citizens.get(0).getPoliticalNation();
        if ((nation != null) && (nation.getCode() != null) && (nation.getCode().getCode() != null)) {
          final var nationCode = new CodeableConcept();
          nationCode.setText(nation.getCode().getCode());
          patient.setNation(nationCode);
        }
      }
    }
  }

  private static void setEmployee(PRPAMT201310UV02Patient pdqPatient, FhirPatient patient) {
    if ((pdqPatient != null) && (pdqPatient.getPatientPerson() != null)
        && (pdqPatient.getPatientPerson().getAsEmployee() != null)) {
      final List<PRPAMT201310UV02Employee> employees = pdqPatient.getPatientPerson().getAsEmployee();
      if (!employees.isEmpty()) {
        final PRPAMT201310UV02Employee employee = employees.get(0);
        if ((employee.getOccupationCode() != null) && (employee.getOccupationCode().getCode() != null)) {
          final var employeeOccupationCode = new CodeableConcept();
          employeeOccupationCode.setText(employee.getOccupationCode().getCode());
          patient.setEmployeeOccupation(employeeOccupationCode);
        }
      }
    }
  }
}
