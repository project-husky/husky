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
import org.ehealth_connector.common.hl7cdar2.CD;
import org.ehealth_connector.common.utils.LangText;
import org.ehealth_connector.common.utils.LangTexts;

/*
 *<div class="de">Codesystem: HL7 ActSite (OID: 2.16.840.1.113883.5.1052).</div>
 */
public enum ActSite {
	//@formatter:off
	/** <div class="en">bilateral ears</div><div class="de">Ohren beidseits</div>*/
	BILATERAL_EARS("BE", "Ohren beidseits", null, null, "bilateral ears"),
	/** <div class="en">bilateral nares</div><div class="de">Nasenlöcher beidseits</div>*/
	BILATERAL_NARES("BN", "Nasenlöcher beidseits", null, null, "bilateral nares"),
	/** <div class="en">biliteral eyes</div><div class="de">Augen beidseits</div>*/
	BILITERAL_EYES("OU", "Augen beidseits", null, null, "biliteral eyes"),
	/** <div class="en">buttock</div><div class="de">Gesässbacke</div>*/
	BUTTOCK("BU", "Gesässbacke", null, null, "buttock"),
	/** <div class="en">left antecubital fossa</div><div class="de">Linke Fossa antecubitalis</div>*/
	LEFT_ANTECUBITAL_FOSSA("LACF", "Linke Fossa antecubitalis", null, null, "left antecubital fossa"),
	/** <div class="en">left anterior chest</div><div class="de">Linker vorderer Thorax</div>*/
	LEFT_ANTERIOR_CHEST("LAC", "Linker vorderer Thorax", null, null, "left anterior chest"),
	/** <div class="en">left arm</div><div class="de">Linker Arm</div>*/
	LEFT_ARM("LA", "Linker Arm", null, null, "left arm"),
	/** <div class="en">left deltoid</div><div class="de">Linker Deltoideus</div>*/
	LEFT_DELTOID("LD", "Linker Deltoideus", null, null, "left deltoid"),
	/** <div class="en">left ear</div><div class="de">Linkes Ohr</div>*/
	LEFT_EAR("LE", "Linkes Ohr", null, null, "left ear"),
	/** <div class="en">left external jugular</div><div class="de">Linke Jugularis externa</div>*/
	LEFT_EXTERNAL_JUGULAR("LEJ", "Linke Jugularis externa", null, null, "left external jugular"),
	/** <div class="en">left eye</div><div class="de">Linkes Auge</div>*/
	LEFT_EYE("OS", "Linkes Auge", null, null, "left eye"),
	/** <div class="en">left foot</div><div class="de">Linker Fuss</div>*/
	LEFT_FOOT("LF", "Linker Fuss", null, null, "left foot"),
	/** <div class="en">left gluteus medius</div><div class="de">Linker Glutaeus medius</div>*/
	LEFT_GLUTEUS_MEDIUS("LG", "Linker Glutaeus medius", null, null, "left gluteus medius"),
	/** <div class="en">left hand</div><div class="de">Linke Hand</div>*/
	LEFT_HAND("LH", "Linke Hand", null, null, "left hand"),
	/** <div class="en">left internal jugular</div><div class="de">Linke Jugularis interna</div>*/
	LEFT_INTERNAL_JUGULAR("LIJ", "Linke Jugularis interna", null, null, "left internal jugular"),
	/** <div class="en">left lower abd quadrant</div><div class="de">Linker unterer Abdominal-Quadrant</div>*/
	LEFT_LOWER_ABD_QUARANT("LLAQ", "Linker unterer Abdominal-Quadrant", null, null, "left lower abd quadrant"),
	/** <div class="en">left lower forearm</div><div class="de">Linker distaler Unterarm</div>*/
	LEFT_LOWER_FOREARM("LLFA", "Linker distaler Unterarm", null, null, "left lower forearm"),
	/** <div class="en">left mid forearm</div><div class="de">Linker mittlerer Unterarm</div>*/
	LEFT_MID_FOREARM("LMFA", "Linker mittlerer Unterarm", null, null, "left mid forearm"),
	/** <div class="en">left naris</div><div class="de">Linkes Nasenloch</div>*/
	LEFT_NARIS("LN", "Linkes Nasenloch", null, null, "left naris"),
	/** <div class="en">left posterior chest</div><div class="de">Linke hinterer Thorax</div>*/
	LEFT_POSTERIOR_CHEST("LPC", "Linke hinterer Thorax", null, null, "left posterior chest"),
	/** <div class="en">left subclavian</div><div class="de">Linke Subclavia</div>*/
	LEFT_SUBCLAVIAN("LSC", "Linke Subclavia", null, null, "left subclavian"),
	/** <div class="en">left tigh</div><div class="de">Linker Oberschenkel</div>*/
	LEFT_TIGH("LT", "Linker Oberschenkel", null, null, "left tigh"),
	/** <div class="en">left upper abd quadrant</div><div class="de">Linker oberer Abdominal‐Quadrant</div>*/
	LEFT_UPPER_ABD_QUARANT("LUAQ", "Linker oberer Abdominal‐Quadrant", null, null, "left upper abd quadrant"),
	/** <div class="en">left upper arm</div><div class="de">Linker Obararm</div>*/
	LEFT_UPPER_ARM("LUA", "Linker Obararm", null, null, "left upper arm"),
	/** <div class="en">left upper forearm</div><div class="de">Linker proximaler Unterarm</div>*/
	LEFT_UPPER_FOREARM("LUFA", "Linker proximaler Unterarm", null, null, "left upper forearm"),
	/** <div class="en">left vastus lateralis</div><div class="de">Linker Vastus lateralis</div>*/
	LEFT_VASTUS_LATERALIS("LVL", "Linker Vastus lateralis", null, null, "left vastus lateralis"),
	/** <div class="en">left ventragluteal</div><div class="de">Links ventragluteal</div>*/
	LEFT_VENTRAGLUTEAL("LVG", "Links ventragluteal", null, null, "left ventragluteal"),
	/** <div class="en">perianal</div><div class="de">perianal</div>*/
	PERIANAL("PA", "perianal", null, null, "perianal"),
	/** <div class="en">perineal</div><div class="de">perineal</div>*/
	PERINEAL("PERIN", "perineal", null, null, "perineal"),
	/** <div class="en">right antecubital fossa</div><div class="de">Rechte Fossa antecubitalis</div>*/
	RIGHT_ANTECUBITAL_FOSSA("RACF", "Rechte Fossa antecubitalis", null, null, "right antecubital fossa"),
	/** <div class="en">right anterior chest</div><div class="de">Rechter vorderer Thorax</div>*/
	RIGHT_ANTERIOR_CHEST("RAC", "Rechter vorderer Thorax", null, null, "right anterior chest"),
	/** <div class="en">right arm</div><div class="de">Rechter Arm</div>*/
	RIGHT_ARM("RA", "Rechter Arm", null, null, "right arm"),
	/** <div class="en">right deltoid</div><div class="de">Rechter Deltoideus</div>*/
	RIGHT_DELTOID("RD", "Rechter Deltoideus", null, null, "right deltoid"),
	/** <div class="en">right ear</div><div class="de">Rechtes Ohr</div>*/
	RIGHT_EAR("RE", "Rechtes Ohr", null, null, "right ear"),
	/** <div class="en">right external jugular</div><div class="de">Rechte Jugularis externa</div>*/
	RIGHT_EXTERNAL_JUGULAR("REJ", "Rechte Jugularis externa", null, null, "right external jugular"),
	/** <div class="en">right eye</div><div class="de">Rechtes Auge</div>*/
	RIGHT_EYE("OD", "Rechtes Auge", null, null, "right eye"),
	/** <div class="en">right foot</div><div class="de">Rechter Fuss</div>*/
	RIGHT_FOOT("RF", "Rechter Fuss", null, null, "right foot"),
	/** <div class="en">right gluteus medius</div><div class="de">Rechter Gluaeus medius</div>*/
	RIGHT_GLUTEUS_MEDIUS("RG", "Rechter Gluaeus medius", null, null, "right gluteus medius"),
	/** <div class="en">right hand</div><div class="de">Rechte Hand</div>*/
	RIGHT_HAND("RH", "Rechte Hand", null, null, "right hand"),
	/** <div class="en">right internal jugular</div><div class="de">Rechte Jugularis interna</div>*/
	RIGHT_INTERNAL_JUGULAR("RIJ", "Rechte Jugularis interna", null, null, "right internal jugular"),
	/** <div class="en">right lower abd quadrant</div><div class="de">Rechter unterer Abdominal-Quadrant</div>*/
	RIGHT_LOWER_ABD_QUARANT("RLAQ", "Rechter unterer Abdominal-Quadrant", null, null, "right lower abd quadrant"),
	/** <div class="en">right lower forearm</div><div class="de">Rechter distaler Unterarm</div>*/
	RIGHT_LOWER_FOREARM("RLFA", "Rechter distaler Unterarm", null, null, "right lower forearm"),
	/** <div class="en">right mid forearm</div><div class="de">Rechter mittlerer Unterarm</div>*/
	RIGHT_MID_FOREARM("RMFA", "Rechter mittlerer Unterarm", null, null, "right mid forearm"),
	/** <div class="en">right naris</div><div class="de">Rechtes Nasenloch</div>*/
	RIGHT_NARIS("RN", "Rechtes Nasenloch", null, null, "right naris"),
	/** <div class="en">right posterior chest</div><div class="de">Rechter hinterer Thorax</div>*/
	RIGHT_POSTERIOR_CHEST("RPC", "Rechter hinterer Thorax", null, null, "right posterior chest"),
	/** <div class="en">right subclavian</div><div class="de">Rechte Subclavia</div>*/
	RIGHT_SUBCLAVIAN("RSC", "Rechte Subclavia", null, null, "right subclavian"),
	/** <div class="en">right tigh</div><div class="de">Rechter Oberschenkel</div>*/
	RIGHT_TIGH("RT", "Rechter Oberschenkel", null, null, "right tigh"),
	/** <div class="en">right upper abd quadrant</div><div class="de">Rechter oberer Abdominal‐Quadrant</div>*/
	RIGHT_UPPER_ABD_QUARANT("RUAQ", "Rechter oberer Abdominal‐Quadrant", null, null, "right upper abd quadrant"),
	/** <div class="en">right upper arm</div><div class="de">Rechter Oberarm</div>*/
	RIGHT_UPPER_ARM("RUA", "Rechter Oberarm", null, null, "right upper arm"),
	/** <div class="en">right upper forearm</div><div class="de">Rechter proximaler Unterarm</div>*/
	RIGHT_UPPER_FOREARM("RUFA", "Rechter proximaler Unterarm", null, null, "right upper forearm"),
	/** <div class="en">right vastus lateralis</div><div class="de">Rechter Vastus lateralis</div>*/
	RIGHT_VASTUS_LATERALIS("RVL", "Rechter Vastus lateralis", null, null, "right vastus lateralis"),
	/** <div class="en">right ventragluteal</div><div class="de">Rechts ventragluteal</div>*/
	RIGHT_VENTRAGLUTEAL("RVG", "Rechts ventragluteal", null, null, "right ventragluteal");
	//@formatter:on

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "HL7ActSite ";
	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1052";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ActSite getEnum(String code) {
		for (final ActSite x : values()) {
			if (x.getCodeValue().equals(code)) {
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
			Enum.valueOf(ActSite.class, enumName);
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
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ActSite x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	private String displayNameDe;

	private String displayNameEn;

	private String displayNameFr;

	private String displayNameIt;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private ActSite(String code, String displayNameDe, String displayNameFr, String displayNameIt,
			String displayNameEn) {
		this.code = code;
		this.displayNameEn = displayNameEn;
		this.displayNameDe = displayNameDe;
		this.displayNameFr = displayNameFr;
		this.displayNameIt = displayNameIt;
		this.displayName = displayNameEn;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		final CD ce = new CD();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCode(code);
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
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
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
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * <div class="en">Gets the display name for the language code.</div>
	 * <div class="de">Liefert den display name für den language code.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getDisplayName(LanguageCode lc) {
		String lcStr = LanguageCode.ENGLISH.getCodeValue();
		if (lc != null) {
			lcStr = lc.getCodeValue().toLowerCase();
		}
		if (lcStr.equals(LanguageCode.GERMAN.getCodeValue().toLowerCase()))
			return getDisplayNameDe();
		if (lcStr.equals(LanguageCode.FRENCH.getCodeValue().toLowerCase()))
			return getDisplayNameFr();
		if (lcStr.equals(LanguageCode.ITALIAN.getCodeValue().toLowerCase()))
			return getDisplayNameIt();
		if ("de".equals(lcStr))
			return getDisplayNameDe();
		if ("fr".equals(lcStr))
			return getDisplayNameFr();
		if ("it".equals(lcStr))
			return getDisplayNameIt();
		if ("en".equals(lcStr))
			return getDisplayNameEn();
		return getDisplayNameDe();
	}

	private String getDisplayNameDe() {
		if (displayNameDe != null) {
			return displayNameDe;
		}
		return getDisplayNameEn();
	}

	private String getDisplayNameEn() {
		if (displayNameEn != null) {
			return displayNameEn;
		}
		return name();
	}

	private String getDisplayNameFr() {
		if (displayNameFr != null) {
			return displayNameFr;
		}
		return getDisplayNameEn();
	}

	private String getDisplayNameIt() {
		if (displayNameIt != null) {
			return displayNameIt;
		}
		return getDisplayNameEn();
	}

	public LangTexts getLangTexts() {
		LangTexts retVal = new LangTexts();
		retVal.add(new LangText(LanguageCode.GERMAN, getDisplayNameDe()));
		retVal.add(new LangText(LanguageCode.ENGLISH, getDisplayNameEn()));
		retVal.add(new LangText(LanguageCode.FRENCH, getDisplayNameFr()));
		retVal.add(new LangText(LanguageCode.ITALIAN, getDisplayNameIt()));
		return retVal;
	}
}
