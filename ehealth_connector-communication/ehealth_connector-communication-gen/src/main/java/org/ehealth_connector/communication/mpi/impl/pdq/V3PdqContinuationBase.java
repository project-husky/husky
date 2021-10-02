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

package org.ehealth_connector.communication.mpi.impl.pdq;

import org.ehealth_connector.common.utils.OID;
import org.ehealth_connector.communication.mpi.V3Message;
import org.ehealth_connector.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.datatypes.II;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Acknowledgement;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01TargetMessage;
import net.ihe.gazelle.hl7v3.quqiin000003UV01.QUQIIN000003UV01Type;
import net.ihe.gazelle.hl7v3.quqimt000001UV01.QUQIMT000001UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.quqimt000001UV01.QUQIMT000001UV01QueryContinuation;
import net.ihe.gazelle.hl7v3.voc.ActClassControlAct;
import net.ihe.gazelle.hl7v3.voc.XActMoodIntentEvent;

public abstract class V3PdqContinuationBase extends V3Message {

	protected QUQIIN000003UV01Type rootElement = new QUQIIN000003UV01Type();
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

		// set the interaction id
		rootElement.setInteractionId(PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "QUQI_IN000003UV01", ""));

		// indicate ITSVersion XML_1.0
		rootElement.setITSVersion("XML_1.0");

		// create an id and set it
		this.messageId = PixPdqV3Utils.createII(OID.createOIDGivenRoot(senderApplicationOID), "", "");
		rootElement.setId(messageId);

		// set current time
		rootElement.setCreationTime(PixPdqV3Utils.createTSCurrentTime());

		// set the processing code
		this.setProcessingCode("T");

		// The value of processingModeCode SHALL be set to T
		rootElement.setProcessingModeCode(PixPdqV3Utils.createCS("T"));

		// The acceptAckCode SHALL be set to AL
		rootElement.setAcceptAckCode(PixPdqV3Utils.createCS("AL"));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		// create an acknowledgement
		var acknowledgement = new MCCIMT000300UV01Acknowledgement();

		// add the acknowledgement to the root element
		rootElement.getAcknowledgement().add(acknowledgement);

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
		rootElement.setControlActProcess(continuationCAP);

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
		rootElement.getReceiver().add(PixPdqV3Utils.createMCCIMT000300UV01Receiver(applicationOID, facilityOID));
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
	 * Set the sender for the query
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
		rootElement.setSender(PixPdqV3Utils.createMCCIMT000300UV01Sender(applicationOID, facilityOID));
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
		return this.rootElement;
	}

}
