/*
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
