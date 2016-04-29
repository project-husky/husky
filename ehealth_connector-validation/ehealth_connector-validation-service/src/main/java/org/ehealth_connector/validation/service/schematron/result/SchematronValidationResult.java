package org.ehealth_connector.validation.service.schematron.result;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.validation.service.schematron.RuleSet;

public class SchematronValidationResult {

	private List<ActivePatternResult> activePatternResultFull;
	private String exceptionMsg = null;

	private boolean schematronValid;

	private RuleSet ruleSet = null;

	private File sourceFile = null;

	public SchematronValidationResult() {
		activePatternResultFull = new ArrayList<ActivePatternResult>();
	}

	public List<ActivePatternResult> getActivePatternResultFull() {
		return activePatternResultFull;
	}

	public String getException() {
		return exceptionMsg;
	}

	public RuleSet getRuleSet() {
		return ruleSet;
	}

	public File getSourceFile() {
		return sourceFile;
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

	public void setRuleSet(RuleSet ruleSet) {
		this.ruleSet = ruleSet;
	}

	public void setSchematronValid(boolean schematronValid) {
		this.schematronValid = schematronValid;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

}
