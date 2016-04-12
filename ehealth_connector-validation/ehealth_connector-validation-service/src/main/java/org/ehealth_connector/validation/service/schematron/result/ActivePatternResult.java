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

package org.ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ehealth_connector.validation.service.schematron.bind.ActivePattern;
import org.ehealth_connector.validation.service.schematron.bind.FailedAssert;
import org.ehealth_connector.validation.service.schematron.bind.FiredRule;
import org.ehealth_connector.validation.service.schematron.bind.SuccessfulReport;

/**
 * Wrapper class for all actve-pattern elemnts, with coresponding
 * fired-rule, failed-assert and successful-report
 *
 */
public class ActivePatternResult {

	private ActivePattern ap;
	private List<Object> apChilds;

	public ActivePatternResult() {
		apChilds = new ArrayList<Object>();
	}

	/**
	 * @return a List of all fired rules
	 */
	public List<FiredRule> getFiredRules() {
		ArrayList<FiredRule> firedRules = new ArrayList<FiredRule>();
		Iterator<Object> apcIter = apChilds.iterator();
		while (apcIter.hasNext()) {
			Object tempObj = apcIter.next();
			if (tempObj instanceof FiredRule) {
				firedRules.add((FiredRule) tempObj);
			}
		}
		return firedRules;
	}

	/**
	 * @return a list of fired-rules with failed-assert or successful-report
	 */
	public List<FiredRuleResult> getFiredRulesSuccessFailed() {
		List<FiredRuleResult> firedRulesresults = new ArrayList<FiredRuleResult>();
		Iterator<Object> apcIter = apChilds.iterator();
		FiredRuleResult tempFR = null;
		Object prevObject = null;
		Object tempObj = null;
		while (apcIter.hasNext()) {
			tempObj = apcIter.next();
			if (tempObj instanceof FiredRule && (prevObject == null || prevObject instanceof FiredRule)) {
				tempFR = new FiredRuleResult((FiredRule) tempObj);
				prevObject = tempFR;
				continue;
			} else {
				if (tempObj instanceof FailedAssert) {
					tempFR.getFailedAssert().add((FailedAssert) tempObj);
					prevObject = tempObj;
					continue;
				}
				if (tempObj instanceof SuccessfulReport) {
					tempFR.getSuccessfulReport().add((SuccessfulReport) tempObj);
					prevObject = tempObj;
					continue;
				}
			}
			if (tempObj instanceof FiredRule && !(prevObject instanceof FiredRule)) {
				if (!(tempFR.getFailedAssert().isEmpty() && tempFR.getSuccessfulReport().isEmpty()))
						firedRulesresults.add(tempFR);
				tempFR = new FiredRuleResult((FiredRule) tempObj);
				prevObject = tempFR;
			}
		}
		if (tempObj instanceof SuccessfulReport || tempObj instanceof SuccessfulReport) {
			firedRulesresults.add(tempFR);
		}
		return firedRulesresults;
	}

	/**
	 * @return a list with all active-pattern childs
	 */
	public List<Object> getApChilds() {
		return apChilds;
	}

	public void setApChilds(List<Object> apChilds) {
		this.apChilds = apChilds;
	}

	/**
	 * @return the underlying ActivePattern
	 */
	public ActivePattern getAp() {
		return ap;
	}

	public void setAp(ActivePattern ap) {
		this.ap = ap;
	}

	/**
	 * @return the id of the ActivePattern
	 */
	public String getId() {
		return ap.getId();
	}

	/**
	 * @return the name of the ActivePattern
	 */
	public void setId(String id) {
		ap.setId(id);
	}

	public String getName() {
		return ap.getName();
	}

	public void setName(String name) {
		ap.setName(name);
	}

}
