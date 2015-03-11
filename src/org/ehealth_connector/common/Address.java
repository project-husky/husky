/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.AddressUse;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;

/**
 * Klasse Address (repräsentiert eine Adresse)
 */
public class Address {

  /**
   * Das HL7 Address Objekt.
   */
  AD mAd;

  /**
   * <div class="en">Instantiates a new address.</div>
   * <div class="de">Instantiiert eine neue Adresse</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param adress <br>
   * 		<div class="de">Adresse</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Address (AD adress) {
    mAd = adress;
  }

  /**
   * Erstellt ein Adress-Objekt
   * 
   * @param zip
   *            PLZ
   * @param city
   *            Ort
   * @param usage
   *            Verwendungszweck (Privat, Geschäft)
   */
  private Address(String zip, String city, AddressUse usage) {
    mAd = DatatypesFactory.eINSTANCE.createAD();
    setCity(city);
    setZip(zip);
    switch (usage) {
      case BUSINESS:
        mAd.getUses().add(PostalAddressUse.WP);
        break;
      case PRIVATE:
        mAd.getUses().add(PostalAddressUse.HP);
        break;
      default:
        mAd.getUses().add(PostalAddressUse.WP);
        break;
    }
  }

  /**
   * Erstellt ein Adress-Objekt.
   *
   * @param addressline            Strasse und Hausnummer
   * @param zip            PLZ
   * @param city            Ort
   * @param usage            Verwendungszweck (Privat, Geschäft)
   */
  public Address(String addressline, String zip, String city, AddressUse usage) {
    this(zip, city, usage);
    setAddressline1(addressline);
  }

  /**
   * Erstellt ein Adress-Objekt ohne UseCode (Wird oft für Organisationen
   * benötigt).
   *
   * @param street            Strasse (ohne Hausnummer)
   * @param houseNumber            Hausnummer
   * @param zip            PLZ
   * @param city            Ort
   */
  public Address(String street, String houseNumber, String zip, String city) {
    this(zip, city, AddressUse.BUSINESS);
    setStreet(street);
    setHouseNumber(houseNumber);
  }

  /**
   * Erstellt ein Adress-Objekt.
   *
   * @param street            Strasse (ohne Hausnummer)
   * @param houseNumber            Hausnummer
   * @param zip            PLZ
   * @param city            Ort
   * @param usage            Verwendungszweck (Privat, Geschäft)
   */
  public Address(String street, String houseNumber, String zip, String city,
      AddressUse usage) {
    this(zip, city, usage);
    setStreet(street);
    setHouseNumber(houseNumber);
  }

  /**
   * Erstellt ein Adress-Objekt.
   *
   * @param addressline1            Adresszeile 1
   * @param addressline2            Adresszeile 2
   * @param addressline3            Adresszeile 3
   * @param zip            PLZ
   * @param city            Ort
   * @param usage            Verwendungszweck (Privat, Geschäft)
   */
  public Address(String addressline1, String addressline2,
      String addressline3, String zip, String city, AddressUse usage) {
    this(zip, city, usage);
    setAddressline1(addressline1);
    setAddressline2(addressline2);
    setAddressline3(addressline3);
  }

  /**
   * <div class="en">Copy mdht adress.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the adress
   */
  public AD copyMdhtAdress() {
    return EcoreUtil.copy(mAd);
  }

  /**
   * Liefert die Adress-Zeile 1.
   *
   * @return Adress-Zeile 1
   */
  public String getAddressline1() {
    return mAd.getStreetAddressLines().get(0).getText();
  }

  /**
   * Liefert die Adress-Zeile 2.
   *
   * @return Adress-Zeile 2
   */
  public String getAddressline2() {
    return mAd.getStreetAddressLines().get(1).getText();
  }

  /**
   * Liefert die Adress-Zeile 3.
   *
   * @return Adress-Zeile 3
   */
  public String getAddressline3() {
    return mAd.getStreetAddressLines().get(2).getText();
  }

  /**
   * Liefert den Ort.
   *
   * @return Ort
   */
  public String getCity() {
    return mAd.getCities().get(0).getText();
  }

  /**
   * Liefert die Hausnummer.
   *
   * @return Hausnummer
   */
  public String getHouseNumber() {
    return mAd.getHouseNumbers().get(0).getText();
  }

  /**
   * <div class="en">Gets the mdht adress.</div>
   * <div class="de">Liefert mdht adress.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return AD <div class="en">the mdht adress</div>
   */
  public AD getMdhtAdress() {
    return mAd;
  }

  /**
   * Liefert die Strasse.
   *
   * @return Strasse
   */
  public String getStreet() {
    return mAd.getStreetNames().get(0).getText();
  }

  /**
   * Liefert die Art der Adresse (Geschäft, Privat).
   *
   * @return Art der Adresse
   */
  public String getUsage() {
    return mAd.getUses().get(0).getLiteral();
  }

  /**
   * Liefert die PLZ.
   *
   * @return PLZ
   */
  public String getZip() {
    return mAd.getPostalCodes().get(0).getText();
  }

  /**
   * Setzt die Adress-Zeile 1.
   *
   * @param addressline            Adress-Zeile 1
   */
  public void setAddressline1(String addressline) {
    mAd.addStreetAddressLine(addressline);
  }

  /**
   * Setzt die Adress-Zeile 2.
   *
   * @param addressline            Adress-Zeile 2
   */
  public void setAddressline2(String addressline) {
    mAd.addStreetAddressLine(addressline);
  }

  /**
   * Setzt die Adress-Zeile 3.
   *
   * @param addressline            Adress-Zeile 3
   */
  public void setAddressline3(String addressline) {
    mAd.addStreetAddressLine(addressline);
  }

  /**
   * Setzt den Ort.
   *
   * @param city            Ort
   */
  public void setCity(String city) {
    mAd.addCity(city);
  }

  /**
   * Setzt die Hausnummer.
   *
   * @param HouseNumber            Hausnummer
   */
  public void setHouseNumber(String HouseNumber) {
    mAd.addHouseNumber(HouseNumber);
  }

  /**
   * Setzt die Strasse.
   *
   * @param street            Strasse
   */
  public void setStreet(String street) {
    mAd.addStreetName(street);
  }

  /**
   * Setzt die PLZ.
   *
   * @param zip            PLZ
   */
  public void setZip(String zip) {
    mAd.addPostalCode(zip);
  }
}
