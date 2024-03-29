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
package org.projecthusky.communication.mpi.impl.pix;

import org.projecthusky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.coctmt710007UV.COCTMT710007UVPlace;
import net.ihe.gazelle.hl7v3.datatypes.AD;
import net.ihe.gazelle.hl7v3.datatypes.TEL;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02Type;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02BirthPlace;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Person;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02BirthPlace;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientPatientPerson;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02BirthPlace;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Person;
import net.ihe.gazelle.hl7v3.voc.HomeAddressUse;
import net.ihe.gazelle.hl7v3.voc.WorkPlaceAddressUse;

/**
 * The Class V3PixSourceMessageHelper.
 *
 * Simplifies the api to the three different PIX Source messages implementations
 * and leaves the possibility to get back to elements PatientRole for
 * languageCommunication which are not implemented in OHT V3 Message
 */
public class V3PixSourceMessageHelper {

	/**
	 * create a TEL type object with the supplied telecom value and use value
	 * (if supplied) we extend the type her also for the mobile, the standard
	 * PixPdqV3Utils.createTel has only WP and HP for useValue
	 *
	 * @param telecomValue
	 *            (the phone, web, or e-mail address value)
	 * @param useValue
	 *            (original either "WP" for Work or "HP" for Home)
	 * @return TEL type with the supplied telecom and use values.
	 */
	public static TEL createTEL(String telecomValue, String useValue) {
		final var returnTEL = new TEL();
		returnTEL.setValue(telecomValue);
		if (null != useValue) {
			if ("WP".equals(useValue)) {
				returnTEL.setUse(WorkPlaceAddressUse.WP.value());
			} else if ("HP".equals(useValue)) {
				returnTEL.setUse(HomeAddressUse.HP.value());
			} else if ("H".equals(useValue)) {
				returnTEL.setUse(HomeAddressUse.H.value());
			} else if ("MC".equals(useValue)) {
				returnTEL.setUse("MC");
			}
		}
		return returnTEL;
	}

	private V3PixSourceMergePatients v3MergePatientsMessage;
	private V3PixSourceRecordAdded v3RecordAddedMessage;

	private V3PixSourceRecordRevised v3RecordRevisedMessage;

	/**
	 * create a V3PixSourceMessageHelper with the supplied sender and receiver.
	 * OHT does not set the conduction Indicator value in the
	 * MFMI_MT700701UV01/subject control act wrapper to false this is fixed in
	 * the constructor
	 *
	 * @param addMessage
	 *            true use V3PixSourceRecordAdded for message generation
	 * @param revisedMessage
	 *            true use V3PixSourceRecordRevised for message generation
	 * @param mergeMessage
	 *            true use V3PixSourceMergePatients for message generation
	 * @param senderApplicationOid
	 *            application oid of the sender
	 * @param senderFacilityOid
	 *            facility oid of the sender
	 * @param receiverApplicationOid
	 *            receiver oid the application
	 * @param receiverFacilityOid
	 *            receiver oid of the facility
	 */
	public V3PixSourceMessageHelper(boolean addMessage, boolean revisedMessage,
			boolean mergeMessage, String senderApplicationOid, String senderFacilityOid,
			String receiverApplicationOid, String receiverFacilityOid) {
		if (addMessage) {
			v3RecordAddedMessage = new V3PixSourceRecordAdded(senderApplicationOid,
					senderFacilityOid, receiverApplicationOid, receiverFacilityOid);
			v3RecordAddedMessage.getRootElement().getControlActProcess().getSubject().get(0)
					.setContextConductionInd(false);
		}
		if (revisedMessage) {
			v3RecordRevisedMessage = new V3PixSourceRecordRevised(senderApplicationOid,
					senderFacilityOid, receiverApplicationOid, receiverFacilityOid);
			v3RecordRevisedMessage.getRootElement().getControlActProcess().getSubject().get(0)
					.setContextConductionInd(false);
		}
		if (mergeMessage) {
			v3MergePatientsMessage = new V3PixSourceMergePatients(senderApplicationOid,
					senderFacilityOid, receiverApplicationOid, receiverFacilityOid);
			v3MergePatientsMessage.getRootElement().getControlActProcess().getSubject().get(0)
					.setContextConductionInd(false);
		}
	}

