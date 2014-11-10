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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

import ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.AdministrativeGenderCode;
import ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.UseCode;

public class Patient {

	RecordTarget mRecordTarget;

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
	public Patient(Name name, AdministrativeGenderCode sex, Date birthDay) {
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
	public Patient(Name name, AdministrativeGenderCode sex, String birthDate) {
		// Create the patientRole
		mRecordTarget = CDAFactory.eINSTANCE.createRecordTarget();
		PatientRole patientRole = CDAFactory.eINSTANCE.createPatientRole();
		mRecordTarget.setPatientRole(patientRole);

		// Create the Patient
		org.openhealthtools.mdht.uml.cda.Patient patient = CDAFactory.eINSTANCE
				.createPatient();
		patientRole.setPatient(patient);

		// Create and fill gender
		patient.setAdministrativeGenderCode(CdaChUtil
				.createAdministrativeGenderCode(sex));

		// Fill Patient Name
		patient.getNames().add(name.mPn);

		// Create and fill birth date
		try {
			patient.setBirthTime(CdaChUtil.createTSFromEuroDate(birthDate));
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Fügt eine Adresse hinzu
	 * 
	 * @param address
	 *            Adresse
	 */
	public void cAddAddress(Address address) {
		mRecordTarget.getPatientRole().getAddrs().add(address);
	}

	/**
	 * Fügt einen Identifikator hinzu
	 * 
	 * @param identificator
	 *            Identificator
	 */
	public void cAddID(Identificator identificator) {
		II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(identificator.cGetRoot());
		id.setExtension(identificator.cGetExtension());
		mRecordTarget.getPatientRole().getIds().add(id);
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
	public void cAddPhone(String phoneNr, UseCode usage) {
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
		mRecordTarget.getPatientRole().getTelecoms().add(tel);
	}
}
