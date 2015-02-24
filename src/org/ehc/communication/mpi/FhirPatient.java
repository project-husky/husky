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
package org.ehc.communication.mpi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.ehc.cda.ch.enums.AdministrativeGender;
import org.ehc.common.Address;
import org.ehc.common.Patient;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;

import ca.uhn.fhir.model.dev.composite.AddressDt;
import ca.uhn.fhir.model.dev.valueset.AdministrativeGenderEnum;

/**
 * The Class FhirPatient. FHIRPatient extends from the FHIR HAPI Patient Resource
 * 
 * @see http://jamesagnew.github.io/hapi-fhir/index.html
 */
public class FhirPatient extends ca.uhn.fhir.model.dev.resource.Patient {

  /** The log. */
  private Log log = LogFactory.getLog(FhirPatient.class);

  /**
   * Instantiates a new fhir patient.
   */
  public FhirPatient() {

  }

  /**
   * Instantiates a new fhir patient based on the ehc.common.patient
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
    if (patient.getGenderCode() != null) {
      AdministrativeGender gender = patient.getGenderCode();
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

  }

}
