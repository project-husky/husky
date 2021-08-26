/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.II;
import org.ehealth_connector.common.hl7cdar2.PN;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Patient;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040PatientRole;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget;
import org.ehealth_connector.common.hl7cdar2.TEL;
import org.ehealth_connector.common.hl7cdar2.TS;
import org.ehealth_connector.common.mdht.enums.AdministrativeGender;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * <div class="en">Class Patient</div>
 */
public class Patient extends Person {

	private final POCDMT000040RecordTarget mRecordTarget;
	protected POCDMT000040PatientRole mPatientRole;
	protected POCDMT000040Patient mPatient;
	private Boolean isNonHumenSubject = false;

	/**
	 * CDA R2 extensions for the PIX Profile as proposed on
	 * http://wiki.hl7.org/index.php?title=CDA_R2_Extensions
	 */

	/**
	 * The multipleBirthInd extension is used to record that the recordTarget or
	 * subjectPerson is part of a multiple birth.
	 */
	private Boolean multipleBirthInd;

	/**
	 * The multipleBirthOrderNumber extension is used to record the order number
	 * within a multiple birth that the recordTarget or subjectPerson was born
	 * in.
	 */
	private Integer multipleBirthOrderNumber;

	/**
	 * The deceasedInd extension is used to record that the recordTarget or
	 * subjectPerson is deceased.
	 */
	private Boolean deceasedInd;

	/**
	 * The deceasedTime extension is used to record the time of death for the
	 * recordTarget or subjectPerson.
	 */
	private Date deceasedTime;

	/**
	 * Mother's Maiden Name Citing Keith Boone, the CDA Book p237: in CDA
	 * Release 2.0 there is no appropriate place beneath <recordTarget> where
	 * this information would appear instead a <participant> would need to be
	 * added to the CDA header that identified the mother of the patient: only
	 * use at the moment in the OHT PIX communication, for CDA no functionality
	 * yet
	 */
	private String mothersMaidenName;

	/**
	 * nation code for pix v3
	 */
	private String nation;

	/**
	 * employeeOccupationCode for pix v3
	 */
	private String employeeOccupation;

	/**
	 * religious Affiliation
	 */
	private String religiousAffiliation;

	/**
	 * Erstellt einen neuen Patienten.
	 *
	 */
	public Patient() {
		// Create the RecordTarget, PatientRole and Patient
		mRecordTarget = new POCDMT000040RecordTarget();
		mPatientRole = new POCDMT000040PatientRole();
		mPatient = new POCDMT000040Patient();

		mPatientRole.setPatient(mPatient);
		mRecordTarget.setPatientRole(mPatientRole);
	}

