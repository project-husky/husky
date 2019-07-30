/*
 *
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

package org.ehealth_connector.cda.ch.mtps.enums;

import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;

/**
 * The possible frequencies types. See MTPS 7.5.10 and CDA Time intervals.
 */
public enum FrequencyType {

	/**
	 * <div class="en">EveryXDay</div><div class="fr">Tous les X jours</div>
	 */
	EVERY_X_DAY("EveryXDay", "Every X days", "Tous les X jours"),

	/**
	 * <div class="en">EveryXWeeks</div><div class="fr">Toutes les X
	 * semaines</div>
	 */
	EVERY_X_WEEKS("EveryXWeeks", "Every X weeks", "Toutes les X semaines"),

	/**
	 * <div class="en">EveryXMonths</div><div class="fr">Tous les X mois</div>
	 */
	EVERY_X_MONTHS("EveryXMonths", "Every X months", "Tous les X mois"),

	/**
	 * <div class="en">XTimesAWeek</div><div class="fr">X fois par semaine</div>
	 */
	X_TIMES_A_WEEK("XTimesAWeek", "X times a week", "X fois par semaine"),

	/**
	 * <div class="en">XTimesAMonth</div><div class="fr">X fois par mois</div>
	 */
	X_TIMES_A_MONTH("XTimesAMonth", "X times a month", "X fois par mois");

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static FrequencyType getEnum(String code) {
		for (final FrequencyType x : values()) {
			if (x.code.equals(code)) {
				return x;
			}
		}
		return null;
	}

	/** The code. */
	private String code;

	/** The display name. */
	private String displayNameEn;

	/** The display name. */
	private String displayNameFr;

	/**
	 * Instantiates a new route of administration.
	 *
	 * @param code
	 *            the code
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameFr
	 *            the display name fr
	 */
	private FrequencyType(String code, String displayNameEn, String displayNameFr) {
		this.code = code;
		this.displayNameEn = displayNameEn;
		this.displayNameFr = displayNameFr;
	}

	/**
	 * Gets the code.
	 *
	 * @param languageCode
	 *            the language code
	 * @return the code
	 */
	public Code getCode(LanguageCode languageCode) {
		String displayName = null;
		if (languageCode != null) {
			switch (languageCode) {
			case FRENCH:
				displayName = displayNameFr;
				break;
			default:
				displayName = displayNameEn;
				break;

			}
		}
		final Code ehcCode = new Code(null, code, displayName);
		return ehcCode;
	}
}
