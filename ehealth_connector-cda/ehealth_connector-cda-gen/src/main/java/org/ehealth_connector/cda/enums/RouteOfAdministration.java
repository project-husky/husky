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

package org.ehealth_connector.cda.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * The RouteOfAdministration.
 */
public enum RouteOfAdministration {

	/**
	 * <div class="en"> chew, oral</div><div class="fr">à mâcher ou à
	 * sucer</div>
	 */
	CHEW_ORAL("CHEW", "chew, oral", "à mâcher ou à sucer"),

	/**
	 * <div class="de">Diffusion, transdermal</div> <div class="fr">Diffusion
	 * transdermique</div>
	 */
	DIFFUSION_TRANSDERMAL("TRNSDERMD", "Diffusion, transdermal", "Diffusion, transdermal"),

	/**
	 * <div class="en"> dissolve, sublingual</div><div class="fr">sous la
	 * langue</div>
	 */
	DISSOLVE_SUBLINGUAL("SL", "dissolve, sublingual", "sous la langue"),

	/**
	 * <div class="en"> infusion, intravenous</div><div class="fr">par voie
	 * intraveineuse</div>
	 */
	INFUSION_INTRANEOUS("IV", "infusion, intravenous", "par voie intraveineuse"),

	/**
	 * <div class="de">Inhalation, Vernebelung, nasal</div>
	 * <div class="fr">Inhalation par nébulisation nasale</div>
	 */
	INHALATION_NEBULIZATION_NASAL("NASNEB", "Inhalation, nebulization, nasal",
			"Inhalation, nébulisation, nasal"),

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
	 * <div class="en"> injection, paranasal sinuses</div><div class="fr">par
	 * voie nasale</div>
	 */
	INJECTION_PARANASAL("PNSINJ", "injection, paranasal sinuses", "par voie nasale"),

	/**
	 * <div class="en"> injection, subcutaneous</div><div class="fr">par voie
	 * sous cutané</div>
	 */
	INJECTION_SUBCUTANEOUS("SQ", "injection, subcutaneous", "par voie sous cutané"),

	/**
	 * <div class="en"> insertion, rectal</div><div class="fr">par voie
	 * rectale</div>
	 */
	INSERTION_RECTAL("PR", "insertion, rectal", "par voie rectale"),

	/**
	 * <div class="en"> insertion, vaginal</div><div class="fr">par voie
	 * vaginale</div>
	 */
	INSERTION_VAGINAL("VAGINS", "insertion, vaginal", "par voie vaginale"),

	/**
	 * <div class="en"> instillation, gastrostomy tube</div><div class="fr">par
	 * sonde gastrostomie</div>
	 */
	INSTILLATION_GASTROTOMY_TUBE("GT", "instillation, gastrostomy tube", "par sonde gastrostomie"),

	/**
	 * <div class="en"> instillation, nasal</div><div class="fr">par
	 * inhalation</div>
	 */
	INSTILLATION_NASAL("NASALINSTIL", "instillation, nasal", "par inhalation"),

	/**
	 * <div class="en"> instillation, nasogastric</div><div class="fr">par sonde
	 * naso gastrique</div>
	 */
	INSTILLATION_NASOGASTRIC("NASOGASINSTIL", "instillation, nasogastric",
			"par sonde naso gastrique"),

	/**
	 * <div class="en"> instillation, otic</div><div class="fr">dans
	 * l'oreille</div>
	 */
	INSTILLATION_OTIC("OT", "instillation, otic", "dans l'oreille"),

	/** <div class="en"> suck, oromucosal</div><div class="fr">à sucer</div> */
	SUCK_OROMUCOSAL("SUCK", "suck, oromucosal", "à sucer"),

	/**
	 * <div class="en"> swallow, oral</div><div class="fr">par la bouche</div>
	 */
	SWALLOW_ORAL("PO", "swallow, oral", "par la bouche"),

	/**
	 * <div class="en"> topical application, buccal</div><div class="fr">dans la
	 * bouche</div>
	 */
	TOPICAL_BUCCAL("BUC", "topical application, buccal", "dans la bouche"),

	/**
	 * <div class="en"> topical application, nail</div><div class="fr">sur
	 * l'ongle</div>
	 */
	TOPICAL_NAIL("NAIL", "topical application, nail", "sur l'ongle"),

	/**
	 * <div class="en"> topical application, ophthalmic</div>
	 * <div class="fr">dans l'oeil</div>
	 */
	TOPICAL_OPHTALMIC("OPTHALTA", "topical application, ophthalmic", "dans l'oeil"),

	/**
	 * <div class="en"> topical application, skin</div><div class="fr">en
	 * application cutanée</div>
	 */
	TOPICAL_SKIN("SKIN", "topical application, skin", "en application cutanée"),

	/**
	 * <div class="en"> topical application, vaginal</div><div class="fr">par
	 * voie transdermique</div>
	 */
	TOPICAL_VAGINAL("TRNSDERM", "topical application, vaginal", "par voie transdermique");

	public static final String CODE_SYSTEM_NAME = "RouteOfAdministration";
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.112";

	public static final String DIFFUSION_TRANSDERMAL_CODE = "TRNSDERMD";
	public static final String INHALATION_NEBULIZATION_NASAL_CODE = "NASNEB";
	public static final String INJECTION_INTRADERMAL_CODE = "IDINJ";
	public static final String INJECTION_INTRAMUSCULAR_CODE = "IM";
	public static final String INJECTION_SUBCUTANEOUS_CODE = "SQ";
	public static final String SWALLOW_ORAL_CODE = "PO";

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

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(RouteOfAdministration.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final RouteOfAdministration x : values()) {
			if (x.code.equals(codeValue)) {
				return true;
			}
		}
		return false;
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
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		return getCE(null);
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE(LanguageCode languageCode) {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCodeSystemName(CODE_SYSTEM_NAME);
		ce.setCode(code);
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
		} else
			displayName = displayNameEn;
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		return getCode(null);
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
		} else
			displayName = displayNameEn;

		return new Code(CODE_SYSTEM_OID, code, CODE_SYSTEM_NAME, displayName);
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayNameEn;
	}
}