	/**
	 * Erstellt einen neuen Patienten.
	 *
	 * @param name
	 *            Name
	 * @param sex
	 *            Geschlecht
	 * @param birthDay
	 *            Geburtsdatum
	 */
	public Patient(Name name, AdministrativeGender sex, Date birthDay) {
		this();

		// Create and fill gender
		if (sex != null) {
			mPatient.setAdministrativeGenderCode(sex.getCE());
		}

		// Fill Patient Name
		mPatient.getName().add(name.getHl7CdaR2Pn());

		// Create and fill birth date
		if (birthDay != null) {
			try {
				mPatient.setBirthTime(DateUtil.date2TsDateOnly(birthDay));
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Erstellt einen neuen Patienten inkl. einer Patienten Id. Wenn es sich bei
	 * dem Dokument um einen Impfausweis handelt dann MUSS dieser Konstruktor
	 * verwendet werden.
	 *
	 * @param name
	 *            Name
	 * @param sex
	 *            Geschlecht
	 * @param birthDay
	 *            Geburtsdatum
	 * @param id
	 *            <br>
	 *            <div class="de">ID</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Patient(Name name, AdministrativeGender sex, Date birthDay, Identificator id) {
		// Create the RecordTarget, PatientRole and Patient
		mRecordTarget = new POCDMT000040RecordTarget();
		mPatientRole = new POCDMT000040PatientRole();
		mPatient = new POCDMT000040Patient();

		mPatientRole.setPatient(mPatient);
		mRecordTarget.setPatientRole(mPatientRole);

		// Gender
		setAdministrativeGender(sex);

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
	 *            <br>
	 *            <div class="en"> record target</div>
	 */
	public Patient(POCDMT000040RecordTarget recordTarget) {
		mRecordTarget = recordTarget;
		mPatientRole = recordTarget.getPatientRole();
		mPatient = recordTarget.getPatientRole().getPatient();
	}

	/**
	 * Fügt eine Adresse hinzu.
	 *
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		if (mPatientRole.getAddr() != null) {
			mPatientRole.getAddr().add(address.getHl7CdaR2Ad());
		}
	}

	/**
	 * Fügt einen Identifikator hinzu.
	 *
	 * @param identificator
	 *            Identificator
	 */
	public void addId(Identificator identificator) {
		final II id = new II();
		id.setRoot(identificator.getRoot());
		id.setExtension(identificator.getExtension());
		mPatientRole.getId().add(id);
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            <br>
	 *            <div class="de"> name</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	@Override
	public void addName(Name name) {
		mPatient.getName().add(name.getHl7CdaR2Pn());
	}

	/**
	 * <div class="en">Gets the address.</div> <div class="de">Liefert die
	 * (erste) Adresse</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the address</div>
	 */
	public Address getAddress() {
		final var mAd = mPatientRole.getAddr().get(0);
		return new Address(mAd);
	}

	/**
	 * <div class="en">Gets the adresses.</div> <div class="de">Liefert alles
	 * Adressen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the adresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<>();
		for (final AD mAddress : mPatientRole.getAddr()) {
			al.add(new Address(mAddress));
		}
		return al;
	}

	/**
	 * <div class="en">Gets the gender code.</div> <div class="de">Liefert das
	 * Geschlecht</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the gender code</div>
	 */
	public AdministrativeGender getAdministrativeGenderCode() {
		final CE code = getMdhtPatient().getAdministrativeGenderCode();
		if (code == null) {
			return null;
		}
		return AdministrativeGender.getEnum(code.getCode());
	}

	/**
	 * <div class="en">Gets the birthday.</div> <div class="de">Liefert
	 * birthday.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Date <div class="en">the birthday</div>
	 */
	public Date getBirthday() {
		try {
			final TS birthTime = getMdhtPatient().getBirthTime();
			if (birthTime == null) {
				return null;
			}
			final String value = birthTime.getValue();
			return parseDate(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException("Cannot convert birthdate", e);
		}
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the complete name</div>
	 */
	@Override
	public String getCompleteName() {
		String retVal = "";
		if (mPatient.getName() != null) {
			if (mPatient.getName().size() > 0) {
				final Name name = new Name(mPatient.getName().get(0));
				retVal = name.getFullName();
			}
		}
		return retVal;
	}

	/**
	 * Gets the deceased Indicator
	 *
	 * @return the deceased ind
	 */
	public Boolean getDeceasedInd() {
		return deceasedInd;
	}

	/**
	 * Gets the deceased time.
	 *
	 * @return the deceased time
	 */
	public Date getDeceasedTime() {
		return deceasedTime;
	}

	/**
	 * Gets the employee occupation.
	 *
	 * @return the employee occupation
	 */
	public String getEmployeeOccupation() {
		return employeeOccupation;
	}

	/**
	 * <div class="en">Gets the ids.</div> <div class="de">Liefert alle
	 * ids.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<Identificator> getIds() {
		List<Identificator> ids = new LinkedList<>();
		for (II id : mPatientRole.getId()) {
			ids.add(new Identificator(id));
		}

		return ids;
	}

	/**
	 * <div class="en">Gets the mdht patient.</div> <div class="de">Liefert mdht
	 * patient.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.Patient <div class="en">the mdht
	 *         patient</div>
	 */
	public POCDMT000040Patient getMdhtPatient() {
		return mPatient;
	}

	/**
	 * <div class="en">Gets the mdht patient role.</div> <div class="de">Liefert
	 * mdht patient role.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return PatientRole <div class="en">the mdht patient role</div>
	 */
	public POCDMT000040PatientRole getMdhtPatientRole() {
		return mPatientRole;
	}

	/**
	 * <div class="en">Gets the mdht record target.</div>
	 * <div class="de">Liefert mdht record target.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return RecordTarget <div class="en">the mdht record target</div>
	 */
	public POCDMT000040RecordTarget getMdhtRecordTarget() {
		return mRecordTarget;
	}

	/**
	 * Gets the mothers maiden name.
	 *
	 * @return the mothers maiden name
	 */
	public String getMothersMaidenName() {
		return mothersMaidenName;
	}

	/**
	 * Gets the multiple birth Indictator
	 *
	 * @return the multiple birth ind
	 */
	public Boolean getMultipleBirthInd() {
		return multipleBirthInd;
	}

	/**
	 * Gets the multiple birth order number.
	 *
	 * @return the multiple birth order number
	 */
	public Integer getMultipleBirthOrderNumber() {
		return multipleBirthOrderNumber;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.ehealth_connector.common.Person#getName()
	 */
	@Override
	public Name getName() {
		return new Name(mPatient.getName().get(0));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.ehealth_connector.common.Person#getNames()
	 */
	@Override
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<>();
		for (final PN mName : mPatient.getName()) {
			nl.add(new Name(mName));
		}
		return nl;
	}

	/**
	 * Gets the nation.
	 *
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * Gets the provider organization.
	 *
	 * @return the provider organization
	 */
	public Organization getProviderOrganization() {
		return new Organization(mPatientRole.getProviderOrganization());
	}

	/**
	 * Gets the religious affiliation.
	 *
	 * @return the religious affiliation
	 */
	public String getReligiousAffiliation() {
		return religiousAffiliation;
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public List<Telecom> getTelecoms() {
		List<Telecom> telecoms = new LinkedList<>();

		for (TEL tel : mPatientRole.getTelecom()) {
			telecoms.add(new Telecom(tel));
		}

		return telecoms;
	}

	/**
	 * Indicates whether this Patient is not a human patient but a non human
	 * subject
	 *
	 * @return true for non human subjects, false for human patients
	 */
	public Boolean isNonHumenSubject() {
		return isNonHumenSubject;
	}

	private Date parseDate(String value) throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(value);
	}

	/**
	 * <div class="en">Sets the gender.</div> <div class="de">Setzt
	 * gender.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param sex
	 *            <div class="en">the new (administrative) gender</div>
	 *            <div class="de">das neue (administrative) Geschlecht</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public void setAdministrativeGender(AdministrativeGender sex) {
		mPatient.setAdministrativeGenderCode(sex.getCE());
	}

	/**
	 * <div class="en">Sets the birthday.</div> <div class="de">Setzt
	 * birthday.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param birthDay
	 *            <div class="en">the new birthday</div> <div class="de">das
	 *            neue birthday.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setBirthday(Date birthDay) {
		mPatient.setBirthTime(DateUtil.date2TsDateOnly(birthDay));
	}

	/**
	 * Sets the deceased Indicator
	 *
	 * @param deceasedInd
	 *            the new deceased ind
	 */
	public void setDeceasedInd(Boolean deceasedInd) {
		this.deceasedInd = deceasedInd;
	}

	/**
	 * Sets the deceased time.
	 *
	 * @param deceasedTime
	 *            the new deceased time
	 */
	public void setDeceasedTime(Date deceasedTime) {
		this.deceasedTime = deceasedTime;
	}

	/**
	 * Sets the employee occupation.
	 *
	 * @param employeeOccupation
	 *            the new employee occupation
	 */
	public void setEmployeeOccupation(String employeeOccupation) {
		this.employeeOccupation = employeeOccupation;
	}

	/**
	 * Configures the eHC Patient objects purpose: It is a human patient
	 * (default setting)
	 */
	public void setIsHumanPatient() {
		this.isNonHumenSubject = false;
	}

	/**
	 * Configures the eHC Patient objects purpose: It is a non human subject
	 */
	public void setIsNonHumenSubject() {
		this.isNonHumenSubject = true;
	}

	/**
	 * Sets the mothers maiden name.
	 *
	 * @param mothersMaidenName
	 *            the new mothers maiden name
	 */
	public void setMothersMaidenName(String mothersMaidenName) {
		this.mothersMaidenName = mothersMaidenName;
	}

	/**
	 * Sets the multiple birth Indicator
	 *
	 * @param multipleBirthInd
	 *            the new multiple birth ind
	 */
	public void setMultipleBirthInd(Boolean multipleBirthInd) {
		this.multipleBirthInd = multipleBirthInd;
	}

	/**
	 * Sets the multiple birth order number.
	 *
	 * @param multipleBirthOrderNumber
	 *            the new multiple birth order number
	 */
	public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
		this.multipleBirthOrderNumber = multipleBirthOrderNumber;
	}

	/**
	 * Sets the nation.
	 *
	 * @param nation
	 *            the new nation
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * Sets the provider organization.
	 *
	 * @param organization
	 *            the new provider organization
	 */
	public void setProviderOrganization(Organization organization) {
		mPatientRole.setProviderOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
	}

	/**
	 * Sets the religious affiliation.
	 *
	 * @param religiousAffiliation
	 *            the new religious affiliation
	 */
	public void setReligiousAffiliation(String religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

	/**
	 * <div class="en">Sets the telecoms.</div> <div class="de">Setzt
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param telecoms
	 *            <div class="en">the new telecoms</div> <div class="de">das
	 *            neue telecoms.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setTelecoms(List<Telecom> telecoms) {

		for (Telecom tel : telecoms) {
			if (tel != null) {
				mPatientRole.getTelecom().add(tel.getHl7CdaR2Tel());
			}
		}
	}

}
