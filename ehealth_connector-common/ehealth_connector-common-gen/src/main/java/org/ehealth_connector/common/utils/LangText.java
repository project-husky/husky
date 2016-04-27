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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.common.utils;

import org.ehealth_connector.common.enums.LanguageCode;

/**
 * A simple combination of text and its language code (used for translations in
 * different languages)
 *
 */
public class LangText {

	private final LanguageCode langCode;
	private final String langText;

	/**
	 * Instantiates class
	 *
	 * @param lang
	 *            the language
	 * @param text
	 *            the text
	 */
	public LangText(LanguageCode lang, String text) {
		langCode = lang;
		langText = text;
	}

	/**
	 * Returns the language of the text
	 * 
	 * @return the langCode the language
	 */
	public LanguageCode getLangCode() {
		return langCode;
	}

	/**
	 * Returns the text
	 * 
	 * @return the langText the text
	 */
	public String getLangText() {
		return langText;
	}

}
