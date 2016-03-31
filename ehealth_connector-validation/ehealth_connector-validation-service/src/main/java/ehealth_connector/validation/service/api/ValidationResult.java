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

package ehealth_connector.validation.service.api;

import java.util.ArrayList;
import java.util.Iterator;

import ehealth_connector.validation.service.pdf.PdfValidationResult;
import ehealth_connector.validation.service.schematron.result.SchematronValidationResult;

/**
 * @author ich
 *
 */
public class ValidationResult {
	
	private boolean xsdValid;
	
	XsdValidationResult xsdValRes; 
	
	private boolean schematronValid;
	
	SchematronValidationResult schValRes;
	
	private boolean pdfValid;
	
	ArrayList<PdfValidationResult> pdfValRes;

	public ValidationResult() {
		this.xsdValRes = new XsdValidationResult();
		this.schValRes = new SchematronValidationResult();
	}
	
	public boolean isXsdValid() {
		return xsdValid;
	}

	public void setXsdValid(boolean xsdValid) {
		this.xsdValid = xsdValid;
	}

	public XsdValidationResult getXsdValRes() {
		return xsdValRes;
	}

	public void setXsdValRes(XsdValidationResult xsdValRes) {
		this.xsdValRes = xsdValRes;
	}

	public boolean isSchematronValid() {
		return schematronValid;
	}

	public void setSchematronValid(boolean schematronValid) {
		this.schematronValid = schematronValid;
	}

	public SchematronValidationResult getSchValRes() {
		return schValRes;
	}

	public void setSchValRes(SchematronValidationResult schValRes) {
		this.schValRes = schValRes;
	}

	public boolean isPdfValid() {
		boolean hasError = false;
		Iterator<PdfValidationResult> iter = pdfValRes.iterator();
		boolean hasErrors = false;
		PdfValidationResult temp;
		while (iter.hasNext()) {
			temp = iter.next();
			hasErrors = hasErrors || temp.hasError();
		}
		return !hasError;
	}

	public ArrayList<PdfValidationResult> getPdfValRes() {
		return pdfValRes;
	}

	public void setPdfValRes(ArrayList<PdfValidationResult> pdfValRes) {
		this.pdfValRes = pdfValRes;
	}

	
}
