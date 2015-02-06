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
 * Year of publication: 2014
 *
 *******************************************************************************/

package org.ehc.common;

import org.ehc.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.mdht.uml.hl7.datatypes.impl.ADImpl;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;

/**
 * Das HL7 Address Objekt
 * 
 */
public class Address extends ADImpl {

	/**
	 * Erstellt ein Adress-Objekt ohne UseCode (Wird oft für Organisationen
	 * benötigt)
	 * 
	 * @param street
	 *            Strasse (ohne Hausnummer)
	 * @param houseNumber
	 *            Hausnummer
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 */
	public Address(String street, String houseNumber, String zip, String city) {
		this(zip, city, UseCode.Business);
		setStreet(street);
		setHouseNumber(houseNumber);
	}

	/**
	 * Erstellt ein Adress-Objekt
	 * 
	 * @param addressline1
	 *            Adresszeile 1
	 * @param addressline2
	 *            Adresszeile 2
	 * @param addressline3
	 *            Adresszeile 3
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public Address(String addressline1, String addressline2,
			String addressline3, String zip, String city, UseCode usage) {
		this(zip, city, usage);
		setAddressline1(addressline1);
		setAddressline2(addressline2);
		setAddressline3(addressline3);
	}

	/**
	 * Erstellt ein Adress-Objekt
	 * 
	 * @param street
	 *            Strasse (ohne Hausnummer)
	 * @param houseNumber
	 *            Hausnummer
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public Address(String street, String houseNumber, String zip, String city,
			UseCode usage) {
		this(zip, city, usage);
		setStreet(street);
		setHouseNumber(houseNumber);
	}

	/**
	 * Erstellt ein Adress-Objekt
	 * 
	 * @param addressline
	 *            Strasse und Hausnummer
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public Address(String addressline, String zip, String city, UseCode usage) {
		this(zip, city, usage);
		setAddressline1(addressline);
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
	private Address(String zip, String city, UseCode usage) {
		setCity(city);
		setZip(zip);
		switch (usage) {
		case Business:
			getUses().add(PostalAddressUse.WP);
			break;
		case Private:
			getUses().add(PostalAddressUse.HP);
			break;
		default:
			getUses().add(PostalAddressUse.WP);
			break;
		}
	}

	/**
	 * Liefert die Adress-Zeile 1
	 * 
	 * @return Adress-Zeile 1
	 */
	public String getAddressline1() {
		return getStreetAddressLines().get(0).getText();
	}

	/**
	 * Liefert die Adress-Zeile 2
	 * 
	 * @return Adress-Zeile 2
	 */
	public String getAddressline2() {
		return getStreetAddressLines().get(1).getText();
	}

	/**
	 * Liefert die Adress-Zeile 3
	 * 
	 * @return Adress-Zeile 3
	 */
	public String getAddressline3() {
		return getStreetAddressLines().get(2).getText();
	}

	/**
	 * Liefert den Ort
	 * 
	 * @return Ort
	 */
	public String getCity() {
		return getCities().get(0).getText();
	}

	/**
	 * Liefert die Hausnummer
	 * 
	 * @return Hausnummer
	 */
	public String getHouseNumber() {
		return getHouseNumbers().get(0).getText();
	}

	/**
	 * Liefert die Strasse
	 * 
	 * @return Strasse
	 */
	public String getStreet() {
		return getStreetNames().get(0).getText();
	}

	/**
	 * Liefert die Art der Adresse (Geschäft, Privat)
	 * 
	 * @return Art der Adresse
	 */
	public String getUsage() {
		return getUses().get(0).getLiteral();
	}

	/**
	 * Liefert die PLZ
	 * 
	 * @return PLZ
	 */
	public String getZip() {
		return getPostalCodes().get(0).getText();
	}

	/**
	 * Setzt die Adress-Zeile 1
	 * 
	 * @param addressline
	 *            Adress-Zeile 1
	 */
	public void setAddressline1(String addressline) {
		addStreetAddressLine(addressline);
	}

	/**
	 * Setzt die Adress-Zeile 2
	 * 
	 * @param addressline
	 *            Adress-Zeile 2
	 */
	public void setAddressline2(String addressline) {
		addStreetAddressLine(addressline);
	}

	/**
	 * Setzt die Adress-Zeile 3
	 * 
	 * @param addressline
	 *            Adress-Zeile 3
	 */
	public void setAddressline3(String addressline) {
		addStreetAddressLine(addressline);
	}

	/**
	 * Setzt den Ort
	 * 
	 * @param city
	 *            Ort
	 */
	public void setCity(String city) {
		addCity(city);
	}

	/**
	 * Setzt die Hausnummer
	 * 
	 * @param HouseNumber
	 *            Hausnummer
	 */
	public void setHouseNumber(String HouseNumber) {
		addHouseNumber(HouseNumber);
	}

	/**
	 * Setzt die Strasse
	 * 
	 * @param street
	 *            Strasse
	 */
	public void setStreet(String street) {
		addStreetName(street);
	}

	/**
	 * Setzt die PLZ
	 * 
	 * @param zip
	 *            PLZ
	 */
	public void setZip(String zip) {
		addPostalCode(zip);
	}

}
