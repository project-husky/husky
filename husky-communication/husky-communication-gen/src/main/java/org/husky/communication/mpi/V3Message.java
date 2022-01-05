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
package org.husky.communication.mpi;

import java.util.ArrayList;

import org.husky.communication.mpi.impl.PixPdqQueryControlActProcess;
import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.datatypes.AD;
import net.ihe.gazelle.hl7v3.datatypes.II;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public abstract class V3Message {

	protected String sendingApplication = null;
	protected String sendingFacility = null;
	private ArrayList<String> receivingApplication = new ArrayList<>(0);
	private ArrayList<String> receivingFacility = new ArrayList<>(0);
	protected II messageId;
	protected PixPdqQueryControlActProcess queryControlActProcess;

	protected V3Message(String senderApplicationOID) {
		// create an id and set it
		this.messageId = PixPdqV3Utils.createII(senderApplicationOID, "", "");

	}

	protected V3Message() {

	}

	/**
	 * Adds the receiving application ID provided
	 * 
	 * @param applicationOID
	 *            (Receiving Device ID)
	 */
	public void addReceivingApplication(String applicationOID) {
		receivingApplication.add(applicationOID);
	}

	/**
	 * Added the receiving facility ID provided
	 * 
	 * @param facilityOID
	 *            (Receiving Organization ID)
	 */
	public void addReceivingFacility(String facilityOID) {
		receivingFacility.add(facilityOID);
	}

	/**
	 * Gets the specified Receiving Application (Receiver Device ID)
	 * 
	 * @param i
	 *            (the index of the receiving application to get)
	 * @return String - Receiving Application
	 */
	public String getReceivingApplication(int i) {
		String returnValue = null;
		if (receivingApplication.size() > i)
			returnValue = receivingApplication.get(i);
		return returnValue;
	}

	/**
	 * Gets the specified Receiving Facility (Receiver Organization ID)
	 * 
	 * @param i
	 *            (the index of the receiving facility to get)
	 * @return String - Receiving Facility
	 */
	public String getReceivingFacility(int i) {
		String returnValue = null;
		if (receivingFacility.size() > i)
			returnValue = receivingFacility.get(i);
		return returnValue;
	}

	/**
	 * Gets the Sending Application (Sender Device ID)
	 * 
	 * @return String - Sending Application
	 */
	public String getSendingApplication() {
		return sendingApplication;
	}

	/**
	 * Gets the Sending Facility (Sender Organization ID)
	 * 
	 * @return String - Sending Facility
	 */
	public String getSendingFacility() {
		return sendingFacility;
	}

	public II getMessageId() {
		return messageId;
	}

	public void setMessageId(II messageId) {
		this.messageId = messageId;
	}

	/**
	 * Set the sender for the query
	 * 
	 * @param applicationOID (Sender Device ID)
	 * @param facilityOID    (Sender Organization ID)
	 */
	public void setSender(String applicationOID, String facilityOID) {
		this.sendingApplication = applicationOID;
		this.sendingFacility = facilityOID;
	}

	protected void addControlActProcess() {
		// This class should be overridden
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

		queryControlActProcess.addPatientAddress(patientAddress);
		addControlActProcess();
	}

	/**
	 * Add Patient Ethnic Group Code to the patient
	 *
	 * @param code
	 */
	public void addPatientEthnicGroupCode(String code) {
		queryControlActProcess.addPatientEthnicGroupCode(code);
		addControlActProcess();
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
		queryControlActProcess.addPatientName(familyName, givenName, other, prefixName, suffixName);
		addControlActProcess();
	}

	/**
	 * Add a Patient Other ID for the patient
	 *
	 * @param extension
	 * @param root
	 */
	public void addPatientOtherID(String extension, String root) {
		queryControlActProcess.addPatientOtherID(extension, root);
		addControlActProcess();
	}

	/**
	 * Add Patient Race Code to the patient
	 *
	 * @param code
	 */
	public void addPatientRaceCode(String code) {
		queryControlActProcess.addPatientRaceCode(code);
		addControlActProcess();
	}

	/**
	 * Add a telecom value with the provided useValue ("HP" or "WP")
	 *
	 * @param telecomValue
	 * @param useValue
	 */
	public void addPatientTelecom(String telecomValue, String useValue) {
		queryControlActProcess.addPatientTelecom(telecomValue, useValue);
		addControlActProcess();
	}

	/**
	 * Set whether there was a multiple birth.
	 *
	 * @param birthIndicator
	 */
	public void setMultipleBirthIndicator(boolean birthIndicator) {
		queryControlActProcess.setMultipleBirthIndicator(birthIndicator);
		addControlActProcess();
	}

	/**
	 * Set the birth order number to the provided value
	 *
	 * @param birthNumber
	 */
	public void setMultipleBirthOrderNumber(int birthNumber) {
		queryControlActProcess.setMultipleBirthOrderNumber(birthNumber);
		addControlActProcess();
	}

	/**
	 * Set the patient birth time.
	 *
	 * @param birthTime
	 */
	public void setPatientBirthTime(String birthTime) {
		queryControlActProcess.setPatientBirthTime(birthTime);
		addControlActProcess();
	}

	/**
	 * Set whether the patient is deceased
	 *
	 * @param patientDeceased
	 */
	public void setPatientDeceased(boolean patientDeceased) {
		queryControlActProcess.setPatientDeceased(patientDeceased);
		addControlActProcess();
	}

	/**
	 * Set the patient deceased time.
	 *
	 * @param patientDeceasedTime
	 */
	public void setPatientDeceasedTime(String patientDeceasedTime) {
		queryControlActProcess.setPatientDeceasedTime(patientDeceasedTime);
		addControlActProcess();
	}

	/**
	 * Set the patient gender to the provided value ("M", "F", or "U")
	 *
	 * @param gender
	 */
	public void setPatientGender(String gender) {
		queryControlActProcess.setPatientGender(gender);
		addControlActProcess();
	}

	/**
	 * Set the marital status for the patient
	 *
	 * @param maritalStatus
	 */
	public void setPatientMaritalStatus(String maritalStatus) {
		queryControlActProcess.setPatientMaritalStatus(maritalStatus);
		addControlActProcess();
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
		queryControlActProcess.setPatientMothersMaidenName(family, given, other, suffix, prefix);
		addControlActProcess();
	}

	/**
	 * Set the religious affiliation for the patient
	 *
	 * @param religiousAffiliation
	 */
	public void setPatientReligiousAffiliation(String religiousAffiliation) {
		queryControlActProcess.setPatientReligiousAffiliation(religiousAffiliation);
		addControlActProcess();
	}

	/**
	 * Add a confidentiality code to the patient
	 *
	 * @param code
	 */
	public void addPatientConfidentialityCode(String code) {
		queryControlActProcess.addPatientConfidentialityCode(code);
		addControlActProcess();
	}

	/**
	 * Set the patient id
	 *
	 * @param extension
	 * @param root
	 * @param namespace
	 */
	public void addPatientID(String extension, String root, String namespace) {
		queryControlActProcess.addPatientID(extension, root, namespace);
		addControlActProcess();
	}

	/**
	 * Set Patient Very Important Person code
	 *
	 * @param code
	 */
	public void setPatientVeryImportantPerson(String code) {
		queryControlActProcess.setPatientVeryImportantPerson(code);
		addControlActProcess();
	}

	public void setProviderOrganization(String organizationOID, String organizationName, String telecomValue) {
		queryControlActProcess.setProviderOrganization(organizationOID, organizationName, telecomValue);
		addControlActProcess();
	}

	/**
	 * Set the scoping organization for the patient
	 *
	 * @param organizationOID
	 * @param organizationName
	 * @param telecomValue
	 */
	public void setScopingOrganization(String organizationOID, String organizationName, String telecomValue) {
		// add this orgnaization as custodian as well
		queryControlActProcess.setScopingOrganization(organizationOID, organizationName, telecomValue);
		addControlActProcess();
	}

}
