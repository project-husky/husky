package org.ehealth_connector.cda.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Codesystem: HL7 ActSite (OID: 2.16.840.1.113883.5.1052).</div>
 */
public enum ActSite {
	//@formatter:off
	BILATERAL_EARS("BE", "bilateral ears"),
	BILATERAL_NARES("BN", "bilateral nares"),
	BUTTOCK("BU", "buttock"),
	
	LEFT_ARM("LA", "left arm"),
	LEFT_ANTERIOR_CHEST("LAC", "left anterior chest"),
	LEFT_ANTECUBITAL_FOSSA("LACF", "left antecubital fossa"),
	LEFT_DELTOID("LD", "left deltoid"),
	LEFT_EAR("LE", "left ear"),
	LEFT_EXTERNAL_JUGULAR("LEJ", "left external jugular"),
	LEFT_FOOT("LF", "left foot"),
	LEFT_GLUTEUS_MEDIUS("LG", "left gluteus medius"),
	LEFT_HAND("LH", "left hand"),
	LEFT_INTERNAL_JUGULAR("LIJ", "left internal jugular"),
	LEFT_LOWER_ABD_QUARANT("LLAQ", "left lower abd quadrant"),
	LEFT_LOWER_FOREARM("LLFA", "left lower forearm"),
	LEFT_MID_FOREARM("LMFA", "left mid forearm"),
	LEFT_NARIS("LN", "left naris"),
	LEFT_POSTERIOR_CHEST("LPC", "left posterior chest"),
	LEFT_SUBCLAVIAN("LSC", "left subclavian"),
	LEFT_TIGH("LT", "left tigh"),
	LEFT_UPPER_ARM("LUA", "left upper arm"),
	LEFT_UPPER_ABD_QUARANT("LUAQ", "left upper abd quadrant"),
	LEFT_UPPER_FOREARM("LUFA", "left upper forearm"),
	LEFT_VENTRAGLUTEAL("LVG", "left ventragluteal"),
	LEFT_VASTUS_LATERALIS("LVL", "left vastus lateralis"),
	
	RIGHT_EYE("OD", "right eye"),
	LEFT_EYE("OS", "left eye"),
	BILITERAL_EYES("OU", "biliteral eyes"),
	PERIANAL("PA", "perianal"),
	PERINEAL("PERIN", "perineal"),
	
	RIGHT_ARM("RA", "right arm"),
	RIGHT_ANTERIOR_CHEST("RAC", "right anterior chest"),
	RIGHT_ANTECUBITAL_FOSSA("RACF", "right antecubital fossa"),
	RIGHT_DELTOID("RD", "right deltoid"),
	RIGHT_EAR("RE", "right ear"),
	RIGHT_EXTERNAL_JUGULAR("REJ", "right external jugular"),
	RIGHT_FOOT("RF", "right foot"),
	RIGHT_GLUTEUS_MEDIUS("RG", "right gluteus medius"),
	RIGHT_HAND("RH", "right hand"),
	RIGHT_INTERNAL_JUGULAR("RIJ", "right internal jugular"),
	RIGHT_LOWER_ABD_QUARANT("RLAQ", "right lower abd quadrant"),
	RIGHT_LOWER_FOREARM("RLFA", "right lower forearm"),
	RIGHT_MID_FOREARM("RMFA", "right mid forearm"),
	RIGHT_NARIS("RN", "right naris"),
	RIGHT_POSTERIOR_CHEST("RPC", "right posterior chest"),
	RIGHT_SUBCLAVIAN("RSC", "right subclavian"),
	RIGHT_TIGH("RT", "right tigh"),
	RIGHT_UPPER_ARM("RUA", "right upper arm"),
	RIGHT_UPPER_ABD_QUARANT("RUAQ", "right upper abd quadrant"),
	RIGHT_UPPER_FOREARM("RUFA", "right upper forearm"),
	RIGHT_VENTRAGLUTEAL("RVG", "right ventragluteal"),
	RIGHT_VASTUS_LATERALIS("RVL", "right vastus lateralis");
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
	private ActSite(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
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
