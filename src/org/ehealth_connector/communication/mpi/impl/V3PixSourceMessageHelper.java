/*******************************************************************************
*
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
 * This code is are made available under the terms of the Eclipse Public License v1.0.
*
 * Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
 * Year of publication: 2015
*
 *******************************************************************************/
package org.ehealth_connector.communication.mpi.impl;

import org.eclipse.emf.common.util.Enumerator;
import org.hl7.v3.AD;
import org.hl7.v3.COCTMT710007UVPlace;
import org.hl7.v3.HomeAddressUse;
import org.hl7.v3.PRPAIN201301UV02Type;
import org.hl7.v3.PRPAIN201302UV02Type;
import org.hl7.v3.PRPAIN201304UV02Type;
import org.hl7.v3.PRPAMT201301UV02BirthPlace;
import org.hl7.v3.PRPAMT201301UV02LanguageCommunication;
import org.hl7.v3.PRPAMT201301UV02Person;
import org.hl7.v3.PRPAMT201302UV02BirthPlace;
import org.hl7.v3.PRPAMT201302UV02LanguageCommunication;
import org.hl7.v3.PRPAMT201302UV02PatientPatientPerson;
import org.hl7.v3.PRPAMT201303UV02BirthPlace;
import org.hl7.v3.PRPAMT201303UV02LanguageCommunication;
import org.hl7.v3.PRPAMT201303UV02Person;
import org.hl7.v3.TEL;
import org.hl7.v3.V3Factory;
import org.hl7.v3.WorkPlaceAddressUse;
import org.openhealthtools.ihe.common.hl7v3.client.PixPdqV3Utils;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceMergePatients;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceRecordAdded;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceRecordRevised;

/**
 * The Class V3PixSourceMessageHelper.
 * 
 * Simplifies the api to the three different PIX Source messages implementations and leaves the
 * possibility to get back to elements PatientRole for languageCommunication which are not implemented in
 * OHT V3 Message
 * 
 * @author oliveregger
 */
public class V3PixSourceMessageHelper {

  private V3PixSourceRecordAdded v3RecordAddedMessage;
  private V3PixSourceRecordRevised v3RecordRevisedMessage;
  private V3PixSourceMergePatients v3MergePatientsMessage;


  /**
   * Create a V3PixSourceMessageHelper with the supplied sender and receiver
   * 
   * @param senderApplicationOID
   * @param senderFacilityOID
   * @param receiverApplicationOID
   * @param receiverFacilityOID
   */
  public V3PixSourceMessageHelper(boolean addMessage, boolean revisedMessage, boolean mergeMessage,
      String senderApplicationOid, String senderFacilityOid, String receiverApplicationOid,
      String receiverFacilityOid) {
    if (addMessage) {
      v3RecordAddedMessage =
          new V3PixSourceRecordAdded(senderApplicationOid, senderFacilityOid,
              receiverApplicationOid, receiverFacilityOid);
    }
    if (revisedMessage) {
      v3RecordRevisedMessage =
          new V3PixSourceRecordRevised(senderApplicationOid, senderFacilityOid,
              receiverApplicationOid, receiverFacilityOid);
    }
    if (mergeMessage) {
      v3MergePatientsMessage =
          new V3PixSourceMergePatients(senderApplicationOid, senderFacilityOid,
              receiverApplicationOid, receiverFacilityOid);
    }
  }

  /**
   * Adds the language communication.
   * 
   * @param languageCommunication the language communication
   */
  public void addLanguageCommunication(String languageCommunication) {
    if (v3RecordAddedMessage != null) {
      PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
      PRPAMT201301UV02LanguageCommunication communication =
          V3Factory.eINSTANCE.createPRPAMT201301UV02LanguageCommunication();
      communication.setLanguageCode(PixPdqV3Utils.createCE(languageCommunication));
      patientPerson.getLanguageCommunication().add(communication);
    }
    if (v3RecordRevisedMessage != null) {
      PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(v3RecordRevisedMessage);
      PRPAMT201302UV02LanguageCommunication communication =
          V3Factory.eINSTANCE.createPRPAMT201302UV02LanguageCommunication();
      communication.setLanguageCode(PixPdqV3Utils.createCE(languageCommunication));
      patientPerson.getLanguageCommunication().add(communication);
    }
    if (v3MergePatientsMessage != null) {
      PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
      PRPAMT201303UV02LanguageCommunication communication =
          V3Factory.eINSTANCE.createPRPAMT201303UV02LanguageCommunication();
      communication.setLanguageCode(PixPdqV3Utils.createCE(languageCommunication));
      patientPerson.getLanguageCommunication().add(communication);
    }
  }

