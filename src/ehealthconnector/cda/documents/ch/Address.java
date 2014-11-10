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

package ehealthconnector.cda.documents.ch;

import org.openhealthtools.mdht.uml.hl7.datatypes.impl.ADImpl;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;

import ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.UseCode;

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
		this.cSetStreet(street);
		this.cSetHouseNumber(houseNumber);
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
		this.cSetAddressline1(addressline1);
		this.cSetAddressline2(addressline2);
		this.cSetAddressline3(addressline3);
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
		this.cSetStreet(street);
		this.cSetHouseNumber(houseNumber);
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
		this.cSetAddressline1(addressline);
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
		this.cSetCity(city);
		this.cSetZip(zip);
		switch (usage) {
		case Business:
			this.getUses().add(PostalAddressUse.WP);
			break;
		case Private:
			this.getUses().add(PostalAddressUse.HP);
			break;
		default:
			this.getUses().add(PostalAddressUse.WP);
			break;
		}
	}

	/**
	 * Liefert die Adress-Zeile 1
	 * 
	 * @return Adress-Zeile 1
	 */
	public String cGetAddressline1() {
		return this.getStreetAddressLines().get(0).getText();
	}

	/**
	 * Liefert die Adress-Zeile 2
	 * 
	 * @return Adress-Zeile 2
	 */
	public String cGetAddressline2() {
		return this.getStreetAddressLines().get(1).getText();
	}

	/**
	 * Liefert die Adress-Zeile 3
	 * 
	 * @return Adress-Zeile 3
	 */
	public String cGetAddressline3() {
		return this.getStreetAddressLines().get(2).getText();
	}

	/**
	 * Liefert den Ort
	 * 
	 * @return Ort
	 */
	public String cGetCity() {
		return this.getCities().get(0).getText();
	}

	/**
	 * Liefert die Hausnummer
	 * 
	 * @return Hausnummer
	 */
	public String cGetHouseNumber() {
		return this.getHouseNumbers().get(0).getText();
	}

	/**
	 * Liefert die Strasse
	 * 
	 * @return Strasse
	 */
	public String cGetStreet() {
		return this.getStreetNames().get(0).getText();
	}

	/**
	 * Liefert die Art der Adresse (Geschäft, Privat)
	 * 
	 * @return Art der Adresse
	 */
	public String cGetUsage() {
		return this.getUses().get(0).getLiteral();
	}

	/**
	 * Liefert die PLZ
	 * 
	 * @return PLZ
	 */
	public String cGetZip() {
		return this.getPostalCodes().get(0).getText();
	}

	/**
	 * Setzt die Adress-Zeile 1
	 * 
	 * @param addressline
	 *            Adress-Zeile 1
	 */
	public void cSetAddressline1(String addressline) {
		this.addStreetAddressLine(addressline);
	}

	/**
	 * Setzt die Adress-Zeile 2
	 * 
	 * @param addressline
	 *            Adress-Zeile 2
	 */
	public void cSetAddressline2(String addressline) {
		this.addStreetAddressLine(addressline);
	}

	/**
	 * Setzt die Adress-Zeile 3
	 * 
	 * @param addressline
	 *            Adress-Zeile 3
	 */
	public void cSetAddressline3(String addressline) {
		this.addStreetAddressLine(addressline);
	}

	/**
	 * Setzt den Ort
	 * 
	 * @param city
	 *            Ort
	 */
	public void cSetCity(String city) {
		this.addCity(city);
	}

	/**
	 * Setzt die Hausnummer
	 * 
	 * @param HouseNumber
	 *            Hausnummer
	 */
	public void cSetHouseNumber(String HouseNumber) {
		this.addHouseNumber(HouseNumber);
	}

	/**
	 * Setzt die Strasse
	 * 
	 * @param street
	 *            Strasse
	 */
	public void cSetStreet(String street) {
		this.addStreetName(street);
	}

	/**
	 * Setzt die PLZ
	 * 
	 * @param zip
	 *            PLZ
	 */
	public void cSetZip(String zip) {
		this.addPostalCode(zip);
	}

}
