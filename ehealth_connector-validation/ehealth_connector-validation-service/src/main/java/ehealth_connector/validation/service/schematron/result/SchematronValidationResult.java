package ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ehealth_connector.validation.service.schematron.bind.ActivePattern;
import ehealth_connector.validation.service.schematron.bind.FiredRule;

public class SchematronValidationResult {

	private List<ActivePatternResult> activePatternResultFull;
	
	private List<ActivePatternResult> activePatternSuccOrFail;
	
	public SchematronValidationResult() {
		activePatternResultFull = new ArrayList<ActivePatternResult>(); 
	}

	
	
	/*
	public void getApSuccessOrFailed () {
		activePatternSuccOrFail = new ArrayList<ActivePatternResult>();
		Iterator<ActivePatternResult> aprIter = activePatternResultFull.iterator();
		while (aprIter.hasNext()) {
			ActivePatternResult tempAPRes = aprIter.next();
			List<FiredRuleResult> firedRulesresults = tempAPRes.getFiredRulesSuccessFailed();
			Iterator<FiredRuleResult> frrIter = firedRulesresults.iterator();
			while (frrIter.hasNext()) {
				System.out.println("Active Pattern: " + tempAPRes.getId());
				FiredRuleResult tempFrr = frrIter.next();
				System.out.println("FiredRule :" + tempFrr.getContext());
				System.out.println("FailedAsser count: "+ tempFrr.getFailedAssert().size());
				System.out.println("SuccessfulReport count: "+ tempFrr.getSuccessfulReport().size());
			}
		}
			
	}*/
	
	
	public List<ActivePatternResult> getActivePatternResultFull() {
		return activePatternResultFull;
	}

	public void setActivePatternResultFull(List<ActivePatternResult> activePatternResult) {
		this.activePatternResultFull = activePatternResult;
	}
}
