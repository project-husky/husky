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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.validation.service.pdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PdfValidationResultEntry {

	public enum SEVERITY {
		Error, Warning, Information, CustomWarning
	};

	private static String T_ERROR = "Error";
	private static String T_WARNING = "Warning";
	private static String T_CUSTOMWARNING = "Custom warning";
	private static String T_INFORMATION = "Information";

	public static PdfValidationResultEntry copy(PdfValidationResultEntry src) {
		PdfValidationResultEntry retVal = new PdfValidationResultEntry();
		String errMsg = src.getErrMsg();
		retVal.setErrMsg(errMsg, src.getSeverity(errMsg));
		return retVal;
	}

	private String lineNumber;
	private Boolean errSeverity = false;
	private final List<SEVERITY> severities = new ArrayList<>();
	private List<String> errMsgs = new ArrayList<>();

	private final int currentItem = 0;

	public String getErrMsg() {
		if (currentItem < errMsgs.size())
			return errMsgs.get(currentItem);
		else
			return "uups oput of bounds";
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

	public String getLineNumber() {
		return lineNumber;
	}

	public SEVERITY getSeverity(String errMsg) {
		SEVERITY retVal = SEVERITY.Error;
		if (errMsg.startsWith(T_CUSTOMWARNING))
			retVal = SEVERITY.CustomWarning;
		if (errMsg.startsWith(T_ERROR))
			retVal = SEVERITY.Error;
		if (errMsg.startsWith(T_WARNING))
			retVal = SEVERITY.Warning;
		if (errMsg.startsWith(T_INFORMATION))
			retVal = SEVERITY.Information;
		return retVal;
	}

	public PdfValidationResultEntry getValidationResultEntry() {
		return this;
	}

	/**
	 * überprüft, ob einer der ErrorCodes = Error od. Warning
	 *
	 * @return
	 */
	public boolean hasError() {
		return errSeverity;
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
			if (!errMsg.startsWith(T_CUSTOMWARNING + ": "))
				this.errMsgs.add(T_CUSTOMWARNING + ": " + errMsg);
			break;
		case Error:
			if (!errMsg.startsWith(T_ERROR + ": "))
				this.errMsgs.add(T_ERROR + ": " + errMsg);
			this.errSeverity = true;
			break;
		case Warning:
			if (!errMsg.startsWith(T_WARNING + ": "))
				this.errMsgs.add(T_WARNING + ": " + errMsg);
			this.errSeverity = true;
			break;
		default:
			if (!errMsg.startsWith(T_INFORMATION + ": "))
				this.errMsgs.add(T_INFORMATION + ": " + errMsg);
			break;
		}
	}

	public void setErrMsgs(ArrayList<String> errMsgs) {
		this.errMsgs = errMsgs;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

}
