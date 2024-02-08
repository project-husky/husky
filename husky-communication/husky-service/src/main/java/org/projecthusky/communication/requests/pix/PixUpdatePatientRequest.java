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
package org.projecthusky.communication.requests.pix;

import org.projecthusky.communication.mpi.impl.PixPdqQueryControlActProcess;
import org.projecthusky.communication.mpi.impl.pix.V3PixSourceRecordRevised;
import org.projecthusky.communication.requests.BaseRequest;
import org.projecthusky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;

/**
 * Request class collecting all XML elements, starting by the root.<br/>
 * Mostly a copy of the {@link V3PixSourceRecordRevised} earlier class.
 * @author szalai
 */
public class PixUpdatePatientRequest extends BaseRequest {
	private PRPAIN201302UV02Type rootElement;
	private String patientId = "";

	/**
	 * Create a UpdatePatientRequest with the supplied sender and receiver
	 * @param senderApplicationOID
	 * @param senderFacilityOID
	 * @param receiverApplicationOID
	 * @param receiverFacilityOID
	 */
	public PixUpdatePatientRequest(String senderApplicationOID, String senderFacilityOID, String receiverApplicationOID, String receiverFacilityOID) {
		super(senderApplicationOID);

		// set the interaction id (Patient Record Added)
		getRootElement().setInteractionId( PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201302UV02", "") );

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		queryControlActProcess = new PixPdqQueryControlActProcess( new PRPAIN201302UV02MFMIMT700701UV01ControlActProcess() );

		addControlActProcess();
	}

	@Override
	protected void addControlActProcess() {
		// add the control act process to the message
		getRootElement().setControlActProcess(queryControlActProcess.getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess());
	}

	/**
	 * Add a Receiver with the supplied IDs
	 * @param applicationOID (Device ID)
	 * @param facilityOID (Organization ID)
	 */
	public void addReceiver(String applicationOID, String facilityOID) {
		this.addReceivingApplication(applicationOID);
		this.addReceivingFacility(facilityOID);
		getRootElement().getReceiver().add(PixPdqV3Utils.createMCCIMT000100UV01Receiver(applicationOID, facilityOID));
	}

	/**
	 * Get the patient ID
	 * @return String - the patient id
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * Get the root element
	 * @return {@link PRPAIN201302UV02Type} - the root element
	 */
	public PRPAIN201302UV02Type getRootElement() {
		if (rootElement == null) {
			rootElement = new PRPAIN201302UV02Type();
		}
		return rootElement;
	}

	/**
	 * Set the processing code.
	 */
	@Override
	protected void setProcessingCode() {
		getRootElement().setProcessingCode(PixPdqV3Utils.createCS(processingCode));
	}

	@Override
	protected void setProcessingModeCode() {
		// The value of processingModeCode SHALL be set to T
		getRootElement().setProcessingModeCode(PixPdqV3Utils.createCS(processingModeCode));
	}

	/**
	 * Set the sender ids
	 * @param applicationOID (Device ID)
	 * @param facilityOID (Organization ID)
	 */
	@Override
	public void setSender(String applicationOID, String facilityOID) {
		super.setSender(applicationOID, facilityOID);

		// set the sender/application OIDs
		getRootElement().setSender(PixPdqV3Utils.createMCCIMT000100UV01Sender(applicationOID, facilityOID));
	}

	@Override
	protected void setAcceptAckCode() {
		// The acceptAckCode SHALL be set to AL
		getRootElement().setAcceptAckCode(PixPdqV3Utils.createCS(acceptAckCode));
	}

	@Override
	protected void setCreationTime() {
		// set current time
		getRootElement().setCreationTime(PixPdqV3Utils.createTSCurrentTime());
	}

	@Override
	protected void setITSVersion() {
		// indicate ITSVersion XML_1.0
		getRootElement().setITSVersion(itsVersion);
	}

	@Override
	protected void setId() {
		getRootElement().setId(messageId);
	}

}
