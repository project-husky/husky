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
 */

package org.ehealth_connector.validation.service.pdf;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all the results of a veraPDF validation cycle
 *
 */
public class VeraPdfValidationResult {

	/** Indicates if the pdf is valid */
	private boolean isPdfValid = false;
	/** List with all results of a veraPDF validation */
	private final List<VeraPdfValidationResultEntry> results = new ArrayList<VeraPdfValidationResultEntry>();
	/** Indicates if valididation cycle has finished */
	private boolean validationDone = false;

	/** Adds a new entry to the list of results */
	public void add(VeraPdfValidationResultEntry entry) {
		results.add(entry);
	}

	/** Returns the list of results */
	public List<VeraPdfValidationResultEntry> getEntries() {
		return results;
	}

	/** True if the pdf validation has finished */
	public boolean isDone() {
		return validationDone;
	}

	/** True if the pdf-document is valid */
	public boolean isPdfValid() {
		return this.isPdfValid;
	}

	/** Set the isDone to false */
	public void resetIsDone() {
		validationDone = false;
	}

	/** Set the isDone to true */
	public void setIsDone() {
		validationDone = true;
	}

	/** Set the the pdf validation status */
	public void setPdfValid(boolean isPdfValid) {
		this.isPdfValid = isPdfValid;
	}
}
