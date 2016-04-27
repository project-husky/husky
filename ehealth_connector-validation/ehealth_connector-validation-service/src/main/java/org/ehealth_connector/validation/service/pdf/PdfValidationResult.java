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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfValidationResult {

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	private boolean validationDone = false;

	private final List<PdfValidationResultEntry> results = new ArrayList<PdfValidationResultEntry>();

	public void add(PdfValidationResultEntry entry) {
		results.add(entry);
	}

	public List<PdfValidationResultEntry> getEntries() {
		return results;
	}

	public boolean isDone() {
		return validationDone;
	}

	public boolean isPdfValid() {
		boolean retVal = true;
		for (PdfValidationResultEntry entry : results) {
			if (entry.hasError())
				retVal = false;
		}
		return retVal;
	}

	public boolean isPdfValidatorApiInstalled() {
		boolean retVal = true;
		for (PdfValidationResultEntry entry : results) {
			for (String msg : entry.getErrMsgsSorted()) {
				if (msg.contains(PdfValidator.ERR_NOT_INSTALLED)) {
					retVal = false;
					break;
				}
			}
			if (!retVal)
				break;
		}
		return retVal;
	}

	public boolean isPdfValidatorApiLicensed() {
		boolean retVal = true;
		for (PdfValidationResultEntry entry : results) {
			for (String msg : entry.getErrMsgsSorted()) {
				if (msg.contains(PdfValidator.ERR_INVALID_LICENSE)) {
					retVal = false;
					break;
				}
			}
			if (!retVal)
				break;
		}
		return retVal;
	}

	public void resetIsDone() {
		validationDone = false;
	}

	public void setIsDone() {
		validationDone = true;
	}
}
