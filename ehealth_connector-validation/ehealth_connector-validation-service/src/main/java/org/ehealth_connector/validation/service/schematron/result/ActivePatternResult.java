/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

package org.ehealth_connector.validation.service.schematron.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.validation.service.schematron.bind.ActivePattern;
import org.ehealth_connector.validation.service.schematron.bind.FailedAssert;
import org.ehealth_connector.validation.service.schematron.bind.FiredRule;
import org.ehealth_connector.validation.service.schematron.bind.LangTextType;
import org.ehealth_connector.validation.service.schematron.bind.SuccessfulReport;

/**
 * Wrapper class for all actve-pattern elemnts, with coresponding fired-rule,
 * failed-assert and successful-report
 *
 */
public class ActivePatternResult {

	/**
	 * Returns the text in the desired language
	 *
	 * @param text
	 *            multiple language text as it comes from the schematron output
	 * @param lang
	 *            the desired language
	 * @return text in the desired language
	 */
	public static String getLangText(
			org.ehealth_connector.validation.service.schematron.bind.Text text, LanguageCode lang) {
		return getLangText(text, lang, null);
	}

	/**
	 * Returns the text in the desired languages
	 *
	 * @param text
	 *            multiple language text as it comes from the schematron output
	 * @param langPrio1
	 *            the desired language top priority
	 * @param langPrio2
	 *            alternatively desired language
	 * @return text in the desired language
	 */
	public static String getLangText(
			org.ehealth_connector.validation.service.schematron.bind.Text text,
			LanguageCode langPrio1, LanguageCode langPrio2) {

		String retVal = "";
		String langTextPrio1 = null;
		String langTextPrio2 = null;
		String noLangText = "";
		for (Serializable item : text.getContent()) {
			if (item instanceof JAXBElement) {
				@SuppressWarnings("unchecked")
				LangTextType langText = ((JAXBElement<LangTextType>) item).getValue();
				if (langPrio1 != null)
					if (langPrio1.getCodeValue().startsWith(langText.getLang()))
						langTextPrio1 = langText.getValue();
				if (langPrio2 != null)
					if (langPrio2.getCodeValue().startsWith(langText.getLang()))
						langTextPrio2 = langText.getValue();
			} else
				noLangText = item.toString();
		}

		if (langTextPrio1 != null) {
			retVal = langTextPrio1;
		} else if (langTextPrio2 != null) {
			retVal = langTextPrio2;
		} else {
			retVal = noLangText;
		}

		return retVal;
	}

	/** Active pattern */
	private ActivePattern ap;

	/** Active pattern childs */
	private List<Object> apChilds;

	/**
	 * Default constructor
	 */
	public ActivePatternResult() {
		apChilds = new ArrayList<Object>();
	}

	/**
	 * Gets the underlying ActivePattern
	 *
	 * @return the underlying ActivePattern
	 */
	public ActivePattern getAp() {
		return ap;
	}

	/**
	 * Gets a list with all active-pattern children
	 *
	 * @return a list with all active-pattern children
	 */
	public List<Object> getApChilds() {
		return apChilds;
	}

	/**
	 * Gets a List of all fired rules
	 *
	 * @return a List of all fired rules
	 */
	public List<FiredRule> getFiredRules() {
		final List<FiredRule> firedRules = new ArrayList<FiredRule>();
		final Iterator<Object> apcIter = apChilds.iterator();
		while (apcIter.hasNext()) {
			final Object tempObj = apcIter.next();
			if (tempObj instanceof FiredRule) {
				firedRules.add((FiredRule) tempObj);
			}
		}
		return firedRules;
	}

	/**
	 * Gets a list of fired-rules with failed-assert or successful-report
	 *
	 * @return a list of fired-rules with failed-assert or successful-report
	 */
	public List<FiredRuleResult> getFiredRulesSuccessFailed() {
		final List<FiredRuleResult> firedRulesresults = new ArrayList<FiredRuleResult>();
		final Iterator<Object> apcIter = apChilds.iterator();
		FiredRuleResult tempFR = null;
		Object prevObject = null;
		Object tempObj = null;
		while (apcIter.hasNext()) {
			tempObj = apcIter.next();
			if ((tempObj instanceof FiredRule)
					&& ((prevObject == null) || (prevObject instanceof FiredRule))) {
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
			if ((tempObj instanceof FiredRule) && !(prevObject instanceof FiredRule)) {
				if (!(tempFR.getFailedAssert().isEmpty() && tempFR.getSuccessfulReport().isEmpty()))
					firedRulesresults.add(tempFR);
				tempFR = new FiredRuleResult((FiredRule) tempObj);
				prevObject = tempFR;
			}
		}
		if ((tempObj instanceof FailedAssert) || (tempObj instanceof SuccessfulReport)) {
			firedRulesresults.add(tempFR);
		}
		return firedRulesresults;
	}

	/**
	 * Gets the id of the ActivePattern
	 *
	 * @return the id of the ActivePattern
	 */
	public String getId() {
		return ap.getId();
	}

	/**
	 * Gets the name of the active pattern
	 *
	 * @return the name of the active pattern
	 */
	public String getName() {
		return ap.getName();
	}

	/**
	 * Sets the active pattern
	 *
	 * @param ap
	 *            the desired active pattern
	 */
	public void setAp(ActivePattern ap) {
		this.ap = ap;
	}

	/**
	 * Sets the children of the active pattern
	 *
	 * @param apChilds
	 *            the children of the active pattern
	 */
	public void setApChilds(List<Object> apChilds) {
		this.apChilds = apChilds;
	}

	/**
	 * Sets the id of the ActivePattern
	 *
	 * @param id
	 *            the id of the ActivePattern
	 */
	public void setId(String id) {
		ap.setId(id);
	}

	/**
	 * Sets the name of the ActivePattern
	 *
	 * @param name
	 *            the desired name of the ActivePattern
	 */
	public void setName(String name) {
		ap.setName(name);
	}
}
