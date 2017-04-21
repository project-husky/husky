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
 * The RouteOfAdministration. MTPS 7.6.4
 */
public enum RouteOfAdministration {

	/**
	 * <div class="en"> topical application, buccal</div><div class="fr">dans la
	 * bouche</div>
	 */
	BUCCAL("BUC", "topical application, buccal", "dans la bouche"),

	/**
	 * <div class="en"> chew, oral</div><div class="fr">à mâcher ou à
	 * sucer</div>
	 */
	CHEW_ORAL("CHEW", "chew, oral", "à mâcher ou à sucer"),

	/**
	 * <div class="en"> instillation, gastrostomy tube</div><div class="fr">par
	 * sonde gastrostomie</div>
	 */
	GASTROTOMY_TUBE("GT", "instillation, gastrostomy tube", "par sonde gastrostomie"),

	/**
	 * <div class="en"> injection, intra-abdominal</div><div class="fr">intra
	 * articulaire</div>
	 */
	INJECTION_INTRA_ABDOMINAL("IARTINJ", "injection, intra-abdominal", "intra articulaire"),

	/**
	 * <div class="en"> injection, intradermal</div><div class="fr">par voie
	 * intradermique</div>
	 */
	INJECTION_INTRADERMAL("IDINJ", "injection, intradermal", "par voie intradermique"),

	/**
	 * <div class="en"> injection, intraepidermal</div>
	 * <div class="fr">épidermique</div>
	 */
	INJECTION_INTRAEPIDERMAL("IEPIDINJ", "injection, intraepidermal", "épidermique"),

	/**
	 * <div class="en"> injection, intramuscular</div><div class="fr">par voie
	 * intramusculaire</div>
	 */
	INJECTION_INTRAMUSCULAR("IM", "injection, intramuscular", "par voie intramusculaire"),

	/**
	 * <div class="en"> infusion, intravenous</div><div class="fr">par voie
	 * intraveineuse</div>
	 */
	INTRANEOUS("IV", "infusion, intravenous", "par voie intraveineuse"),

	/**
	 * <div class="en"> topical application, nail</div><div class="fr">sur
	 * l'ongle</div>
	 */
	NAIL("NAIL", "topical application, nail", "sur l'ongle"),

	/**
	 * <div class="en"> instillation, nasal</div><div class="fr">par
	 * inhalation</div>
	 */
	NASAL_INSTILLATION("NASALINSTIL", "instillation, nasal", "par inhalation"),

	/**
	 * <div class="en"> instillation, nasogastric</div><div class="fr">par sonde
	 * naso gastrique</div>
	 */
	NASOGASTRIC_INSTILLATION("NASOGASINSTIL", "instillation, nasogastric", "par sonde naso gastrique"),

	/**
	 * <div class="en"> topical application, ophthalmic</div>
	 * <div class="fr">dans l'oeil</div>
	 */
	OPHTALMIC_APPLICATION("OPTHALTA", "topical application, ophthalmic", "dans l'oeil"),

	/**
	 * <div class="en"> instillation, otic</div><div class="fr">dans
	 * l'oreille</div>
	 */
	OTIC_INSTILLATION("OT", "instillation, otic", "dans l'oreille"),

	/**
	 * <div class="en"> injection, paranasal sinuses</div><div class="fr">par
	 * voie nasale</div>
	 */
	PARANASAL_INJECTION("PNSINJ", "injection, paranasal sinuses", "par voie nasale"),

	/**
	 * <div class="en"> swallow, oral</div><div class="fr">par la bouche</div>
	 */
	PER_OS("PO", "swallow, oral", "par la bouche"),

	/**
	 * <div class="en"> insertion, rectal</div><div class="fr">par voie
	 * rectale</div>
	 */
	RECTAL("PR", "insertion, rectal", "par voie rectale"),

	/**
	 * <div class="en"> topical application, skin</div><div class="fr">en
	 * application cutanée</div>
	 */
	SKIN("SKIN", "topical application, skin", "en application cutanée"),

	/**
	 * <div class="en"> dissolve, sublingual</div><div class="fr">sous la
	 * langue</div>
	 */
	SUBLINGUAL("SL", "dissolve, sublingual", "sous la langue"),

	/**
	 * <div class="en"> injection, subcutaneous</div><div class="fr">par voie
	 * sous cutané</div>
	 */
	SUBCUTANEOUS("SQ", "injection, subcutaneous", "par voie sous cutané"),

	/** <div class="en"> suck, oromucosal</div><div class="fr">à sucer</div> */
	SUCK("SUCK", "suck, oromucosal", "à sucer"),

	/**
	 * <div class="en"> topical application, vaginal</div><div class="fr">par
	 * voie transdermique</div>
	 */
	TRANSDEMIC("TRNSDERM", "topical application, vaginal", "par voie transdermique"),

	/**
	 * <div class="en"> insertion, vaginal</div><div class="fr">par voie
	 * vaginale</div>
	 */
	VAGINS("VAGINS", "insertion, vaginal", "par voie vaginale");

	public static final String CODE_SYSTEM_NAME = "RouteOfAdministration";
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.112";

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static RouteOfAdministration getEnum(String code) {
		for (final RouteOfAdministration x : values()) {
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
	private RouteOfAdministration(String code, String displayNameEn, String displayNameFr) {
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
}
