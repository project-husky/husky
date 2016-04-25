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

package org.ehealth_connector.validation.service.api;

import java.util.Iterator;
import java.util.List;

import org.ehealth_connector.validation.service.pdf.PdfValidationResult;
import org.ehealth_connector.validation.service.schematron.result.SchematronValidationResult;

/**
 * @author ich
 *
 */
public class ValidationResult {

	private boolean xsdValid;

	private XsdValidationResult xsdValRes;

	private boolean schematronValid;

	private SchematronValidationResult schValRes;

	private boolean pdfValid;

	private List<PdfValidationResult> pdfValRes;

	public ValidationResult() {
		this.xsdValRes = new XsdValidationResult();
		this.schValRes = new SchematronValidationResult();
	}

	public List<PdfValidationResult> getPdfValRes() {
		return pdfValRes;
	}

	public SchematronValidationResult getSchValRes() {
		return schValRes;
	}

	public XsdValidationResult getXsdValRes() {
		return xsdValRes;
	}

	public boolean isPdfValid() {
		final boolean hasError = false;
		final Iterator<PdfValidationResult> iter = pdfValRes.iterator();
		boolean hasErrors = false;
		PdfValidationResult temp;
		while (iter.hasNext()) {
			temp = iter.next();
			hasErrors = hasErrors || temp.hasError();
		}
		return !hasError;
	}

	public boolean isSchematronValid() {
		return schValRes.isSchematronValid();
	}

	public boolean isXsdValid() {
		return xsdValid;
	}

	public void setPdfValRes(List<PdfValidationResult> pdfValRes) {
		this.pdfValRes = pdfValRes;
	}

	public void setSchematronValid(boolean schematronValid) {
		this.getSchValRes().setSchematronValid(schematronValid);
	}

	public void setSchValRes(SchematronValidationResult schValRes) {
		this.schValRes = schValRes;
	}

	public void setXsdValid(boolean xsdValid) {
		this.xsdValid = xsdValid;
	}

	public void setXsdValRes(XsdValidationResult xsdValRes) {
		this.xsdValRes = xsdValRes;
	}

}
