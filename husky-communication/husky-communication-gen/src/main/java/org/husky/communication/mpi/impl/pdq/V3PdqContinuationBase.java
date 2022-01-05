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
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Acknowledgement;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01TargetMessage;
import net.ihe.gazelle.hl7v3.quqiin000003UV01.QUQIIN000003UV01Type;
import net.ihe.gazelle.hl7v3.quqimt000001UV01.QUQIMT000001UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.quqimt000001UV01.QUQIMT000001UV01QueryContinuation;
import net.ihe.gazelle.hl7v3.voc.ActClassControlAct;
import net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public abstract class V3PdqContinuationBase extends V3Message {

	protected QUQIIN000003UV01Type rootElement;
	protected QUQIMT000001UV01QueryContinuation queryContinuation = new QUQIMT000001UV01QueryContinuation();

	/**
	 * Create a V3PdqContinuationBase with the provided sender and receiver and original query
	 * 
	 * @param senderApplicationOID
	 *            (Sender Device ID)
	 * @param senderFacilityOID
	 *            (Sender Organization ID)
	 * @param receiverApplicationOID
	 *            (Receiver Device ID)
	 * @param receiverFacilityOID
	 *            (Receiver Organization ID)
	 * @param v3pdqresponse
	 *            (The original V3 PDQ Response)
	 */
	protected V3PdqContinuationBase(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID,
			String receiverFacilityOID, V3PdqConsumerResponse v3pdqresponse) {

		super(senderApplicationOID);

		// set the interaction id
		getRootElement().setInteractionId(PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "QUQI_IN000003UV01", ""));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		// create an acknowledgement
		var acknowledgement = new MCCIMT000300UV01Acknowledgement();

		// add the acknowledgement to the root element
		getRootElement().getAcknowledgement().add(acknowledgement);

		// add the typecode
		acknowledgement.setTypeCode(PixPdqV3Utils.createCS("AA"));

		// create target message
		var targetMessage = new MCCIMT000300UV01TargetMessage();

		// add targer message to the acknowledgement
		acknowledgement.setTargetMessage(targetMessage);

		// set the id of the message targeted in the acknowledgement (responseId)
		targetMessage.setId(PixPdqV3Utils.copyII(v3pdqresponse.getMessageId()));

		// create the control act process
		var continuationCAP = new QUQIMT000001UV01ControlActProcess();

		// add the control act process
		getRootElement().setControlActProcess(continuationCAP);

		// set the class code
		continuationCAP.setClassCode(ActClassControlAct.CACT);
		continuationCAP.setMoodCode(XActMoodIntentEvent.EVN);

		// set the code
		continuationCAP.setCode(PixPdqV3Utils.createCD("PRPA_TE000003UV01", "", "", ""));

		// add the continuation to the control act process
		continuationCAP.setQueryContinuation(queryContinuation);

		// set the id of the query to continue
		queryContinuation.setQueryId(PixPdqV3Utils.copyII(v3pdqresponse.getAckQueryID()));
	}

	/**
	 * Add a receiver to the query
	 * 
	 * @param applicationOID
	 *            (Receiver Device ID)
	 * @param facilityOID
	 *            (Receiver Organization ID)
	 */
	public void addReceiver(String applicationOID, String facilityOID) {
		this.addReceivingApplication(applicationOID);
		this.addReceivingFacility(facilityOID);
		getRootElement().getReceiver().add(PixPdqV3Utils.createMCCIMT000300UV01Receiver(applicationOID, facilityOID));
	}

	@Override
	protected void setAcceptAckCode() {
		// The acceptAckCode SHALL be set to AL
		getRootElement().setAcceptAckCode(PixPdqV3Utils.createCS(acceptAckCode));
	}

	/**
	 * Set the sender for the query
	 * 
	 * @param applicationOID
	 *            (Sender Device ID)
	 * @param facilityOID
	 *            (Sender Organization ID)
	 */
	@Override
	public void setSender(String applicationOID, String facilityOID) {
		// set the sender/application OIDs
		super.setSender(applicationOID, facilityOID);
		getRootElement().setSender(PixPdqV3Utils.createMCCIMT000300UV01Sender(applicationOID, facilityOID));
	}

	/**
	 * Gets the messageId
	 * 
	 * @return II - messageId
	 */
	public II getId() {
		return messageId;
	}

	public QUQIIN000003UV01Type getRootElement() {
		if (this.rootElement == null) {
			this.rootElement = new QUQIIN000003UV01Type();
		}

		return this.rootElement;
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

	/**
	 * Set the processing code
	 * 
	 * @param processingCode
	 */
	@Override
	protected void setProcessingCode() {
		// set ProcessingCode. This attribute defines whether the message is
		// part of a production,
		// training, or debugging system. Valid values are D (Debugging), T
		// (Testing), P (Production)
		// Will default to production because it will need to be that way in the
		// field.
		getRootElement().setProcessingCode(PixPdqV3Utils.createCS(processingCode));
	}

	public void setProcessingCode(String code) {
		getRootElement().setProcessingCode(PixPdqV3Utils.createCS(code));
	}

	@Override
	protected void setProcessingModeCode() {
		// The value of processingModeCode SHALL be set to T
		getRootElement().setProcessingModeCode(PixPdqV3Utils.createCS(processingModeCode));
	}


}
