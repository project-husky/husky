/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.at.enums;

import org.apache.commons.lang3.NotImplementedException;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.common.hl7cdar2.CE;

/**
 * Interface for all dynamically created/updated value sets.
 */
public interface ValueSetEnumInterfaceAt extends ValueSetEnumInterface {

	/**
	 * Gets the display name.
	 * 
	 * @return the display name
	 */
	@Override
	default String getDisplayName() {
		return getDisplayNameAt(null);
	}

	@Override
	public default String getDisplayName(
			org.husky.common.enums.LanguageCode languageCode) {
		throw new NotImplementedException("Not implemented for the Austrian enums");
	}

	/**
	 * Gets the display name defined by the language parameter. If the language is
	 * unknown, german name is returned
	 *
	 * @param languageCode the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	String getDisplayNameAt(LanguageCode languageCode);
	
	public default CE getHl7cdar2CE() {
		CE ce = new CE();
		ce.setCode(getCodeValue());
		ce.setCodeSystem(getCode().getCodeSystem());
		ce.setDisplayName(getDisplayName());
		ce.setCodeSystemName(getCodeSystemName());
		return ce;
	}

}
