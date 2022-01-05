package org.husky.communication.mpi.impl;

import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.datatypes.AD;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02MFMIMT700701UV01RegistrationEvent;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02MFMIMT700701UV01Subject1;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02MFMIMT700701UV01Subject2;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01RegistrationEvent;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01Subject1;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01Subject2;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02MFMIMT700701UV01RegistrationEvent;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02MFMIMT700701UV01Subject1;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02MFMIMT700701UV01Subject2;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Person;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientPatientPerson;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Person;
import net.ihe.gazelle.hl7v3.voc.ActClass;
import net.ihe.gazelle.hl7v3.voc.ActClassControlAct;
import net.ihe.gazelle.hl7v3.voc.ActMood;
import net.ihe.gazelle.hl7v3.voc.ParticipationTargetSubject;
import net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent;

public class PixPdqQueryControlActProcess {

	private Object internalObj;
	protected PixPdqSubjectPatient subjectPatient;
	protected PixPdqPerson patientPerson;

	public PixPdqQueryControlActProcess(Object obj) {
		this.internalObj = obj;

		if (obj instanceof PRPAIN201301UV02MFMIMT700701UV01ControlActProcess) {
			// set the class code
			getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess().setClassCode(ActClassControlAct.CACT);

			getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess().setMoodCode(XActMoodIntentEvent.EVN);

			// The trigger event code in ControlActProcess.code SHALL be set to
			// PRPA_TE201309UV02 (2.16.840.1.113883.1.6)
			// CP 506: <code code="PRPA_TE201309UV02"
			// codeSystem="2.16.840.1.113883.1.18"/>
			getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess()
					.setCode(PixPdqV3Utils.createCD("PRPA_TE201301UV02", "2.16.840.1.113883.1.18", "", ""));

			// set the subject type code
			getPRPAIN201301UV02MFMIMT700701UV01Subject1().setTypeCode("SUBJ");

			subjectPatient = new PixPdqSubjectPatient(new PRPAMT201301UV02Patient());

			patientPerson = new PixPdqPerson(new PRPAMT201301UV02Person());

			// add the patient person to the patient
			subjectPatient.getPRPAMT201301UV02Patient().setPatientPerson(patientPerson.getPRPAMT201301UV02Person());

			createSubjectRegistrationEvent();
			// add the registrationevent
			getPRPAIN201301UV02MFMIMT700701UV01Subject1()
					.setRegistrationEvent(getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent());

			// add the subject to the control act process
			getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess().getSubject()
					.add(getPRPAIN201301UV02MFMIMT700701UV01Subject1());

		} else if (obj instanceof PRPAIN201302UV02MFMIMT700701UV01ControlActProcess) {

			// set the class code
			getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess().setClassCode(ActClassControlAct.CACT);

			getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess().setMoodCode(XActMoodIntentEvent.EVN);

			// The trigger event code in ControlActProcess.code SHALL be set to
			// PRPA_TE201309UV02 (2.16.840.1.113883.1.6)
			// CP 506: <code code="PRPA_TE201309UV02"
			// codeSystem="2.16.840.1.113883.1.18"/>
			getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess()
					.setCode(PixPdqV3Utils.createCD("PRPA_TE201302UV02", "2.16.840.1.113883.1.18", "", ""));

			// set the subject type code
			getPRPAIN201302UV02MFMIMT700701UV01Subject1().setTypeCode("SUBJ");

			subjectPatient = new PixPdqSubjectPatient(new PRPAMT201302UV02Patient());

			patientPerson = new PixPdqPerson(new PRPAMT201302UV02PatientPatientPerson());

			// add the patient person to the patient
			subjectPatient.getPRPAMT201302UV02Patient()
					.setPatientPerson(patientPerson.getPRPAMT201302UV02PatientPatientPerson());

			createSubjectRegistrationEvent();
			// add the registrationevent
			getPRPAIN201302UV02MFMIMT700701UV01Subject1()
					.setRegistrationEvent(getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent());

			// add the subject to the control act process
			getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess().getSubject()
					.add(getPRPAIN201302UV02MFMIMT700701UV01Subject1());

		} else if (obj instanceof PRPAIN201304UV02MFMIMT700701UV01ControlActProcess) {

			// set the class code
			getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess().setClassCode(ActClassControlAct.CACT);

			getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess().setMoodCode(XActMoodIntentEvent.EVN);

			// The trigger event code in ControlActProcess.code SHALL be set to
			// PRPA_TE201309UV02 (2.16.840.1.113883.1.6)
			// CP 506: <code code="PRPA_TE201309UV02"
			// codeSystem="2.16.840.1.113883.1.18"/>
			getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess()
					.setCode(PixPdqV3Utils.createCD("PRPA_TE201304UV02", "2.16.840.1.113883.1.18", "", ""));

			// set the subject type code
			getPRPAIN201304UV02MFMIMT700701UV01Subject1().setTypeCode("SUBJ");

			subjectPatient = new PixPdqSubjectPatient(new PRPAMT201303UV02Patient());

			patientPerson = new PixPdqPerson(new PRPAMT201303UV02Person());
			// add the patient person to the patient
			subjectPatient.getPRPAMT201303UV02Patient().setPatientPerson(patientPerson.getPRPAMT201303UV02Person());

			createSubjectRegistrationEvent();
			// add the registrationevent
			getPRPAIN201304UV02MFMIMT700701UV01Subject1()
					.setRegistrationEvent(getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent());

			// add the subject to the control act process
			getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess().getSubject()
					.add(getPRPAIN201304UV02MFMIMT700701UV01Subject1());

		}

	}