  /**
   * Adds the birth place
   * 
   * @param addressBirthPlace the new birth place address
   */
  public void setBirthPlace(AD addressBirthPlace) {
    if (v3RecordAddedMessage != null) {
      PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
      PRPAMT201301UV02BirthPlace birthplace =
          V3Factory.eINSTANCE.createPRPAMT201301UV02BirthPlace();
      COCTMT710007UVPlace place = V3Factory.eINSTANCE.createCOCTMT710007UVPlace();
      place.setAddr(addressBirthPlace);
      birthplace.setBirthplace(place);
      patientPerson.setBirthPlace(birthplace);
    }
    if (v3RecordRevisedMessage != null) {
      PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(v3RecordRevisedMessage);
      PRPAMT201302UV02BirthPlace birthplace =
          V3Factory.eINSTANCE.createPRPAMT201302UV02BirthPlace();
      COCTMT710007UVPlace place = V3Factory.eINSTANCE.createCOCTMT710007UVPlace();
      place.setAddr(addressBirthPlace);
      birthplace.setBirthplace(place);
      patientPerson.setBirthPlace(birthplace);
    }
    if (v3MergePatientsMessage != null) {
      PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
      PRPAMT201303UV02BirthPlace birthplace =
          V3Factory.eINSTANCE.createPRPAMT201303UV02BirthPlace();
      COCTMT710007UVPlace place = V3Factory.eINSTANCE.createCOCTMT710007UVPlace();
      place.setAddr(addressBirthPlace);
      birthplace.setBirthplace(place);
      patientPerson.setBirthPlace(birthplace);
    }
  }


