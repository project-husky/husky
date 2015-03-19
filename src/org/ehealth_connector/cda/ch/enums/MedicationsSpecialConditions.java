/********************************************************************************
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
********************************************************************************/

package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Quelle für Subset: [IHE PCC TF-2], Table 6.3.4.16.7-1</div>
 *<div class="fr">Source du sous-ensemble : [IHE PCC TF-2],Table 6.3.4.16.7-1</div>
 */
public enum MedicationsSpecialConditions {

  /** 
   *<div class="de">Medikamentöse Therapie unbekannt</div>
   *<div class="fr">Traitement médicamenteux inconnu</div>
   */
  DRUG_TREATMENT_UNKNOWN ("182904002", "Drug Treatment Unknown"),
  /** 
   *<div class="de">Keine medikamentöse Therapie verschrieben</div>
   *<div class="fr">Aucun traitement médicamenteux prescrit</div>
   */
  NO_DRUG_THERAPY_PRESCRIBED ("182849000", "No Drug Therapy Prescribed"),
  /** 
   *<div class="de">Patient gibt an, keine Medikamente einzunehmen</div>
   *<div class="fr">Le patient indique qu’il ne prend pas de médicaments.</div>
   */
  PATIENT_NOT_ON_SELF_MEDICATIONS ("408350003", "Patient Not On Self-Medications"),
  /** 
   *<div class="de">Patient lehnt die Impfung ab</div>
   *<div class="fr">Le patient refuse la vaccination.</div>
   */
  MEDICATION_REFUSED_PATIENT_OBJECTIVE ("406149000", "Medication refused, Patient Objective");
  public static final String DRUG_TREATMENT_UNKNOWN_CODE="182904002";
  public static final String NO_DRUG_THERAPY_PRESCRIBED_CODE="182849000";
  public static final String PATIENT_NOT_ON_SELF_MEDICATIONS_CODE="408350003";
  public static final String MEDICATION_REFUSED_PATIENT_OBJECTIVE_CODE="406149000";


  public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
  public static final String CODE_SYSTEM_NAME="SNOMED CT";


  /**
   * <div class="en">Gets the Enum with a given code</div>
   * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
   *
   * @param code <br>
   *      <div class="de"> code</div>
   * @return <div class="en">the enum</div>
   */
  public static MedicationsSpecialConditions getEnum(String code) {
    for (MedicationsSpecialConditions x : values()) {
      if (x.getCodeValue().equals(code)) {
        return x;
      }
    }
    return null;
  }
  private String code;


  private String displayName;


  /**
   * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
   * <div class="de">Instantiiert dieses Enum Object mittels eines Codes und einem Display Name</div>
   *
   *@param code <br>
   *	<div class="de"> code</div>
   * @param displayName <br>
   *	<div class="de"> display name</div>
   */
  MedicationsSpecialConditions (String code, String displayName) {
    this.code = code;
    this.displayName = displayName;
  }


  /**
   * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
   * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
   *
   * @return <div class="en">The MDHT Code</div>
   */
  public CD getCD() {
    CD cd = DatatypesFactory.eINSTANCE.createCD();
    cd.setCodeSystem(CODE_SYSTEM);
    cd.setCode(code);
    cd.setDisplayName(displayName);
    return cd;
  }


  /**
   * <div class="en">Gets the ehealthconnector Code Object</div>
   * <div class="de">Liefert das ehealthconnector Code Objekt</div>
   *
   * @return <div class="en">the code</div>
   */
  public Code getCode() {
    Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
    return ehcCode;
  }


  /**
   * <div class="en">Gets the code system id.</div>
   * <div class="de">Liefert die code system id.</div>
   *
   * @return <div class="en">the code system id</div>
   */
  public String getCodeSystemId() {
    return CODE_SYSTEM;
  }


  /**
   * <div class="en">Gets the code system name.</div>
   * <div class="de">Liefert code system name.</div>
   *
   * @return <div class="en">the code system name</div>
   */
  public String getCodeSystemName() {
    return CODE_SYSTEM_NAME;
  }


  /**
   * <div class="en">Gets the actual Code as string</div>
   * <div class="de">Liefert den eigentlichen Code als String</div>
   *
   * @return <div class="en">the code</div>
   */
  public String getCodeValue() {
    return code;
  }


  /**
   * <div class="en">Gets the display name.</div>
   * <div class="de">Liefert display name.</div>
   *
   * @return <div class="en">the display name</div>
   */
  public String getdisplayName() {
    return displayName;
  }


  /**
   * <div class="en">Checks if a given enum is part of this value set.</div>
   * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
   *
   *
   * @param enumStr <br>
   *      <div class="de"> enum str</div>
   * @return true, if is enum of value set
   */
  public boolean isEnumOfValueSet(String enumStr) {
    return Arrays.asList(values()).contains(enumStr);
  }

  /**
   * <div class="en">Checks if a given code is in this value set.</div>
   * <div class="de">Prüft, ob der gegebene code in diesem Value Sets vorhanden ist.</div>
   *
   * @param code <br>
   *      <div class="de"> code</div>
   * @return true, if is in value set
   */
  public boolean isInValueSet(String code) {
    for (MedicationsSpecialConditions x : values()) {
      if (x.getCodeValue().equals(code)) {
        return true;
      }
    }
    return false;
  }

}