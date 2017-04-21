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
