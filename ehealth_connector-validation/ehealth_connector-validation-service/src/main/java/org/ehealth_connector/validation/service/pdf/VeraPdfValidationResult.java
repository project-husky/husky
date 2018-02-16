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
 * This class holds all the results of a veraPDF validation cycle.
 */
public class VeraPdfValidationResult {

	/** PDF compliance level as string. */
	private String pdfConformanceLevel = "not set";

	/** PDF reporting level as string. */
	private String reportingLevel = "not set";

	/** Indicates if the pdf is valid. */
	private boolean isPdfValid = false;

	/** List with all results of a veraPDF validation. */
	private final List<VeraPdfValidationResultEntry> results = new ArrayList<VeraPdfValidationResultEntry>();

	/** Indicates if valididation cycle has finished. */
	private boolean validationDone = false;

	/**
	 * Adds a new entry to the list of results.
	 *
	 * @param entry
	 *            the entry
	 */
	public void add(VeraPdfValidationResultEntry entry) {
		results.add(entry);
	}

	/**
	 * Gets the list of validation entries.
	 *
	 * @return the list of validation entries
	 */
	public List<VeraPdfValidationResultEntry> getEntries() {
		return results;
	}

	/**
	 * Gets the pdf conformance level (e.g. 1a).
	 *
	 * @return the pdf conformance level
	 */
	public String getPdfConformanceLevel() {
		return this.pdfConformanceLevel;
	}

	/**
	 * Gets the reporting level (e.g. 3 for information).
	 *
	 * @return the reporting level
	 */
	public String getReportingLevel() {
		return this.reportingLevel;
	}

	/**
	 * True if the pdf validation has finished.
	 *
	 * @return true, if the pdf validation has finished.
	 */
	public boolean isDone() {
		return validationDone;
	}

	/**
	 * Checks whether is pdf valid.
	 *
	 * @return true, if is pdf valid
	 */
	public boolean isPdfValid() {
		return this.isPdfValid;
	}

	/**
	 * Set the isDone to false.
	 */
	public void resetIsDone() {
		validationDone = false;
	}

	/**
	 * Set the isDone to true.
	 */
	public void setIsDone() {
		validationDone = true;
	}

	/**
	 * Sets the pdf conformance level.
	 * <ul>
	 * <li>1a: PDF/A 1a, ISO 19005-1, Level A compliance</li>
	 * <li>1b: PDF/A 1b, ISO 19005-1, Level B compliance</li>
	 * <li>2a: PDF/A 2a, ISO 19005-2, Level A compliance</li>
	 * <li>2b: PDF/A 2b, ISO 19005-2, Level B compliance</li>
	 * <li>2u: PDF/A 2u, ISO 19005-2, Level U compliance</li>
	 * <li>3a: PDF/A 3a, ISO 19005-3, Level A compliance</li>
	 * <li>3b: PDF/A 3b, ISO 19005-3, Level B compliance</li>
	 * <li>3u: PDF/A 3u, ISO 19005-3, Level U compliance</li>
	 * </ul>
	 *
	 * @param pdfConformanceLevel
	 *            the new pdf conformance level
	 */
	public void setPdfConformanceLevel(String pdfConformanceLevel) {
		this.pdfConformanceLevel = pdfConformanceLevel;
	}

	/**
	 * Set the the pdf validation status.
	 *
	 * @param isPdfValid
	 *            the new pdf valid
	 */
	public void setPdfValid(boolean isPdfValid) {
		this.isPdfValid = isPdfValid;
	}

}
