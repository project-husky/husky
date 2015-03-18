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

package org.ehealth_connector.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;

/**
 * <div class="en">Class Patient</div>
 */
public class Patient extends Person {

  private RecordTarget mRecordTarget;
  private PatientRole mPatientRole;
  private org.openhealthtools.mdht.uml.cda.Patient mPatient;


  /**
   * CDA R2 extensions for the PIX Profile as proposed on
   * http://wiki.hl7.org/index.php?title=CDA_R2_Extensions
   */

  /**
   * The multipleBirthInd extension is used to record that the recordTarget or subjectPerson is part
   * of a multiple birth.
   */
  private Boolean multipleBirthInd;

  /**
   * The multipleBirthOrderNumber extension is used to record the order number within a multiple
   * birth that the recordTarget or subjectPerson was born in.
   */
  private Integer multipleBirthOrderNumber;

  /**
   * The deceasedInd extension is used to record that the recordTarget or subjectPerson is deceased.
   */
  private Boolean deceasedInd;

  /**
   * The deceasedTime extension is used to record the time of death for the recordTarget or
   * subjectPerson.
   */
  private Date deceasedTime;
  
  /**
   * Mother's Maiden Name
   * Citing Keith Boone, the CDA Book p237:
   * in CDA Release 2.0 there is no appropriate place beneath <recordTarget> where this information would appear
   * insteaad a <participant> would need to be added to the CDA header that identified the mother of the patient
   * TODO: only use at the moment in the OHT PIX communication, for CDA no functionality yet
   */
  private String mothersMaidenName;
  
  
  /**
   * religious Affiliation
   */
  private String religiousAffiliation;
  

