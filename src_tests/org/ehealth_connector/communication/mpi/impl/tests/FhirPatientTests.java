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
 *******************************************************************************/
package org.ehealth_connector.communication.mpi.impl.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.junit.Test;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.primitive.DateDt;

/**
 * Junit Tests for the FhirPatient
 * 
 * @see org.ehealth_connector.communication.mpi.FhirPatient
 * @author oliveregger
 * 
 */
public class FhirPatientTests {

  private Log log = LogFactory.getLog(FhirPatientTests.class);

  private Patient getPatient(TestPatient patientMueller) {
    Name name = new Name(patientMueller.given, patientMueller.family);
    AdministrativeGender gender;
    if ("male".equals(patientMueller.gender)) {
      gender = AdministrativeGender.MALE;
    } else if ("female".equals(patientMueller.gender)) {
      gender = AdministrativeGender.FEMALE;
    } else {
      gender = AdministrativeGender.UNDIFFERENTIATED;
    }
    Patient conveniencePatient = new Patient(name, gender, patientMueller.getBirthDate());
    return conveniencePatient;
  }

  @Test
  public void testFhirPatientLastGivenGenderBirthDayGenderMale() {
    TestPatient patientMueller = TestPatient.getTestPatientMueller();
    Patient conveniencePatient = getPatient(patientMueller);
    FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
    assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
    assertEquals(patientMueller.family, fhirPatient.getNameFirstRep().getFamilyAsSingleString());
    assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
    assertEquals(patientMueller.gender, fhirPatient.getGender());
  }

  @Test
  public void testFhirPatientLastGivenGenderBirthDayGenderFemale() {
    TestPatient patientMueller = TestPatient.getTestPatientMuellerPauline();
    Patient conveniencePatient = getPatient(patientMueller);
    FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
    assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
    assertEquals(patientMueller.family, fhirPatient.getNameFirstRep().getFamilyAsSingleString());
    assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
    assertEquals(patientMueller.gender, fhirPatient.getGender());
  }

