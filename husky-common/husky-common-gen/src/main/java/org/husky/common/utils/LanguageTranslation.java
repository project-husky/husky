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
package org.husky.common.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import org.husky.common.enums.LanguageCode;

public class LanguageTranslation {

	LanguageCode mLang;
	ResourceBundle mResourceBundle;

	public LanguageTranslation(LanguageCode lang) {
		mLang = lang;
		mResourceBundle = ResourceBundle.getBundle("MyResources", new Locale(mLang.getCodeValue()));
	}

}