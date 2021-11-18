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
	 * @returnString - Receiving Application
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

}
