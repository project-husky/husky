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
package org.husky.communication.mpi.impl.pix;

import org.husky.communication.mpi.V3Message;
import org.husky.communication.mpi.impl.PixPdqQueryControlActProcess;
import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixSourceRecordRevised extends V3Message {

	// the PIX query
	private PRPAIN201302UV02Type rootElement = new PRPAIN201302UV02Type();
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

		super(senderApplicationOID);

		// set the interaction id (Patient Record Added)
		getRootElement().setInteractionId(
				PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201302UV02", ""));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		queryControlActProcess = new PixPdqQueryControlActProcess(
				new PRPAIN201302UV02MFMIMT700701UV01ControlActProcess());

		addControlActProcess();
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
		getRootElement().getReceiver()
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
		if (rootElement == null) {
			rootElement = new PRPAIN201302UV02Type();
		}

		return rootElement;
	}

	/**
	 * Set the processing code.
	 *
	 * @param processingCode
	 */
	public void setProcessingCode(String processingCode) {
		getRootElement().setProcessingCode(PixPdqV3Utils.createCS(processingCode));
	}

	/**
	 * Set the sender ids
	 *
	 * @param applicationOID
	 *            (Device ID)
	 * @param facilityOID
	 *            (Organization ID)
	 */
	@Override
	public void setSender(String applicationOID, String facilityOID) {
		super.setSender(applicationOID, facilityOID);

		// set the sender/application OIDs
		getRootElement()
				.setSender(PixPdqV3Utils.createMCCIMT000100UV01Sender(applicationOID, facilityOID));
	}

	@Override
	protected void addControlActProcess() {
		// add the control act process to the message
		getRootElement()
				.setControlActProcess(queryControlActProcess.getPRPAIN201302UV02MFMIMT700701UV01ControlActProcess());
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

	@Override
	protected void setCreationTime() {
		// set current time
		getRootElement().setCreationTime(PixPdqV3Utils.createTSCurrentTime());
	}

	@Override
	protected void setProcessingCode() {
		// set ProcessingCode. This attribute defines whether the message is
		// part of a production,
		// training, or debugging system. Valid values are D (Debugging), T
		// (Testing), P (Production)
		// Will default to production because it will need to be that way in the
		// field.
		this.setProcessingCode(processingCode);
	}

	@Override
	protected void setProcessingModeCode() {
		// The value of processingModeCode SHALL be set to T
		getRootElement().setProcessingModeCode(PixPdqV3Utils.createCS(processingModeCode));
	}

	@Override
	protected void setAcceptAckCode() {
		// The acceptAckCode SHALL be set to AL
		getRootElement().setAcceptAckCode(PixPdqV3Utils.createCS(acceptAckCode));
	}

}
