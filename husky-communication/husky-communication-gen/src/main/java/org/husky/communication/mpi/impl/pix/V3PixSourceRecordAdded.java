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

import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02Type;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixSourceRecordAdded extends V3Message {

	// the PIX query
	private PRPAIN201301UV02Type rootElement = new PRPAIN201301UV02Type();

	/**
	 * Create a V3PixSourceRecordAdded with the supplied sender and receiver
	 *
	 * @param senderApplicationOID
	 * @param senderFacilityOID
	 * @param receiverApplicationOID
	 * @param receiverFacilityOID
	 */
	public V3PixSourceRecordAdded(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID, String receiverFacilityOID) {

		super(senderApplicationOID);

		// set the interaction id (Patient Record Added)
		rootElement.setInteractionId(
				PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201301UV02", ""));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		queryControlActProcess = new PixPdqQueryControlActProcess(
				new PRPAIN201301UV02MFMIMT700701UV01ControlActProcess());

		addControlActProcess();
	}

	@Override
	protected void addControlActProcess() {
		// add the control act process to the message
		rootElement.setControlActProcess(queryControlActProcess.getPRPAIN201301UV02MFMIMT700701UV01ControlActProcess());
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
	 * Get the root element
	 *
	 * @return PRPAIN201301UV02Type - the root element
	 */
	public PRPAIN201301UV02Type getRootElement() {
		return rootElement;
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
	@Override
	public void setScopingOrganization(String organizationOID, String organizationName,
			String telecomValue) {
		super.setScopingOrganization(organizationOID, organizationName, telecomValue);
		// add this orgnaization as custodian as well
		queryControlActProcess.setCustodian(organizationOID, organizationName);
		addControlActProcess();
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
		// set the sender/application OIDs
		this.sendingApplication = applicationOID;
		this.sendingFacility = facilityOID;
		rootElement
				.setSender(PixPdqV3Utils.createMCCIMT000100UV01Sender(applicationOID, facilityOID));
	}

	@Override
	protected void setITSVersion() {
		// indicate ITSVersion XML_1.0
		rootElement.setITSVersion(itsVersion);
	}

	@Override
	protected void setId() {
		rootElement.setId(messageId);
	}

	@Override
	protected void setCreationTime() {
		// set current time
		rootElement.setCreationTime(PixPdqV3Utils.createTSCurrentTime());
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
		rootElement.setProcessingModeCode(PixPdqV3Utils.createCS(processingModeCode));
	}

	@Override
	protected void setAcceptAckCode() {
		// The acceptAckCode SHALL be set to AL
		rootElement.setAcceptAckCode(PixPdqV3Utils.createCS(acceptAckCode));
	}

}
