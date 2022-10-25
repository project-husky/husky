/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.projecthusky.common.enums.LanguageCode;

public class LangTexts {

	private final List<LangText> myLangTexts;

	public LangTexts() {
		myLangTexts = new ArrayList<>();
	}

	public void add(LangText langText) {
		myLangTexts.add(langText);
	}

	public String getText(LanguageCode langCode) {
		String retVal = "";
		for (LangText langText : myLangTexts) {
			if (langText.getLangCode().getCode().equals(langCode.getCode()))
				retVal = langText.getLangText();
		}
		return retVal;
	}

}
