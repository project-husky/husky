package ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

import ehealth_connector.validation.service.schematron.bind.ActivePattern;

public class SchematronValidationResult {

	private List<ActivePatternResult> activePatternResult;
	
	public SchematronValidationResult() {
		activePatternResult = new ArrayList<ActivePatternResult>(); 
	}

	public void addActivePattern(ActivePattern activePattern) {
		//activePatternResult.add(activePattern);
	}
	
	public List<ActivePatternResult> getActivePatternResult() {
		return activePatternResult;
	}

	public void setActivePatternResult(List<ActivePatternResult> activePatternResult) {
		this.activePatternResult = activePatternResult;
	}
}
