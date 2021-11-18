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
package org.husky.valueset.enums;

/**
 * <div class="en">The Class DesignationType. Designations are language
 * dependent display names for the code. For any language there might be
 * multiple, each specifying the type (fully specified name, preferred, synonym,
 * ...). See also:
 * https://art-decor.org/mediawiki/index.php?title=DECOR-terminology</div>
 *
 * <div class="de">Die Klasse DesignationType enthält Bezeichnungen in Form von
 * sprachabhängigen Anzeigenamen für den Code. Für jede Sprache kann es mehrere
 * geben, die jeweils den Typ angeben (vollständiger Name, bevorzugter Name,
 * Synonym, ...). Siehe auch:
 * https://art-decor.org/mediawiki/index.php?title=DECOR-terminology</div>
 *
 */
public enum DesignationType {

	/** Preferred designation as specified by Art-DECOR. */
	PREFERRED,

	/** Synonym designation as specified by Art-DECOR. */
	SYNONYM,

	/** abbreviation designation as specified by Art-DECOR. */
	ABBREVIATION,

	/** The fully specified name designation as specified by Art-DECOR. */
	FULLY_SPECIFIED_NAME;

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static DesignationType getEnum(String code) {
		DesignationType retVal = null;
		if ("abbreviation".equals(code))
			retVal = ABBREVIATION;
		if ("preferred".equals(code))
			retVal = PREFERRED;
		if ("synonym".equals(code))
			retVal = SYNONYM;
		if ("fsn".equals(code))
			retVal = FULLY_SPECIFIED_NAME;
		return retVal;
	}

}