	private void createSubjectRegistrationEvent() {

		if (this.internalObj instanceof PRPAIN201301UV02MFMIMT700701UV01ControlActProcess) {
			// add the classcode and moodcode to the registrationevent
			getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent().setClassCode(ActClass.REG);
			getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent().setMoodCode(ActMood.EVN);

			// add the id element because it is required
			getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent().getId().add(PixPdqV3Utils.createIINullFlavor("NA"));

			// RegistrationEvent.statusCode SHALL be set to �active�
			getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent().setStatusCode(PixPdqV3Utils.createCS("active"));

			// add it to the registration event
			getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent()
					.setSubject1(getPRPAIN201301UV02MFMIMT700701UV01Subject2());

			// set the typecode of registrationeventsubject
			getPRPAIN201301UV02MFMIMT700701UV01Subject2().setTypeCode(ParticipationTargetSubject.SBJ);

		} else if (this.internalObj instanceof PRPAIN201302UV02MFMIMT700701UV01ControlActProcess) {
			// add the classcode and moodcode to the registrationevent
			getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent().setClassCode(ActClass.REG);
			getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent().setMoodCode(ActMood.EVN);

			// add the id element because it is required
			getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent().getId().add(PixPdqV3Utils.createIINullFlavor("NA"));

			// RegistrationEvent.statusCode SHALL be set to �active�
			getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent().setStatusCode(PixPdqV3Utils.createCS("active"));

			// add it to the registration event
			getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent()
					.setSubject1(getPRPAIN201302UV02MFMIMT700701UV01Subject2());

			// set the typecode of registrationeventsubject
			getPRPAIN201302UV02MFMIMT700701UV01Subject2().setTypeCode(ParticipationTargetSubject.SBJ);

		} else if (this.internalObj instanceof PRPAIN201304UV02MFMIMT700701UV01ControlActProcess) {
			// add the classcode and moodcode to the registrationevent
			getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent().setClassCode(ActClass.REG);
			getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent().setMoodCode(ActMood.EVN);

			// add the id element because it is required
			getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent().getId().add(PixPdqV3Utils.createIINullFlavor("NA"));

			// RegistrationEvent.statusCode SHALL be set to �active�
			getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent().setStatusCode(PixPdqV3Utils.createCS("active"));

			// add it to the registration event
			getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent()
					.setSubject1(getPRPAIN201304UV02MFMIMT700701UV01Subject2());

			// set the typecode of registrationeventsubject
			getPRPAIN201304UV02MFMIMT700701UV01Subject2().setTypeCode(ParticipationTargetSubject.SBJ);

		}
	}

	private void addSubjectPatient() {

		if (this.internalObj instanceof PRPAIN201301UV02MFMIMT700701UV01ControlActProcess) {
			// add the patient to the subject
			getPRPAIN201301UV02MFMIMT700701UV01Subject2().setPatient(subjectPatient.getPRPAMT201301UV02Patient());
		} else if (this.internalObj instanceof PRPAIN201302UV02MFMIMT700701UV01ControlActProcess) {
			// add the patient to the subject
			getPRPAIN201302UV02MFMIMT700701UV01Subject2().setPatient(subjectPatient.getPRPAMT201302UV02Patient());
		} else if (this.internalObj instanceof PRPAIN201304UV02MFMIMT700701UV01ControlActProcess) {
			// add the patient to the subject
			getPRPAIN201304UV02MFMIMT700701UV01Subject2().setPatient(subjectPatient.getPRPAMT201303UV02Patient());

		}
	}

