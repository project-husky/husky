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
package org.ehc.communication.mpi.impl.tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehc.cda.ch.enums.AddressUse;
import org.ehc.cda.ch.enums.AdministrativeGender;
import org.ehc.common.Address;
import org.ehc.common.Name;
import org.ehc.common.Patient;
import org.ehc.communication.mpi.FhirPatient;
import org.junit.Test;

import ca.uhn.fhir.model.dev.composite.AddressDt;
import ca.uhn.fhir.model.dev.composite.HumanNameDt;
import ca.uhn.fhir.model.dev.composite.IdentifierDt;
import ca.uhn.fhir.model.dev.resource.Organization;
import ca.uhn.fhir.model.dev.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.primitive.DateDt;

/**
 * Junit Tests for the FhirPatient
 * 
 * @see org.ehc.communication.mpi.FhirPatient
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
    Organization org = new Organization();
    IdentifierDt identifier = new IdentifierDt();
    identifier.setValue("OHT");
    identifier.setSystem("2.16.840.1.113883.3.72.5.9.2");
    org.getIdentifier().add(identifier);
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
    identifier.setSystem("2.16.840.1.113883.3.72.5.9.1");
    fhirPatient.getIdentifier().add(identifier);
    fhirPatient.setBirthDate(new DateDt("19380224"));
    fhirPatient.getAddress().add(address);
    fhirPatient.setGender(AdministrativeGenderEnum.MALE);
    fhirPatient.getManagingOrganization().setResource(getScopingOrganization());
    
    Patient patient = fhirPatient.getPatient();
    
    
  }



}
