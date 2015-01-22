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

import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

/**
 * Der HL7 Datentyp Name
 *
 */
public class Name {

  private PN mPn;

  public PN getPn() {
    return mPn;
  }

  public void setPn(PN pn) {
    this.mPn = pn;
  }

  /**
   * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für Patienten)
   * 
   * @param givenName Vorname
   * @param familyName Nachname
   */
  public Name(String givenName, String familyName) {
    // Create and fill Person Name
    mPn = DatatypesFactory.eINSTANCE.createPN();
    if ((givenName != null) && !givenName.equals("")) {
      this.setGivenName(givenName);
    }
    if ((familyName != null) && !familyName.equals("")) {
      this.setFamilyName(familyName);
    }
  }

  /**
   * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für Behandelnde)
   * 
   * @param givenName Vorname
   * @param familyName Nachname
   * @param title Titel (z.B. Dr. med.)
   */
  public Name(String givenName, String familyName, String title) {
    this(givenName, familyName);
    mPn.addPrefix(title);
  }

  /**
   * Erzeugt einen Personennamen
   * 
   * @param familyName Nachname
   * @param givenName Vorname
   * @param prefix Prefix (z.B. "Dipl. Inf.")
   * @param suffix Suffix (z.b. "der Dritte")
   */
  public Name(String givenName, String familyName, String prefix, String suffix) {
    this(givenName, familyName, prefix);
    mPn.addSuffix(suffix);
  }

  /**
   * @param pn
   */
  public Name(PN pn) {
    this.mPn = pn;
  }

  public Name(ON on) {
    this.mPn = (PN) on;
  }

  /**
   * @return Vornamen
   */
  public String getGivenName() {
    return mPn.getGivens().get(0).getText();
  }

  /**
   * @return Nachnamen
   */
  public String getFamilyName() {
    return mPn.getFamilies().get(0).getText();
  }

  public String getCompleteName() {
    StringBuilder nameBuilder = new StringBuilder();

    //TODO Fix this with String.join
    String prefixes = this.getPrefixes();
    String givens = this.getGivenNames();
    String families = this.getFamilyNames();
    String suffixes = this.getSuffixes();

    if (prefixes != "") {
      nameBuilder.append(prefixes);
    }
    if (givens != "") {
      nameBuilder.append(" " + givens);
    }
    if (families != "") {
      nameBuilder.append(" " + families);
    }
    if (suffixes != "") {
      nameBuilder.append(" " + suffixes);
    }

    return nameBuilder.toString();
  }

  /**
   * @return das prefix Objekt
   */
  public String getPrefixes() {
    StringBuilder nameBuilder = new StringBuilder();

    for (ENXP enxp : this.mPn.getPrefixes()) {
      nameBuilder.append(enxp.getText());
    }

    return nameBuilder.toString();
  }

  /**
   * @return das suffix Objekt
   */
  public String getSuffixes() {
    StringBuilder nameBuilder = new StringBuilder();

    for (ENXP enxp : this.mPn.getSuffixes()) {
      nameBuilder.append(enxp.getText());
    }

    return nameBuilder.toString();
  }

  /**
   * @return das suffix Objekt
   */
  public String getGivenNames() {
    StringBuilder nameBuilder = new StringBuilder();

    for (ENXP enxp : this.mPn.getGivens()) {
      nameBuilder.append(enxp.getText());
    }

    return nameBuilder.toString();
  }

  /**
   * @return das suffix Objekt
   */
  public String getFamilyNames() {
    StringBuilder nameBuilder = new StringBuilder();

    for (ENXP enxp : this.mPn.getFamilies()) {
      nameBuilder.append(enxp.getText());
    }

    return nameBuilder.toString();
  }

  /**
   * @param givenName Vornamen
   */
  public void setGivenName(String givenName) {
    if ((givenName != null) && !givenName.equals("")) {
      mPn.addGiven(givenName);
    }
  }

  /**
   * @param familyName Nachnamen
   */
  public void setFamilyName(String familyName) {
    if ((familyName != null) && !familyName.equals("")) {
      mPn.addFamily(familyName);
    }
  }

  /**
   * @param prefix das prefix Objekt welches gesetzt wird
   */
  public void setPrefix(String prefix) {
    if ((prefix != null) && !prefix.equals("")) {
      mPn.addPrefix(prefix);
    }
  }

  /**
   * @param title das title Objekt welches gesetzt wird
   */
  public void setTitle(String title) {
    mPn.addPrefix(title);
  }

  /**
   * @param suffix das suffix Objekt welches gesetzt wird
   */
  public void setSuffix(String suffix) {
    if ((suffix != null) && !suffix.equals("")) {
      mPn.addSuffix(suffix);
    }
  }

}
