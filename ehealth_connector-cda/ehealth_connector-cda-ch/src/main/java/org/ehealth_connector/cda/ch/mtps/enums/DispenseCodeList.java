package org.ehealth_connector.cda.ch.mtps.enums;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;

/**
 * The DispenseCodeList. MTPS 7.6.6
 */
public enum DispenseCodeList {

	/** <div class="en"> First fill – Complete</div><div class="fr">Première dispensation - complète</div> */
	FIRST_FILL_COMPLETE("FFC", "First fill – Complete", "Première dispensation - complète"),

	/** <div class="en"> First fill – Part fill</div><div class="fr">Première dispensation partielle</div> */
	FIRST_FILL_PART_FILL("FFP", "First fill – Part fill", "Première dispensation partielle"),

	/** <div class="en"> Refill – Part fill</div><div class="fr">Dispensation suivante – partielle</div> */
	REFILL_PART_FILL("RFP", "Refill – Part fill", "Dispensation suivante – partielle"),

	/** <div class="en"> Refill – Complete</div><div class="fr">Dispensation suivante - complète</div> */
	REFILL_COMPLETE("RFC", "Refill – Complete", "Dispensation suivante - complète");

	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.4";
	public static final String CODE_SYSTEM_NAME = "DispenseCodeList";

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
	private DispenseCodeList(String code, String displayNameEn, String displayNameFr) {
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
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static DispenseCodeList getEnum(String code) {
		for (final DispenseCodeList x : values()) {
			if (x.code.equals(code)) {
				return x;
			}
		}
		return null;
	}
}
