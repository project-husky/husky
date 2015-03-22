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

/**
 * Bekannte und häufig gebrauchte Identifikationsdomänen
 * <ul>
 * <li>Global Location Number (GLN): 1.3.88</li>
 * <li>Global Trade Item Number (GTIN): 1.3.160</li>
 * </ul>
 */
public enum CodeSystems {

  /**
   * OID: 2.16.756.5.30.1.127.3.1.20080401.1 <div class="de">Krankheiten
   * und Unfallfolgen (VVK-EDI, Kapitel 2.1.1)</div> <div
   * class="fr">Désignation de la maladie ou de la séquelle d’accident
   * (OCA-DFI, chapitre 2.1.1)</div>
   */
  IcrDha080401Disease ("2.16.756.5.30.1.127.3.1.20080401.1", "diseaseName (ICR-DHA, chapter 2.1.1)"),
  /**
   * OID: 1.3.88 <div class="en">Global Location Number</div>
   */
  GLN ("1.3.88", "Global Location Number"),
  /**
   * OID: 1.3.160 <div class="en">Global Trade Item Number</div>
   */
  GTIN ("1.3.160", "Global Trade Item Number"),
  /**
   * OID: 2.16.756.5.32 <div class="de">SwissINDEX</div> <div
   * class="fr">SwissIndex</div>
   */
  SwissINDEX ("2.16.756.5.30.2.6.1", "SwissINDEX"),
  /**
   * OID: 2.16.756.5.32 <div class="de">WHO ATC Code</div> <div
   * class="fr">WHO ATC Code</div>
   */
  WHOATCCode ("2.16.840.1.113883.6.73", "WHO ATC Code"),
  /**
   * OID: 2.16.756.5.32 <div class="de">AHV Nummer (die Neue)</div> <div
   * class="fr">No AVS (le nouveaux)</div>
   */
  SwissSSN ("2.16.756.5.32", "AHV Nummer (die Neue)"),
  /**
   * OID: 2.16.756.5.31 <div class="de">AHV Nummer (die Alte)</div> <div
   * class="fr">No AVS (le vieil)</div>
   */
  SwissSSNDeprecated ("2.16.756.5.31","AHV Nummer (die Alte)"),
  /**
   * OID: 2.16.756.5.31 <div class="de">ICD-10</div> <div
   * class="fr">ICD-10</div>
   */
  ICD10 ("2.16.756.5.30.1.126.3.2","ICD-10"),
  /**
   * OID: 2.16.840.1.113883.6.121 Language Code
   */
  LanguageCode("2.16.840.1.113883.6.121","Language Code"),
  /**
   * OID: 2.16.840.1.113883.5.25 Confidentiality Code
   */
  ConfidentialityCode ("2.16.840.1.113883.5.25", "Confidentiality Code"),
  /**
  * OID: 2.16.840.1.113883.5.1 AdministrativeGender
  */
  AdministrativeGender("2.16.840.1.113883.5.1", "AdministrativeGender"),

  /**
  * OID: 2.16.840.1.113883.5.1119 AddressUse
  */
  AddressUse("2.16.840.1.113883.5.1119", "AddressUse"),

  /**
  * OID: 2.16.840.1.113883.5.89 ParticipationSignature
  */
  ParticipationSignature("2.16.840.1.113883.5.89", "ParticipationSignature"),

  /**
  * OID: 2.16.840.1.113883.5.14 ActStatus
  */
  ActStatus("2.16.840.1.113883.5.14", "ActStatus"),


  /**
  * OID: 2.16.840.1.113883.6.96 SNOMED CT
  */
  SNOMEDCT("2.16.840.1.113883.6.96", "SNOMED CT"),

  /**
  * OID: 2.16.756.5.30.1.127.3.3.2013.1 Komplikationsrisiken
  */
  Komplikationsrisiken("2.16.756.5.30.1.127.3.3.2013.1", "Komplikationsrisiken"),

  /**
  * OID: 2.16.756.5.30.1.127.3.3.2013.2 Expositionsrisiken
  */
  Expositionsrisiken("2.16.756.5.30.1.127.3.3.2013.2", "Expositionsrisiken"),

  /**
  * OID: 2.16.840.1.113883.5.4 HL7ActCode
  */
  HL7ActCode("2.16.840.1.113883.5.4", "HL7ActCode"),

  /**
  * OID: 2.16.840.1.113883.5.1063 HL7SeverityObservation
  */
  HL7SeverityObservation("2.16.840.1.113883.5.1063", "HL7SeverityObservation"),

  /**
  * OID: 2.16.840.1.113883.5.112 HL7RouteOfAdministration
  */
  HL7RouteOfAdministration("2.16.840.1.113883.5.112", "HL7RouteOfAdministration"),

  /**
  * OID: 2.16.840.1.113883.6.1 LOINC
  */
  LOINC("2.16.840.1.113883.6.1", "LOINC"),

  /**
  * OID: 2.16.840.1.113883.5.83 HL7ObservationInterpretation 
  */
  HL7ObservationInterpretation("2.16.840.1.113883.5.83", "HL7ObservationInterpretation"),

  /**
  * OID: 2.16.840.1.113883.5.1008 HL7nullFlavor
  */
  HL7nullFlavor("2.16.840.1.113883.5.1008", "HL7nullFlavor");

  private String codeSystem;
  private String codeSystemName;

  CodeSystems(String oid, String name) {
    codeSystem = oid;
    codeSystemName = name;
  }

//  public String getCodeSystem(org.ehealth_connector.cda.ch.enums.CodeSystems gln) {
//    switch (gln) {
//      case IcrDha080401Disease:
//        return "2.16.756.5.30.1.127.3.1.20080401.1";
//      case GLN:
//        return "1.3.88";
//      case GTIN:
//        return "1.3.160";
//      case SwissSSN:
//        return "2.16.756.5.32";
//      case SwissSSNDeprecated:
//        return "2.16.756.5.31";
//      default:
//        return "undefined";
//    }
//  }

  public String getCodeSystemId() {
    return codeSystem;
  }

  public String getCodeSystemName() {
    return codeSystemName;
  }
}
