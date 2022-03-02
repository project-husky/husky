/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.husky.common.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.PN;
import org.husky.common.hl7cdar2.POCDMT000040Patient;
import org.husky.common.hl7cdar2.POCDMT000040PatientRole;
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.utils.time.DateTimes;

/**
 * Class Patient
 */
public class Patient extends Person {

    private final POCDMT000040RecordTarget mRecordTarget;
    protected POCDMT000040PatientRole mPatientRole;
    protected POCDMT000040Patient mPatient;
    private Boolean isNonHumenSubject = false;

    /*
     * CDA R2 extensions for the PIX Profile as proposed on
     * http://wiki.hl7.org/index.php?title=CDA_R2_Extensions
     */

    /**
     * The multipleBirthInd extension is used to record that the recordTarget or subjectPerson is part of a multiple
     * birth.
     */
    private Boolean multipleBirthInd;

    /**
     * The multipleBirthOrderNumber extension is used to record the order number within a multiple birth that the
     * recordTarget or subjectPerson was born in.
     */
    private Integer multipleBirthOrderNumber;

    /**
     * The deceasedInd extension is used to record that the recordTarget or subjectPerson is deceased.
     */
    private Boolean deceasedInd;

    /**
     * The deceasedTime extension is used to record the time of death for the recordTarget or subjectPerson.
     */
    private Date deceasedTime;

    /**
     * Mother's Maiden Name Citing Keith Boone, the CDA Book p237: in CDA Release 2.0 there is no appropriate place
     * beneath {@code <recordTarget>} where this information would appear instead a {@code <participant>} would need to
     * be added to the CDA header that identified the mother of the patient: only use at the moment in the OHT PIX
     * communication, for CDA no functionality yet
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
     * @param name     Name
     * @param sex      Geschlecht
     * @param birthDay Geburtsdatum
     */
	public Patient(Name name, AdministrativeGender sex, Calendar birthDay) {
        this();

        // Create and fill gender
        if (sex != null) {
            mPatient.setAdministrativeGenderCode(sex.getCE());
        }

        // Fill Patient Name
        mPatient.getName().add(name.getHl7CdaR2Pn());

        // Create and fill birth date
        if (birthDay != null) {
			mPatient.setBirthTime(DateTimes.toDateTs(birthDay.toInstant(), birthDay.getTimeZone().toZoneId()));
        }
    }

