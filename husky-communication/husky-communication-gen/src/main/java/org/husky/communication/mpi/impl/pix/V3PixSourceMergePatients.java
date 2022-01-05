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

import net.ihe.gazelle.hl7v3.mfmimt700701UV01.MFMIMT700701UV01PriorRegisteredRole;
import net.ihe.gazelle.hl7v3.mfmimt700701UV01.MFMIMT700701UV01PriorRegistration;
import net.ihe.gazelle.hl7v3.mfmimt700701UV01.MFMIMT700701UV01ReplacementOf;
import net.ihe.gazelle.hl7v3.mfmimt700701UV01.MFMIMT700701UV01Subject3;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02MFMIMT700701UV01ControlActProcess;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02Type;
import net.ihe.gazelle.hl7v3.voc.ActClass;
import net.ihe.gazelle.hl7v3.voc.ActMood;
import net.ihe.gazelle.hl7v3.voc.ParticipationTargetSubject;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixSourceMergePatients extends V3Message {

	// the PIX query
	private PRPAIN201304UV02Type rootElement;
	private String patientId = "";

	/**
	 * Create a V3PixSourceMergePatients with the supplied sender and receiver
	 *
	 * @param senderApplicationOID
	 * @param senderFacilityOID
	 * @param receiverApplicationOID
	 * @param receiverFacilityOID
	 */
	public V3PixSourceMergePatients(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID, String receiverFacilityOID) {

		super(senderApplicationOID);

		// set the interaction id (Patient Record Added)
		getRootElement().setInteractionId(
				PixPdqV3Utils.createII("2.16.840.1.113883.1.6", "PRPA_IN201304UV02", ""));

		// set the sender
		this.setSender(senderApplicationOID, senderFacilityOID);

		// add the receiver
		this.addReceiver(receiverApplicationOID, receiverFacilityOID);

		queryControlActProcess = new PixPdqQueryControlActProcess(
				new PRPAIN201304UV02MFMIMT700701UV01ControlActProcess());

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
	 * @return PRPAIN201304UV02Type - the root element
	 */
	public PRPAIN201304UV02Type getRootElement() {
		if (rootElement == null) {
			rootElement = new PRPAIN201304UV02Type();
		}

		return rootElement;
	}

	/**
	 * Set the obsolete patient ID
	 *
	 * @param extension
	 * @param root
	 * @param namespace
	 */
	public void setObsoletePatientID(String extension, String root, String namespace) {
		final var idString = new StringBuilder();
		idString.append(extension) //
				.append("^^^");
		if (namespace != null) {
			idString.append(namespace);
		}
		idString.append("&") //
				.append(root) //
				.append("&ISO");
		patientId = idString.toString();

		// add a replacement of
		var replacementOf = new MFMIMT700701UV01ReplacementOf();
		queryControlActProcess.getPRPAIN201304UV02MFMIMT700701UV01RegistrationEvent().getReplacementOf()
				.add(replacementOf);
		replacementOf.setTypeCode("RPLC");
		var priorRegistration = new MFMIMT700701UV01PriorRegistration();
		replacementOf.setPriorRegistration(priorRegistration);
		priorRegistration.setClassCode(ActClass.REG);
		priorRegistration.setMoodCode(ActMood.EVN);
		priorRegistration.setStatusCode(PixPdqV3Utils.createCS("obsolete"));
		var priorRegistrationSubject = new MFMIMT700701UV01Subject3();
		priorRegistration.setSubject1(priorRegistrationSubject);
		priorRegistrationSubject.setTypeCode(ParticipationTargetSubject.SBJ);
		var priorRegisteredRole = new MFMIMT700701UV01PriorRegisteredRole();
		priorRegistrationSubject.setPriorRegisteredRole(priorRegisteredRole);
		priorRegisteredRole.setClassCode("PAT");
		priorRegisteredRole.getId().add(PixPdqV3Utils.createII(root, extension, namespace));
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
				.setControlActProcess(queryControlActProcess.getPRPAIN201304UV02MFMIMT700701UV01ControlActProcess());
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