  /**
   * Add an address for the patient.
   * 
   * @param addressStreetAddress
   * @param addressCity
   * @param addressCounty
   * @param addressState
   * @param addressCountry
   * @param addressZip
   * @param addressOtherDesignation
   * @param addressType
   */
  public void addPatientAddress(String addressStreetAddress, String addressCity,
      String addressCounty, String addressState, String addressCountry, String addressZip,
      String addressOtherDesignation, String addressType) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientAddress(addressStreetAddress, addressCity, addressCounty,
          addressState, addressCountry, addressZip, addressOtherDesignation, addressType);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientAddress(addressStreetAddress, addressCity, addressCounty,
          addressState, addressCountry, addressZip, addressOtherDesignation, addressType);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientAddress(addressStreetAddress, addressCity, addressCounty,
          addressState, addressCountry, addressZip, addressOtherDesignation, addressType);
    }
  }

  /**
   * Add a confidentiality code to the patient
   * 
   * @param code
   */
  public void addPatientConfidentialityCode(String code) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientConfidentialityCode(code);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientConfidentialityCode(code);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientConfidentialityCode(code);
    }
  }


  /**
   * Add Patient Ethnic Group Code to the patient
   * 
   * @param code  (SET<CE>) {CWE:Ethnicity}
   */
  public void addPatientEthnicGroupCode(String code) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientEthnicGroupCode(code);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientEthnicGroupCode(code);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientEthnicGroupCode(code);
    }
  }

  /**
   * Set the patient id
   * 
   * @param extension
   * @param root
   * @param namespace
   */
  public void addPatientID(String extension, String root, String namespace) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientID(extension, root, namespace);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientID(extension, root, namespace);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientID(extension, root, namespace);
    }
  }

  /**
   * Add a patient name.
   * 
   * @param familyName
   * @param givenName
   * @param otherName
   * @param prefixName
   * @param suffixName
   */
  public void addPatientName(String familyName, String givenName, String otherName,
      String prefixName, String suffixName) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientName(familyName, givenName, otherName, prefixName, suffixName);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientName(familyName, givenName, otherName, prefixName,
          suffixName);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientName(familyName, givenName, otherName, prefixName,
          suffixName);
    }
  }

  /**
   * Add a Patient Other ID for the patient
   * 
   * @param extension
   * @param root
   */
  public void addPatientOtherID(String extension, String root) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientOtherID(extension, root);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientOtherID(extension, root);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientOtherID(extension, root);
    }
  }

  /**
   * Add Patient Race Code to the patient
   * 
   * @param code (SET<CE>) {CWE:Race}
   */
  public void addPatientRaceCode(String code) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientRaceCode(code);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientRaceCode(code);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientRaceCode(code);
    }
  }

  /**
   * Create a TEL type object with the supplied telecom value and use value (if supplied)
   * we extend the type her also for the mobile, the standard PixPdqV3Utils.createTel has only WP and HP for usevalue
   * 
   * @param telecomValue (the phone, web, or e-mail address value)
   * @param useValue (original either "WP" for Work or "HP" for Home)
   * @return TEL type with the supplied telecom and use values.
   */
  public static TEL createTEL(String telecomValue, String useValue) {
      TEL returnTEL = V3Factory.eINSTANCE.createTEL();
      returnTEL.setValue(telecomValue);
      if (null != useValue)
      {
          if (useValue == "WP")
              returnTEL.setUse(PixPdqV3Utils.createEnumeratorList(WorkPlaceAddressUse.WP));
          else if(useValue == "HP")
              returnTEL.setUse(PixPdqV3Utils.createEnumeratorList(HomeAddressUse.HP));
          else if(useValue == "H")
            returnTEL.setUse(PixPdqV3Utils.createEnumeratorList(HomeAddressUse.H));
          else if(useValue == "MC") {
            returnTEL.setUse(PixPdqV3Utils.createEnumeratorList(new Enumerator() {

              @Override
              public String getLiteral() {
                return "MC";
              }

              @Override
              public String getName() {
                return "MC";
              }

              @Override
              public int getValue() {
                return 0;
              }
              
            }));
          }
      }
      return returnTEL;
  }

  /**
   * Add a telecom value with the provided useValue ("HP" or "WP" or "H" or "MC")
   * 
   * @param telecomValue
   * @param useValue
   */
  public void addPatientTelecom(String telecomValue, String useValue) {
    
    if (v3RecordAddedMessage != null) {
      PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
      patientPerson.getTelecom().add(createTEL(telecomValue, useValue));
    }
    if (v3RecordRevisedMessage != null) {
      PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(v3RecordRevisedMessage);
      patientPerson.getTelecom().add(createTEL(telecomValue, useValue));
    }
    if (v3MergePatientsMessage != null) {
      PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
      patientPerson.getTelecom().add(createTEL(telecomValue, useValue));
    }
  }

  /**
   * Gets the patient person.
   * 
   * @param v3MergePatientsMessage the v3 merge patients message
   * @return the patient person
   */
  private PRPAMT201303UV02Person getPatientPerson(V3PixSourceMergePatients v3MergePatientsMessage) {
    if (v3MergePatientsMessage != null) {
      PRPAIN201304UV02Type rootElement = v3MergePatientsMessage.getRootElement();
      return rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
          .getSubject1().getPatient().getPatientPerson();
    }
    return null;
  }

  /**
   * Gets the patient person.
   * 
   * @param v3RecordAddedMessage the v3 record added message
   * @return the patient person
   */
  private PRPAMT201301UV02Person getPatientPerson(V3PixSourceRecordAdded v3RecordAddedMessage) {
    if (v3RecordAddedMessage != null) {
      PRPAIN201301UV02Type rootElement = v3RecordAddedMessage.getRootElement();
      return rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
          .getSubject1().getPatient().getPatientPerson();
    }
    return null;
  }

  /**
   * Gets the patient person.
   * 
   * @param v3RecordRevisedMessage the v3 record revised message
   * @return the patient person
   */
  private PRPAMT201302UV02PatientPatientPerson getPatientPerson(
      V3PixSourceRecordRevised v3RecordRevisedMessage) {
    if (v3RecordRevisedMessage != null) {
      PRPAIN201302UV02Type rootElement = v3RecordRevisedMessage.getRootElement();
      return rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
          .getSubject1().getPatient().getPatientPerson();
    }
    return null;
  }

  public V3PixSourceMergePatients getV3MergePatientsMessage() {
    return v3MergePatientsMessage;
  }

  public V3PixSourceRecordAdded getV3RecordAddedMessage() {
    return v3RecordAddedMessage;
  }

  public V3PixSourceRecordRevised getV3RecordRevisedMessage() {
    return v3RecordRevisedMessage;
  }

  /**
   * Set whether there was a multiple birth.
   * 
   * @param birthIndicator
   */
  public void setMultipleBirthIndicator(boolean birthIndicator) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setMultipleBirthIndicator(birthIndicator);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setMultipleBirthIndicator(birthIndicator);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setMultipleBirthIndicator(birthIndicator);
    }
  }

  /**
   * Set the birth order number to the provided value
   * 
   * @param birthNumber
   */
  public void setMultipleBirthOrderNumber(int birthNumber) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setMultipleBirthOrderNumber(birthNumber);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setMultipleBirthOrderNumber(birthNumber);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setMultipleBirthOrderNumber(birthNumber);
    }
  }

  /**
   * Set the patient birth time.
   * 
   * @param birthTime
   */
  public void setPatientBirthTime(String birthTime) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientBirthTime(birthTime);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientBirthTime(birthTime);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientBirthTime(birthTime);
    }
  }

  /**
   * Set whether the patient is deceased
   * 
   * @param patientDeceased
   */
  public void setPatientDeceased(boolean patientDeceased) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientDeceased(patientDeceased);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientDeceased(patientDeceased);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientDeceased(patientDeceased);
    }
  }

  /**
   * Set the patient deceased time.
   * 
   * @param patientDeceasedTime
   */
  public void setPatientDeceasedTime(String patientDeceasedTime) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientDeceasedTime(patientDeceasedTime);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientDeceasedTime(patientDeceasedTime);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientDeceasedTime(patientDeceasedTime);
    }
  }

  /**
   * Set the patient gender to the provided value ("M", "F", or "U")
   * 
   * @param gender
   */
  public void setPatientGender(String gender) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientGender(gender);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientGender(gender);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientGender(gender);
    }
  }

  /**
   * Set the marital status for the patient
   * 
   * @param maritalStatus
   */
  public void setPatientMaritalStatus(String maritalStatus) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientMaritalStatus(maritalStatus);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientMaritalStatus(maritalStatus);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientMaritalStatus(maritalStatus);
    }
  }


  /**
   * Add a mother's maiden name for the patient.
   * 
   * @param family
   * @param given
   * @param other
   * @param suffix
   * @param prefix
   */
  public void setPatientMothersMaidenName(String family, String given, String other, String suffix,
      String prefix) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientMothersMaidenName(family, given, other, suffix, prefix);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientMothersMaidenName(family, given, other, suffix, prefix);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientMothersMaidenName(family, given, other, suffix, prefix);
    }
  }


  /**
   * Set the religious affiliation for the patient
   * 
   * @param religiousAffiliation  CWE:ReligiousAffiliation
   */
  public void setPatientReligiousAffiliation(String religiousAffiliation) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientReligiousAffiliation(religiousAffiliation);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientReligiousAffiliation(religiousAffiliation);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientReligiousAffiliation(religiousAffiliation);
    }
  }

  /**
   * Set Patient Very Important Person code
   * 
   * @param code
   */
  public void setPatientVeryImportantPerson(String code) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientVeryImportantPerson(code);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientVeryImportantPerson(code);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientVeryImportantPerson(code);
    }
  }

  /**
   * Set the scoping organization for the patient
   * 
   * @param organizationOID
   * @param organizationName
   * @param telecomValue
   */
  public void setScopingOrganization(String organizationOID, String organizationName,
      String telecomValue) {
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setScopingOrganization(organizationOID, organizationName, telecomValue);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage
          .setScopingOrganization(organizationOID, organizationName, telecomValue);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage
          .setScopingOrganization(organizationOID, organizationName, telecomValue);
    }
  }

}
