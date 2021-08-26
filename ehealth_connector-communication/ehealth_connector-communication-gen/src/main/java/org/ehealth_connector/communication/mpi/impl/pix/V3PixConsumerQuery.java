/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */

package org.ehealth_connector.communication.mpi.impl.pix;

import org.hl7.v3.ActClassControlAct;
import org.hl7.v3.COCTMT090300UV01AssignedDevice;
import org.hl7.v3.PRPAIN201309UV02QUQIMT021001UV01ControlActProcess;
import org.hl7.v3.PRPAIN201309UV02Type;
import org.hl7.v3.PRPAMT201307UV02DataSource;
import org.hl7.v3.PRPAMT201307UV02ParameterList;
import org.hl7.v3.PRPAMT201307UV02PatientIdentifier;
import org.hl7.v3.PRPAMT201307UV02QueryByParameter;
import org.hl7.v3.QUQIMT021001UV01AuthorOrPerformer;
import org.hl7.v3.RoleClassAssignedEntityMember1;
import org.hl7.v3.V3Factory;
import org.hl7.v3.XActMoodIntentEvent;
import org.hl7.v3.XParticipationAuthorPerformer;
import org.openehealth.ipf.commons.ihe.hl7v3.core.requests.PixV3QueryRequest;
import org.openhealthtools.ihe.common.hl7v3.client.PixPdqV3Utils;
import org.openhealthtools.ihe.common.hl7v3.client.V3Message;
import org.openhealthtools.ihe.utils.OID;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixConsumerQuery extends V3Message {

	PixV3QueryRequest request;

	// the PIX query
	private PRPAIN201309UV02Type rootElement = null;
	private PRPAIN201309UV02QUQIMT021001UV01ControlActProcess queryControlActProcess = null;
	private PRPAMT201307UV02QueryByParameter queryByParameter = null;
	private PRPAMT201307UV02ParameterList parameterList = null;
	private QUQIMT021001UV01AuthorOrPerformer authorOrPerformer = null;
	private COCTMT090300UV01AssignedDevice assignedDevice = null;
	private String queryParams = "";

	/**
	 * Create a V3PixConsumerQuery with the supplied sender and receiver.
	 * 
	 * @param senderApplicationOID
	 *            (Sender Device ID)
	 * @param senderFacilityOID
	 *            (Sender Organization ID)
	 * @param receiverApplicationOID
	 *            (Receiving Device ID)
	 * @param receiverFacilityOID
	 *            (Receiving Organization ID)
	 */
	public V3PixConsumerQuery(String senderApplicationOID, String senderFacilityOID, String receiverApplicationOID,
			String receiverFacilityOID) {

		request = new PixV3QueryRequest();

		// create the root v3 pix element
		rootElement = V3Factory.eINSTANCE.createPRPAIN201309UV02Type();

		// add the root v3 pix element to the document root
		this.v3Message.setPRPAIN201309UV02(rootElement);

		// set the interaction id
		rootElement.setInteractionId(PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201309UV02", ""));

		// indicate ITSVersion XML_1.0
		rootElement.setITSVersion("XML_1.0");

		// create an id and set it
		this.messageId = PixPdqV3Utils.createII(OID.createOIDGivenRoot(senderApplicationOID), "", "");
		rootElement.setId(messageId);

		// set current time
		rootElement.setCreationTime(PixPdqV3Utils.createTS1CurrentTime());

		// set ProcessingCode. This attribute defines whether the message is part of a production,
		// training, or debugging system. Valid values are D (Debugging), T (Testing), P (Production)
		// TODO: how can this be indicated outside of the system? New bridge.properties global to indicate "testing"?
		// Will default to production because it will need to be that way in the field.
		this.setProcessingCode("P");

		// The value of processingModeCode SHALL be set to T
		rootElement.setProcessingModeCode(PixPdqV3Utils.createCS1("T"));

		// The acceptAckCode SHALL be set to AL
		rootElement.setAcceptAckCode(PixPdqV3Utils.createCS1("AL"));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		// create the controlActProcess
		queryControlActProcess = V3Factory.eINSTANCE.createPRPAIN201309UV02QUQIMT021001UV01ControlActProcess();

		// add the control act process to the message
		rootElement.setControlActProcess(queryControlActProcess);

		// set the class code
		queryControlActProcess.setClassCode(ActClassControlAct.CACT);

		// TODO: CONFLICT: The value of ControlActProcess.moodCode SHALL be set to RQO
		queryControlActProcess.setMoodCode(XActMoodIntentEvent.EVN);

		// The trigger event code in ControlActProcess.code SHALL be set to PRPA_TE201309UV02 (2.16.840.1.113883.1.6)
		// CP 506: <code code="PRPA_TE201309UV02" codeSystem="2.16.840.1.113883.1.18"/>
		queryControlActProcess.setCode(PixPdqV3Utils.createCD("PRPA_TE201309UV02", "2.16.840.1.113883.1.18", "", ""));

		// Set the authorOrPerformer
		authorOrPerformer = V3Factory.eINSTANCE.createQUQIMT021001UV01AuthorOrPerformer();

		// The authorOrPerformer typeCode SHALL be set to AUT
		authorOrPerformer.setTypeCode(XParticipationAuthorPerformer.AUT);

		// Set the assigned Device
		assignedDevice = V3Factory.eINSTANCE.createCOCTMT090300UV01AssignedDevice();

		// Indicate classcode of assigned device.
		assignedDevice.setClassCode(RoleClassAssignedEntityMember1.ASSIGNED);

		// Add the assigned device to the author
		authorOrPerformer.setAssignedDevice(assignedDevice);

		// Add the authorOrPerformer
		queryControlActProcess.getAuthorOrPerformer().add(authorOrPerformer);

		// create the query by parameter
		queryByParameter = V3Factory.eINSTANCE.createPRPAMT201307UV02QueryByParameter();

		// add the query by parameter object to the control act process
		queryControlActProcess.setQueryByParameter(queryByParameter);

		// set the queryId
		// TODO: Where do I get the root OID from? sender?
		queryByParameter.setQueryId(PixPdqV3Utils.createIIwithUniqueExtension("1.2.840.114350.1.13.28.1.18.5.999"));

		// QueryByParameter.statusCode is defaulted to "new".
		queryByParameter.setStatusCode(PixPdqV3Utils.createCS1("new"));

		// QueryByParameter.responsePriorityCode is required and is fixed to I (Immediate)
		queryByParameter.setResponsePriorityCode(PixPdqV3Utils.createCS1("I"));

		// create the parameter list
		parameterList = V3Factory.eINSTANCE.createPRPAMT201307UV02ParameterList();

		// add the parameter list to the query by parameter
		queryByParameter.setParameterList(parameterList);
	}

	/**
	 * Add a domain to return to the query
	 * 
	 * @param universalId
	 * @param namespaceId
	 */
	public void addDomainToReturn(String universalId, String namespaceId) {
		queryParams += "Data Source: " + universalId + "^" + namespaceId + ",";
		// create the data source to indicate domain to return
		PRPAMT201307UV02DataSource dataSource = V3Factory.eINSTANCE.createPRPAMT201307UV02DataSource();

		// populate the datasource
		dataSource.getValue().add(PixPdqV3Utils.createII(universalId, "", namespaceId));

		// set the semantics text
		dataSource.setSemanticsText(PixPdqV3Utils.createST1("DataSource.id"));

		// add the data source to the parameter list
		parameterList.getDataSource().add(dataSource);
	}

	/**
	 * Add a patient identifier to query
	 * 
	 * @param patientId
	 * @param universalId
	 * @param namespaceId
	 */
	public void addPatientIdToQuery(String patientId, String universalId, String namespaceId) {
		queryParams += "Patient ID: " + universalId + "^" + patientId + ",";
		// create the patient identifier
		PRPAMT201307UV02PatientIdentifier patientIdentifier = V3Factory.eINSTANCE
				.createPRPAMT201307UV02PatientIdentifier();

		// add the root and assign authority
		patientIdentifier.getValue().add(PixPdqV3Utils.createII(universalId, patientId, namespaceId));

		// set semantics text
		patientIdentifier.setSemanticsText(PixPdqV3Utils.createST1("Patient.Id"));

		// add the patient identifier to the list
		parameterList.getPatientIdentifier().add(patientIdentifier);
	}

	// Add a receiver to the query
	/**
	 * @param applicationOID
	 *            (Receiving Device ID)
	 * @param facilityOID
	 *            (Receiving Organization ID)
	 */
	public void addReceiver(String applicationOID, String facilityOID) {
		this.addReceivingApplication(applicationOID);
		this.addReceivingFacility(facilityOID);
		rootElement.getReceiver().add(PixPdqV3Utils.createMCCIMT000100UV01Receiver(applicationOID, facilityOID));
	}

	/**
	 * Get the pix query control act process element
	 * 
	 * @return PRPAIN201309UV02QUQIMT021001UV01ControlActProcess - Control Act Process
	 */
	public PRPAIN201309UV02QUQIMT021001UV01ControlActProcess getControlActProcess() {
		return queryControlActProcess;
	}

	/**
	 * Gets the current parameter list for this query.
	 * 
	 * @return PRPAMT201307UV02ParameterList - Parameter List
	 */
	public PRPAMT201307UV02ParameterList getParameterList() {
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
	 * Get the root element for this query
	 * 
	 * @return PRPAIN201309UV02Type - Root Element for the query
	 */
	public PRPAIN201309UV02Type getRootElement() {
		return rootElement;
	}

	/**
	 * Set the processing code to the supplied string
	 * 
	 * @param processingCode
	 */
	public void setProcessingCode(String processingCode) {
		rootElement.setProcessingCode(PixPdqV3Utils.createCS1(processingCode));
	}

	/**
	 * Set the sender for this query
	 * 
	 * @param applicationOID
	 *            (Sender Device ID)
	 * @param facilityOID
	 *            (Sender Organization ID)
	 */
	public void setSender(String applicationOID, String facilityOID) {
		// set the sender/application OIDs
		this.sendingApplication = applicationOID;
		this.sendingFacility = facilityOID;
		rootElement.setSender(PixPdqV3Utils.createMCCIMT000100UV01Sender(applicationOID, facilityOID));
	}
}
