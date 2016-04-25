package org.ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

public class SchematronValidationResult {

	private List<ActivePatternResult> activePatternResultFull;

	private boolean schematronValid;

	public SchematronValidationResult() {
		activePatternResultFull = new ArrayList<ActivePatternResult>();
	}

	public boolean isSchematronValid() {
		return schematronValid;
	}

	public void setSchematronValid(boolean schematronValid) {
		this.schematronValid = schematronValid;
	}

	public List<ActivePatternResult> getActivePatternResultFull() {
		return activePatternResultFull;
	}

	public void setActivePatternResultFull(List<ActivePatternResult> activePatternResult) {
		this.activePatternResultFull = activePatternResult;
	}
}