	private void addPatientPerson() {

		if (this.internalObj instanceof PRPAIN201301UV02MFMIMT700701UV01ControlActProcess) {
			// add the patient to the subject
			getPRPAIN201301UV02MFMIMT700701UV01Subject2().getPatient()
					.setPatientPerson(patientPerson.getPRPAMT201301UV02Person());
		} else if (this.internalObj instanceof PRPAIN201302UV02MFMIMT700701UV01ControlActProcess) {
			// add the patient to the subject
			getPRPAIN201302UV02MFMIMT700701UV01Subject2().getPatient()
					.setPatientPerson(patientPerson.getPRPAMT201302UV02PatientPatientPerson());
		} else if (this.internalObj instanceof PRPAIN201304UV02MFMIMT700701UV01ControlActProcess) {
			// add the patient to the subject
			getPRPAIN201304UV02MFMIMT700701UV01Subject2().getPatient()
					.setPatientPerson(patientPerson.getPRPAMT201303UV02Person());

		}
	}

	public void setCustodian(String organizationOID, String organizationName) {
		if (this.internalObj instanceof PRPAIN201301UV02MFMIMT700701UV01ControlActProcess) {
			// add this orgnaization as custodian as well
			getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent()
					.setCustodian(PixPdqV3Utils.createRegistrationCustodian(organizationOID, organizationName));
		}
	}

	/**
	 * Set the scoping organization for the patient
	 *
	 * @param organizationOID
	 * @param organizationName
	 * @param telecomValue
	 */
	public void setScopingOrganization(String organizationOID, String organizationName, String telecomValue) {
		// The Patient class is scoped by the provider organization where this
		// person is a patient.
		// The HL7 definition of the CMET requires that the provider
		// organization needs to be identified by an id attribute,
		// and at least one of address, telecommunications address, or contact
		// person to be present.
		// The id attribute SHALL have only a root, expressed as an ISO OID.
		subjectPatient.setProviderOrganization(organizationOID, organizationName, telecomValue);
		addSubjectPatient();

		// add this orgnaization as custodian as well
		if (this.internalObj instanceof PRPAIN201304UV02MFMIMT700701UV01ControlActProcess) {
			getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent()
					.setCustodian(PixPdqV3Utils.createRegistrationCustodian(organizationOID, organizationName));
		} else if (this.internalObj instanceof PRPAIN201302UV02MFMIMT700701UV01ControlActProcess) {
			getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent()
					.setCustodian(PixPdqV3Utils.createRegistrationCustodian(organizationOID, organizationName));
		}
	}

	/**
	 * Add an address for the patient.
	 *
	 * @param patientAddress
	 * 
	 */
	public void addPatientAddress(AD patientAddress) {
		if (patientAddress == null) {
			return;
		}

		patientPerson.addPatientAddress(patientAddress);
		addPatientPerson();
	}

	/**
	 * Add Patient Ethnic Group Code to the patient
	 *
	 * @param code
	 */
	public void addPatientEthnicGroupCode(String code) {
		patientPerson.addPatientEthnicGroupCode(code);
		addPatientPerson();
	}

	/**
	 * Add a patient name.
	 *
	 * @param familyName
	 * @param givenName
	 * @param other
	 * @param prefixName
	 * @param suffixName
	 */
	public void addPatientName(String familyName, String givenName, String other, String prefixName,
			String suffixName) {
		patientPerson.addPatientName(familyName, givenName, other, prefixName, suffixName);
		addPatientPerson();
	}

	/**
	 * Add a Patient Other ID for the patient
	 *
	 * @param extension
	 * @param root
	 */
	public void addPatientOtherID(String extension, String root) {
		patientPerson.addPatientOtherID(extension, root);
		addPatientPerson();
	}

	/**
	 * Add Patient Race Code to the patient
	 *
	 * @param code
	 */
	public void addPatientRaceCode(String code) {
		patientPerson.addPatientRaceCode(code);
		addPatientPerson();
	}

	/**
	 * Add a telecom value with the provided useValue ("HP" or "WP")
	 *
	 * @param telecomValue
	 * @param useValue
	 */
	public void addPatientTelecom(String telecomValue, String useValue) {
		patientPerson.addPatientTelecom(telecomValue, useValue);
		addPatientPerson();
	}

