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
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2014
 * 
 *******************************************************************************/

package org.ehc.common;

import org.ehc.common.ConvenienceUtilsEnums.KnownOID;
import org.ehc.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

/**
 * Eine Person (z.B. Arzt, Datenerfasser, Angehörige, ...)
 */
public class Person {

  org.openhealthtools.mdht.uml.cda.Person mPerson;

  protected Person() {}

  /**
   * Erstellt eine neue Person (Dieser Konstruktor wird oft gebraucht für Behandelnde)
   * 
   * @param familyName Nachname
   * @param givenName Vorname
   */
  public Person(String familyName, String givenName) {
    mPerson = CDAFactory.eINSTANCE.createPerson();
    // Create and fill Person Name
    final PN pName = DatatypesFactory.eINSTANCE.createPN();
    pName.addGiven(givenName).addFamily(familyName);
    mPerson.getNames().add(pName);
  }

  /**
   * Erstellt eine neue Person (Dieser Konstruktor wird oft gebraucht für Behandelnde)
   * 
   * @param name Nachname
   * @param firstName Vorname
   * @param title Titel (z.B. Dr. med.)
   */
  public Person(String name, String firstName, String title) {
    // Create and fill Person Name
    final PN pName = DatatypesFactory.eINSTANCE.createPN();
    pName.addGiven(firstName).addFamily(name).addPrefix(title);
    mPerson.getNames().add(pName);
  }

  /**
   * Weist der Person eine eMail Adresse zu
   * 
   * @param eMail eMail Adresse
   * @param usage Verwendungszweck (Privat, Geschäft)
   */
  public void addEMail(String eMail, UseCode usage) {
    // Auto-generated method stub

  }

  /**
   * Weist der Person eine Faxnummer zu
   * 
   * @param faxNr Faxnummer (nur internationale Rufnummer ohne Sonderzeichen erlaubt). Beispiel:
   *        +41322345566
   * @param usage Verwendungszweck (Privat, Geschäft)
   */
  public void addFax(String faxNr, UseCode usage) {
    // Auto-generated method stub

  }

  /**
   * Weist der Person eine GLN zu (wird vor allem für Ärzte gebraucht)
   * 
   * @param gln Global Location Number (GLN)
   */
  public void addGLN(String gln) {
    // Auto-generated method stub
    this.addID(new Identificator(gln, KnownOID.GLN));
  }

  /**
   * Weist der Person eine ID zu
   * 
   * @param identificator Kombination von eigentlicher ID und der OID der verwaltenden Domäne
   */
  public void addID(Identificator identificator) {
    // Auto-generated method stub

  }

  /**
   * Weist der Person eine Telefonnummer zu
   * 
   * @param phoneNr Telefonnummer (nur internationale Rufnummer ohne Sonderzeichen erlaubt).
   *        Beispiel: +41322345566
   * @param usage Verwendungszweck (Privat, Geschäft, Mobil)
   */
  public void addPhone(String phoneNr, UseCode usage) {
    // Auto-generated method stub

  }

  /**
   * Weist der Person ein Fachgebiet zu (wird vor allem für Ärzte gebraucht)
   * 
   * @param speciality Fachgebiet (z.B. Facharzt für Allgemeine Medizin)
   */
  public void addSpeciality(String speciality) {
    // Auto-generated method stub

  }

  /**
   * Weist der Person eine Webseite zu
   * 
   * @param eMail Webseite
   * @param usage Verwendungszweck (Privat, Geschäft)
   */
  public void addWebsite(String eMail, UseCode usage) {
    // Auto-generated method stub

  }


  /**
   * Weist der Person einen Namen zu (allfällig vorbestehende Namensliste wird gelöscht)
   * 
   * @param familyName Nachname
   * @param givenName Vorname
   */
  public void setName(String familyName, String givenName) {
    final PN pName = DatatypesFactory.eINSTANCE.createPN();
    pName.addGiven(givenName).addFamily(familyName);
    mPerson.getNames().clear();
    mPerson.getNames().add(pName);
  }
}
