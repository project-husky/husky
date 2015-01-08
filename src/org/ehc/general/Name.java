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

package org.ehc.general;

import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
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
   * @param name Nachname
   * @param firstName Vorname
   */
  public Name(String firstName, String name) {
    // Create and fill Person Name
    mPn = DatatypesFactory.eINSTANCE.createPN();
    if ((firstName != null) && !firstName.equals("")) {
      this.setFirstName(firstName);
    }
    if ((name != null) && !name.equals("")) {
      this.setName(name);
    }
  }

  /**
   * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für Behandelnde)
   * 
   * @param name Nachname
   * @param firstName Vorname
   * @param title Titel (z.B. Dr. med.)
   */
  public Name(String name, String firstName, String title) {
    this(name, firstName);
    mPn.addPrefix(title);
  }

  /**
   * Erzeugt einen Personennamen
   * 
   * @param name Nachname
   * @param firstName Vorname
   * @param prefix Prefix (z.B. "Dipl. Inf.")
   * @param suffix Suffix (z.b. "der Dritte")
   */
  public Name(String name, String firstName, String prefix, String suffix) {
    this(name, firstName, prefix);
    mPn.addSuffix(suffix);
  }

  /**
   * @param pn
   */
  public Name(PN pn) {
    this.mPn = pn;
  }

  /**
   * @return das firstName Objekt
   */
  public String getFirstName() {
    return mPn.getGivens().get(0).getText();
  }

  /**
   * @return das name Objekt
   */
  public String getName() {
    return mPn.getFamilies().get(0).getText();
  }

  public String getCompleteName() {
    StringBuilder nameBuilder = new StringBuilder();

    String prefixes = this.getPrefixes();
    String givens = this.getGivens();
    String families = this.getNames();
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
  public String getGivens() {
    StringBuilder nameBuilder = new StringBuilder();

    for (ENXP enxp : this.mPn.getGivens()) {
      nameBuilder.append(enxp.getText());
    }

    return nameBuilder.toString();
  }

  /**
   * @return das suffix Objekt
   */
  public String getNames() {
    StringBuilder nameBuilder = new StringBuilder();

    for (ENXP enxp : this.mPn.getFamilies()) {
      nameBuilder.append(enxp.getText());
    }

    return nameBuilder.toString();
  }

  /**
   * @param firstName das firstName Objekt welches gesetzt wird
   */
  public void setFirstName(String firstName) {
    if ((firstName != null) && !firstName.equals("")) {
      mPn.addGiven(firstName);
    }
  }

  /**
   * @param name das name Objekt welches gesetzt wird
   */
  public void setName(String name) {
    if ((name != null) && !name.equals("")) {
      mPn.addFamily(name);
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
