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

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.projecthusky.common.enums.LanguageCode;

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
	private String text;

	/**
	 * Instantiates a new lang text. Default constructor.
	 */
	public LangText() {

	}

	/**
	 * Instantiates class
	 *
	 * @param lang the language
	 * @param text the text
	 */
	public LangText(LanguageCode lang, String text) {
		langCode = lang;
		this.text = text;
	}

	/**
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf ihrem
	 * Inhalt).</div>
	 *
	 * @param obj the ValueSetPackage to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;
		if (!(obj instanceof LangText))
			return false;

		if (this.langCode == null)
			retVal = (((LangText) obj).getLangCode() == null);
		else
			retVal = this.langCode.equals(((LangText) obj).getLangCode());

		if (retVal) {
			if (this.text == null)
				retVal = (((LangText) obj).getLangText() == null);
			else
				retVal = this.text.equals(((LangText) obj).getLangText());
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
		return text;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.text)
				.append(this.langCode != null ? this.langCode.hashCode() : null).toHashCode();
	}

	public void setLangCode(LanguageCode langCode) {
		this.langCode = langCode;
	}

	public void setLangText(String langText) {
		this.text = langText;
	}
}
