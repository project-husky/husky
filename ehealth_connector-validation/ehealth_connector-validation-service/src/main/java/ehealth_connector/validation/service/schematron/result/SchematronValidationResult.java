package ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ehealth_connector.validation.service.schematron.bind.ActivePattern;
import ehealth_connector.validation.service.schematron.bind.FiredRule;

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