    /**
     * Erstellt einen neuen Patienten inkl. einer Patienten Id. Wenn es sich bei dem Dokument um einen Impfausweis
     * handelt dann MUSS dieser Konstruktor verwendet werden.
     *
     * @param name     Name
     * @param sex      Geschlecht
     * @param birthDay Geburtsdatum
     * @param id       ID
     */
	public Patient(Name name, AdministrativeGender sex, Calendar birthDay, Identificator id) {
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
     * @param recordTarget record target
     */
    public Patient(POCDMT000040RecordTarget recordTarget) {
        mRecordTarget = recordTarget;
        mPatientRole = recordTarget.getPatientRole();
        mPatient = recordTarget.getPatientRole().getPatient();
    }

    /**
     * Fügt eine Adresse hinzu.
     *
     * @param address Adresse
     */
    public void addAddress(Address address) {
		mPatientRole.getAddr().add(address.getHl7CdaR2Ad());
    }

    /**
     * Fügt einen Identifikator hinzu.
     *
     * @param identificator Identificator
     */
    public void addId(Identificator identificator) {
        final var id = new II();
        id.setRoot(identificator.getRoot());
        id.setExtension(identificator.getExtension());
        mPatientRole.getId().add(id);
    }

	/**
	 * Adds a list of identificator
	 * 
	 * @param identificators list of identificator
	 */
	public void setIds(List<Identificator> identificators) {
		for (Identificator identificator : identificators) {
			if (identificator != null) {
				var id = new II();
				id.setRoot(identificator.getRoot());
				id.setExtension(identificator.getExtension());
				mPatientRole.getId().add(id);
			}
		}
	}

    /**
     * Adds the name.
     *
     * @param name name
     */
    @Override
    public void addName(Name name) {
        mPatient.getName().add(name.getHl7CdaR2Pn());
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        final var mAd = mPatientRole.getAddr().get(0);
        return new Address(mAd);
    }

    /**
     * Gets the adresses.
     *
     * @return the adresses
     */
    public List<Address> getAddresses() {
        final List<Address> al = new ArrayList<>();
        for (final AD mAddress : mPatientRole.getAddr()) {
            al.add(new Address(mAddress));
        }
        return al;
    }

    /**
     * Gets the gender code.
     *
     * @return the gender code
     */
    public AdministrativeGender getAdministrativeGenderCode() {
        final CE code = getMdhtPatient().getAdministrativeGenderCode();
        if (code == null) {
            return null;
        }
        return AdministrativeGender.getEnum(code.getCode());
    }

    /**
     * Gets the birthday.
     *
     * @return Date the birthday
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

	public LocalDate getBirthdayAsLocalDate() {
		final TS birthTime = getMdhtPatient().getBirthTime();
		if (birthTime == null) {
			return null;
		}

		return DateTimes.toLocalDate(birthTime);
	}

    /**
     * Sets the birthday.
     *
     * @param birthDay the new birthday
     */
	public void setBirthday(Calendar birthDay) {
		mPatient.setBirthTime(DateTimes.toDateTs(birthDay.toInstant(), birthDay.getTimeZone().toZoneId()));
    }

    /**
     * Sets the birthday.
     *
     * @param birthDay the new birthday
     */
    public void setBirthday(ZonedDateTime birthDay) {
		mPatient.setBirthTime(DateTimes.toDateTs(birthDay));
    }

    /**
     * Gets the complete name.
     *
     * @return the complete name
     */
    @Override
    public String getCompleteName() {
        var retVal = "";
		if (!mPatient.getName().isEmpty()) {
            final var name = new Name(mPatient.getName().get(0));
            retVal = name.getFullName();
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
     * Sets the deceased Indicator
     *
     * @param deceasedInd the new deceased ind
     */
    public void setDeceasedInd(Boolean deceasedInd) {
        this.deceasedInd = deceasedInd;
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
     * Sets the deceased time.
     *
     * @param deceasedTime the new deceased time
     */
    public void setDeceasedTime(Date deceasedTime) {
        this.deceasedTime = deceasedTime;
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
     * Sets the employee occupation.
     *
     * @param employeeOccupation the new employee occupation
     */
    public void setEmployeeOccupation(String employeeOccupation) {
        this.employeeOccupation = employeeOccupation;
    }

    /**
     * Gets the ids.
     *
     * @return the ids
     */
    public List<Identificator> getIds() {
        List<Identificator> ids = new LinkedList<>();
        for (II id : mPatientRole.getId()) {
            ids.add(new Identificator(id));
        }

        return ids;
    }

    /**
     * Gets the CDA R2 patient.
     *
     * @return the CDA R2 patient
     */
    public POCDMT000040Patient getMdhtPatient() {
        return mPatient;
    }

    /**
     * Gets the CDA R2 patient role.
     *
     * @return PatientRole the CDA R2 patient role
     */
    public POCDMT000040PatientRole getMdhtPatientRole() {
        return mPatientRole;
    }

    /**
     * Gets the CDA R2 record target.
     *
     * @return RecordTarget the CDA R2 record target
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
     * Sets the mothers maiden name.
     *
     * @param mothersMaidenName the new mothers maiden name
     */
    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
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
     * Sets the multiple birth Indicator
     *
     * @param multipleBirthInd the new multiple birth ind
     */
    public void setMultipleBirthInd(Boolean multipleBirthInd) {
        this.multipleBirthInd = multipleBirthInd;
    }

    /**
     * Gets the multiple birth order number.
     *
     * @return the multiple birth order number
     */
    public Integer getMultipleBirthOrderNumber() {
        return multipleBirthOrderNumber;
    }

    /**
     * Sets the multiple birth order number.
     *
     * @param multipleBirthOrderNumber the new multiple birth order number
     */
    public void setMultipleBirthOrderNumber(Integer multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber = multipleBirthOrderNumber;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.husky.common.Person#getName()
     */
    @Override
    public Name getName() {
        return new Name(mPatient.getName().get(0));
    }

    /*
     * (non-Javadoc)
     *
     * @see org.husky.common.Person#getNames()
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
     * Sets the nation.
     *
     * @param nation the new nation
     */
    public void setNation(String nation) {
        this.nation = nation;
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
     * Sets the provider organization.
     *
     * @param organization the new provider organization
     */
    public void setProviderOrganization(Organization organization) {
        mPatientRole.setProviderOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
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
     * Sets the religious affiliation.
     *
     * @param religiousAffiliation the new religious affiliation
     */
    public void setReligiousAffiliation(String religiousAffiliation) {
        this.religiousAffiliation = religiousAffiliation;
    }

    /**
     * Gets the telecoms.
     *
     * @return Telecoms the telecoms
     */
    public List<Telecom> getTelecoms() {
        List<Telecom> telecoms = new LinkedList<>();

        for (TEL tel : mPatientRole.getTelecom()) {
            telecoms.add(new Telecom(tel));
        }

        return telecoms;
    }

    /**
     * Sets the telecoms.
     *
     * @param telecoms the new telecoms
     */
    public void setTelecoms(List<Telecom> telecoms) {

        for (Telecom tel : telecoms) {
            if (tel != null) {
                mPatientRole.getTelecom().add(tel.getHl7CdaR2Tel());
            }
        }
    }

    /**
     * Indicates whether this Patient is not a human patient but a non human subject
     *
     * @return true for non human subjects, false for human patients
     */
    public Boolean isNonHumenSubject() {
        return isNonHumenSubject;
    }

    private Date parseDate(String value) throws ParseException {
        final var sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.parse(value);
    }

    /**
     * Sets the gender.
     *
     * @param sex the new (administrative) gender
     */
    public void setAdministrativeGender(AdministrativeGender sex) {
        mPatient.setAdministrativeGenderCode(sex.getCE());
    }

    /**
     * Configures the eHC Patient objects purpose: It is a human patient (default setting)
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

}
