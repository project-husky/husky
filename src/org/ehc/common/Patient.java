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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.AdministrativeGender;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;

public class Patient extends Person {

	private RecordTarget mRecordTarget;
	private PatientRole mPatientRole;
	private org.openhealthtools.mdht.uml.cda.Patient mPatient;

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
		// Create the RecordTarget, PatientRole and Patient
		mRecordTarget = CDAFactory.eINSTANCE.createRecordTarget();
		mPatientRole = CDAFactory.eINSTANCE.createPatientRole();
		mPatient = CDAFactory.eINSTANCE.createPatient();

		mPatientRole.setPatient(mPatient);
		mRecordTarget.setPatientRole(mPatientRole);

		// Create and fill gender
		mPatient.setAdministrativeGenderCode(sex.getCE());

		// Fill Patient Name
		mPatient.getNames().add(name.getMdhtPn());

		// Create and fill birth date
		try {
			mPatient.setBirthTime(DateUtil.createTSFromEuroDate(birthDay));
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Erstellt einen neuen Patienten inkl. einer Patienten Id. Wenn es sich bei dem Dokument um einen Impfausweis handelt dann MUSS dieser Konstruktor verwendet werden.
	 * 
	 * @param name
	 *            Name
	 * @param sex
	 *            Geschlecht
	 * @param birthDay
	 *            Geburtsdatum
	 */
	public Patient(Name name, AdministrativeGender sex, Date birthDay, Identificator id) {
		// Create the RecordTarget, PatientRole and Patient
		mRecordTarget = CDAFactory.eINSTANCE.createRecordTarget();
		mPatientRole = CDAFactory.eINSTANCE.createPatientRole();
		mPatient = CDAFactory.eINSTANCE.createPatient();

		mPatientRole.setPatient(mPatient);
		mRecordTarget.setPatientRole(mPatientRole);

		// Gender
		setGender(sex);

		// Patient Name
		addName(name);

		// Day of birth
		setBirthday(birthDay);

		// Id
		addId(id);
	}

	/**
	 * Constructor (used when deserializing CDA document).
	 * 
	 * @param recordTarget
	 */
	protected Patient(RecordTarget recordTarget) {
		mRecordTarget = recordTarget;
	}

	/**
	 * Fügt eine Adresse hinzu
	 * 
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		mPatientRole.getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Fügt einen Identifikator hinzu
	 * 
	 * @param identificator
	 *            Identificator
	 */
	public void addId(Identificator identificator) {
		II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(identificator.getRoot());
		id.setExtension(identificator.getExtension());
		mPatientRole.getIds().add(id);
	}

	public void addName(Name name) {
		mPatient.getNames().add(name.copyMdhtPn());
	}

	public org.openhealthtools.mdht.uml.cda.Patient copyMdhtPatient() {
		return EcoreUtil.copy(mPatient);
	}

	public PatientRole copyMdhtPatientRole() {
		return EcoreUtil.copy(mPatientRole);
	}

	public RecordTarget copyMdhtRecordTarget() {
		return EcoreUtil.copy(mRecordTarget);
	}

	public Address getAddress() {
		AD mAd = mPatientRole.getAddrs().get(0);
		Address address = new Address(mAd); 
		return address;
	}

	public ArrayList<Address> getAddresses() {
		ArrayList<Address> al = new ArrayList<Address>();
		for (AD mAddress: mPatientRole.getAddrs()) {
			Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	public Date getBirthday() {
		try {
			TS birthTime = getMdhtPatient().getBirthTime();
			String value = birthTime.getValue();
			return parseDate(value);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Cannot convert birthdate", e);
		}
	}

	public AdministrativeGender getGenderCode() {
		CE code = getMdhtPatient().getAdministrativeGenderCode();
		return AdministrativeGender.getEnum(code.getCode());
	}

	public ArrayList<Identificator> getIds() {
		ArrayList<Identificator> il = new ArrayList<Identificator>();
		for (II mId: mPatientRole.getIds()) {
			Identificator id = new Identificator(mId);
			il.add(id);
		}
		return il;
	}


	public org.openhealthtools.mdht.uml.cda.Patient getMdhtPatient() {
		return mPatient;
	}

	public PatientRole getMdhtPatientRole() {
		return mPatientRole;
	}

	public RecordTarget getMdhtRecordTarget() {
		return mRecordTarget;
	}

	@Override
	public Name getName() {
		Name name = new Name (mPatient.getNames().get(0));
		return name;
	}

	@Override
	public ArrayList<Name> getNames() {
		ArrayList<Name> nl = new ArrayList<Name>();
		for (PN mName: mPatient.getNames()) {
			Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}

	public Telecoms getTelecoms() {
		Telecoms telecoms = new Telecoms(mPatientRole.getTelecoms());
		return telecoms;
	}

	private Date parseDate(String value) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(value);
	}

	public void setBirthday(Date birthDay) {
		try {
			mPatient.setBirthTime(DateUtil.createTSFromEuroDate(birthDay));
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setGender(AdministrativeGender sex) {
		mPatient.setAdministrativeGenderCode(sex.getCE());
	}

	public void setTelecoms(Telecoms telecoms) {
		mPatientRole.getTelecoms().addAll(telecoms.getMdhtTelecoms());
	}
}
