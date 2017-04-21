/*
 * 
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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 * 
 */

package org.ehealth_connector.validation.service.pdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains PDF validation results
 *
 */
public class PdfValidationResultEntry {

	/** Severity values */
	public enum SEVERITY {
		Error, Warning, Information, CustomWarning
	};

	/** Status values */
	public enum STATUS {
		Success, Failure
	};

	/** String indication an error */
	private static String T_ERROR = "Error";

	/** String indication a warning */
	private static String T_WARNING = "Warning";

	/** String indication a custom warning */
	private static String T_CUSTOMWARNING = "Custom warning";

	/** String indication an information */
	private static String T_INFORMATION = "Information";

	/**
	 * Creates a copy of the given validation result entry
	 *
	 * @param src
	 *            The validation result entry to be copied
	 * @return The copy
	 */
	public static PdfValidationResultEntry copy(PdfValidationResultEntry src) {
		PdfValidationResultEntry retVal = new PdfValidationResultEntry();
		String errMsg = src.getErrMsg();
		retVal.setErrMsg(errMsg, src.getSeverity(errMsg));
		return retVal;
	}

	/** Status of this validation entry */
	private STATUS status = STATUS.Success;

	/** line number of the validated PDF within the parent CDA document */
	private String lineNumber;

	/** Error indicator */
	private Boolean containsErrors = false;

	/** Error messages */
	private List<String> errMsgs = new ArrayList<>();

	/** Internal index */
	private final int currentItem = 0;

	/**
	 * Gets the current error message
	 *
	 * @return The current error message
	 */
	public String getErrMsg() {
		if (currentItem < errMsgs.size())
			return errMsgs.get(currentItem);
		else
			return "uups oput of bounds";
	}

	/**
	 * Gets a list of all error messages
	 *
	 * @return A list of all error messages
	 */
	public List<String> getErrMsgs() {
		return errMsgs;
	}

	/**
	 * Gets a sorted list of all error messages
	 *
	 * @return A sorted list of all error messages
	 */
	public List<String> getErrMsgsSorted() {
		String temp;
		Iterator<String> iter = errMsgs.iterator();
		final List<String> tempErrMsgsSorted = new ArrayList<String>();
		// All Errors
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_ERROR))
				tempErrMsgsSorted.add(temp);
		}
		// All Warnings
		iter = errMsgs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_WARNING))
				tempErrMsgsSorted.add(temp);
		}
		// All Custom Warnings
		iter = errMsgs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_CUSTOMWARNING))
				tempErrMsgsSorted.add(temp);
		}
		// All Informations
		iter = errMsgs.iterator();
		while (iter.hasNext()) {
			temp = iter.next();
			if (temp.startsWith(T_INFORMATION))
				tempErrMsgsSorted.add(temp);
		}

		return tempErrMsgsSorted;
	}

	/**
	 * Gets the line number of the validated PDF within the parent CDA document
	 *
	 * @return The line number of the validated PDF within the parent CDA
	 *         document
	 */
	public String getLineNumber() {
		return lineNumber;
	}

	/**
	 * Gets the severity of the given error message
	 *
	 * @param errMsg
	 *            The error message to be interpreted for severity
	 * @return The severity of the given error message
	 */
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

	/**
	 * Gets the status of this validation entry
	 *
	 * @return The status of this validation entry
	 */
	public STATUS getStatus() {
		return status;
	}

	/**
	 * Indicates whether the validation result contains at least one error or
	 * warning
	 *
	 * @return True, when the validation result contains at least one error or
	 *         warning. False otherwise.
	 */
	public boolean hasError() {
		return containsErrors;
	}

	/**
	 * Sets an error message
	 *
	 * @param errMsg
	 *            The error message
	 *
	 * @param severity
	 *            The severity of the error message
	 */
	public void setErrMsg(String errMsg, SEVERITY severity) {
		status = STATUS.Failure;
		switch (severity) {
		case CustomWarning:
			if (!errMsg.startsWith(T_CUSTOMWARNING + ": "))
				this.errMsgs.add(T_CUSTOMWARNING + ": " + errMsg);
			break;
		case Error:
			if (!errMsg.startsWith(T_ERROR + ": "))
				this.errMsgs.add(T_ERROR + ": " + errMsg);
			this.containsErrors = true;
			break;
		case Warning:
			if (!errMsg.startsWith(T_WARNING + ": "))
				this.errMsgs.add(T_WARNING + ": " + errMsg);
			this.containsErrors = true;
			break;
		default:
			if (!errMsg.startsWith(T_INFORMATION + ": "))
				this.errMsgs.add(T_INFORMATION + ": " + errMsg);
			break;
		}
	}

	/**
	 * Sets a List of error messages
	 *
	 * @param errMsgs
	 *            The List of error messages to be set
	 */
	public void setErrMsgs(ArrayList<String> errMsgs) {
		status = STATUS.Failure;
		this.errMsgs = errMsgs;
	}

	/**
	 * Sets the line number of the validated PDF within the parent CDA document
	 *
	 * @param lineNumber
	 *            The line number of the validated PDF within the parent CDA
	 *            document
	 */
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
}
