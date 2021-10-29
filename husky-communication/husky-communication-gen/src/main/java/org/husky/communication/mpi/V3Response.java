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

package org.husky.communication.mpi;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public abstract class V3Response extends V3Message {

	protected String acknowledgementCode = null;
	protected String acknowledgementDetailCode = null;
	protected String acknowledgementDetailText = null;
	protected String errorText = "";
	protected List<String> infoText = new LinkedList<>();
	protected List<String> infoCodes = new LinkedList<>();
	protected boolean hasError = false;

	/**
	 * Get the acknowledgement code
	 * 
	 * @return String - acknowledgementCode
	 */
	public String getAcknowledgementCode() {
		return acknowledgementCode;
	}

	/**
	 * Get the acknowledgement detail code
	 * 
	 * @return String - acknowledgementDetailCode
	 */
	public String getAcknowledgementDetailCode() {
		return acknowledgementDetailCode;
	}

	/**
	 * Get the acknowledgement detail text
	 * 
	 * @return String - acknowledgementDetailText
	 */
	public String getAcknowledgementDetailText() {
		return acknowledgementDetailText;
	}

	/**
	 * Get the error text
	 * 
	 * @return String - errorText
	 */
	public String getErrorText() {
		return errorText;
	}

	public List<String> getInfoText() {
		return infoText;
	}

	public List<String> getInfoCodes() {
		return infoCodes;
	}

	/**
	 * Determine if there has been an error or not.
	 * 
	 * @return boolean - hasError
	 */
	public boolean hasError() {
		return hasError;
	}

	protected void setAcknowledgementCode(String ackCode) {
		// set the ack code
		this.acknowledgementCode = ackCode;

		// assume there was an error, unless we make it through this mess
		hasError = true;

		// if the code was AA, then:
		if (acknowledgementCode.equalsIgnoreCase("AA")) {
			// not an non-error
			hasError = false;
		} else if (acknowledgementCode.equalsIgnoreCase("CA")) {
			// not an error
			hasError = false;
		}
		// if this was an app error
		else if (acknowledgementCode.equalsIgnoreCase("AE")) {
			// set the error text
			errorText = "Acknowledgement: AE (Application Acknowledgement Error)";
		} else if (acknowledgementCode.equalsIgnoreCase("AR")) {
			// set the error text
			errorText = "Acknowledgement: AR (Application Acknowledgement Reject)";
		} else if (acknowledgementCode.equalsIgnoreCase("CE")) {
			// set the error text
			errorText = "Acknowledgement: CE (Accept Acknowledgement Commit Error)";
		} else if (acknowledgementCode.equalsIgnoreCase("CR")) {
			// set the error text
			errorText = "Acknowledgement: CR (Accept Acknowledgement Commit Reject)";
		} else {
			// set the error text
			errorText = "Acknowledgement: " + acknowledgementCode + " (Unknown Application Acknowledgement)";
		}
	}

	protected void setAcknowledgementDetail(String ackDetailCode, String ackDetailText, List<String> infoCodes, List<String> infoTexts) {
		this.acknowledgementDetailCode = ackDetailCode;
		this.acknowledgementDetailText = ackDetailText;

		// append the code and text to the error
		if (null != ackDetailCode)
			errorText = errorText + " - Code: " + ackDetailCode;
		if (null != ackDetailText)
			errorText = errorText + " (" + ackDetailText + ")";
		
		if(infoCodes != null) {
			this.infoCodes = infoCodes;
		}
		
		if(infoTexts != null) {
			this.infoText = infoTexts;
		}

	}
}
