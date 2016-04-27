package org.ehealth_connector.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.enums.LanguageCode;

public class LangTexts {

	private final List<LangText> myLangTexts;

	public LangTexts() {
		myLangTexts = new ArrayList<LangText>();
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
