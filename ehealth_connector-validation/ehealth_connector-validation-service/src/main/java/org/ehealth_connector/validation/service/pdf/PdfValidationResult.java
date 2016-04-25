/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.validation.service.pdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PdfValidationResult {

	public enum SEVERITY {
		Error, Warning, Information, CustomWarning
	};

	private static String T_ERROR = "Error";
	private static String T_WARNING = "Warning";
	private static String T_CUSTOMWARNING = "Custom warning";
	private static String T_INFORMATION = "Information";

	private String lineNumber;
	private Boolean errSeverity = false;
	private List<SEVERITY> severities = new ArrayList<>();
	private List<String> errMsgs = new ArrayList<>();
	// private ArrayList<Integer> errCodes = new ArrayList<>();
	private int currentItem = 0;

	/**
	 * überprüft, ob einer der ErrorCodes = Error od. Warning
	 * 
	 * @return
	 */
	public boolean hasError() {
		return errSeverity;
	}

	public PdfValidationResult getValidationResult() {
		return this;
	}

	/**
	 * Methode zur Aufbereitung der Validierungsmeldungen.
	 * 
	 * @param errMsg
	 * @param severity
	 */
	public void setErrMsg(String errMsg, SEVERITY severity) {
		switch (severity) {
		case CustomWarning:
			this.errMsgs.add(T_CUSTOMWARNING + ": " + errMsg);
			break;
		case Error:
			this.errMsgs.add(T_ERROR + ": " + errMsg);
			this.errSeverity = true;
			break;
		case Warning:
			this.errMsgs.add(T_WARNING + ": " + errMsg);
			this.errSeverity = true;
			break;
		default:
			this.errMsgs.add(T_INFORMATION + ": " + errMsg);
			break;
		}
	}

	public String getErrMsg() {
		return errMsgs.get(currentItem);
	}

	public List<String> getErrMsgs() {
		return errMsgs;
	}

	public List<String> getErrMsgsSorted() {
		String temp;
		Iterator<String> iter = errMsgs.iterator();
		final List<String> tempErrMsgsSorted = new ArrayList<String>();
		// Alle Errors
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_ERROR))
				tempErrMsgsSorted.add(temp);
		}
		// Alle Warnings
		iter = errMsgs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_WARNING))
				tempErrMsgsSorted.add(temp);
		}
		// Alle Custom Warnings
		iter = errMsgs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_CUSTOMWARNING))
				tempErrMsgsSorted.add(temp);
		}
		// Alle Informations
		iter = errMsgs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_INFORMATION))
				tempErrMsgsSorted.add(temp);
		}

		return tempErrMsgsSorted;
	}

	public void setErrMsgs(ArrayList<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

}
