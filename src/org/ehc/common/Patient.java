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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ehc.common.Address;
import org.ehc.common.Identificator;
import org.ehc.common.Name;
import org.ehc.common.Util;
import ch.ehc.cda.enums.AdministrativeGender;
import org.ehc.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

public class Patient extends Person {

	private RecordTarget mRecordTarget;

	/**
	 * Erstellt einen neuen Patienten
	 * 
	 * @param name
	 *            Name
	 * @param sex
	 *            Geschlecht
	 * @param birthDay
	 *            Geburtsdatum
	 */
	public Patient(Name name, AdministrativeGender sex, Date birthDay) {
		this(name, sex, DateFormat.getDateInstance().format(birthDay));
	}

	/**
	 * Erstellt einen neuen Patienten
	 * 
	 * @param name
	 *            Name
	 * @param sex
	 *            Geschlecht
	 * @param birthDate
	 *            Geburtsdatum (als Text) Beispiel:20.05.1967
	 */
	public Patient(Name name, AdministrativeGender sex, String birthDate) {
	  super(name.getGivenName(), name.getFamilyName());
		// Create the patientRole
		setRecordTarget(CDAFactory.eINSTANCE.createRecordTarget());
		PatientRole patientRole = CDAFactory.eINSTANCE.createPatientRole();
		getRecordTarget().setPatientRole(patientRole);

		// Create the Patient
		org.openhealthtools.mdht.uml.cda.Patient patient = CDAFactory.eINSTANCE
				.createPatient();
		patientRole.setPatient(patient);

		// Create and fill gender
		patient.setAdministrativeGenderCode((CE) sex.getCE());

		// Fill Patient Name
		patient.getNames().add(name.getPn());

		// Create and fill birth date
		try {
			patient.setBirthTime(DateUtil.createTSFromEuroDate(birthDate));
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Constructor (used when deserializing CDA document).
	 * 
	 * @param recordTarget
	 */
	protected Patient(RecordTarget recordTarget) {
		this.mRecordTarget = recordTarget;
	}

	/**
	 * Fügt eine Adresse hinzu
	 * 
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		getRecordTarget().getPatientRole().getAddrs().add(address);
	}

	/**
	 * Fügt einen Identifikator hinzu
	 * 
	 * @param identificator
	 *            Identificator
	 */
	public void addID(Identificator identificator) {
		II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(identificator.getRoot());
		id.setExtension(identificator.getExtension());
		getRecordTarget().getPatientRole().getIds().add(id);
	}

	/**
	 * Weist dem Patienten eine Telefonnummer zu
	 * 
	 * @param phoneNr
	 *            Telefonnummer (nur internationale Rufnummer ohne Sonderzeichen
	 *            erlaubt). Beispiel: +41322345566
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft, Mobil)
	 */
	public void addPhone(String phoneNr, UseCode usage) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		TelecommunicationAddressUse useCode = TelecommunicationAddressUse.HP;
		switch (usage) {
		case Private:
			useCode = TelecommunicationAddressUse.HP;
			break;
		case Business:
			useCode = TelecommunicationAddressUse.WP;
			break;
		case Mobile:
			useCode = TelecommunicationAddressUse.MC;
		default:
			useCode = TelecommunicationAddressUse.HP;
			break;
		}
		tel.getUses().add(useCode);
		tel.setValue("tel:" + phoneNr);
		getRecordTarget().getPatientRole().getTelecoms().add(tel);
	}

	public RecordTarget getRecordTarget() {
		return this.mRecordTarget;
	}

	public void setRecordTarget(RecordTarget mRecordTarget) {
		this.mRecordTarget = mRecordTarget;
	}

	public Name getName() {
		PN pn = getPatient().getNames().get(0);
		return new Name(pn);
	}
	
	public Date getBirthDate() {
		try {
			TS birthTime = getPatient().getBirthTime();
			String value = birthTime.getValue();
			return parseDate(value);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Cannot convert birthdate", e);
		}
	}
	
	public AdministrativeGender getGenderCode() {
		CE code = getPatient().getAdministrativeGenderCode();
		if ("M".equals(code.getCode())) {
			return AdministrativeGender.MALE;
		} else if ("F".equals(code.getCode())) {
			return AdministrativeGender.FEMALE;
		} else {
			return AdministrativeGender.UNDIFFERENTIATED;
		}
	}
	
	private Date parseDate(String value) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(value);
	}
	
	private org.openhealthtools.mdht.uml.cda.Patient getPatient() {
		return mRecordTarget.getPatientRole().getPatient();
	}

	public Address getAddress() {
		AD ad = mRecordTarget.getPatientRole().getAddrs().get(0);
		return convertAddress(ad);
	}

	private Address convertAddress(AD ad) {
		String street = ad.getStreetNames().get(0).getText();
		String houseNumber = ad.getHouseNumbers().get(0).getText();
		String zip = ad.getPostalCodes().get(0).getText();
		String city = ad.getCities().get(0).getText();
		
		return new Address(street, houseNumber, zip, city);
	}
}