  @Test
  public void testFhirPatientNames() {
    Name name = new Name("given", "family", "prefix", "suffix");
    Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());
    FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
    assertEquals("given", fhirPatient.getNameFirstRep().getGivenAsSingleString());
    assertEquals("family", fhirPatient.getNameFirstRep().getFamilyAsSingleString());
    assertEquals("prefix", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
    assertEquals("suffix", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
  }

  @Test
  public void testFhirPatientMiddleName() {
    Name name = new Name("given", "family", "prefix", "suffix");
    name.getMdhtPn().addGiven("middle");
    name.getMdhtPn().addFamily("family2");
    name.getMdhtPn().addPrefix("prefix2");
    name.getMdhtPn().addSuffix("suffix2");
    Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());
    FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
    assertEquals("given middle", fhirPatient.getNameFirstRep().getGivenAsSingleString());
    assertEquals("family family2", fhirPatient.getNameFirstRep().getFamilyAsSingleString());
    assertEquals("prefix prefix2", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
    assertEquals("suffix suffix2", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
  }

  @Test
  public void testFhirPatientAddress() {
    Name name = new Name("given", "family", "prefix", "suffix");
    Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());

    Address address =
        new Address("addressline1", "addressline2", "addressline3", "zip", "city",
            AddressUse.PRIVATE);

    address.getMdhtAdress().addCountry("cty");
    address.getMdhtAdress().addState("state");

    conveniencePatient.addAddress(address);

    FhirPatient fhirPatient = new FhirPatient(conveniencePatient);

    assertEquals("addressline1", fhirPatient.getAddressFirstRep().getLine().get(0).getValue());
    assertEquals("addressline2", fhirPatient.getAddressFirstRep().getLine().get(1).getValue());
    assertEquals("addressline3", fhirPatient.getAddressFirstRep().getLine().get(2).getValue());
    assertEquals("zip", fhirPatient.getAddressFirstRep().getPostalCode());
    assertEquals("city", fhirPatient.getAddressFirstRep().getCity());
    assertEquals("cty", fhirPatient.getAddressFirstRep().getCountry());
    assertEquals("state", fhirPatient.getAddressFirstRep().getState());
  }
 
  
  private Organization getScopingOrganization() {
    return this.getScopingOrganization("2.16.840.1.113883.3.72.5.9.2","OHT",null);
  }
  
  private Organization getScopingOrganization(String oid, String name, String tel) {
    Organization org = new Organization();
    if (oid!=null) {
      IdentifierDt identifier = new IdentifierDt();
      identifier.setSystem("urn:oid:"+oid);
      org.getIdentifier().add(identifier);
    }
    if (name!=null) {
      org.setName(name);
    }
    if (tel!=null) {
      ContactPointDt fhirTel = org.addTelecom();
      fhirTel.setValue(tel);
    }
    return org;
  }

  
  @Test
  public void testConveniencePatient() {
    
    // ALPHA ALAN
    FhirPatient fhirPatient = new FhirPatient();
    HumanNameDt humanName = new HumanNameDt().addFamily("ALPHA").addGiven("ALAN");
    fhirPatient.getName().add(humanName);
    AddressDt address =
        new AddressDt().addLine("1 PINETREE").setPostalCode("63119").setCity("WEBSTER")
            .setState("MO");
    IdentifierDt identifier = new IdentifierDt();
    identifier.setValue("PIX");
    identifier.setSystem("urn:oid:2.16.840.1.113883.3.72.5.9.1");
    fhirPatient.getIdentifier().add(identifier);
    fhirPatient.setBirthDate(new DateDt("19380224"));
    fhirPatient.getAddress().add(address);
    fhirPatient.setGender(AdministrativeGenderEnum.MALE);
    fhirPatient.getManagingOrganization().setResource(getScopingOrganization());
    
    Patient patient = fhirPatient.getPatient();
    
    assertEquals("2.16.840.1.113883.3.72.5.9.1",patient.getIds().get(0).getRoot());
    assertEquals("PIX",patient.getIds().get(0).getExtension());
    assertEquals("1 PINETREE",patient.getAddress().getAddressline1());
    assertEquals("63119",patient.getAddress().getZip());
    assertEquals("WEBSTER",patient.getAddress().getCity());
    assertEquals("ALPHA",patient.getName().getFamilyName());
    assertEquals("ALAN",patient.getName().getGivenNames());
    
    org.openhealthtools.mdht.uml.hl7.datatypes.II ii = patient.getMdhtPatientRole().getProviderOrganization().getIds().get(0);
    assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());
    
    FhirPatient fhirPatientEquals = new FhirPatient(patient);
    Patient patientEquals = fhirPatientEquals.getPatient();
       
    assertEquals("2.16.840.1.113883.3.72.5.9.1",patientEquals.getIds().get(0).getRoot());
    assertEquals("PIX",patientEquals.getIds().get(0).getExtension());
    assertEquals("1 PINETREE",patientEquals.getAddress().getAddressline1());
    assertEquals("63119",patientEquals.getAddress().getZip());
    assertEquals("WEBSTER",patientEquals.getAddress().getCity());
    assertEquals("ALPHA",patientEquals.getName().getFamilyName());
    assertEquals("ALAN",patientEquals.getName().getGivenNames());
    
    ii = patientEquals.getMdhtPatientRole().getProviderOrganization().getIds().get(0);
    assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());
  }
  
  @Test
  public void testConveniencePatientOrganization() {
    FhirPatient fhirPatient = new FhirPatient();
    fhirPatient.getManagingOrganization().setResource(getScopingOrganization("1234","Test","+417600000000"));
    

    ca.uhn.fhir.model.dstu2.resource.Organization org =
        (ca.uhn.fhir.model.dstu2.resource.Organization) fhirPatient.getManagingOrganization().getResource();
    
    assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
    assertEquals("Test", org.getName());
    assertEquals("+417600000000", org.getTelecomFirstRep().getValue());
    
    Patient patient = fhirPatient.getPatient();
    assertEquals("Test", patient.getMdhtPatientRole().getProviderOrganization().getNames().get(0).getText());
    assertEquals("1234", patient.getMdhtPatientRole().getProviderOrganization().getIds().get(0).getRoot());
    assertEquals("tel:+417600000000", patient.getMdhtPatientRole().getProviderOrganization().getTelecoms().get(0).getValue());

    FhirPatient fhirPatient2 = new FhirPatient(patient);
    org =
        (ca.uhn.fhir.model.dstu2.resource.Organization) fhirPatient2.getManagingOrganization().getResource();
    
    assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
    assertEquals("Test", org.getName());
    assertEquals("+417600000000", org.getTelecomFirstRep().getValue());
  }



}