	/**
	 * Set whether there was a multiple birth.
	 *
	 * @param birthIndicator
	 */
	public void setMultipleBirthIndicator(boolean birthIndicator) {
		patientPerson.setMultipleBirthIndicator(birthIndicator);
		addPatientPerson();
	}

	/**
	 * Set the birth order number to the provided value
	 *
	 * @param birthNumber
	 */
	public void setMultipleBirthOrderNumber(int birthNumber) {
		patientPerson.setMultipleBirthOrderNumber(birthNumber);
		addPatientPerson();
	}

	/**
	 * Set the patient birth time.
	 *
	 * @param birthTime
	 */
	public void setPatientBirthTime(String birthTime) {
		patientPerson.setPatientBirthTime(birthTime);
		addPatientPerson();
	}

	/**
	 * Set whether the patient is deceased
	 *
	 * @param patientDeceased
	 */
	public void setPatientDeceased(boolean patientDeceased) {
		patientPerson.setPatientDeceased(patientDeceased);
		addPatientPerson();
	}

	/**
	 * Set the patient deceased time.
	 *
	 * @param patientDeceasedTime
	 */
	public void setPatientDeceasedTime(String patientDeceasedTime) {
		patientPerson.setPatientDeceasedTime(patientDeceasedTime);
		addPatientPerson();
	}

	/**
	 * Set the patient gender to the provided value ("M", "F", or "U")
	 *
	 * @param gender
	 */
	public void setPatientGender(String gender) {
		patientPerson.setPatientGender(gender);
		addPatientPerson();
	}

	/**
	 * Set the marital status for the patient
	 *
	 * @param maritalStatus
	 */
	public void setPatientMaritalStatus(String maritalStatus) {
		patientPerson.setPatientMaritalStatus(maritalStatus);
		addPatientPerson();
	}

	/**
	 * Add a mother's maiden name for the patient.
	 *
	 * @param family
	 * @param given
	 * @param other
	 * @param suffix
	 * @param prefix
	 */
	public void setPatientMothersMaidenName(String family, String given, String other, String suffix, String prefix) {
		patientPerson.setPatientMothersMaidenName(family, given, other, suffix, prefix);
		addPatientPerson();
	}

	/**
	 * Set the religious affiliation for the patient
	 *
	 * @param religiousAffiliation
	 */
	public void setPatientReligiousAffiliation(String religiousAffiliation) {
		patientPerson.setPatientReligiousAffiliation(religiousAffiliation);
		addPatientPerson();
	}

	/**
	 * Add a confidentiality code to the patient
	 *
	 * @param code
	 */
	public void addPatientConfidentialityCode(String code) {
		subjectPatient.addPatientConfidentialityCode(code);
		addSubjectPatient();
	}

	/**
	 * Set the patient id
	 *
	 * @param extension
	 * @param root
	 * @param namespace
	 */
	public void addPatientID(String extension, String root, String namespace) {
		subjectPatient.addPatientID(extension, root, namespace);
		addSubjectPatient();
	}

	/**
	 * Set Patient Very Important Person code
	 *
	 * @param code
	 */
	public void setPatientVeryImportantPerson(String code) {
		subjectPatient.setPatientVeryImportantPerson(code);
		addSubjectPatient();
	}

	public void setProviderOrganization(String organizationOID, String organizationName, String telecomValue) {
		subjectPatient.setProviderOrganization(organizationOID, organizationName, telecomValue);
		addSubjectPatient();
	}

	public PRPAIN201301UV02MFMIMT700701UV01ControlActProcess getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess() {
		return (PRPAIN201301UV02MFMIMT700701UV01ControlActProcess) internalObj;
	}

	public PRPAIN201302UV02MFMIMT700701UV01ControlActProcess getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess() {
		return (PRPAIN201302UV02MFMIMT700701UV01ControlActProcess) internalObj;
	}

	public PRPAIN201304UV02MFMIMT700701UV01ControlActProcess getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess() {
		return (PRPAIN201304UV02MFMIMT700701UV01ControlActProcess) internalObj;
	}

	public PRPAIN201301UV02MFMIMT700701UV01Subject1 getPRPAIN201301UV02MFMIMT700701UV01Subject1() {
		if(getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess().getSubject().isEmpty()) {
			getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess().getSubject()
					.add(new PRPAIN201301UV02MFMIMT700701UV01Subject1());
		}
		
		return getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess().getSubject().get(0);
	}

