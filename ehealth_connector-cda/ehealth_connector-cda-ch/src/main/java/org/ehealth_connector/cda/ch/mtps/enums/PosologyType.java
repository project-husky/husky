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

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 * The various types of posologies. See MTPS 7.5.10 and CDA Time intervals. 
 */
public enum PosologyType {

	/**
	 * <div class="en">EveryXHours</div><div class="fr">Toutes les x
	 * heures</div>
	 */
	EVERY_X_HOURS("EveryXHours", "Every X hours", "Toutes les x heures"),

	/**
	 * <div class="en">InstantOfTime</div><div class="fr">à un certain
	 * moment</div>
	 */
	INSTANT_OF_TIME("InstantOfTime", "A a certain time", "A une certaine heure"),

	/**
	 * <div class="en">NTimesADay</div><div class="fr">n fois par jour
	 * sucer</div>
	 */
	N_TIMES_A_DAY("NTimesADay", "N times a day", "N fois par jour"),

	/**
	 * <div class="en">NTimesADay</div><div class="fr">n fois par semaine
	 * sucer</div>
	 */
	N_TIMES_A_WEEK("NTimesAWeek", "N times a week", "N fois par semaine"),

	/**
	 * <div class="en">NTimesAMonth</div><div class="fr">n fois par mois</div>
	 */
	N_TIMES_A_MONTH("NTimesAMonth", "N times a month", "N fois par mois"),

	/**
	 * <div class="en">TimingEvent</div><div class="fr">selon un horaire</div>
	 */
	TIMING_EVENT("TimingEvent", "Timing event", "Selon un horaire");

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static PosologyType getEnum(String code) {
		for (final PosologyType x : values()) {
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
	private PosologyType(String code, String displayNameEn, String displayNameFr) {
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
