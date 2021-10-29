/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.husky.validation.service.schematron.result;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.husky.validation.service.schematron.RuleSet;

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
