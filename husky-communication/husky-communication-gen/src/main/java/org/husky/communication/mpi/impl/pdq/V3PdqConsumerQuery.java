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
package org.husky.communication.mpi.impl.pdq;

import org.husky.communication.mpi.V3Message;
import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.datatypes.II;
import net.ihe.gazelle.hl7v3.prpain201305UV02.PRPAIN201305UV02QUQIMT021001UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201305UV02.PRPAIN201305UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectId;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MatchCriterionList;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MinimumDegreeMatch;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02ParameterList;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02QueryByParameter;
import net.ihe.gazelle.hl7v3.voc.ActClassControlAct;
import net.ihe.gazelle.hl7v3.voc.EntityNameSearchUse;
import net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PdqConsumerQuery extends V3Message {

	// the PIX query
	private PRPAIN201305UV02Type rootElement = null;
	private PRPAIN201305UV02QUQIMT021001UV01ControlActProcess queryControlActProcess = null;
	private PRPAMT201306UV02QueryByParameter queryByParameter = null;
	private PRPAMT201306UV02ParameterList parameterList = null;
	private PRPAMT201306UV02MatchCriterionList matchCriterionList = null;
	private String queryParams = "";

	/**
	 * Create the V3PdqConsumerQuery with the provided sender and receiver IDs
	 * 
	 * @param senderApplicationOID
	 *            (Sender Device ID)
	 * @param senderFacilityOID
	 *            (Sender Organization ID)
	 * @param receiverApplicationOID
	 *            (Receiver Device ID)
	 * @param receiverFacilityOID
	 *            (Receiver Organization ID)
	 */
	public V3PdqConsumerQuery(String senderApplicationOID, String senderFacilityOID, String receiverApplicationOID,
			String receiverFacilityOID) {

		// create the root v3 pdq element
		rootElement = new PRPAIN201305UV02Type();

		// set the interaction id
		rootElement.setInteractionId(PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201305UV02", ""));

		// indicate ITSVersion XML_1.0
		rootElement.setITSVersion("XML_1.0");

		// create an id and set it
		this.messageId = PixPdqV3Utils.createII(senderApplicationOID, "", "");
		rootElement.setId(messageId);

		// set current time
		rootElement.setCreationTime(PixPdqV3Utils.createTSCurrentTime());

		// set ProcessingCode. This attribute defines whether the message is part of a production,
		// training, or debugging system. Valid values are D (Debugging), T (Testing), P (Production)
		// Will default to production because it will need to be that way in the field.
		this.setProcessingCode("P");

		// The value of processingModeCode SHALL be set to T
		rootElement.setProcessingModeCode(PixPdqV3Utils.createCS("T"));

		// The acceptAckCode SHALL be set to AL
		rootElement.setAcceptAckCode(PixPdqV3Utils.createCS("AL"));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		// create the controlActProcess
		queryControlActProcess = new PRPAIN201305UV02QUQIMT021001UV01ControlActProcess();

		// add the control act process to the message
		rootElement.setControlActProcess(queryControlActProcess);

		// set the class code
		queryControlActProcess.setClassCode(ActClassControlAct.CACT);
		queryControlActProcess.setMoodCode(XActMoodIntentEvent.EVN);

		queryControlActProcess.setCode(PixPdqV3Utils.createCD("PRPA_TE201305UV02", "2.16.840.1.113883.1.18", "", ""));

		// create the query by parameter
		queryByParameter = new PRPAMT201306UV02QueryByParameter();

		// add the query by parameter object to the control act process
		queryControlActProcess.setQueryByParameter(queryByParameter);

		// set the queryId
		queryByParameter.setQueryId(PixPdqV3Utils.createIIwithUniqueExtension("1.2.840.114350.1.13.28.1.18.5.999"));

		// QueryByParameter.statusCode is defaulted to "new".
		queryByParameter.setStatusCode(PixPdqV3Utils.createCS("new"));

		// QueryByParameter.responseModalityCode is required and is fixed to R (Real Time)
		queryByParameter.setResponseModalityCode(PixPdqV3Utils.createCS("R"));

		// QueryByParameter.responsePriorityCode is required and is fixed to I (Immediate)
		queryByParameter.setResponsePriorityCode(PixPdqV3Utils.createCS("I"));

		// create the parameter list
		parameterList = new PRPAMT201306UV02ParameterList();

		// add the parameter list to the query by parameter
		queryByParameter.setParameterList(parameterList);
	}

	/**
	 * Add the provided organization ID as a domain to return
	 * 
	 * @param organizationOID
	 */
	public void addDomainToReturn(String organizationOID) {
		// create an otherIDsScopingOrganization
		var currentScopingOrganization = new PRPAMT201306UV02OtherIDsScopingOrganization();

		// set the ID
		currentScopingOrganization.getValue().add(PixPdqV3Utils.createII(organizationOID, "", ""));

		// set the semanticstext
		currentScopingOrganization.setSemanticsText(PixPdqV3Utils.createST("OtherIDs.scopingOrganization.id"));

		// add scoping organization to parameter list
		parameterList.getOtherIDsScopingOrganization().add(currentScopingOrganization);
	}

	/**
	 * Add an address to the patient.
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
	public void addPatientAddress(String addressStreetAddress, String addressCity, String addressCounty,
			String addressState, String addressCountry, String addressZip, String addressOtherDesignation,
			String addressType) {
		queryParams += "Patient Address: " + addressStreetAddress + " " + addressCity + " " + addressCounty + " "
				+ addressState + " " + addressCountry + " " + addressZip + " " + addressOtherDesignation + ","
				+ addressType + ",";
		// Create an AD type to store the address information
		var patientAddressAD = PixPdqV3Utils.createAd(addressStreetAddress, addressCity, addressCounty, addressState,
				addressCountry, addressZip, addressOtherDesignation, addressType);

		// Add the AD to the patient Address
		if (null != patientAddressAD) {
			// add patientAddress element
			var patientAddress = new PRPAMT201306UV02PatientAddress();

			patientAddress.getValue().add(patientAddressAD);

			// set semantics text
			patientAddress.setSemanticsText(PixPdqV3Utils.createST("Patient.addr"));

			// add the address to the querybyparameterlist
			parameterList.getPatientAddress().add(patientAddress);
		}
	}

	/**
	 * Add the provided patient ID to the query
	 * 
	 * @param root
	 * @param extension
	 * @param namespace
	 */
	public void addPatientID(String root, String extension, String namespace) {
		queryParams += "Patient ID: " + root + "^" + extension + ",";
		// create livingSubjectId
		var livingSubjectId = new PRPAMT201306UV02LivingSubjectId();
		livingSubjectId.getValue().add(PixPdqV3Utils.createII(root, extension, namespace));
		livingSubjectId.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.id"));

		// add the birth time to the querybyparameterlist
		parameterList.getLivingSubjectId().add(livingSubjectId);
	}

	/**
	 * Add Mother's Maiden name to patient
	 * 
	 * @param useFuzzySearch
	 *            (whether the server should use fuzzy search for matching)
	 * @param family
	 * @param given
	 * @param other
	 *            (middle name, added as second given)
	 * @param suffix
	 * @param prefix
	 */
	public void addPatientMothersMaidenName(boolean useFuzzySearch, String family, String given, String other,
			String suffix, String prefix) {

		var mothersMaidenName = new PRPAMT201306UV02MothersMaidenName();
		var mothersMaidenNamePN = PixPdqV3Utils.createPN(family, given, other, suffix, prefix);
		if (useFuzzySearch) {
			mothersMaidenNamePN.setUse(EntityNameSearchUse.SRCH.value());
		}
		mothersMaidenName.getValue().add(mothersMaidenNamePN);
		mothersMaidenName.setSemanticsText(PixPdqV3Utils.createST("MothersMaidenName.name"));
		parameterList.getMothersMaidenName().add(mothersMaidenName);
	}

	/**
	 * Add the provided patient ID to the query
	 * 
	 * @param useFuzzySearch
	 *            (whether the server should use fuzzy search for matching)
	 * @param family
	 * @param given
	 * @param other
	 *            (middle name, added as second given)
	 * @param suffix
	 * @param prefix
	 */
	public void addPatientName(boolean useFuzzySearch, String family, String given, String other, String suffix,
			String prefix) {
		queryParams += "Patient Name: " + prefix + " " + given + " " + other + " " + family + " " + suffix + ",";
		// add livingSubjectName
		var livingSubjectName = new PRPAMT201306UV02LivingSubjectName();

		// create the EN Type to hold the name
		var livingSubjectNameEN = PixPdqV3Utils.createEN(family, given, other, suffix, prefix);

		// if we should do fuzzy search
		if (useFuzzySearch)
			livingSubjectNameEN.setUse(EntityNameSearchUse.SRCH.value());

		// Add the built EN to the living subject name
		livingSubjectName.getValue().add(livingSubjectNameEN);

		// set the semanticstext
		livingSubjectName.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.name"));

		// add the birth time to the querybyparameterlist
		parameterList.getLivingSubjectName().add(livingSubjectName);
	}

	/**
	 * Add a patient telecom value of the supplied type.
	 * 
	 * @param telecom
	 * @param type
	 *            ("HP" or "WP"
	 */
	public void addPatientTelecom(String telecom, String type) {

		var patientTel = new PRPAMT201306UV02PatientTelecom();
		var tel = PixPdqV3Utils.createTEL(telecom, type);
		patientTel.getValue().add(tel);
		parameterList.getPatientTelecom().add(patientTel);
	}

	/**
	 * Add the provided Receiver to the query
	 * 
	 * @param applicationOID
	 *            (Receiver Device ID)
	 * @param facilityOID
	 *            (Receiver Organization ID)
	 */
	public void addReceiver(String applicationOID, String facilityOID) {
		rootElement.getReceiver().add(PixPdqV3Utils.createMCCIMT000100UV01Receiver(applicationOID, facilityOID));
	}

	/**
	 * Get the pix query control act process element
	 * 
	 * @return PRPAIN201305UV02QUQIMT021001UV01ControlActProcess - the pix query control act process element
	 */
	public PRPAIN201305UV02QUQIMT021001UV01ControlActProcess getControlActProcess() {
		return queryControlActProcess;
	}

	// expose a method to get message id
	/* (non-Javadoc)
	 * @see org.openhealthtools.ihe.common.hl7v3.client.V3Message#getId()
	 */
	public II getId() {
		return rootElement.getId();
	}

	/**
	 * Get the match criterion list. (If one does not yet exist, it will be created)
	 * 
	 * @return PRPAMT201306UV02MatchCriterionList - the match criterion list.
	 */
	public PRPAMT201306UV02MatchCriterionList getMatchCriterionList() {

		// if we do not yet have a match criterion list, create one
		if (matchCriterionList == null) {

			// get a new matchCriterionList
			matchCriterionList = new PRPAMT201306UV02MatchCriterionList();

			// add the matchcriterionlist to the querybyparameter
			queryByParameter.setMatchCriterionList(matchCriterionList);
		}

		// return the matchCriterionList
		return matchCriterionList;
	}

	/**
	 * Get the current parameter list
	 * 
	 * @return PRPAMT201306UV02ParameterList - the current parameter list
	 */
	public PRPAMT201306UV02ParameterList getParameterList() {
		return parameterList;
	}

	/**
	 * Get the current query parameters
	 * 
	 * @return String - the current query parameters
	 */
	public String getQueryParams() {
		return queryParams;
	}

	/**
	 * Get the root element for this Query
	 * 
	 * @return PRPAIN201305UV02Type - the root element
	 */
	public PRPAIN201305UV02Type getRootElement() {
		return rootElement;
	}

	/**
	 * Set the initial quantity of type "RD" to return in the PDQ response.
	 * 
	 * @param initialQuantity
	 */
	public void setInitialQuantity(Integer initialQuantity) {
		this.setInitialQuantity(initialQuantity, "RD");
	}

	/**
	 * Set the initial quantity of type "units" to return in the PDQ response.
	 * 
	 * @param initialQuantity
	 * @param units
	 */
	public void setInitialQuantity(Integer initialQuantity, String units) {
		queryByParameter.setInitialQuantity(PixPdqV3Utils.createINT1(initialQuantity));
		queryByParameter.setInitialQuantityCode(PixPdqV3Utils.createCE(units));
	}

	/**
	 * Set the minimum degree match to 75
	 *
	 */
	public void setMinimumDegreeMatch() {
		this.setMinimumDegreeMatch(75);
	}

	/**
	 * Set the minimum degree match to the provided value
	 * 
	 * @param minimumDegreeMatch
	 *            - integer value of degree match (0 to 100)
	 */
	public void setMinimumDegreeMatch(Integer minimumDegreeInt) {
		// create the minimum degree match
		var minimumDegreeMatch = new PRPAMT201306UV02MinimumDegreeMatch();
		minimumDegreeMatch.setValue(PixPdqV3Utils.createINT1(minimumDegreeInt));
		minimumDegreeMatch.setSemanticsText(PixPdqV3Utils.createST("MatchAlgorithm"));

		// add the minimum degree match to the matchCriterionList
		this.getMatchCriterionList().setMinimumDegreeMatch(minimumDegreeMatch);
	}

	/**
	 * Set the patient DOB to the provided string
	 * 
	 * @param dob
	 *            - String representation of patient date of birth - yyyyMMdd
	 */
	public void setPatientDateOfBirth(String dob) {
		queryParams += "DOB: " + dob + ",";
		// create livingSubjectBirthTime
		var livingSubjectBirthTime = new PRPAMT201306UV02LivingSubjectBirthTime();
		livingSubjectBirthTime.getValue().add(PixPdqV3Utils.createIVLTS(dob));
		livingSubjectBirthTime.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.birthTime"));

		// add the birth time to the querybyparameterlist
		parameterList.getLivingSubjectBirthTime().add(livingSubjectBirthTime);
	}

	/**
	 * Set the patient sex to the provided value
	 * 
	 * @param sex
	 *            - string representing gender (M,F,U)
	 */
	public void setPatientSex(String sex) {
		queryParams += "Sex: " + sex + ",";
		// create livingSubjectAdministrativeGender
		var livingSubjectAdministrativeGender = new PRPAMT201306UV02LivingSubjectAdministrativeGender();
		livingSubjectAdministrativeGender.getValue().add(PixPdqV3Utils.createCE(sex));
		livingSubjectAdministrativeGender
				.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.administrativeGender"));

		// add the administrative gender to the querybyparameterlist
		parameterList.getLivingSubjectAdministrativeGender().add(livingSubjectAdministrativeGender);
	}

	/**
	 * Set the processing code
	 * 
	 * @param processingCode
	 */
	public void setProcessingCode(String processingCode) {
		rootElement.setProcessingCode(PixPdqV3Utils.createCS(processingCode));
	}

	/**
	 * Set the query ID
	 * 
	 * @param root
	 * @param extension
	 * @param namespace
	 */
	public void setQueryId(String root, String extension, String namespace) {
		queryByParameter.setQueryId(PixPdqV3Utils.createII(root, extension, namespace));
	}

	/**
	 * Set the sender for the query
	 * 
	 * @param applicationOID
	 *            (Sender Device ID)
	 * @param facilityOID
	 *            (Sender Organization ID)
	 */
	public void setSender(String applicationOID, String facilityOID) {
		// set the sender/application OIDs
		rootElement.setSender(PixPdqV3Utils.createMCCIMT000100UV01Sender(applicationOID, facilityOID));

		this.sendingApplication = applicationOID;
		this.sendingFacility = facilityOID;
	}
}
