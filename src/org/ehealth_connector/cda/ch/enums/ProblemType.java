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
package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Wertebereich für Art des Problems (SNOMED CT; 2.16.840.1.113883.6.96)</div>
 *<div class="fr">Domaine de valeurs pour « Type du problème » (SNOMED CT; 2.16.840.1.113883.6.96)</div>
 */
public enum ProblemType {

  /** 
   *<div class="de">Problem</div>
   *<div class="fr">Problème</div>
   */
  PROBLEM ("55607006", "Problem "),
  /** 
   *<div class="de">Krankheit</div>
   *<div class="fr">Maladie</div>
   */
  CONDITION ("64572001", "Condition"),
  /** 
   *<div class="de">Funktionale Einschränkung</div>
   *<div class="fr">Limitation fonctionnelle</div>
   */
  FUNCTIONAL_LIMITATION ("248536006", "Functional limitation "),
  /** 
   *<div class="de">Diagnose</div>
   *<div class="fr">Diagnostic</div>
   */
  DIAGNOSIS ("282291009", "Diagnosis"),
  /** 
   *<div class="de">Befund</div>
   *<div class="fr">Résultat</div>
   */
  FINDING ("404684003", "Finding "),
  /** 
   *<div class="de">Beschwerde</div>
   *<div class="fr">Plainte</div>
   */
  COMPLAINT ("409586006", "Complaint "),
  /** 
   *<div class="de">Symptom</div>
   *<div class="fr">Symptôme</div>
   */
  SYMPTOM ("418799008", "Symptom ");
  public static final String PROBLEM_CODE="55607006";
  public static final String CONDITION_CODE="64572001";
  public static final String FUNCTIONAL_LIMITATION_CODE="248536006";
  public static final String DIAGNOSIS_CODE="282291009";
  public static final String FINDING_CODE="404684003";
  public static final String COMPLAINT_CODE="409586006";
  public static final String SYMPTOM_CODE="418799008";


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
  public static ProblemType getEnum(String code) {
    for (ProblemType x : values()) {
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
  ProblemType (String code, String displayName) {
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
    for (ProblemType x : values()) {
      if (x.getCodeValue().equals(code)) {
        return true;
      }
    }
    return false;
  }

}