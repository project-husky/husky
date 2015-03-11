/*******************************************************************************
 * 
 * The authorship of this code and the accompanying materials is held by ahdis gmbh, Switzerland.
 * All rights reserved. http://ahdis.ch
 * 
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * 
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2015
 * 
 * @author oliveregger
 * 
 *******************************************************************************/
package org.ehealth_connector.communication.mpi;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Organization;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.primitive.StringDt;

/**
 * The Class FhirPatient. FHIRPatient extends from the FHIR HAPI Patient Resource
 * 
 * @see http://jamesagnew.github.io/hapi-fhir/index.html
 */
@ResourceDef(name = "Patient")
public class FhirPatient extends ca.uhn.fhir.model.dstu2.resource.Patient {

  /** The log. */
  private Log log = LogFactory.getLog(FhirPatient.class);

  /**
   * Instantiates a new fhir patient.
   */
  public FhirPatient() {

  }

  /**
   * Instantiates a new fhir patient based on the org.ehealth_connector.common.patient
   * 
   * @param patient the patient
   */
  public FhirPatient(Patient patient) {

    if (patient == null) {
      return;
    }
    if (patient.getName() != null && patient.getName().getGivenNames() != null) {
      EList<ENXP> givens = patient.getName().getMdhtPn().getGivens();
      for (ENXP given : givens) {
        getNameFirstRep().addGiven(given.getText());
      }
    }
    if (patient.getName() != null && patient.getName().getFamilyNames() != null) {
      EList<ENXP> givens = patient.getName().getMdhtPn().getFamilies();
      for (ENXP given : givens) {
        getNameFirstRep().addFamily(given.getText());
      }
    }
    if (patient.getName() != null && patient.getName().getPrefixes() != null) {
      EList<ENXP> givens = patient.getName().getMdhtPn().getPrefixes();
      for (ENXP given : givens) {
        getNameFirstRep().addPrefix(given.getText());
      }
    }
    if (patient.getName() != null && patient.getName().getSuffixes() != null) {
      EList<ENXP> givens = patient.getName().getMdhtPn().getSuffixes();
      for (ENXP given : givens) {
        getNameFirstRep().addSuffix(given.getText());
      }
    }
    if (patient.getBirthday() != null) {
      setBirthDateWithDayPrecision(patient.getBirthday());
    }
    if (patient.getAdministrativeGenderCode() != null) {
      AdministrativeGender gender = patient.getAdministrativeGenderCode();
      if (gender.equals(AdministrativeGender.FEMALE)) {
        this.setGender(AdministrativeGenderEnum.FEMALE);
      } else if (gender.equals(AdministrativeGender.MALE)) {
        this.setGender(AdministrativeGenderEnum.MALE);
      } else if (gender.equals(AdministrativeGender.UNDIFFERENTIATED)) {
        this.setGender(AdministrativeGenderEnum.OTHER);
      }
    }
    if (patient.getAddresses() != null && patient.getAddresses().size() > 0) {
      Address homeAddress = null;
      if (patient.getAddresses().size() == 1) {
        homeAddress = patient.getAddress();
      } else {
        for (int i = 0; i < patient.getAddresses().size(); ++i) {
          if ("HP".equals(patient.getAddresses().get(i).getUsage())) {
            homeAddress = patient.getAddresses().get(i);
          }
        }
      }
      if (homeAddress != null) {
        AddressDt addressDt = new AddressDt();
        if (homeAddress.getAddressline1() != null) {
          addressDt.addLine().setValue(homeAddress.getAddressline1());
        }
        if (homeAddress.getAddressline2() != null) {
          addressDt.addLine().setValue(homeAddress.getAddressline2());
        }
        if (homeAddress.getAddressline3() != null) {
          addressDt.addLine().setValue(homeAddress.getAddressline3());
        }
        if (homeAddress.getCity() != null) {
          addressDt.setCity(homeAddress.getCity());
        }
        if (homeAddress.getZip() != null) {
          addressDt.setPostalCode(homeAddress.getZip());
        }
        if (homeAddress.getMdhtAdress().getStates() != null
            && homeAddress.getMdhtAdress().getStates().size() > 0) {
          addressDt.setState(homeAddress.getMdhtAdress().getStates().get(0).getText());
        }
        if (homeAddress.getMdhtAdress().getCountries() != null
            && homeAddress.getMdhtAdress().getCountries().size() > 0) {
          addressDt.setCountry(homeAddress.getMdhtAdress().getCountries().get(0).getText());
        }
        this.getAddress().add(addressDt);
      } else {
        log.error("adress specified, but no home address");
      }
    }
    for (Identificator ident : patient.getIds()) {
      this.getIdentifier()
          .add(new IdentifierDt("urn:oid:" + ident.getRoot(), ident.getExtension()));
    }
    Organization organization = patient.getMdhtPatientRole().getProviderOrganization();
    if (organization != null) {
      ca.uhn.fhir.model.dstu2.resource.Organization fhirOrganization =
          new ca.uhn.fhir.model.dstu2.resource.Organization();

      if (organization != null && organization.getIds() != null && organization.getIds().size() > 0) {
        org.openhealthtools.mdht.uml.hl7.datatypes.II ii = organization.getIds().get(0);
        IdentifierDt identifier = new IdentifierDt();
        identifier.setValue(ii.getExtension());
        identifier.setSystem("urn:oid:" + ii.getRoot());
        fhirOrganization.getIdentifier().add(identifier);
      }
      
      if (organization.getNames()!=null && organization.getNames().size()>0) {
        String name = organization.getNames().get(0).getText();
        fhirOrganization.setName(name);
      }
      
      if (organization.getTelecoms()!=null && organization.getTelecoms().size()>0) {
        TEL tel = organization.getTelecoms().get(0);
        ContactPointDt fhirTel = fhirOrganization.addTelecom();
        if (tel.getValue().startsWith("tel:")) {
          fhirTel.setValue(tel.getValue().substring(4));
        }
      }
      getManagingOrganization().setResource(fhirOrganization);
    }
    
    if (patient.getTelecoms()!=null) {
      for(TEL tel : patient.getTelecoms().getMdhtTelecoms()) {
        ContactPointDt contactPointDt = new ContactPointDt();
        String value = null;
        ContactPointSystemEnum system = null;
        ContactPointUseEnum use = null;
        if (tel.getValue().length()>4 && tel.getValue().startsWith("tel:")) {
          value = tel.getValue().substring(4);
          system = ContactPointSystemEnum.PHONE;
        } else if (tel.getValue().length()>4 && tel.getValue().startsWith("mailto:")) {
          value = tel.getValue().substring(7);
          system = ContactPointSystemEnum.EMAIL;
        }
        if (tel.getUses().size()>0 && tel.getUses().get(0)==TelecommunicationAddressUse.HP) {
          use = ContactPointUseEnum.HOME;
        }
        if (tel.getUses().size()>0 && tel.getUses().get(0)==TelecommunicationAddressUse.WP) {
          use = ContactPointUseEnum.WORK;
        }
        if (tel.getUses().size()>0 && tel.getUses().get(0)==TelecommunicationAddressUse.MC) {
          use = ContactPointUseEnum.MOBILE;
        }
        contactPointDt.setSystem(system);
        contactPointDt.setUse(use);
        contactPointDt.setValue(value);
        this.getTelecom().add(contactPointDt);
      }
    }
  }


