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

package org.ehealth_connector.communication.mpi.impl.pix;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.utils.OID;
import org.ehealth_connector.communication.mpi.V3Message;
import org.ehealth_connector.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.coctmt030007UV.COCTMT030007UVPerson;
import net.ihe.gazelle.hl7v3.datatypes.II;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01RegistrationEvent;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01Subject1;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01Subject2;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02OtherIDs;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02OtherIDsId;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientId;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientPatientPerson;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientStatusCode;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PersonalRelationship;
import net.ihe.gazelle.hl7v3.voc.ActClass;
import net.ihe.gazelle.hl7v3.voc.ActClassControlAct;
import net.ihe.gazelle.hl7v3.voc.ActMood;
import net.ihe.gazelle.hl7v3.voc.EntityClass;
import net.ihe.gazelle.hl7v3.voc.EntityDeterminer;
import net.ihe.gazelle.hl7v3.voc.ParticipationTargetSubject;
import net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent;
import net.ihe.gazelle.hl7v3.voc.XDeterminerInstanceKind;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixSourceRecordRevised extends V3Message {

	// the PIX query
	private PRPAIN201302UV02Type rootElement = new PRPAIN201302UV02Type();
	private PRPAIN201302UV02MFMIMT700701UV01ControlActProcess queryControlActProcess = new PRPAIN201302UV02MFMIMT700701UV01ControlActProcess();
	private PRPAIN201302UV02MFMIMT700701UV01Subject1 pixSourceSubject = new PRPAIN201302UV02MFMIMT700701UV01Subject1();
	private PRPAIN201302UV02MFMIMT700701UV01RegistrationEvent subjectRegistrationEvent = new PRPAIN201302UV02MFMIMT700701UV01RegistrationEvent();
	private PRPAIN201302UV02MFMIMT700701UV01Subject2 registrationEventSubject = new PRPAIN201302UV02MFMIMT700701UV01Subject2();
	private PRPAMT201302UV02Patient subjectPatient = new PRPAMT201302UV02Patient();
	private PRPAMT201302UV02PatientPatientPerson patientPerson = new PRPAMT201302UV02PatientPatientPerson();
	private String patientId = "";

	/**
	 * Create a V3PixSourceRecordRevised with the supplied sender and receiver
	 *
	 * @param senderApplicationOID
	 * @param senderFacilityOID
	 * @param receiverApplicationOID
	 * @param receiverFacilityOID
	 */
	public V3PixSourceRecordRevised(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID, String receiverFacilityOID) {

		// set the interaction id (Patient Record Added)
		rootElement.setInteractionId(
				PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201302UV02", ""));

		// indicate ITSVersion XML_1.0
		rootElement.setITSVersion("XML_1.0");

		// create an id and set it
		this.messageId = PixPdqV3Utils.createII(OID.createOIDGivenRoot(senderApplicationOID), "",
				"");
		rootElement.setId(messageId);

		// set current time
		rootElement.setCreationTime(PixPdqV3Utils.createTSCurrentTime());

		// set ProcessingCode. This attribute defines whether the message is
		// part of a production,
		// training, or debugging system. Valid values are D (Debugging), T
		// (Testing), P (Production)
		// TODO: how can this be indicated outside of the system? New
		// bridge.properties global to indicate "testing"?
		// Will default to production because it will need to be that way in the
		// field.
		this.setProcessingCode("P");

		// The value of processingModeCode SHALL be set to T
		rootElement.setProcessingModeCode(PixPdqV3Utils.createCS("T"));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		// The acceptAckCode SHALL be set to AL
		rootElement.setAcceptAckCode(PixPdqV3Utils.createCS("AL"));

		// add the control act process to the message
		rootElement.setControlActProcess(queryControlActProcess);

		// set the class code
		queryControlActProcess.setClassCode(ActClassControlAct.CACT);

		// TODO: CONFLICT: The value of ControlActProcess.moodCode SHALL be set
		// to RQO
		queryControlActProcess.setMoodCode(XActMoodIntentEvent.EVN);

		// The trigger event code in ControlActProcess.code SHALL be set to
		// PRPA_TE201309UV02 (2.16.840.1.113883.1.6)
		// CP 506: <code code="PRPA_TE201309UV02"
		// codeSystem="2.16.840.1.113883.1.18"/>
		queryControlActProcess.setCode(
				PixPdqV3Utils.createCD("PRPA_TE201302UV02", "2.16.840.1.113883.1.18", "", ""));

		// set the subject type code
		pixSourceSubject.setTypeCode("SUBJ");

		// add the subject to the control act process
		queryControlActProcess.getSubject().add(pixSourceSubject);

		// add the registrationevent
		pixSourceSubject.setRegistrationEvent(subjectRegistrationEvent);

		subjectRegistrationEvent.setClassCode(ActClass.REG);
		subjectRegistrationEvent.setMoodCode(ActMood.EVN);

		// add the id element because it is required
		subjectRegistrationEvent.getId().add(PixPdqV3Utils.createIINullFlavor("NA"));

		// RegistrationEvent.statusCode SHALL be set to �active�
		subjectRegistrationEvent.setStatusCode(PixPdqV3Utils.createCS("active"));

		// add it to the registration event
		subjectRegistrationEvent.setSubject1(registrationEventSubject);

		// set the typecode of registrationeventsubject
		registrationEventSubject.setTypeCode(ParticipationTargetSubject.SBJ);

		// add the patient to the subject
		registrationEventSubject.setPatient(subjectPatient);

		// set the patient classcode to "PAT"
		subjectPatient.setClassCode("PAT");

		var statusCode = new PRPAMT201302UV02PatientStatusCode();
		statusCode.setCode("active");

		// set the statusCode
		subjectPatient.setStatusCode(statusCode);

		// add the patient person to the patient
		subjectPatient.setPatientPerson(patientPerson);

		// set the person classcode
		patientPerson.setClassCode(EntityClass.PSN);

		// set the person determiner code
		patientPerson.setDeterminerCode(EntityDeterminer.INSTANCE);
	}

	/**
	 * Add an address for the patient.
	 *
	 * @param addressStreetAddress
	 * @param addressCity
	 * @param addressCounty
	 * @param addressState
	 * @param addressCountry
	 * @param addressZip
	 * @param addressOtherDesignation
	 * @param addressType
	 */
	public void addPatientAddress(List<String> addressStreetAddress, String addressCity,
			String addressCounty, String addressState, String addressCountry, String addressZip,
			String addressOtherDesignation, String addressType) {
		var patientAddress = PixPdqV3Utils.createAD(addressStreetAddress, addressCity, addressCounty,
				addressState, addressCountry, addressZip, addressOtherDesignation, addressType);
		if (null != patientAddress)
			patientPerson.getAddr().add(patientAddress);
	}

	/**
	 * Add an address for the patient.
	 *
	 * @param addressStreetAddress
	 * @param addressCity
	 * @param addressCounty
	 * @param addressState
	 * @param addressCountry
	 * @param addressZip
	 * @param addressOtherDesignation
	 * @param addressType
	 */
	public void addPatientAddress(String addressStreetAddress, String addressCity,
			String addressCounty, String addressState, String addressCountry, String addressZip,
			String addressOtherDesignation, String addressType) {
		List<String> addressLines = new ArrayList<>();
		addressLines.add(addressStreetAddress);
		addPatientAddress(addressLines, addressCity, addressCounty, addressState, addressCountry,
				addressZip, addressOtherDesignation, addressType);
	}

	/**
	 * Add a confidentiality code to the patient
	 *
	 * @param code
	 */
	public void addPatientConfidentialityCode(String code) {
		subjectPatient.getConfidentialityCode().add(PixPdqV3Utils.createCE(code));
	}

	/**
	 * Add Patient Ethnic Group Code to the patient
	 *
	 * @param code
	 */
	public void addPatientEthnicGroupCode(String code) {
		patientPerson.getEthnicGroupCode().add(PixPdqV3Utils.createCE(code));
	}

	/**
	 * Set the patient id
	 *
	 * @param extension
	 * @param root
	 * @param namespace
	 */
	public void addPatientID(String extension, String root, String namespace) {
		// patientId = root + "^" + extension;
		final var idString = new StringBuilder();
		idString.append(extension) //
				.append("^^^");
		if (namespace != null) {
			idString.append(namespace);
		}
		idString.append("&") //
				.append(root) //
				.append("&ISO");
		patientId = idString.toString();// extension + "^^^" + namespace + "&" +
										// root + "&ISO";
		var prpamPatientId = new PRPAMT201302UV02PatientId();

		if (null != root && !root.isEmpty())
			prpamPatientId.setRoot(root);
		if (null != extension && !extension.isEmpty())
			prpamPatientId.setExtension(extension);
		if (null != namespace && !namespace.isEmpty())
			prpamPatientId.setAssigningAuthorityName(namespace);
		subjectPatient.getId().add(prpamPatientId);
	}

	/**
	 * Add a patient name.
	 *
	 * @param familyName
	 * @param givenName
	 * @param otherName
	 * @param prefixName
	 * @param suffixName
	 */
	public void addPatientName(String familyName, String givenName, String other,
			String prefixName, String suffixName) {
		var patientName = PixPdqV3Utils.createPN(familyName, givenName, other, suffixName,
				prefixName);
		if (null != patientName)
			patientPerson.getName().add(patientName);
	}

	/**
	 * Add a Patient Other ID for the patient
	 *
	 * @param extension
	 * @param root
	 */
	public void addPatientOtherID(String extension, String root) {
		var asOtherID = new PRPAMT201302UV02OtherIDs();
		asOtherID.setClassCode("PAT");
		var otherId = new PRPAMT201302UV02OtherIDsId();
		if (null != root && !root.isEmpty())
			otherId.setRoot(root);
		if (null != extension && !extension.isEmpty())
			otherId.setExtension(extension);
		asOtherID.getId().add(otherId);
		asOtherID.setScopingOrganization(PixPdqV3Utils.createCOCTMT150002UV01Organization(root));
		patientPerson.getAsOtherIDs().add(asOtherID);
	}

	/**
	 * Add Patient Race Code to the patient
	 *
	 * @param code
	 */
	public void addPatientRaceCode(String code) {
		patientPerson.getRaceCode().add(PixPdqV3Utils.createCE(code));
	}

	/**
	 * Add a telecom value with the provided useValue ("HP" or "WP")
	 *
	 * @param telecomValue
	 * @param useValue
	 */
	public void addPatientTelecom(String telecomValue, String useValue) {
		patientPerson.getTelecom().add(PixPdqV3Utils.createTEL(telecomValue, useValue));
	}

	/**
	 * Add a Receiver with the supplied IDs
	 *
	 * @param applicationOID
	 *            (Device ID)
	 * @param facilityOID
	 *            (Organization ID)
	 */
	public void addReceiver(String applicationOID, String facilityOID) {
		this.addReceivingApplication(applicationOID);
		this.addReceivingFacility(facilityOID);
		rootElement.getReceiver()
				.add(PixPdqV3Utils.createMCCIMT000100UV01Receiver(applicationOID, facilityOID));
	}

	/**
	 * Get the patient ID
	 *
	 * @return String - the patient id
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * Get the root element
	 *
	 * @return PRPAIN201302UV02Type - the root element
	 */
	public PRPAIN201302UV02Type getRootElement() {
		return rootElement;
	}

	/**
	 * Set whether there was a multiple birth.
	 *
	 * @param birthIndicator
	 */
	public void setMultipleBirthIndicator(boolean birthIndicator) {
		patientPerson.setMultipleBirthInd(PixPdqV3Utils.createBL(birthIndicator));
	}

	/**
	 * Set the birth order number to the provided value
	 *
	 * @param birthNumber
	 */
	public void setMultipleBirthOrderNumber(int birthNumber) {
		patientPerson.setMultipleBirthOrderNumber(PixPdqV3Utils.createINT1(birthNumber));
	}

	/**
	 * Set the patient birth time.
	 *
	 * @param birthTime
	 */
	public void setPatientBirthTime(String birthTime) {
		patientPerson.setBirthTime(PixPdqV3Utils.createTS(birthTime));
	}

	/**
	 * Set whether the patient is deceased
	 *
	 * @param patientDeceased
	 */
	public void setPatientDeceased(boolean patientDeceased) {
		patientPerson.setDeceasedInd(PixPdqV3Utils.createBL(patientDeceased));
	}

	/**
	 * Set the patient deceased time.
	 *
	 * @param patientDeceasedTime
	 */
	public void setPatientDeceasedTime(String patientDeceasedTime) {
		patientPerson.setDeceasedTime(PixPdqV3Utils.createTS(patientDeceasedTime));
	}

	/**
	 * Set the patient gender to the provided value ("M", "F", or "U")
	 *
	 * @param gender
	 */
	public void setPatientGender(String gender) {
		patientPerson.setAdministrativeGenderCode(
				PixPdqV3Utils.createCE(gender, "2.16.840.1.113883.5.1", "", ""));
	}

	/**
	 * Set the marital status for the patient
	 *
	 * @param maritalStatus
	 */
	public void setPatientMaritalStatus(String maritalStatus) {
		patientPerson.setMaritalStatusCode(PixPdqV3Utils.createCE(maritalStatus));
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
	public void setPatientMothersMaidenName(String family, String given, String other,
			String suffix, String prefix) {
		var motherRelationship = new PRPAMT201302UV02PersonalRelationship();
		patientPerson.getPersonalRelationship().add(motherRelationship);
		motherRelationship.setClassCode("PRS");
		motherRelationship.setCode(PixPdqV3Utils.createCE("MTH", "2.16.840.1.113883.5.111",
				"PersonalRelationshipRoleType", "Mother"));
		var motherRelationshipHolder = new COCTMT030007UVPerson();
		motherRelationship.setRelationshipHolder1(motherRelationshipHolder);
		motherRelationshipHolder.setClassCode(EntityClass.PSN);
		motherRelationshipHolder.setDeterminerCode(XDeterminerInstanceKind.INSTANCE);
		motherRelationshipHolder.getName()
				.add(PixPdqV3Utils.createPN(family, given, suffix, prefix));
	}

	/**
	 * Set the religious affiliation for the patient
	 *
	 * @param religiousAffiliation
	 */
	public void setPatientReligiousAffiliation(String religiousAffiliation) {
		patientPerson.setReligiousAffiliationCode(PixPdqV3Utils.createCE(religiousAffiliation));
	}

	/**
	 * Set Patient Very Important Person code
	 *
	 * @param code
	 */
	public void setPatientVeryImportantPerson(String code) {
		subjectPatient.setVeryImportantPersonCode(PixPdqV3Utils.createCE(code));
	}

	/**
	 * Set the processing code.
	 *
	 * @param processingCode
	 */
	public void setProcessingCode(String processingCode) {
		rootElement.setProcessingCode(PixPdqV3Utils.createCS(processingCode));
	}

	/**
	 * Set the scoping organization for the patient
	 *
	 * @param organizationOID
	 * @param organizationName
	 * @param telecomValue
	 */
	public void setScopingOrganization(String organizationOID, String organizationName,
			String telecomValue) {
		// The Patient class is scoped by the provider organization where this
		// person is a patient.
		// The HL7 definition of the CMET requires that the provider
		// organization needs to be identified by an id attribute,
		// and at least one of address, telecommunications address, or contact
		// person to be present.
		// The id attribute SHALL have only a root, expressed as an ISO OID.
		subjectPatient.setProviderOrganization(PixPdqV3Utils.createCOCTMT150003UV03Organization(
				organizationOID, organizationName, telecomValue));

		// add this orgnaization as custodian as well
		// TODO: is this right?
		subjectRegistrationEvent.setCustodian(
				PixPdqV3Utils.createRegistrationCustodian(organizationOID, organizationName));
	}

	/**
	 * Set the sender ids
	 *
	 * @param applicationOID
	 *            (Device ID)
	 * @param facilityOID
	 *            (Organization ID)
	 */
	public void setSender(String applicationOID, String facilityOID) {
		// set the sender/application OIDs
		this.sendingApplication = applicationOID;
		this.sendingFacility = facilityOID;
		rootElement
				.setSender(PixPdqV3Utils.createMCCIMT000100UV01Sender(applicationOID, facilityOID));
	}

	@Override
	public II getMessageId() {
		return messageId;
	}
}
