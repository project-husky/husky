/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.NullFlavor;
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
	private final AD mAd;

	public Address() {
		mAd = DatatypesFactory.eINSTANCE.createAD();
	}

	/**
	 * <div class="en">Instantiates a new address.</div>
	 * <div class="de">Instantiiert eine neue Adresse</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param adress
	 *            <br>
	 *            <div class="de">Adresse</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Address(AD adress) {
		mAd = adress;
	}

	public Address(NullFlavor nullFlavor) {
		org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor nf = org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor
				.get(nullFlavor.getCodeValue());
		mAd = DatatypesFactory.eINSTANCE.createAD();
		mAd.setNullFlavor(nf);
		mAd.addPostalCode("");
		mAd.addCity("");
		mAd.addCountry("");
		mAd.getPostalCodes().get(0).setNullFlavor(nf);
		mAd.getCities().get(0).setNullFlavor(nf);
		mAd.getCountries().get(0).setNullFlavor(nf);
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
	public Address(String zip, String city, AddressUse usage) {
		mAd = DatatypesFactory.eINSTANCE.createAD();
		setCityAndZip(zip, city, usage);
	}

	/**
	 * Erstellt ein Adress-Objekt.
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
	public Address(String addressline, String zip, String city, AddressUse usage) {
		mAd = DatatypesFactory.eINSTANCE.createAD();
		setAddressline1(addressline);
		setCityAndZip(zip, city, usage);
	}

	/**
	 * Erstellt ein Adress-Objekt ohne UseCode (Wird oft für Organisationen
	 * benötigt).
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
		mAd = DatatypesFactory.eINSTANCE.createAD();
		setStreet(street);
		if (houseNumber != null)
			if (!"".equals(houseNumber))
				setHouseNumber(houseNumber);
		setCityAndZip(zip, city, AddressUse.PRIVATE);
	}

	/**
	 * Erstellt ein Adress-Objekt.
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
	public Address(String street, String houseNumber, String zip, String city, AddressUse usage) {
		mAd = DatatypesFactory.eINSTANCE.createAD();
		setStreet(street);
		if (houseNumber != null)
			if (!"".equals(houseNumber))
				setHouseNumber(houseNumber);
		setCityAndZip(zip, city, usage);
	}

	/**
	 * Erstellt ein Adress-Objekt.
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
	public Address(String addressline1, String addressline2, String addressline3, String zip,
			String city, AddressUse usage) {
		this(zip, city, usage);
		setAddressline1(addressline1);
		setAddressline2(addressline2);
		setAddressline3(addressline3);
	}

	/**
	 * <div class="en">Copy mdht adress.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
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
		if (mAd.getStreetAddressLines() != null && !mAd.getStreetAddressLines().isEmpty()) {
			return mAd.getStreetAddressLines().get(0).getText();
		}
		return null;
	}

	/**
	 * Liefert die Adress-Zeile 2.
	 *
	 * @return Adress-Zeile 2
	 */
	public String getAddressline2() {
		if (mAd.getStreetAddressLines() != null && mAd.getStreetAddressLines().size() > 1) {
			return mAd.getStreetAddressLines().get(1).getText();
		} else {
			return null;
		}
	}

	/**
	 * Liefert die Adress-Zeile 3.
	 *
	 * @return Adress-Zeile 3
	 */
	public String getAddressline3() {
		if (mAd.getStreetAddressLines() != null && mAd.getStreetAddressLines().size() > 2) {
			return mAd.getStreetAddressLines().get(2).getText();
		} else {
			return null;
		}
	}

	/**
	 * Liefert den Ort.
	 *
	 * @return Ort
	 */
	public String getCity() {
		if (mAd.getCities() != null && !mAd.getCities().isEmpty()) {
			return mAd.getCities().get(0).getText();
		} else {
			return null;
		}
	}

	/**
	 * Returns the Country
	 *
	 * @return Country
	 */
	public String getCountry() {
		if (mAd.getCountries() != null) {
			if (mAd.getCountries().get(0) != null) {
				return mAd.getCountries().get(0).getText();
			}
		}
		return null;
	}

	/**
	 * Liefert die Hausnummer.
	 *
	 * @return Hausnummer
	 */
	public String getHouseNumber() {
		if (mAd.getHouseNumbers() != null && !mAd.getHouseNumbers().isEmpty()) {
			return mAd.getHouseNumbers().get(0).getText();
		} else {
			return null;
		}
	}

	/**
	 * <div class="en">Gets the mdht adress.</div> <div class="de">Liefert mdht
	 * adress.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return AD <div class="en">the mdht adress</div>
	 */
	public AD getMdhtAdress() {
		return mAd;
	}

	/**
	 * Returns the State
	 *
	 * @return State
	 */
	public String getState() {
		if (mAd.getStates() != null && !mAd.getStates().isEmpty()) {
			return mAd.getStates().get(0).getText();
		}
		return null;
	}

	/**
	 * Liefert die Strasse.
	 *
	 * @return Strasse
	 */
	public String getStreet() {
		if (mAd.getStreetNames() != null && !mAd.getStreetNames().isEmpty()) {
			return mAd.getStreetNames().get(0).getText();
		} else {
			return null;
		}
	}

	/**
	 * Liefert die Art der Adresse (Geschäft, Privat).
	 *
	 * @return Art der Adresse
	 */
	public String getUsage() {
		if (mAd.getUses() != null && !mAd.getUses().isEmpty()) {
			return mAd.getUses().get(0).getLiteral();
		} else {
			return null;
		}
	}

	/**
	 * Liefert die PLZ.
	 *
	 * @return PLZ
	 */
	public String getZip() {
		if (mAd.getPostalCodes() != null && !mAd.getPostalCodes().isEmpty()) {
			return mAd.getPostalCodes().get(0).getText();
		} else {
			return null;
		}
	}

	/**
	 * Setzt die Adress-Zeile 1.
	 *
	 * @param addressline
	 *            Adress-Zeile 1
	 */
	public void setAddressline1(String addressline) {
		if (addressline != null)
			mAd.addStreetAddressLine(addressline);
	}

	/**
	 * Setzt die Adress-Zeile 2.
	 *
	 * @param addressline
	 *            Adress-Zeile 2
	 */
	public void setAddressline2(String addressline) {
		if (addressline != null)
			mAd.addStreetAddressLine(addressline);
	}

	/**
	 * Setzt die Adress-Zeile 3.
	 *
	 * @param addressline
	 *            Adress-Zeile 3
	 */
	public void setAddressline3(String addressline) {
		if (addressline != null)
			mAd.addStreetAddressLine(addressline);
	}

	/**
	 * Setzt den Ort.
	 *
	 * @param city
	 *            Ort
	 */
	public void setCity(String city) {
		mAd.addCity(city);
	}

	private void setCityAndZip(String zip, String city, AddressUse usage) {
		setZip(zip);
		setCity(city);
		setUsage(usage);
	}

	/**
	 * Sets the country <div class="de">Setzt den Ort</div>
	 *
	 * @param country
	 *            the country
	 */
	public void setCountry(String country) {
		if (country != null) {
			mAd.getCountries().clear();
			mAd.addCountry(country);
		}
	}

	/**
	 * Sets the house number.<div class="de">Setzt die Hausnummer.</div>
	 *
	 * @param houseNumber
	 *            the new house number
	 */
	public void setHouseNumber(String houseNumber) {
		if (houseNumber != null)
			if (!"".equals(houseNumber))
				mAd.addHouseNumber(houseNumber);
	}

	/**
	 * <div class="en">Sets the state</div><div class="de">Setzt den
	 * Kanton</div>.
	 *
	 * @param state
	 *            the new state
	 */
	public void setState(String state) {
		if (state != null) {
			mAd.addState(state);
		}
	}

	/**
	 * Setzt die Strasse.
	 *
	 * @param street
	 *            Strasse
	 */
	public void setStreet(String street) {
		mAd.addStreetName(street);
	}

	public void setUsage(AddressUse usage) {
		if (usage != null) {
			switch (usage) {
			case BUSINESS:
				mAd.getUses().add(PostalAddressUse.WP);
				break;
			case PRIVATE:
				mAd.getUses().add(PostalAddressUse.HP);
				break;
			case PUBLIC:
				mAd.getUses().add(PostalAddressUse.PUB);
				break;
			default:
				mAd.getUses().add(PostalAddressUse.WP);
				break;
			}
		}
	}

	/**
	 * Setzt die PLZ.
	 *
	 * @param zip
	 *            PLZ
	 */
	public void setZip(String zip) {
		mAd.addPostalCode(zip);
	}

	@Override
	public String toString() {
		return "Address [mAd=" + mAd + "]";
	}

}