  public Patient getPatient() {

    Name patientName = new Name(null, null);
    PN pn = patientName.getMdhtPn();
    AdministrativeGender patientGender = null;
    Date patientBirthdate = null;

    HumanNameDt humanDt = this.getNameFirstRep();
    if (humanDt != null) {
      for (StringDt name : humanDt.getPrefix()) {
        pn.addPrefix(name.getValue());
      }
      for (StringDt name : humanDt.getGiven()) {
        pn.addGiven(name.getValue());
      }
      for (StringDt name : humanDt.getFamily()) {
        pn.addFamily(name.getValue());
      }
      for (StringDt name : humanDt.getSuffix()) {
        pn.addSuffix(name.getValue());
      }
    }

    String gender = getGender();
    if (gender != null) {
      if (gender.equals(AdministrativeGenderEnum.FEMALE.getCode())) {
        patientGender = AdministrativeGender.FEMALE;
      } else if (gender.equals(AdministrativeGenderEnum.MALE.getCode())) {
        patientGender = AdministrativeGender.MALE;
      } else if (gender.equals(AdministrativeGenderEnum.OTHER.getCode())) {
        patientGender = AdministrativeGender.UNDIFFERENTIATED;
      }
    }


    String addressline1 = "";
    String addressline2 = "";
    String addressline3 = "";

    AddressDt addressDt = getAddressFirstRep();
    if (addressDt.getLine().size() > 2) {
      addressline3 = addressDt.getLine().get(2).getValueAsString();
    }
    if (addressDt.getLine().size() > 1) {
      addressline2 = addressDt.getLine().get(1).getValueAsString();
    }
    if (addressDt.getLine().size() > 0) {
      addressline1 = addressDt.getLine().get(0).getValueAsString();
    }

    String city = "";
    if (addressDt.getCity() != null) {
      city = addressDt.getCity();
    }
    String zip = "";
    if (addressDt.getPostalCode() != null) {
      zip = addressDt.getPostalCode();
    }


    Address patientAddress =
        new Address(addressline1, addressline2, addressline3, zip, city, AddressUse.PRIVATE);
    if (addressDt.getState() != null) {
      patientAddress.getMdhtAdress().addState(addressDt.getState());
    }
    if (addressDt.getCountry() != null) {
      patientAddress.getMdhtAdress().addCountry(addressDt.getCountry());
    }

    patientBirthdate = getBirthDate();
    Patient patient = new Patient(patientName, patientGender, patientBirthdate);
    for (IdentifierDt identDt : getIdentifier()) {
      String oid = "";
      if (identDt.getSystem().startsWith("urn:oid:")) {
        oid = identDt.getSystem().substring(8);
      }
      String id = identDt.getValue();
      Identificator identificator = new Identificator(oid, id);
      patient.addId(identificator);
    }

    if (patientAddress != null) {
      patient.addAddress(patientAddress);
    }

    if (getManagingOrganization() != null) {
      PatientRole patientRole = patient.getMdhtPatientRole();
      Organization organization = CDAFactory.eINSTANCE.createOrganization();
      org.ehealth_connector.common.Organization convenienceOrganization = new org.ehealth_connector.common.Organization(organization);
      
      patientRole.setProviderOrganization(organization);
      ca.uhn.fhir.model.dstu2.resource.Organization org =
          (ca.uhn.fhir.model.dstu2.resource.Organization) getManagingOrganization().getResource();
      
      if (org!=null && org.getName()!=null) {
        convenienceOrganization.addName(org.getName());
      }
      
      if (org!=null && org.getIdentifierFirstRep().getSystem().startsWith("urn:oid:")) {
        String oid = "";
        oid = org.getIdentifierFirstRep().getSystem().substring(8);
        organization.getIds().add(
            new Identificator(oid, org.getIdentifierFirstRep().getValue()).getIi());
      }
      if (org !=null && org.getTelecom().size()>0) {
        ContactPointDt contactPointDt = org.getTelecomFirstRep();
        if (contactPointDt!=null && contactPointDt.getValue()!=null) {
          TEL tel = Util.createTel(contactPointDt.getValue(),null);
          organization.getTelecoms().add(tel);
        }
      }
    }
    
    // telecommunications
    if (getTelecom().size()>0) {
      Telecoms telecoms = new Telecoms();
      for(ContactPointDt contactPointDt : getTelecom()) {
        if (ContactPointSystemEnum.PHONE.equals(contactPointDt.getSystemElement().getValueAsEnum())) {
          AddressUse addressUse = null;
          if (ContactPointUseEnum.HOME.equals(contactPointDt.getUseElement().getValueAsEnum())) {
            addressUse = AddressUse.PRIVATE;
          } else if (ContactPointUseEnum.WORK.equals(contactPointDt.getUseElement().getValueAsEnum())) {
            addressUse = AddressUse.BUSINESS;
          } else if (ContactPointUseEnum.MOBILE.equals(contactPointDt.getUseElement().getValueAsEnum())) {
            addressUse = AddressUse.MOBILE;
          } 
          telecoms.addPhone(contactPointDt.getValue(), addressUse);
        }
        if (ContactPointSystemEnum.EMAIL.equals(contactPointDt.getSystemElement().getValueAsEnum())) {
          AddressUse addressUse = null;
          if (ContactPointUseEnum.HOME.equals(contactPointDt.getUseElement().getValueAsEnum())) {
            addressUse = AddressUse.PRIVATE;
          } else if (ContactPointUseEnum.WORK.equals(contactPointDt.getUseElement().getValueAsEnum())) {
            addressUse = AddressUse.BUSINESS;
          } 
          telecoms.addEMail(contactPointDt.getValue(), addressUse);
        }
      }
      if (telecoms.getMdhtTelecoms().size()>0) {
        patient.setTelecoms(telecoms);
      }
    }
    

    return patient;
  }

}
