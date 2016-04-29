package org.ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

public class SchematronValidationResult {

	private List<ActivePatternResult> activePatternResultFull;
	private String exceptionMsg = null;

	private boolean schematronValid;

	public SchematronValidationResult() {
		activePatternResultFull = new ArrayList<ActivePatternResult>();
	}

	public List<ActivePatternResult> getActivePatternResultFull() {
		return activePatternResultFull;
	}

	public String getException() {
		return exceptionMsg;
	}

	public boolean isSchematronValid() {
		return schematronValid;
	}

	public void setActivePatternResultFull(List<ActivePatternResult> activePatternResult) {
		this.activePatternResultFull = activePatternResult;
	}

	public void setException(String message) {
		exceptionMsg = message;
		schematronValid = false;
	}

	public void setSchematronValid(boolean schematronValid) {
		this.schematronValid = schematronValid;
	}
}
