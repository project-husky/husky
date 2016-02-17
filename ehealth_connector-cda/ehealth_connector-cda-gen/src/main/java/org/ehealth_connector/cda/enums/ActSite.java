package org.ehealth_connector.cda.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Codesystem: HL7 ActSite (OID: 2.16.840.1.113883.5.1052).</div>
 */
public enum ActSite {
	//@formatter:off
	BILATERAL_EARS("BE", "Ohren beidseits", null, null, "bilateral ears"),
	BILATERAL_NARES("BN", "Nasenlöcher beidseits", null, null, "bilateral nares"),
	BUTTOCK("BU", "Gesässbacke", null, null, "buttock"),
	
	LEFT_ARM("LA", "Linker Arm", null, null, "left arm"),
	LEFT_ANTERIOR_CHEST("LAC", "Linker vorderer Thorax", null, null, "left anterior chest"),
	LEFT_ANTECUBITAL_FOSSA("LACF", "Linke Fossa antecubitalis", null, null, "left antecubital fossa"),
	LEFT_DELTOID("LD", "Linker Deltoideus", null, null, "left deltoid"),
	LEFT_EAR("LE", "Linkes Ohr", null, null, "left ear"),
	LEFT_EXTERNAL_JUGULAR("LEJ", "Linke Jugularis externa", null, null, "left external jugular"),
	LEFT_FOOT("LF", "Linker Fuss", null, null, "left foot"),
	LEFT_GLUTEUS_MEDIUS("LG", "Linker Glutaeus medius", null, null, "left gluteus medius"),
	LEFT_HAND("LH", "Linke Hand", null, null, "left hand"),
	LEFT_INTERNAL_JUGULAR("LIJ", "Linke Jugularis interna", null, null, "left internal jugular"),
	LEFT_LOWER_ABD_QUARANT("LLAQ", "Linker unterer Abdominal-Quadrant", null, null, "left lower abd quadrant"),
	LEFT_LOWER_FOREARM("LLFA", "Linker distaler Unterarm", null, null, "left lower forearm"),
	LEFT_MID_FOREARM("LMFA", "Linker mittlerer Unterarm", null, null, "left mid forearm"),
	LEFT_NARIS("LN", "Linkes Nasenloch", null, null, "left naris"),
	LEFT_POSTERIOR_CHEST("LPC", "Linke hinterer Thorax", null, null, "left posterior chest"),
	LEFT_SUBCLAVIAN("LSC", "Linke Subclavia", null, null, "left subclavian"),
	LEFT_TIGH("LT", "Linker Oberschenkel", null, null, "left tigh"),
	LEFT_UPPER_ARM("LUA", "Linker Obararm", null, null, "left upper arm"),
	LEFT_UPPER_ABD_QUARANT("LUAQ", "Linker oberer Abdominal‐Quadrant", null, null, "left upper abd quadrant"),
	LEFT_UPPER_FOREARM("LUFA", "Linker proximaler Unterarm", null, null, "left upper forearm"),
	LEFT_VENTRAGLUTEAL("LVG", "Links ventragluteal", null, null, "left ventragluteal"),
	LEFT_VASTUS_LATERALIS("LVL", "Linker Vastus lateralis", null, null, "left vastus lateralis"),
	
	RIGHT_EYE("OD", "Rechtes Auge", null, null, "right eye"),
	LEFT_EYE("OS", "Linkes Auge", null, null, "left eye"),
	BILITERAL_EYES("OU", "Augen beidseits", null, null, "biliteral eyes"),
	PERIANAL("PA", "perianal", null, null, "perianal"),
	PERINEAL("PERIN", "perineal", null, null, "perineal"),
	
	RIGHT_ARM("RA", "Rechter Arm", null, null, "right arm"),
	RIGHT_ANTERIOR_CHEST("RAC", "Rechter vorderer Thorax", null, null, "right anterior chest"),
	RIGHT_ANTECUBITAL_FOSSA("RACF", "Rechte Fossa antecubitalis", null, null, "right antecubital fossa"),
	RIGHT_DELTOID("RD", "Rechter Deltoideus", null, null, "right deltoid"),
	RIGHT_EAR("RE", "Rechtes Ohr", null, null, "right ear"),
	RIGHT_EXTERNAL_JUGULAR("REJ", "Rechte Jugularis externa", null, null, "right external jugular"),
	RIGHT_FOOT("RF", "Rechter Fuss", null, null, "right foot"),
	RIGHT_GLUTEUS_MEDIUS("RG", "Rechter Gluaeus medius", null, null, "right gluteus medius"),
	RIGHT_HAND("RH", "Rechte Hand", null, null, "right hand"),
	RIGHT_INTERNAL_JUGULAR("RIJ", "Rechte Jugularis interna", null, null, "right internal jugular"),
	RIGHT_LOWER_ABD_QUARANT("RLAQ", "Rechter unterer Abdominal-Quadrant", null, null, "right lower abd quadrant"),
	RIGHT_LOWER_FOREARM("RLFA", "Rechter distaler Unterarm", null, null, "right lower forearm"),
	RIGHT_MID_FOREARM("RMFA", "Rechter mittlerer Unterarm", null, null, "right mid forearm"),
	RIGHT_NARIS("RN", "Rechtes Nasenloch", null, null, "right naris"),
	RIGHT_POSTERIOR_CHEST("RPC", "Rechter hinterer Thorax", null, null, "right posterior chest"),
	RIGHT_SUBCLAVIAN("RSC", "Rechte Subclavia", null, null, "right subclavian"),
	RIGHT_TIGH("RT", "Rechter Oberschenkel", null, null, "right tigh"),
	RIGHT_UPPER_ARM("RUA", "Rechter Oberarm", null, null, "right upper arm"),
	RIGHT_UPPER_ABD_QUARANT("RUAQ", "Rechter oberer Abdominal‐Quadrant", null, null, "right upper abd quadrant"),
	RIGHT_UPPER_FOREARM("RUFA", "Rechter proximaler Unterarm", null, null, "right upper forearm"),
	RIGHT_VENTRAGLUTEAL("RVG", "Rechts ventragluteal", null, null, "right ventragluteal"),
	RIGHT_VASTUS_LATERALIS("RVL", "Rechter Vastus lateralis", null, null, "right vastus lateralis");
	//@formatter:on

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "HL7ActSite ";
	/**
	 * <div class="en">Identifier of the Code System</div> <div
	 * class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1052";

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ActSite getEnum(String code) {
		for (ActSite x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the display name for the language code.</div> <div
	 * class="de">Liefert den display name für den language code.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getDisplayName(CS lc) {
		String lcStr = LanguageCode.ENGLISH.getCodeValue();
		if (lc != null) {
			lcStr = lc.getCode().toLowerCase();
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

	private String getDisplayNameDe() {
		if (displayNameDe != null) {
			return displayNameDe;
		}
		return getDisplayNameEn();
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumName
	 * <br>
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
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (ActSite x : values()) {
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
	 * <div class="en">Human readable name</div> <div
	 * class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	private String displayNameEn;
	private String displayNameDe;
	private String displayNameFr;
	private String displayNameIt;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
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
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD ce = DatatypesFactory.eINSTANCE.createCD();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
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
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
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
}