	/**
	 * adds an employee code
	 *
	 * @param employeeOccupationCode
	 *            CWE:EmployeeOccupationCode
	 */
	public void addEmployeeCode(String employeeOccupationCode) {
		if (v3RecordAddedMessage != null) {
			final PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
			final var employee = new PRPAMT201301UV02Employee();
			employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupationCode));
			patientPerson.getAsEmployee().add(employee);
		}
		if (v3RecordRevisedMessage != null) {
			final PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(
					v3RecordRevisedMessage);
			final var employee = new PRPAMT201302UV02Employee();
			employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupationCode));
			patientPerson.getAsEmployee().add(employee);
		}
		if (v3MergePatientsMessage != null) {
			final PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
			final var employee = new PRPAMT201303UV02Employee();
			employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupationCode));
			patientPerson.getAsEmployee().add(employee);
		}
	}

	/**
	 * adds a language communication.
	 *
	 * @param languageCommunication
	 *            the language communication {CWE:HumanLanguage}
	 */
	public void addLanguageCommunication(String languageCommunication) {
		if (v3RecordAddedMessage != null) {
			final PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
			final var communication = new PRPAMT201301UV02LanguageCommunication();
			communication.setLanguageCode(PixPdqV3Utils.createCE(languageCommunication));
			patientPerson.getLanguageCommunication().add(communication);
		}
		if (v3RecordRevisedMessage != null) {
			final PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(
					v3RecordRevisedMessage);
			final var communication = new PRPAMT201302UV02LanguageCommunication();
			communication.setLanguageCode(PixPdqV3Utils.createCE(languageCommunication));
			patientPerson.getLanguageCommunication().add(communication);
		}
		if (v3MergePatientsMessage != null) {
			final PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
			final var communication = new PRPAMT201303UV02LanguageCommunication();
			communication.setLanguageCode(PixPdqV3Utils.createCE(languageCommunication));
			patientPerson.getLanguageCommunication().add(communication);
		}
	}

	/**
	 * add an address for the patient.
	 *
	 * @param address
	 */
	public void addPatientAddress(AD address) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientAddress(address);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientAddress(address);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientAddress(address);
		}
	}

	/**
	 * adds a confidentiality code to the patient
	 *
	 * @param code
	 *            confidentiality Code {CWE:Confidentiality}
	 */
	public void addPatientConfidentialityCode(String code) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientConfidentialityCode(code);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientConfidentialityCode(code);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientConfidentialityCode(code);
		}
	}

	/**
	 * add a patient ethnic group code to the patient
	 *
	 * @param code
	 *            patient etnnic group code {CWE:Ethnicity}
	 */
	public void addPatientEthnicGroupCode(String code) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientEthnicGroupCode(code);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientEthnicGroupCode(code);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientEthnicGroupCode(code);
		}
	}

	/**
	 * adds a patient identifier
	 *
	 * @param extension
	 *            patient identifier
	 * @param root
	 *            oid of patient identifier domain
	 * @param namespace
	 *            namespace of patient identifier domain
	 */
	public void addPatientID(String extension, String root, String namespace) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientID(extension, root, namespace);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientID(extension, root, namespace);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientID(extension, root, namespace);
		}
	}

	/**
	 * adds a patient name
	 *
	 * @param familyName
	 *            family
	 * @param givenName
	 *            given
	 * @param otherName
	 *            other
	 * @param prefixName
	 *            prefix
	 * @param suffixName
	 *            suffix
	 */
	public void addPatientName(String familyName, String givenName, String otherName,
			String prefixName, String suffixName) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientName(familyName, givenName, otherName, prefixName,
					suffixName);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientName(familyName, givenName, otherName, prefixName,
					suffixName);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientName(familyName, givenName, otherName, prefixName,
					suffixName);
		}
	}

	/**
	 * adds a nation code
	 *
	 * @param nationCode
	 *            CWE:NationEntityType
	 */
	public void addPatientNation(String nationCode) {
		if (v3RecordAddedMessage != null) {
			final PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
			final var citizen = new PRPAMT201301UV02Citizen();
			final var citizenNation = new PRPAMT201301UV02Nation();
			citizen.setPoliticalNation(citizenNation);
			citizenNation.setCode(PixPdqV3Utils.createCE(nationCode));
			patientPerson.getAsCitizen().add(citizen);
		}
		if (v3RecordRevisedMessage != null) {
			final PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(
					v3RecordRevisedMessage);
			final var citizen = new PRPAMT201302UV02Citizen();
			final var citizenNation = new PRPAMT201302UV02Nation();
			citizen.setPoliticalNation(citizenNation);
			citizenNation.setCode(PixPdqV3Utils.createCE(nationCode));
			patientPerson.getAsCitizen().add(citizen);
		}
		if (v3MergePatientsMessage != null) {
			final PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
			final var citizen = new PRPAMT201303UV02Citizen();
			final var citizenNation = new PRPAMT201303UV02Nation();
			citizen.setPoliticalNation(citizenNation);
			citizenNation.setCode(PixPdqV3Utils.createCE(nationCode));
			patientPerson.getAsCitizen().add(citizen);
		}
	}

	/**
	 * add a patient other id for the patient
	 *
	 * @param extension
	 *            id for the patient which should be listed as otherId
	 * @param root
	 *            oid of the patient id domain
	 */
	public void addPatientOtherID(String extension, String root) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientOtherID(extension, root);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientOtherID(extension, root);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientOtherID(extension, root);
		}
	}

	/**
	 * adds patient race code to the patient
	 *
	 * @param code
	 *            patient race code {CWE:Race}
	 */
	public void addPatientRaceCode(String code) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.addPatientRaceCode(code);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.addPatientRaceCode(code);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.addPatientRaceCode(code);
		}
	}

	/**
	 * adds a telecom value with the provided useValue ("HP" or "WP" or "H" or
	 * "MC")
	 *
	 * @param telecomValue
	 *            value for the telecom
	 * @param useValue
	 *            usage of telecom: "HP" or "WP" or "H" or "MC"
	 */
	public void addPatientTelecom(String telecomValue, String useValue) {

		if (v3RecordAddedMessage != null) {
			final PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
			patientPerson.getTelecom().add(createTEL(telecomValue, useValue));
		}
		if (v3RecordRevisedMessage != null) {
			final PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(
					v3RecordRevisedMessage);
			patientPerson.getTelecom().add(createTEL(telecomValue, useValue));
		}
		if (v3MergePatientsMessage != null) {
			final PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
			patientPerson.getTelecom().add(createTEL(telecomValue, useValue));
		}
	}

	/**
	 * gets the patient person.
	 *
	 * @param v3MergePatientsMessage
	 *            the v3 merge patients message
	 * @return the patient person
	 */
	private PRPAMT201303UV02Person getPatientPerson(
			V3PixSourceMergePatients v3MergePatientsMessage) {
		if (v3MergePatientsMessage != null) {
			final PRPAIN201304UV02Type rootElement = v3MergePatientsMessage.getRootElement();
			return rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
					.getSubject1().getPatient().getPatientPerson();
		}
		return null;
	}

	/**
	 * gets the patient person.
	 *
	 * @param v3RecordAddedMessage
	 *            the v3 record added message
	 * @return the patient person
	 */
	private PRPAMT201301UV02Person getPatientPerson(V3PixSourceRecordAdded v3RecordAddedMessage) {
		if (v3RecordAddedMessage != null) {
			final PRPAIN201301UV02Type rootElement = v3RecordAddedMessage.getRootElement();
			return rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
					.getSubject1().getPatient().getPatientPerson();
		}
		return null;
	}

	/**
	 * gets the patient person.
	 *
	 * @param v3RecordRevisedMessage
	 *            the v3 record revised message
	 * @return the patient person
	 */
	private PRPAMT201302UV02PatientPatientPerson getPatientPerson(
			V3PixSourceRecordRevised v3RecordRevisedMessage) {
		if (v3RecordRevisedMessage != null) {
			final PRPAIN201302UV02Type rootElement = v3RecordRevisedMessage.getRootElement();
			return rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
					.getSubject1().getPatient().getPatientPerson();
		}
		return null;
	}

	/**
	 * Gets the v3 merge patients message.
	 *
	 * @return the v3 merge patients message
	 */
	public V3PixSourceMergePatients getV3MergePatientsMessage() {
		return v3MergePatientsMessage;
	}

	/**
	 * Gets the v3 record added message.
	 *
	 * @return the v3 record added message
	 */
	public V3PixSourceRecordAdded getV3RecordAddedMessage() {
		return v3RecordAddedMessage;
	}

	/**
	 * Gets the v3 record revised message.
	 *
	 * @return the v3 record revised message
	 */
	public V3PixSourceRecordRevised getV3RecordRevisedMessage() {
		return v3RecordRevisedMessage;
	}

	/**
	 * sets the birth place
	 *
	 * @param addressBirthPlace
	 *            the birth place address
	 */
	public void setPatientBirthPlace(AD addressBirthPlace) {
		if (v3RecordAddedMessage != null) {
			final PRPAMT201301UV02Person patientPerson = getPatientPerson(v3RecordAddedMessage);
			final var birthplace = new PRPAMT201301UV02BirthPlace();
			final var place = new COCTMT710007UVPlace();
			place.setAddr(addressBirthPlace);
			birthplace.setBirthplace(place);
			patientPerson.setBirthPlace(birthplace);
		}
		if (v3RecordRevisedMessage != null) {
			final PRPAMT201302UV02PatientPatientPerson patientPerson = getPatientPerson(
					v3RecordRevisedMessage);
			final var birthplace = new PRPAMT201302UV02BirthPlace();
			final var place = new COCTMT710007UVPlace();
			place.setAddr(addressBirthPlace);
			birthplace.setBirthplace(place);
			patientPerson.setBirthPlace(birthplace);
		}
		if (v3MergePatientsMessage != null) {
			final PRPAMT201303UV02Person patientPerson = getPatientPerson(v3MergePatientsMessage);
			final var birthplace = new PRPAMT201303UV02BirthPlace();
			final var place = new COCTMT710007UVPlace();
			place.setAddr(addressBirthPlace);
			birthplace.setBirthplace(place);
			patientPerson.setBirthPlace(birthplace);
		}
	}

	/**
	 * sets the patient birth time.
	 *
	 * @param birthTime
	 *            birthtime of the patient
	 */
	public void setPatientBirthTime(String birthTime) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientBirthTime(birthTime);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientBirthTime(birthTime);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientBirthTime(birthTime);
		}
	}

	/**
	 * sets whether the patient is deceased
	 *
	 * @param patientDeceased
	 *            true if patient is deceased
	 */
	public void setPatientDeceased(boolean patientDeceased) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientDeceased(patientDeceased);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientDeceased(patientDeceased);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientDeceased(patientDeceased);
		}
	}

	/**
	 * sets the patient deceased time.
	 *
	 * @param patientDeceasedTime
	 *            deceased time of the patient
	 */
	public void setPatientDeceasedTime(String patientDeceasedTime) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientDeceasedTime(patientDeceasedTime);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientDeceasedTime(patientDeceasedTime);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientDeceasedTime(patientDeceasedTime);
		}
	}

	/**
	 * set the patient gender to the provided value ("M", "F", or "U")
	 *
	 * @param gender
	 *            gender values ("M", "F", or "U")
	 */
	public void setPatientGender(String gender) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientGender(gender);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientGender(gender);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientGender(gender);
		}
	}

	/**
	 * Set the marital status for the patient
	 *
	 * @param maritalStatus
	 *            marital status of the patient {CWE:MaritalStatus}
	 */
	public void setPatientMaritalStatus(String maritalStatus) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientMaritalStatus(maritalStatus);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientMaritalStatus(maritalStatus);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientMaritalStatus(maritalStatus);
		}
	}

	/**
	 * sets a mother's maiden name for the patient.
	 *
	 * @param family
	 *            mothers maiden family
	 * @param given
	 *            mothers maiden given
	 * @param other
	 *            mothers maiden other
	 * @param suffix
	 *            mothers maiden suffix
	 * @param prefix
	 *            mothers maiden prefix
	 */
	public void setPatientMothersMaidenName(String family, String given, String other,
			String suffix, String prefix) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientMothersMaidenName(family, given, other, suffix, prefix);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientMothersMaidenName(family, given, other, suffix,
					prefix);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientMothersMaidenName(family, given, other, suffix, prefix);
		}
	}

	/**
	 * sets whether there was a multiple birth.
	 *
	 * @param birthIndicator
	 *            true if multiple birth
	 */
	public void setPatientMultipleBirthIndicator(boolean birthIndicator) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setMultipleBirthIndicator(birthIndicator);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setMultipleBirthIndicator(birthIndicator);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setMultipleBirthIndicator(birthIndicator);
		}
	}

	/**
	 * sets the birth order number to the provided value
	 *
	 * @param birthNumber
	 *            birth order number
	 */
	public void setPatientMultipleBirthOrderNumber(int birthNumber) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setMultipleBirthOrderNumber(birthNumber);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setMultipleBirthOrderNumber(birthNumber);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setMultipleBirthOrderNumber(birthNumber);
		}
	}

	/**
	 * sets the religious affiliation for the patient
	 *
	 * @param religiousAffiliation
	 *            CWE:ReligiousAffiliation
	 */
	public void setPatientReligiousAffiliation(String religiousAffiliation) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientReligiousAffiliation(religiousAffiliation);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientReligiousAffiliation(religiousAffiliation);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientReligiousAffiliation(religiousAffiliation);
		}
	}

	/**
	 * sets the patient very important person code
	 *
	 * @param code
	 *            patient vip code CWE:PatientImportance}
	 */
	public void setPatientVeryImportantPerson(String code) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setPatientVeryImportantPerson(code);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setPatientVeryImportantPerson(code);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setPatientVeryImportantPerson(code);
		}
	}

	/**
	 * sets the scoping organization for the patient
	 *
	 * @param organizationOID
	 *            oid of the organization
	 * @param organizationName
	 *            organization name
	 * @param telecomValue
	 *            contact telecom value of the organization
	 */
	public void setScopingOrganization(String organizationOID, String organizationName,
			String telecomValue) {
		if (v3RecordAddedMessage != null) {
			v3RecordAddedMessage.setScopingOrganization(organizationOID, organizationName,
					telecomValue);
		}
		if (v3RecordRevisedMessage != null) {
			v3RecordRevisedMessage.setScopingOrganization(organizationOID, organizationName,
					telecomValue);
		}
		if (v3MergePatientsMessage != null) {
			v3MergePatientsMessage.setScopingOrganization(organizationOID, organizationName,
					telecomValue);
		}
	}

}
