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
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.AddressUse;
import org.ehc.cda.ch.enums.AdministrativeGender;
import org.ehc.cda.ch.enums.CodeSystems;
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
		// Create the RecordTarget, PatientRole and Patient
		setRecordTarget(CDAFactory.eINSTANCE.createRecordTarget());
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
			mPatient.setBirthTime(DateUtil.createTSFromEuroDate(birthDate));
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

	/**
	 * Weist dem Patienten eine Telefonnummer zu
	 * 
	 * @param phoneNr
	 *            Telefonnummer (nur internationale Rufnummer ohne Sonderzeichen
	 *            erlaubt). Beispiel: +41322345566
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft, Mobil)
	 */
	public void addPhone(String phoneNr, AddressUse usage) {
		getMdhtRecordTarget().getPatientRole().getTelecoms().add(Util.createTel(phoneNr, usage));
	}

	/**
	 * Weist der Person eine Webseite zu
	 * 
	 * @param eMail Webseite
	 * @param usage Verwendungszweck (Privat, Geschäft)
	 */
	public void addWebsite(String eMail, UseCode usage) {
		// Auto-generated method stub
		//TODO
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

	public Date getBirthDate() {
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

	/**
	 * Weist dem Patient eine eMail Adresse zu
	 * 
	 * @param eMail eMail Adresse
	 * @param usage Verwendungszweck (Privat, Geschäft)
	 */
	public void addEMail(String eMail, AddressUse usage) {
		mPatientRole.getTelecoms().add(Util.createEMail(eMail, usage));
	}
	/**
	 * Weist der Person eine Faxnummer zu
	 * 
	 * @param faxNr Faxnummer (nur internationale Rufnummer ohne Sonderzeichen erlaubt). Beispiel:
	 *        +41322345566
	 * @param usage Verwendungszweck (Privat, Geschäft)
	 */
	public void addFax(String faxNr, AddressUse usage) {
		mPatientRole.getTelecoms().add(Util.createFax(faxNr, usage));
	}
	
	/**
	 * Weist der Person eine GLN zu (wird vor allem für Ärzte gebraucht)
	 * 
	 * @param gln Global Location Number (GLN)
	 */
	public void addGLN(String gln) {
		addId(new Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
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

	public Name getName() {
		Name name = new Name (mPatient.getNames().get(0));
		return name;
	}

	public ArrayList<Name> getNames() {
		ArrayList<Name> nl = new ArrayList<Name>();
		for (PN mName: mPatient.getNames()) {
			Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}

	private Date parseDate(String value) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(value);
	}

	public void setRecordTarget(RecordTarget mRecordTarget) {
		this.mRecordTarget = mRecordTarget;
	}
}