	public PRPAIN201302UV02MFMIMT700701UV01Subject1 getPRPAIN201302UV02MFMIMT700701UV01Subject1() {
		if (getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess().getSubject().isEmpty()) {
			getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess().getSubject()
					.add(new PRPAIN201302UV02MFMIMT700701UV01Subject1());
		}

		return getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess().getSubject().get(0);
	}

	public PRPAIN201304UV02MFMIMT700701UV01Subject1 getPRPAIN201304UV02MFMIMT700701UV01Subject1() {
		if (getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess().getSubject().isEmpty()) {
			getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess().getSubject()
					.add(new PRPAIN201304UV02MFMIMT700701UV01Subject1());
		}

		return getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess().getSubject().get(0);
	}

	public PRPAIN201301UV02MFMIMT700701UV01RegistrationEvent getPRPAIN201301UV02MFMIMT700701UV01RegistrationEvent() {
		if (getPRPAIN201301UV02MFMIMT700701UV01Subject1().getRegistrationEvent() == null) {
			getPRPAIN201301UV02MFMIMT700701UV01Subject1()
					.setRegistrationEvent(new PRPAIN201301UV02MFMIMT700701UV01RegistrationEvent());
		}
		return getPRPAIN201301UV02MFMIMT700701UV01Subject1().getRegistrationEvent();
	}

	public PRPAIN201302UV02MFMIMT700701UV01RegistrationEvent getPRPAIN201302UV02MFMIMT700701UV01RegistrationEvent() {
		if (getPRPAIN201302UV02MFMIMT700701UV01Subject1().getRegistrationEvent() == null) {
			getPRPAIN201302UV02MFMIMT700701UV01Subject1()
					.setRegistrationEvent(new PRPAIN201302UV02MFMIMT700701UV01RegistrationEvent());
		}
		return getPRPAIN201302UV02MFMIMT700701UV01Subject1().getRegistrationEvent();
	}

	public PRPAIN201304UV02MFMIMT700701UV01RegistrationEvent getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent() {
		if (getPRPAIN201304UV02MFMIMT700701UV01Subject1().getRegistrationEvent() == null) {
			getPRPAIN201304UV02MFMIMT700701UV01Subject1()
					.setRegistrationEvent(new PRPAIN201304UV02MFMIMT700701UV01RegistrationEvent());
		}
		return getPRPAIN201304UV02MFMIMT700701UV01Subject1().getRegistrationEvent();
	}

	public PRPAIN201301UV02MFMIMT700701UV01Subject2 getPRPAIN201301UV02MFMIMT700701UV01Subject2() {
		if (getPRPAIN201301UV02MFMIMT700701UV01Subject1().getRegistrationEvent().getSubject1() == null) {
			getPRPAIN201301UV02MFMIMT700701UV01Subject1().getRegistrationEvent()
					.setSubject1(new PRPAIN201301UV02MFMIMT700701UV01Subject2());
		}

		return getPRPAIN201301UV02MFMIMT700701UV01Subject1().getRegistrationEvent().getSubject1();
	}

	public PRPAIN201302UV02MFMIMT700701UV01Subject2 getPRPAIN201302UV02MFMIMT700701UV01Subject2() {
		if (getPRPAIN201302UV02MFMIMT700701UV01Subject1().getRegistrationEvent().getSubject1() == null) {
			getPRPAIN201302UV02MFMIMT700701UV01Subject1().getRegistrationEvent()
					.setSubject1(new PRPAIN201302UV02MFMIMT700701UV01Subject2());
		}

		return getPRPAIN201302UV02MFMIMT700701UV01Subject1().getRegistrationEvent().getSubject1();
	}

	public PRPAIN201304UV02MFMIMT700701UV01Subject2 getPRPAIN201304UV02MFMIMT700701UV01Subject2() {
		if (getPRPAIN201304UV02MFMIMT700701UV01Subject1().getRegistrationEvent().getSubject1() == null) {
			getPRPAIN201304UV02MFMIMT700701UV01Subject1().getRegistrationEvent()
					.setSubject1(new PRPAIN201304UV02MFMIMT700701UV01Subject2());
		}

		return getPRPAIN201304UV02MFMIMT700701UV01Subject1().getRegistrationEvent().getSubject1();
	}

	public PRPAMT201302UV02Patient getPRPAMT201302UV02Patient() {
		return (PRPAMT201302UV02Patient) internalObj;
	}

	public PRPAMT201303UV02Patient getPRPAMT201303UV02Patient() {
		return (PRPAMT201303UV02Patient) internalObj;
	}

}