  /**
   * Erstellt einen neuen Patienten.
   * 
   * @param name Name
   * @param sex Geschlecht
   * @param birthDay Geburtsdatum
   */
  public Patient(Name name, AdministrativeGender sex, Date birthDay) {
    // Create the RecordTarget, PatientRole and Patient
    mRecordTarget = CDAFactory.eINSTANCE.createRecordTarget();
    mPatientRole = CDAFactory.eINSTANCE.createPatientRole();
    mPatient = CDAFactory.eINSTANCE.createPatient();

    mPatientRole.setPatient(mPatient);
    mRecordTarget.setPatientRole(mPatientRole);

    // Create and fill gender
    if (sex != null) {
      mPatient.setAdministrativeGenderCode(sex.getCE());
    }

    // Fill Patient Name
    mPatient.getNames().add(name.getMdhtPn());

    // Create and fill birth date
    if (birthDay != null) {
      try {
        mPatient.setBirthTime(DateUtil.createTSFromEuroDate(birthDay));
      } catch (final ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  /**
   * Erstellt einen neuen Patienten inkl. einer Patienten Id. Wenn es sich bei dem Dokument um einen
   * Impfausweis handelt dann MUSS dieser Konstruktor verwendet werden.
   * 
   * @param name Name
   * @param sex Geschlecht
   * @param birthDay Geburtsdatum
   * @param id <br>
   *        <div class="de">ID</div> <div class="fr"></div> <div class="it"></div>
   */
  public Patient(Name name, AdministrativeGender sex, Date birthDay, Identificator id) {
    // Create the RecordTarget, PatientRole and Patient
    mRecordTarget = CDAFactory.eINSTANCE.createRecordTarget();
    mPatientRole = CDAFactory.eINSTANCE.createPatientRole();
    mPatient = CDAFactory.eINSTANCE.createPatient();

    mPatientRole.setPatient(mPatient);
    mRecordTarget.setPatientRole(mPatientRole);

    // Gender
    setAdministrativeGender(sex);

    // Patient Name
    addName(name);

    // Day of birth
    setBirthday(birthDay);

    // Id
    addId(id);
  }

  /**
   * Constructor (used when deserializing CDA document).
   * 
   * @param recordTarget <br>
   *        <div class="en"> record target</div>
   */
  public Patient(RecordTarget recordTarget) {
    mRecordTarget = recordTarget;
  }

  /**
   * Fügt eine Adresse hinzu.
   * 
   * @param address Adresse
   */
  public void addAddress(Address address) {
    mPatientRole.getAddrs().add(address.copyMdhtAdress());
  }

  /**
   * Fügt einen Identifikator hinzu.
   * 
   * @param identificator Identificator
   */
  public void addId(Identificator identificator) {
    II id = DatatypesFactory.eINSTANCE.createII();
    id.setRoot(identificator.getRoot());
    id.setExtension(identificator.getExtension());
    mPatientRole.getIds().add(id);
  }

  /**
   * <div class="en">Adds the name.</div> <div class="de"></div> <div class="fr"></div> <div
   * class="it"></div>
   * 
   * @param name <br>
   *        <div class="de"> name</div> <div class="fr"></div> <div class="it"></div>
   */
  public void addName(Name name) {
    mPatient.getNames().add(name.copyMdhtPn());
  }

  /**
   * <div class="en">Copy mdht patient.</div> <div class="de"></div> <div class="fr"></div> <div
   * class="it"></div>
   * 
   * @return the org.openhealthtools.mdht.uml.cda.Patient the MDHT Patient object
   */
  public org.openhealthtools.mdht.uml.cda.Patient copyMdhtPatient() {
    return EcoreUtil.copy(mPatient);
  }

  /**
   * <div class="en">Copy mdht patient role.</div> <div class="de"></div> <div class="fr"></div>
   * <div class="it"></div>
   * 
   * @return PatientRole the patient role
   */
  public PatientRole copyMdhtPatientRole() {
    return EcoreUtil.copy(mPatientRole);
  }

  /**
   * <div class="en">Copy mdht record target.</div> <div class="de"></div> <div class="fr"></div>
   * <div class="it"></div>
   * 
   * @return RecordTarget the record target
   */
  public RecordTarget copyMdhtRecordTarget() {
    return EcoreUtil.copy(mRecordTarget);
  }

  /**
   * <div class="en">Gets the address.</div> <div class="de">Liefert die (erste) Adresse</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return <div class="en">the address</div>
   */
  public Address getAddress() {
    AD mAd = mPatientRole.getAddrs().get(0);
    Address address = new Address(mAd);
    return address;
  }

  /**
   * <div class="en">Gets the adresses.</div> <div class="de">Liefert alles Adressen</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return <div class="en">the adresses</div>
   */
  public ArrayList<Address> getAddresses() {
    ArrayList<Address> al = new ArrayList<Address>();
    for (AD mAddress : mPatientRole.getAddrs()) {
      Address address = new Address(mAddress);
      al.add(address);
    }
    return al;
  }

  /**
   * <div class="en">Gets the gender code.</div> <div class="de">Liefert das Geschlecht</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return <div class="en">the gender code</div>
   */
  public AdministrativeGender getAdministrativeGenderCode() {
    CE code = getMdhtPatient().getAdministrativeGenderCode();
    if (code == null) {
      return null;
    }
    return AdministrativeGender.getEnum(code.getCode());
  }

  /**
   * <div class="en">Gets the birthday.</div> <div class="de">Liefert birthday.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return Date <div class="en">the birthday</div>
   */
  public Date getBirthday() {
    try {
      TS birthTime = getMdhtPatient().getBirthTime();
      if (birthTime == null) {
        return null;
      }
      String value = birthTime.getValue();
      return parseDate(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Cannot convert birthdate", e);
    }
  }

  /**
   * Gets the deceased Indicator
   *
   * @return the deceased ind
   */
  public Boolean getDeceasedInd() {
    return deceasedInd;
  }


  /**
   * Gets the deceased time.
   *
   * @return the deceased time
   */
  public Date getDeceasedTime() {
    return deceasedTime;
  }

  /**
   * <div class="en">Gets the ids.</div> <div class="de">Liefert alle ids.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return <div class="en">the ids</div>
   */
  public ArrayList<Identificator> getIds() {
    ArrayList<Identificator> il = new ArrayList<Identificator>();
    for (II mId : mPatientRole.getIds()) {
      Identificator id = new Identificator(mId);
      il.add(id);
    }
    return il;
  }

  /**
   * <div class="en">Gets the mdht patient.</div> <div class="de">Liefert mdht patient.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return org.openhealthtools.mdht.uml.cda.Patient <div class="en">the mdht patient</div>
   */
  public org.openhealthtools.mdht.uml.cda.Patient getMdhtPatient() {
    return mPatient;
  }

  /**
   * <div class="en">Gets the mdht patient role.</div> <div class="de">Liefert mdht patient
   * role.</div> <div class="fr"></div> <div class="it"></div>
   * 
   * @return PatientRole <div class="en">the mdht patient role</div>
   */
  public PatientRole getMdhtPatientRole() {
    return mPatientRole;
  }

  /**
   * <div class="en">Gets the mdht record target.</div> <div class="de">Liefert mdht record
   * target.</div> <div class="fr"></div> <div class="it"></div>
   * 
   * @return RecordTarget <div class="en">the mdht record target</div>
   */
  public RecordTarget getMdhtRecordTarget() {
    return mRecordTarget;
  }

  /**
   * Gets the multiple birth Indictator
   *
   * @return the multiple birth ind
   */
  public Boolean getMultipleBirthInd() {
    return multipleBirthInd;
  }

  /**
   * Gets the multiple birth order number.
   *
   * @return the multiple birth order number
   */
  public Integer getMultipleBirthOrderNumber() {
    return multipleBirthOrderNumber;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.ehealth_connector.common.Person#getName()
   */
  @Override
  public Name getName() {
    Name name = new Name(mPatient.getNames().get(0));
    return name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.ehealth_connector.common.Person#getNames()
   */
  @Override
  public ArrayList<Name> getNames() {
    ArrayList<Name> nl = new ArrayList<Name>();
    for (PN mName : mPatient.getNames()) {
      Name name = new Name(mName);
      nl.add(name);
    }
    return nl;
  }

  /**
   * <div class="en">Gets the telecoms.</div> <div class="de">Liefert telecoms.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @return Telecoms <div class="en">the telecoms</div>
   */
  public Telecoms getTelecoms() {
    Telecoms telecoms = new Telecoms(mPatientRole.getTelecoms());
    return telecoms;
  }

  private Date parseDate(String value) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    return sdf.parse(value);
  }


  /**
   * <div class="en">Sets the gender.</div> <div class="de">Setzt gender.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * 
   * @param sex <div class="en">the new (administrative) gender</div> <div class="de">das neue
   *        (administrative) Geschlecht</div> <div class="fr"></div> <div class="it"></div>
   */
  public void setAdministrativeGender(AdministrativeGender sex) {
    mPatient.setAdministrativeGenderCode(sex.getCE());
  }

  /**
   * <div class="en">Sets the birthday.</div> <div class="de">Setzt birthday.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * @param birthDay <div class="en">the new birthday</div> <div class="de">das neue birthday.</div>
   *        <div class="fr"></div> <div class="it"></div>
   */
  public void setBirthday(Date birthDay) {
    try {
      mPatient.setBirthTime(DateUtil.createTSFromEuroDate(birthDay));
    } catch (final ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Sets the deceased Indicator
   *
   * @param deceasedInd the new deceased ind
   */
  public void setDeceasedInd(Boolean deceasedInd) {
    this.deceasedInd = deceasedInd;
  }

  /**
   * Sets the deceased time.
   *
   * @param deceasedTime the new deceased time
   */
  public void setDeceasedTime(Date deceasedTime) {
    this.deceasedTime = deceasedTime;
  }

  /**
   * Sets the multiple birth Indicator
   *
   * @param multipleBirthInd the new multiple birth ind
   */
  public void setMultipleBirthInd(Boolean multipleBirthInd) {
    this.multipleBirthInd = multipleBirthInd;
  }

  /**
   * Sets the multiple birth order number.
   *
   * @param multipleBirthOrderNumber the new multiple birth order number
   */
  public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
    this.multipleBirthOrderNumber = multipleBirthOrderNumber;
  }

  /**
   * <div class="en">Sets the telecoms.</div> <div class="de">Setzt telecoms.</div> <div
   * class="fr"></div> <div class="it"></div>
   * 
   * 
   * @param telecoms <div class="en">the new telecoms</div> <div class="de">das neue telecoms.</div>
   *        <div class="fr"></div> <div class="it"></div>
   */
  public void setTelecoms(Telecoms telecoms) {
    mPatientRole.getTelecoms().addAll(telecoms.getMdhtTelecoms());
  }

  /**
   * Gets the mothers maiden name.
   *
   * @return the mothers maiden name
   */
  public String getMothersMaidenName() {
    return mothersMaidenName;
  }

  /**
   * Sets the mothers maiden name.
   *
   * @param mothersMaidenName the new mothers maiden name
   */
  public void setMothersMaidenName(String mothersMaidenName) {
    this.mothersMaidenName = mothersMaidenName;
  }

  /**
   * Gets the religious affiliation.
   *
   * @return the religious affiliation
   */
  public String getReligiousAffiliation() {
    return religiousAffiliation;
  }

  /**
   * Sets the religious affiliation.
   *
   * @param religiousAffiliation the new religious affiliation
   */
  public void setReligiousAffiliation(String religiousAffiliation) {
    this.religiousAffiliation = religiousAffiliation;
  }
}
