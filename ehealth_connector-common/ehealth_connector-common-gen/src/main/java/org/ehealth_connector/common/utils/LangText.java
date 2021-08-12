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

package org.ehealth_connector.common.utils;

import java.io.Serializable;

import org.ehealth_connector.common.enums.LanguageCode;

/**
 * A simple combination of text and its language code (used for translations in
 * different languages)
 *
 */
public class LangText implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2813370207249945398L;
	private LanguageCode langCode;
	private String langText;

	/**
	 * Instantiates a new lang text. Default constructor.
	 */
	public LangText() {

	}

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
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the ValueSetPackage to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean retVal = true;
		if (obj == null)
			return false;
		if (!(obj instanceof LangText))
			return false;

		if (retVal) {
			if (this.langCode == null)
				retVal = (((LangText) obj).getLangCode() == null);
			else
				retVal = this.langCode.equals(((LangText) obj).getLangCode());
		}
		if (retVal) {
			if (this.langText == null)
				retVal = (((LangText) obj).getLangText() == null);
			else
				retVal = this.langText.equals(((LangText) obj).getLangText());
		}
		return retVal;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Util.getChecksum(this);
	}

	public void setLangCode(LanguageCode langCode) {
		this.langCode = langCode;
	}

	public void setLangText(String langText) {
		this.langText = langText;
	}
}
