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

package org.ehealth_connector.validation.service.api;

import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.pdf.VeraPdfValidationResult;
import org.ehealth_connector.validation.service.schematron.result.SchematronValidationResult;

/**
 * Contains all validation results
 */
public class ValidationResult {

	/** The Schema validation results */
	private XsdValidationResult xsdValRes = null;

	/** The Schematron validation results */
	private SchematronValidationResult schValRes = null;

	/** The PDF validation results */
	private PdfValidationResult pdfValRes = null;
	
	/** The veraPDF validation results */
	private VeraPdfValidationResult veraPdfValRes = null;

	/**
	 * Default constructor
	 */
	public ValidationResult() {
	}

	/**
	 * Gets the PDF validation results
	 *
	 * @return the PDF validation results
	 */
	public PdfValidationResult getPdfValidationResult() {
		return pdfValRes;
	}

	/**
	 * Gets the veraPDF validation results
	 *
	 * @return the PDF validation results
	 */
	public VeraPdfValidationResult getVeraPdfValRes() {
		return veraPdfValRes;
	}
	
	/**
	 * Gets the Schematron validation results
	 *
	 * @return the Schematron validation results
	 */
	public SchematronValidationResult getSchValidationResult() {
		return schValRes;
	}

	/**
	 * Gets the Schema validation results
	 *
	 * @return the Schema validation results
	 */
	public XsdValidationResult getXsdValidationResult() {
		return xsdValRes;
	}

	/**
	 * Indicates whether the embedded PDFs are valid
	 *
	 * @return true when the embedded PDFs are valid, false otherwise
	 */
	public boolean isPdfValid() {
		if (pdfValRes != null)
			return pdfValRes.isPdfValid();
		else 
			return veraPdfValRes.isPdfValid();
	}

	/**
	 * Indicates whether the PDF validation was performed
	 *
	 * @return true when the PDF validation was performed, false otherwise
	 */
	public boolean isPdfValidationPerformed() {
		if (pdfValRes != null)
			return pdfValRes.isDone();
		else 
			return veraPdfValRes.isDone();
	}

	/**
	 * Indicates whether the CDA contains Schematron failures
	 *
	 * @return true when CDA does not contain any Schematron failures, false
	 *         otherwise
	 */
	public boolean isSchValid() {
		if (schValRes != null)
			return schValRes.isSchematronValid();
		else
			return false;
	}

	/**
	 * Indicates whether the Schematron validation was performed
	 *
	 * @return true when the Schematron validation was performed, false
	 *         otherwise
	 */
	public boolean isSchValidationPerformed() {
		return (schValRes != null);
	}

	/**
	 * Indicates whether the CDA contains Schema failures
	 *
	 * @return true when CDA does not contain any Schema failures, false
	 *         otherwise
	 */
	public boolean isXsdValid() {
		if (xsdValRes != null)
			return xsdValRes.isXsdValid();
		else
			return false;
	}

	/**
	 * Indicates whether the Schema validation was performed
	 *
	 * @return true when the Schema validation was performed, false otherwise
	 */
	public boolean isXsdValidationPerformed() {
		return (xsdValRes != null);
	}

	/**
	 * Sets the given PDF validation results
	 *
	 * @param pdfValRes
	 *            the desired PDF validation results
	 */
	public void setPdfValidationResult(PdfValidationResult pdfValRes) {
		this.pdfValRes = pdfValRes;
	}

	/**
	 * Sets the given veraPDF validation results
	 *
	 * @param pdfValRes
	 *            the desired PDF validation results
	 */
	public void setVeraPdfValRes(VeraPdfValidationResult veraPdfValRes) {
		this.veraPdfValRes = veraPdfValRes;
	}


	/**
	 * Sets the Schematron validation success indicator
	 *
	 * @param schematronValid
	 *            the Schematron validation success indicator
	 */
	public void setSchValid(boolean schematronValid) {
		this.getSchValidationResult().setSchematronValid(schematronValid);
	}

	/**
	 * Sets the given Schematron validation results
	 *
	 * @param schValRes
	 *            the desired Schematron validation results
	 */
	public void setSchValidationResult(SchematronValidationResult schValRes) {
		this.schValRes = schValRes;
	}

	/**
	 * Sets the given Schema validation results
	 *
	 * @param xsdValRes
	 *            the desired Schema validation results
	 */
	public void setXsdValidationResult(XsdValidationResult xsdValRes) {
		this.xsdValRes = xsdValRes;
	}
}
