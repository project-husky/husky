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

package org.ehealth_connector.cda.ihe.pharm.enums;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;

/**
 * The Enum TimingEvent (OID 2.16.840.1.113883.5.139)
 */
public enum TimingEvent {

	/**
	 * <div class="en"> After breakfast</div><div class="fr">Après le
	 * petit-déjeuner</div>
	 */
	AFTER_BREAKFAST("PCM", "After breakfast", "Après le petit-déjeuner"),

	/**
	 * <div class="en"> After dinner</div><div class="fr">Après le repas du
	 * soir</div>
	 */
	AFTER_DINNER("PCV", "After dinner", "Après le repas du soir"),

	/**
	 * <div class="en"> After lunch</div><div class="fr">Après le repas de
	 * midi</div>
	 */
	AFTER_LUNCH("PCD", "After lunch", "Après le repas de midi"),

	/** <div class="en"> After meal</div><div class="fr">Après un repas</div> */
	AFTER_MEAL("PC", "After meal", "Après un repas"),

	/**
	 * <div class="en"> Before breakfast</div><div class="fr">Avant le
	 * petit-déjeuner</div>
	 */
	BEFORE_BREAKFAST("ACM", "Before breakfast", "Avant le petit-déjeuner"),

	/**
	 * <div class="en"> Before dinner</div><div class="fr">Avant le repas du
	 * soir</div>
	 */
	BEFORE_DINNER("ACV", "Before dinner", "Avant le repas du soir"),

	/**
	 * <div class="en"> Before lunch</div><div class="fr">Avant le repas de
	 * midi</div>
	 */
	BEFORE_LUNCH("ACD", "Before lunch", "Avant le repas de midi"),

	/** <div class="en"> Before meal</div><div class="fr">Avant un repas</div> */
	BEFORE_MEAL("AC", "Before meal", "Avant un repas"),

	/**
	 * <div class="en"> Before sleep</div><div class="fr">Avant d’aller dormir
	 * (hors sieste)</div>
	 */
	BEFORE_SLEEP("HS", "Before sleep", "Avant d’aller dormir (hors sieste)"),

	/**
	 * <div class="en"> Between breakfast and lunch</div><div class="fr">Entre le
	 * petit-déjeuner et le repas de midi</div>
	 */
	BETWEEN_BREAKFAST_AND_LUNCH("ICM", "Between breakfast and lunch", "Entre le petit-déjeuner et le repas de midi"),

	/**
	 * <div class="en"> Between dinner and sleep</div><div class="fr">Entre le
	 * repas du soir et l’heure du coucher</div>
	 */
	BETWEEN_DINNER_AND_SLEEP("ICV", "Between dinner and sleep", "Entre le repas du soir et l’heure du coucher"),

	/**
	 * <div class="en"> Between lunch and dinner</div><div class="fr">Entre le
	 * repas de midi et le repas du soir</div>
	 */
	BETWEEN_LUNCH_AND_DINNER("ICD", "Between lunch and dinner", "Entre le repas de midi et le repas du soir"),

	/**
	 * <div class="en"> Between meals</div><div class="fr">Entre les repas</div>
	 */
	BETWEEN_MEALS("IC", "Between meals", "Entre les repas"),

	/**
	 * <div class="en"> During breakfast</div><div class="fr">Pendant le
	 * petit-déjeuner</div>
	 */
	DURING_BREAKFAST("CM", "During breakfast", "Pendant le petit-déjeuner"),

	/**
	 * <div class="en"> During dinner</div><div class="fr">Pendant le repas du
	 * soir</div>
	 */
	DURING_DINNER("CV", "During dinner", "Pendant le repas du soir"),

	/**
	 * <div class="en"> During lunch</div><div class="fr">Pendant le repas de
	 * midi</div>
	 */
	DURING_LUNCH("CD", "During lunch", "Pendant le repas de midi"),

	/**
	 * <div class="en"> During meal</div><div class="fr">Pendant le repas</div>
	 */
	DURING_MEAL("C", "During meal", "Pendant le repas"),

	/** <div class="en"> Waking up</div><div class="fr">Au réveil</div> */
	WAKING_UP("WAKE", "Waking up", "Au réveil");

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "HL7 TimingEvent";

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.139";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *          the code
	 * @return the enum
	 */
	public static TimingEvent getEnum(String code) {
		for (final TimingEvent x : values()) {
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
	 * Instantiates a new TimingEvent.
	 *
	 * @param code
	 *          the code
	 * @param displayNameEn
	 *          the display name en
	 * @param displayNameFr
	 *          the display name fr
	 */
	private TimingEvent(String code, String displayNameEn, String displayNameFr) {
		this.code = code;
		this.displayNameEn = displayNameEn;
		this.displayNameFr = displayNameFr;
	}

	/**
	 * Gets the code.
	 *
	 * @param languageCode
	 *          the language code
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
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

}
